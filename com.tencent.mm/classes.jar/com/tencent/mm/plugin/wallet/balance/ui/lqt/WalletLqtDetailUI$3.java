package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ctg;
import com.tencent.mm.wallet_core.ui.f;

final class WalletLqtDetailUI$3
  implements View.OnClickListener
{
  WalletLqtDetailUI$3(WalletLqtDetailUI paramWalletLqtDetailUI, ctg paramctg) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68789);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    f.u(this.Hyk.KZR, this.Hyk.yUB, 0, 1061);
    h.CyF.a(16807, new Object[] { Integer.valueOf(2), Integer.valueOf(2), this.Hyk.yUB, this.Hyk.KZR });
    a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(68789);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.3
 * JD-Core Version:    0.7.0.1
 */