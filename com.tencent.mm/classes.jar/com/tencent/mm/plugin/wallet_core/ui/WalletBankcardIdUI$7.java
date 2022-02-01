package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.id_verify.model.RealNameBundle;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.ui.e;

final class WalletBankcardIdUI$7
  implements View.OnClickListener
{
  WalletBankcardIdUI$7(WalletBankcardIdUI paramWalletBankcardIdUI, RealNameBundle paramRealNameBundle) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(70728);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/wallet_core/ui/WalletBankcardIdUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    g.yhR.f(11353, new Object[] { Integer.valueOf(2), Integer.valueOf(0) });
    if ((WalletBankcardIdUI.d(this.DcG)) && (this.DcH != null) && (!bt.isNullOrNil(this.DcH.CTa))) {}
    for (paramView = this.DcH.CTa;; paramView = t.eFy().getTrueName())
    {
      e.d(this.DcG, paramView);
      a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletBankcardIdUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(70728);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI.7
 * JD-Core Version:    0.7.0.1
 */