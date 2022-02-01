package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.protocal.protobuf.dtx;
import com.tencent.mm.protocal.protobuf.ekd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.i;

final class WalletLqtDetailUI$25
  implements View.OnClickListener
{
  WalletLqtDetailUI$25(WalletLqtDetailUI paramWalletLqtDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(316456);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    Log.i("MicroMsg.WalletLqtDetailUI", "click middle banner with urltype : %d", new Object[] { Integer.valueOf(WalletLqtDetailUI.d(this.VeZ).abpk.aaZv) });
    if (WalletLqtDetailUI.d(this.VeZ).abpk.aaZv == 2)
    {
      paramView = WalletLqtDetailUI.d(this.VeZ).abpk.Krl;
      if (!Util.isNullOrNil(paramView))
      {
        Log.i("MicroMsg.WalletLqtDetailUI", "open middle banner h5 with url : %s", new Object[] { paramView });
        i.o(this.VeZ, paramView, false);
      }
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(316456);
      return;
      if (WalletLqtDetailUI.d(this.VeZ).abpk.aaZv == 3)
      {
        paramView = WalletLqtDetailUI.d(this.VeZ).abpk.YYZ;
        if (!Util.isNullOrNil(paramView))
        {
          Log.i("MicroMsg.WalletLqtDetailUI", "open middle banner tinyapp with username : %s", new Object[] { paramView });
          i.y(paramView, WalletLqtDetailUI.d(this.VeZ).abpk.Krl, 0, 1061);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.25
 * JD-Core Version:    0.7.0.1
 */