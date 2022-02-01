package com.tencent.mm.plugin.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.b;
import com.tencent.mm.ak.f.c;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.protocal.protobuf.dgr;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class d
  implements f
{
  private static int axC(String paramString)
  {
    int j = 0;
    AppMethodBeat.i(29457);
    int i = j;
    if (!bs.isNullOrNil(paramString)) {}
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
        ac.printErrStackTrace("MicroMsg.TalkRoomExtension", paramString, "", new Object[0]);
        i = j;
      }
    }
  }
  
  private static String dZ(List<dgr> paramList)
  {
    AppMethodBeat.i(29458);
    List localList = b.ebm().cXc();
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    label187:
    for (;;)
    {
      dgr localdgr;
      if (paramList.hasNext())
      {
        localdgr = (dgr)paramList.next();
        Iterator localIterator = localList.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
        } while (!((dgr)localIterator.next()).ncR.equals(localdgr.ncR));
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label187;
        }
        localLinkedList.add(localdgr.ncR);
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
          if (!paramList.equals(u.axw()))
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
  
  private static String ea(List<dgr> paramList)
  {
    AppMethodBeat.i(29459);
    Object localObject = b.ebm().cXc();
    LinkedList localLinkedList = new LinkedList();
    localObject = ((List)localObject).iterator();
    label187:
    for (;;)
    {
      dgr localdgr;
      if (((Iterator)localObject).hasNext())
      {
        localdgr = (dgr)((Iterator)localObject).next();
        Iterator localIterator = paramList.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
        } while (!((dgr)localIterator.next()).ncR.equals(localdgr.ncR));
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label187;
        }
        localLinkedList.add(localdgr.ncR);
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
          if (!paramList.equals(u.axw()))
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
    Object localObject2 = parama.fXi;
    if (localObject2 == null)
    {
      ac.e("MicroMsg.TalkRoomExtension", "onPreAddMessage cmdAM is null");
      AppMethodBeat.o(29456);
      return null;
    }
    if (((cu)localObject2).tit != 56)
    {
      ac.e("MicroMsg.TalkRoomExtension", "onPreAddMessage cmdAM.type:%d", new Object[] { Integer.valueOf(((cu)localObject2).tit) });
      AppMethodBeat.o(29456);
      return null;
    }
    Object localObject1 = z.a(((cu)localObject2).DPT);
    parama = z.a(((cu)localObject2).DPU);
    az.ayM();
    if (((String)c.agA().get(2, null)).equals(localObject1)) {
      localObject1 = parama;
    }
    for (;;)
    {
      az.ayM();
      parama = c.awB().aNt((String)localObject1);
      if ((parama == null) || ((int)parama.fLJ == 0))
      {
        az.ayM();
        c.awB().ag(new ai((String)localObject1));
      }
      parama = z.a(((cu)localObject2).DPV);
      ac.d("MicroMsg.TalkRoomExtension", "talkroom xml:".concat(String.valueOf(parama)));
      localObject2 = bv.L(parama, "talkroominfo");
      if (localObject2 != null) {}
      for (;;)
      {
        try
        {
          if (axC((String)((Map)localObject2).get(".talkroominfo.tracksysmsgtype")) != 0) {
            break label528;
          }
          axC((String)((Map)localObject2).get(".talkroominfo.sysmsgtype"));
          i = 1;
          LinkedList localLinkedList = new LinkedList();
          axC((String)((Map)localObject2).get(".talkroominfo.membersize"));
          int j = 0;
          Object localObject3 = new StringBuilder(".talkroominfo.memberlist.member");
          if (j == 0)
          {
            parama = "";
            localObject3 = parama;
            parama = (String)((Map)localObject2).get((String)localObject3 + ".username");
            if (!bs.isNullOrNil(parama))
            {
              int m = axC((String)((Map)localObject2).get((String)localObject3 + ".memberid"));
              localObject3 = new dgr();
              ((dgr)localObject3).ncR = parama;
              ((dgr)localObject3).FPT = m;
              localLinkedList.add(localObject3);
              j += 1;
            }
          }
          else
          {
            parama = Integer.valueOf(j);
            continue;
          }
          if (!((String)localObject1).equals(b.ebm().zWB)) {
            break label520;
          }
          localObject2 = dZ(localLinkedList);
          if (!bs.isNullOrNil((String)localObject2)) {
            break label515;
          }
          parama = ea(localLinkedList);
          localObject3 = b.ebn();
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
          ac.e("MicroMsg.TalkRoomExtension", "parsing memList xml failed");
          ac.printErrStackTrace("MicroMsg.TalkRoomExtension", parama, "", new Object[0]);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.d
 * JD-Core Version:    0.7.0.1
 */