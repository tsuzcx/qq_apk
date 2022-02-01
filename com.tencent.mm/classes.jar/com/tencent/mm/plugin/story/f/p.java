package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cyd;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.protocal.protobuf.cym;
import com.tencent.mm.protocal.protobuf.czd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import d.l;
import d.n.n;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/model/StoryTimelineConvert;", "", "()V", "Companion", "pullXml", "plugin-story_release"})
public final class p
{
  private static final String TAG = "MicroMsg.StoryTimelineConvert";
  private static String muL;
  public static final a yfx;
  
  static
  {
    AppMethodBeat.i(118768);
    yfx = new a((byte)0);
    TAG = "MicroMsg.StoryTimelineConvert";
    muL = "]]>";
    AppMethodBeat.o(118768);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/model/StoryTimelineConvert$Companion;", "", "()V", "INVALID_TAG", "", "getINVALID_TAG", "()Ljava/lang/String;", "setINVALID_TAG", "(Ljava/lang/String;)V", "TAG", "filterId", "s", "filterNull", "isNumeric", "", "str", "pullTimeLineXml", "timeLine", "Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "editor", "Lcom/tencent/mm/protocal/protobuf/StoryMediaEditorInfo;", "plugin-story_release"})
  public static final class a
  {
    public static String a(czd paramczd, cyl paramcyl)
    {
      AppMethodBeat.i(118758);
      d.g.b.k.h(paramczd, "timeLine");
      p.b localb = new p.b();
      HashMap localHashMap = new HashMap();
      localb.Oq("StoryObject");
      localb.Oq("id");
      if ((paramczd.Id == null) || (paramczd.Id.equals(""))) {
        localb.setText("0");
      }
      String str;
      for (;;)
      {
        localb.Or("id");
        if (paramczd.mAQ != null)
        {
          localb.Oq("username");
          localb.arz(paramczd.mAQ);
          localb.Or("username");
        }
        localb.Oq("createTime");
        localb.arz(String.valueOf(paramczd.CreateTime));
        localb.Or("createTime");
        localb.Oq("scope");
        localb.setText(paramczd.Erc);
        localb.Or("scope");
        localb.Oq("featured");
        localb.setText(paramczd.Erd);
        localb.Or("featured");
        localb.Oq("report");
        localb.Oq("publish_obj_id");
        str = paramczd.Erb;
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        localb.arz((String)localObject);
        localb.Or("publish_obj_id");
        ad.i(p.access$getTAG$cp(), "report ".concat(String.valueOf(paramcyl)));
        if (paramcyl == null) {
          break label578;
        }
        localb.Oq("music");
        if (paramcyl.EqA)
        {
          localb.Oq("req_id");
          localb.arz(String.valueOf(paramcyl.Eqz));
          localb.Or("req_id");
          localb.Oq("id");
          localb.setText(paramcyl.viz);
          localb.Or("id");
          localb.Oq("index");
          localb.setText(paramcyl.Ddh);
          localb.Or("index");
        }
        localb.Or("music");
        localb.Oq("emojiList");
        localObject = paramcyl.EqB;
        d.g.b.k.g(localObject, "editor.emojiMd5");
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          str = (String)((Iterator)localObject).next();
          localb.Oq("emoji");
          d.g.b.k.g(str, "it");
          localb.arz(str);
          localb.Or("emoji");
        }
        localb.setText(paramczd.Id);
      }
      localb.Or("emojiList");
      localb.Oq("wordList");
      Object localObject = paramcyl.EqC;
      d.g.b.k.g(localObject, "editor.wordText");
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        str = (String)((Iterator)localObject).next();
        localb.Oq("word");
        d.g.b.k.g(str, "it");
        localb.arz(str);
        localb.Or("word");
      }
      localb.Or("wordList");
      localb.Oq("tip");
      localObject = paramcyl.zVL;
      paramcyl = (cyl)localObject;
      if (localObject == null) {
        paramcyl = "";
      }
      localb.arz(paramcyl);
      localb.Or("tip");
      label578:
      localb.Or("report");
      localb.Oq("ContentObject");
      localb.Oq("title");
      localb.arz(apk(paramczd.Era.Title));
      localb.Or("title");
      if (paramczd.Era.DaC.size() > 0)
      {
        localb.Oq("mediaList");
        paramczd = paramczd.Era.DaC.iterator();
        if (paramczd.hasNext())
        {
          paramcyl = (cym)paramczd.next();
          localb.Oq("media");
          localb.Oq("id");
          localObject = paramcyl.Id;
          d.g.b.k.g(localObject, "media.Id");
          if (d.g.b.k.g(apl((String)localObject), "")) {
            localb.arz("0");
          }
          for (;;)
          {
            localb.Or("id");
            localb.Oq("type");
            localb.arz(String.valueOf(paramcyl.mBH));
            localb.Or("type");
            localb.Oq("duration");
            float f = paramcyl.EqD;
            localb.muN.append(f);
            localb.Or("duration");
            localHashMap.clear();
            ((Map)localHashMap).put("type", String.valueOf(paramcyl.Dzl));
            if (!bt.isNullOrNil(paramcyl.md5)) {
              ((Map)localHashMap).put("md5", paramcyl.md5);
            }
            if (!bt.isNullOrNil(paramcyl.DNl)) {
              ((Map)localHashMap).put("videomd5", paramcyl.DNl);
            }
            localb.p("url", (Map)localHashMap);
            localb.arz(apk(paramcyl.Url));
            localb.Or("url");
            if ((paramcyl.DMQ != null) && (!paramcyl.DMQ.equals("")))
            {
              localHashMap.clear();
              ((Map)localHashMap).put("type", String.valueOf(paramcyl.DMR));
              localb.p("thumb", (Map)localHashMap);
              localb.arz(apk(paramcyl.DMQ));
              localb.Or("thumb");
            }
            if (paramcyl.subType > 0)
            {
              localb.Oq("subType");
              localb.arz(String.valueOf(paramcyl.subType));
              localb.Or("subType");
            }
            localb.Or("media");
            break;
            localObject = paramcyl.Id;
            d.g.b.k.g(localObject, "media.Id");
            localb.arz(apl((String)localObject));
          }
        }
        localb.Or("mediaList");
      }
      localb.Or("ContentObject");
      localb.Or("StoryObject");
      paramczd = localb.muN.toString();
      d.g.b.k.g(paramczd, "sb.toString()");
      ad.d(p.access$getTAG$cp(), "xmlContent: ".concat(String.valueOf(paramczd)));
      if (bw.K(paramczd, "StoryObject") == null)
      {
        ad.e(p.access$getTAG$cp(), "xml is error");
        AppMethodBeat.o(118758);
        return "";
      }
      AppMethodBeat.o(118758);
      return paramczd;
    }
    
    private static String apk(String paramString)
    {
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      return str;
    }
    
    private static String apl(String paramString)
    {
      AppMethodBeat.i(118759);
      d.g.b.k.h(paramString, "s");
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
      d.g.b.k.h(paramString, "str");
      paramString = (CharSequence)paramString;
      boolean bool = new d.n.k("\\d*").aA(paramString);
      AppMethodBeat.o(118760);
      return bool;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/model/StoryTimelineConvert$pullXml;", "", "()V", "sb", "Ljava/lang/StringBuffer;", "getSb", "()Ljava/lang/StringBuffer;", "setSb", "(Ljava/lang/StringBuffer;)V", "xml", "", "getXml", "()Ljava/lang/String;", "addTag", "", "tag", "value", "", "emptyTag", "endTag", "setText", "", "startTag", "values", "", "text", "plugin-story_release"})
  public static final class b
  {
    StringBuffer muN;
    
    public b()
    {
      AppMethodBeat.i(118767);
      this.muN = new StringBuffer();
      AppMethodBeat.o(118767);
    }
    
    public final void Oq(String paramString)
    {
      AppMethodBeat.i(118761);
      d.g.b.k.h(paramString, "tag");
      this.muN.append("<" + paramString + '>');
      AppMethodBeat.o(118761);
    }
    
    public final void Or(String paramString)
    {
      AppMethodBeat.i(118762);
      d.g.b.k.h(paramString, "tag");
      this.muN.append("</" + paramString + '>');
      AppMethodBeat.o(118762);
    }
    
    public final void arz(String paramString)
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
      this.muN.append("<".concat(String.valueOf(paramString)));
      paramString = paramMap.keySet().iterator();
      while (paramString.hasNext())
      {
        String str1 = (String)paramString.next();
        String str2 = (String)paramMap.get(str1);
        this.muN.append(" " + str1 + "=\"" + str2 + "\" ");
      }
      this.muN.append(">");
      paramMap.clear();
      AppMethodBeat.o(118766);
    }
    
    public final void setText(int paramInt)
    {
      AppMethodBeat.i(118765);
      this.muN.append(paramInt);
      AppMethodBeat.o(118765);
    }
    
    public final void setText(String paramString)
    {
      AppMethodBeat.i(118764);
      d.g.b.k.h(paramString, "value");
      if (bt.isNullOrNil(paramString))
      {
        AppMethodBeat.o(118764);
        return;
      }
      CharSequence localCharSequence = (CharSequence)paramString;
      p.a locala = p.yfx;
      if (n.a(localCharSequence, (CharSequence)p.dHw(), false))
      {
        this.muN.append("<![CDATA[" + bt.aGf(paramString) + "]]>");
        AppMethodBeat.o(118764);
        return;
      }
      this.muN.append("<![CDATA[" + paramString + "]]>");
      AppMethodBeat.o(118764);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.p
 * JD-Core Version:    0.7.0.1
 */