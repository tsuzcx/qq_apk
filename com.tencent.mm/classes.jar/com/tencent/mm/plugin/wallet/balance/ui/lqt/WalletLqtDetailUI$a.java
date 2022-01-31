package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.a;
import com.tencent.mm.plugin.wallet_core.model.a.a;
import com.tencent.mm.sdk.platformtools.ab;

final class WalletLqtDetailUI$a
  extends a
{
  boolean tPY = false;
  
  private WalletLqtDetailUI$a(WalletLqtDetailUI paramWalletLqtDetailUI) {}
  
  public final void a(a.a parama)
  {
    this.tPY = false;
  }
  
  public final void bOR()
  {
    AppMethodBeat.i(142299);
    ab.i("MicroMsg.WalletLqtDetailUI", "time expired: %s", new Object[] { Boolean.valueOf(this.tPY) });
    if (!this.tPY)
    {
      WalletLqtDetailUI.k(this.tPQ).setVisibility(8);
      WalletLqtDetailUI.l(this.tPQ).setVisibility(0);
    }
    AppMethodBeat.o(142299);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.a
 * JD-Core Version:    0.7.0.1
 */