package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.edk;
import com.tencent.mm.protocal.protobuf.eds;
import com.tencent.mm.protocal.protobuf.edt;
import com.tencent.mm.protocal.protobuf.edu;
import com.tencent.mm.protocal.protobuf.eek;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.l;
import kotlin.n.k;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/StoryTimelineConvert;", "", "()V", "Companion", "pullXml", "plugin-story_release"})
public final class p
{
  public static final a FmN;
  private static String INVALID_TAG;
  private static final String TAG = "MicroMsg.StoryTimelineConvert";
  
  static
  {
    AppMethodBeat.i(118768);
    FmN = new a((byte)0);
    TAG = "MicroMsg.StoryTimelineConvert";
    INVALID_TAG = "]]>";
    AppMethodBeat.o(118768);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/StoryTimelineConvert$Companion;", "", "()V", "INVALID_TAG", "", "getINVALID_TAG", "()Ljava/lang/String;", "setINVALID_TAG", "(Ljava/lang/String;)V", "TAG", "filterId", "s", "filterNull", "isNumeric", "", "str", "pullTimeLineXml", "timeLine", "Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "postInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaPostInfo;", "plugin-story_release"})
  public static final class a
  {
    public static String a(eek parameek, edu paramedu)
    {
      AppMethodBeat.i(222908);
      kotlin.g.b.p.h(parameek, "timeLine");
      p.b localb;
      HashMap localHashMap;
      if (paramedu != null)
      {
        localObject1 = paramedu.Nef;
        localb = new p.b();
        localHashMap = new HashMap();
        localb.startTag("StoryObject");
        localb.startTag("id");
        if ((parameek.Id != null) && (!parameek.Id.equals(""))) {
          break label449;
        }
        localb.setText("0");
      }
      String str;
      for (;;)
      {
        localb.endTag("id");
        if (parameek.UserName != null)
        {
          localb.startTag("username");
          localb.text(parameek.UserName);
          localb.endTag("username");
        }
        localb.startTag("createTime");
        localb.text(String.valueOf(parameek.CreateTime));
        localb.endTag("createTime");
        localb.startTag("scope");
        localb.setText(parameek.NeD);
        localb.endTag("scope");
        localb.startTag("featured");
        localb.setText(parameek.NeE);
        localb.endTag("featured");
        localb.startTag("report");
        localb.startTag("publish_obj_id");
        str = parameek.NeC;
        localObject2 = str;
        if (str == null) {
          localObject2 = "";
        }
        localb.text((String)localObject2);
        localb.endTag("publish_obj_id");
        Log.i(p.access$getTAG$cp(), "report ".concat(String.valueOf(localObject1)));
        if (localObject1 == null) {
          break label610;
        }
        localb.startTag("music");
        if (((eds)localObject1).Nea)
        {
          localb.startTag("req_id");
          localb.text(String.valueOf(((eds)localObject1).NdZ));
          localb.endTag("req_id");
          localb.startTag("id");
          localb.setText(((eds)localObject1).BOX);
          localb.endTag("id");
          localb.startTag("index");
          localb.setText(((eds)localObject1).Lsa);
          localb.endTag("index");
        }
        localb.endTag("music");
        localb.startTag("emojiList");
        localObject2 = ((eds)localObject1).Neb;
        kotlin.g.b.p.g(localObject2, "editor.emojiMd5");
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          str = (String)((Iterator)localObject2).next();
          localb.startTag("emoji");
          kotlin.g.b.p.g(str, "it");
          localb.text(str);
          localb.endTag("emoji");
        }
        localObject1 = null;
        break;
        label449:
        localb.setText(parameek.Id);
      }
      localb.endTag("emojiList");
      localb.startTag("wordList");
      Object localObject2 = ((eds)localObject1).Nec;
      kotlin.g.b.p.g(localObject2, "editor.wordText");
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        str = (String)((Iterator)localObject2).next();
        localb.startTag("word");
        kotlin.g.b.p.g(str, "it");
        localb.text(str);
        localb.endTag("word");
      }
      localb.endTag("wordList");
      localb.startTag("tip");
      localObject2 = ((eds)localObject1).HIK;
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localb.text((String)localObject1);
      localb.endTag("tip");
      label610:
      localb.endTag("report");
      localb.startTag("ContentObject");
      localb.startTag("title");
      localb.text(filterNull(parameek.NeB.Title));
      localb.endTag("title");
      if (parameek.NeB.LoV.size() > 0)
      {
        localb.startTag("mediaList");
        localObject1 = parameek.NeB.LoV.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          parameek = (edt)((Iterator)localObject1).next();
          localb.startTag("media");
          localb.startTag("id");
          localObject2 = parameek.Id;
          kotlin.g.b.p.g(localObject2, "media.Id");
          if (kotlin.g.b.p.j(filterId((String)localObject2), ""))
          {
            localb.text("0");
            localb.endTag("id");
            localb.startTag("type");
            localb.text(String.valueOf(parameek.oUv));
            localb.endTag("type");
            localb.startTag("duration");
            float f = parameek.Ned;
            localb.sb.append(f);
            localb.endTag("duration");
            localHashMap.clear();
            ((Map)localHashMap).put("type", String.valueOf(parameek.Mcw));
            if (!Util.isNullOrNil(parameek.md5)) {
              ((Map)localHashMap).put("md5", parameek.md5);
            }
            if (!Util.isNullOrNil(parameek.MsS)) {
              ((Map)localHashMap).put("videomd5", parameek.MsS);
            }
            localb.startTag("url", (Map)localHashMap);
            localb.text(filterNull(parameek.Url));
            localb.endTag("url");
            if ((parameek.Msz != null) && (!parameek.Msz.equals("")))
            {
              localHashMap.clear();
              ((Map)localHashMap).put("type", String.valueOf(parameek.MsA));
              localb.startTag("thumb", (Map)localHashMap);
              localb.text(filterNull(parameek.Msz));
              localb.endTag("thumb");
            }
            if (parameek.subType > 0)
            {
              localb.startTag("subType");
              localb.text(String.valueOf(parameek.subType));
              localb.endTag("subType");
            }
            if (paramedu == null) {
              break label1210;
            }
            parameek = paramedu.Nei;
          }
          for (;;)
          {
            label1081:
            if (!Util.isNullOrNil((List)parameek))
            {
              localb.startTag("SrcPicMD5List");
              if (paramedu != null)
              {
                parameek = paramedu.Nei;
                if (parameek != null)
                {
                  parameek = ((Iterable)parameek).iterator();
                  for (;;)
                  {
                    if (parameek.hasNext())
                    {
                      localObject2 = (String)parameek.next();
                      if (!Util.isNullOrNil((String)localObject2))
                      {
                        localb.startTag("value");
                        kotlin.g.b.p.g(localObject2, "it");
                        localb.text((String)localObject2);
                        localb.endTag("value");
                        continue;
                        localObject2 = parameek.Id;
                        kotlin.g.b.p.g(localObject2, "media.Id");
                        localb.text(filterId((String)localObject2));
                        break;
                        label1210:
                        parameek = null;
                        break label1081;
                      }
                    }
                  }
                }
              }
              localb.endTag("SrcPicMD5List");
            }
          }
          localb.endTag("media");
        }
        localb.endTag("mediaList");
      }
      localb.endTag("ContentObject");
      localb.endTag("StoryObject");
      parameek = localb.sb.toString();
      kotlin.g.b.p.g(parameek, "sb.toString()");
      Log.d(p.access$getTAG$cp(), "xmlContent: ".concat(String.valueOf(parameek)));
      if (XmlParser.parseXml(parameek, "StoryObject", null) == null)
      {
        Log.e(p.access$getTAG$cp(), "xml is error");
        AppMethodBeat.o(222908);
        return "";
      }
      AppMethodBeat.o(222908);
      return parameek;
    }
    
    private static String filterId(String paramString)
    {
      AppMethodBeat.i(118759);
      kotlin.g.b.p.h(paramString, "s");
      if (Util.isNullOrNil(paramString))
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
    
    private static String filterNull(String paramString)
    {
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      return str;
    }
    
    private static boolean isNumeric(String paramString)
    {
      AppMethodBeat.i(118760);
      kotlin.g.b.p.h(paramString, "str");
      paramString = (CharSequence)paramString;
      boolean bool = new k("\\d*").aJ(paramString);
      AppMethodBeat.o(118760);
      return bool;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/StoryTimelineConvert$pullXml;", "", "()V", "sb", "Ljava/lang/StringBuffer;", "getSb", "()Ljava/lang/StringBuffer;", "setSb", "(Ljava/lang/StringBuffer;)V", "xml", "", "getXml", "()Ljava/lang/String;", "addTag", "", "tag", "value", "", "emptyTag", "endTag", "setText", "", "startTag", "values", "", "text", "plugin-story_release"})
  public static final class b
  {
    StringBuffer sb;
    
    public b()
    {
      AppMethodBeat.i(118767);
      this.sb = new StringBuffer();
      AppMethodBeat.o(118767);
    }
    
    public final void endTag(String paramString)
    {
      AppMethodBeat.i(118762);
      kotlin.g.b.p.h(paramString, "tag");
      this.sb.append("</" + paramString + '>');
      AppMethodBeat.o(118762);
    }
    
    public final void setText(int paramInt)
    {
      AppMethodBeat.i(118765);
      this.sb.append(paramInt);
      AppMethodBeat.o(118765);
    }
    
    public final void setText(String paramString)
    {
      AppMethodBeat.i(118764);
      kotlin.g.b.p.h(paramString, "value");
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(118764);
        return;
      }
      CharSequence localCharSequence = (CharSequence)paramString;
      p.a locala = p.FmN;
      if (n.a(localCharSequence, (CharSequence)p.fow(), false))
      {
        this.sb.append("<![CDATA[" + Util.escapeStringForXml(paramString) + "]]>");
        AppMethodBeat.o(118764);
        return;
      }
      this.sb.append("<![CDATA[" + paramString + "]]>");
      AppMethodBeat.o(118764);
    }
    
    public final void startTag(String paramString)
    {
      AppMethodBeat.i(118761);
      kotlin.g.b.p.h(paramString, "tag");
      this.sb.append("<" + paramString + '>');
      AppMethodBeat.o(118761);
    }
    
    public final void startTag(String paramString, Map<String, String> paramMap)
    {
      AppMethodBeat.i(118766);
      kotlin.g.b.p.h(paramString, "tag");
      kotlin.g.b.p.h(paramMap, "values");
      this.sb.append("<".concat(String.valueOf(paramString)));
      paramString = paramMap.keySet().iterator();
      while (paramString.hasNext())
      {
        String str1 = (String)paramString.next();
        String str2 = (String)paramMap.get(str1);
        this.sb.append(" " + str1 + "=\"" + str2 + "\" ");
      }
      this.sb.append(">");
      paramMap.clear();
      AppMethodBeat.o(118766);
    }
    
    public final void text(String paramString)
    {
      AppMethodBeat.i(118763);
      kotlin.g.b.p.h(paramString, "value");
      setText(paramString);
      AppMethodBeat.o(118763);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.p
 * JD-Core Version:    0.7.0.1
 */