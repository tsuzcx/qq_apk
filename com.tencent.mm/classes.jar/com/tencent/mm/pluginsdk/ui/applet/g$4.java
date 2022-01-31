package com.tencent.mm.pluginsdk.ui.applet;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class g$4
  implements DialogInterface.OnClickListener
{
  g$4(q.b paramb) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(27642);
    if (this.vTr != null) {
      this.vTr.iM(false);
    }
    AppMethodBeat.o(27642);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.g.4
 * JD-Core Version:    0.7.0.1
 */