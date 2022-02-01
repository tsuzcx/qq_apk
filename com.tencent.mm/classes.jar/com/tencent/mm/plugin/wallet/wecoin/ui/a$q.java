package com.tencent.mm.plugin.wallet.wecoin.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet.wecoin.model.f;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$updateCheckBox$1$1"})
final class a$q
  implements View.OnClickListener
{
  a$q(CheckBox paramCheckBox, a parama, Integer paramInteger) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(273504);
    b localb = new b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$updateCheckBox$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    paramView = this.OGr;
    p.j(paramView, "agreementCheckBox");
    if (paramView.isChecked())
    {
      paramView = this.OGr;
      p.j(paramView, "agreementCheckBox");
      paramView.setChecked(false);
      a.d(this.OGh).amu(4);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$updateCheckBox$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(273504);
      return;
    }
    paramView = this.OGr;
    p.j(paramView, "agreementCheckBox");
    paramView.setChecked(true);
    a.d(this.OGh).amu(3);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$updateCheckBox$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(273504);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.ui.a.q
 * JD-Core Version:    0.7.0.1
 */