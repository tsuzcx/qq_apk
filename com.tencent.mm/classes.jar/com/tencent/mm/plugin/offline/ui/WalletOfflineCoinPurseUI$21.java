package com.tencent.mm.plugin.offline.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;

final class WalletOfflineCoinPurseUI$21
  implements View.OnClickListener
{
  WalletOfflineCoinPurseUI$21(WalletOfflineCoinPurseUI paramWalletOfflineCoinPurseUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(66422);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$28", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    com.tencent.mm.plugin.offline.c.a.j(this.wQC, WalletOfflineCoinPurseUI.b(this.wQC));
    this.wQC.finish();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$28", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(66422);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.21
 * JD-Core Version:    0.7.0.1
 */