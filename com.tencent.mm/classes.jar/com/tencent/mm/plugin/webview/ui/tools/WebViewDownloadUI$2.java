package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.at;

final class WebViewDownloadUI$2
  implements View.OnClickListener
{
  WebViewDownloadUI$2(WebViewDownloadUI paramWebViewDownloadUI, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(7595);
    ab.i("MicroMsg.WebViewDownloadUI", "downloadOpBtn.onClick state=%s", new Object[] { WebViewDownloadUI.a(this.vcl) });
    switch (WebViewDownloadUI.5.vcp[WebViewDownloadUI.a(this.vcl).ordinal()])
    {
    default: 
      ab.e("MicroMsg.WebViewDownloadUI", "downloadOpBtn.onClick unexpected download state");
      AppMethodBeat.o(7595);
      return;
    }
    if (!at.isNetworkConnected(WebViewDownloadUI.b(this.vcl)))
    {
      Toast.makeText(WebViewDownloadUI.b(this.vcl), this.vcl.getString(2131300360), 0).show();
      ab.i("MicroMsg.WebViewDownloadUI", "startDownload fail, network not ready");
      AppMethodBeat.o(7595);
      return;
    }
    if (at.isWifi(WebViewDownloadUI.b(this.vcl)))
    {
      WebViewDownloadUI.a(this.vcl, this.val$url, this.iiy, this.hyf, this.val$appId, this.vcm, this.uTj, this.hyt, this.val$packageName, this.vcn);
      AppMethodBeat.o(7595);
      return;
    }
    com.tencent.mm.plugin.report.service.h.qsU.e(14217, new Object[] { this.val$appId, Integer.valueOf(4), this.uTj, this.val$url, Integer.valueOf(0) });
    com.tencent.mm.ui.base.h.a(this.vcl, this.vcl.getString(2131305852), this.vcl.getString(2131305853), this.vcl.getString(2131305847), this.vcl.getString(2131296888), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(7593);
        com.tencent.mm.plugin.report.service.h.qsU.e(14217, new Object[] { WebViewDownloadUI.2.this.val$appId, Integer.valueOf(5), WebViewDownloadUI.2.this.uTj, WebViewDownloadUI.2.this.val$url, Integer.valueOf(0) });
        WebViewDownloadUI.a(WebViewDownloadUI.2.this.vcl, WebViewDownloadUI.2.this.val$url, WebViewDownloadUI.2.this.iiy, WebViewDownloadUI.2.this.hyf, WebViewDownloadUI.2.this.val$appId, WebViewDownloadUI.2.this.vcm, WebViewDownloadUI.2.this.uTj, WebViewDownloadUI.2.this.hyt, WebViewDownloadUI.2.this.val$packageName, WebViewDownloadUI.2.this.vcn);
        paramAnonymousDialogInterface.dismiss();
        AppMethodBeat.o(7593);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(7594);
        com.tencent.mm.plugin.report.service.h.qsU.e(14217, new Object[] { WebViewDownloadUI.2.this.val$appId, Integer.valueOf(6), WebViewDownloadUI.2.this.uTj, WebViewDownloadUI.2.this.val$url, Integer.valueOf(0) });
        paramAnonymousDialogInterface.dismiss();
        AppMethodBeat.o(7594);
      }
    }, 2131690701);
    AppMethodBeat.o(7595);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewDownloadUI.2
 * JD-Core Version:    0.7.0.1
 */