package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class ae
  implements ThreadFactory
{
  private static final AtomicInteger a;
  private final ThreadGroup b;
  private final AtomicInteger c;
  private final String d;
  
  static
  {
    AppMethodBeat.i(147201);
    a = new AtomicInteger(1);
    AppMethodBeat.o(147201);
  }
  
  public ae(String paramString)
  {
    AppMethodBeat.i(147199);
    this.c = new AtomicInteger(1);
    Object localObject = System.getSecurityManager();
    if (localObject != null) {}
    for (localObject = ((SecurityManager)localObject).getThreadGroup();; localObject = Thread.currentThread().getThreadGroup())
    {
      this.b = ((ThreadGroup)localObject);
      this.d = (paramString + "_" + a.getAndIncrement() + "_thread_");
      AppMethodBeat.o(147199);
      return;
    }
  }
  
  public final Thread newThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(147200);
    paramRunnable = new Thread(this.b, paramRunnable, this.d + this.c.getAndIncrement(), 0L);
    if (paramRunnable.isDaemon()) {
      paramRunnable.setDaemon(false);
    }
    try
    {
      paramRunnable.setPriority(5);
      label63:
      AppMethodBeat.o(147200);
      return paramRunnable;
    }
    catch (Exception localException)
    {
      break label63;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ae
 * JD-Core Version:    0.7.0.1
 */