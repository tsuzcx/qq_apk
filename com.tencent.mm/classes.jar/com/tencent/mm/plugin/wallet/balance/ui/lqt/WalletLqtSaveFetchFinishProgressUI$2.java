package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletLqtSaveFetchFinishProgressUI$2
  implements View.OnClickListener
{
  WalletLqtSaveFetchFinishProgressUI$2(WalletLqtSaveFetchFinishProgressUI paramWalletLqtSaveFetchFinishProgressUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(45635);
    this.tRm.finish();
    AppMethodBeat.o(45635);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchFinishProgressUI.2
 * JD-Core Version:    0.7.0.1
 */