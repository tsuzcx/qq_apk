package com.tencent.mm.plugin.recharge.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class RechargeUI$11
  implements View.OnClickListener
{
  RechargeUI$11(RechargeUI paramRechargeUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(67225);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/recharge/ui/RechargeUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    paramView = new Intent();
    paramView.putExtra("rawUrl", RechargeUI.a(this.BFe));
    c.b(this.BFe, "webview", ".ui.tools.WebViewUI", paramView);
    a.a(this, "com/tencent/mm/plugin/recharge/ui/RechargeUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(67225);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.RechargeUI.11
 * JD-Core Version:    0.7.0.1
 */