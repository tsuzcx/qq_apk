package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.d.h;

final class BaseSOSWebViewUI$7
  implements Runnable
{
  BaseSOSWebViewUI$7(BaseSOSWebViewUI paramBaseSOSWebViewUI, int paramInt, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(80530);
    if (this.Jnm.getJsapi() != null) {
      this.Jnm.getJsapi().cQ(this.qQL, this.lxA);
    }
    AppMethodBeat.o(80530);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.7
 * JD-Core Version:    0.7.0.1
 */