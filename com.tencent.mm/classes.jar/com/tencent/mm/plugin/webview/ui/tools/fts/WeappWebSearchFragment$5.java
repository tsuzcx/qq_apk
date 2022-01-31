package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;

final class WeappWebSearchFragment$5
  implements Runnable
{
  WeappWebSearchFragment$5(WeappWebSearchFragment paramWeappWebSearchFragment, int paramInt, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(8613);
    if (this.vmc.getJsapi() != null) {
      this.vmc.getJsapi().bG(this.qac, this.hwP);
    }
    AppMethodBeat.o(8613);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.WeappWebSearchFragment.5
 * JD-Core Version:    0.7.0.1
 */