package com.tencent.mm.plugin.wallet.pwd.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ad;

final class WalletLockCheckPwdUI$2
  implements View.OnClickListener
{
  WalletLockCheckPwdUI$2(WalletLockCheckPwdUI paramWalletLockCheckPwdUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(69714);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/wallet/pwd/ui/WalletLockCheckPwdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    ad.i("MicroMsg.WalletLockCheckPwdUI", "alvinluo cancel by BackBtn");
    WalletLockCheckPwdUI.a(this.CMF);
    a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletLockCheckPwdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(69714);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletLockCheckPwdUI.2
 * JD-Core Version:    0.7.0.1
 */