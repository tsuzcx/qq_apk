package com.tencent.mm.plugin.scanner.box;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.widget.MMWebView.e;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "l", "", "t", "oldl", "oldt", "onWebViewScrollChanged"})
final class BoxDialogView$i
  implements MMWebView.e
{
  BoxDialogView$i(BoxDialogView paramBoxDialogView) {}
  
  public final void onWebViewScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = true;
    AppMethodBeat.i(52091);
    ae.v("MicroMsg.BoxDialogView", "alvinluo onWebViewScrollChanged l: %d, t: %d, oldl: %d, oldt: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    BoxDialogView localBoxDialogView = this.yAL;
    if (paramInt2 == 0) {}
    for (;;)
    {
      BoxDialogView.a(localBoxDialogView, bool);
      AppMethodBeat.o(52091);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.BoxDialogView.i
 * JD-Core Version:    0.7.0.1
 */