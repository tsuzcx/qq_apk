package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.graphics.Point;
import com.tencent.mm.sdk.platformtools.ah;

final class WebViewBag$1
  implements Runnable
{
  WebViewBag$1(WebViewBag paramWebViewBag) {}
  
  public final void run()
  {
    float f = (float)(System.currentTimeMillis() - WebViewBag.a(this.rsh)) * 1.0F / 200.0F;
    if (f <= 1.0F)
    {
      this.rsh.jge.postDelayed(WebViewBag.b(this.rsh), 5L);
      WebViewBag localWebViewBag = this.rsh;
      int i = WebViewBag.c(this.rsh).x;
      int j = (int)((WebViewBag.d(this.rsh).x * 1.0F - WebViewBag.c(this.rsh).x) * f);
      int k = WebViewBag.c(this.rsh).y;
      WebViewBag.a(localWebViewBag, i + j, (int)(f * (WebViewBag.d(this.rsh).y * 1.0F - WebViewBag.c(this.rsh).y)) + k);
      return;
    }
    WebViewBag.a(this.rsh, WebViewBag.d(this.rsh).x, WebViewBag.d(this.rsh).y);
    WebViewBag.e(this.rsh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.WebViewBag.1
 * JD-Core Version:    0.7.0.1
 */