package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;

final class WeappWebSearchFragment$4
  implements Runnable
{
  WeappWebSearchFragment$4(WeappWebSearchFragment paramWeappWebSearchFragment, Bundle paramBundle, String paramString1, boolean paramBoolean, String paramString2) {}
  
  public final void run()
  {
    AppMethodBeat.i(8612);
    if (this.vmc.getJsapi() != null)
    {
      if ((this.vjH != null) && (this.vjH.getInt("isRefresh") == 1) && (this.vjH.getString("widgetId") != null))
      {
        this.vmc.getJsapi().hz(this.vjH.getString("widgetId"), this.iOH);
        AppMethodBeat.o(8612);
        return;
      }
      this.vmc.getJsapi().h(this.iOH, this.vjI, this.uPq);
    }
    AppMethodBeat.o(8612);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.WeappWebSearchFragment.4
 * JD-Core Version:    0.7.0.1
 */