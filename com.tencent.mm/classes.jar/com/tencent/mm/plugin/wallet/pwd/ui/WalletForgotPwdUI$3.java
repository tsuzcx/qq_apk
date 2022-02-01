package com.tencent.mm.plugin.wallet.pwd.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.wallet_core.ui.e;

final class WalletForgotPwdUI$3
  implements View.OnClickListener
{
  WalletForgotPwdUI$3(WalletForgotPwdUI paramWalletForgotPwdUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(69653);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/wallet/pwd/ui/WalletForgotPwdUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    g.yhR.f(11353, new Object[] { Integer.valueOf(2), Integer.valueOf(0) });
    paramView = this.CMg;
    s.eDp();
    e.d(paramView, s.eDq().getTrueName());
    a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletForgotPwdUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(69653);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdUI.3
 * JD-Core Version:    0.7.0.1
 */