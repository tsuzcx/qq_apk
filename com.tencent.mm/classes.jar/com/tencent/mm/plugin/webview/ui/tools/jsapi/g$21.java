package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.plugin.webview.model.x;

final class g$21
  implements DialogInterface.OnCancelListener
{
  g$21(g paramg, x paramx) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(154936);
    com.tencent.mm.kernel.g.Rc().a(this.vqC);
    AppMethodBeat.o(154936);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.21
 * JD-Core Version:    0.7.0.1
 */