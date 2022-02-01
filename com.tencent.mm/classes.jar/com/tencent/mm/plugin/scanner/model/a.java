package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;
import java.util.Map;

public final class a
{
  public int duc;
  public int dud;
  public String iconUrl;
  public LinkedList<a> kGU;
  public String title;
  public int type;
  public int vNS;
  public String vNT;
  public boolean vNU;
  
  public a()
  {
    AppMethodBeat.i(51609);
    this.type = 1;
    this.kGU = new LinkedList();
    AppMethodBeat.o(51609);
  }
  
  public static LinkedList<a> m(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(51610);
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
        if (!bt.isNullOrNil((String)paramMap.get((String)localObject2 + ".$type"))) {
          locala.type = bt.getInt((String)paramMap.get((String)localObject2 + ".$type"), 0);
        }
        locala.title = bt.nullAsNil((String)paramMap.get((String)localObject2 + ".$title"));
        locala.iconUrl = bt.nullAsNil((String)paramMap.get((String)localObject2 + ".$iconurl"));
        locala.duc = bt.getInt((String)paramMap.get((String)localObject2 + ".$iconwidth"), 34);
        locala.dud = bt.getInt((String)paramMap.get((String)localObject2 + ".$iconheight"), 34);
        locala.vNT = bt.nullAsNil((String)paramMap.get((String)localObject2 + ".$referkey"));
        locala.vNS = bt.getInt((String)paramMap.get((String)localObject2 + ".$listshowtype"), 0);
        bool = false;
        localLinkedList2 = new LinkedList();
        k = 0;
        if (k >= 1000) {
          break label586;
        }
        localStringBuilder = new StringBuilder().append((String)localObject2).append(".action");
        if (k <= 0) {
          break label494;
        }
      }
      label494:
      for (localObject1 = Integer.valueOf(k);; localObject1 = "")
      {
        localObject1 = localObject1;
        if (!bt.isNullOrNil((String)paramMap.get((String)localObject1 + ".$type"))) {
          break label532;
        }
        if (i == 0) {
          break label501;
        }
        AppMethodBeat.o(51610);
        return localLinkedList1;
        localObject1 = "";
        break;
      }
      label501:
      i = 1;
      locala.kGU = localLinkedList2;
    }
    label532:
    label586:
    for (;;)
    {
      locala.vNU = bool;
      localLinkedList1.add(locala);
      j += 1;
      break;
      i = 0;
      localObject1 = n(paramMap, (String)localObject1);
      if (localObject1 != null)
      {
        localLinkedList2.add(localObject1);
        if (!o.a((a)localObject1)) {
          bool = true;
        }
      }
      for (;;)
      {
        k += 1;
        break;
        AppMethodBeat.o(51610);
        return localLinkedList1;
      }
    }
  }
  
  public static a n(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(51611);
    int i = bt.getInt((String)paramMap.get(paramString + ".$type"), 0);
    a locala = new a(i);
    locala.type = i;
    locala.vNZ = bt.nullAsNil((String)paramMap.get(paramString + ".statid"));
    locala.name = bt.nullAsNil((String)paramMap.get(paramString + ".name"));
    locala.desc = bt.nullAsNil((String)paramMap.get(paramString + ".desc"));
    locala.gKF = bt.nullAsNil((String)paramMap.get(paramString + ".digest"));
    locala.dcz = bt.getInt((String)paramMap.get(paramString + ".showtype"), 0);
    locala.image = bt.nullAsNil((String)paramMap.get(paramString + ".image"));
    locala.key = bt.nullAsNil((String)paramMap.get(paramString + ".$key"));
    locala.iconUrl = bt.nullAsNil((String)paramMap.get(paramString + ".iconurl"));
    if (i == 1)
    {
      locala.link = bt.nullAsNil((String)paramMap.get(paramString + ".link"));
      paramMap = locala;
    }
    for (;;)
    {
      AppMethodBeat.o(51611);
      return paramMap;
      if (i == 2)
      {
        locala.username = bt.nullAsNil((String)paramMap.get(paramString + ".username"));
        locala.nickname = bt.nullAsNil((String)paramMap.get(paramString + ".nickname"));
        locala.vOd = bt.nullAsNil((String)paramMap.get(paramString + ".strbeforefollow"));
        locala.vOe = bt.nullAsNil((String)paramMap.get(paramString + ".strafterfollow"));
        paramMap = locala;
      }
      else if (i == 3)
      {
        locala.thumburl = bt.nullAsNil((String)paramMap.get(paramString + ".thumburl"));
        locala.link = bt.nullAsNil((String)paramMap.get(paramString + ".link"));
        paramMap = locala;
      }
      else if (i == 4)
      {
        locala.thumburl = bt.nullAsNil((String)paramMap.get(paramString + ".thumburl"));
        locala.username = bt.nullAsNil((String)paramMap.get(paramString + ".username"));
        locala.nickname = bt.nullAsNil((String)paramMap.get(paramString + ".nickname"));
        paramMap = locala;
      }
      else
      {
        if (i == 5)
        {
          locala.vNW = bt.nullAsNil((String)paramMap.get(paramString + ".wifiurl"));
          locala.vNX = bt.nullAsNil((String)paramMap.get(paramString + ".wapurl"));
          locala.vNY = bt.nullAsNil((String)paramMap.get(paramString + ".weburl"));
          if ((bt.isNullOrNil(locala.vNW)) && (bt.isNullOrNil(locala.vNX)) && (bt.isNullOrNil(locala.vNY))) {
            paramMap = null;
          }
        }
        else if (i != 6)
        {
          if (i == 7)
          {
            locala.thumburl = bt.nullAsNil((String)paramMap.get(paramString + ".thumburl"));
            locala.vNV = bt.nullAsNil((String)paramMap.get(paramString + ".playurl"));
            paramMap = locala;
            continue;
          }
          if (i == 9)
          {
            locala.vOa = bt.nullAsNil((String)paramMap.get(paramString + ".productid"));
            paramMap = locala;
            continue;
          }
          if (i == 8)
          {
            locala.vOb = bt.nullAsNil((String)paramMap.get(paramString + ".cardext"));
            locala.vOc = bt.nullAsNil((String)paramMap.get(paramString + ".cardid"));
            paramMap = locala;
            continue;
          }
          if (i == 10)
          {
            locala.vOa = bt.nullAsNil((String)paramMap.get(paramString + ".id"));
            paramMap = locala;
            continue;
          }
          if (i == 12)
          {
            locala.thumburl = bt.nullAsNil((String)paramMap.get(paramString + ".image"));
            locala.link = bt.nullAsNil((String)paramMap.get(paramString + ".link"));
            paramMap = locala;
            continue;
          }
          if (i == 22)
          {
            locala.content = bt.nullAsNil((String)paramMap.get(paramString + ".content"));
            locala.link = bt.nullAsNil((String)paramMap.get(paramString + ".link"));
            locala.nickname = bt.nullAsNil((String)paramMap.get(paramString + ".nickname"));
            locala.thumburl = bt.nullAsNil((String)paramMap.get(paramString + ".image"));
            paramMap = locala;
            continue;
          }
          if (i == 21)
          {
            locala.vNT = bt.nullAsNil((String)paramMap.get(paramString + ".referkey"));
            paramMap = locala;
            continue;
          }
          locala.link = bt.nullAsNil((String)paramMap.get(paramString + ".link"));
        }
        paramMap = locala;
      }
    }
  }
  
  public static final class a
  {
    public String content;
    public int dcz;
    public String desc = "";
    public String gKF = "";
    public String iconUrl = "";
    public String image = "";
    public String key;
    public String link = "";
    public String name = "";
    public String nickname = "";
    public String thumburl = "";
    public int type;
    public String username = "";
    public String vNT;
    public String vNV = "";
    public String vNW = "";
    public String vNX = "";
    public String vNY = "";
    public String vNZ = "";
    public String vOa = "";
    public String vOb = "";
    public String vOc = "";
    public String vOd;
    public String vOe;
    
    public a() {}
    
    public a(int paramInt)
    {
      this.type = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.a
 * JD-Core Version:    0.7.0.1
 */