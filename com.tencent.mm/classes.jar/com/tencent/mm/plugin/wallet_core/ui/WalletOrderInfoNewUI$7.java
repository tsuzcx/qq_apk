package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.ui.i;

final class WalletOrderInfoNewUI$7
  implements View.OnClickListener
{
  WalletOrderInfoNewUI$7(WalletOrderInfoNewUI paramWalletOrderInfoNewUI, String paramString) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(301318);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    Log.i("MicroMsg.WalletOrderInfoNewUI", "leadViewInfo h5 url：%s，mTransactionId：%s", new Object[] { this.VQE, WalletOrderInfoNewUI.o(this.VQz) });
    i.o(this.VQz, this.VQE, true);
    a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(301318);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI.7
 * JD-Core Version:    0.7.0.1
 */