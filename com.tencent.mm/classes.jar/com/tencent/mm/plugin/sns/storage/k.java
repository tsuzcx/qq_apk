package com.tencent.mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.modelsns.o;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.protocal.protobuf.dnb;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.d;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/storage/MediaObjParser;", "", "()V", "fillContentMediaSize", "Lcom/tencent/mm/protocal/protobuf/MediaSize;", "maps", "", "", "SIZE_TAG", "parseMedia", "Lcom/tencent/mm/protocal/protobuf/MediaObj;", "prefTag", "values", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
{
  public static final k QYy;
  
  static
  {
    AppMethodBeat.i(306591);
    QYy = new k();
    AppMethodBeat.o(306591);
  }
  
  public static dmz W(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(306584);
    if (paramString == null)
    {
      AppMethodBeat.o(306584);
      return null;
    }
    if (paramMap == null)
    {
      AppMethodBeat.o(306584);
      return null;
    }
    String str7 = s.X(paramString, ".id");
    String str9 = s.X(paramString, ".type");
    String str12 = s.X(paramString, ".title");
    String str14 = s.X(paramString, ".description");
    String str16 = s.X(paramString, ".url");
    String str23 = s.X(paramString, ".url.$videomd5");
    String str21 = s.X(paramString, ".thumb");
    String str25 = s.X(paramString, ".url.$type");
    String str27 = s.X(paramString, ".thumb.$type");
    String str19 = s.X(paramString, ".private");
    String str24 = s.X(paramString, ".subType");
    String str22 = s.X(paramString, ".userData");
    String str29 = s.X(paramString, ".lowBandUrl");
    String str30 = s.X(paramString, ".lowBandUrl.$type");
    String str28 = s.X(paramString, ".songalbumurl");
    String str26 = s.X(paramString, ".songlyric");
    String str20 = s.X(paramString, ".attachUrl");
    String str18 = s.X(paramString, ".attachUrl.$md5");
    String str17 = s.X(paramString, ".url.$md5");
    String str15 = s.X(paramString, ".videosize.$attachTotalTime");
    String str13 = s.X(paramString, ".attachThumbUrl");
    String str11 = s.X(paramString, ".attachShareTitle");
    String str8 = s.X(paramString, ".enc");
    String str6 = s.X(paramString, ".enc.$key");
    String str5 = s.X(paramString, ".url.$token");
    String str4 = s.X(paramString, ".url.$enc_idx");
    String str3 = s.X(paramString, ".url.$key");
    String str2 = s.X(paramString, ".thumb.$token");
    String str1 = s.X(paramString, ".thumb.$enc_idx");
    Object localObject = s.X(paramString, ".thumb.$key");
    String str10 = s.X(paramString, ".videoDuration");
    String str31 = s.X(paramString, ".size.$width");
    String str32 = s.X(paramString, ".size.$height");
    paramString = s.X(paramString, ".size.$totalSize");
    str31 = (String)paramMap.get(str31);
    str32 = (String)paramMap.get(str32);
    String str33 = (String)paramMap.get(paramString);
    paramString = new dnb();
    paramString.aaUc = 0.0F;
    paramString.aaUb = 0.0F;
    paramString.aaUd = 0.0F;
    if (str31 != null) {
      paramString.aaUb = o.Pk(str31);
    }
    if (str32 != null) {
      paramString.aaUc = o.Pk(str32);
    }
    if (str33 != null) {
      paramString.aaUd = o.Pk(str33);
    }
    str7 = (String)paramMap.get(str7);
    str9 = (String)paramMap.get(str9);
    str12 = (String)paramMap.get(str12);
    str14 = (String)paramMap.get(str14);
    str16 = (String)paramMap.get(str16);
    str10 = (String)paramMap.get(str10);
    str19 = (String)paramMap.get(str19);
    str21 = (String)paramMap.get(str21);
    str23 = (String)paramMap.get(str23);
    str25 = (String)paramMap.get(str25);
    str27 = (String)paramMap.get(str27);
    str29 = (String)paramMap.get(str29);
    str30 = (String)paramMap.get(str30);
    str28 = (String)paramMap.get(str28);
    str26 = (String)paramMap.get(str26);
    str24 = (String)paramMap.get(str24);
    str22 = (String)paramMap.get(str22);
    str20 = (String)paramMap.get(str20);
    str18 = (String)paramMap.get(str18);
    str17 = (String)paramMap.get(str17);
    str15 = (String)paramMap.get(str15);
    str13 = (String)paramMap.get(str13);
    str11 = (String)paramMap.get(str11);
    str8 = (String)paramMap.get(str8);
    str6 = (String)paramMap.get(str6);
    str5 = (String)paramMap.get(str5);
    str4 = (String)paramMap.get(str4);
    str3 = (String)paramMap.get(str3);
    str2 = (String)paramMap.get(str2);
    str1 = (String)paramMap.get(str1);
    paramMap = (String)paramMap.get(localObject);
    if ((str9 == null) || (Util.isNullOrNil(str7)))
    {
      AppMethodBeat.o(306584);
      return null;
    }
    localObject = new dmz();
    ((dmz)localObject).Id = o.Pl(str7);
    ((dmz)localObject).vhJ = Util.getInt(str9, 0);
    ((dmz)localObject).hAP = o.Pl(str12);
    ((dmz)localObject).IGG = o.Pl(str14);
    ((dmz)localObject).Url = o.Pl(str16);
    ((dmz)localObject).aazR = Util.getInt(str25, 0);
    ((dmz)localObject).aaTl = o.Pl(str21);
    ((dmz)localObject).aaTm = Util.getInt(str27, 0);
    ((dmz)localObject).Privated = Util.getInt(str19, 0);
    ((dmz)localObject).aaTn = paramString;
    ((dmz)localObject).aaTo = o.Pl(str29);
    ((dmz)localObject).aaTp = Util.getInt(str30, 0);
    ((dmz)localObject).songAlbumUrl = str28;
    ((dmz)localObject).songLyric = str26;
    ((dmz)localObject).RcB = o.Pl(str22);
    ((dmz)localObject).subType = Util.getInt(str24, 0);
    ((dmz)localObject).aaTr = o.Pl(str20);
    ((dmz)localObject).aaTt = o.Pl(str18);
    ((dmz)localObject).aaTs = o.Pl(str17);
    ((dmz)localObject).aaTE = o.Pl(str23);
    ((dmz)localObject).RGm = Util.getInt(str15, 0);
    ((dmz)localObject).aaTu = o.Pl(str13);
    ((dmz)localObject).aaTv = o.Pl(str11);
    ((dmz)localObject).aaTw = Util.getInt(str8, 0);
    ((dmz)localObject).aaTx = Util.getLong(str6, 0L);
    if (((dmz)localObject).Url == null)
    {
      paramString = "".getBytes(d.UTF_8);
      s.s(paramString, "(this as java.lang.String).getBytes(charset)");
    }
    for (;;)
    {
      ((dmz)localObject).aaTy = g.getMessageDigest(paramString);
      ((dmz)localObject).msf = str5;
      ((dmz)localObject).aaTz = Util.getInt(str4, 0);
      ((dmz)localObject).aaTA = str3;
      ((dmz)localObject).aaTB = str2;
      ((dmz)localObject).aaTC = Util.getInt(str1, 0);
      ((dmz)localObject).aaTD = paramMap;
      ((dmz)localObject).aaTF = o.Pk(str10);
      AppMethodBeat.o(306584);
      return localObject;
      paramString = ((dmz)localObject).Url;
      s.s(paramString, "mediaObj.Url");
      paramString = paramString.getBytes(d.UTF_8);
      s.s(paramString, "(this as java.lang.String).getBytes(charset)");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.k
 * JD-Core Version:    0.7.0.1
 */