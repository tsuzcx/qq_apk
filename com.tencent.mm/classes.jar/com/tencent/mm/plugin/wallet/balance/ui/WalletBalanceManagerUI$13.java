package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.ui.e.m;
import com.tencent.mm.wallet_core.ui.e;

final class WalletBalanceManagerUI$13
  implements View.OnClickListener
{
  WalletBalanceManagerUI$13(WalletBalanceManagerUI paramWalletBalanceManagerUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68659);
    paramView = new Intent();
    paramView.putExtra("rawUrl", "https://kf.qq.com/touch/scene_product.html?scene_id=kf4");
    paramView.putExtra("showShare", false);
    paramView.putExtra("geta8key_username", u.aqG());
    paramView.putExtra(e.m.FIC, true);
    e.X(this.zHn.getContext(), paramView);
    e.aby(17);
    AppMethodBeat.o(68659);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.13
 * JD-Core Version:    0.7.0.1
 */