package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class h$3
  implements DialogInterface.OnCancelListener
{
  h$3(h paramh) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(6290);
    h.a(this.uTu, "cancel");
    AppMethodBeat.o(6290);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.h.3
 * JD-Core Version:    0.7.0.1
 */