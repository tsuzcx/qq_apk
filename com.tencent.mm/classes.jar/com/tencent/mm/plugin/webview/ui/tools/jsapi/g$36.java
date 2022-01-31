package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

final class g$36
  implements DialogInterface.OnCancelListener
{
  g$36(g paramg, i parami, Map paramMap) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(154959);
    this.vqm.a(this.uZa, this.uZa.vrQ + ":cancelled", this.vqI);
    AppMethodBeat.o(154959);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.36
 * JD-Core Version:    0.7.0.1
 */