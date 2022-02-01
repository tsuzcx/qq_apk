package com.tencent.mm.sdk.platformtools;

import android.util.Xml;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

@Deprecated
class XmlUtils
{
  public static final ArrayList<Object> readListXml(InputStream paramInputStream)
  {
    AppMethodBeat.i(262012);
    XmlPullParser localXmlPullParser = Xml.newPullParser();
    localXmlPullParser.setInput(paramInputStream, null);
    paramInputStream = (ArrayList)readValueXml(localXmlPullParser, new String[1]);
    AppMethodBeat.o(262012);
    return paramInputStream;
  }
  
  public static final HashMap<String, Object> readMapXml(InputStream paramInputStream)
  {
    AppMethodBeat.i(262009);
    XmlPullParser localXmlPullParser = Xml.newPullParser();
    localXmlPullParser.setInput(paramInputStream, null);
    paramInputStream = (HashMap)readValueXml(localXmlPullParser, new String[1]);
    AppMethodBeat.o(262009);
    return paramInputStream;
  }
  
  public static final HashSet<Object> readSetXml(InputStream paramInputStream)
  {
    AppMethodBeat.i(262014);
    XmlPullParser localXmlPullParser = Xml.newPullParser();
    localXmlPullParser.setInput(paramInputStream, null);
    paramInputStream = (HashSet)readValueXml(localXmlPullParser, new String[1]);
    AppMethodBeat.o(262014);
    return paramInputStream;
  }
  
  public static final int[] readThisIntArrayXml(XmlPullParser paramXmlPullParser, String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(262026);
    int i;
    int j;
    try
    {
      i = Integer.parseInt(paramXmlPullParser.getAttributeValue(null, "num"));
      paramArrayOfString = new int[i];
      j = 0;
      i = paramXmlPullParser.getEventType();
    }
    catch (NullPointerException paramXmlPullParser)
    {
      try
      {
        do
        {
          paramArrayOfString[j] = Integer.parseInt(paramXmlPullParser.getAttributeValue(null, "value"));
          k = j;
          m = paramXmlPullParser.next();
          j = k;
          i = m;
        } while (m != 1);
        paramXmlPullParser = new XmlPullParserException("Document ended before " + paramString + " end tag");
        AppMethodBeat.o(262026);
        throw paramXmlPullParser;
      }
      catch (NullPointerException paramXmlPullParser)
      {
        paramXmlPullParser = new XmlPullParserException("Need value attribute in item");
        AppMethodBeat.o(262026);
        throw paramXmlPullParser;
      }
      catch (NumberFormatException paramXmlPullParser)
      {
        paramXmlPullParser = new XmlPullParserException("Not a number in value attribute in item");
        AppMethodBeat.o(262026);
        throw paramXmlPullParser;
      }
      paramXmlPullParser = paramXmlPullParser;
      paramXmlPullParser = new XmlPullParserException("Need num attribute in byte-array");
      AppMethodBeat.o(262026);
      throw paramXmlPullParser;
    }
    catch (NumberFormatException paramXmlPullParser)
    {
      paramXmlPullParser = new XmlPullParserException("Not a number in num attribute in byte-array");
      AppMethodBeat.o(262026);
      throw paramXmlPullParser;
    }
    if (i == 2) {
      if (!paramXmlPullParser.getName().equals("item")) {}
    }
    for (;;)
    {
      int m;
      paramXmlPullParser = new XmlPullParserException("Expected item tag at: " + paramXmlPullParser.getName());
      AppMethodBeat.o(262026);
      throw paramXmlPullParser;
      int k = j;
      if (i == 3)
      {
        if (paramXmlPullParser.getName().equals(paramString))
        {
          AppMethodBeat.o(262026);
          return paramArrayOfString;
        }
        if (!paramXmlPullParser.getName().equals("item")) {
          break;
        }
        k = j + 1;
      }
    }
    paramXmlPullParser = new XmlPullParserException("Expected " + paramString + " end tag at: " + paramXmlPullParser.getName());
    AppMethodBeat.o(262026);
    throw paramXmlPullParser;
  }
  
