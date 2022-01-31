package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.MMWebView;

final class d$30
  implements Runnable
{
  d$30(d paramd, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(8893);
    try
    {
      d.d(this.voP).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.voS + ")", null);
      AppMethodBeat.o(8893);
      return;
    }
    catch (Exception localException)
    {
      ab.w("MicroMsg.JsApiHandler", "doCallback, ex = %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(8893);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.d.30
 * JD-Core Version:    0.7.0.1
 */