package com.tencent.mm.plugin.wallet.bind.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Util;

final class WalletBankcardManageUI$8
  implements View.OnClickListener
{
  WalletBankcardManageUI$8(WalletBankcardManageUI paramWalletBankcardManageUI, com.tencent.mm.plugin.wallet_core.model.f paramf) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(69108);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardManageUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if (!Util.isNullOrNil(this.HDy.HWj))
    {
      com.tencent.mm.wallet_core.ui.f.o(this.HDv.getContext(), this.HDy.HWj, false);
      h.CyF.a(14422, new Object[] { Integer.valueOf(6) });
    }
    a.a(this, "com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardManageUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(69108);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI.8
 * JD-Core Version:    0.7.0.1
 */