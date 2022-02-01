package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.f.39;
import com.tencent.mm.plugin.webview.c.l.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;

final class FTSSOSHomeWebViewUI$a$a$1
  implements Runnable
{
  FTSSOSHomeWebViewUI$a$a$1(FTSSOSHomeWebViewUI.a.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(80635);
    f localf = this.Blv.Blu.Bln.getJsapi();
    if (!localf.yZR)
    {
      ad.e("MicroMsg.JsApiHandler", "onFocusSearchInput fail, not ready");
      AppMethodBeat.o(80635);
      return;
    }
    ad.i("MicroMsg.JsApiHandler", "onFocusSearchInput success, ready");
    aq.f(new f.39(localf, l.a.b("onFocusSearchInput", null, localf.ARm, localf.ARn)));
    AppMethodBeat.o(80635);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.a.a.1
 * JD-Core Version:    0.7.0.1
 */