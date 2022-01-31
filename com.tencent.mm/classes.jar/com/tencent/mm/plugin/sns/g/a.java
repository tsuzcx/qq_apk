package com.tencent.mm.plugin.sns.g;

import com.tencent.mm.protocal.c.anz;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.awf;
import com.tencent.mm.protocal.c.cq;
import com.tencent.mm.protocal.c.el;
import com.tencent.mm.protocal.c.em;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import java.util.Map;

public final class a
{
  private static int Oh(String paramString)
  {
    try
    {
      int i = bk.getInt(paramString, 0);
      return i;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.AlbumBgHelper", "parserInt error " + paramString);
    }
    return 0;
  }
  
  public static cq Oi(String paramString)
  {
    Map localMap = bn.s(paramString, "albumList");
    cq localcq = new cq();
    if (localMap != null)
    {
      localcq.kUa = nm((String)localMap.get(".albumList.$lang"));
      paramString = new el();
      paramString.kRZ = nm((String)localMap.get(".albumList.album.author.name"));
      paramString.bGw = nm((String)localMap.get(".albumList.album.author.title"));
      paramString.sxZ = nm((String)localMap.get(".albumList.album.author.description"));
      paramString.sxY = nm((String)localMap.get(".albumList.album.author.quote"));
      Object localObject1 = new em();
      Object localObject2 = o(localMap, ".albumList.album.author.icon.media");
      String str1 = (String)localMap.get(".albumList.album.author.icon.media.id");
      String str2 = (String)localMap.get(".albumList.album.author.icon.media.type");
      String str3 = (String)localMap.get(".albumList.album.author.icon.media.title");
      String str4 = (String)localMap.get(".albumList.album.author.icon.media.desc");
      String str5 = (String)localMap.get(".albumList.album.author.icon.media.url");
      String str6 = (String)localMap.get(".albumList.album.author.icon.media.private");
      String str7 = (String)localMap.get(".albumList.album.author.icon.media.thumb");
      String str8 = (String)localMap.get(".albumList.album.author.icon.media.url.$type");
      String str9 = (String)localMap.get(".albumList.album.author.icon.media.thumb.$type");
      awd localawd = new awd();
      localawd.lsK = nm(str1);
      localawd.hQR = Oh(str2);
      localawd.bGw = nm(str3);
      localawd.kRN = nm(str4);
      localawd.kSC = nm(str5);
      localawd.trO = Oh(str8);
      localawd.trP = nm(str7);
      localawd.trQ = Oh(str9);
      localawd.trR = Oh(str6);
      localawd.trS = ((awf)localObject2);
      ((em)localObject1).syb = localawd;
      paramString.sya = ((em)localObject1);
      localcq.swk = paramString;
      int i = 0;
      localObject2 = new anz();
      if (i == 0) {
        localObject1 = ".albumList.album.groupList.group.name";
      }
      for (paramString = ".albumList.album.groupList.group.mediaList";; paramString = ".albumList.album.groupList.group" + i + ".mediaList")
      {
        localObject1 = (String)localMap.get(localObject1);
        if (localObject1 == null) {
          break label495;
        }
        ((anz)localObject2).kRZ = nm((String)localObject1);
        ((anz)localObject2).sPJ = p(localMap, paramString);
        localcq.swl.add(localObject2);
        i += 1;
        break;
        localObject1 = ".albumList.album.groupList.group" + i + ".name";
      }
      label495:
      return localcq;
    }
    return localcq;
  }
  
  private static float nl(String paramString)
  {
    if (paramString == null) {
      return 0.0F;
    }
    try
    {
      float f = bk.getFloat(paramString, 0.0F);
      return f;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.AlbumBgHelper", "parseFloat error " + paramString);
    }
    return 0.0F;
  }
  
  private static String nm(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private static awf o(Map<String, String> paramMap, String paramString)
  {
    String str2 = paramString + ".size.$width";
    String str1 = paramString + ".size.$height";
    Object localObject = paramString + ".size.$totalSize";
    paramString = (String)paramMap.get(str2);
    str1 = (String)paramMap.get(str1);
    paramMap = (String)paramMap.get(localObject);
    localObject = new awf();
    ((awf)localObject).tsG = 0.0F;
    ((awf)localObject).tsF = 0.0F;
    ((awf)localObject).tsH = 0.0F;
    if (paramString != null) {
      ((awf)localObject).tsF = nl(paramString);
    }
    if (str1 != null) {
      ((awf)localObject).tsG = nl(str1);
    }
    if (paramMap != null) {
      ((awf)localObject).tsH = nl(paramMap);
    }
    return localObject;
  }
  
  private static LinkedList<awd> p(Map<String, String> paramMap, String paramString)
  {
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    String str9;
    String str8;
    String str7;
    String str6;
    String str5;
    String str3;
    String str2;
    String str1;
    String str4;
    if (i != 0)
    {
      str9 = paramString + ".media" + i + ".id";
      str8 = paramString + ".media" + i + ".type";
      str7 = paramString + ".media" + i + ".title";
      str6 = paramString + ".media" + i + ".desc";
      str5 = paramString + ".media" + i + ".url";
      str3 = paramString + ".media" + i + ".thumb";
      str2 = paramString + ".media" + i + ".url.$type";
      str1 = paramString + ".media" + i + ".thumb.$type";
      str4 = paramString + ".media" + i + ".private";
    }
    for (Object localObject = paramString + ".media" + i;; localObject = paramString + ".media")
    {
      if ((str9 == null) || (str8 == null)) {
        break label795;
      }
      localObject = o(paramMap, (String)localObject);
      str9 = (String)paramMap.get(str9);
      str8 = (String)paramMap.get(str8);
      str7 = (String)paramMap.get(str7);
      str6 = (String)paramMap.get(str6);
      str5 = (String)paramMap.get(str5);
      str4 = (String)paramMap.get(str4);
      str3 = (String)paramMap.get(str3);
      str2 = (String)paramMap.get(str2);
      str1 = (String)paramMap.get(str1);
      if ((str9 == null) || (str8 == null)) {
        break label795;
      }
      awd localawd = new awd();
      localawd.lsK = nm(str9);
      localawd.hQR = Oh(str8);
      localawd.bGw = nm(str7);
      localawd.kRN = nm(str6);
      localawd.kSC = nm(str5);
      localawd.trO = Oh(str2);
      localawd.trP = nm(str3);
      localawd.trQ = Oh(str1);
      localawd.trR = Oh(str4);
      localawd.trS = ((awf)localObject);
      localLinkedList.add(localawd);
      i += 1;
      break;
      str9 = paramString + ".media.id";
      str8 = paramString + ".media.type";
      str7 = paramString + ".media.title";
      str6 = paramString + ".media.desc";
      str5 = paramString + ".media.url";
      str3 = paramString + ".media.thumb";
      str2 = paramString + ".media.url.$type";
      str1 = paramString + ".media.thumb.$type";
      str4 = paramString + ".media.private";
    }
    label795:
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.g.a
 * JD-Core Version:    0.7.0.1
 */