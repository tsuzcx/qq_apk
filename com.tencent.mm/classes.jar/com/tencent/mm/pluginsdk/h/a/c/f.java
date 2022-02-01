package com.tencent.mm.pluginsdk.h.a.c;

import android.os.Process;
import com.tencent.e.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

public abstract class f<T extends b>
{
  final Map<String, Future<?>> Dlw = new ConcurrentHashMap();
  final Map<String, b> pendingRequests = new ConcurrentHashMap();
  
  protected final void LJ(String paramString)
  {
    Future localFuture = (Future)this.Dlw.remove(paramString);
    if (localFuture != null) {
      localFuture.cancel(true);
    }
    this.pendingRequests.remove(paramString);
  }
  
  protected abstract d a(T paramT);
  
  public final boolean aGE(String paramString)
  {
    return this.Dlw.containsKey(paramString);
  }
  
  /* Error */
  public final boolean aGF(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 33	com/tencent/mm/pluginsdk/h/a/c/f:Dlw	Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface 55 2 0
    //   12: ifne +18 -> 30
    //   15: aload_0
    //   16: getfield 31	com/tencent/mm/pluginsdk/h/a/c/f:pendingRequests	Ljava/util/Map;
    //   19: aload_1
    //   20: invokeinterface 55 2 0
    //   25: istore_2
    //   26: iload_2
    //   27: ifeq +9 -> 36
    //   30: iconst_1
    //   31: istore_2
    //   32: aload_0
    //   33: monitorexit
    //   34: iload_2
    //   35: ireturn
    //   36: iconst_0
    //   37: istore_2
    //   38: goto -6 -> 32
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	this	f
    //   0	46	1	paramString	String
    //   25	13	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	26	41	finally
  }
  
  protected final void b(T paramT)
  {
    this.pendingRequests.put(paramT.eLF(), paramT);
    eLR().submit(a(paramT));
  }
  
  protected abstract b eLR();
  
  public final class a
    extends b
  {
    public a(int paramInt1, int paramInt2, BlockingQueue<Runnable> paramBlockingQueue)
    {
      super(paramInt2, paramBlockingQueue, localBlockingQueue);
    }
    
    public final void afterExecute(Runnable paramRunnable, Throwable paramThrowable)
    {
      AppMethodBeat.i(152014);
      if ((paramRunnable instanceof f.c))
      {
        f.c localc = (f.c)paramRunnable;
        f.this.Dlw.remove(localc.Dly.eLF());
        f.this.pendingRequests.remove(localc.Dly.eLF());
      }
      for (;;)
      {
        super.afterExecute(paramRunnable, paramThrowable);
        AppMethodBeat.o(152014);
        return;
        ac.i("MicroMsg.ResDownloader.IOWorker", "r = %s is not RequestFutureTask<?>", new Object[] { paramRunnable.getClass().getSimpleName() });
      }
    }
    
    public final void beforeExecute(Thread paramThread, Runnable paramRunnable)
    {
      AppMethodBeat.i(152013);
      f.c localc;
      if ((paramRunnable instanceof f.c))
      {
        localc = (f.c)paramRunnable;
        if (f.this.Dlw.containsKey(localc.Dly.eLF())) {
          localc.cancel(false);
        }
      }
      for (;;)
      {
        super.beforeExecute(paramThread, paramRunnable);
        AppMethodBeat.o(152013);
        return;
        f.this.Dlw.put(localc.Dly.eLF(), localc);
        f.this.pendingRequests.remove(localc.Dly.eLF());
        continue;
        ac.i("MicroMsg.ResDownloader.IOWorker", "r = %s is not RequestFutureTask<?>", new Object[] { paramRunnable.getClass().getSimpleName() });
      }
    }
    
    protected final <V> RunnableFuture<V> newTaskFor(Runnable paramRunnable, V paramV)
    {
      AppMethodBeat.i(152011);
      if ((paramRunnable instanceof f.d))
      {
        paramRunnable = new f.c(paramRunnable, paramV, f.d.a((f.d)paramRunnable));
        AppMethodBeat.o(152011);
        return paramRunnable;
      }
      paramRunnable = super.newTaskFor(paramRunnable, paramV);
      AppMethodBeat.o(152011);
      return paramRunnable;
    }
    
    public final void terminated()
    {
      AppMethodBeat.i(152012);
      f.this.Dlw.clear();
      super.terminated();
      AppMethodBeat.o(152012);
    }
  }
  
  public static abstract interface b
  {
    public abstract String eLF();
  }
  
  protected static final class c<V>
    extends FutureTask<V>
  {
    protected final f.b Dly;
    
    public c(Runnable paramRunnable, V paramV, f.b paramb)
    {
      super(paramV);
      this.Dly = paramb;
    }
  }
  
  public static abstract class d<Req extends f.b>
    implements Runnable
  {
    private final Req Dly;
    
    protected d(Req paramReq)
    {
      this.Dly = paramReq;
    }
    
    protected Req aXi()
    {
      return this.Dly;
    }
    
    public void run()
    {
      if (Process.getThreadPriority(Process.myTid()) != 10) {
        Process.setThreadPriority(10);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.h.a.c.f
 * JD-Core Version:    0.7.0.1
 */