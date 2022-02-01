package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletLqtSaveFetchUI$7
  implements View.OnClickListener
{
  WalletLqtSaveFetchUI$7(WalletLqtSaveFetchUI paramWalletLqtSaveFetchUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68975);
    if (!WalletLqtSaveFetchUI.q(this.zMe).isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      WalletLqtSaveFetchUI.q(this.zMe).setChecked(bool);
      AppMethodBeat.o(68975);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.7
 * JD-Core Version:    0.7.0.1
 */