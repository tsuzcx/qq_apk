package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.remittance.model.v;
import com.tencent.mm.plugin.remittance.model.v.a;
import com.tencent.mm.sdk.platformtools.bo;

final class RemittanceNewBaseUI$15
  implements DialogInterface.OnClickListener
{
  RemittanceNewBaseUI$15(RemittanceNewBaseUI paramRemittanceNewBaseUI, v paramv) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(142239);
    if (bo.isNullOrNil(this.qml.qjA.qkc))
    {
      com.tencent.mm.wallet_core.a.b(this.qqR, "ShowOrdersInfoProcess", null);
      AppMethodBeat.o(142239);
      return;
    }
    com.tencent.mm.plugin.account.a.b.a.b(this.qqR, this.qml.qjA.qkc, 5, true);
    AppMethodBeat.o(142239);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.15
 * JD-Core Version:    0.7.0.1
 */