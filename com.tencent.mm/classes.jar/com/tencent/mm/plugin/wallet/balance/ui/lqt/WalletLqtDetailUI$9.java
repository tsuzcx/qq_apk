package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ctg;
import com.tencent.mm.protocal.protobuf.dhn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.f;

final class WalletLqtDetailUI$9
  implements View.OnClickListener
{
  WalletLqtDetailUI$9(WalletLqtDetailUI paramWalletLqtDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68795);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    Log.i("MicroMsg.WalletLqtDetailUI", "click top biz");
    if (WalletLqtDetailUI.d(this.Hyi).MMl.Myg == 2) {
      if (!Util.isNullOrNil(WalletLqtDetailUI.d(this.Hyi).MMl.yUB))
      {
        f.o(this.Hyi, WalletLqtDetailUI.d(this.Hyi).MMl.yUB, false);
        h.CyF.a(16807, new Object[] { Integer.valueOf(1), Integer.valueOf(2), WalletLqtDetailUI.d(this.Hyi).MMl.yUB });
      }
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(68795);
      return;
      if ((WalletLqtDetailUI.d(this.Hyi).MMl.Myg == 3) && (!Util.isNullOrNil(WalletLqtDetailUI.d(this.Hyi).MMl.KZR)) && (!Util.isNullOrNil(WalletLqtDetailUI.d(this.Hyi).MMl.yUB)))
      {
        f.u(WalletLqtDetailUI.d(this.Hyi).MMl.KZR, WalletLqtDetailUI.d(this.Hyi).MMl.yUB, 0, 1061);
        h.CyF.a(16807, new Object[] { Integer.valueOf(1), Integer.valueOf(3), WalletLqtDetailUI.d(this.Hyi).MMl.yUB, WalletLqtDetailUI.d(this.Hyi).MMl.KZR });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.9
 * JD-Core Version:    0.7.0.1
 */