package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;

final class g$29
  implements Runnable
{
  g$29(g paramg, Intent paramIntent) {}
  
  public final void run()
  {
    AppMethodBeat.i(153375);
    d.b(g.j(this.vqm), "webview", ".ui.tools.game.GameWebViewUI", this.val$intent);
    AppMethodBeat.o(153375);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.29
 * JD-Core Version:    0.7.0.1
 */