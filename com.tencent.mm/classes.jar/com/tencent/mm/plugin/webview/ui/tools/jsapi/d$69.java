package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.MMWebView;

public final class d$69
  implements Runnable
{
  public d$69(d paramd, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(153328);
    try
    {
      if (d.d(this.voP) != null) {
        d.d(this.voP).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.voV + ")", null);
      }
      AppMethodBeat.o(153328);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.JsApiHandler", "eval onMiniProgramData, ex = %s", new Object[] { localException });
      AppMethodBeat.o(153328);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.d.69
 * JD-Core Version:    0.7.0.1
 */