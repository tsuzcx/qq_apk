package com.tencent.mm.plugin.story.model;

import a.f.b.j;
import a.l;
import a.l.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.chb;
import com.tencent.mm.protocal.protobuf.chk;
import com.tencent.mm.protocal.protobuf.chl;
import com.tencent.mm.protocal.protobuf.cic;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/StoryTimelineConvert$Companion;", "", "()V", "INVALID_TAG", "", "getINVALID_TAG", "()Ljava/lang/String;", "setINVALID_TAG", "(Ljava/lang/String;)V", "TAG", "filterId", "s", "filterNull", "isNumeric", "", "str", "pullTimeLineXml", "timeLine", "Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "editor", "Lcom/tencent/mm/protocal/protobuf/StoryMediaEditorInfo;", "plugin-story_release"})
public final class p$a
{
  public static String a(cic paramcic, chk paramchk)
  {
    AppMethodBeat.i(109135);
    j.q(paramcic, "timeLine");
    p.b localb = new p.b();
    HashMap localHashMap = new HashMap();
    localb.Gp("StoryObject");
    localb.Gp("id");
    if ((paramcic.Id == null) || (paramcic.Id.equals(""))) {
      localb.setText("0");
    }
    String str;
    for (;;)
    {
      localb.Gq("id");
      if (paramcic.jJA != null)
      {
        localb.Gp("username");
        localb.adh(paramcic.jJA);
        localb.Gq("username");
      }
      localb.Gp("createTime");
      localb.adh(String.valueOf(paramcic.CreateTime));
      localb.Gq("createTime");
      localb.Gp("scope");
      localb.setText(paramcic.xSM);
      localb.Gq("scope");
      localb.Gp("featured");
      localb.setText(paramcic.xSN);
      localb.Gq("featured");
      localb.Gp("report");
      localb.Gp("publish_obj_id");
      str = paramcic.xSL;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      localb.adh((String)localObject);
      localb.Gq("publish_obj_id");
      ab.i("czf", "report ".concat(String.valueOf(paramchk)));
      if (paramchk == null) {
        break label577;
      }
      localb.Gp("music");
      if (paramchk.xSn)
      {
        localb.Gp("req_id");
        localb.adh(String.valueOf(paramchk.xSm));
        localb.Gq("req_id");
        localb.Gp("id");
        localb.setText(paramchk.swp);
        localb.Gq("id");
        localb.Gp("index");
        localb.setText(paramchk.xSg);
        localb.Gq("index");
      }
      localb.Gq("music");
      localb.Gp("emojiList");
      localObject = paramchk.xSo;
      j.p(localObject, "editor.emojiMd5");
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        str = (String)((Iterator)localObject).next();
        localb.Gp("emoji");
        j.p(str, "it");
        localb.adh(str);
        localb.Gq("emoji");
      }
      localb.setText(paramcic.Id);
    }
    localb.Gq("emojiList");
    localb.Gp("wordList");
    Object localObject = paramchk.xSp;
    j.p(localObject, "editor.wordText");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      str = (String)((Iterator)localObject).next();
      localb.Gp("word");
      j.p(str, "it");
      localb.adh(str);
      localb.Gq("word");
    }
    localb.Gq("wordList");
    localb.Gp("tip");
    localObject = paramchk.ubk;
    paramchk = (chk)localObject;
    if (localObject == null) {
      paramchk = "";
    }
    localb.adh(paramchk);
    localb.Gq("tip");
    label577:
    localb.Gq("report");
    localb.Gp("ContentObject");
    localb.Gp("title");
    localb.adh(abd(paramcic.xSK.Title));
    localb.Gq("title");
    if (paramcic.xSK.wOa.size() > 0)
    {
      localb.Gp("mediaList");
      paramcic = paramcic.xSK.wOa.iterator();
      if (paramcic.hasNext())
      {
        paramchk = (chl)paramcic.next();
        localb.Gp("media");
        localb.Gp("id");
        localObject = paramchk.Id;
        j.p(localObject, "media.Id");
        if (j.e(abe((String)localObject), "")) {
          localb.adh("0");
        }
        for (;;)
        {
          localb.Gq("id");
          localb.Gp("type");
          localb.adh(String.valueOf(paramchk.jKs));
          localb.Gq("type");
          localb.Gp("duration");
          float f = paramchk.duration;
          localb.jDt.append(f);
          localb.Gq("duration");
          localHashMap.clear();
          ((Map)localHashMap).put("type", String.valueOf(paramchk.xrR));
          if (!bo.isNullOrNil(paramchk.cqq)) {
            ((Map)localHashMap).put("md5", paramchk.cqq);
          }
          if (!bo.isNullOrNil(paramchk.xsn)) {
            ((Map)localHashMap).put("videomd5", paramchk.xsn);
          }
          localb.n("url", (Map)localHashMap);
          localb.adh(abd(paramchk.Url));
          localb.Gq("url");
          if ((paramchk.xrS != null) && (!paramchk.xrS.equals("")))
          {
            localHashMap.clear();
            ((Map)localHashMap).put("type", String.valueOf(paramchk.xrT));
            localb.n("thumb", (Map)localHashMap);
            localb.adh(abd(paramchk.xrS));
            localb.Gq("thumb");
          }
          if (paramchk.subType > 0)
          {
            localb.Gp("subType");
            localb.adh(String.valueOf(paramchk.subType));
            localb.Gq("subType");
          }
          localb.Gq("media");
          break;
          localObject = paramchk.Id;
          j.p(localObject, "media.Id");
          localb.adh(abe((String)localObject));
        }
      }
      localb.Gq("mediaList");
    }
    localb.Gq("ContentObject");
    localb.Gq("StoryObject");
    paramcic = localb.jDt.toString();
    j.p(paramcic, "sb.toString()");
    ab.d(p.access$getTAG$cp(), "xmlContent: ".concat(String.valueOf(paramcic)));
    if (br.F(paramcic, "StoryObject") == null)
    {
      ab.e(p.access$getTAG$cp(), "xml is error");
      AppMethodBeat.o(109135);
      return "";
    }
    AppMethodBeat.o(109135);
    return paramcic;
  }
  
  private static String abd(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private static String abe(String paramString)
  {
    AppMethodBeat.i(109136);
    j.q(paramString, "s");
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(109136);
      return "";
    }
    if (isNumeric(paramString))
    {
      AppMethodBeat.o(109136);
      return paramString;
    }
    AppMethodBeat.o(109136);
    return "";
  }
  
  private static boolean isNumeric(String paramString)
  {
    AppMethodBeat.i(109137);
    j.q(paramString, "str");
    paramString = (CharSequence)paramString;
    boolean bool = new k("\\d*").ao(paramString);
    AppMethodBeat.o(109137);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.p.a
 * JD-Core Version:    0.7.0.1
 */