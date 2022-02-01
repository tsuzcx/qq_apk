package com.tencent.mm.plugin.wepkg.downloader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.LinkedBlockingQueue;

public final class b
{
  private static volatile b BHB;
  public static Object lock;
  h BHC;
  
  static
  {
    AppMethodBeat.i(110591);
    lock = new Object();
    AppMethodBeat.o(110591);
  }
  
  private b()
  {
    AppMethodBeat.i(110590);
    this.BHC = new h("WePkgDownloadExcutor", new LinkedBlockingQueue(24));
    AppMethodBeat.o(110590);
  }
  
  public static b etE()
  {
    AppMethodBeat.i(110589);
    if (BHB == null) {}
    synchronized (lock)
    {
      if (BHB == null) {
        BHB = new b();
      }
      ??? = BHB;
      AppMethodBeat.o(110589);
      return ???;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.downloader.b
 * JD-Core Version:    0.7.0.1
 */