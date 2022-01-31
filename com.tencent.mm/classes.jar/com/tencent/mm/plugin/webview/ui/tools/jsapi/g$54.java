package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.report.service.h;

final class g$54
  implements DialogInterface.OnClickListener
{
  g$54(g paramg, String paramString1, String paramString2, String paramString3, i parami) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    h.nFQ.f(14217, new Object[] { this.val$appId, Integer.valueOf(6), this.rmF, this.val$url, Integer.valueOf(3) });
    paramDialogInterface.dismiss();
    g.a(this.rzi, this.rzk, "doResumeDownloadTask:fail_network_not_wifi", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.54
 * JD-Core Version:    0.7.0.1
 */