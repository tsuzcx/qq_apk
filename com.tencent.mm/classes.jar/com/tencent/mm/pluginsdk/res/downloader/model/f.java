package com.tencent.mm.pluginsdk.res.downloader.model;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.b;
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
  final Map<String, b> XWu = new ConcurrentHashMap();
  protected final Map<String, Future<?>> XWv = new ConcurrentHashMap();
  
  protected final void ZJ(String paramString)
  {
    Future localFuture = (Future)this.XWv.remove(paramString);
    if (localFuture != null) {
      localFuture.cancel(true);
    }
    this.XWu.remove(paramString);
  }
  
  protected abstract d a(T paramT);
  
  protected final void b(T paramT)
  {
    this.XWu.put(paramT.iJd(), paramT);
    iJs().submit(a(paramT));
  }
  
  public final boolean bqm(String paramString)
  {
    return this.XWv.containsKey(paramString);
  }
  
  /* Error */
  public final boolean bqn(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 33	com/tencent/mm/pluginsdk/res/downloader/model/f:XWv	Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface 78 2 0
    //   12: ifne +18 -> 30
    //   15: aload_0
    //   16: getfield 31	com/tencent/mm/pluginsdk/res/downloader/model/f:XWu	Ljava/util/Map;
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
    Iterator localIterator = this.XWv.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (Future)this.XWv.get(localObject);
      if (localObject != null) {
        ((Future)localObject).cancel(true);
      }
    }
    this.XWu.clear();
    this.XWv.clear();
  }
  
  protected abstract b iJs();
  
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
        f.this.XWv.remove(localc.XWx.iJd());
        f.this.XWu.remove(localc.XWx.iJd());
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
        if (f.this.XWv.containsKey(localc.XWx.iJd())) {
          localc.cancel(false);
        }
      }
      for (;;)
      {
        super.beforeExecute(paramThread, paramRunnable);
        AppMethodBeat.o(152013);
        return;
        f.this.XWv.put(localc.XWx.iJd(), localc);
        f.this.XWu.remove(localc.XWx.iJd());
        continue;
        Log.i("MicroMsg.ResDownloader.IOWorker", "r = %s is not RequestFutureTask<?>", new Object[] { paramRunnable.getClass().getSimpleName() });
      }
    }
    
    public final void iFm()
    {
      AppMethodBeat.i(152012);
      f.this.XWv.clear();
      super.iFm();
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
    public abstract String iJd();
  }
  
  protected static final class c<V>
    extends FutureTask<V>
  {
    protected final f.b XWx;
    
    public c(Runnable paramRunnable, V paramV, f.b paramb)
    {
      super(paramV);
      this.XWx = paramb;
    }
  }
  
  public static abstract class d<Req extends f.b>
    implements Runnable
  {
    private final Req XWx;
    
    protected d(Req paramReq)
    {
      this.XWx = paramReq;
    }
    
    protected Req cgY()
    {
      return this.XWx;
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
 * Qualified Name:     com.tencent.mm.pluginsdk.res.downloader.model.f
 * JD-Core Version:    0.7.0.1
 */