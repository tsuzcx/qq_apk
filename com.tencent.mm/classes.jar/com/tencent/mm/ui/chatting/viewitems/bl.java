package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class bl
{
  private static final List<c> KhE;
  
  static
  {
    AppMethodBeat.i(37561);
    ArrayList localArrayList = new ArrayList();
    KhE = localArrayList;
    localArrayList.add(new ax.b());
    KhE.add(new ax.a());
    KhE.add(new e.e());
    KhE.add(new e.d());
    KhE.add(new s.c());
    KhE.add(new s.b());
    KhE.add(new aa.c());
    KhE.add(new aa.b());
    KhE.add(new r.c());
    KhE.add(new r.b());
    KhE.add(new v.c());
    KhE.add(new v.b());
    KhE.add(new l.d());
    KhE.add(new l.c());
    KhE.add(new au());
    KhE.add(new ap.b());
    KhE.add(new ak.b());
    KhE.add(new ak.a());
    KhE.add(new az.a());
    KhE.add(new az.b());
    KhE.add(new ar.a());
    KhE.add(new ag.c());
    KhE.add(new ag.b());
    KhE.add(new al.a());
    KhE.add(new ay.b());
    KhE.add(new ay.a());
    KhE.add(new aq.b());
    KhE.add(new aq.a());
    KhE.add(new bd.f());
    KhE.add(new bd.c());
    KhE.add(new bd.g());
    KhE.add(new ae.j());
    KhE.add(new bd.d());
    KhE.add(new bd.e());
    KhE.add(new bc());
    KhE.add(new ba());
    KhE.add(new bb());
    KhE.add(new at.a());
    KhE.add(new at.b());
    KhE.add(new be.c());
    KhE.add(new be.b());
    KhE.add(new ai());
    KhE.add(new d());
    KhE.add(new u.b());
    KhE.add(new u.c());
    KhE.add(new am());
    KhE.add(new an());
    KhE.add(new ao());
    KhE.add(new y.c());
    KhE.add(new y.b());
    KhE.add(new f.c());
    KhE.add(new f.b());
    KhE.add(new j.c());
    KhE.add(new j.b());
    KhE.add(new h.c());
    KhE.add(new h.b());
    KhE.add(new i.c());
    KhE.add(new i.b());
    KhE.add(new ac.b());
    KhE.add(new ac.a());
    KhE.add(new ad.b());
    KhE.add(new ad.a());
    KhE.add(new ab.b());
    KhE.add(new ab.a());
    KhE.add(new t.c());
    KhE.add(new t.b());
    KhE.add(new ap.a());
    KhE.add(new g.c());
    KhE.add(new g.b());
    KhE.add(new k.c());
    KhE.add(new w());
    KhE.add(new n.b());
    KhE.add(new n.c());
    KhE.add(new p.b());
    KhE.add(new p.c());
    KhE.add(new m.b());
    KhE.add(new m.c());
    KhE.add(new o.b());
    KhE.add(new o.c());
    KhE.add(new z.a());
    KhE.add(new z.b());
    KhE.add(new q.b());
    KhE.add(new q.c());
    KhE.add(new x());
    KhE.add(new ax.b()
    {
      public final boolean bi(int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(37556);
        ad.w("MicroMsg.Chatting.ItemFactory", "unfound msgType:%d, isSender:%b", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(paramAnonymousBoolean) });
        AppMethodBeat.o(37556);
        return paramAnonymousBoolean;
      }
    });
    KhE.add(new ax.a()
    {
      public final boolean bi(int paramAnonymousInt, boolean paramAnonymousBoolean)
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
  
  public static int cA(bu parambu)
  {
    AppMethodBeat.i(37560);
    if (parambu.getType() == 49)
    {
      i = m.g(k.b.yr(parambu.field_content));
      ad.d("MicroMsg.Chatting.ItemFactory", "maybe honeypay need change type: %s", new Object[] { Integer.valueOf(i) });
      if (i != 49)
      {
        parambu.setType(i);
        com.tencent.mm.model.ba.aBQ();
        com.tencent.mm.model.c.azs().a(parambu.field_msgId, parambu);
      }
    }
    int i = 0;
    while (i < KhE.size())
    {
      c localc = (c)KhE.get(i);
      int j = parambu.getType();
      if (parambu.field_isSend == 1) {}
      for (boolean bool = true; localc.bi(j, bool); bool = false)
      {
        AppMethodBeat.o(37560);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(37560);
    return 0;
  }
  
  public static c cz(bu parambu)
  {
    AppMethodBeat.i(37558);
    Iterator localIterator = KhE.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      int i = parambu.getType();
      if (parambu.field_isSend == 1) {}
      for (boolean bool = true; localc.bi(i, bool); bool = false) {
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
    parambu = new ax.a();
    AppMethodBeat.o(37558);
    return parambu;
  }
  
  public static int fHx()
  {
    AppMethodBeat.i(37559);
    int i = KhE.size();
    AppMethodBeat.o(37559);
    return i + 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bl
 * JD-Core Version:    0.7.0.1
 */