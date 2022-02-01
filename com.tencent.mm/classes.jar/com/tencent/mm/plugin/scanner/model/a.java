package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.Map;

public final class a
{
  public int IKe;
  public String IKf;
  public boolean IKg;
  public int iconHeight;
  public String iconUrl;
  public int iconWidth;
  public LinkedList<a> pSC;
  public String title;
  public int type;
  
  public a()
  {
    AppMethodBeat.i(51609);
    this.type = 1;
    this.pSC = new LinkedList();
    AppMethodBeat.o(51609);
  }
  
  public static LinkedList<a> o(Map<String, String> paramMap, String paramString)
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
        if (!Util.isNullOrNil((String)paramMap.get((String)localObject2 + ".$type"))) {
          locala.type = Util.getInt((String)paramMap.get((String)localObject2 + ".$type"), 0);
        }
        locala.title = Util.nullAsNil((String)paramMap.get((String)localObject2 + ".$title"));
        locala.iconUrl = Util.nullAsNil((String)paramMap.get((String)localObject2 + ".$iconurl"));
        locala.iconWidth = Util.getInt((String)paramMap.get((String)localObject2 + ".$iconwidth"), 34);
        locala.iconHeight = Util.getInt((String)paramMap.get((String)localObject2 + ".$iconheight"), 34);
        locala.IKf = Util.nullAsNil((String)paramMap.get((String)localObject2 + ".$referkey"));
        locala.IKe = Util.getInt((String)paramMap.get((String)localObject2 + ".$listshowtype"), 0);
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
        if (!Util.isNullOrNil((String)paramMap.get((String)localObject1 + ".$type"))) {
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
      locala.pSC = localLinkedList2;
    }
    label532:
    label586:
    for (;;)
    {
      locala.IKg = bool;
      localLinkedList1.add(locala);
      j += 1;
      break;
      i = 0;
      localObject1 = p(paramMap, (String)localObject1);
      if (localObject1 != null)
      {
        localLinkedList2.add(localObject1);
        if (!r.a((a)localObject1)) {
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
  
  public static a p(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(51611);
    int i = Util.getInt((String)paramMap.get(paramString + ".$type"), 0);
    a locala = new a(i);
    locala.type = i;
    locala.IKl = Util.nullAsNil((String)paramMap.get(paramString + ".statid"));
    locala.name = Util.nullAsNil((String)paramMap.get(paramString + ".name"));
    locala.desc = Util.nullAsNil((String)paramMap.get(paramString + ".desc"));
    locala.lpM = Util.nullAsNil((String)paramMap.get(paramString + ".digest"));
    locala.fwp = Util.getInt((String)paramMap.get(paramString + ".showtype"), 0);
    locala.image = Util.nullAsNil((String)paramMap.get(paramString + ".image"));
    locala.key = Util.nullAsNil((String)paramMap.get(paramString + ".$key"));
    locala.iconUrl = Util.nullAsNil((String)paramMap.get(paramString + ".iconurl"));
    if (i == 1)
    {
      locala.link = Util.nullAsNil((String)paramMap.get(paramString + ".link"));
      paramMap = locala;
    }
    for (;;)
    {
      AppMethodBeat.o(51611);
      return paramMap;
      if (i == 2)
      {
        locala.username = Util.nullAsNil((String)paramMap.get(paramString + ".username"));
        locala.nickname = Util.nullAsNil((String)paramMap.get(paramString + ".nickname"));
        locala.IKp = Util.nullAsNil((String)paramMap.get(paramString + ".strbeforefollow"));
        locala.IKq = Util.nullAsNil((String)paramMap.get(paramString + ".strafterfollow"));
        paramMap = locala;
      }
      else if (i == 3)
      {
        locala.thumburl = Util.nullAsNil((String)paramMap.get(paramString + ".thumburl"));
        locala.link = Util.nullAsNil((String)paramMap.get(paramString + ".link"));
        paramMap = locala;
      }
      else if (i == 4)
      {
        locala.thumburl = Util.nullAsNil((String)paramMap.get(paramString + ".thumburl"));
        locala.username = Util.nullAsNil((String)paramMap.get(paramString + ".username"));
        locala.nickname = Util.nullAsNil((String)paramMap.get(paramString + ".nickname"));
        paramMap = locala;
      }
      else
      {
        if (i == 5)
        {
          locala.IKi = Util.nullAsNil((String)paramMap.get(paramString + ".wifiurl"));
          locala.IKj = Util.nullAsNil((String)paramMap.get(paramString + ".wapurl"));
          locala.IKk = Util.nullAsNil((String)paramMap.get(paramString + ".weburl"));
          if ((Util.isNullOrNil(locala.IKi)) && (Util.isNullOrNil(locala.IKj)) && (Util.isNullOrNil(locala.IKk))) {
            paramMap = null;
          }
        }
        else if (i != 6)
        {
          if (i == 7)
          {
            locala.thumburl = Util.nullAsNil((String)paramMap.get(paramString + ".thumburl"));
            locala.IKh = Util.nullAsNil((String)paramMap.get(paramString + ".playurl"));
            paramMap = locala;
            continue;
          }
          if (i == 9)
          {
            locala.IKm = Util.nullAsNil((String)paramMap.get(paramString + ".productid"));
            paramMap = locala;
            continue;
          }
          if (i == 8)
          {
            locala.IKn = Util.nullAsNil((String)paramMap.get(paramString + ".cardext"));
            locala.IKo = Util.nullAsNil((String)paramMap.get(paramString + ".cardid"));
            paramMap = locala;
            continue;
          }
          if (i == 10)
          {
            locala.IKm = Util.nullAsNil((String)paramMap.get(paramString + ".id"));
            paramMap = locala;
            continue;
          }
          if (i == 12)
          {
            locala.thumburl = Util.nullAsNil((String)paramMap.get(paramString + ".image"));
            locala.link = Util.nullAsNil((String)paramMap.get(paramString + ".link"));
            paramMap = locala;
            continue;
          }
          if (i == 22)
          {
            locala.content = Util.nullAsNil((String)paramMap.get(paramString + ".content"));
            locala.link = Util.nullAsNil((String)paramMap.get(paramString + ".link"));
            locala.nickname = Util.nullAsNil((String)paramMap.get(paramString + ".nickname"));
            locala.thumburl = Util.nullAsNil((String)paramMap.get(paramString + ".image"));
            paramMap = locala;
            continue;
          }
          if (i == 21)
          {
            locala.IKf = Util.nullAsNil((String)paramMap.get(paramString + ".referkey"));
            paramMap = locala;
            continue;
          }
          locala.link = Util.nullAsNil((String)paramMap.get(paramString + ".link"));
        }
        paramMap = locala;
      }
    }
  }
  
  public static final class a
  {
    public String IKf;
    public String IKh = "";
    public String IKi = "";
    public String IKj = "";
    public String IKk = "";
    public String IKl = "";
    public String IKm = "";
    public String IKn = "";
    public String IKo = "";
    public String IKp;
    public String IKq;
    public String content;
    public String desc = "";
    public int fwp;
    public String iconUrl = "";
    public String image = "";
    public String key;
    public String link = "";
    public String lpM = "";
    public String name = "";
    public String nickname = "";
    public String thumburl = "";
    public int type;
    public String username = "";
    
    public a() {}
    
    public a(int paramInt)
    {
      this.type = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.a
 * JD-Core Version:    0.7.0.1
 */