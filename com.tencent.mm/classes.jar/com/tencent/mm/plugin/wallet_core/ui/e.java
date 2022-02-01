package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum e
{
  private Map<String, WeakReference<d>> Ajq;
  
  static
  {
    AppMethodBeat.i(70674);
    Ajp = new e("INSTANCE");
    Ajr = new e[] { Ajp };
    AppMethodBeat.o(70674);
  }
  
  private e()
  {
    AppMethodBeat.i(70671);
    this.Ajq = new HashMap();
    AppMethodBeat.o(70671);
  }
  
  private static String b(Orders paramOrders)
  {
    AppMethodBeat.i(70673);
    if ((paramOrders != null) && (paramOrders.Afx != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      while (i < paramOrders.Afx.size())
      {
        localStringBuilder.append(((Orders.Commodity)paramOrders.Afx.get(i)).dcF);
        i += 1;
      }
      localStringBuilder.append("@");
      localStringBuilder.append(paramOrders.Aff);
      paramOrders = localStringBuilder.toString();
      AppMethodBeat.o(70673);
      return paramOrders;
    }
    AppMethodBeat.o(70673);
    return null;
  }
  
  public final d a(Orders paramOrders)
  {
    AppMethodBeat.i(70672);
    String str = b(paramOrders);
    if (bt.isNullOrNil(str))
    {
      ad.w("MicroMsg.FavorLogicHelperPool", "get key null");
      AppMethodBeat.o(70672);
      return null;
    }
    Object localObject;
    if (this.Ajq.containsKey(str))
    {
      ad.i("MicroMsg.FavorLogicHelperPool", "hit cache, key:".concat(String.valueOf(str)));
      localObject = (WeakReference)this.Ajq.get(str);
      if (localObject == null) {
        break label153;
      }
      localObject = (d)((WeakReference)localObject).get();
      if (localObject != null)
      {
        AppMethodBeat.o(70672);
        return localObject;
      }
      ad.i("MicroMsg.FavorLogicHelperPool", "helper null");
    }
    while ((paramOrders != null) && (paramOrders.Afy != null))
    {
      paramOrders = new d(paramOrders.Afy);
      localObject = new WeakReference(paramOrders);
      this.Ajq.put(str, localObject);
      AppMethodBeat.o(70672);
      return paramOrders;
      label153:
      ad.i("MicroMsg.FavorLogicHelperPool", "weakHelper null");
    }
    AppMethodBeat.o(70672);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.e
 * JD-Core Version:    0.7.0.1
 */