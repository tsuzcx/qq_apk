package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.dhk;
import com.tencent.mm.protocal.protobuf.dtx;
import com.tencent.mm.protocal.protobuf.ekd;
import com.tencent.mm.wallet_core.ui.i;

final class WalletLqtDetailUI$29
  implements View.OnClickListener
{
  WalletLqtDetailUI$29(WalletLqtDetailUI paramWalletLqtDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(316445);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$35", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    i.y(WalletLqtDetailUI.d(this.VeZ).abpi.aaMH.YYZ, WalletLqtDetailUI.d(this.VeZ).abpi.aaMH.Krl, 0, 1061);
    h.OAn.b(17084, new Object[] { Integer.valueOf(11) });
    a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$35", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(316445);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.29
 * JD-Core Version:    0.7.0.1
 */