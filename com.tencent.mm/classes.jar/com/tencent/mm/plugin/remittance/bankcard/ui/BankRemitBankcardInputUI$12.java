package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.widget.b.d;

final class BankRemitBankcardInputUI$12
  implements MenuItem.OnMenuItemClickListener
{
  BankRemitBankcardInputUI$12(BankRemitBankcardInputUI paramBankRemitBankcardInputUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(44526);
    ab.d("MicroMsg.BankRemitBankcardInputUI", "help click");
    BankRemitBankcardInputUI.a(this.qhe, new d(this.qhe.getContext(), 1, false));
    BankRemitBankcardInputUI.a(this.qhe).sao = new n.c()
    {
      public final void onCreateMMMenu(l paramAnonymousl)
      {
        AppMethodBeat.i(44524);
        paramAnonymousl.add(0, 0, 0, BankRemitBankcardInputUI.12.this.qhe.getString(2131297495));
        paramAnonymousl.add(0, 1, 0, BankRemitBankcardInputUI.12.this.qhe.getString(2131297493));
        AppMethodBeat.o(44524);
      }
    };
    BankRemitBankcardInputUI.a(this.qhe).sap = new BankRemitBankcardInputUI.12.2(this);
    this.qhe.hideTenpayKB();
    BankRemitBankcardInputUI.a(this.qhe).crd();
    h.qsU.e(14673, new Object[] { Integer.valueOf(2) });
    AppMethodBeat.o(44526);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.12
 * JD-Core Version:    0.7.0.1
 */