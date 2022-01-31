package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class g$79
  implements DialogInterface.OnCancelListener
{
  g$79(g paramg, i parami) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(155000);
    this.vqm.a(this.uZa, "doChooseMedia:cancel", null);
    AppMethodBeat.o(155000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.79
 * JD-Core Version:    0.7.0.1
 */