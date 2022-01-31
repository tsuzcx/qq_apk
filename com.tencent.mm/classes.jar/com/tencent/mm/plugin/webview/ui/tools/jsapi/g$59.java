package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.modelgeo.c;
import com.tencent.mm.sdk.platformtools.y;

final class g$59
  implements Runnable
{
  g$59(g paramg) {}
  
  public final void run()
  {
    if (g.x(this.rzi) != null) {
      g.x(this.rzi).c(g.y(this.rzi));
    }
    if (g.y(this.rzi) == null)
    {
      y.w("MicroMsg.MsgHandler", "already callback");
      return;
    }
    g.z(this.rzi);
    g.a(this.rzi, g.j(this.rzi), "geo_location:fail_timeout", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.59
 * JD-Core Version:    0.7.0.1
 */