package com.tencent.wxperf.fd;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class FDDumpBridge
{
  static
  {
    AppMethodBeat.i(219236);
    System.loadLibrary("wxperf-fd");
    AppMethodBeat.o(219236);
  }
  
  public static String bar(String paramString)
  {
    AppMethodBeat.i(219235);
    paramString = getFdPathNameNative(paramString);
    AppMethodBeat.o(219235);
    return paramString;
  }
  
  public static native String getFdPathNameNative(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wxperf.fd.FDDumpBridge
 * JD-Core Version:    0.7.0.1
 */