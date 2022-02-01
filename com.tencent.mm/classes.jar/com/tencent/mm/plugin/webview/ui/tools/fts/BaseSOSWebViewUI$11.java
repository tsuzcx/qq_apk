package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.d.h;

final class BaseSOSWebViewUI$11
  implements Runnable
{
  BaseSOSWebViewUI$11(BaseSOSWebViewUI paramBaseSOSWebViewUI, String paramString, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(80534);
    if (this.Jnm.getJsapi() != null) {
      this.Jnm.getJsapi().gq(this.Jnq, this.joN);
    }
    AppMethodBeat.o(80534);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.11
 * JD-Core Version:    0.7.0.1
 */