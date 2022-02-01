package com.tencent.mm.videocomposition.c;

import android.os.Looper;
import android.os.Process;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.ad;
import d.g.b.p;
import d.l;
import java.util.Arrays;

@l(gjZ={1, 1, 15}, gka={""}, gkb={"Lcom/tencent/mm/videocomposition/sdk/CLog;", "", "()V", "LEVEL_DEBUG", "", "LEVEL_ERROR", "LEVEL_FATAL", "LEVEL_INFO", "LEVEL_NONE", "LEVEL_VERBOSE", "LEVEL_WARNING", "logImp", "Lcom/tencent/mm/videocomposition/sdk/CLog$LogImp;", "d", "", "tag", "", "format", "obj", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V", "e", "f", "getStack", "Lcom/tencent/mm/videocomposition/sdk/MMStack;", "i", "printDebugStack", "printErrStackTrace", "tr", "", "(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V", "printInfoStack", "setLogImpl", "v", "w", "LogImp", "video_composition_release"})
public final class b
{
  private static a LKo;
  public static final b LKp;
  
  static
  {
    AppMethodBeat.i(195060);
    LKp = new b();
    AppMethodBeat.o(195060);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(195052);
    p.h(parama, "logImp");
    LKo = parama;
    AppMethodBeat.o(195052);
  }
  
  public static final void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(195056);
    p.h(paramVarArgs, "obj");
    a locala = LKo;
    if (locala != null)
    {
      ad localad = ad.Njc;
      if (paramString2 == null) {
        p.gkB();
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
      locala.kp(paramString1, paramString2);
      AppMethodBeat.o(195056);
      return;
    }
    AppMethodBeat.o(195056);
  }
  
  public static final void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(195053);
    p.h(paramVarArgs, "obj");
    a locala = LKo;
    if (locala != null)
    {
      ad localad = ad.Njc;
      if (paramString2 == null) {
        p.gkB();
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
      locala.kq(paramString1, paramString2);
      AppMethodBeat.o(195053);
      return;
    }
    AppMethodBeat.o(195053);
  }
  
  public static final void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(195055);
    p.h(paramVarArgs, "obj");
    a locala = LKo;
    if (locala != null)
    {
      ad localad = ad.Njc;
      if (paramString2 == null) {
        p.gkB();
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
      locala.kr(paramString1, paramString2);
      AppMethodBeat.o(195055);
      return;
    }
    AppMethodBeat.o(195055);
  }
  
  public static final void m(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(195058);
    p.h(paramVarArgs, "obj");
    a locala = LKo;
    if (locala != null)
    {
      ad localad = ad.Njc;
      if (paramString2 == null) {
        p.gkB();
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
      locala.kr(paramString1, paramString2);
      AppMethodBeat.o(195058);
      return;
    }
    AppMethodBeat.o(195058);
  }
  
  public static final void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(195059);
    p.h(paramVarArgs, "obj");
    a locala = LKo;
    if (locala != null)
    {
      ad localad = ad.Njc;
      if (paramString2 == null) {
        p.gkB();
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
      locala.kq(paramString1, paramThrowable);
      AppMethodBeat.o(195059);
      return;
    }
    AppMethodBeat.o(195059);
  }
  
  public static final void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(195057);
    p.h(paramVarArgs, "obj");
    a locala = LKo;
    if (locala != null)
    {
      ad localad = ad.Njc;
      if (paramString2 == null) {
        p.gkB();
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
      locala.ks(paramString1, paramString2);
      AppMethodBeat.o(195057);
      return;
    }
    AppMethodBeat.o(195057);
  }
  
  public static final void y(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(195054);
    p.h(paramVarArgs, "obj");
    a locala = LKo;
    if (locala != null)
    {
      ad localad = ad.Njc;
      if (paramString == null) {
        p.gkB();
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
      locala.aEH(paramString);
      AppMethodBeat.o(195054);
      return;
    }
    AppMethodBeat.o(195054);
  }
  
  @l(gjZ={1, 1, 15}, gka={""}, gkb={"Lcom/tencent/mm/videocomposition/sdk/CLog$LogImp;", "", "logLevel", "", "getLogLevel", "()I", "logD", "", "tag", "", "filename", "funcname", "linuxTid", "pid", "tid", "", "maintid", "log", "logE", "logF", "logI", "logV", "logW", "video_composition_release"})
  public static abstract interface a
  {
    public abstract void aEH(String paramString);
    
    public abstract void kp(String paramString1, String paramString2);
    
    public abstract void kq(String paramString1, String paramString2);
    
    public abstract void kr(String paramString1, String paramString2);
    
    public abstract void ks(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.videocomposition.c.b
 * JD-Core Version:    0.7.0.1
 */