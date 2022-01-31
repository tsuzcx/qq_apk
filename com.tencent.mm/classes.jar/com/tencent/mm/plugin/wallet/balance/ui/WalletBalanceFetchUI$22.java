package com.tencent.mm.plugin.wallet.balance.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.c;
import com.tencent.mm.plugin.wallet_core.model.c.a;
import com.tencent.mm.plugin.wallet_core.model.c.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.b.d;
import com.tencent.mm.wallet_core.ui.e;

final class WalletBalanceFetchUI$22
  implements MenuItem.OnMenuItemClickListener
{
  WalletBalanceFetchUI$22(WalletBalanceFetchUI paramWalletBalanceFetchUI, c paramc) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(45385);
    paramMenuItem = new d(this.tOj.getContext(), 1, false);
    paramMenuItem.sao = new WalletBalanceFetchUI.22.1(this);
    paramMenuItem.sap = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(45384);
        paramAnonymousInt = paramAnonymousMenuItem.getItemId();
        if ((WalletBalanceFetchUI.22.this.tOu.ufs.ufu != null) && (paramAnonymousInt < WalletBalanceFetchUI.22.this.tOu.ufs.ufu.length))
        {
          paramAnonymousMenuItem = WalletBalanceFetchUI.22.this.tOu.ufs.ufu[paramAnonymousInt];
          ab.i("MicroMsg.WalletBalanceFetchUI", "jump type: %s, url: %s", new Object[] { Integer.valueOf(paramAnonymousMenuItem.pdt), paramAnonymousMenuItem.knV });
          switch (paramAnonymousMenuItem.pdt)
          {
          }
        }
        for (;;)
        {
          AppMethodBeat.o(45384);
          return;
          e.m(WalletBalanceFetchUI.22.this.tOj.getContext(), paramAnonymousMenuItem.knV, true);
          AppMethodBeat.o(45384);
          return;
          e.q(paramAnonymousMenuItem.username, paramAnonymousMenuItem.path, 0, 1000);
        }
      }
    };
    paramMenuItem.crd();
    AppMethodBeat.o(45385);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.22
 * JD-Core Version:    0.7.0.1
 */