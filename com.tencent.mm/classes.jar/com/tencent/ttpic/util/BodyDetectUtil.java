package com.tencent.ttpic.util;

import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.youtu.bodydetector.BodyDetectResult;
import java.util.Iterator;
import java.util.List;

public class BodyDetectUtil
{
  private static final int WAISTLINE_LEFT_POINT = 15;
  private static final int WAISTLINE_RIGHT_POINT = 43;
  
  public static float calcWaistLine(List<PointF> paramList, double paramDouble, int paramInt)
  {
    AppMethodBeat.i(83823);
    float f2 = -1.0F;
    float f1 = f2;
    if (paramList != null)
    {
      f1 = f2;
      if (!paramList.isEmpty())
      {
        f1 = f2;
        if (paramInt > 0)
        {
          f1 = (float)(((PointF)paramList.get(15)).y / paramDouble);
          f1 = ((float)(((PointF)paramList.get(43)).y / paramDouble) + f1) / 2.0F / paramInt;
        }
      }
    }
    AppMethodBeat.o(83823);
    return f1;
  }
  
  public static void updateBodyPositionsAlterLongLeg(List<BodyDetectResult> paramList, float paramFloat)
  {
    AppMethodBeat.i(83824);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(83824);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      List localList = ((BodyDetectResult)paramList.next()).bodyPoints;
      float f = ((PointF)localList.get(15)).y;
      f = (((PointF)localList.get(43)).y + f) / 2.0F;
      int i = 16;
      while (i < 43)
      {
        PointF localPointF = (PointF)localList.get(i);
        localPointF.y += (localPointF.y - f) * (paramFloat * 0.2F);
        i += 1;
      }
    }
    AppMethodBeat.o(83824);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.util.BodyDetectUtil
 * JD-Core Version:    0.7.0.1
 */