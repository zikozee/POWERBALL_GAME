package com.spiritbeing.powerball.abstractModel;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;

public abstract class Chart {

    //getting Max n Min Value from a map
    protected final int initial_Value = 1;
    protected final int NUMBER_OF_HISTOGRAM = 14;
    protected final int MULTIPLIER = 2;

    protected Long getMaxValue(Map<Integer, Long> myMap){
        Comparator<? super Map.Entry<Integer, Long>> maxValueComparator = getComparator();

        Optional<Map.Entry<Integer, Long>> maxValue = myMap.entrySet()
                .stream().max(maxValueComparator);

        return maxValue.map(Map.Entry::getValue).orElse(null);
    }

    protected Long getMinValue(Map<Integer, Long> myMap){
        Comparator<? super Map.Entry<Integer, Long>> maxValueComparator = getComparator();

        Optional<Map.Entry<Integer, Long>> minValue = myMap.entrySet()
                .stream().min(maxValueComparator);

        return minValue.map(Map.Entry::getValue).orElse(null);
    }

    private Comparator<? super Map.Entry<Integer, Long>> getComparator() {
        return Comparator.comparing(Map.Entry::getValue);
    }

    protected Long yCoordinate(Map<Integer, Long> data, int min, int max){
        Long total = 0L;

        for(int i = min; i <= max; i++){
            Long value = data.get(i);
            if(value != null)
                total += value;

        }

        return total;
    }
}
