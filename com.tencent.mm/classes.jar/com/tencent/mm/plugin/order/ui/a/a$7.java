package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject.HelpCenter;
import com.tencent.mm.plugin.order.model.MallTransactionObject;

final class a$7
  implements View.OnClickListener
{
  a$7(a parama, Context paramContext, MallTransactionObject paramMallTransactionObject) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(43892);
    if (paramView.getTag() == null)
    {
      AppMethodBeat.o(43892);
      return;
    }
    if ((paramView.getTag() instanceof MallOrderDetailObject.HelpCenter))
    {
      paramView = (MallOrderDetailObject.HelpCenter)paramView.getTag();
      a.a(this.val$context, paramView.url, this.poX);
    }
    AppMethodBeat.o(43892);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.a.7
 * JD-Core Version:    0.7.0.1
 */