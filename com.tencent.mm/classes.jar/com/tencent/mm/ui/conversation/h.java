package com.tencent.mm.ui.conversation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cx;
import com.tencent.mm.g.a.hw;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.o.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class h
  implements n.b
{
  public static h KtJ;
  private static HashMap<String, Integer> KtK;
  private volatile boolean EOS;
  private c<cx> EOT;
  private c<hw> KtL;
  
  static
  {
    AppMethodBeat.i(194661);
    KtJ = new h();
    KtK = new HashMap();
    AppMethodBeat.o(194661);
  }
  
  private h()
  {
    AppMethodBeat.i(194656);
    this.EOT = new c() {};
    this.KtL = new c() {};
    this.EOT.alive();
    this.KtL.alive();
    AppMethodBeat.o(194656);
  }
  
  public static int fIP()
  {
    AppMethodBeat.i(194659);
    ad.i("MicroMsg.ConversationUnreadHelper", "getTotalUnread %s", new Object[] { bt.flS() });
    com.tencent.mm.plugin.report.service.g.yhR.dD(931, 25);
    Object localObject2;
    int i;
    synchronized (KtK)
    {
      if (!KtK.isEmpty()) {
        break label191;
      }
      HashMap localHashMap2 = x.AB(w.hFd);
      localObject2 = localHashMap2.keySet().iterator();
      if (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        i = ((at)localHashMap2.get(str)).field_unReadCount;
        KtK.put(str, Integer.valueOf(i));
      }
    }
    com.tencent.mm.plugin.report.service.g.yhR.dD(931, 26);
    for (;;)
    {
      Iterator localIterator = KtK.keySet().iterator();
      for (i = 0; localIterator.hasNext(); i = ((Integer)KtK.get(localObject2)).intValue() + i) {
        localObject2 = (String)localIterator.next();
      }
      label191:
      com.tencent.mm.plugin.report.service.g.yhR.dD(931, 27);
    }
    AppMethodBeat.o(194659);
    return i;
  }
  
  public final void a(int paramInt, n arg2, Object paramObject)
  {
    AppMethodBeat.i(194657);
    if (!(paramObject instanceof String))
    {
      ad.d("MicroMsg.ConversationUnreadHelper", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), ???, paramObject });
      AppMethodBeat.o(194657);
      return;
    }
    paramObject = (String)paramObject;
    ad.i("MicroMsg.ConversationUnreadHelper", "onNotifyChange %s", new Object[] { paramObject });
    long l;
    if ((??? instanceof bq))
    {
      if (x.aBp().contains(paramObject)) {
        break label434;
      }
      if (paramInt == 5) {
        synchronized (KtK)
        {
          KtK.clear();
          AppMethodBeat.o(194657);
          return;
        }
      }
      l = bt.HI();
    }
    for (;;)
    {
      synchronized (KtK)
      {
        ad.i("MicroMsg.ConversationUnreadHelper", "refreshPartial start");
        if (KtK.isEmpty())
        {
          AppMethodBeat.o(194657);
          return;
        }
        if (!KtK.containsKey(paramObject)) {
          break label446;
        }
        paramInt = ((Integer)KtK.get(paramObject)).intValue();
        ad.i("MicroMsg.ConversationUnreadHelper", "refreshPartial getUnread %s", new Object[] { paramObject });
        if (x.AD(paramObject)) {
          break label440;
        }
        i = x.aF(paramObject, w.hFd);
        KtK.put(paramObject, Integer.valueOf(i));
        ad.i("MicroMsg.ConversationUnreadHelper", "refreshPartial username %s, preUnread %d, unread %d", new Object[] { paramObject, Integer.valueOf(paramInt), Integer.valueOf(i) });
        ad.i("MicroMsg.ConversationUnreadHelper", "refreshPartial cost %d ms", new Object[] { Long.valueOf(bt.aO(l)) });
        AppMethodBeat.o(194657);
        return;
      }
      if ((??? instanceof bp))
      {
        if (!bt.isNullOrNil(paramObject))
        {
          ??? = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(paramObject);
          if ((??? != null) && ((int)???.gfj > 0) && (!w.zC(paramObject))) {
            ad.i("MicroMsg.ConversationUnreadHelper", "onContactStorageNotifyChange contact isMute %s, ChatRoomNotify %d", new Object[] { Boolean.valueOf(???.Pf()), Integer.valueOf(???.ePs) });
          }
        }
        else
        {
          if ((paramInt != 5) && (paramInt != 2) && (!this.EOS)) {
            break label404;
          }
          AppMethodBeat.o(194657);
          return;
        }
        AppMethodBeat.o(194657);
        return;
        synchronized (KtK)
        {
          label404:
          KtK.clear();
          AppMethodBeat.o(194657);
          return;
        }
      }
      label434:
      AppMethodBeat.o(194657);
      return;
      label440:
      int i = 0;
      continue;
      label446:
      paramInt = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.h
 * JD-Core Version:    0.7.0.1
 */