package com.tencent.mm.plugin.offline.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;

final class WalletOfflineCoinPurseUI$29
  implements View.OnClickListener
{
  WalletOfflineCoinPurseUI$29(WalletOfflineCoinPurseUI paramWalletOfflineCoinPurseUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(213653);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$35", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    Log.i("MicroMsg.WalletOfflineCoinPurseUI", "do click fqf text link");
    WalletOfflineCoinPurseUI.M(this.AMt);
    WalletOfflineCoinPurseUI.N(this.AMt);
    WalletOfflineCoinPurseUI.b(this.AMt, "weixin://wcpay/fqf/opentinyapp");
    a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$35", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(213653);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.29
 * JD-Core Version:    0.7.0.1
 */