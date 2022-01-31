package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.MMWebView;

final class d$13
  implements Runnable
{
  d$13(d paramd, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(8876);
    try
    {
      d.d(this.voP).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.uUq + ")", null);
      AppMethodBeat.o(8876);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.JsApiHandler", "onLocalImageUploadProgress fail, ex = %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(8876);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.d.13
 * JD-Core Version:    0.7.0.1
 */