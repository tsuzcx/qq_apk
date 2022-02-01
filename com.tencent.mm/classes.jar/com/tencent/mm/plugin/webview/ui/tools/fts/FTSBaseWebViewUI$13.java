package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.f;

final class FTSBaseWebViewUI$13
  implements Runnable
{
  FTSBaseWebViewUI$13(FTSBaseWebViewUI paramFTSBaseWebViewUI, Bundle paramBundle, String paramString1, boolean paramBoolean, String paramString2) {}
  
  public final void run()
  {
    AppMethodBeat.i(80592);
    if (this.CDb.Cjc != null)
    {
      if ((this.Abi != null) && (this.Abi.getInt("isRefresh") == 1) && (this.Abi.getString("widgetId") != null))
      {
        this.CDb.Cjc.kr(this.Abi.getString("widgetId"), this.meg);
        AppMethodBeat.o(80592);
        return;
      }
      this.CDb.Cjc.j(this.meg, this.CCC, this.Chz);
    }
    AppMethodBeat.o(80592);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI.13
 * JD-Core Version:    0.7.0.1
 */