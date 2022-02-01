package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.d.h;

final class FTSBaseWebViewUI$14
  implements Runnable
{
  FTSBaseWebViewUI$14(FTSBaseWebViewUI paramFTSBaseWebViewUI, Bundle paramBundle, String paramString1, boolean paramBoolean, String paramString2) {}
  
  public final void run()
  {
    AppMethodBeat.i(80592);
    if (this.JnQ.IBw != null)
    {
      if ((this.GkX != null) && (this.GkX.getInt("isRefresh") == 1) && (this.GkX.getString("widgetId") != null))
      {
        this.JnQ.IBw.lU(this.GkX.getString("widgetId"), this.nWD);
        AppMethodBeat.o(80592);
        return;
      }
      this.JnQ.IBw.j(this.nWD, this.Jnn, this.IPc);
    }
    AppMethodBeat.o(80592);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI.14
 * JD-Core Version:    0.7.0.1
 */