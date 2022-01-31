package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.remittance.model.v;

final class RemittanceNewBaseUI$14
  implements DialogInterface.OnClickListener
{
  RemittanceNewBaseUI$14(RemittanceNewBaseUI paramRemittanceNewBaseUI, v paramv) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(142238);
    if (!RemittanceNewBaseUI.a(this.qqR, this.qml))
    {
      if (RemittanceNewBaseUI.o(this.qqR)) {
        RemittanceNewBaseUI.p(this.qqR);
      }
      this.qqR.a(this.qml.cwk, this.qqR.eaX, this.qqR.qlK, this.qml);
    }
    AppMethodBeat.o(142238);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.14
 * JD-Core Version:    0.7.0.1
 */