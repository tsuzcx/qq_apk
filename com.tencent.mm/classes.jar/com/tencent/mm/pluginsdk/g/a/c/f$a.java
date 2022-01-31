package com.tencent.mm.pluginsdk.g.a.c;

import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class f$a
  extends ThreadPoolExecutor
{
  public f$a(int paramInt1, int paramInt2, long paramLong, TimeUnit paramTimeUnit, BlockingQueue<Runnable> paramBlockingQueue, u paramu)
  {
    super(paramInt2, paramLong, ???, paramBlockingQueue, paramu, localThreadFactory);
  }
  
  protected final void afterExecute(Runnable paramRunnable, Throwable paramThrowable)
  {
    if ((paramRunnable instanceof f.c))
    {
      f.c localc = (f.c)paramRunnable;
      this.rXq.rXp.remove(localc.rXr.cls());
      this.rXq.rXo.remove(localc.rXr.cls());
    }
    for (;;)
    {
      super.afterExecute(paramRunnable, paramThrowable);
      return;
      y.i("MicroMsg.ResDownloader.IOWorker", "r = %s is not RequestFutureTask<?>", new Object[] { paramRunnable.getClass().getSimpleName() });
    }
  }
  
  protected final void beforeExecute(Thread paramThread, Runnable paramRunnable)
  {
    f.c localc;
    if ((paramRunnable instanceof f.c))
    {
      localc = (f.c)paramRunnable;
      if (this.rXq.rXp.containsKey(localc.rXr.cls())) {
        localc.cancel(false);
      }
    }
    for (;;)
    {
      super.beforeExecute(paramThread, paramRunnable);
      return;
      this.rXq.rXp.put(localc.rXr.cls(), localc);
      this.rXq.rXo.remove(localc.rXr.cls());
      continue;
      y.i("MicroMsg.ResDownloader.IOWorker", "r = %s is not RequestFutureTask<?>", new Object[] { paramRunnable.getClass().getSimpleName() });
    }
  }
  
  protected final <V> RunnableFuture<V> newTaskFor(Runnable paramRunnable, V paramV)
  {
    if ((paramRunnable instanceof f.d)) {
      return new f.c(paramRunnable, paramV, f.d.a((f.d)paramRunnable));
    }
    return super.newTaskFor(paramRunnable, paramV);
  }
  
  protected final void terminated()
  {
    this.rXq.rXp.clear();
    super.terminated();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.c.f.a
 * JD-Core Version:    0.7.0.1
 */