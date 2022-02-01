package com.tencent.mm.plugin.wepkg.downloader;

import com.tencent.e.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
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
      if ((locale.EWF != null) && (locale.EWF.EWg != null))
      {
        d.fbF().aMc(locale.EWF.EWg.EWG);
        ae.i("MicroMsg.Wepkg.WePkgThreadPoolExecutor", "remove download task");
      }
    }
    ae.i("MicroMsg.Wepkg.WePkgThreadPoolExecutor", "afterExecute");
    super.afterExecute(paramRunnable, paramThrowable);
    AppMethodBeat.o(110623);
  }
  
  public final void beforeExecute(Thread paramThread, Runnable paramRunnable)
  {
    AppMethodBeat.i(110622);
    super.beforeExecute(paramThread, paramRunnable);
    ae.i("MicroMsg.Wepkg.WePkgThreadPoolExecutor", "beforeExecute");
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
    d locald = d.fbF();
    if (locald.EWq != null) {
      locald.EWq.clear();
    }
    super.terminated();
    AppMethodBeat.o(110621);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.downloader.h
 * JD-Core Version:    0.7.0.1
 */