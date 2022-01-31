package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

final class a$5
  implements DialogInterface.OnClickListener
{
  a$5(a parama, String paramString1, String paramString2, String paramString3, bh.a parama1) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(6268);
    h.qsU.e(14217, new Object[] { this.val$appId, Integer.valueOf(6), this.uTj, this.val$url, Integer.valueOf(3) });
    paramDialogInterface.dismiss();
    this.law.c("network_not_wifi", null);
    AppMethodBeat.o(6268);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.a.5
 * JD-Core Version:    0.7.0.1
 */