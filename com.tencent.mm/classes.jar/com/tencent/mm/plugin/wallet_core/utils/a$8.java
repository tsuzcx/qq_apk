package com.tencent.mm.plugin.wallet_core.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.g;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a$8
  implements com.tencent.mm.vending.c.a<Object, Object>
{
  public a$8(a parama, List paramList, Map paramMap, a.a parama1) {}
  
  public final Object call(Object paramObject)
  {
    AppMethodBeat.i(47991);
    paramObject = this.tWx.iterator();
    while (paramObject.hasNext())
    {
      Bankcard localBankcard = (Bankcard)paramObject.next();
      g localg = b.afv(localBankcard.field_bankcardType);
      this.uya.put(localBankcard.field_bankcardType, localg);
    }
    if (this.uyb != null) {
      this.uyb.am(this.uya);
    }
    paramObject = AOo;
    AppMethodBeat.o(47991);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.a.8
 * JD-Core Version:    0.7.0.1
 */