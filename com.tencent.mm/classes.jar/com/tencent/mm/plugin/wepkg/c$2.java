package com.tencent.mm.plugin.wepkg;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.xweb.WebView;

final class c$2
  implements Runnable
{
  c$2(c paramc, WebView paramWebView, boolean paramBoolean) {}
  
  public final void run()
  {
    if (this.ruX != null)
    {
      String str = String.format("javascript:(function() {window.__usewepkg__=%s;})();", new Object[] { Boolean.valueOf(this.rOa) });
      this.ruX.evaluateJavascript(str, null);
      return;
    }
    y.i("MicroMsg.WePkgPlugin", "injectWepkgState, webview == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.c.2
 * JD-Core Version:    0.7.0.1
 */