package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.g;

final class WalletBankcardIdUI$3
  implements View.OnClickListener
{
  WalletBankcardIdUI$3(WalletBankcardIdUI paramWalletBankcardIdUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(70724);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/wallet_core/ui/WalletBankcardIdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    g.yhR.f(11353, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
    this.DcG.aUj();
    a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletBankcardIdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(70724);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI.3
 * JD-Core Version:    0.7.0.1
 */