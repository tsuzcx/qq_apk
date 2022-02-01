package com.tencent.mm.pluginsdk.k.a.c;

import android.os.Process;
import com.tencent.e.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

public abstract class f<T extends b>
{
  protected final Map<String, Future<?>> Raq = new ConcurrentHashMap();
  final Map<String, b> pendingRequests = new ConcurrentHashMap();
  
  protected abstract d a(T paramT);
  
  protected final void agN(String paramString)
  {
    Future localFuture = (Future)this.Raq.remove(paramString);
    if (localFuture != null) {
      localFuture.cancel(true);
    }
    this.pendingRequests.remove(paramString);
  }
  
  protected final void b(T paramT)
  {
    this.pendingRequests.put(paramT.hig(), paramT);
    hit().submit(a(paramT));
  }
  
  public final boolean bqy(String paramString)
  {
    return this.Raq.containsKey(paramString);
  }
  
  /* Error */
  public final boolean bqz(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 33	com/tencent/mm/pluginsdk/k/a/c/f:Raq	Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface 78 2 0
    //   12: ifne +18 -> 30
    //   15: aload_0
    //   16: getfield 31	com/tencent/mm/pluginsdk/k/a/c/f:pendingRequests	Ljava/util/Map;
    //   19: aload_1
    //   20: invokeinterface 78 2 0
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
  
  public final void cancelAll()
  {
    Iterator localIterator = this.Raq.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (Future)this.Raq.get(localObject);
      if (localObject != null) {
        ((Future)localObject).cancel(true);
      }
    }
    this.pendingRequests.clear();
    this.Raq.clear();
  }
  
  protected abstract b hit();
  
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
        f.this.Raq.remove(localc.Ras.hig());
        f.this.pendingRequests.remove(localc.Ras.hig());
      }
      for (;;)
      {
        super.afterExecute(paramRunnable, paramThrowable);
        AppMethodBeat.o(152014);
        return;
        Log.i("MicroMsg.ResDownloader.IOWorker", "r = %s is not RequestFutureTask<?>", new Object[] { paramRunnable.getClass().getSimpleName() });
      }
    }
    
    public final void beforeExecute(Thread paramThread, Runnable paramRunnable)
    {
      AppMethodBeat.i(152013);
      f.c localc;
      if ((paramRunnable instanceof f.c))
      {
        localc = (f.c)paramRunnable;
        if (f.this.Raq.containsKey(localc.Ras.hig())) {
          localc.cancel(false);
        }
      }
      for (;;)
      {
        super.beforeExecute(paramThread, paramRunnable);
        AppMethodBeat.o(152013);
        return;
        f.this.Raq.put(localc.Ras.hig(), localc);
        f.this.pendingRequests.remove(localc.Ras.hig());
        continue;
        Log.i("MicroMsg.ResDownloader.IOWorker", "r = %s is not RequestFutureTask<?>", new Object[] { paramRunnable.getClass().getSimpleName() });
      }
    }
    
    public final void heE()
    {
      AppMethodBeat.i(152012);
      f.this.Raq.clear();
      super.heE();
      AppMethodBeat.o(152012);
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
  }
  
  public static abstract interface b
  {
    public abstract String hig();
  }
  
  protected static final class c<V>
    extends FutureTask<V>
  {
    protected final f.b Ras;
    
    public c(Runnable paramRunnable, V paramV, f.b paramb)
    {
      super(paramV);
      this.Ras = paramb;
    }
  }
  
  public static abstract class d<Req extends f.b>
    implements Runnable
  {
    private final Req Ras;
    
    protected d(Req paramReq)
    {
      this.Ras = paramReq;
    }
    
    protected Req bHA()
    {
      return this.Ras;
    }
    
    public void run()
    {
      if (Process.getThreadPriority(Process.myTid()) != 10) {
        Process.setThreadPriority(10);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.k.a.c.f
 * JD-Core Version:    0.7.0.1
 */