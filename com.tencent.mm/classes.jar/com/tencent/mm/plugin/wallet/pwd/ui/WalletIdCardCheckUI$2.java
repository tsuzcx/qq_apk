package com.tencent.mm.plugin.wallet.pwd.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.h.b.a.aa;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.wallet_core.c.l;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

final class WalletIdCardCheckUI$2
  implements View.OnClickListener
{
  WalletIdCardCheckUI$2(WalletIdCardCheckUI paramWalletIdCardCheckUI) {}
  
  public final void onClick(View paramView)
  {
    if (WalletIdCardCheckUI.a(this.qpp))
    {
      paramView = new aa();
      paramView.ckr = 1L;
      paramView.cks = 1L;
      paramView.QX();
      h.nFQ.f(13731, new Object[] { Integer.valueOf(2) });
      paramView = new l(WalletIdCardCheckUI.b(this.qpp).getText(), WalletIdCardCheckUI.c(this.qpp), o.bVs().aEZ());
      this.qpp.a(paramView, true, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletIdCardCheckUI.2
 * JD-Core Version:    0.7.0.1
 */