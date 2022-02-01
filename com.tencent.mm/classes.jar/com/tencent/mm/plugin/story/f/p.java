package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.djx;
import com.tencent.mm.protocal.protobuf.dkf;
import com.tencent.mm.protocal.protobuf.dkg;
import com.tencent.mm.protocal.protobuf.dkx;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import d.l;
import d.n.k;
import d.n.n;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/model/StoryTimelineConvert;", "", "()V", "Companion", "pullXml", "plugin-story_release"})
public final class p
{
  public static final a BbU;
  private static final String TAG = "MicroMsg.StoryTimelineConvert";
  private static String nCE;
  
  static
  {
    AppMethodBeat.i(118768);
    BbU = new a((byte)0);
    TAG = "MicroMsg.StoryTimelineConvert";
    nCE = "]]>";
    AppMethodBeat.o(118768);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/model/StoryTimelineConvert$Companion;", "", "()V", "INVALID_TAG", "", "getINVALID_TAG", "()Ljava/lang/String;", "setINVALID_TAG", "(Ljava/lang/String;)V", "TAG", "filterId", "s", "filterNull", "isNumeric", "", "str", "pullTimeLineXml", "timeLine", "Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "editor", "Lcom/tencent/mm/protocal/protobuf/StoryMediaEditorInfo;", "plugin-story_release"})
  public static final class a
  {
    public static String a(dkx paramdkx, dkf paramdkf)
    {
      AppMethodBeat.i(118758);
      d.g.b.p.h(paramdkx, "timeLine");
      p.b localb = new p.b();
      HashMap localHashMap = new HashMap();
      localb.WK("StoryObject");
      localb.WK("id");
      if ((paramdkx.Id == null) || (paramdkx.Id.equals(""))) {
        localb.setText("0");
      }
      String str;
      for (;;)
      {
        localb.WL("id");
        if (paramdkx.nIJ != null)
        {
          localb.WK("username");
          localb.ac(paramdkx.nIJ);
          localb.WL("username");
        }
        localb.WK("createTime");
        localb.ac(String.valueOf(paramdkx.CreateTime));
        localb.WL("createTime");
        localb.WK("scope");
        localb.setText(paramdkx.HSA);
        localb.WL("scope");
        localb.WK("featured");
        localb.setText(paramdkx.HSB);
        localb.WL("featured");
        localb.WK("report");
        localb.WK("publish_obj_id");
        str = paramdkx.HSz;
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        localb.ac((String)localObject);
        localb.WL("publish_obj_id");
        ae.i(p.access$getTAG$cp(), "report ".concat(String.valueOf(paramdkf)));
        if (paramdkf == null) {
          break label578;
        }
        localb.WK("music");
        if (paramdkf.HRY)
        {
          localb.WK("req_id");
          localb.ac(String.valueOf(paramdkf.HRX));
          localb.WL("req_id");
          localb.WK("id");
          localb.setText(paramdkf.xOV);
          localb.WL("id");
          localb.WK("index");
          localb.setText(paramdkf.Gwu);
          localb.WL("index");
        }
        localb.WL("music");
        localb.WK("emojiList");
        localObject = paramdkf.HRZ;
        d.g.b.p.g(localObject, "editor.emojiMd5");
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          str = (String)((Iterator)localObject).next();
          localb.WK("emoji");
          d.g.b.p.g(str, "it");
          localb.ac(str);
          localb.WL("emoji");
        }
        localb.setText(paramdkx.Id);
      }
      localb.WL("emojiList");
      localb.WK("wordList");
      Object localObject = paramdkf.HSa;
      d.g.b.p.g(localObject, "editor.wordText");
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        str = (String)((Iterator)localObject).next();
        localb.WK("word");
        d.g.b.p.g(str, "it");
        localb.ac(str);
        localb.WL("word");
      }
      localb.WL("wordList");
      localb.WK("tip");
      localObject = paramdkf.DcW;
      paramdkf = (dkf)localObject;
      if (localObject == null) {
        paramdkf = "";
      }
      localb.ac(paramdkf);
      localb.WL("tip");
      label578:
      localb.WL("report");
      localb.WK("ContentObject");
      localb.WK("title");
      localb.ac(aAT(paramdkx.HSy.Title));
      localb.WL("title");
      if (paramdkx.HSy.Gtx.size() > 0)
      {
        localb.WK("mediaList");
        paramdkx = paramdkx.HSy.Gtx.iterator();
        if (paramdkx.hasNext())
        {
          paramdkf = (dkg)paramdkx.next();
          localb.WK("media");
          localb.WK("id");
          localObject = paramdkf.Id;
          d.g.b.p.g(localObject, "media.Id");
          if (d.g.b.p.i(aAU((String)localObject), "")) {
            localb.ac("0");
          }
          for (;;)
          {
            localb.WL("id");
            localb.WK("type");
            localb.ac(String.valueOf(paramdkf.nJA));
            localb.WL("type");
            localb.WK("duration");
            float f = paramdkf.HSb;
            localb.nCG.append(f);
            localb.WL("duration");
            localHashMap.clear();
            ((Map)localHashMap).put("type", String.valueOf(paramdkf.GXH));
            if (!bu.isNullOrNil(paramdkf.md5)) {
              ((Map)localHashMap).put("md5", paramdkf.md5);
            }
            if (!bu.isNullOrNil(paramdkf.HmE)) {
              ((Map)localHashMap).put("videomd5", paramdkf.HmE);
            }
            localb.s("url", (Map)localHashMap);
            localb.ac(aAT(paramdkf.Url));
            localb.WL("url");
            if ((paramdkf.Hmj != null) && (!paramdkf.Hmj.equals("")))
            {
              localHashMap.clear();
              ((Map)localHashMap).put("type", String.valueOf(paramdkf.Hmk));
              localb.s("thumb", (Map)localHashMap);
              localb.ac(aAT(paramdkf.Hmj));
              localb.WL("thumb");
            }
            if (paramdkf.subType > 0)
            {
              localb.WK("subType");
              localb.ac(String.valueOf(paramdkf.subType));
              localb.WL("subType");
            }
            localb.WL("media");
            break;
            localObject = paramdkf.Id;
            d.g.b.p.g(localObject, "media.Id");
            localb.ac(aAU((String)localObject));
          }
        }
        localb.WL("mediaList");
      }
      localb.WL("ContentObject");
      localb.WL("StoryObject");
      paramdkx = localb.nCG.toString();
      d.g.b.p.g(paramdkx, "sb.toString()");
      ae.d(p.access$getTAG$cp(), "xmlContent: ".concat(String.valueOf(paramdkx)));
      if (bx.M(paramdkx, "StoryObject") == null)
      {
        ae.e(p.access$getTAG$cp(), "xml is error");
        AppMethodBeat.o(118758);
        return "";
      }
      AppMethodBeat.o(118758);
      return paramdkx;
    }
    
    private static String aAT(String paramString)
    {
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      return str;
    }
    
    private static String aAU(String paramString)
    {
      AppMethodBeat.i(118759);
      d.g.b.p.h(paramString, "s");
      if (bu.isNullOrNil(paramString))
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
      boolean bool = new k("\\d*").aB(paramString);
      AppMethodBeat.o(118760);
      return bool;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/model/StoryTimelineConvert$pullXml;", "", "()V", "sb", "Ljava/lang/StringBuffer;", "getSb", "()Ljava/lang/StringBuffer;", "setSb", "(Ljava/lang/StringBuffer;)V", "xml", "", "getXml", "()Ljava/lang/String;", "addTag", "", "tag", "value", "", "emptyTag", "endTag", "setText", "", "startTag", "values", "", "text", "plugin-story_release"})
  public static final class b
  {
    StringBuffer nCG;
    
    public b()
    {
      AppMethodBeat.i(118767);
      this.nCG = new StringBuffer();
      AppMethodBeat.o(118767);
    }
    
    public final void WK(String paramString)
    {
      AppMethodBeat.i(118761);
      d.g.b.p.h(paramString, "tag");
      this.nCG.append("<" + paramString + '>');
      AppMethodBeat.o(118761);
    }
    
    public final void WL(String paramString)
    {
      AppMethodBeat.i(118762);
      d.g.b.p.h(paramString, "tag");
      this.nCG.append("</" + paramString + '>');
      AppMethodBeat.o(118762);
    }
    
    public final void ac(String paramString)
    {
      AppMethodBeat.i(118763);
      d.g.b.p.h(paramString, "value");
      setText(paramString);
      AppMethodBeat.o(118763);
    }
    
    public final void s(String paramString, Map<String, String> paramMap)
    {
      AppMethodBeat.i(118766);
      d.g.b.p.h(paramString, "tag");
      d.g.b.p.h(paramMap, "values");
      this.nCG.append("<".concat(String.valueOf(paramString)));
      paramString = paramMap.keySet().iterator();
      while (paramString.hasNext())
      {
        String str1 = (String)paramString.next();
        String str2 = (String)paramMap.get(str1);
        this.nCG.append(" " + str1 + "=\"" + str2 + "\" ");
      }
      this.nCG.append(">");
      paramMap.clear();
      AppMethodBeat.o(118766);
    }
    
    public final void setText(int paramInt)
    {
      AppMethodBeat.i(118765);
      this.nCG.append(paramInt);
      AppMethodBeat.o(118765);
    }
    
    public final void setText(String paramString)
    {
      AppMethodBeat.i(118764);
      d.g.b.p.h(paramString, "value");
      if (bu.isNullOrNil(paramString))
      {
        AppMethodBeat.o(118764);
        return;
      }
      CharSequence localCharSequence = (CharSequence)paramString;
      p.a locala = p.BbU;
      if (n.a(localCharSequence, (CharSequence)p.elU(), false))
      {
        this.nCG.append("<![CDATA[" + bu.aSz(paramString) + "]]>");
        AppMethodBeat.o(118764);
        return;
      }
      this.nCG.append("<![CDATA[" + paramString + "]]>");
      AppMethodBeat.o(118764);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.p
 * JD-Core Version:    0.7.0.1
 */