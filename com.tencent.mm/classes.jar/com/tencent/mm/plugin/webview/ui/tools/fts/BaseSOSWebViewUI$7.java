package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;

final class BaseSOSWebViewUI$7
  implements Runnable
{
  BaseSOSWebViewUI$7(BaseSOSWebViewUI paramBaseSOSWebViewUI, int paramInt1, String paramString, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(8337);
    if (this.vjG.getJsapi() != null) {
      this.vjG.getJsapi().p(this.vjJ, this.iOH, this.iOI);
    }
    AppMethodBeat.o(8337);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.7
 * JD-Core Version:    0.7.0.1
 */