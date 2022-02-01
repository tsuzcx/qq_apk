package com.tencent.mm.plugin.wallet.pwd.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.wallet_core.ui.f;

final class WalletForgotPwdVerifyIdUI$2
  implements View.OnClickListener
{
  WalletForgotPwdVerifyIdUI$2(WalletForgotPwdVerifyIdUI paramWalletForgotPwdVerifyIdUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(69683);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/wallet/pwd/ui/WalletForgotPwdVerifyIdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    f.p(this.HJX, "https://" + WeChatHosts.domainString(2131761715) + "/touch/scene_product.html?scene_id=kf3258", false);
    a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletForgotPwdVerifyIdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(69683);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdVerifyIdUI.2
 * JD-Core Version:    0.7.0.1
 */