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
  private Map<String, WeakReference<d>> Dce;
  
  static
  {
    AppMethodBeat.i(70674);
    Dcd = new e("INSTANCE");
    Dcf = new e[] { Dcd };
    AppMethodBeat.o(70674);
  }
  
  private e()
  {
    AppMethodBeat.i(70671);
    this.Dce = new HashMap();
    AppMethodBeat.o(70671);
  }
  
  private static String b(Orders paramOrders)
  {
    AppMethodBeat.i(70673);
    if ((paramOrders != null) && (paramOrders.CYk != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      while (i < paramOrders.CYk.size())
      {
        localStringBuilder.append(((Orders.Commodity)paramOrders.CYk.get(i)).dlv);
        i += 1;
      }
      localStringBuilder.append("@");
      localStringBuilder.append(paramOrders.CXS);
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
    if (this.Dce.containsKey(str))
    {
      ad.i("MicroMsg.FavorLogicHelperPool", "hit cache, key:".concat(String.valueOf(str)));
      localObject = (WeakReference)this.Dce.get(str);
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
    while ((paramOrders != null) && (paramOrders.CYl != null))
    {
      paramOrders = new d(paramOrders.CYl);
      localObject = new WeakReference(paramOrders);
      this.Dce.put(str, localObject);
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