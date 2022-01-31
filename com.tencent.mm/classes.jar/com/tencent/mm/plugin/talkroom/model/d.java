package com.tencent.mm.plugin.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.ai.e.b;
import com.tencent.mm.ai.e.c;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.n.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.cjn;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class d
  implements com.tencent.mm.ai.e
{
  private static int aea(String paramString)
  {
    int j = 0;
    AppMethodBeat.i(25775);
    int i = j;
    if (!bo.isNullOrNil(paramString)) {}
    try
    {
      i = Integer.valueOf(paramString).intValue();
      AppMethodBeat.o(25775);
      return i;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.TalkRoomExtension", paramString, "", new Object[0]);
        i = j;
      }
    }
  }
  
  private static String ce(List<cjn> paramList)
  {
    AppMethodBeat.i(25776);
    List localList = b.cHs().bLy();
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    label187:
    for (;;)
    {
      cjn localcjn;
      if (paramList.hasNext())
      {
        localcjn = (cjn)paramList.next();
        Iterator localIterator = localList.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
        } while (!((cjn)localIterator.next()).jJA.equals(localcjn.jJA));
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label187;
        }
        localLinkedList.add(localcjn.jJA);
        break;
        if (localLinkedList.isEmpty())
        {
          AppMethodBeat.o(25776);
          return null;
        }
        i = 0;
        while (i < localLinkedList.size())
        {
          paramList = (String)localLinkedList.get(i);
          if (!paramList.equals(r.Zn()))
          {
            AppMethodBeat.o(25776);
            return paramList;
          }
          i += 1;
        }
        AppMethodBeat.o(25776);
        return null;
      }
    }
  }
  
  private static String cf(List<cjn> paramList)
  {
    AppMethodBeat.i(25777);
    Object localObject = b.cHs().bLy();
    LinkedList localLinkedList = new LinkedList();
    localObject = ((List)localObject).iterator();
    label187:
    for (;;)
    {
      cjn localcjn;
      if (((Iterator)localObject).hasNext())
      {
        localcjn = (cjn)((Iterator)localObject).next();
        Iterator localIterator = paramList.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
        } while (!((cjn)localIterator.next()).jJA.equals(localcjn.jJA));
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label187;
        }
        localLinkedList.add(localcjn.jJA);
        break;
        if (localLinkedList.isEmpty())
        {
          AppMethodBeat.o(25777);
          return null;
        }
        i = 0;
        while (i < localLinkedList.size())
        {
          paramList = (String)localLinkedList.get(i);
          if (!paramList.equals(r.Zn()))
          {
            AppMethodBeat.o(25777);
            return paramList;
          }
          i += 1;
        }
        AppMethodBeat.o(25777);
        return null;
      }
    }
  }
  
  public final void a(e.c paramc) {}
  
  public final e.b b(e.a parama)
  {
    int k = 1;
    AppMethodBeat.i(25774);
    Object localObject2 = parama.eyJ;
    if (localObject2 == null)
    {
      ab.e("MicroMsg.TalkRoomExtension", "onPreAddMessage cmdAM is null");
      AppMethodBeat.o(25774);
      return null;
    }
    if (((cm)localObject2).nqW != 56)
    {
      ab.e("MicroMsg.TalkRoomExtension", "onPreAddMessage cmdAM.type:%d", new Object[] { Integer.valueOf(((cm)localObject2).nqW) });
      AppMethodBeat.o(25774);
      return null;
    }
    Object localObject1 = aa.a(((cm)localObject2).woP);
    parama = aa.a(((cm)localObject2).woQ);
    aw.aaz();
    if (((String)c.Ru().get(2, null)).equals(localObject1)) {
      localObject1 = parama;
    }
    for (;;)
    {
      aw.aaz();
      parama = c.YA().arw((String)localObject1);
      if ((parama == null) || ((int)parama.euF == 0))
      {
        aw.aaz();
        c.YA().Y(new ad((String)localObject1));
      }
      parama = aa.a(((cm)localObject2).woR);
      ab.d("MicroMsg.TalkRoomExtension", "talkroom xml:".concat(String.valueOf(parama)));
      localObject2 = br.F(parama, "talkroominfo");
      if (localObject2 != null) {}
      for (;;)
      {
        try
        {
          if (aea((String)((Map)localObject2).get(".talkroominfo.tracksysmsgtype")) != 0) {
            break label528;
          }
          aea((String)((Map)localObject2).get(".talkroominfo.sysmsgtype"));
          i = 1;
          LinkedList localLinkedList = new LinkedList();
          aea((String)((Map)localObject2).get(".talkroominfo.membersize"));
          int j = 0;
          Object localObject3 = new StringBuilder(".talkroominfo.memberlist.member");
          if (j == 0)
          {
            parama = "";
            localObject3 = parama;
            parama = (String)((Map)localObject2).get((String)localObject3 + ".username");
            if (!bo.isNullOrNil(parama))
            {
              int m = aea((String)((Map)localObject2).get((String)localObject3 + ".memberid"));
              localObject3 = new cjn();
              ((cjn)localObject3).jJA = parama;
              ((cjn)localObject3).xTD = m;
              localLinkedList.add(localObject3);
              j += 1;
            }
          }
          else
          {
            parama = Integer.valueOf(j);
            continue;
          }
          if (!((String)localObject1).equals(b.cHs().tcS)) {
            break label520;
          }
          localObject2 = ce(localLinkedList);
          if (!bo.isNullOrNil((String)localObject2)) {
            break label515;
          }
          parama = cf(localLinkedList);
          localObject3 = b.cHt();
          j = k;
          if (i != 0) {
            j = 0;
          }
          ((e)localObject3).a((String)localObject1, localLinkedList, (String)localObject2, parama, j);
          AppMethodBeat.o(25774);
          return null;
        }
        catch (Exception parama)
        {
          ab.e("MicroMsg.TalkRoomExtension", "parsing memList xml failed");
          ab.printErrStackTrace("MicroMsg.TalkRoomExtension", parama, "", new Object[0]);
        }
        AppMethodBeat.o(25774);
        return null;
        label515:
        parama = null;
        continue;
        label520:
        parama = null;
        localObject2 = null;
        continue;
        label528:
        int i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.d
 * JD-Core Version:    0.7.0.1
 */