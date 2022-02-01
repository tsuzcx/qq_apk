package com.tencent.mm.plugin.sns.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.chu;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.protocal.protobuf.cvv;
import com.tencent.mm.protocal.protobuf.dw;
import com.tencent.mm.protocal.protobuf.gs;
import com.tencent.mm.protocal.protobuf.gt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.LinkedList;
import java.util.Map;

public final class a
{
  private static cvv N(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(96148);
    String str2 = paramString + ".size.$width";
    String str1 = paramString + ".size.$height";
    Object localObject = paramString + ".size.$totalSize";
    paramString = (String)paramMap.get(str2);
    str1 = (String)paramMap.get(str1);
    paramMap = (String)paramMap.get(localObject);
    localObject = new cvv();
    ((cvv)localObject).TEv = 0.0F;
    ((cvv)localObject).TEu = 0.0F;
    ((cvv)localObject).TEw = 0.0F;
    if (paramString != null) {
      ((cvv)localObject).TEu = Xi(paramString);
    }
    if (str1 != null) {
      ((cvv)localObject).TEv = Xi(str1);
    }
    if (paramMap != null) {
      ((cvv)localObject).TEw = Xi(paramMap);
    }
    AppMethodBeat.o(96148);
    return localObject;
  }
  
  private static LinkedList<cvt> O(Map<String, String> paramMap, String paramString)
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
      localObject = N(paramMap, (String)localObject);
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
      cvt localcvt = new cvt();
      localcvt.Id = Xj(str9);
      localcvt.rWu = baK(str8);
      localcvt.fwr = Xj(str7);
      localcvt.CMB = Xj(str6);
      localcvt.Url = Xj(str5);
      localcvt.TlV = baK(str2);
      localcvt.TDF = Xj(str3);
      localcvt.TDG = baK(str1);
      localcvt.Privated = baK(str4);
      localcvt.TDH = ((cvv)localObject);
      localLinkedList.add(localcvt);
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
  
  private static float Xi(String paramString)
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
  
  private static String Xj(String paramString)
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
    gs localgs = new gs();
    localgs.CMP = Xj((String)paramMap.get(".albumList.album.author.name"));
    localgs.fwr = Xj((String)paramMap.get(".albumList.album.author.title"));
    localgs.RIC = Xj((String)paramMap.get(".albumList.album.author.description"));
    localgs.RLF = Xj((String)paramMap.get(".albumList.album.author.quote"));
    localgs.RLG = aH(paramMap);
    paramdw.RJn = localgs;
    AppMethodBeat.o(96146);
    return paramdw;
  }
  
  private static gt aH(Map<String, String> paramMap)
  {
    AppMethodBeat.i(96147);
    gt localgt = new gt();
    cvv localcvv = N(paramMap, ".albumList.album.author.icon.media");
    String str1 = (String)paramMap.get(".albumList.album.author.icon.media.id");
    String str2 = (String)paramMap.get(".albumList.album.author.icon.media.type");
    String str3 = (String)paramMap.get(".albumList.album.author.icon.media.title");
    String str4 = (String)paramMap.get(".albumList.album.author.icon.media.desc");
    String str5 = (String)paramMap.get(".albumList.album.author.icon.media.url");
    String str6 = (String)paramMap.get(".albumList.album.author.icon.media.private");
    String str7 = (String)paramMap.get(".albumList.album.author.icon.media.thumb");
    String str8 = (String)paramMap.get(".albumList.album.author.icon.media.url.$type");
    paramMap = (String)paramMap.get(".albumList.album.author.icon.media.thumb.$type");
    cvt localcvt = new cvt();
    localcvt.Id = Xj(str1);
    localcvt.rWu = baK(str2);
    localcvt.fwr = Xj(str3);
    localcvt.CMB = Xj(str4);
    localcvt.Url = Xj(str5);
    localcvt.TlV = baK(str8);
    localcvt.TDF = Xj(str7);
    localcvt.TDG = baK(paramMap);
    localcvt.Privated = baK(str6);
    localcvt.TDH = localcvv;
    localgt.RLH = localcvt;
    AppMethodBeat.o(96147);
    return localgt;
  }
  
  private static dw b(Map<String, String> paramMap, dw paramdw)
  {
    AppMethodBeat.i(96149);
    int i = 0;
    chu localchu = new chu();
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
      localchu.CMP = Xj(str2);
      localchu.Sqr = O(paramMap, str1);
      paramdw.GroupList.add(localchu);
      i += 1;
      break;
      str2 = ".albumList.album.groupList.group" + i + ".name";
    }
    label137:
    AppMethodBeat.o(96149);
    return paramdw;
  }
  
  private static int baK(String paramString)
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
  
  public static dw baL(String paramString)
  {
    AppMethodBeat.i(96145);
    Map localMap = XmlParser.parseXml(paramString, "albumList", null);
    paramString = new dw();
    if (localMap != null)
    {
      paramString.CPt = Xj((String)localMap.get(".albumList.$lang"));
      paramString = b(localMap, a(localMap, paramString));
    }
    for (;;)
    {
      AppMethodBeat.o(96145);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.j.a
 * JD-Core Version:    0.7.0.1
 */