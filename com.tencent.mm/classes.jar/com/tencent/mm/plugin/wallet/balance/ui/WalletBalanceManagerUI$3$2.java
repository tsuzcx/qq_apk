package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.rc;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.ui.e;
import java.util.List;

final class WalletBalanceManagerUI$3$2
  implements n.d
{
  WalletBalanceManagerUI$3$2(WalletBalanceManagerUI.3 param3) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    paramMenuItem = (WalletBalanceManagerUI.a)this.qhn.kOC.get(paramMenuItem.getItemId());
    if (paramMenuItem.qho == 1) {
      e.l(this.qhn.qhk.mController.uMN, paramMenuItem.qhp, false);
    }
    do
    {
      return;
      if (paramMenuItem.qho == 2)
      {
        rc localrc = new rc();
        localrc.caq.userName = paramMenuItem.qhq;
        localrc.caq.cas = bk.aM(paramMenuItem.qhr, "");
        localrc.caq.scene = 1061;
        localrc.caq.cat = 0;
        a.udP.m(localrc);
        return;
      }
    } while (paramMenuItem.qho != 7);
    new Intent();
    d.x(this.qhn.qhk.mController.uMN, "wallet_ecard", ".ui.WalletECardLogoutUI");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.3.2
 * JD-Core Version:    0.7.0.1
 */