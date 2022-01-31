package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.b;

final class ap$2
  implements DialogInterface.OnCancelListener
{
  ap$2(ap paramap, String paramString, bh.a parama) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(6350);
    ao.a.flI.pl(this.efI);
    this.lax.c("cancel", null);
    AppMethodBeat.o(6350);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ap.2
 * JD-Core Version:    0.7.0.1
 */