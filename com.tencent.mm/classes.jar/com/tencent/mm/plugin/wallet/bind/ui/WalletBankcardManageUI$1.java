package com.tencent.mm.plugin.wallet.bind.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

final class WalletBankcardManageUI$1
  implements MenuItem.OnMenuItemClickListener
{
  WalletBankcardManageUI$1(WalletBankcardManageUI paramWalletBankcardManageUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(315562);
    this.VkC.finish();
    h.OAn.b(14422, new Object[] { Integer.valueOf(4) });
    AppMethodBeat.o(315562);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI.1
 * JD-Core Version:    0.7.0.1
 */