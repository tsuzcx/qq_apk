package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class n$1
  implements View.OnClickListener
{
  n$1(n paramn) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(70940);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/wallet_core/ui/WalletFavorDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    n.a(this.IgQ);
    this.IgQ.dismiss();
    a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletFavorDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(70940);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.n.1
 * JD-Core Version:    0.7.0.1
 */