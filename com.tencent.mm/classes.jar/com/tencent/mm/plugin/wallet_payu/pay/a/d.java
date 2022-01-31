package com.tencent.mm.plugin.wallet_payu.pay.a;

import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.List;

public final class d
{
  public static Orders a(Orders paramOrders, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    if ((paramOrders == null) || (paramOrders.qwN == null) || (paramOrders.qwN.size() <= 0))
    {
      y.d("MicroMsg.OrdersWrapper", "hy: params error");
      return paramOrders;
    }
    Iterator localIterator = paramOrders.qwN.iterator();
    label43:
    Orders.Commodity localCommodity;
    if (localIterator.hasNext())
    {
      localCommodity = (Orders.Commodity)localIterator.next();
      localCommodity.mOV = paramInt;
      if (!paramString1.equals("1")) {
        break label107;
      }
    }
    label107:
    for (String str = "2";; str = "1")
    {
      localCommodity.mOS = str;
      localCommodity.mOT = paramString2;
      localCommodity.mOX = paramString3;
      break label43;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pay.a.d
 * JD-Core Version:    0.7.0.1
 */