package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.e.p;
import com.tencent.mm.wallet_core.ui.f;

final class WalletSecuritySettingUI$2
  implements View.OnClickListener
{
  WalletSecuritySettingUI$2(WalletSecuritySettingUI paramWalletSecuritySettingUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(69791);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/wallet/pwd/ui/WalletSecuritySettingUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if ((WalletSecuritySettingUI.d(this.HLl) != null) && (Util.isNullOrNil(WalletSecuritySettingUI.d(this.HLl).HLp)))
    {
      Log.e("MicroMsg.WalletSecuritySettingUI", "alivnluo jump h5 url is null");
      a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletSecuritySettingUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(69791);
      return;
    }
    if ((WalletSecuritySettingUI.d(this.HLl) != null) && (WalletSecuritySettingUI.d(this.HLl).jumpType == 1) && (!Util.isNullOrNil(WalletSecuritySettingUI.d(this.HLl).HLp)))
    {
      paramView = new Intent();
      Log.i("MicroMsg.WalletSecuritySettingUI", "alvinluo jump url: %s", new Object[] { WalletSecuritySettingUI.d(this.HLl).HLp });
      paramView.putExtra("rawUrl", WalletSecuritySettingUI.d(this.HLl).HLp);
      paramView.putExtra(e.p.OzJ, true);
      f.aA(this.HLl.getContext(), paramView);
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletSecuritySettingUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(69791);
      return;
      if ((WalletSecuritySettingUI.d(this.HLl) != null) && (WalletSecuritySettingUI.d(this.HLl).jumpType == 2)) {
        Util.isNullOrNil(WalletSecuritySettingUI.d(this.HLl).HLq);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletSecuritySettingUI.2
 * JD-Core Version:    0.7.0.1
 */