package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;

final class BaseSOSWebViewUI$9
  implements Runnable
{
  BaseSOSWebViewUI$9(BaseSOSWebViewUI paramBaseSOSWebViewUI, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(8339);
    if (this.vjG.getJsapi() != null) {
      this.vjG.getJsapi().aiZ(this.iOH);
    }
    AppMethodBeat.o(8339);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.9
 * JD-Core Version:    0.7.0.1
 */