package com.tencent.mm.pluginsdk.ui.applet;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.b.c;

final class g$12
  implements DialogInterface.OnClickListener
{
  g$12(c paramc, q.a parama) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(27650);
    this.jMO.dismiss();
    if (this.jMP != null) {
      this.jMP.a(true, this.jMO.dOY(), this.jMO.dOZ());
    }
    AppMethodBeat.o(27650);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.g.12
 * JD-Core Version:    0.7.0.1
 */