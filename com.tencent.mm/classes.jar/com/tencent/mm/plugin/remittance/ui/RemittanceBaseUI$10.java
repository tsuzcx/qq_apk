package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.remittance.model.v;

final class RemittanceBaseUI$10
  implements DialogInterface.OnClickListener
{
  RemittanceBaseUI$10(RemittanceBaseUI paramRemittanceBaseUI, v paramv) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(44834);
    if (!RemittanceBaseUI.a(this.qmk, this.qml))
    {
      RemittanceBaseUI.i(this.qmk);
      this.qmk.a(this.qml.cwk, this.qmk.eaX, this.qmk.qlK, this.qml);
    }
    AppMethodBeat.o(44834);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.10
 * JD-Core Version:    0.7.0.1
 */