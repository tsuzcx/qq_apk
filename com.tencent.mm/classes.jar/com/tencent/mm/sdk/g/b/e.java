package com.tencent.mm.sdk.g.b;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.a.b;
import com.tencent.mm.sdk.g.c.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public final class e
  implements a
{
  public a yth;
  
  public e(b paramb, d.a parama)
  {
    AppMethodBeat.i(52668);
    a locala = new a((byte)0);
    int j = Runtime.getRuntime().availableProcessors() * 6;
    if (j > 42) {}
    for (;;)
    {
      LinkedBlockingQueue localLinkedBlockingQueue = new LinkedBlockingQueue(i * 2);
      ab.i("MicroMsg.ThreadPoolExecutorProxy", "isHandlerThreadPool:%s coreSize:%s", new Object[] { Boolean.TRUE, Integer.valueOf(i) });
      this.yth = new b.1(i, Math.round(0.8F * i), localLinkedBlockingQueue, c.yto, locala, parama, paramb);
      AppMethodBeat.o(52668);
      return;
      if (j < 28) {
        i = 28;
      } else {
        i = j;
      }
    }
  }
  
  public final void execute(Runnable paramRunnable)
  {
    AppMethodBeat.i(52669);
    this.yth.execute(paramRunnable);
    AppMethodBeat.o(52669);
  }
  
  public final int getCorePoolSize()
  {
    AppMethodBeat.i(52674);
    int i = this.yth.getCorePoolSize();
    AppMethodBeat.o(52674);
    return i;
  }
  
  public final void r(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(52673);
    this.yth.r(paramRunnable, paramLong);
    AppMethodBeat.o(52673);
  }
  
  public final boolean remove(Runnable paramRunnable)
  {
    AppMethodBeat.i(52670);
    boolean bool = this.yth.remove(paramRunnable);
    AppMethodBeat.o(52670);
    return bool;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(52672);
    this.yth.reset();
    AppMethodBeat.o(52672);
  }
  
  public final void shutdown()
  {
    AppMethodBeat.i(52671);
    this.yth.shutdown();
    AppMethodBeat.o(52671);
  }
  
  final class a
    implements d.b, RejectedExecutionHandler
  {
    public HandlerThread yti;
    Handler ytj;
    
    private a()
    {
      AppMethodBeat.i(52664);
      this.yti = c.aqv("ThreadPool#FallBackExecutor");
      this.ytj = null;
      AppMethodBeat.o(52664);
    }
    
    private void at(Runnable paramRunnable)
    {
      AppMethodBeat.i(52665);
      if (this.ytj == null) {}
      synchronized (this.yti)
      {
        if (this.ytj == null)
        {
          if (!this.yti.isAlive()) {
            this.yti.start();
          }
          this.ytj = new Handler(this.yti.getLooper());
        }
        this.ytj.post(paramRunnable);
        AppMethodBeat.o(52665);
        return;
      }
    }
    
    public final void as(Runnable paramRunnable)
    {
      AppMethodBeat.i(52666);
      at(paramRunnable);
      AppMethodBeat.o(52666);
    }
    
    public final void rejectedExecution(Runnable paramRunnable, ThreadPoolExecutor paramThreadPoolExecutor)
    {
      AppMethodBeat.i(52667);
      at(paramRunnable);
      AppMethodBeat.o(52667);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.g.b.e
 * JD-Core Version:    0.7.0.1
 */