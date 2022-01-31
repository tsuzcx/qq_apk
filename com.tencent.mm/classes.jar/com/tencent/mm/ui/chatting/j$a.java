package com.tencent.mm.ui.chatting;

import com.tencent.mm.ae.h;
import com.tencent.mm.h.a.nd;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.p;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

final class j$a
  implements av.a
{
  private Set<Long> viZ;
  private p vja;
  private aj vjb;
  
  public j$a(Set<Long> paramSet, p paramp, aj paramaj)
  {
    this.viZ = paramSet;
    this.vja = paramp;
    this.vjb = paramaj;
  }
  
  public final boolean JS()
  {
    Object localObject1 = this.viZ;
    LinkedList localLinkedList = new LinkedList();
    localObject1 = ((Set)localObject1).iterator();
    if (((Iterator)localObject1).hasNext())
    {
      Long localLong = (Long)((Iterator)localObject1).next();
      au.Hx();
      Object localObject2 = c.Fy().fd(localLong.longValue());
      if (((cs)localObject2).field_msgId == localLong.longValue())
      {
        if (!((bi)localObject2).aVK()) {
          break label141;
        }
        com.tencent.mm.modelstat.b.eBD.c((bi)localObject2, h.g((bi)localObject2));
      }
      for (;;)
      {
        localLinkedList.add(localLong);
        localObject2 = new nd();
        ((nd)localObject2).bWJ.type = 3;
        ((nd)localObject2).bWJ.bIt = localLong.longValue();
        a.udP.m((com.tencent.mm.sdk.b.b)localObject2);
        break;
        label141:
        com.tencent.mm.modelstat.b.eBD.y((bi)localObject2);
      }
    }
    bd.N(localLinkedList);
    if (this.vjb != null) {
      this.vjb.a(aj.a.vmw);
    }
    return true;
  }
  
  public final boolean JT()
  {
    if (this.vja != null)
    {
      this.vja.dismiss();
      if (this.vjb != null) {
        this.vjb.b(aj.a.vmw);
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.j.a
 * JD-Core Version:    0.7.0.1
 */