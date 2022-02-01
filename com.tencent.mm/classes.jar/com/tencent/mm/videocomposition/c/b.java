package com.tencent.mm.videocomposition.c;

import android.os.Looper;
import android.os.Process;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/videocomposition/sdk/CLog;", "", "()V", "LEVEL_DEBUG", "", "LEVEL_ERROR", "LEVEL_FATAL", "LEVEL_INFO", "LEVEL_NONE", "LEVEL_VERBOSE", "LEVEL_WARNING", "logImp", "Lcom/tencent/mm/videocomposition/sdk/CLog$LogImp;", "d", "", "tag", "", "format", "obj", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V", "e", "f", "getStack", "Lcom/tencent/mm/videocomposition/sdk/MMStack;", "i", "printDebugStack", "printErrStackTrace", "tr", "", "(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V", "printInfoStack", "setLogImpl", "v", "w", "LogImp", "video_composition_release"})
public final class b
{
  private static a YJO;
  public static final b YJP;
  
  static
  {
    AppMethodBeat.i(248592);
    YJP = new b();
    AppMethodBeat.o(248592);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(248580);
    p.k(parama, "logImp");
    YJO = parama;
    AppMethodBeat.o(248580);
  }
  
  public static final void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    int j = 1;
    AppMethodBeat.i(248584);
    p.k(paramVarArgs, "obj");
    a locala = YJO;
    if (locala != null)
    {
      int i;
      if (paramVarArgs.length == 0)
      {
        i = 1;
        if (i == 0) {
          break label120;
        }
        i = j;
        label38:
        if (i == 0) {
          break label125;
        }
      }
      for (;;)
      {
        paramVarArgs = paramString2;
        if (paramString2 == null) {
          paramVarArgs = "";
        }
        Process.myTid();
        Process.myPid();
        paramString2 = Thread.currentThread();
        p.j(paramString2, "Thread.currentThread()");
        paramString2.getId();
        paramString2 = Looper.getMainLooper();
        p.j(paramString2, "Looper.getMainLooper()");
        paramString2 = paramString2.getThread();
        p.j(paramString2, "Looper.getMainLooper().thread");
        paramString2.getId();
        locala.mZ(paramString1, paramVarArgs);
        AppMethodBeat.o(248584);
        return;
        i = 0;
        break;
        label120:
        i = 0;
        break label38;
        label125:
        af localaf = af.aaBG;
        if (paramString2 == null) {
          p.iCn();
        }
        paramVarArgs = Arrays.copyOf(paramVarArgs, paramVarArgs.length);
        paramString2 = String.format(paramString2, Arrays.copyOf(paramVarArgs, paramVarArgs.length));
        p.j(paramString2, "java.lang.String.format(format, *args)");
      }
    }
    AppMethodBeat.o(248584);
  }
  
  public static final void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    int j = 1;
    AppMethodBeat.i(248581);
    p.k(paramVarArgs, "obj");
    a locala = YJO;
    if (locala != null)
    {
      int i;
      if (paramVarArgs.length == 0)
      {
        i = 1;
        if (i == 0) {
          break label120;
        }
        i = j;
        label38:
        if (i == 0) {
          break label125;
        }
      }
      for (;;)
      {
        paramVarArgs = paramString2;
        if (paramString2 == null) {
          paramVarArgs = "";
        }
        Process.myTid();
        Process.myPid();
        paramString2 = Thread.currentThread();
        p.j(paramString2, "Thread.currentThread()");
        paramString2.getId();
        paramString2 = Looper.getMainLooper();
        p.j(paramString2, "Looper.getMainLooper()");
        paramString2 = paramString2.getThread();
        p.j(paramString2, "Looper.getMainLooper().thread");
        paramString2.getId();
        locala.na(paramString1, paramVarArgs);
        AppMethodBeat.o(248581);
        return;
        i = 0;
        break;
        label120:
        i = 0;
        break label38;
        label125:
        af localaf = af.aaBG;
        if (paramString2 == null) {
          p.iCn();
        }
        paramVarArgs = Arrays.copyOf(paramVarArgs, paramVarArgs.length);
        paramString2 = String.format(paramString2, Arrays.copyOf(paramVarArgs, paramVarArgs.length));
        p.j(paramString2, "java.lang.String.format(format, *args)");
      }
    }
    AppMethodBeat.o(248581);
  }
  
  public static final void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    int j = 1;
    AppMethodBeat.i(248583);
    p.k(paramVarArgs, "obj");
    a locala = YJO;
    if (locala != null)
    {
      int i;
      if (paramVarArgs.length == 0)
      {
        i = 1;
        if (i == 0) {
          break label120;
        }
        i = j;
        label38:
        if (i == 0) {
          break label125;
        }
      }
      for (;;)
      {
        paramVarArgs = paramString2;
        if (paramString2 == null) {
          paramVarArgs = "";
        }
        Process.myTid();
        Process.myPid();
        paramString2 = Thread.currentThread();
        p.j(paramString2, "Thread.currentThread()");
        paramString2.getId();
        paramString2 = Looper.getMainLooper();
        p.j(paramString2, "Looper.getMainLooper()");
        paramString2 = paramString2.getThread();
        p.j(paramString2, "Looper.getMainLooper().thread");
        paramString2.getId();
        locala.nb(paramString1, paramVarArgs);
        AppMethodBeat.o(248583);
        return;
        i = 0;
        break;
        label120:
        i = 0;
        break label38;
        label125:
        af localaf = af.aaBG;
        if (paramString2 == null) {
          p.iCn();
        }
        paramVarArgs = Arrays.copyOf(paramVarArgs, paramVarArgs.length);
        paramString2 = String.format(paramString2, Arrays.copyOf(paramVarArgs, paramVarArgs.length));
        p.j(paramString2, "java.lang.String.format(format, *args)");
      }
    }
    AppMethodBeat.o(248583);
  }
  
  public static final void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(248590);
    p.k(paramVarArgs, "obj");
    a locala = YJO;
    if (locala != null)
    {
      paramVarArgs = paramString2;
      if (paramString2 == null) {
        paramVarArgs = "";
      }
      paramThrowable = paramVarArgs + "  " + Log.getStackTraceString(paramThrowable);
      Process.myTid();
      Process.myPid();
      paramString2 = Thread.currentThread();
      p.j(paramString2, "Thread.currentThread()");
      paramString2.getId();
      paramString2 = Looper.getMainLooper();
      p.j(paramString2, "Looper.getMainLooper()");
      paramString2 = paramString2.getThread();
      p.j(paramString2, "Looper.getMainLooper().thread");
      paramString2.getId();
      locala.na(paramString1, paramThrowable);
      AppMethodBeat.o(248590);
      return;
    }
    AppMethodBeat.o(248590);
  }
  
  public static final void printInfoStack(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(248588);
    p.k(paramVarArgs, "obj");
    a locala = YJO;
    if (locala != null)
    {
      paramVarArgs = paramString2;
      if (paramString2 == null) {
        paramVarArgs = "";
      }
      paramString2 = paramVarArgs + "  " + new e();
      Process.myTid();
      Process.myPid();
      paramVarArgs = Thread.currentThread();
      p.j(paramVarArgs, "Thread.currentThread()");
      paramVarArgs.getId();
      paramVarArgs = Looper.getMainLooper();
      p.j(paramVarArgs, "Looper.getMainLooper()");
      paramVarArgs = paramVarArgs.getThread();
      p.j(paramVarArgs, "Looper.getMainLooper().thread");
      paramVarArgs.getId();
      locala.nb(paramString1, paramString2);
      AppMethodBeat.o(248588);
      return;
    }
    AppMethodBeat.o(248588);
  }
  
  public static final void r(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(248582);
    p.k(paramVarArgs, "obj");
    a locala = YJO;
    if (locala != null)
    {
      paramVarArgs = paramString;
      if (paramString == null) {
        paramVarArgs = "";
      }
      Process.myTid();
      Process.myPid();
      paramString = Thread.currentThread();
      p.j(paramString, "Thread.currentThread()");
      paramString.getId();
      paramString = Looper.getMainLooper();
      p.j(paramString, "Looper.getMainLooper()");
      paramString = paramString.getThread();
      p.j(paramString, "Looper.getMainLooper().thread");
      paramString.getId();
      locala.boR(paramVarArgs);
      AppMethodBeat.o(248582);
      return;
    }
    AppMethodBeat.o(248582);
  }
  
  public static final void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(248586);
    p.k(paramVarArgs, "obj");
    a locala = YJO;
    if (locala != null)
    {
      paramVarArgs = paramString2;
      if (paramString2 == null) {
        paramVarArgs = "";
      }
      Process.myTid();
      Process.myPid();
      paramString2 = Thread.currentThread();
      p.j(paramString2, "Thread.currentThread()");
      paramString2.getId();
      paramString2 = Looper.getMainLooper();
      p.j(paramString2, "Looper.getMainLooper()");
      paramString2 = paramString2.getThread();
      p.j(paramString2, "Looper.getMainLooper().thread");
      paramString2.getId();
      locala.nc(paramString1, paramVarArgs);
      AppMethodBeat.o(248586);
      return;
    }
    AppMethodBeat.o(248586);
  }
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/videocomposition/sdk/CLog$LogImp;", "", "logLevel", "", "getLogLevel", "()I", "logD", "", "tag", "", "filename", "funcname", "linuxTid", "pid", "tid", "", "maintid", "log", "logE", "logF", "logI", "logV", "logW", "video_composition_release"})
  public static abstract interface a
  {
    public abstract void boR(String paramString);
    
    public abstract void mZ(String paramString1, String paramString2);
    
    public abstract void na(String paramString1, String paramString2);
    
    public abstract void nb(String paramString1, String paramString2);
    
    public abstract void nc(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.videocomposition.c.b
 * JD-Core Version:    0.7.0.1
 */