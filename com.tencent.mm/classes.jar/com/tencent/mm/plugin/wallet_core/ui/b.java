package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum b
{
  private Map<String, WeakReference<a>> qAe = new HashMap();
  
  private b() {}
  
  public final a a(Orders paramOrders)
  {
    Object localObject1;
    if ((paramOrders != null) && (paramOrders.qwN != null))
    {
      localObject1 = new StringBuilder();
      int i = 0;
      while (i < paramOrders.qwN.size())
      {
        ((StringBuilder)localObject1).append(((Orders.Commodity)paramOrders.qwN.get(i)).bMY);
        i += 1;
      }
      ((StringBuilder)localObject1).append("@");
      ((StringBuilder)localObject1).append(paramOrders.qww);
      localObject1 = ((StringBuilder)localObject1).toString();
      if (!bk.bl((String)localObject1)) {
        break label104;
      }
      y.w("MicroMsg.FavorLogicHelperPool", "get key null");
    }
    for (;;)
    {
      return null;
      localObject1 = null;
      break;
      label104:
      Object localObject2;
      if (this.qAe.containsKey(localObject1))
      {
        y.i("MicroMsg.FavorLogicHelperPool", "hit cache, key:" + (String)localObject1);
        localObject2 = (WeakReference)this.qAe.get(localObject1);
        if (localObject2 == null) {
          break label231;
        }
        localObject2 = (a)((WeakReference)localObject2).get();
        if (localObject2 != null) {
          return localObject2;
        }
        y.i("MicroMsg.FavorLogicHelperPool", "helper null");
      }
      while ((paramOrders != null) && (paramOrders.qwO != null))
      {
        paramOrders = new a(paramOrders.qwO);
        localObject2 = new WeakReference(paramOrders);
        this.qAe.put(localObject1, localObject2);
        return paramOrders;
        label231:
        y.i("MicroMsg.FavorLogicHelperPool", "weakHelper null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.b
 * JD-Core Version:    0.7.0.1
 */