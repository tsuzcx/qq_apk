package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.wallet_core.ui.i;

final class WalletLqtDetailUI$6
  implements View.OnClickListener
{
  WalletLqtDetailUI$6(WalletLqtDetailUI paramWalletLqtDetailUI, ViewGroup paramViewGroup) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68792);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    paramView = (String)this.Vfd.getTag();
    i.o(this.VeZ, paramView, false);
    a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(68792);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.6
 * JD-Core Version:    0.7.0.1
 */