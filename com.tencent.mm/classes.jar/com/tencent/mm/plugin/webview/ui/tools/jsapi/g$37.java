package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

final class g$37
  implements DialogInterface.OnDismissListener
{
  g$37(g paramg, i parami, Map paramMap) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(154960);
    this.vqm.a(this.uZa, this.uZa.vrQ + ":dismiss", this.vqI);
    AppMethodBeat.o(154960);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.37
 * JD-Core Version:    0.7.0.1
 */