package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletLqtSaveFetchUI$8
  implements CompoundButton.OnCheckedChangeListener
{
  WalletLqtSaveFetchUI$8(WalletLqtSaveFetchUI paramWalletLqtSaveFetchUI) {}
  
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    AppMethodBeat.i(155074);
    if (!paramBoolean)
    {
      WalletLqtSaveFetchUI.a(this.tRZ, false);
      AppMethodBeat.o(155074);
      return;
    }
    WalletLqtSaveFetchUI.a(this.tRZ, true);
    AppMethodBeat.o(155074);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.8
 * JD-Core Version:    0.7.0.1
 */