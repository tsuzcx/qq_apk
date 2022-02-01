package com.tencent.mm.plugin.sns.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bmq;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.protocal.protobuf.byp;
import com.tencent.mm.protocal.protobuf.dm;
import com.tencent.mm.protocal.protobuf.gr;
import com.tencent.mm.protocal.protobuf.gs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import java.util.LinkedList;
import java.util.Map;

public final class a
{
  private static float Gv(String paramString)
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
      float f2 = bt.getFloat(paramString, 0.0F);
      f1 = f2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.AlbumBgHelper", "parseFloat error ".concat(String.valueOf(paramString)));
      }
    }
    AppMethodBeat.o(96144);
    return f1;
  }
  
  private static String Gw(String paramString)
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
    localgr.Name = Gw((String)paramMap.get(".albumList.album.author.name"));
    localgr.Title = Gw((String)paramMap.get(".albumList.album.author.title"));
    localgr.Fvh = Gw((String)paramMap.get(".albumList.album.author.description"));
    localgr.FyI = Gw((String)paramMap.get(".albumList.album.author.quote"));
    localgr.FyJ = aI(paramMap);
    paramdm.FvO = localgr;
    AppMethodBeat.o(96146);
    return paramdm;
  }
  
  private static gs aI(Map<String, String> paramMap)
  {
    AppMethodBeat.i(96147);
    gs localgs = new gs();
    byp localbyp = r(paramMap, ".albumList.album.author.icon.media");
    String str1 = (String)paramMap.get(".albumList.album.author.icon.media.id");
    String str2 = (String)paramMap.get(".albumList.album.author.icon.media.type");
    String str3 = (String)paramMap.get(".albumList.album.author.icon.media.title");
    String str4 = (String)paramMap.get(".albumList.album.author.icon.media.desc");
    String str5 = (String)paramMap.get(".albumList.album.author.icon.media.url");
    String str6 = (String)paramMap.get(".albumList.album.author.icon.media.private");
    String str7 = (String)paramMap.get(".albumList.album.author.icon.media.thumb");
    String str8 = (String)paramMap.get(".albumList.album.author.icon.media.url.$type");
    paramMap = (String)paramMap.get(".albumList.album.author.icon.media.thumb.$type");
    byn localbyn = new byn();
    localbyn.Id = Gw(str1);
    localbyn.nEf = azA(str2);
    localbyn.Title = Gw(str3);
    localbyn.Desc = Gw(str4);
    localbyn.Url = Gw(str5);
    localbyn.GEe = azA(str8);
    localbyn.GSI = Gw(str7);
    localbyn.GSJ = azA(paramMap);
    localbyn.GSK = azA(str6);
    localbyn.GSL = localbyp;
    localgs.FyK = localbyn;
    AppMethodBeat.o(96147);
    return localgs;
  }
  
  private static int azA(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(96143);
    try
    {
      int j = bt.getInt(paramString, 0);
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.AlbumBgHelper", "parserInt error ".concat(String.valueOf(paramString)));
      }
    }
    AppMethodBeat.o(96143);
    return i;
  }
  
  public static dm azB(String paramString)
  {
    AppMethodBeat.i(96145);
    Map localMap = bw.M(paramString, "albumList");
    paramString = new dm();
    if (localMap != null)
    {
      paramString.uhu = Gw((String)localMap.get(".albumList.$lang"));
      paramString = b(localMap, a(localMap, paramString));
    }
    for (;;)
    {
      AppMethodBeat.o(96145);
      return paramString;
    }
  }
  
  private static dm b(Map<String, String> paramMap, dm paramdm)
  {
    AppMethodBeat.i(96149);
    int i = 0;
    bmq localbmq = new bmq();
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
      localbmq.Name = Gw(str2);
      localbmq.GaQ = s(paramMap, str1);
      paramdm.GroupList.add(localbmq);
      i += 1;
      break;
      str2 = ".albumList.album.groupList.group" + i + ".name";
    }
    label130:
    AppMethodBeat.o(96149);
    return paramdm;
  }
  
  private static byp r(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(96148);
    String str2 = paramString + ".size.$width";
    String str1 = paramString + ".size.$height";
    Object localObject = paramString + ".size.$totalSize";
    paramString = (String)paramMap.get(str2);
    str1 = (String)paramMap.get(str1);
    paramMap = (String)paramMap.get(localObject);
    localObject = new byp();
    ((byp)localObject).GTA = 0.0F;
    ((byp)localObject).GTz = 0.0F;
    ((byp)localObject).GTB = 0.0F;
    if (paramString != null) {
      ((byp)localObject).GTz = Gv(paramString);
    }
    if (str1 != null) {
      ((byp)localObject).GTA = Gv(str1);
    }
    if (paramMap != null) {
      ((byp)localObject).GTB = Gv(paramMap);
    }
    AppMethodBeat.o(96148);
    return localObject;
  }
  
  private static LinkedList<byn> s(Map<String, String> paramMap, String paramString)
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
      byn localbyn = new byn();
      localbyn.Id = Gw(str9);
      localbyn.nEf = azA(str8);
      localbyn.Title = Gw(str7);
      localbyn.Desc = Gw(str6);
      localbyn.Url = Gw(str5);
      localbyn.GEe = azA(str2);
      localbyn.GSI = Gw(str3);
      localbyn.GSJ = azA(str1);
      localbyn.GSK = azA(str4);
      localbyn.GSL = ((byp)localObject);
      localLinkedList.add(localbyn);
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