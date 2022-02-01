package com.tencent.mm.plugin.wallet.pwd.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class WalletForgotPwdUI$6
  implements View.OnClickListener
{
  WalletForgotPwdUI$6(WalletForgotPwdUI paramWalletForgotPwdUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(69656);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/wallet/pwd/ui/WalletForgotPwdUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    WalletForgotPwdUI.a(this.CMg, true);
    WalletForgotPwdUI.a(this.CMg);
    a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletForgotPwdUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(69656);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdUI.6
 * JD-Core Version:    0.7.0.1
 */