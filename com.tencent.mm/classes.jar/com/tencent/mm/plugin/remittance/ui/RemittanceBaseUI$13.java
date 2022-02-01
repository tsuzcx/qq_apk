package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.a;

final class RemittanceBaseUI$13
  implements DialogInterface.OnClickListener
{
  RemittanceBaseUI$13(RemittanceBaseUI paramRemittanceBaseUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(67962);
    a.b(this.Ipl, "ShowOrdersInfoProcess", null);
    AppMethodBeat.o(67962);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.13
 * JD-Core Version:    0.7.0.1
 */