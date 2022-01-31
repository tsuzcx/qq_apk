package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.sdk.platformtools.y;

final class g$110
  implements Runnable
{
  g$110(g paramg) {}
  
  public final void run()
  {
    try
    {
      g.j(this.rzi, new i());
      return;
    }
    catch (Exception localException)
    {
      y.i("MicroMsg.MsgHandler", "openCunstomWebview, close window exception : %s", new Object[] { localException.getMessage() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.110
 * JD-Core Version:    0.7.0.1
 */