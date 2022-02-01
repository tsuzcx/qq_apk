package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.zp;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.protocal.protobuf.dor;
import com.tencent.mm.protocal.protobuf.ekd;
import com.tencent.mm.sdk.platformtools.Util;

final class WalletLqtDetailUI$11
  implements View.OnClickListener
{
  WalletLqtDetailUI$11(WalletLqtDetailUI paramWalletLqtDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(316473);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    paramView = new zp();
    paramView.icM.userName = WalletLqtDetailUI.d(this.VeZ).aboM.username;
    paramView.icM.icO = Util.nullAs(WalletLqtDetailUI.d(this.VeZ).aboM.path, "");
    paramView.icM.scene = 1061;
    paramView.icM.icP = 0;
    paramView.publish();
    a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(316473);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.11
 * JD-Core Version:    0.7.0.1
 */