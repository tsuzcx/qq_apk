package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.x;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;

final class WeappWebSearchFragment$9
  implements x
{
  WeappWebSearchFragment$9(WeappWebSearchFragment paramWeappWebSearchFragment) {}
  
  public final void gE(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(8617);
    if (this.vmc.getJsapi() != null) {
      this.vmc.getJsapi().gQ(paramInt1, paramInt2);
    }
    AppMethodBeat.o(8617);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.WeappWebSearchFragment.9
 * JD-Core Version:    0.7.0.1
 */