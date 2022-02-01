package com.tencent.mm.plugin.scanner.box;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMWebView.e;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "l", "", "t", "oldl", "oldt", "onWebViewScrollChanged"})
final class BaseBoxDialogView$g
  implements MMWebView.e
{
  BaseBoxDialogView$g(BaseBoxDialogView paramBaseBoxDialogView) {}
  
  public final void onWebViewScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = true;
    AppMethodBeat.i(240226);
    Log.v("MicroMsg.BaseBoxDialogView", "alvinluo onWebViewScrollChanged l: %d, t: %d, oldl: %d, oldt: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    BaseBoxDialogView localBaseBoxDialogView = this.CCb;
    if (paramInt2 == 0) {}
    for (;;)
    {
      BaseBoxDialogView.a(localBaseBoxDialogView, bool);
      AppMethodBeat.o(240226);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.BaseBoxDialogView.g
 * JD-Core Version:    0.7.0.1
 */