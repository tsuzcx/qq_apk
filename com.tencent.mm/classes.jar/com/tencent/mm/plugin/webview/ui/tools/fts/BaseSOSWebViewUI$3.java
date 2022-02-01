package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.f;
import java.util.Map;

final class BaseSOSWebViewUI$3
  implements Runnable
{
  BaseSOSWebViewUI$3(BaseSOSWebViewUI paramBaseSOSWebViewUI, Map paramMap) {}
  
  public final void run()
  {
    AppMethodBeat.i(80526);
    if (this.CCB.getJsapi() != null) {
      this.CCB.getJsapi().bx(this.BAd);
    }
    AppMethodBeat.o(80526);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.3
 * JD-Core Version:    0.7.0.1
 */