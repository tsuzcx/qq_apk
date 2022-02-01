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
    AppMethodBeat.i(197402);
    try
    {
      boolean bool = _addVCodecBlacklist(paramInt1, paramInt2, paramTPVCodecPropertyRange);
      AppMethodBeat.o(197402);
      return bool;
    }
    catch (Throwable paramTPVCodecPropertyRange)
    {
      TPNativeLog.printLog(4, paramTPVCodecPropertyRange.getMessage());
      AppMethodBeat.o(197402);
    }
    return false;
  }
  
  public static boolean addVCodecWhitelist(int paramInt1, int paramInt2, TPCodecCapability.TPVCodecPropertyRange paramTPVCodecPropertyRange)
  {
    AppMethodBeat.i(197403);
    try
    {
      boolean bool = _addVCodecWhitelist(paramInt1, paramInt2, paramTPVCodecPropertyRange);
      AppMethodBeat.o(197403);
      return bool;
    }
    catch (Throwable paramTPVCodecPropertyRange)
    {
      TPNativeLog.printLog(4, paramTPVCodecPropertyRange.getMessage());
      AppMethodBeat.o(197403);
    }
    return false;
  }
  
  public static HashMap<Integer, TPCodecCapability.TPVCodecMaxCapability> getVCodecDecoderMaxCapabilityMap(int paramInt)
  {
    AppMethodBeat.i(197401);
    try
    {
      HashMap localHashMap = _getDecoderMaxCapabilityMap(paramInt);
      AppMethodBeat.o(197401);
      return localHashMap;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(197401);
    }
    return null;
  }
  
  public static void init(Context paramContext, boolean paramBoolean)
  {
    try
    {
      AppMethodBeat.i(197400);
      TPCodecUtils.init(paramContext, paramBoolean);
      AppMethodBeat.o(197400);
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
    AppMethodBeat.i(197408);
    boolean bool = TPCodecUtils.isBlackListForHdr10(paramString);
    AppMethodBeat.o(197408);
    return bool;
  }
  
  public static boolean isBlackListForHdr10Enhance(String paramString)
  {
    AppMethodBeat.i(197411);
    boolean bool = TPCodecUtils.isBlackListForHdr10Enhance(paramString);
    AppMethodBeat.o(197411);
    return bool;
  }
  
  public static boolean isBlackListForVidHdr10Enhance(String paramString1, String paramString2)
  {
    AppMethodBeat.i(197409);
    boolean bool = TPCodecUtils.isBlackListForVidHdr10Enhance(paramString1, paramString2);
    AppMethodBeat.o(197409);
    return bool;
  }
  
  public static boolean isDDPlusSupported()
  {
    AppMethodBeat.i(197406);
    boolean bool = TPCodecUtils.isHwDDPlusSupported();
    AppMethodBeat.o(197406);
    return bool;
  }
  
  public static boolean isDolbyDSSupported()
  {
    AppMethodBeat.i(197405);
    boolean bool = TPCodecUtils.isHwDolbyDSSupported();
    AppMethodBeat.o(197405);
    return bool;
  }
  
  public static boolean isHDRsupport(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(197407);
    boolean bool = TPCodecUtils.isHDRsupport(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(197407);
    return bool;
  }
  
  public static boolean isVCodecCapabilitySupport(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(197404);
    if (TPDecoderType.TP_VIDEO_DECODER_MEDIACODEC == paramInt1)
    {
      String str = "";
      switch (paramInt2)
      {
      }
      while (TPCodecUtils.isInMediaCodecWhiteList(str, paramInt3, paramInt4))
      {
        AppMethodBeat.o(197404);
        return true;
        str = "video/avc";
        continue;
        str = "video/hevc";
      }
      if (TPCodecUtils.isBlackListForHardwareDec(str))
      {
        AppMethodBeat.o(197404);
        return false;
      }
    }
    try
    {
      boolean bool = _isVCodecCapabilitySupport(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
      AppMethodBeat.o(197404);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(197404);
    }
    return false;
  }
  
  public static boolean isWhiteListForHdr10(String paramString)
  {
    AppMethodBeat.i(197410);
    boolean bool = TPCodecUtils.isWhiteListForHdr10(paramString);
    AppMethodBeat.o(197410);
    return bool;
  }
  
  public static boolean isWhiteListForHdr10Enhance(String paramString)
  {
    AppMethodBeat.i(197412);
    boolean bool = TPCodecUtils.isWhiteListForHdr10Enhance(paramString);
    AppMethodBeat.o(197412);
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