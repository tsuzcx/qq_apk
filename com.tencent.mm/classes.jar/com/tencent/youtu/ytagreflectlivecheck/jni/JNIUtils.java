package com.tencent.youtu.ytagreflectlivecheck.jni;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.Timeval;

public class JNIUtils
{
  private static final String TAG = "LightLiveCheck";
  
  public static Timeval getTimeval(long paramLong)
  {
    AppMethodBeat.i(231591);
    Timeval localTimeval = new Timeval(paramLong / 1000L, (int)(1000L * paramLong % 1000000L));
    AppMethodBeat.o(231591);
    return localTimeval;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.jni.JNIUtils
 * JD-Core Version:    0.7.0.1
 */