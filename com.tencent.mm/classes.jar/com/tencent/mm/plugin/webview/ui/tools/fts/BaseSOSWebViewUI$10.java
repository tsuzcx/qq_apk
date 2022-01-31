package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;

final class BaseSOSWebViewUI$10
  implements Runnable
{
  BaseSOSWebViewUI$10(BaseSOSWebViewUI paramBaseSOSWebViewUI, String paramString, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(8340);
    if (this.vjG.getJsapi() != null) {
      this.vjG.getJsapi().ec(this.vjK, this.fUa);
    }
    AppMethodBeat.o(8340);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.10
 * JD-Core Version:    0.7.0.1
 */