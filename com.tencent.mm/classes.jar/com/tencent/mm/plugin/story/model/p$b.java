package com.tencent.mm.plugin.story.model;

import a.f.b.j;
import a.l;
import a.l.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/StoryTimelineConvert$pullXml;", "", "()V", "sb", "Ljava/lang/StringBuffer;", "getSb", "()Ljava/lang/StringBuffer;", "setSb", "(Ljava/lang/StringBuffer;)V", "xml", "", "getXml", "()Ljava/lang/String;", "addTag", "", "tag", "value", "", "emptyTag", "endTag", "setText", "", "startTag", "values", "", "text", "plugin-story_release"})
public final class p$b
{
  StringBuffer jDt;
  
  public p$b()
  {
    AppMethodBeat.i(109144);
    this.jDt = new StringBuffer();
    AppMethodBeat.o(109144);
  }
  
  public final void Gp(String paramString)
  {
    AppMethodBeat.i(109138);
    j.q(paramString, "tag");
    this.jDt.append("<" + paramString + '>');
    AppMethodBeat.o(109138);
  }
  
  public final void Gq(String paramString)
  {
    AppMethodBeat.i(109139);
    j.q(paramString, "tag");
    this.jDt.append("</" + paramString + '>');
    AppMethodBeat.o(109139);
  }
  
  public final void adh(String paramString)
  {
    AppMethodBeat.i(109140);
    j.q(paramString, "value");
    setText(paramString);
    AppMethodBeat.o(109140);
  }
  
  public final void n(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(109143);
    j.q(paramString, "tag");
    j.q(paramMap, "values");
    this.jDt.append("<".concat(String.valueOf(paramString)));
    paramString = paramMap.keySet().iterator();
    while (paramString.hasNext())
    {
      String str1 = (String)paramString.next();
      String str2 = (String)paramMap.get(str1);
      this.jDt.append(" " + str1 + "=\"" + str2 + "\" ");
    }
    this.jDt.append(">");
    paramMap.clear();
    AppMethodBeat.o(109143);
  }
  
  public final void setText(int paramInt)
  {
    AppMethodBeat.i(109142);
    this.jDt.append(paramInt);
    AppMethodBeat.o(109142);
  }
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(109141);
    j.q(paramString, "value");
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(109141);
      return;
    }
    CharSequence localCharSequence = (CharSequence)paramString;
    p.a locala = p.svy;
    if (m.a(localCharSequence, (CharSequence)p.cAX(), false))
    {
      this.jDt.append("<![CDATA[" + bo.apT(paramString) + "]]>");
      AppMethodBeat.o(109141);
      return;
    }
    this.jDt.append("<![CDATA[" + paramString + "]]>");
    AppMethodBeat.o(109141);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.p.b
 * JD-Core Version:    0.7.0.1
 */