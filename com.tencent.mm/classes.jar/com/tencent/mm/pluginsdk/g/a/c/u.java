package com.tencent.mm.pluginsdk.g.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.d;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class u
  implements ThreadFactory
{
  private static final AtomicInteger vON;
  private final AtomicInteger cfV;
  private String cfW;
  
  static
  {
    AppMethodBeat.i(79640);
    vON = new AtomicInteger(1);
    AppMethodBeat.o(79640);
  }
  
  public u()
  {
    this("ResDownloaderPool", "ResDownloaderThread");
  }
  
  public u(String paramString1, String paramString2)
  {
    AppMethodBeat.i(79638);
    this.cfV = new AtomicInteger(1);
    this.cfW = String.format("%s-%d-%s-", new Object[] { paramString1, Integer.valueOf(vON.getAndIncrement()), paramString2 });
    AppMethodBeat.o(79638);
  }
  
  public final Thread newThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(79639);
    paramRunnable = d.a(paramRunnable, this.cfW + this.cfV.getAndIncrement(), 1);
    if (paramRunnable.isDaemon()) {
      paramRunnable.setDaemon(false);
    }
    AppMethodBeat.o(79639);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.c.u
 * JD-Core Version:    0.7.0.1
 */