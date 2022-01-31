package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class g$105$2
  implements DialogInterface.OnClickListener
{
  g$105$2(g.105 param105) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(9178);
    this.vrv.vqm.a(this.vrv.uZa, "nfcCheckState:nfc_off", null);
    AppMethodBeat.o(9178);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.105.2
 * JD-Core Version:    0.7.0.1
 */