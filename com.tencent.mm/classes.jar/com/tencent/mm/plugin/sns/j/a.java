package com.tencent.mm.plugin.sns.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.beq;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.protocal.protobuf.bpk;
import com.tencent.mm.protocal.protobuf.dj;
import com.tencent.mm.protocal.protobuf.gg;
import com.tencent.mm.protocal.protobuf.gh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import java.util.LinkedList;
import java.util.Map;

public final class a
{
  private static dj a(Map<String, String> paramMap, dj paramdj)
  {
    AppMethodBeat.i(96146);
    gg localgg = new gg();
    localgg.Name = zm((String)paramMap.get(".albumList.album.author.name"));
    localgg.Title = zm((String)paramMap.get(".albumList.album.author.title"));
    localgg.Cxw = zm((String)paramMap.get(".albumList.album.author.description"));
    localgg.CAR = zm((String)paramMap.get(".albumList.album.author.quote"));
    localgg.CAS = aB(paramMap);
    paramdj.Cyd = localgg;
    AppMethodBeat.o(96146);
    return paramdj;
  }
  
  private static gh aB(Map<String, String> paramMap)
  {
    AppMethodBeat.i(96147);
    gh localgh = new gh();
    bpk localbpk = p(paramMap, ".albumList.album.author.icon.media");
    String str1 = (String)paramMap.get(".albumList.album.author.icon.media.id");
    String str2 = (String)paramMap.get(".albumList.album.author.icon.media.type");
    String str3 = (String)paramMap.get(".albumList.album.author.icon.media.title");
    String str4 = (String)paramMap.get(".albumList.album.author.icon.media.desc");
    String str5 = (String)paramMap.get(".albumList.album.author.icon.media.url");
    String str6 = (String)paramMap.get(".albumList.album.author.icon.media.private");
    String str7 = (String)paramMap.get(".albumList.album.author.icon.media.thumb");
    String str8 = (String)paramMap.get(".albumList.album.author.icon.media.url.$type");
    paramMap = (String)paramMap.get(".albumList.album.author.icon.media.thumb.$type");
    bpi localbpi = new bpi();
    localbpi.Id = zm(str1);
    localbpi.mBH = api(str2);
    localbpi.Title = zm(str3);
    localbpi.Desc = zm(str4);
    localbpi.Url = zm(str5);
    localbpi.Dzl = api(str8);
    localbpi.DMQ = zm(str7);
    localbpi.DMR = api(paramMap);
    localbpi.DMS = api(str6);
    localbpi.DMT = localbpk;
    localgh.CAT = localbpi;
    AppMethodBeat.o(96147);
    return localgh;
  }
  
  private static int api(String paramString)
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
  
  public static dj apj(String paramString)
  {
    AppMethodBeat.i(96145);
    Map localMap = bw.K(paramString, "albumList");
    paramString = new dj();
    if (localMap != null)
    {
      paramString.sbA = zm((String)localMap.get(".albumList.$lang"));
      paramString = b(localMap, a(localMap, paramString));
    }
    for (;;)
    {
      AppMethodBeat.o(96145);
      return paramString;
    }
  }
  
  private static dj b(Map<String, String> paramMap, dj paramdj)
  {
    AppMethodBeat.i(96149);
    int i = 0;
    beq localbeq = new beq();
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
      localbeq.Name = zm(str2);
      localbeq.DaC = q(paramMap, str1);
      paramdj.GroupList.add(localbeq);
      i += 1;
      break;
      str2 = ".albumList.album.groupList.group" + i + ".name";
    }
    label130:
    AppMethodBeat.o(96149);
    return paramdj;
  }
  
  private static bpk p(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(96148);
    String str2 = paramString + ".size.$width";
    String str1 = paramString + ".size.$height";
    Object localObject = paramString + ".size.$totalSize";
    paramString = (String)paramMap.get(str2);
    str1 = (String)paramMap.get(str1);
    paramMap = (String)paramMap.get(localObject);
    localObject = new bpk();
    ((bpk)localObject).DNI = 0.0F;
    ((bpk)localObject).DNH = 0.0F;
    ((bpk)localObject).DNJ = 0.0F;
    if (paramString != null) {
      ((bpk)localObject).DNH = zl(paramString);
    }
    if (str1 != null) {
      ((bpk)localObject).DNI = zl(str1);
    }
    if (paramMap != null) {
      ((bpk)localObject).DNJ = zl(paramMap);
    }
    AppMethodBeat.o(96148);
    return localObject;
  }
  
  private static LinkedList<bpi> q(Map<String, String> paramMap, String paramString)
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
      localObject = p(paramMap, (String)localObject);
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
      bpi localbpi = new bpi();
      localbpi.Id = zm(str9);
      localbpi.mBH = api(str8);
      localbpi.Title = zm(str7);
      localbpi.Desc = zm(str6);
      localbpi.Url = zm(str5);
      localbpi.Dzl = api(str2);
      localbpi.DMQ = zm(str3);
      localbpi.DMR = api(str1);
      localbpi.DMS = api(str4);
      localbpi.DMT = ((bpk)localObject);
      localLinkedList.add(localbpi);
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
  
  private static float zl(String paramString)
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
  
  private static String zm(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.j.a
 * JD-Core Version:    0.7.0.1
 */