package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;
import java.util.Map;

public final class a
{
  public int iconHeight;
  public String iconUrl;
  public int iconWidth;
  public LinkedList<a> lFr;
  public String title;
  public int type;
  public int ylX;
  public String ylY;
  public boolean ylZ;
  
  public a()
  {
    AppMethodBeat.i(51609);
    this.type = 1;
    this.lFr = new LinkedList();
    AppMethodBeat.o(51609);
  }
  
  public static LinkedList<a> n(Map<String, String> paramMap, String paramString)
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
        locala.iconWidth = bt.getInt((String)paramMap.get((String)localObject2 + ".$iconwidth"), 34);
        locala.iconHeight = bt.getInt((String)paramMap.get((String)localObject2 + ".$iconheight"), 34);
        locala.ylY = bt.nullAsNil((String)paramMap.get((String)localObject2 + ".$referkey"));
        locala.ylX = bt.getInt((String)paramMap.get((String)localObject2 + ".$listshowtype"), 0);
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
      locala.lFr = localLinkedList2;
    }
    label532:
    label586:
    for (;;)
    {
      locala.ylZ = bool;
      localLinkedList1.add(locala);
      j += 1;
      break;
      i = 0;
      localObject1 = o(paramMap, (String)localObject1);
      if (localObject1 != null)
      {
        localLinkedList2.add(localObject1);
        if (!q.a((a)localObject1)) {
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
  
  public static a o(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(51611);
    int i = bt.getInt((String)paramMap.get(paramString + ".$type"), 0);
    a locala = new a(i);
    locala.type = i;
    locala.yme = bt.nullAsNil((String)paramMap.get(paramString + ".statid"));
    locala.name = bt.nullAsNil((String)paramMap.get(paramString + ".name"));
    locala.desc = bt.nullAsNil((String)paramMap.get(paramString + ".desc"));
    locala.hDo = bt.nullAsNil((String)paramMap.get(paramString + ".digest"));
    locala.dlp = bt.getInt((String)paramMap.get(paramString + ".showtype"), 0);
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
        locala.ymi = bt.nullAsNil((String)paramMap.get(paramString + ".strbeforefollow"));
        locala.ymj = bt.nullAsNil((String)paramMap.get(paramString + ".strafterfollow"));
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
          locala.ymb = bt.nullAsNil((String)paramMap.get(paramString + ".wifiurl"));
          locala.ymc = bt.nullAsNil((String)paramMap.get(paramString + ".wapurl"));
          locala.ymd = bt.nullAsNil((String)paramMap.get(paramString + ".weburl"));
          if ((bt.isNullOrNil(locala.ymb)) && (bt.isNullOrNil(locala.ymc)) && (bt.isNullOrNil(locala.ymd))) {
            paramMap = null;
          }
        }
        else if (i != 6)
        {
          if (i == 7)
          {
            locala.thumburl = bt.nullAsNil((String)paramMap.get(paramString + ".thumburl"));
            locala.yma = bt.nullAsNil((String)paramMap.get(paramString + ".playurl"));
            paramMap = locala;
            continue;
          }
          if (i == 9)
          {
            locala.ymf = bt.nullAsNil((String)paramMap.get(paramString + ".productid"));
            paramMap = locala;
            continue;
          }
          if (i == 8)
          {
            locala.ymg = bt.nullAsNil((String)paramMap.get(paramString + ".cardext"));
            locala.ymh = bt.nullAsNil((String)paramMap.get(paramString + ".cardid"));
            paramMap = locala;
            continue;
          }
          if (i == 10)
          {
            locala.ymf = bt.nullAsNil((String)paramMap.get(paramString + ".id"));
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
            locala.ylY = bt.nullAsNil((String)paramMap.get(paramString + ".referkey"));
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
    public String desc = "";
    public int dlp;
    public String hDo = "";
    public String iconUrl = "";
    public String image = "";
    public String key;
    public String link = "";
    public String name = "";
    public String nickname = "";
    public String thumburl = "";
    public int type;
    public String username = "";
    public String ylY;
    public String yma = "";
    public String ymb = "";
    public String ymc = "";
    public String ymd = "";
    public String yme = "";
    public String ymf = "";
    public String ymg = "";
    public String ymh = "";
    public String ymi;
    public String ymj;
    
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