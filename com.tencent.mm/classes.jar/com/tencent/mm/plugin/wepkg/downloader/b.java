package com.tencent.mm.plugin.wepkg.downloader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.g.a.c.u;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public final class b
{
  public static Object lock;
  private static volatile b vEP;
  h vEQ;
  
  static
  {
    AppMethodBeat.i(63420);
    lock = new Object();
    AppMethodBeat.o(63420);
  }
  
  private b()
  {
    AppMethodBeat.i(63419);
    this.vEQ = new h(TimeUnit.MILLISECONDS, new LinkedBlockingQueue(24), new u("WepkgDownloaderPool", "WepkgDownloaderThread"));
    AppMethodBeat.o(63419);
  }
  
  public static b dkv()
  {
    AppMethodBeat.i(63418);
    if (vEP == null) {}
    synchronized (lock)
    {
      if (vEP == null) {
        vEP = new b();
      }
      ??? = vEP;
      AppMethodBeat.o(63418);
      return ???;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.downloader.b
 * JD-Core Version:    0.7.0.1
 */