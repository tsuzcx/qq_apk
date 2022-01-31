package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.ui.widget.MMWebView;

public final class d$62
  implements Runnable
{
  public d$62(d paramd, String paramString) {}
  
  public final void run()
  {
    try
    {
      d.d(this.rxV).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.fZS + ")", null);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.d.62
 * JD-Core Version:    0.7.0.1
 */