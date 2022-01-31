package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.plugin.webview.model.ae;

final class g$130
  implements DialogInterface.OnCancelListener
{
  g$130(g paramg, ae paramae) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(155043);
    com.tencent.mm.kernel.g.Rc().a(this.vrF);
    AppMethodBeat.o(155043);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.130
 * JD-Core Version:    0.7.0.1
 */