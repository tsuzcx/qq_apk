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

public class XmlParser
{
  private static final String TAG = "MicroMsg.SDK.XmlParser";
  private static ThreadLocal<XmlPullParser> threadLocalPool;
  
  static
  {
    AppMethodBeat.i(158006);
    threadLocalPool = new ThreadLocal();
    AppMethodBeat.o(158006);
  }
  
  public static String getCDataWrapper(String paramString)
  {
    AppMethodBeat.i(168848);
    if (paramString == null)
    {
      AppMethodBeat.o(168848);
      return "";
    }
    paramString = String.format("<![CDATA[%s]]>", new Object[] { paramString });
    AppMethodBeat.o(168848);
    return paramString;
  }
  
  public static String nodeToString(Node paramNode)
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
        Log.e("MicroMsg.SDK.XmlParser", "nodeToString: %s", new Object[] { paramNode.getMessage() });
      }
    }
  }
  
  public static Map<String, String> parseXml(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(243655);
    if (paramString1 == null) {}
    for (int i = -1; i < 0; i = paramString1.indexOf("<".concat(String.valueOf(paramString2))))
    {
      Log.e("MicroMsg.SDK.XmlParser", "can not find the tag <%s>", new Object[] { paramString2 });
      AppMethodBeat.o(243655);
      return null;
    }
    String str = paramString1;
    if (i > 0) {
      str = paramString1.substring(i);
    }
    try
    {
      paramString1 = new MMXmlPullParser(str, paramString2, paramString3).parse();
      AppMethodBeat.o(243655);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      Log.printErrStackTrace("MicroMsg.SDK.XmlParser", paramString1, "[ %s ]", new Object[] { str });
      AppMethodBeat.o(243655);
    }
    return null;
  }
  
  static class MMXmlPullParser
  {
    private Map<Integer, Integer> countMap;
    private StringBuilder pathSB;
    private Map<String, String> result;
    private String rootTag;
    private XmlPullParser xmlParser;
    
    public MMXmlPullParser(String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(243906);
      this.pathSB = new StringBuilder();
      this.rootTag = paramString2;
      paramString2 = (XmlPullParser)XmlParser.threadLocalPool.get();
      this.xmlParser = paramString2;
      if (paramString2 == null)
      {
        paramString2 = XmlParser.threadLocalPool;
        paramString3 = XmlPullParserFactory.newInstance().newPullParser();
        this.xmlParser = paramString3;
        paramString2.set(paramString3);
      }
      this.xmlParser.setInput(new StringReader(paramString1));
      this.countMap = new HashMap();
      this.result = new HashMap();
      AppMethodBeat.o(243906);
    }
    
    private void handleElementContent()
    {
      AppMethodBeat.i(243916);
      String str = this.xmlParser.getText();
      if (str != null) {
        this.result.put(this.pathSB.toString(), str);
      }
      AppMethodBeat.o(243916);
    }
    
    private void handleEndElement()
    {
      AppMethodBeat.i(243926);
      this.pathSB = this.pathSB.delete(this.pathSB.lastIndexOf("."), this.pathSB.length());
      AppMethodBeat.o(243926);
    }
    
    private void handleStartElement()
    {
      AppMethodBeat.i(243910);
      this.pathSB.append('.').append(this.xmlParser.getName());
      String str = this.pathSB.toString();
      int i = str.hashCode();
      Integer localInteger = (Integer)this.countMap.get(Integer.valueOf(i));
      if (localInteger != null)
      {
        localInteger = Integer.valueOf(localInteger.intValue() + 1);
        this.pathSB.append(localInteger);
        this.countMap.put(Integer.valueOf(i), localInteger);
        str = str + localInteger;
      }
      for (;;)
      {
        this.result.put(str, "");
        i = 0;
        while (i < this.xmlParser.getAttributeCount())
        {
          this.result.put(str + ".$" + this.xmlParser.getAttributeName(i), this.xmlParser.getAttributeValue(i));
          i += 1;
        }
        this.countMap.put(Integer.valueOf(i), Integer.valueOf(0));
      }
      AppMethodBeat.o(243910);
    }
    
    public Map<String, String> parse()
    {
      AppMethodBeat.i(243933);
      int i = this.xmlParser.getEventType();
      do
      {
        int j;
        do
        {
          for (;;)
          {
            if (i == 1) {
              break label81;
            }
            j = this.xmlParser.next();
            if (j == 2)
            {
              handleStartElement();
              i = j;
            }
            else
            {
              if (j != 4) {
                break;
              }
              handleElementContent();
              i = j;
            }
          }
          i = j;
        } while (j != 3);
        handleEndElement();
        i = j;
      } while (this.pathSB.length() != 0);
      label81:
      Map localMap = this.result;
      AppMethodBeat.o(243933);
      return localMap;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.XmlParser
 * JD-Core Version:    0.7.0.1
 */