package com.tencent.mm.pluginsdk.ui.applet;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$1
  implements DialogInterface.OnCancelListener
{
  a$1(a parama) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(79700);
    a.a(this.vSX, false, this.vSX.vSQ, this.vSX.gAl);
    AppMethodBeat.o(79700);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.a.1
 * JD-Core Version:    0.7.0.1
 */