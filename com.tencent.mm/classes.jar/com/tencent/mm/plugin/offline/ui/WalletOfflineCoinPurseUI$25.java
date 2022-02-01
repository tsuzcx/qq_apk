package com.tencent.mm.plugin.offline.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ae;

final class WalletOfflineCoinPurseUI$25
  implements View.OnClickListener
{
  WalletOfflineCoinPurseUI$25(WalletOfflineCoinPurseUI paramWalletOfflineCoinPurseUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(184855);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    ae.i("MicroMsg.WalletOfflineCoinPurseUI", "do click fqf text link");
    WalletOfflineCoinPurseUI.H(this.wQC);
    WalletOfflineCoinPurseUI.I(this.wQC);
    WalletOfflineCoinPurseUI.b(this.wQC, "weixin://wcpay/fqf/opentinyapp");
    a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(184855);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.25
 * JD-Core Version:    0.7.0.1
 */