package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.f;

final class BaseSOSWebViewUI$7
  implements Runnable
{
  BaseSOSWebViewUI$7(BaseSOSWebViewUI paramBaseSOSWebViewUI, int paramInt1, String paramString, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(80530);
    if (this.CCB.getJsapi() != null) {
      this.CCB.getJsapi().w(this.CCD, this.meg, this.meh);
    }
    AppMethodBeat.o(80530);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.7
 * JD-Core Version:    0.7.0.1
 */