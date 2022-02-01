package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.g;

final class WalletLqtSaveFetchUI$1
  implements View.OnClickListener
{
  WalletLqtSaveFetchUI$1(WalletLqtSaveFetchUI paramWalletLqtSaveFetchUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68967);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    this.CWq.hideTenpayKB();
    WalletLqtSaveFetchUI.a(this.CWq);
    g.yxI.f(20287, new Object[] { Integer.valueOf(3) });
    a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(68967);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.1
 * JD-Core Version:    0.7.0.1
 */