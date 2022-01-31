package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletLqtSaveFetchUI$1
  implements View.OnClickListener
{
  WalletLqtSaveFetchUI$1(WalletLqtSaveFetchUI paramWalletLqtSaveFetchUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(45644);
    this.tRZ.hideTenpayKB();
    WalletLqtSaveFetchUI.a(this.tRZ);
    AppMethodBeat.o(45644);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.1
 * JD-Core Version:    0.7.0.1
 */