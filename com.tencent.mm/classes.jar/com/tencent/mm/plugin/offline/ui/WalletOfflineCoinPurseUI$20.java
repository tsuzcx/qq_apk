package com.tencent.mm.plugin.offline.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.offline.k;

final class WalletOfflineCoinPurseUI$20
  implements View.OnClickListener
{
  WalletOfflineCoinPurseUI$20(WalletOfflineCoinPurseUI paramWalletOfflineCoinPurseUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(66421);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    com.tencent.mm.plugin.offline.c.a.dAK();
    k.dzG();
    k.bz(196648, "0");
    WalletOfflineCoinPurseUI.F(this.wQC);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(66421);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.20
 * JD-Core Version:    0.7.0.1
 */