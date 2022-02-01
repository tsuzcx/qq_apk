package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.wallet_core.ui.i;

final class BankRemitBankcardInputUI$1
  implements MenuItem.OnMenuItemClickListener
{
  BankRemitBankcardInputUI$1(BankRemitBankcardInputUI paramBankRemitBankcardInputUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(288757);
    Log.d("MicroMsg.BankRemitBankcardInputUI", "help click");
    BankRemitBankcardInputUI.a(this.Odx, new f(this.Odx.getContext(), 1, false));
    BankRemitBankcardInputUI.a(this.Odx).Vtg = new u.g()
    {
      public final void onCreateMMMenu(s paramAnonymouss)
      {
        AppMethodBeat.i(288760);
        paramAnonymouss.add(0, 0, 0, BankRemitBankcardInputUI.1.this.Odx.getString(a.i.bank_remit_history_title));
        paramAnonymouss.add(0, 1, 0, BankRemitBankcardInputUI.1.this.Odx.getString(a.i.bank_remit_help_center_text));
        AppMethodBeat.o(288760);
      }
    };
    BankRemitBankcardInputUI.a(this.Odx).GAC = new u.i()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(288763);
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(288763);
          return;
          if (!Util.isNullOrNil(BankRemitBankcardInputUI.b(BankRemitBankcardInputUI.1.this.Odx))) {
            i.p(BankRemitBankcardInputUI.1.this.Odx.getContext(), BankRemitBankcardInputUI.b(BankRemitBankcardInputUI.1.this.Odx), false);
          }
          for (;;)
          {
            h.OAn.b(14673, new Object[] { Integer.valueOf(6) });
            AppMethodBeat.o(288763);
            return;
            Log.w("MicroMsg.BankRemitBankcardInputUI", "paylist url is null");
          }
          i.p(BankRemitBankcardInputUI.1.this.Odx.getContext(), "https://" + WeChatHosts.domainString(a.i.host_kf_qq_com) + "/touch/scene_product.html?scene_id=kf4568", true);
        }
      }
    };
    this.Odx.hideTenpayKB();
    BankRemitBankcardInputUI.a(this.Odx).dDn();
    h.OAn.b(14673, new Object[] { Integer.valueOf(2) });
    AppMethodBeat.o(288757);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.1
 * JD-Core Version:    0.7.0.1
 */