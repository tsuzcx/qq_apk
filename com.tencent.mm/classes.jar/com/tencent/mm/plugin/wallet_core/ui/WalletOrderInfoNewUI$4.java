package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.so;
import com.tencent.mm.plugin.wallet_core.model.Orders.ShowInfo;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class WalletOrderInfoNewUI$4
  implements View.OnClickListener
{
  WalletOrderInfoNewUI$4(WalletOrderInfoNewUI paramWalletOrderInfoNewUI, Orders.ShowInfo paramShowInfo) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(142509);
    ab.i("MicroMsg.WalletOrderInfoNewUI", "onClick jump tinyApp, linkWeApp:%s, linkAddr:%s", new Object[] { this.urz.ukC, this.urz.ukD });
    paramView = new so();
    paramView.cIQ.userName = this.urz.ukC;
    paramView.cIQ.cIS = bo.bf(this.urz.ukD, "");
    paramView.cIQ.scene = 1060;
    paramView.cIQ.cmF = WalletOrderInfoNewUI.p(this.ury);
    paramView.cIQ.cIT = 0;
    paramView.cIQ.context = this.ury;
    a.ymk.l(paramView);
    AppMethodBeat.o(142509);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI.4
 * JD-Core Version:    0.7.0.1
 */