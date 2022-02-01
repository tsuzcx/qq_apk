package com.tencent.mm.plugin.sns.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bzz;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.cnd;
import com.tencent.mm.protocal.protobuf.dw;
import com.tencent.mm.protocal.protobuf.he;
import com.tencent.mm.protocal.protobuf.hf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.LinkedList;
import java.util.Map;

public final class a
{
  private static cnd D(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(96148);
    String str2 = paramString + ".size.$width";
    String str1 = paramString + ".size.$height";
    Object localObject = paramString + ".size.$totalSize";
    paramString = (String)paramMap.get(str2);
    str1 = (String)paramMap.get(str1);
    paramMap = (String)paramMap.get(localObject);
    localObject = new cnd();
    ((cnd)localObject).Mtp = 0.0F;
    ((cnd)localObject).Mto = 0.0F;
    ((cnd)localObject).Mtq = 0.0F;
    if (paramString != null) {
      ((cnd)localObject).Mto = PK(paramString);
    }
    if (str1 != null) {
      ((cnd)localObject).Mtp = PK(str1);
    }
    if (paramMap != null) {
      ((cnd)localObject).Mtq = PK(paramMap);
    }
    AppMethodBeat.o(96148);
    return localObject;
  }
  
  private static LinkedList<cnb> E(Map<String, String> paramMap, String paramString)
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
        break label789;
      }
      localObject = D(paramMap, (String)localObject);
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
        break label789;
      }
      cnb localcnb = new cnb();
      localcnb.Id = PL(str9);
      localcnb.oUv = aPN(str8);
      localcnb.Title = PL(str7);
      localcnb.Desc = PL(str6);
      localcnb.Url = PL(str5);
      localcnb.Mcw = aPN(str2);
      localcnb.Msz = PL(str3);
      localcnb.MsA = aPN(str1);
      localcnb.Privated = aPN(str4);
      localcnb.MsB = ((cnd)localObject);
      localLinkedList.add(localcnb);
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
    label789:
    AppMethodBeat.o(96150);
    return localLinkedList;
  }
  
  private static float PK(String paramString)
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
      float f2 = Util.getFloat(paramString, 0.0F);
      f1 = f2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.AlbumBgHelper", "parseFloat error ".concat(String.valueOf(paramString)));
      }
    }
    AppMethodBeat.o(96144);
    return f1;
  }
  
  private static String PL(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private static dw a(Map<String, String> paramMap, dw paramdw)
  {
    AppMethodBeat.i(96146);
    he localhe = new he();
    localhe.Name = PL((String)paramMap.get(".albumList.album.author.name"));
    localhe.Title = PL((String)paramMap.get(".albumList.album.author.title"));
    localhe.KHk = PL((String)paramMap.get(".albumList.album.author.description"));
    localhe.KKN = PL((String)paramMap.get(".albumList.album.author.quote"));
    localhe.KKO = aN(paramMap);
    paramdw.KHT = localhe;
    AppMethodBeat.o(96146);
    return paramdw;
  }
  
  private static hf aN(Map<String, String> paramMap)
  {
    AppMethodBeat.i(96147);
    hf localhf = new hf();
    cnd localcnd = D(paramMap, ".albumList.album.author.icon.media");
    String str1 = (String)paramMap.get(".albumList.album.author.icon.media.id");
    String str2 = (String)paramMap.get(".albumList.album.author.icon.media.type");
    String str3 = (String)paramMap.get(".albumList.album.author.icon.media.title");
    String str4 = (String)paramMap.get(".albumList.album.author.icon.media.desc");
    String str5 = (String)paramMap.get(".albumList.album.author.icon.media.url");
    String str6 = (String)paramMap.get(".albumList.album.author.icon.media.private");
    String str7 = (String)paramMap.get(".albumList.album.author.icon.media.thumb");
    String str8 = (String)paramMap.get(".albumList.album.author.icon.media.url.$type");
    paramMap = (String)paramMap.get(".albumList.album.author.icon.media.thumb.$type");
    cnb localcnb = new cnb();
    localcnb.Id = PL(str1);
    localcnb.oUv = aPN(str2);
    localcnb.Title = PL(str3);
    localcnb.Desc = PL(str4);
    localcnb.Url = PL(str5);
    localcnb.Mcw = aPN(str8);
    localcnb.Msz = PL(str7);
    localcnb.MsA = aPN(paramMap);
    localcnb.Privated = aPN(str6);
    localcnb.MsB = localcnd;
    localhf.KKP = localcnb;
    AppMethodBeat.o(96147);
    return localhf;
  }
  
  private static int aPN(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(96143);
    try
    {
      int j = Util.getInt(paramString, 0);
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.AlbumBgHelper", "parserInt error ".concat(String.valueOf(paramString)));
      }
    }
    AppMethodBeat.o(96143);
    return i;
  }
  
  public static dw aPO(String paramString)
  {
    AppMethodBeat.i(96145);
    Map localMap = XmlParser.parseXml(paramString, "albumList", null);
    paramString = new dw();
    if (localMap != null)
    {
      paramString.xLl = PL((String)localMap.get(".albumList.$lang"));
      paramString = b(localMap, a(localMap, paramString));
    }
    for (;;)
    {
      AppMethodBeat.o(96145);
      return paramString;
    }
  }
  
  private static dw b(Map<String, String> paramMap, dw paramdw)
  {
    AppMethodBeat.i(96149);
    int i = 0;
    bzz localbzz = new bzz();
    String str2;
    if (i == 0) {
      str2 = ".albumList.album.groupList.group.name";
    }
    for (String str1 = ".albumList.album.groupList.group.mediaList";; str1 = ".albumList.album.groupList.group" + i + ".mediaList")
    {
      str2 = (String)paramMap.get(str2);
      if (str2 == null) {
        break label137;
      }
      localbzz.Name = PL(str2);
      localbzz.LoV = E(paramMap, str1);
      paramdw.GroupList.add(localbzz);
      i += 1;
      break;
      str2 = ".albumList.album.groupList.group" + i + ".name";
    }
    label137:
    AppMethodBeat.o(96149);
    return paramdw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.j.a
 * JD-Core Version:    0.7.0.1
 */