package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.remittance.model.v;

final class RemittanceBaseUI$9
  implements DialogInterface.OnClickListener
{
  RemittanceBaseUI$9(RemittanceBaseUI paramRemittanceBaseUI, v paramv) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(44833);
    RemittanceBaseUI.a(this.qmk, 2, this.qml.cyr);
    AppMethodBeat.o(44833);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.9
 * JD-Core Version:    0.7.0.1
 */