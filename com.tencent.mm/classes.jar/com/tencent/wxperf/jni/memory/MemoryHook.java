package com.tencent.wxperf.jni.memory;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wxperf.jni.a;
import java.util.HashSet;
import java.util.Set;

public class MemoryHook
  extends a
{
  public static final MemoryHook MLE;
  private Set<String> MLF;
  private Set<String> MLG;
  public int MLH;
  public int MLI;
  private double MLJ;
  public boolean MLK;
  public boolean MLL;
  
  static
  {
    AppMethodBeat.i(195219);
    MLE = new MemoryHook();
    AppMethodBeat.o(195219);
  }
  
  private MemoryHook()
  {
    AppMethodBeat.i(195213);
    this.MLF = new HashSet();
    this.MLG = new HashSet();
    this.MLJ = 1.0D;
    AppMethodBeat.o(195213);
  }
  
  private native void addHookSoNative(String[] paramArrayOfString);
  
  private native void addIgnoreSoNative(String[] paramArrayOfString);
  
  private native void enableMmapHookNative(boolean paramBoolean);
  
  private native void enableStacktraceNative(boolean paramBoolean);
  
  private native void setSampleSizeRangeNative(int paramInt1, int paramInt2);
  
  private native void setSamplingNative(double paramDouble);
  
  public final MemoryHook F(double paramDouble)
  {
    AppMethodBeat.i(195216);
    if ((this.MLJ < 0.0D) || (this.MLJ > 1.0D))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("sampling should be between 0 and 1: ".concat(String.valueOf(paramDouble)));
      AppMethodBeat.o(195216);
      throw localIllegalArgumentException;
    }
    this.MLJ = paramDouble;
    AppMethodBeat.o(195216);
    return this;
  }
  
  public final MemoryHook ag(String... paramVarArgs)
  {
    AppMethodBeat.i(195214);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      String str = paramVarArgs[i];
      if (TextUtils.isEmpty(str))
      {
        paramVarArgs = new IllegalArgumentException("regex = ".concat(String.valueOf(str)));
        AppMethodBeat.o(195214);
        throw paramVarArgs;
      }
      this.MLF.add(str);
      i += 1;
    }
    AppMethodBeat.o(195214);
    return this;
  }
  
  public final MemoryHook ah(String... paramVarArgs)
  {
    AppMethodBeat.i(195215);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      String str = paramVarArgs[i];
      if (!TextUtils.isEmpty(str)) {
        this.MLG.add(str);
      }
      i += 1;
    }
    AppMethodBeat.o(195215);
    return this;
  }
  
  public native void dumpNative(String paramString);
  
  public final void geH()
  {
    AppMethodBeat.i(195217);
    if ((this.MLH < 0) || ((this.MLI != 0) && (this.MLI < this.MLH)))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("sizes should not be negative and maxSize should be 0 or greater than minSize: min = " + this.MLH + ", max = " + this.MLI);
      AppMethodBeat.o(195217);
      throw localIllegalArgumentException;
    }
    new StringBuilder("enable mmap? ").append(this.MLL);
    enableMmapHookNative(this.MLL);
    setSampleSizeRangeNative(this.MLH, this.MLI);
    setSamplingNative(this.MLJ);
    enableStacktraceNative(this.MLK);
    AppMethodBeat.o(195217);
  }
  
  public final void geI()
  {
    AppMethodBeat.i(195218);
    addHookSoNative((String[])this.MLF.toArray(new String[0]));
    addIgnoreSoNative((String[])this.MLG.toArray(new String[0]));
    AppMethodBeat.o(195218);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.wxperf.jni.memory.MemoryHook
 * JD-Core Version:    0.7.0.1
 */