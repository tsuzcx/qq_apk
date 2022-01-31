package com.tencent.mm.pluginsdk.ui.applet;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$3
  implements DialogInterface.OnClickListener
{
  a$3(a parama) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(79702);
    this.vSX.vSU = false;
    this.vSX.dnv();
    AppMethodBeat.o(79702);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.a.3
 * JD-Core Version:    0.7.0.1
 */