package com.tencent.mm.plugin.webview.ui.tools;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class WebViewDownloadUI$3
  implements View.OnClickListener
{
  WebViewDownloadUI$3(WebViewDownloadUI paramWebViewDownloadUI, String paramString1, String paramString2, String paramString3) {}
  
  public final void onClick(View paramView)
  {
    y.i("MicroMsg.WebViewDownloadUI", "doCancelDownloadTask, downloadId = %d, state=%s", new Object[] { Long.valueOf(WebViewDownloadUI.c(this.rmD)), WebViewDownloadUI.a(this.rmD) });
    h.nFQ.f(14217, new Object[] { this.val$appId, Integer.valueOf(3), this.rmF, this.val$url, Integer.valueOf(0) });
    if (WebViewDownloadUI.c(this.rmD) <= 0L) {
      y.e("MicroMsg.WebViewDownloadUI", "doCancelDownloadTask fail, unexpected branch! ");
    }
    int i;
    do
    {
      Toast.makeText(this.rmD.mController.uMN, this.rmD.getString(R.l.webview_download_ui_cancel_failed), 1).show();
      return;
      i = d.aFP().dc(WebViewDownloadUI.c(this.rmD));
      y.i("MicroMsg.WebViewDownloadUI", "doCancelDownloadTask, ret = %d", new Object[] { Integer.valueOf(i) });
    } while (i <= 0);
    Toast.makeText(this.rmD.mController.uMN, this.rmD.getString(R.l.webview_download_ui_canceled), 1).show();
    this.rmD.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewDownloadUI.3
 * JD-Core Version:    0.7.0.1
 */