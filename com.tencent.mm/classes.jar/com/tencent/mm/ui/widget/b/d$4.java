package com.tencent.mm.ui.widget.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$4
  implements DialogInterface.OnDismissListener
{
  d$4(d paramd) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(112650);
    if (!d.p(this.AHn)) {
      this.AHn.AGQ.onDismiss();
    }
    AppMethodBeat.o(112650);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.b.d.4
 * JD-Core Version:    0.7.0.1
 */