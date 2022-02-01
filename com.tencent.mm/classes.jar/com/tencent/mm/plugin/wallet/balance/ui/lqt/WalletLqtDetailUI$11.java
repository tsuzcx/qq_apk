package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.dcf;
import com.tencent.mm.protocal.protobuf.dri;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.g;

final class WalletLqtDetailUI$11
  implements View.OnClickListener
{
  WalletLqtDetailUI$11(WalletLqtDetailUI paramWalletLqtDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(274944);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    Log.i("MicroMsg.WalletLqtDetailUI", "click top biz");
    if (WalletLqtDetailUI.d(this.OpW).TYg.TJG == 2) {
      if (!Util.isNullOrNil(WalletLqtDetailUI.d(this.OpW).TYg.Eyy))
      {
        g.o(this.OpW, WalletLqtDetailUI.d(this.OpW).TYg.Eyy, false);
        h.IzE.a(16807, new Object[] { Integer.valueOf(1), Integer.valueOf(2), WalletLqtDetailUI.d(this.OpW).TYg.Eyy });
      }
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(274944);
      return;
      if ((WalletLqtDetailUI.d(this.OpW).TYg.TJG == 3) && (!Util.isNullOrNil(WalletLqtDetailUI.d(this.OpW).TYg.Sba)) && (!Util.isNullOrNil(WalletLqtDetailUI.d(this.OpW).TYg.Eyy)))
      {
        g.v(WalletLqtDetailUI.d(this.OpW).TYg.Sba, WalletLqtDetailUI.d(this.OpW).TYg.Eyy, 0, 1061);
        h.IzE.a(16807, new Object[] { Integer.valueOf(1), Integer.valueOf(3), WalletLqtDetailUI.d(this.OpW).TYg.Eyy, WalletLqtDetailUI.d(this.OpW).TYg.Sba });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.11
 * JD-Core Version:    0.7.0.1
 */