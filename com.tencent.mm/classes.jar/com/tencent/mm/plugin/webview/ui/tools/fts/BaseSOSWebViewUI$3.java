package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import java.util.Map;

final class BaseSOSWebViewUI$3
  implements Runnable
{
  BaseSOSWebViewUI$3(BaseSOSWebViewUI paramBaseSOSWebViewUI, Map paramMap) {}
  
  public final void run()
  {
    AppMethodBeat.i(8333);
    if (this.vjG.getJsapi() != null) {
      this.vjG.getJsapi().aP(this.bQD);
    }
    AppMethodBeat.o(8333);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.3
 * JD-Core Version:    0.7.0.1
 */