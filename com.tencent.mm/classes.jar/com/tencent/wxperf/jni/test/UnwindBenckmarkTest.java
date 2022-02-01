package com.tencent.wxperf.jni.test;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class UnwindBenckmarkTest
{
  static
  {
    AppMethodBeat.i(195231);
    System.loadLibrary("wxperf-jni");
    AppMethodBeat.o(195231);
  }
  
  public static native void benchmarkInitNative();
  
  public static native void benchmarkNative();
  
  public static native void debugNative();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wxperf.jni.test.UnwindBenckmarkTest
 * JD-Core Version:    0.7.0.1
 */