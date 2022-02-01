package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.g;
import com.tenpay.bankcard.TenpaySegmentEditText;

final class WalletConfirmCardIDUI$3
  implements View.OnClickListener
{
  WalletConfirmCardIDUI$3(WalletConfirmCardIDUI paramWalletConfirmCardIDUI, String paramString) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(70932);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/wallet_core/ui/WalletConfirmCardIDUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    paramView = WalletConfirmCardIDUI.f(this.DfV).get3DesEncrptData();
    if ((paramView != null) && (paramView.equals(this.DfW))) {
      g.yhR.f(11353, new Object[] { Integer.valueOf(0), Integer.valueOf(1) });
    }
    for (;;)
    {
      WalletConfirmCardIDUI.g(this.DfV);
      a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletConfirmCardIDUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(70932);
      return;
      g.yhR.f(11353, new Object[] { Integer.valueOf(0), Integer.valueOf(2) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletConfirmCardIDUI.3
 * JD-Core Version:    0.7.0.1
 */