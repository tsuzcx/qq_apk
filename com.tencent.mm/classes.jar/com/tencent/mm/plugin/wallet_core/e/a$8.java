package com.tencent.mm.plugin.wallet_core.e;

import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.e;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a$8
  implements com.tencent.mm.vending.c.a<Object, Object>
{
  public a$8(a parama, List paramList, Map paramMap, a.a parama1) {}
  
  public final Object call(Object paramObject)
  {
    paramObject = this.qnh.iterator();
    while (paramObject.hasNext())
    {
      Bankcard localBankcard = (Bankcard)paramObject.next();
      e locale = b.QB(localBankcard.field_bankcardType);
      this.qJs.put(localBankcard.field_bankcardType, locale);
    }
    if (this.qJt != null) {
      this.qJt.S(this.qJs);
    }
    return wtt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.e.a.8
 * JD-Core Version:    0.7.0.1
 */