package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.ui.e;

final class WalletLqtDetailUI$19
  implements View.OnClickListener
{
  WalletLqtDetailUI$19(WalletLqtDetailUI paramWalletLqtDetailUI, ViewGroup paramViewGroup) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(45543);
    paramView = (String)this.tPX.getTag();
    e.m(this.tPQ, paramView, false);
    AppMethodBeat.o(45543);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.19
 * JD-Core Version:    0.7.0.1
 */