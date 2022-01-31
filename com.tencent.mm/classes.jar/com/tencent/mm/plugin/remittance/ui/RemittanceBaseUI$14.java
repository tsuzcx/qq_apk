package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.a;

final class RemittanceBaseUI$14
  implements DialogInterface.OnClickListener
{
  RemittanceBaseUI$14(RemittanceBaseUI paramRemittanceBaseUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(44838);
    a.b(this.qmk, "ShowOrdersInfoProcess", null);
    AppMethodBeat.o(44838);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.14
 * JD-Core Version:    0.7.0.1
 */