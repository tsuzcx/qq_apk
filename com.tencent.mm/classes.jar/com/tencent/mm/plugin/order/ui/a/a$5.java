package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;
import java.util.List;

final class a$5
  implements View.OnClickListener
{
  a$5(a parama, MallTransactionObject paramMallTransactionObject, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    paramView = new LinkedList();
    LinkedList localLinkedList = new LinkedList();
    if (!bk.bl(this.mOH.mPa))
    {
      localLinkedList.add(Integer.valueOf(0));
      paramView.add(this.val$context.getString(a.i.wallet_order_info_support_biz));
    }
    if (!bk.bl(this.mOH.mOD))
    {
      localLinkedList.add(Integer.valueOf(1));
      paramView.add(this.val$context.getString(a.i.wallet_order_info_support_call));
    }
    if (!bk.bl(this.mOH.mPj))
    {
      localLinkedList.add(Integer.valueOf(2));
      paramView.add(this.val$context.getString(a.i.wallet_order_info_support_safeguard));
    }
    if (localLinkedList.size() == 1)
    {
      com.tencent.mm.plugin.order.model.a.a(((Integer)localLinkedList.get(0)).intValue(), this.val$context, this.mOH);
      return;
    }
    h.a(this.val$context, null, paramView, localLinkedList, null, true, new a.5.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.a.5
 * JD-Core Version:    0.7.0.1
 */