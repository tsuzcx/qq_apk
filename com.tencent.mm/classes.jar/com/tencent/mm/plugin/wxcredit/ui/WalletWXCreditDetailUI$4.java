package com.tencent.mm.plugin.wxcredit.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.List;

final class WalletWXCreditDetailUI$4
  implements MenuItem.OnMenuItemClickListener
{
  WalletWXCreditDetailUI$4(WalletWXCreditDetailUI paramWalletWXCreditDetailUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = new ArrayList();
    o.bVs();
    String str = WalletWXCreditDetailUI.a(this.rRL).field_bindSerial;
    h.a(this.rRL, null, (String[])paramMenuItem.toArray(new String[paramMenuItem.size()]), this.rRL.getString(a.i.wallet_index_ui_unbind_bankcard), false, new WalletWXCreditDetailUI.4.1(this));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditDetailUI.4
 * JD-Core Version:    0.7.0.1
 */