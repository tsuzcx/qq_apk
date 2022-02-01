package com.tencent.mm.ui.conversation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cu;
import com.tencent.mm.g.a.hp;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.az;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class h
  implements n.b
{
  public static h ICD;
  private static HashMap<String, Integer> ICE;
  private volatile boolean ICF;
  private c<cu> ICG;
  private c<hp> ICH;
  
  static
  {
    AppMethodBeat.i(196818);
    ICD = new h();
    ICE = new HashMap();
    AppMethodBeat.o(196818);
  }
  
  private h()
  {
    AppMethodBeat.i(196812);
    this.ICG = new c() {};
    this.ICH = new c() {};
    this.ICG.alive();
    this.ICH.alive();
    AppMethodBeat.o(196812);
  }
  
  private static void frZ()
  {
    AppMethodBeat.i(196814);
    long l = bs.Gn();
    synchronized (ICE)
    {
      ICE.clear();
      HashMap localHashMap2 = x.xD(w.hmN);
      Iterator localIterator = localHashMap2.keySet().iterator();
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        int i = ((ap)localHashMap2.get(str)).field_unReadCount;
        ICE.put(str, Integer.valueOf(i));
        ac.i("MicroMsg.ConversationUnreadHelper", "refreshAll, (%s , %d)", new Object[] { str, Integer.valueOf(i) });
      }
    }
    ac.i("MicroMsg.ConversationUnreadHelper", "refreshAll cost %d ms", new Object[] { Long.valueOf(bs.aO(l)) });
    AppMethodBeat.o(196814);
  }
  
  public static void fsa()
  {
    AppMethodBeat.i(196815);
    synchronized (ICE)
    {
      if (!ICE.isEmpty())
      {
        Iterator localIterator = ICE.keySet().iterator();
        if (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          ac.i("MicroMsg.ConversationUnreadHelper", "debug unread, (%s, %s, %d)", new Object[] { str, ((com.tencent.mm.plugin.messenger.a.b)g.ab(com.tencent.mm.plugin.messenger.a.b.class)).wk(str), ICE.get(str) });
        }
      }
    }
    AppMethodBeat.o(196815);
  }
  
  public static int fsb()
  {
    AppMethodBeat.i(196816);
    ac.i("MicroMsg.ConversationUnreadHelper", "getTotalUnread %s", new Object[] { bs.eWi() });
    com.tencent.mm.plugin.report.service.h.wUl.dB(931, 25);
    int i;
    synchronized (ICE)
    {
      if (ICE.isEmpty())
      {
        frZ();
        com.tencent.mm.plugin.report.service.h.wUl.dB(931, 26);
        Iterator localIterator = ICE.keySet().iterator();
        String str;
        for (i = 0; localIterator.hasNext(); i = ((Integer)ICE.get(str)).intValue() + i)
        {
          str = (String)localIterator.next();
          ac.i("MicroMsg.ConversationUnreadHelper", "getTotalUnread, (%s , %d)", new Object[] { str, ICE.get(str) });
        }
      }
      com.tencent.mm.plugin.report.service.h.wUl.dB(931, 27);
    }
    AppMethodBeat.o(196816);
    return i;
  }
  
  public final void a(int paramInt, n arg2, Object paramObject)
  {
    AppMethodBeat.i(196813);
    if (!(paramObject instanceof String))
    {
      ac.d("MicroMsg.ConversationUnreadHelper", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), ???, paramObject });
      AppMethodBeat.o(196813);
      return;
    }
    paramObject = (String)paramObject;
    ac.i("MicroMsg.ConversationUnreadHelper", "onNotifyChange %s", new Object[] { paramObject });
    long l;
    if ((??? instanceof bk))
    {
      if (x.ayp().contains(paramObject)) {
        break label422;
      }
      if (paramInt == 5) {
        synchronized (ICE)
        {
          ICE.clear();
          AppMethodBeat.o(196813);
          return;
        }
      }
      l = bs.Gn();
    }
    for (;;)
    {
      synchronized (ICE)
      {
        ac.i("MicroMsg.ConversationUnreadHelper", "refreshPartial start");
        if (ICE.isEmpty())
        {
          AppMethodBeat.o(196813);
          return;
        }
        if (!ICE.containsKey(paramObject)) {
          break label434;
        }
        paramInt = ((Integer)ICE.get(paramObject)).intValue();
        ac.i("MicroMsg.ConversationUnreadHelper", "refreshPartial getUnread %s", new Object[] { paramObject });
        if (x.xF(paramObject)) {
          break label428;
        }
        i = x.aD(paramObject, w.hmN);
        ICE.put(paramObject, Integer.valueOf(i));
        ac.i("MicroMsg.ConversationUnreadHelper", "refreshPartial username %s, preUnread %d, unread %d", new Object[] { paramObject, Integer.valueOf(paramInt), Integer.valueOf(i) });
        ac.i("MicroMsg.ConversationUnreadHelper", "refreshPartial cost %d ms", new Object[] { Long.valueOf(bs.aO(l)) });
        AppMethodBeat.o(196813);
        return;
      }
      if ((??? instanceof bj))
      {
        if (!bs.isNullOrNil(paramObject))
        {
          ??? = ((k)g.ab(k.class)).awB().aNt(paramObject);
          if ((??? != null) && ((int)???.fLJ > 0)) {
            ac.i("MicroMsg.ConversationUnreadHelper", "onContactStorageNotifyChange contact isMute %s, ChatRoomNotify %d", new Object[] { Boolean.valueOf(???.Nw()), Integer.valueOf(???.exT) });
          }
        }
        if ((paramInt == 5) || (paramInt == 2) || (this.ICF))
        {
          AppMethodBeat.o(196813);
          return;
        }
        synchronized (ICE)
        {
          ICE.clear();
          AppMethodBeat.o(196813);
          return;
        }
      }
      label422:
      AppMethodBeat.o(196813);
      return;
      label428:
      int i = 0;
      continue;
      label434:
      paramInt = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.h
 * JD-Core Version:    0.7.0.1
 */