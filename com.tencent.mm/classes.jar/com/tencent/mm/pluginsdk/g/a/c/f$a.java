package com.tencent.mm.pluginsdk.g.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
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
    AppMethodBeat.i(79570);
    if ((paramRunnable instanceof f.c))
    {
      f.c localc = (f.c)paramRunnable;
      this.vOh.vOg.remove(localc.vOi.dlZ());
      this.vOh.pendingRequests.remove(localc.vOi.dlZ());
    }
    for (;;)
    {
      super.afterExecute(paramRunnable, paramThrowable);
      AppMethodBeat.o(79570);
      return;
      ab.i("MicroMsg.ResDownloader.IOWorker", "r = %s is not RequestFutureTask<?>", new Object[] { paramRunnable.getClass().getSimpleName() });
    }
  }
  
  protected final void beforeExecute(Thread paramThread, Runnable paramRunnable)
  {
    AppMethodBeat.i(79569);
    f.c localc;
    if ((paramRunnable instanceof f.c))
    {
      localc = (f.c)paramRunnable;
      if (this.vOh.vOg.containsKey(localc.vOi.dlZ())) {
        localc.cancel(false);
      }
    }
    for (;;)
    {
      super.beforeExecute(paramThread, paramRunnable);
      AppMethodBeat.o(79569);
      return;
      this.vOh.vOg.put(localc.vOi.dlZ(), localc);
      this.vOh.pendingRequests.remove(localc.vOi.dlZ());
      continue;
      ab.i("MicroMsg.ResDownloader.IOWorker", "r = %s is not RequestFutureTask<?>", new Object[] { paramRunnable.getClass().getSimpleName() });
    }
  }
  
  protected final <V> RunnableFuture<V> newTaskFor(Runnable paramRunnable, V paramV)
  {
    AppMethodBeat.i(79567);
    if ((paramRunnable instanceof f.d))
    {
      paramRunnable = new f.c(paramRunnable, paramV, f.d.a((f.d)paramRunnable));
      AppMethodBeat.o(79567);
      return paramRunnable;
    }
    paramRunnable = super.newTaskFor(paramRunnable, paramV);
    AppMethodBeat.o(79567);
    return paramRunnable;
  }
  
  protected final void terminated()
  {
    AppMethodBeat.i(79568);
    this.vOh.vOg.clear();
    super.terminated();
    AppMethodBeat.o(79568);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.c.f.a
 * JD-Core Version:    0.7.0.1
 */