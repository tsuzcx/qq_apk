package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.h;

final class a$3
  implements View.OnClickListener
{
  a$3(a parama, Context paramContext, MallTransactionObject paramMallTransactionObject) {}
  
  public final void onClick(View paramView)
  {
    h.a(this.val$context, this.val$context.getString(a.i.remittance_confirm_resend_msg), this.val$context.getString(a.i.app_remind), this.val$context.getString(a.i.remittance_resend), this.val$context.getString(a.i.app_cancel), new a.3.1(this), new a.3.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.a.3
 * JD-Core Version:    0.7.0.1
 */