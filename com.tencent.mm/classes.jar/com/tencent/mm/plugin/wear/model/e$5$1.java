package com.tencent.mm.plugin.wear.model;

import com.tencent.mm.h.a.li;
import com.tencent.mm.h.a.li.a;
import com.tencent.mm.protocal.c.cjl;
import java.util.ArrayList;

final class e$5$1
  implements Runnable
{
  e$5$1(e.5 param5, li paramli) {}
  
  public final void run()
  {
    a.bYL().qRw.Rf(this.qRX.bUs.talker);
    Object localObject1 = a.bYL().qRw.Re(this.qRX.bUs.talker);
    Object localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(Integer.valueOf(((f)localObject1).id));
    a.bYL().qRA.a(new com.tencent.mm.plugin.wear.model.f.i((ArrayList)localObject2));
    if (this.qRX.bUs.talker.equals("gh_43f2581f6fd6"))
    {
      localObject1 = a.bYL().qRu.qRL.qSA;
      if (localObject1 != null)
      {
        localObject2 = a.bYL().qRx;
        if ((localObject1 == null) || (!((b)localObject2).qRE) || (!b.Rd(((cjl)localObject1).tXi))) {
          break label154;
        }
      }
    }
    label154:
    for (int i = 1; i != 0; i = 0)
    {
      a.bYL();
      b.a((cjl)localObject1);
      return;
    }
    a.bYL().qRx.connect();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.5.1
 * JD-Core Version:    0.7.0.1
 */