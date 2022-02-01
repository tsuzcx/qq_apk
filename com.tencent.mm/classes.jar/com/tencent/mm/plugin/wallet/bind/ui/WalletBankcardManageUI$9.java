package com.tencent.mm.plugin.wallet.bind.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.f;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Util;

final class WalletBankcardManageUI$9
  implements View.OnClickListener
{
  WalletBankcardManageUI$9(WalletBankcardManageUI paramWalletBankcardManageUI, f paramf) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(69109);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardManageUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    paramView = new wq();
    paramView.ecI.userName = this.HDy.HWk;
    paramView.ecI.ecK = Util.nullAs(this.HDy.HWl, "");
    paramView.ecI.scene = 1071;
    paramView.ecI.ecL = 0;
    EventCenter.instance.publish(paramView);
    h.CyF.a(14422, new Object[] { Integer.valueOf(6) });
    a.a(this, "com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardManageUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(69109);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI.9
 * JD-Core Version:    0.7.0.1
 */