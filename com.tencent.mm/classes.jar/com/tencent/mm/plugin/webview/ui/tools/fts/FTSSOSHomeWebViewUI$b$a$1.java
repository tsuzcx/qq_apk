package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.39;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class FTSSOSHomeWebViewUI$b$a$1
  implements Runnable
{
  FTSSOSHomeWebViewUI$b$a$1(FTSSOSHomeWebViewUI.b.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(8458);
    d locald = this.vlg.vlf.vkS.getJsapi();
    if (!locald.ready)
    {
      ab.e("MicroMsg.JsApiHandler", "onFocusSearchInput fail, not ready");
      AppMethodBeat.o(8458);
      return;
    }
    ab.i("MicroMsg.JsApiHandler", "onFocusSearchInput success, ready");
    al.d(new d.39(locald, i.a.b("onFocusSearchInput", null, locald.voB, locald.voC)));
    AppMethodBeat.o(8458);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.b.a.1
 * JD-Core Version:    0.7.0.1
 */