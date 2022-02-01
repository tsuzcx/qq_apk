package com.tencent.mm.plugin.wallet.pwd.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;

final class WalletSecuritySettingUI$3
  implements View.OnClickListener
{
  WalletSecuritySettingUI$3(WalletSecuritySettingUI paramWalletSecuritySettingUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(69792);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/wallet/pwd/ui/WalletSecuritySettingUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    Log.v("MicroMsg.WalletSecuritySettingUI", "alvinluo click close");
    this.HLl.finish();
    a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletSecuritySettingUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(69792);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletSecuritySettingUI.3
 * JD-Core Version:    0.7.0.1
 */