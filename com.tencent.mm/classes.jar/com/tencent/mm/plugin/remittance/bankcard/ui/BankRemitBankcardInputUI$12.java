package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.a.d;

final class BankRemitBankcardInputUI$12
  implements MenuItem.OnMenuItemClickListener
{
  BankRemitBankcardInputUI$12(BankRemitBankcardInputUI paramBankRemitBankcardInputUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    y.d("MicroMsg.BankRemitBankcardInputUI", "help click");
    BankRemitBankcardInputUI.a(this.nwd, new d(this.nwd.mController.uMN, 1, false));
    BankRemitBankcardInputUI.a(this.nwd).phH = new BankRemitBankcardInputUI.12.1(this);
    BankRemitBankcardInputUI.a(this.nwd).phI = new BankRemitBankcardInputUI.12.2(this);
    this.nwd.VH();
    BankRemitBankcardInputUI.a(this.nwd).cfU();
    h.nFQ.f(14673, new Object[] { Integer.valueOf(2) });
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.12
 * JD-Core Version:    0.7.0.1
 */