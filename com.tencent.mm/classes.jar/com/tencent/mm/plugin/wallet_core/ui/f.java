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

public enum f
{
  private Map<String, WeakReference<e>> OVl;
  
  static
  {
    AppMethodBeat.i(70674);
    OVk = new f("INSTANCE");
    OVm = new f[] { OVk };
    AppMethodBeat.o(70674);
  }
  
  private f()
  {
    AppMethodBeat.i(70671);
    this.OVl = new HashMap();
    AppMethodBeat.o(70671);
  }
  
  private static String b(Orders paramOrders)
  {
    AppMethodBeat.i(70673);
    if ((paramOrders != null) && (paramOrders.ORd != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      while (i < paramOrders.ORd.size())
      {
        localStringBuilder.append(((Orders.Commodity)paramOrders.ORd.get(i)).fww);
        i += 1;
      }
      localStringBuilder.append("@");
      localStringBuilder.append(paramOrders.OQL);
      paramOrders = localStringBuilder.toString();
      AppMethodBeat.o(70673);
      return paramOrders;
    }
    AppMethodBeat.o(70673);
    return null;
  }
  
  public final e a(Orders paramOrders)
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
    if (this.OVl.containsKey(str))
    {
      Log.i("MicroMsg.FavorLogicHelperPool", "hit cache, key:".concat(String.valueOf(str)));
      localObject = (WeakReference)this.OVl.get(str);
      if (localObject == null) {
        break label153;
      }
      localObject = (e)((WeakReference)localObject).get();
      if (localObject != null)
      {
        AppMethodBeat.o(70672);
        return localObject;
      }
      Log.i("MicroMsg.FavorLogicHelperPool", "helper null");
    }
    while ((paramOrders != null) && (paramOrders.ORe != null))
    {
      paramOrders = new e(paramOrders.ORe);
      localObject = new WeakReference(paramOrders);
      this.OVl.put(str, localObject);
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
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.f
 * JD-Core Version:    0.7.0.1
 */