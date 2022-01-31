package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.Date;

final class WalletBankcardManageUI$8
  implements View.OnClickListener
{
  final int tTn = 1000;
  
  WalletBankcardManageUI$8(WalletBankcardManageUI paramWalletBankcardManageUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(45770);
    if (paramView.getId() == 2131829017)
    {
      paramView = i.cTp();
      if (paramView.Pk())
      {
        com.tencent.mm.ui.base.h.b(this.tTk, paramView.pot, this.tTk.getString(2131297087), true);
        AppMethodBeat.o(45770);
        return;
      }
      com.tencent.mm.wallet_core.ui.e.RX(19);
      this.tTk.cRA();
      com.tencent.mm.plugin.report.service.h.qsU.e(14422, new Object[] { Integer.valueOf(2) });
      AppMethodBeat.o(45770);
      return;
    }
    if (paramView.getId() == 2131829023)
    {
      Object localObject = paramView.getTag();
      long l = new Date().getTime();
      paramView.setTag(Long.valueOf(l));
      if ((localObject != null) && (l - ((Long)localObject).longValue() < 1000L))
      {
        AppMethodBeat.o(45770);
        return;
      }
      paramView = new Intent();
      paramView.putExtra("rawUrl", WalletBankcardManageUI.a(this.tTk).field_loan_jump_url);
      d.b(this.tTk, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramView);
      g.RM();
      g.RL().Ru().set(ac.a.yAU, Integer.valueOf(WalletBankcardManageUI.a(this.tTk).field_red_dot_index));
      com.tencent.mm.wallet_core.ui.e.RX(6);
      AppMethodBeat.o(45770);
      return;
    }
    if (paramView.getId() == 2131829028)
    {
      paramView = new Intent();
      paramView.putExtra("rawUrl", "https://kf.qq.com/touch/product/weixinpay_app.html?platform=15&ADTAG=veda.weixinpay.wenti");
      d.b(this.tTk, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramView);
      com.tencent.mm.plugin.report.service.h.qsU.e(14422, new Object[] { Integer.valueOf(3) });
    }
    AppMethodBeat.o(45770);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI.8
 * JD-Core Version:    0.7.0.1
 */