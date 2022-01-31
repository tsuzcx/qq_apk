package com.tencent.mm.ui.chatting;

import com.tencent.mm.ae.l;
import com.tencent.mm.ae.m;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.bi;
import java.util.Iterator;
import java.util.List;

final class m$1
  implements Runnable
{
  m$1(List paramList) {}
  
  public final void run()
  {
    Object localObject1 = this.gFL;
    if (!bk.dk((List)localObject1))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (bi)((Iterator)localObject1).next();
        if (((bi)localObject2).ctz())
        {
          localObject2 = ((a)g.r(a.class)).d(((cs)localObject2).field_msgId, ((cs)localObject2).field_content).dTx;
          if (localObject2 != null)
          {
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              m localm = (m)((Iterator)localObject2).next();
              if ((!bk.bl(localm.dTN)) && (com.tencent.mm.ae.i.gr(localm.dTI))) {
                b.JD().a(new m.2(localm), localm.dTN, null, ((com.tencent.mm.modelappbrand.i)g.r(com.tencent.mm.modelappbrand.i.class)).bk(112, 90));
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.m.1
 * JD-Core Version:    0.7.0.1
 */