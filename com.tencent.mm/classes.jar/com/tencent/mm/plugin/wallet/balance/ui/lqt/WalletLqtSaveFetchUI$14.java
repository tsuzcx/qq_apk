package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.wallet_core.ui.e.a;
import com.tencent.mm.wallet_core.ui.f;
import java.util.ArrayList;
import java.util.Iterator;

final class WalletLqtSaveFetchUI$14
  implements e.a
{
  WalletLqtSaveFetchUI$14(WalletLqtSaveFetchUI paramWalletLqtSaveFetchUI, ArrayList paramArrayList) {}
  
  public final void bmr()
  {
    AppMethodBeat.i(213983);
    e locale = new e(this.HBI, 1, false);
    locale.HLX = new o.f()
    {
      public final void onCreateMMMenu(m paramAnonymousm)
      {
        AppMethodBeat.i(213981);
        Iterator localIterator = WalletLqtSaveFetchUI.14.this.HBS.iterator();
        int i = 0;
        while (localIterator.hasNext())
        {
          paramAnonymousm.add(0, i, 0, ((java.lang.String)localIterator.next()).split("\\|\\|")[0]);
          i += 1;
        }
        AppMethodBeat.o(213981);
      }
    };
    locale.HLY = new o.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(213982);
        paramAnonymousInt = paramAnonymousMenuItem.getItemId();
        if (paramAnonymousInt < WalletLqtSaveFetchUI.14.this.HBS.size())
        {
          paramAnonymousMenuItem = ((java.lang.String)WalletLqtSaveFetchUI.14.this.HBS.get(paramAnonymousInt)).split("\\|\\|")[1];
          f.p(WalletLqtSaveFetchUI.14.this.HBI, paramAnonymousMenuItem, false);
        }
        AppMethodBeat.o(213982);
      }
    };
    locale.dGm();
    AppMethodBeat.o(213983);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.14
 * JD-Core Version:    0.7.0.1
 */