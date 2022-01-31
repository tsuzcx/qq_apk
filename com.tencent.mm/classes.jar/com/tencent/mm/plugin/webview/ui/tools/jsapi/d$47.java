package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMWebView;

final class d$47
  implements Runnable
{
  d$47(d paramd, String paramString1, String paramString2) {}
  
  public final void run()
  {
    try
    {
      d.d(this.rxV).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.rya + ")", null);
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.JsApiHandler", "onSendEventToJSBridge fail, event=%s, ex=%s", new Object[] { this.fZS, localException.getMessage() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.d.47
 * JD-Core Version:    0.7.0.1
 */