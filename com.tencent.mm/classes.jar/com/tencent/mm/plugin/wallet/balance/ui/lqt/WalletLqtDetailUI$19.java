package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.bup;
import com.tencent.mm.protocal.protobuf.cda;
import com.tencent.mm.protocal.protobuf.cpo;
import com.tencent.mm.wallet_core.ui.f;

final class WalletLqtDetailUI$19
  implements View.OnClickListener
{
  WalletLqtDetailUI$19(WalletLqtDetailUI paramWalletLqtDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(190075);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$26", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    f.u(WalletLqtDetailUI.d(this.CSZ).HBI.HhO.GjV, WalletLqtDetailUI.d(this.CSZ).HBI.HhO.GvO, 0, 1061);
    g.yxI.f(17084, new Object[] { Integer.valueOf(11) });
    a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$26", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(190075);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.19
 * JD-Core Version:    0.7.0.1
 */