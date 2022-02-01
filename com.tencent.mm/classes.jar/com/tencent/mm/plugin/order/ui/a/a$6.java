package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.order.model.MallTransactionObject;

final class a$6
  implements View.OnClickListener
{
  a$6(a parama, Context paramContext, MallTransactionObject paramMallTransactionObject) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(66798);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/order/ui/preference/DefaultOrderPrefFactory$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    a.a(this.val$context, this.wRY.wSA, this.wRY);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/order/ui/preference/DefaultOrderPrefFactory$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(66798);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.a.6
 * JD-Core Version:    0.7.0.1
 */