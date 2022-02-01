package com.tencent.thumbplayer.core.common;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.thirdparties.LocalCache;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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
  private static TPCodecCapability.TPVCodecMaxCapability mAVCSWMaxCapability;
  private static TPCodecCapability.TPVCodecMaxCapability mAVS3WMaxCapability;
  private static int mAvs3DeviceLevel;
  private static ArrayList<String> mBlackListModel;
  private static HashMap<String, Integer> mCodecCap;
  protected static ArrayList<String> mCodecCapList;
  private static Context mContext;
  private static HashMap<String, TPMediaDecoderInfo> mDecoderInfoMap;
  private static int mFhdAvs3HisiIndex;
  private static int mFhdAvs3QualcommIndex;
  private static TPCodecCapability.TPVCodecMaxCapability mHEVCSWMaxCapability;
  private static int mHdHevcHisiIndex;
  private static int mHdHevcMtkIndex;
  private static int mHdHevcQualcommIndex;
  private static int mHdHevcSumsingIndex;
  private static int mHevcDeviceLevel;
  private static boolean mIsFFmpegCapGot;
  private static boolean mIsInitDone;
  private static boolean mIsMediaCodecCapGot;
  private static LocalCache mLocalCache;
  private static HashMap<Integer, TPCodecCapability.TPVCodecMaxCapability> mMaxVCodecHwCapabilityMap;
  private static HashMap<Integer, TPCodecCapability.TPVCodecMaxCapability> mMaxVCodecSwCapabilityMap;
  private static int mShdAvs3QualcommIndex;
  private static int mShdHevcHisiIndex;
  private static int mShdHevcMtkIndex;
  private static int mShdHevcQualcommIndex;
  private static int mShdHevcSumsingIndex;
  protected static ArrayList<String> mSoftCodecCapList;
  private static ArrayList<String> mSupportedHWCodec;
  private static TPCodecCapability.TPVCodecMaxCapability mVP9SWMaxCapability;
  protected static ArrayList<String> mffmpegVCodecCapList;
  
  static
  {
    AppMethodBeat.i(228076);
    mHevcDeviceLevel = -1;
    mAvs3DeviceLevel = -1;
    mCodecCap = null;
    mContext = null;
    mLocalCache = null;
    mCodecCapList = new ArrayList();
    mSoftCodecCapList = new ArrayList();
    mffmpegVCodecCapList = new ArrayList();
    mBlackListModel = new ArrayList();
    mSupportedHWCodec = new ArrayList();
    mIsInitDone = false;
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
    mSupportedHWCodec.add("video/avc");
    mSupportedHWCodec.add("video/hevc");
    mSupportedHWCodec.add("video/x-vnd.on2.vp9");
    mBlackListModel.add("SM-J7008");
    mBlackListModel.add("SM-J5008");
    mBlackListModel.add("TCL i806");
    mBlackListModel.add("NX511J");
    mBlackListModel.add("vivo Y11i T");
    mBlackListModel.add("长虹智能电视");
    mBlackListModel.add("MI 1S");
    mBlackListModel.add("SP9832A");
    mBlackListModel.add("SP9830A");
    mBlackListModel.add("VOTO GT17");
    mBlackListModel.add("EVA-AL10");
    mIsMediaCodecCapGot = false;
    mIsFFmpegCapGot = false;
    mAVCSWMaxCapability = new TPCodecCapability.TPVCodecMaxCapability(0, 0, 0, 30);
    mHEVCSWMaxCapability = new TPCodecCapability.TPVCodecMaxCapability(0, 0, 0, 30);
    mVP9SWMaxCapability = new TPCodecCapability.TPVCodecMaxCapability(0, 0, 0, 30);
    mAVS3WMaxCapability = new TPCodecCapability.TPVCodecMaxCapability(0, 0, 0, 30);
    mMaxVCodecHwCapabilityMap = new HashMap();
    mMaxVCodecSwCapabilityMap = new HashMap();
    mDecoderInfoMap = new HashMap();
    AppMethodBeat.o(228076);
  }
  
  public static int convertDolbyVisionToOmxProfile(int paramInt)
  {
    AppMethodBeat.i(228057);
    int i = 1 << paramInt;
    if ((paramInt > 0) && (paramInt <= 512))
    {
      TPNativeLog.printLog(2, "TPCodecUtils", "convertDolbyVisionToOmxProfile dolbyVisionProfile:" + paramInt + " omxProfile:" + i);
      AppMethodBeat.o(228057);
      return i;
    }
    TPNativeLog.printLog(2, "TPCodecUtils", "convertDolbyVisionToOmxProfile Unsupported profile".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(228057);
    return paramInt;
  }
  
  public static boolean getAudioMediaCodecPassThroughCap(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(227966);
    if (paramInt1 != 5004)
    {
      AppMethodBeat.o(227966);
      return false;
    }
    paramInt1 = 1;
    if (paramInt2 == 20) {}
    for (paramInt1 = 7;; paramInt1 = 8) {
      do
      {
        boolean bool = TPAudioPassThroughPluginDetector.isAudioPassThroughSupport(paramInt1, paramInt3);
        AppMethodBeat.o(227966);
        return bool;
      } while ((paramInt2 != 50) && (paramInt2 != 60));
    }
  }
  
  public static int getAvs3SWDecodeLevel()
  {
    AppMethodBeat.i(227831);
    String str = TPSystemInfo.getCpuHarewareName();
    int i = TPSystemInfo.getCpuHWProducter(str);
    int j = TPSystemInfo.getCpuHWProductIndex(str);
    TPNativeLog.printLog(2, "TPCodecUtils", "[getAvs3SWDecodeLevel], mCpuHWProducter = " + i + ", getMaxCpuFreq() = " + TPSystemInfo.getMaxCpuFreq() + ", numCores = " + TPSystemInfo.getNumCores() + ", mCpuHWProductIdx=" + j + ", hardware=" + str);
    if (-1 != mAvs3DeviceLevel)
    {
      i = mAvs3DeviceLevel;
      AppMethodBeat.o(227831);
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
      AppMethodBeat.o(227831);
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
  
  private static int getDecodeLevelByCoresAndFreq()
  {
    int i = 21;
    AppMethodBeat.i(227837);
    if (TPSystemInfo.getNumCores() >= 8) {
      if (TPSystemInfo.getMaxCpuFreq() / 1000L < 1200L) {}
    }
    for (;;)
    {
      AppMethodBeat.o(227837);
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
    //   3: ldc_w 314
    //   6: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 111	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsInitDone	Z
    //   12: ifeq +22 -> 34
    //   15: iconst_2
    //   16: ldc 34
    //   18: ldc_w 316
    //   21: invokestatic 164	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   24: ldc_w 314
    //   27: invokestatic 218	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: ldc 2
    //   32: monitorexit
    //   33: return
    //   34: iconst_2
    //   35: ldc 34
    //   37: ldc_w 318
    //   40: invokestatic 164	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   43: new 320	java/lang/Thread
    //   46: dup
    //   47: new 6	com/tencent/thumbplayer/core/common/TPCodecUtils$1
    //   50: dup
    //   51: invokespecial 321	com/tencent/thumbplayer/core/common/TPCodecUtils$1:<init>	()V
    //   54: invokespecial 324	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   57: astore_0
    //   58: aload_0
    //   59: ldc_w 326
    //   62: invokevirtual 329	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   65: aload_0
    //   66: invokevirtual 332	java/lang/Thread:start	()V
    //   69: ldc_w 314
    //   72: invokestatic 218	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static String getDecoderName(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(228041);
    TPMediaDecoderInfo[] arrayOfTPMediaDecoderInfo = TPMediaDecoderList.getTPMediaDecoderInfos(mLocalCache);
    int j = arrayOfTPMediaDecoderInfo.length;
    int i = 0;
    while (i < j)
    {
      TPMediaDecoderInfo localTPMediaDecoderInfo = arrayOfTPMediaDecoderInfo[i];
      if ((TextUtils.equals(paramString, localTPMediaDecoderInfo.getDecoderMimeType())) && (localTPMediaDecoderInfo.isSecureDecoder() == paramBoolean))
      {
        TPNativeLog.printLog(2, "TPCodecUtils", "getDecoderName:" + localTPMediaDecoderInfo.getDecoderName());
        paramString = localTPMediaDecoderInfo.getDecoderName();
        AppMethodBeat.o(228041);
        return paramString;
      }
      i += 1;
    }
    AppMethodBeat.o(228041);
    return null;
  }
  
  public static String getDolbyVisionDecoderName(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(228051);
    if ((Build.VERSION.SDK_INT < 21) || (!TextUtils.equals("video/dolby-vision", paramString)))
    {
      AppMethodBeat.o(228051);
      return null;
    }
    int j = convertDolbyVisionToOmxProfile(paramInt1);
    TPMediaDecoderInfo[] arrayOfTPMediaDecoderInfo = TPMediaDecoderList.getTPMediaDecoderInfos(mLocalCache);
    int k = arrayOfTPMediaDecoderInfo.length;
    paramInt2 = 0;
    while (paramInt2 < k)
    {
      TPMediaDecoderInfo localTPMediaDecoderInfo = arrayOfTPMediaDecoderInfo[paramInt2];
      TPMediaDecoderInfo.DecoderProfileLevel[] arrayOfDecoderProfileLevel = localTPMediaDecoderInfo.getProfileLevels();
      if (TextUtils.equals(localTPMediaDecoderInfo.getDecoderMimeType(), paramString))
      {
        int m = arrayOfDecoderProfileLevel.length;
        int i = 0;
        while (i < m)
        {
          TPMediaDecoderInfo.DecoderProfileLevel localDecoderProfileLevel = arrayOfDecoderProfileLevel[i];
          if (localDecoderProfileLevel.profile == j)
          {
            TPNativeLog.printLog(2, "TPCodecUtils", "getDolbyVisionDecoderName  profile:" + localDecoderProfileLevel.profile + " dvProfile:" + paramInt1 + " bSecure:" + paramBoolean + " name:" + localTPMediaDecoderInfo.getDecoderName());
            if (localTPMediaDecoderInfo.isSecureDecoder() == paramBoolean)
            {
              paramString = localTPMediaDecoderInfo.getDecoderName();
              AppMethodBeat.o(228051);
              return paramString;
            }
          }
          i += 1;
        }
      }
      paramInt2 += 1;
    }
    AppMethodBeat.o(228051);
    return null;
  }
  
  public static int getHevcSWDecodeLevel()
  {
    AppMethodBeat.i(227823);
    String str = TPSystemInfo.getCpuHarewareName();
    int i = TPSystemInfo.getCpuHWProducter(str);
    int j = TPSystemInfo.getCpuHWProductIndex(str);
    TPNativeLog.printLog(2, "TPCodecUtils", "[getHevcSWDecodeLevel], mCpuHWProducter = " + i + ", getMaxCpuFreq() = " + TPSystemInfo.getMaxCpuFreq() + ", numCores = " + TPSystemInfo.getNumCores() + ", mCpuHWProductIdx=" + j + ", hardware=" + str);
    if (-1 != mHevcDeviceLevel)
    {
      i = mHevcDeviceLevel;
      AppMethodBeat.o(227823);
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
      AppMethodBeat.o(227823);
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
  
  public static int getMaxLumaSample(String paramString, int paramInt)
  {
    AppMethodBeat.i(228002);
    if (TextUtils.equals(paramString, "video/avc"))
    {
      paramInt = TPMediaCodecProfileLevel.getAVCMaxLumaSample(paramInt);
      AppMethodBeat.o(228002);
      return paramInt;
    }
    if (TextUtils.equals(paramString, "video/hevc"))
    {
      paramInt = TPMediaCodecProfileLevel.getHEVCMaxLumaSample(paramInt);
      AppMethodBeat.o(228002);
      return paramInt;
    }
    if (TextUtils.equals(paramString, "video/x-vnd.on2.vp9"))
    {
      paramInt = TPMediaCodecProfileLevel.getVP9MaxLumaSample(paramInt);
      AppMethodBeat.o(228002);
      return paramInt;
    }
    AppMethodBeat.o(228002);
    return 0;
  }
  
  public static int getMaxSupportedFrameRatesFor(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    for (;;)
    {
      String str;
      try
      {
        AppMethodBeat.i(228014);
        if ((Build.VERSION.SDK_INT < 21) || (paramInt1 == 101) || (paramInt1 == -1))
        {
          paramInt1 = 30;
          AppMethodBeat.o(228014);
          return paramInt1;
        }
        str = getSupportedHWMimeType(paramInt2);
        if (str.isEmpty())
        {
          paramInt1 = 30;
          AppMethodBeat.o(228014);
          continue;
        }
        localInteger = Integer.valueOf(30);
      }
      finally {}
      Integer localInteger;
      Object localObject2 = localInteger;
      try
      {
        arrayOfTPMediaDecoderInfo = TPMediaDecoderList.getTPMediaDecoderInfos(mLocalCache);
        localObject2 = localInteger;
        paramInt2 = arrayOfTPMediaDecoderInfo.length;
        paramInt1 = 0;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          TPMediaDecoderInfo[] arrayOfTPMediaDecoderInfo;
          TPMediaDecoderInfo localTPMediaDecoderInfo;
          int i;
          int j;
          int k;
          int m;
          TPNativeLog.printLog(4, "TPCodecUtils", "getMaxSupportedFrameRatesFor failed:" + localException.getMessage());
          continue;
          if (paramInt3 < paramInt4) {
            if (paramInt3 <= i) {
              if (paramInt4 > paramInt2)
              {
                continue;
                paramInt1 += 1;
              }
            }
          }
        }
      }
      localObject2 = localInteger;
      if (paramInt1 < paramInt2)
      {
        localTPMediaDecoderInfo = arrayOfTPMediaDecoderInfo[paramInt1];
        localObject2 = localInteger;
        if (!str.equals(localTPMediaDecoderInfo.getDecoderMimeType())) {
          break label467;
        }
        localObject2 = localInteger;
        paramInt1 = localTPMediaDecoderInfo.getDecoderMaxWidth();
        localObject2 = localInteger;
        paramInt2 = localTPMediaDecoderInfo.getDecoderMaxHeight();
        localObject2 = localInteger;
        i = localTPMediaDecoderInfo.getDecoderLumaWidth();
        localObject2 = localInteger;
        j = localTPMediaDecoderInfo.getDecoderLumaHeight();
        localObject2 = localInteger;
        k = localTPMediaDecoderInfo.getDecoderMaxFrameRateForMaxLuma();
        localObject2 = localInteger;
        m = localTPMediaDecoderInfo.getDecoderMaxFrameRate();
        if ((paramInt3 <= paramInt4) || ((paramInt3 <= paramInt1) && (paramInt4 <= j))) {
          break;
        }
        localObject2 = localInteger;
        TPNativeLog.printLog(4, "TPCodecUtils", "disable width:" + paramInt3 + " height:" + paramInt4 + " do not support! maxWidth:" + paramInt1 + " maxHeight:" + paramInt2);
        localObject2 = localInteger;
        localInteger = Integer.valueOf(Math.min(m, Math.max(1, (int)(paramInt1 * j * 1L / Math.max(paramInt3 * paramInt4 * 1L, 1L)) * k)));
        localObject2 = localInteger;
        TPNativeLog.printLog(2, "TPCodecUtils", "getSupportedFrameRatesFor max width:" + paramInt1 + " max height:" + j + " max framerate for max resolution:" + k + " current width:" + paramInt3 + " height:" + paramInt4 + " max support framerate:" + localInteger);
        localObject2 = localInteger;
      }
      paramInt1 = localObject2.intValue();
      AppMethodBeat.o(228014);
    }
  }
  
  /* Error */
  public static HashMap<Integer, TPCodecCapability.TPVCodecMaxCapability> getMediaCodecMaxCapabilityMap()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 485
    //   6: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: iconst_2
    //   10: ldc 34
    //   12: ldc_w 487
    //   15: invokestatic 164	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   18: getstatic 211	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   21: invokevirtual 488	java/util/HashMap:isEmpty	()Z
    //   24: ifne +27 -> 51
    //   27: iconst_2
    //   28: ldc 34
    //   30: ldc_w 490
    //   33: invokestatic 164	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   36: getstatic 211	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   39: astore_2
    //   40: ldc_w 485
    //   43: invokestatic 218	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: ldc 2
    //   48: monitorexit
    //   49: aload_2
    //   50: areturn
    //   51: getstatic 94	com/tencent/thumbplayer/core/common/TPCodecUtils:mLocalCache	Lcom/tencent/thumbplayer/core/thirdparties/LocalCache;
    //   54: invokestatic 341	com/tencent/thumbplayer/core/common/TPMediaDecoderList:getTPMediaDecoderInfos	(Lcom/tencent/thumbplayer/core/thirdparties/LocalCache;)[Lcom/tencent/thumbplayer/core/common/TPMediaDecoderInfo;
    //   57: astore_2
    //   58: aload_2
    //   59: arraylength
    //   60: istore_1
    //   61: iconst_0
    //   62: istore_0
    //   63: iload_0
    //   64: iload_1
    //   65: if_icmpge +221 -> 286
    //   68: aload_2
    //   69: iload_0
    //   70: aaload
    //   71: astore_3
    //   72: aload_3
    //   73: invokevirtual 346	com/tencent/thumbplayer/core/common/TPMediaDecoderInfo:getDecoderMimeType	()Ljava/lang/String;
    //   76: astore 4
    //   78: getstatic 101	com/tencent/thumbplayer/core/common/TPCodecUtils:mCodecCapList	Ljava/util/ArrayList;
    //   81: aload 4
    //   83: invokevirtual 170	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   86: pop
    //   87: iconst_2
    //   88: ldc 34
    //   90: new 227	java/lang/StringBuilder
    //   93: dup
    //   94: ldc_w 492
    //   97: invokespecial 232	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   100: aload 4
    //   102: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: ldc_w 494
    //   108: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload_3
    //   112: invokevirtual 360	com/tencent/thumbplayer/core/common/TPMediaDecoderInfo:getDecoderName	()Ljava/lang/String;
    //   115: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: invokestatic 164	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   124: aload 4
    //   126: invokestatic 498	com/tencent/thumbplayer/core/common/TPCodecUtils:isSupportedHWCodec	(Ljava/lang/String;)Z
    //   129: ifeq +123 -> 252
    //   132: aload_3
    //   133: invokevirtual 356	com/tencent/thumbplayer/core/common/TPMediaDecoderInfo:isSecureDecoder	()Z
    //   136: ifne +116 -> 252
    //   139: aload_3
    //   140: invokevirtual 502	com/tencent/thumbplayer/core/common/TPMediaDecoderInfo:getMaxProfileLevel	()Lcom/tencent/thumbplayer/core/common/TPMediaDecoderInfo$DecoderProfileLevel;
    //   143: astore 5
    //   145: new 198	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability
    //   148: dup
    //   149: aload 4
    //   151: aload 5
    //   153: getfield 505	com/tencent/thumbplayer/core/common/TPMediaDecoderInfo$DecoderProfileLevel:level	I
    //   156: invokestatic 507	com/tencent/thumbplayer/core/common/TPCodecUtils:getMaxLumaSample	(Ljava/lang/String;I)I
    //   159: aload 5
    //   161: getfield 381	com/tencent/thumbplayer/core/common/TPMediaDecoderInfo$DecoderProfileLevel:profile	I
    //   164: aload 5
    //   166: getfield 505	com/tencent/thumbplayer/core/common/TPMediaDecoderInfo$DecoderProfileLevel:level	I
    //   169: aload_3
    //   170: invokevirtual 438	com/tencent/thumbplayer/core/common/TPMediaDecoderInfo:getDecoderMaxFrameRateForMaxLuma	()I
    //   173: invokespecial 201	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:<init>	(IIII)V
    //   176: astore 6
    //   178: iconst_2
    //   179: ldc 34
    //   181: new 227	java/lang/StringBuilder
    //   184: dup
    //   185: ldc_w 494
    //   188: invokespecial 232	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   191: aload_3
    //   192: invokevirtual 360	com/tencent/thumbplayer/core/common/TPMediaDecoderInfo:getDecoderName	()Ljava/lang/String;
    //   195: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: ldc_w 509
    //   201: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: aload 4
    //   206: aload 5
    //   208: getfield 505	com/tencent/thumbplayer/core/common/TPMediaDecoderInfo$DecoderProfileLevel:level	I
    //   211: invokestatic 507	com/tencent/thumbplayer/core/common/TPCodecUtils:getMaxLumaSample	(Ljava/lang/String;I)I
    //   214: invokevirtual 236	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   217: ldc_w 511
    //   220: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: aload_3
    //   224: invokevirtual 438	com/tencent/thumbplayer/core/common/TPMediaDecoderInfo:getDecoderMaxFrameRateForMaxLuma	()I
    //   227: invokevirtual 236	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   230: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: invokestatic 164	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   236: aload 4
    //   238: invokestatic 514	com/tencent/thumbplayer/core/common/TPCodecUtils:getSupportedCodecId	(Ljava/lang/String;)I
    //   241: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   244: aload 6
    //   246: getstatic 211	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   249: invokestatic 518	com/tencent/thumbplayer/core/common/TPCodecUtils:replace	(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/HashMap;)V
    //   252: iload_0
    //   253: iconst_1
    //   254: iadd
    //   255: istore_0
    //   256: goto -193 -> 63
    //   259: astore_2
    //   260: iconst_4
    //   261: ldc 34
    //   263: new 227	java/lang/StringBuilder
    //   266: dup
    //   267: ldc_w 520
    //   270: invokespecial 232	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   273: aload_2
    //   274: invokevirtual 482	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   277: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   283: invokestatic 164	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   286: getstatic 211	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   289: astore_2
    //   290: ldc_w 485
    //   293: invokestatic 218	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   296: goto -250 -> 46
    //   299: astore_2
    //   300: ldc 2
    //   302: monitorexit
    //   303: aload_2
    //   304: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   62	194	0	i	int
    //   60	6	1	j	int
    //   39	30	2	localObject1	Object
    //   259	15	2	localException	Exception
    //   289	1	2	localHashMap	HashMap
    //   299	5	2	localObject2	Object
    //   71	153	3	localObject3	Object
    //   76	161	4	str	String
    //   143	64	5	localDecoderProfileLevel	TPMediaDecoderInfo.DecoderProfileLevel
    //   176	69	6	localTPVCodecMaxCapability	TPCodecCapability.TPVCodecMaxCapability
    // Exception table:
    //   from	to	target	type
    //   51	61	259	java/lang/Exception
    //   72	252	259	java/lang/Exception
    //   3	46	299	finally
    //   51	61	299	finally
    //   72	252	299	finally
    //   260	286	299	finally
    //   286	296	299	finally
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
  
  private static int getSupportedCodecId(String paramString)
  {
    AppMethodBeat.i(227976);
    if (TextUtils.equals(paramString, "video/avc"))
    {
      AppMethodBeat.o(227976);
      return 26;
    }
    if (TextUtils.equals(paramString, "video/hevc"))
    {
      AppMethodBeat.o(227976);
      return 172;
    }
    if (TextUtils.equals(paramString, "video/x-vnd.on2.vp9"))
    {
      AppMethodBeat.o(227976);
      return 166;
    }
    AppMethodBeat.o(227976);
    return -1;
  }
  
  private static String getSupportedHWMimeType(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 26: 
      return "video/avc";
    case 172: 
      return "video/hevc";
    }
    return "video/x-vnd.on2.vp9";
  }
  
  public static HashMap<Integer, TPCodecCapability.TPVCodecMaxCapability> getVCodecSWMaxCapabilityMap()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(227868);
        TPNativeLog.printLog(2, "TPCodecUtils", "getVCodecSWMaxCapabilityMap func in");
        if (mIsFFmpegCapGot)
        {
          localHashMap = mMaxVCodecSwCapabilityMap;
          AppMethodBeat.o(227868);
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
          TPNativeLog.printLog(2, "getVCodecSWMaxCapabilityMaphevcDecodeLevel:" + i + " avs3DecodeLevel:" + k);
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
          AppMethodBeat.o(227868);
        }
        catch (Exception localException)
        {
          TPNativeLog.printLog(4, "TPCodecUtils", "getVCodecSWMaxCapabilityMap exception");
          Object localObject2 = null;
          AppMethodBeat.o(227868);
        }
        localObject1 = finally;
      }
    }
  }
  
  public static void init(Context paramContext, boolean paramBoolean)
  {
    try
    {
      AppMethodBeat.i(227809);
      TPNativeLog.printLog(2, "TPCodecUtils", "is local cache enabled:".concat(String.valueOf(paramBoolean)));
      mContext = paramContext.getApplicationContext();
      if (paramBoolean) {
        mLocalCache = LocalCache.get(mContext);
      }
      getDecoderMaxCapabilityMapAsync();
      AppMethodBeat.o(227809);
      return;
    }
    finally {}
  }
  
  public static boolean isBlackListModel()
  {
    AppMethodBeat.i(227889);
    boolean bool = mBlackListModel.contains(Build.MODEL);
    AppMethodBeat.o(227889);
    return bool;
  }
  
  public static boolean isBlackListType(String paramString)
  {
    AppMethodBeat.i(227900);
    if ((Arrays.asList(new String[] { "PRO 7 Plus", "PRO 7-H", "PRO+7+Plus" }).contains(Build.MODEL)) && (TextUtils.equals(paramString, "video/hevc")) && (Build.VERSION.SDK_INT >= 14))
    {
      AppMethodBeat.o(227900);
      return true;
    }
    AppMethodBeat.o(227900);
    return false;
  }
  
  /* Error */
  private static boolean isHDR10Support(int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: ldc 2
    //   5: monitorenter
    //   6: ldc_w 620
    //   9: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   12: getstatic 94	com/tencent/thumbplayer/core/common/TPCodecUtils:mLocalCache	Lcom/tencent/thumbplayer/core/thirdparties/LocalCache;
    //   15: invokestatic 341	com/tencent/thumbplayer/core/common/TPMediaDecoderList:getTPMediaDecoderInfos	(Lcom/tencent/thumbplayer/core/thirdparties/LocalCache;)[Lcom/tencent/thumbplayer/core/common/TPMediaDecoderInfo;
    //   18: astore 6
    //   20: aload 6
    //   22: arraylength
    //   23: istore_3
    //   24: iconst_0
    //   25: istore_1
    //   26: iload_1
    //   27: iload_3
    //   28: if_icmpge +98 -> 126
    //   31: aload 6
    //   33: iload_1
    //   34: aaload
    //   35: astore 7
    //   37: aload 7
    //   39: invokevirtual 346	com/tencent/thumbplayer/core/common/TPMediaDecoderInfo:getDecoderMimeType	()Ljava/lang/String;
    //   42: ldc 172
    //   44: invokestatic 352	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   47: ifeq +72 -> 119
    //   50: aload 7
    //   52: invokevirtual 376	com/tencent/thumbplayer/core/common/TPMediaDecoderInfo:getProfileLevels	()[Lcom/tencent/thumbplayer/core/common/TPMediaDecoderInfo$DecoderProfileLevel;
    //   55: astore 7
    //   57: aload 7
    //   59: arraylength
    //   60: istore 4
    //   62: iconst_0
    //   63: istore_2
    //   64: iload_2
    //   65: iload 4
    //   67: if_icmpge +52 -> 119
    //   70: aload 7
    //   72: iload_2
    //   73: aaload
    //   74: getfield 381	com/tencent/thumbplayer/core/common/TPMediaDecoderInfo$DecoderProfileLevel:profile	I
    //   77: iload_0
    //   78: if_icmpne +34 -> 112
    //   81: iconst_2
    //   82: ldc 34
    //   84: ldc_w 622
    //   87: iload_0
    //   88: invokestatic 252	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   91: invokevirtual 256	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   94: invokestatic 164	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   97: iconst_1
    //   98: istore 5
    //   100: ldc_w 620
    //   103: invokestatic 218	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   106: ldc 2
    //   108: monitorexit
    //   109: iload 5
    //   111: ireturn
    //   112: iload_2
    //   113: iconst_1
    //   114: iadd
    //   115: istore_2
    //   116: goto -52 -> 64
    //   119: iload_1
    //   120: iconst_1
    //   121: iadd
    //   122: istore_1
    //   123: goto -97 -> 26
    //   126: ldc_w 620
    //   129: invokestatic 218	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   132: goto -26 -> 106
    //   135: astore 6
    //   137: ldc 2
    //   139: monitorexit
    //   140: aload 6
    //   142: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	paramInt	int
    //   25	98	1	i	int
    //   63	53	2	j	int
    //   23	6	3	k	int
    //   60	8	4	m	int
    //   1	109	5	bool	boolean
    //   18	14	6	arrayOfTPMediaDecoderInfo	TPMediaDecoderInfo[]
    //   135	6	6	localObject1	Object
    //   35	36	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   6	24	135	finally
    //   37	62	135	finally
    //   70	97	135	finally
    //   100	106	135	finally
    //   126	132	135	finally
  }
  
  private static boolean isHDRDVSupport(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(227928);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          bool = mCodecCapList.contains("video/dolby-vision");
          AppMethodBeat.o(227928);
          return bool;
        }
        TPMediaDecoderInfo[] arrayOfTPMediaDecoderInfo = TPMediaDecoderList.getTPMediaDecoderInfos(mLocalCache);
        int k = arrayOfTPMediaDecoderInfo.length;
        i = 0;
        if (i >= k) {
          break label171;
        }
        Object localObject2 = arrayOfTPMediaDecoderInfo[i];
        if (!TextUtils.equals(((TPMediaDecoderInfo)localObject2).getDecoderMimeType(), "video/dolby-vision")) {
          break label164;
        }
        localObject2 = ((TPMediaDecoderInfo)localObject2).getProfileLevels();
        int m = localObject2.length;
        int j = 0;
        if (j >= m) {
          break label164;
        }
        Object localObject3 = localObject2[j];
        if ((localObject3.profile == paramInt1) && (localObject3.level == paramInt2))
        {
          TPNativeLog.printLog(2, "TPCodecUtils", "support dolbyvision");
          bool = true;
          AppMethodBeat.o(227928);
          continue;
        }
        j += 1;
      }
      finally {}
      continue;
      label164:
      i += 1;
      continue;
      label171:
      AppMethodBeat.o(227928);
    }
  }
  
  public static boolean isHDRsupport(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(227952);
    boolean bool;
    if (paramInt1 == 2)
    {
      bool = isHDRDVSupport(paramInt2, paramInt3);
      AppMethodBeat.o(227952);
      return bool;
    }
    if (paramInt1 == 0)
    {
      bool = isHDR10Support(4096);
      AppMethodBeat.o(227952);
      return bool;
    }
    if (paramInt1 == 1)
    {
      bool = isHDR10Support(8192);
      AppMethodBeat.o(227952);
      return bool;
    }
    AppMethodBeat.o(227952);
    return false;
  }
  
  /* Error */
  public static boolean isHwDDPlusSupported()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 634
    //   6: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: invokestatic 636	com/tencent/thumbplayer/core/common/TPCodecUtils:isBlackListModel	()Z
    //   12: ifeq +16 -> 28
    //   15: iconst_0
    //   16: istore_0
    //   17: ldc_w 634
    //   20: invokestatic 218	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: ldc 2
    //   25: monitorexit
    //   26: iload_0
    //   27: ireturn
    //   28: getstatic 101	com/tencent/thumbplayer/core/common/TPCodecUtils:mCodecCapList	Ljava/util/ArrayList;
    //   31: ldc_w 638
    //   34: invokevirtual 600	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   37: istore_0
    //   38: ldc_w 634
    //   41: invokestatic 218	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: goto -21 -> 23
    //   47: astore_1
    //   48: ldc 2
    //   50: monitorexit
    //   51: aload_1
    //   52: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   16	22	0	bool	boolean
    //   47	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	15	47	finally
    //   17	23	47	finally
    //   28	44	47	finally
  }
  
  public static boolean isHwDolbyDSSupported()
  {
    try
    {
      AppMethodBeat.i(227908);
      boolean bool = mCodecCapList.contains("audio/ac3");
      AppMethodBeat.o(227908);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean isInMediaCodecWhiteList(String paramString, int paramInt1, int paramInt2)
  {
    boolean bool = true;
    AppMethodBeat.i(227881);
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
      AppMethodBeat.o(227881);
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
      else if ((TextUtils.equals(paramString, "audio/ac3")) || (TextUtils.equals(paramString, "audio/eac3")))
      {
        if ((((Integer)localObject).intValue() & 0x8) == 0)
        {
          bool = false;
          continue;
          AppMethodBeat.o(227881);
          return false;
        }
      }
      else {
        bool = false;
      }
    }
  }
  
  private static boolean isSupportedHWCodec(String paramString)
  {
    AppMethodBeat.i(227994);
    boolean bool = mSupportedHWCodec.contains(paramString);
    AppMethodBeat.o(227994);
    return bool;
  }
  
  private static <K, T> void replace(K paramK, T paramT, HashMap<K, T> paramHashMap)
  {
    AppMethodBeat.i(227845);
    if (paramHashMap.containsKey(paramK))
    {
      paramHashMap.remove(paramK);
      paramHashMap.put(paramK, paramT);
      AppMethodBeat.o(227845);
      return;
    }
    paramHashMap.put(paramK, paramT);
    AppMethodBeat.o(227845);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPCodecUtils
 * JD-Core Version:    0.7.0.1
 */