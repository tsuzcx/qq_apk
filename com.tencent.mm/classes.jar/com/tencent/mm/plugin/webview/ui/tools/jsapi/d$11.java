package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.MMWebView;

public final class d$11
  implements Runnable
{
  public d$11(d paramd, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(8874);
    try
    {
      d.d(this.voP).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.uUq + ")", null);
      AppMethodBeat.o(8874);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.JsApiHandler", "onMediaFileUploadProgress fail, ex = %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(8874);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.d.11
 * JD-Core Version:    0.7.0.1
 */