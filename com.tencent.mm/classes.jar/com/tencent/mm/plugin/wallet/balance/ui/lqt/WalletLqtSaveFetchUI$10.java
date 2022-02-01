package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import java.util.ArrayList;
import java.util.Iterator;

final class WalletLqtSaveFetchUI$10
  implements a.a
{
  WalletLqtSaveFetchUI$10(WalletLqtSaveFetchUI paramWalletLqtSaveFetchUI, ArrayList paramArrayList) {}
  
  public final void aRn()
  {
    AppMethodBeat.i(199240);
    com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(this.CEJ, 1, false);
    locale.KJy = new n.d()
    {
      public final void onCreateMMMenu(l paramAnonymousl)
      {
        AppMethodBeat.i(199238);
        Iterator localIterator = WalletLqtSaveFetchUI.10.this.CEO.iterator();
        int i = 0;
        while (localIterator.hasNext())
        {
          paramAnonymousl.add(0, i, 0, ((java.lang.String)localIterator.next()).split("\\|\\|")[0]);
          i += 1;
        }
        AppMethodBeat.o(199238);
      }
    };
    locale.KJz = new n.e()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(199239);
        paramAnonymousInt = paramAnonymousMenuItem.getItemId();
        if (paramAnonymousInt < WalletLqtSaveFetchUI.10.this.CEO.size())
        {
          paramAnonymousMenuItem = ((java.lang.String)WalletLqtSaveFetchUI.10.this.CEO.get(paramAnonymousInt)).split("\\|\\|")[1];
          com.tencent.mm.wallet_core.ui.e.o(WalletLqtSaveFetchUI.10.this.CEJ, paramAnonymousMenuItem, false);
        }
        AppMethodBeat.o(199239);
      }
    };
    locale.cMW();
    AppMethodBeat.o(199240);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.10
 * JD-Core Version:    0.7.0.1
 */