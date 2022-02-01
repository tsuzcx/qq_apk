package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import java.util.HashMap;

final class s$2
  implements View.OnClickListener
{
  s$2(PayInfo paramPayInfo, View.OnClickListener paramOnClickListener, s params) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(71156);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/wallet_core/ui/WalletPwdDialog$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    s.cVT().put(this.wzu.dlu, Boolean.TRUE);
    this.DiW.onClick(paramView);
    if (this.DiX.DiK) {
      g.yhR.f(14530, new Object[] { Integer.valueOf(2) });
    }
    a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletPwdDialog$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(71156);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.s.2
 * JD-Core Version:    0.7.0.1
 */