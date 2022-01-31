package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.remittance.model.aa;

final class RemittanceOSUI$3
  implements DialogInterface.OnClickListener
{
  RemittanceOSUI$3(RemittanceOSUI paramRemittanceOSUI, aa paramaa) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(45094);
    this.qrd.Yo(this.qre.qkO);
    AppMethodBeat.o(45094);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceOSUI.3
 * JD-Core Version:    0.7.0.1
 */