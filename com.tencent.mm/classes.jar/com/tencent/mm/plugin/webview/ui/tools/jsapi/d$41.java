package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.MMWebView;

public final class d$41
  implements Runnable
{
  public d$41(d paramd, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(8904);
    try
    {
      d.d(this.voP).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.uUq + ")", null);
      AppMethodBeat.o(8904);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.JsApiHandler", "onSearchWAWidgetOpenApp fail, ex = %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(8904);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.d.41
 * JD-Core Version:    0.7.0.1
 */