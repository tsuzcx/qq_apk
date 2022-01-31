package com.tencent.ttpic.util;

import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BaseUtils;
import java.util.ArrayList;
import java.util.List;

public class StableUtil
{
  public static List<Integer> getAvgAngles(List<List<Integer>> paramList)
  {
    int k = 0;
    AppMethodBeat.i(83976);
    if (BaseUtils.isEmpty(paramList))
    {
      paramList = VideoMaterialUtil.EMPTY_ANGLES_LIST;
      AppMethodBeat.o(83976);
      return paramList;
    }
    ArrayList localArrayList = new ArrayList(((List)paramList.get(0)).size());
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= paramList.size()) {
        break;
      }
      j = 0;
      while (j < ((List)paramList.get(0)).size())
      {
        if (j >= localArrayList.size()) {
          localArrayList.add(Integer.valueOf(0));
        }
        int m = ((Integer)localArrayList.get(j)).intValue();
        localArrayList.set(j, Integer.valueOf(((Integer)((List)paramList.get(i)).get(j)).intValue() + m));
        j += 1;
      }
      i += 1;
    }
    while (j < localArrayList.size())
    {
      localArrayList.set(j, Integer.valueOf(((Integer)localArrayList.get(j)).intValue() / paramList.size()));
      j += 1;
    }
    AppMethodBeat.o(83976);
    return localArrayList;
  }
  
  public static List<PointF> getAvgPoints(List<List<PointF>> paramList)
  {
    int k = 0;
    AppMethodBeat.i(83975);
    if (BaseUtils.isEmpty(paramList))
    {
      paramList = VideoMaterialUtil.EMPTY_POINTS_LIST;
      AppMethodBeat.o(83975);
      return paramList;
    }
    ArrayList localArrayList = new ArrayList(((List)paramList.get(0)).size());
    int i = 0;
    int j;
    PointF localPointF;
    for (;;)
    {
      j = k;
      if (i >= paramList.size()) {
        break;
      }
      j = 0;
      while (j < ((List)paramList.get(0)).size())
      {
        if (j >= localArrayList.size()) {
          localArrayList.add(new PointF());
        }
        localPointF = (PointF)localArrayList.get(j);
        float f = localPointF.x;
        localPointF.x = (((PointF)((List)paramList.get(i)).get(j)).x + f);
        localPointF = (PointF)localArrayList.get(j);
        f = localPointF.y;
        localPointF.y = (((PointF)((List)paramList.get(i)).get(j)).y + f);
        j += 1;
      }
      i += 1;
    }
    while (j < localArrayList.size())
    {
      localPointF = (PointF)localArrayList.get(j);
      localPointF.x /= paramList.size();
      localPointF = (PointF)localArrayList.get(j);
      localPointF.y /= paramList.size();
      j += 1;
    }
    AppMethodBeat.o(83975);
    return localArrayList;
  }
  
  public static float getDistSquare(PointF paramPointF1, PointF paramPointF2)
  {
    if ((paramPointF1 == null) || (paramPointF2 == null)) {
      return 0.0F;
    }
    float f1 = paramPointF1.x - paramPointF2.x;
    float f2 = paramPointF1.y - paramPointF2.y;
    return f1 * f1 + f2 * f2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.util.StableUtil
 * JD-Core Version:    0.7.0.1
 */