package com.tencent.ttpic.util;

import android.graphics.PointF;
import com.tencent.ttpic.model.FaceMoveItem;
import java.util.List;

public class FaceMoveUtil
{
  public static final int[] FaceMeshTriangles = { 1, 0, 35, 35, 36, 1, 35, 42, 36, 35, 20, 42, 19, 20, 35, 19, 26, 20, 19, 96, 26, 90, 96, 19, 35, 90, 19, 35, 0, 90, 95, 26, 96, 25, 26, 95, 26, 25, 21, 20, 26, 21, 42, 20, 21, 42, 21, 41, 42, 41, 43, 36, 42, 43, 36, 43, 37, 36, 37, 57, 57, 2, 36, 2, 57, 3, 65, 3, 57, 4, 3, 65, 5, 4, 65, 67, 5, 65, 67, 6, 5, 7, 6, 67, 7, 67, 68, 8, 7, 68, 68, 69, 8, 68, 73, 69, 68, 74, 73, 67, 74, 68, 67, 65, 74, 65, 75, 82, 75, 65, 57, 75, 57, 58, 75, 58, 76, 82, 75, 76, 65, 82, 74, 74, 82, 81, 74, 81, 73, 73, 81, 80, 73, 80, 72, 70, 73, 72, 69, 73, 70, 69, 70, 10, 10, 9, 69, 69, 9, 8, 10, 70, 11, 11, 70, 12, 12, 70, 71, 12, 71, 13, 13, 71, 66, 13, 66, 14, 14, 66, 15, 15, 66, 79, 79, 61, 15, 61, 79, 60, 60, 64, 61, 60, 59, 64, 78, 59, 60, 78, 77, 59, 80, 77, 78, 80, 81, 77, 76, 77, 81, 77, 76, 59, 76, 58, 59, 59, 58, 64, 58, 56, 64, 57, 56, 58, 57, 38, 56, 37, 38, 57, 38, 37, 43, 38, 43, 40, 38, 40, 39, 56, 38, 39, 39, 55, 56, 23, 55, 39, 31, 55, 23, 55, 31, 63, 56, 55, 63, 56, 63, 62, 64, 56, 62, 64, 62, 61, 47, 61, 62, 61, 47, 46, 61, 46, 17, 16, 61, 15, 16, 61, 17, 17, 46, 45, 45, 18, 17, 18, 45, 91, 45, 27, 91, 45, 28, 27, 52, 28, 45, 52, 29, 28, 51, 29, 52, 51, 50, 29, 50, 51, 53, 48, 50, 53, 49, 50, 48, 49, 31, 50, 49, 63, 31, 48, 63, 49, 48, 62, 63, 47, 62, 48, 48, 53, 47, 47, 53, 52, 46, 47, 52, 45, 46, 52, 53, 51, 52, 31, 30, 50, 31, 32, 30, 32, 31, 94, 32, 94, 92, 32, 92, 33, 30, 32, 33, 30, 33, 29, 50, 30, 29, 28, 29, 33, 34, 28, 33, 28, 34, 27, 27, 34, 93, 27, 93, 91, 93, 34, 92, 34, 33, 92, 94, 31, 23, 23, 24, 94, 22, 24, 23, 22, 21, 24, 41, 21, 22, 40, 41, 22, 43, 41, 40, 40, 22, 39, 39, 22, 23, 21, 25, 24, 25, 95, 24, 24, 95, 94, 82, 76, 81, 80, 78, 79, 72, 80, 66, 80, 79, 66, 71, 72, 66, 70, 72, 71, 79, 78, 60, 36, 2, 1, 99, 106, 96, 106, 105, 93, 105, 104, 91, 104, 103, 14, 103, 102, 11, 102, 101, 7, 101, 100, 4, 100, 99, 90, 0, 1, 100, 1, 2, 100, 2, 3, 100, 3, 4, 100, 4, 5, 101, 5, 6, 101, 6, 7, 101, 7, 8, 102, 8, 9, 102, 9, 10, 102, 10, 11, 102, 11, 12, 103, 12, 13, 103, 13, 14, 103, 14, 15, 104, 15, 16, 104, 16, 17, 104, 17, 18, 104, 18, 91, 104, 91, 93, 105, 93, 92, 106, 92, 94, 106, 94, 95, 106, 95, 96, 106, 96, 90, 99, 90, 0, 100 };
  public static final int SIZE_FULL_COORDS = 107;
  public static final int TRIANGLE_COUNT = 182;
  
