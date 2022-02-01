package com.tencent.mm.plugin.wepkg.downloader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.LinkedBlockingQueue;

public final class b
{
  private static volatile b CZJ;
  public static Object lock;
  h CZK;
  
  static
  {
    AppMethodBeat.i(110591);
    lock = new Object();
    AppMethodBeat.o(110591);
  }
  
  private b()
  {
    AppMethodBeat.i(110590);
    this.CZK = new h("WePkgDownloadExcutor", new LinkedBlockingQueue(24));
    AppMethodBeat.o(110590);
  }
  
  public static b eIX()
  {
    AppMethodBeat.i(110589);
    if (CZJ == null) {}
    synchronized (lock)
    {
      if (CZJ == null) {
        CZJ = new b();
      }
      ??? = CZJ;
      AppMethodBeat.o(110589);
      return ???;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.downloader.b
 * JD-Core Version:    0.7.0.1
 */