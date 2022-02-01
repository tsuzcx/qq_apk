package com.tencent.mm.plugin.wepkg.downloader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.concurrent.Future;

public final class d
{
  private static volatile d EWp;
  private static Object lock;
  HashMap<String, c> EWq;
  
  static
  {
    AppMethodBeat.i(110601);
    lock = new Object();
    AppMethodBeat.o(110601);
  }
  
  private d()
  {
    AppMethodBeat.i(110598);
    this.EWq = new HashMap();
    AppMethodBeat.o(110598);
  }
  
  public static d fbF()
  {
    AppMethodBeat.i(110597);
    if (EWp == null) {}
    synchronized (lock)
    {
      if (EWp == null) {
        EWp = new d();
      }
      ??? = EWp;
      AppMethodBeat.o(110597);
      return ???;
    }
  }
  
  final boolean a(c paramc)
  {
    AppMethodBeat.i(110600);
    if (this.EWq.containsKey(paramc.EWg.EWG))
    {
      paramc.EWm = true;
      for (;;)
      {
        try
        {
          HttpURLConnection localHttpURLConnection = paramc.EWi;
          if (localHttpURLConnection == null) {}
        }
        catch (Exception localException2)
        {
          ae.i("MicroMsg.Wepkg.WePkgDownloadTask", "stop, " + localException2.getMessage());
          continue;
        }
        try
        {
          paramc.EWi.getInputStream().close();
          paramc.EWi.disconnect();
          if (paramc.EWh != null) {
            paramc.EWh.cancel(false);
          }
          this.EWq.remove(paramc.EWg.EWG);
          AppMethodBeat.o(110600);
          return true;
        }
        catch (Exception localException1)
        {
          ae.e("MicroMsg.Wepkg.WePkgDownloadTask", localException1.getMessage());
        }
      }
    }
    AppMethodBeat.o(110600);
    return false;
  }
  
  public final boolean aMc(String paramString)
  {
    AppMethodBeat.i(110599);
    if (this.EWq.containsKey(paramString)) {
      this.EWq.remove(paramString);
    }
    AppMethodBeat.o(110599);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.downloader.d
 * JD-Core Version:    0.7.0.1
 */