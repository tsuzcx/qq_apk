package com.tencent.wxperf.fd;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.stubs.logger.Log;

public class FDDumpBridge
{
  private static boolean initialized;
  
  static
  {
    AppMethodBeat.i(197965);
    try
    {
      System.loadLibrary("wxperf-fd");
      initialized = true;
      AppMethodBeat.o(197965);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.printStack(6, "FDDumpBridge", localThrowable);
      initialized = false;
      AppMethodBeat.o(197965);
    }
  }
  
  public static String bbU(String paramString)
  {
    AppMethodBeat.i(197964);
    if (!initialized)
    {
      AppMethodBeat.o(197964);
      return paramString;
    }
    paramString = getFdPathNameNative(paramString);
    AppMethodBeat.o(197964);
    return paramString;
  }
  
  public static native String getFdPathNameNative(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.wxperf.fd.FDDumpBridge
 * JD-Core Version:    0.7.0.1
 */