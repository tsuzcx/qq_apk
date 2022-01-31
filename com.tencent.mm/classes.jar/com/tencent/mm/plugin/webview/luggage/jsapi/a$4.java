package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import org.json.JSONObject;

final class a$4
  implements DialogInterface.OnClickListener
{
  a$4(a parama, String paramString1, String paramString2, String paramString3, Context paramContext, JSONObject paramJSONObject, bh.a parama1) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(6267);
    h.qsU.e(14217, new Object[] { this.val$appId, Integer.valueOf(5), this.uTj, this.val$url, Integer.valueOf(3) });
    a.a(this.uTi, this.bBa, this.law);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(6267);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.a.4
 * JD-Core Version:    0.7.0.1
 */