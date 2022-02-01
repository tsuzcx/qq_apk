package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class r$3
  implements View.OnClickListener
{
  r$3(r paramr) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(71124);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/wallet_core/ui/WalletPwdCustomDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    if (this.DiL.mKBLayout.isShown()) {
      this.DiL.mKBLayout.setVisibility(8);
    }
    a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletPwdCustomDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(71124);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.r.3
 * JD-Core Version:    0.7.0.1
 */