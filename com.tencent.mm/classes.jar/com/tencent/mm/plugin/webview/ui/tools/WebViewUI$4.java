package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.56;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

final class WebViewUI$4
  implements g.a
{
  WebViewUI$4(WebViewUI paramWebViewUI) {}
  
  public final void cdM()
  {
    y.d("MicroMsg.WebViewUI", "onPullDownRefresh, start");
    d locald;
    if (this.rpH.rbk != null)
    {
      locald = this.rpH.rbk;
      if (!locald.ready) {
        y.e("MicroMsg.JsApiHandler", "onPullDownRefresh fail, not ready");
      }
    }
    else
    {
      return;
    }
    y.i("MicroMsg.JsApiHandler", "onPullDownRefresh success, ready");
    ai.d(new d.56(locald, d.TQ(i.a.a("onPullDownRefresh", null, locald.rxI, locald.rxJ))));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.4
 * JD-Core Version:    0.7.0.1
 */