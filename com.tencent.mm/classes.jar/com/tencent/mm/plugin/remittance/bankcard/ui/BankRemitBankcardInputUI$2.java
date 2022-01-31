package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.widget.Toast;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.remittance.bankcard.a.a;
import com.tencent.mm.protocal.c.ei;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.n.a;

final class BankRemitBankcardInputUI$2
  implements n.a
{
  BankRemitBankcardInputUI$2(BankRemitBankcardInputUI paramBankRemitBankcardInputUI, a parama) {}
  
  public final void f(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.e("MicroMsg.BankRemitBankcardInputUI", "appoint reponse error: %s, msg: %s", new Object[] { Integer.valueOf(this.nwe.nuQ.iHq), this.nwe.nuQ.iHr });
    if (!bk.bl(this.nwe.nuQ.iHr)) {
      Toast.makeText(this.nwd, this.nwe.nuQ.iHr, 1).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.2
 * JD-Core Version:    0.7.0.1
 */