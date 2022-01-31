package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.widget.Toast;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.n.a;

final class BankRemitDetailUI$3
  implements n.a
{
  BankRemitDetailUI$3(BankRemitDetailUI paramBankRemitDetailUI) {}
  
  public final void f(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.e("MicroMsg.BankRemitDetailUI", "net error: %s", new Object[] { paramm });
    Toast.makeText(this.nwC, a.i.bank_remit_detail_fetch_fail_text, 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitDetailUI.3
 * JD-Core Version:    0.7.0.1
 */