package com.tencent.mm.pluginsdk.ui.applet;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;

final class u$1$1
  implements DialogInterface.OnCancelListener
{
  u$1$1(u.1 param1) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(27721);
    aw.Rc().a(this.vUC.vUB.qBT);
    this.vUC.vUB.mOt = null;
    AppMethodBeat.o(27721);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.u.1.1
 * JD-Core Version:    0.7.0.1
 */