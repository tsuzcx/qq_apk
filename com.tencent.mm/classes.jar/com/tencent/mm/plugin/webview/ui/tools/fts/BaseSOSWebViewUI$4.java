package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;

final class BaseSOSWebViewUI$4
  implements Runnable
{
  BaseSOSWebViewUI$4(BaseSOSWebViewUI paramBaseSOSWebViewUI, Bundle paramBundle, String paramString1, boolean paramBoolean, String paramString2) {}
  
  public final void run()
  {
    AppMethodBeat.i(8334);
    if (this.vjG.getJsapi() != null)
    {
      if ((this.vjH != null) && (this.vjH.getInt("isRefresh") == 1) && (this.vjH.getString("widgetId") != null))
      {
        this.vjG.getJsapi().hz(this.vjH.getString("widgetId"), this.iOH);
        AppMethodBeat.o(8334);
        return;
      }
      this.vjG.getJsapi().h(this.iOH, this.vjI, this.uPq);
    }
    AppMethodBeat.o(8334);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.4
 * JD-Core Version:    0.7.0.1
 */