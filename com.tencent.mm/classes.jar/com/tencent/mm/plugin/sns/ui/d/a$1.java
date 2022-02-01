package com.tencent.mm.plugin.sns.ui.d;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;

final class a$1
  implements DialogInterface.OnCancelListener
{
  a$1(a parama, com.tencent.mm.plugin.sns.model.q paramq) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(100189);
    g.agS();
    g.agQ().ghe.a(this.yyt);
    AppMethodBeat.o(100189);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.a.1
 * JD-Core Version:    0.7.0.1
 */