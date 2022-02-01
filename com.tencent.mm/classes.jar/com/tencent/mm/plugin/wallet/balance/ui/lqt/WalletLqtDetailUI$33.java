package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ekd;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.i;

final class WalletLqtDetailUI$33
  implements View.OnClickListener
{
  WalletLqtDetailUI$33(WalletLqtDetailUI paramWalletLqtDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68808);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if (!Util.isNullOrNil(WalletLqtDetailUI.d(this.VeZ).aboS))
    {
      i.o(this.VeZ, WalletLqtDetailUI.d(this.VeZ).aboS, false);
      h.OAn.b(17084, new Object[] { Integer.valueOf(1) });
    }
    a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(68808);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.33
 * JD-Core Version:    0.7.0.1
 */