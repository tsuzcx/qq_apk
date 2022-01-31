package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;

final class g$35
  implements Runnable
{
  g$35(g paramg, Intent paramIntent) {}
  
  public final void run()
  {
    AppMethodBeat.i(9086);
    d.b(g.j(this.vqm), "webview", ".ui.tools.game.GameWebViewUI", this.val$intent);
    AppMethodBeat.o(9086);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.35
 * JD-Core Version:    0.7.0.1
 */