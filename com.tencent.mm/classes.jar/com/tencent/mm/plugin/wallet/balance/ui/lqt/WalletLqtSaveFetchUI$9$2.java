package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;

final class WalletLqtSaveFetchUI$9$2
  implements n.d
{
  WalletLqtSaveFetchUI$9$2(WalletLqtSaveFetchUI.9 param9) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(155076);
    paramInt = paramMenuItem.getItemId();
    if (paramInt < this.tSe.tSd.size())
    {
      paramMenuItem = ((java.lang.String)this.tSe.tSd.get(paramInt)).split("\\|\\|")[1];
      e.m(this.tSe.tRZ, paramMenuItem, false);
    }
    AppMethodBeat.o(155076);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.9.2
 * JD-Core Version:    0.7.0.1
 */