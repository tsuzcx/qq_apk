package com.tencent.mm.pluginsdk.ui.applet;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.a.d;

final class o$10
  implements DialogInterface.OnClickListener
{
  o$10(d paramd, y.a parama) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(31353);
    this.nPd.dismiss();
    if (this.nPe != null) {
      this.nPe.a(true, this.nPd.fLY(), this.nPd.fLZ());
    }
    AppMethodBeat.o(31353);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.o.10
 * JD-Core Version:    0.7.0.1
 */