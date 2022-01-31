package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.MMWebView;

final class d$57
  implements Runnable
{
  d$57(d paramd, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(8921);
    try
    {
      d.d(this.voP).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.uUq + ")", null);
      AppMethodBeat.o(8921);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.JsApiHandler", "onUxOplogDataReady fail, ex = %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(8921);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.d.57
 * JD-Core Version:    0.7.0.1
 */