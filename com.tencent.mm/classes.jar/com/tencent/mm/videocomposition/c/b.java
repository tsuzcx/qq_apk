package com.tencent.mm.videocomposition.c;

import android.os.Looper;
import android.os.Process;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.ad;
import d.g.b.p;
import d.l;
import java.util.Arrays;

@l(gfx={1, 1, 15}, gfy={""}, gfz={"Lcom/tencent/mm/videocomposition/sdk/CLog;", "", "()V", "LEVEL_DEBUG", "", "LEVEL_ERROR", "LEVEL_FATAL", "LEVEL_INFO", "LEVEL_NONE", "LEVEL_VERBOSE", "LEVEL_WARNING", "logImp", "Lcom/tencent/mm/videocomposition/sdk/CLog$LogImp;", "d", "", "tag", "", "format", "obj", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V", "e", "f", "getStack", "Lcom/tencent/mm/videocomposition/sdk/MMStack;", "i", "printDebugStack", "printErrStackTrace", "tr", "", "(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V", "printInfoStack", "setLogImpl", "v", "w", "LogImp", "video_composition_release"})
public final class b
{
  private static a LnD;
  public static final b LnE;
  
  static
  {
    AppMethodBeat.i(220925);
    LnE = new b();
    AppMethodBeat.o(220925);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(220917);
    p.h(parama, "logImp");
    LnD = parama;
    AppMethodBeat.o(220917);
  }
  
  public static final void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(220921);
    p.h(paramVarArgs, "obj");
    a locala = LnD;
    if (locala != null)
    {
      ad localad = ad.MLZ;
      if (paramString2 == null) {
        p.gfZ();
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
      locala.kj(paramString1, paramString2);
      AppMethodBeat.o(220921);
      return;
    }
    AppMethodBeat.o(220921);
  }
  
  public static final void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(220918);
    p.h(paramVarArgs, "obj");
    a locala = LnD;
    if (locala != null)
    {
      ad localad = ad.MLZ;
      if (paramString2 == null) {
        p.gfZ();
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
      locala.kk(paramString1, paramString2);
      AppMethodBeat.o(220918);
      return;
    }
    AppMethodBeat.o(220918);
  }
  
  public static final void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(220920);
    p.h(paramVarArgs, "obj");
    a locala = LnD;
    if (locala != null)
    {
      ad localad = ad.MLZ;
      if (paramString2 == null) {
        p.gfZ();
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
      locala.kl(paramString1, paramString2);
      AppMethodBeat.o(220920);
      return;
    }
    AppMethodBeat.o(220920);
  }
  
  public static final void m(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(220923);
    p.h(paramVarArgs, "obj");
    a locala = LnD;
    if (locala != null)
    {
      ad localad = ad.MLZ;
      if (paramString2 == null) {
        p.gfZ();
      }
      paramVarArgs = Arrays.copyOf(paramVarArgs, 0);
      paramVarArgs = String.format(paramString2, Arrays.copyOf(paramVarArgs, paramVarArgs.length));
      p.g(paramVarArgs, "java.lang.String.format(format, *args)");
      paramString2 = paramVarArgs;
      if (paramVarArgs == null) {
        paramString2 = "";
      }
      paramString2 = paramString2 + "  " + new c();
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
      locala.kl(paramString1, paramString2);
      AppMethodBeat.o(220923);
      return;
    }
    AppMethodBeat.o(220923);
  }
  
  public static final void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(220924);
    p.h(paramVarArgs, "obj");
    a locala = LnD;
    if (locala != null)
    {
      ad localad = ad.MLZ;
      if (paramString2 == null) {
        p.gfZ();
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
      locala.kk(paramString1, paramThrowable);
      AppMethodBeat.o(220924);
      return;
    }
    AppMethodBeat.o(220924);
  }
  
  public static final void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(220922);
    p.h(paramVarArgs, "obj");
    a locala = LnD;
    if (locala != null)
    {
      ad localad = ad.MLZ;
      if (paramString2 == null) {
        p.gfZ();
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
      locala.km(paramString1, paramString2);
      AppMethodBeat.o(220922);
      return;
    }
    AppMethodBeat.o(220922);
  }
  
  public static final void y(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(220919);
    p.h(paramVarArgs, "obj");
    a locala = LnD;
    if (locala != null)
    {
      ad localad = ad.MLZ;
      if (paramString == null) {
        p.gfZ();
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
      locala.aDo(paramString);
      AppMethodBeat.o(220919);
      return;
    }
    AppMethodBeat.o(220919);
  }
  
  @l(gfx={1, 1, 15}, gfy={""}, gfz={"Lcom/tencent/mm/videocomposition/sdk/CLog$LogImp;", "", "logLevel", "", "getLogLevel", "()I", "logD", "", "tag", "", "filename", "funcname", "linuxTid", "pid", "tid", "", "maintid", "log", "logE", "logF", "logI", "logV", "logW", "video_composition_release"})
  public static abstract interface a
  {
    public abstract void aDo(String paramString);
    
    public abstract void kj(String paramString1, String paramString2);
    
    public abstract void kk(String paramString1, String paramString2);
    
    public abstract void kl(String paramString1, String paramString2);
    
    public abstract void km(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.videocomposition.c.b
 * JD-Core Version:    0.7.0.1
 */