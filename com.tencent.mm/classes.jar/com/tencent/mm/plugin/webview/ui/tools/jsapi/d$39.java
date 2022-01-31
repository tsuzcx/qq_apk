package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.MMWebView;

public final class d$39
  implements Runnable
{
  public d$39(d paramd, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(8902);
    try
    {
      d.d(this.voP).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.uUq + ")", null);
      AppMethodBeat.o(8902);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.JsApiHandler", "onFocusSearchInput fail, ex = %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(8902);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.d.39
 * JD-Core Version:    0.7.0.1
 */