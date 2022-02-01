package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.f;

final class BaseSOSWebViewUI$6
  implements Runnable
{
  BaseSOSWebViewUI$6(BaseSOSWebViewUI paramBaseSOSWebViewUI, int paramInt, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(80529);
    if (this.CCB.getJsapi() != null) {
      this.CCB.getJsapi().ct(this.oRg, this.jWh);
    }
    AppMethodBeat.o(80529);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.6
 * JD-Core Version:    0.7.0.1
 */