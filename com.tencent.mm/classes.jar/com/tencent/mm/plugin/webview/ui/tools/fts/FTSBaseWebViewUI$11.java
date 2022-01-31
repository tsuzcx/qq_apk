package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.os.Bundle;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;

final class FTSBaseWebViewUI$11
  implements Runnable
{
  FTSBaseWebViewUI$11(FTSBaseWebViewUI paramFTSBaseWebViewUI, Bundle paramBundle, String paramString1, boolean paramBoolean, String paramString2) {}
  
  public final void run()
  {
    if (FTSBaseWebViewUI.m(this.rtV) != null)
    {
      if ((this.rtB != null) && (this.rtB.getInt("isRefresh") == 1) && (this.rtB.getString("widgetId") != null)) {
        FTSBaseWebViewUI.n(this.rtV).fC(this.rtB.getString("widgetId"), this.hdV);
      }
    }
    else {
      return;
    }
    FTSBaseWebViewUI.o(this.rtV).f(this.hdV, this.rtC, this.qZI);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI.11
 * JD-Core Version:    0.7.0.1
 */