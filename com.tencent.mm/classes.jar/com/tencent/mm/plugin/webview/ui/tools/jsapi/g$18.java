package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.plugin.webview.model.x;

final class g$18
  implements DialogInterface.OnCancelListener
{
  g$18(g paramg, x paramx) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(9062);
    com.tencent.mm.kernel.g.Rc().a(this.vqC);
    AppMethodBeat.o(9062);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.18
 * JD-Core Version:    0.7.0.1
 */