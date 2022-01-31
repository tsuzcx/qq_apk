package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMWebView;

final class d$60
  implements Runnable
{
  d$60(d paramd, String paramString) {}
  
  public final void run()
  {
    try
    {
      d.d(this.rxV).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.fZS + ")", null);
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.JsApiHandler", "onGetMsgProofItems fail, ex = %s", new Object[] { localException.getMessage() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.d.60
 * JD-Core Version:    0.7.0.1
 */