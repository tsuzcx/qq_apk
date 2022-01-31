package com.tencent.mm.plugin.sns.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.atp;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.bcu;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.protocal.protobuf.fo;
import com.tencent.mm.protocal.protobuf.fp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.LinkedList;
import java.util.Map;

public final class a
{
  private static db a(Map<String, String> paramMap, db paramdb)
  {
    AppMethodBeat.i(36818);
    fo localfo = new fo();
    localfo.Name = uz((String)paramMap.get(".albumList.album.author.name"));
    localfo.Title = uz((String)paramMap.get(".albumList.album.author.title"));
    localfo.woO = uz((String)paramMap.get(".albumList.album.author.description"));
    localfo.wrD = uz((String)paramMap.get(".albumList.album.author.quote"));
    localfo.wrE = ad(paramMap);
    paramdb.wpx = localfo;
    AppMethodBeat.o(36818);
    return paramdb;
  }
  
  private static int abb(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(36815);
    try
    {
      int j = bo.getInt(paramString, 0);
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.AlbumBgHelper", "parserInt error ".concat(String.valueOf(paramString)));
      }
    }
    AppMethodBeat.o(36815);
    return i;
  }
  
  public static db abc(String paramString)
  {
    AppMethodBeat.i(36817);
    Map localMap = br.F(paramString, "albumList");
    paramString = new db();
    if (localMap != null)
    {
      paramString.nsa = uz((String)localMap.get(".albumList.$lang"));
      paramString = b(localMap, a(localMap, paramString));
    }
    for (;;)
    {
      AppMethodBeat.o(36817);
      return paramString;
    }
  }
  
  private static fp ad(Map<String, String> paramMap)
  {
    AppMethodBeat.i(36819);
    fp localfp = new fp();
    bcu localbcu = o(paramMap, ".albumList.album.author.icon.media");
    String str1 = (String)paramMap.get(".albumList.album.author.icon.media.id");
    String str2 = (String)paramMap.get(".albumList.album.author.icon.media.type");
    String str3 = (String)paramMap.get(".albumList.album.author.icon.media.title");
    String str4 = (String)paramMap.get(".albumList.album.author.icon.media.desc");
    String str5 = (String)paramMap.get(".albumList.album.author.icon.media.url");
    String str6 = (String)paramMap.get(".albumList.album.author.icon.media.private");
    String str7 = (String)paramMap.get(".albumList.album.author.icon.media.thumb");
    String str8 = (String)paramMap.get(".albumList.album.author.icon.media.url.$type");
    paramMap = (String)paramMap.get(".albumList.album.author.icon.media.thumb.$type");
    bcs localbcs = new bcs();
    localbcs.Id = uz(str1);
    localbcs.jKs = abb(str2);
    localbcs.Title = uz(str3);
    localbcs.Desc = uz(str4);
    localbcs.Url = uz(str5);
    localbcs.xrR = abb(str8);
    localbcs.xrS = uz(str7);
    localbcs.xrT = abb(paramMap);
    localbcs.xrU = abb(str6);
    localbcs.xrV = localbcu;
    localfp.wrF = localbcs;
    AppMethodBeat.o(36819);
    return localfp;
  }
  
  private static db b(Map<String, String> paramMap, db paramdb)
  {
    AppMethodBeat.i(36821);
    int i = 0;
    atp localatp = new atp();
    String str2;
    if (i == 0) {
      str2 = ".albumList.album.groupList.group.name";
    }
    for (String str1 = ".albumList.album.groupList.group.mediaList";; str1 = ".albumList.album.groupList.group" + i + ".mediaList")
    {
      str2 = (String)paramMap.get(str2);
      if (str2 == null) {
        break label130;
      }
      localatp.Name = uz(str2);
      localatp.wOa = p(paramMap, str1);
      paramdb.GroupList.add(localatp);
      i += 1;
      break;
      str2 = ".albumList.album.groupList.group" + i + ".name";
    }
    label130:
    AppMethodBeat.o(36821);
    return paramdb;
  }
  
  private static bcu o(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(36820);
    String str2 = paramString + ".size.$width";
    String str1 = paramString + ".size.$height";
    Object localObject = paramString + ".size.$totalSize";
    paramString = (String)paramMap.get(str2);
    str1 = (String)paramMap.get(str1);
    paramMap = (String)paramMap.get(localObject);
    localObject = new bcu();
    ((bcu)localObject).xsI = 0.0F;
    ((bcu)localObject).xsH = 0.0F;
    ((bcu)localObject).xsJ = 0.0F;
    if (paramString != null) {
      ((bcu)localObject).xsH = uy(paramString);
    }
    if (str1 != null) {
      ((bcu)localObject).xsI = uy(str1);
    }
    if (paramMap != null) {
      ((bcu)localObject).xsJ = uy(paramMap);
    }
    AppMethodBeat.o(36820);
    return localObject;
  }
  
  private static LinkedList<bcs> p(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(36822);
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
        break label819;
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
        break label819;
      }
      bcs localbcs = new bcs();
      localbcs.Id = uz(str9);
      localbcs.jKs = abb(str8);
      localbcs.Title = uz(str7);
      localbcs.Desc = uz(str6);
      localbcs.Url = uz(str5);
      localbcs.xrR = abb(str2);
      localbcs.xrS = uz(str3);
      localbcs.xrT = abb(str1);
      localbcs.xrU = abb(str4);
      localbcs.xrV = ((bcu)localObject);
      localLinkedList.add(localbcs);
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
    label819:
    AppMethodBeat.o(36822);
    return localLinkedList;
  }
  
  private static float uy(String paramString)
  {
    float f1 = 0.0F;
    AppMethodBeat.i(36816);
    if (paramString == null)
    {
      AppMethodBeat.o(36816);
      return 0.0F;
    }
    try
    {
      float f2 = bo.getFloat(paramString, 0.0F);
      f1 = f2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.AlbumBgHelper", "parseFloat error ".concat(String.valueOf(paramString)));
      }
    }
    AppMethodBeat.o(36816);
    return f1;
  }
  
  private static String uz(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.h.a
 * JD-Core Version:    0.7.0.1
 */