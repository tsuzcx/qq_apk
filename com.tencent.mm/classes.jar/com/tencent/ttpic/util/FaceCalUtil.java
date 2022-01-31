package com.tencent.ttpic.util;

import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FaceCalUtil
{
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(83865);
    TAG = FaceCalUtil.class.getSimpleName();
    AppMethodBeat.o(83865);
  }
  
  public static List<PointF> AlignFace(List<PointF> paramList1, List<PointF> paramList2, int paramInt)
  {
    AppMethodBeat.i(83833);
    float f = getFaceWidth(paramList1) / getFaceWidth(paramList2);
    paramList1 = paramList2.iterator();
    while (paramList1.hasNext())
    {
      PointF localPointF = (PointF)paramList1.next();
      localPointF.x = ((localPointF.x - paramInt / 2) * f + paramInt / 2);
    }
    AppMethodBeat.o(83833);
    return paramList2;
  }
  
  public static List<PointF> arrayToPointList(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(83835);
    ArrayList localArrayList = new ArrayList();
    if (paramArrayOfFloat == null)
    {
      AppMethodBeat.o(83835);
      return localArrayList;
    }
    int i = 0;
    while (i < paramArrayOfFloat.length / 2)
    {
      localArrayList.add(new PointF(paramArrayOfFloat[(i * 2)], paramArrayOfFloat[(i * 2 + 1)]));
      i += 1;
    }
    AppMethodBeat.o(83835);
    return localArrayList;
  }
  
  public static List<PointF> arrayToPointList(int[][] paramArrayOfInt)
  {
    AppMethodBeat.i(83834);
    ArrayList localArrayList = new ArrayList();
    if (paramArrayOfInt == null)
    {
      AppMethodBeat.o(83834);
      return localArrayList;
    }
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      localArrayList.add(new PointF(paramArrayOfInt[i][0], paramArrayOfInt[i][1]));
      i += 1;
    }
    AppMethodBeat.o(83834);
    return localArrayList;
  }
  
  public static List<PointF> facePointf83to90(List<PointF> paramList)
  {
    AppMethodBeat.i(83861);
    if ((paramList == null) || (paramList.size() < 83))
    {
      AppMethodBeat.o(83861);
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
    AppMethodBeat.o(83861);
    return paramList;
  }
  
  public static float getBrowAngle(List<PointF> paramList1, List<PointF> paramList2)
  {
    AppMethodBeat.i(83841);
    paramList1 = AlgoUtils.genVector((PointF)paramList1.get(19), (PointF)paramList1.get(23));
    paramList2 = AlgoUtils.genVector((PointF)paramList2.get(19), (PointF)paramList2.get(23));
    double d1 = Math.atan2(paramList1.y, paramList1.x);
    double d2 = Math.atan2(paramList2.y, paramList2.x);
    float f1 = FaceItemCal.BROW_ANGLE.getAdjustValue((float)(d1 - d2));
    float f2 = FaceCalUtil.CAL_PARAM.BROW_ANGLE_SCALE_FACTOR.value;
    AppMethodBeat.o(83841);
    return f1 * f2;
  }
  
  public static float getDiffBrowX(List<PointF> paramList1, List<PointF> paramList2)
  {
    AppMethodBeat.i(83842);
    float f1 = AlgoUtils.getDistance((PointF)paramList2.get(0), (PointF)paramList2.get(18));
    f1 = AlgoUtils.getDistance((PointF)paramList2.get(43), (PointF)paramList2.get(53)) / f1;
    float f2 = AlgoUtils.getDistance((PointF)paramList1.get(0), (PointF)paramList1.get(18));
    f1 = AlgoUtils.getDistance((PointF)paramList1.get(43), (PointF)paramList1.get(53)) / f2 / f1;
    f1 = FaceItemCal.BROW_DIST_X.getAdjustValue(f1);
    f2 = FaceCalUtil.CAL_PARAM.BROW_DIST_X_SCALE_FACTOR.value;
    AppMethodBeat.o(83842);
    return f1 * f2;
  }
  
  public static float getDiffBrowY(List<PointF> paramList1, List<PointF> paramList2)
  {
    AppMethodBeat.i(83843);
    PointF localPointF1 = AlgoUtils.middlePoint(AlgoUtils.middlePoint((PointF)paramList2.get(8), (PointF)paramList2.get(10)), (PointF)paramList2.get(9));
    PointF localPointF2 = AlgoUtils.middlePoint(AlgoUtils.middlePoint((PointF)paramList1.get(8), (PointF)paramList1.get(10)), (PointF)paramList1.get(9));
    float f2 = AlgoUtils.getDistance((PointF)paramList2.get(83), localPointF1);
    float f1 = AlgoUtils.getDistance((PointF)paramList1.get(83), localPointF2);
    float f3 = ((PointF)paramList2.get(20)).y;
    float f4 = ((PointF)paramList2.get(26)).y;
    float f5 = ((PointF)paramList2.get(21)).y;
    float f6 = ((PointF)paramList2.get(25)).y;
    float f7 = ((PointF)paramList2.get(22)).y;
    float f8 = ((PointF)paramList2.get(24)).y;
    float f9 = ((PointF)paramList2.get(30)).y;
    float f10 = ((PointF)paramList2.get(32)).y;
    float f11 = ((PointF)paramList2.get(29)).y;
    float f12 = ((PointF)paramList2.get(33)).y;
    float f13 = ((PointF)paramList2.get(28)).y;
    f3 = (((PointF)paramList2.get(34)).y + (f3 + f4 + f5 + f6 + f7 + f8 + f9 + f10 + f11 + f12 + f13)) / 12.0F;
    f4 = ((PointF)paramList1.get(20)).y;
    f5 = ((PointF)paramList1.get(26)).y;
    f6 = ((PointF)paramList1.get(21)).y;
    f7 = ((PointF)paramList1.get(25)).y;
    f8 = ((PointF)paramList1.get(22)).y;
    f9 = ((PointF)paramList1.get(24)).y;
    f10 = ((PointF)paramList1.get(30)).y;
    f11 = ((PointF)paramList1.get(32)).y;
    f12 = ((PointF)paramList1.get(29)).y;
    f13 = ((PointF)paramList1.get(33)).y;
    float f14 = ((PointF)paramList1.get(28)).y;
    f4 = (((PointF)paramList1.get(34)).y + (f4 + f5 + f6 + f7 + f8 + f9 + f10 + f11 + f12 + f13 + f14)) / 12.0F;
    f2 = (((PointF)paramList2.get(83)).y - f3) / f2;
    f1 = (((PointF)paramList1.get(83)).y - f4) / f1 / f2;
    f1 = FaceItemCal.BROW_DIST_Y.getAdjustValue(f1);
    f2 = FaceCalUtil.CAL_PARAM.BROW_DIST_Y_SCALE_FACTOR.value;
    AppMethodBeat.o(83843);
    return f1 * f2;
  }
  
  public static float getDiffBrowY2(List<PointF> paramList1, List<PointF> paramList2)
  {
    AppMethodBeat.i(83844);
    float f1 = ((PointF)paramList1.get(21)).y;
    float f2 = ((PointF)paramList1.get(25)).y;
    float f3 = ((PointF)paramList2.get(21)).y;
    f1 = (f1 + f2 - (((PointF)paramList2.get(25)).y + f3)) / 2.0F;
    f1 = FaceItemCal.BROW_DIST_Y2.getAdjustValue(f1);
    f2 = FaceCalUtil.CAL_PARAM.BROW_DIST_Y_SCALE_FACTOR.value;
    AppMethodBeat.o(83844);
    return f1 * f2;
  }
  
  public static float getDiffEyeX(List<PointF> paramList1, List<PointF> paramList2)
  {
    AppMethodBeat.i(83837);
    float f1 = getFaceWidth(paramList2);
    f1 = AlgoUtils.getDistance((PointF)paramList2.get(43), (PointF)paramList2.get(53)) / f1;
    float f2 = getFaceWidth(paramList1);
    f1 = AlgoUtils.getDistance((PointF)paramList1.get(43), (PointF)paramList1.get(53)) / f2 / f1;
    f1 = FaceItemCal.EYE_DIST_X.getAdjustValue(f1);
    f2 = FaceCalUtil.CAL_PARAM.EYE_DIST_SCALE_FACTOR.value;
    AppMethodBeat.o(83837);
    return f1 * f2;
  }
  
  public static float getDiffMouthY(List<PointF> paramList1, List<PointF> paramList2)
  {
    AppMethodBeat.i(83848);
    PointF localPointF1 = AlgoUtils.middlePoint(AlgoUtils.middlePoint((PointF)paramList2.get(8), (PointF)paramList2.get(10)), (PointF)paramList2.get(9));
    PointF localPointF2 = AlgoUtils.middlePoint(AlgoUtils.middlePoint((PointF)paramList1.get(8), (PointF)paramList1.get(10)), (PointF)paramList1.get(9));
    float f2 = AlgoUtils.getDistance((PointF)paramList2.get(59), localPointF1);
    float f1 = AlgoUtils.getDistance((PointF)paramList1.get(59), localPointF2);
    f2 = (((PointF)paramList2.get(73)).y + ((PointF)paramList2.get(81)).y - ((PointF)paramList2.get(59)).y * 2.0F) / 2.0F / f2;
    f1 = (((PointF)paramList1.get(73)).y + ((PointF)paramList1.get(81)).y - ((PointF)paramList1.get(59)).y * 2.0F) / 2.0F / f1 / f2;
    f1 = FaceItemCal.MOUTH_DIST_Y.getAdjustValue(f1);
    f2 = FaceCalUtil.CAL_PARAM.MOUTH_DIST_Y_SCALE_FACTOR.value;
    AppMethodBeat.o(83848);
    return f1 * f2;
  }
  
  public static float getDiffMouthY2(List<PointF> paramList1, List<PointF> paramList2)
  {
    AppMethodBeat.i(83849);
    float f1 = ((PointF)paramList1.get(77)).y;
    float f2 = ((PointF)paramList1.get(69)).y;
    float f3 = ((PointF)paramList2.get(77)).y;
    f1 = (f1 + f2 - (((PointF)paramList2.get(69)).y + f3)) / 2.0F;
    f1 = FaceItemCal.MOUTH_DIST_Y2.getAdjustValue(f1);
    f2 = FaceCalUtil.CAL_PARAM.MOUTH_DIST_Y_SCALE_FACTOR.value;
    AppMethodBeat.o(83849);
    return f1 * f2;
  }
  
  public static float getDiffNoseY(List<PointF> paramList1, List<PointF> paramList2)
  {
    AppMethodBeat.i(83845);
    PointF localPointF1 = AlgoUtils.middlePoint(AlgoUtils.middlePoint((PointF)paramList2.get(8), (PointF)paramList2.get(10)), (PointF)paramList2.get(9));
    PointF localPointF2 = AlgoUtils.middlePoint(AlgoUtils.middlePoint((PointF)paramList1.get(8), (PointF)paramList1.get(10)), (PointF)paramList1.get(9));
    float f2 = AlgoUtils.getDistance((PointF)paramList2.get(83), localPointF1);
    float f1 = AlgoUtils.getDistance((PointF)paramList1.get(83), localPointF2);
    f2 = AlgoUtils.getDistance((PointF)paramList2.get(83), (PointF)paramList2.get(59)) / f2;
    f1 = AlgoUtils.getDistance((PointF)paramList1.get(83), (PointF)paramList1.get(59)) / f1 / f2;
    f1 = FaceItemCal.NOSE_DIST_Y.getAdjustValue(f1);
    f2 = FaceCalUtil.CAL_PARAM.NOSE_DIST_Y_SCALE_FACTOR.value;
    AppMethodBeat.o(83845);
    return f1 * f2;
  }
  
  public static float getDiffNoseY2(List<PointF> paramList1, List<PointF> paramList2)
  {
    AppMethodBeat.i(83846);
    float f1 = ((PointF)paramList1.get(59)).y;
    float f2 = ((PointF)paramList2.get(59)).y;
    f1 = FaceItemCal.NOSE_DIST_Y2.getAdjustValue(f1 - f2);
    f2 = FaceCalUtil.CAL_PARAM.NOSE_DIST_Y_SCALE_FACTOR.value;
    AppMethodBeat.o(83846);
    return f1 * f2;
  }
  
  public static float getEyeAngle(List<PointF> paramList1, List<PointF> paramList2)
  {
    AppMethodBeat.i(83840);
    paramList1 = AlgoUtils.genVector((PointF)paramList1.get(35), (PointF)paramList1.get(39));
    paramList2 = AlgoUtils.genVector((PointF)paramList2.get(35), (PointF)paramList2.get(39));
    double d1 = Math.atan2(paramList1.y, paramList1.x);
    double d2 = Math.atan2(paramList2.y, paramList2.x);
    float f1 = FaceItemCal.EYE_ANGLE.getAdjustValue((float)(d1 - d2));
    float f2 = FaceCalUtil.CAL_PARAM.EYE_ANGLE_SCALE_FACTOR.value;
    AppMethodBeat.o(83840);
    return f1 * f2;
  }
  
  public static float getEyeScaleX(List<PointF> paramList1, List<PointF> paramList2)
  {
    AppMethodBeat.i(83838);
    float f2 = getFaceWidth(paramList2);
    float f1 = getFaceWidth(paramList1);
    float f3 = AlgoUtils.getDistance((PointF)paramList2.get(35), (PointF)paramList2.get(39));
    f2 = (AlgoUtils.getDistance((PointF)paramList2.get(45), (PointF)paramList2.get(49)) + f3) / 2.0F / f2;
    f3 = AlgoUtils.getDistance((PointF)paramList1.get(35), (PointF)paramList1.get(39));
    f1 = (AlgoUtils.getDistance((PointF)paramList1.get(45), (PointF)paramList1.get(49)) + f3) / 2.0F / f1 / f2;
    f1 = FaceItemCal.EYE_WIDTH.getAdjustValue(f1);
    f2 = FaceCalUtil.CAL_PARAM.EYE_WIDTH_SCALE_FACTOR.value;
    AppMethodBeat.o(83838);
    return f1 * f2;
  }
  
  public static float getEyeScaleY(List<PointF> paramList1, List<PointF> paramList2)
  {
    AppMethodBeat.i(83839);
    PointF localPointF1 = AlgoUtils.middlePoint(AlgoUtils.middlePoint((PointF)paramList2.get(8), (PointF)paramList2.get(10)), (PointF)paramList2.get(9));
    PointF localPointF2 = AlgoUtils.middlePoint(AlgoUtils.middlePoint((PointF)paramList1.get(8), (PointF)paramList1.get(10)), (PointF)paramList1.get(9));
    float f2 = AlgoUtils.getDistance((PointF)paramList2.get(83), localPointF1);
    float f1 = AlgoUtils.getDistance((PointF)paramList1.get(83), localPointF2);
    float f3 = AlgoUtils.getDistance((PointF)paramList2.get(37), (PointF)paramList2.get(41));
    f2 = (AlgoUtils.getDistance((PointF)paramList2.get(47), (PointF)paramList2.get(51)) + f3) / 2.0F / f2;
    f3 = AlgoUtils.getDistance((PointF)paramList1.get(37), (PointF)paramList1.get(41));
    f1 = (AlgoUtils.getDistance((PointF)paramList1.get(47), (PointF)paramList1.get(51)) + f3) / 2.0F / f1 / f2;
    f1 = FaceItemCal.EYE_HEIGHT.getAdjustValue(f1);
    f2 = FaceCalUtil.CAL_PARAM.EYE_HEIGHT_SCALE_FACTOR.value;
    AppMethodBeat.o(83839);
    return f1 * f2;
  }
  
  public static double getFaceAngle(List<PointF> paramList)
  {
    AppMethodBeat.i(83855);
    Object localObject = getFaceOutlinePoints(paramList, true);
    paramList = getFaceOutlinePoints(paramList, false);
    localObject = AlgoUtils.linearRegression((List)localObject);
    paramList = AlgoUtils.linearRegression(paramList);
    double d = Math.atan2(localObject[0] - paramList[0], localObject[0] * paramList[0] + 1.0F);
    AppMethodBeat.o(83855);
    return 3.141592653589793D - d;
  }
  
  public static float getFaceJawLevel(List<PointF> paramList1, List<PointF> paramList2)
  {
    AppMethodBeat.i(83854);
    paramList2 = AlgoUtils.middlePoint(AlgoUtils.middlePoint((PointF)paramList2.get(8), (PointF)paramList2.get(10)), (PointF)paramList2.get(9));
    float f1 = AlgoUtils.middlePoint(AlgoUtils.middlePoint((PointF)paramList1.get(8), (PointF)paramList1.get(10)), (PointF)paramList1.get(9)).y;
    float f2 = paramList2.y;
    f1 = FaceItemCal.FACE_JAW.getAdjustValue(f1 - f2);
    f2 = FaceCalUtil.CAL_PARAM.MOUTH_DIST_Y_SCALE_FACTOR.value;
    AppMethodBeat.o(83854);
    return f1 * f2;
  }
  
  private static float getFaceOutlineDist(List<PointF> paramList)
  {
    AppMethodBeat.i(83857);
    int i = 2;
    float f2;
    for (float f1 = 0.0F; i <= 7; f1 += f2)
    {
      f2 = AlgoUtils.getDistance((PointF)paramList.get(i), (PointF)paramList.get(18 - i));
      i += 1;
    }
    AppMethodBeat.o(83857);
    return f1;
  }
  
  private static List<PointF> getFaceOutlinePoints(List<PointF> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(83856);
    ArrayList localArrayList = new ArrayList();
    int i = 2;
    if (i <= 5)
    {
      if (paramBoolean) {}
      for (int j = i;; j = 18 - i)
      {
        localArrayList.add(paramList.get(j));
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(83856);
    return localArrayList;
  }
  
  public static float getFaceScaleX(List<PointF> paramList1, List<PointF> paramList2)
  {
    AppMethodBeat.i(83836);
    PointF localPointF1 = AlgoUtils.middlePoint(AlgoUtils.middlePoint((PointF)paramList2.get(8), (PointF)paramList2.get(10)), (PointF)paramList2.get(9));
    PointF localPointF2 = AlgoUtils.middlePoint(AlgoUtils.middlePoint((PointF)paramList1.get(8), (PointF)paramList1.get(10)), (PointF)paramList1.get(9));
    float f1 = AlgoUtils.getDistance((PointF)paramList2.get(83), localPointF1);
    float f2 = AlgoUtils.getDistance((PointF)paramList1.get(83), localPointF2);
    float f3 = getFaceWidth(paramList2);
    f1 = f2 / getFaceWidth(paramList1) / (f1 / f3);
    f1 = FaceItemCal.FACE_WIDTH.getAdjustValue(f1);
    f2 = FaceCalUtil.CAL_PARAM.FACE_WIDTH_SCALE_FACTOR.value;
    AppMethodBeat.o(83836);
    return f1 * f2;
  }
  
  public static float getFaceScaleX2(List<PointF> paramList1, List<PointF> paramList2)
  {
    return 0.0F;
  }
  
  public static float getFaceVLevel(List<PointF> paramList1, List<PointF> paramList2)
  {
    AppMethodBeat.i(83852);
    float f1 = getFaceOutlineDist(paramList1);
    float f2 = getFaceOutlineDist(paramList2);
    float f3 = getFaceWidth(paramList1);
    float f4 = getFaceWidth(paramList2);
    f1 = f1 / f3 / (f2 / f4);
    f1 = FaceItemCal.FACE_V.getAdjustValue(f1);
    f2 = FaceCalUtil.CAL_PARAM.FACE_V_SCALE_FACTOR.value;
    AppMethodBeat.o(83852);
    return f1 * f2;
  }
  
  public static float getFaceVLevel1(List<PointF> paramList1, List<PointF> paramList2)
  {
    AppMethodBeat.i(83853);
    float f1 = (float)(getFaceAngle(paramList1) / getFaceAngle(paramList2));
    f1 = FaceItemCal.FACE_V.getAdjustValue(f1);
    float f2 = FaceCalUtil.CAL_PARAM.FACE_V_SCALE_FACTOR.value;
    AppMethodBeat.o(83853);
    return f1 * f2;
  }
  
  public static float getFaceWidth(List<PointF> paramList)
  {
    AppMethodBeat.i(83858);
    float f1 = AlgoUtils.getDistance((PointF)paramList.get(0), (PointF)paramList.get(18));
    float f2 = AlgoUtils.getDistance((PointF)paramList.get(1), (PointF)paramList.get(17));
    float f3 = AlgoUtils.getDistance((PointF)paramList.get(2), (PointF)paramList.get(16));
    f1 = Math.max(Math.max(f1, f2), f3);
    AppMethodBeat.o(83858);
    return f1;
  }
  
  public static float getMouthScaleX(List<PointF> paramList1, List<PointF> paramList2)
  {
    AppMethodBeat.i(83850);
    float f2 = getFaceWidth(paramList2);
    float f1 = getFaceWidth(paramList1);
    f2 = AlgoUtils.getDistance((PointF)paramList2.get(65), (PointF)paramList2.get(66)) / f2;
    f1 = AlgoUtils.getDistance((PointF)paramList1.get(65), (PointF)paramList1.get(66)) / f1 / f2;
    f1 = FaceItemCal.MOUTH_WIDTH.getAdjustValue(f1);
    f2 = FaceCalUtil.CAL_PARAM.MOUTH_WIDTH_SCALE_FACTOR.value;
    AppMethodBeat.o(83850);
    return f1 * f2;
  }
  
  public static float getMouthScaleY(List<PointF> paramList1, List<PointF> paramList2)
  {
    AppMethodBeat.i(83851);
    PointF localPointF1 = AlgoUtils.middlePoint(AlgoUtils.middlePoint((PointF)paramList2.get(8), (PointF)paramList2.get(10)), (PointF)paramList2.get(9));
    PointF localPointF2 = AlgoUtils.middlePoint(AlgoUtils.middlePoint((PointF)paramList1.get(8), (PointF)paramList1.get(10)), (PointF)paramList1.get(9));
    float f2 = AlgoUtils.getDistance((PointF)paramList2.get(83), localPointF1);
    float f1 = AlgoUtils.getDistance((PointF)paramList1.get(83), localPointF2);
    f2 = (((PointF)paramList2.get(69)).y * 2.0F - ((PointF)paramList2.get(76)).y - ((PointF)paramList2.get(78)).y) / 2.0F / f2;
    f1 = (((PointF)paramList1.get(69)).y * 2.0F - ((PointF)paramList1.get(76)).y - ((PointF)paramList1.get(78)).y) / 2.0F / f1 / f2;
    f1 = FaceItemCal.MOUTH_HEIGHT.getAdjustValue(f1);
    f2 = FaceCalUtil.CAL_PARAM.MOUTH_HEIGHT_SCALE_FACTOR.value;
    AppMethodBeat.o(83851);
    return f1 * f2;
  }
  
  public static float getNoseScaleX(List<PointF> paramList1, List<PointF> paramList2)
  {
    AppMethodBeat.i(83847);
    float f2 = getFaceWidth(paramList2);
    float f1 = getFaceWidth(paramList1);
    f2 = AlgoUtils.getDistance((PointF)paramList2.get(57), (PointF)paramList2.get(61)) / f2;
    f1 = AlgoUtils.getDistance((PointF)paramList1.get(57), (PointF)paramList1.get(61)) / f1 / f2;
    f1 = FaceItemCal.NOSE_WIDTH.getAdjustValue(f1);
    f2 = FaceCalUtil.CAL_PARAM.NOSE_WIDTH_SCALE_FACTOR.value;
    AppMethodBeat.o(83847);
    return f1 * f2;
  }
  
  public static PointF[] getRangePoints(List<PointF> paramList)
  {
    AppMethodBeat.i(83859);
    float f1 = getFaceWidth(paramList);
    float f2 = AlgoUtils.getDistance((PointF)paramList.get(0), (PointF)paramList.get(18));
    float f3 = AlgoUtils.getDistance((PointF)paramList.get(1), (PointF)paramList.get(17));
    AlgoUtils.getDistance((PointF)paramList.get(2), (PointF)paramList.get(16));
    if (Float.compare(f1, f2) == 0)
    {
      localPointF = (PointF)paramList.get(0);
      paramList = (PointF)paramList.get(18);
      AppMethodBeat.o(83859);
      return new PointF[] { localPointF, paramList };
    }
    if (Float.compare(f1, f3) == 0)
    {
      localPointF = (PointF)paramList.get(1);
      paramList = (PointF)paramList.get(17);
      AppMethodBeat.o(83859);
      return new PointF[] { localPointF, paramList };
    }
    PointF localPointF = (PointF)paramList.get(2);
    paramList = (PointF)paramList.get(16);
    AppMethodBeat.o(83859);
    return new PointF[] { localPointF, paramList };
  }
  
  public static void printPoints(List<PointF> paramList)
  {
    AppMethodBeat.i(83863);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[facePoints] ");
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      PointF localPointF = (PointF)paramList.next();
      localStringBuilder.append(localPointF.x + "f, " + localPointF.y + "f, ");
    }
    AppMethodBeat.o(83863);
  }
  
  public static void printPoints(int[][] paramArrayOfInt)
  {
    AppMethodBeat.i(83864);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[facePoints] ");
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int[] arrayOfInt = paramArrayOfInt[i];
      localStringBuilder.append(arrayOfInt[0] + ", " + arrayOfInt[1] + ", ");
      i += 1;
    }
    AppMethodBeat.o(83864);
  }
  
  public static float[] toFlatArray(List<PointF> paramList)
  {
    AppMethodBeat.i(83862);
    if (paramList == null)
    {
      AppMethodBeat.o(83862);
      return new float[0];
    }
    float[] arrayOfFloat = new float[paramList.size() * 2];
    int i = 0;
    while (i < paramList.size())
    {
      PointF localPointF = (PointF)paramList.get(i);
      if (localPointF != null)
      {
        arrayOfFloat[(i * 2)] = localPointF.x;
        arrayOfFloat[(i * 2 + 1)] = localPointF.y;
      }
      i += 1;
    }
    AppMethodBeat.o(83862);
    return arrayOfFloat;
  }
  
  public static PointsWithTexcoords transToStSpace(List<PointF> paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(83832);
    Object localObject = getRangePoints(paramList);
    localObject = new PointF(localObject[1].x - localObject[0].x, localObject[1].y - localObject[0].y);
    PointF localPointF3 = new PointF(((PointF)localObject).x * 1.5F, ((PointF)localObject).y * 1.5F);
    PointF localPointF4 = new PointF(-localPointF3.y, localPointF3.x);
    PointF localPointF5 = new PointF(((PointF)paramList.get(83)).x - localPointF4.x * 0.1F, ((PointF)paramList.get(83)).y - localPointF4.y * 0.1F);
    localObject = new PointF(localPointF5.x - localPointF3.x - localPointF4.x, localPointF5.y - localPointF3.y - localPointF4.y);
    PointF localPointF1 = new PointF(localPointF5.x - localPointF3.x + localPointF4.x, localPointF5.y - localPointF3.y + localPointF4.y);
    PointF localPointF2 = new PointF(localPointF5.x + localPointF3.x + localPointF4.x, localPointF5.y + localPointF3.y + localPointF4.y);
    float f1 = localPointF5.x;
    float f2 = localPointF3.x;
    float f3 = localPointF4.x;
    float f4 = localPointF5.y;
    localPointF3 = new PointF(f1 + f2 - f3, localPointF3.y + f4 - localPointF4.y);
    updateFacePoints(paramList, (PointF)localObject, localPointF3, localPointF1, paramInt3, paramInt4);
    ((PointF)localObject).x /= paramInt1;
    localPointF1.x /= paramInt1;
    localPointF2.x /= paramInt1;
    localPointF3.x /= paramInt1;
    ((PointF)localObject).y /= paramInt2;
    localPointF1.y /= paramInt2;
    localPointF2.y /= paramInt2;
    localPointF3.y /= paramInt2;
    paramList = new PointsWithTexcoords(paramList, new float[] { ((PointF)localObject).x, ((PointF)localObject).y, localPointF1.x, localPointF1.y, localPointF2.x, localPointF2.y, localPointF3.x, localPointF3.y });
    AppMethodBeat.o(83832);
    return paramList;
  }
  
  public static void updateFacePoints(List<PointF> paramList, PointF paramPointF1, PointF paramPointF2, PointF paramPointF3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(83860);
    float f1 = AlgoUtils.getDistance(paramPointF1, paramPointF2);
    float f2 = AlgoUtils.getDistance(paramPointF1, paramPointF3);
    float f3 = paramInt1 / f1;
    float f4 = paramInt2 / f2;
    paramInt1 = 0;
    while (paramInt1 < 83)
    {
      float f5 = AlgoUtils.distanceOfPoint2Line(paramPointF1, paramPointF3, f2, (PointF)paramList.get(paramInt1));
      float f6 = AlgoUtils.distanceOfPoint2Line(paramPointF1, paramPointF2, f1, (PointF)paramList.get(paramInt1));
      ((PointF)paramList.get(paramInt1)).set(f3 * f5, f4 * f6);
      paramInt1 += 1;
    }
    while (paramList.size() > 83) {
      paramList.remove(paramList.size() - 1);
    }
    facePointf83to90(paramList);
    AppMethodBeat.o(83860);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.util.FaceCalUtil
 * JD-Core Version:    0.7.0.1
 */