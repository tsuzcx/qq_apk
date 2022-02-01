package com.tencent.mm.plugin.wallet.bind.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.wallet_core.ui.f;

final class WalletBankcardManageUI$6
  implements View.OnClickListener
{
  WalletBankcardManageUI$6(WalletBankcardManageUI paramWalletBankcardManageUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(69106);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardManageUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    this.HDv.fOa();
    f.aqm(19);
    h.CyF.a(14422, new Object[] { Integer.valueOf(2) });
    a.a(this, "com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardManageUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(69106);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI.6
 * JD-Core Version:    0.7.0.1
 */