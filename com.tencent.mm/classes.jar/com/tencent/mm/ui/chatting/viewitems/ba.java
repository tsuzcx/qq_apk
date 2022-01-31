package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.storage.bi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class ba
{
  private static final List<c> zYO;
  
  static
  {
    AppMethodBeat.i(33451);
    ArrayList localArrayList = new ArrayList();
    zYO = localArrayList;
    localArrayList.add(new am.b());
    zYO.add(new am.a());
    zYO.add(new d.e());
    zYO.add(new d.d());
    zYO.add(new l.c());
    zYO.add(new l.b());
    zYO.add(new q.c());
    zYO.add(new q.b());
    zYO.add(new k.d());
    zYO.add(new k.c());
    zYO.add(new aj());
    zYO.add(new ae.b());
    zYO.add(new z.b());
    zYO.add(new z.a());
    zYO.add(new ao.a());
    zYO.add(new ao.b());
    zYO.add(new ag.a());
    zYO.add(new v.c());
    zYO.add(new v.b());
    zYO.add(new aa.a());
    zYO.add(new an.b());
    zYO.add(new an.a());
    zYO.add(new af.b());
    zYO.add(new af.a());
    zYO.add(new as.f());
    zYO.add(new as.c());
    zYO.add(new as.g());
    zYO.add(new u.j());
    zYO.add(new as.d());
    zYO.add(new as.e());
    zYO.add(new ar());
    zYO.add(new ap());
    zYO.add(new aq());
    zYO.add(new ai.a());
    zYO.add(new ai.b());
    zYO.add(new at.c());
    zYO.add(new at.b());
    zYO.add(new x());
    zYO.add(new n.b());
    zYO.add(new n.c());
    zYO.add(new ab());
    zYO.add(new ac());
    zYO.add(new ad());
    zYO.add(new p.c());
    zYO.add(new p.b());
    zYO.add(new e.c());
    zYO.add(new e.b());
    zYO.add(new i.c());
    zYO.add(new i.b());
    zYO.add(new g.c());
    zYO.add(new g.b());
    zYO.add(new h.c());
    zYO.add(new h.b());
    zYO.add(new s.b());
    zYO.add(new s.a());
    zYO.add(new t.b());
    zYO.add(new t.a());
    zYO.add(new r.b());
    zYO.add(new r.a());
    zYO.add(new m.c());
    zYO.add(new m.b());
    zYO.add(new ae.a());
    zYO.add(new f.c());
    zYO.add(new f.b());
    zYO.add(new j.c());
    zYO.add(new o());
    zYO.add(new ba.1());
    zYO.add(new ba.2());
    AppMethodBeat.o(33451);
  }
  
  public static c bN(bi parambi)
  {
    AppMethodBeat.i(33448);
    Iterator localIterator = zYO.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      int i = parambi.getType();
      if (parambi.field_isSend == 1) {}
      for (boolean bool = true; localc.aK(i, bool); bool = false) {
        try
        {
          localc = (c)localc.getClass().newInstance();
          AppMethodBeat.o(33448);
          return localc;
        }
        catch (Exception localException)
        {
          com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.Chatting.ItemFactory", localException, "", new Object[0]);
        }
      }
    }
    parambi = new am.a();
    AppMethodBeat.o(33448);
    return parambi;
  }
  
  public static int bO(bi parambi)
  {
    AppMethodBeat.i(33450);
    if (parambi.getType() == 49)
    {
      i = l.c(j.b.mY(parambi.field_content));
      com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.Chatting.ItemFactory", "maybe honeypay need change type: %s", new Object[] { Integer.valueOf(i) });
      if (i != 49)
      {
        parambi.setType(i);
        aw.aaz();
        com.tencent.mm.model.c.YC().a(parambi.field_msgId, parambi);
      }
    }
    int i = 0;
    while (i < zYO.size())
    {
      c localc = (c)zYO.get(i);
      int j = parambi.getType();
      if (parambi.field_isSend == 1) {}
      for (boolean bool = true; localc.aK(j, bool); bool = false)
      {
        AppMethodBeat.o(33450);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(33450);
    return 0;
  }
  
  public static int dLy()
  {
    AppMethodBeat.i(33449);
    int i = zYO.size();
    AppMethodBeat.o(33449);
    return i + 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ba
 * JD-Core Version:    0.7.0.1
 */