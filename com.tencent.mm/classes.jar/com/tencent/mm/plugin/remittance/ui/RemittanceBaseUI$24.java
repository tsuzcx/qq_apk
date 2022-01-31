package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.remittance.model.v;

final class RemittanceBaseUI$24
  implements DialogInterface.OnClickListener
{
  RemittanceBaseUI$24(RemittanceBaseUI paramRemittanceBaseUI, String paramString, v paramv) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(142155);
    RemittanceBaseUI.l(this.qmk);
    this.qmk.a(this.qms, this.qmk.eaX, this.qmk.qlK, this.qlb);
    AppMethodBeat.o(142155);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.24
 * JD-Core Version:    0.7.0.1
 */