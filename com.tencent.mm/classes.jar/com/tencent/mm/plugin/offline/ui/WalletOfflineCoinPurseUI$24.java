package com.tencent.mm.plugin.offline.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;

final class WalletOfflineCoinPurseUI$24
  implements View.OnClickListener
{
  WalletOfflineCoinPurseUI$24(WalletOfflineCoinPurseUI paramWalletOfflineCoinPurseUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(174394);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$30", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    com.tencent.mm.plugin.offline.c.a.dAK();
    com.tencent.mm.plugin.offline.c.a.k(this.wQC, WalletOfflineCoinPurseUI.b(this.wQC));
    this.wQC.finish();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$30", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(174394);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.24
 * JD-Core Version:    0.7.0.1
 */