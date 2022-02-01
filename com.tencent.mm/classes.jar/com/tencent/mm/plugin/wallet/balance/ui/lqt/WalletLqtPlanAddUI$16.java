package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

final class WalletLqtPlanAddUI$16
  implements View.OnClickListener
{
  WalletLqtPlanAddUI$16(WalletLqtPlanAddUI paramWalletLqtPlanAddUI, Button paramButton) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68850);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanAddUI$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    WalletLqtPlanAddUI.a(this.CCt).setText(this.xgq.getText().toString().substring(1));
    a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanAddUI$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(68850);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI.16
 * JD-Core Version:    0.7.0.1
 */