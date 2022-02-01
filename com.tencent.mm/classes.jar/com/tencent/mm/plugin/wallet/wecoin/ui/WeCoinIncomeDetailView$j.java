package com.tencent.mm.plugin.wallet.wecoin.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.protocal.protobuf.bco;
import com.tencent.mm.wallet_core.ui.g;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class WeCoinIncomeDetailView$j
  implements View.OnClickListener
{
  WeCoinIncomeDetailView$j(WeCoinIncomeDetailView paramWeCoinIncomeDetailView, bco parambco) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(266144);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinIncomeDetailView$initLiveSettlement$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    paramView = new Intent();
    paramView.putExtra("rawUrl", this.OHf.jDP);
    g.aJ((Context)this.OHe, paramView);
    a.a(this, "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinIncomeDetailView$initLiveSettlement$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(266144);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.ui.WeCoinIncomeDetailView.j
 * JD-Core Version:    0.7.0.1
 */