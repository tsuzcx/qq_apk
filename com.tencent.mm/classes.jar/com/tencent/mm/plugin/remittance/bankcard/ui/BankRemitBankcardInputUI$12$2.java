package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.wallet_core.ui.e;

final class BankRemitBankcardInputUI$12$2
  implements n.d
{
  BankRemitBankcardInputUI$12$2(BankRemitBankcardInputUI.12 param12) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(44525);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(44525);
      return;
      if (!bo.isNullOrNil(BankRemitBankcardInputUI.b(this.qhj.qhe))) {
        e.m(this.qhj.qhe.getContext(), BankRemitBankcardInputUI.b(this.qhj.qhe), false);
      }
      for (;;)
      {
        h.qsU.e(14673, new Object[] { Integer.valueOf(6) });
        AppMethodBeat.o(44525);
        return;
        ab.w("MicroMsg.BankRemitBankcardInputUI", "paylist url is null");
      }
      e.m(this.qhj.qhe.getContext(), "https://kf.qq.com/touch/scene_product.html?scene_id=kf4568", true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.12.2
 * JD-Core Version:    0.7.0.1
 */