package com.tencent.wxperf.fd;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.stubs.logger.Log;

public class FDDumpBridge
{
  private static boolean initialized;
  
  static
  {
    AppMethodBeat.i(224177);
    try
    {
      System.loadLibrary("wxperf-fd");
      initialized = true;
      AppMethodBeat.o(224177);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.printStack(6, "FDDumpBridge", localThrowable);
      initialized = false;
      AppMethodBeat.o(224177);
    }
  }
  
  public static String brC(String paramString)
  {
    AppMethodBeat.i(224176);
    if (!initialized)
    {
      AppMethodBeat.o(224176);
      return paramString;
    }
    paramString = getFdPathNameNative(paramString);
    AppMethodBeat.o(224176);
    return paramString;
  }
  
  public static native int getFDLimit();
  
  public static native String getFdPathNameNative(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.wxperf.fd.FDDumpBridge
 * JD-Core Version:    0.7.0.1
 */