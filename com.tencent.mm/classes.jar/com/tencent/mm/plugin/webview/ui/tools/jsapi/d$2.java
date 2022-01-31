package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.MMWebView;

final class d$2
  implements Runnable
{
  d$2(d paramd, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(8865);
    try
    {
      d.d(this.voP).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.uUq + ")", null);
      AppMethodBeat.o(8865);
      return;
    }
    catch (Exception localException)
    {
      ab.w("MicroMsg.JsApiHandler", "onDownloadStateChange, ex = %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(8865);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.d.2
 * JD-Core Version:    0.7.0.1
 */