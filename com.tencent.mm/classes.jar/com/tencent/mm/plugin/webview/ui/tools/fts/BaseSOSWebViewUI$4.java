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
    if (this.CCB.getJsapi() != null)
    {
      if ((this.Abi != null) && (this.Abi.getInt("isRefresh") == 1) && (this.Abi.getString("widgetId") != null))
      {
        this.CCB.getJsapi().kr(this.Abi.getString("widgetId"), this.meg);
        AppMethodBeat.o(80527);
        return;
      }
      this.CCB.getJsapi().j(this.meg, this.CCC, this.Chz);
    }
    AppMethodBeat.o(80527);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.4
 * JD-Core Version:    0.7.0.1
 */