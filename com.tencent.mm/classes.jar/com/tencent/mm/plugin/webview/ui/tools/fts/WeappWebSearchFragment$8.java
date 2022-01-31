package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;

final class WeappWebSearchFragment$8
  implements Runnable
{
  WeappWebSearchFragment$8(WeappWebSearchFragment paramWeappWebSearchFragment, String paramString, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(8616);
    if (this.vmc.getJsapi() != null) {
      this.vmc.getJsapi().ec(this.vjK, this.fUa);
    }
    AppMethodBeat.o(8616);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.WeappWebSearchFragment.8
 * JD-Core Version:    0.7.0.1
 */