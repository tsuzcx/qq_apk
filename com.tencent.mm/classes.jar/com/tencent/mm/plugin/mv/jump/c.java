package com.tencent.mm.plugin.mv.jump;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.boo;
import com.tencent.mm.protocal.protobuf.bop;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"parseFromXml", "", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "prefix", "", "values", "", "plugin-mv_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final void a(boo paramboo, String paramString, Map<String, String> paramMap)
  {
    long l = 0L;
    AppMethodBeat.i(286024);
    s.u(paramboo, "<this>");
    s.u(paramString, "prefix");
    s.u(paramMap, "values");
    try
    {
      String str2 = s.X(paramString, ".FinderMVSongInfo");
      String str1 = (String)paramMap.get(s.X(str2, ".songName"));
      paramString = str1;
      if (str1 == null) {
        paramString = "";
      }
      paramboo.songName = paramString;
      str1 = (String)paramMap.get(s.X(str2, ".singer"));
      paramString = str1;
      if (str1 == null) {
        paramString = "";
      }
      paramboo.rDl = paramString;
      str1 = (String)paramMap.get(s.X(str2, ".musicDataUrl"));
      paramString = str1;
      if (str1 == null) {
        paramString = "";
      }
      paramboo.musicDataUrl = paramString;
      str1 = (String)paramMap.get(s.X(str2, ".musicAppId"));
      paramString = str1;
      if (str1 == null) {
        paramString = "";
      }
      paramboo.ZWQ = paramString;
      str1 = (String)paramMap.get(s.X(str2, ".musicWebUrl"));
      paramString = str1;
      if (str1 == null) {
        paramString = "";
      }
      paramboo.ZWR = paramString;
      str1 = (String)paramMap.get(s.X(str2, ".songId"));
      paramString = str1;
      if (str1 == null) {
        paramString = "";
      }
      paramboo.mLQ = paramString;
      str1 = (String)paramMap.get(s.X(str2, ".lyric"));
      paramString = str1;
      if (str1 == null) {
        paramString = "";
      }
      paramboo.Mcq = paramString;
      str1 = (String)paramMap.get(s.X(str2, ".albumName"));
      paramString = str1;
      if (str1 == null) {
        paramString = "";
      }
      paramboo.albumName = paramString;
      str1 = (String)paramMap.get(s.X(str2, ".albumUrl"));
      paramString = str1;
      if (str1 == null) {
        paramString = "";
      }
      paramboo.ZWS = paramString;
      str1 = (String)paramMap.get(s.X(str2, ".genre"));
      paramString = str1;
      if (str1 == null) {
        paramString = "";
      }
      paramboo.ZTA = paramString;
      str1 = (String)paramMap.get(s.X(str2, ".publicTime"));
      paramString = str1;
      if (str1 == null) {
        paramString = "";
      }
      paramboo.ZWT = paramString;
      paramString = (String)paramMap.get(s.X(str2, ".publicTimeS"));
      int i;
      if (paramString == null)
      {
        paramboo.ZWU = l;
        str1 = (String)paramMap.get(s.X(str2, ".extraInfo"));
        paramString = str1;
        if (str1 == null) {
          paramString = "";
        }
        paramboo.extraInfo = paramString;
        str1 = (String)paramMap.get(s.X(str2, ".identification"));
        paramString = str1;
        if (str1 == null) {
          paramString = "";
        }
        paramboo.identification = paramString;
        paramString = (String)paramMap.get(s.X(str2, ".duration"));
        if (paramString != null) {
          break label640;
        }
        i = 0;
      }
      for (;;)
      {
        paramboo.duration = i;
        bop localbop = new bop();
        str1 = (String)paramMap.get(s.X(str2, ".musicOperationUrl"));
        paramString = str1;
        if (str1 == null) {
          paramString = "";
        }
        localbop.ZWX = paramString;
        paramString = ah.aiuX;
        paramboo.ZWW = localbop;
        paramMap = (String)paramMap.get(s.X(str2, ".mid"));
        paramString = paramMap;
        if (paramMap == null) {
          paramString = "";
        }
        paramboo.oOZ = paramString;
        AppMethodBeat.o(286024);
        return;
        paramString = n.bJH(paramString);
        if (paramString == null) {
          break;
        }
        l = paramString.longValue();
        break;
        label640:
        paramString = n.bJF(paramString);
        if (paramString == null) {
          i = 0;
        } else {
          i = paramString.intValue();
        }
      }
      return;
    }
    catch (Exception paramboo)
    {
      Log.e("FinderMVSongInfo", s.X("parse FinderMVSongInfo from xml fail:", paramboo.getLocalizedMessage()));
      AppMethodBeat.o(286024);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.jump.c
 * JD-Core Version:    0.7.0.1
 */