package com.tencent.mm.plugin.sns.g;

import com.tencent.mm.sdk.platformtools.bk;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class j$a
{
  StringBuffer hJQ = new StringBuffer();
  
  public final void k(String paramString, Map<String, String> paramMap)
  {
    this.hJQ.append("<" + paramString);
    paramString = paramMap.keySet().iterator();
    while (paramString.hasNext())
    {
      String str1 = (String)paramString.next();
      String str2 = (String)paramMap.get(str1);
      this.hJQ.append(" " + str1 + "=\"" + str2 + "\" ");
    }
    this.hJQ.append(">");
    paramMap.clear();
  }
  
  public final void setText(String paramString)
  {
    if (bk.bl(paramString)) {
      return;
    }
    if (paramString.contains(j.hJN))
    {
      this.hJQ.append("<![CDATA[" + bk.ZP(paramString) + "]]>");
      return;
    }
    this.hJQ.append("<![CDATA[" + paramString + "]]>");
  }
  
  public final void xY(int paramInt)
  {
    this.hJQ.append(paramInt);
  }
  
  public final void xw(String paramString)
  {
    this.hJQ.append("<" + paramString + ">");
  }
  
  public final void xx(String paramString)
  {
    this.hJQ.append("</" + paramString + ">");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.g.j.a
 * JD-Core Version:    0.7.0.1
 */