package com.tencent.mm.sdk.platformtools;

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

public final class bn
{
  private static ThreadLocal<XmlPullParser> uiX = new ThreadLocal();
  
  public static String b(Node paramNode)
  {
    StringWriter localStringWriter = new StringWriter();
    try
    {
      Transformer localTransformer = TransformerFactory.newInstance().newTransformer();
      localTransformer.setOutputProperty("omit-xml-declaration", "yes");
      localTransformer.transform(new DOMSource(paramNode), new StreamResult(localStringWriter));
      return localStringWriter.toString();
    }
    catch (TransformerException paramNode)
    {
      for (;;)
      {
        y.e("MicroMsg.SDK.XmlParser", "nodeToString: %s", new Object[] { paramNode.getMessage() });
      }
    }
  }
  
  public static Map<String, String> s(String paramString1, String paramString2)
  {
    if (paramString1 == null) {}
    for (int i = -1; i < 0; i = paramString1.indexOf("<" + paramString2))
    {
      y.e("MicroMsg.SDK.XmlParser", "can not find the tag <%s>", new Object[] { paramString2 });
      return null;
    }
    String str = paramString1;
    if (i > 0) {
      str = paramString1.substring(i);
    }
    try
    {
      paramString1 = new a(str, paramString2).csj();
      return paramString1;
    }
    catch (Exception paramString1)
    {
      y.printErrStackTrace("MicroMsg.SDK.XmlParser", paramString1, "[ %s ]", new Object[] { str });
    }
    return null;
  }
  
  private static final class a
  {
    private XmlPullParser uiY;
    private String uiZ;
    private StringBuilder uja = new StringBuilder();
    private Map<String, String> ujb;
    private Map<Integer, Integer> ujc;
    
    public a(String paramString1, String paramString2)
    {
      this.uiZ = paramString2;
      paramString2 = (XmlPullParser)bn.csi().get();
      this.uiY = paramString2;
      if (paramString2 == null)
      {
        paramString2 = bn.csi();
        XmlPullParser localXmlPullParser = XmlPullParserFactory.newInstance().newPullParser();
        this.uiY = localXmlPullParser;
        paramString2.set(localXmlPullParser);
      }
      this.uiY.setInput(new StringReader(paramString1));
      this.ujc = new HashMap();
      this.ujb = new HashMap();
    }
    
    public final Map<String, String> csj()
    {
      int i = this.uiY.getEventType();
      for (;;)
      {
        if (i != 1)
        {
          i = this.uiY.next();
          String str;
          if (i == 2)
          {
            this.uja.append('.').append(this.uiY.getName());
            str = this.uja.toString();
            int j = str.hashCode();
            Integer localInteger = (Integer)this.ujc.get(Integer.valueOf(j));
            if (localInteger != null)
            {
              localInteger = Integer.valueOf(localInteger.intValue() + 1);
              this.uja.append(localInteger);
              this.ujc.put(Integer.valueOf(j), localInteger);
              str = str + localInteger;
            }
            for (;;)
            {
              this.ujb.put(str, "");
              j = 0;
              while (j < this.uiY.getAttributeCount())
              {
                this.ujb.put(str + ".$" + this.uiY.getAttributeName(j), this.uiY.getAttributeValue(j));
                j += 1;
              }
              this.ujc.put(Integer.valueOf(j), Integer.valueOf(0));
            }
          }
          else if (i == 4)
          {
            str = this.uiY.getText();
            if (str != null) {
              this.ujb.put(this.uja.toString(), str);
            }
          }
          else if (i == 3)
          {
            this.uja = this.uja.delete(this.uja.lastIndexOf("."), this.uja.length());
            if (this.uja.length() != 0) {}
          }
        }
        else
        {
          return this.ujb;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.bn
 * JD-Core Version:    0.7.0.1
 */