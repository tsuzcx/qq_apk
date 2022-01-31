package com.tencent.mm.plugin.order.ui.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.order.model.MallTransactionObject;

final class a$2
  implements View.OnClickListener
{
  a$2(a parama, MallTransactionObject paramMallTransactionObject, f paramf, com.tencent.mm.ui.base.preference.f paramf1) {}
  
  public final void onClick(View paramView)
  {
    paramView = this.mOH.desc + "\n" + this.mOH.mOP;
    this.mRj.setContent(paramView);
    this.hcx.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.a.2
 * JD-Core Version:    0.7.0.1
 */