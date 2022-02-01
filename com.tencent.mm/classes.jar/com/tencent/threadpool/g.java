package com.tencent.threadpool;

import android.content.Context;
import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.threadpool.c.b;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;

public final class g
{
  private static Executor ahAz;
  
  public static void a(Context paramContext, a parama)
  {
    AppMethodBeat.i(183142);
    parama.a(new c()
    {
      public final void a(d.a paramAnonymousa)
      {
        d.ahAq = paramAnonymousa;
      }
      
      public final void a(d.e paramAnonymouse)
      {
        d.ahAo = paramAnonymouse;
      }
      
      public final void a(d.f paramAnonymousf)
      {
        d.ahAp = paramAnonymousf;
      }
    });
    a locala = parama.a(new a.a());
    b.ahBl = new com.tencent.threadpool.b.a(paramContext, locala);
    com.tencent.threadpool.g.h.ahBK = com.tencent.threadpool.g.h.b(locala);
    h.a(locala);
    if (locala.ahzT) {
      jYU();
    }
    if (locala.ahzU) {}
    try
    {
      Class.forName("com.tencent.threadpool.coroutines.hook.CoroutineDispatchersHookInitializer").getDeclaredMethod("setup", new Class[0]).invoke(null, new Object[0]);
      parama.aKR();
      AppMethodBeat.o(183142);
      return;
    }
    catch (ClassNotFoundException paramContext)
    {
      paramContext = new IllegalArgumentException("Cannot enable hook coroutines dispatchers without depending threadpool-coroutines.");
      AppMethodBeat.o(183142);
      throw paramContext;
    }
    catch (NoSuchMethodException paramContext)
    {
      paramContext = new IllegalStateException("ThreadPool internal error. Cannot find method setup in coroutines dispatchers hook initializer.");
      AppMethodBeat.o(183142);
      throw paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext = new IllegalStateException("ThreadPool internal error. Cannot call method setup in coroutines dispatchers hook initializer.");
      AppMethodBeat.o(183142);
      throw paramContext;
    }
  }
  
  private static void jYU()
  {
    AppMethodBeat.i(183144);
    try
    {
      ahAz = (Executor)com.tencent.threadpool.l.c.n(AsyncTask.class, "THREAD_POOL_EXECUTOR");
      com.tencent.threadpool.l.c.c(AsyncTask.class, "THREAD_POOL_EXECUTOR", new g.2());
      AppMethodBeat.o(183144);
      return;
    }
    catch (Exception localException)
    {
      d.ahAq.e("ThreadModuleBoot", localException.toString(), new Object[0]);
      AppMethodBeat.o(183144);
    }
  }
  
  public static void shutdown()
  {
    AppMethodBeat.i(183143);
    h.ahAA.jYV();
    b.ahBl.ayG();
    if (h.ahAA.jYW().ahzT) {}
    try
    {
      com.tencent.threadpool.l.c.c(AsyncTask.class, "THREAD_POOL_EXECUTOR", ahAz);
      ahAz = null;
      AppMethodBeat.o(183143);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        d.ahAq.e("ThreadModuleBoot", localException.toString(), new Object[0]);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract a a(a.a parama);
    
    public abstract void a(g.c paramc);
    
    public abstract void aKR();
  }
  
  public static abstract interface b
  {
    public abstract void a(Thread paramThread, String paramString);
    
    public abstract boolean gzk();
    
    public abstract boolean gzl();
    
    public abstract boolean gzm();
  }
  
  public static abstract interface c
  {
    public abstract void a(d.a parama);
    
    public abstract void a(d.e parame);
    
    public abstract void a(d.f paramf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.threadpool.g
 * JD-Core Version:    0.7.0.1
 */