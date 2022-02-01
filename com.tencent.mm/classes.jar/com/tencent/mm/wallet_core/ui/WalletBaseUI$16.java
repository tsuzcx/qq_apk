package com.tencent.mm.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class WalletBaseUI$16
  implements View.OnClickListener
{
  WalletBaseUI$16(WalletBaseUI paramWalletBaseUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(72977);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/wallet_core/ui/WalletBaseUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    this.agUX.showNormalStWcKb();
    a.a(this, "com/tencent/mm/wallet_core/ui/WalletBaseUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(72977);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.WalletBaseUI.16
 * JD-Core Version:    0.7.0.1
 */