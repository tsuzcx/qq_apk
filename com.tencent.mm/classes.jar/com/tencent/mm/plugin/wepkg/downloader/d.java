package com.tencent.mm.plugin.wepkg.downloader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.concurrent.Future;

public final class d
{
  private static Object lock;
  private static volatile d vFa;
  HashMap<String, c> vFb;
  
  static
  {
    AppMethodBeat.i(63430);
    lock = new Object();
    AppMethodBeat.o(63430);
  }
  
  private d()
  {
    AppMethodBeat.i(63427);
    this.vFb = new HashMap();
    AppMethodBeat.o(63427);
  }
  
  public static d dkx()
  {
    AppMethodBeat.i(63426);
    if (vFa == null) {}
    synchronized (lock)
    {
      if (vFa == null) {
        vFa = new d();
      }
      ??? = vFa;
      AppMethodBeat.o(63426);
      return ???;
    }
  }
  
  final boolean a(c paramc)
  {
    AppMethodBeat.i(63429);
    if (this.vFb.containsKey(paramc.vER.vFr))
    {
      paramc.vEX = true;
      for (;;)
      {
        try
        {
          HttpURLConnection localHttpURLConnection = paramc.vET;
          if (localHttpURLConnection == null) {}
        }
        catch (Exception localException2)
        {
          ab.i("MicroMsg.Wepkg.WePkgDownloadTask", "stop, " + localException2.getMessage());
          continue;
        }
        try
        {
          paramc.vET.getInputStream().close();
          paramc.vET.disconnect();
          if (paramc.vES != null) {
            paramc.vES.cancel(false);
          }
          this.vFb.remove(paramc.vER.vFr);
          AppMethodBeat.o(63429);
          return true;
        }
        catch (Exception localException1)
        {
          ab.e("MicroMsg.Wepkg.WePkgDownloadTask", localException1.getMessage());
        }
      }
    }
    AppMethodBeat.o(63429);
    return false;
  }
  
  public final boolean akx(String paramString)
  {
    AppMethodBeat.i(63428);
    if (this.vFb.containsKey(paramString)) {
      this.vFb.remove(paramString);
    }
    AppMethodBeat.o(63428);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.downloader.d
 * JD-Core Version:    0.7.0.1
 */