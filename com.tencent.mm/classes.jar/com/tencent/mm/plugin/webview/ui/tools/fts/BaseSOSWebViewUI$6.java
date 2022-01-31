package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;

final class BaseSOSWebViewUI$6
  implements Runnable
{
  BaseSOSWebViewUI$6(BaseSOSWebViewUI paramBaseSOSWebViewUI, int paramInt, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(8336);
    if (this.vjG.getJsapi() != null) {
      this.vjG.getJsapi().bG(this.qac, this.hwP);
    }
    AppMethodBeat.o(8336);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.6
 * JD-Core Version:    0.7.0.1
 */