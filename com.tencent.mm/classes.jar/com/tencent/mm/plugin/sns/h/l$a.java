package com.tencent.mm.plugin.sns.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class l$a
{
  StringBuffer jDt;
  
  l$a()
  {
    AppMethodBeat.i(36834);
    this.jDt = new StringBuffer();
    AppMethodBeat.o(36834);
  }
  
  public final void Gp(String paramString)
  {
    AppMethodBeat.i(36835);
    this.jDt.append("<" + paramString + ">");
    AppMethodBeat.o(36835);
  }
  
  public final void Gq(String paramString)
  {
    AppMethodBeat.i(36836);
    this.jDt.append("</" + paramString + ">");
    AppMethodBeat.o(36836);
  }
  
  public final void n(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(36839);
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
    AppMethodBeat.o(36839);
  }
  
  public final void setText(int paramInt)
  {
    AppMethodBeat.i(36838);
    this.jDt.append(paramInt);
    AppMethodBeat.o(36838);
  }
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(36837);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(36837);
      return;
    }
    if (paramString.contains(l.jDr))
    {
      this.jDt.append("<![CDATA[" + bo.apT(paramString) + "]]>");
      AppMethodBeat.o(36837);
      return;
    }
    this.jDt.append("<![CDATA[" + paramString + "]]>");
    AppMethodBeat.o(36837);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.h.l.a
 * JD-Core Version:    0.7.0.1
 */