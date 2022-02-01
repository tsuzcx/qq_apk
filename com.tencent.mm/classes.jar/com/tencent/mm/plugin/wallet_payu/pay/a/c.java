package com.tencent.mm.plugin.wallet_payu.pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Iterator;
import java.util.List;

public final class c
{
  public static Orders a(Orders paramOrders, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(72086);
    if ((paramOrders == null) || (paramOrders.DpP == null) || (paramOrders.DpP.size() <= 0))
    {
      ae.d("MicroMsg.OrdersWrapper", "hy: params error");
      AppMethodBeat.o(72086);
      return paramOrders;
    }
    Iterator localIterator = paramOrders.DpP.iterator();
    if (localIterator.hasNext())
    {
      Orders.Commodity localCommodity = (Orders.Commodity)localIterator.next();
      localCommodity.wSm = paramInt;
      if (paramString1.equals("1")) {}
      for (String str = "2";; str = "1")
      {
        localCommodity.wSj = str;
        localCommodity.wSk = paramString2;
        localCommodity.wSo = paramString3;
        break;
      }
    }
    AppMethodBeat.o(72086);
    return paramOrders;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pay.a.c
 * JD-Core Version:    0.7.0.1
 */