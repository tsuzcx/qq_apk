package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.38;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

final class FTSSOSHomeWebViewUI$b$a$1
  implements Runnable
{
  FTSSOSHomeWebViewUI$b$a$1(FTSSOSHomeWebViewUI.b.a parama) {}
  
  public final void run()
  {
    d locald = FTSSOSHomeWebViewUI.K(this.ruR.ruQ.ruD);
    if (!locald.ready)
    {
      y.e("MicroMsg.JsApiHandler", "onFocusSearchInput fail, not ready");
      return;
    }
    y.i("MicroMsg.JsApiHandler", "onFocusSearchInput success, ready");
    ai.d(new d.38(locald, i.a.a("onFocusSearchInput", null, locald.rxI, locald.rxJ)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.b.a.1
 * JD-Core Version:    0.7.0.1
 */