package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletLqtSaveFetchUI$9
  implements CompoundButton.OnCheckedChangeListener
{
  WalletLqtSaveFetchUI$9(WalletLqtSaveFetchUI paramWalletLqtSaveFetchUI) {}
  
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    AppMethodBeat.i(199237);
    if (!paramBoolean)
    {
      WalletLqtSaveFetchUI.a(this.CEJ, false);
      AppMethodBeat.o(199237);
      return;
    }
    WalletLqtSaveFetchUI.a(this.CEJ, true);
    AppMethodBeat.o(199237);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.9
 * JD-Core Version:    0.7.0.1
 */