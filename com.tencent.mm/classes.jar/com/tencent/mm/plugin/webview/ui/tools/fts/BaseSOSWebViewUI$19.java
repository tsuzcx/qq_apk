package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;

final class BaseSOSWebViewUI$19
  implements Runnable
{
  BaseSOSWebViewUI$19(BaseSOSWebViewUI paramBaseSOSWebViewUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(8349);
    if (this.vjG.getJsapi() != null) {
      this.vjG.getJsapi().a(this.vjG.getTotalQuery(), this.vjG.getInEditTextQuery(), this.vjG.dfD());
    }
    AppMethodBeat.o(8349);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.19
 * JD-Core Version:    0.7.0.1
 */