  public static void adjustCoords(PointF[] paramArrayOfPointF1, PointF[] paramArrayOfPointF2, List<FaceMoveItem> paramList)
  {
    if (VideoUtil.isEmpty(paramList)) {}
    for (;;)
    {
      return;
      VideoMaterialUtil.copyArrayToArray(paramArrayOfPointF1, paramArrayOfPointF2);
      float f1 = AlgoUtils.getDistance(paramArrayOfPointF1[0], paramArrayOfPointF1[18]) / 480.0F;
      PointF localPointF1 = new PointF(paramArrayOfPointF1[54].x - paramArrayOfPointF1[44].x, paramArrayOfPointF1[54].y - paramArrayOfPointF1[44].y);
      PointF localPointF2 = new PointF(-localPointF1.y, localPointF1.x);
      float f2 = (float)Math.sqrt(localPointF1.x * localPointF1.x + localPointF1.y * localPointF1.y);
      float f3 = (float)Math.sqrt(localPointF2.x * localPointF2.x + localPointF2.y * localPointF2.y);
      localPointF1 = new PointF(localPointF1.x * f1 / f2, localPointF1.y * f1 / f2);
      localPointF2 = new PointF(localPointF2.x * f1 / f3, f1 * localPointF2.y / f3);
      int i = 0;
      while (i < paramList.size())
      {
        FaceMoveItem localFaceMoveItem = (FaceMoveItem)paramList.get(i);
        PointF localPointF4 = paramArrayOfPointF1[((FaceMoveItem)paramList.get(i)).pos1];
        PointF localPointF5 = paramArrayOfPointF1[((FaceMoveItem)paramList.get(i)).pos2];
        PointF localPointF3 = paramArrayOfPointF1[((FaceMoveItem)paramList.get(i)).position];
        localPointF4 = new PointF(localPointF4.x * localFaceMoveItem.ratio1 + localPointF5.x * (1.0F - localFaceMoveItem.ratio1), localPointF4.y * localFaceMoveItem.ratio1 + localPointF5.y * (1.0F - localFaceMoveItem.ratio1));
        f1 = localPointF4.x;
        f2 = localFaceMoveItem.ratio2;
        f3 = localPointF3.x;
        float f4 = localFaceMoveItem.ratio2;
        float f5 = localPointF4.y;
        float f6 = localFaceMoveItem.ratio2;
        localPointF3 = new PointF(f1 * f2 + f3 * (1.0F - f4), localPointF3.y * (1.0F - localFaceMoveItem.ratio2) + f5 * f6);
        int j = localFaceMoveItem.position;
        f1 = localPointF3.x;
        f2 = localPointF1.x;
        f3 = localFaceMoveItem.dx;
        f4 = localPointF2.x;
        f5 = localFaceMoveItem.dy;
        f6 = localPointF3.y;
        float f7 = localPointF1.y;
        float f8 = localFaceMoveItem.dx;
        float f9 = localPointF2.y;
        paramArrayOfPointF2[j] = new PointF(f1 + f2 * f3 + f4 * f5, localFaceMoveItem.dy * f9 + (f6 + f7 * f8));
        i += 1;
      }
    }
  }
  
