package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;

final class g$118
  implements Runnable
{
  g$118(g paramg, Intent paramIntent) {}
  
  public final void run()
  {
    AppMethodBeat.i(9195);
    d.b(g.j(this.vqm), "webview", ".ui.tools.WebViewUI", this.val$intent);
    AppMethodBeat.o(9195);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.118
 * JD-Core Version:    0.7.0.1
 */