package com.tencent.mm.plugin.wepkg.downloader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.LinkedBlockingQueue;

public final class b
{
  private static volatile b JLX;
  public static Object lock;
  h JLY;
  
  static
  {
    AppMethodBeat.i(110591);
    lock = new Object();
    AppMethodBeat.o(110591);
  }
  
  private b()
  {
    AppMethodBeat.i(110590);
    this.JLY = new h("WePkgDownloadExcutor", new LinkedBlockingQueue(24));
    AppMethodBeat.o(110590);
  }
  
  public static b gkJ()
  {
    AppMethodBeat.i(110589);
    if (JLX == null) {}
    synchronized (lock)
    {
      if (JLX == null) {
        JLX = new b();
      }
      ??? = JLX;
      AppMethodBeat.o(110589);
      return ???;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.downloader.b
 * JD-Core Version:    0.7.0.1
 */