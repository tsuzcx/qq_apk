package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;

final class g$117
  implements Runnable
{
  g$117(g paramg, Intent paramIntent) {}
  
  public final void run()
  {
    AppMethodBeat.i(9194);
    d.b(g.j(this.vqm), "webview", ".ui.tools.game.GameWebViewUI", this.val$intent);
    AppMethodBeat.o(9194);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.117
 * JD-Core Version:    0.7.0.1
 */