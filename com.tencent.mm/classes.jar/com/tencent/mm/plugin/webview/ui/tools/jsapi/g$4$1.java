package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

final class g$4$1
  implements Runnable
{
  g$4$1(g.4 param4) {}
  
  public final void run()
  {
    AppMethodBeat.i(153343);
    Runnable localRunnable = (Runnable)g.dgM().pollFirst();
    if (localRunnable != null)
    {
      localRunnable.run();
      AppMethodBeat.o(153343);
      return;
    }
    ab.i("MicroMsg.MsgHandler", "authJsApiQueue processed!");
    g.dgN();
    AppMethodBeat.o(153343);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.4.1
 * JD-Core Version:    0.7.0.1
 */