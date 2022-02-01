package com.tencent.mm.videocomposition.d;

import android.os.Looper;
import android.os.Process;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.g.b.am;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/videocomposition/sdk/CLog;", "", "()V", "LEVEL_DEBUG", "", "LEVEL_ERROR", "LEVEL_FATAL", "LEVEL_INFO", "LEVEL_NONE", "LEVEL_VERBOSE", "LEVEL_WARNING", "logImp", "Lcom/tencent/mm/videocomposition/sdk/CLog$LogImp;", "d", "", "tag", "", "format", "obj", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V", "e", "f", "getStack", "Lcom/tencent/mm/videocomposition/sdk/MMStack;", "i", "printDebugStack", "printErrStackTrace", "tr", "", "(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V", "printInfoStack", "setLogImpl", "v", "w", "LogImp", "video_composition_release"}, k=1, mv={1, 1, 15})
public final class b
{
  private static a agFG;
  public static final b agFH;
  
  static
  {
    AppMethodBeat.i(233756);
    agFH = new b();
    AppMethodBeat.o(233756);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(233706);
    s.t(parama, "logImp");
    agFG = parama;
    AppMethodBeat.o(233706);
  }
  
  public static final void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    int j = 1;
    AppMethodBeat.i(233731);
    s.t(paramVarArgs, "obj");
    a locala = agFG;
    if (locala != null)
    {
      int i;
      if (locala.getLogLevel() <= 1)
      {
        if (paramVarArgs.length != 0) {
          break label126;
        }
        i = 1;
        if (i == 0) {
          break label131;
        }
        i = j;
        label49:
        if (i == 0) {
          break label136;
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
        s.r(paramString2, "Thread.currentThread()");
        paramString2.getId();
        paramString2 = Looper.getMainLooper();
        s.r(paramString2, "Looper.getMainLooper()");
        paramString2 = paramString2.getThread();
        s.r(paramString2, "Looper.getMainLooper().thread");
        paramString2.getId();
        locala.oU(paramString1, paramVarArgs);
        AppMethodBeat.o(233731);
        return;
        label126:
        i = 0;
        break;
        label131:
        i = 0;
        break label49;
        label136:
        am localam = am.aixg;
        if (paramString2 == null) {
          s.klw();
        }
        paramVarArgs = Arrays.copyOf(paramVarArgs, paramVarArgs.length);
        paramString2 = String.format(paramString2, Arrays.copyOf(paramVarArgs, paramVarArgs.length));
        s.r(paramString2, "java.lang.String.format(format, *args)");
      }
    }
    AppMethodBeat.o(233731);
  }
  
  public static final void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    int j = 1;
    AppMethodBeat.i(233715);
    s.t(paramVarArgs, "obj");
    a locala = agFG;
    if (locala != null)
    {
      int i;
      if (locala.getLogLevel() <= 4)
      {
        if (paramVarArgs.length != 0) {
          break label126;
        }
        i = 1;
        if (i == 0) {
          break label131;
        }
        i = j;
        label49:
        if (i == 0) {
          break label136;
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
        s.r(paramString2, "Thread.currentThread()");
        paramString2.getId();
        paramString2 = Looper.getMainLooper();
        s.r(paramString2, "Looper.getMainLooper()");
        paramString2 = paramString2.getThread();
        s.r(paramString2, "Looper.getMainLooper().thread");
        paramString2.getId();
        locala.oV(paramString1, paramVarArgs);
        AppMethodBeat.o(233715);
        return;
        label126:
        i = 0;
        break;
        label131:
        i = 0;
        break label49;
        label136:
        am localam = am.aixg;
        if (paramString2 == null) {
          s.klw();
        }
        paramVarArgs = Arrays.copyOf(paramVarArgs, paramVarArgs.length);
        paramString2 = String.format(paramString2, Arrays.copyOf(paramVarArgs, paramVarArgs.length));
        s.r(paramString2, "java.lang.String.format(format, *args)");
      }
    }
    AppMethodBeat.o(233715);
  }
  
  public static final void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    int j = 1;
    AppMethodBeat.i(233725);
    s.t(paramVarArgs, "obj");
    a locala = agFG;
    if (locala != null)
    {
      int i;
      if (locala.getLogLevel() <= 2)
      {
        if (paramVarArgs.length != 0) {
          break label126;
        }
        i = 1;
        if (i == 0) {
          break label131;
        }
        i = j;
        label49:
        if (i == 0) {
          break label136;
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
        s.r(paramString2, "Thread.currentThread()");
        paramString2.getId();
        paramString2 = Looper.getMainLooper();
        s.r(paramString2, "Looper.getMainLooper()");
        paramString2 = paramString2.getThread();
        s.r(paramString2, "Looper.getMainLooper().thread");
        paramString2.getId();
        locala.oW(paramString1, paramVarArgs);
        AppMethodBeat.o(233725);
        return;
        label126:
        i = 0;
        break;
        label131:
        i = 0;
        break label49;
        label136:
        am localam = am.aixg;
        if (paramString2 == null) {
          s.klw();
        }
        paramVarArgs = Arrays.copyOf(paramVarArgs, paramVarArgs.length);
        paramString2 = String.format(paramString2, Arrays.copyOf(paramVarArgs, paramVarArgs.length));
        s.r(paramString2, "java.lang.String.format(format, *args)");
      }
    }
    AppMethodBeat.o(233725);
  }
  