  public static final ArrayList<Object> readThisListXml(XmlPullParser paramXmlPullParser, String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(156361);
    ArrayList localArrayList = new ArrayList();
    int i = paramXmlPullParser.getEventType();
    if (i == 2) {
      localArrayList.add(readThisValueXml(paramXmlPullParser, paramArrayOfString));
    }
    while (i != 3)
    {
      int j = paramXmlPullParser.next();
      i = j;
      if (j != 1) {
        break;
      }
      paramXmlPullParser = new XmlPullParserException("Document ended before " + paramString + " end tag");
      AppMethodBeat.o(156361);
      throw paramXmlPullParser;
    }
    if (paramXmlPullParser.getName().equals(paramString))
    {
      AppMethodBeat.o(156361);
      return localArrayList;
    }
    paramXmlPullParser = new XmlPullParserException("Expected " + paramString + " end tag at: " + paramXmlPullParser.getName());
    AppMethodBeat.o(156361);
    throw paramXmlPullParser;
  }
  
  public static final HashMap<String, Object> readThisMapXml(XmlPullParser paramXmlPullParser, String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(156360);
    HashMap localHashMap = new HashMap();
    int i = paramXmlPullParser.getEventType();
    if (i == 2)
    {
      localObject = readThisValueXml(paramXmlPullParser, paramArrayOfString);
      if (paramArrayOfString[0] != null) {
        localHashMap.put(paramArrayOfString[0], localObject);
      }
    }
    while (i != 3)
    {
      Object localObject;
      int j = paramXmlPullParser.next();
      i = j;
      if (j != 1) {
        break;
      }
      paramXmlPullParser = new XmlPullParserException("Document ended before " + paramString + " end tag");
      AppMethodBeat.o(156360);
      throw paramXmlPullParser;
      paramXmlPullParser = new XmlPullParserException("Map value without name attribute: " + paramXmlPullParser.getName());
      AppMethodBeat.o(156360);
      throw paramXmlPullParser;
    }
    if (paramXmlPullParser.getName().equals(paramString))
    {
      AppMethodBeat.o(156360);
      return localHashMap;
    }
    paramXmlPullParser = new XmlPullParserException("Expected " + paramString + " end tag at: " + paramXmlPullParser.getName());
    AppMethodBeat.o(156360);
    throw paramXmlPullParser;
  }
  
  public static final HashSet<Object> readThisSetXml(XmlPullParser paramXmlPullParser, String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(156362);
    HashSet localHashSet = new HashSet();
    int i = paramXmlPullParser.getEventType();
    if (i == 2) {
      localHashSet.add(readThisValueXml(paramXmlPullParser, paramArrayOfString));
    }
    while (i != 3)
    {
      int j = paramXmlPullParser.next();
      i = j;
      if (j != 1) {
        break;
      }
      paramXmlPullParser = new XmlPullParserException("Document ended before " + paramString + " end tag");
      AppMethodBeat.o(156362);
      throw paramXmlPullParser;
    }
    if (paramXmlPullParser.getName().equals(paramString))
    {
      AppMethodBeat.o(156362);
      return localHashSet;
    }
    paramXmlPullParser = new XmlPullParserException("Expected " + paramString + " end tag at: " + paramXmlPullParser.getName());
    AppMethodBeat.o(156362);
    throw paramXmlPullParser;
  }
  
