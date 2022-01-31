package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.ae.g.a;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.storage.bi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class ax
{
  private static final List<c> vHt;
  
  static
  {
    ArrayList localArrayList = new ArrayList();
    vHt = localArrayList;
    localArrayList.add(new aj.b());
    vHt.add(new aj.a());
    vHt.add(new d.e());
    vHt.add(new d.d());
    vHt.add(new l.c());
    vHt.add(new l.b());
    vHt.add(new o.c());
    vHt.add(new o.b());
    vHt.add(new k.d());
    vHt.add(new k.c());
    vHt.add(new ag());
    vHt.add(new ab.b());
    vHt.add(new w.b());
    vHt.add(new w.a());
    vHt.add(new al.a());
    vHt.add(new al.b());
    vHt.add(new ad.a());
    vHt.add(new s.c());
    vHt.add(new s.b());
    vHt.add(new x.a());
    vHt.add(new ak.b());
    vHt.add(new ak.a());
    vHt.add(new ac.b());
    vHt.add(new ac.a());
    vHt.add(new ap.f());
    vHt.add(new ap.c());
    vHt.add(new ap.g());
    vHt.add(new r.j());
    vHt.add(new ap.d());
    vHt.add(new ap.e());
    vHt.add(new ao());
    vHt.add(new am());
    vHt.add(new an());
    vHt.add(new af.a());
    vHt.add(new af.b());
    vHt.add(new aq.c());
    vHt.add(new aq.b());
    vHt.add(new u());
    vHt.add(new m.b());
    vHt.add(new m.c());
    vHt.add(new y());
    vHt.add(new z());
    vHt.add(new aa());
    vHt.add(new n.c());
    vHt.add(new n.b());
    vHt.add(new e.c());
    vHt.add(new e.b());
    vHt.add(new i.c());
    vHt.add(new i.b());
    vHt.add(new g.c());
    vHt.add(new g.b());
    vHt.add(new h.c());
    vHt.add(new h.b());
    vHt.add(new p.b());
    vHt.add(new p.a());
    vHt.add(new q.b());
    vHt.add(new q.a());
    vHt.add(new ab.a());
    vHt.add(new f.c());
    vHt.add(new f.b());
    vHt.add(new j.c());
    vHt.add(new aj.b()
    {
      public final boolean au(int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        com.tencent.mm.sdk.platformtools.y.w("MicroMsg.Chatting.ItemFactory", "unfound msgType:%d, isSender:%b", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(paramAnonymousBoolean) });
        return paramAnonymousBoolean;
      }
    });
    vHt.add(new ax.2());
  }
  
  public static c bC(bi parambi)
  {
    Iterator localIterator = vHt.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      int i = parambi.getType();
      if (parambi.field_isSend == 1) {}
      for (boolean bool = true; localc.au(i, bool); bool = false) {
        try
        {
          localc = (c)localc.getClass().newInstance();
          return localc;
        }
        catch (Exception localException)
        {
          com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.Chatting.ItemFactory", localException, "", new Object[0]);
        }
      }
    }
    return new aj.a();
  }
  
  public static int bD(bi parambi)
  {
    if (parambi.getType() == 49)
    {
      i = l.d(g.a.gp(parambi.field_content));
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.Chatting.ItemFactory", "maybe honeypay need change type: %s", new Object[] { Integer.valueOf(i) });
      if (i != 49)
      {
        parambi.setType(i);
        au.Hx();
        com.tencent.mm.model.c.Fy().a(parambi.field_msgId, parambi);
      }
    }
    int i = 0;
    while (i < vHt.size())
    {
      c localc = (c)vHt.get(i);
      int j = parambi.getType();
      if (parambi.field_isSend == 1) {}
      for (boolean bool = true; localc.au(j, bool); bool = false) {
        return i;
      }
      i += 1;
    }
    return 0;
  }
  
  public static int cHi()
  {
    return vHt.size() + 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ax
 * JD-Core Version:    0.7.0.1
 */