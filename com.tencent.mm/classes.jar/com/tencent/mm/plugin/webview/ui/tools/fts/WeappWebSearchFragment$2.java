package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;

final class WeappWebSearchFragment$2
  implements Runnable
{
  WeappWebSearchFragment$2(WeappWebSearchFragment paramWeappWebSearchFragment, String paramString, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void run()
  {
    AppMethodBeat.i(8610);
    if (this.vmc.getJsapi() != null) {
      this.vmc.getJsapi().n(this.iOH, this.iOI, this.iOJ, this.iOK);
    }
    AppMethodBeat.o(8610);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.WeappWebSearchFragment.2
 * JD-Core Version:    0.7.0.1
 */