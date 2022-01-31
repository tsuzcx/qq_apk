package com.tencent.mm.plugin.wepkg.downloader;

import com.tencent.mm.pluginsdk.g.a.c.u;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public final class b
{
  public static Object lock = new Object();
  private static volatile b rOe;
  h rOf = new h(TimeUnit.MILLISECONDS, new LinkedBlockingQueue(24), new u("WepkgDownloaderPool", "WepkgDownloaderThread"));
  
  public static b cjQ()
  {
    if (rOe == null) {}
    synchronized (lock)
    {
      if (rOe == null) {
        rOe = new b();
      }
      return rOe;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.downloader.b
 * JD-Core Version:    0.7.0.1
 */