  public static void genFullCoords(List<PointF> paramList)
  {
    if ((paramList == null) || (paramList.size() < 83)) {
      return;
    }
    while (paramList.size() < 107) {
      paramList.add(new PointF());
    }
    PointF localPointF1 = (PointF)paramList.get(83);
    float f1 = ((PointF)paramList.get(55)).x;
    localPointF1.x = ((((PointF)paramList.get(63)).x - ((PointF)paramList.get(55)).x) / 2.0F + f1);
    localPointF1 = (PointF)paramList.get(83);
    f1 = ((PointF)paramList.get(55)).y;
    localPointF1.y = ((((PointF)paramList.get(63)).y - ((PointF)paramList.get(55)).y) / 2.0F + f1);
    localPointF1 = (PointF)paramList.get(84);
    f1 = ((PointF)paramList.get(23)).x;
    localPointF1.x = ((((PointF)paramList.get(31)).x - ((PointF)paramList.get(23)).x) / 2.0F + f1);
    localPointF1 = (PointF)paramList.get(84);
    f1 = ((PointF)paramList.get(23)).y;
    localPointF1.y = ((((PointF)paramList.get(31)).y - ((PointF)paramList.get(23)).y) / 2.0F + f1);
    localPointF1 = (PointF)paramList.get(85);
    f1 = ((PointF)paramList.get(59)).x;
    localPointF1.x = ((((PointF)paramList.get(77)).x - ((PointF)paramList.get(59)).x) / 2.0F + f1);
    localPointF1 = (PointF)paramList.get(85);
    f1 = ((PointF)paramList.get(59)).y;
    localPointF1.y = ((((PointF)paramList.get(77)).y - ((PointF)paramList.get(59)).y) / 2.0F + f1);
    localPointF1 = (PointF)paramList.get(86);
    f1 = ((PointF)paramList.get(35)).x;
    localPointF1.x = (((PointF)paramList.get(35)).x - ((PointF)paramList.get(6)).x + f1);
    localPointF1 = (PointF)paramList.get(86);
    f1 = ((PointF)paramList.get(35)).y;
    localPointF1.y = (((PointF)paramList.get(35)).y - ((PointF)paramList.get(6)).y + f1);
    localPointF1 = (PointF)paramList.get(87);
    f1 = ((PointF)paramList.get(64)).x;
    localPointF1.x = ((((PointF)paramList.get(64)).x - ((PointF)paramList.get(9)).x) * 1.4F + f1);
    localPointF1 = (PointF)paramList.get(87);
    f1 = ((PointF)paramList.get(64)).y;
    localPointF1.y = ((((PointF)paramList.get(64)).y - ((PointF)paramList.get(9)).y) * 1.4F + f1);
    localPointF1 = (PointF)paramList.get(88);
    f1 = ((PointF)paramList.get(45)).x;
    localPointF1.x = (((PointF)paramList.get(45)).x - ((PointF)paramList.get(12)).x + f1);
    localPointF1 = (PointF)paramList.get(88);
    f1 = ((PointF)paramList.get(45)).y;
    localPointF1.y = (((PointF)paramList.get(45)).y - ((PointF)paramList.get(12)).y + f1);
    localPointF1 = (PointF)paramList.get(89);
    f1 = ((PointF)paramList.get(83)).x;
    localPointF1.x = (((PointF)paramList.get(83)).x - ((PointF)paramList.get(59)).x + f1);
    localPointF1 = (PointF)paramList.get(89);
    f1 = ((PointF)paramList.get(83)).y;
    localPointF1.y = (((PointF)paramList.get(83)).y - ((PointF)paramList.get(59)).y + f1);
    f1 = ((PointF)paramList.get(9)).x;
    float f2 = ((PointF)paramList.get(84)).x;
    float f3 = -((PointF)paramList.get(9)).y;
    f1 = (float)Math.atan((f1 - f2) / (((PointF)paramList.get(84)).y + f3));
    f2 = AlgoUtils.getDistance((PointF)paramList.get(0), (PointF)paramList.get(1));
    ((PointF)paramList.get(90)).x = ((float)(((PointF)paramList.get(1)).x + 2.0F * f2 * Math.sin(f1)));
    ((PointF)paramList.get(90)).y = ((float)(((PointF)paramList.get(1)).y - 2.0F * f2 * Math.cos(f1)));
    f2 = AlgoUtils.getDistance((PointF)paramList.get(17), (PointF)paramList.get(18));
    ((PointF)paramList.get(91)).x = ((float)(((PointF)paramList.get(17)).x + 2.0F * f2 * Math.sin(f1)));
    ((PointF)paramList.get(91)).y = ((float)(((PointF)paramList.get(17)).y - 2.0F * f2 * Math.cos(f1)));
    f2 = ((PointF)paramList.get(41)).x;
    f2 = (((PointF)paramList.get(51)).x + f2) / 2.0F;
    f3 = ((PointF)paramList.get(41)).y;
    localPointF1 = new PointF(f2, (((PointF)paramList.get(51)).y + f3) / 2.0F);
    f2 = AlgoUtils.getDistance((PointF)paramList.get(59), localPointF1);
    localPointF1 = (PointF)paramList.get(91);
    PointF localPointF2 = (PointF)paramList.get(90);
    f3 = (float)(((PointF)paramList.get(59)).x + 2.0F * f2 * Math.sin(f1));
    double d1 = ((PointF)paramList.get(59)).y;
    double d2 = 2.0F * f2;
    PointF localPointF3 = new PointF(f3, (float)(d1 - Math.cos(f1) * d2));
    int i = 2;
    while (i > 0)
    {
      f1 = 0.5233334F * i;
      ((PointF)paramList.get(94 - i)).x = ((float)(localPointF3.x - (localPointF3.x - localPointF1.x) * Math.cos(f1)));
      ((PointF)paramList.get(94 - i)).y = ((float)(localPointF1.y - (localPointF1.y - localPointF3.y) * Math.sin(f1)));
      i -= 1;
    }
    i = 3;
    while (i > 0)
    {
      f1 = 0.5233334F * i;
      ((PointF)paramList.get(97 - i)).x = ((float)(localPointF3.x - (localPointF3.x - localPointF2.x) * Math.cos(f1)));
      ((PointF)paramList.get(97 - i)).y = ((float)(localPointF2.y - (localPointF2.y - localPointF3.y) * Math.sin(f1)));
      i -= 1;
    }
    localPointF1 = (PointF)paramList.get(64);
    localPointF2 = new PointF(((PointF)paramList.get(54)).x - ((PointF)paramList.get(44)).x, ((PointF)paramList.get(54)).y - ((PointF)paramList.get(44)).y);
    f1 = localPointF2.x;
    f2 = localPointF2.x;
    f3 = localPointF2.y;
    localPointF2 = new PointF(f1 + f2, localPointF2.y + f3);
    localPointF3 = new PointF(-localPointF2.y, localPointF2.x);
    ((PointF)paramList.get(99)).x = (localPointF1.x - localPointF2.x - localPointF3.x);
    ((PointF)paramList.get(99)).y = (localPointF1.y - localPointF2.y - localPointF3.y);
    ((PointF)paramList.get(100)).x = (localPointF1.x - localPointF2.x);
    ((PointF)paramList.get(100)).y = (localPointF1.y - localPointF2.y);
    ((PointF)paramList.get(101)).x = (localPointF1.x - localPointF2.x + localPointF3.x);
    ((PointF)paramList.get(101)).y = (localPointF1.y - localPointF2.y + localPointF3.y);
    ((PointF)paramList.get(102)).x = (localPointF1.x + localPointF3.x);
    ((PointF)paramList.get(102)).y = (localPointF1.y + localPointF3.y);
    ((PointF)paramList.get(103)).x = (localPointF1.x + localPointF2.x + localPointF3.x);
    ((PointF)paramList.get(103)).y = (localPointF1.y + localPointF2.y + localPointF3.y);
    ((PointF)paramList.get(104)).x = (localPointF1.x + localPointF2.x);
    ((PointF)paramList.get(104)).y = (localPointF1.y + localPointF2.y);
    ((PointF)paramList.get(105)).x = (localPointF1.x + localPointF2.x - localPointF3.x);
    PointF localPointF4 = (PointF)paramList.get(105);
    f1 = localPointF1.y;
    localPointF4.y = (localPointF2.y + f1 - localPointF3.y);
    ((PointF)paramList.get(106)).x = (localPointF1.x - localPointF3.x);
    ((PointF)paramList.get(106)).y = (localPointF1.y - localPointF3.y);
  }
  
