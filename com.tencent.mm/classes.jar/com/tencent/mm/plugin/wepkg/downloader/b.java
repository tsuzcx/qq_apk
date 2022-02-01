package com.tencent.mm.plugin.wepkg.downloader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.LinkedBlockingQueue;

public final class b
{
  private static volatile b XEP;
  public static Object lock;
  h XEQ;
  
  static
  {
    AppMethodBeat.i(110591);
    lock = new Object();
    AppMethodBeat.o(110591);
  }
  
  private b()
  {
    AppMethodBeat.i(110590);
    this.XEQ = new h("WePkgDownloadExcutor", new LinkedBlockingQueue(24));
    AppMethodBeat.o(110590);
  }
  
  public static b iFi()
  {
    AppMethodBeat.i(110589);
    if (XEP == null) {}
    synchronized (lock)
    {
      if (XEP == null) {
        XEP = new b();
      }
      ??? = XEP;
      AppMethodBeat.o(110589);
      return ???;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.downloader.b
 * JD-Core Version:    0.7.0.1
 */