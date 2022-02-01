package com.tencent.mm.plugin.wepkg.downloader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.concurrent.Future;

public final class d
{
  private static volatile d EDT;
  private static Object lock;
  HashMap<String, c> EDU;
  
  static
  {
    AppMethodBeat.i(110601);
    lock = new Object();
    AppMethodBeat.o(110601);
  }
  
  private d()
  {
    AppMethodBeat.i(110598);
    this.EDU = new HashMap();
    AppMethodBeat.o(110598);
  }
  
  public static d eXT()
  {
    AppMethodBeat.i(110597);
    if (EDT == null) {}
    synchronized (lock)
    {
      if (EDT == null) {
        EDT = new d();
      }
      ??? = EDT;
      AppMethodBeat.o(110597);
      return ???;
    }
  }
  
  final boolean a(c paramc)
  {
    AppMethodBeat.i(110600);
    if (this.EDU.containsKey(paramc.EDK.EEk))
    {
      paramc.EDQ = true;
      for (;;)
      {
        try
        {
          HttpURLConnection localHttpURLConnection = paramc.EDM;
          if (localHttpURLConnection == null) {}
        }
        catch (Exception localException2)
        {
          ad.i("MicroMsg.Wepkg.WePkgDownloadTask", "stop, " + localException2.getMessage());
          continue;
        }
        try
        {
          paramc.EDM.getInputStream().close();
          paramc.EDM.disconnect();
          if (paramc.EDL != null) {
            paramc.EDL.cancel(false);
          }
          this.EDU.remove(paramc.EDK.EEk);
          AppMethodBeat.o(110600);
          return true;
        }
        catch (Exception localException1)
        {
          ad.e("MicroMsg.Wepkg.WePkgDownloadTask", localException1.getMessage());
        }
      }
    }
    AppMethodBeat.o(110600);
    return false;
  }
  
  public final boolean aKG(String paramString)
  {
    AppMethodBeat.i(110599);
    if (this.EDU.containsKey(paramString)) {
      this.EDU.remove(paramString);
    }
    AppMethodBeat.o(110599);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.downloader.d
 * JD-Core Version:    0.7.0.1
 */