  private static final Object readThisValueXml(XmlPullParser paramXmlPullParser, String[] paramArrayOfString)
  {
    Object localObject = null;
    AppMethodBeat.i(156365);
    String str1 = paramXmlPullParser.getAttributeValue(null, "name");
    String str2 = paramXmlPullParser.getName();
    if (str2.equals("null")) {}
    int i;
    label244:
    do
    {
      for (;;)
      {
        i = paramXmlPullParser.next();
        if (i == 1) {
          break label715;
        }
        if (i != 3) {
          break label613;
        }
        if (!paramXmlPullParser.getName().equals(str2)) {
          break label567;
        }
        paramArrayOfString[0] = str1;
        AppMethodBeat.o(156365);
        return localObject;
        if (str2.equals("string"))
        {
          localObject = "";
          do
          {
            for (;;)
            {
              i = paramXmlPullParser.next();
              if (i == 1) {
                break label244;
              }
              if (i == 3)
              {
                if (paramXmlPullParser.getName().equals("string"))
                {
                  paramArrayOfString[0] = str1;
                  AppMethodBeat.o(156365);
                  return localObject;
                }
                paramXmlPullParser = new XmlPullParserException("Unexpected end tag in <string>: " + paramXmlPullParser.getName());
                AppMethodBeat.o(156365);
                throw paramXmlPullParser;
              }
              if (i != 4) {
                break;
              }
              localObject = (String)localObject + paramXmlPullParser.getText();
            }
          } while (i != 2);
          paramXmlPullParser = new XmlPullParserException("Unexpected start tag in <string>: " + paramXmlPullParser.getName());
          AppMethodBeat.o(156365);
          throw paramXmlPullParser;
          paramXmlPullParser = new XmlPullParserException("Unexpected end of document in <string>");
          AppMethodBeat.o(156365);
          throw paramXmlPullParser;
        }
        if (str2.equals("int"))
        {
          localObject = Integer.valueOf(Integer.parseInt(paramXmlPullParser.getAttributeValue(null, "value")));
        }
        else if (str2.equals("long"))
        {
          localObject = Long.valueOf(paramXmlPullParser.getAttributeValue(null, "value"));
        }
        else if (str2.equals("float"))
        {
          localObject = Float.valueOf(paramXmlPullParser.getAttributeValue(null, "value"));
        }
        else if (str2.equals("double"))
        {
          localObject = Double.valueOf(paramXmlPullParser.getAttributeValue(null, "value"));
        }
        else
        {
          if (!str2.equals("boolean")) {
            break;
          }
          localObject = Boolean.valueOf(paramXmlPullParser.getAttributeValue(null, "value"));
        }
      }
      if (str2.equals("int-array"))
      {
        paramXmlPullParser.next();
        paramXmlPullParser = readThisIntArrayXml(paramXmlPullParser, "int-array", paramArrayOfString);
        paramArrayOfString[0] = str1;
        AppMethodBeat.o(156365);
        return paramXmlPullParser;
      }
      if (str2.equals("map"))
      {
        paramXmlPullParser.next();
        paramXmlPullParser = readThisMapXml(paramXmlPullParser, "map", paramArrayOfString);
        paramArrayOfString[0] = str1;
        AppMethodBeat.o(156365);
        return paramXmlPullParser;
      }
      if (str2.equals("list"))
      {
        paramXmlPullParser.next();
        paramXmlPullParser = readThisListXml(paramXmlPullParser, "list", paramArrayOfString);
        paramArrayOfString[0] = str1;
        AppMethodBeat.o(156365);
        return paramXmlPullParser;
      }
      if (str2.equals("set"))
      {
        paramXmlPullParser.next();
        paramXmlPullParser = readThisSetXml(paramXmlPullParser, "set", paramArrayOfString);
        paramArrayOfString[0] = str1;
        AppMethodBeat.o(156365);
        return paramXmlPullParser;
      }
      paramXmlPullParser = new XmlPullParserException("Unknown tag: ".concat(String.valueOf(str2)));
      AppMethodBeat.o(156365);
      throw paramXmlPullParser;
      paramXmlPullParser = new XmlPullParserException("Unexpected end tag in <" + str2 + ">: " + paramXmlPullParser.getName());
      AppMethodBeat.o(156365);
      throw paramXmlPullParser;
      if (i == 4)
      {
        paramXmlPullParser = new XmlPullParserException("Unexpected text in <" + str2 + ">: " + paramXmlPullParser.getName());
        AppMethodBeat.o(156365);
        throw paramXmlPullParser;
      }
    } while (i != 2);
    label567:
    label613:
    paramXmlPullParser = new XmlPullParserException("Unexpected start tag in <" + str2 + ">: " + paramXmlPullParser.getName());
    AppMethodBeat.o(156365);
    throw paramXmlPullParser;
    label715:
    paramXmlPullParser = new XmlPullParserException("Unexpected end of document in <" + str2 + ">");
    AppMethodBeat.o(156365);
    throw paramXmlPullParser;
  }
  
  public static final Object readValueXml(XmlPullParser paramXmlPullParser, String[] paramArrayOfString)
  {
    AppMethodBeat.i(156364);
    int i = paramXmlPullParser.getEventType();
    int j;
    do
    {
      if (i == 2)
      {
        paramXmlPullParser = readThisValueXml(paramXmlPullParser, paramArrayOfString);
        AppMethodBeat.o(156364);
        return paramXmlPullParser;
      }
      if (i == 3)
      {
        paramXmlPullParser = new XmlPullParserException("Unexpected end tag at: " + paramXmlPullParser.getName());
        AppMethodBeat.o(156364);
        throw paramXmlPullParser;
      }
      if (i == 4)
      {
        paramXmlPullParser = new XmlPullParserException("Unexpected text: " + paramXmlPullParser.getText());
        AppMethodBeat.o(156364);
        throw paramXmlPullParser;
      }
      j = paramXmlPullParser.next();
      i = j;
    } while (j != 1);
    paramXmlPullParser = new XmlPullParserException("Unexpected end of document");
    AppMethodBeat.o(156364);
    throw paramXmlPullParser;
  }
  
