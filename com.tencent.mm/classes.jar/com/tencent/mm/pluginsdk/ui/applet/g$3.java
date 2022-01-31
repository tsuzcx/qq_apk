package com.tencent.mm.pluginsdk.ui.applet;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class g$3
  implements DialogInterface.OnClickListener
{
  g$3(q.b paramb) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(27641);
    if (this.vTr != null) {
      this.vTr.iM(true);
    }
    AppMethodBeat.o(27641);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.g.3
 * JD-Core Version:    0.7.0.1
 */