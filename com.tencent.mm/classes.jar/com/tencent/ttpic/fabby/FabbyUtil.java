package com.tencent.ttpic.fabby;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.model.GridSettingModel;
import java.util.Iterator;
import java.util.List;
import java.util.List<Landroid.util.Pair<Ljava.lang.Float;Ljava.lang.Double;>;>;

public class FabbyUtil
{
  public static int getDivideValue(float paramFloat, List<Pair<Float, Integer>> paramList, int paramInt)
  {
    AppMethodBeat.i(81883);
    if (paramList.size() <= 0)
    {
      AppMethodBeat.o(81883);
      return paramInt;
    }
    Iterator localIterator = paramList.iterator();
    Pair localPair;
    for (paramList = null; localIterator.hasNext(); paramList = localPair)
    {
      localPair = (Pair)localIterator.next();
      if (((Float)localPair.first).floatValue() > paramFloat) {
        break;
      }
    }
    if (paramList == null)
    {
      AppMethodBeat.o(81883);
      return 0;
    }
    paramInt = ((Integer)paramList.second).intValue();
    AppMethodBeat.o(81883);
    return paramInt;
  }
  
  public static GridSettingModel getGridSetting(float paramFloat, List<Pair<Float, GridSettingModel>> paramList, GridSettingModel paramGridSettingModel)
  {
    AppMethodBeat.i(81885);
    if (paramList.size() <= 0)
    {
      AppMethodBeat.o(81885);
      return paramGridSettingModel;
    }
    Iterator localIterator = paramList.iterator();
    Pair localPair;
    for (paramList = null; localIterator.hasNext(); paramList = localPair)
    {
      localPair = (Pair)localIterator.next();
      if (((Float)localPair.first).floatValue() > paramFloat) {
        break;
      }
    }
    if (paramList == null)
    {
      AppMethodBeat.o(81885);
      return paramGridSettingModel;
    }
    paramList = (GridSettingModel)paramList.second;
    AppMethodBeat.o(81885);
    return paramList;
  }
  
  public static double getRangeValue(int paramInt, float paramFloat, List<Pair<Float, Double>> paramList, double paramDouble)
  {
    AppMethodBeat.i(81882);
    if (paramList.size() <= 0)
    {
      AppMethodBeat.o(81882);
      return paramDouble;
    }
    Iterator localIterator = paramList.iterator();
    Object localObject2;
    for (paramList = null; localIterator.hasNext(); paramList = (List<Pair<Float, Double>>)localObject2)
    {
      localObject2 = (Pair)localIterator.next();
      localObject1 = localObject2;
      if (((Float)((Pair)localObject2).first).floatValue() > paramFloat) {
        break label82;
      }
    }
    Object localObject1 = null;
    label82:
    if ((paramList == null) && (localObject1 == null))
    {
      AppMethodBeat.o(81882);
      return 1.0D;
    }
    if (paramList == null) {
      paramList = (List<Pair<Float, Double>>)localObject1;
    }
    for (;;)
    {
      if (((Float)((Pair)localObject1).first).equals(paramList.first))
      {
        paramDouble = ((Double)((Pair)localObject1).second).doubleValue();
        AppMethodBeat.o(81882);
        return paramDouble;
        if (localObject1 == null)
        {
          localObject1 = paramList;
          localObject2 = paramList;
          paramList = (List<Pair<Float, Double>>)localObject1;
          localObject1 = localObject2;
        }
      }
      else
      {
        paramDouble = getValue(paramInt, ((Double)((Pair)localObject1).second).doubleValue(), ((Float)((Pair)localObject1).first).floatValue(), ((Double)paramList.second).doubleValue(), ((Float)paramList.first).floatValue(), paramFloat);
        AppMethodBeat.o(81882);
        return paramDouble;
      }
      localObject2 = paramList;
      paramList = (List<Pair<Float, Double>>)localObject1;
      localObject1 = localObject2;
    }
  }
  
  private static double getValue(int paramInt, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5)
  {
    AppMethodBeat.i(81884);
    paramDouble2 = (paramDouble5 - paramDouble2) / (paramDouble4 - paramDouble2);
    switch (paramInt)
    {
    default: 
      paramDouble1 = paramDouble2 * (paramDouble3 - paramDouble1) + paramDouble1;
    }
    for (;;)
    {
      AppMethodBeat.o(81884);
      return paramDouble1;
      paramDouble1 = -(paramDouble3 - paramDouble1);
      paramDouble1 = Math.cos(paramDouble2 * 1.570796326794897D) * paramDouble1 + paramDouble3;
      continue;
      paramDouble1 = Math.sin(paramDouble2 * 1.570796326794897D) * (paramDouble3 - paramDouble1) + paramDouble1;
      continue;
      paramDouble3 = -(paramDouble3 - paramDouble1) / 2.0D;
      paramDouble1 = (Math.cos(paramDouble2 * 3.141592653589793D) - 1.0D) * paramDouble3 + paramDouble1;
    }
  }
  
  public static boolean isHorizon(int paramInt)
  {
    return (paramInt == 90) || (paramInt == 270);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.fabby.FabbyUtil
 * JD-Core Version:    0.7.0.1
 */