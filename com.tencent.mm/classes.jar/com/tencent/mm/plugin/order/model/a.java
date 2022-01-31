package com.tencent.mm.plugin.order.model;

import android.content.Context;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;

public final class a
{
  public static com.tencent.mm.plugin.order.ui.a.e a(Context paramContext, MallTransactionObject paramMallTransactionObject)
  {
    com.tencent.mm.plugin.order.ui.a.e locale = new com.tencent.mm.plugin.order.ui.a.e(paramContext);
    if (!bk.bl(paramMallTransactionObject.mPj)) {}
    for (locale.mRp = paramContext.getString(a.i.wallet_order_info_support);; locale.mRp = paramContext.getString(a.i.wallet_order_info_support_customer_service))
    {
      locale.mOnClickListener = new a.1(paramMallTransactionObject, paramContext);
      return locale;
    }
  }
  
  public static void a(int paramInt, Context paramContext, MallTransactionObject paramMallTransactionObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      g.DQ();
      ad localad = ((j)g.r(j.class)).Fw().abl(paramMallTransactionObject.mPa);
      if ((localad != null) && (com.tencent.mm.n.a.gR(localad.field_type)))
      {
        com.tencent.mm.wallet_core.ui.e.bF(paramContext, paramMallTransactionObject.mPa);
        return;
      }
      com.tencent.mm.wallet_core.ui.e.aa(paramContext, paramMallTransactionObject.mPa);
      return;
    case 1: 
      com.tencent.mm.wallet_core.ui.e.bG(paramContext, paramMallTransactionObject.mOD);
      return;
    }
    com.tencent.mm.wallet_core.ui.e.l(paramContext, paramMallTransactionObject.mPj, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.a
 * JD-Core Version:    0.7.0.1
 */