package com.tencent.mm.plugin.webview.ui.tools.bag;

import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

final class n$2
  implements e
{
  n$2(n paramn) {}
  
  public final void ceX()
  {
    y.i("MicroMsg.WebViewUIBagHelper", "bag transformation onAnimationCancel do default");
    n.c(this.rsO);
    n.a(this.rsO).jW(true);
    ai.l(new n.2.1(this), 500L);
  }
  
  public final void onAnimationEnd()
  {
    y.i("MicroMsg.WebViewUIBagHelper", "bag transformation onAnimationEnd");
    n.c(this.rsO);
    n.a(this.rsO).jW(false);
    n.b(this.rsO, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.n.2
 * JD-Core Version:    0.7.0.1
 */