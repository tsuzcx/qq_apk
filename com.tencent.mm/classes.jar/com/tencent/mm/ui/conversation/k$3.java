package com.tencent.mm.ui.conversation;

import com.tencent.mm.h.c.as;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.f.a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

final class k$3
  implements f.a
{
  k$3(k paramk) {}
  
  public final void Wp()
  {
    k.b(this.vTA).cHV();
    h localh;
    if (k.a(this.vTA) != null)
    {
      localh = k.a(this.vTA);
      if ((localh.veF != null) && (localh.vSm != null) && (!localh.vSm.isEmpty())) {}
    }
    else
    {
      k.d(this.vTA).post(new k.3.1(this));
      return;
    }
    if (localh.vSn)
    {
      localh.veF.clear();
      localh.vSn = false;
    }
    for (;;)
    {
      localh.vSm.clear();
      break;
      y.d("MicroMsg.ConversationWithCacheAdapter", "dealWithConversationEvents size %d", new Object[] { Integer.valueOf(localh.vSm.size()) });
      Iterator localIterator = localh.vSm.iterator();
      while (localIterator.hasNext()) {
        localh.veF.remove(localIterator.next());
      }
    }
  }
  
  public final void cyh()
  {
    g.wI(12);
    d locald = k.b(this.vTA);
    locald.vPE = -1;
    locald.vPD.clear();
    if ((locald.vPG == null) || (locald.vPF < 0) || (!locald.vPG.cxa()))
    {
      locald.vPE = 0;
      return;
    }
    if (locald.vPG.vSn)
    {
      locald.vPE = 0;
      return;
    }
    if (locald.vPG.vSl)
    {
      y.i("MicroMsg.ConvUnreadHelper", "unreadcheck preSetLauncherUIUnReadCount has contact change");
      locald.vPE = 0;
      locald.vPG.vSl = false;
      return;
    }
    Object localObject1 = (HashSet)locald.vPG.vSm.clone();
    y.i("MicroMsg.ConvUnreadHelper", "unreadcheck preSetLauncherUIUnReadCount  events size %d", new Object[] { Integer.valueOf(((HashSet)localObject1).size()) });
    if (((HashSet)localObject1).contains("floatbottle"))
    {
      locald.vPE = 0;
      return;
    }
    ((HashSet)localObject1).remove("officialaccounts");
    if (((HashSet)localObject1).isEmpty())
    {
      locald.vPE = 1;
      return;
    }
    localObject1 = ((HashSet)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      String str = (String)((Iterator)localObject1).next();
      Object localObject2 = locald.vPG;
      boolean bool;
      if (((h)localObject2).adY(str)) {
        bool = false;
      }
      for (;;)
      {
        if (bool) {
          break label321;
        }
        localObject2 = locald.adX(str);
        if (localObject2 != null) {
          break label323;
        }
        locald.vPD.put(str, Integer.valueOf(0));
        y.i("MicroMsg.ConvUnreadHelper", "unreadcheck preSetLauncherUIUnReadCount  cov == null username %s, unreadcount %d", new Object[] { str, Integer.valueOf(0) });
        break;
        localObject2 = (h.d)((h)localObject2).veF.get(str);
        if (localObject2 == null) {
          bool = false;
        } else if (s.fn(str)) {
          bool = ((h.d)localObject2).vQu;
        } else {
          bool = ((h.d)localObject2).vQq;
        }
      }
      label321:
      continue;
      label323:
      locald.vPD.put(str, Integer.valueOf(((as)localObject2).field_unReadCount));
      y.i("MicroMsg.ConvUnreadHelper", "unreadcheck preSetLauncherUIUnReadCount  cov != null username %s, unreadcount %d", new Object[] { str, Integer.valueOf(((as)localObject2).field_unReadCount) });
    }
    y.i("MicroMsg.ConvUnreadHelper", "unreadcheck preSetLauncherUIUnReadCount  preUnReadCount size %d", new Object[] { Integer.valueOf(locald.vPD.size()) });
    if (locald.vPD.isEmpty())
    {
      locald.vPE = 1;
      return;
    }
    if (locald.vPD.size() > 20)
    {
      locald.vPE = 0;
      return;
    }
    locald.vPE = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.k.3
 * JD-Core Version:    0.7.0.1
 */