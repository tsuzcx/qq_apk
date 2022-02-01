package com.tencent.mm.plugin.sns.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bni;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.protocal.protobuf.bzj;
import com.tencent.mm.protocal.protobuf.dm;
import com.tencent.mm.protocal.protobuf.gr;
import com.tencent.mm.protocal.protobuf.gs;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import java.util.LinkedList;
import java.util.Map;

public final class a
{
  private static float GX(String paramString)
  {
    float f1 = 0.0F;
    AppMethodBeat.i(96144);
    if (paramString == null)
    {
      AppMethodBeat.o(96144);
      return 0.0F;
    }
    try
    {
      float f2 = bu.getFloat(paramString, 0.0F);
      f1 = f2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.e("MicroMsg.AlbumBgHelper", "parseFloat error ".concat(String.valueOf(paramString)));
      }
    }
    AppMethodBeat.o(96144);
    return f1;
  }
  
  private static String GY(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private static dm a(Map<String, String> paramMap, dm paramdm)
  {
    AppMethodBeat.i(96146);
    gr localgr = new gr();
    localgr.Name = GY((String)paramMap.get(".albumList.album.author.name"));
    localgr.Title = GY((String)paramMap.get(".albumList.album.author.title"));
    localgr.FNF = GY((String)paramMap.get(".albumList.album.author.description"));
    localgr.FRg = GY((String)paramMap.get(".albumList.album.author.quote"));
    localgr.FRh = aO(paramMap);
    paramdm.FOm = localgr;
    AppMethodBeat.o(96146);
    return paramdm;
  }
  
  private static int aAR(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(96143);
    try
    {
      int j = bu.getInt(paramString, 0);
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.e("MicroMsg.AlbumBgHelper", "parserInt error ".concat(String.valueOf(paramString)));
      }
    }
    AppMethodBeat.o(96143);
    return i;
  }
  
  public static dm aAS(String paramString)
  {
    AppMethodBeat.i(96145);
    Map localMap = bx.M(paramString, "albumList");
    paramString = new dm();
    if (localMap != null)
    {
      paramString.usS = GY((String)localMap.get(".albumList.$lang"));
      paramString = b(localMap, a(localMap, paramString));
    }
    for (;;)
    {
      AppMethodBeat.o(96145);
      return paramString;
    }
  }
  
  private static gs aO(Map<String, String> paramMap)
  {
    AppMethodBeat.i(96147);
    gs localgs = new gs();
    bzj localbzj = r(paramMap, ".albumList.album.author.icon.media");
    String str1 = (String)paramMap.get(".albumList.album.author.icon.media.id");
    String str2 = (String)paramMap.get(".albumList.album.author.icon.media.type");
    String str3 = (String)paramMap.get(".albumList.album.author.icon.media.title");
    String str4 = (String)paramMap.get(".albumList.album.author.icon.media.desc");
    String str5 = (String)paramMap.get(".albumList.album.author.icon.media.url");
    String str6 = (String)paramMap.get(".albumList.album.author.icon.media.private");
    String str7 = (String)paramMap.get(".albumList.album.author.icon.media.thumb");
    String str8 = (String)paramMap.get(".albumList.album.author.icon.media.url.$type");
    paramMap = (String)paramMap.get(".albumList.album.author.icon.media.thumb.$type");
    bzh localbzh = new bzh();
    localbzh.Id = GY(str1);
    localbzh.nJA = aAR(str2);
    localbzh.Title = GY(str3);
    localbzh.Desc = GY(str4);
    localbzh.Url = GY(str5);
    localbzh.GXH = aAR(str8);
    localbzh.Hmj = GY(str7);
    localbzh.Hmk = aAR(paramMap);
    localbzh.Hml = aAR(str6);
    localbzh.Hmm = localbzj;
    localgs.FRi = localbzh;
    AppMethodBeat.o(96147);
    return localgs;
  }
  
  private static dm b(Map<String, String> paramMap, dm paramdm)
  {
    AppMethodBeat.i(96149);
    int i = 0;
    bni localbni = new bni();
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
      localbni.Name = GY(str2);
      localbni.Gtx = s(paramMap, str1);
      paramdm.GroupList.add(localbni);
      i += 1;
      break;
      str2 = ".albumList.album.groupList.group" + i + ".name";
    }
    label130:
    AppMethodBeat.o(96149);
    return paramdm;
  }
  
  private static bzj r(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(96148);
    String str2 = paramString + ".size.$width";
    String str1 = paramString + ".size.$height";
    Object localObject = paramString + ".size.$totalSize";
    paramString = (String)paramMap.get(str2);
    str1 = (String)paramMap.get(str1);
    paramMap = (String)paramMap.get(localObject);
    localObject = new bzj();
    ((bzj)localObject).Hnb = 0.0F;
    ((bzj)localObject).Hna = 0.0F;
    ((bzj)localObject).Hnc = 0.0F;
    if (paramString != null) {
      ((bzj)localObject).Hna = GX(paramString);
    }
    if (str1 != null) {
      ((bzj)localObject).Hnb = GX(str1);
    }
    if (paramMap != null) {
      ((bzj)localObject).Hnc = GX(paramMap);
    }
    AppMethodBeat.o(96148);
    return localObject;
  }
  
  private static LinkedList<bzh> s(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(96150);
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
      localObject = r(paramMap, (String)localObject);
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
      bzh localbzh = new bzh();
      localbzh.Id = GY(str9);
      localbzh.nJA = aAR(str8);
      localbzh.Title = GY(str7);
      localbzh.Desc = GY(str6);
      localbzh.Url = GY(str5);
      localbzh.GXH = aAR(str2);
      localbzh.Hmj = GY(str3);
      localbzh.Hmk = aAR(str1);
      localbzh.Hml = aAR(str4);
      localbzh.Hmm = ((bzj)localObject);
      localLinkedList.add(localbzh);
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
    AppMethodBeat.o(96150);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.i.a
 * JD-Core Version:    0.7.0.1
 */