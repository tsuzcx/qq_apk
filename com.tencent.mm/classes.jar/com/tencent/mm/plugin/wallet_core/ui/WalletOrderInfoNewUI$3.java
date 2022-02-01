package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.wallet_core.ui.g;

final class WalletOrderInfoNewUI$3
  implements View.OnClickListener
{
  WalletOrderInfoNewUI$3(WalletOrderInfoNewUI paramWalletOrderInfoNewUI, String paramString1, String paramString2, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(70990);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    h.IzE.a(22110, new Object[] { Integer.valueOf(1), WalletOrderInfoNewUI.o(this.Pah) });
    g.v(this.iXG, this.val$path, this.pqg, 8);
    a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(70990);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI.3
 * JD-Core Version:    0.7.0.1
 */