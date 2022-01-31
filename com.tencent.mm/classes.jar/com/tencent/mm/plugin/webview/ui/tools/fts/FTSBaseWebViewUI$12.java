package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;

final class FTSBaseWebViewUI$12
  implements Runnable
{
  FTSBaseWebViewUI$12(FTSBaseWebViewUI paramFTSBaseWebViewUI, Bundle paramBundle, String paramString1, boolean paramBoolean, String paramString2) {}
  
  public final void run()
  {
    AppMethodBeat.i(8394);
    if (this.vkg.uQS != null)
    {
      if ((this.vjH != null) && (this.vjH.getInt("isRefresh") == 1) && (this.vjH.getString("widgetId") != null))
      {
        this.vkg.uQS.hz(this.vjH.getString("widgetId"), this.iOH);
        AppMethodBeat.o(8394);
        return;
      }
      this.vkg.uQS.h(this.iOH, this.vjI, this.uPq);
    }
    AppMethodBeat.o(8394);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI.12
 * JD-Core Version:    0.7.0.1
 */