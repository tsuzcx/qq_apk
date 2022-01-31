package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RemittanceResultOldUI$2
  implements DialogInterface.OnClickListener
{
  RemittanceResultOldUI$2(RemittanceResultOldUI paramRemittanceResultOldUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(45146);
    RemittanceResultOldUI.b(this.qrw);
    AppMethodBeat.o(45146);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceResultOldUI.2
 * JD-Core Version:    0.7.0.1
 */