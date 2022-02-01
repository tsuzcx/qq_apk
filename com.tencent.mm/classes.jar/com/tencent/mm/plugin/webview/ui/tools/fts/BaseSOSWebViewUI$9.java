package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.f;

final class BaseSOSWebViewUI$9
  implements Runnable
{
  BaseSOSWebViewUI$9(BaseSOSWebViewUI paramBaseSOSWebViewUI, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(80532);
    if (this.CCB.getJsapi() != null) {
      this.CCB.getJsapi().aBp(this.meg);
    }
    AppMethodBeat.o(80532);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.9
 * JD-Core Version:    0.7.0.1
 */