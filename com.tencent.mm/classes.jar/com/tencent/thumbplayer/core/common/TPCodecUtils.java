package com.tencent.thumbplayer.core.common;

import android.content.Context;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecList;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.thirdparties.LocalCache;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

public class TPCodecUtils
{
  public static final int CAP_AUDIO_AAC = 4;
  public static final int CAP_AUDIO_DDP = 8;
  public static final int CAP_VIDEO_AVC = 1;
  public static final int CAP_VIDEO_HEVC = 2;
  public static final int PLAYER_LEVEL_1 = 1;
  public static final int PLAYER_LEVEL_11 = 11;
  public static final int PLAYER_LEVEL_16 = 16;
  public static final int PLAYER_LEVEL_21 = 21;
  public static final int PLAYER_LEVEL_26 = 26;
  public static final int PLAYER_LEVEL_28 = 28;
  public static final int PLAYER_LEVEL_33 = 33;
  public static final int PLAYER_LEVEL_6 = 6;
  private static final String TAG = "TPCodecUtils";
  private static TPCodecCapability.TPVCodecMaxCapability mAVCMediaCodecMaxCapability;
  private static TPCodecCapability.TPVCodecMaxCapability mAVCSWMaxCapability;
  private static Context mApplicationContext;
  private static HashMap<String, Integer> mCodecCap;
  private static int mDeviceLevel;
  private static String mHDR10CapabilityKey;
  private static String mHDR10PLUSCapabilityKey;
  private static String mHDRDOLBYVISIONCapabilityKey;
  private static String mHDRHLGCapabilityKey;
  private static TPCodecCapability.TPVCodecMaxCapability mHEVCMediaCodecMaxCapability;
  private static TPCodecCapability.TPVCodecMaxCapability mHEVCSWMaxCapability;
  protected static ArrayList<String> mHWCodecCapList;
  private static String mHWCodecCapListKey;
  private static int mHdHevcHisiIndex;
  private static int mHdHevcMtkIndex;
  private static int mHdHevcQualcommIndex;
  private static int mHdHevcSumsingIndex;
  private static boolean mIsFFmpegCapGot;
  private static int mIsInBlackListForHardwareDec;
  private static boolean mIsInitDone;
  private static boolean mIsLocalCacheEnabled;
  private static boolean mIsMediaCodecCapGot;
  private static HashMap<Integer, TPCodecCapability.TPVCodecMaxCapability> mMaxVCodecHwCapabilityMap;
  private static String mMaxVCodecHwCapabilityMapKey;
  private static HashMap<Integer, TPCodecCapability.TPVCodecMaxCapability> mMaxVCodecSwCapabilityMap;
  private static String mMaxVCodecSwCapabilityMapKey;
  private static boolean mNeedToReprobeDecoderCapability;
  private static boolean mNeedToReprobeHDRCapability;
  private static String mPlayerCoreVersion;
  private static int mShdHevcHisiIndex;
  private static int mShdHevcMtkIndex;
  private static int mShdHevcQualcommIndex;
  private static int mShdHevcSumsingIndex;
  protected static ArrayList<String> mSoftCodecCapList;
  private static String mSoftCodecCapListKey;
  private static String mStoredPlayerCoreVersionKey;
  private static String mSupportValue;
  private static String mUnsupportValue;
  private static TPCodecCapability.TPVCodecMaxCapability mVP9MediaCodecMaxCapability;
  private static TPCodecCapability.TPVCodecMaxCapability mVP9SWMaxCapability;
  protected static ArrayList<String> mffmpegVCodecCapList;
  private static String mffmpegVCodecCapListKey;
  private static int sDolbyLevel;
  private static boolean sIsDDPInit;
  private static boolean sIsDDPSup;
  private static boolean sIsDDSInit;
  private static boolean sIsDDSSup;
  
  static
  {
    AppMethodBeat.i(220412);
    mDeviceLevel = -1;
    mCodecCap = null;
    mApplicationContext = null;
    mIsLocalCacheEnabled = false;
    mNeedToReprobeDecoderCapability = true;
    mNeedToReprobeHDRCapability = true;
    mPlayerCoreVersion = "2.3.1.1071.wechat";
    mHWCodecCapList = new ArrayList();
    mSoftCodecCapList = new ArrayList();
    mffmpegVCodecCapList = new ArrayList();
    mIsInitDone = false;
    mIsInBlackListForHardwareDec = -1;
    sIsDDPInit = false;
    sIsDDPSup = false;
    sIsDDSInit = false;
    sIsDDSSup = false;
    sDolbyLevel = -1;
    mStoredPlayerCoreVersionKey = "Playercore_version_Key";
    mHWCodecCapListKey = "HW_list_Key";
    mSoftCodecCapListKey = "Soft_list_Key";
    mffmpegVCodecCapListKey = "FFmpeg_list_Key";
    mMaxVCodecHwCapabilityMapKey = "HW_CapMap_key";
    mMaxVCodecSwCapabilityMapKey = "SW_CapMap_key";
    mHDR10CapabilityKey = "HDR10_cap_Key";
    mHDR10PLUSCapabilityKey = "HDR10PLUS_cap_Key";
    mHDRDOLBYVISIONCapabilityKey = "HDRDOLBYVISION_cap_Key";
    mHDRHLGCapabilityKey = "HDRHLG_cap_Key";
    mSupportValue = "support";
    mUnsupportValue = "unsupport";
    mShdHevcQualcommIndex = 32;
    mHdHevcQualcommIndex = 20;
    mShdHevcMtkIndex = 12;
    mHdHevcMtkIndex = 8;
    mShdHevcHisiIndex = 8;
    mHdHevcHisiIndex = 3;
    mShdHevcSumsingIndex = 8;
    mHdHevcSumsingIndex = 5;
    HashMap localHashMap = new HashMap();
    mCodecCap = localHashMap;
    localHashMap.put("NX511J", Integer.valueOf(7));
    mCodecCap.put("Hi3798MV100", Integer.valueOf(7));
    mCodecCap.put("长虹智能电视", Integer.valueOf(7));
    mCodecCap.put("Android TV on Tcl 901", Integer.valueOf(7));
    mCodecCap.put("xt880b", Integer.valueOf(7));
    TPNativeLog.printLog(2, "TPCodecUtils", "white list init");
    mIsMediaCodecCapGot = false;
    mIsFFmpegCapGot = false;
    mAVCMediaCodecMaxCapability = new TPCodecCapability.TPVCodecMaxCapability(0, 0, 0);
    mHEVCMediaCodecMaxCapability = new TPCodecCapability.TPVCodecMaxCapability(0, 0, 0);
    mVP9MediaCodecMaxCapability = new TPCodecCapability.TPVCodecMaxCapability(0, 0, 0);
    mAVCSWMaxCapability = new TPCodecCapability.TPVCodecMaxCapability(0, 0, 0);
    mHEVCSWMaxCapability = new TPCodecCapability.TPVCodecMaxCapability(0, 0, 0);
    mVP9SWMaxCapability = new TPCodecCapability.TPVCodecMaxCapability(0, 0, 0);
    mMaxVCodecHwCapabilityMap = new HashMap();
    mMaxVCodecSwCapabilityMap = new HashMap();
    AppMethodBeat.o(220412);
  }
  
  private static void cacheCapList(String paramString, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(220397);
    if (mApplicationContext != null) {
      try
      {
        LocalCache localLocalCache = LocalCache.get(mApplicationContext);
        if (localLocalCache != null) {
          localLocalCache.put(paramString, paramArrayList);
        }
        AppMethodBeat.o(220397);
        return;
      }
      catch (Throwable paramArrayList)
      {
        TPNativeLog.printLog(4, "TPCodecUtils", "cache " + paramString + "failed");
      }
    }
    AppMethodBeat.o(220397);
  }
  
  private static void cacheCapabilityMap(String paramString, HashMap<Integer, TPCodecCapability.TPVCodecMaxCapability> paramHashMap)
  {
    AppMethodBeat.i(220398);
    if (mApplicationContext != null) {
      try
      {
        LocalCache localLocalCache = LocalCache.get(mApplicationContext);
        if (localLocalCache != null) {
          localLocalCache.put(paramString, paramHashMap);
        }
        AppMethodBeat.o(220398);
        return;
      }
      catch (Throwable paramHashMap)
      {
        TPNativeLog.printLog(4, "TPCodecUtils", "cache " + paramString + "failed");
      }
    }
    AppMethodBeat.o(220398);
  }
  
  private static void cacheStringInfo(String paramString1, String paramString2)
  {
    AppMethodBeat.i(220396);
    if (mApplicationContext != null) {
      try
      {
        LocalCache localLocalCache = LocalCache.get(mApplicationContext);
        if (localLocalCache != null) {
          localLocalCache.put(paramString1, paramString2);
        }
        AppMethodBeat.o(220396);
        return;
      }
      catch (Throwable paramString2)
      {
        TPNativeLog.printLog(4, "TPCodecUtils", "cache " + paramString1 + "failed");
      }
    }
    AppMethodBeat.o(220396);
  }
  
  public static boolean getAudioMediaCodecPassThroughCap(int paramInt1, int paramInt2, int paramInt3)
  {
    int j = 1;
    AppMethodBeat.i(220411);
    if (paramInt1 != 5004)
    {
      AppMethodBeat.o(220411);
      return false;
    }
    int i;
    if (paramInt1 == 5004) {
      if (paramInt2 == 20) {
        i = 7;
      }
    }
    for (;;)
    {
      boolean bool = TPAudioPassThroughPluginDetector.isAudioPassThroughSupport(i, paramInt3);
      AppMethodBeat.o(220411);
      return bool;
      i = j;
      if (paramInt2 == 20)
      {
        i = 8;
        continue;
        i = j;
        if (paramInt1 == 5002) {
          if (paramInt2 == 1)
          {
            i = 10;
          }
          else if (paramInt2 == 4)
          {
            i = 11;
          }
          else
          {
            i = j;
            if (paramInt2 == 28) {
              i = 12;
            }
          }
        }
      }
    }
  }
  
  private static ArrayList<String> getCachedCapList(String paramString)
  {
    AppMethodBeat.i(220400);
    if (mApplicationContext != null) {
      try
      {
        Object localObject = LocalCache.get(mApplicationContext);
        if (localObject != null)
        {
          localObject = (ArrayList)((LocalCache)localObject).getAsObject(paramString);
          AppMethodBeat.o(220400);
          return localObject;
        }
      }
      catch (Throwable localThrowable)
      {
        TPNativeLog.printLog(4, "TPCodecUtils", "get " + paramString + "failed");
      }
    }
    AppMethodBeat.o(220400);
    return null;
  }
  
  private static HashMap<Integer, TPCodecCapability.TPVCodecMaxCapability> getCachedCapabilityMap(String paramString)
  {
    AppMethodBeat.i(220401);
    if (mApplicationContext != null) {
      try
      {
        Object localObject = LocalCache.get(mApplicationContext);
        if (localObject != null)
        {
          localObject = (HashMap)((LocalCache)localObject).getAsObject(paramString);
          AppMethodBeat.o(220401);
          return localObject;
        }
      }
      catch (Throwable localThrowable)
      {
        TPNativeLog.printLog(4, "TPCodecUtils", "get " + paramString + "failed");
      }
    }
    AppMethodBeat.o(220401);
    return null;
  }
  
  private static String getCachedStringInfo(String paramString)
  {
    AppMethodBeat.i(220399);
    if (mApplicationContext != null) {
      try
      {
        Object localObject = LocalCache.get(mApplicationContext);
        if (localObject != null)
        {
          localObject = ((LocalCache)localObject).getAsString(paramString);
          AppMethodBeat.o(220399);
          return localObject;
        }
      }
      catch (Throwable localThrowable)
      {
        TPNativeLog.printLog(4, "TPCodecUtils", "get " + paramString + "failed");
      }
    }
    AppMethodBeat.o(220399);
    return null;
  }
  
