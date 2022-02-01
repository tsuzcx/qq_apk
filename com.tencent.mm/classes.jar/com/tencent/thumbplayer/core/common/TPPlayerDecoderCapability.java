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
    AppMethodBeat.i(227750);
    try
    {
      boolean bool = _addVCodecBlacklist(paramInt1, paramInt2, paramTPVCodecPropertyRange);
      AppMethodBeat.o(227750);
      return bool;
    }
    finally
    {
      TPNativeLog.printLog(4, paramTPVCodecPropertyRange.getMessage());
      AppMethodBeat.o(227750);
    }
    return false;
  }
  
  public static boolean addVCodecWhitelist(int paramInt1, int paramInt2, TPCodecCapability.TPVCodecPropertyRange paramTPVCodecPropertyRange)
  {
    AppMethodBeat.i(227754);
    try
    {
      boolean bool = _addVCodecWhitelist(paramInt1, paramInt2, paramTPVCodecPropertyRange);
      AppMethodBeat.o(227754);
      return bool;
    }
    finally
    {
      TPNativeLog.printLog(4, paramTPVCodecPropertyRange.getMessage());
      AppMethodBeat.o(227754);
    }
    return false;
  }
  
  public static HashMap<Integer, TPCodecCapability.TPVCodecMaxCapability> getVCodecDecoderMaxCapabilityMap(int paramInt)
  {
    AppMethodBeat.i(227743);
    try
    {
      HashMap localHashMap = _getDecoderMaxCapabilityMap(paramInt);
      AppMethodBeat.o(227743);
      return localHashMap;
    }
    finally
    {
      TPNativeLog.printLog(4, localObject.getMessage());
      AppMethodBeat.o(227743);
    }
    return null;
  }
  
  public static void init(Context paramContext, boolean paramBoolean)
  {
    try
    {
      AppMethodBeat.i(227720);
      TPCodecUtils.init(paramContext, paramBoolean);
      AppMethodBeat.o(227720);
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
  
  public static boolean isDDPlusSupported()
  {
    AppMethodBeat.i(227773);
    boolean bool = TPCodecUtils.isHwDDPlusSupported();
    AppMethodBeat.o(227773);
    return bool;
  }
  
  public static boolean isDolbyDSSupported()
  {
    AppMethodBeat.i(227768);
    boolean bool = TPCodecUtils.isHwDolbyDSSupported();
    AppMethodBeat.o(227768);
    return bool;
  }
  
  public static boolean isHDRsupport(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(227779);
    boolean bool = TPCodecUtils.isHDRsupport(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(227779);
    return bool;
  }
  
  public static boolean isVCodecCapabilitySupport(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    AppMethodBeat.i(227761);
    if (102 == paramInt1)
    {
      String str = "";
      switch (paramInt2)
      {
      }
      while (TPCodecUtils.isInMediaCodecWhiteList(str, paramInt3, paramInt4))
      {
        AppMethodBeat.o(227761);
        return true;
        str = "video/avc";
        continue;
        str = "video/hevc";
      }
      if ((TPCodecUtils.isBlackListModel()) || (TPCodecUtils.isBlackListType(str)))
      {
        AppMethodBeat.o(227761);
        return false;
      }
    }
    try
    {
      boolean bool = _isVCodecCapabilitySupport(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
      AppMethodBeat.o(227761);
      return bool;
    }
    finally
    {
      TPNativeLog.printLog(4, localObject.getMessage());
      AppMethodBeat.o(227761);
    }
    return false;
  }
  
  public static boolean probeACodecMaxCapability()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPPlayerDecoderCapability
 * JD-Core Version:    0.7.0.1
 */