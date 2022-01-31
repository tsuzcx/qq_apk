package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class g$105$1
  implements DialogInterface.OnClickListener
{
  g$105$1(g.105 param105) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(9177);
    g.j(this.vrv.vqm).startActivity(new Intent("android.settings.NFC_SETTINGS"));
    this.vrv.vqm.a(this.vrv.uZa, "nfcCheckState:nfc_off", null);
    AppMethodBeat.o(9177);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.105.1
 * JD-Core Version:    0.7.0.1
 */