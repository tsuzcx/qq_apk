package com.tencent.mm.videocomposition.c;

import android.os.Looper;
import android.os.Process;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 15}, hxE={""}, hxF={"Lcom/tencent/mm/videocomposition/sdk/CLog;", "", "()V", "LEVEL_DEBUG", "", "LEVEL_ERROR", "LEVEL_FATAL", "LEVEL_INFO", "LEVEL_NONE", "LEVEL_VERBOSE", "LEVEL_WARNING", "logImp", "Lcom/tencent/mm/videocomposition/sdk/CLog$LogImp;", "d", "", "tag", "", "format", "obj", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V", "e", "f", "getStack", "Lcom/tencent/mm/videocomposition/sdk/MMStack;", "i", "printDebugStack", "printErrStackTrace", "tr", "", "(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V", "printInfoStack", "setLogImpl", "v", "w", "LogImp", "video_composition_release"})
public final class b
{
  private static a Rih;
  public static final b Rii;
  
  static
  {
    AppMethodBeat.i(216869);
    Rii = new b();
    AppMethodBeat.o(216869);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(216861);
    p.h(parama, "logImp");
    Rih = parama;
    AppMethodBeat.o(216861);
  }
  
  public static final void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(216865);
    p.h(paramVarArgs, "obj");
    a locala = Rih;
    if (locala != null)
    {
      ae localae = ae.SYK;
      if (paramString2 == null) {
        p.hyc();
      }
      paramVarArgs = Arrays.copyOf(paramVarArgs, paramVarArgs.length);
      paramVarArgs = String.format(paramString2, Arrays.copyOf(paramVarArgs, paramVarArgs.length));
      p.g(paramVarArgs, "java.lang.String.format(format, *args)");
      paramString2 = paramVarArgs;
      if (paramVarArgs == null) {
        paramString2 = "";
      }
      Process.myTid();
      Process.myPid();
      paramVarArgs = Thread.currentThread();
      p.g(paramVarArgs, "Thread.currentThread()");
      paramVarArgs.getId();
      paramVarArgs = Looper.getMainLooper();
      p.g(paramVarArgs, "Looper.getMainLooper()");
      paramVarArgs = paramVarArgs.getThread();
      p.g(paramVarArgs, "Looper.getMainLooper().thread");
      paramVarArgs.getId();
      locala.lh(paramString1, paramString2);
      AppMethodBeat.o(216865);
      return;
    }
    AppMethodBeat.o(216865);
  }
  
  public static final void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(216862);
    p.h(paramVarArgs, "obj");
    a locala = Rih;
    if (locala != null)
    {
      ae localae = ae.SYK;
      if (paramString2 == null) {
        p.hyc();
      }
      paramVarArgs = Arrays.copyOf(paramVarArgs, paramVarArgs.length);
      paramVarArgs = String.format(paramString2, Arrays.copyOf(paramVarArgs, paramVarArgs.length));
      p.g(paramVarArgs, "java.lang.String.format(format, *args)");
      paramString2 = paramVarArgs;
      if (paramVarArgs == null) {
        paramString2 = "";
      }
      Process.myTid();
      Process.myPid();
      paramVarArgs = Thread.currentThread();
      p.g(paramVarArgs, "Thread.currentThread()");
      paramVarArgs.getId();
      paramVarArgs = Looper.getMainLooper();
      p.g(paramVarArgs, "Looper.getMainLooper()");
      paramVarArgs = paramVarArgs.getThread();
      p.g(paramVarArgs, "Looper.getMainLooper().thread");
      paramVarArgs.getId();
      locala.li(paramString1, paramString2);
      AppMethodBeat.o(216862);
      return;
    }
    AppMethodBeat.o(216862);
  }
  
  public static final void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(216864);
    p.h(paramVarArgs, "obj");
    a locala = Rih;
    if (locala != null)
    {
      ae localae = ae.SYK;
      if (paramString2 == null) {
        p.hyc();
      }
      paramVarArgs = Arrays.copyOf(paramVarArgs, paramVarArgs.length);
      paramVarArgs = String.format(paramString2, Arrays.copyOf(paramVarArgs, paramVarArgs.length));
      p.g(paramVarArgs, "java.lang.String.format(format, *args)");
      paramString2 = paramVarArgs;
      if (paramVarArgs == null) {
        paramString2 = "";
      }
      Process.myTid();
      Process.myPid();
      paramVarArgs = Thread.currentThread();
      p.g(paramVarArgs, "Thread.currentThread()");
      paramVarArgs.getId();
      paramVarArgs = Looper.getMainLooper();
      p.g(paramVarArgs, "Looper.getMainLooper()");
      paramVarArgs = paramVarArgs.getThread();
      p.g(paramVarArgs, "Looper.getMainLooper().thread");
      paramVarArgs.getId();
      locala.lj(paramString1, paramString2);
      AppMethodBeat.o(216864);
      return;
    }
    AppMethodBeat.o(216864);
  }
  
  public static final void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(216868);
    p.h(paramVarArgs, "obj");
    a locala = Rih;
    if (locala != null)
    {
      ae localae = ae.SYK;
      if (paramString2 == null) {
        p.hyc();
      }
      paramVarArgs = Arrays.copyOf(paramVarArgs, 0);
      paramVarArgs = String.format(paramString2, Arrays.copyOf(paramVarArgs, paramVarArgs.length));
      p.g(paramVarArgs, "java.lang.String.format(format, *args)");
      paramString2 = paramVarArgs;
      if (paramVarArgs == null) {
        paramString2 = "";
      }
      paramThrowable = paramString2 + "  " + Log.getStackTraceString(paramThrowable);
      Process.myTid();
      Process.myPid();
      paramString2 = Thread.currentThread();
      p.g(paramString2, "Thread.currentThread()");
      paramString2.getId();
      paramString2 = Looper.getMainLooper();
      p.g(paramString2, "Looper.getMainLooper()");
      paramString2 = paramString2.getThread();
      p.g(paramString2, "Looper.getMainLooper().thread");
      paramString2.getId();
      locala.li(paramString1, paramThrowable);
      AppMethodBeat.o(216868);
      return;
    }
    AppMethodBeat.o(216868);
  }
  
  public static final void printInfoStack(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(216867);
    p.h(paramVarArgs, "obj");
    a locala = Rih;
    if (locala != null)
    {
      ae localae = ae.SYK;
      if (paramString2 == null) {
        p.hyc();
      }
      paramVarArgs = Arrays.copyOf(paramVarArgs, 0);
      paramVarArgs = String.format(paramString2, Arrays.copyOf(paramVarArgs, paramVarArgs.length));
      p.g(paramVarArgs, "java.lang.String.format(format, *args)");
      paramString2 = paramVarArgs;
      if (paramVarArgs == null) {
        paramString2 = "";
      }
      paramString2 = paramString2 + "  " + new e();
      Process.myTid();
      Process.myPid();
      paramVarArgs = Thread.currentThread();
      p.g(paramVarArgs, "Thread.currentThread()");
      paramVarArgs.getId();
      paramVarArgs = Looper.getMainLooper();
      p.g(paramVarArgs, "Looper.getMainLooper()");
      paramVarArgs = paramVarArgs.getThread();
      p.g(paramVarArgs, "Looper.getMainLooper().thread");
      paramVarArgs.getId();
      locala.lj(paramString1, paramString2);
      AppMethodBeat.o(216867);
      return;
    }
    AppMethodBeat.o(216867);
  }
  
  public static final void s(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(216863);
    p.h(paramVarArgs, "obj");
    a locala = Rih;
    if (locala != null)
    {
      ae localae = ae.SYK;
      if (paramString == null) {
        p.hyc();
      }
      paramVarArgs = Arrays.copyOf(paramVarArgs, 0);
      paramVarArgs = String.format(paramString, Arrays.copyOf(paramVarArgs, paramVarArgs.length));
      p.g(paramVarArgs, "java.lang.String.format(format, *args)");
      paramString = paramVarArgs;
      if (paramVarArgs == null) {
        paramString = "";
      }
      Process.myTid();
      Process.myPid();
      paramVarArgs = Thread.currentThread();
      p.g(paramVarArgs, "Thread.currentThread()");
      paramVarArgs.getId();
      paramVarArgs = Looper.getMainLooper();
      p.g(paramVarArgs, "Looper.getMainLooper()");
      paramVarArgs = paramVarArgs.getThread();
      p.g(paramVarArgs, "Looper.getMainLooper().thread");
      paramVarArgs.getId();
      locala.aTZ(paramString);
      AppMethodBeat.o(216863);
      return;
    }
    AppMethodBeat.o(216863);
  }
  
  public static final void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(216866);
    p.h(paramVarArgs, "obj");
    a locala = Rih;
    if (locala != null)
    {
      ae localae = ae.SYK;
      if (paramString2 == null) {
        p.hyc();
      }
      paramVarArgs = Arrays.copyOf(paramVarArgs, 0);
      paramVarArgs = String.format(paramString2, Arrays.copyOf(paramVarArgs, paramVarArgs.length));
      p.g(paramVarArgs, "java.lang.String.format(format, *args)");
      paramString2 = paramVarArgs;
      if (paramVarArgs == null) {
        paramString2 = "";
      }
      Process.myTid();
      Process.myPid();
      paramVarArgs = Thread.currentThread();
      p.g(paramVarArgs, "Thread.currentThread()");
      paramVarArgs.getId();
      paramVarArgs = Looper.getMainLooper();
      p.g(paramVarArgs, "Looper.getMainLooper()");
      paramVarArgs = paramVarArgs.getThread();
      p.g(paramVarArgs, "Looper.getMainLooper().thread");
      paramVarArgs.getId();
      locala.lk(paramString1, paramString2);
      AppMethodBeat.o(216866);
      return;
    }
    AppMethodBeat.o(216866);
  }
  
  @l(hxD={1, 1, 15}, hxE={""}, hxF={"Lcom/tencent/mm/videocomposition/sdk/CLog$LogImp;", "", "logLevel", "", "getLogLevel", "()I", "logD", "", "tag", "", "filename", "funcname", "linuxTid", "pid", "tid", "", "maintid", "log", "logE", "logF", "logI", "logV", "logW", "video_composition_release"})
  public static abstract interface a
  {
    public abstract void aTZ(String paramString);
    
    public abstract void lh(String paramString1, String paramString2);
    
    public abstract void li(String paramString1, String paramString2);
    
    public abstract void lj(String paramString1, String paramString2);
    
    public abstract void lk(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.videocomposition.c.b
 * JD-Core Version:    0.7.0.1
 */