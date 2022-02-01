package com.tencent.wxperf.jni.pthread;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wxperf.jni.a;
import java.util.HashSet;
import java.util.Set;

public class PthreadHook
  extends a
{
  public static final PthreadHook MoQ;
  private Set<String> MoJ;
  private Set<String> MoK;
  private Set<String> MoR;
  
  static
  {
    AppMethodBeat.i(211558);
    MoQ = new PthreadHook();
    AppMethodBeat.o(211558);
  }
  
  private PthreadHook()
  {
    AppMethodBeat.i(211549);
    this.MoJ = new HashSet();
    this.MoK = new HashSet();
    this.MoR = new HashSet();
    AppMethodBeat.o(211549);
  }
  
  private native void addHookSoNative(String[] paramArrayOfString);
  
  private native void addHookThreadNameNative(String[] paramArrayOfString);
  
  private native void addIgnoreSoNative(String[] paramArrayOfString);
  
  private PthreadHook bas(String paramString)
  {
    AppMethodBeat.i(211550);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new IllegalArgumentException("so regex = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(211550);
      throw paramString;
    }
    this.MoJ.add(paramString);
    AppMethodBeat.o(211550);
    return this;
  }
  
  private PthreadHook bat(String paramString)
  {
    AppMethodBeat.i(211552);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(211552);
      return this;
    }
    this.MoK.add(paramString);
    AppMethodBeat.o(211552);
    return this;
  }
  
  private PthreadHook bau(String paramString)
  {
    AppMethodBeat.i(211554);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new IllegalArgumentException("thread regex should NOT be empty");
      AppMethodBeat.o(211554);
      throw paramString;
    }
    this.MoR.add(paramString);
    AppMethodBeat.o(211554);
    return this;
  }
  
  public final PthreadHook ai(String... paramVarArgs)
  {
    AppMethodBeat.i(211551);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      bas(paramVarArgs[i]);
      i += 1;
    }
    AppMethodBeat.o(211551);
    return this;
  }
  
  public final PthreadHook aj(String... paramVarArgs)
  {
    AppMethodBeat.i(211553);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      bat(paramVarArgs[i]);
      i += 1;
    }
    AppMethodBeat.o(211553);
    return this;
  }
  
  public final PthreadHook ak(String... paramVarArgs)
  {
    AppMethodBeat.i(211555);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      bau(paramVarArgs[i]);
      i += 1;
    }
    AppMethodBeat.o(211555);
    return this;
  }
  
  public native void dumpNative(String paramString);
  
  public final void gaf()
  {
    AppMethodBeat.i(211556);
    addHookThreadNameNative((String[])this.MoR.toArray(new String[0]));
    AppMethodBeat.o(211556);
  }
  
  public final void gag()
  {
    AppMethodBeat.i(211557);
    addHookSoNative((String[])this.MoJ.toArray(new String[0]));
    addIgnoreSoNative((String[])this.MoK.toArray(new String[0]));
    AppMethodBeat.o(211557);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.wxperf.jni.pthread.PthreadHook
 * JD-Core Version:    0.7.0.1
 */