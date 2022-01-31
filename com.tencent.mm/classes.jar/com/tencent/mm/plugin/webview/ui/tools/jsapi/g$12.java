package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.c;
import com.tencent.mm.at.o;

final class g$12
  implements DialogInterface.OnCancelListener
{
  g$12(g paramg, String paramString) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(9057);
    o.ahB().sU(this.fEW);
    this.vqm.a(g.k(this.vqm), "send_app_msg:cancel", null);
    AppMethodBeat.o(9057);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.12
 * JD-Core Version:    0.7.0.1
 */