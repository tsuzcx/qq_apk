package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RemittanceOSRedirect$2
  implements DialogInterface.OnClickListener
{
  RemittanceOSRedirect$2(RemittanceOSRedirect paramRemittanceOSRedirect) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(45086);
    this.qqW.finish();
    AppMethodBeat.o(45086);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceOSRedirect.2
 * JD-Core Version:    0.7.0.1
 */