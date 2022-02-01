package com.tencent.mm.plugin.recharge.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.sdk.platformtools.bt;

final class RechargeUI$16
  implements View.OnClickListener
{
  RechargeUI$16(RechargeUI paramRechargeUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(67230);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/recharge/ui/RechargeUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    if (!bt.isNullOrNil(RechargeUI.h(this.xpj).Dbp.Dby))
    {
      paramView = new Intent();
      paramView.putExtra("rawUrl", RechargeUI.h(this.xpj).Dbp.Dby);
      paramView.putExtra("geta8key_username", u.aAm());
      d.b(this.xpj, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramView);
    }
    a.a(this, "com/tencent/mm/plugin/recharge/ui/RechargeUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(67230);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.RechargeUI.16
 * JD-Core Version:    0.7.0.1
 */