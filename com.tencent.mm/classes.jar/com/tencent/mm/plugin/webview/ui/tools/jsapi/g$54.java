package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

final class g$54
  implements DialogInterface.OnClickListener
{
  g$54(g paramg, String paramString1, String paramString2, String paramString3, i parami) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(9114);
    h.qsU.e(14217, new Object[] { this.val$appId, Integer.valueOf(6), this.uTj, this.val$url, Integer.valueOf(3) });
    paramDialogInterface.dismiss();
    this.vqm.a(this.uZa, "add_download_task_straight:fail_network_not_wifi", null);
    AppMethodBeat.o(9114);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.54
 * JD-Core Version:    0.7.0.1
 */