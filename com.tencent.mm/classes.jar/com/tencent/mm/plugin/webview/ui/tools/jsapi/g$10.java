package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.c;
import com.tencent.mm.at.o;

final class g$10
  implements DialogInterface.OnCancelListener
{
  g$10(g paramg, String paramString, i parami) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(154929);
    o.ahB().sU(this.fEW);
    this.vqm.a(this.uZa, "send_service_app_msg:fail", null);
    AppMethodBeat.o(154929);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.10
 * JD-Core Version:    0.7.0.1
 */