  /* Error */
  public static void getDecoderMaxCapabilityMapAsync()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 340
    //   6: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 127	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsInitDone	Z
    //   12: ifeq +22 -> 34
    //   15: iconst_2
    //   16: ldc 34
    //   18: ldc_w 342
    //   21: invokestatic 234	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   24: ldc_w 340
    //   27: invokestatic 262	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: ldc 2
    //   32: monitorexit
    //   33: return
    //   34: iconst_2
    //   35: ldc 34
    //   37: ldc_w 344
    //   40: invokestatic 234	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   43: new 346	java/lang/Thread
    //   46: dup
    //   47: new 6	com/tencent/thumbplayer/core/common/TPCodecUtils$1
    //   50: dup
    //   51: invokespecial 347	com/tencent/thumbplayer/core/common/TPCodecUtils$1:<init>	()V
    //   54: invokespecial 350	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   57: astore_0
    //   58: aload_0
    //   59: ldc_w 352
    //   62: invokevirtual 355	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   65: aload_0
    //   66: invokevirtual 358	java/lang/Thread:start	()V
    //   69: ldc_w 340
    //   72: invokestatic 262	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   75: goto -45 -> 30
    //   78: astore_0
    //   79: ldc 2
    //   81: monitorexit
    //   82: aload_0
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   57	9	0	localThread	java.lang.Thread
    //   78	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	30	78	finally
    //   34	75	78	finally
  }
  
  private static int getHevcLvByCoresAndFreq()
  {
    int i = 21;
    AppMethodBeat.i(220381);
    if (TPSystemInfo.getNumCores() >= 8) {
      if (TPSystemInfo.getMaxCpuFreq() / 1000L < 1200L) {}
    }
    for (;;)
    {
      AppMethodBeat.o(220381);
      return i;
      i = 16;
      continue;
      if (TPSystemInfo.getNumCores() >= 6)
      {
        if (TPSystemInfo.getMaxCpuFreq() / 1000L < 1400L) {
          i = 16;
        }
      }
      else if (TPSystemInfo.getNumCores() >= 4)
      {
        if (TPSystemInfo.getMaxCpuFreq() / 1000L < 1600L) {
          i = 16;
        }
      }
      else {
        i = 6;
      }
    }
  }
  
  public static int getHwDolbyLevel()
  {
    AppMethodBeat.i(220395);
    if (sDolbyLevel == -1) {
      initDolbyInvariableParams();
    }
    int i = sDolbyLevel;
    AppMethodBeat.o(220395);
    return i;
  }
  
  /* Error */
  public static HashMap<Integer, TPCodecCapability.TPVCodecMaxCapability> getMediaCodecMaxCapabilityMap()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 400
    //   6: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: iconst_2
    //   10: ldc 34
    //   12: ldc_w 402
    //   15: invokestatic 234	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   18: getstatic 236	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsMediaCodecCapGot	Z
    //   21: ifeq +29 -> 50
    //   24: iconst_2
    //   25: ldc 34
    //   27: ldc_w 404
    //   30: invokestatic 234	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   33: getstatic 257	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   36: astore 12
    //   38: ldc_w 400
    //   41: invokestatic 262	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: ldc 2
    //   46: monitorexit
    //   47: aload 12
    //   49: areturn
    //   50: getstatic 106	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsLocalCacheEnabled	Z
    //   53: ifeq +175 -> 228
    //   56: getstatic 108	com/tencent/thumbplayer/core/common/TPCodecUtils:mNeedToReprobeDecoderCapability	Z
    //   59: ifne +169 -> 228
    //   62: iconst_2
    //   63: ldc 34
    //   65: ldc_w 406
    //   68: invokestatic 234	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   71: getstatic 121	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   74: ifnull +12 -> 86
    //   77: getstatic 121	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   80: invokevirtual 409	java/util/ArrayList:size	()I
    //   83: ifne +21 -> 104
    //   86: getstatic 147	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapListKey	Ljava/lang/String;
    //   89: invokestatic 411	com/tencent/thumbplayer/core/common/TPCodecUtils:getCachedCapList	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   92: astore 12
    //   94: aload 12
    //   96: ifnull +8 -> 104
    //   99: aload 12
    //   101: putstatic 121	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   104: getstatic 121	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   107: ifnull +121 -> 228
    //   110: getstatic 121	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   113: invokevirtual 409	java/util/ArrayList:size	()I
    //   116: ifle +112 -> 228
    //   119: getstatic 159	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMapKey	Ljava/lang/String;
    //   122: invokestatic 413	com/tencent/thumbplayer/core/common/TPCodecUtils:getCachedCapabilityMap	(Ljava/lang/String;)Ljava/util/HashMap;
    //   125: astore 12
    //   127: aload 12
    //   129: ifnull +99 -> 228
    //   132: aload 12
    //   134: putstatic 257	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   137: aload 12
    //   139: invokevirtual 414	java/util/HashMap:size	()I
    //   142: ifle +86 -> 228
    //   145: iconst_2
    //   146: ldc 34
    //   148: new 283	java/lang/StringBuilder
    //   151: dup
    //   152: ldc_w 416
    //   155: invokespecial 288	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   158: getstatic 257	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   161: invokevirtual 414	java/util/HashMap:size	()I
    //   164: invokevirtual 419	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   167: invokevirtual 298	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokestatic 234	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   173: iconst_1
    //   174: putstatic 236	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsMediaCodecCapGot	Z
    //   177: getstatic 257	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   180: astore 12
    //   182: ldc_w 400
    //   185: invokestatic 262	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   188: goto -144 -> 44
    //   191: astore 12
    //   193: ldc 2
    //   195: monitorexit
    //   196: aload 12
    //   198: athrow
    //   199: astore 12
    //   201: iconst_4
    //   202: ldc 34
    //   204: new 283	java/lang/StringBuilder
    //   207: dup
    //   208: ldc_w 421
    //   211: invokespecial 288	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   214: aload 12
    //   216: invokevirtual 424	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   219: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: invokevirtual 298	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: invokestatic 234	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   228: iconst_0
    //   229: istore_3
    //   230: iconst_0
    //   231: istore_1
    //   232: iconst_0
    //   233: istore_0
    //   234: ldc_w 426
    //   237: invokestatic 432	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   240: astore 12
    //   242: aload 12
    //   244: ldc_w 434
    //   247: iconst_0
    //   248: anewarray 428	java/lang/Class
    //   251: invokevirtual 438	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   254: astore 20
    //   256: aload 12
    //   258: ldc_w 440
    //   261: iconst_1
    //   262: anewarray 428	java/lang/Class
    //   265: dup
    //   266: iconst_0
    //   267: getstatic 444	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   270: aastore
    //   271: invokevirtual 438	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   274: astore 12
    //   276: ldc_w 446
    //   279: invokestatic 432	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   282: astore 16
    //   284: aload 16
    //   286: ldc_w 448
    //   289: iconst_0
    //   290: anewarray 428	java/lang/Class
    //   293: invokevirtual 438	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   296: astore 13
    //   298: aload 16
    //   300: ldc_w 450
    //   303: iconst_0
    //   304: anewarray 428	java/lang/Class
    //   307: invokevirtual 438	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   310: astore 14
    //   312: aload 16
    //   314: ldc_w 452
    //   317: iconst_0
    //   318: anewarray 428	java/lang/Class
    //   321: invokevirtual 438	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   324: astore 15
    //   326: aload 16
    //   328: ldc_w 454
    //   331: iconst_1
    //   332: anewarray 428	java/lang/Class
    //   335: dup
    //   336: iconst_0
    //   337: ldc_w 456
    //   340: aastore
    //   341: invokevirtual 438	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   344: astore 16
    //   346: ldc_w 458
    //   349: invokestatic 432	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   352: ldc_w 460
    //   355: invokevirtual 464	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   358: astore 17
    //   360: ldc_w 466
    //   363: invokestatic 432	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   366: astore 19
    //   368: aload 19
    //   370: ldc_w 468
    //   373: invokevirtual 464	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   376: astore 18
    //   378: aload 19
    //   380: ldc_w 470
    //   383: invokevirtual 464	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   386: astore 19
    //   388: aload 20
    //   390: aconst_null
    //   391: iconst_0
    //   392: anewarray 4	java/lang/Object
    //   395: invokevirtual 476	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   398: checkcast 210	java/lang/Integer
    //   401: invokevirtual 479	java/lang/Integer:intValue	()I
    //   404: istore 8
    //   406: iconst_2
    //   407: ldc_w 481
    //   410: iload 8
    //   412: invokestatic 484	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   415: invokevirtual 487	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   418: invokestatic 490	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   421: iconst_0
    //   422: istore 4
    //   424: iload 4
    //   426: iload 8
    //   428: if_icmpge +1292 -> 1720
    //   431: aload 12
    //   433: aconst_null
    //   434: iconst_1
    //   435: anewarray 4	java/lang/Object
    //   438: dup
    //   439: iconst_0
    //   440: iload 4
    //   442: invokestatic 214	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   445: aastore
    //   446: invokevirtual 476	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   449: astore 20
    //   451: iload_0
    //   452: istore_2
    //   453: iload_1
    //   454: istore 6
    //   456: iload_3
    //   457: istore 7
    //   459: aload 15
    //   461: aload 20
    //   463: iconst_0
    //   464: anewarray 4	java/lang/Object
    //   467: invokevirtual 476	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   470: checkcast 492	java/lang/Boolean
    //   473: invokevirtual 496	java/lang/Boolean:booleanValue	()Z
    //   476: ifne +1227 -> 1703
    //   479: aload 14
    //   481: aload 20
    //   483: iconst_0
    //   484: anewarray 4	java/lang/Object
    //   487: invokevirtual 476	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   490: checkcast 456	java/lang/String
    //   493: invokevirtual 499	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   496: astore 21
    //   498: aload 13
    //   500: aload 20
    //   502: iconst_0
    //   503: anewarray 4	java/lang/Object
    //   506: invokevirtual 476	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   509: checkcast 501	[Ljava/lang/String;
    //   512: checkcast 501	[Ljava/lang/String;
    //   515: astore 22
    //   517: aload 22
    //   519: arraylength
    //   520: istore 9
    //   522: iconst_0
    //   523: istore 5
    //   525: iload_0
    //   526: istore_2
    //   527: iload_1
    //   528: istore 6
    //   530: iload_3
    //   531: istore 7
    //   533: iload 5
    //   535: iload 9
    //   537: if_icmpge +1166 -> 1703
    //   540: aload 22
    //   542: iload 5
    //   544: aaload
    //   545: astore 23
    //   547: iconst_2
    //   548: ldc_w 503
    //   551: aload 23
    //   553: invokestatic 506	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   556: invokevirtual 487	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   559: invokestatic 490	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   562: aload 21
    //   564: ldc_w 508
    //   567: invokevirtual 512	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   570: ifne +36 -> 606
    //   573: aload 21
    //   575: ldc_w 514
    //   578: invokevirtual 512	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   581: ifne +25 -> 606
    //   584: aload 21
    //   586: ldc_w 516
    //   589: invokevirtual 512	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   592: ifne +14 -> 606
    //   595: aload 21
    //   597: ldc_w 518
    //   600: invokevirtual 512	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   603: ifeq +17 -> 620
    //   606: getstatic 123	com/tencent/thumbplayer/core/common/TPCodecUtils:mSoftCodecCapList	Ljava/util/ArrayList;
    //   609: aload 23
    //   611: invokevirtual 522	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   614: pop
    //   615: iload_3
    //   616: istore_2
    //   617: goto +1561 -> 2178
    //   620: getstatic 121	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   623: aload 23
    //   625: invokevirtual 522	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   628: pop
    //   629: getstatic 121	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   632: ldc_w 524
    //   635: invokevirtual 526	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   638: istore 11
    //   640: iload_3
    //   641: istore_2
    //   642: iload 11
    //   644: ifeq +238 -> 882
    //   647: iload_3
    //   648: istore_2
    //   649: iload_3
    //   650: ifne +232 -> 882
    //   653: aload 17
    //   655: aload 16
    //   657: aload 20
    //   659: iconst_1
    //   660: anewarray 4	java/lang/Object
    //   663: dup
    //   664: iconst_0
    //   665: ldc_w 524
    //   668: aastore
    //   669: invokevirtual 476	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   672: invokevirtual 531	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   675: checkcast 533	[Ljava/lang/Object;
    //   678: checkcast 533	[Ljava/lang/Object;
    //   681: astore 23
    //   683: aload 23
    //   685: arraylength
    //   686: istore_3
    //   687: iconst_0
    //   688: istore_2
    //   689: iload_2
    //   690: iload_3
    //   691: if_icmpge +100 -> 791
    //   694: aload 23
    //   696: iload_2
    //   697: aaload
    //   698: astore 24
    //   700: aload 18
    //   702: aload 24
    //   704: invokevirtual 531	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   707: checkcast 210	java/lang/Integer
    //   710: invokevirtual 479	java/lang/Integer:intValue	()I
    //   713: istore 6
    //   715: aload 19
    //   717: aload 24
    //   719: invokevirtual 531	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   722: checkcast 210	java/lang/Integer
    //   725: invokevirtual 479	java/lang/Integer:intValue	()I
    //   728: istore 7
    //   730: iload 7
    //   732: iload 6
    //   734: invokestatic 537	com/tencent/thumbplayer/core/common/TPCodecUtils:maxLumaSamplesForAVCProfileLevel	(II)I
    //   737: istore 10
    //   739: iload 10
    //   741: getstatic 245	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   744: getfield 540	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   747: if_icmplt +1442 -> 2189
    //   750: getstatic 245	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   753: iload 10
    //   755: putfield 540	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   758: getstatic 245	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   761: iload 7
    //   763: putfield 543	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxProfile	I
    //   766: getstatic 245	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   769: iload 6
    //   771: putfield 546	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLevel	I
    //   774: bipush 26
    //   776: invokestatic 214	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   779: getstatic 245	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   782: getstatic 257	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   785: invokestatic 550	com/tencent/thumbplayer/core/common/TPCodecUtils:replace	(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/HashMap;)V
    //   788: goto +1401 -> 2189
    //   791: iconst_2
    //   792: new 283	java/lang/StringBuilder
    //   795: dup
    //   796: ldc_w 552
    //   799: invokespecial 288	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   802: getstatic 257	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   805: bipush 26
    //   807: invokestatic 214	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   810: invokevirtual 553	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   813: checkcast 240	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability
    //   816: getfield 543	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxProfile	I
    //   819: invokevirtual 419	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   822: ldc_w 555
    //   825: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   828: getstatic 257	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   831: bipush 26
    //   833: invokestatic 214	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   836: invokevirtual 553	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   839: checkcast 240	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability
    //   842: getfield 546	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLevel	I
    //   845: invokevirtual 419	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   848: ldc_w 557
    //   851: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   854: getstatic 257	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   857: bipush 26
    //   859: invokestatic 214	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   862: invokevirtual 553	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   865: checkcast 240	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability
    //   868: getfield 540	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   871: invokevirtual 419	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   874: invokevirtual 298	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   877: invokestatic 490	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   880: iconst_1
    //   881: istore_2
    //   882: getstatic 121	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   885: ldc_w 559
    //   888: invokevirtual 526	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   891: istore 11
    //   893: iload_1
    //   894: istore_3
    //   895: iload 11
    //   897: ifeq +363 -> 1260
    //   900: iload_1
    //   901: istore_3
    //   902: iload_1
    //   903: ifne +357 -> 1260
    //   906: aload 17
    //   908: aload 16
    //   910: aload 20
    //   912: iconst_1
    //   913: anewarray 4	java/lang/Object
    //   916: dup
    //   917: iconst_0
    //   918: ldc_w 559
    //   921: aastore
    //   922: invokevirtual 476	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   925: invokevirtual 531	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   928: checkcast 533	[Ljava/lang/Object;
    //   931: checkcast 533	[Ljava/lang/Object;
    //   934: astore 23
    //   936: aload 23
    //   938: arraylength
    //   939: istore_3
    //   940: iconst_0
    //   941: istore_1
    //   942: iload_1
    //   943: iload_3
    //   944: if_icmpge +222 -> 1166
    //   947: aload 23
    //   949: iload_1
    //   950: aaload
    //   951: astore 24
    //   953: aload 18
    //   955: aload 24
    //   957: invokevirtual 531	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   960: checkcast 210	java/lang/Integer
    //   963: invokevirtual 479	java/lang/Integer:intValue	()I
    //   966: istore 6
    //   968: aload 19
    //   970: aload 24
    //   972: invokevirtual 531	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   975: checkcast 210	java/lang/Integer
    //   978: invokevirtual 479	java/lang/Integer:intValue	()I
    //   981: istore 7
    //   983: iload 7
    //   985: iload 6
    //   987: invokestatic 562	com/tencent/thumbplayer/core/common/TPCodecUtils:maxLumaSamplesForHEVCProfileLevel	(II)I
    //   990: istore 10
    //   992: iload 10
    //   994: getstatic 247	com/tencent/thumbplayer/core/common/TPCodecUtils:mHEVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   997: getfield 540	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   1000: if_icmplt +42 -> 1042
    //   1003: getstatic 247	com/tencent/thumbplayer/core/common/TPCodecUtils:mHEVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1006: iload 10
    //   1008: putfield 540	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   1011: getstatic 247	com/tencent/thumbplayer/core/common/TPCodecUtils:mHEVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1014: iload 7
    //   1016: putfield 543	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxProfile	I
    //   1019: getstatic 247	com/tencent/thumbplayer/core/common/TPCodecUtils:mHEVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1022: iload 6
    //   1024: putfield 546	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLevel	I
    //   1027: sipush 172
    //   1030: invokestatic 214	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1033: getstatic 247	com/tencent/thumbplayer/core/common/TPCodecUtils:mHEVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1036: getstatic 257	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1039: invokestatic 550	com/tencent/thumbplayer/core/common/TPCodecUtils:replace	(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/HashMap;)V
    //   1042: iload_1
    //   1043: iconst_1
    //   1044: iadd
    //   1045: istore_1
    //   1046: goto -104 -> 942
    //   1049: astore 23
    //   1051: iconst_1
    //   1052: istore_2
    //   1053: iconst_4
    //   1054: new 283	java/lang/StringBuilder
    //   1057: dup
    //   1058: ldc_w 564
    //   1061: invokespecial 288	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1064: aload 23
    //   1066: invokevirtual 565	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   1069: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1072: invokevirtual 298	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1075: invokestatic 490	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1078: goto -196 -> 882
    //   1081: astore 12
    //   1083: iconst_4
    //   1084: new 283	java/lang/StringBuilder
    //   1087: dup
    //   1088: ldc_w 567
    //   1091: invokespecial 288	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1094: aload 12
    //   1096: invokevirtual 568	java/lang/reflect/InvocationTargetException:getMessage	()Ljava/lang/String;
    //   1099: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1102: invokevirtual 298	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1105: invokestatic 490	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1108: iconst_2
    //   1109: ldc_w 570
    //   1112: invokestatic 490	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1115: getstatic 106	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsLocalCacheEnabled	Z
    //   1118: ifeq +30 -> 1148
    //   1121: getstatic 147	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapListKey	Ljava/lang/String;
    //   1124: getstatic 121	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   1127: invokestatic 572	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   1130: getstatic 159	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMapKey	Ljava/lang/String;
    //   1133: getstatic 257	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1136: invokestatic 574	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapabilityMap	(Ljava/lang/String;Ljava/util/HashMap;)V
    //   1139: iconst_2
    //   1140: ldc 34
    //   1142: ldc_w 576
    //   1145: invokestatic 234	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   1148: iconst_1
    //   1149: putstatic 236	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsMediaCodecCapGot	Z
    //   1152: getstatic 257	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1155: astore 12
    //   1157: ldc_w 400
    //   1160: invokestatic 262	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1163: goto -1119 -> 44
    //   1166: iconst_2
    //   1167: new 283	java/lang/StringBuilder
    //   1170: dup
    //   1171: ldc_w 578
    //   1174: invokespecial 288	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1177: getstatic 257	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1180: sipush 172
    //   1183: invokestatic 214	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1186: invokevirtual 553	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1189: checkcast 240	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability
    //   1192: getfield 543	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxProfile	I
    //   1195: invokevirtual 419	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1198: ldc_w 555
    //   1201: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1204: getstatic 257	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1207: sipush 172
    //   1210: invokestatic 214	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1213: invokevirtual 553	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1216: checkcast 240	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability
    //   1219: getfield 546	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLevel	I
    //   1222: invokevirtual 419	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1225: ldc_w 557
    //   1228: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1231: getstatic 257	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1234: sipush 172
    //   1237: invokestatic 214	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1240: invokevirtual 553	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1243: checkcast 240	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability
    //   1246: getfield 540	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   1249: invokevirtual 419	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1252: invokevirtual 298	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1255: invokestatic 490	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1258: iconst_1
    //   1259: istore_3
    //   1260: getstatic 121	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   1263: ldc_w 580
    //   1266: invokevirtual 526	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   1269: istore 11
    //   1271: iload_0
    //   1272: istore_1
    //   1273: iload 11
    //   1275: ifeq +423 -> 1698
    //   1278: iload_0
    //   1279: istore_1
    //   1280: iload_0
    //   1281: ifne +417 -> 1698
    //   1284: aload 17
    //   1286: aload 16
    //   1288: aload 20
    //   1290: iconst_1
    //   1291: anewarray 4	java/lang/Object
    //   1294: dup
    //   1295: iconst_0
    //   1296: ldc_w 580
    //   1299: aastore
    //   1300: invokevirtual 476	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1303: invokevirtual 531	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1306: checkcast 533	[Ljava/lang/Object;
    //   1309: checkcast 533	[Ljava/lang/Object;
    //   1312: astore 23
    //   1314: aload 23
    //   1316: arraylength
    //   1317: istore_1
    //   1318: iconst_0
    //   1319: istore_0
    //   1320: iload_0
    //   1321: iload_1
    //   1322: if_icmpge +222 -> 1544
    //   1325: aload 23
    //   1327: iload_0
    //   1328: aaload
    //   1329: astore 24
    //   1331: aload 18
    //   1333: aload 24
    //   1335: invokevirtual 531	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1338: checkcast 210	java/lang/Integer
    //   1341: invokevirtual 479	java/lang/Integer:intValue	()I
    //   1344: istore 6
    //   1346: aload 19
    //   1348: aload 24
    //   1350: invokevirtual 531	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1353: checkcast 210	java/lang/Integer
    //   1356: invokevirtual 479	java/lang/Integer:intValue	()I
    //   1359: istore 7
    //   1361: iload 7
    //   1363: iload 6
    //   1365: invokestatic 583	com/tencent/thumbplayer/core/common/TPCodecUtils:maxLumaSamplesForVP9ProfileLevel	(II)I
    //   1368: istore 10
    //   1370: iload 10
    //   1372: getstatic 249	com/tencent/thumbplayer/core/common/TPCodecUtils:mVP9MediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1375: getfield 540	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   1378: if_icmplt +42 -> 1420
    //   1381: getstatic 249	com/tencent/thumbplayer/core/common/TPCodecUtils:mVP9MediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1384: iload 10
    //   1386: putfield 540	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   1389: getstatic 249	com/tencent/thumbplayer/core/common/TPCodecUtils:mVP9MediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1392: iload 7
    //   1394: putfield 543	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxProfile	I
    //   1397: getstatic 249	com/tencent/thumbplayer/core/common/TPCodecUtils:mVP9MediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1400: iload 6
    //   1402: putfield 546	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLevel	I
    //   1405: sipush 166
    //   1408: invokestatic 214	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1411: getstatic 249	com/tencent/thumbplayer/core/common/TPCodecUtils:mVP9MediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1414: getstatic 257	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1417: invokestatic 550	com/tencent/thumbplayer/core/common/TPCodecUtils:replace	(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/HashMap;)V
    //   1420: iload_0
    //   1421: iconst_1
    //   1422: iadd
    //   1423: istore_0
    //   1424: goto -104 -> 1320
    //   1427: astore 23
    //   1429: iconst_1
    //   1430: istore_3
    //   1431: iconst_4
    //   1432: new 283	java/lang/StringBuilder
    //   1435: dup
    //   1436: ldc_w 585
    //   1439: invokespecial 288	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1442: aload 23
    //   1444: invokevirtual 565	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   1447: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1450: invokevirtual 298	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1453: invokestatic 490	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1456: goto -196 -> 1260
    //   1459: astore 12
    //   1461: iconst_4
    //   1462: new 283	java/lang/StringBuilder
    //   1465: dup
    //   1466: ldc_w 567
    //   1469: invokespecial 288	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1472: aload 12
    //   1474: invokevirtual 586	java/lang/NoSuchMethodException:getMessage	()Ljava/lang/String;
    //   1477: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1480: invokevirtual 298	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1483: invokestatic 490	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1486: iconst_2
    //   1487: ldc_w 570
    //   1490: invokestatic 490	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1493: getstatic 106	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsLocalCacheEnabled	Z
    //   1496: ifeq +30 -> 1526
    //   1499: getstatic 147	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapListKey	Ljava/lang/String;
    //   1502: getstatic 121	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   1505: invokestatic 572	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   1508: getstatic 159	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMapKey	Ljava/lang/String;
    //   1511: getstatic 257	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1514: invokestatic 574	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapabilityMap	(Ljava/lang/String;Ljava/util/HashMap;)V
    //   1517: iconst_2
    //   1518: ldc 34
    //   1520: ldc_w 576
    //   1523: invokestatic 234	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   1526: iconst_1
    //   1527: putstatic 236	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsMediaCodecCapGot	Z
    //   1530: getstatic 257	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1533: astore 12
    //   1535: ldc_w 400
    //   1538: invokestatic 262	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1541: goto -1497 -> 44
    //   1544: iconst_2
    //   1545: new 283	java/lang/StringBuilder
    //   1548: dup
    //   1549: ldc_w 588
    //   1552: invokespecial 288	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1555: getstatic 257	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1558: sipush 166
    //   1561: invokestatic 214	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1564: invokevirtual 553	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1567: checkcast 240	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability
    //   1570: getfield 543	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxProfile	I
    //   1573: invokevirtual 419	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1576: ldc_w 555
    //   1579: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1582: getstatic 257	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1585: sipush 166
    //   1588: invokestatic 214	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1591: invokevirtual 553	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1594: checkcast 240	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability
    //   1597: getfield 546	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLevel	I
    //   1600: invokevirtual 419	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1603: ldc_w 557
    //   1606: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1609: getstatic 257	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1612: sipush 166
    //   1615: invokestatic 214	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1618: invokevirtual 553	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1621: checkcast 240	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability
    //   1624: getfield 540	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   1627: invokevirtual 419	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1630: invokevirtual 298	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1633: invokestatic 490	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1636: iconst_1
    //   1637: istore_0
    //   1638: iconst_2
    //   1639: new 283	java/lang/StringBuilder
    //   1642: dup
    //   1643: ldc_w 590
    //   1646: invokespecial 288	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1649: getstatic 257	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1652: invokevirtual 414	java/util/HashMap:size	()I
    //   1655: invokevirtual 419	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1658: invokevirtual 298	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1661: invokestatic 490	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1664: iload_3
    //   1665: istore_1
    //   1666: goto +512 -> 2178
    //   1669: astore 23
    //   1671: iconst_1
    //   1672: istore_1
    //   1673: iconst_4
    //   1674: new 283	java/lang/StringBuilder
    //   1677: dup
    //   1678: ldc_w 592
    //   1681: invokespecial 288	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1684: aload 23
    //   1686: invokevirtual 565	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   1689: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1692: invokevirtual 298	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1695: invokestatic 490	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1698: iload_1
    //   1699: istore_0
    //   1700: goto -62 -> 1638
    //   1703: iload 4
    //   1705: iconst_1
    //   1706: iadd
    //   1707: istore 4
    //   1709: iload_2
    //   1710: istore_0
    //   1711: iload 6
    //   1713: istore_1
    //   1714: iload 7
    //   1716: istore_3
    //   1717: goto -1293 -> 424
    //   1720: iconst_2
    //   1721: ldc_w 570
    //   1724: invokestatic 490	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1727: getstatic 106	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsLocalCacheEnabled	Z
    //   1730: ifeq +30 -> 1760
    //   1733: getstatic 147	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapListKey	Ljava/lang/String;
    //   1736: getstatic 121	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   1739: invokestatic 572	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   1742: getstatic 159	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMapKey	Ljava/lang/String;
    //   1745: getstatic 257	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1748: invokestatic 574	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapabilityMap	(Ljava/lang/String;Ljava/util/HashMap;)V
    //   1751: iconst_2
    //   1752: ldc 34
    //   1754: ldc_w 576
    //   1757: invokestatic 234	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   1760: iconst_1
    //   1761: putstatic 236	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsMediaCodecCapGot	Z
    //   1764: getstatic 257	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1767: astore 12
    //   1769: ldc_w 400
    //   1772: invokestatic 262	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1775: goto -1731 -> 44
    //   1778: astore 12
    //   1780: iconst_4
    //   1781: new 283	java/lang/StringBuilder
    //   1784: dup
    //   1785: ldc_w 567
    //   1788: invokespecial 288	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1791: aload 12
    //   1793: invokevirtual 593	java/lang/IllegalAccessException:getMessage	()Ljava/lang/String;
    //   1796: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1799: invokevirtual 298	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1802: invokestatic 490	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1805: iconst_2
    //   1806: ldc_w 570
    //   1809: invokestatic 490	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1812: getstatic 106	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsLocalCacheEnabled	Z
    //   1815: ifeq +30 -> 1845
    //   1818: getstatic 147	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapListKey	Ljava/lang/String;
    //   1821: getstatic 121	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   1824: invokestatic 572	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   1827: getstatic 159	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMapKey	Ljava/lang/String;
    //   1830: getstatic 257	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1833: invokestatic 574	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapabilityMap	(Ljava/lang/String;Ljava/util/HashMap;)V
    //   1836: iconst_2
    //   1837: ldc 34
    //   1839: ldc_w 576
    //   1842: invokestatic 234	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   1845: iconst_1
    //   1846: putstatic 236	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsMediaCodecCapGot	Z
    //   1849: getstatic 257	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1852: astore 12
    //   1854: ldc_w 400
    //   1857: invokestatic 262	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1860: goto -1816 -> 44
    //   1863: astore 12
    //   1865: iconst_4
    //   1866: new 283	java/lang/StringBuilder
    //   1869: dup
    //   1870: ldc_w 567
    //   1873: invokespecial 288	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1876: aload 12
    //   1878: invokevirtual 594	java/lang/NoSuchFieldException:getMessage	()Ljava/lang/String;
    //   1881: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1884: invokevirtual 298	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1887: invokestatic 490	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1890: iconst_2
    //   1891: ldc_w 570
    //   1894: invokestatic 490	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1897: getstatic 106	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsLocalCacheEnabled	Z
    //   1900: ifeq +30 -> 1930
    //   1903: getstatic 147	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapListKey	Ljava/lang/String;
    //   1906: getstatic 121	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   1909: invokestatic 572	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   1912: getstatic 159	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMapKey	Ljava/lang/String;
    //   1915: getstatic 257	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1918: invokestatic 574	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapabilityMap	(Ljava/lang/String;Ljava/util/HashMap;)V
    //   1921: iconst_2
    //   1922: ldc 34
    //   1924: ldc_w 576
    //   1927: invokestatic 234	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   1930: iconst_1
    //   1931: putstatic 236	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsMediaCodecCapGot	Z
    //   1934: getstatic 257	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1937: astore 12
    //   1939: ldc_w 400
    //   1942: invokestatic 262	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1945: goto -1901 -> 44
    //   1948: astore 12
    //   1950: iconst_4
    //   1951: new 283	java/lang/StringBuilder
    //   1954: dup
    //   1955: ldc_w 567
    //   1958: invokespecial 288	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1961: aload 12
    //   1963: invokevirtual 595	java/lang/ClassNotFoundException:getMessage	()Ljava/lang/String;
    //   1966: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1969: invokevirtual 298	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1972: invokestatic 490	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1975: iconst_2
    //   1976: ldc_w 570
    //   1979: invokestatic 490	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1982: getstatic 106	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsLocalCacheEnabled	Z
    //   1985: ifeq +30 -> 2015
    //   1988: getstatic 147	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapListKey	Ljava/lang/String;
    //   1991: getstatic 121	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   1994: invokestatic 572	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   1997: getstatic 159	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMapKey	Ljava/lang/String;
    //   2000: getstatic 257	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   2003: invokestatic 574	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapabilityMap	(Ljava/lang/String;Ljava/util/HashMap;)V
    //   2006: iconst_2
    //   2007: ldc 34
    //   2009: ldc_w 576
    //   2012: invokestatic 234	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   2015: iconst_1
    //   2016: putstatic 236	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsMediaCodecCapGot	Z
    //   2019: getstatic 257	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   2022: astore 12
    //   2024: ldc_w 400
    //   2027: invokestatic 262	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2030: goto -1986 -> 44
    //   2033: astore 12
    //   2035: iconst_4
    //   2036: new 283	java/lang/StringBuilder
    //   2039: dup
    //   2040: ldc_w 567
    //   2043: invokespecial 288	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2046: aload 12
    //   2048: invokevirtual 565	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   2051: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2054: invokevirtual 298	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2057: invokestatic 490	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   2060: iconst_2
    //   2061: ldc_w 570
    //   2064: invokestatic 490	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   2067: getstatic 106	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsLocalCacheEnabled	Z
    //   2070: ifeq +30 -> 2100
    //   2073: getstatic 147	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapListKey	Ljava/lang/String;
    //   2076: getstatic 121	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   2079: invokestatic 572	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   2082: getstatic 159	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMapKey	Ljava/lang/String;
    //   2085: getstatic 257	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   2088: invokestatic 574	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapabilityMap	(Ljava/lang/String;Ljava/util/HashMap;)V
    //   2091: iconst_2
    //   2092: ldc 34
    //   2094: ldc_w 576
    //   2097: invokestatic 234	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   2100: iconst_1
    //   2101: putstatic 236	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsMediaCodecCapGot	Z
    //   2104: getstatic 257	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   2107: astore 12
    //   2109: ldc_w 400
    //   2112: invokestatic 262	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2115: goto -2071 -> 44
    //   2118: astore 12
    //   2120: iconst_2
    //   2121: ldc_w 570
    //   2124: invokestatic 490	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   2127: getstatic 106	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsLocalCacheEnabled	Z
    //   2130: ifeq +30 -> 2160
    //   2133: getstatic 147	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapListKey	Ljava/lang/String;
    //   2136: getstatic 121	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   2139: invokestatic 572	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   2142: getstatic 159	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMapKey	Ljava/lang/String;
    //   2145: getstatic 257	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   2148: invokestatic 574	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapabilityMap	(Ljava/lang/String;Ljava/util/HashMap;)V
    //   2151: iconst_2
    //   2152: ldc 34
    //   2154: ldc_w 576
    //   2157: invokestatic 234	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   2160: iconst_1
    //   2161: putstatic 236	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsMediaCodecCapGot	Z
    //   2164: getstatic 257	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   2167: astore 12
    //   2169: ldc_w 400
    //   2172: invokestatic 262	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2175: goto -2131 -> 44
    //   2178: iload 5
    //   2180: iconst_1
    //   2181: iadd
    //   2182: istore 5
    //   2184: iload_2
    //   2185: istore_3
    //   2186: goto -1661 -> 525
    //   2189: iload_2
    //   2190: iconst_1
    //   2191: iadd
    //   2192: istore_2
    //   2193: goto -1504 -> 689
    // Local variable table:
    //   start	length	slot	name	signature
    //   233	1478	0	i	int
    //   231	1483	1	j	int
    //   452	1741	2	k	int
    //   229	1957	3	m	int
    //   422	1286	4	n	int
    //   523	1660	5	i1	int
    //   454	1258	6	i2	int
    //   457	1258	7	i3	int
    //   404	25	8	i4	int
    //   520	18	9	i5	int
    //   737	648	10	i6	int
    //   638	636	11	bool	boolean
    //   36	145	12	localObject1	Object
    //   191	6	12	localObject2	Object
    //   199	16	12	localException	Exception
    //   240	192	12	localObject3	Object
    //   1081	14	12	localInvocationTargetException	java.lang.reflect.InvocationTargetException
    //   1155	1	12	localHashMap1	HashMap
    //   1459	14	12	localNoSuchMethodException	java.lang.NoSuchMethodException
    //   1533	235	12	localHashMap2	HashMap
    //   1778	14	12	localIllegalAccessException	java.lang.IllegalAccessException
    //   1852	1	12	localHashMap3	HashMap
    //   1863	14	12	localNoSuchFieldException	java.lang.NoSuchFieldException
    //   1937	1	12	localHashMap4	HashMap
    //   1948	14	12	localClassNotFoundException	java.lang.ClassNotFoundException
    //   2022	1	12	localHashMap5	HashMap
    //   2033	14	12	localRuntimeException1	java.lang.RuntimeException
    //   2107	1	12	localHashMap6	HashMap
    //   2118	1	12	localObject4	Object
    //   2167	1	12	localHashMap7	HashMap
    //   296	203	13	localMethod1	Method
    //   310	170	14	localMethod2	Method
    //   324	136	15	localMethod3	Method
    //   282	1005	16	localObject5	Object
    //   358	927	17	localField1	Field
    //   376	956	18	localField2	Field
    //   366	981	19	localObject6	Object
    //   254	1035	20	localObject7	Object
    //   496	100	21	str	String
    //   515	26	22	arrayOfString	String[]
    //   545	403	23	localObject8	Object
    //   1049	16	23	localRuntimeException2	java.lang.RuntimeException
    //   1312	14	23	arrayOfObject	Object[]
    //   1427	16	23	localRuntimeException3	java.lang.RuntimeException
    //   1669	16	23	localRuntimeException4	java.lang.RuntimeException
    //   698	651	24	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   3	44	191	finally
    //   50	86	191	finally
    //   86	94	191	finally
    //   99	104	191	finally
    //   104	127	191	finally
    //   132	182	191	finally
    //   182	188	191	finally
    //   201	228	191	finally
    //   1108	1148	191	finally
    //   1148	1163	191	finally
    //   1486	1526	191	finally
    //   1526	1541	191	finally
    //   1720	1760	191	finally
    //   1760	1775	191	finally
    //   1805	1845	191	finally
    //   1845	1860	191	finally
    //   1890	1930	191	finally
    //   1930	1945	191	finally
    //   1975	2015	191	finally
    //   2015	2030	191	finally
    //   2060	2100	191	finally
    //   2100	2115	191	finally
    //   2120	2160	191	finally
    //   2160	2175	191	finally
    //   50	86	199	java/lang/Exception
    //   86	94	199	java/lang/Exception
    //   99	104	199	java/lang/Exception
    //   104	127	199	java/lang/Exception
    //   132	182	199	java/lang/Exception
    //   653	687	1049	java/lang/RuntimeException
    //   700	788	1049	java/lang/RuntimeException
    //   791	880	1049	java/lang/RuntimeException
    //   234	421	1081	java/lang/reflect/InvocationTargetException
    //   431	451	1081	java/lang/reflect/InvocationTargetException
    //   459	522	1081	java/lang/reflect/InvocationTargetException
    //   547	606	1081	java/lang/reflect/InvocationTargetException
    //   606	615	1081	java/lang/reflect/InvocationTargetException
    //   620	640	1081	java/lang/reflect/InvocationTargetException
    //   653	687	1081	java/lang/reflect/InvocationTargetException
    //   700	788	1081	java/lang/reflect/InvocationTargetException
    //   791	880	1081	java/lang/reflect/InvocationTargetException
    //   882	893	1081	java/lang/reflect/InvocationTargetException
    //   906	940	1081	java/lang/reflect/InvocationTargetException
    //   953	1042	1081	java/lang/reflect/InvocationTargetException
    //   1053	1078	1081	java/lang/reflect/InvocationTargetException
    //   1166	1258	1081	java/lang/reflect/InvocationTargetException
    //   1260	1271	1081	java/lang/reflect/InvocationTargetException
    //   1284	1318	1081	java/lang/reflect/InvocationTargetException
    //   1331	1420	1081	java/lang/reflect/InvocationTargetException
    //   1431	1456	1081	java/lang/reflect/InvocationTargetException
    //   1544	1636	1081	java/lang/reflect/InvocationTargetException
    //   1638	1664	1081	java/lang/reflect/InvocationTargetException
    //   1673	1698	1081	java/lang/reflect/InvocationTargetException
    //   906	940	1427	java/lang/RuntimeException
    //   953	1042	1427	java/lang/RuntimeException
    //   1166	1258	1427	java/lang/RuntimeException
    //   234	421	1459	java/lang/NoSuchMethodException
    //   431	451	1459	java/lang/NoSuchMethodException
    //   459	522	1459	java/lang/NoSuchMethodException
    //   547	606	1459	java/lang/NoSuchMethodException
    //   606	615	1459	java/lang/NoSuchMethodException
    //   620	640	1459	java/lang/NoSuchMethodException
    //   653	687	1459	java/lang/NoSuchMethodException
    //   700	788	1459	java/lang/NoSuchMethodException
    //   791	880	1459	java/lang/NoSuchMethodException
    //   882	893	1459	java/lang/NoSuchMethodException
    //   906	940	1459	java/lang/NoSuchMethodException
    //   953	1042	1459	java/lang/NoSuchMethodException
    //   1053	1078	1459	java/lang/NoSuchMethodException
    //   1166	1258	1459	java/lang/NoSuchMethodException
    //   1260	1271	1459	java/lang/NoSuchMethodException
    //   1284	1318	1459	java/lang/NoSuchMethodException
    //   1331	1420	1459	java/lang/NoSuchMethodException
    //   1431	1456	1459	java/lang/NoSuchMethodException
    //   1544	1636	1459	java/lang/NoSuchMethodException
    //   1638	1664	1459	java/lang/NoSuchMethodException
    //   1673	1698	1459	java/lang/NoSuchMethodException
    //   1284	1318	1669	java/lang/RuntimeException
    //   1331	1420	1669	java/lang/RuntimeException
    //   1544	1636	1669	java/lang/RuntimeException
    //   234	421	1778	java/lang/IllegalAccessException
    //   431	451	1778	java/lang/IllegalAccessException
    //   459	522	1778	java/lang/IllegalAccessException
    //   547	606	1778	java/lang/IllegalAccessException
    //   606	615	1778	java/lang/IllegalAccessException
    //   620	640	1778	java/lang/IllegalAccessException
    //   653	687	1778	java/lang/IllegalAccessException
    //   700	788	1778	java/lang/IllegalAccessException
    //   791	880	1778	java/lang/IllegalAccessException
    //   882	893	1778	java/lang/IllegalAccessException
    //   906	940	1778	java/lang/IllegalAccessException
    //   953	1042	1778	java/lang/IllegalAccessException
    //   1053	1078	1778	java/lang/IllegalAccessException
    //   1166	1258	1778	java/lang/IllegalAccessException
    //   1260	1271	1778	java/lang/IllegalAccessException
    //   1284	1318	1778	java/lang/IllegalAccessException
    //   1331	1420	1778	java/lang/IllegalAccessException
    //   1431	1456	1778	java/lang/IllegalAccessException
    //   1544	1636	1778	java/lang/IllegalAccessException
    //   1638	1664	1778	java/lang/IllegalAccessException
    //   1673	1698	1778	java/lang/IllegalAccessException
    //   234	421	1863	java/lang/NoSuchFieldException
    //   431	451	1863	java/lang/NoSuchFieldException
    //   459	522	1863	java/lang/NoSuchFieldException
    //   547	606	1863	java/lang/NoSuchFieldException
    //   606	615	1863	java/lang/NoSuchFieldException
    //   620	640	1863	java/lang/NoSuchFieldException
    //   653	687	1863	java/lang/NoSuchFieldException
    //   700	788	1863	java/lang/NoSuchFieldException
    //   791	880	1863	java/lang/NoSuchFieldException
    //   882	893	1863	java/lang/NoSuchFieldException
    //   906	940	1863	java/lang/NoSuchFieldException
    //   953	1042	1863	java/lang/NoSuchFieldException
    //   1053	1078	1863	java/lang/NoSuchFieldException
    //   1166	1258	1863	java/lang/NoSuchFieldException
    //   1260	1271	1863	java/lang/NoSuchFieldException
    //   1284	1318	1863	java/lang/NoSuchFieldException
    //   1331	1420	1863	java/lang/NoSuchFieldException
    //   1431	1456	1863	java/lang/NoSuchFieldException
    //   1544	1636	1863	java/lang/NoSuchFieldException
    //   1638	1664	1863	java/lang/NoSuchFieldException
    //   1673	1698	1863	java/lang/NoSuchFieldException
    //   234	421	1948	java/lang/ClassNotFoundException
    //   431	451	1948	java/lang/ClassNotFoundException
    //   459	522	1948	java/lang/ClassNotFoundException
    //   547	606	1948	java/lang/ClassNotFoundException
    //   606	615	1948	java/lang/ClassNotFoundException
    //   620	640	1948	java/lang/ClassNotFoundException
    //   653	687	1948	java/lang/ClassNotFoundException
    //   700	788	1948	java/lang/ClassNotFoundException
    //   791	880	1948	java/lang/ClassNotFoundException
    //   882	893	1948	java/lang/ClassNotFoundException
    //   906	940	1948	java/lang/ClassNotFoundException
    //   953	1042	1948	java/lang/ClassNotFoundException
    //   1053	1078	1948	java/lang/ClassNotFoundException
    //   1166	1258	1948	java/lang/ClassNotFoundException
    //   1260	1271	1948	java/lang/ClassNotFoundException
    //   1284	1318	1948	java/lang/ClassNotFoundException
    //   1331	1420	1948	java/lang/ClassNotFoundException
    //   1431	1456	1948	java/lang/ClassNotFoundException
    //   1544	1636	1948	java/lang/ClassNotFoundException
    //   1638	1664	1948	java/lang/ClassNotFoundException
    //   1673	1698	1948	java/lang/ClassNotFoundException
    //   234	421	2033	java/lang/RuntimeException
    //   431	451	2033	java/lang/RuntimeException
    //   459	522	2033	java/lang/RuntimeException
    //   547	606	2033	java/lang/RuntimeException
    //   606	615	2033	java/lang/RuntimeException
    //   620	640	2033	java/lang/RuntimeException
    //   882	893	2033	java/lang/RuntimeException
    //   1053	1078	2033	java/lang/RuntimeException
    //   1260	1271	2033	java/lang/RuntimeException
    //   1431	1456	2033	java/lang/RuntimeException
    //   1638	1664	2033	java/lang/RuntimeException
    //   1673	1698	2033	java/lang/RuntimeException
    //   234	421	2118	finally
    //   431	451	2118	finally
    //   459	522	2118	finally
    //   547	606	2118	finally
    //   606	615	2118	finally
    //   620	640	2118	finally
    //   653	687	2118	finally
    //   700	788	2118	finally
    //   791	880	2118	finally
    //   882	893	2118	finally
    //   906	940	2118	finally
    //   953	1042	2118	finally
    //   1053	1078	2118	finally
    //   1083	1108	2118	finally
    //   1166	1258	2118	finally
    //   1260	1271	2118	finally
    //   1284	1318	2118	finally
    //   1331	1420	2118	finally
    //   1431	1456	2118	finally
    //   1461	1486	2118	finally
    //   1544	1636	2118	finally
    //   1638	1664	2118	finally
    //   1673	1698	2118	finally
    //   1780	1805	2118	finally
    //   1865	1890	2118	finally
    //   1950	1975	2118	finally
    //   2035	2060	2118	finally
  }
  
  public static int getSWDecodeLevel()
  {
    AppMethodBeat.i(220380);
    String str = TPSystemInfo.getCpuHarewareName();
    int i = TPSystemInfo.getCpuHWProducter(str);
    int j = TPSystemInfo.getCpuHWProductIndex(str);
    TPNativeLog.printLog(2, "TPCodecUtils", "[getSWDecodeLevel], mCpuHWProducter = " + i + ", getMaxCpuFreq() = " + TPSystemInfo.getMaxCpuFreq() + ", numCores = " + TPSystemInfo.getNumCores() + ", mCpuHWProductIdx=" + j);
    if (-1 != mDeviceLevel)
    {
      i = mDeviceLevel;
      AppMethodBeat.o(220380);
      return i;
    }
    mDeviceLevel = 0;
    if (-1 != i) {
      switch (i)
      {
      }
    }
    for (;;)
    {
      i = mDeviceLevel;
      AppMethodBeat.o(220380);
      return i;
      if (j >= mShdHevcQualcommIndex)
      {
        mDeviceLevel = 21;
      }
      else if (j >= mHdHevcQualcommIndex)
      {
        mDeviceLevel = 16;
      }
      else
      {
        mDeviceLevel = getHevcLvByCoresAndFreq();
        continue;
        if (j >= mShdHevcMtkIndex)
        {
          mDeviceLevel = 21;
        }
        else if (j >= mHdHevcMtkIndex)
        {
          mDeviceLevel = 16;
        }
        else
        {
          mDeviceLevel = getHevcLvByCoresAndFreq();
          continue;
          if (j >= mShdHevcHisiIndex)
          {
            mDeviceLevel = 21;
          }
          else if (j >= mHdHevcHisiIndex)
          {
            mDeviceLevel = 16;
          }
          else
          {
            mDeviceLevel = getHevcLvByCoresAndFreq();
            continue;
            if (j >= mShdHevcSumsingIndex) {
              mDeviceLevel = 21;
            } else if (j >= mHdHevcSumsingIndex) {
              mDeviceLevel = 16;
            } else {
              mDeviceLevel = getHevcLvByCoresAndFreq();
            }
          }
        }
      }
    }
  }
  
  public static HashMap<Integer, TPCodecCapability.TPVCodecMaxCapability> getVCodecSWMaxCapabilityMap()
  {
    int j = 407040;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(220387);
        TPNativeLog.printLog(2, "TPCodecUtils", "getVCodecSWMaxCapabilityMap func in");
        if (mIsFFmpegCapGot)
        {
          localHashMap = mMaxVCodecSwCapabilityMap;
          AppMethodBeat.o(220387);
          return localHashMap;
        }
        i = j;
      }
      finally
      {
        try
        {
          HashMap localHashMap;
          switch (getSWDecodeLevel())
          {
          case 11: 
            mAVCSWMaxCapability.maxLumaSamples = i;
            mAVCSWMaxCapability.maxProfile = 64;
            mAVCSWMaxCapability.maxLevel = 65536;
            mMaxVCodecSwCapabilityMap.put(Integer.valueOf(26), mAVCSWMaxCapability);
            mffmpegVCodecCapList.add("video/avc");
            mHEVCSWMaxCapability.maxLumaSamples = i;
            mHEVCSWMaxCapability.maxProfile = 2;
            mHEVCSWMaxCapability.maxLevel = 33554432;
            mMaxVCodecSwCapabilityMap.put(Integer.valueOf(172), mHEVCSWMaxCapability);
            mffmpegVCodecCapList.add("video/hevc");
            mVP9SWMaxCapability.maxLumaSamples = i;
            mVP9SWMaxCapability.maxProfile = 8;
            mVP9SWMaxCapability.maxLevel = 8192;
            mMaxVCodecSwCapabilityMap.put(Integer.valueOf(166), mVP9SWMaxCapability);
            mffmpegVCodecCapList.add("video/x-vnd.on2.vp9");
            TPNativeLog.printLog(2, "getVCodecSWMaxCapabilityMap success, maxLumaSamples:".concat(String.valueOf(i)));
            mIsFFmpegCapGot = true;
            localHashMap = mMaxVCodecSwCapabilityMap;
            AppMethodBeat.o(220387);
          }
        }
        catch (Exception localException)
        {
          TPNativeLog.printLog(4, "TPCodecUtils", "getVCodecSWMaxCapabilityMap exception");
          Object localObject2 = null;
          AppMethodBeat.o(220387);
        }
        localObject1 = finally;
      }
      int i = 129600;
      continue;
      i = 307200;
      continue;
      i = 480000;
      continue;
      i = 921600;
      continue;
      i = 2073600;
      continue;
      i = 8294400;
      continue;
      i = 8847360;
      continue;
      continue;
      i = j;
    }
  }
  
  /* Error */
  public static void init(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 644
    //   6: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: iconst_2
    //   10: ldc 34
    //   12: ldc_w 646
    //   15: iload_1
    //   16: invokestatic 649	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   19: invokevirtual 487	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   22: invokestatic 234	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   25: aload_0
    //   26: invokevirtual 655	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   29: putstatic 104	com/tencent/thumbplayer/core/common/TPCodecUtils:mApplicationContext	Landroid/content/Context;
    //   32: iload_1
    //   33: putstatic 106	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsLocalCacheEnabled	Z
    //   36: iload_1
    //   37: ifeq +37 -> 74
    //   40: getstatic 143	com/tencent/thumbplayer/core/common/TPCodecUtils:mStoredPlayerCoreVersionKey	Ljava/lang/String;
    //   43: invokestatic 657	com/tencent/thumbplayer/core/common/TPCodecUtils:getCachedStringInfo	(Ljava/lang/String;)Ljava/lang/String;
    //   46: astore_0
    //   47: getstatic 114	com/tencent/thumbplayer/core/common/TPCodecUtils:mPlayerCoreVersion	Ljava/lang/String;
    //   50: aload_0
    //   51: invokevirtual 660	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   54: ifne +48 -> 102
    //   57: iconst_1
    //   58: putstatic 108	com/tencent/thumbplayer/core/common/TPCodecUtils:mNeedToReprobeDecoderCapability	Z
    //   61: iconst_1
    //   62: putstatic 110	com/tencent/thumbplayer/core/common/TPCodecUtils:mNeedToReprobeHDRCapability	Z
    //   65: iconst_2
    //   66: ldc 34
    //   68: ldc_w 662
    //   71: invokestatic 234	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   74: invokestatic 664	com/tencent/thumbplayer/core/common/TPCodecUtils:getDecoderMaxCapabilityMapAsync	()V
    //   77: getstatic 106	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsLocalCacheEnabled	Z
    //   80: ifeq +12 -> 92
    //   83: getstatic 143	com/tencent/thumbplayer/core/common/TPCodecUtils:mStoredPlayerCoreVersionKey	Ljava/lang/String;
    //   86: getstatic 114	com/tencent/thumbplayer/core/common/TPCodecUtils:mPlayerCoreVersion	Ljava/lang/String;
    //   89: invokestatic 666	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheStringInfo	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: ldc_w 644
    //   95: invokestatic 262	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   98: ldc 2
    //   100: monitorexit
    //   101: return
    //   102: iconst_0
    //   103: putstatic 108	com/tencent/thumbplayer/core/common/TPCodecUtils:mNeedToReprobeDecoderCapability	Z
    //   106: iconst_0
    //   107: putstatic 110	com/tencent/thumbplayer/core/common/TPCodecUtils:mNeedToReprobeHDRCapability	Z
    //   110: iconst_2
    //   111: ldc 34
    //   113: ldc_w 668
    //   116: invokestatic 234	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   119: goto -45 -> 74
    //   122: astore_0
    //   123: ldc 2
    //   125: monitorexit
    //   126: aload_0
    //   127: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	paramContext	Context
    //   0	128	1	paramBoolean	boolean
    // Exception table:
    //   from	to	target	type
    //   3	36	122	finally
    //   40	74	122	finally
    //   74	92	122	finally
    //   92	98	122	finally
    //   102	119	122	finally
  }
  
  private static void initDolbyInvariableParams()
  {
    AppMethodBeat.i(220394);
    boolean bool1 = isHwDDPlusSupported_V2();
    boolean bool2 = isHwDolbyDSSupported();
    if ((!bool2) && (!bool1))
    {
      sDolbyLevel = 0;
      AppMethodBeat.o(220394);
      return;
    }
    if ((bool1) && (!bool2))
    {
      sDolbyLevel = 1;
      AppMethodBeat.o(220394);
      return;
    }
    if ((!bool1) && (bool2))
    {
      sDolbyLevel = 10;
      AppMethodBeat.o(220394);
      return;
    }
    if ((bool2) && (bool1)) {
      sDolbyLevel = 11;
    }
    AppMethodBeat.o(220394);
  }
  
  public static boolean isBlackListForHardwareDec(String paramString)
  {
    AppMethodBeat.i(220390);
    if (mIsInBlackListForHardwareDec != -1)
    {
      if (mIsInBlackListForHardwareDec == 0)
      {
        AppMethodBeat.o(220390);
        return false;
      }
      AppMethodBeat.o(220390);
      return true;
    }
    mIsInBlackListForHardwareDec = 0;
    try
    {
      String str = Build.MODEL;
      if (!TextUtils.isEmpty(str))
      {
        int i = 0;
        while (i < 11)
        {
          if (new String[] { "SM-J7008", "SM-J5008", "TCL i806", "NX511J", "vivo Y11i T", "长虹智能电视", "MI 1S", "SP9832A", "SP9830A", "VOTO GT17", "EVA-AL10" }[i].equals(str))
          {
            TPNativeLog.printLog(2, "TPCodecUtils", "isBlackListForHardwareDec, deviceName: ".concat(String.valueOf(str)));
            mIsInBlackListForHardwareDec = 1;
            AppMethodBeat.o(220390);
            return true;
          }
          i += 1;
        }
      }
      if ((!TextUtils.isEmpty(paramString)) && ("video/hevc".equals(paramString)) && (Build.VERSION.SDK_INT >= 14) && (!TextUtils.isEmpty(str)) && (("PRO 7 Plus".equals(str)) || ("PRO 7-H".equals(str)) || ("PRO+7+Plus".equals(str))))
      {
        mIsInBlackListForHardwareDec = 1;
        AppMethodBeat.o(220390);
        return true;
      }
    }
    catch (Exception paramString)
    {
      TPNativeLog.printLog(4, "TPCodecUtils", "isBlackListForHardwareDec exception");
      AppMethodBeat.o(220390);
    }
    return false;
  }
  
  public static boolean isBlackListForHdr10(String paramString)
  {
    AppMethodBeat.i(220406);
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        String[] arrayOfString = paramString.split(",");
        String str = Build.MODEL;
        TPNativeLog.printLog(4, "TPCodecUtils", "hdr10 黑名单：".concat(String.valueOf(paramString)));
        int i = 0;
        while (i < arrayOfString.length)
        {
          boolean bool = str.equalsIgnoreCase(arrayOfString[i]);
          if (bool)
          {
            AppMethodBeat.o(220406);
            return true;
          }
          i += 1;
        }
      }
      return false;
    }
    catch (Exception paramString)
    {
      TPNativeLog.printLog(4, "TPCodecUtils", "isBlackListForHdr10：" + paramString.toString());
      AppMethodBeat.o(220406);
    }
  }
  
  public static boolean isBlackListForHdr10Enhance(String paramString)
  {
    AppMethodBeat.i(220409);
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        String[] arrayOfString = paramString.split(",");
        String str = Build.MODEL;
        TPNativeLog.printLog(2, "TPCodecUtils", "hdr10 黑名单：".concat(String.valueOf(paramString)));
        int i = 0;
        while (i < arrayOfString.length)
        {
          boolean bool = str.equalsIgnoreCase(arrayOfString[i]);
          if (bool)
          {
            AppMethodBeat.o(220409);
            return true;
          }
          i += 1;
        }
      }
      return false;
    }
    catch (Exception paramString)
    {
      TPNativeLog.printLog(4, "TPCodecUtils", "isBlackListForHdr10：" + paramString.toString());
      AppMethodBeat.o(220409);
    }
  }
  
  public static boolean isBlackListForVidHdr10Enhance(String paramString1, String paramString2)
  {
    AppMethodBeat.i(220407);
    try
    {
      if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
      {
        String[] arrayOfString = paramString2.split(",");
        TPNativeLog.printLog(2, "TPCodecUtils", "hdr10 vid：".concat(String.valueOf(paramString2)));
        int i = 0;
        while (i < arrayOfString.length)
        {
          boolean bool = paramString1.equalsIgnoreCase(arrayOfString[i]);
          if (bool)
          {
            AppMethodBeat.o(220407);
            return true;
          }
          i += 1;
        }
      }
      return false;
    }
    catch (Exception paramString1)
    {
      TPNativeLog.printLog(4, "TPCodecUtils", "isBlackListForHdr10：" + paramString1.getMessage());
      AppMethodBeat.o(220407);
    }
  }
  
  public static boolean isHDR10PLUSSupport()
  {
    AppMethodBeat.i(220404);
    if (Build.VERSION.SDK_INT < 29)
    {
      AppMethodBeat.o(220404);
      return false;
    }
    try
    {
      int m = MediaCodecList.getCodecCount();
      int i = 0;
      while (i < m)
      {
        MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
        if (!localMediaCodecInfo.isEncoder())
        {
          String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
          int n = arrayOfString.length;
          int j = 0;
          while (j < n)
          {
            if (arrayOfString[j].equalsIgnoreCase("video/hevc"))
            {
              MediaCodecInfo.CodecProfileLevel[] arrayOfCodecProfileLevel = localMediaCodecInfo.getCapabilitiesForType("video/hevc").profileLevels;
              int i1 = arrayOfCodecProfileLevel.length;
              int k = 0;
              while (k < i1)
              {
                if (arrayOfCodecProfileLevel[k].profile == 8192)
                {
                  TPNativeLog.printLog(2, "TPCodecUtils", "isHDR10PLUSSupport support HDR10PLUS");
                  AppMethodBeat.o(220404);
                  return true;
                }
                k += 1;
              }
            }
            j += 1;
          }
        }
        i += 1;
      }
      TPNativeLog.printLog(2, "TPCodecUtils", "isHDR10PLUSSupport not support");
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, "TPCodecUtils", "isHDR10PLUSSupport " + localThrowable.toString());
      AppMethodBeat.o(220404);
      return false;
    }
    AppMethodBeat.o(220404);
    return false;
  }
  
  public static boolean isHDR10Support()
  {
    AppMethodBeat.i(220403);
    if (Build.VERSION.SDK_INT < 24)
    {
      AppMethodBeat.o(220403);
      return false;
    }
    try
    {
      int m = MediaCodecList.getCodecCount();
      int i = 0;
      while (i < m)
      {
        MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
        if (!localMediaCodecInfo.isEncoder())
        {
          String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
          int n = arrayOfString.length;
          int j = 0;
          while (j < n)
          {
            if (arrayOfString[j].equalsIgnoreCase("video/hevc"))
            {
              MediaCodecInfo.CodecProfileLevel[] arrayOfCodecProfileLevel = localMediaCodecInfo.getCapabilitiesForType("video/hevc").profileLevels;
              int i1 = arrayOfCodecProfileLevel.length;
              int k = 0;
              while (k < i1)
              {
                if (arrayOfCodecProfileLevel[k].profile == 4096)
                {
                  TPNativeLog.printLog(2, "TPCodecUtils", "isHDR10Support support HDR10");
                  AppMethodBeat.o(220403);
                  return true;
                }
                k += 1;
              }
            }
            j += 1;
          }
        }
        i += 1;
      }
      TPNativeLog.printLog(2, "TPCodecUtils", "isHDR10Support not support");
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, "TPCodecUtils", "isHDR10Support " + localThrowable.toString());
      AppMethodBeat.o(220403);
      return false;
    }
    AppMethodBeat.o(220403);
    return false;
  }
  
  public static boolean isHDRDolbyVisionSupport(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(220405);
    if (Build.VERSION.SDK_INT < 24)
    {
      AppMethodBeat.o(220405);
      return false;
    }
    try
    {
      int m = MediaCodecList.getCodecCount();
      int i = 0;
      while (i < m)
      {
        MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
        if (!localMediaCodecInfo.isEncoder())
        {
          String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
          int n = arrayOfString.length;
          int j = 0;
          while (j < n)
          {
            if (arrayOfString[j].equalsIgnoreCase("video/dolby-vision"))
            {
              MediaCodecInfo.CodecProfileLevel[] arrayOfCodecProfileLevel = localMediaCodecInfo.getCapabilitiesForType("video/dolby-vision").profileLevels;
              int i1 = arrayOfCodecProfileLevel.length;
              int k = 0;
              while (k < i1)
              {
                MediaCodecInfo.CodecProfileLevel localCodecProfileLevel = arrayOfCodecProfileLevel[k];
                if ((localCodecProfileLevel.profile > 0) && (localCodecProfileLevel.profile >= paramInt1) && (localCodecProfileLevel.level > 0) && (localCodecProfileLevel.level >= paramInt2))
                {
                  TPNativeLog.printLog(2, "TPCodecUtils", "isHDRDolbyVisionSupport support dolbyvision");
                  AppMethodBeat.o(220405);
                  return true;
                }
                k += 1;
              }
            }
            j += 1;
          }
        }
        i += 1;
      }
      TPNativeLog.printLog(2, "TPCodecUtils", "isHDRDolbyVisionSupport not support");
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, "TPCodecUtils", "isHDRDolbyVisionSupport " + localThrowable.toString());
      AppMethodBeat.o(220405);
      return false;
    }
    AppMethodBeat.o(220405);
    return false;
  }
  
  public static boolean isHDRHLGSupport(int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public static boolean isHDRsupport(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(220402);
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool6 = false;
    boolean bool2 = false;
    boolean bool5 = false;
    boolean bool1 = false;
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(220402);
      return false;
    case 0: 
      if (Build.VERSION.SDK_INT < 24)
      {
        AppMethodBeat.o(220402);
        return false;
      }
      break;
    case 1: 
      if (Build.VERSION.SDK_INT < 29)
      {
        AppMethodBeat.o(220402);
        return false;
      }
      break;
    case 2: 
      if (Build.VERSION.SDK_INT < 24)
      {
        AppMethodBeat.o(220402);
        return false;
      }
      break;
    case 3: 
      AppMethodBeat.o(220402);
      return false;
    }
    Object localObject;
    boolean bool7;
    try
    {
      if ((mIsLocalCacheEnabled) && (!mNeedToReprobeHDRCapability))
      {
        String str = "";
        switch (paramInt1)
        {
        case 0: 
        case 1: 
        case 2: 
        case 3: 
          for (;;)
          {
            localObject = getCachedStringInfo(str);
            TPNativeLog.printLog(2, "TPCodecUtils", "get local cached hdrtype key:" + str + " hdr cap:" + (String)localObject);
            if (localObject == null) {
              break label289;
            }
            bool7 = ((String)localObject).equals(mSupportValue);
            if (!bool7) {
              break;
            }
            AppMethodBeat.o(220402);
            return true;
            str = mHDR10CapabilityKey;
            continue;
            str = mHDR10PLUSCapabilityKey;
            continue;
            str = mHDRDOLBYVISIONCapabilityKey;
            continue;
            str = mHDRHLGCapabilityKey;
          }
          AppMethodBeat.o(220402);
          return false;
        }
      }
    }
    catch (Exception localException)
    {
      TPNativeLog.printLog(4, "TPCodecUtils", "get local cached hdr capability failed");
    }
    for (;;)
    {
      label289:
      int k;
      try
      {
        int m = MediaCodecList.getCodecCount();
        i = 0;
        bool6 = bool3;
        bool5 = bool1;
        bool4 = bool2;
        if (i < m)
        {
          bool4 = bool3;
          bool5 = bool1;
          bool6 = bool2;
          localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
          bool7 = bool3;
          bool8 = bool1;
          bool9 = bool2;
          bool4 = bool3;
          bool5 = bool1;
          bool6 = bool2;
          if (!localMediaCodecInfo.isEncoder())
          {
            bool4 = bool3;
            bool5 = bool1;
            bool6 = bool2;
            localObject = localMediaCodecInfo.getSupportedTypes();
            bool4 = bool3;
            bool5 = bool1;
            bool6 = bool2;
            int n = localObject.length;
            j = 0;
            bool7 = bool3;
            bool8 = bool1;
            bool9 = bool2;
            if (j < n)
            {
              arrayOfCodecProfileLevel = localObject[j];
              bool4 = bool3;
              bool5 = bool1;
              bool6 = bool2;
              if (arrayOfCodecProfileLevel.equalsIgnoreCase("video/hevc"))
              {
                bool4 = bool3;
                bool5 = bool1;
                bool6 = bool2;
                arrayOfCodecProfileLevel = localMediaCodecInfo.getCapabilitiesForType("video/hevc").profileLevels;
                bool4 = bool3;
                bool5 = bool1;
                bool6 = bool2;
                i1 = arrayOfCodecProfileLevel.length;
                k = 0;
                if (k < i1) {
                  localCodecProfileLevel = arrayOfCodecProfileLevel[k];
                }
              }
            }
          }
        }
      }
      catch (Throwable localThrowable1)
      {
        int i;
        MediaCodecInfo localMediaCodecInfo;
        int j;
        MediaCodecInfo.CodecProfileLevel[] arrayOfCodecProfileLevel;
        int i1;
        MediaCodecInfo.CodecProfileLevel localCodecProfileLevel;
        bool2 = bool6;
        bool1 = bool5;
        bool3 = bool4;
        TPNativeLog.printLog(4, "TPCodecUtils", "isHDR10Support " + localThrowable1.toString());
        bool4 = bool2;
        bool5 = bool1;
        bool6 = bool3;
        if (mIsLocalCacheEnabled)
        {
          if (bool6)
          {
            cacheStringInfo(mHDR10CapabilityKey, mSupportValue);
            if (!bool4) {
              break label1024;
            }
            cacheStringInfo(mHDR10PLUSCapabilityKey, mSupportValue);
            if (!bool5) {
              break label1036;
            }
            cacheStringInfo(mHDRDOLBYVISIONCapabilityKey, mSupportValue);
            cacheStringInfo(mHDRHLGCapabilityKey, mUnsupportValue);
            TPNativeLog.printLog(2, "TPCodecUtils", "cached hdr cap done isHDR10Support:" + bool6 + " isHDR10PLUSSupport:" + bool4 + " isHDRDOLBYVISIONSupport:" + bool5 + " isHDRHLGSupport:false");
          }
        }
        else
        {
          mNeedToReprobeHDRCapability = false;
          bool1 = bool6;
          switch (paramInt1)
          {
          default: 
            bool1 = false;
          case 0: 
            AppMethodBeat.o(220402);
            return bool1;
          }
        }
      }
      try
      {
        if (localCodecProfileLevel.profile == 4096)
        {
          TPNativeLog.printLog(2, "TPCodecUtils", "support HDR10");
          bool5 = true;
          bool4 = bool2;
        }
        else
        {
          bool4 = bool2;
          bool5 = bool3;
          if (localCodecProfileLevel.profile == 8192)
          {
            TPNativeLog.printLog(2, "TPCodecUtils", "support HDR10PLUS");
            bool4 = true;
            bool5 = bool3;
          }
        }
      }
      catch (Throwable localThrowable2)
      {
        continue;
        bool7 = bool3;
        bool8 = bool1;
        bool9 = bool2;
        continue;
      }
      boolean bool9 = bool2;
      boolean bool8 = bool1;
      bool7 = bool3;
      j += 1;
      bool3 = bool7;
      bool1 = bool8;
      bool2 = bool9;
      continue;
      bool7 = bool3;
      bool8 = bool1;
      bool9 = bool2;
      bool4 = bool3;
      bool5 = bool1;
      bool6 = bool2;
      if (arrayOfCodecProfileLevel.equalsIgnoreCase("video/dolby-vision"))
      {
        bool4 = bool3;
        bool5 = bool1;
        bool6 = bool2;
        arrayOfCodecProfileLevel = localMediaCodecInfo.getCapabilitiesForType("video/dolby-vision").profileLevels;
        bool4 = bool3;
        bool5 = bool1;
        bool6 = bool2;
        i1 = arrayOfCodecProfileLevel.length;
        k = 0;
        if (k < i1)
        {
          localCodecProfileLevel = arrayOfCodecProfileLevel[k];
          bool4 = bool1;
          try
          {
            if (localCodecProfileLevel.profile > 0)
            {
              bool4 = bool1;
              if (localCodecProfileLevel.profile >= paramInt2)
              {
                bool4 = bool1;
                if (localCodecProfileLevel.level > 0)
                {
                  bool4 = bool1;
                  if (localCodecProfileLevel.level >= paramInt3)
                  {
                    TPNativeLog.printLog(2, "TPCodecUtils", "support dolbyvision");
                    bool4 = true;
                  }
                }
              }
            }
            k += 1;
            bool1 = bool4;
          }
          catch (Throwable localThrowable3)
          {
            continue;
          }
          i += 1;
          bool3 = bool7;
          bool1 = bool8;
          bool2 = bool9;
          continue;
          cacheStringInfo(mHDR10CapabilityKey, mUnsupportValue);
          continue;
          label1024:
          cacheStringInfo(mHDR10PLUSCapabilityKey, mUnsupportValue);
          continue;
          label1036:
          cacheStringInfo(mHDRDOLBYVISIONCapabilityKey, mUnsupportValue);
          continue;
          bool1 = bool4;
          continue;
          bool1 = bool5;
          continue;
          bool1 = false;
        }
        else
        {
          break;
          k += 1;
          bool2 = bool4;
          bool3 = bool5;
        }
      }
    }
  }
  
  public static boolean isHwDDPlusSupported()
  {
    AppMethodBeat.i(220393);
    boolean bool1;
    if (sIsDDPInit)
    {
      bool1 = sIsDDPSup;
      AppMethodBeat.o(220393);
      return bool1;
    }
    if (isBlackListForHardwareDec(null))
    {
      sIsDDPInit = true;
      sIsDDPSup = false;
      AppMethodBeat.o(220393);
      return false;
    }
    boolean bool2;
    for (;;)
    {
      try
      {
        localObject1 = Class.forName("android.media.MediaCodecList");
        localObject2 = ((Class)localObject1).getDeclaredMethod("getCodecCount", new Class[0]);
        localObject1 = ((Class)localObject1).getDeclaredMethod("getCodecInfoAt", new Class[] { Integer.TYPE });
        localMethod = Class.forName("android.media.MediaCodecInfo").getDeclaredMethod("getSupportedTypes", new Class[0]);
        int k = ((Integer)((Method)localObject2).invoke(null, new Object[0])).intValue();
        i = 0;
        bool1 = false;
        if (i >= k) {
          break label279;
        }
      }
      catch (Exception localException1)
      {
        Object localObject1;
        Object localObject2;
        Method localMethod;
        int i;
        int m;
        int j;
        Object localObject3;
        bool2 = false;
      }
      try
      {
        localObject2 = (String[])localMethod.invoke(((Method)localObject1).invoke(null, new Object[] { Integer.valueOf(i) }), new Object[0]);
        m = localObject2.length;
        j = 0;
        if (j >= m) {
          break label276;
        }
        localObject3 = localObject2[j];
        if (!"audio/eac3".equals(localObject3))
        {
          bool2 = "audio/ac3".equals(localObject3);
          if (!bool2) {
            continue;
          }
        }
        bool1 = true;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          bool2 = bool1;
        }
        continue;
      }
      bool2 = bool1;
      if (bool1) {
        break;
      }
      i += 1;
      continue;
      j += 1;
    }
    for (;;)
    {
      sIsDDPSup = bool2;
      sIsDDPInit = true;
      bool1 = sIsDDPSup;
      AppMethodBeat.o(220393);
      return bool1;
      label276:
      label279:
      bool2 = bool1;
    }
  }
  
  public static boolean isHwDDPlusSupported_V2()
  {
    boolean bool1 = false;
    AppMethodBeat.i(220391);
    if (isBlackListForHardwareDec(null))
    {
      sIsDDPSup = false;
      AppMethodBeat.o(220391);
      return false;
    }
    try
    {
      boolean bool2 = isHwSupportDDPlus();
      bool1 = bool2;
    }
    catch (Exception localException)
    {
      label33:
      break label33;
    }
    sIsDDPSup = bool1;
    AppMethodBeat.o(220391);
    return bool1;
  }
  
  public static boolean isHwDolbyDSSupported()
  {
    AppMethodBeat.i(220392);
    boolean bool;
    if (sIsDDSInit)
    {
      if (sIsDDSSup) {
        TPNativeLog.printLog(2, "TPCodecUtils", "dds ha suported " + sIsDDSSup);
      }
      bool = sIsDDSSup;
      AppMethodBeat.o(220392);
      return bool;
    }
    try
    {
      Object localObject1 = Class.forName("android.os.SystemProperties");
      localObject1 = (String)((Class)localObject1).getMethod("get", new Class[] { String.class }).invoke(localObject1, new Object[] { "dolby.ds.state" });
      if ((localObject1 == null) || ((localObject1 != null) && (((String)localObject1).trim().equals(""))))
      {
        bool = false;
        sIsDDSSup = bool;
        sIsDDSInit = true;
        if (sIsDDSSup) {
          TPNativeLog.printLog(2, "TPCodecUtils", "dds ha suported " + sIsDDSSup);
        }
        bool = sIsDDSSup;
        AppMethodBeat.o(220392);
        return bool;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        TPNativeLog.printLog(4, "TPCodecUtils", localException.getMessage());
        Object localObject2 = null;
        continue;
        bool = true;
      }
    }
  }
  
  public static boolean isHwSupportDDPlus()
  {
    AppMethodBeat.i(220388);
    if ((mHWCodecCapList != null) && (mHWCodecCapList.size() > 0) && ((mHWCodecCapList.contains("audio/eac3")) || (mHWCodecCapList.contains("audio/ac3"))))
    {
      AppMethodBeat.o(220388);
      return true;
    }
    if ((mSoftCodecCapList != null) && (mSoftCodecCapList.size() > 0) && ((mSoftCodecCapList.contains("audio/eac3")) || (mSoftCodecCapList.contains("audio/ac3"))))
    {
      AppMethodBeat.o(220388);
      return true;
    }
    AppMethodBeat.o(220388);
    return false;
  }
  
  public static boolean isInMediaCodecWhiteList(String paramString, int paramInt1, int paramInt2)
  {
    boolean bool = true;
    AppMethodBeat.i(220389);
    Object localObject = Build.MODEL;
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (mCodecCap != null) && (mCodecCap.containsKey(localObject)))
    {
      localObject = (Integer)mCodecCap.get(localObject);
      if (TextUtils.equals(paramString, "video/avc")) {
        if ((((Integer)localObject).intValue() & 0x1) != 0) {
          bool = true;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(220389);
      return bool;
      bool = false;
      continue;
      if (TextUtils.equals(paramString, "video/hevc"))
      {
        if ((((Integer)localObject).intValue() & 0x2) == 0) {
          bool = false;
        }
      }
      else if (TextUtils.equals(paramString, "audio/mp4a-latm"))
      {
        if ((((Integer)localObject).intValue() & 0x4) == 0) {
          bool = false;
        }
      }
      else if ((TextUtils.equals(paramString, "audio/eac3")) || (TextUtils.equals(paramString, "audio/ac3")))
      {
        if ((((Integer)localObject).intValue() & 0x8) == 0)
        {
          bool = false;
          continue;
          AppMethodBeat.o(220389);
          return false;
        }
      }
      else {
        bool = false;
      }
    }
  }
  
  public static boolean isWhiteListForHdr10(String paramString)
  {
    AppMethodBeat.i(220408);
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        String[] arrayOfString = paramString.split(",");
        String str = Build.MODEL;
        TPNativeLog.printLog(2, "TPCodecUtils", "hdr10 白名单：".concat(String.valueOf(paramString)));
        int i = 0;
        while (i < arrayOfString.length)
        {
          boolean bool = str.equalsIgnoreCase(arrayOfString[i]);
          if (bool)
          {
            AppMethodBeat.o(220408);
            return true;
          }
          i += 1;
        }
      }
      return false;
    }
    catch (Exception paramString)
    {
      TPNativeLog.printLog(4, "TPCodecUtils", "isWhiteListForHdr10：" + paramString.toString());
      AppMethodBeat.o(220408);
    }
  }
  
  public static boolean isWhiteListForHdr10Enhance(String paramString)
  {
    AppMethodBeat.i(220410);
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        String[] arrayOfString = paramString.split(",");
        String str = Build.MODEL;
        TPNativeLog.printLog(2, "TPCodecUtils", "hdr10 白名单：".concat(String.valueOf(paramString)));
        int i = 0;
        while (i < arrayOfString.length)
        {
          boolean bool = str.equalsIgnoreCase(arrayOfString[i]);
          if (bool)
          {
            AppMethodBeat.o(220410);
            return true;
          }
          i += 1;
        }
      }
      return false;
    }
    catch (Exception paramString)
    {
      TPNativeLog.printLog(4, "TPCodecUtils", "isWhiteListForHdr10：" + paramString.toString());
      AppMethodBeat.o(220410);
    }
  }
  
  private static int maxLumaSamplesForAVCProfileLevel(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(220383);
    for (;;)
    {
      try
      {
        Class localClass = Class.forName("android.media.MediaCodecInfo$CodecProfileLevel");
        i = ((Integer)localClass.getField("AVCLevel1").get(null)).intValue();
        j = ((Integer)localClass.getField("AVCLevel1b").get(null)).intValue();
        k = ((Integer)localClass.getField("AVCLevel11").get(null)).intValue();
        m = ((Integer)localClass.getField("AVCLevel12").get(null)).intValue();
        n = ((Integer)localClass.getField("AVCLevel13").get(null)).intValue();
        i1 = ((Integer)localClass.getField("AVCLevel2").get(null)).intValue();
        i2 = ((Integer)localClass.getField("AVCLevel21").get(null)).intValue();
        i3 = ((Integer)localClass.getField("AVCLevel22").get(null)).intValue();
        i4 = ((Integer)localClass.getField("AVCLevel3").get(null)).intValue();
        i5 = ((Integer)localClass.getField("AVCLevel31").get(null)).intValue();
        i6 = ((Integer)localClass.getField("AVCLevel32").get(null)).intValue();
        i7 = ((Integer)localClass.getField("AVCLevel4").get(null)).intValue();
        i8 = ((Integer)localClass.getField("AVCLevel41").get(null)).intValue();
        i9 = ((Integer)localClass.getField("AVCLevel42").get(null)).intValue();
        i10 = ((Integer)localClass.getField("AVCLevel5").get(null)).intValue();
        i11 = ((Integer)localClass.getField("AVCLevel51").get(null)).intValue();
        if (paramInt2 != i) {
          continue;
        }
        i = 25344;
      }
      catch (Exception localException)
      {
        int j;
        int k;
        int m;
        int n;
        int i1;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        TPNativeLog.printLog(4, "failed to get avc maxLumaSamples");
        TPNativeLog.printLog(4, localException.getMessage());
        int i = 414720;
        continue;
      }
      TPNativeLog.printLog(2, "AVC: maxprofile :" + paramInt1 + " , maxlevel :" + paramInt2 + " , maxSample : " + i);
      AppMethodBeat.o(220383);
      return i;
      if (paramInt2 == j)
      {
        i = 25344;
      }
      else if (paramInt2 == k)
      {
        i = 101376;
      }
      else if (paramInt2 == m)
      {
        i = 101376;
      }
      else if (paramInt2 == n)
      {
        i = 101376;
      }
      else if (paramInt2 == i1)
      {
        i = 101376;
      }
      else if (paramInt2 == i2)
      {
        i = 202752;
      }
      else if (paramInt2 == i3)
      {
        i = 414720;
      }
      else if (paramInt2 == i4)
      {
        i = 414720;
      }
      else if (paramInt2 == i5)
      {
        i = 921600;
      }
      else if (paramInt2 == i6)
      {
        i = 1310720;
      }
      else if (paramInt2 == i7)
      {
        i = 2097152;
      }
      else if (paramInt2 == i8)
      {
        i = 2097152;
      }
      else if (paramInt2 == i9)
      {
        i = 2228224;
      }
      else if (paramInt2 == i10)
      {
        i = 5652480;
      }
      else
      {
        if (paramInt2 < i11) {
          continue;
        }
        i = 9437184;
      }
    }
  }
  
  private static int maxLumaSamplesForHEVCProfileLevel(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(220384);
    for (;;)
    {
      try
      {
        Class localClass = Class.forName("android.media.MediaCodecInfo$CodecProfileLevel");
        i = ((Integer)localClass.getField("HEVCHighTierLevel1").get(null)).intValue();
        j = ((Integer)localClass.getField("HEVCHighTierLevel2").get(null)).intValue();
        k = ((Integer)localClass.getField("HEVCHighTierLevel21").get(null)).intValue();
        m = ((Integer)localClass.getField("HEVCHighTierLevel3").get(null)).intValue();
        n = ((Integer)localClass.getField("HEVCHighTierLevel31").get(null)).intValue();
        i1 = ((Integer)localClass.getField("HEVCHighTierLevel4").get(null)).intValue();
        i2 = ((Integer)localClass.getField("HEVCHighTierLevel41").get(null)).intValue();
        i3 = ((Integer)localClass.getField("HEVCHighTierLevel5").get(null)).intValue();
        i4 = ((Integer)localClass.getField("HEVCHighTierLevel51").get(null)).intValue();
        i5 = ((Integer)localClass.getField("HEVCHighTierLevel52").get(null)).intValue();
        i6 = ((Integer)localClass.getField("HEVCHighTierLevel6").get(null)).intValue();
        i7 = ((Integer)localClass.getField("HEVCHighTierLevel61").get(null)).intValue();
        i8 = ((Integer)localClass.getField("HEVCHighTierLevel62").get(null)).intValue();
        int i9 = ((Integer)localClass.getField("HEVCMainTierLevel1").get(null)).intValue();
        i10 = ((Integer)localClass.getField("HEVCMainTierLevel2").get(null)).intValue();
        i11 = ((Integer)localClass.getField("HEVCMainTierLevel21").get(null)).intValue();
        i12 = ((Integer)localClass.getField("HEVCMainTierLevel3").get(null)).intValue();
        i13 = ((Integer)localClass.getField("HEVCMainTierLevel31").get(null)).intValue();
        i14 = ((Integer)localClass.getField("HEVCMainTierLevel4").get(null)).intValue();
        i15 = ((Integer)localClass.getField("HEVCMainTierLevel41").get(null)).intValue();
        i16 = ((Integer)localClass.getField("HEVCMainTierLevel5").get(null)).intValue();
        i17 = ((Integer)localClass.getField("HEVCMainTierLevel51").get(null)).intValue();
        i18 = ((Integer)localClass.getField("HEVCMainTierLevel52").get(null)).intValue();
        i19 = ((Integer)localClass.getField("HEVCMainTierLevel6").get(null)).intValue();
        i20 = ((Integer)localClass.getField("HEVCMainTierLevel61").get(null)).intValue();
        i21 = ((Integer)localClass.getField("HEVCMainTierLevel62").get(null)).intValue();
        if ((paramInt2 != i) && (paramInt2 != i9)) {
          continue;
        }
        i = 36864;
      }
      catch (Exception localException)
      {
        int j;
        int k;
        int m;
        int n;
        int i1;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        TPNativeLog.printLog(4, "failed to get hevc maxLumaSamples");
        TPNativeLog.printLog(4, localException.getMessage());
        int i = 552960;
        continue;
      }
      TPNativeLog.printLog(2, "HEVC: maxprofile :" + paramInt1 + " , maxlevel :" + paramInt2 + " , maxSample : " + i);
      AppMethodBeat.o(220384);
      return i;
      if ((paramInt2 == j) || (paramInt2 == i10))
      {
        i = 122880;
      }
      else if ((paramInt2 == k) || (paramInt2 == i11))
      {
        i = 245760;
      }
      else if ((paramInt2 == m) || (paramInt2 == i12))
      {
        i = 552960;
      }
      else if ((paramInt2 == n) || (paramInt2 == i13))
      {
        i = 983040;
      }
      else if ((paramInt2 == i1) || (paramInt2 == i14))
      {
        i = 2228224;
      }
      else if ((paramInt2 == i2) || (paramInt2 == i15))
      {
        i = 2228224;
      }
      else if ((paramInt2 == i3) || (paramInt2 == i16))
      {
        i = 8912896;
      }
      else if ((paramInt2 == i4) || (paramInt2 == i17))
      {
        i = 8912896;
      }
      else if ((paramInt2 == i5) || (paramInt2 == i18))
      {
        i = 8912896;
      }
      else if ((paramInt2 == i6) || (paramInt2 == i19))
      {
        i = 35651584;
      }
      else if ((paramInt2 >= i7) || (paramInt2 == i20))
      {
        i = 35651584;
      }
      else
      {
        if ((paramInt2 < i8) && (paramInt2 != i21)) {
          continue;
        }
        i = 35651584;
      }
    }
  }
  
  private static int maxLumaSamplesForVP9ProfileLevel(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(220385);
    for (;;)
    {
      try
      {
        Class localClass = Class.forName("android.media.MediaCodecInfo$CodecProfileLevel");
        i = ((Integer)localClass.getField("VP9Level1").get(null)).intValue();
        j = ((Integer)localClass.getField("VP9Level11").get(null)).intValue();
        k = ((Integer)localClass.getField("VP9Level2").get(null)).intValue();
        m = ((Integer)localClass.getField("VP9Level21").get(null)).intValue();
        n = ((Integer)localClass.getField("VP9Level3").get(null)).intValue();
        i1 = ((Integer)localClass.getField("VP9Level31").get(null)).intValue();
        i2 = ((Integer)localClass.getField("VP9Level4").get(null)).intValue();
        i3 = ((Integer)localClass.getField("VP9Level41").get(null)).intValue();
        i4 = ((Integer)localClass.getField("VP9Level5").get(null)).intValue();
        i5 = ((Integer)localClass.getField("VP9Level51").get(null)).intValue();
        i6 = ((Integer)localClass.getField("VP9Level52").get(null)).intValue();
        i7 = ((Integer)localClass.getField("VP9Level6").get(null)).intValue();
        i8 = ((Integer)localClass.getField("VP9Level61").get(null)).intValue();
        i9 = ((Integer)localClass.getField("VP9Level62").get(null)).intValue();
        if (paramInt2 != i) {
          continue;
        }
        i = 36864;
      }
      catch (Exception localException)
      {
        int j;
        int k;
        int m;
        int n;
        int i1;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        TPNativeLog.printLog(4, "failed to get vp9 maxLumaSamples");
        TPNativeLog.printLog(4, localException.getMessage());
        int i = 552960;
        continue;
      }
      TPNativeLog.printLog(2, "VP9: maxprofile :" + paramInt1 + " , maxlevel :" + paramInt2 + " , maxSample : " + i);
      AppMethodBeat.o(220385);
      return i;
      if (paramInt2 == j)
      {
        i = 73728;
      }
      else if (paramInt2 == k)
      {
        i = 122880;
      }
      else if (paramInt2 == m)
      {
        i = 245760;
      }
      else if (paramInt2 == n)
      {
        i = 552960;
      }
      else if (paramInt2 == i1)
      {
        i = 983040;
      }
      else if (paramInt2 == i2)
      {
        i = 2228224;
      }
      else if (paramInt2 == i3)
      {
        i = 2228224;
      }
      else if (paramInt2 == i4)
      {
        i = 8912896;
      }
      else if (paramInt2 == i5)
      {
        i = 8912896;
      }
      else if (paramInt2 == i6)
      {
        i = 8912896;
      }
      else if (paramInt2 == i7)
      {
        i = 35651584;
      }
      else if (paramInt2 == i8)
      {
        i = 35651584;
      }
      else
      {
        if (paramInt2 != i9) {
          continue;
        }
        i = 35651584;
      }
    }
  }
  
  private static <K, T> void replace(K paramK, T paramT, HashMap<K, T> paramHashMap)
  {
    AppMethodBeat.i(220382);
    if (paramHashMap.containsKey(paramK))
    {
      paramHashMap.remove(paramK);
      paramHashMap.put(paramK, paramT);
      AppMethodBeat.o(220382);
      return;
    }
    paramHashMap.put(paramK, paramT);
    AppMethodBeat.o(220382);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPCodecUtils
 * JD-Core Version:    0.7.0.1
 */