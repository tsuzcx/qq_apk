package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.sdk.platformtools.bk;
import java.util.LinkedList;
import java.util.Map;

public final class a
{
  public LinkedList<a.a> eAm = new LinkedList();
  public int iJe;
  public String iconUrl;
  public String nGA;
  public boolean nGB;
  public int nGy;
  public int nGz;
  public String title;
  public int type = 1;
  
  public static LinkedList<a> l(Map<String, String> paramMap, String paramString)
  {
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
        if (!bk.bl((String)paramMap.get((String)localObject2 + ".$type"))) {
          locala.type = Integer.valueOf((String)paramMap.get((String)localObject2 + ".$type")).intValue();
        }
        locala.title = bk.pm((String)paramMap.get((String)localObject2 + ".$title"));
        locala.iconUrl = bk.pm((String)paramMap.get((String)localObject2 + ".$iconurl"));
        locala.iJe = bk.getInt((String)paramMap.get((String)localObject2 + ".$iconwidth"), 34);
        locala.nGy = bk.getInt((String)paramMap.get((String)localObject2 + ".$iconheight"), 34);
        locala.nGA = bk.pm((String)paramMap.get((String)localObject2 + ".$referkey"));
        locala.nGz = bk.getInt((String)paramMap.get((String)localObject2 + ".$listshowtype"), 0);
        bool = false;
        localLinkedList2 = new LinkedList();
        k = 0;
        if (k >= 1000) {
          break label573;
        }
        localStringBuilder = new StringBuilder().append((String)localObject2).append(".action");
        if (k <= 0) {
          break label486;
        }
      }
      label486:
      for (localObject1 = Integer.valueOf(k);; localObject1 = "")
      {
        localObject1 = localObject1;
        if (!bk.bl((String)paramMap.get((String)localObject1 + ".$type"))) {
          break label524;
        }
        if (i == 0) {
          break label493;
        }
        return localLinkedList1;
        localObject1 = "";
        break;
      }
      label493:
      i = 1;
      locala.eAm = localLinkedList2;
    }
    label524:
    label573:
    for (;;)
    {
      locala.nGB = bool;
      localLinkedList1.add(locala);
      j += 1;
      break;
      i = 0;
      localObject1 = m(paramMap, (String)localObject1);
      if (localObject1 != null)
      {
        localLinkedList2.add(localObject1);
        if (!l.a((a.a)localObject1)) {
          bool = true;
        }
      }
      for (;;)
      {
        k += 1;
        break;
        return localLinkedList1;
      }
    }
  }
  
  public static a.a m(Map<String, String> paramMap, String paramString)
  {
    int i = bk.getInt((String)paramMap.get(paramString + ".$type"), 0);
    a.a locala = new a.a(i);
    locala.type = i;
    locala.nGG = bk.pm((String)paramMap.get(paramString + ".statid"));
    locala.name = bk.pm((String)paramMap.get(paramString + ".name"));
    locala.desc = bk.pm((String)paramMap.get(paramString + ".desc"));
    locala.dTF = bk.pm((String)paramMap.get(paramString + ".digest"));
    locala.showType = bk.getInt((String)paramMap.get(paramString + ".showtype"), 0);
    locala.image = bk.pm((String)paramMap.get(paramString + ".image"));
    locala.key = bk.pm((String)paramMap.get(paramString + ".$key"));
    locala.iconUrl = bk.pm((String)paramMap.get(paramString + ".iconurl"));
    if (i == 1)
    {
      locala.eAl = bk.pm((String)paramMap.get(paramString + ".link"));
      return locala;
    }
    if (i == 2)
    {
      locala.username = bk.pm((String)paramMap.get(paramString + ".username"));
      locala.nickname = bk.pm((String)paramMap.get(paramString + ".nickname"));
      locala.nGK = bk.pm((String)paramMap.get(paramString + ".strbeforefollow"));
      locala.nGL = bk.pm((String)paramMap.get(paramString + ".strafterfollow"));
      return locala;
    }
    if (i == 3)
    {
      locala.thumburl = bk.pm((String)paramMap.get(paramString + ".thumburl"));
      locala.eAl = bk.pm((String)paramMap.get(paramString + ".link"));
      return locala;
    }
    if (i == 4)
    {
      locala.thumburl = bk.pm((String)paramMap.get(paramString + ".thumburl"));
      locala.username = bk.pm((String)paramMap.get(paramString + ".username"));
      locala.nickname = bk.pm((String)paramMap.get(paramString + ".nickname"));
      return locala;
    }
    if (i == 5)
    {
      locala.nGD = bk.pm((String)paramMap.get(paramString + ".wifiurl"));
      locala.nGE = bk.pm((String)paramMap.get(paramString + ".wapurl"));
      locala.nGF = bk.pm((String)paramMap.get(paramString + ".weburl"));
      if ((bk.bl(locala.nGD)) && (bk.bl(locala.nGE)) && (bk.bl(locala.nGF))) {
        return null;
      }
    }
    else if (i != 6)
    {
      if (i == 7)
      {
        locala.thumburl = bk.pm((String)paramMap.get(paramString + ".thumburl"));
        locala.nGC = bk.pm((String)paramMap.get(paramString + ".playurl"));
        return locala;
      }
      if (i == 9)
      {
        locala.nGH = bk.pm((String)paramMap.get(paramString + ".productid"));
        return locala;
      }
      if (i == 8)
      {
        locala.nGI = bk.pm((String)paramMap.get(paramString + ".cardext"));
        locala.nGJ = bk.pm((String)paramMap.get(paramString + ".cardid"));
        return locala;
      }
      if (i == 10)
      {
        locala.nGH = bk.pm((String)paramMap.get(paramString + ".id"));
        return locala;
      }
      if (i == 12)
      {
        locala.thumburl = bk.pm((String)paramMap.get(paramString + ".image"));
        locala.eAl = bk.pm((String)paramMap.get(paramString + ".link"));
        return locala;
      }
      if (i == 22)
      {
        locala.content = bk.pm((String)paramMap.get(paramString + ".content"));
        locala.eAl = bk.pm((String)paramMap.get(paramString + ".link"));
        locala.nickname = bk.pm((String)paramMap.get(paramString + ".nickname"));
        locala.thumburl = bk.pm((String)paramMap.get(paramString + ".image"));
        return locala;
      }
      if (i == 21)
      {
        locala.nGA = bk.pm((String)paramMap.get(paramString + ".referkey"));
        return locala;
      }
      locala.eAl = bk.pm((String)paramMap.get(paramString + ".link"));
    }
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.a.a
 * JD-Core Version:    0.7.0.1
 */