package com.tencent.mm.plugin.voip.model;

import android.net.Proxy;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.f.g;
import com.tencent.mm.sdk.platformtools.Log;
import java.net.InetAddress;
import java.net.UnknownHostException;

final class l$c
  implements Runnable
{
  int Uzx = 0;
  int Uzy = 0;
  l.b Uzz;
  int vll;
  
  private l$c(l paraml) {}
  
  public final void run()
  {
    AppMethodBeat.i(114898);
    String str = Proxy.getDefaultHost();
    int i = Proxy.getDefaultPort();
    if ((str != null) && (str.length() > 0) && (i > 0))
    {
      this.vll = 1;
      this.Uzx = i;
    }
    try
    {
      this.Uzy = g.aJE(InetAddress.getByName(str).getHostAddress());
      this.Uzz.bi(this.vll, this.Uzx, this.Uzy);
      AppMethodBeat.o(114898);
      return;
    }
    catch (UnknownHostException localUnknownHostException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.Voip.VoipContext", localUnknownHostException, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.l.c
 * JD-Core Version:    0.7.0.1
 */