package com.tencent.tbs.one.impl.a;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;

public final class m
{
  private static final Object b;
  private static HandlerThread c;
  private static Handler d;
  
  static
  {
    AppMethodBeat.i(173937);
    if (!m.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      b = new Object();
      AppMethodBeat.o(173937);
      return;
    }
  }
  
  public static Handler a()
  {
    AppMethodBeat.i(173931);
    synchronized (b)
    {
      if (d == null)
      {
        localObject2 = new HandlerThread("TBSOneThread");
        c = (HandlerThread)localObject2;
        ((HandlerThread)localObject2).start();
        d = new Handler(c.getLooper());
      }
      Object localObject2 = d;
      AppMethodBeat.o(173931);
      return localObject2;
    }
  }
  
  public static void a(Runnable paramRunnable)
  {
    AppMethodBeat.i(173932);
    if (b())
    {
      paramRunnable.run();
      AppMethodBeat.o(173932);
      return;
    }
    a().post(paramRunnable);
    AppMethodBeat.o(173932);
  }
  
  public static void b(Runnable paramRunnable)
  {
    AppMethodBeat.i(173933);
    a().post(paramRunnable);
    AppMethodBeat.o(173933);
  }
  
  public static boolean b()
  {
    AppMethodBeat.i(173935);
    if (a().getLooper() == Looper.myLooper())
    {
      AppMethodBeat.o(173935);
      return true;
    }
    AppMethodBeat.o(173935);
    return false;
  }
  
  public static void c(Runnable paramRunnable)
  {
    AppMethodBeat.i(173934);
    a().postDelayed(paramRunnable, 2000L);
    AppMethodBeat.o(173934);
  }
  
  public static void d(Runnable paramRunnable)
  {
    AppMethodBeat.i(173936);
    AsyncTask.THREAD_POOL_EXECUTOR.execute(paramRunnable);
    AppMethodBeat.o(173936);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tbs.one.impl.a.m
 * JD-Core Version:    0.7.0.1
 */