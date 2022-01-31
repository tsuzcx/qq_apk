package com.tencent.mm.plugin.webview.ui.tools;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.R.e;
import com.tencent.mm.R.l;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.y;

final class WebViewDownloadWithX5UI$2
  implements View.OnClickListener
{
  WebViewDownloadWithX5UI$2(WebViewDownloadWithX5UI paramWebViewDownloadWithX5UI, long paramLong, String paramString1, String paramString2) {}
  
  public final void onClick(View paramView)
  {
    if (!aq.isNetworkConnected(WebViewDownloadWithX5UI.a(this.rmN)))
    {
      Toast.makeText(WebViewDownloadWithX5UI.a(this.rmN), this.rmN.getString(R.l.game_download_network_unavailable), 0).show();
      y.i("MicroMsg.WebViewDownloadWithX5UI", "startDownload fail, network not ready");
      return;
    }
    au.Hx();
    if (!c.isSDCardAvailable())
    {
      Toast.makeText(WebViewDownloadWithX5UI.a(this.rmN), this.rmN.getString(R.l.game_download_sdcard_unavailable), 0).show();
      y.i("MicroMsg.WebViewDownloadWithX5UI", "startDownload fail, sdcard not ready");
      return;
    }
    if ((this.rmO > 0L) && (!f.bs(this.rmO)))
    {
      Toast.makeText(WebViewDownloadWithX5UI.a(this.rmN), this.rmN.getString(R.l.game_download_not_enough_space), 0).show();
      y.i("MicroMsg.WebViewDownloadWithX5UI", "startDownload fail, not enough space, require size = " + this.rmO);
      return;
    }
    if (aq.isWifi(WebViewDownloadWithX5UI.a(this.rmN)))
    {
      WebViewDownloadWithX5UI.a(this.rmN, this.val$url, this.rmF);
      return;
    }
    com.tencent.mm.plugin.report.service.h.nFQ.f(14217, new Object[] { "", Integer.valueOf(4), this.rmF, this.val$url, Integer.valueOf(1) });
    com.tencent.mm.ui.base.h.a(this.rmN, this.rmN.getString(R.l.webview_download_ui_download_not_in_wifi_tips), this.rmN.getString(R.l.webview_download_ui_download_not_in_wifi_title), this.rmN.getString(R.l.webview_download_ui_btn_state_to_download), this.rmN.getString(R.l.app_cancel), false, new WebViewDownloadWithX5UI.2.1(this), new WebViewDownloadWithX5UI.2.2(this), R.e.wechat_green);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewDownloadWithX5UI.2
 * JD-Core Version:    0.7.0.1
 */