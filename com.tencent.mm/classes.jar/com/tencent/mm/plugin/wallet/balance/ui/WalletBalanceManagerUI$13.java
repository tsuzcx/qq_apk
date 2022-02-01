package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.ui.e.p;
import com.tencent.mm.wallet_core.ui.f;

final class WalletBalanceManagerUI$13
  implements View.OnClickListener
{
  WalletBalanceManagerUI$13(WalletBalanceManagerUI paramWalletBalanceManagerUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68659);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    paramView = new Intent();
    paramView.putExtra("rawUrl", WalletBalanceManagerUI.access$500());
    paramView.putExtra("showShare", false);
    paramView.putExtra("geta8key_username", z.aTY());
    paramView.putExtra(e.p.OzJ, true);
    f.aA(this.Hwm.getContext(), paramView);
    f.aqm(17);
    a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(68659);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.13
 * JD-Core Version:    0.7.0.1
 */