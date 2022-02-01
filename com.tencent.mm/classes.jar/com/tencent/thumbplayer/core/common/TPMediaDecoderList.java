package com.tencent.thumbplayer.core.common;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.thirdparties.LocalCache;
import java.util.ArrayList;
import java.util.Arrays;

public final class TPMediaDecoderList
{
  private static final int GET_SYSTEM_MEDIA_CODEC_LIST_TIMEOUT_MS = 2000;
  private static final String MEDIA_DECODER_INFO_KEY = "DecoderInfos_Key";
  private static String MEDIA_DECODER_VERSION = "2.10.0.1072.wechat";
  private static final String MEDIA_DECODER_VERSION_KEY = "Version_Key";
  private static final String TAG = "TPMediaDecoderList";
  private static TPMediaDecoderInfo[] sDecoderInfos = null;
  
  private static void cacheDecoderInfos(LocalCache paramLocalCache, TPMediaDecoderInfo[] paramArrayOfTPMediaDecoderInfo)
  {
    AppMethodBeat.i(227783);
    try
    {
      paramLocalCache.put("DecoderInfos_Key", paramArrayOfTPMediaDecoderInfo);
      AppMethodBeat.o(227783);
      return;
    }
    finally
    {
      TPNativeLog.printLog(4, "TPMediaDecoderList", "cache decode infos failed");
      AppMethodBeat.o(227783);
    }
  }
  
  private static void cacheVersion(LocalCache paramLocalCache, String paramString)
  {
    AppMethodBeat.i(227776);
    try
    {
      paramLocalCache.put("Version_Key", paramString);
      AppMethodBeat.o(227776);
      return;
    }
    finally
    {
      TPNativeLog.printLog(4, "TPMediaDecoderList", "cache version failed");
      AppMethodBeat.o(227776);
    }
  }
  
  private static TPMediaDecoderInfo[] getCachedDecoderInfos(LocalCache paramLocalCache)
  {
    AppMethodBeat.i(227795);
    try
    {
      paramLocalCache = (TPMediaDecoderInfo[])paramLocalCache.getAsObject("DecoderInfos_Key");
      AppMethodBeat.o(227795);
      return paramLocalCache;
    }
    finally
    {
      TPNativeLog.printLog(4, "TPMediaDecoderList", "get decoder info failed");
      AppMethodBeat.o(227795);
    }
    return null;
  }
  
  private static String getCachedVersion(LocalCache paramLocalCache)
  {
    AppMethodBeat.i(227788);
    try
    {
      paramLocalCache = paramLocalCache.getAsString("Version_Key");
      TPNativeLog.printLog(2, "TPMediaDecoderList", "version:".concat(String.valueOf(paramLocalCache)));
      AppMethodBeat.o(227788);
      return paramLocalCache;
    }
    finally
    {
      TPNativeLog.printLog(4, "TPMediaDecoderList", "get version failed");
      AppMethodBeat.o(227788);
    }
    return null;
  }
  
  private static final MediaCodecInfo[] getCodecInfos()
  {
    AppMethodBeat.i(227730);
    if (Build.VERSION.SDK_INT < 16)
    {
      AppMethodBeat.o(227730);
      return null;
    }
    if (Build.VERSION.SDK_INT < 21)
    {
      int j = MediaCodecList.getCodecCount();
      localObject = new ArrayList();
      int i = 0;
      while (i < j)
      {
        ((ArrayList)localObject).add(MediaCodecList.getCodecInfoAt(i));
        i += 1;
      }
      localObject = (MediaCodecInfo[])((ArrayList)localObject).toArray(new MediaCodecInfo[((ArrayList)localObject).size()]);
      AppMethodBeat.o(227730);
      return localObject;
    }
    Object localObject = new MediaCodecList(1).getCodecInfos();
    AppMethodBeat.o(227730);
    return localObject;
  }
  
