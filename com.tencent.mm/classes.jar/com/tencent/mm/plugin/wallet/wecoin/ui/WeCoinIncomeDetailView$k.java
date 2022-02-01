package com.tencent.mm.plugin.wallet.wecoin.ui;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.z;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class WeCoinIncomeDetailView$k
  implements View.OnClickListener
{
  WeCoinIncomeDetailView$k(WeCoinIncomeDetailView paramWeCoinIncomeDetailView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(263777);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinIncomeDetailView$initLiveTaskEntrance$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    paramView = (com.tencent.c.a.a.a.b)com.tencent.mm.kernel.h.ag(com.tencent.c.a.a.a.b.class);
    if (paramView != null) {
      paramView.enterLiveTaskPage((Activity)this.OHe, 2);
    }
    com.tencent.mm.plugin.report.service.h.IzE.a(22748, new Object[] { Integer.valueOf(2), Integer.valueOf(2), Long.valueOf(cm.bfE()), z.bdh() });
    a.a(this, "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinIncomeDetailView$initLiveTaskEntrance$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(263777);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.ui.WeCoinIncomeDetailView.k
 * JD-Core Version:    0.7.0.1
 */