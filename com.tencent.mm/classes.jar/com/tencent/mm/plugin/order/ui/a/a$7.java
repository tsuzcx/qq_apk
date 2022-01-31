package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject.HelpCenter;
import com.tencent.mm.plugin.order.model.MallTransactionObject;

final class a$7
  implements View.OnClickListener
{
  a$7(a parama, Context paramContext, MallTransactionObject paramMallTransactionObject) {}
  
  public final void onClick(View paramView)
  {
    if (paramView.getTag() == null) {}
    while (!(paramView.getTag() instanceof MallOrderDetailObject.HelpCenter)) {
      return;
    }
    paramView = (MallOrderDetailObject.HelpCenter)paramView.getTag();
    a.a(this.val$context, paramView.url, this.mOH);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.a.7
 * JD-Core Version:    0.7.0.1
 */