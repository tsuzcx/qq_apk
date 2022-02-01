package com.tencent.mm.plugin.profile.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.ei;
import com.tencent.mm.model.bh;

final class d$6
  implements DialogInterface.OnCancelListener
{
  d$6(d paramd, p paramp) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(305630);
    bh.aZW().b(536, this.MXk);
    paramDialogInterface = new ei();
    paramDialogInterface.hEe.opType = 2;
    paramDialogInterface.hEe.hEi = this.hxO;
    paramDialogInterface.publish();
    AppMethodBeat.o(305630);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.d.6
 * JD-Core Version:    0.7.0.1
 */