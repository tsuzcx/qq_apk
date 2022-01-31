package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;

final class WeappWebSearchFragment$6
  implements Runnable
{
  WeappWebSearchFragment$6(WeappWebSearchFragment paramWeappWebSearchFragment, int paramInt1, String paramString, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(8614);
    if (this.vmc.getJsapi() != null) {
      this.vmc.getJsapi().p(this.vjJ, this.iOH, this.iOI);
    }
    AppMethodBeat.o(8614);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.WeappWebSearchFragment.6
 * JD-Core Version:    0.7.0.1
 */