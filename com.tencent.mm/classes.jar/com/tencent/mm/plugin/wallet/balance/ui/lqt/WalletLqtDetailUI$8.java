package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vq;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.protocal.protobuf.bzv;
import com.tencent.mm.protocal.protobuf.cpo;
import com.tencent.mm.sdk.platformtools.bu;

final class WalletLqtDetailUI$8
  implements View.OnClickListener
{
  WalletLqtDetailUI$8(WalletLqtDetailUI paramWalletLqtDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68794);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    paramView = new vq();
    paramView.dKT.userName = WalletLqtDetailUI.d(this.CSZ).HBn.username;
    paramView.dKT.dKV = bu.bI(WalletLqtDetailUI.d(this.CSZ).HBn.path, "");
    paramView.dKT.scene = 1061;
    paramView.dKT.dKW = 0;
    com.tencent.mm.sdk.b.a.IvT.l(paramView);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(68794);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.8
 * JD-Core Version:    0.7.0.1
 */