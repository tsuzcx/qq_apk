package com.tencent.mm.plugin.order.ui.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.order.model.MallTransactionObject;

final class b$2
  implements View.OnClickListener
{
  b$2(b paramb, MallTransactionObject paramMallTransactionObject, f paramf, com.tencent.mm.ui.base.preference.f paramf1) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(66803);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/order/ui/preference/FetchOrderPrefFactory$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    paramView = this.GHh.desc + "\n" + this.GHh.GHp;
    this.GJE.setContent(paramView);
    this.qTL.notifyDataSetChanged();
    a.a(this, "com/tencent/mm/plugin/order/ui/preference/FetchOrderPrefFactory$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(66803);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.b.2
 * JD-Core Version:    0.7.0.1
 */