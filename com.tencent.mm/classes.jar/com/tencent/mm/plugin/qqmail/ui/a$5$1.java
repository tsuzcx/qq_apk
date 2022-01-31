package com.tencent.mm.plugin.qqmail.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.qqmail.b.t;

final class a$5$1
  implements DialogInterface.OnCancelListener
{
  a$5$1(a.5 param5, t paramt) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(68265);
    g.RK().eHt.a(this.pMC);
    AppMethodBeat.o(68265);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.a.5.1
 * JD-Core Version:    0.7.0.1
 */