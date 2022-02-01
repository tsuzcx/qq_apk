package com.tencent.mm.plugin.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.f.a;
import com.tencent.mm.al.f.b;
import com.tencent.mm.al.f.c;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.protocal.protobuf.dbf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class d
  implements f
{
  private static int ast(String paramString)
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
  
  private static String dV(List<dbf> paramList)
  {
    AppMethodBeat.i(29458);
    List localList = b.dMM().cJx();
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    label187:
    for (;;)
    {
      dbf localdbf;
      if (paramList.hasNext())
      {
        localdbf = (dbf)paramList.next();
        Iterator localIterator = localList.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
        } while (!((dbf)localIterator.next()).mAQ.equals(localdbf.mAQ));
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label187;
        }
        localLinkedList.add(localdbf.mAQ);
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
          if (!paramList.equals(u.aqG()))
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
  
  private static String dW(List<dbf> paramList)
  {
    AppMethodBeat.i(29459);
    Object localObject = b.dMM().cJx();
    LinkedList localLinkedList = new LinkedList();
    localObject = ((List)localObject).iterator();
    label187:
    for (;;)
    {
      dbf localdbf;
      if (((Iterator)localObject).hasNext())
      {
        localdbf = (dbf)((Iterator)localObject).next();
        Iterator localIterator = paramList.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
        } while (!((dbf)localIterator.next()).mAQ.equals(localdbf.mAQ));
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label187;
        }
        localLinkedList.add(localdbf.mAQ);
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
          if (!paramList.equals(u.aqG()))
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
  
  public final f.b b(f.a parama)
  {
    int k = 1;
    AppMethodBeat.i(29456);
    Object localObject2 = parama.fTo;
    if (localObject2 == null)
    {
      ad.e("MicroMsg.TalkRoomExtension", "onPreAddMessage cmdAM is null");
      AppMethodBeat.o(29456);
      return null;
    }
    if (((cs)localObject2).saz != 56)
    {
      ad.e("MicroMsg.TalkRoomExtension", "onPreAddMessage cmdAM.type:%d", new Object[] { Integer.valueOf(((cs)localObject2).saz) });
      AppMethodBeat.o(29456);
      return null;
    }
    Object localObject1 = z.a(((cs)localObject2).Cxx);
    parama = z.a(((cs)localObject2).Cxy);
    az.arV();
    if (((String)c.afk().get(2, null)).equals(localObject1)) {
      localObject1 = parama;
    }
    for (;;)
    {
      az.arV();
      parama = c.apM().aHY((String)localObject1);
      if ((parama == null) || ((int)parama.fId == 0))
      {
        az.arV();
        c.apM().af(new af((String)localObject1));
      }
      parama = z.a(((cs)localObject2).Cxz);
      ad.d("MicroMsg.TalkRoomExtension", "talkroom xml:".concat(String.valueOf(parama)));
      localObject2 = bw.K(parama, "talkroominfo");
      if (localObject2 != null) {}
      for (;;)
      {
        try
        {
          if (ast((String)((Map)localObject2).get(".talkroominfo.tracksysmsgtype")) != 0) {
            break label528;
          }
          ast((String)((Map)localObject2).get(".talkroominfo.sysmsgtype"));
          i = 1;
          LinkedList localLinkedList = new LinkedList();
          ast((String)((Map)localObject2).get(".talkroominfo.membersize"));
          int j = 0;
          Object localObject3 = new StringBuilder(".talkroominfo.memberlist.member");
          if (j == 0)
          {
            parama = "";
            localObject3 = parama;
            parama = (String)((Map)localObject2).get((String)localObject3 + ".username");
            if (!bt.isNullOrNil(parama))
            {
              int m = ast((String)((Map)localObject2).get((String)localObject3 + ".memberid"));
              localObject3 = new dbf();
              ((dbf)localObject3).mAQ = parama;
              ((dbf)localObject3).EsR = m;
              localLinkedList.add(localObject3);
              j += 1;
            }
          }
          else
          {
            parama = Integer.valueOf(j);
            continue;
          }
          if (!((String)localObject1).equals(b.dMM().yJo)) {
            break label520;
          }
          localObject2 = dV(localLinkedList);
          if (!bt.isNullOrNil((String)localObject2)) {
            break label515;
          }
          parama = dW(localLinkedList);
          localObject3 = b.dMN();
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
  
  public final void b(f.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.d
 * JD-Core Version:    0.7.0.1
 */