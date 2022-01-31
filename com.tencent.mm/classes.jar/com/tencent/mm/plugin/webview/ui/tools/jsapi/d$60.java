package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.MMWebView;

public final class d$60
  implements Runnable
{
  public d$60(d paramd, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(8923);
    try
    {
      d.d(this.voP).evaluateJavascript(this.voV, null);
      AppMethodBeat.o(8923);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.JsApiHandler", "onPullDownRefresh fail, ex = %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(8923);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.d.60
 * JD-Core Version:    0.7.0.1
 */