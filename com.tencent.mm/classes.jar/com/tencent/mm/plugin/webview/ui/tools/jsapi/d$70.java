package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMWebView;

public final class d$70
  implements Runnable
{
  public d$70(d paramd, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(154919);
    try
    {
      d.d(this.voP).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.uUq + ")", null);
      AppMethodBeat.o(154919);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(154919);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.d.70
 * JD-Core Version:    0.7.0.1
 */