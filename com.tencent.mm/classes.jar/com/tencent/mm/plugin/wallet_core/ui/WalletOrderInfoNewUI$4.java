package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.findersdk.a.ag;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.sdk.platformtools.Log;

final class WalletOrderInfoNewUI$4
  implements View.OnClickListener
{
  WalletOrderInfoNewUI$4(WalletOrderInfoNewUI paramWalletOrderInfoNewUI, int paramInt, String paramString1, String paramString2, String paramString3) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(70991);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    com.tencent.mm.plugin.report.service.h.IzE.a(22110, new Object[] { Integer.valueOf(1), WalletOrderInfoNewUI.o(this.Pah) });
    switch (this.Pai)
    {
    default: 
      Log.i("MicroMsg.WalletOrderInfoNewUI", "finder_uri_feedid：%s，finder_uri_nonceid：%s", new Object[] { this.Pak, this.Pal });
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(70991);
      return;
      Log.i("MicroMsg.WalletOrderInfoNewUI", "finder_uri_username：%s, mTransactionId:%s", new Object[] { this.Paj, WalletOrderInfoNewUI.o(this.Pah) });
      ((ak)com.tencent.mm.kernel.h.ag(ak.class)).getFinderUtilApi().aM(this.Pah, this.Paj);
      continue;
      Log.i("MicroMsg.WalletOrderInfoNewUI", "finder_uri_feedid：%s，finder_uri_nonceid：%s，mTransactionId:%s ", new Object[] { this.Pak, this.Pal, WalletOrderInfoNewUI.o(this.Pah) });
      ((ak)com.tencent.mm.kernel.h.ag(ak.class)).getFinderUtilApi().F(this.Pah, this.Pak, this.Pal);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI.4
 * JD-Core Version:    0.7.0.1
 */