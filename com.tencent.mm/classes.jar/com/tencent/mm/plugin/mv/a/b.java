package com.tencent.mm.plugin.mv.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"parseFromXml", "", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "prefix", "", "values", "", "plugin-mv_release"})
public final class b
{
  public static final void a(bds parambds, String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(243338);
    p.k(parambds, "$this$parseFromXml");
    p.k(paramString, "prefix");
    p.k(paramMap, "values");
    try
    {
      String str2 = paramString + ".FinderMVSongInfo";
      String str1 = (String)paramMap.get(str2 + ".songName");
      paramString = str1;
      if (str1 == null) {
        paramString = "";
      }
      parambds.HLH = paramString;
      str1 = (String)paramMap.get(str2 + ".singer");
      paramString = str1;
      if (str1 == null) {
        paramString = "";
      }
      parambds.ozs = paramString;
      str1 = (String)paramMap.get(str2 + ".musicDataUrl");
      paramString = str1;
      if (str1 == null) {
        paramString = "";
      }
      parambds.musicDataUrl = paramString;
      str1 = (String)paramMap.get(str2 + ".musicAppId");
      paramString = str1;
      if (str1 == null) {
        paramString = "";
      }
      parambds.SOJ = paramString;
      str1 = (String)paramMap.get(str2 + ".musicWebUrl");
      paramString = str1;
      if (str1 == null) {
        paramString = "";
      }
      parambds.SOK = paramString;
      str1 = (String)paramMap.get(str2 + ".songId");
      paramString = str1;
      if (str1 == null) {
        paramString = "";
      }
      parambds.kkU = paramString;
      str1 = (String)paramMap.get(str2 + ".lyric");
      paramString = str1;
      if (str1 == null) {
        paramString = "";
      }
      parambds.SOL = paramString;
      str1 = (String)paramMap.get(str2 + ".albumName");
      paramString = str1;
      if (str1 == null) {
        paramString = "";
      }
      parambds.albumName = paramString;
      str1 = (String)paramMap.get(str2 + ".albumUrl");
      paramString = str1;
      if (str1 == null) {
        paramString = "";
      }
      parambds.SOM = paramString;
      str1 = (String)paramMap.get(str2 + ".genre");
      paramString = str1;
      if (str1 == null) {
        paramString = "";
      }
      parambds.SMY = paramString;
      str1 = (String)paramMap.get(str2 + ".publicTime");
      paramString = str1;
      if (str1 == null) {
        paramString = "";
      }
      parambds.SON = paramString;
      paramString = (String)paramMap.get(str2 + ".publicTimeS");
      long l;
      if (paramString != null)
      {
        paramString = n.bHD(paramString);
        if (paramString != null)
        {
          l = paramString.longValue();
          parambds.SOO = l;
          str1 = (String)paramMap.get(str2 + ".extraInfo");
          paramString = str1;
          if (str1 == null) {
            paramString = "";
          }
          parambds.extraInfo = paramString;
          str1 = (String)paramMap.get(str2 + ".identification");
          paramString = str1;
          if (str1 == null) {
            paramString = "";
          }
          parambds.identification = paramString;
          paramString = (String)paramMap.get(str2 + ".duration");
          if (paramString == null) {
            break label775;
          }
          paramString = n.bHC(paramString);
          if (paramString == null) {
            break label775;
          }
        }
      }
      label775:
      for (int i = paramString.intValue();; i = 0)
      {
        parambds.duration = i;
        AppMethodBeat.o(243338);
        return;
        l = 0L;
        break;
      }
      return;
    }
    catch (Exception parambds)
    {
      Log.e("FinderMVSongInfo", "parse FinderMVSongInfo from xml fail:" + parambds.getLocalizedMessage());
      AppMethodBeat.o(243338);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.a.b
 * JD-Core Version:    0.7.0.1
 */