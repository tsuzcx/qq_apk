package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.view.MenuItem;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.ui.e;

final class BankRemitBankcardInputUI$12$2
  implements n.d
{
  BankRemitBankcardInputUI$12$2(BankRemitBankcardInputUI.12 param12) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return;
    case 0: 
      if (!bk.bl(BankRemitBankcardInputUI.b(this.nwi.nwd))) {
        e.l(this.nwi.nwd.mController.uMN, BankRemitBankcardInputUI.b(this.nwi.nwd), false);
      }
      for (;;)
      {
        h.nFQ.f(14673, new Object[] { Integer.valueOf(6) });
        return;
        y.w("MicroMsg.BankRemitBankcardInputUI", "paylist url is null");
      }
    }
    e.l(this.nwi.nwd.mController.uMN, "https://kf.qq.com/touch/scene_product.html?scene_id=kf4568", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.12.2
 * JD-Core Version:    0.7.0.1
 */