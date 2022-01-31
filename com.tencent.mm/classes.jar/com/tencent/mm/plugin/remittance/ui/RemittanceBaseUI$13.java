package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.h.b.a.ab;
import com.tencent.mm.plugin.remittance.model.v;
import com.tencent.mm.sdk.platformtools.y;

final class RemittanceBaseUI$13
  implements DialogInterface.OnClickListener
{
  RemittanceBaseUI$13(RemittanceBaseUI paramRemittanceBaseUI, v paramv) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    y.i("MicroMsg.RemittanceBaseUI", "onClick1 realNameCheckMessage %s", new Object[] { RemittanceBaseUI.e(this.nAH) });
    RemittanceBaseUI.a(this.nAH, this.nzN, RemittanceBaseUI.e(this.nAH));
    paramDialogInterface = new ab();
    paramDialogInterface.ckv = this.nzN.amount;
    paramDialogInterface.cku = this.nzN.username;
    paramDialogInterface.ckp = 7L;
    paramDialogInterface.QX();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.13
 * JD-Core Version:    0.7.0.1
 */