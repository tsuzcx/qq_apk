package com.tencent.mm.ui.transmit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$2
  implements DialogInterface.OnClickListener
{
  c$2(c paramc) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(35212);
    paramDialogInterface = this.AAB;
    if (paramDialogInterface.gwf != null)
    {
      paramDialogInterface.gwf.dismiss();
      paramDialogInterface.gwf = null;
    }
    paramDialogInterface.AAA.dOl();
    AppMethodBeat.o(35212);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.c.2
 * JD-Core Version:    0.7.0.1
 */