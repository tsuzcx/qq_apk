package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.l;
import com.tencent.mm.af.p;
import com.tencent.mm.af.q;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.i;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.util.Iterator;
import java.util.List;

final class l$1
  implements Runnable
{
  l$1(List paramList) {}
  
  public final void run()
  {
    AppMethodBeat.i(30590);
    Object localObject1 = this.ieO;
    if (!bo.es((List)localObject1))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (bi)((Iterator)localObject1).next();
        if (((bi)localObject2).dvV())
        {
          localObject2 = ((a)g.E(a.class)).b(((dd)localObject2).field_msgId, ((dd)localObject2).field_content).fjy;
          if (localObject2 != null)
          {
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              q localq = (q)((Iterator)localObject2).next();
              if ((!bo.isNullOrNil(localq.fjT)) && (l.na(localq.fjO))) {
                b.acD().a(new l.2(localq), localq.fjT, null, ((i)g.E(i.class)).cu(112, 90));
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(30590);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.l.1
 * JD-Core Version:    0.7.0.1
 */