package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.dtx;
import com.tencent.mm.protocal.protobuf.ekd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.i;

final class WalletLqtDetailUI$13
  implements View.OnClickListener
{
  WalletLqtDetailUI$13(WalletLqtDetailUI paramWalletLqtDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(316477);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    Log.i("MicroMsg.WalletLqtDetailUI", "click top biz");
    if (WalletLqtDetailUI.d(this.VeZ).aboY.aaZv == 2) {
      if (!Util.isNullOrNil(WalletLqtDetailUI.d(this.VeZ).aboY.Krl))
      {
        i.o(this.VeZ, WalletLqtDetailUI.d(this.VeZ).aboY.Krl, false);
        h.OAn.b(16807, new Object[] { Integer.valueOf(1), Integer.valueOf(2), WalletLqtDetailUI.d(this.VeZ).aboY.Krl });
      }
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(316477);
      return;
      if ((WalletLqtDetailUI.d(this.VeZ).aboY.aaZv == 3) && (!Util.isNullOrNil(WalletLqtDetailUI.d(this.VeZ).aboY.YYZ)) && (!Util.isNullOrNil(WalletLqtDetailUI.d(this.VeZ).aboY.Krl)))
      {
        i.y(WalletLqtDetailUI.d(this.VeZ).aboY.YYZ, WalletLqtDetailUI.d(this.VeZ).aboY.Krl, 0, 1061);
        h.OAn.b(16807, new Object[] { Integer.valueOf(1), Integer.valueOf(3), WalletLqtDetailUI.d(this.VeZ).aboY.Krl, WalletLqtDetailUI.d(this.VeZ).aboY.YYZ });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.13
 * JD-Core Version:    0.7.0.1
 */