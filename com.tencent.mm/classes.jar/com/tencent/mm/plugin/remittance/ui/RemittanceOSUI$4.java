package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.remittance.model.aa;

final class RemittanceOSUI$4
  implements DialogInterface.OnClickListener
{
  RemittanceOSUI$4(RemittanceOSUI paramRemittanceOSUI, aa paramaa) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(45095);
    this.qrd.Yn(this.qre.qjt);
    AppMethodBeat.o(45095);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceOSUI.4
 * JD-Core Version:    0.7.0.1
 */