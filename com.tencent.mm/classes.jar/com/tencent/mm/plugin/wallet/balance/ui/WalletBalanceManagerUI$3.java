package com.tencent.mm.plugin.wallet.balance.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.a.d;
import java.util.List;
import org.json.JSONObject;

final class WalletBalanceManagerUI$3
  implements MenuItem.OnMenuItemClickListener
{
  WalletBalanceManagerUI$3(WalletBalanceManagerUI paramWalletBalanceManagerUI, JSONObject paramJSONObject, List paramList) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = new d(this.qhk.mController.uMN, 1, false);
    paramMenuItem.phH = new WalletBalanceManagerUI.3.1(this);
    paramMenuItem.phI = new WalletBalanceManagerUI.3.2(this);
    paramMenuItem.cfU();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.3
 * JD-Core Version:    0.7.0.1
 */