package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;

final class BaseSOSWebViewUI$18
  implements Runnable
{
  BaseSOSWebViewUI$18(BaseSOSWebViewUI paramBaseSOSWebViewUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(8348);
    if (this.vjG.getJsapi() != null) {
      this.vjG.getJsapi().a(this.vjG.getTotalQuery(), this.vjG.getInEditTextQuery(), this.vjG.dfD());
    }
    AppMethodBeat.o(8348);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.18
 * JD-Core Version:    0.7.0.1
 */