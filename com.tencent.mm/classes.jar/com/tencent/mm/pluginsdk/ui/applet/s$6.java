package com.tencent.mm.pluginsdk.ui.applet;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class s$6
  implements DialogInterface.OnClickListener
{
  s$6(s params) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(151627);
    this.vUx.vSU = false;
    this.vUx.dnv();
    AppMethodBeat.o(151627);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.s.6
 * JD-Core Version:    0.7.0.1
 */