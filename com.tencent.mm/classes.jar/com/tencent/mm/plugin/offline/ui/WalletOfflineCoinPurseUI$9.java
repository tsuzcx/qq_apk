package com.tencent.mm.plugin.offline.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.g;

final class WalletOfflineCoinPurseUI$9
  implements View.OnClickListener
{
  WalletOfflineCoinPurseUI$9(WalletOfflineCoinPurseUI paramWalletOfflineCoinPurseUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(66410);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    g.yxI.f(14515, new Object[] { Integer.valueOf(1) });
    WalletOfflineCoinPurseUI.n(this.wQC);
    a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(66410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.9
 * JD-Core Version:    0.7.0.1
 */