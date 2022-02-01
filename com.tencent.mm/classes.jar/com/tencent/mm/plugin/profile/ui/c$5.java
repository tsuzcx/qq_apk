package com.tencent.mm.plugin.profile.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.dr;
import com.tencent.mm.model.bg;
import com.tencent.mm.sdk.event.EventCenter;

final class c$5
  implements DialogInterface.OnCancelListener
{
  c$5(c paramc, q paramq) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(27076);
    bg.azz().b(536, this.Bfj);
    paramDialogInterface = new dr();
    paramDialogInterface.dGF.opType = 2;
    paramDialogInterface.dGF.dGJ = this.dAK;
    EventCenter.instance.publish(paramDialogInterface);
    AppMethodBeat.o(27076);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.c.5
 * JD-Core Version:    0.7.0.1
 */