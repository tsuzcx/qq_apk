package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.remittance.model.v;
import com.tencent.mm.plugin.remittance.model.v.a;
import com.tencent.mm.sdk.platformtools.bo;

final class RemittanceBaseUI$11
  implements DialogInterface.OnClickListener
{
  RemittanceBaseUI$11(RemittanceBaseUI paramRemittanceBaseUI, v paramv) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(44835);
    if (bo.isNullOrNil(this.qml.qjA.qkc))
    {
      com.tencent.mm.wallet_core.a.b(this.qmk, "ShowOrdersInfoProcess", null);
      AppMethodBeat.o(44835);
      return;
    }
    com.tencent.mm.plugin.account.a.b.a.b(this.qmk, this.qml.qjA.qkc, 5, true);
    AppMethodBeat.o(44835);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.11
 * JD-Core Version:    0.7.0.1
 */