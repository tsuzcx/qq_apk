package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.widget.Toast;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.remittance.bankcard.a.k;
import com.tencent.mm.protocal.c.bcj;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.n.a;

final class BankRemitBankcardInputUI$15
  implements n.a
{
  BankRemitBankcardInputUI$15(BankRemitBankcardInputUI paramBankRemitBankcardInputUI, k paramk) {}
  
  public final void f(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.e("MicroMsg.BankRemitBankcardInputUI", "operation response error: %s, %s", new Object[] { Integer.valueOf(this.nwj.nva.iHq), this.nwj.nva.iHr });
    if (!bk.bl(this.nwj.nva.iHr)) {
      Toast.makeText(this.nwd, this.nwj.nva.iHr, 1).show();
    }
    this.nwd.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.15
 * JD-Core Version:    0.7.0.1
 */