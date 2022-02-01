package com.tencent.mm.plugin.wallet.wecoin.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class WeCoinIncomeDetailView$j
  implements View.OnClickListener
{
  WeCoinIncomeDetailView$j(WeCoinIncomeDetailView paramWeCoinIncomeDetailView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(212850);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinIncomeDetailView$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    WeCoinIncomeDetailView.a(this.HPa);
    a.a(this, "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinIncomeDetailView$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(212850);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.ui.WeCoinIncomeDetailView.j
 * JD-Core Version:    0.7.0.1
 */