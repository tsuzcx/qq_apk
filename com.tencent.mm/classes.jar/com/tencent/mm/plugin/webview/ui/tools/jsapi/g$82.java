package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.model.al;
import com.tencent.mm.plugin.webview.model.d.b;

final class g$82
  implements DialogInterface.OnCancelListener
{
  g$82(g paramg, d.b paramb, String paramString1, i parami, String paramString2) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(155002);
    com.tencent.mm.plugin.webview.modeltools.g.dcD().a(this.uTy);
    com.tencent.mm.plugin.webview.modeltools.g.dcD();
    al.zE(this.uUf);
    this.vqm.a(this.uZa, this.isO + ":fail", null);
    AppMethodBeat.o(155002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.82
 * JD-Core Version:    0.7.0.1
 */