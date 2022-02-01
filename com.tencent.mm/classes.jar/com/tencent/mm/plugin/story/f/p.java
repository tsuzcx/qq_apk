package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ddp;
import com.tencent.mm.protocal.protobuf.ddx;
import com.tencent.mm.protocal.protobuf.ddy;
import com.tencent.mm.protocal.protobuf.dep;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import d.l;
import d.n.n;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/model/StoryTimelineConvert;", "", "()V", "Companion", "pullXml", "plugin-story_release"})
public final class p
{
  private static final String TAG = "MicroMsg.StoryTimelineConvert";
  private static String mWM;
  public static final a zsx;
  
  static
  {
    AppMethodBeat.i(118768);
    zsx = new a((byte)0);
    TAG = "MicroMsg.StoryTimelineConvert";
    mWM = "]]>";
    AppMethodBeat.o(118768);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/model/StoryTimelineConvert$Companion;", "", "()V", "INVALID_TAG", "", "getINVALID_TAG", "()Ljava/lang/String;", "setINVALID_TAG", "(Ljava/lang/String;)V", "TAG", "filterId", "s", "filterNull", "isNumeric", "", "str", "pullTimeLineXml", "timeLine", "Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "editor", "Lcom/tencent/mm/protocal/protobuf/StoryMediaEditorInfo;", "plugin-story_release"})
  public static final class a
  {
    public static String a(dep paramdep, ddx paramddx)
    {
      AppMethodBeat.i(118758);
      d.g.b.k.h(paramdep, "timeLine");
      p.b localb = new p.b();
      HashMap localHashMap = new HashMap();
      localb.SA("StoryObject");
      localb.SA("id");
      if ((paramdep.Id == null) || (paramdep.Id.equals(""))) {
        localb.setText("0");
      }
      String str;
      for (;;)
      {
        localb.SB("id");
        if (paramdep.ncR != null)
        {
          localb.SA("username");
          localb.awI(paramdep.ncR);
          localb.SB("username");
        }
        localb.SA("createTime");
        localb.awI(String.valueOf(paramdep.CreateTime));
        localb.SB("createTime");
        localb.SA("scope");
        localb.setText(paramdep.FOe);
        localb.SB("scope");
        localb.SA("featured");
        localb.setText(paramdep.FOf);
        localb.SB("featured");
        localb.SA("report");
        localb.SA("publish_obj_id");
        str = paramdep.FOd;
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        localb.awI((String)localObject);
        localb.SB("publish_obj_id");
        ac.i(p.access$getTAG$cp(), "report ".concat(String.valueOf(paramddx)));
        if (paramddx == null) {
          break label578;
        }
        localb.SA("music");
        if (paramddx.FNC)
        {
          localb.SA("req_id");
          localb.awI(String.valueOf(paramddx.FNB));
          localb.SB("req_id");
          localb.SA("id");
          localb.setText(paramddx.wri);
          localb.SB("id");
          localb.SA("index");
          localb.setText(paramddx.Ewn);
          localb.SB("index");
        }
        localb.SB("music");
        localb.SA("emojiList");
        localObject = paramddx.FND;
        d.g.b.k.g(localObject, "editor.emojiMd5");
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          str = (String)((Iterator)localObject).next();
          localb.SA("emoji");
          d.g.b.k.g(str, "it");
          localb.awI(str);
          localb.SB("emoji");
        }
        localb.setText(paramdep.Id);
      }
      localb.SB("emojiList");
      localb.SA("wordList");
      Object localObject = paramddx.FNE;
      d.g.b.k.g(localObject, "editor.wordText");
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        str = (String)((Iterator)localObject).next();
        localb.SA("word");
        d.g.b.k.g(str, "it");
        localb.awI(str);
        localb.SB("word");
      }
      localb.SB("wordList");
      localb.SA("tip");
      localObject = paramddx.Bof;
      paramddx = (ddx)localObject;
      if (localObject == null) {
        paramddx = "";
      }
      localb.awI(paramddx);
      localb.SB("tip");
      label578:
      localb.SB("report");
      localb.SA("ContentObject");
      localb.SA("title");
      localb.awI(auw(paramdep.FOc.Title));
      localb.SB("title");
      if (paramdep.FOc.Etz.size() > 0)
      {
        localb.SA("mediaList");
        paramdep = paramdep.FOc.Etz.iterator();
        if (paramdep.hasNext())
        {
          paramddx = (ddy)paramdep.next();
          localb.SA("media");
          localb.SA("id");
          localObject = paramddx.Id;
          d.g.b.k.g(localObject, "media.Id");
          if (d.g.b.k.g(aux((String)localObject), "")) {
            localb.awI("0");
          }
          for (;;)
          {
            localb.SB("id");
            localb.SA("type");
            localb.awI(String.valueOf(paramddx.ndI));
            localb.SB("type");
            localb.SA("duration");
            float f = paramddx.FNF;
            localb.mWO.append(f);
            localb.SB("duration");
            localHashMap.clear();
            ((Map)localHashMap).put("type", String.valueOf(paramddx.EUH));
            if (!bs.isNullOrNil(paramddx.md5)) {
              ((Map)localHashMap).put("md5", paramddx.md5);
            }
            if (!bs.isNullOrNil(paramddx.FjC)) {
              ((Map)localHashMap).put("videomd5", paramddx.FjC);
            }
            localb.p("url", (Map)localHashMap);
            localb.awI(auw(paramddx.Url));
            localb.SB("url");
            if ((paramddx.Fjh != null) && (!paramddx.Fjh.equals("")))
            {
              localHashMap.clear();
              ((Map)localHashMap).put("type", String.valueOf(paramddx.Fji));
              localb.p("thumb", (Map)localHashMap);
              localb.awI(auw(paramddx.Fjh));
              localb.SB("thumb");
            }
            if (paramddx.subType > 0)
            {
              localb.SA("subType");
              localb.awI(String.valueOf(paramddx.subType));
              localb.SB("subType");
            }
            localb.SB("media");
            break;
            localObject = paramddx.Id;
            d.g.b.k.g(localObject, "media.Id");
            localb.awI(aux((String)localObject));
          }
        }
        localb.SB("mediaList");
      }
      localb.SB("ContentObject");
      localb.SB("StoryObject");
      paramdep = localb.mWO.toString();
      d.g.b.k.g(paramdep, "sb.toString()");
      ac.d(p.access$getTAG$cp(), "xmlContent: ".concat(String.valueOf(paramdep)));
      if (bv.L(paramdep, "StoryObject") == null)
      {
        ac.e(p.access$getTAG$cp(), "xml is error");
        AppMethodBeat.o(118758);
        return "";
      }
      AppMethodBeat.o(118758);
      return paramdep;
    }
    
    private static String auw(String paramString)
    {
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      return str;
    }
    
    private static String aux(String paramString)
    {
      AppMethodBeat.i(118759);
      d.g.b.k.h(paramString, "s");
      if (bs.isNullOrNil(paramString))
      {
        AppMethodBeat.o(118759);
        return "";
      }
      if (isNumeric(paramString))
      {
        AppMethodBeat.o(118759);
        return paramString;
      }
      AppMethodBeat.o(118759);
      return "";
    }
    
    private static boolean isNumeric(String paramString)
    {
      AppMethodBeat.i(118760);
      d.g.b.k.h(paramString, "str");
      paramString = (CharSequence)paramString;
      boolean bool = new d.n.k("\\d*").aB(paramString);
      AppMethodBeat.o(118760);
      return bool;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/model/StoryTimelineConvert$pullXml;", "", "()V", "sb", "Ljava/lang/StringBuffer;", "getSb", "()Ljava/lang/StringBuffer;", "setSb", "(Ljava/lang/StringBuffer;)V", "xml", "", "getXml", "()Ljava/lang/String;", "addTag", "", "tag", "value", "", "emptyTag", "endTag", "setText", "", "startTag", "values", "", "text", "plugin-story_release"})
  public static final class b
  {
    StringBuffer mWO;
    
    public b()
    {
      AppMethodBeat.i(118767);
      this.mWO = new StringBuffer();
      AppMethodBeat.o(118767);
    }
    
    public final void SA(String paramString)
    {
      AppMethodBeat.i(118761);
      d.g.b.k.h(paramString, "tag");
      this.mWO.append("<" + paramString + '>');
      AppMethodBeat.o(118761);
    }
    
    public final void SB(String paramString)
    {
      AppMethodBeat.i(118762);
      d.g.b.k.h(paramString, "tag");
      this.mWO.append("</" + paramString + '>');
      AppMethodBeat.o(118762);
    }
    
    public final void awI(String paramString)
    {
      AppMethodBeat.i(118763);
      d.g.b.k.h(paramString, "value");
      setText(paramString);
      AppMethodBeat.o(118763);
    }
    
    public final void p(String paramString, Map<String, String> paramMap)
    {
      AppMethodBeat.i(118766);
      d.g.b.k.h(paramString, "tag");
      d.g.b.k.h(paramMap, "values");
      this.mWO.append("<".concat(String.valueOf(paramString)));
      paramString = paramMap.keySet().iterator();
      while (paramString.hasNext())
      {
        String str1 = (String)paramString.next();
        String str2 = (String)paramMap.get(str1);
        this.mWO.append(" " + str1 + "=\"" + str2 + "\" ");
      }
      this.mWO.append(">");
      paramMap.clear();
      AppMethodBeat.o(118766);
    }
    
    public final void setText(int paramInt)
    {
      AppMethodBeat.i(118765);
      this.mWO.append(paramInt);
      AppMethodBeat.o(118765);
    }
    
    public final void setText(String paramString)
    {
      AppMethodBeat.i(118764);
      d.g.b.k.h(paramString, "value");
      if (bs.isNullOrNil(paramString))
      {
        AppMethodBeat.o(118764);
        return;
      }
      CharSequence localCharSequence = (CharSequence)paramString;
      p.a locala = p.zsx;
      if (n.a(localCharSequence, (CharSequence)p.dVX(), false))
      {
        this.mWO.append("<![CDATA[" + bs.aLw(paramString) + "]]>");
        AppMethodBeat.o(118764);
        return;
      }
      this.mWO.append("<![CDATA[" + paramString + "]]>");
      AppMethodBeat.o(118764);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.p
 * JD-Core Version:    0.7.0.1
 */