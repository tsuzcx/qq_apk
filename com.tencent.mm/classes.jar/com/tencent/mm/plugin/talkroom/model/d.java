package com.tencent.mm.plugin.talkroom.model;

import com.tencent.mm.ah.e.a;
import com.tencent.mm.ah.e.b;
import com.tencent.mm.ah.e.c;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.n.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.bxc;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.List<Lcom.tencent.mm.protocal.c.bxc;>;
import java.util.Map;

public final class d
  implements com.tencent.mm.ah.e
{
  private static int PH(String paramString)
  {
    int i = 0;
    if (!bk.bl(paramString)) {}
    try
    {
      i = Integer.valueOf(paramString).intValue();
      return i;
    }
    catch (Exception paramString)
    {
      y.printErrStackTrace("MicroMsg.TalkRoomExtension", paramString, "", new Object[0]);
    }
    return 0;
  }
  
  private static String bH(List<bxc> paramList)
  {
    Object localObject = b.bMu().bee();
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    label160:
    label165:
    for (;;)
    {
      bxc localbxc;
      if (paramList.hasNext())
      {
        localbxc = (bxc)paramList.next();
        Iterator localIterator = ((List)localObject).iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
        } while (!((bxc)localIterator.next()).hPY.equals(localbxc.hPY));
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label165;
        }
        localLinkedList.add(localbxc.hPY);
        break;
        if (localLinkedList.isEmpty())
        {
          paramList = null;
          return paramList;
        }
        i = 0;
        for (;;)
        {
          if (i >= localLinkedList.size()) {
            break label160;
          }
          localObject = (String)localLinkedList.get(i);
          paramList = (List<bxc>)localObject;
          if (!((String)localObject).equals(q.Gj())) {
            break;
          }
          i += 1;
        }
        return null;
      }
    }
  }
  
  private static String bI(List<bxc> paramList)
  {
    Object localObject = b.bMu().bee();
    LinkedList localLinkedList = new LinkedList();
    localObject = ((List)localObject).iterator();
    label160:
    label165:
    for (;;)
    {
      bxc localbxc;
      if (((Iterator)localObject).hasNext())
      {
        localbxc = (bxc)((Iterator)localObject).next();
        Iterator localIterator = paramList.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
        } while (!((bxc)localIterator.next()).hPY.equals(localbxc.hPY));
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label165;
        }
        localLinkedList.add(localbxc.hPY);
        break;
        if (localLinkedList.isEmpty())
        {
          paramList = null;
          return paramList;
        }
        i = 0;
        for (;;)
        {
          if (i >= localLinkedList.size()) {
            break label160;
          }
          localObject = (String)localLinkedList.get(i);
          paramList = (List<bxc>)localObject;
          if (!((String)localObject).equals(q.Gj())) {
            break;
          }
          i += 1;
        }
        return null;
      }
    }
  }
  
  public final void a(e.c paramc) {}
  
  public final e.b b(e.a parama)
  {
    int k = 1;
    Object localObject2 = parama.dBs;
    if (localObject2 == null)
    {
      y.e("MicroMsg.TalkRoomExtension", "onPreAddMessage cmdAM is null");
      return null;
    }
    if (((cd)localObject2).kSW != 56)
    {
      y.e("MicroMsg.TalkRoomExtension", "onPreAddMessage cmdAM.type:%d", new Object[] { Integer.valueOf(((cd)localObject2).kSW) });
      return null;
    }
    Object localObject1 = aa.a(((cd)localObject2).svF);
    parama = aa.a(((cd)localObject2).svG);
    au.Hx();
    if (((String)c.Dz().get(2, null)).equals(localObject1)) {
      localObject1 = parama;
    }
    for (;;)
    {
      au.Hx();
      parama = c.Fw().abl((String)localObject1);
      if ((parama == null) || ((int)parama.dBe == 0))
      {
        au.Hx();
        c.Fw().V(new ad((String)localObject1));
      }
      parama = aa.a(((cd)localObject2).svH);
      y.d("MicroMsg.TalkRoomExtension", "talkroom xml:" + parama);
      localObject2 = bn.s(parama, "talkroominfo");
      if (localObject2 == null) {
        break;
      }
      for (;;)
      {
        try
        {
          if (PH((String)((Map)localObject2).get(".talkroominfo.tracksysmsgtype")) != 0) {
            break label504;
          }
          PH((String)((Map)localObject2).get(".talkroominfo.sysmsgtype"));
          i = 1;
          LinkedList localLinkedList = new LinkedList();
          PH((String)((Map)localObject2).get(".talkroominfo.membersize"));
          int j = 0;
          Object localObject3 = new StringBuilder(".talkroominfo.memberlist.member");
          if (j == 0)
          {
            parama = "";
            localObject3 = parama;
            parama = (String)((Map)localObject2).get((String)localObject3 + ".username");
            if (!bk.bl(parama))
            {
              int m = PH((String)((Map)localObject2).get((String)localObject3 + ".memberid"));
              localObject3 = new bxc();
              ((bxc)localObject3).hPY = parama;
              ((bxc)localObject3).tNh = m;
              localLinkedList.add(localObject3);
              j += 1;
            }
          }
          else
          {
            parama = Integer.valueOf(j);
            continue;
          }
          if (!((String)localObject1).equals(b.bMu().pBi)) {
            break label496;
          }
          localObject2 = bH(localLinkedList);
          if (bk.bl((String)localObject2))
          {
            parama = bI(localLinkedList);
            localObject3 = b.bMv();
            j = k;
            if (i != 0) {
              j = 0;
            }
            ((e)localObject3).a((String)localObject1, localLinkedList, (String)localObject2, parama, j);
            return null;
          }
        }
        catch (Exception parama)
        {
          y.e("MicroMsg.TalkRoomExtension", "parsing memList xml failed");
          y.printErrStackTrace("MicroMsg.TalkRoomExtension", parama, "", new Object[0]);
          return null;
        }
        parama = null;
        continue;
        label496:
        parama = null;
        localObject2 = null;
        continue;
        label504:
        int i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.d
 * JD-Core Version:    0.7.0.1
 */