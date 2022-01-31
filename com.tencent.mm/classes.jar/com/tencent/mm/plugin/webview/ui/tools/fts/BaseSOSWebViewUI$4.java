package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.os.Bundle;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;

final class BaseSOSWebViewUI$4
  implements Runnable
{
  BaseSOSWebViewUI$4(BaseSOSWebViewUI paramBaseSOSWebViewUI, Bundle paramBundle, String paramString1, boolean paramBoolean, String paramString2) {}
  
  public final void run()
  {
    if (BaseSOSWebViewUI.p(this.rtA) != null)
    {
      if ((this.rtB != null) && (this.rtB.getInt("isRefresh") == 1) && (this.rtB.getString("widgetId") != null)) {
        BaseSOSWebViewUI.q(this.rtA).fC(this.rtB.getString("widgetId"), this.hdV);
      }
    }
    else {
      return;
    }
    BaseSOSWebViewUI.r(this.rtA).f(this.hdV, this.rtC, this.qZI);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.4
 * JD-Core Version:    0.7.0.1
 */