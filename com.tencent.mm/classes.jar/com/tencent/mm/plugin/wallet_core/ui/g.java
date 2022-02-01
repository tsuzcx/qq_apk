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

public enum g
{
  private Map<String, WeakReference<f>> VLy;
  
  static
  {
    AppMethodBeat.i(70674);
    VLx = new g("INSTANCE");
    VLz = new g[] { VLx };
    AppMethodBeat.o(70674);
  }
  
  private g()
  {
    AppMethodBeat.i(70671);
    this.VLy = new HashMap();
    AppMethodBeat.o(70671);
  }
  
  private static String b(Orders paramOrders)
  {
    AppMethodBeat.i(70673);
    if ((paramOrders != null) && (paramOrders.VGX != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      while (i < paramOrders.VGX.size())
      {
        localStringBuilder.append(((Orders.Commodity)paramOrders.VGX.get(i)).hAU);
        i += 1;
      }
      localStringBuilder.append("@");
      localStringBuilder.append(paramOrders.VGF);
      paramOrders = localStringBuilder.toString();
      AppMethodBeat.o(70673);
      return paramOrders;
    }
    AppMethodBeat.o(70673);
    return null;
  }
  
  public final f a(Orders paramOrders)
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
    if (this.VLy.containsKey(str))
    {
      Log.i("MicroMsg.FavorLogicHelperPool", "hit cache, key:".concat(String.valueOf(str)));
      localObject = (WeakReference)this.VLy.get(str);
      if (localObject == null) {
        break label153;
      }
      localObject = (f)((WeakReference)localObject).get();
      if (localObject != null)
      {
        AppMethodBeat.o(70672);
        return localObject;
      }
      Log.i("MicroMsg.FavorLogicHelperPool", "helper null");
    }
    while ((paramOrders != null) && (paramOrders.VGY != null))
    {
      paramOrders = new f(paramOrders.VGY);
      localObject = new WeakReference(paramOrders);
      this.VLy.put(str, localObject);
      AppMethodBeat.o(70672);
      return paramOrders;
      label153:
      Log.i("MicroMsg.FavorLogicHelperPool", "weakHelper null");
    }
    AppMethodBeat.o(70672);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.g
 * JD-Core Version:    0.7.0.1
 */