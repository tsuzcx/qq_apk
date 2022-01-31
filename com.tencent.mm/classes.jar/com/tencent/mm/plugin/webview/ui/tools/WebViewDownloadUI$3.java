package com.tencent.mm.plugin.webview.ui.tools;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

final class WebViewDownloadUI$3
  implements View.OnClickListener
{
  WebViewDownloadUI$3(WebViewDownloadUI paramWebViewDownloadUI, String paramString1, String paramString2, String paramString3) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(7596);
    ab.i("MicroMsg.WebViewDownloadUI", "doCancelDownloadTask, downloadId = %d, state=%s", new Object[] { Long.valueOf(WebViewDownloadUI.c(this.vcl)), WebViewDownloadUI.a(this.vcl) });
    h.qsU.e(14217, new Object[] { this.val$appId, Integer.valueOf(3), this.uTj, this.val$url, Integer.valueOf(0) });
    if (WebViewDownloadUI.c(this.vcl) <= 0L) {
      ab.e("MicroMsg.WebViewDownloadUI", "doCancelDownloadTask fail, unexpected branch! ");
    }
    int i;
    do
    {
      Toast.makeText(this.vcl.getContext(), this.vcl.getString(2131305849), 1).show();
      AppMethodBeat.o(7596);
      return;
      i = f.bjl().iz(WebViewDownloadUI.c(this.vcl));
      ab.i("MicroMsg.WebViewDownloadUI", "doCancelDownloadTask, ret = %d", new Object[] { Integer.valueOf(i) });
    } while (i <= 0);
    Toast.makeText(this.vcl.getContext(), this.vcl.getString(2131305850), 1).show();
    this.vcl.finish();
    AppMethodBeat.o(7596);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewDownloadUI.3
 * JD-Core Version:    0.7.0.1
 */