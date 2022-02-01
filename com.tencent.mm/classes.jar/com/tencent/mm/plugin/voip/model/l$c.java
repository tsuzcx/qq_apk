package com.tencent.mm.plugin.voip.model;

import android.net.Proxy;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.sdk.platformtools.ac;
import java.net.InetAddress;
import java.net.UnknownHostException;

final class l$c
  implements Runnable
{
  int ACn = 0;
  int ACo = 0;
  l.b ACp;
  int ngZ;
  
  private l$c(l paraml) {}
  
  public final void run()
  {
    AppMethodBeat.i(114898);
    String str = Proxy.getDefaultHost();
    int i = Proxy.getDefaultPort();
    if ((str != null) && (str.length() > 0) && (i > 0))
    {
      this.ngZ = 1;
      this.ACn = i;
    }
    try
    {
      this.ACo = d.ajv(InetAddress.getByName(str).getHostAddress());
      this.ACp.au(this.ngZ, this.ACn, this.ACo);
      AppMethodBeat.o(114898);
      return;
    }
    catch (UnknownHostException localUnknownHostException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.Voip.VoipContext", localUnknownHostException, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.l.c
 * JD-Core Version:    0.7.0.1
 */