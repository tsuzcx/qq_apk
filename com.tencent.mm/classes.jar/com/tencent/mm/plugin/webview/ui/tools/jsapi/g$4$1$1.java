package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.sdk.platformtools.y;

final class g$4$1$1
  implements g.d.a
{
  g$4$1$1(g.4.1 param1) {}
  
  public final void q(boolean paramBoolean1, boolean paramBoolean2)
  {
    y.i("MicroMsg.MsgHandler", "onLaunchAppCallback(launchRet : %s, launchSuccess : %s)", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if (paramBoolean1)
    {
      g.a(this.rzm.rzl.rzi, this.rzm.rzl.rzk, "launchApplication:ok", null);
      return;
    }
    g.a(this.rzm.rzl.rzi, this.rzm.rzl.rzk, "launchApplication:fail", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.4.1.1
 * JD-Core Version:    0.7.0.1
 */