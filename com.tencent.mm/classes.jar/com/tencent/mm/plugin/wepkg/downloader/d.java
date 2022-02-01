package com.tencent.mm.plugin.wepkg.downloader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.concurrent.Future;

public final class d
{
  private static volatile d JMh;
  private static Object lock;
  HashMap<String, c> JMi;
  
  static
  {
    AppMethodBeat.i(110601);
    lock = new Object();
    AppMethodBeat.o(110601);
  }
  
  private d()
  {
    AppMethodBeat.i(110598);
    this.JMi = new HashMap();
    AppMethodBeat.o(110598);
  }
  
  public static d gkL()
  {
    AppMethodBeat.i(110597);
    if (JMh == null) {}
    synchronized (lock)
    {
      if (JMh == null) {
        JMh = new d();
      }
      ??? = JMh;
      AppMethodBeat.o(110597);
      return ???;
    }
  }
  
  boolean a(c paramc)
  {
    AppMethodBeat.i(110600);
    if (this.JMi.containsKey(paramc.JLZ.JMx))
    {
      paramc.JMe = true;
      for (;;)
      {
        try
        {
          HttpURLConnection localHttpURLConnection = paramc.JMa;
          if (localHttpURLConnection == null) {}
        }
        catch (Exception localException2)
        {
          Log.i("MicroMsg.Wepkg.WePkgDownloadTask", "stop, " + localException2.getMessage());
          continue;
        }
        try
        {
          paramc.JMa.getInputStream().close();
          paramc.JMa.disconnect();
          if (paramc.jKp != null) {
            paramc.jKp.cancel(false);
          }
          this.JMi.remove(paramc.JLZ.JMx);
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
  
  public final boolean bcv(String paramString)
  {
    AppMethodBeat.i(110599);
    if (this.JMi.containsKey(paramString)) {
      this.JMi.remove(paramString);
    }
    AppMethodBeat.o(110599);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.downloader.d
 * JD-Core Version:    0.7.0.1
 */