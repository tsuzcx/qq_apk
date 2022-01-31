package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMWebView;

public final class d$45
  implements Runnable
{
  public d$45(d paramd, String paramString) {}
  
  public final void run()
  {
    try
    {
      d.d(this.rxV).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.fZS + ")", null);
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.JsApiHandler", "onSearchWAWidgetDataPush fail, ex = %s", new Object[] { localException.getMessage() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.d.45
 * JD-Core Version:    0.7.0.1
 */