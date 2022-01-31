package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMWebView;

public final class d$61
  implements Runnable
{
  public d$61(d paramd, String paramString) {}
  
  public final void run()
  {
    try
    {
      if (d.d(this.rxV) != null) {
        d.d(this.rxV).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.ryb + ")", null);
      }
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.JsApiHandler", "eval onMiniProgramData, ex = %s", new Object[] { localException });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.d.61
 * JD-Core Version:    0.7.0.1
 */