package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.MMWebView;

final class d$31
  implements Runnable
{
  d$31(d paramd, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(8894);
    try
    {
      d.d(this.voP).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.uUq + ")", null);
      AppMethodBeat.o(8894);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.JsApiHandler", "onSelectContact fail, ex = %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(8894);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.d.31
 * JD-Core Version:    0.7.0.1
 */