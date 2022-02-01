package com.tencent.mm.plugin.wallet.pwd.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.wallet_core.ui.e;

final class WalletForgotPwdUI$2
  implements View.OnClickListener
{
  WalletForgotPwdUI$2(WalletForgotPwdUI paramWalletForgotPwdUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(69652);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/wallet/pwd/ui/WalletForgotPwdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    e.o(this.CMg, "https://kf.qq.com/touch/scene_product.html?scene_id=kf3258", false);
    a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletForgotPwdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(69652);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdUI.2
 * JD-Core Version:    0.7.0.1
 */