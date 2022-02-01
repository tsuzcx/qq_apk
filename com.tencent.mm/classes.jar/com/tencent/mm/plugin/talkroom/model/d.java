package com.tencent.mm.plugin.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.b;
import com.tencent.mm.am.g.c;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.protocal.protobuf.fly;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class d
  implements com.tencent.mm.am.g
{
  private static int bdg(String paramString)
  {
    int j = 0;
    AppMethodBeat.i(29457);
    int i = j;
    if (!Util.isNullOrNil(paramString)) {}
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
        Log.printErrStackTrace("MicroMsg.TalkRoomExtension", paramString, "", new Object[0]);
        i = j;
      }
    }
  }
  
  private static String iK(List<fly> paramList)
  {
    AppMethodBeat.i(29458);
    List localList = b.hCo().fUJ();
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    label187:
    for (;;)
    {
      fly localfly;
      if (paramList.hasNext())
      {
        localfly = (fly)paramList.next();
        Iterator localIterator = localList.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
        } while (!((fly)localIterator.next()).UserName.equals(localfly.UserName));
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label187;
        }
        localLinkedList.add(localfly.UserName);
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
          if (!paramList.equals(z.bAM()))
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
  
  private static String iL(List<fly> paramList)
  {
    AppMethodBeat.i(29459);
    Object localObject = b.hCo().fUJ();
    LinkedList localLinkedList = new LinkedList();
    localObject = ((List)localObject).iterator();
    label187:
    for (;;)
    {
      fly localfly;
      if (((Iterator)localObject).hasNext())
      {
        localfly = (fly)((Iterator)localObject).next();
        Iterator localIterator = paramList.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
        } while (!((fly)localIterator.next()).UserName.equals(localfly.UserName));
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label187;
        }
        localLinkedList.add(localfly.UserName);
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
          if (!paramList.equals(z.bAM()))
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
  
  public final g.b b(g.a parama)
  {
    int k = 1;
    AppMethodBeat.i(29456);
    Object localObject2 = parama.mpN;
    if (localObject2 == null)
    {
      Log.e("MicroMsg.TalkRoomExtension", "onPreAddMessage cmdAM is null");
      AppMethodBeat.o(29456);
      return null;
    }
    if (((dl)localObject2).IIs != 56)
    {
      Log.e("MicroMsg.TalkRoomExtension", "onPreAddMessage cmdAM.type:%d", new Object[] { Integer.valueOf(((dl)localObject2).IIs) });
      AppMethodBeat.o(29456);
      return null;
    }
    Object localObject1 = w.a(((dl)localObject2).YFE);
    parama = w.a(((dl)localObject2).YFF);
    bh.bCz();
    if (((String)c.ban().d(2, null)).equals(localObject1)) {
      localObject1 = parama;
    }
    for (;;)
    {
      bh.bCz();
      parama = c.bzA().JE((String)localObject1);
      if ((parama == null) || ((int)parama.maN == 0))
      {
        bh.bCz();
        c.bzA().aB(new au((String)localObject1));
      }
      parama = w.a(((dl)localObject2).YFG);
      Log.d("MicroMsg.TalkRoomExtension", "talkroom xml:".concat(String.valueOf(parama)));
      localObject2 = XmlParser.parseXml(parama, "talkroominfo", null);
      if (localObject2 != null) {}
      for (;;)
      {
        try
        {
          if (bdg((String)((Map)localObject2).get(".talkroominfo.tracksysmsgtype")) != 0) {
            break label529;
          }
          bdg((String)((Map)localObject2).get(".talkroominfo.sysmsgtype"));
          i = 1;
          LinkedList localLinkedList = new LinkedList();
          bdg((String)((Map)localObject2).get(".talkroominfo.membersize"));
          int j = 0;
          Object localObject3 = new StringBuilder(".talkroominfo.memberlist.member");
          if (j == 0)
          {
            parama = "";
            localObject3 = parama;
            parama = (String)((Map)localObject2).get((String)localObject3 + ".username");
            if (!Util.isNullOrNil(parama))
            {
              int m = bdg((String)((Map)localObject2).get((String)localObject3 + ".memberid"));
              localObject3 = new fly();
              ((fly)localObject3).UserName = parama;
              ((fly)localObject3).abMo = m;
              localLinkedList.add(localObject3);
              j += 1;
            }
          }
          else
          {
            parama = Integer.valueOf(j);
            continue;
          }
          if (!((String)localObject1).equals(b.hCo().SNR)) {
            break label521;
          }
          localObject2 = iK(localLinkedList);
          if (!Util.isNullOrNil((String)localObject2)) {
            break label516;
          }
          parama = iL(localLinkedList);
          localObject3 = b.hCp();
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
          Log.e("MicroMsg.TalkRoomExtension", "parsing memList xml failed");
          Log.printErrStackTrace("MicroMsg.TalkRoomExtension", parama, "", new Object[0]);
        }
        AppMethodBeat.o(29456);
        return null;
        label516:
        parama = null;
        continue;
        label521:
        parama = null;
        localObject2 = null;
        continue;
        label529:
        int i = 0;
      }
    }
  }
  
  public final void b(g.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.d
 * JD-Core Version:    0.7.0.1
 */