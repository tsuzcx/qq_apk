package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Node;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public final class br
{
  private static ThreadLocal<XmlPullParser> yqX;
  
  static
  {
    AppMethodBeat.i(52443);
    yqX = new ThreadLocal();
    AppMethodBeat.o(52443);
  }
  
  public static Map<String, String> F(String paramString1, String paramString2)
  {
    AppMethodBeat.i(52441);
    if (paramString1 == null) {}
    for (int i = -1; i < 0; i = paramString1.indexOf("<".concat(String.valueOf(paramString2))))
    {
      ab.e("MicroMsg.SDK.XmlParser", "can not find the tag <%s>", new Object[] { paramString2 });
      AppMethodBeat.o(52441);
      return null;
    }
    String str = paramString1;
    if (i > 0) {
      str = paramString1.substring(i);
    }
    for (;;)
    {
      try
      {
        paramString2 = new a(str, paramString2);
        i = paramString2.yqY.getEventType();
        if (i == 1) {
          break label443;
        }
        i = paramString2.yqY.next();
        if (i == 2)
        {
          paramString2.yra.append('.').append(paramString2.yqY.getName());
          paramString1 = paramString2.yra.toString();
          int j = paramString1.hashCode();
          Integer localInteger = (Integer)paramString2.yrc.get(Integer.valueOf(j));
          if (localInteger != null)
          {
            localInteger = Integer.valueOf(localInteger.intValue() + 1);
            paramString2.yra.append(localInteger);
            paramString2.yrc.put(Integer.valueOf(j), localInteger);
            paramString1 = paramString1 + localInteger;
            paramString2.yrb.put(paramString1, "");
            j = 0;
            if (j < paramString2.yqY.getAttributeCount())
            {
              paramString2.yrb.put(paramString1 + ".$" + paramString2.yqY.getAttributeName(j), paramString2.yqY.getAttributeValue(j));
              j += 1;
              continue;
            }
          }
          else
          {
            paramString2.yrc.put(Integer.valueOf(j), Integer.valueOf(0));
            continue;
          }
          continue;
        }
      }
      catch (Exception paramString1)
      {
        ab.printErrStackTrace("MicroMsg.SDK.XmlParser", paramString1, "[ %s ]", new Object[] { str });
        AppMethodBeat.o(52441);
        return null;
      }
      if (i == 4)
      {
        paramString1 = paramString2.yqY.getText();
        if (paramString1 != null) {
          paramString2.yrb.put(paramString2.yra.toString(), paramString1);
        }
      }
      else if (i == 3)
      {
        paramString2.yra = paramString2.yra.delete(paramString2.yra.lastIndexOf("."), paramString2.yra.length());
        if (paramString2.yra.length() == 0)
        {
          label443:
          paramString1 = paramString2.yrb;
          AppMethodBeat.o(52441);
          return paramString1;
        }
      }
    }
  }
  
  public static String b(Node paramNode)
  {
    AppMethodBeat.i(52442);
    StringWriter localStringWriter = new StringWriter();
    try
    {
      Transformer localTransformer = TransformerFactory.newInstance().newTransformer();
      localTransformer.setOutputProperty("omit-xml-declaration", "yes");
      localTransformer.transform(new DOMSource(paramNode), new StreamResult(localStringWriter));
      paramNode = localStringWriter.toString();
      AppMethodBeat.o(52442);
      return paramNode;
    }
    catch (TransformerException paramNode)
    {
      for (;;)
      {
        ab.e("MicroMsg.SDK.XmlParser", "nodeToString: %s", new Object[] { paramNode.getMessage() });
      }
    }
  }
  
  static final class a
  {
    XmlPullParser yqY;
    private String yqZ;
    StringBuilder yra;
    Map<String, String> yrb;
    Map<Integer, Integer> yrc;
    
    public a(String paramString1, String paramString2)
    {
      AppMethodBeat.i(52440);
      this.yra = new StringBuilder();
      this.yqZ = paramString2;
      paramString2 = (XmlPullParser)br.dug().get();
      this.yqY = paramString2;
      if (paramString2 == null)
      {
        paramString2 = br.dug();
        XmlPullParser localXmlPullParser = XmlPullParserFactory.newInstance().newPullParser();
        this.yqY = localXmlPullParser;
        paramString2.set(localXmlPullParser);
      }
      this.yqY.setInput(new StringReader(paramString1));
      this.yrc = new HashMap();
      this.yrb = new HashMap();
      AppMethodBeat.o(52440);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.br
 * JD-Core Version:    0.7.0.1
 */