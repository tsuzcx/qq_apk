package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class bz
{
  private static final List<c> XmV;
  
  static
  {
    AppMethodBeat.i(37561);
    ArrayList localArrayList = new ArrayList();
    XmV = localArrayList;
    localArrayList.add(new bi.b());
    XmV.add(new bi.a());
    XmV.add(new o.c());
    XmV.add(new o.b());
    XmV.add(new e.e());
    XmV.add(new e.d());
    XmV.add(new z.c());
    XmV.add(new z.b());
    XmV.add(new aj.c());
    XmV.add(new aj.b());
    XmV.add(new y.c());
    XmV.add(new y.b());
    XmV.add(new ad.c());
    XmV.add(new ad.b());
    XmV.add(new m.d());
    XmV.add(new m.c());
    XmV.add(new ae.b());
    XmV.add(new ae.a());
    XmV.add(new bf());
    XmV.add(new az.b());
    XmV.add(new at.b());
    XmV.add(new at.a());
    XmV.add(new bk.a());
    XmV.add(new bk.b());
    XmV.add(new bb.a());
    XmV.add(new ap.c());
    XmV.add(new ap.b());
    XmV.add(new au.a());
    XmV.add(new bj.b());
    XmV.add(new bj.a());
    XmV.add(new ba.b());
    XmV.add(new ba.a());
    XmV.add(new bo.f());
    XmV.add(new bo.c());
    XmV.add(new bo.g());
    XmV.add(new an.j());
    XmV.add(new bo.d());
    XmV.add(new bo.e());
    XmV.add(new bn());
    XmV.add(new bl());
    XmV.add(new bm());
    XmV.add(new bd.a());
    XmV.add(new bd.b());
    XmV.add(new bp.c());
    XmV.add(new bp.b());
    XmV.add(new ar());
    XmV.add(new av());
    XmV.add(new d());
    XmV.add(new ab.b());
    XmV.add(new ab.c());
    XmV.add(new aw());
    XmV.add(new ax());
    XmV.add(new ay());
    XmV.add(new ah.c());
    XmV.add(new ah.b());
    XmV.add(new f.c());
    XmV.add(new f.b());
    XmV.add(new k.c());
    XmV.add(new k.b());
    XmV.add(new i.c());
    XmV.add(new i.b());
    XmV.add(new j.c());
    XmV.add(new j.b());
    XmV.add(new al.b());
    XmV.add(new al.a());
    XmV.add(new am.b());
    XmV.add(new am.a());
    XmV.add(new ak.b());
    XmV.add(new ak.a());
    XmV.add(new aa.c());
    XmV.add(new aa.b());
    XmV.add(new az.a());
    XmV.add(new g.c());
    XmV.add(new g.b());
    XmV.add(new h.c());
    XmV.add(new h.b());
    XmV.add(new l.c());
    XmV.add(new af());
    XmV.add(new s.b());
    XmV.add(new s.c());
    XmV.add(new ac.b());
    XmV.add(new ac.c());
    XmV.add(new w.b());
    XmV.add(new w.c());
    XmV.add(new p.b());
    XmV.add(new p.c());
    XmV.add(new q.b());
    XmV.add(new q.c());
    XmV.add(new r.b());
    XmV.add(new r.c());
    XmV.add(new u.b());
    XmV.add(new u.c());
    XmV.add(new ChatingItemAppMsgFinderLiveFeed.a());
    XmV.add(new ChatingItemAppMsgFinderLiveFeed.b());
    XmV.add(new ai.a());
    XmV.add(new ai.b());
    XmV.add(new x.b());
    XmV.add(new x.c());
    XmV.add(new ag());
    XmV.add(new t.a());
    XmV.add(new t.b());
    XmV.add(new v.b());
    XmV.add(new v.c());
    XmV.add(new n.a());
    XmV.add(new n.b());
    XmV.add(new bi.b()
    {
      public final boolean bZ(int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(37556);
        Log.w("MicroMsg.Chatting.ItemFactory", "unfound msgType:%d, isSender:%b", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(paramAnonymousBoolean) });
        AppMethodBeat.o(37556);
        return paramAnonymousBoolean;
      }
    });
    XmV.add(new bi.a()
    {
      public final boolean bZ(int paramAnonymousInt, boolean paramAnonymousBoolean)
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
  
  public static c dk(ca paramca)
  {
    AppMethodBeat.i(37558);
    int i = dm(paramca);
    Iterator localIterator = XmV.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if (paramca.field_isSend == 1) {}
      for (boolean bool = true; localc.bZ(i, bool); bool = false) {
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
    paramca = new bi.a();
    AppMethodBeat.o(37558);
    return paramca;
  }
  
  public static int dl(ca paramca)
  {
    AppMethodBeat.i(37560);
    if (paramca.getType() == 49)
    {
      i = m.g(com.tencent.mm.aj.k.b.OQ(paramca.field_content));
      Log.d("MicroMsg.Chatting.ItemFactory", "maybe honeypay need change type: %s", new Object[] { Integer.valueOf(i) });
      if ((i != 49) && (i != 1090519089))
      {
        paramca.setType(i);
        bh.beI();
        com.tencent.mm.model.c.bbO().a(paramca.field_msgId, paramca);
      }
    }
    int j = dm(paramca);
    int i = 0;
    while (i < XmV.size())
    {
      c localc = (c)XmV.get(i);
      if (paramca.field_isSend == 1) {}
      for (boolean bool = true; localc.bZ(j, bool); bool = false)
      {
        AppMethodBeat.o(37560);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(37560);
    return 0;
  }
  
  private static int dm(ca paramca)
  {
    AppMethodBeat.i(280168);
    int j = paramca.getType();
    int i = j;
    com.tencent.mm.aj.k.b localb;
    if (paramca.getType() == 49)
    {
      localb = com.tencent.mm.aj.k.b.OQ(paramca.field_content);
      i = j;
      if (localb != null) {
        switch (localb.type)
        {
        }
      }
    }
    for (i = j;; i = 1090519089)
    {
      AppMethodBeat.o(280168);
      return i;
      Log.i("MicroMsg.Chatting.ItemFactory", "createItem %s %s %s", new Object[] { Long.valueOf(paramca.field_msgId), Integer.valueOf(j), Integer.valueOf(localb.type) });
    }
  }
  
  public static int hTY()
  {
    AppMethodBeat.i(37559);
    int i = XmV.size();
    AppMethodBeat.o(37559);
    return i + 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bz
 * JD-Core Version:    0.7.0.1
 */