  public static final void writeByteArrayXml(byte[] paramArrayOfByte, String paramString, XmlSerializer paramXmlSerializer)
  {
    AppMethodBeat.i(156357);
    if (paramArrayOfByte == null)
    {
      paramXmlSerializer.startTag(null, "null");
      paramXmlSerializer.endTag(null, "null");
      AppMethodBeat.o(156357);
      return;
    }
    paramXmlSerializer.startTag(null, "byte-array");
    if (paramString != null) {
      paramXmlSerializer.attribute(null, "name", paramString);
    }
    int k = paramArrayOfByte.length;
    paramXmlSerializer.attribute(null, "num", Integer.toString(k));
    paramString = new StringBuilder(paramArrayOfByte.length * 2);
    int i = 0;
    if (i < k)
    {
      int m = paramArrayOfByte[i];
      int j = m >> 4;
      if (j >= 10)
      {
        j = j + 97 - 10;
        label128:
        paramString.append(j);
        j = m & 0xFF;
        if (j < 10) {
          break label184;
        }
        j = j + 97 - 10;
      }
      for (;;)
      {
        paramString.append(j);
        i += 1;
        break;
        j += 48;
        break label128;
        label184:
        j += 48;
      }
    }
    paramXmlSerializer.text(paramString.toString());
    paramXmlSerializer.endTag(null, "byte-array");
    AppMethodBeat.o(156357);
  }
  
  public static final void writeIntArrayXml(int[] paramArrayOfInt, String paramString, XmlSerializer paramXmlSerializer)
  {
    AppMethodBeat.i(156358);
    if (paramArrayOfInt == null)
    {
      paramXmlSerializer.startTag(null, "null");
      paramXmlSerializer.endTag(null, "null");
      AppMethodBeat.o(156358);
      return;
    }
    paramXmlSerializer.startTag(null, "int-array");
    if (paramString != null) {
      paramXmlSerializer.attribute(null, "name", paramString);
    }
    int j = paramArrayOfInt.length;
    paramXmlSerializer.attribute(null, "num", Integer.toString(j));
    int i = 0;
    while (i < j)
    {
      paramXmlSerializer.startTag(null, "item");
      paramXmlSerializer.attribute(null, "value", Integer.toString(paramArrayOfInt[i]));
      paramXmlSerializer.endTag(null, "item");
      i += 1;
    }
    paramXmlSerializer.endTag(null, "int-array");
    AppMethodBeat.o(156358);
  }
  
  public static final void writeListXml(List<Object> paramList, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(261999);
    XmlSerializer localXmlSerializer = Xml.newSerializer();
    localXmlSerializer.setOutput(paramOutputStream, "utf-8");
    localXmlSerializer.startDocument(null, Boolean.TRUE);
    localXmlSerializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
    writeListXml(paramList, null, localXmlSerializer);
    localXmlSerializer.endDocument();
    AppMethodBeat.o(261999);
  }
  
