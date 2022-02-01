package com.tencent.mm.plugin.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.b;
import com.tencent.mm.al.e.c;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.protocal.protobuf.dme;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class d
  implements com.tencent.mm.al.e
{
  private static int aCG(String paramString)
  {
    int j = 0;
    AppMethodBeat.i(29457);
    int i = j;
    if (!bt.isNullOrNil(paramString)) {}
    try
    {
      i = Integer.valueOf(paramString).intValue();
      AppMethodBeat.o(29457);
      return i;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.TalkRoomExtension", paramString, "", new Object[0]);
        i = j;
      }
    }
  }
  
  private static String em(List<dme> paramList)
  {
    AppMethodBeat.i(29458);
    List localList = b.enD().dgo();
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    label187:
    for (;;)
    {
      dme localdme;
      if (paramList.hasNext())
      {
        localdme = (dme)paramList.next();
        Iterator localIterator = localList.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
        } while (!((dme)localIterator.next()).nDo.equals(localdme.nDo));
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label187;
        }
        localLinkedList.add(localdme.nDo);
        break;
        if (localLinkedList.isEmpty())
        {
          AppMethodBeat.o(29458);
          return null;
        }
        i = 0;
        while (i < localLinkedList.size())
        {
          paramList = (String)localLinkedList.get(i);
          if (!paramList.equals(u.aAm()))
          {
            AppMethodBeat.o(29458);
            return paramList;
          }
          i += 1;
        }
        AppMethodBeat.o(29458);
        return null;
      }
    }
  }
  
  private static String en(List<dme> paramList)
  {
    AppMethodBeat.i(29459);
    Object localObject = b.enD().dgo();
    LinkedList localLinkedList = new LinkedList();
    localObject = ((List)localObject).iterator();
    label187:
    for (;;)
    {
      dme localdme;
      if (((Iterator)localObject).hasNext())
      {
        localdme = (dme)((Iterator)localObject).next();
        Iterator localIterator = paramList.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
        } while (!((dme)localIterator.next()).nDo.equals(localdme.nDo));
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label187;
        }
        localLinkedList.add(localdme.nDo);
        break;
        if (localLinkedList.isEmpty())
        {
          AppMethodBeat.o(29459);
          return null;
        }
        i = 0;
        while (i < localLinkedList.size())
        {
          paramList = (String)localLinkedList.get(i);
          if (!paramList.equals(u.aAm()))
          {
            AppMethodBeat.o(29459);
            return paramList;
          }
          i += 1;
        }
        AppMethodBeat.o(29459);
        return null;
      }
    }
  }
  
  public final e.b b(e.a parama)
  {
    int k = 1;
    AppMethodBeat.i(29456);
    Object localObject2 = parama.gqE;
    if (localObject2 == null)
    {
      ad.e("MicroMsg.TalkRoomExtension", "onPreAddMessage cmdAM is null");
      AppMethodBeat.o(29456);
      return null;
    }
    if (((cv)localObject2).ugm != 56)
    {
      ad.e("MicroMsg.TalkRoomExtension", "onPreAddMessage cmdAM.type:%d", new Object[] { Integer.valueOf(((cv)localObject2).ugm) });
      AppMethodBeat.o(29456);
      return null;
    }
    Object localObject1 = z.a(((cv)localObject2).Fvi);
    parama = z.a(((cv)localObject2).Fvj);
    ba.aBQ();
    if (((String)c.ajl().get(2, null)).equals(localObject1)) {
      localObject1 = parama;
    }
    for (;;)
    {
      ba.aBQ();
      parama = c.azp().Bf((String)localObject1);
      if ((parama == null) || ((int)parama.gfj == 0))
      {
        ba.aBQ();
        c.azp().ag(new am((String)localObject1));
      }
      parama = z.a(((cv)localObject2).Fvk);
      ad.d("MicroMsg.TalkRoomExtension", "talkroom xml:".concat(String.valueOf(parama)));
      localObject2 = bw.M(parama, "talkroominfo");
      if (localObject2 != null) {}
      for (;;)
      {
        try
        {
          if (aCG((String)((Map)localObject2).get(".talkroominfo.tracksysmsgtype")) != 0) {
            break label528;
          }
          aCG((String)((Map)localObject2).get(".talkroominfo.sysmsgtype"));
          i = 1;
          LinkedList localLinkedList = new LinkedList();
          aCG((String)((Map)localObject2).get(".talkroominfo.membersize"));
          int j = 0;
          Object localObject3 = new StringBuilder(".talkroominfo.memberlist.member");
          if (j == 0)
          {
            parama = "";
            localObject3 = parama;
            parama = (String)((Map)localObject2).get((String)localObject3 + ".username");
            if (!bt.isNullOrNil(parama))
            {
              int m = aCG((String)((Map)localObject2).get((String)localObject3 + ".memberid"));
              localObject3 = new dme();
              ((dme)localObject3).nDo = parama;
              ((dme)localObject3).HAy = m;
              localLinkedList.add(localObject3);
              j += 1;
            }
          }
          else
          {
            parama = Integer.valueOf(j);
            continue;
          }
          if (!((String)localObject1).equals(b.enD().Bof)) {
            break label520;
          }
          localObject2 = em(localLinkedList);
          if (!bt.isNullOrNil((String)localObject2)) {
            break label515;
          }
          parama = en(localLinkedList);
          localObject3 = b.enE();
          j = k;
          if (i != 0) {
            j = 0;
          }
          ((e)localObject3).a((String)localObject1, localLinkedList, (String)localObject2, parama, j);
          AppMethodBeat.o(29456);
          return null;
        }
        catch (Exception parama)
        {
          ad.e("MicroMsg.TalkRoomExtension", "parsing memList xml failed");
          ad.printErrStackTrace("MicroMsg.TalkRoomExtension", parama, "", new Object[0]);
        }
        AppMethodBeat.o(29456);
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
  
  public final void b(e.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.d
 * JD-Core Version:    0.7.0.1
 */