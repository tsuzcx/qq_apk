package com.tencent.thumbplayer.core.common;

import android.content.Context;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecInfo.VideoCapabilities;
import android.media.MediaCodecList;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Range;
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
  private static TPCodecCapability.TPVCodecMaxCapability mAVS3WMaxCapability;
  private static Context mApplicationContext;
  private static int mAvs3DeviceLevel;
  private static String mCapabilityVersion;
  private static String mCapabilityVersionKey;
  private static HashMap<String, Integer> mCodecCap;
  private static int mFhdAvs3HisiIndex;
  private static int mFhdAvs3QualcommIndex;
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
  private static int mHevcDeviceLevel;
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
  private static int mShdAvs3QualcommIndex;
  private static int mShdHevcHisiIndex;
  private static int mShdHevcMtkIndex;
  private static int mShdHevcQualcommIndex;
  private static int mShdHevcSumsingIndex;
  protected static ArrayList<String> mSoftCodecCapList;
  private static String mSoftCodecCapListKey;
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
    AppMethodBeat.i(222768);
    mHevcDeviceLevel = -1;
    mAvs3DeviceLevel = -1;
    mCodecCap = null;
    mApplicationContext = null;
    mIsLocalCacheEnabled = false;
    mNeedToReprobeDecoderCapability = true;
    mNeedToReprobeHDRCapability = true;
    mCapabilityVersion = "2.10.0.1072.wechat";
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
    mCapabilityVersionKey = "Capability_version_Key";
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
    mFhdAvs3QualcommIndex = 58;
    mShdAvs3QualcommIndex = 55;
    mFhdAvs3HisiIndex = 14;
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
    mAVCMediaCodecMaxCapability = new TPCodecCapability.TPVCodecMaxCapability(0, 0, 0, 30);
    mHEVCMediaCodecMaxCapability = new TPCodecCapability.TPVCodecMaxCapability(0, 0, 0, 30);
    mVP9MediaCodecMaxCapability = new TPCodecCapability.TPVCodecMaxCapability(0, 0, 0, 30);
    mAVCSWMaxCapability = new TPCodecCapability.TPVCodecMaxCapability(0, 0, 0, 30);
    mHEVCSWMaxCapability = new TPCodecCapability.TPVCodecMaxCapability(0, 0, 0, 30);
    mVP9SWMaxCapability = new TPCodecCapability.TPVCodecMaxCapability(0, 0, 0, 30);
    mAVS3WMaxCapability = new TPCodecCapability.TPVCodecMaxCapability(0, 0, 0, 30);
    mMaxVCodecHwCapabilityMap = new HashMap();
    mMaxVCodecSwCapabilityMap = new HashMap();
    AppMethodBeat.o(222768);
  }
  
  private static void cacheCapList(String paramString, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(222709);
    if (mApplicationContext != null) {
      try
      {
        LocalCache localLocalCache = LocalCache.get(mApplicationContext);
        if (localLocalCache != null) {
          localLocalCache.put(paramString, paramArrayList);
        }
        AppMethodBeat.o(222709);
        return;
      }
      catch (Throwable paramArrayList)
      {
        TPNativeLog.printLog(4, "TPCodecUtils", "cache " + paramString + "failed");
      }
    }
    AppMethodBeat.o(222709);
  }
  
  private static void cacheCapabilityMap(String paramString, HashMap<Integer, TPCodecCapability.TPVCodecMaxCapability> paramHashMap)
  {
    AppMethodBeat.i(222712);
    if (mApplicationContext != null) {
      try
      {
        LocalCache localLocalCache = LocalCache.get(mApplicationContext);
        if (localLocalCache != null) {
          localLocalCache.put(paramString, paramHashMap);
        }
        AppMethodBeat.o(222712);
        return;
      }
      catch (Throwable paramHashMap)
      {
        TPNativeLog.printLog(4, "TPCodecUtils", "cache " + paramString + "failed");
      }
    }
    AppMethodBeat.o(222712);
  }
  
  private static void cacheStringInfo(String paramString1, String paramString2)
  {
    AppMethodBeat.i(222707);
    if (mApplicationContext != null) {
      try
      {
        LocalCache localLocalCache = LocalCache.get(mApplicationContext);
        if (localLocalCache != null) {
          localLocalCache.put(paramString1, paramString2);
        }
        AppMethodBeat.o(222707);
        return;
      }
      catch (Throwable paramString2)
      {
        TPNativeLog.printLog(4, "TPCodecUtils", "cache " + paramString1 + "failed");
      }
    }
    AppMethodBeat.o(222707);
  }
  
  public static boolean getAudioMediaCodecPassThroughCap(int paramInt1, int paramInt2, int paramInt3)
  {
    int j = 1;
    AppMethodBeat.i(222764);
    if (paramInt1 != 5004)
    {
      AppMethodBeat.o(222764);
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
      AppMethodBeat.o(222764);
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
  
  public static int getAvs3SWDecodeLevel()
  {
    AppMethodBeat.i(222517);
    String str = TPSystemInfo.getCpuHarewareName();
    int i = TPSystemInfo.getCpuHWProducter(str);
    int j = TPSystemInfo.getCpuHWProductIndex(str);
    TPNativeLog.printLog(2, "TPCodecUtils", "[getAvs3SWDecodeLevel], mCpuHWProducter = " + i + ", getMaxCpuFreq() = " + TPSystemInfo.getMaxCpuFreq() + ", numCores = " + TPSystemInfo.getNumCores() + ", mCpuHWProductIdx=" + j + ", hardware=" + str);
    if (-1 != mAvs3DeviceLevel)
    {
      i = mAvs3DeviceLevel;
      AppMethodBeat.o(222517);
      return i;
    }
    mAvs3DeviceLevel = 0;
    if (-1 != i) {
      switch (i)
      {
      }
    }
    for (;;)
    {
      i = mAvs3DeviceLevel;
      AppMethodBeat.o(222517);
      return i;
      if (j >= mFhdAvs3QualcommIndex)
      {
        mAvs3DeviceLevel = 26;
      }
      else if (j >= mShdAvs3QualcommIndex)
      {
        mAvs3DeviceLevel = 21;
      }
      else
      {
        mAvs3DeviceLevel = getDecodeLevelByCoresAndFreq();
        continue;
        mAvs3DeviceLevel = getDecodeLevelByCoresAndFreq();
        continue;
        if (j >= mFhdAvs3HisiIndex)
        {
          mAvs3DeviceLevel = 26;
        }
        else
        {
          mAvs3DeviceLevel = getDecodeLevelByCoresAndFreq();
          continue;
          mAvs3DeviceLevel = getDecodeLevelByCoresAndFreq();
        }
      }
    }
  }
  
  private static ArrayList<String> getCachedCapList(String paramString)
  {
    AppMethodBeat.i(222714);
    if (mApplicationContext != null) {
      try
      {
        Object localObject = LocalCache.get(mApplicationContext);
        if (localObject != null)
        {
          localObject = (ArrayList)((LocalCache)localObject).getAsObject(paramString);
          AppMethodBeat.o(222714);
          return localObject;
        }
      }
      catch (Throwable localThrowable)
      {
        TPNativeLog.printLog(4, "TPCodecUtils", "get " + paramString + "failed");
      }
    }
    AppMethodBeat.o(222714);
    return null;
  }
  
  private static HashMap<Integer, TPCodecCapability.TPVCodecMaxCapability> getCachedCapabilityMap(String paramString)
  {
    AppMethodBeat.i(222718);
    if (mApplicationContext != null) {
      try
      {
        Object localObject = LocalCache.get(mApplicationContext);
        if (localObject != null)
        {
          localObject = (HashMap)((LocalCache)localObject).getAsObject(paramString);
          AppMethodBeat.o(222718);
          return localObject;
        }
      }
      catch (Throwable localThrowable)
      {
        TPNativeLog.printLog(4, "TPCodecUtils", "get " + paramString + "failed");
      }
    }
    AppMethodBeat.o(222718);
    return null;
  }
  
  private static String getCachedStringInfo(String paramString)
  {
    AppMethodBeat.i(222713);
    if (mApplicationContext != null) {
      try
      {
        Object localObject = LocalCache.get(mApplicationContext);
        if (localObject != null)
        {
          localObject = ((LocalCache)localObject).getAsString(paramString);
          AppMethodBeat.o(222713);
          return localObject;
        }
      }
      catch (Throwable localThrowable)
      {
        TPNativeLog.printLog(4, "TPCodecUtils", "get " + paramString + "failed");
      }
    }
    AppMethodBeat.o(222713);
    return null;
  }
  
  private static int getDecodeLevelByCoresAndFreq()
  {
    int i = 21;
    AppMethodBeat.i(222527);
    if (TPSystemInfo.getNumCores() >= 8) {
      if (TPSystemInfo.getMaxCpuFreq() / 1000L < 1200L) {}
    }
    for (;;)
    {
      AppMethodBeat.o(222527);
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
  
  /* Error */
  public static void getDecoderMaxCapabilityMapAsync()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 405
    //   6: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 134	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsInitDone	Z
    //   12: ifeq +22 -> 34
    //   15: iconst_2
    //   16: ldc 34
    //   18: ldc_w 407
    //   21: invokestatic 247	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   24: ldc_w 405
    //   27: invokestatic 277	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: ldc 2
    //   32: monitorexit
    //   33: return
    //   34: iconst_2
    //   35: ldc 34
    //   37: ldc_w 409
    //   40: invokestatic 247	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   43: new 411	java/lang/Thread
    //   46: dup
    //   47: new 6	com/tencent/thumbplayer/core/common/TPCodecUtils$1
    //   50: dup
    //   51: invokespecial 412	com/tencent/thumbplayer/core/common/TPCodecUtils$1:<init>	()V
    //   54: invokespecial 415	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   57: astore_0
    //   58: aload_0
    //   59: ldc_w 417
    //   62: invokevirtual 420	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   65: aload_0
    //   66: invokevirtual 423	java/lang/Thread:start	()V
    //   69: ldc_w 405
    //   72: invokestatic 277	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static int getHevcSWDecodeLevel()
  {
    AppMethodBeat.i(222509);
    String str = TPSystemInfo.getCpuHarewareName();
    int i = TPSystemInfo.getCpuHWProducter(str);
    int j = TPSystemInfo.getCpuHWProductIndex(str);
    TPNativeLog.printLog(2, "TPCodecUtils", "[getHevcSWDecodeLevel], mCpuHWProducter = " + i + ", getMaxCpuFreq() = " + TPSystemInfo.getMaxCpuFreq() + ", numCores = " + TPSystemInfo.getNumCores() + ", mCpuHWProductIdx=" + j + ", hardware=" + str);
    if (-1 != mHevcDeviceLevel)
    {
      i = mHevcDeviceLevel;
      AppMethodBeat.o(222509);
      return i;
    }
    mHevcDeviceLevel = 0;
    if (-1 != i) {
      switch (i)
      {
      }
    }
    for (;;)
    {
      i = mHevcDeviceLevel;
      AppMethodBeat.o(222509);
      return i;
      if (j >= mShdHevcQualcommIndex)
      {
        mHevcDeviceLevel = 21;
      }
      else if (j >= mHdHevcQualcommIndex)
      {
        mHevcDeviceLevel = 16;
      }
      else
      {
        mHevcDeviceLevel = getDecodeLevelByCoresAndFreq();
        continue;
        if (j >= mShdHevcMtkIndex)
        {
          mHevcDeviceLevel = 21;
        }
        else if (j >= mHdHevcMtkIndex)
        {
          mHevcDeviceLevel = 16;
        }
        else
        {
          mHevcDeviceLevel = getDecodeLevelByCoresAndFreq();
          continue;
          if (j >= mShdHevcHisiIndex)
          {
            mHevcDeviceLevel = 21;
          }
          else if (j >= mHdHevcHisiIndex)
          {
            mHevcDeviceLevel = 16;
          }
          else
          {
            mHevcDeviceLevel = getDecodeLevelByCoresAndFreq();
            continue;
            if (j >= mShdHevcSumsingIndex) {
              mHevcDeviceLevel = 21;
            } else if (j >= mHdHevcSumsingIndex) {
              mHevcDeviceLevel = 16;
            } else {
              mHevcDeviceLevel = getDecodeLevelByCoresAndFreq();
            }
          }
        }
      }
    }
  }
  
  public static int getHwDolbyLevel()
  {
    AppMethodBeat.i(222704);
    if (sDolbyLevel == -1) {
      initDolbyInvariableParams();
    }
    int i = sDolbyLevel;
    AppMethodBeat.o(222704);
    return i;
  }
  
  public static int getMaxSupportedFrameRatesFor(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(222612);
    if (Build.VERSION.SDK_INT < 21)
    {
      AppMethodBeat.o(222612);
      return 30;
    }
    if (paramInt1 == 101)
    {
      AppMethodBeat.o(222612);
      return 30;
    }
    try
    {
      int j = MediaCodecList.getCodecCount();
      paramInt1 = 0;
      while (paramInt1 < j)
      {
        MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(paramInt1);
        if (!localMediaCodecInfo.isEncoder())
        {
          String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
          int k = arrayOfString.length;
          int i = 0;
          while (i < k)
          {
            Object localObject = arrayOfString[i];
            if (((String)localObject).equalsIgnoreCase("video/hevc"))
            {
              localObject = localMediaCodecInfo.getCapabilitiesForType("video/hevc").getVideoCapabilities().getSupportedFrameRatesFor(paramInt3, paramInt4);
              if (paramInt2 == 172)
              {
                if (((Double)((Range)localObject).getUpper()).intValue() % 10 == 0) {}
                for (paramInt1 = ((Double)((Range)localObject).getUpper()).intValue();; paramInt1 = ((Double)((Range)localObject).getUpper()).intValue() + 1)
                {
                  AppMethodBeat.o(222612);
                  return paramInt1;
                }
              }
            }
            else if (((String)localObject).equalsIgnoreCase("video/avc"))
            {
              localObject = localMediaCodecInfo.getCapabilitiesForType("video/avc").getVideoCapabilities().getSupportedFrameRatesFor(paramInt3, paramInt4);
              if (paramInt2 == 26)
              {
                if (((Double)((Range)localObject).getUpper()).intValue() % 10 == 0) {
                  paramInt1 = ((Double)((Range)localObject).getUpper()).intValue();
                }
                for (;;)
                {
                  AppMethodBeat.o(222612);
                  return paramInt1;
                  paramInt1 = ((Double)((Range)localObject).getUpper()).intValue();
                  paramInt1 += 1;
                }
              }
            }
            i += 1;
          }
        }
        paramInt1 += 1;
      }
      return 30;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, "TPCodecUtils", "getSupportedFrameRatesFor func failed:" + localThrowable.toString());
      AppMethodBeat.o(222612);
    }
  }
  
  /* Error */
  public static HashMap<Integer, TPCodecCapability.TPVCodecMaxCapability> getMediaCodecMaxCapabilityMap()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 516
    //   6: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: iconst_2
    //   10: ldc 34
    //   12: ldc_w 518
    //   15: invokestatic 247	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   18: getstatic 249	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsMediaCodecCapGot	Z
    //   21: ifeq +29 -> 50
    //   24: iconst_2
    //   25: ldc 34
    //   27: ldc_w 520
    //   30: invokestatic 247	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   33: getstatic 272	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   36: astore 12
    //   38: ldc_w 516
    //   41: invokestatic 277	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: ldc 2
    //   46: monitorexit
    //   47: aload 12
    //   49: areturn
    //   50: getstatic 113	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsLocalCacheEnabled	Z
    //   53: ifeq +175 -> 228
    //   56: getstatic 115	com/tencent/thumbplayer/core/common/TPCodecUtils:mNeedToReprobeDecoderCapability	Z
    //   59: ifne +169 -> 228
    //   62: iconst_2
    //   63: ldc 34
    //   65: ldc_w 522
    //   68: invokestatic 247	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   71: getstatic 128	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   74: ifnull +12 -> 86
    //   77: getstatic 128	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   80: invokevirtual 525	java/util/ArrayList:size	()I
    //   83: ifne +21 -> 104
    //   86: getstatic 154	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapListKey	Ljava/lang/String;
    //   89: invokestatic 527	com/tencent/thumbplayer/core/common/TPCodecUtils:getCachedCapList	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   92: astore 12
    //   94: aload 12
    //   96: ifnull +8 -> 104
    //   99: aload 12
    //   101: putstatic 128	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   104: getstatic 128	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   107: ifnull +121 -> 228
    //   110: getstatic 128	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   113: invokevirtual 525	java/util/ArrayList:size	()I
    //   116: ifle +112 -> 228
    //   119: getstatic 166	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMapKey	Ljava/lang/String;
    //   122: invokestatic 529	com/tencent/thumbplayer/core/common/TPCodecUtils:getCachedCapabilityMap	(Ljava/lang/String;)Ljava/util/HashMap;
    //   125: astore 12
    //   127: aload 12
    //   129: ifnull +99 -> 228
    //   132: aload 12
    //   134: putstatic 272	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   137: aload 12
    //   139: invokevirtual 530	java/util/HashMap:size	()I
    //   142: ifle +86 -> 228
    //   145: iconst_2
    //   146: ldc 34
    //   148: new 298	java/lang/StringBuilder
    //   151: dup
    //   152: ldc_w 532
    //   155: invokespecial 303	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   158: getstatic 272	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   161: invokevirtual 530	java/util/HashMap:size	()I
    //   164: invokevirtual 353	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   167: invokevirtual 313	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokestatic 247	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   173: iconst_1
    //   174: putstatic 249	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsMediaCodecCapGot	Z
    //   177: getstatic 272	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   180: astore 12
    //   182: ldc_w 516
    //   185: invokestatic 277	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   188: goto -144 -> 44
    //   191: astore 12
    //   193: ldc 2
    //   195: monitorexit
    //   196: aload 12
    //   198: athrow
    //   199: astore 12
    //   201: iconst_4
    //   202: ldc 34
    //   204: new 298	java/lang/StringBuilder
    //   207: dup
    //   208: ldc_w 534
    //   211: invokespecial 303	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   214: aload 12
    //   216: invokevirtual 537	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   219: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: invokevirtual 313	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: invokestatic 247	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   228: iconst_0
    //   229: istore_3
    //   230: iconst_0
    //   231: istore_1
    //   232: iconst_0
    //   233: istore_0
    //   234: ldc_w 539
    //   237: invokestatic 545	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   240: astore 12
    //   242: aload 12
    //   244: ldc_w 546
    //   247: iconst_0
    //   248: anewarray 541	java/lang/Class
    //   251: invokevirtual 550	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   254: astore 20
    //   256: aload 12
    //   258: ldc_w 551
    //   261: iconst_1
    //   262: anewarray 541	java/lang/Class
    //   265: dup
    //   266: iconst_0
    //   267: getstatic 555	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   270: aastore
    //   271: invokevirtual 550	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   274: astore 12
    //   276: ldc_w 557
    //   279: invokestatic 545	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   282: astore 16
    //   284: aload 16
    //   286: ldc_w 558
    //   289: iconst_0
    //   290: anewarray 541	java/lang/Class
    //   293: invokevirtual 550	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   296: astore 13
    //   298: aload 16
    //   300: ldc_w 560
    //   303: iconst_0
    //   304: anewarray 541	java/lang/Class
    //   307: invokevirtual 550	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   310: astore 14
    //   312: aload 16
    //   314: ldc_w 561
    //   317: iconst_0
    //   318: anewarray 541	java/lang/Class
    //   321: invokevirtual 550	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   324: astore 15
    //   326: aload 16
    //   328: ldc_w 562
    //   331: iconst_1
    //   332: anewarray 541	java/lang/Class
    //   335: dup
    //   336: iconst_0
    //   337: ldc_w 463
    //   340: aastore
    //   341: invokevirtual 550	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   344: astore 16
    //   346: ldc_w 564
    //   349: invokestatic 545	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   352: ldc_w 566
    //   355: invokevirtual 570	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   358: astore 17
    //   360: ldc_w 572
    //   363: invokestatic 545	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   366: astore 19
    //   368: aload 19
    //   370: ldc_w 574
    //   373: invokevirtual 570	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   376: astore 18
    //   378: aload 19
    //   380: ldc_w 576
    //   383: invokevirtual 570	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   386: astore 19
    //   388: aload 20
    //   390: aconst_null
    //   391: iconst_0
    //   392: anewarray 4	java/lang/Object
    //   395: invokevirtual 582	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   398: checkcast 223	java/lang/Integer
    //   401: invokevirtual 583	java/lang/Integer:intValue	()I
    //   404: istore 8
    //   406: iconst_2
    //   407: ldc_w 585
    //   410: iload 8
    //   412: invokestatic 588	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   415: invokevirtual 591	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   418: invokestatic 594	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   421: iconst_0
    //   422: istore 4
    //   424: iload 4
    //   426: iload 8
    //   428: if_icmpge +1969 -> 2397
    //   431: aload 12
    //   433: aconst_null
    //   434: iconst_1
    //   435: anewarray 4	java/lang/Object
    //   438: dup
    //   439: iconst_0
    //   440: iload 4
    //   442: invokestatic 227	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   445: aastore
    //   446: invokevirtual 582	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
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
    //   467: invokevirtual 582	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   470: checkcast 596	java/lang/Boolean
    //   473: invokevirtual 599	java/lang/Boolean:booleanValue	()Z
    //   476: ifne +1904 -> 2380
    //   479: aload 14
    //   481: aload 20
    //   483: iconst_0
    //   484: anewarray 4	java/lang/Object
    //   487: invokevirtual 582	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   490: checkcast 463	java/lang/String
    //   493: invokevirtual 602	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   496: astore 21
    //   498: aload 13
    //   500: aload 20
    //   502: iconst_0
    //   503: anewarray 4	java/lang/Object
    //   506: invokevirtual 582	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   509: checkcast 604	[Ljava/lang/String;
    //   512: checkcast 604	[Ljava/lang/String;
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
    //   537: if_icmpge +1843 -> 2380
    //   540: aload 22
    //   542: iload 5
    //   544: aaload
    //   545: astore 23
    //   547: iconst_2
    //   548: ldc_w 606
    //   551: aload 23
    //   553: invokestatic 609	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   556: invokevirtual 591	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   559: invokestatic 594	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   562: aload 21
    //   564: ldc_w 611
    //   567: invokevirtual 615	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   570: ifne +36 -> 606
    //   573: aload 21
    //   575: ldc_w 617
    //   578: invokevirtual 615	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   581: ifne +25 -> 606
    //   584: aload 21
    //   586: ldc_w 619
    //   589: invokevirtual 615	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   592: ifne +14 -> 606
    //   595: aload 21
    //   597: ldc_w 621
    //   600: invokevirtual 615	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   603: ifeq +17 -> 620
    //   606: getstatic 130	com/tencent/thumbplayer/core/common/TPCodecUtils:mSoftCodecCapList	Ljava/util/ArrayList;
    //   609: aload 23
    //   611: invokevirtual 625	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   614: pop
    //   615: iload_3
    //   616: istore_2
    //   617: goto +1923 -> 2540
    //   620: getstatic 128	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   623: aload 23
    //   625: invokevirtual 625	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   628: pop
    //   629: getstatic 128	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   632: ldc_w 496
    //   635: invokevirtual 627	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   638: istore 11
    //   640: iload_3
    //   641: istore_2
    //   642: iload 11
    //   644: ifeq +241 -> 885
    //   647: iload_3
    //   648: istore_2
    //   649: iload_3
    //   650: ifne +235 -> 885
    //   653: aload 17
    //   655: aload 16
    //   657: aload 20
    //   659: iconst_1
    //   660: anewarray 4	java/lang/Object
    //   663: dup
    //   664: iconst_0
    //   665: ldc_w 496
    //   668: aastore
    //   669: invokevirtual 582	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   672: invokevirtual 632	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   675: checkcast 634	[Ljava/lang/Object;
    //   678: checkcast 634	[Ljava/lang/Object;
    //   681: astore 23
    //   683: aload 23
    //   685: arraylength
    //   686: istore_3
    //   687: iconst_0
    //   688: istore_2
    //   689: iload_2
    //   690: iload_3
    //   691: if_icmpge +727 -> 1418
    //   694: aload 23
    //   696: iload_2
    //   697: aaload
    //   698: astore 24
    //   700: aload 18
    //   702: aload 24
    //   704: invokevirtual 632	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   707: checkcast 223	java/lang/Integer
    //   710: invokevirtual 583	java/lang/Integer:intValue	()I
    //   713: istore 6
    //   715: aload 19
    //   717: aload 24
    //   719: invokevirtual 632	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   722: checkcast 223	java/lang/Integer
    //   725: invokevirtual 583	java/lang/Integer:intValue	()I
    //   728: istore 7
    //   730: iload 7
    //   732: iload 6
    //   734: invokestatic 638	com/tencent/thumbplayer/core/common/TPCodecUtils:maxLumaSamplesForAVCProfileLevel	(II)I
    //   737: istore 10
    //   739: iload 10
    //   741: getstatic 258	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   744: getfield 641	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   747: if_icmplt +1804 -> 2551
    //   750: getstatic 258	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   753: iload 10
    //   755: putfield 641	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   758: getstatic 258	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   761: iload 7
    //   763: putfield 644	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxProfile	I
    //   766: getstatic 258	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   769: iload 6
    //   771: putfield 647	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLevel	I
    //   774: getstatic 258	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   777: getfield 641	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   780: ldc_w 648
    //   783: if_icmplt +39 -> 822
    //   786: getstatic 258	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   789: bipush 102
    //   791: bipush 26
    //   793: sipush 7680
    //   796: sipush 4320
    //   799: invokestatic 650	com/tencent/thumbplayer/core/common/TPCodecUtils:getMaxSupportedFrameRatesFor	(IIII)I
    //   802: putfield 653	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxFramerateFormaxLumaSamples	I
    //   805: bipush 26
    //   807: invokestatic 227	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   810: getstatic 258	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   813: getstatic 272	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   816: invokestatic 657	com/tencent/thumbplayer/core/common/TPCodecUtils:replace	(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/HashMap;)V
    //   819: goto +1732 -> 2551
    //   822: getstatic 258	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   825: getfield 641	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   828: ldc_w 658
    //   831: if_icmplt +253 -> 1084
    //   834: getstatic 258	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   837: bipush 102
    //   839: bipush 26
    //   841: sipush 4096
    //   844: sipush 2160
    //   847: invokestatic 650	com/tencent/thumbplayer/core/common/TPCodecUtils:getMaxSupportedFrameRatesFor	(IIII)I
    //   850: putfield 653	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxFramerateFormaxLumaSamples	I
    //   853: goto -48 -> 805
    //   856: astore 23
    //   858: iconst_1
    //   859: istore_2
    //   860: iconst_4
    //   861: new 298	java/lang/StringBuilder
    //   864: dup
    //   865: ldc_w 660
    //   868: invokespecial 303	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   871: aload 23
    //   873: invokevirtual 661	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   876: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   879: invokevirtual 313	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   882: invokestatic 594	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   885: getstatic 128	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   888: ldc_w 461
    //   891: invokevirtual 627	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   894: istore 11
    //   896: iload_1
    //   897: istore_3
    //   898: iload 11
    //   900: ifeq +783 -> 1683
    //   903: iload_1
    //   904: istore_3
    //   905: iload_1
    //   906: ifne +777 -> 1683
    //   909: aload 17
    //   911: aload 16
    //   913: aload 20
    //   915: iconst_1
    //   916: anewarray 4	java/lang/Object
    //   919: dup
    //   920: iconst_0
    //   921: ldc_w 461
    //   924: aastore
    //   925: invokevirtual 582	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   928: invokevirtual 632	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   931: checkcast 634	[Ljava/lang/Object;
    //   934: checkcast 634	[Ljava/lang/Object;
    //   937: astore 23
    //   939: aload 23
    //   941: arraylength
    //   942: istore_3
    //   943: iconst_0
    //   944: istore_1
    //   945: iload_1
    //   946: iload_3
    //   947: if_icmpge +1129 -> 2076
    //   950: aload 23
    //   952: iload_1
    //   953: aaload
    //   954: astore 24
    //   956: aload 18
    //   958: aload 24
    //   960: invokevirtual 632	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   963: checkcast 223	java/lang/Integer
    //   966: invokevirtual 583	java/lang/Integer:intValue	()I
    //   969: istore 6
    //   971: aload 19
    //   973: aload 24
    //   975: invokevirtual 632	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   978: checkcast 223	java/lang/Integer
    //   981: invokevirtual 583	java/lang/Integer:intValue	()I
    //   984: istore 7
    //   986: iload 7
    //   988: iload 6
    //   990: invokestatic 664	com/tencent/thumbplayer/core/common/TPCodecUtils:maxLumaSamplesForHEVCProfileLevel	(II)I
    //   993: istore 10
    //   995: iload 10
    //   997: getstatic 260	com/tencent/thumbplayer/core/common/TPCodecUtils:mHEVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1000: getfield 641	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   1003: if_icmplt +74 -> 1077
    //   1006: getstatic 260	com/tencent/thumbplayer/core/common/TPCodecUtils:mHEVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1009: iload 10
    //   1011: putfield 641	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   1014: getstatic 260	com/tencent/thumbplayer/core/common/TPCodecUtils:mHEVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1017: iload 7
    //   1019: putfield 644	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxProfile	I
    //   1022: getstatic 260	com/tencent/thumbplayer/core/common/TPCodecUtils:mHEVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1025: iload 6
    //   1027: putfield 647	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLevel	I
    //   1030: getstatic 260	com/tencent/thumbplayer/core/common/TPCodecUtils:mHEVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1033: getfield 641	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   1036: ldc_w 648
    //   1039: if_icmplt +580 -> 1619
    //   1042: getstatic 260	com/tencent/thumbplayer/core/common/TPCodecUtils:mHEVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1045: bipush 102
    //   1047: sipush 172
    //   1050: sipush 7680
    //   1053: sipush 4320
    //   1056: invokestatic 650	com/tencent/thumbplayer/core/common/TPCodecUtils:getMaxSupportedFrameRatesFor	(IIII)I
    //   1059: putfield 653	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxFramerateFormaxLumaSamples	I
    //   1062: sipush 172
    //   1065: invokestatic 227	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1068: getstatic 260	com/tencent/thumbplayer/core/common/TPCodecUtils:mHEVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1071: getstatic 272	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1074: invokestatic 657	com/tencent/thumbplayer/core/common/TPCodecUtils:replace	(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/HashMap;)V
    //   1077: iload_1
    //   1078: iconst_1
    //   1079: iadd
    //   1080: istore_1
    //   1081: goto -136 -> 945
    //   1084: getstatic 258	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1087: getfield 641	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   1090: ldc_w 665
    //   1093: if_icmplt +110 -> 1203
    //   1096: getstatic 258	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1099: bipush 102
    //   1101: bipush 26
    //   1103: sipush 1920
    //   1106: sipush 1080
    //   1109: invokestatic 650	com/tencent/thumbplayer/core/common/TPCodecUtils:getMaxSupportedFrameRatesFor	(IIII)I
    //   1112: putfield 653	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxFramerateFormaxLumaSamples	I
    //   1115: goto -310 -> 805
    //   1118: astore 12
    //   1120: iconst_4
    //   1121: new 298	java/lang/StringBuilder
    //   1124: dup
    //   1125: ldc_w 667
    //   1128: invokespecial 303	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1131: aload 12
    //   1133: invokevirtual 668	java/lang/reflect/InvocationTargetException:getMessage	()Ljava/lang/String;
    //   1136: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1139: invokevirtual 313	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1142: invokestatic 594	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1145: iconst_2
    //   1146: ldc_w 670
    //   1149: invokestatic 594	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1152: getstatic 113	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsLocalCacheEnabled	Z
    //   1155: ifeq +30 -> 1185
    //   1158: getstatic 154	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapListKey	Ljava/lang/String;
    //   1161: getstatic 128	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   1164: invokestatic 672	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   1167: getstatic 166	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMapKey	Ljava/lang/String;
    //   1170: getstatic 272	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1173: invokestatic 674	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapabilityMap	(Ljava/lang/String;Ljava/util/HashMap;)V
    //   1176: iconst_2
    //   1177: ldc 34
    //   1179: ldc_w 676
    //   1182: invokestatic 247	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   1185: iconst_1
    //   1186: putstatic 249	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsMediaCodecCapGot	Z
    //   1189: getstatic 272	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1192: astore 12
    //   1194: ldc_w 516
    //   1197: invokestatic 277	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1200: goto -1156 -> 44
    //   1203: getstatic 258	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1206: getfield 641	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   1209: ldc_w 677
    //   1212: if_icmplt +110 -> 1322
    //   1215: getstatic 258	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1218: bipush 102
    //   1220: bipush 26
    //   1222: sipush 1280
    //   1225: sipush 720
    //   1228: invokestatic 650	com/tencent/thumbplayer/core/common/TPCodecUtils:getMaxSupportedFrameRatesFor	(IIII)I
    //   1231: putfield 653	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxFramerateFormaxLumaSamples	I
    //   1234: goto -429 -> 805
    //   1237: astore 12
    //   1239: iconst_4
    //   1240: new 298	java/lang/StringBuilder
    //   1243: dup
    //   1244: ldc_w 667
    //   1247: invokespecial 303	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1250: aload 12
    //   1252: invokevirtual 678	java/lang/NoSuchMethodException:getMessage	()Ljava/lang/String;
    //   1255: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1258: invokevirtual 313	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1261: invokestatic 594	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1264: iconst_2
    //   1265: ldc_w 670
    //   1268: invokestatic 594	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1271: getstatic 113	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsLocalCacheEnabled	Z
    //   1274: ifeq +30 -> 1304
    //   1277: getstatic 154	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapListKey	Ljava/lang/String;
    //   1280: getstatic 128	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   1283: invokestatic 672	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   1286: getstatic 166	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMapKey	Ljava/lang/String;
    //   1289: getstatic 272	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1292: invokestatic 674	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapabilityMap	(Ljava/lang/String;Ljava/util/HashMap;)V
    //   1295: iconst_2
    //   1296: ldc 34
    //   1298: ldc_w 676
    //   1301: invokestatic 247	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   1304: iconst_1
    //   1305: putstatic 249	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsMediaCodecCapGot	Z
    //   1308: getstatic 272	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1311: astore 12
    //   1313: ldc_w 516
    //   1316: invokestatic 277	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1319: goto -1275 -> 44
    //   1322: getstatic 258	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1325: bipush 30
    //   1327: putfield 653	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxFramerateFormaxLumaSamples	I
    //   1330: goto -525 -> 805
    //   1333: astore 12
    //   1335: iconst_4
    //   1336: new 298	java/lang/StringBuilder
    //   1339: dup
    //   1340: ldc_w 667
    //   1343: invokespecial 303	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1346: aload 12
    //   1348: invokevirtual 679	java/lang/IllegalAccessException:getMessage	()Ljava/lang/String;
    //   1351: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1354: invokevirtual 313	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1357: invokestatic 594	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1360: iconst_2
    //   1361: ldc_w 670
    //   1364: invokestatic 594	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1367: getstatic 113	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsLocalCacheEnabled	Z
    //   1370: ifeq +30 -> 1400
    //   1373: getstatic 154	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapListKey	Ljava/lang/String;
    //   1376: getstatic 128	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   1379: invokestatic 672	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   1382: getstatic 166	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMapKey	Ljava/lang/String;
    //   1385: getstatic 272	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1388: invokestatic 674	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapabilityMap	(Ljava/lang/String;Ljava/util/HashMap;)V
    //   1391: iconst_2
    //   1392: ldc 34
    //   1394: ldc_w 676
    //   1397: invokestatic 247	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   1400: iconst_1
    //   1401: putstatic 249	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsMediaCodecCapGot	Z
    //   1404: getstatic 272	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1407: astore 12
    //   1409: ldc_w 516
    //   1412: invokestatic 277	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1415: goto -1371 -> 44
    //   1418: getstatic 272	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1421: bipush 26
    //   1423: invokestatic 227	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1426: invokevirtual 682	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   1429: ifeq +95 -> 1524
    //   1432: iconst_2
    //   1433: new 298	java/lang/StringBuilder
    //   1436: dup
    //   1437: ldc_w 684
    //   1440: invokespecial 303	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1443: getstatic 272	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1446: bipush 26
    //   1448: invokestatic 227	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1451: invokevirtual 685	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1454: checkcast 253	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability
    //   1457: getfield 644	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxProfile	I
    //   1460: invokevirtual 353	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1463: ldc_w 687
    //   1466: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1469: getstatic 272	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1472: bipush 26
    //   1474: invokestatic 227	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1477: invokevirtual 685	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1480: checkcast 253	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability
    //   1483: getfield 647	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLevel	I
    //   1486: invokevirtual 353	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1489: ldc_w 689
    //   1492: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1495: getstatic 272	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1498: bipush 26
    //   1500: invokestatic 227	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1503: invokevirtual 685	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1506: checkcast 253	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability
    //   1509: getfield 641	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   1512: invokevirtual 353	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1515: invokevirtual 313	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1518: invokestatic 594	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1521: goto +1037 -> 2558
    //   1524: iconst_2
    //   1525: ldc_w 691
    //   1528: invokestatic 594	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1531: goto +1027 -> 2558
    //   1534: astore 12
    //   1536: iconst_4
    //   1537: new 298	java/lang/StringBuilder
    //   1540: dup
    //   1541: ldc_w 667
    //   1544: invokespecial 303	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1547: aload 12
    //   1549: invokevirtual 692	java/lang/NoSuchFieldException:getMessage	()Ljava/lang/String;
    //   1552: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1555: invokevirtual 313	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1558: invokestatic 594	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1561: iconst_2
    //   1562: ldc_w 670
    //   1565: invokestatic 594	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1568: getstatic 113	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsLocalCacheEnabled	Z
    //   1571: ifeq +30 -> 1601
    //   1574: getstatic 154	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapListKey	Ljava/lang/String;
    //   1577: getstatic 128	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   1580: invokestatic 672	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   1583: getstatic 166	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMapKey	Ljava/lang/String;
    //   1586: getstatic 272	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1589: invokestatic 674	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapabilityMap	(Ljava/lang/String;Ljava/util/HashMap;)V
    //   1592: iconst_2
    //   1593: ldc 34
    //   1595: ldc_w 676
    //   1598: invokestatic 247	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   1601: iconst_1
    //   1602: putstatic 249	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsMediaCodecCapGot	Z
    //   1605: getstatic 272	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1608: astore 12
    //   1610: ldc_w 516
    //   1613: invokestatic 277	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1616: goto -1572 -> 44
    //   1619: getstatic 260	com/tencent/thumbplayer/core/common/TPCodecUtils:mHEVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1622: getfield 641	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   1625: ldc_w 658
    //   1628: if_icmplt +222 -> 1850
    //   1631: getstatic 260	com/tencent/thumbplayer/core/common/TPCodecUtils:mHEVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1634: bipush 102
    //   1636: sipush 172
    //   1639: sipush 4096
    //   1642: sipush 2160
    //   1645: invokestatic 650	com/tencent/thumbplayer/core/common/TPCodecUtils:getMaxSupportedFrameRatesFor	(IIII)I
    //   1648: putfield 653	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxFramerateFormaxLumaSamples	I
    //   1651: goto -589 -> 1062
    //   1654: astore 23
    //   1656: iconst_1
    //   1657: istore_3
    //   1658: iconst_4
    //   1659: new 298	java/lang/StringBuilder
    //   1662: dup
    //   1663: ldc_w 694
    //   1666: invokespecial 303	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1669: aload 23
    //   1671: invokevirtual 661	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   1674: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1677: invokevirtual 313	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1680: invokestatic 594	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1683: getstatic 128	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   1686: ldc_w 696
    //   1689: invokevirtual 627	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   1692: istore 11
    //   1694: iload_0
    //   1695: istore_1
    //   1696: iload 11
    //   1698: ifeq +677 -> 2375
    //   1701: iload_0
    //   1702: istore_1
    //   1703: iload_0
    //   1704: ifne +671 -> 2375
    //   1707: aload 17
    //   1709: aload 16
    //   1711: aload 20
    //   1713: iconst_1
    //   1714: anewarray 4	java/lang/Object
    //   1717: dup
    //   1718: iconst_0
    //   1719: ldc_w 696
    //   1722: aastore
    //   1723: invokevirtual 582	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1726: invokevirtual 632	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1729: checkcast 634	[Ljava/lang/Object;
    //   1732: checkcast 634	[Ljava/lang/Object;
    //   1735: astore 23
    //   1737: aload 23
    //   1739: arraylength
    //   1740: istore_1
    //   1741: iconst_0
    //   1742: istore_0
    //   1743: iload_0
    //   1744: iload_1
    //   1745: if_icmpge +451 -> 2196
    //   1748: aload 23
    //   1750: iload_0
    //   1751: aaload
    //   1752: astore 24
    //   1754: aload 18
    //   1756: aload 24
    //   1758: invokevirtual 632	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1761: checkcast 223	java/lang/Integer
    //   1764: invokevirtual 583	java/lang/Integer:intValue	()I
    //   1767: istore 6
    //   1769: aload 19
    //   1771: aload 24
    //   1773: invokevirtual 632	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1776: checkcast 223	java/lang/Integer
    //   1779: invokevirtual 583	java/lang/Integer:intValue	()I
    //   1782: istore 7
    //   1784: iload 7
    //   1786: iload 6
    //   1788: invokestatic 699	com/tencent/thumbplayer/core/common/TPCodecUtils:maxLumaSamplesForVP9ProfileLevel	(II)I
    //   1791: istore 10
    //   1793: iload 10
    //   1795: getstatic 262	com/tencent/thumbplayer/core/common/TPCodecUtils:mVP9MediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1798: getfield 641	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   1801: if_icmplt +42 -> 1843
    //   1804: getstatic 262	com/tencent/thumbplayer/core/common/TPCodecUtils:mVP9MediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1807: iload 10
    //   1809: putfield 641	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   1812: getstatic 262	com/tencent/thumbplayer/core/common/TPCodecUtils:mVP9MediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1815: iload 7
    //   1817: putfield 644	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxProfile	I
    //   1820: getstatic 262	com/tencent/thumbplayer/core/common/TPCodecUtils:mVP9MediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1823: iload 6
    //   1825: putfield 647	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLevel	I
    //   1828: sipush 166
    //   1831: invokestatic 227	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1834: getstatic 262	com/tencent/thumbplayer/core/common/TPCodecUtils:mVP9MediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1837: getstatic 272	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1840: invokestatic 657	com/tencent/thumbplayer/core/common/TPCodecUtils:replace	(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/HashMap;)V
    //   1843: iload_0
    //   1844: iconst_1
    //   1845: iadd
    //   1846: istore_0
    //   1847: goto -104 -> 1743
    //   1850: getstatic 260	com/tencent/thumbplayer/core/common/TPCodecUtils:mHEVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1853: getfield 641	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   1856: ldc_w 665
    //   1859: if_icmplt +111 -> 1970
    //   1862: getstatic 260	com/tencent/thumbplayer/core/common/TPCodecUtils:mHEVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1865: bipush 102
    //   1867: sipush 172
    //   1870: sipush 1920
    //   1873: sipush 1080
    //   1876: invokestatic 650	com/tencent/thumbplayer/core/common/TPCodecUtils:getMaxSupportedFrameRatesFor	(IIII)I
    //   1879: putfield 653	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxFramerateFormaxLumaSamples	I
    //   1882: goto -820 -> 1062
    //   1885: astore 12
    //   1887: iconst_4
    //   1888: new 298	java/lang/StringBuilder
    //   1891: dup
    //   1892: ldc_w 667
    //   1895: invokespecial 303	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1898: aload 12
    //   1900: invokevirtual 700	java/lang/ClassNotFoundException:getMessage	()Ljava/lang/String;
    //   1903: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1906: invokevirtual 313	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1909: invokestatic 594	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1912: iconst_2
    //   1913: ldc_w 670
    //   1916: invokestatic 594	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1919: getstatic 113	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsLocalCacheEnabled	Z
    //   1922: ifeq +30 -> 1952
    //   1925: getstatic 154	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapListKey	Ljava/lang/String;
    //   1928: getstatic 128	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   1931: invokestatic 672	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   1934: getstatic 166	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMapKey	Ljava/lang/String;
    //   1937: getstatic 272	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1940: invokestatic 674	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapabilityMap	(Ljava/lang/String;Ljava/util/HashMap;)V
    //   1943: iconst_2
    //   1944: ldc 34
    //   1946: ldc_w 676
    //   1949: invokestatic 247	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   1952: iconst_1
    //   1953: putstatic 249	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsMediaCodecCapGot	Z
    //   1956: getstatic 272	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1959: astore 12
    //   1961: ldc_w 516
    //   1964: invokestatic 277	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1967: goto -1923 -> 44
    //   1970: getstatic 260	com/tencent/thumbplayer/core/common/TPCodecUtils:mHEVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1973: getfield 641	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   1976: ldc_w 677
    //   1979: if_icmplt +86 -> 2065
    //   1982: getstatic 260	com/tencent/thumbplayer/core/common/TPCodecUtils:mHEVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1985: bipush 102
    //   1987: sipush 172
    //   1990: sipush 1280
    //   1993: sipush 720
    //   1996: invokestatic 650	com/tencent/thumbplayer/core/common/TPCodecUtils:getMaxSupportedFrameRatesFor	(IIII)I
    //   1999: putfield 653	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxFramerateFormaxLumaSamples	I
    //   2002: goto -940 -> 1062
    //   2005: astore 12
    //   2007: iconst_2
    //   2008: ldc_w 670
    //   2011: invokestatic 594	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   2014: getstatic 113	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsLocalCacheEnabled	Z
    //   2017: ifeq +30 -> 2047
    //   2020: getstatic 154	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapListKey	Ljava/lang/String;
    //   2023: getstatic 128	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   2026: invokestatic 672	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   2029: getstatic 166	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMapKey	Ljava/lang/String;
    //   2032: getstatic 272	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   2035: invokestatic 674	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapabilityMap	(Ljava/lang/String;Ljava/util/HashMap;)V
    //   2038: iconst_2
    //   2039: ldc 34
    //   2041: ldc_w 676
    //   2044: invokestatic 247	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   2047: iconst_1
    //   2048: putstatic 249	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsMediaCodecCapGot	Z
    //   2051: getstatic 272	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   2054: astore 12
    //   2056: ldc_w 516
    //   2059: invokestatic 277	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2062: goto -2018 -> 44
    //   2065: getstatic 260	com/tencent/thumbplayer/core/common/TPCodecUtils:mHEVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   2068: bipush 30
    //   2070: putfield 653	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxFramerateFormaxLumaSamples	I
    //   2073: goto -1011 -> 1062
    //   2076: getstatic 272	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   2079: sipush 172
    //   2082: invokestatic 227	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2085: invokevirtual 682	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   2088: ifeq +98 -> 2186
    //   2091: iconst_2
    //   2092: new 298	java/lang/StringBuilder
    //   2095: dup
    //   2096: ldc_w 702
    //   2099: invokespecial 303	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2102: getstatic 272	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   2105: sipush 172
    //   2108: invokestatic 227	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2111: invokevirtual 685	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2114: checkcast 253	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability
    //   2117: getfield 644	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxProfile	I
    //   2120: invokevirtual 353	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2123: ldc_w 687
    //   2126: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2129: getstatic 272	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   2132: sipush 172
    //   2135: invokestatic 227	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2138: invokevirtual 685	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2141: checkcast 253	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability
    //   2144: getfield 647	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLevel	I
    //   2147: invokevirtual 353	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2150: ldc_w 689
    //   2153: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2156: getstatic 272	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   2159: sipush 172
    //   2162: invokestatic 227	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2165: invokevirtual 685	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2168: checkcast 253	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability
    //   2171: getfield 641	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   2174: invokevirtual 353	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2177: invokevirtual 313	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2180: invokestatic 594	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   2183: goto +380 -> 2563
    //   2186: iconst_2
    //   2187: ldc_w 704
    //   2190: invokestatic 594	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   2193: goto +370 -> 2563
    //   2196: getstatic 272	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   2199: sipush 166
    //   2202: invokestatic 227	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2205: invokevirtual 682	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   2208: ifeq +128 -> 2336
    //   2211: iconst_2
    //   2212: new 298	java/lang/StringBuilder
    //   2215: dup
    //   2216: ldc_w 706
    //   2219: invokespecial 303	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2222: getstatic 272	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   2225: sipush 166
    //   2228: invokestatic 227	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2231: invokevirtual 685	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2234: checkcast 253	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability
    //   2237: getfield 644	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxProfile	I
    //   2240: invokevirtual 353	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2243: ldc_w 687
    //   2246: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2249: getstatic 272	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   2252: sipush 166
    //   2255: invokestatic 227	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2258: invokevirtual 685	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2261: checkcast 253	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability
    //   2264: getfield 647	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLevel	I
    //   2267: invokevirtual 353	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2270: ldc_w 689
    //   2273: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2276: getstatic 272	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   2279: sipush 166
    //   2282: invokestatic 227	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2285: invokevirtual 685	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2288: checkcast 253	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability
    //   2291: getfield 641	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   2294: invokevirtual 353	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2297: invokevirtual 313	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2300: invokestatic 594	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   2303: iconst_1
    //   2304: istore_0
    //   2305: iconst_2
    //   2306: new 298	java/lang/StringBuilder
    //   2309: dup
    //   2310: ldc_w 708
    //   2313: invokespecial 303	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2316: getstatic 272	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   2319: invokevirtual 530	java/util/HashMap:size	()I
    //   2322: invokevirtual 353	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2325: invokevirtual 313	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2328: invokestatic 594	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   2331: iload_3
    //   2332: istore_1
    //   2333: goto +207 -> 2540
    //   2336: iconst_2
    //   2337: ldc_w 710
    //   2340: invokestatic 594	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   2343: goto -40 -> 2303
    //   2346: astore 23
    //   2348: iconst_1
    //   2349: istore_1
    //   2350: iconst_4
    //   2351: new 298	java/lang/StringBuilder
    //   2354: dup
    //   2355: ldc_w 712
    //   2358: invokespecial 303	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2361: aload 23
    //   2363: invokevirtual 661	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   2366: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2369: invokevirtual 313	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2372: invokestatic 594	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   2375: iload_1
    //   2376: istore_0
    //   2377: goto -72 -> 2305
    //   2380: iload 4
    //   2382: iconst_1
    //   2383: iadd
    //   2384: istore 4
    //   2386: iload_2
    //   2387: istore_0
    //   2388: iload 6
    //   2390: istore_1
    //   2391: iload 7
    //   2393: istore_3
    //   2394: goto -1970 -> 424
    //   2397: iconst_2
    //   2398: ldc_w 670
    //   2401: invokestatic 594	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   2404: getstatic 113	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsLocalCacheEnabled	Z
    //   2407: ifeq +30 -> 2437
    //   2410: getstatic 154	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapListKey	Ljava/lang/String;
    //   2413: getstatic 128	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   2416: invokestatic 672	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   2419: getstatic 166	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMapKey	Ljava/lang/String;
    //   2422: getstatic 272	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   2425: invokestatic 674	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapabilityMap	(Ljava/lang/String;Ljava/util/HashMap;)V
    //   2428: iconst_2
    //   2429: ldc 34
    //   2431: ldc_w 676
    //   2434: invokestatic 247	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   2437: iconst_1
    //   2438: putstatic 249	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsMediaCodecCapGot	Z
    //   2441: getstatic 272	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   2444: astore 12
    //   2446: ldc_w 516
    //   2449: invokestatic 277	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2452: goto -2408 -> 44
    //   2455: astore 12
    //   2457: iconst_4
    //   2458: new 298	java/lang/StringBuilder
    //   2461: dup
    //   2462: ldc_w 667
    //   2465: invokespecial 303	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2468: aload 12
    //   2470: invokevirtual 661	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   2473: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2476: invokevirtual 313	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2479: invokestatic 594	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   2482: iconst_2
    //   2483: ldc_w 670
    //   2486: invokestatic 594	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   2489: getstatic 113	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsLocalCacheEnabled	Z
    //   2492: ifeq +30 -> 2522
    //   2495: getstatic 154	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapListKey	Ljava/lang/String;
    //   2498: getstatic 128	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   2501: invokestatic 672	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   2504: getstatic 166	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMapKey	Ljava/lang/String;
    //   2507: getstatic 272	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   2510: invokestatic 674	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapabilityMap	(Ljava/lang/String;Ljava/util/HashMap;)V
    //   2513: iconst_2
    //   2514: ldc 34
    //   2516: ldc_w 676
    //   2519: invokestatic 247	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   2522: iconst_1
    //   2523: putstatic 249	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsMediaCodecCapGot	Z
    //   2526: getstatic 272	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   2529: astore 12
    //   2531: ldc_w 516
    //   2534: invokestatic 277	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2537: goto -2493 -> 44
    //   2540: iload 5
    //   2542: iconst_1
    //   2543: iadd
    //   2544: istore 5
    //   2546: iload_2
    //   2547: istore_3
    //   2548: goto -2023 -> 525
    //   2551: iload_2
    //   2552: iconst_1
    //   2553: iadd
    //   2554: istore_2
    //   2555: goto -1866 -> 689
    //   2558: iconst_1
    //   2559: istore_2
    //   2560: goto -1675 -> 885
    //   2563: iconst_1
    //   2564: istore_3
    //   2565: goto -882 -> 1683
    // Local variable table:
    //   start	length	slot	name	signature
    //   233	2155	0	i	int
    //   231	2160	1	j	int
    //   452	2108	2	k	int
    //   229	2336	3	m	int
    //   422	1963	4	n	int
    //   523	2022	5	i1	int
    //   454	1935	6	i2	int
    //   457	1935	7	i3	int
    //   404	25	8	i4	int
    //   520	18	9	i5	int
    //   737	1071	10	i6	int
    //   638	1059	11	bool	boolean
    //   36	145	12	localObject1	Object
    //   191	6	12	localObject2	Object
    //   199	16	12	localException	Exception
    //   240	192	12	localObject3	Object
    //   1118	14	12	localInvocationTargetException	java.lang.reflect.InvocationTargetException
    //   1192	1	12	localHashMap1	HashMap
    //   1237	14	12	localNoSuchMethodException	java.lang.NoSuchMethodException
    //   1311	1	12	localHashMap2	HashMap
    //   1333	14	12	localIllegalAccessException	java.lang.IllegalAccessException
    //   1407	1	12	localHashMap3	HashMap
    //   1534	14	12	localNoSuchFieldException	java.lang.NoSuchFieldException
    //   1608	1	12	localHashMap4	HashMap
    //   1885	14	12	localClassNotFoundException	java.lang.ClassNotFoundException
    //   1959	1	12	localHashMap5	HashMap
    //   2005	1	12	localObject4	Object
    //   2054	391	12	localHashMap6	HashMap
    //   2455	14	12	localRuntimeException1	java.lang.RuntimeException
    //   2529	1	12	localHashMap7	HashMap
    //   296	203	13	localMethod1	Method
    //   310	170	14	localMethod2	Method
    //   324	136	15	localMethod3	Method
    //   282	1428	16	localObject5	Object
    //   358	1350	17	localField1	Field
    //   376	1379	18	localField2	Field
    //   366	1404	19	localObject6	Object
    //   254	1458	20	localObject7	Object
    //   496	100	21	str	String
    //   515	26	22	arrayOfString	String[]
    //   545	150	23	localObject8	Object
    //   856	16	23	localRuntimeException2	java.lang.RuntimeException
    //   937	14	23	arrayOfObject1	Object[]
    //   1654	16	23	localRuntimeException3	java.lang.RuntimeException
    //   1735	14	23	arrayOfObject2	Object[]
    //   2346	16	23	localRuntimeException4	java.lang.RuntimeException
    //   698	1074	24	localObject9	Object
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
    //   1145	1185	191	finally
    //   1185	1200	191	finally
    //   1264	1304	191	finally
    //   1304	1319	191	finally
    //   1360	1400	191	finally
    //   1400	1415	191	finally
    //   1561	1601	191	finally
    //   1601	1616	191	finally
    //   1912	1952	191	finally
    //   1952	1967	191	finally
    //   2007	2047	191	finally
    //   2047	2062	191	finally
    //   2397	2437	191	finally
    //   2437	2452	191	finally
    //   2482	2522	191	finally
    //   2522	2537	191	finally
    //   50	86	199	java/lang/Exception
    //   86	94	199	java/lang/Exception
    //   99	104	199	java/lang/Exception
    //   104	127	199	java/lang/Exception
    //   132	182	199	java/lang/Exception
    //   653	687	856	java/lang/RuntimeException
    //   700	805	856	java/lang/RuntimeException
    //   805	819	856	java/lang/RuntimeException
    //   822	853	856	java/lang/RuntimeException
    //   1084	1115	856	java/lang/RuntimeException
    //   1203	1234	856	java/lang/RuntimeException
    //   1322	1330	856	java/lang/RuntimeException
    //   1418	1521	856	java/lang/RuntimeException
    //   1524	1531	856	java/lang/RuntimeException
    //   234	421	1118	java/lang/reflect/InvocationTargetException
    //   431	451	1118	java/lang/reflect/InvocationTargetException
    //   459	522	1118	java/lang/reflect/InvocationTargetException
    //   547	606	1118	java/lang/reflect/InvocationTargetException
    //   606	615	1118	java/lang/reflect/InvocationTargetException
    //   620	640	1118	java/lang/reflect/InvocationTargetException
    //   653	687	1118	java/lang/reflect/InvocationTargetException
    //   700	805	1118	java/lang/reflect/InvocationTargetException
    //   805	819	1118	java/lang/reflect/InvocationTargetException
    //   822	853	1118	java/lang/reflect/InvocationTargetException
    //   860	885	1118	java/lang/reflect/InvocationTargetException
    //   885	896	1118	java/lang/reflect/InvocationTargetException
    //   909	943	1118	java/lang/reflect/InvocationTargetException
    //   956	1062	1118	java/lang/reflect/InvocationTargetException
    //   1062	1077	1118	java/lang/reflect/InvocationTargetException
    //   1084	1115	1118	java/lang/reflect/InvocationTargetException
    //   1203	1234	1118	java/lang/reflect/InvocationTargetException
    //   1322	1330	1118	java/lang/reflect/InvocationTargetException
    //   1418	1521	1118	java/lang/reflect/InvocationTargetException
    //   1524	1531	1118	java/lang/reflect/InvocationTargetException
    //   1619	1651	1118	java/lang/reflect/InvocationTargetException
    //   1658	1683	1118	java/lang/reflect/InvocationTargetException
    //   1683	1694	1118	java/lang/reflect/InvocationTargetException
    //   1707	1741	1118	java/lang/reflect/InvocationTargetException
    //   1754	1843	1118	java/lang/reflect/InvocationTargetException
    //   1850	1882	1118	java/lang/reflect/InvocationTargetException
    //   1970	2002	1118	java/lang/reflect/InvocationTargetException
    //   2065	2073	1118	java/lang/reflect/InvocationTargetException
    //   2076	2183	1118	java/lang/reflect/InvocationTargetException
    //   2186	2193	1118	java/lang/reflect/InvocationTargetException
    //   2196	2303	1118	java/lang/reflect/InvocationTargetException
    //   2305	2331	1118	java/lang/reflect/InvocationTargetException
    //   2336	2343	1118	java/lang/reflect/InvocationTargetException
    //   2350	2375	1118	java/lang/reflect/InvocationTargetException
    //   234	421	1237	java/lang/NoSuchMethodException
    //   431	451	1237	java/lang/NoSuchMethodException
    //   459	522	1237	java/lang/NoSuchMethodException
    //   547	606	1237	java/lang/NoSuchMethodException
    //   606	615	1237	java/lang/NoSuchMethodException
    //   620	640	1237	java/lang/NoSuchMethodException
    //   653	687	1237	java/lang/NoSuchMethodException
    //   700	805	1237	java/lang/NoSuchMethodException
    //   805	819	1237	java/lang/NoSuchMethodException
    //   822	853	1237	java/lang/NoSuchMethodException
    //   860	885	1237	java/lang/NoSuchMethodException
    //   885	896	1237	java/lang/NoSuchMethodException
    //   909	943	1237	java/lang/NoSuchMethodException
    //   956	1062	1237	java/lang/NoSuchMethodException
    //   1062	1077	1237	java/lang/NoSuchMethodException
    //   1084	1115	1237	java/lang/NoSuchMethodException
    //   1203	1234	1237	java/lang/NoSuchMethodException
    //   1322	1330	1237	java/lang/NoSuchMethodException
    //   1418	1521	1237	java/lang/NoSuchMethodException
    //   1524	1531	1237	java/lang/NoSuchMethodException
    //   1619	1651	1237	java/lang/NoSuchMethodException
    //   1658	1683	1237	java/lang/NoSuchMethodException
    //   1683	1694	1237	java/lang/NoSuchMethodException
    //   1707	1741	1237	java/lang/NoSuchMethodException
    //   1754	1843	1237	java/lang/NoSuchMethodException
    //   1850	1882	1237	java/lang/NoSuchMethodException
    //   1970	2002	1237	java/lang/NoSuchMethodException
    //   2065	2073	1237	java/lang/NoSuchMethodException
    //   2076	2183	1237	java/lang/NoSuchMethodException
    //   2186	2193	1237	java/lang/NoSuchMethodException
    //   2196	2303	1237	java/lang/NoSuchMethodException
    //   2305	2331	1237	java/lang/NoSuchMethodException
    //   2336	2343	1237	java/lang/NoSuchMethodException
    //   2350	2375	1237	java/lang/NoSuchMethodException
    //   234	421	1333	java/lang/IllegalAccessException
    //   431	451	1333	java/lang/IllegalAccessException
    //   459	522	1333	java/lang/IllegalAccessException
    //   547	606	1333	java/lang/IllegalAccessException
    //   606	615	1333	java/lang/IllegalAccessException
    //   620	640	1333	java/lang/IllegalAccessException
    //   653	687	1333	java/lang/IllegalAccessException
    //   700	805	1333	java/lang/IllegalAccessException
    //   805	819	1333	java/lang/IllegalAccessException
    //   822	853	1333	java/lang/IllegalAccessException
    //   860	885	1333	java/lang/IllegalAccessException
    //   885	896	1333	java/lang/IllegalAccessException
    //   909	943	1333	java/lang/IllegalAccessException
    //   956	1062	1333	java/lang/IllegalAccessException
    //   1062	1077	1333	java/lang/IllegalAccessException
    //   1084	1115	1333	java/lang/IllegalAccessException
    //   1203	1234	1333	java/lang/IllegalAccessException
    //   1322	1330	1333	java/lang/IllegalAccessException
    //   1418	1521	1333	java/lang/IllegalAccessException
    //   1524	1531	1333	java/lang/IllegalAccessException
    //   1619	1651	1333	java/lang/IllegalAccessException
    //   1658	1683	1333	java/lang/IllegalAccessException
    //   1683	1694	1333	java/lang/IllegalAccessException
    //   1707	1741	1333	java/lang/IllegalAccessException
    //   1754	1843	1333	java/lang/IllegalAccessException
    //   1850	1882	1333	java/lang/IllegalAccessException
    //   1970	2002	1333	java/lang/IllegalAccessException
    //   2065	2073	1333	java/lang/IllegalAccessException
    //   2076	2183	1333	java/lang/IllegalAccessException
    //   2186	2193	1333	java/lang/IllegalAccessException
    //   2196	2303	1333	java/lang/IllegalAccessException
    //   2305	2331	1333	java/lang/IllegalAccessException
    //   2336	2343	1333	java/lang/IllegalAccessException
    //   2350	2375	1333	java/lang/IllegalAccessException
    //   234	421	1534	java/lang/NoSuchFieldException
    //   431	451	1534	java/lang/NoSuchFieldException
    //   459	522	1534	java/lang/NoSuchFieldException
    //   547	606	1534	java/lang/NoSuchFieldException
    //   606	615	1534	java/lang/NoSuchFieldException
    //   620	640	1534	java/lang/NoSuchFieldException
    //   653	687	1534	java/lang/NoSuchFieldException
    //   700	805	1534	java/lang/NoSuchFieldException
    //   805	819	1534	java/lang/NoSuchFieldException
    //   822	853	1534	java/lang/NoSuchFieldException
    //   860	885	1534	java/lang/NoSuchFieldException
    //   885	896	1534	java/lang/NoSuchFieldException
    //   909	943	1534	java/lang/NoSuchFieldException
    //   956	1062	1534	java/lang/NoSuchFieldException
    //   1062	1077	1534	java/lang/NoSuchFieldException
    //   1084	1115	1534	java/lang/NoSuchFieldException
    //   1203	1234	1534	java/lang/NoSuchFieldException
    //   1322	1330	1534	java/lang/NoSuchFieldException
    //   1418	1521	1534	java/lang/NoSuchFieldException
    //   1524	1531	1534	java/lang/NoSuchFieldException
    //   1619	1651	1534	java/lang/NoSuchFieldException
    //   1658	1683	1534	java/lang/NoSuchFieldException
    //   1683	1694	1534	java/lang/NoSuchFieldException
    //   1707	1741	1534	java/lang/NoSuchFieldException
    //   1754	1843	1534	java/lang/NoSuchFieldException
    //   1850	1882	1534	java/lang/NoSuchFieldException
    //   1970	2002	1534	java/lang/NoSuchFieldException
    //   2065	2073	1534	java/lang/NoSuchFieldException
    //   2076	2183	1534	java/lang/NoSuchFieldException
    //   2186	2193	1534	java/lang/NoSuchFieldException
    //   2196	2303	1534	java/lang/NoSuchFieldException
    //   2305	2331	1534	java/lang/NoSuchFieldException
    //   2336	2343	1534	java/lang/NoSuchFieldException
    //   2350	2375	1534	java/lang/NoSuchFieldException
    //   909	943	1654	java/lang/RuntimeException
    //   956	1062	1654	java/lang/RuntimeException
    //   1062	1077	1654	java/lang/RuntimeException
    //   1619	1651	1654	java/lang/RuntimeException
    //   1850	1882	1654	java/lang/RuntimeException
    //   1970	2002	1654	java/lang/RuntimeException
    //   2065	2073	1654	java/lang/RuntimeException
    //   2076	2183	1654	java/lang/RuntimeException
    //   2186	2193	1654	java/lang/RuntimeException
    //   234	421	1885	java/lang/ClassNotFoundException
    //   431	451	1885	java/lang/ClassNotFoundException
    //   459	522	1885	java/lang/ClassNotFoundException
    //   547	606	1885	java/lang/ClassNotFoundException
    //   606	615	1885	java/lang/ClassNotFoundException
    //   620	640	1885	java/lang/ClassNotFoundException
    //   653	687	1885	java/lang/ClassNotFoundException
    //   700	805	1885	java/lang/ClassNotFoundException
    //   805	819	1885	java/lang/ClassNotFoundException
    //   822	853	1885	java/lang/ClassNotFoundException
    //   860	885	1885	java/lang/ClassNotFoundException
    //   885	896	1885	java/lang/ClassNotFoundException
    //   909	943	1885	java/lang/ClassNotFoundException
    //   956	1062	1885	java/lang/ClassNotFoundException
    //   1062	1077	1885	java/lang/ClassNotFoundException
    //   1084	1115	1885	java/lang/ClassNotFoundException
    //   1203	1234	1885	java/lang/ClassNotFoundException
    //   1322	1330	1885	java/lang/ClassNotFoundException
    //   1418	1521	1885	java/lang/ClassNotFoundException
    //   1524	1531	1885	java/lang/ClassNotFoundException
    //   1619	1651	1885	java/lang/ClassNotFoundException
    //   1658	1683	1885	java/lang/ClassNotFoundException
    //   1683	1694	1885	java/lang/ClassNotFoundException
    //   1707	1741	1885	java/lang/ClassNotFoundException
    //   1754	1843	1885	java/lang/ClassNotFoundException
    //   1850	1882	1885	java/lang/ClassNotFoundException
    //   1970	2002	1885	java/lang/ClassNotFoundException
    //   2065	2073	1885	java/lang/ClassNotFoundException
    //   2076	2183	1885	java/lang/ClassNotFoundException
    //   2186	2193	1885	java/lang/ClassNotFoundException
    //   2196	2303	1885	java/lang/ClassNotFoundException
    //   2305	2331	1885	java/lang/ClassNotFoundException
    //   2336	2343	1885	java/lang/ClassNotFoundException
    //   2350	2375	1885	java/lang/ClassNotFoundException
    //   234	421	2005	finally
    //   431	451	2005	finally
    //   459	522	2005	finally
    //   547	606	2005	finally
    //   606	615	2005	finally
    //   620	640	2005	finally
    //   653	687	2005	finally
    //   700	805	2005	finally
    //   805	819	2005	finally
    //   822	853	2005	finally
    //   860	885	2005	finally
    //   885	896	2005	finally
    //   909	943	2005	finally
    //   956	1062	2005	finally
    //   1062	1077	2005	finally
    //   1084	1115	2005	finally
    //   1120	1145	2005	finally
    //   1203	1234	2005	finally
    //   1239	1264	2005	finally
    //   1322	1330	2005	finally
    //   1335	1360	2005	finally
    //   1418	1521	2005	finally
    //   1524	1531	2005	finally
    //   1536	1561	2005	finally
    //   1619	1651	2005	finally
    //   1658	1683	2005	finally
    //   1683	1694	2005	finally
    //   1707	1741	2005	finally
    //   1754	1843	2005	finally
    //   1850	1882	2005	finally
    //   1887	1912	2005	finally
    //   1970	2002	2005	finally
    //   2065	2073	2005	finally
    //   2076	2183	2005	finally
    //   2186	2193	2005	finally
    //   2196	2303	2005	finally
    //   2305	2331	2005	finally
    //   2336	2343	2005	finally
    //   2350	2375	2005	finally
    //   2457	2482	2005	finally
    //   1707	1741	2346	java/lang/RuntimeException
    //   1754	1843	2346	java/lang/RuntimeException
    //   2196	2303	2346	java/lang/RuntimeException
    //   2336	2343	2346	java/lang/RuntimeException
    //   234	421	2455	java/lang/RuntimeException
    //   431	451	2455	java/lang/RuntimeException
    //   459	522	2455	java/lang/RuntimeException
    //   547	606	2455	java/lang/RuntimeException
    //   606	615	2455	java/lang/RuntimeException
    //   620	640	2455	java/lang/RuntimeException
    //   860	885	2455	java/lang/RuntimeException
    //   885	896	2455	java/lang/RuntimeException
    //   1658	1683	2455	java/lang/RuntimeException
    //   1683	1694	2455	java/lang/RuntimeException
    //   2305	2331	2455	java/lang/RuntimeException
    //   2350	2375	2455	java/lang/RuntimeException
  }
  
  private static int getSoftMaxSamples(int paramInt)
  {
    switch (paramInt)
    {
    case 11: 
    default: 
      return 407040;
    case 1: 
      return 129600;
    case 6: 
      return 307200;
    case 16: 
      return 480000;
    case 21: 
      return 921600;
    case 26: 
      return 2073600;
    case 28: 
      return 8294400;
    }
    return 8847360;
  }
  
  public static HashMap<Integer, TPCodecCapability.TPVCodecMaxCapability> getVCodecSWMaxCapabilityMap()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(222670);
        TPNativeLog.printLog(2, "TPCodecUtils", "getVCodecSWMaxCapabilityMap func in");
        if (mIsFFmpegCapGot)
        {
          localHashMap = mMaxVCodecSwCapabilityMap;
          AppMethodBeat.o(222670);
          return localHashMap;
        }
      }
      finally
      {
        try
        {
          int i = getHevcSWDecodeLevel();
          int j = getSoftMaxSamples(i);
          int k = getAvs3SWDecodeLevel();
          int m = getSoftMaxSamples(k);
          TPNativeLog.printLog(2, "getVCodecSWMaxCapabilityMap hevcDecodeLevel:" + i + " avs3DecodeLevel:" + k);
          mAVCSWMaxCapability.maxLumaSamples = j;
          mAVCSWMaxCapability.maxProfile = 64;
          mAVCSWMaxCapability.maxLevel = 65536;
          mMaxVCodecSwCapabilityMap.put(Integer.valueOf(26), mAVCSWMaxCapability);
          mffmpegVCodecCapList.add("video/avc");
          mHEVCSWMaxCapability.maxLumaSamples = j;
          mHEVCSWMaxCapability.maxProfile = 2;
          mHEVCSWMaxCapability.maxLevel = 33554432;
          mMaxVCodecSwCapabilityMap.put(Integer.valueOf(172), mHEVCSWMaxCapability);
          mffmpegVCodecCapList.add("video/hevc");
          mVP9SWMaxCapability.maxLumaSamples = j;
          mVP9SWMaxCapability.maxProfile = 8;
          mVP9SWMaxCapability.maxLevel = 8192;
          mMaxVCodecSwCapabilityMap.put(Integer.valueOf(166), mVP9SWMaxCapability);
          mffmpegVCodecCapList.add("video/x-vnd.on2.vp9");
          mAVS3WMaxCapability.maxLumaSamples = m;
          mAVS3WMaxCapability.maxProfile = 0;
          mAVS3WMaxCapability.maxLevel = 0;
          mMaxVCodecSwCapabilityMap.put(Integer.valueOf(192), mAVS3WMaxCapability);
          TPNativeLog.printLog(2, "getVCodecSWMaxCapabilityMap success, maxHevcLumaSamples:" + j + " maxAvs3LumaSamples:" + m);
          mIsFFmpegCapGot = true;
          HashMap localHashMap = mMaxVCodecSwCapabilityMap;
          AppMethodBeat.o(222670);
        }
        catch (Exception localException)
        {
          TPNativeLog.printLog(4, "TPCodecUtils", "getVCodecSWMaxCapabilityMap exception");
          Object localObject2 = null;
          AppMethodBeat.o(222670);
        }
        localObject1 = finally;
      }
    }
  }
  
  /* Error */
  public static void init(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 745
    //   6: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: iconst_2
    //   10: ldc 34
    //   12: ldc_w 747
    //   15: iload_1
    //   16: invokestatic 750	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   19: invokevirtual 591	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   22: invokestatic 247	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   25: aload_0
    //   26: invokevirtual 756	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   29: putstatic 111	com/tencent/thumbplayer/core/common/TPCodecUtils:mApplicationContext	Landroid/content/Context;
    //   32: iload_1
    //   33: putstatic 113	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsLocalCacheEnabled	Z
    //   36: iload_1
    //   37: ifeq +37 -> 74
    //   40: getstatic 150	com/tencent/thumbplayer/core/common/TPCodecUtils:mCapabilityVersionKey	Ljava/lang/String;
    //   43: invokestatic 758	com/tencent/thumbplayer/core/common/TPCodecUtils:getCachedStringInfo	(Ljava/lang/String;)Ljava/lang/String;
    //   46: astore_0
    //   47: getstatic 121	com/tencent/thumbplayer/core/common/TPCodecUtils:mCapabilityVersion	Ljava/lang/String;
    //   50: aload_0
    //   51: invokevirtual 761	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   54: ifne +48 -> 102
    //   57: iconst_1
    //   58: putstatic 115	com/tencent/thumbplayer/core/common/TPCodecUtils:mNeedToReprobeDecoderCapability	Z
    //   61: iconst_1
    //   62: putstatic 117	com/tencent/thumbplayer/core/common/TPCodecUtils:mNeedToReprobeHDRCapability	Z
    //   65: iconst_2
    //   66: ldc 34
    //   68: ldc_w 763
    //   71: invokestatic 247	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   74: invokestatic 765	com/tencent/thumbplayer/core/common/TPCodecUtils:getDecoderMaxCapabilityMapAsync	()V
    //   77: getstatic 113	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsLocalCacheEnabled	Z
    //   80: ifeq +12 -> 92
    //   83: getstatic 150	com/tencent/thumbplayer/core/common/TPCodecUtils:mCapabilityVersionKey	Ljava/lang/String;
    //   86: getstatic 121	com/tencent/thumbplayer/core/common/TPCodecUtils:mCapabilityVersion	Ljava/lang/String;
    //   89: invokestatic 767	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheStringInfo	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: ldc_w 745
    //   95: invokestatic 277	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   98: ldc 2
    //   100: monitorexit
    //   101: return
    //   102: iconst_0
    //   103: putstatic 115	com/tencent/thumbplayer/core/common/TPCodecUtils:mNeedToReprobeDecoderCapability	Z
    //   106: iconst_0
    //   107: putstatic 117	com/tencent/thumbplayer/core/common/TPCodecUtils:mNeedToReprobeHDRCapability	Z
    //   110: iconst_2
    //   111: ldc 34
    //   113: ldc_w 769
    //   116: invokestatic 247	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
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
    AppMethodBeat.i(222703);
    boolean bool1 = isHwDDPlusSupported_V2();
    boolean bool2 = isHwDolbyDSSupported();
    if ((!bool2) && (!bool1))
    {
      sDolbyLevel = 0;
      AppMethodBeat.o(222703);
      return;
    }
    if ((bool1) && (!bool2))
    {
      sDolbyLevel = 1;
      AppMethodBeat.o(222703);
      return;
    }
    if ((!bool1) && (bool2))
    {
      sDolbyLevel = 10;
      AppMethodBeat.o(222703);
      return;
    }
    if ((bool2) && (bool1)) {
      sDolbyLevel = 11;
    }
    AppMethodBeat.o(222703);
  }
  
  public static boolean isBlackListForHardwareDec(String paramString)
  {
    AppMethodBeat.i(222685);
    if (mIsInBlackListForHardwareDec != -1)
    {
      if (mIsInBlackListForHardwareDec == 0)
      {
        AppMethodBeat.o(222685);
        return false;
      }
      AppMethodBeat.o(222685);
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
            AppMethodBeat.o(222685);
            return true;
          }
          i += 1;
        }
      }
      if ((!TextUtils.isEmpty(paramString)) && ("video/hevc".equals(paramString)) && (Build.VERSION.SDK_INT >= 14) && (!TextUtils.isEmpty(str)) && (("PRO 7 Plus".equals(str)) || ("PRO 7-H".equals(str)) || ("PRO+7+Plus".equals(str))))
      {
        mIsInBlackListForHardwareDec = 1;
        AppMethodBeat.o(222685);
        return true;
      }
    }
    catch (Exception paramString)
    {
      TPNativeLog.printLog(4, "TPCodecUtils", "isBlackListForHardwareDec exception");
      AppMethodBeat.o(222685);
    }
    return false;
  }
  
  public static boolean isBlackListForHdr10(String paramString)
  {
    AppMethodBeat.i(222754);
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
            AppMethodBeat.o(222754);
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
      AppMethodBeat.o(222754);
    }
  }
  
  public static boolean isBlackListForHdr10Enhance(String paramString)
  {
    AppMethodBeat.i(222761);
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
            AppMethodBeat.o(222761);
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
      AppMethodBeat.o(222761);
    }
  }
  
  public static boolean isBlackListForVidHdr10Enhance(String paramString1, String paramString2)
  {
    AppMethodBeat.i(222756);
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
            AppMethodBeat.o(222756);
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
      AppMethodBeat.o(222756);
    }
  }
  
  public static boolean isHDR10PLUSSupport()
  {
    AppMethodBeat.i(222741);
    if (Build.VERSION.SDK_INT < 29)
    {
      AppMethodBeat.o(222741);
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
                  AppMethodBeat.o(222741);
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
      AppMethodBeat.o(222741);
      return false;
    }
    AppMethodBeat.o(222741);
    return false;
  }
  
  public static boolean isHDR10Support()
  {
    AppMethodBeat.i(222738);
    if (Build.VERSION.SDK_INT < 24)
    {
      AppMethodBeat.o(222738);
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
                  AppMethodBeat.o(222738);
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
      AppMethodBeat.o(222738);
      return false;
    }
    AppMethodBeat.o(222738);
    return false;
  }
  
  public static boolean isHDRDolbyVisionSupport(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(222748);
    if (Build.VERSION.SDK_INT < 24)
    {
      AppMethodBeat.o(222748);
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
                  AppMethodBeat.o(222748);
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
      AppMethodBeat.o(222748);
      return false;
    }
    AppMethodBeat.o(222748);
    return false;
  }
  
  public static boolean isHDRHLGSupport(int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public static boolean isHDRsupport(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(222735);
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool6 = false;
    boolean bool2 = false;
    boolean bool5 = false;
    boolean bool1 = false;
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(222735);
      return false;
    case 0: 
      if (Build.VERSION.SDK_INT < 24)
      {
        AppMethodBeat.o(222735);
        return false;
      }
      break;
    case 1: 
      if (Build.VERSION.SDK_INT < 29)
      {
        AppMethodBeat.o(222735);
        return false;
      }
      break;
    case 2: 
      if (Build.VERSION.SDK_INT < 24)
      {
        AppMethodBeat.o(222735);
        return false;
      }
      break;
    case 3: 
      AppMethodBeat.o(222735);
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
            AppMethodBeat.o(222735);
            return true;
            str = mHDR10CapabilityKey;
            continue;
            str = mHDR10PLUSCapabilityKey;
            continue;
            str = mHDRDOLBYVISIONCapabilityKey;
            continue;
            str = mHDRHLGCapabilityKey;
          }
          AppMethodBeat.o(222735);
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
            AppMethodBeat.o(222735);
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
    AppMethodBeat.i(222701);
    boolean bool1;
    if (sIsDDPInit)
    {
      bool1 = sIsDDPSup;
      AppMethodBeat.o(222701);
      return bool1;
    }
    if (isBlackListForHardwareDec(null))
    {
      sIsDDPInit = true;
      sIsDDPSup = false;
      AppMethodBeat.o(222701);
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
      AppMethodBeat.o(222701);
      return bool1;
      label276:
      label279:
      bool2 = bool1;
    }
  }
  
  public static boolean isHwDDPlusSupported_V2()
  {
    boolean bool1 = false;
    AppMethodBeat.i(222686);
    if (isBlackListForHardwareDec(null))
    {
      sIsDDPSup = false;
      AppMethodBeat.o(222686);
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
    AppMethodBeat.o(222686);
    return bool1;
  }
  
  public static boolean isHwDolbyDSSupported()
  {
    AppMethodBeat.i(222694);
    boolean bool;
    if (sIsDDSInit)
    {
      if (sIsDDSSup) {
        TPNativeLog.printLog(2, "TPCodecUtils", "dds ha suported " + sIsDDSSup);
      }
      bool = sIsDDSSup;
      AppMethodBeat.o(222694);
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
        AppMethodBeat.o(222694);
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
    AppMethodBeat.i(222673);
    if ((mHWCodecCapList != null) && (mHWCodecCapList.size() > 0) && ((mHWCodecCapList.contains("audio/eac3")) || (mHWCodecCapList.contains("audio/ac3"))))
    {
      AppMethodBeat.o(222673);
      return true;
    }
    if ((mSoftCodecCapList != null) && (mSoftCodecCapList.size() > 0) && ((mSoftCodecCapList.contains("audio/eac3")) || (mSoftCodecCapList.contains("audio/ac3"))))
    {
      AppMethodBeat.o(222673);
      return true;
    }
    AppMethodBeat.o(222673);
    return false;
  }
  
  public static boolean isInMediaCodecWhiteList(String paramString, int paramInt1, int paramInt2)
  {
    boolean bool = true;
    AppMethodBeat.i(222680);
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
      AppMethodBeat.o(222680);
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
          AppMethodBeat.o(222680);
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
    AppMethodBeat.i(222759);
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
            AppMethodBeat.o(222759);
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
      AppMethodBeat.o(222759);
    }
  }
  
  public static boolean isWhiteListForHdr10Enhance(String paramString)
  {
    AppMethodBeat.i(222763);
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
            AppMethodBeat.o(222763);
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
      AppMethodBeat.o(222763);
    }
  }
  
  private static int maxLumaSamplesForAVCProfileLevel(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(222551);
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
      AppMethodBeat.o(222551);
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
    AppMethodBeat.i(222581);
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
      AppMethodBeat.o(222581);
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
    AppMethodBeat.i(222604);
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
      AppMethodBeat.o(222604);
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
    AppMethodBeat.i(222532);
    if (paramHashMap.containsKey(paramK))
    {
      paramHashMap.remove(paramK);
      paramHashMap.put(paramK, paramT);
      AppMethodBeat.o(222532);
      return;
    }
    paramHashMap.put(paramK, paramT);
    AppMethodBeat.o(222532);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPCodecUtils
 * JD-Core Version:    0.7.0.1
 */