package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import java.util.Map;

final class WeappWebSearchFragment$3
  implements Runnable
{
  WeappWebSearchFragment$3(WeappWebSearchFragment paramWeappWebSearchFragment, Map paramMap) {}
  
  public final void run()
  {
    AppMethodBeat.i(8611);
    if (this.vmc.getJsapi() != null) {
      this.vmc.getJsapi().aP(this.bQD);
    }
    AppMethodBeat.o(8611);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.WeappWebSearchFragment.3
 * JD-Core Version:    0.7.0.1
 */