package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.view.ViewGroup;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.remittance.bankcard.a.l;
import com.tencent.mm.protocal.c.bhr;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.n.a;

final class BankRemitDetailUI$5
  implements n.a
{
  BankRemitDetailUI$5(BankRemitDetailUI paramBankRemitDetailUI, l paraml) {}
  
  public final void f(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.BankRemitDetailUI", "state: %s, amount: %s, fee: %s, account: %s", new Object[] { Integer.valueOf(this.nwD.nvb.state), Integer.valueOf(this.nwD.nvb.amount), Integer.valueOf(this.nwD.nvb.tCr), this.nwD.nvb.tCs });
    BankRemitDetailUI.a(this.nwC, this.nwD.nvb.state);
    BankRemitDetailUI.a(this.nwC, this.nwD.nvb.state, this.nwD.nvb.tCq);
    BankRemitDetailUI.a(this.nwC, this.nwD.nvb);
    BankRemitDetailUI.a(this.nwC).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitDetailUI.5
 * JD-Core Version:    0.7.0.1
 */