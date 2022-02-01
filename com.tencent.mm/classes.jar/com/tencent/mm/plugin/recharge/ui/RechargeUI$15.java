package com.tencent.mm.plugin.recharge.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.sdk.platformtools.Util;

final class RechargeUI$15
  implements View.OnClickListener
{
  RechargeUI$15(RechargeUI paramRechargeUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(67230);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/recharge/ui/RechargeUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if (!Util.isNullOrNil(RechargeUI.h(this.NyL).VKI.VKR))
    {
      paramView = new Intent();
      paramView.putExtra("rawUrl", RechargeUI.h(this.NyL).VKI.VKR);
      paramView.putExtra("geta8key_username", z.bAM());
      c.b(this.NyL, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramView);
    }
    a.a(this, "com/tencent/mm/plugin/recharge/ui/RechargeUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(67230);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.RechargeUI.15
 * JD-Core Version:    0.7.0.1
 */