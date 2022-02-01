package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.dhn;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.f;

final class WalletLqtDetailUI$27
  implements View.OnClickListener
{
  WalletLqtDetailUI$27(WalletLqtDetailUI paramWalletLqtDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68808);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if (!Util.isNullOrNil(WalletLqtDetailUI.d(this.Hyi).MMf))
    {
      f.o(this.Hyi, WalletLqtDetailUI.d(this.Hyi).MMf, false);
      h.CyF.a(17084, new Object[] { Integer.valueOf(1) });
    }
    a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(68808);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.27
 * JD-Core Version:    0.7.0.1
 */