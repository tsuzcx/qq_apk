package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.bv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class bl
{
  private static final List<c> KDY;
  
  static
  {
    AppMethodBeat.i(37561);
    ArrayList localArrayList = new ArrayList();
    KDY = localArrayList;
    localArrayList.add(new ax.b());
    KDY.add(new ax.a());
    KDY.add(new e.e());
    KDY.add(new e.d());
    KDY.add(new s.c());
    KDY.add(new s.b());
    KDY.add(new aa.c());
    KDY.add(new aa.b());
    KDY.add(new r.c());
    KDY.add(new r.b());
    KDY.add(new v.c());
    KDY.add(new v.b());
    KDY.add(new l.d());
    KDY.add(new l.c());
    KDY.add(new au());
    KDY.add(new ap.b());
    KDY.add(new ak.b());
    KDY.add(new ak.a());
    KDY.add(new az.a());
    KDY.add(new az.b());
    KDY.add(new ar.a());
    KDY.add(new ag.c());
    KDY.add(new ag.b());
    KDY.add(new al.a());
    KDY.add(new ay.b());
    KDY.add(new ay.a());
    KDY.add(new aq.b());
    KDY.add(new aq.a());
    KDY.add(new bd.f());
    KDY.add(new bd.c());
    KDY.add(new bd.g());
    KDY.add(new ae.j());
    KDY.add(new bd.d());
    KDY.add(new bd.e());
    KDY.add(new bc());
    KDY.add(new ba());
    KDY.add(new bb());
    KDY.add(new at.a());
    KDY.add(new at.b());
    KDY.add(new be.c());
    KDY.add(new be.b());
    KDY.add(new ai());
    KDY.add(new d());
    KDY.add(new u.b());
    KDY.add(new u.c());
    KDY.add(new am());
    KDY.add(new an());
    KDY.add(new ao());
    KDY.add(new y.c());
    KDY.add(new y.b());
    KDY.add(new f.c());
    KDY.add(new f.b());
    KDY.add(new j.c());
    KDY.add(new j.b());
    KDY.add(new h.c());
    KDY.add(new h.b());
    KDY.add(new i.c());
    KDY.add(new i.b());
    KDY.add(new ac.b());
    KDY.add(new ac.a());
    KDY.add(new ad.b());
    KDY.add(new ad.a());
    KDY.add(new ab.b());
    KDY.add(new ab.a());
    KDY.add(new t.c());
    KDY.add(new t.b());
    KDY.add(new ap.a());
    KDY.add(new g.c());
    KDY.add(new g.b());
    KDY.add(new k.c());
    KDY.add(new w());
    KDY.add(new n.b());
    KDY.add(new n.c());
    KDY.add(new p.b());
    KDY.add(new p.c());
    KDY.add(new m.b());
    KDY.add(new m.c());
    KDY.add(new o.b());
    KDY.add(new o.c());
    KDY.add(new z.a());
    KDY.add(new z.b());
    KDY.add(new q.b());
    KDY.add(new q.c());
    KDY.add(new x());
    KDY.add(new ax.b()
    {
      public final boolean br(int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(37556);
        ae.w("MicroMsg.Chatting.ItemFactory", "unfound msgType:%d, isSender:%b", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(paramAnonymousBoolean) });
        AppMethodBeat.o(37556);
        return paramAnonymousBoolean;
      }
    });
    KDY.add(new ax.a()
    {
      public final boolean br(int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(37557);
        ae.w("MicroMsg.Chatting.ItemFactory", "unfound msgType:%d, isSender:%b", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(paramAnonymousBoolean) });
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
  
  public static c cy(bv parambv)
  {
    AppMethodBeat.i(37558);
    Iterator localIterator = KDY.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      int i = parambv.getType();
      if (parambv.field_isSend == 1) {}
      for (boolean bool = true; localc.br(i, bool); bool = false) {
        try
        {
          localc = (c)localc.getClass().newInstance();
          AppMethodBeat.o(37558);
          return localc;
        }
        catch (Exception localException)
        {
          ae.printErrStackTrace("MicroMsg.Chatting.ItemFactory", localException, "", new Object[0]);
        }
      }
    }
    parambv = new ax.a();
    AppMethodBeat.o(37558);
    return parambv;
  }
  
  public static int cz(bv parambv)
  {
    AppMethodBeat.i(37560);
    if (parambv.getType() == 49)
    {
      i = m.g(k.b.zb(parambv.field_content));
      ae.d("MicroMsg.Chatting.ItemFactory", "maybe honeypay need change type: %s", new Object[] { Integer.valueOf(i) });
      if (i != 49)
      {
        parambv.setType(i);
        com.tencent.mm.model.bc.aCg();
        com.tencent.mm.model.c.azI().a(parambv.field_msgId, parambv);
      }
    }
    int i = 0;
    while (i < KDY.size())
    {
      c localc = (c)KDY.get(i);
      int j = parambv.getType();
      if (parambv.field_isSend == 1) {}
      for (boolean bool = true; localc.br(j, bool); bool = false)
      {
        AppMethodBeat.o(37560);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(37560);
    return 0;
  }
  
  public static int fLP()
  {
    AppMethodBeat.i(37559);
    int i = KDY.size();
    AppMethodBeat.o(37559);
    return i + 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bl
 * JD-Core Version:    0.7.0.1
 */