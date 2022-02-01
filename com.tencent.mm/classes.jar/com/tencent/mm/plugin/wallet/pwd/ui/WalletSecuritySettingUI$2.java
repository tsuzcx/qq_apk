package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.e.m;
import com.tencent.mm.wallet_core.ui.e;

final class WalletSecuritySettingUI$2
  implements View.OnClickListener
{
  WalletSecuritySettingUI$2(WalletSecuritySettingUI paramWalletSecuritySettingUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(69791);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/wallet/pwd/ui/WalletSecuritySettingUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    if ((WalletSecuritySettingUI.a(this.CNK) != null) && (bt.isNullOrNil(WalletSecuritySettingUI.a(this.CNK).CNO)))
    {
      ad.e("MicroMsg.WalletSecuritySettingUI", "alivnluo jump h5 url is null");
      a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletSecuritySettingUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(69791);
      return;
    }
    if ((WalletSecuritySettingUI.a(this.CNK) != null) && (WalletSecuritySettingUI.a(this.CNK).jumpType == 1) && (!bt.isNullOrNil(WalletSecuritySettingUI.a(this.CNK).CNO)))
    {
      paramView = new Intent();
      ad.i("MicroMsg.WalletSecuritySettingUI", "alvinluo jump url: %s", new Object[] { WalletSecuritySettingUI.a(this.CNK).CNO });
      paramView.putExtra("rawUrl", WalletSecuritySettingUI.a(this.CNK).CNO);
      paramView.putExtra(e.m.IVa, true);
      e.an(this.CNK.getContext(), paramView);
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletSecuritySettingUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(69791);
      return;
      if ((WalletSecuritySettingUI.a(this.CNK) != null) && (WalletSecuritySettingUI.a(this.CNK).jumpType == 2)) {
        bt.isNullOrNil(WalletSecuritySettingUI.a(this.CNK).CNP);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletSecuritySettingUI.2
 * JD-Core Version:    0.7.0.1
 */