package com.tencent.mm.plugin.webview.ui.tools.bag;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class n$2
  implements e
{
  n$2(n paramn) {}
  
  public final void dfe()
  {
    AppMethodBeat.i(8251);
    ab.i("MicroMsg.WebViewUIBagHelper", "bag transformation onAnimationCancel do default");
    n.c(this.viU);
    n.a(this.viU).mU(true);
    al.p(new n.2.1(this), 500L);
    AppMethodBeat.o(8251);
  }
  
  public final void onAnimationEnd()
  {
    AppMethodBeat.i(8250);
    ab.i("MicroMsg.WebViewUIBagHelper", "bag transformation onAnimationEnd");
    n.c(this.viU);
    n.a(this.viU).mU(false);
    n.b(this.viU, 1);
    AppMethodBeat.o(8250);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.n.2
 * JD-Core Version:    0.7.0.1
 */