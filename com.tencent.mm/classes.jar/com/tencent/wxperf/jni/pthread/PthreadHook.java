package com.tencent.wxperf.jni.pthread;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wxperf.jni.a;
import java.util.HashSet;
import java.util.Set;

public class PthreadHook
  extends a
{
  public static final PthreadHook SyB;
  public Set<String> SyC;
  public Set<String> Syt;
  public Set<String> Syu;
  
  static
  {
    AppMethodBeat.i(199069);
    SyB = new PthreadHook();
    AppMethodBeat.o(199069);
  }
  
  private PthreadHook()
  {
    AppMethodBeat.i(199066);
    this.Syt = new HashSet();
    this.Syu = new HashSet();
    this.SyC = new HashSet();
    AppMethodBeat.o(199066);
  }
  
  private native void addHookSoNative(String[] paramArrayOfString);
  
  private native void addHookThreadNameNative(String[] paramArrayOfString);
  
  private native void addIgnoreSoNative(String[] paramArrayOfString);
  
  public native void dumpNative(String paramString);
  
  public final void hrX()
  {
    AppMethodBeat.i(199067);
    addHookThreadNameNative((String[])this.SyC.toArray(new String[0]));
    AppMethodBeat.o(199067);
  }
  
  public final void hrY()
  {
    AppMethodBeat.i(199068);
    addHookSoNative((String[])this.Syt.toArray(new String[0]));
    addIgnoreSoNative((String[])this.Syu.toArray(new String[0]));
    AppMethodBeat.o(199068);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.wxperf.jni.pthread.PthreadHook
 * JD-Core Version:    0.7.0.1
 */