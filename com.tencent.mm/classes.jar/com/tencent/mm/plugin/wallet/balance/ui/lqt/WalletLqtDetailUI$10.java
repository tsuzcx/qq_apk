package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.mm.wallet_core.ui.e;

final class WalletLqtDetailUI$10
  implements View.OnClickListener
{
  WalletLqtDetailUI$10(WalletLqtDetailUI paramWalletLqtDetailUI, LinearLayout paramLinearLayout) {}
  
  public final void onClick(View paramView)
  {
    paramView = (String)this.qip.getTag();
    e.l(this.qil, paramView, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.10
 * JD-Core Version:    0.7.0.1
 */