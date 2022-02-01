package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet_core.model.Orders.DeductShowInfo;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.f;

final class WalletPayDeductUI$4
  implements View.OnClickListener
{
  WalletPayDeductUI$4(WalletPayDeductUI paramWalletPayDeductUI, Orders.DeductShowInfo paramDeductShowInfo) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(69373);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/wallet/pay/ui/WalletPayDeductUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    Log.i("MicroMsg.WalletPayDeductUI", "click link_type: %s", new Object[] { Integer.valueOf(this.HGO.gTx) });
    if (this.HGO.gTx == 1) {
      if (!Util.isNullOrNil(this.HGO.HZX))
      {
        paramView = new Intent();
        paramView.putExtra("rawUrl", this.HGO.HZX);
        paramView.putExtra("showShare", false);
        f.aA(this.HGL.getContext(), paramView);
      }
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/wallet/pay/ui/WalletPayDeductUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(69373);
      return;
      if (this.HGO.gTx == 2)
      {
        paramView = new wq();
        paramView.ecI.userName = this.HGO.HZV;
        paramView.ecI.ecK = Util.nullAs(this.HGO.HZW, "");
        paramView.ecI.scene = 1097;
        paramView.ecI.ecL = 0;
        EventCenter.instance.publish(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayDeductUI.4
 * JD-Core Version:    0.7.0.1
 */