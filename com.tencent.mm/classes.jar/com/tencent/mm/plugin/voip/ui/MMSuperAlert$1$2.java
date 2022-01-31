package com.tencent.mm.plugin.voip.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MMSuperAlert$1$2
  implements DialogInterface.OnClickListener
{
  MMSuperAlert$1$2(MMSuperAlert.1 param1) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(4781);
    this.tCa.tBZ.finish();
    AppMethodBeat.o(4781);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.MMSuperAlert.1.2
 * JD-Core Version:    0.7.0.1
 */