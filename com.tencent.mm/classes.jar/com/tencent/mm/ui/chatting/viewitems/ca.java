package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.cc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class ca
{
  private static final List<c> aeYb;
  
  static
  {
    AppMethodBeat.i(37561);
    ArrayList localArrayList = new ArrayList();
    aeYb = localArrayList;
    localArrayList.add(new bj.b());
    aeYb.add(new bj.a());
    aeYb.add(new o.c());
    aeYb.add(new o.b());
    aeYb.add(new e.e());
    aeYb.add(new e.d());
    aeYb.add(new y.c());
    aeYb.add(new y.b());
    aeYb.add(new ai.c());
    aeYb.add(new ai.b());
    aeYb.add(new x.c());
    aeYb.add(new x.b());
    aeYb.add(new ab.c());
    aeYb.add(new ab.b());
    aeYb.add(new m.d());
    aeYb.add(new m.c());
    aeYb.add(new ac.b());
    aeYb.add(new ac.a());
    aeYb.add(new bg());
    aeYb.add(new az.b());
    aeYb.add(new as.b());
    aeYb.add(new as.a());
    aeYb.add(new bl.a());
    aeYb.add(new bl.b());
    aeYb.add(new bb.a());
    aeYb.add(new ao.c());
    aeYb.add(new ao.b());
    aeYb.add(new at.a());
    aeYb.add(new bk.b());
    aeYb.add(new bk.a());
    aeYb.add(new ba.b());
    aeYb.add(new ba.a());
    aeYb.add(new bp.f());
    aeYb.add(new bp.c());
    aeYb.add(new bp.g());
    aeYb.add(new am.j());
    aeYb.add(new bp.d());
    aeYb.add(new bp.e());
    aeYb.add(new bo());
    aeYb.add(new bm());
    aeYb.add(new bn());
    aeYb.add(new be.a());
    aeYb.add(new be.b());
    aeYb.add(new bq.c());
    aeYb.add(new bq.b());
    aeYb.add(new aq());
    aeYb.add(new au());
    aeYb.add(new d());
    aeYb.add(new aa.b());
    aeYb.add(new aa.c());
    aeYb.add(new aw());
    aeYb.add(new ax());
    aeYb.add(new ay());
    aeYb.add(new af.c());
    aeYb.add(new af.b());
    aeYb.add(new f.c());
    aeYb.add(new f.b());
    aeYb.add(new k.c());
    aeYb.add(new k.b());
    aeYb.add(new i.c());
    aeYb.add(new i.b());
    aeYb.add(new j.c());
    aeYb.add(new j.b());
    aeYb.add(new ak.b());
    aeYb.add(new ak.a());
    aeYb.add(new al.b());
    aeYb.add(new al.a());
    aeYb.add(new aj.b());
    aeYb.add(new aj.a());
    aeYb.add(new z.c());
    aeYb.add(new z.b());
    aeYb.add(new az.a());
    aeYb.add(new g.c());
    aeYb.add(new g.b());
    aeYb.add(new h.c());
    aeYb.add(new h.b());
    aeYb.add(new l.c());
    aeYb.add(new ad());
    aeYb.add(new ChattingItemAppMsgFinderFeed.b());
    aeYb.add(new ChattingItemAppMsgFinderFeed.c());
    aeYb.add(new ChattingItemAppMsgMegaVideo.b());
    aeYb.add(new ChattingItemAppMsgMegaVideo.c());
    aeYb.add(new v.b());
    aeYb.add(new v.c());
    aeYb.add(new p.b());
    aeYb.add(new p.c());
    aeYb.add(new q.b());
    aeYb.add(new q.c());
    aeYb.add(new r.b());
    aeYb.add(new r.c());
    aeYb.add(new t.b());
    aeYb.add(new t.c());
    aeYb.add(new ChatingItemAppMsgFinderLiveFeed.b());
    aeYb.add(new ChatingItemAppMsgFinderLiveFeed.c());
    aeYb.add(new ChattingItemAppMsgFinderProduct.a());
    aeYb.add(new ChattingItemAppMsgFinderProduct.b());
    aeYb.add(new ah.a());
    aeYb.add(new ah.b());
    aeYb.add(new w.b());
    aeYb.add(new w.c());
    aeYb.add(new ae());
    aeYb.add(new ag());
    aeYb.add(new s.a());
    aeYb.add(new s.b());
    aeYb.add(new u.b());
    aeYb.add(new u.c());
    aeYb.add(new n.a());
    aeYb.add(new n.b());
    aeYb.add(new bd.c());
    aeYb.add(new bd.d());
    aeYb.add(new bj.b()
    {
      public final boolean cM(int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(37556);
        Log.w("MicroMsg.Chatting.ItemFactory", "unfound msgType:%d, isSender:%b", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(paramAnonymousBoolean) });
        AppMethodBeat.o(37556);
        return paramAnonymousBoolean;
      }
    });
    aeYb.add(new bj.a()
    {
      public final boolean cM(int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(37557);
        Log.w("MicroMsg.Chatting.ItemFactory", "unfound msgType:%d, isSender:%b", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(paramAnonymousBoolean) });
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(37557);
          return true;
        }
        AppMethodBeat.o(37557);
        return false;
      }
    });
    AppMethodBeat.o(37561);
  }
  
  public static c dK(cc paramcc)
  {
    AppMethodBeat.i(37558);
    int i = dM(paramcc);
    Iterator localIterator = aeYb.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if (paramcc.field_isSend == 1) {}
      for (boolean bool = true; localc.cM(i, bool); bool = false) {
        try
        {
          localc = (c)localc.getClass().newInstance();
          AppMethodBeat.o(37558);
          return localc;
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace("MicroMsg.Chatting.ItemFactory", localException, "", new Object[0]);
        }
      }
    }
    paramcc = new bj.a();
    AppMethodBeat.o(37558);
    return paramcc;
  }
  
  public static int dL(cc paramcc)
  {
    AppMethodBeat.i(37560);
    if (paramcc.getType() == 49)
    {
      i = n.h(com.tencent.mm.message.k.b.Hf(paramcc.field_content));
      Log.d("MicroMsg.Chatting.ItemFactory", "maybe honeypay need change type: %s", new Object[] { Integer.valueOf(i) });
      if ((i != 49) && (i != 1090519089))
      {
        paramcc.setType(i);
        bh.bCz();
        com.tencent.mm.model.c.bzD().a(paramcc.field_msgId, paramcc);
      }
    }
    int j = dM(paramcc);
    int i = 0;
    while (i < aeYb.size())
    {
      c localc = (c)aeYb.get(i);
      if (paramcc.field_isSend == 1) {}
      for (boolean bool = true; localc.cM(j, bool); bool = false)
      {
        AppMethodBeat.o(37560);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(37560);
    return 0;
  }
  
  private static int dM(cc paramcc)
  {
    AppMethodBeat.i(255236);
    int j = paramcc.getType();
    int i = j;
    com.tencent.mm.message.k.b localb;
    if (paramcc.getType() == 49)
    {
      localb = com.tencent.mm.message.k.b.Hf(paramcc.field_content);
      i = j;
      if (localb != null) {
        switch (localb.type)
        {
        }
      }
    }
    for (i = j;; i = 1090519089)
    {
      AppMethodBeat.o(255236);
      return i;
      Log.i("MicroMsg.Chatting.ItemFactory", "createItem %s %s %s", new Object[] { Long.valueOf(paramcc.field_msgId), Integer.valueOf(j), Integer.valueOf(localb.type) });
    }
  }
  
  public static int jxD()
  {
    AppMethodBeat.i(37559);
    int i = aeYb.size();
    AppMethodBeat.o(37559);
    return i + 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ca
 * JD-Core Version:    0.7.0.1
 */