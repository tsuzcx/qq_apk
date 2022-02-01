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
    AppMethodBeat.i(68976);
    if (!paramBoolean)
    {
      WalletLqtSaveFetchUI.a(this.zMe, false);
      AppMethodBeat.o(68976);
      return;
    }
    WalletLqtSaveFetchUI.a(this.zMe, true);
    AppMethodBeat.o(68976);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.8
 * JD-Core Version:    0.7.0.1
 */