package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.remittance.bankcard.a.n;
import com.tencent.mm.protocal.c.blo;
import com.tencent.mm.protocal.c.cr;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.ui.e;

final class BankRemitMoneyInputUI$9
  implements DialogInterface.OnClickListener
{
  BankRemitMoneyInputUI$9(BankRemitMoneyInputUI paramBankRemitMoneyInputUI, n paramn, cr paramcr) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.nxj.nvd.iHq == 0) {
      BankRemitMoneyInputUI.a(this.nxh, this.nxj.nvd.lRA, this.nxj.nvd.nvA, this.nxj.nvd.lnT, this.nxj.nvd.nvz);
    }
    while (bk.bl(this.nxm.iHx)) {
      return;
    }
    e.l(this.nxh.mController.uMN, this.nxm.iHx, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitMoneyInputUI.9
 * JD-Core Version:    0.7.0.1
 */