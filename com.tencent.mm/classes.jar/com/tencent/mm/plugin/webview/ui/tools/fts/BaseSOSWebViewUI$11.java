package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.f;

final class BaseSOSWebViewUI$11
  implements Runnable
{
  BaseSOSWebViewUI$11(BaseSOSWebViewUI paramBaseSOSWebViewUI, String paramString, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(80534);
    if (this.Egk.getJsapi() != null) {
      this.Egk.getJsapi().fI(this.Egn, this.iqF);
    }
    AppMethodBeat.o(80534);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.11
 * JD-Core Version:    0.7.0.1
 */