package com.tencent.mm.plugin.voip.model;

import android.net.Proxy;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import java.net.InetAddress;
import java.net.UnknownHostException;

final class l$c
  implements Runnable
{
  int mEU;
  int zjD = 0;
  int zjE = 0;
  l.b zjF;
  
  private l$c(l paraml) {}
  
  public final void run()
  {
    AppMethodBeat.i(114898);
    String str = Proxy.getDefaultHost();
    int i = Proxy.getDefaultPort();
    if ((str != null) && (str.length() > 0) && (i > 0))
    {
      this.mEU = 1;
      this.zjD = i;
    }
    try
    {
      this.zjE = c.aeD(InetAddress.getByName(str).getHostAddress());
      this.zjF.at(this.mEU, this.zjD, this.zjE);
      AppMethodBeat.o(114898);
      return;
    }
    catch (UnknownHostException localUnknownHostException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.Voip.VoipContext", localUnknownHostException, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.l.c
 * JD-Core Version:    0.7.0.1
 */