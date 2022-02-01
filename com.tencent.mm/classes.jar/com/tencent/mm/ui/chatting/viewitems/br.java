package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class br
{
  private static final List<c> PQL;
  
  static
  {
    AppMethodBeat.i(37561);
    ArrayList localArrayList = new ArrayList();
    PQL = localArrayList;
    localArrayList.add(new bd.b());
    PQL.add(new bd.a());
    PQL.add(new e.e());
    PQL.add(new e.d());
    PQL.add(new w.c());
    PQL.add(new w.b());
    PQL.add(new ag.c());
    PQL.add(new ag.b());
    PQL.add(new v.c());
    PQL.add(new v.b());
    PQL.add(new aa.c());
    PQL.add(new aa.b());
    PQL.add(new l.d());
    PQL.add(new l.c());
    PQL.add(new ab.b());
    PQL.add(new ab.a());
    PQL.add(new ba());
    PQL.add(new av.b());
    PQL.add(new aq.b());
    PQL.add(new aq.a());
    PQL.add(new bf.a());
    PQL.add(new bf.b());
    PQL.add(new ax.a());
    PQL.add(new am.c());
    PQL.add(new am.b());
    PQL.add(new ar.a());
    PQL.add(new be.b());
    PQL.add(new be.a());
    PQL.add(new aw.b());
    PQL.add(new aw.a());
    PQL.add(new bj.f());
    PQL.add(new bj.c());
    PQL.add(new bj.g());
    PQL.add(new ak.j());
    PQL.add(new bj.d());
    PQL.add(new bj.e());
    PQL.add(new bi());
    PQL.add(new bg());
    PQL.add(new bh());
    PQL.add(new az.a());
    PQL.add(new az.b());
    PQL.add(new bk.c());
    PQL.add(new bk.b());
    PQL.add(new ao());
    PQL.add(new d());
    PQL.add(new y.b());
    PQL.add(new y.c());
    PQL.add(new as());
    PQL.add(new at());
    PQL.add(new au());
    PQL.add(new ae.c());
    PQL.add(new ae.b());
    PQL.add(new f.c());
    PQL.add(new f.b());
    PQL.add(new j.c());
    PQL.add(new j.b());
    PQL.add(new h.c());
    PQL.add(new h.b());
    PQL.add(new i.c());
    PQL.add(new i.b());
    PQL.add(new ai.b());
    PQL.add(new ai.a());
    PQL.add(new aj.b());
    PQL.add(new aj.a());
    PQL.add(new ah.b());
    PQL.add(new ah.a());
    PQL.add(new x.c());
    PQL.add(new x.b());
    PQL.add(new av.a());
    PQL.add(new g.c());
    PQL.add(new g.b());
    PQL.add(new k.c());
    PQL.add(new ac());
    PQL.add(new p.b());
    PQL.add(new p.c());
    PQL.add(new z.b());
    PQL.add(new z.c());
    PQL.add(new t.b());
    PQL.add(new t.c());
    PQL.add(new m.b());
    PQL.add(new m.c());
    PQL.add(new n.b());
    PQL.add(new n.c());
    PQL.add(new o.b());
    PQL.add(new o.c());
    PQL.add(new r.b());
    PQL.add(new r.c());
    PQL.add(new ChatingItemAppMsgFinderLiveFeed.a());
    PQL.add(new ChatingItemAppMsgFinderLiveFeed.b());
    PQL.add(new af.a());
    PQL.add(new af.b());
    PQL.add(new u.b());
    PQL.add(new u.c());
    PQL.add(new ad());
    PQL.add(new q.a());
    PQL.add(new q.b());
    PQL.add(new s.b());
    PQL.add(new s.c());
    PQL.add(new bd.b()
    {
      public final boolean bM(int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(37556);
        Log.w("MicroMsg.Chatting.ItemFactory", "unfound msgType:%d, isSender:%b", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(paramAnonymousBoolean) });
        AppMethodBeat.o(37556);
        return paramAnonymousBoolean;
      }
    });
    PQL.add(new bd.a()
    {
      public final boolean bM(int paramAnonymousInt, boolean paramAnonymousBoolean)
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
  
  public static c cR(ca paramca)
  {
    AppMethodBeat.i(37558);
    Iterator localIterator = PQL.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      int i = paramca.getType();
      if (paramca.field_isSend == 1) {}
      for (boolean bool = true; localc.bM(i, bool); bool = false) {
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
    paramca = new bd.a();
    AppMethodBeat.o(37558);
    return paramca;
  }
  
  public static int cS(ca paramca)
  {
    AppMethodBeat.i(37560);
    if (paramca.getType() == 49)
    {
      i = m.g(k.b.HD(paramca.field_content));
      Log.d("MicroMsg.Chatting.ItemFactory", "maybe honeypay need change type: %s", new Object[] { Integer.valueOf(i) });
      if (i != 49)
      {
        paramca.setType(i);
        com.tencent.mm.model.bg.aVF();
        com.tencent.mm.model.c.aSQ().a(paramca.field_msgId, paramca);
      }
    }
    int i = 0;
    while (i < PQL.size())
    {
      c localc = (c)PQL.get(i);
      int j = paramca.getType();
      if (paramca.field_isSend == 1) {}
      for (boolean bool = true; localc.bM(j, bool); bool = false)
      {
        AppMethodBeat.o(37560);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(37560);
    return 0;
  }
  
  public static int gUk()
  {
    AppMethodBeat.i(37559);
    int i = PQL.size();
    AppMethodBeat.o(37559);
    return i + 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.br
 * JD-Core Version:    0.7.0.1
 */