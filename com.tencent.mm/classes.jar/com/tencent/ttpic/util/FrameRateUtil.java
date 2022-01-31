package com.tencent.ttpic.util;

import com.tencent.ttpic.config.MediaConfig;
import com.tencent.util.g;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FrameRateUtil
{
  private static final int BASE_COUNT = 6;
  private static int FPS_LIST_MAX_COUNT = 500;
  public static final int MAX_FPS = 18;
  private static final String TAG = FrameRateUtil.class.getSimpleName();
  private static final long TIME_INTERVAL = 55L;
  private static int count;
  private static List<Long> fpsList = new LinkedList();
  private static List<Long> fpsListForDG = new LinkedList();
  private static FrameRateUtil.DowngradeListener listener;
  private static FrameRateUtil.DOWNGRADE_LEVEL mDowngradeLevel = FrameRateUtil.DOWNGRADE_LEVEL.MEDIUM;
  public static int mFrameCount;
  public static long mRecordStartTime;
  private static long start;
  
  private static void checkDownGrade()
  {
    if (mDowngradeLevel.equals(FrameRateUtil.DOWNGRADE_LEVEL.LOW)) {}
    while (fpsListForDG.size() < 12) {
      return;
    }
    Collections.sort(fpsListForDG);
    int j = 0;
    int i = 4;
    while (i < fpsListForDG.size() - 4)
    {
      j = (int)(j + ((Long)fpsListForDG.get(i)).longValue());
      i += 1;
    }
    if (j / (fpsListForDG.size() - 8) < 10) {
      downgrade();
    }
    fpsListForDG.clear();
  }
  
  /* Error */
  public static void checkFps(long paramLong)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc2_w 20
    //   6: lload_0
    //   7: lsub
    //   8: lconst_0
    //   9: lcmp
    //   10: ifle +9 -> 19
    //   13: ldc2_w 102
    //   16: invokestatic 108	java/lang/Thread:sleep	(J)V
    //   19: ldc 2
    //   21: monitorexit
    //   22: return
    //   23: astore_2
    //   24: goto -5 -> 19
    //   27: astore_2
    //   28: ldc 2
    //   30: monitorexit
    //   31: aload_2
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	paramLong	long
    //   23	1	2	localInterruptedException	java.lang.InterruptedException
    //   27	5	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   13	19	23	java/lang/InterruptedException
    //   13	19	27	finally
  }
  
  public static void clearFpsList()
  {
    try
    {
      g.h(TAG, "clearFpsList");
      fpsList.clear();
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
    if ((mDowngradeLevel == null) || (listener == null)) {
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
    return fpsList;
  }
  
  public static FrameRateUtil.DOWNGRADE_LEVEL getRenderLevel()
  {
    return mDowngradeLevel;
  }
  
  public static void record()
  {
    try
    {
      count += 1;
      if (fpsListForDG.size() >= FPS_LIST_MAX_COUNT) {
        fpsListForDG.clear();
      }
      if (count >= 6)
      {
        long l1 = System.currentTimeMillis();
        long l2 = 6000L / (l1 - start);
        if (fpsList.size() >= FPS_LIST_MAX_COUNT) {
          fpsList.remove(0);
        }
        fpsList.add(Long.valueOf(l2));
        fpsListForDG.add(Long.valueOf(l2));
        start = l1;
        count = 0;
      }
      checkDownGrade();
      return;
    }
    finally {}
  }
  
  /* Error */
  public static void recordFps(boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: ldc 2
    //   4: monitorenter
    //   5: getstatic 160	com/tencent/ttpic/util/FrameRateUtil:count	I
    //   8: iconst_1
    //   9: iadd
    //   10: putstatic 160	com/tencent/ttpic/util/FrameRateUtil:count	I
    //   13: getstatic 52	com/tencent/ttpic/util/FrameRateUtil:fpsListForDG	Ljava/util/List;
    //   16: invokeinterface 75 1 0
    //   21: getstatic 54	com/tencent/ttpic/util/FrameRateUtil:FPS_LIST_MAX_COUNT	I
    //   24: if_icmplt +11 -> 35
    //   27: getstatic 52	com/tencent/ttpic/util/FrameRateUtil:fpsListForDG	Ljava/util/List;
    //   30: invokeinterface 97 1 0
    //   35: getstatic 160	com/tencent/ttpic/util/FrameRateUtil:count	I
    //   38: bipush 6
    //   40: if_icmplt +78 -> 118
    //   43: invokestatic 165	java/lang/System:currentTimeMillis	()J
    //   46: lstore_3
    //   47: ldc2_w 166
    //   50: lload_3
    //   51: getstatic 169	com/tencent/ttpic/util/FrameRateUtil:start	J
    //   54: lsub
    //   55: ldiv
    //   56: lstore 5
    //   58: getstatic 50	com/tencent/ttpic/util/FrameRateUtil:fpsList	Ljava/util/List;
    //   61: invokeinterface 75 1 0
    //   66: getstatic 54	com/tencent/ttpic/util/FrameRateUtil:FPS_LIST_MAX_COUNT	I
    //   69: if_icmplt +13 -> 82
    //   72: getstatic 50	com/tencent/ttpic/util/FrameRateUtil:fpsList	Ljava/util/List;
    //   75: iconst_0
    //   76: invokeinterface 172 2 0
    //   81: pop
    //   82: getstatic 50	com/tencent/ttpic/util/FrameRateUtil:fpsList	Ljava/util/List;
    //   85: lload 5
    //   87: invokestatic 176	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   90: invokeinterface 179 2 0
    //   95: pop
    //   96: getstatic 52	com/tencent/ttpic/util/FrameRateUtil:fpsListForDG	Ljava/util/List;
    //   99: lload 5
    //   101: invokestatic 176	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   104: invokeinterface 179 2 0
    //   109: pop
    //   110: lload_3
    //   111: putstatic 169	com/tencent/ttpic/util/FrameRateUtil:start	J
    //   114: iconst_0
    //   115: putstatic 160	com/tencent/ttpic/util/FrameRateUtil:count	I
    //   118: iload_0
    //   119: ifeq +17 -> 136
    //   122: getstatic 59	com/tencent/ttpic/util/FrameRateUtil:mDowngradeLevel	Lcom/tencent/ttpic/util/FrameRateUtil$DOWNGRADE_LEVEL;
    //   125: getstatic 65	com/tencent/ttpic/util/FrameRateUtil$DOWNGRADE_LEVEL:LOW	Lcom/tencent/ttpic/util/FrameRateUtil$DOWNGRADE_LEVEL;
    //   128: invokevirtual 69	com/tencent/ttpic/util/FrameRateUtil$DOWNGRADE_LEVEL:equals	(Ljava/lang/Object;)Z
    //   131: istore_0
    //   132: iload_0
    //   133: ifeq +7 -> 140
    //   136: ldc 2
    //   138: monitorexit
    //   139: return
    //   140: getstatic 52	com/tencent/ttpic/util/FrameRateUtil:fpsListForDG	Ljava/util/List;
    //   143: invokeinterface 75 1 0
    //   148: bipush 12
    //   150: if_icmplt -14 -> 136
    //   153: getstatic 52	com/tencent/ttpic/util/FrameRateUtil:fpsListForDG	Ljava/util/List;
    //   156: invokestatic 81	java/util/Collections:sort	(Ljava/util/List;)V
    //   159: iconst_4
    //   160: istore_1
    //   161: iload_1
    //   162: getstatic 52	com/tencent/ttpic/util/FrameRateUtil:fpsListForDG	Ljava/util/List;
    //   165: invokeinterface 75 1 0
    //   170: iconst_4
    //   171: isub
    //   172: if_icmpge +30 -> 202
    //   175: iload_2
    //   176: i2l
    //   177: getstatic 52	com/tencent/ttpic/util/FrameRateUtil:fpsListForDG	Ljava/util/List;
    //   180: iload_1
    //   181: invokeinterface 85 2 0
    //   186: checkcast 87	java/lang/Long
    //   189: invokevirtual 91	java/lang/Long:longValue	()J
    //   192: ladd
    //   193: l2i
    //   194: istore_2
    //   195: iload_1
    //   196: iconst_1
    //   197: iadd
    //   198: istore_1
    //   199: goto -38 -> 161
    //   202: iload_2
    //   203: getstatic 52	com/tencent/ttpic/util/FrameRateUtil:fpsListForDG	Ljava/util/List;
    //   206: invokeinterface 75 1 0
    //   211: bipush 8
    //   213: isub
    //   214: idiv
    //   215: bipush 10
    //   217: if_icmpge +6 -> 223
    //   220: invokestatic 94	com/tencent/ttpic/util/FrameRateUtil:downgrade	()V
    //   223: getstatic 52	com/tencent/ttpic/util/FrameRateUtil:fpsListForDG	Ljava/util/List;
    //   226: invokeinterface 97 1 0
    //   231: goto -95 -> 136
    //   234: astore 7
    //   236: ldc 2
    //   238: monitorexit
    //   239: aload 7
    //   241: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	242	0	paramBoolean	boolean
    //   160	39	1	i	int
    //   1	214	2	j	int
    //   46	65	3	l1	long
    //   56	44	5	l2	long
    //   234	6	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   5	35	234	finally
    //   35	82	234	finally
    //   82	118	234	finally
    //   122	132	234	finally
    //   140	159	234	finally
    //   161	195	234	finally
    //   202	223	234	finally
    //   223	231	234	finally
  }
  
  public static void setDowngradeLevel(int paramInt)
  {
    FrameRateUtil.DOWNGRADE_LEVEL[] arrayOfDOWNGRADE_LEVEL = FrameRateUtil.DOWNGRADE_LEVEL.values();
    int j = arrayOfDOWNGRADE_LEVEL.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        FrameRateUtil.DOWNGRADE_LEVEL localDOWNGRADE_LEVEL = arrayOfDOWNGRADE_LEVEL[i];
        if (paramInt == localDOWNGRADE_LEVEL.value) {
          mDowngradeLevel = localDOWNGRADE_LEVEL;
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  public static void setListener(FrameRateUtil.DowngradeListener paramDowngradeListener)
  {
    listener = paramDowngradeListener;
  }
  
  public static void upgrade()
  {
    if (mDowngradeLevel == null) {
      mDowngradeLevel = FrameRateUtil.DOWNGRADE_LEVEL.MEDIUM;
    }
    if (mDowngradeLevel.equals(FrameRateUtil.DOWNGRADE_LEVEL.MEDIUM)) {
      mDowngradeLevel = FrameRateUtil.DOWNGRADE_LEVEL.MEDIUM;
    }
    for (;;)
    {
      VideoPrefsUtil.setDowngradeLevel(mDowngradeLevel.value);
      return;
      if (mDowngradeLevel.equals(FrameRateUtil.DOWNGRADE_LEVEL.LOW)) {
        mDowngradeLevel = FrameRateUtil.DOWNGRADE_LEVEL.MEDIUM;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.util.FrameRateUtil
 * JD-Core Version:    0.7.0.1
 */