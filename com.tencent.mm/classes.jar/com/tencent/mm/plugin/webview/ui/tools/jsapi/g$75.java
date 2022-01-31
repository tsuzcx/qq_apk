package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.model.al;
import com.tencent.mm.plugin.webview.model.d.b;

final class g$75
  implements DialogInterface.OnCancelListener
{
  g$75(g paramg, d.b paramb, String paramString, i parami) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(154995);
    com.tencent.mm.plugin.webview.modeltools.g.dcD().a(this.uTy);
    com.tencent.mm.plugin.webview.modeltools.g.dcD();
    al.ahd(this.uTw);
    this.vqm.a(this.uZa, "downloadImage:fail", null);
    AppMethodBeat.o(154995);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.75
 * JD-Core Version:    0.7.0.1
 */