package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;

final class BaseSOSWebViewUI$8
  implements Runnable
{
  BaseSOSWebViewUI$8(BaseSOSWebViewUI paramBaseSOSWebViewUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(8338);
    if (this.vjG.getJsapi() != null) {
      this.vjG.getJsapi().a(this.vjG.getTotalQuery(), this.vjG.getInEditTextQuery(), this.vjG.dfD());
    }
    AppMethodBeat.o(8338);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.8
 * JD-Core Version:    0.7.0.1
 */