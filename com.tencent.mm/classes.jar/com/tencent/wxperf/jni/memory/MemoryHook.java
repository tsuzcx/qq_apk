package com.tencent.wxperf.jni.memory;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wxperf.jni.a;
import java.util.HashSet;
import java.util.Set;

public class MemoryHook
  extends a
{
  public static final MemoryHook MoI;
  private Set<String> MoJ;
  private Set<String> MoK;
  public int MoL;
  public int MoM;
  private double MoN;
  public boolean MoO;
  public boolean MoP;
  
  static
  {
    AppMethodBeat.i(211548);
    MoI = new MemoryHook();
    AppMethodBeat.o(211548);
  }
  
  private MemoryHook()
  {
    AppMethodBeat.i(211542);
    this.MoJ = new HashSet();
    this.MoK = new HashSet();
    this.MoN = 1.0D;
    AppMethodBeat.o(211542);
  }
  
  private native void addHookSoNative(String[] paramArrayOfString);
  
  private native void addIgnoreSoNative(String[] paramArrayOfString);
  
  private native void enableMmapHookNative(boolean paramBoolean);
  
  private native void enableStacktraceNative(boolean paramBoolean);
  
  private native void setSampleSizeRangeNative(int paramInt1, int paramInt2);
  
  private native void setSamplingNative(double paramDouble);
  
  public final MemoryHook F(double paramDouble)
  {
    AppMethodBeat.i(211545);
    if ((this.MoN < 0.0D) || (this.MoN > 1.0D))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("sampling should be between 0 and 1: ".concat(String.valueOf(paramDouble)));
      AppMethodBeat.o(211545);
      throw localIllegalArgumentException;
    }
    this.MoN = paramDouble;
    AppMethodBeat.o(211545);
    return this;
  }
  
  public final MemoryHook ag(String... paramVarArgs)
  {
    AppMethodBeat.i(211543);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      String str = paramVarArgs[i];
      if (TextUtils.isEmpty(str))
      {
        paramVarArgs = new IllegalArgumentException("regex = ".concat(String.valueOf(str)));
        AppMethodBeat.o(211543);
        throw paramVarArgs;
      }
      this.MoJ.add(str);
      i += 1;
    }
    AppMethodBeat.o(211543);
    return this;
  }
  
  public final MemoryHook ah(String... paramVarArgs)
  {
    AppMethodBeat.i(211544);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      String str = paramVarArgs[i];
      if (!TextUtils.isEmpty(str)) {
        this.MoK.add(str);
      }
      i += 1;
    }
    AppMethodBeat.o(211544);
    return this;
  }
  
  public native void dumpNative(String paramString);
  
  public final void gaf()
  {
    AppMethodBeat.i(211546);
    if ((this.MoL < 0) || ((this.MoM != 0) && (this.MoM < this.MoL)))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("sizes should not be negative and maxSize should be 0 or greater than minSize: min = " + this.MoL + ", max = " + this.MoM);
      AppMethodBeat.o(211546);
      throw localIllegalArgumentException;
    }
    new StringBuilder("enable mmap? ").append(this.MoP);
    enableMmapHookNative(this.MoP);
    setSampleSizeRangeNative(this.MoL, this.MoM);
    setSamplingNative(this.MoN);
    enableStacktraceNative(this.MoO);
    AppMethodBeat.o(211546);
  }
  
  public final void gag()
  {
    AppMethodBeat.i(211547);
    addHookSoNative((String[])this.MoJ.toArray(new String[0]));
    addIgnoreSoNative((String[])this.MoK.toArray(new String[0]));
    AppMethodBeat.o(211547);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.wxperf.jni.memory.MemoryHook
 * JD-Core Version:    0.7.0.1
 */