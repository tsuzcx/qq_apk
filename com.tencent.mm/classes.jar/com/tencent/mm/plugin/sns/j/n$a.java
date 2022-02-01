package com.tencent.mm.plugin.sns.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class n$a
{
  StringBuffer muN;
  
  n$a()
  {
    AppMethodBeat.i(96165);
    this.muN = new StringBuffer();
    AppMethodBeat.o(96165);
  }
  
  public final void Oq(String paramString)
  {
    AppMethodBeat.i(96166);
    this.muN.append("<" + paramString + ">");
    AppMethodBeat.o(96166);
  }
  
  public final void Or(String paramString)
  {
    AppMethodBeat.i(96167);
    this.muN.append("</" + paramString + ">");
    AppMethodBeat.o(96167);
  }
  
  public final void append(String paramString)
  {
    AppMethodBeat.i(163073);
    if (!bt.isNullOrNil(paramString)) {
      this.muN.append(paramString);
    }
    AppMethodBeat.o(163073);
  }
  
  public final void p(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(96170);
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
    AppMethodBeat.o(96170);
  }
  
  public final void setText(int paramInt)
  {
    AppMethodBeat.i(96169);
    this.muN.append(paramInt);
    AppMethodBeat.o(96169);
  }
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(96168);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(96168);
      return;
    }
    if (paramString.contains(n.muL))
    {
      this.muN.append("<![CDATA[" + bt.aGf(paramString) + "]]>");
      AppMethodBeat.o(96168);
      return;
    }
    this.muN.append("<![CDATA[" + paramString + "]]>");
    AppMethodBeat.o(96168);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.j.n.a
 * JD-Core Version:    0.7.0.1
 */