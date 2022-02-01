package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class EasyXml
{
  public static String INVALID_TAG = "]]>";
  String mprevTag;
  StringBuffer sb;
  
  public EasyXml()
  {
    AppMethodBeat.i(157525);
    this.mprevTag = "";
    this.sb = new StringBuffer();
    AppMethodBeat.o(157525);
  }
  
  public EasyXml(String paramString)
  {
    AppMethodBeat.i(157526);
    this.mprevTag = "";
    this.sb = new StringBuffer();
    this.mprevTag = paramString;
    startTag(this.mprevTag);
    AppMethodBeat.o(157526);
  }
  
  public static String filterId(String paramString)
  {
    AppMethodBeat.i(230281);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(230281);
      return "";
    }
    if (isNumeric(paramString))
    {
      AppMethodBeat.o(230281);
      return paramString;
    }
    AppMethodBeat.o(230281);
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
  
  public static boolean isNumeric(String paramString)
  {
    AppMethodBeat.i(230280);
    if (paramString.matches("\\d*"))
    {
      AppMethodBeat.o(230280);
      return true;
    }
    AppMethodBeat.o(230280);
    return false;
  }
  
  public void addTag(String paramString, int paramInt)
  {
    AppMethodBeat.i(230285);
    startTag(paramString);
    setText(paramInt);
    endTag(paramString);
    AppMethodBeat.o(230285);
  }
  
  public void addTag(String paramString1, String paramString2)
  {
    AppMethodBeat.i(157530);
    startTag(paramString1);
    setText(paramString2);
    endTag(paramString1);
    AppMethodBeat.o(157530);
  }
  
  public void endTag(String paramString)
  {
    AppMethodBeat.i(157528);
    this.sb.append("</" + paramString + ">");
    AppMethodBeat.o(157528);
  }
  
  public String getXml()
  {
    AppMethodBeat.i(230287);
    if (!Util.isNullOrNil(this.mprevTag))
    {
      endTag(this.mprevTag);
      this.mprevTag = "";
    }
    String str = this.sb.toString();
    AppMethodBeat.o(230287);
    return str;
  }
  
  public void setText(int paramInt)
  {
    AppMethodBeat.i(230284);
    this.sb.append(paramInt);
    AppMethodBeat.o(230284);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(157529);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(157529);
      return;
    }
    if (paramString.contains(INVALID_TAG))
    {
      this.sb.append("<![CDATA[" + Util.escapeStringForXml(paramString) + "]]>");
      AppMethodBeat.o(157529);
      return;
    }
    this.sb.append("<![CDATA[" + paramString + "]]>");
    AppMethodBeat.o(157529);
  }
  
  public void startTag(String paramString)
  {
    AppMethodBeat.i(157527);
    this.sb.append("<" + paramString + ">");
    AppMethodBeat.o(157527);
  }
  
  public void startTag(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(230286);
    this.sb.append("<".concat(String.valueOf(paramString)));
    paramString = paramMap.keySet().iterator();
    while (paramString.hasNext())
    {
      String str1 = (String)paramString.next();
      String str2 = (String)paramMap.get(str1);
      this.sb.append(" " + str1 + " =  \"" + str2 + "\" ");
    }
    this.sb.append(">");
    paramMap.clear();
    AppMethodBeat.o(230286);
  }
  
  public void text(int paramInt)
  {
    AppMethodBeat.i(230283);
    setText(paramInt);
    AppMethodBeat.o(230283);
  }
  
  public void text(String paramString)
  {
    AppMethodBeat.i(230282);
    setText(paramString);
    AppMethodBeat.o(230282);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.EasyXml
 * JD-Core Version:    0.7.0.1
 */