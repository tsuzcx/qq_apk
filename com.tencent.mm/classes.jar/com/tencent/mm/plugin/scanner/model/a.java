package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.Map;

public final class a
{
  public int cDA;
  public int cDB;
  public LinkedList<a.a> fQb;
  public String iconUrl;
  public int qtP;
  public String qtQ;
  public boolean qtR;
  public String title;
  public int type;
  
  public a()
  {
    AppMethodBeat.i(80821);
    this.type = 1;
    this.fQb = new LinkedList();
    AppMethodBeat.o(80821);
  }
  
  public static LinkedList<a> l(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(80822);
    LinkedList localLinkedList1 = new LinkedList();
    int i = 0;
    int j = 0;
    a locala;
    Object localObject1;
    boolean bool;
    LinkedList localLinkedList2;
    int k;
    if (j < 1000)
    {
      locala = new a();
      Object localObject2 = new StringBuilder().append(paramString).append(".actionlist");
      StringBuilder localStringBuilder;
      if (j > 0)
      {
        localObject1 = Integer.valueOf(j);
        localObject2 = localObject1;
        if (!bo.isNullOrNil((String)paramMap.get((String)localObject2 + ".$type"))) {
          locala.type = Integer.valueOf((String)paramMap.get((String)localObject2 + ".$type")).intValue();
        }
        locala.title = bo.nullAsNil((String)paramMap.get((String)localObject2 + ".$title"));
        locala.iconUrl = bo.nullAsNil((String)paramMap.get((String)localObject2 + ".$iconurl"));
        locala.cDA = bo.getInt((String)paramMap.get((String)localObject2 + ".$iconwidth"), 34);
        locala.cDB = bo.getInt((String)paramMap.get((String)localObject2 + ".$iconheight"), 34);
        locala.qtQ = bo.nullAsNil((String)paramMap.get((String)localObject2 + ".$referkey"));
        locala.qtP = bo.getInt((String)paramMap.get((String)localObject2 + ".$listshowtype"), 0);
        bool = false;
        localLinkedList2 = new LinkedList();
        k = 0;
        if (k >= 1000) {
          break label588;
        }
        localStringBuilder = new StringBuilder().append((String)localObject2).append(".action");
        if (k <= 0) {
          break label496;
        }
      }
      label496:
      for (localObject1 = Integer.valueOf(k);; localObject1 = "")
      {
        localObject1 = localObject1;
        if (!bo.isNullOrNil((String)paramMap.get((String)localObject1 + ".$type"))) {
          break label534;
        }
        if (i == 0) {
          break label503;
        }
        AppMethodBeat.o(80822);
        return localLinkedList1;
        localObject1 = "";
        break;
      }
      label503:
      i = 1;
      locala.fQb = localLinkedList2;
    }
    label534:
    label588:
    for (;;)
    {
      locala.qtR = bool;
      localLinkedList1.add(locala);
      j += 1;
      break;
      i = 0;
      localObject1 = m(paramMap, (String)localObject1);
      if (localObject1 != null)
      {
        localLinkedList2.add(localObject1);
        if (!m.a((a.a)localObject1)) {
          bool = true;
        }
      }
      for (;;)
      {
        k += 1;
        break;
        AppMethodBeat.o(80822);
        return localLinkedList1;
      }
    }
  }
  
