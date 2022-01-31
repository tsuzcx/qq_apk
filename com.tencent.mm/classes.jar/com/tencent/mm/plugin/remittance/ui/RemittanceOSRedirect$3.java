package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RemittanceOSRedirect$3
  implements DialogInterface.OnClickListener
{
  RemittanceOSRedirect$3(RemittanceOSRedirect paramRemittanceOSRedirect) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(45087);
    this.qqW.finish();
    AppMethodBeat.o(45087);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceOSRedirect.3
 * JD-Core Version:    0.7.0.1
 */