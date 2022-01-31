package com.tencent.mm.plugin.scanner.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;

final class r$1$1
  implements DialogInterface.OnCancelListener
{
  r$1$1(r.1 param1) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(81362);
    g.Rc().a(this.qBV.qBU.qBT);
    this.qBV.qBU.mOt = null;
    AppMethodBeat.o(81362);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.r.1.1
 * JD-Core Version:    0.7.0.1
 */