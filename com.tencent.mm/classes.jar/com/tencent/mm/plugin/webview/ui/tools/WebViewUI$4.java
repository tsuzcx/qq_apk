package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.60;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class WebViewUI$4
  implements l.a
{
  WebViewUI$4(WebViewUI paramWebViewUI) {}
  
  public final void ded()
  {
    AppMethodBeat.i(7812);
    ab.d("MicroMsg.WebViewUI", "onPullDownRefresh, start");
    if (this.vgz.uQS != null)
    {
      d locald = this.vgz.uQS;
      if (!locald.ready)
      {
        ab.e("MicroMsg.JsApiHandler", "onPullDownRefresh fail, not ready");
        AppMethodBeat.o(7812);
        return;
      }
      ab.i("MicroMsg.JsApiHandler", "onPullDownRefresh success, ready");
      al.d(new d.60(locald, d.aja(i.a.b("onPullDownRefresh", null, locald.voB, locald.voC))));
    }
    AppMethodBeat.o(7812);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.4
 * JD-Core Version:    0.7.0.1
 */