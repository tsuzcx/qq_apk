package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.f;

final class BaseSOSWebViewUI$4
  implements Runnable
{
  BaseSOSWebViewUI$4(BaseSOSWebViewUI paramBaseSOSWebViewUI, Bundle paramBundle, String paramString1, boolean paramBoolean, String paramString2) {}
  
  public final void run()
  {
    AppMethodBeat.i(80527);
    if (this.Egk.getJsapi() != null)
    {
      if ((this.BsT != null) && (this.BsT.getInt("isRefresh") == 1) && (this.BsT.getString("widgetId") != null))
      {
        this.Egk.getJsapi().kP(this.BsT.getString("widgetId"), this.mEz);
        AppMethodBeat.o(80527);
        return;
      }
      this.Egk.getJsapi().j(this.mEz, this.Egl, this.DKG);
    }
    AppMethodBeat.o(80527);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.4
 * JD-Core Version:    0.7.0.1
 */