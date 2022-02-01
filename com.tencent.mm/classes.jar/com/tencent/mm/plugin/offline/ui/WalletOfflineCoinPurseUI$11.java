package com.tencent.mm.plugin.offline.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;

final class WalletOfflineCoinPurseUI$11
  implements View.OnClickListener
{
  WalletOfflineCoinPurseUI$11(WalletOfflineCoinPurseUI paramWalletOfflineCoinPurseUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(184848);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    Log.i("MicroMsg.WalletOfflineCoinPurseUI", "click change_bankcard_layout() card：%s", new Object[] { WalletOfflineCoinPurseUI.b(this.AMt) });
    h.CyF.a(14515, new Object[] { Integer.valueOf(1) });
    WalletOfflineCoinPurseUI.p(this.AMt);
    WalletOfflineCoinPurseUI.q(this.AMt);
    a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(184848);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.11
 * JD-Core Version:    0.7.0.1
 */