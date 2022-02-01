package com.tencent.skyline;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.skyline.jni.SkylineLibraryLoader;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/skyline/TraceLogic;", "", "()V", "TAG", "", "flushTrace", "", "initTraceBinding", "isolatePtr", "", "contextPtr", "nativeFlushTrace", "nativeInitTraceBinding", "nativeStartTrace", "nativeStopTrace", "filePath", "nativeTraceBegin", "category", "name", "nativeTraceDebugBegin", "nativeTraceDebugEnd", "nativeTraceDebugInstant", "nativeTraceEnd", "nativeTraceInstant", "startTrace", "stopTrace", "traceBegin", "traceDebugBegin", "traceDebugEnd", "traceDebugInstant", "traceEnd", "traceInstant", "skyline_android_lib_release"}, k=1, mv={1, 1, 16})
public final class TraceLogic
{
  public static final TraceLogic INSTANCE;
  private static final String TAG = "Skyline.TraceLogic";
  
  static
  {
    AppMethodBeat.i(210699);
    INSTANCE = new TraceLogic();
    SkylineLibraryLoader.load("trace");
    AppMethodBeat.o(210699);
  }
  
  private final native void nativeFlushTrace();
  
  private final native void nativeInitTraceBinding(long paramLong1, long paramLong2);
  
  private final native void nativeStartTrace();
  
  private final native void nativeStopTrace(String paramString);
  
  private final native void nativeTraceBegin(String paramString1, String paramString2);
  
  private final native void nativeTraceDebugBegin(String paramString1, String paramString2);
  
  private final native void nativeTraceDebugEnd();
  
  private final native void nativeTraceDebugInstant(String paramString1, String paramString2);
  
  private final native void nativeTraceEnd();
  
  private final native void nativeTraceInstant(String paramString1, String paramString2);
  
  public final void flushTrace()
  {
    AppMethodBeat.i(210709);
    nativeFlushTrace();
    AppMethodBeat.o(210709);
  }
  
  public final void initTraceBinding(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(210748);
    nativeInitTraceBinding(paramLong1, paramLong2);
    AppMethodBeat.o(210748);
  }
  
  public final void startTrace()
  {
    AppMethodBeat.i(210703);
    nativeStartTrace();
    AppMethodBeat.o(210703);
  }
  
  public final void stopTrace(String paramString)
  {
    AppMethodBeat.i(210715);
    s.t(paramString, "filePath");
    nativeStopTrace(paramString);
    AppMethodBeat.o(210715);
  }
  
  public final void traceBegin(String paramString1, String paramString2)
  {
    AppMethodBeat.i(210719);
    s.t(paramString1, "category");
    s.t(paramString2, "name");
    nativeTraceBegin(paramString1, paramString2);
    AppMethodBeat.o(210719);
  }
  
  public final void traceDebugBegin(String paramString1, String paramString2)
  {
    AppMethodBeat.i(210728);
    s.t(paramString1, "category");
    s.t(paramString2, "name");
    nativeTraceDebugBegin(paramString1, paramString2);
    AppMethodBeat.o(210728);
  }
  
  public final void traceDebugEnd()
  {
    AppMethodBeat.i(210731);
    nativeTraceDebugEnd();
    AppMethodBeat.o(210731);
  }
  
  public final void traceDebugInstant(String paramString1, String paramString2)
  {
    AppMethodBeat.i(210743);
    s.t(paramString1, "category");
    s.t(paramString2, "name");
    nativeTraceDebugInstant(paramString1, paramString2);
    AppMethodBeat.o(210743);
  }
  
  public final void traceEnd()
  {
    AppMethodBeat.i(210724);
    nativeTraceEnd();
    AppMethodBeat.o(210724);
  }
  
  public final void traceInstant(String paramString1, String paramString2)
  {
    AppMethodBeat.i(210734);
    s.t(paramString1, "category");
    s.t(paramString2, "name");
    nativeTraceInstant(paramString1, paramString2);
    AppMethodBeat.o(210734);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.skyline.TraceLogic
 * JD-Core Version:    0.7.0.1
 */