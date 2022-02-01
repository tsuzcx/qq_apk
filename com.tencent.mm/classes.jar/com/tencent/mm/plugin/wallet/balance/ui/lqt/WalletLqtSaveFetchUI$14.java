package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.wallet_core.ui.f.a;
import com.tencent.mm.wallet_core.ui.g;
import java.util.ArrayList;
import java.util.Iterator;

final class WalletLqtSaveFetchUI$14
  implements f.a
{
  WalletLqtSaveFetchUI$14(WalletLqtSaveFetchUI paramWalletLqtSaveFetchUI, ArrayList paramArrayList) {}
  
  public final void bwz()
  {
    AppMethodBeat.i(270295);
    e locale = new e(this.Oty, 1, false);
    locale.ODT = new q.f()
    {
      public final void onCreateMMMenu(o paramAnonymouso)
      {
        AppMethodBeat.i(275133);
        Iterator localIterator = WalletLqtSaveFetchUI.14.this.OtI.iterator();
        int i = 0;
        while (localIterator.hasNext())
        {
          paramAnonymouso.add(0, i, 0, ((java.lang.String)localIterator.next()).split("\\|\\|")[0]);
          i += 1;
        }
        AppMethodBeat.o(275133);
      }
    };
    locale.ODU = new q.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(270343);
        paramAnonymousInt = paramAnonymousMenuItem.getItemId();
        if (paramAnonymousInt < WalletLqtSaveFetchUI.14.this.OtI.size())
        {
          paramAnonymousMenuItem = ((java.lang.String)WalletLqtSaveFetchUI.14.this.OtI.get(paramAnonymousInt)).split("\\|\\|")[1];
          g.p(WalletLqtSaveFetchUI.14.this.Oty, paramAnonymousMenuItem, false);
        }
        AppMethodBeat.o(270343);
      }
    };
    locale.eik();
    AppMethodBeat.o(270295);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.14
 * JD-Core Version:    0.7.0.1
 */