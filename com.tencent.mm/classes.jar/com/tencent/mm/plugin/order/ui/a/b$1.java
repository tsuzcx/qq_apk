package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.wallet_core.ui.f;

final class b$1
  implements View.OnClickListener
{
  b$1(b paramb, MallTransactionObject paramMallTransactionObject, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(66802);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/order/ui/preference/FetchOrderPrefFactory$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    if (!bu.isNullOrNil(this.wRY.wSr)) {
      f.ae(this.val$context, this.wRY.wSr);
    }
    a.a(this, "com/tencent/mm/plugin/order/ui/preference/FetchOrderPrefFactory$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(66802);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.b.1
 * JD-Core Version:    0.7.0.1
 */