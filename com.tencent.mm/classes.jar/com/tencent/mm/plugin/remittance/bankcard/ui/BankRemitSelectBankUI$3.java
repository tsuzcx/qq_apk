package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.widget.Toast;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.remittance.bankcard.a.h;
import com.tencent.mm.protocal.c.abz;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.n.a;

final class BankRemitSelectBankUI$3
  implements n.a
{
  BankRemitSelectBankUI$3(BankRemitSelectBankUI paramBankRemitSelectBankUI, h paramh) {}
  
  public final void f(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.e("MicroMsg.BankRemitSelectBankUI", "response error: %s, %s", new Object[] { Integer.valueOf(this.nxt.nuX.iHq), this.nxt.nuX.iHr });
    if (!bk.bl(this.nxt.nuX.iHr)) {
      Toast.makeText(this.nxs, this.nxt.nuX.iHr, 1).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectBankUI.3
 * JD-Core Version:    0.7.0.1
 */