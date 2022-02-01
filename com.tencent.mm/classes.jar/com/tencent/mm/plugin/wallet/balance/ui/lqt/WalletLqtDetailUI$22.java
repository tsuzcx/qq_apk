package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.cpo;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.wallet_core.ui.f;

final class WalletLqtDetailUI$22
  implements View.OnClickListener
{
  WalletLqtDetailUI$22(WalletLqtDetailUI paramWalletLqtDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68809);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    if (!bu.isNullOrNil(WalletLqtDetailUI.d(this.CSZ).HBu))
    {
      f.o(this.CSZ, WalletLqtDetailUI.d(this.CSZ).HBu, false);
      g.yxI.f(17084, new Object[] { Integer.valueOf(2) });
    }
    a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(68809);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.22
 * JD-Core Version:    0.7.0.1
 */