  public static final void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(233751);
    s.t(paramVarArgs, "obj");
    a locala = agFG;
    if (locala != null)
    {
      if (locala.getLogLevel() <= 4)
      {
        paramVarArgs = paramString2;
        if (paramString2 == null) {
          paramVarArgs = "";
        }
        paramThrowable = paramVarArgs + "  " + Log.getStackTraceString(paramThrowable);
        Process.myTid();
        Process.myPid();
        paramString2 = Thread.currentThread();
        s.r(paramString2, "Thread.currentThread()");
        paramString2.getId();
        paramString2 = Looper.getMainLooper();
        s.r(paramString2, "Looper.getMainLooper()");
        paramString2 = paramString2.getThread();
        s.r(paramString2, "Looper.getMainLooper().thread");
        paramString2.getId();
        locala.oV(paramString1, paramThrowable);
      }
      AppMethodBeat.o(233751);
      return;
    }
    AppMethodBeat.o(233751);
  }
  
  public static final void printInfoStack(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(233745);
    s.t(paramVarArgs, "obj");
    a locala = agFG;
    if (locala != null)
    {
      if (locala.getLogLevel() <= 2)
      {
        paramVarArgs = paramString2;
        if (paramString2 == null) {
          paramVarArgs = "";
        }
        paramString2 = paramVarArgs + "  " + new e();
        Process.myTid();
        Process.myPid();
        paramVarArgs = Thread.currentThread();
        s.r(paramVarArgs, "Thread.currentThread()");
        paramVarArgs.getId();
        paramVarArgs = Looper.getMainLooper();
        s.r(paramVarArgs, "Looper.getMainLooper()");
        paramVarArgs = paramVarArgs.getThread();
        s.r(paramVarArgs, "Looper.getMainLooper().thread");
        paramVarArgs.getId();
        locala.oW(paramString1, paramString2);
      }
      AppMethodBeat.o(233745);
      return;
    }
    AppMethodBeat.o(233745);
  }
  
  public static final void s(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(233720);
    s.t(paramVarArgs, "obj");
    a locala = agFG;
    if (locala != null)
    {
      if (locala.getLogLevel() <= 3)
      {
        paramVarArgs = paramString;
        if (paramString == null) {
          paramVarArgs = "";
        }
        Process.myTid();
        Process.myPid();
        paramString = Thread.currentThread();
        s.r(paramString, "Thread.currentThread()");
        paramString.getId();
        paramString = Looper.getMainLooper();
        s.r(paramString, "Looper.getMainLooper()");
        paramString = paramString.getThread();
        s.r(paramString, "Looper.getMainLooper().thread");
        paramString.getId();
        locala.boH(paramVarArgs);
      }
      AppMethodBeat.o(233720);
      return;
    }
    AppMethodBeat.o(233720);
  }
  
  public static final void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(233739);
    s.t(paramVarArgs, "obj");
    a locala = agFG;
    if (locala != null)
    {
      if (locala.getLogLevel() <= 0)
      {
        paramVarArgs = paramString2;
        if (paramString2 == null) {
          paramVarArgs = "";
        }
        Process.myTid();
        Process.myPid();
        paramString2 = Thread.currentThread();
        s.r(paramString2, "Thread.currentThread()");
        paramString2.getId();
        paramString2 = Looper.getMainLooper();
        s.r(paramString2, "Looper.getMainLooper()");
        paramString2 = paramString2.getThread();
        s.r(paramString2, "Looper.getMainLooper().thread");
        paramString2.getId();
        locala.oX(paramString1, paramVarArgs);
      }
      AppMethodBeat.o(233739);
      return;
    }
    AppMethodBeat.o(233739);
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/videocomposition/sdk/CLog$LogImp;", "", "logLevel", "", "getLogLevel", "()I", "logD", "", "tag", "", "filename", "funcname", "linuxTid", "pid", "tid", "", "maintid", "log", "logE", "logF", "logI", "logV", "logW", "video_composition_release"}, k=1, mv={1, 1, 15})
  public static abstract interface a
  {
    public abstract void boH(String paramString);
    
    public abstract int getLogLevel();
    
    public abstract void oU(String paramString1, String paramString2);
    
    public abstract void oV(String paramString1, String paramString2);
    
    public abstract void oW(String paramString1, String paramString2);
    
    public abstract void oX(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.videocomposition.d.b
 * JD-Core Version:    0.7.0.1
 */