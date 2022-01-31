package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.plugin.webview.model.n;

final class g$112
  implements DialogInterface.OnCancelListener
{
  g$112(g paramg, n paramn, f paramf) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(155031);
    com.tencent.mm.kernel.g.Rc().a(this.vry);
    com.tencent.mm.kernel.g.Rc().b(1393, this.vrz);
    AppMethodBeat.o(155031);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.112
 * JD-Core Version:    0.7.0.1
 */