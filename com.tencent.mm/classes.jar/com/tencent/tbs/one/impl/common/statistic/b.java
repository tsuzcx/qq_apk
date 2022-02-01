package com.tencent.tbs.one.impl.common.statistic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class b
{
  private static final int a;
  private static final int b;
  private static final int c;
  private static final BlockingQueue<Runnable> d;
  private static final Executor e;
  private static final ThreadFactory f;
  private static volatile Executor g;
  private static b h;
  private static final Object i;
  
  static
  {
    AppMethodBeat.i(174234);
    a = Runtime.getRuntime().availableProcessors();
    b = Math.max(2, Math.min(a - 1, 4));
    c = a * 2 + 1;
    d = new LinkedBlockingQueue(128);
    f = new ThreadFactory()
    {
      private final AtomicInteger a;
      
      public final Thread newThread(Runnable paramAnonymousRunnable)
      {
        AppMethodBeat.i(174200);
        paramAnonymousRunnable = new Thread(paramAnonymousRunnable, "StatisticExecutor #" + this.a.getAndIncrement());
        AppMethodBeat.o(174200);
        return paramAnonymousRunnable;
      }
    };
    g = new Executor()
    {
      final ArrayDeque<Runnable> a;
      Runnable b;
      
      final void a()
      {
        try
        {
          AppMethodBeat.i(174228);
          Runnable localRunnable = (Runnable)this.a.poll();
          this.b = localRunnable;
          if (localRunnable != null) {
            b.b().execute(this.b);
          }
          AppMethodBeat.o(174228);
          return;
        }
        finally {}
      }
      
      public final void execute(final Runnable paramAnonymousRunnable)
      {
        try
        {
          AppMethodBeat.i(174227);
          this.a.offer(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(174230);
              try
              {
                paramAnonymousRunnable.run();
                return;
              }
              finally
              {
                b.2.this.a();
                AppMethodBeat.o(174230);
              }
            }
          });
          if (this.b == null) {
            a();
          }
          AppMethodBeat.o(174227);
          return;
        }
        finally {}
      }
    };
    ThreadPoolExecutor localThreadPoolExecutor = new ThreadPoolExecutor(b, c, 30L, TimeUnit.SECONDS, d, f);
    localThreadPoolExecutor.allowCoreThreadTimeOut(true);
    e = localThreadPoolExecutor;
    i = new Object();
    AppMethodBeat.o(174234);
  }
  
  public static b a()
  {
    AppMethodBeat.i(174232);
    if (h == null) {}
    synchronized (i)
    {
      if (h == null) {
        h = new b();
      }
      ??? = h;
      AppMethodBeat.o(174232);
      return ???;
    }
  }
  
  public static void a(Runnable paramRunnable)
  {
    AppMethodBeat.i(174233);
    g.execute(paramRunnable);
    AppMethodBeat.o(174233);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tbs.one.impl.common.statistic.b
 * JD-Core Version:    0.7.0.1
 */