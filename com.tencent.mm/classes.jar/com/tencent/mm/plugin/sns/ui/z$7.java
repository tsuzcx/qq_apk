package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;

final class z$7
  implements DialogInterface.OnCancelListener
{
  z$7(z paramz, com.tencent.mm.plugin.sns.model.s params) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(308297);
    if (this.RdY.vhG != 0)
    {
      h.baF();
      h.baD().mCm.a(this.Rcu);
      this.RdY.vhG = 0;
    }
    AppMethodBeat.o(308297);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.z.7
 * JD-Core Version:    0.7.0.1
 */