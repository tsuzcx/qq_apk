package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.cda;
import com.tencent.mm.wallet_core.ui.f;

final class WalletLqtDetailUI$3
  implements View.OnClickListener
{
  WalletLqtDetailUI$3(WalletLqtDetailUI paramWalletLqtDetailUI, cda paramcda) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68789);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    f.u(this.CTb.GjV, this.CTb.GvO, 0, 1061);
    g.yxI.f(16807, new Object[] { Integer.valueOf(2), Integer.valueOf(2), this.CTb.GvO, this.CTb.GjV });
    a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(68789);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.3
 * JD-Core Version:    0.7.0.1
 */