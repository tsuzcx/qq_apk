package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.MMWebView;

final class d$48
  implements Runnable
{
  d$48(d paramd, String paramString1, String paramString2) {}
  
  public final void run()
  {
    AppMethodBeat.i(8912);
    try
    {
      d.d(this.voP).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.voU + ")", null);
      AppMethodBeat.o(8912);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.JsApiHandler", "onSendEventToJSBridge fail, event=%s, ex=%s", new Object[] { this.uUq, localException.getMessage() });
      AppMethodBeat.o(8912);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.d.48
 * JD-Core Version:    0.7.0.1
 */