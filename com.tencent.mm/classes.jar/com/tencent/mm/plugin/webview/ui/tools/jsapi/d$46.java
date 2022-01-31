package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.MMWebView;

public final class d$46
  implements Runnable
{
  public d$46(d paramd, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(8910);
    try
    {
      d.d(this.voP).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.uUq + ")", null);
      AppMethodBeat.o(8910);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.JsApiHandler", "onSearchWAWidgetDataPush fail, ex = %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(8910);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.d.46
 * JD-Core Version:    0.7.0.1
 */