package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.h.a.dn;
import com.tencent.mm.h.a.dn.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;

final class g$63
  implements Runnable
{
  g$63(g paramg, dn paramdn, i parami) {}
  
  public final void run()
  {
    y.i("MicroMsg.MsgHandler", "ExDeviceGetTicketEvent isOk[%s], ticket[%s]", new Object[] { Boolean.valueOf(this.rAa.bJV.bJX), this.rAa.bJV.bJY });
    if (this.rAa.bJV.bJX)
    {
      if (!bk.bl(this.rAa.bJV.bJY))
      {
        HashMap localHashMap = new HashMap();
        y.i("MicroMsg.MsgHandler", "ticket %s", new Object[] { this.rAa.bJV.bJY });
        localHashMap.put("ticket", this.rAa.bJV.bJY);
        g.a(this.rzi, this.rzk, "getWXDeviceTicket:ok", localHashMap);
      }
    }
    else {
      return;
    }
    g.a(this.rzi, this.rzk, "getWXDeviceTicket:fail", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.63
 * JD-Core Version:    0.7.0.1
 */