package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.d.h;

final class BaseSOSWebViewUI$10
  implements Runnable
{
  BaseSOSWebViewUI$10(BaseSOSWebViewUI paramBaseSOSWebViewUI, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(80533);
    if (this.Jnm.getJsapi() != null) {
      this.Jnm.getJsapi().aXm(this.nWD);
    }
    AppMethodBeat.o(80533);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.10
 * JD-Core Version:    0.7.0.1
 */