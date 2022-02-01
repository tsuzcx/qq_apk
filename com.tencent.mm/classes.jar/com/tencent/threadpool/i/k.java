package com.tencent.threadpool.i;

import android.os.Looper;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.threadpool.d.e;
import com.tencent.threadpool.f;
import com.tencent.threadpool.g.b;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class k<V>
  extends FutureTask<V>
  implements c, d<V>, h, Delayed, RunnableScheduledFuture<V>
{
  private static final com.tencent.threadpool.f.a ahCk;
  private static final AtomicLong ahCl;
  private static final long ahCt;
  private static final com.tencent.threadpool.g.a.b ahzQ;
  private f MMA;
  protected long MMg;
  private final long PuU;
  private final long ahCm;
  private volatile long ahCn;
  public Object ahCo;
  private String ahCp;
  private com.tencent.threadpool.g.g ahCq;
  public com.tencent.threadpool.h.d ahCr;
  public final int ahCs;
  private boolean isLogging;
  protected Thread thread;
  private Throwable throwable;
  protected long time;
  protected long waitTime;
  
  static
  {
    AppMethodBeat.i(183391);
    ahCk = new com.tencent.threadpool.f.a()
    {
      public final void a(k paramAnonymousk)
      {
        AppMethodBeat.i(226899);
        if (com.tencent.threadpool.c.b.ahBl != null) {
          com.tencent.threadpool.c.b.ahBl.a(paramAnonymousk);
        }
        AppMethodBeat.o(226899);
      }
      
      public final void a(k paramAnonymousk, long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(226898);
        if (com.tencent.threadpool.c.b.ahBl != null) {
          com.tencent.threadpool.c.b.ahBl.a(paramAnonymousk, paramAnonymousLong1, paramAnonymousLong2);
        }
        AppMethodBeat.o(226898);
      }
      
      public final void b(k paramAnonymousk)
      {
        AppMethodBeat.i(226897);
        if (com.tencent.threadpool.c.b.ahBl != null) {
          com.tencent.threadpool.c.b.ahBl.b(paramAnonymousk);
        }
        AppMethodBeat.o(226897);
      }
      
      public final void c(k paramAnonymousk)
      {
        AppMethodBeat.i(226900);
        if (com.tencent.threadpool.c.b.ahBl != null) {
          com.tencent.threadpool.c.b.ahBl.c(paramAnonymousk);
        }
        AppMethodBeat.o(226900);
      }
      
      public final void d(k paramAnonymousk)
      {
        AppMethodBeat.i(226896);
        if (com.tencent.threadpool.c.b.ahBl != null) {
          com.tencent.threadpool.c.b.ahBl.d(paramAnonymousk);
        }
        AppMethodBeat.o(226896);
      }
      
      public final void e(k paramAnonymousk)
      {
        AppMethodBeat.i(226902);
        if (com.tencent.threadpool.c.b.ahBl != null) {
          com.tencent.threadpool.c.b.ahBl.e(paramAnonymousk);
        }
        AppMethodBeat.o(226902);
      }
    };
    ahCl = new AtomicLong();
    ahzQ = com.tencent.threadpool.g.h.ahBK;
    ahCt = Looper.getMainLooper().getThread().getId();
    AppMethodBeat.o(183391);
  }
  
  public k(Runnable paramRunnable, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    super(paramRunnable, null);
    AppMethodBeat.i(183377);
    this.isLogging = true;
    this.time = 0L;
    this.waitTime = 0L;
    this.MMg = 0L;
    this.MMA = f.ahAu;
    this.ahCm = ahCl.getAndIncrement();
    this.ahCo = paramRunnable;
    this.ahCn = paramLong1;
    this.PuU = paramLong2;
    this.ahCp = getKey();
    this.ahCs = paramRunnable.hashCode();
    this.isLogging = paramBoolean;
    if ((paramBoolean) && (ahCk != null)) {
      ahCk.d(this);
    }
    com.tencent.threadpool.d.ahAo.a(getKey(), this.ahCs, this.MMA, paramLong1 - System.nanoTime(), 0L, "", paramBoolean);
    AppMethodBeat.o(183377);
  }
  
  public k(Runnable paramRunnable, long paramLong, boolean paramBoolean)
  {
    super(paramRunnable, null);
    AppMethodBeat.i(183376);
    this.isLogging = true;
    this.time = 0L;
    this.waitTime = 0L;
    this.MMg = 0L;
    this.MMA = f.ahAu;
    this.ahCm = ahCl.getAndIncrement();
    this.ahCo = paramRunnable;
    this.ahCn = paramLong;
    this.PuU = 0L;
    this.ahCp = getKey();
    this.ahCs = paramRunnable.hashCode();
    this.isLogging = paramBoolean;
    if ((paramBoolean) && (ahCk != null)) {
      ahCk.d(this);
    }
    com.tencent.threadpool.d.ahAo.a(getKey(), this.ahCs, this.MMA, paramLong - System.nanoTime(), 0L, "", paramBoolean);
    AppMethodBeat.o(183376);
  }
  
  public k(Callable<V> paramCallable, long paramLong, boolean paramBoolean)
  {
    super(paramCallable);
    AppMethodBeat.i(183378);
    this.isLogging = true;
    this.time = 0L;
    this.waitTime = 0L;
    this.MMg = 0L;
    this.MMA = f.ahAu;
    this.ahCm = ahCl.getAndIncrement();
    this.ahCo = paramCallable;
    this.ahCn = paramLong;
    this.PuU = 0L;
    this.ahCp = getKey();
    this.ahCs = paramCallable.hashCode();
    this.isLogging = paramBoolean;
    if ((paramBoolean) && (ahCk != null)) {
      ahCk.d(this);
    }
    com.tencent.threadpool.d.ahAo.a(getKey(), this.ahCs, this.MMA, paramLong - System.nanoTime(), 0L, "", paramBoolean);
    AppMethodBeat.o(183378);
  }
  
  private void jZv()
  {
    AppMethodBeat.i(183380);
    if (this.throwable != null)
    {
      if ((this.throwable instanceof RuntimeException))
      {
        localObject = (RuntimeException)this.throwable;
        AppMethodBeat.o(183380);
        throw ((Throwable)localObject);
      }
      if ((this.throwable instanceof Error))
      {
        localObject = (Error)this.throwable;
        AppMethodBeat.o(183380);
        throw ((Throwable)localObject);
      }
      Object localObject = new Error(this.throwable);
      AppMethodBeat.o(183380);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(183380);
  }
  
  public static com.tencent.threadpool.g.a.b jZw()
  {
    return ahzQ;
  }
  
  private void l(Looper paramLooper)
  {
    AppMethodBeat.i(226901);
    g.b localb = com.tencent.threadpool.a.ahzV;
    if ((localb.gzk()) && (ahCt != Thread.currentThread().getId()) && (Looper.myLooper() != null) && (paramLooper == null))
    {
      localb.a(Thread.currentThread(), getKey());
      if (localb.gzm()) {
        try
        {
          ((ThreadLocal)com.tencent.threadpool.l.c.n(Looper.class, "sThreadLocal")).set(null);
          AppMethodBeat.o(226901);
          return;
        }
        catch (Exception paramLooper)
        {
          this.throwable = paramLooper;
          AppMethodBeat.o(226901);
          return;
        }
      }
      if (localb.gzl()) {
        this.throwable = new RuntimeException("this task has prepared looper, is not " + getKey());
      }
    }
    AppMethodBeat.o(226901);
  }
  
  public final void a(com.tencent.threadpool.h.d paramd)
  {
    AppMethodBeat.i(183382);
    this.ahCr = paramd;
    this.waitTime = SystemClock.uptimeMillis();
    AppMethodBeat.o(183382);
  }
  
  public boolean cancel(boolean paramBoolean)
  {
    AppMethodBeat.i(183381);
    if (super.cancel(paramBoolean))
    {
      this.MMA = f.ahAt;
      if ((this.isLogging) && (ahCk != null)) {
        ahCk.b(this);
      }
      com.tencent.threadpool.d.ahAo.a(getKey(), this.ahCs, this.MMA, 0L, 0L, "", this.isLogging);
      if (this.ahCr != null) {
        this.ahCr.i(this);
      }
      AppMethodBeat.o(183381);
      return true;
    }
    AppMethodBeat.o(183381);
    return false;
  }
  
  protected void done()
  {
    AppMethodBeat.i(183388);
    super.done();
    this.ahCo = null;
    AppMethodBeat.o(183388);
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(183389);
    super.finalize();
    if ((this.MMA == f.ahAu) || (this.MMA == f.ahAv)) {
      cancel(false);
    }
    AppMethodBeat.o(183389);
  }
  
  public long getDelay(TimeUnit paramTimeUnit)
  {
    AppMethodBeat.i(183386);
    long l = paramTimeUnit.convert(this.ahCn - System.nanoTime(), TimeUnit.NANOSECONDS);
    AppMethodBeat.o(183386);
    return l;
  }
  
  public String getKey()
  {
    AppMethodBeat.i(183385);
    if (this.ahCp == null)
    {
      if ((this.ahCo instanceof g))
      {
        str = ((g)this.ahCo).getKey();
        AppMethodBeat.o(183385);
        return str;
      }
      str = this.ahCo.getClass().getName();
      AppMethodBeat.o(183385);
      return str;
    }
    String str = this.ahCp;
    AppMethodBeat.o(183385);
    return str;
  }
  
  public final Thread getThread()
  {
    return this.thread;
  }
  
  public boolean isPeriodic()
  {
    return this.PuU != 0L;
  }
  
  public final com.tencent.threadpool.g.g jZx()
  {
    AppMethodBeat.i(183383);
    if (this.ahCq == null) {
      this.ahCq = ahzQ.bFU(this.ahCp);
    }
    com.tencent.threadpool.g.g localg = this.ahCq;
    AppMethodBeat.o(183383);
    return localg;
  }
  
  public final long[] jZy()
  {
    if (this.MMA == f.ahAx) {
      return new long[] { this.MMg, this.time };
    }
    return new long[2];
  }
  
  public void run()
  {
    AppMethodBeat.i(183379);
    if (isCancelled())
    {
      AppMethodBeat.o(183379);
      return;
    }
    long l1;
    int i;
    if (!ahzQ.c(jZx()))
    {
      l1 = ahzQ.a(jZx(), TimeUnit.NANOSECONDS);
      if (l1 >= 0L) {
        this.ahCn = (l1 + System.nanoTime());
      }
      for (i = 1; i != 0; i = 0)
      {
        this.MMA = f.ahAv;
        this.ahCr.g(this);
        com.tencent.threadpool.d.ahAo.a(getKey(), this.ahCs, jZx().jZp(), this.ahCn - System.nanoTime(), this.ahCr.getName());
        AppMethodBeat.o(183379);
        return;
      }
      this.MMA = f.ahAr;
      if ((this.isLogging) && (ahCk != null)) {
        ahCk.e(this);
      }
      com.tencent.threadpool.d.ahAo.a(getKey(), this.ahCs, this.MMA, 0L, 0L, this.ahCr.getName(), this.isLogging);
      AppMethodBeat.o(183379);
      return;
    }
    this.time = SystemClock.uptimeMillis();
    this.waitTime -= this.time;
    this.MMg = SystemClock.currentThreadTimeMillis();
    this.MMA = f.ahAw;
    com.tencent.threadpool.d.ahAo.a(getKey(), this.ahCs, this.MMA, this.time, this.MMg, this.ahCr.getName(), this.isLogging);
    if ((this.isLogging) && (ahCk != null)) {
      ahCk.a(this);
    }
    Looper localLooper = Looper.myLooper();
    this.thread = Thread.currentThread();
    try
    {
      boolean bool = isPeriodic();
      if (!this.ahCr.isShutdown())
      {
        i = 1;
        label342:
        if (i != 0) {
          break label454;
        }
        cancel(false);
      }
      for (;;)
      {
        this.time = (SystemClock.uptimeMillis() - this.time);
        this.MMg = (SystemClock.currentThreadTimeMillis() - this.MMg);
        if (this.MMA != f.ahAs) {
          this.MMA = f.ahAx;
        }
        if (ahCk != null) {}
        switch (2.ahCu[this.MMA.ordinal()])
        {
        default: 
          label432:
          l(localLooper);
          jZv();
          AppMethodBeat.o(183379);
          return;
          i = 0;
          break label342;
          label454:
          if (bool) {
            break label567;
          }
          super.run();
        }
      }
      l(localLooper);
    }
    finally
    {
      this.time = (SystemClock.uptimeMillis() - this.time);
      this.MMg = (SystemClock.currentThreadTimeMillis() - this.MMg);
      if (this.MMA != f.ahAs) {
        this.MMA = f.ahAx;
      }
      if (ahCk != null) {
        switch (2.ahCu[this.MMA.ordinal()])
        {
        }
      }
    }
    for (;;)
    {
      jZv();
      AppMethodBeat.o(183379);
      throw localObject;
      label567:
      if (!super.runAndReset()) {
        break;
      }
      l1 = this.PuU;
      long l2;
      if (l1 > 0L) {
        l2 = this.ahCn;
      }
      for (;;)
      {
        this.ahCn = (l1 + l2);
        if ((this.isLogging) && (ahCk != null)) {
          ahCk.d(this);
        }
        this.ahCr.g(this);
        break;
        l1 = -l1;
        l2 = System.nanoTime();
        if (l1 >= 4611686018427387903L) {
          l1 = 4611686018427387903L;
        }
      }
      if (this.isLogging) {
        ahCk.c(this);
      }
      com.tencent.threadpool.d.ahAo.a(getKey(), this.ahCs, this.throwable);
      break label432;
      if (this.isLogging) {
        ahCk.a(this, this.MMg, this.time);
      }
      com.tencent.threadpool.d.ahAo.a(getKey(), this.ahCs, this.MMA, this.time, this.MMg, this.ahCr.getName(), this.isLogging);
      break label432;
      if (this.isLogging) {
        ahCk.c(this);
      }
      com.tencent.threadpool.d.ahAo.a(getKey(), this.ahCs, this.throwable);
      continue;
      if (this.isLogging) {
        ahCk.a(this, this.MMg, this.time);
      }
      com.tencent.threadpool.d.ahAo.a(getKey(), this.ahCs, this.MMA, this.time, this.MMg, this.ahCr.getName(), this.isLogging);
    }
  }
  
  protected void setException(Throwable paramThrowable)
  {
    AppMethodBeat.i(183384);
    super.setException(paramThrowable);
    this.MMA = f.ahAs;
    this.throwable = paramThrowable;
    AppMethodBeat.o(183384);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.threadpool.i.k
 * JD-Core Version:    0.7.0.1
 */