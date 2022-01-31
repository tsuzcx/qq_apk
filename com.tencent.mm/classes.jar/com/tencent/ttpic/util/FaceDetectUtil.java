package com.tencent.ttpic.util;

import android.graphics.Point;
import android.graphics.PointF;
import com.tencent.faceBeauty.FaceParam;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.youtu.TTpicBitmapFaceDetect;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FaceDetectUtil
{
  public static final List<PointF> EMPTY_LIST;
  public static final int ILLEGAL_BIG_FACE = 2;
  public static final int ILLEGAL_SMALL_FACE = 1;
  public static final int LEGAL_NORMAL_FACE = 0;
  
  static
  {
    AppMethodBeat.i(83874);
    EMPTY_LIST = new ArrayList();
    AppMethodBeat.o(83874);
  }
  
  public static List<PointF> array2List(PointF[] paramArrayOfPointF)
  {
    AppMethodBeat.i(83872);
    ArrayList localArrayList = new ArrayList();
    if (paramArrayOfPointF == null)
    {
      AppMethodBeat.o(83872);
      return localArrayList;
    }
    int j = paramArrayOfPointF.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramArrayOfPointF[i]);
      i += 1;
    }
    AppMethodBeat.o(83872);
    return localArrayList;
  }
  
  public static int checkLegalFace(FaceParam paramFaceParam, int paramInt)
  {
    AppMethodBeat.i(83868);
    if (paramFaceParam == null)
    {
      AppMethodBeat.o(83868);
      return 1;
    }
    int i = distance(paramFaceParam.bsS, paramFaceParam.bsT);
    if (i < 40)
    {
      AppMethodBeat.o(83868);
      return 1;
    }
    if (i > paramInt)
    {
      AppMethodBeat.o(83868);
      return 2;
    }
    AppMethodBeat.o(83868);
    return 0;
  }
  
  /* Error */
  public static List<FaceParam> cosFunDetect(android.graphics.Bitmap paramBitmap, int paramInt, HashMap<FaceParam, float[]> paramHashMap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc 65
    //   5: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 25	java/util/ArrayList
    //   11: dup
    //   12: invokespecial 28	java/util/ArrayList:<init>	()V
    //   15: astore 6
    //   17: aload_0
    //   18: ifnull +10 -> 28
    //   21: aload_0
    //   22: invokevirtual 71	android/graphics/Bitmap:isRecycled	()Z
    //   25: ifeq +11 -> 36
    //   28: ldc 65
    //   30: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: aload 6
    //   35: areturn
    //   36: new 73	com/tencent/ttpic/util/youtu/TTpicBitmapFaceDetect
    //   39: dup
    //   40: invokespecial 74	com/tencent/ttpic/util/youtu/TTpicBitmapFaceDetect:<init>	()V
    //   43: astore 5
    //   45: aload 5
    //   47: iconst_1
    //   48: invokevirtual 78	com/tencent/ttpic/util/youtu/TTpicBitmapFaceDetect:needDetectFaceFeatures	(Z)V
    //   51: aload 5
    //   53: iconst_1
    //   54: invokevirtual 81	com/tencent/ttpic/util/youtu/TTpicBitmapFaceDetect:needDetectFaceGender	(Z)V
    //   57: aload 5
    //   59: aload_0
    //   60: invokevirtual 85	com/tencent/ttpic/util/youtu/TTpicBitmapFaceDetect:detectFace	(Landroid/graphics/Bitmap;)V
    //   63: aload 5
    //   65: invokevirtual 88	com/tencent/ttpic/util/youtu/TTpicBitmapFaceDetect:detectedFace	()Z
    //   68: ifeq +42 -> 110
    //   71: aload 6
    //   73: aload 5
    //   75: iload_1
    //   76: aload_2
    //   77: invokestatic 92	com/tencent/ttpic/util/FaceDetectUtil:pickAvailableFaces	(Lcom/tencent/ttpic/util/youtu/TTpicBitmapFaceDetect;ILjava/util/HashMap;)Ljava/util/List;
    //   80: invokeinterface 96 2 0
    //   85: pop
    //   86: aload 4
    //   88: astore_0
    //   89: aload 5
    //   91: invokevirtual 99	com/tencent/ttpic/util/youtu/TTpicBitmapFaceDetect:destroy	()V
    //   94: aload_0
    //   95: ifnull +7 -> 102
    //   98: aload_0
    //   99: invokevirtual 104	com/tencent/faceBeauty/b:release	()V
    //   102: ldc 65
    //   104: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: aload 6
    //   109: areturn
    //   110: new 106	com/tencent/faceBeauty/a
    //   113: dup
    //   114: invokespecial 107	com/tencent/faceBeauty/a:<init>	()V
    //   117: astore 4
    //   119: aload 4
    //   121: aload_0
    //   122: invokevirtual 108	com/tencent/faceBeauty/b:detectFace	(Landroid/graphics/Bitmap;)V
    //   125: aload 4
    //   127: invokevirtual 109	com/tencent/faceBeauty/b:detectedFace	()Z
    //   130: istore_3
    //   131: aload 4
    //   133: iconst_0
    //   134: invokevirtual 113	com/tencent/faceBeauty/b:getFaceParams	(I)Lcom/tencent/faceBeauty/FaceParam;
    //   137: astore 7
    //   139: iload_3
    //   140: ifeq +65 -> 205
    //   143: aload 7
    //   145: ifnull +60 -> 205
    //   148: aload 5
    //   150: aload_0
    //   151: aload 7
    //   153: getfield 117	com/tencent/faceBeauty/FaceParam:bsP	Landroid/graphics/Rect;
    //   156: aload 7
    //   158: getfield 55	com/tencent/faceBeauty/FaceParam:bsS	Landroid/graphics/Point;
    //   161: aload 7
    //   163: getfield 58	com/tencent/faceBeauty/FaceParam:bsT	Landroid/graphics/Point;
    //   166: invokevirtual 121	com/tencent/ttpic/util/youtu/TTpicBitmapFaceDetect:detectFaceByManual	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Point;Landroid/graphics/Point;)V
    //   169: aload 5
    //   171: iconst_0
    //   172: invokevirtual 122	com/tencent/ttpic/util/youtu/TTpicBitmapFaceDetect:getFaceParams	(I)Lcom/tencent/faceBeauty/FaceParam;
    //   175: astore_0
    //   176: aload_0
    //   177: ifnull +28 -> 205
    //   180: aload 6
    //   182: aload_0
    //   183: invokeinterface 44 2 0
    //   188: pop
    //   189: aload_2
    //   190: ifnull +15 -> 205
    //   193: aload_2
    //   194: aload_0
    //   195: aload 5
    //   197: iconst_0
    //   198: invokevirtual 126	com/tencent/ttpic/util/youtu/TTpicBitmapFaceDetect:getFaceAngles	(I)[F
    //   201: invokevirtual 132	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   204: pop
    //   205: aload 4
    //   207: astore_0
    //   208: goto -119 -> 89
    //   211: astore_0
    //   212: aconst_null
    //   213: astore_2
    //   214: aconst_null
    //   215: astore 4
    //   217: aload 4
    //   219: ifnull +8 -> 227
    //   222: aload 4
    //   224: invokevirtual 99	com/tencent/ttpic/util/youtu/TTpicBitmapFaceDetect:destroy	()V
    //   227: aload_2
    //   228: ifnull +7 -> 235
    //   231: aload_2
    //   232: invokevirtual 104	com/tencent/faceBeauty/b:release	()V
    //   235: ldc 65
    //   237: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   240: aload_0
    //   241: athrow
    //   242: astore_0
    //   243: aconst_null
    //   244: astore_2
    //   245: aload 5
    //   247: astore 4
    //   249: goto -32 -> 217
    //   252: astore_0
    //   253: aload 4
    //   255: astore_2
    //   256: aload 5
    //   258: astore 4
    //   260: goto -43 -> 217
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	263	0	paramBitmap	android.graphics.Bitmap
    //   0	263	1	paramInt	int
    //   0	263	2	paramHashMap	HashMap<FaceParam, float[]>
    //   130	10	3	bool	boolean
    //   1	258	4	localObject	Object
    //   43	214	5	localTTpicBitmapFaceDetect	TTpicBitmapFaceDetect
    //   15	166	6	localArrayList	ArrayList
    //   137	25	7	localFaceParam	FaceParam
    // Exception table:
    //   from	to	target	type
    //   36	45	211	finally
    //   45	86	242	finally
    //   110	119	242	finally
    //   119	139	252	finally
    //   148	176	252	finally
    //   180	189	252	finally
    //   193	205	252	finally
  }
  
  private static int distance(Point paramPoint1, Point paramPoint2)
  {
    AppMethodBeat.i(83869);
    int i = (int)Math.sqrt(Math.abs(paramPoint1.x - paramPoint2.x) * Math.abs(paramPoint1.x - paramPoint2.x) + Math.abs(paramPoint1.y - paramPoint2.y) * Math.abs(paramPoint1.y - paramPoint2.y));
    AppMethodBeat.o(83869);
    return i;
  }
  
  public static List<PointF> facePointf83to90(List<PointF> paramList)
  {
    AppMethodBeat.i(83873);
    if ((paramList == null) || (paramList.size() < 83))
    {
      AppMethodBeat.o(83873);
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
    AppMethodBeat.o(83873);
    return paramList;
  }
  
  public static PointF[] flatArray2Points(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(83870);
    if (paramArrayOfFloat == null)
    {
      AppMethodBeat.o(83870);
      return null;
    }
    PointF[] arrayOfPointF = new PointF[paramArrayOfFloat.length / 2];
    int i = 0;
    while (i < paramArrayOfFloat.length / 2)
    {
      arrayOfPointF[i] = new PointF(paramArrayOfFloat[(i * 2)], paramArrayOfFloat[(i * 2 + 1)]);
      i += 1;
    }
    AppMethodBeat.o(83870);
    return arrayOfPointF;
  }
  
  private static List<FaceParam> pickAvailableFaces(TTpicBitmapFaceDetect paramTTpicBitmapFaceDetect, int paramInt, HashMap<FaceParam, float[]> paramHashMap)
  {
    AppMethodBeat.i(83867);
    ArrayList localArrayList = new ArrayList();
    if ((paramTTpicBitmapFaceDetect.mFaceParams != null) && (paramTTpicBitmapFaceDetect.mFaceParams.size() > 0))
    {
      int i = 0;
      FaceParam localFaceParam;
      while (i < paramTTpicBitmapFaceDetect.mFaceParams.size())
      {
        localFaceParam = (FaceParam)paramTTpicBitmapFaceDetect.mFaceParams.get(i);
        if (checkLegalFace(localFaceParam, paramInt) != 1)
        {
          localArrayList.add(localFaceParam);
          if (paramHashMap != null) {
            paramHashMap.put(localFaceParam, paramTTpicBitmapFaceDetect.getFaceAngles(i));
          }
        }
        i += 1;
      }
      if (localArrayList.isEmpty())
      {
        localFaceParam = (FaceParam)paramTTpicBitmapFaceDetect.mFaceParams.get(0);
        localArrayList.add(localFaceParam);
        if (paramHashMap != null) {
          paramHashMap.put(localFaceParam, paramTTpicBitmapFaceDetect.getFaceAngles(0));
        }
      }
    }
    AppMethodBeat.o(83867);
    return localArrayList;
  }
  
  public static PointF[] ulsee2Orig(PointF[] paramArrayOfPointF)
  {
    AppMethodBeat.i(83871);
    if (paramArrayOfPointF == null)
    {
      AppMethodBeat.o(83871);
      return null;
    }
    PointF localPointF1 = paramArrayOfPointF[0];
    PointF localPointF2 = AlgoUtils.middlePoint(paramArrayOfPointF[1], paramArrayOfPointF[2]);
    PointF localPointF3 = paramArrayOfPointF[3];
    PointF localPointF4 = AlgoUtils.middlePoint(paramArrayOfPointF[4], paramArrayOfPointF[5]);
    PointF localPointF5 = paramArrayOfPointF[6];
    PointF localPointF6 = paramArrayOfPointF[8];
    PointF localPointF7 = paramArrayOfPointF[10];
    PointF localPointF8 = paramArrayOfPointF[12];
    PointF localPointF9 = paramArrayOfPointF[14];
    PointF localPointF10 = paramArrayOfPointF[16];
    PointF localPointF11 = paramArrayOfPointF[18];
    PointF localPointF12 = paramArrayOfPointF[20];
    PointF localPointF13 = paramArrayOfPointF[22];
    PointF localPointF14 = paramArrayOfPointF[24];
    PointF localPointF15 = paramArrayOfPointF[26];
    PointF localPointF16 = AlgoUtils.middlePoint(paramArrayOfPointF[27], paramArrayOfPointF[28]);
    PointF localPointF17 = paramArrayOfPointF[29];
    PointF localPointF18 = AlgoUtils.middlePoint(paramArrayOfPointF[30], paramArrayOfPointF[31]);
    PointF localPointF19 = paramArrayOfPointF[32];
    PointF localPointF20 = paramArrayOfPointF[33];
    PointF localPointF21 = paramArrayOfPointF[64];
    PointF localPointF22 = paramArrayOfPointF[65];
    PointF localPointF23 = paramArrayOfPointF[66];
    PointF localPointF24 = paramArrayOfPointF[67];
    PointF localPointF25 = paramArrayOfPointF[36];
    PointF localPointF26 = paramArrayOfPointF[35];
    PointF localPointF27 = paramArrayOfPointF[34];
    PointF localPointF28 = paramArrayOfPointF[42];
    PointF localPointF29 = paramArrayOfPointF[71];
    PointF localPointF30 = paramArrayOfPointF[70];
    PointF localPointF31 = paramArrayOfPointF[69];
    PointF localPointF32 = paramArrayOfPointF[68];
    PointF localPointF33 = paramArrayOfPointF[39];
    PointF localPointF34 = paramArrayOfPointF[40];
    PointF localPointF35 = paramArrayOfPointF[41];
    PointF localPointF36 = paramArrayOfPointF[52];
    PointF localPointF37 = paramArrayOfPointF[57];
    PointF localPointF38 = paramArrayOfPointF[73];
    PointF localPointF39 = paramArrayOfPointF[56];
    PointF localPointF40 = paramArrayOfPointF[55];
    PointF localPointF41 = paramArrayOfPointF[54];
    PointF localPointF42 = paramArrayOfPointF[72];
    PointF localPointF43 = paramArrayOfPointF[53];
    PointF localPointF44 = paramArrayOfPointF[74];
    PointF localPointF45 = paramArrayOfPointF[104];
    PointF localPointF46 = paramArrayOfPointF[61];
    PointF localPointF47 = paramArrayOfPointF[62];
    PointF localPointF48 = paramArrayOfPointF[76];
    PointF localPointF49 = paramArrayOfPointF[63];
    PointF localPointF50 = paramArrayOfPointF[58];
    PointF localPointF51 = paramArrayOfPointF[59];
    PointF localPointF52 = paramArrayOfPointF[75];
    PointF localPointF53 = paramArrayOfPointF[60];
    PointF localPointF54 = paramArrayOfPointF[77];
    PointF localPointF55 = paramArrayOfPointF[105];
    PointF localPointF56 = paramArrayOfPointF[78];
    PointF localPointF57 = paramArrayOfPointF[80];
    PointF localPointF58 = paramArrayOfPointF[82];
    PointF localPointF59 = AlgoUtils.middlePoint(paramArrayOfPointF[47], paramArrayOfPointF[48]);
    PointF localPointF60 = paramArrayOfPointF[49];
    PointF localPointF61 = AlgoUtils.middlePoint(paramArrayOfPointF[50], paramArrayOfPointF[51]);
    PointF localPointF62 = paramArrayOfPointF[83];
    PointF localPointF63 = paramArrayOfPointF[81];
    PointF localPointF64 = paramArrayOfPointF[79];
    PointF localPointF65 = paramArrayOfPointF[46];
    PointF localPointF66 = paramArrayOfPointF[84];
    PointF localPointF67 = paramArrayOfPointF[90];
    PointF localPointF68 = paramArrayOfPointF[95];
    PointF localPointF69 = paramArrayOfPointF[94];
    PointF localPointF70 = paramArrayOfPointF[93];
    PointF localPointF71 = paramArrayOfPointF[92];
    PointF localPointF72 = paramArrayOfPointF[91];
    PointF localPointF73 = paramArrayOfPointF[101];
    PointF localPointF74 = paramArrayOfPointF[102];
    PointF localPointF75 = paramArrayOfPointF[103];
    PointF localPointF76 = paramArrayOfPointF[85];
    PointF localPointF77 = paramArrayOfPointF[86];
    PointF localPointF78 = paramArrayOfPointF[87];
    PointF localPointF79 = paramArrayOfPointF[88];
    PointF localPointF80 = paramArrayOfPointF[89];
    PointF localPointF81 = paramArrayOfPointF[99];
    PointF localPointF82 = paramArrayOfPointF[98];
    paramArrayOfPointF = paramArrayOfPointF[97];
    AppMethodBeat.o(83871);
    return new PointF[] { localPointF1, localPointF2, localPointF3, localPointF4, localPointF5, localPointF6, localPointF7, localPointF8, localPointF9, localPointF10, localPointF11, localPointF12, localPointF13, localPointF14, localPointF15, localPointF16, localPointF17, localPointF18, localPointF19, localPointF20, localPointF21, localPointF22, localPointF23, localPointF24, localPointF25, localPointF26, localPointF27, localPointF28, localPointF29, localPointF30, localPointF31, localPointF32, localPointF33, localPointF34, localPointF35, localPointF36, localPointF37, localPointF38, localPointF39, localPointF40, localPointF41, localPointF42, localPointF43, localPointF44, localPointF45, localPointF46, localPointF47, localPointF48, localPointF49, localPointF50, localPointF51, localPointF52, localPointF53, localPointF54, localPointF55, localPointF56, localPointF57, localPointF58, localPointF59, localPointF60, localPointF61, localPointF62, localPointF63, localPointF64, localPointF65, localPointF66, localPointF67, localPointF68, localPointF69, localPointF70, localPointF71, localPointF72, localPointF73, localPointF74, localPointF75, localPointF76, localPointF77, localPointF78, localPointF79, localPointF80, localPointF81, localPointF82, paramArrayOfPointF };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.util.FaceDetectUtil
 * JD-Core Version:    0.7.0.1
 */