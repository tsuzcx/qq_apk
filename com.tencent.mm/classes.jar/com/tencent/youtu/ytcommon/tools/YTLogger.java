package com.tencent.youtu.ytcommon.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class YTLogger
{
  private static YTLogger.IFaceLiveLogger iFaceLiveLogger;
  private static boolean sEnableLog = false;
  private static boolean sEnableNativeLog = false;
  
  public static void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(118098);
    if (!sEnableLog)
    {
      AppMethodBeat.o(118098);
      return;
    }
    if (iFaceLiveLogger != null) {
      iFaceLiveLogger.d(paramString1, paramString2);
    }
    AppMethodBeat.o(118098);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(118101);
    if (iFaceLiveLogger != null) {
      iFaceLiveLogger.e(paramString1, paramString2);
    }
    AppMethodBeat.o(118101);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(118099);
    if (!sEnableLog)
    {
      AppMethodBeat.o(118099);
      return;
    }
    if (iFaceLiveLogger != null) {
      iFaceLiveLogger.i(paramString1, paramString2);
    }
    AppMethodBeat.o(118099);
  }
  
  public static boolean isEnableLog()
  {
    return sEnableLog;
  }
  
  public static boolean isEnableNativeLog()
  {
    return sEnableNativeLog;
  }
  
  public static void setIsEnabledLog(boolean paramBoolean)
  {
    sEnableLog = paramBoolean;
  }
  
  public static void setIsEnabledNativeLog(boolean paramBoolean)
  {
    sEnableNativeLog = paramBoolean;
  }
  
  public static void setLog(YTLogger.IFaceLiveLogger paramIFaceLiveLogger)
  {
    iFaceLiveLogger = paramIFaceLiveLogger;
  }
  
  public static void v(String paramString1, String paramString2)
  {
    AppMethodBeat.i(118097);
    if (!sEnableLog)
    {
      AppMethodBeat.o(118097);
      return;
    }
    if (iFaceLiveLogger != null) {
      iFaceLiveLogger.v(paramString1, paramString2);
    }
    AppMethodBeat.o(118097);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(118100);
    if (!sEnableLog)
    {
      AppMethodBeat.o(118100);
      return;
    }
    if (iFaceLiveLogger != null) {
      iFaceLiveLogger.w(paramString1, paramString2);
    }
    AppMethodBeat.o(118100);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.youtu.ytcommon.tools.YTLogger
 * JD-Core Version:    0.7.0.1
 */