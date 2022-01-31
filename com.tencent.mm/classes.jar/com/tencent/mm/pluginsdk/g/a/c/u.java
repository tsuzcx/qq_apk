package com.tencent.mm.pluginsdk.g.a.c;

import com.tencent.mm.sdk.f.e;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class u
  implements ThreadFactory
{
  private static final AtomicInteger rXW = new AtomicInteger(1);
  private final AtomicInteger eqH = new AtomicInteger(1);
  private String eqI;
  
  public u()
  {
    this("ResDownloaderPool", "ResDownloaderThread");
  }
  
  public u(String paramString1, String paramString2)
  {
    this.eqI = String.format("%s-%d-%s-", new Object[] { paramString1, Integer.valueOf(rXW.getAndIncrement()), paramString2 });
  }
  
  public final Thread newThread(Runnable paramRunnable)
  {
    paramRunnable = e.c(paramRunnable, this.eqI + this.eqH.getAndIncrement(), 1);
    if (paramRunnable.isDaemon()) {
      paramRunnable.setDaemon(false);
    }
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.c.u
 * JD-Core Version:    0.7.0.1
 */