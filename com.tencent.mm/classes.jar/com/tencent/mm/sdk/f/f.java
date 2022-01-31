package com.tencent.mm.sdk.f;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;
import java.util.concurrent.TimeUnit;

final class f
  extends ThreadPoolExecutor
{
  private a ukv;
  
  public f(int paramInt, TimeUnit paramTimeUnit, BlockingQueue<Runnable> paramBlockingQueue, a parama)
  {
    super(0, paramInt, 120L, paramTimeUnit, paramBlockingQueue, new d(), new ThreadPoolExecutor.CallerRunsPolicy());
    this.ukv = parama;
  }
  
  protected final void afterExecute(Runnable paramRunnable, Throwable paramThrowable)
  {
    super.afterExecute(paramRunnable, paramThrowable);
    if (this.ukv != null) {
      this.ukv.X(paramRunnable);
    }
  }
  
  protected final void beforeExecute(Thread paramThread, Runnable paramRunnable)
  {
    if (this.ukv != null) {
      this.ukv.beforeExecute(paramThread, paramRunnable);
    }
    super.beforeExecute(paramThread, paramRunnable);
  }
  
  public final void execute(Runnable paramRunnable)
  {
    super.execute(paramRunnable);
  }
  
  static abstract interface a
  {
    public abstract void X(Runnable paramRunnable);
    
    public abstract void beforeExecute(Thread paramThread, Runnable paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.f.f
 * JD-Core Version:    0.7.0.1
 */