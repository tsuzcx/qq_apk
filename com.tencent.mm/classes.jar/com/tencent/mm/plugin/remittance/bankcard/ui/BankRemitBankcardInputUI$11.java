package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.widget.Toast;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.remittance.bankcard.a.d;
import com.tencent.mm.protocal.c.of;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.n.a;

final class BankRemitBankcardInputUI$11
  implements n.a
{
  BankRemitBankcardInputUI$11(BankRemitBankcardInputUI paramBankRemitBankcardInputUI, d paramd) {}
  
  public final void f(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.e("MicroMsg.BankRemitBankcardInputUI", "check response error: %s, %s", new Object[] { Integer.valueOf(this.nwh.nuT.iHq), this.nwh.nuT.iHr });
    if (!bk.bl(this.nwh.nuT.iHr)) {
      Toast.makeText(this.nwd, this.nwh.nuT.iHr, 1).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.11
 * JD-Core Version:    0.7.0.1
 */