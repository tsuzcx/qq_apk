package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.djc;
import com.tencent.mm.protocal.protobuf.djk;
import com.tencent.mm.protocal.protobuf.djl;
import com.tencent.mm.protocal.protobuf.dkc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import d.l;
import d.n.k;
import d.n.n;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/model/StoryTimelineConvert;", "", "()V", "Companion", "pullXml", "plugin-story_release"})
public final class p
{
  public static final a AKr;
  private static final String TAG = "MicroMsg.StoryTimelineConvert";
  private static String nxj;
  
  static
  {
    AppMethodBeat.i(118768);
    AKr = new a((byte)0);
    TAG = "MicroMsg.StoryTimelineConvert";
    nxj = "]]>";
    AppMethodBeat.o(118768);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/model/StoryTimelineConvert$Companion;", "", "()V", "INVALID_TAG", "", "getINVALID_TAG", "()Ljava/lang/String;", "setINVALID_TAG", "(Ljava/lang/String;)V", "TAG", "filterId", "s", "filterNull", "isNumeric", "", "str", "pullTimeLineXml", "timeLine", "Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "editor", "Lcom/tencent/mm/protocal/protobuf/StoryMediaEditorInfo;", "plugin-story_release"})
  public static final class a
  {
    public static String a(dkc paramdkc, djk paramdjk)
    {
      AppMethodBeat.i(118758);
      d.g.b.p.h(paramdkc, "timeLine");
      p.b localb = new p.b();
      HashMap localHashMap = new HashMap();
      localb.VY("StoryObject");
      localb.VY("id");
      if ((paramdkc.Id == null) || (paramdkc.Id.equals(""))) {
        localb.setText("0");
      }
      String str;
      for (;;)
      {
        localb.VZ("id");
        if (paramdkc.nDo != null)
        {
          localb.VY("username");
          localb.ac(paramdkc.nDo);
          localb.VZ("username");
        }
        localb.VY("createTime");
        localb.ac(String.valueOf(paramdkc.CreateTime));
        localb.VZ("createTime");
        localb.VY("scope");
        localb.setText(paramdkc.HyP);
        localb.VZ("scope");
        localb.VY("featured");
        localb.setText(paramdkc.HyQ);
        localb.VZ("featured");
        localb.VY("report");
        localb.VY("publish_obj_id");
        str = paramdkc.HyO;
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        localb.ac((String)localObject);
        localb.VZ("publish_obj_id");
        ad.i(p.access$getTAG$cp(), "report ".concat(String.valueOf(paramdjk)));
        if (paramdjk == null) {
          break label578;
        }
        localb.VY("music");
        if (paramdjk.Hyn)
        {
          localb.VY("req_id");
          localb.ac(String.valueOf(paramdjk.Hym));
          localb.VZ("req_id");
          localb.VY("id");
          localb.setText(paramdjk.xyZ);
          localb.VZ("id");
          localb.VY("index");
          localb.setText(paramdjk.GdN);
          localb.VZ("index");
        }
        localb.VZ("music");
        localb.VY("emojiList");
        localObject = paramdjk.Hyo;
        d.g.b.p.g(localObject, "editor.emojiMd5");
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          str = (String)((Iterator)localObject).next();
          localb.VY("emoji");
          d.g.b.p.g(str, "it");
          localb.ac(str);
          localb.VZ("emoji");
        }
        localb.setText(paramdkc.Id);
      }
      localb.VZ("emojiList");
      localb.VY("wordList");
      Object localObject = paramdjk.Hyp;
      d.g.b.p.g(localObject, "editor.wordText");
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        str = (String)((Iterator)localObject).next();
        localb.VY("word");
        d.g.b.p.g(str, "it");
        localb.ac(str);
        localb.VZ("word");
      }
      localb.VZ("wordList");
      localb.VY("tip");
      localObject = paramdjk.COu;
      paramdjk = (djk)localObject;
      if (localObject == null) {
        paramdjk = "";
      }
      localb.ac(paramdjk);
      localb.VZ("tip");
      label578:
      localb.VZ("report");
      localb.VY("ContentObject");
      localb.VY("title");
      localb.ac(azC(paramdkc.HyN.Title));
      localb.VZ("title");
      if (paramdkc.HyN.GaQ.size() > 0)
      {
        localb.VY("mediaList");
        paramdkc = paramdkc.HyN.GaQ.iterator();
        if (paramdkc.hasNext())
        {
          paramdjk = (djl)paramdkc.next();
          localb.VY("media");
          localb.VY("id");
          localObject = paramdjk.Id;
          d.g.b.p.g(localObject, "media.Id");
          if (d.g.b.p.i(azD((String)localObject), "")) {
            localb.ac("0");
          }
          for (;;)
          {
            localb.VZ("id");
            localb.VY("type");
            localb.ac(String.valueOf(paramdjk.nEf));
            localb.VZ("type");
            localb.VY("duration");
            float f = paramdjk.Hyq;
            localb.nxl.append(f);
            localb.VZ("duration");
            localHashMap.clear();
            ((Map)localHashMap).put("type", String.valueOf(paramdjk.GEe));
            if (!bt.isNullOrNil(paramdjk.md5)) {
              ((Map)localHashMap).put("md5", paramdjk.md5);
            }
            if (!bt.isNullOrNil(paramdjk.GTd)) {
              ((Map)localHashMap).put("videomd5", paramdjk.GTd);
            }
            localb.r("url", (Map)localHashMap);
            localb.ac(azC(paramdjk.Url));
            localb.VZ("url");
            if ((paramdjk.GSI != null) && (!paramdjk.GSI.equals("")))
            {
              localHashMap.clear();
              ((Map)localHashMap).put("type", String.valueOf(paramdjk.GSJ));
              localb.r("thumb", (Map)localHashMap);
              localb.ac(azC(paramdjk.GSI));
              localb.VZ("thumb");
            }
            if (paramdjk.subType > 0)
            {
              localb.VY("subType");
              localb.ac(String.valueOf(paramdjk.subType));
              localb.VZ("subType");
            }
            localb.VZ("media");
            break;
            localObject = paramdjk.Id;
            d.g.b.p.g(localObject, "media.Id");
            localb.ac(azD((String)localObject));
          }
        }
        localb.VZ("mediaList");
      }
      localb.VZ("ContentObject");
      localb.VZ("StoryObject");
      paramdkc = localb.nxl.toString();
      d.g.b.p.g(paramdkc, "sb.toString()");
      ad.d(p.access$getTAG$cp(), "xmlContent: ".concat(String.valueOf(paramdkc)));
      if (bw.M(paramdkc, "StoryObject") == null)
      {
        ad.e(p.access$getTAG$cp(), "xml is error");
        AppMethodBeat.o(118758);
        return "";
      }
      AppMethodBeat.o(118758);
      return paramdkc;
    }
    
    private static String azC(String paramString)
    {
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      return str;
    }
    
    private static String azD(String paramString)
    {
      AppMethodBeat.i(118759);
      d.g.b.p.h(paramString, "s");
      if (bt.isNullOrNil(paramString))
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
      d.g.b.p.h(paramString, "str");
      paramString = (CharSequence)paramString;
      boolean bool = new k("\\d*").aC(paramString);
      AppMethodBeat.o(118760);
      return bool;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/model/StoryTimelineConvert$pullXml;", "", "()V", "sb", "Ljava/lang/StringBuffer;", "getSb", "()Ljava/lang/StringBuffer;", "setSb", "(Ljava/lang/StringBuffer;)V", "xml", "", "getXml", "()Ljava/lang/String;", "addTag", "", "tag", "value", "", "emptyTag", "endTag", "setText", "", "startTag", "values", "", "text", "plugin-story_release"})
  public static final class b
  {
    StringBuffer nxl;
    
    public b()
    {
      AppMethodBeat.i(118767);
      this.nxl = new StringBuffer();
      AppMethodBeat.o(118767);
    }
    
    public final void VY(String paramString)
    {
      AppMethodBeat.i(118761);
      d.g.b.p.h(paramString, "tag");
      this.nxl.append("<" + paramString + '>');
      AppMethodBeat.o(118761);
    }
    
    public final void VZ(String paramString)
    {
      AppMethodBeat.i(118762);
      d.g.b.p.h(paramString, "tag");
      this.nxl.append("</" + paramString + '>');
      AppMethodBeat.o(118762);
    }
    
    public final void ac(String paramString)
    {
      AppMethodBeat.i(118763);
      d.g.b.p.h(paramString, "value");
      setText(paramString);
      AppMethodBeat.o(118763);
    }
    
    public final void r(String paramString, Map<String, String> paramMap)
    {
      AppMethodBeat.i(118766);
      d.g.b.p.h(paramString, "tag");
      d.g.b.p.h(paramMap, "values");
      this.nxl.append("<".concat(String.valueOf(paramString)));
      paramString = paramMap.keySet().iterator();
      while (paramString.hasNext())
      {
        String str1 = (String)paramString.next();
        String str2 = (String)paramMap.get(str1);
        this.nxl.append(" " + str1 + "=\"" + str2 + "\" ");
      }
      this.nxl.append(">");
      paramMap.clear();
      AppMethodBeat.o(118766);
    }
    
    public final void setText(int paramInt)
    {
      AppMethodBeat.i(118765);
      this.nxl.append(paramInt);
      AppMethodBeat.o(118765);
    }
    
    public final void setText(String paramString)
    {
      AppMethodBeat.i(118764);
      d.g.b.p.h(paramString, "value");
      if (bt.isNullOrNil(paramString))
      {
        AppMethodBeat.o(118764);
        return;
      }
      CharSequence localCharSequence = (CharSequence)paramString;
      p.a locala = p.AKr;
      if (n.a(localCharSequence, (CharSequence)p.eim(), false))
      {
        this.nxl.append("<![CDATA[" + bt.aRc(paramString) + "]]>");
        AppMethodBeat.o(118764);
        return;
      }
      this.nxl.append("<![CDATA[" + paramString + "]]>");
      AppMethodBeat.o(118764);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.p
 * JD-Core Version:    0.7.0.1
 */