  public static void genFullCoords(PointF[] paramArrayOfPointF)
  {
    if ((paramArrayOfPointF == null) || (paramArrayOfPointF.length < 107)) {
      return;
    }
    paramArrayOfPointF[83].x = (paramArrayOfPointF[55].x + (paramArrayOfPointF[63].x - paramArrayOfPointF[55].x) / 2.0F);
    paramArrayOfPointF[83].y = (paramArrayOfPointF[55].y + (paramArrayOfPointF[63].y - paramArrayOfPointF[55].y) / 2.0F);
    paramArrayOfPointF[84].x = (paramArrayOfPointF[23].x + (paramArrayOfPointF[31].x - paramArrayOfPointF[23].x) / 2.0F);
    paramArrayOfPointF[84].y = (paramArrayOfPointF[23].y + (paramArrayOfPointF[31].y - paramArrayOfPointF[23].y) / 2.0F);
    paramArrayOfPointF[85].x = (paramArrayOfPointF[59].x + (paramArrayOfPointF[77].x - paramArrayOfPointF[59].x) / 2.0F);
    paramArrayOfPointF[85].y = (paramArrayOfPointF[59].y + (paramArrayOfPointF[77].y - paramArrayOfPointF[59].y) / 2.0F);
    paramArrayOfPointF[86].x = (paramArrayOfPointF[35].x + (paramArrayOfPointF[35].x - paramArrayOfPointF[6].x));
    paramArrayOfPointF[86].y = (paramArrayOfPointF[35].y + (paramArrayOfPointF[35].y - paramArrayOfPointF[6].y));
    paramArrayOfPointF[87].x = (paramArrayOfPointF[64].x + (paramArrayOfPointF[64].x - paramArrayOfPointF[9].x) * 1.4F);
    paramArrayOfPointF[87].y = (paramArrayOfPointF[64].y + (paramArrayOfPointF[64].y - paramArrayOfPointF[9].y) * 1.4F);
    paramArrayOfPointF[88].x = (paramArrayOfPointF[45].x + (paramArrayOfPointF[45].x - paramArrayOfPointF[12].x));
    paramArrayOfPointF[88].y = (paramArrayOfPointF[45].y + (paramArrayOfPointF[45].y - paramArrayOfPointF[12].y));
    paramArrayOfPointF[89].x = (paramArrayOfPointF[83].x + (paramArrayOfPointF[83].x - paramArrayOfPointF[59].x));
    paramArrayOfPointF[89].y = (paramArrayOfPointF[83].y + (paramArrayOfPointF[83].y - paramArrayOfPointF[59].y));
    float f1 = (float)Math.atan((paramArrayOfPointF[9].x - paramArrayOfPointF[84].x) / (-paramArrayOfPointF[9].y + paramArrayOfPointF[84].y));
    float f2 = AlgoUtils.getDistance(paramArrayOfPointF[0], paramArrayOfPointF[1]);
    paramArrayOfPointF[90].x = ((float)(paramArrayOfPointF[1].x + 2.0F * f2 * Math.sin(f1)));
    paramArrayOfPointF[90].y = ((float)(paramArrayOfPointF[1].y - f2 * 2.0F * Math.cos(f1)));
    f2 = AlgoUtils.getDistance(paramArrayOfPointF[17], paramArrayOfPointF[18]);
    paramArrayOfPointF[91].x = ((float)(paramArrayOfPointF[17].x + 2.0F * f2 * Math.sin(f1)));
    paramArrayOfPointF[91].y = ((float)(paramArrayOfPointF[17].y - f2 * 2.0F * Math.cos(f1)));
    PointF localPointF1 = new PointF((paramArrayOfPointF[41].x + paramArrayOfPointF[51].x) / 2.0F, (paramArrayOfPointF[41].y + paramArrayOfPointF[51].y) / 2.0F);
    f2 = AlgoUtils.getDistance(paramArrayOfPointF[59], localPointF1);
    localPointF1 = paramArrayOfPointF[91];
    PointF localPointF2 = paramArrayOfPointF[90];
    float f3 = (float)(paramArrayOfPointF[59].x + 2.0F * f2 * Math.sin(f1));
    double d1 = paramArrayOfPointF[59].y;
    double d2 = f2 * 2.0F;
    PointF localPointF3 = new PointF(f3, (float)(d1 - Math.cos(f1) * d2));
    int i = 2;
    while (i > 0)
    {
      f1 = i * 0.5233334F;
      paramArrayOfPointF[(94 - i)].x = ((float)(localPointF3.x - (localPointF3.x - localPointF1.x) * Math.cos(f1)));
      paramArrayOfPointF[(94 - i)].y = ((float)(localPointF1.y - (localPointF1.y - localPointF3.y) * Math.sin(f1)));
      i -= 1;
    }
    i = 3;
    while (i > 0)
    {
      f1 = i * 0.5233334F;
      paramArrayOfPointF[(97 - i)].x = ((float)(localPointF3.x - (localPointF3.x - localPointF2.x) * Math.cos(f1)));
      paramArrayOfPointF[(97 - i)].y = ((float)(localPointF2.y - (localPointF2.y - localPointF3.y) * Math.sin(f1)));
      i -= 1;
    }
    localPointF1 = paramArrayOfPointF[64];
    localPointF2 = new PointF(paramArrayOfPointF[54].x - paramArrayOfPointF[44].x, paramArrayOfPointF[54].y - paramArrayOfPointF[44].y);
    f1 = localPointF2.x;
    f2 = localPointF2.x;
    f3 = localPointF2.y;
    localPointF2 = new PointF(f1 + f2, localPointF2.y + f3);
    localPointF3 = new PointF(-localPointF2.y, localPointF2.x);
    paramArrayOfPointF[99].x = (localPointF1.x - localPointF2.x - localPointF3.x);
    paramArrayOfPointF[99].y = (localPointF1.y - localPointF2.y - localPointF3.y);
    paramArrayOfPointF[100].x = (localPointF1.x - localPointF2.x);
    paramArrayOfPointF[100].y = (localPointF1.y - localPointF2.y);
    paramArrayOfPointF[101].x = (localPointF1.x - localPointF2.x + localPointF3.x);
    paramArrayOfPointF[101].y = (localPointF1.y - localPointF2.y + localPointF3.y);
    paramArrayOfPointF[102].x = (localPointF1.x + localPointF3.x);
    paramArrayOfPointF[102].y = (localPointF1.y + localPointF3.y);
    paramArrayOfPointF[103].x = (localPointF1.x + localPointF2.x + localPointF3.x);
    paramArrayOfPointF[103].y = (localPointF1.y + localPointF2.y + localPointF3.y);
    paramArrayOfPointF[104].x = (localPointF1.x + localPointF2.x);
    paramArrayOfPointF[104].y = (localPointF1.y + localPointF2.y);
    paramArrayOfPointF[105].x = (localPointF1.x + localPointF2.x - localPointF3.x);
    PointF localPointF4 = paramArrayOfPointF[105];
    f1 = localPointF1.y;
    localPointF4.y = (localPointF2.y + f1 - localPointF3.y);
    paramArrayOfPointF[106].x = (localPointF1.x - localPointF3.x);
    paramArrayOfPointF[106].y = (localPointF1.y - localPointF3.y);
  }
  
