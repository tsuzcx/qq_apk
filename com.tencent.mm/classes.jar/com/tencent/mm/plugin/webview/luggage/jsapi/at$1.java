package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

final class at$1
  implements DialogInterface.OnClickListener
{
  at$1(at paramat, JSONObject paramJSONObject, long paramLong, bh.a parama) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(6361);
    at.a(this.uTT, this.kXZ, this.law);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(6361);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.at.1
 * JD-Core Version:    0.7.0.1
 */