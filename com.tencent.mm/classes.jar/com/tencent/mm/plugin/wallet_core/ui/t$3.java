package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class t$3
  implements View.OnClickListener
{
  t$3(t paramt) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(71124);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/wallet_core/ui/WalletPwdCustomDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if (this.VSy.mKBLayout.isShown()) {
      this.VSy.mKBLayout.setVisibility(8);
    }
    a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletPwdCustomDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(71124);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.t.3
 * JD-Core Version:    0.7.0.1
 */