package com.tencent.mm.ui.conversation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.c;
import com.tencent.mm.g.a.db;
import com.tencent.mm.g.a.im;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ac;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class h
  implements MStorageEx.IOnStorageChange
{
  public static h Qdi;
  private static HashMap<String, Integer> Qdj;
  private volatile boolean JYf;
  private IListener<db> JYh;
  private IListener<im> Qdk;
  
  static
  {
    AppMethodBeat.i(234150);
    Qdi = new h();
    Qdj = new HashMap();
    AppMethodBeat.o(234150);
  }
  
  private h()
  {
    AppMethodBeat.i(234146);
    this.JYh = new IListener() {};
    this.Qdk = new IListener() {};
    this.JYh.alive();
    this.Qdk.alive();
    AppMethodBeat.o(234146);
  }
  
  public static int gVB()
  {
    AppMethodBeat.i(234148);
    Log.i("MicroMsg.ConversationUnreadHelper", "getTotalUnread %s", new Object[] { Util.getStack() });
    com.tencent.mm.plugin.report.service.h.CyF.dN(931, 25);
    Object localObject2;
    int i;
    synchronized (Qdj)
    {
      if (!Qdj.isEmpty()) {
        break label191;
      }
      HashMap localHashMap2 = ac.JQ(ab.iCF);
      localObject2 = localHashMap2.keySet().iterator();
      if (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        i = ((az)localHashMap2.get(str)).field_unReadCount;
        Qdj.put(str, Integer.valueOf(i));
      }
    }
    com.tencent.mm.plugin.report.service.h.CyF.dN(931, 26);
    for (;;)
    {
      Iterator localIterator = Qdj.keySet().iterator();
      for (i = 0; localIterator.hasNext(); i = ((Integer)Qdj.get(localObject2)).intValue() + i) {
        localObject2 = (String)localIterator.next();
      }
      label191:
      com.tencent.mm.plugin.report.service.h.CyF.dN(931, 27);
    }
    AppMethodBeat.o(234148);
    return i;
  }
  
  public final void onNotifyChange(int paramInt, MStorageEx arg2, Object paramObject)
  {
    AppMethodBeat.i(234147);
    if (!(paramObject instanceof String))
    {
      Log.d("MicroMsg.ConversationUnreadHelper", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), ???, paramObject });
      AppMethodBeat.o(234147);
      return;
    }
    paramObject = (String)paramObject;
    Log.i("MicroMsg.ConversationUnreadHelper", "onNotifyChange %s", new Object[] { paramObject });
    long l;
    if ((??? instanceof bw))
    {
      if (ac.aVd().contains(paramObject)) {
        break label435;
      }
      if (paramInt == 5) {
        synchronized (Qdj)
        {
          Qdj.clear();
          AppMethodBeat.o(234147);
          return;
        }
      }
      l = Util.currentTicks();
    }
    for (;;)
    {
      synchronized (Qdj)
      {
        Log.i("MicroMsg.ConversationUnreadHelper", "refreshPartial start");
        if (Qdj.isEmpty())
        {
          AppMethodBeat.o(234147);
          return;
        }
        if (!Qdj.containsKey(paramObject)) {
          break label447;
        }
        paramInt = ((Integer)Qdj.get(paramObject)).intValue();
        Log.i("MicroMsg.ConversationUnreadHelper", "refreshPartial getUnread %s", new Object[] { paramObject });
        if (ac.JS(paramObject)) {
          break label441;
        }
        i = ac.aI(paramObject, ab.iCF);
        Qdj.put(paramObject, Integer.valueOf(i));
        Log.i("MicroMsg.ConversationUnreadHelper", "refreshPartial username %s, preUnread %d, unread %d", new Object[] { paramObject, Integer.valueOf(paramInt), Integer.valueOf(i) });
        Log.i("MicroMsg.ConversationUnreadHelper", "refreshPartial cost %d ms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
        AppMethodBeat.o(234147);
        return;
      }
      if ((??? instanceof bv))
      {
        if (!Util.isNullOrNil(paramObject))
        {
          ??? = ((l)g.af(l.class)).aSN().Kn(paramObject);
          if ((??? != null) && ((int)???.gMZ > 0) && (!ab.IR(paramObject))) {
            Log.i("MicroMsg.ConversationUnreadHelper", "onContactStorageNotifyChange contact isMute %s, ChatRoomNotify %d", new Object[] { Boolean.valueOf(???.Zx()), Integer.valueOf(???.fuH) });
          }
        }
        else
        {
          if ((paramInt != 5) && (paramInt != 2) && (!this.JYf)) {
            break label405;
          }
          AppMethodBeat.o(234147);
          return;
        }
        AppMethodBeat.o(234147);
        return;
        synchronized (Qdj)
        {
          label405:
          Qdj.clear();
          AppMethodBeat.o(234147);
          return;
        }
      }
      label435:
      AppMethodBeat.o(234147);
      return;
      label441:
      int i = 0;
      continue;
      label447:
      paramInt = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.h
 * JD-Core Version:    0.7.0.1
 */