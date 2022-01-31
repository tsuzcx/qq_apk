package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class g$120
  implements Runnable
{
  g$120(g paramg) {}
  
  public final void run()
  {
    AppMethodBeat.i(9197);
    try
    {
      g.k(this.vqm, new i());
      AppMethodBeat.o(9197);
      return;
    }
    catch (Exception localException)
    {
      ab.i("MicroMsg.MsgHandler", "openCunstomWebview, close window exception : %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(9197);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.120
 * JD-Core Version:    0.7.0.1
 */