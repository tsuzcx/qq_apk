package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fr;
import com.tencent.mm.sdk.b.a;

final class g$100$1
  implements DialogInterface.OnCancelListener
{
  g$100$1(g.100 param100) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(155017);
    paramDialogInterface = new fr();
    paramDialogInterface.ctT.ctW = 3;
    a.ymk.l(paramDialogInterface);
    this.vrs.vqm.a(this.vrs.uZa, "translateVoice:fail", null);
    AppMethodBeat.o(155017);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.100.1
 * JD-Core Version:    0.7.0.1
 */