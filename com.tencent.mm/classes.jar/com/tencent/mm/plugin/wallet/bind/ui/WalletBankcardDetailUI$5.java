package com.tencent.mm.plugin.wallet.bind.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.List;

final class WalletBankcardDetailUI$5
  implements MenuItem.OnMenuItemClickListener
{
  WalletBankcardDetailUI$5(WalletBankcardDetailUI paramWalletBankcardDetailUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    p.bTK();
    paramMenuItem = p.bTL().bVZ();
    if ((paramMenuItem != null) && (paramMenuItem.size() > 1))
    {
      p.bTK();
      p.bTL();
      paramMenuItem = this.qjV.qhv.field_bindSerial;
    }
    paramMenuItem = new ArrayList();
    h.a(this.qjV, null, (String[])paramMenuItem.toArray(new String[paramMenuItem.size()]), this.qjV.getString(a.i.wallet_index_ui_unbind_bankcard), false, new WalletBankcardDetailUI.5.1(this));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardDetailUI.5
 * JD-Core Version:    0.7.0.1
 */