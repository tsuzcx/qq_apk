package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class bk
{
  private static final List<c> IqZ;
  
  static
  {
    AppMethodBeat.i(37561);
    ArrayList localArrayList = new ArrayList();
    IqZ = localArrayList;
    localArrayList.add(new aw.b());
    IqZ.add(new aw.a());
    IqZ.add(new e.e());
    IqZ.add(new e.d());
    IqZ.add(new r.c());
    IqZ.add(new r.b());
    IqZ.add(new z.c());
    IqZ.add(new z.b());
    IqZ.add(new q.c());
    IqZ.add(new q.b());
    IqZ.add(new u.c());
    IqZ.add(new u.b());
    IqZ.add(new l.d());
    IqZ.add(new l.c());
    IqZ.add(new at());
    IqZ.add(new ao.b());
    IqZ.add(new aj.b());
    IqZ.add(new aj.a());
    IqZ.add(new ay.a());
    IqZ.add(new ay.b());
    IqZ.add(new aq.a());
    IqZ.add(new af.c());
    IqZ.add(new af.b());
    IqZ.add(new ak.a());
    IqZ.add(new ax.b());
    IqZ.add(new ax.a());
    IqZ.add(new ap.b());
    IqZ.add(new ap.a());
    IqZ.add(new bc.f());
    IqZ.add(new bc.c());
    IqZ.add(new bc.g());
    IqZ.add(new ad.j());
    IqZ.add(new bc.d());
    IqZ.add(new bc.e());
    IqZ.add(new bb());
    IqZ.add(new az());
    IqZ.add(new ba());
    IqZ.add(new as.a());
    IqZ.add(new as.b());
    IqZ.add(new bd.c());
    IqZ.add(new bd.b());
    IqZ.add(new ah());
    IqZ.add(new d());
    IqZ.add(new t.b());
    IqZ.add(new t.c());
    IqZ.add(new al());
    IqZ.add(new am());
    IqZ.add(new an());
    IqZ.add(new x.c());
    IqZ.add(new x.b());
    IqZ.add(new f.c());
    IqZ.add(new f.b());
    IqZ.add(new j.c());
    IqZ.add(new j.b());
    IqZ.add(new h.c());
    IqZ.add(new h.b());
    IqZ.add(new i.c());
    IqZ.add(new i.b());
    IqZ.add(new ab.b());
    IqZ.add(new ab.a());
    IqZ.add(new ac.b());
    IqZ.add(new ac.a());
    IqZ.add(new aa.b());
    IqZ.add(new aa.a());
    IqZ.add(new s.c());
    IqZ.add(new s.b());
    IqZ.add(new ao.a());
    IqZ.add(new g.c());
    IqZ.add(new g.b());
    IqZ.add(new k.c());
    IqZ.add(new v());
    IqZ.add(new n.b());
    IqZ.add(new n.c());
    IqZ.add(new p.b());
    IqZ.add(new p.c());
    IqZ.add(new m.b());
    IqZ.add(new m.c());
    IqZ.add(new o.b());
    IqZ.add(new o.c());
    IqZ.add(new y.a());
    IqZ.add(new y.b());
    IqZ.add(new w());
    IqZ.add(new aw.b()
    {
      public final boolean bb(int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(37556);
        ac.w("MicroMsg.Chatting.ItemFactory", "unfound msgType:%d, isSender:%b", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(paramAnonymousBoolean) });
        AppMethodBeat.o(37556);
        return paramAnonymousBoolean;
      }
    });
    IqZ.add(new aw.a()
    {
      public final boolean bb(int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(37557);
        ac.w("MicroMsg.Chatting.ItemFactory", "unfound msgType:%d, isSender:%b", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(paramAnonymousBoolean) });
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
  
  public static c ct(bo parambo)
  {
    AppMethodBeat.i(37558);
    Iterator localIterator = IqZ.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      int i = parambo.getType();
      if (parambo.field_isSend == 1) {}
      for (boolean bool = true; localc.bb(i, bool); bool = false) {
        try
        {
          localc = (c)localc.getClass().newInstance();
          AppMethodBeat.o(37558);
          return localc;
        }
        catch (Exception localException)
        {
          ac.printErrStackTrace("MicroMsg.Chatting.ItemFactory", localException, "", new Object[0]);
        }
      }
    }
    parambo = new aw.a();
    AppMethodBeat.o(37558);
    return parambo;
  }
  
  public static int cu(bo parambo)
  {
    AppMethodBeat.i(37560);
    if (parambo.getType() == 49)
    {
      i = m.f(k.b.vA(parambo.field_content));
      ac.d("MicroMsg.Chatting.ItemFactory", "maybe honeypay need change type: %s", new Object[] { Integer.valueOf(i) });
      if (i != 49)
      {
        parambo.setType(i);
        com.tencent.mm.model.az.ayM();
        com.tencent.mm.model.c.awD().a(parambo.field_msgId, parambo);
      }
    }
    int i = 0;
    while (i < IqZ.size())
    {
      c localc = (c)IqZ.get(i);
      int j = parambo.getType();
      if (parambo.field_isSend == 1) {}
      for (boolean bool = true; localc.bb(j, bool); bool = false)
      {
        AppMethodBeat.o(37560);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(37560);
    return 0;
  }
  
  public static int fqK()
  {
    AppMethodBeat.i(37559);
    int i = IqZ.size();
    AppMethodBeat.o(37559);
    return i + 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bk
 * JD-Core Version:    0.7.0.1
 */