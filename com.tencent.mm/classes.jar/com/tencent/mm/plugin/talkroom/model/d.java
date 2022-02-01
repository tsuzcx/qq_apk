package com.tencent.mm.plugin.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.b;
import com.tencent.mm.ak.e.c;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.v;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.protocal.protobuf.dnb;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class d
  implements com.tencent.mm.ak.e
{
  private static int aDZ(String paramString)
  {
    int j = 0;
    AppMethodBeat.i(29457);
    int i = j;
    if (!bu.isNullOrNil(paramString)) {}
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
        ae.printErrStackTrace("MicroMsg.TalkRoomExtension", paramString, "", new Object[0]);
        i = j;
      }
    }
  }
  
  private static String eq(List<dnb> paramList)
  {
    AppMethodBeat.i(29458);
    List localList = b.erk().djn();
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    label187:
    for (;;)
    {
      dnb localdnb;
      if (paramList.hasNext())
      {
        localdnb = (dnb)paramList.next();
        Iterator localIterator = localList.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
        } while (!((dnb)localIterator.next()).nIJ.equals(localdnb.nIJ));
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label187;
        }
        localLinkedList.add(localdnb.nIJ);
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
          if (!paramList.equals(v.aAC()))
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
  
  private static String er(List<dnb> paramList)
  {
    AppMethodBeat.i(29459);
    Object localObject = b.erk().djn();
    LinkedList localLinkedList = new LinkedList();
    localObject = ((List)localObject).iterator();
    label187:
    for (;;)
    {
      dnb localdnb;
      if (((Iterator)localObject).hasNext())
      {
        localdnb = (dnb)((Iterator)localObject).next();
        Iterator localIterator = paramList.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
        } while (!((dnb)localIterator.next()).nIJ.equals(localdnb.nIJ));
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label187;
        }
        localLinkedList.add(localdnb.nIJ);
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
          if (!paramList.equals(v.aAC()))
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
    Object localObject2 = parama.gte;
    if (localObject2 == null)
    {
      ae.e("MicroMsg.TalkRoomExtension", "onPreAddMessage cmdAM is null");
      AppMethodBeat.o(29456);
      return null;
    }
    if (((cv)localObject2).urJ != 56)
    {
      ae.e("MicroMsg.TalkRoomExtension", "onPreAddMessage cmdAM.type:%d", new Object[] { Integer.valueOf(((cv)localObject2).urJ) });
      AppMethodBeat.o(29456);
      return null;
    }
    Object localObject1 = z.a(((cv)localObject2).FNG);
    parama = z.a(((cv)localObject2).FNH);
    bc.aCg();
    if (((String)com.tencent.mm.model.c.ajA().get(2, null)).equals(localObject1)) {
      localObject1 = parama;
    }
    for (;;)
    {
      bc.aCg();
      parama = com.tencent.mm.model.c.azF().BH((String)localObject1);
      if ((parama == null) || ((int)parama.ght == 0))
      {
        bc.aCg();
        com.tencent.mm.model.c.azF().an(new an((String)localObject1));
      }
      parama = z.a(((cv)localObject2).FNI);
      ae.d("MicroMsg.TalkRoomExtension", "talkroom xml:".concat(String.valueOf(parama)));
      localObject2 = bx.M(parama, "talkroominfo");
      if (localObject2 != null) {}
      for (;;)
      {
        try
        {
          if (aDZ((String)((Map)localObject2).get(".talkroominfo.tracksysmsgtype")) != 0) {
            break label528;
          }
          aDZ((String)((Map)localObject2).get(".talkroominfo.sysmsgtype"));
          i = 1;
          LinkedList localLinkedList = new LinkedList();
          aDZ((String)((Map)localObject2).get(".talkroominfo.membersize"));
          int j = 0;
          Object localObject3 = new StringBuilder(".talkroominfo.memberlist.member");
          if (j == 0)
          {
            parama = "";
            localObject3 = parama;
            parama = (String)((Map)localObject2).get((String)localObject3 + ".username");
            if (!bu.isNullOrNil(parama))
            {
              int m = aDZ((String)((Map)localObject2).get((String)localObject3 + ".memberid"));
              localObject3 = new dnb();
              ((dnb)localObject3).nIJ = parama;
              ((dnb)localObject3).HUl = m;
              localLinkedList.add(localObject3);
              j += 1;
            }
          }
          else
          {
            parama = Integer.valueOf(j);
            continue;
          }
          if (!((String)localObject1).equals(b.erk().BFE)) {
            break label520;
          }
          localObject2 = eq(localLinkedList);
          if (!bu.isNullOrNil((String)localObject2)) {
            break label515;
          }
          parama = er(localLinkedList);
          localObject3 = b.erl();
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
          ae.e("MicroMsg.TalkRoomExtension", "parsing memList xml failed");
          ae.printErrStackTrace("MicroMsg.TalkRoomExtension", parama, "", new Object[0]);
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