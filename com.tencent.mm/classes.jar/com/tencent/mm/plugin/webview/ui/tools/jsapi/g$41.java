package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.h.a.cp;
import com.tencent.mm.h.a.cp.b;
import com.tencent.mm.sdk.platformtools.y;

final class g$41
  implements Runnable
{
  g$41(g paramg, cp paramcp, i parami) {}
  
  public final void run()
  {
    y.i("MicroMsg.MsgHandler", "run ecard jsapi check callback");
    if (this.qJJ.bIJ.retCode == 0)
    {
      g.a(this.rzi, this.rzk, "openECard:ok", null);
      return;
    }
    g.a(this.rzi, this.rzk, "openECard:fail", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.41
 * JD-Core Version:    0.7.0.1
 */