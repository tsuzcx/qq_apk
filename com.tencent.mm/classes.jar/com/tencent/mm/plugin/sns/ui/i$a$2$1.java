package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.r;

final class i$a$2$1
  implements DialogInterface.OnCancelListener
{
  i$a$2$1(i.a.2 param2, r paramr) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(38185);
    g.RM();
    g.RK().eHt.a(this.rFL);
    AppMethodBeat.o(38185);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.i.a.2.1
 * JD-Core Version:    0.7.0.1
 */