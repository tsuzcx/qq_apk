package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.LinkedList;
import java.util.Map;

public final class a
{
  public int drN;
  public int drO;
  public String iconUrl;
  public LinkedList<a> lio;
  public String title;
  public int type;
  public int wYo;
  public String wYp;
  public boolean wYq;
  
  public a()
  {
    AppMethodBeat.i(51609);
    this.type = 1;
    this.lio = new LinkedList();
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
        if (!bs.isNullOrNil((String)paramMap.get((String)localObject2 + ".$type"))) {
          locala.type = bs.getInt((String)paramMap.get((String)localObject2 + ".$type"), 0);
        }
        locala.title = bs.nullAsNil((String)paramMap.get((String)localObject2 + ".$title"));
        locala.iconUrl = bs.nullAsNil((String)paramMap.get((String)localObject2 + ".$iconurl"));
        locala.drN = bs.getInt((String)paramMap.get((String)localObject2 + ".$iconwidth"), 34);
        locala.drO = bs.getInt((String)paramMap.get((String)localObject2 + ".$iconheight"), 34);
        locala.wYp = bs.nullAsNil((String)paramMap.get((String)localObject2 + ".$referkey"));
        locala.wYo = bs.getInt((String)paramMap.get((String)localObject2 + ".$listshowtype"), 0);
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
        if (!bs.isNullOrNil((String)paramMap.get((String)localObject1 + ".$type"))) {
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
      locala.lio = localLinkedList2;
    }
    label532:
    label586:
    for (;;)
    {
      locala.wYq = bool;
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
    int i = bs.getInt((String)paramMap.get(paramString + ".$type"), 0);
    a locala = new a(i);
    locala.type = i;
    locala.wYv = bs.nullAsNil((String)paramMap.get(paramString + ".statid"));
    locala.name = bs.nullAsNil((String)paramMap.get(paramString + ".name"));
    locala.desc = bs.nullAsNil((String)paramMap.get(paramString + ".desc"));
    locala.hlf = bs.nullAsNil((String)paramMap.get(paramString + ".digest"));
    locala.cZX = bs.getInt((String)paramMap.get(paramString + ".showtype"), 0);
    locala.image = bs.nullAsNil((String)paramMap.get(paramString + ".image"));
    locala.key = bs.nullAsNil((String)paramMap.get(paramString + ".$key"));
    locala.iconUrl = bs.nullAsNil((String)paramMap.get(paramString + ".iconurl"));
    if (i == 1)
    {
      locala.link = bs.nullAsNil((String)paramMap.get(paramString + ".link"));
      paramMap = locala;
    }
    for (;;)
    {
      AppMethodBeat.o(51611);
      return paramMap;
      if (i == 2)
      {
        locala.username = bs.nullAsNil((String)paramMap.get(paramString + ".username"));
        locala.nickname = bs.nullAsNil((String)paramMap.get(paramString + ".nickname"));
        locala.wYz = bs.nullAsNil((String)paramMap.get(paramString + ".strbeforefollow"));
        locala.wYA = bs.nullAsNil((String)paramMap.get(paramString + ".strafterfollow"));
        paramMap = locala;
      }
      else if (i == 3)
      {
        locala.thumburl = bs.nullAsNil((String)paramMap.get(paramString + ".thumburl"));
        locala.link = bs.nullAsNil((String)paramMap.get(paramString + ".link"));
        paramMap = locala;
      }
      else if (i == 4)
      {
        locala.thumburl = bs.nullAsNil((String)paramMap.get(paramString + ".thumburl"));
        locala.username = bs.nullAsNil((String)paramMap.get(paramString + ".username"));
        locala.nickname = bs.nullAsNil((String)paramMap.get(paramString + ".nickname"));
        paramMap = locala;
      }
      else
      {
        if (i == 5)
        {
          locala.wYs = bs.nullAsNil((String)paramMap.get(paramString + ".wifiurl"));
          locala.wYt = bs.nullAsNil((String)paramMap.get(paramString + ".wapurl"));
          locala.wYu = bs.nullAsNil((String)paramMap.get(paramString + ".weburl"));
          if ((bs.isNullOrNil(locala.wYs)) && (bs.isNullOrNil(locala.wYt)) && (bs.isNullOrNil(locala.wYu))) {
            paramMap = null;
          }
        }
        else if (i != 6)
        {
          if (i == 7)
          {
            locala.thumburl = bs.nullAsNil((String)paramMap.get(paramString + ".thumburl"));
            locala.wYr = bs.nullAsNil((String)paramMap.get(paramString + ".playurl"));
            paramMap = locala;
            continue;
          }
          if (i == 9)
          {
            locala.wYw = bs.nullAsNil((String)paramMap.get(paramString + ".productid"));
            paramMap = locala;
            continue;
          }
          if (i == 8)
          {
            locala.wYx = bs.nullAsNil((String)paramMap.get(paramString + ".cardext"));
            locala.wYy = bs.nullAsNil((String)paramMap.get(paramString + ".cardid"));
            paramMap = locala;
            continue;
          }
          if (i == 10)
          {
            locala.wYw = bs.nullAsNil((String)paramMap.get(paramString + ".id"));
            paramMap = locala;
            continue;
          }
          if (i == 12)
          {
            locala.thumburl = bs.nullAsNil((String)paramMap.get(paramString + ".image"));
            locala.link = bs.nullAsNil((String)paramMap.get(paramString + ".link"));
            paramMap = locala;
            continue;
          }
          if (i == 22)
          {
            locala.content = bs.nullAsNil((String)paramMap.get(paramString + ".content"));
            locala.link = bs.nullAsNil((String)paramMap.get(paramString + ".link"));
            locala.nickname = bs.nullAsNil((String)paramMap.get(paramString + ".nickname"));
            locala.thumburl = bs.nullAsNil((String)paramMap.get(paramString + ".image"));
            paramMap = locala;
            continue;
          }
          if (i == 21)
          {
            locala.wYp = bs.nullAsNil((String)paramMap.get(paramString + ".referkey"));
            paramMap = locala;
            continue;
          }
          locala.link = bs.nullAsNil((String)paramMap.get(paramString + ".link"));
        }
        paramMap = locala;
      }
    }
  }
  
  public static final class a
  {
    public int cZX;
    public String content;
    public String desc = "";
    public String hlf = "";
    public String iconUrl = "";
    public String image = "";
    public String key;
    public String link = "";
    public String name = "";
    public String nickname = "";
    public String thumburl = "";
    public int type;
    public String username = "";
    public String wYA;
    public String wYp;
    public String wYr = "";
    public String wYs = "";
    public String wYt = "";
    public String wYu = "";
    public String wYv = "";
    public String wYw = "";
    public String wYx = "";
    public String wYy = "";
    public String wYz;
    
    public a() {}
    
    public a(int paramInt)
    {
      this.type = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.a
 * JD-Core Version:    0.7.0.1
 */