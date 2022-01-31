package com.tencent.mm.plugin.wallet_payu.pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.List;

public final class d
{
  public static Orders a(Orders paramOrders, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(48445);
    if ((paramOrders == null) || (paramOrders.ujl == null) || (paramOrders.ujl.size() <= 0))
    {
      ab.d("MicroMsg.OrdersWrapper", "hy: params error");
      AppMethodBeat.o(48445);
      return paramOrders;
    }
    Iterator localIterator = paramOrders.ujl.iterator();
    if (localIterator.hasNext())
    {
      Orders.Commodity localCommodity = (Orders.Commodity)localIterator.next();
      localCommodity.ppl = paramInt;
      if (paramString1.equals("1")) {}
      for (String str = "2";; str = "1")
      {
        localCommodity.ppi = str;
        localCommodity.ppj = paramString2;
        localCommodity.ppn = paramString3;
        break;
      }
    }
    AppMethodBeat.o(48445);
    return paramOrders;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pay.a.d
 * JD-Core Version:    0.7.0.1
 */