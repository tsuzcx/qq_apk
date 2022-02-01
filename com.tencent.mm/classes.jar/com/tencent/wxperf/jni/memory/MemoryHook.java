package com.tencent.wxperf.jni.memory;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.stubs.logger.Log;
import com.tencent.wxperf.jni.HookManager;
import com.tencent.wxperf.jni.a;
import java.util.HashSet;
import java.util.Set;

public class MemoryHook
  extends a
{
  public static final MemoryHook Sys;
  public boolean SyA;
  public Set<String> Syt;
  public Set<String> Syu;
  public int Syv;
  public int Syw;
  public int Syx;
  public double Syy;
  public boolean Syz;
  
  static
  {
    AppMethodBeat.i(199065);
    Sys = new MemoryHook();
    AppMethodBeat.o(199065);
  }
  
  private MemoryHook()
  {
    AppMethodBeat.i(199061);
    this.Syt = new HashSet();
    this.Syu = new HashSet();
    this.Syx = 10485760;
    this.Syy = 1.0D;
    AppMethodBeat.o(199061);
  }
  
  private native void addHookSoNative(String[] paramArrayOfString);
  
  private native void addIgnoreSoNative(String[] paramArrayOfString);
  
  private native void dumpNative(String paramString1, String paramString2);
  
  private native void enableMmapHookNative(boolean paramBoolean);
  
  private native void enableStacktraceNative(boolean paramBoolean);
  
  private native void setSampleSizeRangeNative(int paramInt1, int paramInt2);
  
  private native void setSamplingNative(double paramDouble);
  
  private native void setStacktraceLogThresholdNative(int paramInt);
  
  public final void dump(String paramString1, String paramString2)
  {
    AppMethodBeat.i(199064);
    if (HookManager.Syn.Syo) {
      dumpNative(paramString1, paramString2);
    }
    AppMethodBeat.o(199064);
  }
  
  public final void hrX()
  {
    AppMethodBeat.i(199062);
    if ((this.Syv < 0) || ((this.Syw != 0) && (this.Syw < this.Syv)))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("sizes should not be negative and maxSize should be 0 or greater than minSize: min = " + this.Syv + ", max = " + this.Syw);
      AppMethodBeat.o(199062);
      throw localIllegalArgumentException;
    }
    Log.d("Yves.debug", "enable mmap? " + this.SyA);
    enableMmapHookNative(this.SyA);
    setSampleSizeRangeNative(this.Syv, this.Syw);
    setSamplingNative(this.Syy);
    setStacktraceLogThresholdNative(this.Syx);
    enableStacktraceNative(this.Syz);
    AppMethodBeat.o(199062);
  }
  
  public final void hrY()
  {
    AppMethodBeat.i(199063);
    addHookSoNative((String[])this.Syt.toArray(new String[0]));
    addIgnoreSoNative((String[])this.Syu.toArray(new String[0]));
    AppMethodBeat.o(199063);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.wxperf.jni.memory.MemoryHook
 * JD-Core Version:    0.7.0.1
 */