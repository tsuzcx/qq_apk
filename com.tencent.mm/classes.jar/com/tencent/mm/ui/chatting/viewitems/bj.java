package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.c.du;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class bj
{
  private static final List<c> GQY;
  
  static
  {
    AppMethodBeat.i(37561);
    ArrayList localArrayList = new ArrayList();
    GQY = localArrayList;
    localArrayList.add(new av.b());
    GQY.add(new av.a());
    GQY.add(new e.e());
    GQY.add(new e.d());
    GQY.add(new r.c());
    GQY.add(new r.b());
    GQY.add(new y.c());
    GQY.add(new y.b());
    GQY.add(new q.c());
    GQY.add(new q.b());
    GQY.add(new u.c());
    GQY.add(new u.b());
    GQY.add(new l.d());
    GQY.add(new l.c());
    GQY.add(new as());
    GQY.add(new an.b());
    GQY.add(new ai.b());
    GQY.add(new ai.a());
    GQY.add(new ax.a());
    GQY.add(new ax.b());
    GQY.add(new ap.a());
    GQY.add(new ae.c());
    GQY.add(new ae.b());
    GQY.add(new aj.a());
    GQY.add(new aw.b());
    GQY.add(new aw.a());
    GQY.add(new ao.b());
    GQY.add(new ao.a());
    GQY.add(new bb.f());
    GQY.add(new bb.c());
    GQY.add(new bb.g());
    GQY.add(new ac.j());
    GQY.add(new bb.d());
    GQY.add(new bb.e());
    GQY.add(new ba());
    GQY.add(new ay());
    GQY.add(new az());
    GQY.add(new ar.a());
    GQY.add(new ar.b());
    GQY.add(new bc.c());
    GQY.add(new bc.b());
    GQY.add(new ag());
    GQY.add(new d());
    GQY.add(new t.b());
    GQY.add(new t.c());
    GQY.add(new ak());
    GQY.add(new al());
    GQY.add(new am());
    GQY.add(new x.c());
    GQY.add(new x.b());
    GQY.add(new f.c());
    GQY.add(new f.b());
    GQY.add(new j.c());
    GQY.add(new j.b());
    GQY.add(new h.c());
    GQY.add(new h.b());
    GQY.add(new i.c());
    GQY.add(new i.b());
    GQY.add(new aa.b());
    GQY.add(new aa.a());
    GQY.add(new ab.b());
    GQY.add(new ab.a());
    GQY.add(new z.b());
    GQY.add(new z.a());
    GQY.add(new s.c());
    GQY.add(new s.b());
    GQY.add(new an.a());
    GQY.add(new g.c());
    GQY.add(new g.b());
    GQY.add(new k.c());
    GQY.add(new v());
    GQY.add(new n.b());
    GQY.add(new n.c());
    GQY.add(new p.b());
    GQY.add(new p.c());
    GQY.add(new m.b());
    GQY.add(new m.c());
    GQY.add(new o.b());
    GQY.add(new o.c());
    GQY.add(new br.a());
    GQY.add(new br.b());
    GQY.add(new w());
    GQY.add(new av.b()
    {
      public final boolean aX(int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(37556);
        ad.w("MicroMsg.Chatting.ItemFactory", "unfound msgType:%d, isSender:%b", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(paramAnonymousBoolean) });
        AppMethodBeat.o(37556);
        return paramAnonymousBoolean;
      }
    });
    GQY.add(new av.a()
    {
      public final boolean aX(int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(37557);
        ad.w("MicroMsg.Chatting.ItemFactory", "unfound msgType:%d, isSender:%b", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(paramAnonymousBoolean) });
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
  
  public static c cq(bl parambl)
  {
    AppMethodBeat.i(37558);
    Iterator localIterator = GQY.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      int i = parambl.getType();
      if (parambl.field_isSend == 1) {}
      for (boolean bool = true; localc.aX(i, bool); bool = false) {
        try
        {
          localc = (c)localc.getClass().newInstance();
          AppMethodBeat.o(37558);
          return localc;
        }
        catch (Exception localException)
        {
          ad.printErrStackTrace("MicroMsg.Chatting.ItemFactory", localException, "", new Object[0]);
        }
      }
    }
    parambl = new av.a();
    AppMethodBeat.o(37558);
    return parambl;
  }
  
  public static int cr(bl parambl)
  {
    AppMethodBeat.i(37560);
    if (parambl.getType() == 49)
    {
      i = m.f(k.b.rx(parambl.field_content));
      ad.d("MicroMsg.Chatting.ItemFactory", "maybe honeypay need change type: %s", new Object[] { Integer.valueOf(i) });
      if (i != 49)
      {
        parambl.setType(i);
        com.tencent.mm.model.az.arV();
        com.tencent.mm.model.c.apO().a(parambl.field_msgId, parambl);
      }
    }
    int i = 0;
    while (i < GQY.size())
    {
      c localc = (c)GQY.get(i);
      int j = parambl.getType();
      if (parambl.field_isSend == 1) {}
      for (boolean bool = true; localc.aX(j, bool); bool = false)
      {
        AppMethodBeat.o(37560);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(37560);
    return 0;
  }
  
  public static int faU()
  {
    AppMethodBeat.i(37559);
    int i = GQY.size();
    AppMethodBeat.o(37559);
    return i + 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bj
 * JD-Core Version:    0.7.0.1
 */