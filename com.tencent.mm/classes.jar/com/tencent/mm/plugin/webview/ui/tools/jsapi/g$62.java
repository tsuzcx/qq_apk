package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.plugin.report.service.h;

final class g$62
  implements DialogInterface.OnClickListener
{
  g$62(g paramg, a parama, String paramString1, String paramString2, i parami) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(9123);
    h.qsU.e(14217, new Object[] { this.kYh.field_appId, Integer.valueOf(6), this.uTj, this.val$url, Integer.valueOf(3) });
    paramDialogInterface.dismiss();
    this.vqm.a(this.uZa, "doResumeDownloadTask:fail_network_not_wifi", null);
    AppMethodBeat.o(9123);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.62
 * JD-Core Version:    0.7.0.1
 */