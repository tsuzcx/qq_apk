package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class WalletSetPasswordUI$1
  implements View.OnClickListener
{
  WalletSetPasswordUI$1(WalletSetPasswordUI paramWalletSetPasswordUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(71232);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/wallet_core/ui/WalletSetPasswordUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    if (this.Djq.needConfirmFinish())
    {
      this.Djq.hideVKB();
      this.Djq.showDialog(1000);
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletSetPasswordUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(71232);
      return;
      this.Djq.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI.1
 * JD-Core Version:    0.7.0.1
 */