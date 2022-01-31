package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.widget.Toast;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.remittance.bankcard.a.f;
import com.tencent.mm.protocal.c.tt;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.n.a;

final class BankRemitSelectPayeeUI$10
  implements n.a
{
  BankRemitSelectPayeeUI$10(BankRemitSelectPayeeUI paramBankRemitSelectPayeeUI, f paramf) {}
  
  public final void f(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.e("MicroMsg.BankRemitSelectPayeeUI", "reponse error: %s, msg: %s", new Object[] { Integer.valueOf(this.nxD.nuV.iHq), this.nxD.nuV.iHr });
    if (!bk.bl(this.nxD.nuV.iHr)) {
      Toast.makeText(this.nxC, this.nxD.nuV.iHr, 1).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectPayeeUI.10
 * JD-Core Version:    0.7.0.1
 */