package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class r$2
  implements View.OnClickListener
{
  r$2(r paramr) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(71123);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/wallet_core/ui/WalletPwdCustomDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    if (!this.DiL.mKBLayout.isShown()) {
      this.DiL.mKBLayout.setVisibility(0);
    }
    a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletPwdCustomDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(71123);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.r.2
 * JD-Core Version:    0.7.0.1
 */