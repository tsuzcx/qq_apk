package com.tencent.ttpic.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.config.MediaConfig;
import com.tencent.util.i;
import java.util.LinkedList;
import java.util.List;

public class FrameRateUtil
{
  private static final int BASE_COUNT = 6;
  private static int FPS_LIST_MAX_COUNT = 0;
  public static final int MAX_FPS = 18;
  private static final String TAG;
  private static final long TIME_INTERVAL = 55L;
  private static int count;
  private static List<Long> fpsList;
  private static List<Long> fpsListForDG;
  private static FrameRateUtil.DowngradeListener listener;
  private static FrameRateUtil.DOWNGRADE_LEVEL mDowngradeLevel;
  public static int mFrameCount;
  public static long mRecordStartTime;
  private static long start;
  
  static
  {
    AppMethodBeat.i(83927);
    TAG = FrameRateUtil.class.getSimpleName();
    fpsList = new LinkedList();
    fpsListForDG = new LinkedList();
    FPS_LIST_MAX_COUNT = 500;
    mDowngradeLevel = FrameRateUtil.DOWNGRADE_LEVEL.MEDIUM;
    AppMethodBeat.o(83927);
  }
  
  /* Error */
  public static void checkFps(long paramLong)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 76
    //   5: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc2_w 20
    //   11: lload_0
    //   12: lsub
    //   13: lconst_0
    //   14: lcmp
    //   15: ifle +19 -> 34
    //   18: ldc2_w 77
    //   21: invokestatic 83	java/lang/Thread:sleep	(J)V
    //   24: ldc 76
    //   26: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: ldc 2
    //   31: monitorexit
    //   32: return
    //   33: astore_2
    //   34: ldc 76
    //   36: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   39: goto -10 -> 29
    //   42: astore_2
    //   43: ldc 2
    //   45: monitorexit
    //   46: aload_2
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	paramLong	long
    //   33	1	2	localInterruptedException	java.lang.InterruptedException
    //   42	5	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   18	24	33	java/lang/InterruptedException
    //   3	8	42	finally
    //   18	24	42	finally
    //   24	29	42	finally
    //   34	39	42	finally
  }
  
  public static void clearFpsList()
  {
    try
    {
      AppMethodBeat.i(83922);
      i.l(TAG, "clearFpsList");
      fpsList.clear();
      AppMethodBeat.o(83922);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static void downgrade()
  {
    AppMethodBeat.i(83925);
    if ((mDowngradeLevel == null) || (listener == null))
    {
      AppMethodBeat.o(83925);
      return;
    }
    if (mDowngradeLevel.equals(FrameRateUtil.DOWNGRADE_LEVEL.HIGH))
    {
      mDowngradeLevel = FrameRateUtil.DOWNGRADE_LEVEL.MEDIUM;
      listener.downgrade(MediaConfig.INTERMIDIATE_IMAGE_WIDTH_MEDIUM);
    }
    for (;;)
    {
      new StringBuilder("[downgrade] ").append(mDowngradeLevel.value);
      VideoPrefsUtil.setDowngradeLevel(mDowngradeLevel.value);
      AppMethodBeat.o(83925);
      return;
      if (mDowngradeLevel.equals(FrameRateUtil.DOWNGRADE_LEVEL.MEDIUM))
      {
        mDowngradeLevel = FrameRateUtil.DOWNGRADE_LEVEL.LOW;
        listener.downgrade(MediaConfig.INTERMIDIATE_IMAGE_WIDTH_LOW);
      }
    }
  }
  
  public static List<Long> getFpsList()
  {
    return fpsListForDG;
  }
  
  public static FrameRateUtil.DOWNGRADE_LEVEL getRenderLevel()
  {
    return mDowngradeLevel;
  }
  
  /* Error */
  public static void recordFps(boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc 149
    //   7: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: getstatic 151	com/tencent/ttpic/util/FrameRateUtil:count	I
    //   13: iconst_1
    //   14: iadd
    //   15: putstatic 151	com/tencent/ttpic/util/FrameRateUtil:count	I
    //   18: getstatic 59	com/tencent/ttpic/util/FrameRateUtil:fpsListForDG	Ljava/util/List;
    //   21: invokeinterface 155 1 0
    //   26: getstatic 61	com/tencent/ttpic/util/FrameRateUtil:FPS_LIST_MAX_COUNT	I
    //   29: if_icmplt +11 -> 40
    //   32: getstatic 59	com/tencent/ttpic/util/FrameRateUtil:fpsListForDG	Ljava/util/List;
    //   35: invokeinterface 97 1 0
    //   40: getstatic 151	com/tencent/ttpic/util/FrameRateUtil:count	I
    //   43: bipush 6
    //   45: if_icmplt +78 -> 123
    //   48: invokestatic 161	java/lang/System:currentTimeMillis	()J
    //   51: lstore_3
    //   52: ldc2_w 162
    //   55: lload_3
    //   56: getstatic 165	com/tencent/ttpic/util/FrameRateUtil:start	J
    //   59: lsub
    //   60: ldiv
    //   61: lstore 5
    //   63: getstatic 57	com/tencent/ttpic/util/FrameRateUtil:fpsList	Ljava/util/List;
    //   66: invokeinterface 155 1 0
    //   71: getstatic 61	com/tencent/ttpic/util/FrameRateUtil:FPS_LIST_MAX_COUNT	I
    //   74: if_icmplt +13 -> 87
    //   77: getstatic 57	com/tencent/ttpic/util/FrameRateUtil:fpsList	Ljava/util/List;
    //   80: iconst_0
    //   81: invokeinterface 169 2 0
    //   86: pop
    //   87: getstatic 57	com/tencent/ttpic/util/FrameRateUtil:fpsList	Ljava/util/List;
    //   90: lload 5
    //   92: invokestatic 175	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   95: invokeinterface 178 2 0
    //   100: pop
    //   101: getstatic 59	com/tencent/ttpic/util/FrameRateUtil:fpsListForDG	Ljava/util/List;
    //   104: lload 5
    //   106: invokestatic 175	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   109: invokeinterface 178 2 0
    //   114: pop
    //   115: lload_3
    //   116: putstatic 165	com/tencent/ttpic/util/FrameRateUtil:start	J
    //   119: iconst_0
    //   120: putstatic 151	com/tencent/ttpic/util/FrameRateUtil:count	I
    //   123: iload_0
    //   124: ifeq +115 -> 239
    //   127: getstatic 66	com/tencent/ttpic/util/FrameRateUtil:mDowngradeLevel	Lcom/tencent/ttpic/util/FrameRateUtil$DOWNGRADE_LEVEL;
    //   130: getstatic 137	com/tencent/ttpic/util/FrameRateUtil$DOWNGRADE_LEVEL:LOW	Lcom/tencent/ttpic/util/FrameRateUtil$DOWNGRADE_LEVEL;
    //   133: invokevirtual 108	com/tencent/ttpic/util/FrameRateUtil$DOWNGRADE_LEVEL:equals	(Ljava/lang/Object;)Z
    //   136: ifeq +12 -> 148
    //   139: ldc 149
    //   141: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   144: ldc 2
    //   146: monitorexit
    //   147: return
    //   148: getstatic 59	com/tencent/ttpic/util/FrameRateUtil:fpsListForDG	Ljava/util/List;
    //   151: invokeinterface 155 1 0
    //   156: bipush 12
    //   158: if_icmplt +81 -> 239
    //   161: getstatic 59	com/tencent/ttpic/util/FrameRateUtil:fpsListForDG	Ljava/util/List;
    //   164: invokestatic 184	java/util/Collections:sort	(Ljava/util/List;)V
    //   167: iconst_4
    //   168: istore_1
    //   169: iload_1
    //   170: getstatic 59	com/tencent/ttpic/util/FrameRateUtil:fpsListForDG	Ljava/util/List;
    //   173: invokeinterface 155 1 0
    //   178: iconst_4
    //   179: isub
    //   180: if_icmpge +30 -> 210
    //   183: iload_2
    //   184: i2l
    //   185: getstatic 59	com/tencent/ttpic/util/FrameRateUtil:fpsListForDG	Ljava/util/List;
    //   188: iload_1
    //   189: invokeinterface 187 2 0
    //   194: checkcast 171	java/lang/Long
    //   197: invokevirtual 190	java/lang/Long:longValue	()J
    //   200: ladd
    //   201: l2i
    //   202: istore_2
    //   203: iload_1
    //   204: iconst_1
    //   205: iadd
    //   206: istore_1
    //   207: goto -38 -> 169
    //   210: iload_2
    //   211: getstatic 59	com/tencent/ttpic/util/FrameRateUtil:fpsListForDG	Ljava/util/List;
    //   214: invokeinterface 155 1 0
    //   219: bipush 8
    //   221: isub
    //   222: idiv
    //   223: bipush 10
    //   225: if_icmpge +6 -> 231
    //   228: invokestatic 192	com/tencent/ttpic/util/FrameRateUtil:downgrade	()V
    //   231: getstatic 59	com/tencent/ttpic/util/FrameRateUtil:fpsListForDG	Ljava/util/List;
    //   234: invokeinterface 97 1 0
    //   239: ldc 149
    //   241: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   244: goto -100 -> 144
    //   247: astore 7
    //   249: ldc 2
    //   251: monitorexit
    //   252: aload 7
    //   254: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	255	0	paramBoolean	boolean
    //   168	39	1	i	int
    //   1	222	2	j	int
    //   51	65	3	l1	long
    //   61	44	5	l2	long
    //   247	6	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   5	40	247	finally
    //   40	87	247	finally
    //   87	123	247	finally
    //   127	144	247	finally
    //   148	167	247	finally
    //   169	203	247	finally
    //   210	231	247	finally
    //   231	239	247	finally
    //   239	244	247	finally
  }
  
  public static void setDowngradeLevel(int paramInt)
  {
    AppMethodBeat.i(83926);
    FrameRateUtil.DOWNGRADE_LEVEL[] arrayOfDOWNGRADE_LEVEL = FrameRateUtil.DOWNGRADE_LEVEL.values();
    int j = arrayOfDOWNGRADE_LEVEL.length;
    int i = 0;
    while (i < j)
    {
      FrameRateUtil.DOWNGRADE_LEVEL localDOWNGRADE_LEVEL = arrayOfDOWNGRADE_LEVEL[i];
      if (paramInt == localDOWNGRADE_LEVEL.value)
      {
        mDowngradeLevel = localDOWNGRADE_LEVEL;
        AppMethodBeat.o(83926);
        return;
      }
      i += 1;
    }
    AppMethodBeat.o(83926);
  }
  
  public static void setListener(FrameRateUtil.DowngradeListener paramDowngradeListener)
  {
    listener = paramDowngradeListener;
  }
  
  public static void upgrade()
  {
    AppMethodBeat.i(83924);
    if (mDowngradeLevel == null) {
      mDowngradeLevel = FrameRateUtil.DOWNGRADE_LEVEL.MEDIUM;
    }
    if (mDowngradeLevel.equals(FrameRateUtil.DOWNGRADE_LEVEL.MEDIUM)) {
      mDowngradeLevel = FrameRateUtil.DOWNGRADE_LEVEL.MEDIUM;
    }
    for (;;)
    {
      VideoPrefsUtil.setDowngradeLevel(mDowngradeLevel.value);
      AppMethodBeat.o(83924);
      return;
      if (mDowngradeLevel.equals(FrameRateUtil.DOWNGRADE_LEVEL.LOW)) {
        mDowngradeLevel = FrameRateUtil.DOWNGRADE_LEVEL.MEDIUM;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.util.FrameRateUtil
 * JD-Core Version:    0.7.0.1
 */