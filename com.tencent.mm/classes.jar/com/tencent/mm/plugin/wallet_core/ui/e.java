package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum e
{
  private Map<String, WeakReference<d>> DtI;
  
  static
  {
    AppMethodBeat.i(70674);
    DtH = new e("INSTANCE");
    DtJ = new e[] { DtH };
    AppMethodBeat.o(70674);
  }
  
  private e()
  {
    AppMethodBeat.i(70671);
    this.DtI = new HashMap();
    AppMethodBeat.o(70671);
  }
  
  private static String b(Orders paramOrders)
  {
    AppMethodBeat.i(70673);
    if ((paramOrders != null) && (paramOrders.DpP != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      while (i < paramOrders.DpP.size())
      {
        localStringBuilder.append(((Orders.Commodity)paramOrders.DpP.get(i)).dmx);
        i += 1;
      }
      localStringBuilder.append("@");
      localStringBuilder.append(paramOrders.Dpx);
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
    if (bu.isNullOrNil(str))
    {
      ae.w("MicroMsg.FavorLogicHelperPool", "get key null");
      AppMethodBeat.o(70672);
      return null;
    }
    Object localObject;
    if (this.DtI.containsKey(str))
    {
      ae.i("MicroMsg.FavorLogicHelperPool", "hit cache, key:".concat(String.valueOf(str)));
      localObject = (WeakReference)this.DtI.get(str);
      if (localObject == null) {
        break label153;
      }
      localObject = (d)((WeakReference)localObject).get();
      if (localObject != null)
      {
        AppMethodBeat.o(70672);
        return localObject;
      }
      ae.i("MicroMsg.FavorLogicHelperPool", "helper null");
    }
    while ((paramOrders != null) && (paramOrders.DpQ != null))
    {
      paramOrders = new d(paramOrders.DpQ);
      localObject = new WeakReference(paramOrders);
      this.DtI.put(str, localObject);
      AppMethodBeat.o(70672);
      return paramOrders;
      label153:
      ae.i("MicroMsg.FavorLogicHelperPool", "weakHelper null");
    }
    AppMethodBeat.o(70672);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.e
 * JD-Core Version:    0.7.0.1
 */