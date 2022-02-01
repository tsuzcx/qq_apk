package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.cda;
import com.tencent.mm.protocal.protobuf.cpo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.wallet_core.ui.f;

final class WalletLqtDetailUI$9
  implements View.OnClickListener
{
  WalletLqtDetailUI$9(WalletLqtDetailUI paramWalletLqtDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68795);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    ae.i("MicroMsg.WalletLqtDetailUI", "click top biz");
    if (WalletLqtDetailUI.d(this.CSZ).HBz.Hpz == 2) {
      if (!bu.isNullOrNil(WalletLqtDetailUI.d(this.CSZ).HBz.GvO))
      {
        f.o(this.CSZ, WalletLqtDetailUI.d(this.CSZ).HBz.GvO, false);
        g.yxI.f(16807, new Object[] { Integer.valueOf(1), Integer.valueOf(2), WalletLqtDetailUI.d(this.CSZ).HBz.GvO });
      }
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(68795);
      return;
      if ((WalletLqtDetailUI.d(this.CSZ).HBz.Hpz == 3) && (!bu.isNullOrNil(WalletLqtDetailUI.d(this.CSZ).HBz.GjV)) && (!bu.isNullOrNil(WalletLqtDetailUI.d(this.CSZ).HBz.GvO)))
      {
        f.u(WalletLqtDetailUI.d(this.CSZ).HBz.GjV, WalletLqtDetailUI.d(this.CSZ).HBz.GvO, 0, 1061);
        g.yxI.f(16807, new Object[] { Integer.valueOf(1), Integer.valueOf(3), WalletLqtDetailUI.d(this.CSZ).HBz.GvO, WalletLqtDetailUI.d(this.CSZ).HBz.GjV });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.9
 * JD-Core Version:    0.7.0.1
 */