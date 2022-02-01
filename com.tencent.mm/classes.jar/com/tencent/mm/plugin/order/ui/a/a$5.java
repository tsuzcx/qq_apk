package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;
import java.util.LinkedList;
import java.util.List;

final class a$5
  implements View.OnClickListener
{
  a$5(a parama, MallTransactionObject paramMallTransactionObject, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(66797);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/order/ui/preference/DefaultOrderPrefFactory$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
    paramView = new LinkedList();
    localObject = new LinkedList();
    if (!bt.isNullOrNil(this.wCn.wCG))
    {
      ((List)localObject).add(Integer.valueOf(0));
      paramView.add(this.val$context.getString(2131765579));
    }
    if (!bt.isNullOrNil(this.wCn.wCj))
    {
      ((List)localObject).add(Integer.valueOf(1));
      paramView.add(this.val$context.getString(2131765580));
    }
    if (!bt.isNullOrNil(this.wCn.wCP))
    {
      ((List)localObject).add(Integer.valueOf(2));
      paramView.add(this.val$context.getString(2131765582));
    }
    if (((List)localObject).size() == 1)
    {
      com.tencent.mm.plugin.order.model.a.a(((Integer)((List)localObject).get(0)).intValue(), this.val$context, this.wCn);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/order/ui/preference/DefaultOrderPrefFactory$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(66797);
      return;
    }
    h.b(this.val$context, null, paramView, (List)localObject, null, new h.d()
    {
      public final void cv(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(66796);
        com.tencent.mm.plugin.order.model.a.a(paramAnonymousInt2, a.5.this.val$context, a.5.this.wCn);
        AppMethodBeat.o(66796);
      }
    });
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/order/ui/preference/DefaultOrderPrefFactory$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(66797);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.a.5
 * JD-Core Version:    0.7.0.1
 */