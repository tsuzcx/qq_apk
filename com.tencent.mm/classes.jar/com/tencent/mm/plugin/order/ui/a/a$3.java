package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.ui.base.h;

final class a$3
  implements View.OnClickListener
{
  a$3(a parama, Context paramContext, MallTransactionObject paramMallTransactionObject) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(43887);
    h.d(this.val$context, this.val$context.getString(2131302539), this.val$context.getString(2131297056), this.val$context.getString(2131302613), this.val$context.getString(2131296888), new a.3.1(this), new a.3.2(this));
    AppMethodBeat.o(43887);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.a.3
 * JD-Core Version:    0.7.0.1
 */