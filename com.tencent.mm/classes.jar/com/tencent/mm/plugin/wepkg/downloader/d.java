package com.tencent.mm.plugin.wepkg.downloader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.concurrent.Future;

public final class d
{
  private static volatile d BHM;
  private static Object lock;
  HashMap<String, c> BHN;
  
  static
  {
    AppMethodBeat.i(110601);
    lock = new Object();
    AppMethodBeat.o(110601);
  }
  
  private d()
  {
    AppMethodBeat.i(110598);
    this.BHN = new HashMap();
    AppMethodBeat.o(110598);
  }
  
  public static d etG()
  {
    AppMethodBeat.i(110597);
    if (BHM == null) {}
    synchronized (lock)
    {
      if (BHM == null) {
        BHM = new d();
      }
      ??? = BHM;
      AppMethodBeat.o(110597);
      return ???;
    }
  }
  
  final boolean a(c paramc)
  {
    AppMethodBeat.i(110600);
    if (this.BHN.containsKey(paramc.BHD.BId))
    {
      paramc.BHJ = true;
      for (;;)
      {
        try
        {
          HttpURLConnection localHttpURLConnection = paramc.BHF;
          if (localHttpURLConnection == null) {}
        }
        catch (Exception localException2)
        {
          ad.i("MicroMsg.Wepkg.WePkgDownloadTask", "stop, " + localException2.getMessage());
          continue;
        }
        try
        {
          paramc.BHF.getInputStream().close();
          paramc.BHF.disconnect();
          if (paramc.BHE != null) {
            paramc.BHE.cancel(false);
          }
          this.BHN.remove(paramc.BHD.BId);
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
  
  public final boolean azQ(String paramString)
  {
    AppMethodBeat.i(110599);
    if (this.BHN.containsKey(paramString)) {
      this.BHN.remove(paramString);
    }
    AppMethodBeat.o(110599);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.downloader.d
 * JD-Core Version:    0.7.0.1
 */