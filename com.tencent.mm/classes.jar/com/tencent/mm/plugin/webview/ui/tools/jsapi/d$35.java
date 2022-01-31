package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMWebView;

public final class d$35
  implements Runnable
{
  public d$35(d paramd, String paramString) {}
  
  public final void run()
  {
    try
    {
      y.d("MicroMsg.JsApiHandler", "onSearchHistoryReady %s", new Object[] { this.fZS });
      d.d(this.rxV).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.fZS + ")", null);
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.JsApiHandler", "onSearchHistoryReady fail, ex = %s", new Object[] { localException.getMessage() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.d.35
 * JD-Core Version:    0.7.0.1
 */