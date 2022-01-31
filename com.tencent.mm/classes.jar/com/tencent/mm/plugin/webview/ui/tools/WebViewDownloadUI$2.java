package com.tencent.mm.plugin.webview.ui.tools;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.R.e;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.y;

final class WebViewDownloadUI$2
  implements View.OnClickListener
{
  WebViewDownloadUI$2(WebViewDownloadUI paramWebViewDownloadUI, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8) {}
  
  public final void onClick(View paramView)
  {
    y.i("MicroMsg.WebViewDownloadUI", "downloadOpBtn.onClick state=%s", new Object[] { WebViewDownloadUI.a(this.rmD) });
    switch (WebViewDownloadUI.5.rmI[WebViewDownloadUI.a(this.rmD).ordinal()])
    {
    default: 
      y.e("MicroMsg.WebViewDownloadUI", "downloadOpBtn.onClick unexpected download state");
      return;
    }
    if (!aq.isNetworkConnected(WebViewDownloadUI.b(this.rmD)))
    {
      Toast.makeText(WebViewDownloadUI.b(this.rmD), this.rmD.getString(R.l.game_download_network_unavailable), 0).show();
      y.i("MicroMsg.WebViewDownloadUI", "startDownload fail, network not ready");
      return;
    }
    if (aq.isWifi(WebViewDownloadUI.b(this.rmD)))
    {
      WebViewDownloadUI.a(this.rmD, this.val$url, this.grU, this.ggg, this.val$appId, this.rmE, this.rmF, this.rmG, this.val$packageName);
      return;
    }
    com.tencent.mm.plugin.report.service.h.nFQ.f(14217, new Object[] { this.val$appId, Integer.valueOf(4), this.rmF, this.val$url, Integer.valueOf(0) });
    com.tencent.mm.ui.base.h.a(this.rmD, this.rmD.getString(R.l.webview_download_ui_download_not_in_wifi_tips), this.rmD.getString(R.l.webview_download_ui_download_not_in_wifi_title), this.rmD.getString(R.l.webview_download_ui_btn_state_to_download), this.rmD.getString(R.l.app_cancel), false, new WebViewDownloadUI.2.1(this), new WebViewDownloadUI.2.2(this), R.e.wechat_green);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewDownloadUI.2
 * JD-Core Version:    0.7.0.1
 */