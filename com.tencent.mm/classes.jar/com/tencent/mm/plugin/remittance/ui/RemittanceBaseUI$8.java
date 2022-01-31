package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.remittance.model.v;

final class RemittanceBaseUI$8
  implements DialogInterface.OnClickListener
{
  RemittanceBaseUI$8(RemittanceBaseUI paramRemittanceBaseUI, v paramv) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(142146);
    RemittanceBaseUI.a(this.qmk, 3, this.qml.cyr);
    if (!RemittanceBaseUI.a(this.qmk, this.qml))
    {
      RemittanceBaseUI.h(this.qmk);
      this.qmk.a(this.qml.cwk, this.qmk.eaX, this.qmk.qlK, this.qml);
    }
    AppMethodBeat.o(142146);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.8
 * JD-Core Version:    0.7.0.1
 */