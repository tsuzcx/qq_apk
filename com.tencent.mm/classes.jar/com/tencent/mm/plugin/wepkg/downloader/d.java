package com.tencent.mm.plugin.wepkg.downloader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.concurrent.Future;

public final class d
{
  private static volatile d XEZ;
  private static Object lock;
  HashMap<String, c> XFa;
  
  static
  {
    AppMethodBeat.i(110601);
    lock = new Object();
    AppMethodBeat.o(110601);
  }
  
  private d()
  {
    AppMethodBeat.i(110598);
    this.XFa = new HashMap();
    AppMethodBeat.o(110598);
  }
  
  public static d iFk()
  {
    AppMethodBeat.i(110597);
    if (XEZ == null) {}
    synchronized (lock)
    {
      if (XEZ == null) {
        XEZ = new d();
      }
      ??? = XEZ;
      AppMethodBeat.o(110597);
      return ???;
    }
  }
  
  boolean a(c paramc)
  {
    AppMethodBeat.i(110600);
    if (this.XFa.containsKey(paramc.XER.XFp))
    {
      paramc.XEW = true;
      for (;;)
      {
        try
        {
          HttpURLConnection localHttpURLConnection = paramc.XES;
          if (localHttpURLConnection == null) {}
        }
        catch (Exception localException2)
        {
          Log.i("MicroMsg.Wepkg.WePkgDownloadTask", "stop, " + localException2.getMessage());
          continue;
        }
        try
        {
          paramc.XES.getInputStream().close();
          paramc.XES.disconnect();
          if (paramc.PL != null) {
            paramc.PL.cancel(false);
          }
          this.XFa.remove(paramc.XER.XFp);
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
  
  public final boolean boj(String paramString)
  {
    AppMethodBeat.i(110599);
    if (this.XFa.containsKey(paramString)) {
      this.XFa.remove(paramString);
    }
    AppMethodBeat.o(110599);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.downloader.d
 * JD-Core Version:    0.7.0.1
 */