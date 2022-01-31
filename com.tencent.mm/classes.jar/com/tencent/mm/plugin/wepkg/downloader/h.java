package com.tencent.mm.plugin.wepkg.downloader;

import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class h
  extends ThreadPoolExecutor
{
  public h(TimeUnit paramTimeUnit, BlockingQueue<Runnable> paramBlockingQueue, ThreadFactory paramThreadFactory)
  {
    super(3, 3, 3000L, paramTimeUnit, paramBlockingQueue, paramThreadFactory);
  }
  
  protected final void afterExecute(Runnable paramRunnable, Throwable paramThrowable)
  {
    if ((paramRunnable instanceof e))
    {
      e locale = (e)paramRunnable;
      if ((locale.rOC != null) && (locale.rOC.rOg != null))
      {
        d.cjS().Vc(locale.rOC.rOg.rOD);
        y.i("MicroMsg.Wepkg.WePkgThreadPoolExecutor", "remove download task");
      }
    }
    y.i("MicroMsg.Wepkg.WePkgThreadPoolExecutor", "afterExecute");
    super.afterExecute(paramRunnable, paramThrowable);
  }
  
  protected final void beforeExecute(Thread paramThread, Runnable paramRunnable)
  {
    super.beforeExecute(paramThread, paramRunnable);
    y.i("MicroMsg.Wepkg.WePkgThreadPoolExecutor", "beforeExecute");
  }
  
  protected final <V> RunnableFuture<V> newTaskFor(Runnable paramRunnable, V paramV)
  {
    if ((paramRunnable instanceof c)) {
      return new e(paramRunnable, paramV, (c)paramRunnable);
    }
    return super.newTaskFor(paramRunnable, paramV);
  }
  
  protected final void terminated()
  {
    d locald = d.cjS();
    if (locald.rOq != null) {
      locald.rOq.clear();
    }
    super.terminated();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.downloader.h
 * JD-Core Version:    0.7.0.1
 */