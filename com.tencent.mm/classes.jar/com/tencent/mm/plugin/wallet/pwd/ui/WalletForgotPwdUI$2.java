package com.tencent.mm.plugin.wallet.pwd.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.wallet_core.ui.i;
import com.tencent.mm.wallet_core.ui.k;

final class WalletForgotPwdUI$2
  extends k
{
  WalletForgotPwdUI$2(WalletForgotPwdUI paramWalletForgotPwdUI) {}
  
  public final void dr(View paramView)
  {
    AppMethodBeat.i(315615);
    i.p(this.VqP, "https://" + WeChatHosts.domainString(a.i.host_kf_qq_com) + "/touch/scene_product.html?scene_id=kf3258", false);
    AppMethodBeat.o(315615);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdUI.2
 * JD-Core Version:    0.7.0.1
 */