  public static float[] initFacePositions(PointF[] paramArrayOfPointF, int paramInt1, int paramInt2, float[] paramArrayOfFloat, int[] paramArrayOfInt)
  {
    if ((paramArrayOfPointF == null) || (paramArrayOfFloat == null) || (paramInt1 <= 0) || (paramInt2 <= 0) || (paramArrayOfFloat.length != 1092))
    {
      paramArrayOfInt = new float[0];
      return paramArrayOfInt;
    }
    PointF[] arrayOfPointF = new PointF[3];
    int[] arrayOfInt = paramArrayOfInt;
    if (paramArrayOfInt == null) {
      arrayOfInt = FaceMeshTriangles;
    }
    int i = 0;
    int j = 0;
    for (;;)
    {
      paramArrayOfInt = paramArrayOfFloat;
      if (i >= arrayOfInt.length) {
        break;
      }
      arrayOfPointF[0] = paramArrayOfPointF[arrayOfInt[i]];
      arrayOfPointF[1] = paramArrayOfPointF[arrayOfInt[(i + 1)]];
      arrayOfPointF[2] = paramArrayOfPointF[arrayOfInt[(i + 2)]];
      int k = 0;
      while (k < 3)
      {
        paramArrayOfFloat[(k * 2 + j)] = (arrayOfPointF[k].x / paramInt1 * 2.0F - 1.0F);
        paramArrayOfFloat[(k * 2 + j + 1)] = (arrayOfPointF[k].y / paramInt2 * 2.0F - 1.0F);
        k += 1;
      }
      j += 6;
      i += 3;
    }
  }
  
