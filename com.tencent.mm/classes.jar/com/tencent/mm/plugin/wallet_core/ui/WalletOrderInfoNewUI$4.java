package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet_core.model.Orders.ShowInfo;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

final class WalletOrderInfoNewUI$4
  implements View.OnClickListener
{
  WalletOrderInfoNewUI$4(WalletOrderInfoNewUI paramWalletOrderInfoNewUI, Orders.ShowInfo paramShowInfo) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(70991);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    Log.i("MicroMsg.WalletOrderInfoNewUI", "onClick jump tinyApp, linkWeApp:%s, linkAddr:%s", new Object[] { this.IhV.Ias, this.IhV.Iat });
    paramView = new wq();
    paramView.ecI.userName = this.IhV.Ias;
    paramView.ecI.ecK = Util.nullAs(this.IhV.Iat, "");
    paramView.ecI.scene = 1060;
    paramView.ecI.dCw = WalletOrderInfoNewUI.q(this.IhU);
    paramView.ecI.ecL = 0;
    paramView.ecI.context = this.IhU;
    EventCenter.instance.publish(paramView);
    a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(70991);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI.4
 * JD-Core Version:    0.7.0.1
 */