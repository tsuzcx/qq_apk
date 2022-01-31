package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.MMWebView;

final class d$61
  implements Runnable
{
  d$61(d paramd, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(8924);
    try
    {
      d.d(this.voP).evaluateJavascript(this.voV, null);
      AppMethodBeat.o(8924);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.JsApiHandler", "onPullDownRefresh fail, ex = %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(8924);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.d.61
 * JD-Core Version:    0.7.0.1
 */