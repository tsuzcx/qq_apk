package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.wallet_core.ui.e;

final class a$1
  implements View.OnClickListener
{
  a$1(a parama, MallTransactionObject paramMallTransactionObject, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    if (!bk.bl(this.mOH.mPa)) {
      e.aa(this.val$context, this.mOH.mPa);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.a.1
 * JD-Core Version:    0.7.0.1
 */