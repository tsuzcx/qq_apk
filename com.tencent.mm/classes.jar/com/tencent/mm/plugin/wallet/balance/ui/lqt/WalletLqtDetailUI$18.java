package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.wallet_core.ui.f;

final class WalletLqtDetailUI$18
  implements View.OnClickListener
{
  WalletLqtDetailUI$18(WalletLqtDetailUI paramWalletLqtDetailUI, ViewGroup paramViewGroup) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(190074);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    paramView = (String)this.CTh.getTag();
    f.o(this.CSZ, paramView, false);
    g.yxI.f(17084, new Object[] { Integer.valueOf(11) });
    a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(190074);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.18
 * JD-Core Version:    0.7.0.1
 */