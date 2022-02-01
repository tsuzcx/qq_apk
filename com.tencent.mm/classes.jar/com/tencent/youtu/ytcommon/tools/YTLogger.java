package com.tencent.youtu.ytcommon.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class YTLogger
{
  private static IFaceLiveLogger iFaceLiveLogger;
  private static boolean sEnableLog = false;
  private static boolean sEnableNativeLog = false;
  
  public static void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(73388);
    if (!sEnableLog)
    {
      AppMethodBeat.o(73388);
      return;
    }
    if (iFaceLiveLogger != null) {
      iFaceLiveLogger.d(paramString1, paramString2);
    }
    AppMethodBeat.o(73388);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(73391);
    if (iFaceLiveLogger != null) {
      iFaceLiveLogger.e(paramString1, paramString2);
    }
    AppMethodBeat.o(73391);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(73389);
    if (!sEnableLog)
    {
      AppMethodBeat.o(73389);
      return;
    }
    if (iFaceLiveLogger != null) {
      iFaceLiveLogger.i(paramString1, paramString2);
    }
    AppMethodBeat.o(73389);
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
  
  public static void setLog(IFaceLiveLogger paramIFaceLiveLogger)
  {
    iFaceLiveLogger = paramIFaceLiveLogger;
  }
  
  public static void v(String paramString1, String paramString2)
  {
    AppMethodBeat.i(73387);
    if (!sEnableLog)
    {
      AppMethodBeat.o(73387);
      return;
    }
    if (iFaceLiveLogger != null) {
      iFaceLiveLogger.v(paramString1, paramString2);
    }
    AppMethodBeat.o(73387);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(73390);
    if (!sEnableLog)
    {
      AppMethodBeat.o(73390);
      return;
    }
    if (iFaceLiveLogger != null) {
      iFaceLiveLogger.w(paramString1, paramString2);
    }
    AppMethodBeat.o(73390);
  }
  
  public static abstract interface IFaceLiveLogger
  {
    public abstract void d(String paramString1, String paramString2);
    
    public abstract void e(String paramString1, String paramString2);
    
    public abstract void i(String paramString1, String paramString2);
    
    public abstract void v(String paramString1, String paramString2);
    
    public abstract void w(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.youtu.ytcommon.tools.YTLogger
 * JD-Core Version:    0.7.0.1
 */