package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.report.service.h;

final class WebViewDownloadUI$2$2
  implements DialogInterface.OnClickListener
{
  WebViewDownloadUI$2$2(WebViewDownloadUI.2 param2) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    h.nFQ.f(14217, new Object[] { this.rmH.val$appId, Integer.valueOf(6), this.rmH.rmF, this.rmH.val$url, Integer.valueOf(0) });
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewDownloadUI.2.2
 * JD-Core Version:    0.7.0.1
 */