  private static final TPMediaDecoderInfo[] getLocalCacheMediaCodecList(LocalCache paramLocalCache)
  {
    AppMethodBeat.i(227745);
    TPNativeLog.printLog(2, "getLocalCacheMediaCodecList");
    String str = getCachedVersion(paramLocalCache);
    if ((str != null) && (str.equals(MEDIA_DECODER_VERSION)))
    {
      paramLocalCache = getCachedDecoderInfos(paramLocalCache);
      if (paramLocalCache != null)
      {
        TPNativeLog.printLog(2, "getCachedDecoderInfos length " + paramLocalCache.length);
        AppMethodBeat.o(227745);
        return paramLocalCache;
      }
    }
    AppMethodBeat.o(227745);
    return null;
  }
  
  private static TPMediaDecoderInfo[] getSystemMediaCodecList()
  {
    AppMethodBeat.i(227737);
    TPNativeLog.printLog(2, "getSystemMediaCodecList");
    Object localObject1 = getCodecInfos();
    if (localObject1 == null)
    {
      AppMethodBeat.o(227737);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int k = localObject1.length;
    int i = 0;
    while (i < k)
    {
      Object localObject2 = localObject1[i];
      if (!localObject2.isEncoder())
      {
        String[] arrayOfString = localObject2.getSupportedTypes();
        int m = arrayOfString.length;
        int j = 0;
        while (j < m)
        {
          String str = arrayOfString[j];
          TPMediaDecoderInfo localTPMediaDecoderInfo = new TPMediaDecoderInfo(str, localObject2.getName(), localObject2.getCapabilitiesForType(str));
          if (!localTPMediaDecoderInfo.isVideoSofwareDecoder())
          {
            TPNativeLog.printLog(2, "MediaCodecList codecName " + localObject2.getName() + "supportedType " + str);
            localArrayList.add(localTPMediaDecoderInfo);
          }
          j += 1;
        }
      }
      i += 1;
    }
    localObject1 = (TPMediaDecoderInfo[])localArrayList.toArray(new TPMediaDecoderInfo[localArrayList.size()]);
    AppMethodBeat.o(227737);
    return localObject1;
  }
  
  /* Error */
  private static TPMediaDecoderInfo[] getSystemMediaCodecListAsyncAndTimeOutWait()
  {
    // Byte code:
    //   0: ldc 209
    //   2: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 185
    //   7: iconst_2
    //   8: newarray int
    //   10: dup
    //   11: iconst_0
    //   12: iconst_1
    //   13: iastore
    //   14: dup
    //   15: iconst_1
    //   16: iconst_1
    //   17: iastore
    //   18: invokestatic 215	java/lang/reflect/Array:newInstance	(Ljava/lang/Class;[I)Ljava/lang/Object;
    //   21: checkcast 217	[[Lcom/tencent/thumbplayer/core/common/TPMediaDecoderInfo;
    //   24: astore 5
    //   26: aload 5
    //   28: iconst_0
    //   29: aconst_null
    //   30: aastore
    //   31: iconst_1
    //   32: newarray boolean
    //   34: astore 6
    //   36: aload 6
    //   38: iconst_0
    //   39: iconst_0
    //   40: bastore
    //   41: new 219	java/lang/Thread
    //   44: dup
    //   45: new 6	com/tencent/thumbplayer/core/common/TPMediaDecoderList$1
    //   48: dup
    //   49: aload 5
    //   51: aload 6
    //   53: invokespecial 222	com/tencent/thumbplayer/core/common/TPMediaDecoderList$1:<init>	([[Lcom/tencent/thumbplayer/core/common/TPMediaDecoderInfo;[Z)V
    //   56: invokespecial 225	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   59: invokevirtual 228	java/lang/Thread:start	()V
    //   62: invokestatic 234	java/lang/System:currentTimeMillis	()J
    //   65: lstore_3
    //   66: ldc2_w 235
    //   69: lstore_1
    //   70: aload 5
    //   72: monitorenter
    //   73: iconst_0
    //   74: istore_0
    //   75: lload_1
    //   76: lconst_0
    //   77: lcmp
    //   78: ifle +27 -> 105
    //   81: aload 6
    //   83: iconst_0
    //   84: baload
    //   85: ifne +20 -> 105
    //   88: aload 5
    //   90: lload_1
    //   91: invokevirtual 240	java/lang/Object:wait	(J)V
    //   94: lload_1
    //   95: invokestatic 234	java/lang/System:currentTimeMillis	()J
    //   98: lload_3
    //   99: lsub
    //   100: lsub
    //   101: lstore_1
    //   102: goto -27 -> 75
    //   105: aload 5
    //   107: monitorexit
    //   108: iload_0
    //   109: ifeq +9 -> 118
    //   112: invokestatic 244	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   115: invokevirtual 247	java/lang/Thread:interrupt	()V
    //   118: aload 5
    //   120: iconst_0
    //   121: aaload
    //   122: astore 5
    //   124: aload 5
    //   126: ifnonnull +26 -> 152
    //   129: ldc 209
    //   131: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   134: iconst_0
    //   135: anewarray 185	com/tencent/thumbplayer/core/common/TPMediaDecoderInfo
    //   138: areturn
    //   139: astore 6
    //   141: aload 5
    //   143: monitorexit
    //   144: ldc 209
    //   146: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   149: aload 6
    //   151: athrow
    //   152: ldc 209
    //   154: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   157: aload 5
    //   159: areturn
    //   160: astore 7
    //   162: iconst_1
    //   163: istore_0
    //   164: goto -70 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   74	90	0	i	int
    //   69	33	1	l1	long
    //   65	34	3	l2	long
    //   24	134	5	localObject1	Object
    //   34	48	6	arrayOfBoolean	boolean[]
    //   139	11	6	localObject2	Object
    //   160	1	7	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   88	94	139	finally
    //   94	102	139	finally
    //   105	108	139	finally
    //   88	94	160	java/lang/InterruptedException
  }
  
  public static final TPMediaDecoderInfo[] getTPMediaDecoderInfos(LocalCache paramLocalCache)
  {
    try
    {
      AppMethodBeat.i(227724);
      if (sDecoderInfos == null) {
        sDecoderInfos = initCodecList(paramLocalCache);
      }
      paramLocalCache = sDecoderInfos;
      paramLocalCache = (TPMediaDecoderInfo[])Arrays.copyOf(paramLocalCache, paramLocalCache.length);
      AppMethodBeat.o(227724);
      return paramLocalCache;
    }
    finally {}
  }
  
  private static final TPMediaDecoderInfo[] initCodecList(LocalCache paramLocalCache)
  {
    AppMethodBeat.i(227770);
    TPMediaDecoderInfo[] arrayOfTPMediaDecoderInfo2 = getLocalCacheMediaCodecList(paramLocalCache);
    TPMediaDecoderInfo[] arrayOfTPMediaDecoderInfo1;
    if (arrayOfTPMediaDecoderInfo2 != null)
    {
      arrayOfTPMediaDecoderInfo1 = arrayOfTPMediaDecoderInfo2;
      if (arrayOfTPMediaDecoderInfo2.length != 0) {}
    }
    else
    {
      arrayOfTPMediaDecoderInfo1 = getSystemMediaCodecListAsyncAndTimeOutWait();
      storeLocalCacheMediaCodecList(paramLocalCache, arrayOfTPMediaDecoderInfo1);
    }
    AppMethodBeat.o(227770);
    return arrayOfTPMediaDecoderInfo1;
  }
  
  private static final void storeLocalCacheMediaCodecList(LocalCache paramLocalCache, TPMediaDecoderInfo[] paramArrayOfTPMediaDecoderInfo)
  {
    AppMethodBeat.i(227752);
    TPNativeLog.printLog(2, "storeLocalCacheMediaCodecList");
    cacheDecoderInfos(paramLocalCache, paramArrayOfTPMediaDecoderInfo);
    cacheVersion(paramLocalCache, MEDIA_DECODER_VERSION);
    AppMethodBeat.o(227752);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPMediaDecoderList
 * JD-Core Version:    0.7.0.1
 */