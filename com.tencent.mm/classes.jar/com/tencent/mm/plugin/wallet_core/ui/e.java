package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum e
{
  private Map<String, WeakReference<d>> BBM;
  
  static
  {
    AppMethodBeat.i(70674);
    BBL = new e("INSTANCE");
    BBN = new e[] { BBL };
    AppMethodBeat.o(70674);
  }
  
  private e()
  {
    AppMethodBeat.i(70671);
    this.BBM = new HashMap();
    AppMethodBeat.o(70671);
  }
  
  private static String b(Orders paramOrders)
  {
    AppMethodBeat.i(70673);
    if ((paramOrders != null) && (paramOrders.BxR != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      while (i < paramOrders.BxR.size())
      {
        localStringBuilder.append(((Orders.Commodity)paramOrders.BxR.get(i)).dad);
        i += 1;
      }
      localStringBuilder.append("@");
      localStringBuilder.append(paramOrders.Bxz);
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
    if (bs.isNullOrNil(str))
    {
      ac.w("MicroMsg.FavorLogicHelperPool", "get key null");
      AppMethodBeat.o(70672);
      return null;
    }
    Object localObject;
    if (this.BBM.containsKey(str))
    {
      ac.i("MicroMsg.FavorLogicHelperPool", "hit cache, key:".concat(String.valueOf(str)));
      localObject = (WeakReference)this.BBM.get(str);
      if (localObject == null) {
        break label153;
      }
      localObject = (d)((WeakReference)localObject).get();
      if (localObject != null)
      {
        AppMethodBeat.o(70672);
        return localObject;
      }
      ac.i("MicroMsg.FavorLogicHelperPool", "helper null");
    }
    while ((paramOrders != null) && (paramOrders.BxS != null))
    {
      paramOrders = new d(paramOrders.BxS);
      localObject = new WeakReference(paramOrders);
      this.BBM.put(str, localObject);
      AppMethodBeat.o(70672);
      return paramOrders;
      label153:
      ac.i("MicroMsg.FavorLogicHelperPool", "weakHelper null");
    }
    AppMethodBeat.o(70672);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.e
 * JD-Core Version:    0.7.0.1
 */