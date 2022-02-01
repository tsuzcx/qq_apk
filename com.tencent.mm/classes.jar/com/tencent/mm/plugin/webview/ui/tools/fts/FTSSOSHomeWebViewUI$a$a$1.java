package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.f.41;
import com.tencent.mm.plugin.webview.c.l.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;

final class FTSSOSHomeWebViewUI$a$a$1
  implements Runnable
{
  FTSSOSHomeWebViewUI$a$a$1(FTSSOSHomeWebViewUI.a.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(80635);
    f localf = this.Ezw.Ezv.Ezo.getJsapi();
    if (!localf.BZx)
    {
      ae.e("MicroMsg.JsApiHandler", "onFocusSearchInput fail, not ready");
      AppMethodBeat.o(80635);
      return;
    }
    ae.i("MicroMsg.JsApiHandler", "onFocusSearchInput success, ready");
    ar.f(new f.41(localf, l.a.b("onFocusSearchInput", null, localf.EeC, localf.vVT)));
    AppMethodBeat.o(80635);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.a.a.1
 * JD-Core Version:    0.7.0.1
 */