  public static final void writeListXml(List<Object> paramList, String paramString, XmlSerializer paramXmlSerializer)
  {
    AppMethodBeat.i(156355);
    if (paramList == null)
    {
      paramXmlSerializer.startTag(null, "null");
      paramXmlSerializer.endTag(null, "null");
      AppMethodBeat.o(156355);
      return;
    }
    paramXmlSerializer.startTag(null, "list");
    if (paramString != null) {
      paramXmlSerializer.attribute(null, "name", paramString);
    }
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      writeValueXml(paramList.get(i), null, paramXmlSerializer);
      i += 1;
    }
    paramXmlSerializer.endTag(null, "list");
    AppMethodBeat.o(156355);
  }
  
  public static final void writeMapXml(Map<String, Object> paramMap, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(261996);
    XmlSerializer localXmlSerializer = Xml.newSerializer();
    localXmlSerializer.setOutput(paramOutputStream, "utf-8");
    localXmlSerializer.startDocument(null, Boolean.TRUE);
    localXmlSerializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
    writeMapXml(paramMap, null, localXmlSerializer);
    localXmlSerializer.endDocument();
    AppMethodBeat.o(261996);
  }
  
  public static final void writeMapXml(Map<String, Object> paramMap, String paramString, XmlSerializer paramXmlSerializer)
  {
    AppMethodBeat.i(156354);
    if (paramMap == null)
    {
      paramXmlSerializer.startTag(null, "null");
      paramXmlSerializer.endTag(null, "null");
      AppMethodBeat.o(156354);
      return;
    }
    paramMap = paramMap.entrySet().iterator();
    paramXmlSerializer.startTag(null, "map");
    if (paramString != null) {
      paramXmlSerializer.attribute(null, "name", paramString);
    }
    while (paramMap.hasNext())
    {
      paramString = (Map.Entry)paramMap.next();
      writeValueXml(paramString.getValue(), (String)paramString.getKey(), paramXmlSerializer);
    }
    paramXmlSerializer.endTag(null, "map");
    AppMethodBeat.o(156354);
  }
  
  public static final void writeSetXml(Set<Object> paramSet, String paramString, XmlSerializer paramXmlSerializer)
  {
    AppMethodBeat.i(156356);
    if (paramSet == null)
    {
      paramXmlSerializer.startTag(null, "null");
      paramXmlSerializer.endTag(null, "null");
      AppMethodBeat.o(156356);
      return;
    }
    paramXmlSerializer.startTag(null, "set");
    if (paramString != null) {
      paramXmlSerializer.attribute(null, "name", paramString);
    }
    paramSet = paramSet.iterator();
    while (paramSet.hasNext()) {
      writeValueXml(paramSet.next(), null, paramXmlSerializer);
    }
    paramXmlSerializer.endTag(null, "set");
    AppMethodBeat.o(156356);
  }
  
  public static final void writeValueXml(Object paramObject, String paramString, XmlSerializer paramXmlSerializer)
  {
    AppMethodBeat.i(156359);
    if (paramObject == null)
    {
      paramXmlSerializer.startTag(null, "null");
      if (paramString != null) {
        paramXmlSerializer.attribute(null, "name", paramString);
      }
      paramXmlSerializer.endTag(null, "null");
      AppMethodBeat.o(156359);
      return;
    }
    if ((paramObject instanceof String))
    {
      paramXmlSerializer.startTag(null, "string");
      if (paramString != null) {
        paramXmlSerializer.attribute(null, "name", paramString);
      }
      paramXmlSerializer.text(paramObject.toString());
      paramXmlSerializer.endTag(null, "string");
      AppMethodBeat.o(156359);
      return;
    }
    String str;
    if ((paramObject instanceof Integer)) {
      str = "int";
    }
    for (;;)
    {
      paramXmlSerializer.startTag(null, str);
      if (paramString != null) {
        paramXmlSerializer.attribute(null, "name", paramString);
      }
      paramXmlSerializer.attribute(null, "value", paramObject.toString());
      paramXmlSerializer.endTag(null, str);
      AppMethodBeat.o(156359);
      return;
      if ((paramObject instanceof Long))
      {
        str = "long";
      }
      else if ((paramObject instanceof Float))
      {
        str = "float";
      }
      else if ((paramObject instanceof Double))
      {
        str = "double";
      }
      else
      {
        if (!(paramObject instanceof Boolean)) {
          break;
        }
        str = "boolean";
      }
    }
    if ((paramObject instanceof byte[]))
    {
      writeByteArrayXml((byte[])paramObject, paramString, paramXmlSerializer);
      AppMethodBeat.o(156359);
      return;
    }
    if ((paramObject instanceof int[]))
    {
      writeIntArrayXml((int[])paramObject, paramString, paramXmlSerializer);
      AppMethodBeat.o(156359);
      return;
    }
    if ((paramObject instanceof Map))
    {
      writeMapXml((Map)paramObject, paramString, paramXmlSerializer);
      AppMethodBeat.o(156359);
      return;
    }
    if ((paramObject instanceof List))
    {
      writeListXml((List)paramObject, paramString, paramXmlSerializer);
      AppMethodBeat.o(156359);
      return;
    }
    if ((paramObject instanceof Set))
    {
      writeSetXml((Set)paramObject, paramString, paramXmlSerializer);
      AppMethodBeat.o(156359);
      return;
    }
    if ((paramObject instanceof CharSequence))
    {
      paramXmlSerializer.startTag(null, "string");
      if (paramString != null) {
        paramXmlSerializer.attribute(null, "name", paramString);
      }
      paramXmlSerializer.text(paramObject.toString());
      paramXmlSerializer.endTag(null, "string");
      AppMethodBeat.o(156359);
      return;
    }
    paramObject = new RuntimeException("writeValueXml: unable to write value ".concat(String.valueOf(paramObject)));
    AppMethodBeat.o(156359);
    throw paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.XmlUtils
 * JD-Core Version:    0.7.0.1
 */