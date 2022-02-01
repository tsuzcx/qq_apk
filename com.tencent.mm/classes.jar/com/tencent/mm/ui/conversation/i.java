package com.tencent.mm.ui.conversation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.d;
import com.tencent.mm.f.a.df;
import com.tencent.mm.f.a.jc;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ac;
import com.tencent.mm.plugin.messenger.foundation.a.n;
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

public final class i
  implements MStorageEx.IOnStorageChange
{
  public static i XBh;
  private static HashMap<String, Integer> XBi;
  private IListener<jc> XBj;
  private volatile boolean jxo;
  private IListener<df> jxr;
  
  static
  {
    AppMethodBeat.i(289253);
    XBh = new i();
    XBi = new HashMap();
    AppMethodBeat.o(289253);
  }
  
  private i()
  {
    AppMethodBeat.i(289249);
    this.jxr = new IListener() {};
    this.XBj = new IListener() {};
    this.jxr.alive();
    this.XBj.alive();
    AppMethodBeat.o(289249);
  }
  
  public static int hWh()
  {
    AppMethodBeat.i(289251);
    com.tencent.mm.plugin.report.service.h.IzE.el(931, 25);
    Log.i("MicroMsg.ConversationUnreadHelper", "getTotalUnread %s", new Object[] { Util.getStack() });
    Object localObject2;
    int i;
    synchronized (XBi)
    {
      if (!XBi.isEmpty()) {
        break label189;
      }
      HashMap localHashMap2 = ac.uN(1);
      localObject2 = localHashMap2.keySet().iterator();
      if (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        i = ((az)localHashMap2.get(str)).field_unReadCount;
        XBi.put(str, Integer.valueOf(i));
      }
    }
    com.tencent.mm.plugin.report.service.h.IzE.el(931, 26);
    for (;;)
    {
      Iterator localIterator = XBi.keySet().iterator();
      for (i = 0; localIterator.hasNext(); i = ((Integer)XBi.get(localObject2)).intValue() + i) {
        localObject2 = (String)localIterator.next();
      }
      label189:
      com.tencent.mm.plugin.report.service.h.IzE.el(931, 27);
    }
    AppMethodBeat.o(289251);
    return i;
  }
  
  public final void onNotifyChange(int paramInt, MStorageEx arg2, Object paramObject)
  {
    AppMethodBeat.i(289250);
    if (!(paramObject instanceof String))
    {
      Log.d("MicroMsg.ConversationUnreadHelper", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), ???, paramObject });
      AppMethodBeat.o(289250);
      return;
    }
    String str = (String)paramObject;
    boolean bool = this.jxo;
    if (??? != null) {
      paramObject = ???.toString();
    }
    long l;
    for (;;)
    {
      Log.i("MicroMsg.ConversationUnreadHelper", "onNotifyChange username:%s isIniting:%s stg:%s", new Object[] { str, Boolean.valueOf(bool), paramObject });
      if ((??? instanceof bw))
      {
        if (ac.beg().contains(str)) {
          break label481;
        }
        if (paramInt == 5) {}
        synchronized (XBi)
        {
          XBi.clear();
          AppMethodBeat.o(289250);
          return;
          paramObject = "null";
        }
      }
    }
    for (;;)
    {
      synchronized (XBi)
      {
        Log.i("MicroMsg.ConversationUnreadHelper", "refreshPartial start");
        if (XBi.isEmpty())
        {
          AppMethodBeat.o(289250);
          return;
        }
        if (!XBi.containsKey(str)) {
          break label493;
        }
        paramInt = ((Integer)XBi.get(str)).intValue();
        Log.i("MicroMsg.ConversationUnreadHelper", "refreshPartial getUnread %s", new Object[] { str });
        if (ac.Rk(str)) {
          break label487;
        }
        i = ac.aM(str, ab.lsA);
        XBi.put(str, Integer.valueOf(i));
        Log.i("MicroMsg.ConversationUnreadHelper", "refreshPartial username %s, preUnread %d, unread %d", new Object[] { str, Integer.valueOf(paramInt), Integer.valueOf(i) });
        Log.i("MicroMsg.ConversationUnreadHelper", "refreshPartial cost %d ms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
        AppMethodBeat.o(289250);
        return;
      }
      if ((??? instanceof bv))
      {
        if ((paramInt == 5) || (paramInt == 2) || (this.jxo))
        {
          AppMethodBeat.o(289250);
          return;
        }
        if (!Util.isNullOrNil(str))
        {
          ??? = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(str);
          if ((??? == null) || ((int)???.jxt <= 0) || (ab.Qk(str))) {
            break label465;
          }
          Log.i("MicroMsg.ConversationUnreadHelper", "onContactStorageNotifyChange contact isMute %s, ChatRoomNotify %d", new Object[] { Boolean.valueOf(???.aeg()), Integer.valueOf(???.hDj) });
        }
        synchronized (XBi)
        {
          XBi.clear();
          AppMethodBeat.o(289250);
          return;
          label465:
          AppMethodBeat.o(289250);
          return;
        }
      }
      label481:
      AppMethodBeat.o(289250);
      return;
      label487:
      int i = 0;
      continue;
      label493:
      paramInt = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.i
 * JD-Core Version:    0.7.0.1
 */