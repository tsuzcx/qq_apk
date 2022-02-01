package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;

final class n$4
  implements DialogInterface.OnCancelListener
{
  n$4(n paramn, com.tencent.mm.plugin.sns.model.q paramq) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(97849);
    g.ajD();
    g.ajB().gAO.a(this.zQa);
    AppMethodBeat.o(97849);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.n.4
 * JD-Core Version:    0.7.0.1
 */