package com.tencent.mm.plugin.sns.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bii;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.protocal.protobuf.bub;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.protocal.protobuf.gk;
import com.tencent.mm.protocal.protobuf.gl;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import java.util.LinkedList;
import java.util.Map;

public final class a
{
  private static float Dq(String paramString)
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
      float f2 = bs.getFloat(paramString, 0.0F);
      f1 = f2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.e("MicroMsg.AlbumBgHelper", "parseFloat error ".concat(String.valueOf(paramString)));
      }
    }
    AppMethodBeat.o(96144);
    return f1;
  }
  
  private static String Dr(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private static dl a(Map<String, String> paramMap, dl paramdl)
  {
    AppMethodBeat.i(96146);
    gk localgk = new gk();
    localgk.Name = Dr((String)paramMap.get(".albumList.album.author.name"));
    localgk.Title = Dr((String)paramMap.get(".albumList.album.author.title"));
    localgk.DPS = Dr((String)paramMap.get(".albumList.album.author.description"));
    localgk.DTp = Dr((String)paramMap.get(".albumList.album.author.quote"));
    localgk.DTq = aF(paramMap);
    paramdl.DQz = localgk;
    AppMethodBeat.o(96146);
    return paramdl;
  }
  
  private static gl aF(Map<String, String> paramMap)
  {
    AppMethodBeat.i(96147);
    gl localgl = new gl();
    bub localbub = p(paramMap, ".albumList.album.author.icon.media");
    String str1 = (String)paramMap.get(".albumList.album.author.icon.media.id");
    String str2 = (String)paramMap.get(".albumList.album.author.icon.media.type");
    String str3 = (String)paramMap.get(".albumList.album.author.icon.media.title");
    String str4 = (String)paramMap.get(".albumList.album.author.icon.media.desc");
    String str5 = (String)paramMap.get(".albumList.album.author.icon.media.url");
    String str6 = (String)paramMap.get(".albumList.album.author.icon.media.private");
    String str7 = (String)paramMap.get(".albumList.album.author.icon.media.thumb");
    String str8 = (String)paramMap.get(".albumList.album.author.icon.media.url.$type");
    paramMap = (String)paramMap.get(".albumList.album.author.icon.media.thumb.$type");
    btz localbtz = new btz();
    localbtz.Id = Dr(str1);
    localbtz.ndI = auu(str2);
    localbtz.Title = Dr(str3);
    localbtz.Desc = Dr(str4);
    localbtz.Url = Dr(str5);
    localbtz.EUH = auu(str8);
    localbtz.Fjh = Dr(str7);
    localbtz.Fji = auu(paramMap);
    localbtz.Fjj = auu(str6);
    localbtz.Fjk = localbub;
    localgl.DTr = localbtz;
    AppMethodBeat.o(96147);
    return localgl;
  }
  
  private static int auu(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(96143);
    try
    {
      int j = bs.getInt(paramString, 0);
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.e("MicroMsg.AlbumBgHelper", "parserInt error ".concat(String.valueOf(paramString)));
      }
    }
    AppMethodBeat.o(96143);
    return i;
  }
  
  public static dl auv(String paramString)
  {
    AppMethodBeat.i(96145);
    Map localMap = bv.L(paramString, "albumList");
    paramString = new dl();
    if (localMap != null)
    {
      paramString.tju = Dr((String)localMap.get(".albumList.$lang"));
      paramString = b(localMap, a(localMap, paramString));
    }
    for (;;)
    {
      AppMethodBeat.o(96145);
      return paramString;
    }
  }
  
  private static dl b(Map<String, String> paramMap, dl paramdl)
  {
    AppMethodBeat.i(96149);
    int i = 0;
    bii localbii = new bii();
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
      localbii.Name = Dr(str2);
      localbii.Etz = q(paramMap, str1);
      paramdl.GroupList.add(localbii);
      i += 1;
      break;
      str2 = ".albumList.album.groupList.group" + i + ".name";
    }
    label130:
    AppMethodBeat.o(96149);
    return paramdl;
  }
  
  private static bub p(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(96148);
    String str2 = paramString + ".size.$width";
    String str1 = paramString + ".size.$height";
    Object localObject = paramString + ".size.$totalSize";
    paramString = (String)paramMap.get(str2);
    str1 = (String)paramMap.get(str1);
    paramMap = (String)paramMap.get(localObject);
    localObject = new bub();
    ((bub)localObject).FjZ = 0.0F;
    ((bub)localObject).FjY = 0.0F;
    ((bub)localObject).Fka = 0.0F;
    if (paramString != null) {
      ((bub)localObject).FjY = Dq(paramString);
    }
    if (str1 != null) {
      ((bub)localObject).FjZ = Dq(str1);
    }
    if (paramMap != null) {
      ((bub)localObject).Fka = Dq(paramMap);
    }
    AppMethodBeat.o(96148);
    return localObject;
  }
  
  private static LinkedList<btz> q(Map<String, String> paramMap, String paramString)
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
      btz localbtz = new btz();
      localbtz.Id = Dr(str9);
      localbtz.ndI = auu(str8);
      localbtz.Title = Dr(str7);
      localbtz.Desc = Dr(str6);
      localbtz.Url = Dr(str5);
      localbtz.EUH = auu(str2);
      localbtz.Fjh = Dr(str3);
      localbtz.Fji = auu(str1);
      localbtz.Fjj = auu(str4);
      localbtz.Fjk = ((bub)localObject);
      localLinkedList.add(localbtz);
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