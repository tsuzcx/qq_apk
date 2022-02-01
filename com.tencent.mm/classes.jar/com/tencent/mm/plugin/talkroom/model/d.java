package com.tencent.mm.plugin.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.b;
import com.tencent.mm.an.h.c;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.protocal.protobuf.equ;
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
  private static int bdY(String paramString)
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
  
  private static String fM(List<equ> paramList)
  {
    AppMethodBeat.i(29458);
    List localList = b.gin().eMr();
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    label187:
    for (;;)
    {
      equ localequ;
      if (paramList.hasNext())
      {
        localequ = (equ)paramList.next();
        Iterator localIterator = localList.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
        } while (!((equ)localIterator.next()).UserName.equals(localequ.UserName));
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label187;
        }
        localLinkedList.add(localequ.UserName);
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
          if (!paramList.equals(com.tencent.mm.model.z.bcZ()))
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
  
  private static String fN(List<equ> paramList)
  {
    AppMethodBeat.i(29459);
    Object localObject = b.gin().eMr();
    LinkedList localLinkedList = new LinkedList();
    localObject = ((List)localObject).iterator();
    label187:
    for (;;)
    {
      equ localequ;
      if (((Iterator)localObject).hasNext())
      {
        localequ = (equ)((Iterator)localObject).next();
        Iterator localIterator = paramList.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
        } while (!((equ)localIterator.next()).UserName.equals(localequ.UserName));
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label187;
        }
        localLinkedList.add(localequ.UserName);
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
          if (!paramList.equals(com.tencent.mm.model.z.bcZ()))
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
    Object localObject2 = parama.jQG;
    if (localObject2 == null)
    {
      Log.e("MicroMsg.TalkRoomExtension", "onPreAddMessage cmdAM is null");
      AppMethodBeat.o(29456);
      return null;
    }
    if (((db)localObject2).COi != 56)
    {
      Log.e("MicroMsg.TalkRoomExtension", "onPreAddMessage cmdAM.type:%d", new Object[] { Integer.valueOf(((db)localObject2).COi) });
      AppMethodBeat.o(29456);
      return null;
    }
    Object localObject1 = com.tencent.mm.platformtools.z.a(((db)localObject2).RID);
    parama = com.tencent.mm.platformtools.z.a(((db)localObject2).RIE);
    bh.beI();
    if (((String)c.aHp().b(2, null)).equals(localObject1)) {
      localObject1 = parama;
    }
    for (;;)
    {
      bh.beI();
      parama = c.bbL().RG((String)localObject1);
      if ((parama == null) || ((int)parama.jxt == 0))
      {
        bh.beI();
        c.bbL().av(new as((String)localObject1));
      }
      parama = com.tencent.mm.platformtools.z.a(((db)localObject2).RIF);
      Log.d("MicroMsg.TalkRoomExtension", "talkroom xml:".concat(String.valueOf(parama)));
      localObject2 = XmlParser.parseXml(parama, "talkroominfo", null);
      if (localObject2 != null) {}
      for (;;)
      {
        try
        {
          if (bdY((String)((Map)localObject2).get(".talkroominfo.tracksysmsgtype")) != 0) {
            break label529;
          }
          bdY((String)((Map)localObject2).get(".talkroominfo.sysmsgtype"));
          i = 1;
          LinkedList localLinkedList = new LinkedList();
          bdY((String)((Map)localObject2).get(".talkroominfo.membersize"));
          int j = 0;
          Object localObject3 = new StringBuilder(".talkroominfo.memberlist.member");
          if (j == 0)
          {
            parama = "";
            localObject3 = parama;
            parama = (String)((Map)localObject2).get((String)localObject3 + ".username");
            if (!Util.isNullOrNil(parama))
            {
              int m = bdY((String)((Map)localObject2).get((String)localObject3 + ".memberid"));
              localObject3 = new equ();
              ((equ)localObject3).UserName = parama;
              ((equ)localObject3).Uth = m;
              localLinkedList.add(localObject3);
              j += 1;
            }
          }
          else
          {
            parama = Integer.valueOf(j);
            continue;
          }
          if (!((String)localObject1).equals(b.gin().Mkw)) {
            break label521;
          }
          localObject2 = fM(localLinkedList);
          if (!Util.isNullOrNil((String)localObject2)) {
            break label516;
          }
          parama = fN(localLinkedList);
          localObject3 = b.gio();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.d
 * JD-Core Version:    0.7.0.1
 */