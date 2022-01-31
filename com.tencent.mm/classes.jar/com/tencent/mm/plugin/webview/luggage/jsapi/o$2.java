package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.model.al;
import com.tencent.mm.plugin.webview.model.d.b;
import com.tencent.mm.plugin.webview.modeltools.g;

final class o$2
  implements DialogInterface.OnCancelListener
{
  o$2(o paramo, d.b paramb, String paramString, bh.a parama) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(153120);
    g.dcD().a(this.uTy);
    g.dcD();
    al.ahd(this.uTw);
    this.lax.c("downloadImage:fail", null);
    AppMethodBeat.o(153120);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.o.2
 * JD-Core Version:    0.7.0.1
 */