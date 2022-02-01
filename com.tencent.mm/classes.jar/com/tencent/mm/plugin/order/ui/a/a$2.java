package com.tencent.mm.plugin.order.ui.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.order.model.MallTransactionObject;

final class a$2
  implements View.OnClickListener
{
  a$2(a parama, MallTransactionObject paramMallTransactionObject, f paramf, com.tencent.mm.ui.base.preference.f paramf1) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(66792);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/order/ui/preference/DefaultOrderPrefFactory$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    paramView = this.wCn.desc + "\n" + this.wCn.wCv;
    this.wEM.setContent(paramView);
    this.mAu.notifyDataSetChanged();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/order/ui/preference/DefaultOrderPrefFactory$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(66792);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.a.2
 * JD-Core Version:    0.7.0.1
 */