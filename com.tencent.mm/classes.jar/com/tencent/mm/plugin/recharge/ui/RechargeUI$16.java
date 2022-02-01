package com.tencent.mm.plugin.recharge.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.sdk.platformtools.Util;

final class RechargeUI$16
  implements View.OnClickListener
{
  RechargeUI$16(RechargeUI paramRechargeUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(67230);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/recharge/ui/RechargeUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    if (!Util.isNullOrNil(RechargeUI.h(this.HBi).OUr.OUA))
    {
      paramView = new Intent();
      paramView.putExtra("rawUrl", RechargeUI.h(this.HBi).OUr.OUA);
      paramView.putExtra("geta8key_username", z.bcZ());
      c.b(this.HBi, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramView);
    }
    a.a(this, "com/tencent/mm/plugin/recharge/ui/RechargeUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(67230);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.RechargeUI.16
 * JD-Core Version:    0.7.0.1
 */