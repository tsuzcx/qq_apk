package com.tencent.ttpic.util.youtu;

import android.graphics.Point;
import com.tencent.faceBeauty.FaceParam;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BitmapFaceDetectUtil
{
  public static final int ILLEGAL_BIG_FACE = 2;
  public static final int ILLEGAL_SMALL_FACE = 1;
  public static final int LEGAL_NORMAL_FACE = 0;
  
  private static List<FaceParam> checkAvailableParams(List<FaceParam> paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (paramList.size() > 0))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        FaceParam localFaceParam = (FaceParam)localIterator.next();
        if (checkLegalFace(localFaceParam, paramInt) != 1) {
          localArrayList.add(localFaceParam);
        }
      }
      if (localArrayList.isEmpty()) {
        localArrayList.add(paramList.get(0));
      }
    }
    return localArrayList;
  }
  
  public static int checkLegalFace(FaceParam paramFaceParam, int paramInt)
  {
    if (paramFaceParam == null) {}
    int i;
    do
    {
      return 1;
      i = distance(paramFaceParam.bcq, paramFaceParam.bcr);
    } while (i < 40);
    if (i > paramInt) {
      return 2;
    }
    return 0;
  }
  
  /* Error */
  public static List<FaceParam> cosFunDetect(android.graphics.Bitmap paramBitmap, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 20	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 21	java/util/ArrayList:<init>	()V
    //   9: astore 5
    //   11: aload_0
    //   12: ifnull +10 -> 22
    //   15: aload_0
    //   16: invokevirtual 78	android/graphics/Bitmap:isRecycled	()Z
    //   19: ifeq +6 -> 25
    //   22: aload 5
    //   24: areturn
    //   25: new 80	com/tencent/ttpic/util/youtu/TTpicBitmapFaceDetect
    //   28: dup
    //   29: invokespecial 81	com/tencent/ttpic/util/youtu/TTpicBitmapFaceDetect:<init>	()V
    //   32: astore 4
    //   34: aload 4
    //   36: iconst_1
    //   37: invokevirtual 85	com/tencent/ttpic/util/youtu/TTpicBitmapFaceDetect:needDetectFaceFeatures	(Z)V
    //   40: aload 4
    //   42: iconst_1
    //   43: invokevirtual 88	com/tencent/ttpic/util/youtu/TTpicBitmapFaceDetect:needDetectFaceGender	(Z)V
    //   46: aload 4
    //   48: aload_0
    //   49: invokevirtual 92	com/tencent/ttpic/util/youtu/TTpicBitmapFaceDetect:detectFace	(Landroid/graphics/Bitmap;)V
    //   52: aload 4
    //   54: invokevirtual 95	com/tencent/ttpic/util/youtu/TTpicBitmapFaceDetect:detectedFace	()Z
    //   57: ifeq +38 -> 95
    //   60: aload 5
    //   62: aload 4
    //   64: getfield 99	com/tencent/ttpic/util/youtu/TTpicBitmapFaceDetect:mFaceParams	Ljava/util/List;
    //   67: iload_1
    //   68: invokestatic 101	com/tencent/ttpic/util/youtu/BitmapFaceDetectUtil:checkAvailableParams	(Ljava/util/List;I)Ljava/util/List;
    //   71: invokeinterface 105 2 0
    //   76: pop
    //   77: aload_3
    //   78: astore_0
    //   79: aload 4
    //   81: invokevirtual 108	com/tencent/ttpic/util/youtu/TTpicBitmapFaceDetect:destroy	()V
    //   84: aload_0
    //   85: ifnull +7 -> 92
    //   88: aload_0
    //   89: invokevirtual 113	com/tencent/faceBeauty/b:release	()V
    //   92: aload 5
    //   94: areturn
    //   95: new 115	com/tencent/faceBeauty/a
    //   98: dup
    //   99: invokespecial 116	com/tencent/faceBeauty/a:<init>	()V
    //   102: astore_3
    //   103: aload_3
    //   104: aload_0
    //   105: invokevirtual 117	com/tencent/faceBeauty/b:detectFace	(Landroid/graphics/Bitmap;)V
    //   108: aload_3
    //   109: invokevirtual 118	com/tencent/faceBeauty/b:detectedFace	()Z
    //   112: istore_2
    //   113: aload_3
    //   114: iconst_0
    //   115: invokevirtual 122	com/tencent/faceBeauty/b:getFaceParams	(I)Lcom/tencent/faceBeauty/FaceParam;
    //   118: astore 6
    //   120: iload_2
    //   121: ifeq +49 -> 170
    //   124: aload 6
    //   126: ifnull +44 -> 170
    //   129: aload 4
    //   131: aload_0
    //   132: aload 6
    //   134: getfield 126	com/tencent/faceBeauty/FaceParam:bcn	Landroid/graphics/Rect;
    //   137: aload 6
    //   139: getfield 64	com/tencent/faceBeauty/FaceParam:bcq	Landroid/graphics/Point;
    //   142: aload 6
    //   144: getfield 67	com/tencent/faceBeauty/FaceParam:bcr	Landroid/graphics/Point;
    //   147: invokevirtual 130	com/tencent/ttpic/util/youtu/TTpicBitmapFaceDetect:detectFaceByManual	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Point;Landroid/graphics/Point;)V
    //   150: aload 4
    //   152: iconst_0
    //   153: invokevirtual 131	com/tencent/ttpic/util/youtu/TTpicBitmapFaceDetect:getFaceParams	(I)Lcom/tencent/faceBeauty/FaceParam;
    //   156: astore_0
    //   157: aload_0
    //   158: ifnull +12 -> 170
    //   161: aload 5
    //   163: aload_0
    //   164: invokeinterface 51 2 0
    //   169: pop
    //   170: aload_3
    //   171: astore_0
    //   172: goto -93 -> 79
    //   175: astore_0
    //   176: aconst_null
    //   177: astore_3
    //   178: aconst_null
    //   179: astore 4
    //   181: aload 4
    //   183: ifnull +8 -> 191
    //   186: aload 4
    //   188: invokevirtual 108	com/tencent/ttpic/util/youtu/TTpicBitmapFaceDetect:destroy	()V
    //   191: aload_3
    //   192: ifnull +7 -> 199
    //   195: aload_3
    //   196: invokevirtual 113	com/tencent/faceBeauty/b:release	()V
    //   199: aload_0
    //   200: athrow
    //   201: astore_0
    //   202: aconst_null
    //   203: astore_3
    //   204: goto -23 -> 181
    //   207: astore_0
    //   208: goto -27 -> 181
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	211	0	paramBitmap	android.graphics.Bitmap
    //   0	211	1	paramInt	int
    //   112	9	2	bool	boolean
    //   1	203	3	locala	com.tencent.faceBeauty.a
    //   32	155	4	localTTpicBitmapFaceDetect	TTpicBitmapFaceDetect
    //   9	153	5	localArrayList	ArrayList
    //   118	25	6	localFaceParam	FaceParam
    // Exception table:
    //   from	to	target	type
    //   25	34	175	finally
    //   34	77	201	finally
    //   95	103	201	finally
    //   103	120	207	finally
    //   129	157	207	finally
    //   161	170	207	finally
  }
  
  private static int distance(Point paramPoint1, Point paramPoint2)
  {
    return (int)Math.sqrt(Math.abs(paramPoint1.x - paramPoint2.x) * Math.abs(paramPoint1.x - paramPoint2.x) + Math.abs(paramPoint1.y - paramPoint2.y) * Math.abs(paramPoint1.y - paramPoint2.y));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.util.youtu.BitmapFaceDetectUtil
 * JD-Core Version:    0.7.0.1
 */