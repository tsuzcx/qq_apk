package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.f;

final class BaseSOSWebViewUI$8
  implements Runnable
{
  BaseSOSWebViewUI$8(BaseSOSWebViewUI paramBaseSOSWebViewUI, int paramInt1, String paramString, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(80531);
    if (this.Egk.getJsapi() != null) {
      this.Egk.getJsapi().v(this.Egm, this.mEz, this.mEA);
    }
    AppMethodBeat.o(80531);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.8
 * JD-Core Version:    0.7.0.1
 */