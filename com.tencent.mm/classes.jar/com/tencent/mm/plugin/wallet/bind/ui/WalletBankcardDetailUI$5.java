package com.tencent.mm.plugin.wallet.bind.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.List;

final class WalletBankcardDetailUI$5
  implements MenuItem.OnMenuItemClickListener
{
  WalletBankcardDetailUI$5(WalletBankcardDetailUI paramWalletBankcardDetailUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(45745);
    s.cRG();
    paramMenuItem = s.cRH().cUF();
    if ((paramMenuItem != null) && (paramMenuItem.size() > 1))
    {
      s.cRG();
      s.cRH();
    }
    paramMenuItem = new ArrayList();
    h.a(this.tSV, null, (String[])paramMenuItem.toArray(new String[paramMenuItem.size()]), this.tSV.getString(2131305127), false, new WalletBankcardDetailUI.5.1(this));
    AppMethodBeat.o(45745);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardDetailUI.5
 * JD-Core Version:    0.7.0.1
 */