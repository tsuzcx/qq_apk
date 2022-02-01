package com.tencent.mm.ui.conversation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.dp;
import com.tencent.mm.autogen.a.kd;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.contact.d;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ac;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class j
  implements MStorageEx.IOnStorageChange
{
  public static j afnT;
  private static HashMap<String, Integer> afnU;
  private IListener<kd> afnV;
  private volatile boolean maI;
  private IListener<dp> maL;
  
  static
  {
    AppMethodBeat.i(256987);
    afnT = new j();
    afnU = new HashMap();
    AppMethodBeat.o(256987);
  }
  
  private j()
  {
    AppMethodBeat.i(256959);
    this.maL = new ConversationUnreadHelper.1(this, f.hfK);
    this.afnV = new ConversationUnreadHelper.2(this, f.hfK);
    this.maL.alive();
    this.afnV.alive();
    AppMethodBeat.o(256959);
  }
  
  public static int jAf()
  {
    AppMethodBeat.i(256969);
    com.tencent.mm.plugin.report.service.h.OAn.kJ(931, 25);
    Log.i("MicroMsg.ConversationUnreadHelper", "getTotalUnread %s", new Object[] { Util.getStack() });
    long l;
    Object localObject2;
    int i;
    synchronized (afnU)
    {
      if (!afnU.isEmpty()) {
        break label226;
      }
      l = Util.currentTicks();
      HashMap localHashMap2 = ac.bBZ();
      localObject2 = localHashMap2.keySet().iterator();
      if (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        i = ((bb)localHashMap2.get(str)).field_unReadCount;
        afnU.put(str, Integer.valueOf(i));
      }
    }
    com.tencent.mm.plugin.report.service.h.OAn.kJ(931, 26);
    Log.d("MicroMsg.ConversationUnreadHelper", "getTotalUnread cost %d ms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
    for (;;)
    {
      Iterator localIterator = afnU.keySet().iterator();
      for (i = 0; localIterator.hasNext(); i = ((Integer)afnU.get(localObject2)).intValue() + i) {
        localObject2 = (String)localIterator.next();
      }
      label226:
      com.tencent.mm.plugin.report.service.h.OAn.kJ(931, 27);
    }
    AppMethodBeat.o(256969);
    return i;
  }
  
  public final void onNotifyChange(int paramInt, MStorageEx arg2, Object paramObject)
  {
    AppMethodBeat.i(256996);
    if (!(paramObject instanceof String))
    {
      Log.d("MicroMsg.ConversationUnreadHelper", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), ???, paramObject });
      AppMethodBeat.o(256996);
      return;
    }
    String str = (String)paramObject;
    boolean bool = this.maI;
    if (??? != null) {
      paramObject = ???.toString();
    }
    long l;
    for (;;)
    {
      Log.i("MicroMsg.ConversationUnreadHelper", "onNotifyChange username:%s isIniting:%s stg:%s", new Object[] { str, Boolean.valueOf(bool), paramObject });
      if ((??? instanceof by))
      {
        if (ac.bCa().contains(str)) {
          break label481;
        }
        if (paramInt == 5) {}
        synchronized (afnU)
        {
          afnU.clear();
          AppMethodBeat.o(256996);
          return;
          paramObject = "null";
        }
      }
    }
    for (;;)
    {
      synchronized (afnU)
      {
        Log.i("MicroMsg.ConversationUnreadHelper", "refreshPartial start");
        if (afnU.isEmpty())
        {
          AppMethodBeat.o(256996);
          return;
        }
        if (!afnU.containsKey(str)) {
          break label493;
        }
        paramInt = ((Integer)afnU.get(str)).intValue();
        Log.i("MicroMsg.ConversationUnreadHelper", "refreshPartial getUnread %s", new Object[] { str });
        if (ac.Ji(str)) {
          break label487;
        }
        i = ac.b(str, ab.ojY);
        afnU.put(str, Integer.valueOf(i));
        Log.i("MicroMsg.ConversationUnreadHelper", "refreshPartial username %s, preUnread %d, unread %d", new Object[] { str, Integer.valueOf(paramInt), Integer.valueOf(i) });
        Log.i("MicroMsg.ConversationUnreadHelper", "refreshPartial cost %d ms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
        AppMethodBeat.o(256996);
        return;
      }
      if ((??? instanceof bx))
      {
        if ((paramInt == 5) || (paramInt == 2) || (this.maI))
        {
          AppMethodBeat.o(256996);
          return;
        }
        if (!Util.isNullOrNil(str))
        {
          ??? = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(str);
          if ((??? == null) || ((int)???.maN <= 0) || (au.bxa(str))) {
            break label465;
          }
          Log.i("MicroMsg.ConversationUnreadHelper", "onContactStorageNotifyChange contact isMute %s, ChatRoomNotify %d", new Object[] { Boolean.valueOf(???.aGe()), Integer.valueOf(???.kaf) });
        }
        synchronized (afnU)
        {
          afnU.clear();
          AppMethodBeat.o(256996);
          return;
          label465:
          AppMethodBeat.o(256996);
          return;
        }
      }
      label481:
      AppMethodBeat.o(256996);
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
 * Qualified Name:     com.tencent.mm.ui.conversation.j
 * JD-Core Version:    0.7.0.1
 */