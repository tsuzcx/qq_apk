package com.tencent.mm.plugin.nearby.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;

final class a$4$1
  implements DialogInterface.OnCancelListener
{
  a$4$1(a.4 param4) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(55413);
    g.Rc().a(a.c(this.pcP.pcO));
    AppMethodBeat.o(55413);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.a.4.1
 * JD-Core Version:    0.7.0.1
 */