package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.cda;
import com.tencent.mm.wallet_core.ui.f;

final class WalletLqtDetailUI$2
  implements View.OnClickListener
{
  WalletLqtDetailUI$2(WalletLqtDetailUI paramWalletLqtDetailUI, ViewGroup paramViewGroup, cda paramcda) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68788);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    paramView = (String)this.CTa.getTag();
    f.o(this.CSZ, paramView, false);
    g.yxI.f(16807, new Object[] { Integer.valueOf(2), Integer.valueOf(2), this.CTb.GvO });
    a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(68788);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.2
 * JD-Core Version:    0.7.0.1
 */