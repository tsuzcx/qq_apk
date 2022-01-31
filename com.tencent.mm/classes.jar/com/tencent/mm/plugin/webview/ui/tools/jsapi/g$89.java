package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fo;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.sdk.b.a;

public final class g$89
  implements Runnable
{
  public g$89(g paramg, WebViewJSSDKFileItem paramWebViewJSSDKFileItem) {}
  
  public final void run()
  {
    AppMethodBeat.i(9155);
    fo localfo = new fo();
    localfo.ctE.op = 2;
    localfo.ctE.filePath = this.vrl.hgj;
    a.ymk.l(localfo);
    g.H(this.vqm);
    AppMethodBeat.o(9155);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.89
 * JD-Core Version:    0.7.0.1
 */