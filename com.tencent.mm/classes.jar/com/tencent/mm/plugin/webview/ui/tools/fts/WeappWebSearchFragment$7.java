package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;

final class WeappWebSearchFragment$7
  implements Runnable
{
  WeappWebSearchFragment$7(WeappWebSearchFragment paramWeappWebSearchFragment, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(8615);
    if (this.vmc.getJsapi() != null) {
      this.vmc.getJsapi().aiZ(this.iOH);
    }
    AppMethodBeat.o(8615);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.WeappWebSearchFragment.7
 * JD-Core Version:    0.7.0.1
 */