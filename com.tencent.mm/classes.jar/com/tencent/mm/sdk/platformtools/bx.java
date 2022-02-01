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

public final class bx
{
  private static ThreadLocal<XmlPullParser> IAW;
  
  static
  {
    AppMethodBeat.i(158006);
    IAW = new ThreadLocal();
    AppMethodBeat.o(158006);
  }
  
  public static Map<String, String> M(String paramString1, String paramString2)
  {
    AppMethodBeat.i(158004);
    if (paramString1 == null) {}
    for (int i = -1; i < 0; i = paramString1.indexOf("<".concat(String.valueOf(paramString2))))
    {
      ae.e("MicroMsg.SDK.XmlParser", "can not find the tag <%s>", new Object[] { paramString2 });
      AppMethodBeat.o(158004);
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
        i = paramString2.IAX.getEventType();
        if (i == 1) {
          break label443;
        }
        i = paramString2.IAX.next();
        if (i == 2)
        {
          paramString2.IAZ.append('.').append(paramString2.IAX.getName());
          paramString1 = paramString2.IAZ.toString();
          int j = paramString1.hashCode();
          Integer localInteger = (Integer)paramString2.IBb.get(Integer.valueOf(j));
          if (localInteger != null)
          {
            localInteger = Integer.valueOf(localInteger.intValue() + 1);
            paramString2.IAZ.append(localInteger);
            paramString2.IBb.put(Integer.valueOf(j), localInteger);
            paramString1 = paramString1 + localInteger;
            paramString2.IBa.put(paramString1, "");
            j = 0;
            if (j < paramString2.IAX.getAttributeCount())
            {
              paramString2.IBa.put(paramString1 + ".$" + paramString2.IAX.getAttributeName(j), paramString2.IAX.getAttributeValue(j));
              j += 1;
              continue;
            }
          }
          else
          {
            paramString2.IBb.put(Integer.valueOf(j), Integer.valueOf(0));
            continue;
          }
          continue;
        }
      }
      catch (Exception paramString1)
      {
        ae.printErrStackTrace("MicroMsg.SDK.XmlParser", paramString1, "[ %s ]", new Object[] { str });
        AppMethodBeat.o(158004);
        return null;
      }
      if (i == 4)
      {
        paramString1 = paramString2.IAX.getText();
        if (paramString1 != null) {
          paramString2.IBa.put(paramString2.IAZ.toString(), paramString1);
        }
      }
      else if (i == 3)
      {
        paramString2.IAZ = paramString2.IAZ.delete(paramString2.IAZ.lastIndexOf("."), paramString2.IAZ.length());
        if (paramString2.IAZ.length() == 0)
        {
          label443:
          paramString1 = paramString2.IBa;
          AppMethodBeat.o(158004);
          return paramString1;
        }
      }
    }
  }
  
  public static String aSV(String paramString)
  {
    AppMethodBeat.i(168848);
    paramString = String.format("<![CDATA[%s]]>", new Object[] { paramString });
    AppMethodBeat.o(168848);
    return paramString;
  }
  
  public static String b(Node paramNode)
  {
    AppMethodBeat.i(158005);
    StringWriter localStringWriter = new StringWriter();
    try
    {
      Transformer localTransformer = TransformerFactory.newInstance().newTransformer();
      localTransformer.setOutputProperty("omit-xml-declaration", "yes");
      localTransformer.transform(new DOMSource(paramNode), new StreamResult(localStringWriter));
      paramNode = localStringWriter.toString();
      AppMethodBeat.o(158005);
      return paramNode;
    }
    catch (TransformerException paramNode)
    {
      for (;;)
      {
        ae.e("MicroMsg.SDK.XmlParser", "nodeToString: %s", new Object[] { paramNode.getMessage() });
      }
    }
  }
  
  static final class a
  {
    XmlPullParser IAX;
    private String IAY;
    StringBuilder IAZ;
    Map<String, String> IBa;
    Map<Integer, Integer> IBb;
    
    public a(String paramString1, String paramString2)
    {
      AppMethodBeat.i(158003);
      this.IAZ = new StringBuilder();
      this.IAY = paramString2;
      paramString2 = (XmlPullParser)bx.fpW().get();
      this.IAX = paramString2;
      if (paramString2 == null)
      {
        paramString2 = bx.fpW();
        XmlPullParser localXmlPullParser = XmlPullParserFactory.newInstance().newPullParser();
        this.IAX = localXmlPullParser;
        paramString2.set(localXmlPullParser);
      }
      this.IAX.setInput(new StringReader(paramString1));
      this.IBb = new HashMap();
      this.IBa = new HashMap();
      AppMethodBeat.o(158003);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.bx
 * JD-Core Version:    0.7.0.1
 */