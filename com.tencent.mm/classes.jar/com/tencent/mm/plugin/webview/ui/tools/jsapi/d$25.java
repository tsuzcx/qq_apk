package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.MMWebView;

final class d$25
  implements Runnable
{
  d$25(d paramd, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(8888);
    try
    {
      d.d(this.voP).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.uUq + ")", null);
      AppMethodBeat.o(8888);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.JsApiHandler", "onGetSmiley fail, ex = %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(8888);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.d.25
 * JD-Core Version:    0.7.0.1
 */