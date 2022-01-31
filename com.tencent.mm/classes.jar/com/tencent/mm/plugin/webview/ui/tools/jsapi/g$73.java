package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.dq;
import com.tencent.mm.g.a.dq.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;

final class g$73
  implements Runnable
{
  g$73(g paramg, dq paramdq, i parami) {}
  
  public final void run()
  {
    AppMethodBeat.i(9136);
    ab.i("MicroMsg.MsgHandler", "ExDeviceGetTicketEvent isOk[%s], ticket[%s]", new Object[] { Boolean.valueOf(this.vrf.crp.crr), this.vrf.crp.crs });
    if (this.vrf.crp.crr)
    {
      if (!bo.isNullOrNil(this.vrf.crp.crs))
      {
        HashMap localHashMap = new HashMap();
        ab.i("MicroMsg.MsgHandler", "ticket %s", new Object[] { this.vrf.crp.crs });
        localHashMap.put("ticket", this.vrf.crp.crs);
        this.vqm.a(this.uZa, "getWXDeviceTicket:ok", localHashMap);
        AppMethodBeat.o(9136);
        return;
      }
      this.vqm.a(this.uZa, "getWXDeviceTicket:fail", null);
    }
    AppMethodBeat.o(9136);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.73
 * JD-Core Version:    0.7.0.1
 */