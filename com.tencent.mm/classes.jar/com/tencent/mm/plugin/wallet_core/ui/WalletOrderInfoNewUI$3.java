package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet_core.model.Orders.ShowInfo;
import com.tencent.mm.sdk.platformtools.Log;

final class WalletOrderInfoNewUI$3
  implements View.OnClickListener
{
  WalletOrderInfoNewUI$3(WalletOrderInfoNewUI paramWalletOrderInfoNewUI, Orders.ShowInfo paramShowInfo) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(70990);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    Log.i("MicroMsg.WalletOrderInfoNewUI", "onClick showInfo, jump url: %s", new Object[] { this.IhV.Iau });
    this.IhU.ahM(this.IhV.Iau);
    a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(70990);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI.3
 * JD-Core Version:    0.7.0.1
 */