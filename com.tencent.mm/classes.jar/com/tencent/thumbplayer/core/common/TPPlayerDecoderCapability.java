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
  
  private static native boolean _isVCodecCapabilitySupport(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7);
  
  public static boolean addACodecBlacklist(int paramInt1, int paramInt2, TPCodecCapability.TPACodecCapability paramTPACodecCapability)
  {
    return true;
  }
  
  public static boolean addVCodecBlacklist(int paramInt1, int paramInt2, TPCodecCapability.TPVCodecPropertyRange paramTPVCodecPropertyRange)
  {
    AppMethodBeat.i(189782);
    try
    {
      boolean bool = _addVCodecBlacklist(paramInt1, paramInt2, paramTPVCodecPropertyRange);
      AppMethodBeat.o(189782);
      return bool;
    }
    catch (Throwable paramTPVCodecPropertyRange)
    {
      TPNativeLog.printLog(4, paramTPVCodecPropertyRange.getMessage());
      AppMethodBeat.o(189782);
    }
    return false;
  }
  
  public static boolean addVCodecWhitelist(int paramInt1, int paramInt2, TPCodecCapability.TPVCodecPropertyRange paramTPVCodecPropertyRange)
  {
    AppMethodBeat.i(189783);
    try
    {
      boolean bool = _addVCodecWhitelist(paramInt1, paramInt2, paramTPVCodecPropertyRange);
      AppMethodBeat.o(189783);
      return bool;
    }
    catch (Throwable paramTPVCodecPropertyRange)
    {
      TPNativeLog.printLog(4, paramTPVCodecPropertyRange.getMessage());
      AppMethodBeat.o(189783);
    }
    return false;
  }
  
  public static HashMap<Integer, TPCodecCapability.TPVCodecMaxCapability> getVCodecDecoderMaxCapabilityMap(int paramInt)
  {
    AppMethodBeat.i(189781);
    try
    {
      HashMap localHashMap = _getDecoderMaxCapabilityMap(paramInt);
      AppMethodBeat.o(189781);
      return localHashMap;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(189781);
    }
    return null;
  }
  
  public static void init(Context paramContext, boolean paramBoolean)
  {
    try
    {
      AppMethodBeat.i(189780);
      TPCodecUtils.init(paramContext, paramBoolean);
      AppMethodBeat.o(189780);
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
    AppMethodBeat.i(189788);
    boolean bool = TPCodecUtils.isBlackListForHdr10(paramString);
    AppMethodBeat.o(189788);
    return bool;
  }
  
  public static boolean isBlackListForHdr10Enhance(String paramString)
  {
    AppMethodBeat.i(189791);
    boolean bool = TPCodecUtils.isBlackListForHdr10Enhance(paramString);
    AppMethodBeat.o(189791);
    return bool;
  }
  
  public static boolean isBlackListForVidHdr10Enhance(String paramString1, String paramString2)
  {
    AppMethodBeat.i(189789);
    boolean bool = TPCodecUtils.isBlackListForVidHdr10Enhance(paramString1, paramString2);
    AppMethodBeat.o(189789);
    return bool;
  }
  
  public static boolean isDDPlusSupported()
  {
    AppMethodBeat.i(189786);
    boolean bool = TPCodecUtils.isHwDDPlusSupported();
    AppMethodBeat.o(189786);
    return bool;
  }
  
  public static boolean isDolbyDSSupported()
  {
    AppMethodBeat.i(189785);
    boolean bool = TPCodecUtils.isHwDolbyDSSupported();
    AppMethodBeat.o(189785);
    return bool;
  }
  
  public static boolean isHDRsupport(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(189787);
    boolean bool = TPCodecUtils.isHDRsupport(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(189787);
    return bool;
  }
  
  public static boolean isVCodecCapabilitySupport(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    AppMethodBeat.i(189784);
    if (102 == paramInt1)
    {
      String str = "";
      switch (paramInt2)
      {
      }
      while (TPCodecUtils.isInMediaCodecWhiteList(str, paramInt3, paramInt4))
      {
        AppMethodBeat.o(189784);
        return true;
        str = "video/avc";
        continue;
        str = "video/hevc";
      }
      if (TPCodecUtils.isBlackListForHardwareDec(str))
      {
        AppMethodBeat.o(189784);
        return false;
      }
    }
    try
    {
      boolean bool = _isVCodecCapabilitySupport(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
      AppMethodBeat.o(189784);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(189784);
    }
    return false;
  }
  
  public static boolean isWhiteListForHdr10(String paramString)
  {
    AppMethodBeat.i(189790);
    boolean bool = TPCodecUtils.isWhiteListForHdr10(paramString);
    AppMethodBeat.o(189790);
    return bool;
  }
  
  public static boolean isWhiteListForHdr10Enhance(String paramString)
  {
    AppMethodBeat.i(189792);
    boolean bool = TPCodecUtils.isWhiteListForHdr10Enhance(paramString);
    AppMethodBeat.o(189792);
    return bool;
  }
  
  public static boolean probeACodecMaxCapability()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPPlayerDecoderCapability
 * JD-Core Version:    0.7.0.1
 */