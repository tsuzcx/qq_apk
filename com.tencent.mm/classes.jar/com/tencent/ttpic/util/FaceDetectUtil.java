package com.tencent.ttpic.util;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;

public class FaceDetectUtil
{
  public static final List<PointF> EMPTY_LIST = new ArrayList();
  
  public static List<PointF> array2List(PointF[] paramArrayOfPointF)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayOfPointF == null) {}
    for (;;)
    {
      return localArrayList;
      int j = paramArrayOfPointF.length;
      int i = 0;
      while (i < j)
      {
        localArrayList.add(paramArrayOfPointF[i]);
        i += 1;
      }
    }
  }
  
  public static List<PointF> facePointf83to90(List<PointF> paramList)
  {
    if ((paramList == null) || (paramList.size() < 83)) {
      return paramList;
    }
    while (paramList.size() < 90) {
      paramList.add(new PointF());
    }
    while (paramList.size() > 90) {
      paramList.remove(paramList.size() - 1);
    }
    PointF localPointF = (PointF)paramList.get(83);
    float f = ((PointF)paramList.get(55)).x;
    localPointF.x = ((((PointF)paramList.get(63)).x - ((PointF)paramList.get(55)).x) / 2.0F + f);
    localPointF = (PointF)paramList.get(83);
    f = ((PointF)paramList.get(55)).y;
    localPointF.y = ((((PointF)paramList.get(63)).y - ((PointF)paramList.get(55)).y) / 2.0F + f);
    localPointF = (PointF)paramList.get(84);
    f = ((PointF)paramList.get(23)).x;
    localPointF.x = ((((PointF)paramList.get(31)).x - ((PointF)paramList.get(23)).x) / 2.0F + f);
    localPointF = (PointF)paramList.get(84);
    f = ((PointF)paramList.get(23)).y;
    localPointF.y = ((((PointF)paramList.get(31)).y - ((PointF)paramList.get(23)).y) / 2.0F + f);
    localPointF = (PointF)paramList.get(85);
    f = ((PointF)paramList.get(59)).x;
    localPointF.x = ((((PointF)paramList.get(77)).x - ((PointF)paramList.get(59)).x) / 2.0F + f);
    localPointF = (PointF)paramList.get(85);
    f = ((PointF)paramList.get(59)).y;
    localPointF.y = ((((PointF)paramList.get(77)).y - ((PointF)paramList.get(59)).y) / 2.0F + f);
    localPointF = (PointF)paramList.get(86);
    f = ((PointF)paramList.get(35)).x;
    localPointF.x = (((PointF)paramList.get(35)).x - ((PointF)paramList.get(6)).x + f);
    localPointF = (PointF)paramList.get(86);
    f = ((PointF)paramList.get(35)).y;
    localPointF.y = (((PointF)paramList.get(35)).y - ((PointF)paramList.get(6)).y + f);
    localPointF = (PointF)paramList.get(87);
    f = ((PointF)paramList.get(64)).x;
    localPointF.x = ((((PointF)paramList.get(64)).x - ((PointF)paramList.get(9)).x) * 1.4F + f);
    localPointF = (PointF)paramList.get(87);
    f = ((PointF)paramList.get(64)).y;
    localPointF.y = ((((PointF)paramList.get(64)).y - ((PointF)paramList.get(9)).y) * 1.4F + f);
    localPointF = (PointF)paramList.get(88);
    f = ((PointF)paramList.get(45)).x;
    localPointF.x = (((PointF)paramList.get(45)).x - ((PointF)paramList.get(12)).x + f);
    localPointF = (PointF)paramList.get(88);
    f = ((PointF)paramList.get(45)).y;
    localPointF.y = (((PointF)paramList.get(45)).y - ((PointF)paramList.get(12)).y + f);
    localPointF = (PointF)paramList.get(89);
    f = ((PointF)paramList.get(83)).x;
    localPointF.x = (((PointF)paramList.get(83)).x - ((PointF)paramList.get(59)).x + f);
    localPointF = (PointF)paramList.get(89);
    f = ((PointF)paramList.get(83)).y;
    localPointF.y = (((PointF)paramList.get(83)).y - ((PointF)paramList.get(59)).y + f);
    return paramList;
  }
  
  public static PointF[] flatArray2Points(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat == null) {
      return null;
    }
    PointF[] arrayOfPointF = new PointF[paramArrayOfFloat.length / 2];
    int i = 0;
    while (i < paramArrayOfFloat.length / 2)
    {
      arrayOfPointF[i] = new PointF(paramArrayOfFloat[(i * 2)], paramArrayOfFloat[(i * 2 + 1)]);
      i += 1;
    }
    return arrayOfPointF;
  }
  
  public static PointF[] ulsee2Orig(PointF[] paramArrayOfPointF)
  {
    if (paramArrayOfPointF == null) {
      return null;
    }
    return new PointF[] { paramArrayOfPointF[0], AlgoUtils.middlePoint(paramArrayOfPointF[1], paramArrayOfPointF[2]), paramArrayOfPointF[3], AlgoUtils.middlePoint(paramArrayOfPointF[4], paramArrayOfPointF[5]), paramArrayOfPointF[6], paramArrayOfPointF[8], paramArrayOfPointF[10], paramArrayOfPointF[12], paramArrayOfPointF[14], paramArrayOfPointF[16], paramArrayOfPointF[18], paramArrayOfPointF[20], paramArrayOfPointF[22], paramArrayOfPointF[24], paramArrayOfPointF[26], AlgoUtils.middlePoint(paramArrayOfPointF[27], paramArrayOfPointF[28]), paramArrayOfPointF[29], AlgoUtils.middlePoint(paramArrayOfPointF[30], paramArrayOfPointF[31]), paramArrayOfPointF[32], paramArrayOfPointF[33], paramArrayOfPointF[64], paramArrayOfPointF[65], paramArrayOfPointF[66], paramArrayOfPointF[67], paramArrayOfPointF[36], paramArrayOfPointF[35], paramArrayOfPointF[34], paramArrayOfPointF[42], paramArrayOfPointF[71], paramArrayOfPointF[70], paramArrayOfPointF[69], paramArrayOfPointF[68], paramArrayOfPointF[39], paramArrayOfPointF[40], paramArrayOfPointF[41], paramArrayOfPointF[52], paramArrayOfPointF[57], paramArrayOfPointF[73], paramArrayOfPointF[56], paramArrayOfPointF[55], paramArrayOfPointF[54], paramArrayOfPointF[72], paramArrayOfPointF[53], paramArrayOfPointF[74], paramArrayOfPointF[104], paramArrayOfPointF[61], paramArrayOfPointF[62], paramArrayOfPointF[76], paramArrayOfPointF[63], paramArrayOfPointF[58], paramArrayOfPointF[59], paramArrayOfPointF[75], paramArrayOfPointF[60], paramArrayOfPointF[77], paramArrayOfPointF[105], paramArrayOfPointF[78], paramArrayOfPointF[80], paramArrayOfPointF[82], AlgoUtils.middlePoint(paramArrayOfPointF[47], paramArrayOfPointF[48]), paramArrayOfPointF[49], AlgoUtils.middlePoint(paramArrayOfPointF[50], paramArrayOfPointF[51]), paramArrayOfPointF[83], paramArrayOfPointF[81], paramArrayOfPointF[79], paramArrayOfPointF[46], paramArrayOfPointF[84], paramArrayOfPointF[90], paramArrayOfPointF[95], paramArrayOfPointF[94], paramArrayOfPointF[93], paramArrayOfPointF[92], paramArrayOfPointF[91], paramArrayOfPointF[101], paramArrayOfPointF[102], paramArrayOfPointF[103], paramArrayOfPointF[85], paramArrayOfPointF[86], paramArrayOfPointF[87], paramArrayOfPointF[88], paramArrayOfPointF[89], paramArrayOfPointF[99], paramArrayOfPointF[98], paramArrayOfPointF[97] };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.util.FaceDetectUtil
 * JD-Core Version:    0.7.0.1
 */