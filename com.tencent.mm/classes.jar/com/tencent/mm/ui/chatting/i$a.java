package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.k;
import com.tencent.mm.af.t;
import com.tencent.mm.af.t.a;
import com.tencent.mm.g.a.oa;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.az.a;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.p;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

final class i$a
  implements az.a
{
  private Set<Long> zxZ;
  private p zya;
  private t zyb;
  
  public i$a(Set<Long> paramSet, p paramp, t paramt)
  {
    this.zxZ = paramSet;
    this.zya = paramp;
    this.zyb = paramt;
  }
  
  public final boolean acS()
  {
    AppMethodBeat.i(30529);
    Object localObject1 = this.zxZ;
    LinkedList localLinkedList = new LinkedList();
    localObject1 = ((Set)localObject1).iterator();
    if (((Iterator)localObject1).hasNext())
    {
      Long localLong = (Long)((Iterator)localObject1).next();
      aw.aaz();
      Object localObject2 = c.YC().kB(localLong.longValue());
      if (((dd)localObject2).field_msgId == localLong.longValue())
      {
        if (!((bi)localObject2).bCn()) {
          break label147;
        }
        com.tencent.mm.modelstat.b.fRu.c((bi)localObject2, k.k((bi)localObject2));
      }
      for (;;)
      {
        localLinkedList.add(localLong);
        localObject2 = new oa();
        ((oa)localObject2).cEz.type = 3;
        ((oa)localObject2).cEz.cpO = localLong.longValue();
        a.ymk.l((com.tencent.mm.sdk.b.b)localObject2);
        break;
        label147:
        com.tencent.mm.modelstat.b.fRu.E((bi)localObject2);
      }
    }
    bf.U(localLinkedList);
    if (this.zyb != null) {
      this.zyb.b(t.a.fkd);
    }
    AppMethodBeat.o(30529);
    return true;
  }
  
  public final boolean acT()
  {
    AppMethodBeat.i(30530);
    if (this.zya != null)
    {
      this.zya.dismiss();
      if (this.zyb != null) {
        this.zyb.c(t.a.fkd);
      }
    }
    AppMethodBeat.o(30530);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.i.a
 * JD-Core Version:    0.7.0.1
 */