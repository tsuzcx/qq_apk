package com.tencent.mm.plugin.wxcredit.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.List;

final class WalletWXCreditDetailUI$4
  implements MenuItem.OnMenuItemClickListener
{
  WalletWXCreditDetailUI$4(WalletWXCreditDetailUI paramWalletWXCreditDetailUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(48724);
    paramMenuItem = new ArrayList();
    t.cTN();
    WalletWXCreditDetailUI.a(this.vIB);
    h.a(this.vIB, null, (String[])paramMenuItem.toArray(new String[paramMenuItem.size()]), this.vIB.getString(2131305127), false, new WalletWXCreditDetailUI.4.1(this));
    AppMethodBeat.o(48724);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditDetailUI.4
 * JD-Core Version:    0.7.0.1
 */