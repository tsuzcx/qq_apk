package com.tencent.mm.plugin.wallet_payu.pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.List;

public final class c
{
  public static Orders a(Orders paramOrders, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(72086);
    if ((paramOrders == null) || (paramOrders.CYk == null) || (paramOrders.CYk.size() <= 0))
    {
      ad.d("MicroMsg.OrdersWrapper", "hy: params error");
      AppMethodBeat.o(72086);
      return paramOrders;
    }
    Iterator localIterator = paramOrders.CYk.iterator();
    if (localIterator.hasNext())
    {
      Orders.Commodity localCommodity = (Orders.Commodity)localIterator.next();
      localCommodity.wCB = paramInt;
      if (paramString1.equals("1")) {}
      for (String str = "2";; str = "1")
      {
        localCommodity.wCy = str;
        localCommodity.wCz = paramString2;
        localCommodity.wCD = paramString3;
        break;
      }
    }
    AppMethodBeat.o(72086);
    return paramOrders;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pay.a.c
 * JD-Core Version:    0.7.0.1
 */