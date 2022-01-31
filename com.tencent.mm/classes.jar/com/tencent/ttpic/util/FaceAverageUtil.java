package com.tencent.ttpic.util;

import android.graphics.PointF;
import android.graphics.RectF;
import java.util.List;

public class FaceAverageUtil
{
  private static boolean checkFaceFeatureOutScreen(List<PointF> paramList, int paramInt1, int paramInt2, double paramDouble)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return false;
    }
    RectF localRectF = new RectF(0.0F, 0.0F, (float)(paramInt1 * paramDouble), (float)(paramInt2 * paramDouble));
    if (!localRectF.contains(((PointF)paramList.get(65)).x, ((PointF)paramList.get(65)).y)) {
      return false;
    }
    if (!localRectF.contains(((PointF)paramList.get(66)).x, ((PointF)paramList.get(66)).y)) {
      return false;
    }
    float f1 = ((PointF)paramList.get(69)).x;
    f1 = (((PointF)paramList.get(9)).x + f1) / 2.0F;
    float f2 = ((PointF)paramList.get(69)).y;
    paramList = new PointF(f1, (((PointF)paramList.get(9)).y + f2) / 2.0F);
    return localRectF.contains(paramList.x, paramList.y);
  }
  
  public static boolean isPositiveFace(float[] paramArrayOfFloat, List<PointF> paramList, int paramInt1, int paramInt2, double paramDouble)
  {
    boolean bool = true;
    double d = Math.min(Math.abs(Math.cos(paramArrayOfFloat[0])), Math.abs(Math.cos(paramArrayOfFloat[1])));
    if ((!checkFaceFeatureOutScreen(paramList, paramInt1, paramInt2, paramDouble)) || (d < 0.94D)) {
      bool = false;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.util.FaceAverageUtil
 * JD-Core Version:    0.7.0.1
 */