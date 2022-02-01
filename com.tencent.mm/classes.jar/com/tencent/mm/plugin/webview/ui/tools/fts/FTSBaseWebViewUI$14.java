package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.f;

final class FTSBaseWebViewUI$14
  implements Runnable
{
  FTSBaseWebViewUI$14(FTSBaseWebViewUI paramFTSBaseWebViewUI, Bundle paramBundle, String paramString1, boolean paramBoolean, String paramString2) {}
  
  public final void run()
  {
    AppMethodBeat.i(80592);
    if (this.EgM.DzP != null)
    {
      if ((this.BsT != null) && (this.BsT.getInt("isRefresh") == 1) && (this.BsT.getString("widgetId") != null))
      {
        this.EgM.DzP.kP(this.BsT.getString("widgetId"), this.mEz);
        AppMethodBeat.o(80592);
        return;
      }
      this.EgM.DzP.j(this.mEz, this.Egl, this.DKG);
    }
    AppMethodBeat.o(80592);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI.14
 * JD-Core Version:    0.7.0.1
 */