package com.tencent.mm.plugin.wallet.bind.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.zp;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.f;
import com.tencent.mm.sdk.platformtools.Util;

final class WalletBankcardManageUI$4
  implements View.OnClickListener
{
  WalletBankcardManageUI$4(WalletBankcardManageUI paramWalletBankcardManageUI, f paramf) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(315564);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardManageUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    paramView = new zp();
    paramView.icM.userName = this.VkD.VEe;
    paramView.icM.icO = Util.nullAs(this.VkD.VEf, "");
    paramView.icM.scene = 1071;
    paramView.icM.icP = 0;
    paramView.publish();
    h.OAn.b(14422, new Object[] { Integer.valueOf(6) });
    a.a(this, "com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardManageUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(315564);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI.4
 * JD-Core Version:    0.7.0.1
 */