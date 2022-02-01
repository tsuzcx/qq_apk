package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum e
{
  private Map<String, WeakReference<d>> IcU;
  
  static
  {
    AppMethodBeat.i(70674);
    IcT = new e("INSTANCE");
    IcV = new e[] { IcT };
    AppMethodBeat.o(70674);
  }
  
  private e()
  {
    AppMethodBeat.i(70671);
    this.IcU = new HashMap();
    AppMethodBeat.o(70671);
  }
  
  private static String b(Orders paramOrders)
  {
    AppMethodBeat.i(70673);
    if ((paramOrders != null) && (paramOrders.HZd != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      while (i < paramOrders.HZd.size())
      {
        localStringBuilder.append(((Orders.Commodity)paramOrders.HZd.get(i)).dDM);
        i += 1;
      }
      localStringBuilder.append("@");
      localStringBuilder.append(paramOrders.HYL);
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
    if (Util.isNullOrNil(str))
    {
      Log.w("MicroMsg.FavorLogicHelperPool", "get key null");
      AppMethodBeat.o(70672);
      return null;
    }
    Object localObject;
    if (this.IcU.containsKey(str))
    {
      Log.i("MicroMsg.FavorLogicHelperPool", "hit cache, key:".concat(String.valueOf(str)));
      localObject = (WeakReference)this.IcU.get(str);
      if (localObject == null) {
        break label153;
      }
      localObject = (d)((WeakReference)localObject).get();
      if (localObject != null)
      {
        AppMethodBeat.o(70672);
        return localObject;
      }
      Log.i("MicroMsg.FavorLogicHelperPool", "helper null");
    }
    while ((paramOrders != null) && (paramOrders.HZe != null))
    {
      paramOrders = new d(paramOrders.HZe);
      localObject = new WeakReference(paramOrders);
      this.IcU.put(str, localObject);
      AppMethodBeat.o(70672);
      return paramOrders;
      label153:
      Log.i("MicroMsg.FavorLogicHelperPool", "weakHelper null");
    }
    AppMethodBeat.o(70672);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.e
 * JD-Core Version:    0.7.0.1
 */