package com.tencent.mm.plugin.wallet_core.e;

import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.c.c;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vending.g.f;
import java.util.LinkedList;
import java.util.List;

public final class a$9
  implements com.tencent.mm.vending.c.a<Object, List<Bankcard>>
{
  public a$9(a parama) {}
  
  private Object cX(List<Bankcard> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      int j = paramList.size();
      this.qJn.qJm = new LinkedList();
      int i = 0;
      Object localObject;
      if (i < j)
      {
        localObject = (Bankcard)paramList.get(i);
        if (((Bankcard)localObject).bUQ()) {
          y.i("MicroMsg.BankcardLogoHelper", "ignore balance!!");
        }
        for (;;)
        {
          i += 1;
          break;
          this.qJn.qJm.add(((Bankcard)localObject).field_bankcardType);
        }
      }
      if (this.qJn.qJm.size() > 0)
      {
        y.i("MicroMsg.BankcardLogoHelper", "need fetch bank logo, %s", new Object[] { Integer.valueOf(this.qJn.qJm.size()) });
        paramList = f.cKX();
        localObject = new c(this.qJn.qJm);
        g.DQ();
        g.DO().dJT.a(1650, new a.9.1(this, paramList));
        g.DQ();
        g.DO().dJT.a((m)localObject, 0);
        paramList.cKW();
      }
    }
    return wtt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.e.a.9
 * JD-Core Version:    0.7.0.1
 */