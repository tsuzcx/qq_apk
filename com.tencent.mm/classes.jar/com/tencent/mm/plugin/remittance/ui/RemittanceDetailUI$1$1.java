package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.h.a.nl;
import com.tencent.mm.h.a.nl.a;
import com.tencent.mm.plugin.remittance.model.u;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

final class RemittanceDetailUI$1$1
  implements DialogInterface.OnClickListener
{
  RemittanceDetailUI$1$1(RemittanceDetailUI.1 param1, nl paramnl) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new u(this.nDn.bXc.bMY, this.nDn.bXc.bQR, this.nDn.bXc.bXd, "refuse", this.nDn.bXc.bXe, this.nDn.bXc.bXf);
    paramDialogInterface.dIA = "RemittanceProcess";
    this.nDo.nDm.a(paramDialogInterface, true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI.1.1
 * JD-Core Version:    0.7.0.1
 */