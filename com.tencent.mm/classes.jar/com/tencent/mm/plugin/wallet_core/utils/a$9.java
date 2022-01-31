package com.tencent.mm.plugin.wallet_core.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;
import java.util.List;

public final class a$9
  implements com.tencent.mm.vending.c.a<Object, List<Bankcard>>
{
  public a$9(a parama) {}
  
  private Object eb(List<Bankcard> paramList)
  {
    AppMethodBeat.i(47993);
    if ((paramList != null) && (paramList.size() > 0))
    {
      int j = paramList.size();
      this.uxV.uxU = new LinkedList();
      int i = 0;
      Object localObject;
      if (i < j)
      {
        localObject = (Bankcard)paramList.get(i);
        if (((Bankcard)localObject).cTf()) {
          ab.i("MicroMsg.BankcardLogoHelper", "ignore balance!!");
        }
        for (;;)
        {
          i += 1;
          break;
          this.uxV.uxU.add(((Bankcard)localObject).field_bankcardType);
        }
      }
      if (this.uxV.uxU.size() > 0)
      {
        ab.i("MicroMsg.BankcardLogoHelper", "need fetch bank logo, %s", new Object[] { Integer.valueOf(this.uxV.uxU.size()) });
        paramList = com.tencent.mm.vending.g.f.dQn();
        localObject = new com.tencent.mm.plugin.wallet_core.c.f(this.uxV.uxU);
        g.RM();
        g.RK().eHt.a(1650, new a.9.1(this, paramList));
        g.RM();
        g.RK().eHt.a((m)localObject, 0);
        paramList.dQm();
      }
    }
    paramList = AOo;
    AppMethodBeat.o(47993);
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.a.9
 * JD-Core Version:    0.7.0.1
 */