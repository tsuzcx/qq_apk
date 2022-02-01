package com.tencent.mm.plugin.wallet.balance.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet_core.model.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.ui.f;

final class WalletBalanceManagerUI$9
  implements View.OnClickListener
{
  WalletBalanceManagerUI$9(WalletBalanceManagerUI paramWalletBalanceManagerUI, w paramw) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68655);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    Log.i("MicroMsg.WalletBalanceManagerUI", "click freeze layout");
    f.o(this.Hwm.getContext(), this.Hwq.Ibc, true);
    w.aVh("");
    WalletBalanceManagerUI.b(this.Hwm).setVisibility(8);
    a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(68655);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.9
 * JD-Core Version:    0.7.0.1
 */