package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.ccg;
import com.tencent.mm.protocal.protobuf.cou;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.ui.e;

final class WalletLqtDetailUI$9
  implements View.OnClickListener
{
  WalletLqtDetailUI$9(WalletLqtDetailUI paramWalletLqtDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68795);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    ad.i("MicroMsg.WalletLqtDetailUI", "click top biz");
    if (WalletLqtDetailUI.d(this.CBs).HhZ.GVZ == 2) {
      if (!bt.isNullOrNil(WalletLqtDetailUI.d(this.CBs).HhZ.Gdh))
      {
        e.n(this.CBs, WalletLqtDetailUI.d(this.CBs).HhZ.Gdh, false);
        g.yhR.f(16807, new Object[] { Integer.valueOf(1), Integer.valueOf(2), WalletLqtDetailUI.d(this.CBs).HhZ.Gdh });
      }
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(68795);
      return;
      if ((WalletLqtDetailUI.d(this.CBs).HhZ.GVZ == 3) && (!bt.isNullOrNil(WalletLqtDetailUI.d(this.CBs).HhZ.FRw)) && (!bt.isNullOrNil(WalletLqtDetailUI.d(this.CBs).HhZ.Gdh)))
      {
        e.v(WalletLqtDetailUI.d(this.CBs).HhZ.FRw, WalletLqtDetailUI.d(this.CBs).HhZ.Gdh, 0, 1061);
        g.yhR.f(16807, new Object[] { Integer.valueOf(1), Integer.valueOf(3), WalletLqtDetailUI.d(this.CBs).HhZ.Gdh, WalletLqtDetailUI.d(this.CBs).HhZ.FRw });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.9
 * JD-Core Version:    0.7.0.1
 */