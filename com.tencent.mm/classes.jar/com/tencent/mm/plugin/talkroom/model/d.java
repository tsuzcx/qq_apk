package com.tencent.mm.plugin.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.b;
import com.tencent.mm.ak.h.c;
import com.tencent.mm.model.bg;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.protocal.protobuf.egs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class d
  implements h
{
  private static int aSU(String paramString)
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
  
  private static String fk(List<egs> paramList)
  {
    AppMethodBeat.i(29458);
    List localList = b.ftN().ecY();
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    label187:
    for (;;)
    {
      egs localegs;
      if (paramList.hasNext())
      {
        localegs = (egs)paramList.next();
        Iterator localIterator = localList.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
        } while (!((egs)localIterator.next()).UserName.equals(localegs.UserName));
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label187;
        }
        localLinkedList.add(localegs.UserName);
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
          if (!paramList.equals(com.tencent.mm.model.z.aTY()))
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
  
  private static String fl(List<egs> paramList)
  {
    AppMethodBeat.i(29459);
    Object localObject = b.ftN().ecY();
    LinkedList localLinkedList = new LinkedList();
    localObject = ((List)localObject).iterator();
    label187:
    for (;;)
    {
      egs localegs;
      if (((Iterator)localObject).hasNext())
      {
        localegs = (egs)((Iterator)localObject).next();
        Iterator localIterator = paramList.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
        } while (!((egs)localIterator.next()).UserName.equals(localegs.UserName));
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label187;
        }
        localLinkedList.add(localegs.UserName);
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
          if (!paramList.equals(com.tencent.mm.model.z.aTY()))
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
  
  public final h.b b(h.a parama)
  {
    int k = 1;
    AppMethodBeat.i(29456);
    Object localObject2 = parama.heO;
    if (localObject2 == null)
    {
      Log.e("MicroMsg.TalkRoomExtension", "onPreAddMessage cmdAM is null");
      AppMethodBeat.o(29456);
      return null;
    }
    if (((de)localObject2).xKb != 56)
    {
      Log.e("MicroMsg.TalkRoomExtension", "onPreAddMessage cmdAM.type:%d", new Object[] { Integer.valueOf(((de)localObject2).xKb) });
      AppMethodBeat.o(29456);
      return null;
    }
    Object localObject1 = com.tencent.mm.platformtools.z.a(((de)localObject2).KHl);
    parama = com.tencent.mm.platformtools.z.a(((de)localObject2).KHm);
    bg.aVF();
    if (((String)com.tencent.mm.model.c.azQ().get(2, null)).equals(localObject1)) {
      localObject1 = parama;
    }
    for (;;)
    {
      bg.aVF();
      parama = com.tencent.mm.model.c.aSN().Kn((String)localObject1);
      if ((parama == null) || ((int)parama.gMZ == 0))
      {
        bg.aVF();
        com.tencent.mm.model.c.aSN().ap(new as((String)localObject1));
      }
      parama = com.tencent.mm.platformtools.z.a(((de)localObject2).KHn);
      Log.d("MicroMsg.TalkRoomExtension", "talkroom xml:".concat(String.valueOf(parama)));
      localObject2 = XmlParser.parseXml(parama, "talkroominfo", null);
      if (localObject2 != null) {}
      for (;;)
      {
        try
        {
          if (aSU((String)((Map)localObject2).get(".talkroominfo.tracksysmsgtype")) != 0) {
            break label529;
          }
          aSU((String)((Map)localObject2).get(".talkroominfo.sysmsgtype"));
          i = 1;
          LinkedList localLinkedList = new LinkedList();
          aSU((String)((Map)localObject2).get(".talkroominfo.membersize"));
          int j = 0;
          Object localObject3 = new StringBuilder(".talkroominfo.memberlist.member");
          if (j == 0)
          {
            parama = "";
            localObject3 = parama;
            parama = (String)((Map)localObject2).get((String)localObject3 + ".username");
            if (!Util.isNullOrNil(parama))
            {
              int m = aSU((String)((Map)localObject2).get((String)localObject3 + ".memberid"));
              localObject3 = new egs();
              ((egs)localObject3).UserName = parama;
              ((egs)localObject3).NgD = m;
              localLinkedList.add(localObject3);
              j += 1;
            }
          }
          else
          {
            parama = Integer.valueOf(j);
            continue;
          }
          if (!((String)localObject1).equals(b.ftN().FQv)) {
            break label521;
          }
          localObject2 = fk(localLinkedList);
          if (!Util.isNullOrNil((String)localObject2)) {
            break label516;
          }
          parama = fl(localLinkedList);
          localObject3 = b.ftO();
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
  
  public final void b(h.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.d
 * JD-Core Version:    0.7.0.1
 */