  public static float[] initMaterialFaceTexCoords(PointF[] paramArrayOfPointF, int paramInt1, int paramInt2, float[] paramArrayOfFloat, int[] paramArrayOfInt)
  {
    if ((paramArrayOfPointF == null) || (paramArrayOfFloat == null) || (paramInt1 <= 0) || (paramInt2 <= 0) || (paramArrayOfFloat.length != 1092))
    {
      paramArrayOfInt = new float[0];
      return paramArrayOfInt;
    }
    PointF[] arrayOfPointF = new PointF[3];
    int[] arrayOfInt = paramArrayOfInt;
    if (paramArrayOfInt == null) {
      arrayOfInt = FaceMeshTriangles;
    }
    int i = 0;
    int j = 0;
    for (;;)
    {
      paramArrayOfInt = paramArrayOfFloat;
      if (i >= arrayOfInt.length) {
        break;
      }
      arrayOfPointF[0] = paramArrayOfPointF[arrayOfInt[i]];
      arrayOfPointF[1] = paramArrayOfPointF[arrayOfInt[(i + 1)]];
      arrayOfPointF[2] = paramArrayOfPointF[arrayOfInt[(i + 2)]];
      int k = 0;
      while (k < 3)
      {
        paramArrayOfFloat[(k * 2 + j)] = (arrayOfPointF[k].x / paramInt1);
        paramArrayOfFloat[(k * 2 + j + 1)] = (arrayOfPointF[k].y / paramInt2);
        k += 1;
      }
      j += 6;
      i += 3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.util.FaceMoveUtil
 * JD-Core Version:    0.7.0.1
 */