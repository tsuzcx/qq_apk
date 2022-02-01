package com.tencent.mm.plugin.wepkg.downloader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.concurrent.Future;

public final class d
{
  private static volatile d QLA;
  private static Object lock;
  HashMap<String, c> QLB;
  
  static
  {
    AppMethodBeat.i(110601);
    lock = new Object();
    AppMethodBeat.o(110601);
  }
  
  private d()
  {
    AppMethodBeat.i(110598);
    this.QLB = new HashMap();
    AppMethodBeat.o(110598);
  }
  
  public static d heC()
  {
    AppMethodBeat.i(110597);
    if (QLA == null) {}
    synchronized (lock)
    {
      if (QLA == null) {
        QLA = new d();
      }
      ??? = QLA;
      AppMethodBeat.o(110597);
      return ???;
    }
  }
  
  boolean a(c paramc)
  {
    AppMethodBeat.i(110600);
    if (this.QLB.containsKey(paramc.QLs.QLQ))
    {
      paramc.QLx = true;
      for (;;)
      {
        try
        {
          HttpURLConnection localHttpURLConnection = paramc.QLt;
          if (localHttpURLConnection == null) {}
        }
        catch (Exception localException2)
        {
          Log.i("MicroMsg.Wepkg.WePkgDownloadTask", "stop, " + localException2.getMessage());
          continue;
        }
        try
        {
          paramc.QLt.getInputStream().close();
          paramc.QLt.disconnect();
          if (paramc.mBs != null) {
            paramc.mBs.cancel(false);
          }
          this.QLB.remove(paramc.QLs.QLQ);
          AppMethodBeat.o(110600);
          return true;
        }
        catch (Exception localException1)
        {
          Log.e("MicroMsg.Wepkg.WePkgDownloadTask", localException1.getMessage());
        }
      }
    }
    AppMethodBeat.o(110600);
    return false;
  }
  
  public final boolean bov(String paramString)
  {
    AppMethodBeat.i(110599);
    if (this.QLB.containsKey(paramString)) {
      this.QLB.remove(paramString);
    }
    AppMethodBeat.o(110599);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.downloader.d
 * JD-Core Version:    0.7.0.1
 */