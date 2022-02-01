package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.ui.i;

final class WalletOrderInfoNewUI$8
  implements View.OnClickListener
{
  WalletOrderInfoNewUI$8(WalletOrderInfoNewUI paramWalletOrderInfoNewUI, String paramString1, String paramString2, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(301320);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    Log.i("MicroMsg.WalletOrderInfoNewUI", "leadViewInfo click app username：%s，path：%s，version：%s ,mTransactionId：%s", new Object[] { this.VQF, this.VQG, Integer.valueOf(this.VQH), WalletOrderInfoNewUI.o(this.VQz) });
    i.y(this.VQF, this.VQG, this.VQH, 8);
    a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(301320);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI.8
 * JD-Core Version:    0.7.0.1
 */