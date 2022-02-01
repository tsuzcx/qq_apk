package com.tencent.mm.plugin.story.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.fij;
import com.tencent.mm.protocal.protobuf.fir;
import com.tencent.mm.protocal.protobuf.fis;
import com.tencent.mm.protocal.protobuf.fit;
import com.tencent.mm.protocal.protobuf.fjj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.k;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/model/StoryTimelineConvert;", "", "()V", "Companion", "pullXml", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
{
  private static String INVALID_TAG;
  public static final a Skt;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(118768);
    Skt = new a((byte)0);
    TAG = "MicroMsg.StoryTimelineConvert";
    INVALID_TAG = "]]>";
    AppMethodBeat.o(118768);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/model/StoryTimelineConvert$Companion;", "", "()V", "INVALID_TAG", "", "getINVALID_TAG", "()Ljava/lang/String;", "setINVALID_TAG", "(Ljava/lang/String;)V", "TAG", "filterId", "s", "filterNull", "isNumeric", "", "str", "pullTimeLineXml", "timeLine", "Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "postInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaPostInfo;", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static String a(fjj paramfjj, fit paramfit)
    {
      AppMethodBeat.i(367121);
      s.u(paramfjj, "timeLine");
      o.b localb;
      HashMap localHashMap;
      if (paramfit == null)
      {
        localObject1 = null;
        localb = new o.b();
        localHashMap = new HashMap();
        localb.startTag("StoryObject");
        localb.startTag("id");
        if ((paramfjj.Id != null) && (!paramfjj.Id.equals(""))) {
          break label438;
        }
        localb.setText("0");
      }
      String str;
      for (;;)
      {
        localb.endTag("id");
        if (paramfjj.UserName != null)
        {
          localb.startTag("username");
          localb.text(s.X(paramfjj.UserName, ""));
          localb.endTag("username");
        }
        localb.startTag("createTime");
        localb.text(String.valueOf(paramfjj.CreateTime));
        localb.endTag("createTime");
        localb.startTag("scope");
        localb.setText(paramfjj.abKb);
        localb.endTag("scope");
        localb.startTag("featured");
        localb.setText(paramfjj.abKc);
        localb.endTag("featured");
        localb.startTag("report");
        localb.startTag("publish_obj_id");
        str = paramfjj.abKa;
        localObject2 = str;
        if (str == null) {
          localObject2 = "";
        }
        localb.text((String)localObject2);
        localb.endTag("publish_obj_id");
        Log.i(o.access$getTAG$cp(), s.X("report ", localObject1));
        if (localObject1 == null) {
          break label591;
        }
        localb.startTag("music");
        if (((fir)localObject1).abJy)
        {
          localb.startTag("req_id");
          localb.text(String.valueOf(((fir)localObject1).abJx));
          localb.endTag("req_id");
          localb.startTag("id");
          localb.setText(((fir)localObject1).NID);
          localb.endTag("id");
          localb.startTag("index");
          localb.setText(((fir)localObject1).Ztm);
          localb.endTag("index");
        }
        localb.endTag("music");
        localb.startTag("emojiList");
        localObject2 = ((fir)localObject1).abJz;
        s.s(localObject2, "editor.emojiMd5");
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          str = (String)((Iterator)localObject2).next();
          localb.startTag("emoji");
          s.s(str, "it");
          localb.text(str);
          localb.endTag("emoji");
        }
        localObject1 = paramfit.abJD;
        break;
        label438:
        localb.setText(s.X(paramfjj.Id, ""));
      }
      localb.endTag("emojiList");
      localb.startTag("wordList");
      Object localObject2 = ((fir)localObject1).abJA;
      s.s(localObject2, "editor.wordText");
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        str = (String)((Iterator)localObject2).next();
        localb.startTag("word");
        s.s(str, "it");
        localb.text(str);
        localb.endTag("word");
      }
      localb.endTag("wordList");
      localb.startTag("tip");
      localObject2 = ((fir)localObject1).VpP;
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localb.text((String)localObject1);
      localb.endTag("tip");
      label591:
      localb.endTag("report");
      localb.startTag("ContentObject");
      localb.startTag("title");
      localb.text(filterNull(paramfjj.abJZ.hAP));
      localb.endTag("title");
      if (paramfjj.abJZ.Zpr.size() > 0)
      {
        localb.startTag("mediaList");
        localObject1 = paramfjj.abJZ.Zpr.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          paramfjj = (fis)((Iterator)localObject1).next();
          localb.startTag("media");
          localb.startTag("id");
          localObject2 = paramfjj.Id;
          s.s(localObject2, "media.Id");
          if (s.p(filterId((String)localObject2), ""))
          {
            localb.text("0");
            localb.endTag("id");
            localb.startTag("type");
            localb.text(String.valueOf(paramfjj.vhJ));
            localb.endTag("type");
            localb.startTag("duration");
            float f = paramfjj.abJB;
            localb.sb.append(f);
            localb.endTag("duration");
            localHashMap.clear();
            ((Map)localHashMap).put("type", String.valueOf(paramfjj.aazR));
            if (!Util.isNullOrNil(paramfjj.md5)) {
              ((Map)localHashMap).put("md5", s.X(paramfjj.md5, ""));
            }
            if (!Util.isNullOrNil(paramfjj.aaTE)) {
              ((Map)localHashMap).put("videomd5", s.X(paramfjj.aaTE, ""));
            }
            localb.startTag("url", (Map)localHashMap);
            localb.text(filterNull(paramfjj.Url));
            localb.endTag("url");
            if ((paramfjj.aaTl != null) && (!paramfjj.aaTl.equals("")))
            {
              localHashMap.clear();
              ((Map)localHashMap).put("type", String.valueOf(paramfjj.aaTm));
              localb.startTag("thumb", (Map)localHashMap);
              localb.text(filterNull(paramfjj.aaTl));
              localb.endTag("thumb");
            }
            if (paramfjj.subType > 0)
            {
              localb.startTag("subType");
              localb.text(String.valueOf(paramfjj.subType));
              localb.endTag("subType");
            }
            if (paramfit != null) {
              break label1169;
            }
            paramfjj = null;
          }
          label1169:
          for (;;)
          {
            label1041:
            if (!Util.isNullOrNil((List)paramfjj))
            {
              localb.startTag("SrcPicMD5List");
              if (paramfit != null)
              {
                paramfjj = paramfit.abJG;
                if (paramfjj != null)
                {
                  paramfjj = ((Iterable)paramfjj).iterator();
                  for (;;)
                  {
                    if (paramfjj.hasNext())
                    {
                      localObject2 = (String)paramfjj.next();
                      if (!Util.isNullOrNil((String)localObject2))
                      {
                        localb.startTag("value");
                        s.s(localObject2, "it");
                        localb.text((String)localObject2);
                        localb.endTag("value");
                        continue;
                        localObject2 = paramfjj.Id;
                        s.s(localObject2, "media.Id");
                        localb.text(filterId((String)localObject2));
                        break;
                        paramfjj = paramfit.abJG;
                        break label1041;
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
      paramfjj = localb.sb.toString();
      s.s(paramfjj, "sb.toString()");
      Log.d(o.access$getTAG$cp(), s.X("xmlContent: ", paramfjj));
      if (XmlParser.parseXml(paramfjj, "StoryObject", null) == null)
      {
        Log.e(o.access$getTAG$cp(), "xml is error");
        AppMethodBeat.o(367121);
        return "";
      }
      AppMethodBeat.o(367121);
      return paramfjj;
    }
    
    private static String filterId(String paramString)
    {
      AppMethodBeat.i(118759);
      s.u(paramString, "s");
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
      s.u(paramString, "str");
      paramString = (CharSequence)paramString;
      boolean bool = new k("\\d*").bm(paramString);
      AppMethodBeat.o(118760);
      return bool;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/model/StoryTimelineConvert$pullXml;", "", "()V", "sb", "Ljava/lang/StringBuffer;", "getSb", "()Ljava/lang/StringBuffer;", "setSb", "(Ljava/lang/StringBuffer;)V", "xml", "", "getXml", "()Ljava/lang/String;", "addTag", "", "tag", "value", "", "emptyTag", "endTag", "setText", "", "startTag", "values", "", "text", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
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
      s.u(paramString, "tag");
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
      s.u(paramString, "value");
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(118764);
        return;
      }
      CharSequence localCharSequence = (CharSequence)paramString;
      o.a locala = o.Skt;
      if (n.a(localCharSequence, (CharSequence)o.hwk(), false))
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
      s.u(paramString, "tag");
      this.sb.append("<" + paramString + '>');
      AppMethodBeat.o(118761);
    }
    
    public final void startTag(String paramString, Map<String, String> paramMap)
    {
      AppMethodBeat.i(118766);
      s.u(paramString, "tag");
      s.u(paramMap, "values");
      this.sb.append(s.X("<", paramString));
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
      s.u(paramString, "value");
      setText(paramString);
      AppMethodBeat.o(118763);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.o
 * JD-Core Version:    0.7.0.1
 */