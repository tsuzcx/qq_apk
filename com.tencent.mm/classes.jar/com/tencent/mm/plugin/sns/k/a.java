package com.tencent.mm.plugin.sns.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cxu;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.protocal.protobuf.dnb;
import com.tencent.mm.protocal.protobuf.en;
import com.tencent.mm.protocal.protobuf.hl;
import com.tencent.mm.protocal.protobuf.hm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.LinkedList;
import java.util.Map;

public final class a
{
  private static float Pk(String paramString)
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
  
  private static String Pl(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private static en a(Map<String, String> paramMap, en paramen)
  {
    AppMethodBeat.i(96146);
    hl localhl = new hl();
    localhl.IGU = Pl((String)paramMap.get(".albumList.album.author.name"));
    localhl.hAP = Pl((String)paramMap.get(".albumList.album.author.title"));
    localhl.crB = Pl((String)paramMap.get(".albumList.album.author.description"));
    localhl.YIQ = Pl((String)paramMap.get(".albumList.album.author.quote"));
    localhl.YIR = aY(paramMap);
    paramen.YGD = localhl;
    AppMethodBeat.o(96146);
    return paramen;
  }
  
  private static hm aY(Map<String, String> paramMap)
  {
    AppMethodBeat.i(96147);
    hm localhm = new hm();
    dnb localdnb = ae(paramMap, ".albumList.album.author.icon.media");
    String str1 = (String)paramMap.get(".albumList.album.author.icon.media.id");
    String str2 = (String)paramMap.get(".albumList.album.author.icon.media.type");
    String str3 = (String)paramMap.get(".albumList.album.author.icon.media.title");
    String str4 = (String)paramMap.get(".albumList.album.author.icon.media.desc");
    String str5 = (String)paramMap.get(".albumList.album.author.icon.media.url");
    String str6 = (String)paramMap.get(".albumList.album.author.icon.media.private");
    String str7 = (String)paramMap.get(".albumList.album.author.icon.media.thumb");
    String str8 = (String)paramMap.get(".albumList.album.author.icon.media.url.$type");
    paramMap = (String)paramMap.get(".albumList.album.author.icon.media.thumb.$type");
    dmz localdmz = new dmz();
    localdmz.Id = Pl(str1);
    localdmz.vhJ = aZh(str2);
    localdmz.hAP = Pl(str3);
    localdmz.IGG = Pl(str4);
    localdmz.Url = Pl(str5);
    localdmz.aazR = aZh(str8);
    localdmz.aaTl = Pl(str7);
    localdmz.aaTm = aZh(paramMap);
    localdmz.Privated = aZh(str6);
    localdmz.aaTn = localdnb;
    localhm.YIS = localdmz;
    AppMethodBeat.o(96147);
    return localhm;
  }
  
  private static int aZh(String paramString)
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
  
  public static en aZi(String paramString)
  {
    AppMethodBeat.i(96145);
    Map localMap = XmlParser.parseXml(paramString, "albumList", null);
    paramString = new en();
    if (localMap != null)
    {
      paramString.IJD = Pl((String)localMap.get(".albumList.$lang"));
      paramString = b(localMap, a(localMap, paramString));
    }
    for (;;)
    {
      AppMethodBeat.o(96145);
      return paramString;
    }
  }
  
  private static dnb ae(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(96148);
    String str2 = paramString + ".size.$width";
    String str1 = paramString + ".size.$height";
    Object localObject = paramString + ".size.$totalSize";
    paramString = (String)paramMap.get(str2);
    str1 = (String)paramMap.get(str1);
    paramMap = (String)paramMap.get(localObject);
    localObject = new dnb();
    ((dnb)localObject).aaUc = 0.0F;
    ((dnb)localObject).aaUb = 0.0F;
    ((dnb)localObject).aaUd = 0.0F;
    if (paramString != null) {
      ((dnb)localObject).aaUb = Pk(paramString);
    }
    if (str1 != null) {
      ((dnb)localObject).aaUc = Pk(str1);
    }
    if (paramMap != null) {
      ((dnb)localObject).aaUd = Pk(paramMap);
    }
    AppMethodBeat.o(96148);
    return localObject;
  }
  
  private static LinkedList<dmz> af(Map<String, String> paramMap, String paramString)
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
        break label803;
      }
      localObject = ae(paramMap, (String)localObject);
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
        break label803;
      }
      dmz localdmz = new dmz();
      localdmz.Id = Pl(str9);
      localdmz.vhJ = aZh(str8);
      localdmz.hAP = Pl(str7);
      localdmz.IGG = Pl(str6);
      localdmz.Url = Pl(str5);
      localdmz.aazR = aZh(str2);
      localdmz.aaTl = Pl(str3);
      localdmz.aaTm = aZh(str1);
      localdmz.Privated = aZh(str4);
      localdmz.aaTn = ((dnb)localObject);
      localLinkedList.add(localdmz);
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
    label803:
    AppMethodBeat.o(96150);
    return localLinkedList;
  }
  
  private static en b(Map<String, String> paramMap, en paramen)
  {
    AppMethodBeat.i(96149);
    int i = 0;
    cxu localcxu = new cxu();
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
      localcxu.IGU = Pl(str2);
      localcxu.Zpr = af(paramMap, str1);
      paramen.GroupList.add(localcxu);
      i += 1;
      break;
      str2 = ".albumList.album.groupList.group" + i + ".name";
    }
    label137:
    AppMethodBeat.o(96149);
    return paramen;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.k.a
 * JD-Core Version:    0.7.0.1
 */