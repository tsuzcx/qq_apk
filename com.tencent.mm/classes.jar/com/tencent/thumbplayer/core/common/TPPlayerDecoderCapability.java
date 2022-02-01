package com.tencent.thumbplayer.core.common;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public class TPPlayerDecoderCapability
{
  private static String TAG = "TPPlayerDecoderCapability";
  private long mNativeContext = 0L;
  
  private static native boolean _addVCodecBlacklist(int paramInt1, int paramInt2, TPCodecCapability.TPVCodecPropertyRange paramTPVCodecPropertyRange);
  
  private static native boolean _addVCodecWhitelist(int paramInt1, int paramInt2, TPCodecCapability.TPVCodecPropertyRange paramTPVCodecPropertyRange);
  
  private static native HashMap<Integer, TPCodecCapability.TPVCodecMaxCapability> _getDecoderMaxCapabilityMap(int paramInt);
  
  private static native boolean _isVCodecCapabilitySupport(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
  
  public static boolean addACodecBlacklist(int paramInt1, int paramInt2, TPCodecCapability.TPACodecCapability paramTPACodecCapability)
  {
    return true;
  }
  
  public static boolean addVCodecBlacklist(int paramInt1, int paramInt2, TPCodecCapability.TPVCodecPropertyRange paramTPVCodecPropertyRange)
  {
    AppMethodBeat.i(193681);
    try
    {
      boolean bool = _addVCodecBlacklist(paramInt1, paramInt2, paramTPVCodecPropertyRange);
      AppMethodBeat.o(193681);
      return bool;
    }
    catch (Throwable paramTPVCodecPropertyRange)
    {
      TPNativeLog.printLog(4, paramTPVCodecPropertyRange.getMessage());
      AppMethodBeat.o(193681);
    }
    return false;
  }
  
  public static boolean addVCodecWhitelist(int paramInt1, int paramInt2, TPCodecCapability.TPVCodecPropertyRange paramTPVCodecPropertyRange)
  {
    AppMethodBeat.i(193682);
    try
    {
      boolean bool = _addVCodecWhitelist(paramInt1, paramInt2, paramTPVCodecPropertyRange);
      AppMethodBeat.o(193682);
      return bool;
    }
    catch (Throwable paramTPVCodecPropertyRange)
    {
      TPNativeLog.printLog(4, paramTPVCodecPropertyRange.getMessage());
      AppMethodBeat.o(193682);
    }
    return false;
  }
  
  public static HashMap<Integer, TPCodecCapability.TPVCodecMaxCapability> getVCodecDecoderMaxCapabilityMap(int paramInt)
  {
    AppMethodBeat.i(193680);
    try
    {
      HashMap localHashMap = _getDecoderMaxCapabilityMap(paramInt);
      AppMethodBeat.o(193680);
      return localHashMap;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(193680);
    }
    return null;
  }
  
  public static void init(Context paramContext, boolean paramBoolean)
  {
    try
    {
      AppMethodBeat.i(193679);
      TPCodecUtils.init(paramContext, paramBoolean);
      AppMethodBeat.o(193679);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static boolean isACodecCapabilitySupport(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return true;
  }
  
  public static boolean isBlackListForHdr10(String paramString)
  {
    AppMethodBeat.i(193687);
    boolean bool = TPCodecUtils.isBlackListForHdr10(paramString);
    AppMethodBeat.o(193687);
    return bool;
  }
  
  public static boolean isBlackListForHdr10Enhance(String paramString)
  {
    AppMethodBeat.i(193690);
    boolean bool = TPCodecUtils.isBlackListForHdr10Enhance(paramString);
    AppMethodBeat.o(193690);
    return bool;
  }
  
  public static boolean isBlackListForVidHdr10Enhance(String paramString1, String paramString2)
  {
    AppMethodBeat.i(193688);
    boolean bool = TPCodecUtils.isBlackListForVidHdr10Enhance(paramString1, paramString2);
    AppMethodBeat.o(193688);
    return bool;
  }
  
  public static boolean isDDPlusSupported()
  {
    AppMethodBeat.i(193685);
    boolean bool = TPCodecUtils.isHwDDPlusSupported();
    AppMethodBeat.o(193685);
    return bool;
  }
  
  public static boolean isDolbyDSSupported()
  {
    AppMethodBeat.i(193684);
    boolean bool = TPCodecUtils.isHwDolbyDSSupported();
    AppMethodBeat.o(193684);
    return bool;
  }
  
  public static boolean isHDRsupport(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(193686);
    boolean bool = TPCodecUtils.isHDRsupport(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(193686);
    return bool;
  }
  
  public static boolean isVCodecCapabilitySupport(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(193683);
    if (TPDecoderType.TP_VIDEO_DECODER_MEDIACODEC == paramInt1)
    {
      String str = "";
      switch (paramInt2)
      {
      }
      while (TPCodecUtils.isInMediaCodecWhiteList(str, paramInt3, paramInt4))
      {
        AppMethodBeat.o(193683);
        return true;
        str = "video/avc";
        continue;
        str = "video/hevc";
      }
      if (TPCodecUtils.isBlackListForHardwareDec(str))
      {
        AppMethodBeat.o(193683);
        return false;
      }
    }
    try
    {
      boolean bool = _isVCodecCapabilitySupport(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
      AppMethodBeat.o(193683);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(193683);
    }
    return false;
  }
  
  public static boolean isWhiteListForHdr10(String paramString)
  {
    AppMethodBeat.i(193689);
    boolean bool = TPCodecUtils.isWhiteListForHdr10(paramString);
    AppMethodBeat.o(193689);
    return bool;
  }
  
  public static boolean isWhiteListForHdr10Enhance(String paramString)
  {
    AppMethodBeat.i(193691);
    boolean bool = TPCodecUtils.isWhiteListForHdr10Enhance(paramString);
    AppMethodBeat.o(193691);
    return bool;
  }
  
  public static boolean probeACodecMaxCapability()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPPlayerDecoderCapability
 * JD-Core Version:    0.7.0.1
 */