  public static a.a m(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(80823);
    int i = bo.getInt((String)paramMap.get(paramString + ".$type"), 0);
    a.a locala = new a.a(i);
    locala.type = i;
    locala.qtW = bo.nullAsNil((String)paramMap.get(paramString + ".statid"));
    locala.name = bo.nullAsNil((String)paramMap.get(paramString + ".name"));
    locala.desc = bo.nullAsNil((String)paramMap.get(paramString + ".desc"));
    locala.fjL = bo.nullAsNil((String)paramMap.get(paramString + ".digest"));
    locala.showType = bo.getInt((String)paramMap.get(paramString + ".showtype"), 0);
    locala.image = bo.nullAsNil((String)paramMap.get(paramString + ".image"));
    locala.key = bo.nullAsNil((String)paramMap.get(paramString + ".$key"));
    locala.iconUrl = bo.nullAsNil((String)paramMap.get(paramString + ".iconurl"));
    if (i == 1)
    {
      locala.link = bo.nullAsNil((String)paramMap.get(paramString + ".link"));
      paramMap = locala;
    }
    for (;;)
    {
      AppMethodBeat.o(80823);
      return paramMap;
      if (i == 2)
      {
        locala.username = bo.nullAsNil((String)paramMap.get(paramString + ".username"));
        locala.nickname = bo.nullAsNil((String)paramMap.get(paramString + ".nickname"));
        locala.qub = bo.nullAsNil((String)paramMap.get(paramString + ".strbeforefollow"));
        locala.quc = bo.nullAsNil((String)paramMap.get(paramString + ".strafterfollow"));
        paramMap = locala;
      }
      else if (i == 3)
      {
        locala.thumburl = bo.nullAsNil((String)paramMap.get(paramString + ".thumburl"));
        locala.link = bo.nullAsNil((String)paramMap.get(paramString + ".link"));
        paramMap = locala;
      }
      else if (i == 4)
      {
        locala.thumburl = bo.nullAsNil((String)paramMap.get(paramString + ".thumburl"));
        locala.username = bo.nullAsNil((String)paramMap.get(paramString + ".username"));
        locala.nickname = bo.nullAsNil((String)paramMap.get(paramString + ".nickname"));
        paramMap = locala;
      }
      else
      {
        if (i == 5)
        {
          locala.qtT = bo.nullAsNil((String)paramMap.get(paramString + ".wifiurl"));
          locala.qtU = bo.nullAsNil((String)paramMap.get(paramString + ".wapurl"));
          locala.qtV = bo.nullAsNil((String)paramMap.get(paramString + ".weburl"));
          if ((bo.isNullOrNil(locala.qtT)) && (bo.isNullOrNil(locala.qtU)) && (bo.isNullOrNil(locala.qtV))) {
            paramMap = null;
          }
        }
        else if (i != 6)
        {
          if (i == 7)
          {
            locala.thumburl = bo.nullAsNil((String)paramMap.get(paramString + ".thumburl"));
            locala.qtS = bo.nullAsNil((String)paramMap.get(paramString + ".playurl"));
            paramMap = locala;
            continue;
          }
          if (i == 9)
          {
            locala.qtX = bo.nullAsNil((String)paramMap.get(paramString + ".productid"));
            paramMap = locala;
            continue;
          }
          if (i == 8)
          {
            locala.qtY = bo.nullAsNil((String)paramMap.get(paramString + ".cardext"));
            locala.qtZ = bo.nullAsNil((String)paramMap.get(paramString + ".cardid"));
            paramMap = locala;
            continue;
          }
          if (i == 10)
          {
            locala.qtX = bo.nullAsNil((String)paramMap.get(paramString + ".id"));
            paramMap = locala;
            continue;
          }
          if (i == 12)
          {
            locala.thumburl = bo.nullAsNil((String)paramMap.get(paramString + ".image"));
            locala.link = bo.nullAsNil((String)paramMap.get(paramString + ".link"));
            paramMap = locala;
            continue;
          }
          if (i == 22)
          {
            locala.content = bo.nullAsNil((String)paramMap.get(paramString + ".content"));
            locala.link = bo.nullAsNil((String)paramMap.get(paramString + ".link"));
            locala.nickname = bo.nullAsNil((String)paramMap.get(paramString + ".nickname"));
            locala.thumburl = bo.nullAsNil((String)paramMap.get(paramString + ".image"));
            paramMap = locala;
            continue;
          }
          if (i == 21)
          {
            locala.qtQ = bo.nullAsNil((String)paramMap.get(paramString + ".referkey"));
            paramMap = locala;
            continue;
          }
          locala.link = bo.nullAsNil((String)paramMap.get(paramString + ".link"));
        }
        paramMap = locala;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.a
 * JD-Core Version:    0.7.0.1
 */