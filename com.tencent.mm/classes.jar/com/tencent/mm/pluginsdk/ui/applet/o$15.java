package com.tencent.mm.pluginsdk.ui.applet;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class o$15
  implements DialogInterface.OnClickListener
{
  o$15(y.a parama) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(31358);
    if (this.Kfe != null) {
      this.Kfe.a(false, null, 0);
    }
    AppMethodBeat.o(31358);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.o.15
 * JD-Core Version:    0.7.0.1
 */