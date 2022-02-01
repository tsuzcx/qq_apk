package com.tencent.mm.ui.conversation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cy;
import com.tencent.mm.g.a.hx;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.model.x;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class h
  implements n.b
{
  public static h KQd;
  private static HashMap<String, Integer> KQe;
  private volatile boolean Fhn;
  private com.tencent.mm.sdk.b.c<cy> Fho;
  private com.tencent.mm.sdk.b.c<hx> KQf;
  
  static
  {
    AppMethodBeat.i(188062);
    KQd = new h();
    KQe = new HashMap();
    AppMethodBeat.o(188062);
  }
  
  private h()
  {
    AppMethodBeat.i(188058);
    this.Fho = new com.tencent.mm.sdk.b.c() {};
    this.KQf = new com.tencent.mm.sdk.b.c() {};
    this.Fho.alive();
    this.KQf.alive();
    AppMethodBeat.o(188058);
  }
  
  public static int fNg()
  {
    AppMethodBeat.i(188060);
    ae.i("MicroMsg.ConversationUnreadHelper", "getTotalUnread %s", new Object[] { bu.fpN() });
    com.tencent.mm.plugin.report.service.g.yxI.dD(931, 25);
    Object localObject2;
    int i;
    synchronized (KQe)
    {
      if (!KQe.isEmpty()) {
        break label191;
      }
      HashMap localHashMap2 = y.Bl(x.hHV);
      localObject2 = localHashMap2.keySet().iterator();
      if (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        i = ((au)localHashMap2.get(str)).field_unReadCount;
        KQe.put(str, Integer.valueOf(i));
      }
    }
    com.tencent.mm.plugin.report.service.g.yxI.dD(931, 26);
    for (;;)
    {
      Iterator localIterator = KQe.keySet().iterator();
      for (i = 0; localIterator.hasNext(); i = ((Integer)KQe.get(localObject2)).intValue() + i) {
        localObject2 = (String)localIterator.next();
      }
      label191:
      com.tencent.mm.plugin.report.service.g.yxI.dD(931, 27);
    }
    AppMethodBeat.o(188060);
    return i;
  }
  
  public final void a(int paramInt, n arg2, Object paramObject)
  {
    AppMethodBeat.i(188059);
    if (!(paramObject instanceof String))
    {
      ae.d("MicroMsg.ConversationUnreadHelper", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), ???, paramObject });
      AppMethodBeat.o(188059);
      return;
    }
    paramObject = (String)paramObject;
    ae.i("MicroMsg.ConversationUnreadHelper", "onNotifyChange %s", new Object[] { paramObject });
    long l;
    if ((??? instanceof br))
    {
      if (y.aBF().contains(paramObject)) {
        break label434;
      }
      if (paramInt == 5) {
        synchronized (KQe)
        {
          KQe.clear();
          AppMethodBeat.o(188059);
          return;
        }
      }
      l = bu.HQ();
    }
    for (;;)
    {
      synchronized (KQe)
      {
        ae.i("MicroMsg.ConversationUnreadHelper", "refreshPartial start");
        if (KQe.isEmpty())
        {
          AppMethodBeat.o(188059);
          return;
        }
        if (!KQe.containsKey(paramObject)) {
          break label446;
        }
        paramInt = ((Integer)KQe.get(paramObject)).intValue();
        ae.i("MicroMsg.ConversationUnreadHelper", "refreshPartial getUnread %s", new Object[] { paramObject });
        if (y.Bn(paramObject)) {
          break label440;
        }
        i = y.aG(paramObject, x.hHV);
        KQe.put(paramObject, Integer.valueOf(i));
        ae.i("MicroMsg.ConversationUnreadHelper", "refreshPartial username %s, preUnread %d, unread %d", new Object[] { paramObject, Integer.valueOf(paramInt), Integer.valueOf(i) });
        ae.i("MicroMsg.ConversationUnreadHelper", "refreshPartial cost %d ms", new Object[] { Long.valueOf(bu.aO(l)) });
        AppMethodBeat.o(188059);
        return;
      }
      if ((??? instanceof bq))
      {
        if (!bu.isNullOrNil(paramObject))
        {
          ??? = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(paramObject);
          if ((??? != null) && ((int)???.ght > 0) && (!x.Am(paramObject))) {
            ae.i("MicroMsg.ConversationUnreadHelper", "onContactStorageNotifyChange contact isMute %s, ChatRoomNotify %d", new Object[] { Boolean.valueOf(???.Pd()), Integer.valueOf(???.eRd) });
          }
        }
        else
        {
          if ((paramInt != 5) && (paramInt != 2) && (!this.Fhn)) {
            break label404;
          }
          AppMethodBeat.o(188059);
          return;
        }
        AppMethodBeat.o(188059);
        return;
        synchronized (KQe)
        {
          label404:
          KQe.clear();
          AppMethodBeat.o(188059);
          return;
        }
      }
      label434:
      AppMethodBeat.o(188059);
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