package com.tencent.mm.plugin.wepkg.downloader;

import com.tencent.f.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RunnableFuture;

public final class h
  extends b
{
  public h(String paramString, BlockingQueue<Runnable> paramBlockingQueue)
  {
    super(paramString, 3, 3, paramBlockingQueue);
  }
  
  public final void afterExecute(Runnable paramRunnable, Throwable paramThrowable)
  {
    AppMethodBeat.i(110623);
    if ((paramRunnable instanceof e))
    {
      e locale = (e)paramRunnable;
      if ((locale.JMw != null) && (locale.JMw.JLZ != null))
      {
        d.gkL().bcv(locale.JMw.JLZ.JMx);
        Log.i("MicroMsg.Wepkg.WePkgThreadPoolExecutor", "remove download task");
      }
    }
    Log.i("MicroMsg.Wepkg.WePkgThreadPoolExecutor", "afterExecute");
    super.afterExecute(paramRunnable, paramThrowable);
    AppMethodBeat.o(110623);
  }
  
  public final void beforeExecute(Thread paramThread, Runnable paramRunnable)
  {
    AppMethodBeat.i(110622);
    super.beforeExecute(paramThread, paramRunnable);
    Log.i("MicroMsg.Wepkg.WePkgThreadPoolExecutor", "beforeExecute");
    AppMethodBeat.o(110622);
  }
  
  protected final <V> RunnableFuture<V> newTaskFor(Runnable paramRunnable, V paramV)
  {
    AppMethodBeat.i(110620);
    if ((paramRunnable instanceof c))
    {
      paramRunnable = new e(paramRunnable, paramV, (c)paramRunnable);
      AppMethodBeat.o(110620);
      return paramRunnable;
    }
    paramRunnable = super.newTaskFor(paramRunnable, paramV);
    AppMethodBeat.o(110620);
    return paramRunnable;
  }
  
  public final void terminated()
  {
    AppMethodBeat.i(110621);
    d locald = d.gkL();
    if (locald.JMi != null) {
      locald.JMi.clear();
    }
    super.terminated();
    AppMethodBeat.o(110621);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.downloader.h
 * JD-Core Version:    0.7.0.1
 */