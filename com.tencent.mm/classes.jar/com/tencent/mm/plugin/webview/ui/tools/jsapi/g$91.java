package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fl;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.sdk.b.a;

final class g$91
  implements Runnable
{
  g$91(g paramg, WebViewJSSDKFileItem paramWebViewJSSDKFileItem, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(9157);
    fl localfl = new fl();
    localfl.ctw.op = 1;
    localfl.ctw.fileName = this.vrl.fileName;
    localfl.ctw.cie = true;
    localfl.ctw.ctA = new g.91.1(this);
    localfl.ctw.ctB = new g.91.2(this);
    a.ymk.l(localfl);
    AppMethodBeat.o(9157);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.91
 * JD-Core Version:    0.7.0.1
 */