package com.tencent.mm.plugin.wepkg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.xweb.WebView;

final class c$2
  implements Runnable
{
  c$2(c paramc, WebView paramWebView, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(63365);
    if (this.vlm != null)
    {
      String str = String.format("javascript:(function() {window.__usewepkg__=%s;})();", new Object[] { Boolean.valueOf(this.vEK) });
      this.vlm.evaluateJavascript(str, null);
      AppMethodBeat.o(63365);
      return;
    }
    ab.i("MicroMsg.Wepkg.WePkgPlugin", "injectWepkgState, webview == null");
    AppMethodBeat.o(63365);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.c.2
 * JD-Core Version:    0.7.0.1
 */