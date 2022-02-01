package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class WalletCardImportUI$3
  implements View.OnClickListener
{
  WalletCardImportUI$3(WalletCardImportUI paramWalletCardImportUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(70830);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardImportUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    this.IfE.showDialog(1);
    a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardImportUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(70830);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCardImportUI.3
 * JD-Core Version:    0.7.0.1
 */