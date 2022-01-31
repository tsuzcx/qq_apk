package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum c
{
  private Map<String, WeakReference<b>> umP;
  
  static
  {
    AppMethodBeat.i(47124);
    umO = new c("INSTANCE");
    umQ = new c[] { umO };
    AppMethodBeat.o(47124);
  }
  
  private c()
  {
    AppMethodBeat.i(47121);
    this.umP = new HashMap();
    AppMethodBeat.o(47121);
  }
  
  private static String b(Orders paramOrders)
  {
    AppMethodBeat.i(47123);
    if ((paramOrders != null) && (paramOrders.ujl != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      while (i < paramOrders.ujl.size())
      {
        localStringBuilder.append(((Orders.Commodity)paramOrders.ujl.get(i)).cnJ);
        i += 1;
      }
      localStringBuilder.append("@");
      localStringBuilder.append(paramOrders.uiU);
      paramOrders = localStringBuilder.toString();
      AppMethodBeat.o(47123);
      return paramOrders;
    }
    AppMethodBeat.o(47123);
    return null;
  }
  
  public final b a(Orders paramOrders)
  {
    AppMethodBeat.i(47122);
    String str = b(paramOrders);
    if (bo.isNullOrNil(str))
    {
      ab.w("MicroMsg.FavorLogicHelperPool", "get key null");
      AppMethodBeat.o(47122);
      return null;
    }
    Object localObject;
    if (this.umP.containsKey(str))
    {
      ab.i("MicroMsg.FavorLogicHelperPool", "hit cache, key:".concat(String.valueOf(str)));
      localObject = (WeakReference)this.umP.get(str);
      if (localObject == null) {
        break label153;
      }
      localObject = (b)((WeakReference)localObject).get();
      if (localObject != null)
      {
        AppMethodBeat.o(47122);
        return localObject;
      }
      ab.i("MicroMsg.FavorLogicHelperPool", "helper null");
    }
    while ((paramOrders != null) && (paramOrders.ujm != null))
    {
      paramOrders = new b(paramOrders.ujm);
      localObject = new WeakReference(paramOrders);
      this.umP.put(str, localObject);
      AppMethodBeat.o(47122);
      return paramOrders;
      label153:
      ab.i("MicroMsg.FavorLogicHelperPool", "weakHelper null");
    }
    AppMethodBeat.o(47122);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.c
 * JD-Core Version:    0.7.0.1
 */