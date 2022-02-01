package com.tencent.wxperf.jni.pthread;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wxperf.jni.HookManager;
import com.tencent.wxperf.jni.a;
import java.util.HashSet;
import java.util.Set;

public class PthreadHook
  extends a
{
  public static final PthreadHook MLM;
  private Set<String> MLF;
  private Set<String> MLG;
  private Set<String> MLN;
  
  static
  {
    AppMethodBeat.i(195230);
    MLM = new PthreadHook();
    AppMethodBeat.o(195230);
  }
  
  private PthreadHook()
  {
    AppMethodBeat.i(195220);
    this.MLF = new HashSet();
    this.MLG = new HashSet();
    this.MLN = new HashSet();
    AppMethodBeat.o(195220);
  }
  
  private native void addHookSoNative(String[] paramArrayOfString);
  
  private native void addHookThreadNameNative(String[] paramArrayOfString);
  
  private native void addIgnoreSoNative(String[] paramArrayOfString);
  
  private PthreadHook bbV(String paramString)
  {
    AppMethodBeat.i(195221);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new IllegalArgumentException("so regex = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(195221);
      throw paramString;
    }
    this.MLF.add(paramString);
    AppMethodBeat.o(195221);
    return this;
  }
  
  private PthreadHook bbW(String paramString)
  {
    AppMethodBeat.i(195223);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(195223);
      return this;
    }
    this.MLG.add(paramString);
    AppMethodBeat.o(195223);
    return this;
  }
  
  private PthreadHook bbX(String paramString)
  {
    AppMethodBeat.i(195225);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new IllegalArgumentException("thread regex should NOT be empty");
      AppMethodBeat.o(195225);
      throw paramString;
    }
    this.MLN.add(paramString);
    AppMethodBeat.o(195225);
    return this;
  }
  
  private native void dumpNative(String paramString);
  
  public final PthreadHook ai(String... paramVarArgs)
  {
    AppMethodBeat.i(195222);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      bbV(paramVarArgs[i]);
      i += 1;
    }
    AppMethodBeat.o(195222);
    return this;
  }
  
  public final PthreadHook aj(String... paramVarArgs)
  {
    AppMethodBeat.i(195224);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      bbW(paramVarArgs[i]);
      i += 1;
    }
    AppMethodBeat.o(195224);
    return this;
  }
  
  public final PthreadHook ak(String... paramVarArgs)
  {
    AppMethodBeat.i(195226);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      bbX(paramVarArgs[i]);
      i += 1;
    }
    AppMethodBeat.o(195226);
    return this;
  }
  
  public final void dump(String paramString)
  {
    AppMethodBeat.i(195227);
    if (HookManager.MLy.MLz) {
      dumpNative(paramString);
    }
    AppMethodBeat.o(195227);
  }
  
  public final void geH()
  {
    AppMethodBeat.i(195228);
    addHookThreadNameNative((String[])this.MLN.toArray(new String[0]));
    AppMethodBeat.o(195228);
  }
  
  public final void geI()
  {
    AppMethodBeat.i(195229);
    addHookSoNative((String[])this.MLF.toArray(new String[0]));
    addIgnoreSoNative((String[])this.MLG.toArray(new String[0]));
    AppMethodBeat.o(195229);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.wxperf.jni.pthread.PthreadHook
 * JD-Core Version:    0.7.0.1
 */