package com.tencent.mm.sdk.f;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class d
  implements ThreadFactory
{
  private ThreadGroup eqG = new ThreadGroup("MM_THREAD_POOL_GROUP");
  private final AtomicInteger ukc = new AtomicInteger(1);
  
  public final Thread newThread(Runnable paramRunnable)
  {
    paramRunnable = new Thread(this.eqG, paramRunnable, "MM_Thread_Pool_Thread#" + this.ukc.getAndIncrement());
    if (paramRunnable.isDaemon()) {
      paramRunnable.setDaemon(false);
    }
    if (paramRunnable.getPriority() != 5) {
      paramRunnable.setPriority(5);
    }
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.f.d
 * JD-Core Version:    0.7.0.1
 */