package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.at;

final class WebViewDownloadWithX5UI$2
  implements View.OnClickListener
{
  WebViewDownloadWithX5UI$2(WebViewDownloadWithX5UI paramWebViewDownloadWithX5UI, long paramLong, String paramString1, String paramString2) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(7615);
    if (!at.isNetworkConnected(WebViewDownloadWithX5UI.a(this.vcu)))
    {
      Toast.makeText(WebViewDownloadWithX5UI.a(this.vcu), this.vcu.getString(2131300360), 0).show();
      ab.i("MicroMsg.WebViewDownloadWithX5UI", "startDownload fail, network not ready");
      AppMethodBeat.o(7615);
      return;
    }
    if (!g.RL().isSDCardAvailable())
    {
      Toast.makeText(WebViewDownloadWithX5UI.a(this.vcu), this.vcu.getString(2131300364), 0).show();
      ab.i("MicroMsg.WebViewDownloadWithX5UI", "startDownload fail, sdcard not ready");
      AppMethodBeat.o(7615);
      return;
    }
    if ((this.vcv > 0L) && (!f.gc(this.vcv)))
    {
      Toast.makeText(WebViewDownloadWithX5UI.a(this.vcu), this.vcu.getString(2131300361), 0).show();
      ab.i("MicroMsg.WebViewDownloadWithX5UI", "startDownload fail, not enough space, require size = " + this.vcv);
      AppMethodBeat.o(7615);
      return;
    }
    if (at.isWifi(WebViewDownloadWithX5UI.a(this.vcu)))
    {
      WebViewDownloadWithX5UI.a(this.vcu, this.val$url, this.uTj);
      AppMethodBeat.o(7615);
      return;
    }
    com.tencent.mm.plugin.report.service.h.qsU.e(14217, new Object[] { "", Integer.valueOf(4), this.uTj, this.val$url, Integer.valueOf(1) });
    com.tencent.mm.ui.base.h.a(this.vcu, this.vcu.getString(2131305852), this.vcu.getString(2131305853), this.vcu.getString(2131305847), this.vcu.getString(2131296888), false, new DialogInterface.OnClickListener()new WebViewDownloadWithX5UI.2.2
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(7613);
        com.tencent.mm.plugin.report.service.h.qsU.e(14217, new Object[] { "", Integer.valueOf(5), WebViewDownloadWithX5UI.2.this.uTj, WebViewDownloadWithX5UI.2.this.val$url, Integer.valueOf(1) });
        WebViewDownloadWithX5UI.a(WebViewDownloadWithX5UI.2.this.vcu, WebViewDownloadWithX5UI.2.this.val$url, WebViewDownloadWithX5UI.2.this.uTj);
        paramAnonymousDialogInterface.dismiss();
        AppMethodBeat.o(7613);
      }
    }, new WebViewDownloadWithX5UI.2.2(this), 2131690701);
    AppMethodBeat.o(7615);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewDownloadWithX5UI.2
 * JD-Core Version:    0.7.0.1
 */