package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.MMWebView;

public final class d$36
  implements Runnable
{
  public d$36(d paramd, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(8899);
    try
    {
      ab.d("MicroMsg.JsApiHandler", "onSearchHistoryReady %s", new Object[] { this.uUq });
      d.d(this.voP).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.uUq + ")", null);
      AppMethodBeat.o(8899);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.JsApiHandler", "onSearchHistoryReady fail, ex = %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(8899);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.d.36
 * JD-Core Version:    0.7.0.1
 */