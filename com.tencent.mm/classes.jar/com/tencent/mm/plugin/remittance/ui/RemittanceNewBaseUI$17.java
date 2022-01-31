package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.a;

final class RemittanceNewBaseUI$17
  implements DialogInterface.OnClickListener
{
  RemittanceNewBaseUI$17(RemittanceNewBaseUI paramRemittanceNewBaseUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(142241);
    a.b(this.qqR, "ShowOrdersInfoProcess", null);
    AppMethodBeat.o(142241);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.17
 * JD-Core Version:    0.7.0.1
 */