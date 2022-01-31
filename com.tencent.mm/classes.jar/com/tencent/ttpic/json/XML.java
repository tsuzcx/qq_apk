package com.tencent.ttpic.json;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

public class XML
{
  public static final Character AMP;
  public static final Character APOS;
  public static final Character BANG;
  public static final Character EQ;
  public static final Character GT;
  public static final Character LT;
  public static final Character QUEST;
  public static final Character QUOT;
  public static final Character SLASH;
  
  static
  {
    AppMethodBeat.i(50222);
    AMP = Character.valueOf('&');
    APOS = Character.valueOf('\'');
    BANG = Character.valueOf('!');
    EQ = Character.valueOf('=');
    GT = Character.valueOf('>');
    LT = Character.valueOf('<');
    QUEST = Character.valueOf('?');
    QUOT = Character.valueOf('"');
    SLASH = Character.valueOf('/');
    AppMethodBeat.o(50222);
  }
  
  public static String escape(String paramString)
  {
    AppMethodBeat.i(50215);
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    int j = paramString.length();
    if (i < j)
    {
      char c = paramString.charAt(i);
      switch (c)
      {
      default: 
        localStringBuffer.append(c);
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuffer.append("&amp;");
        continue;
        localStringBuffer.append("&lt;");
        continue;
        localStringBuffer.append("&gt;");
        continue;
        localStringBuffer.append("&quot;");
        continue;
        localStringBuffer.append("&apos;");
      }
    }
    paramString = localStringBuffer.toString();
    AppMethodBeat.o(50215);
    return paramString;
  }
  
  public static void noSpace(String paramString)
  {
    AppMethodBeat.i(50216);
    int j = paramString.length();
    if (j == 0)
    {
      paramString = new JSONException("Empty string.");
      AppMethodBeat.o(50216);
      throw paramString;
    }
    int i = 0;
    while (i < j)
    {
      if (Character.isWhitespace(paramString.charAt(i)))
      {
        paramString = new JSONException("'" + paramString + "' contains a space character.");
        AppMethodBeat.o(50216);
        throw paramString;
      }
      i += 1;
    }
    AppMethodBeat.o(50216);
  }
  
  private static boolean parse(XMLTokener paramXMLTokener, JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(50217);
    Object localObject = paramXMLTokener.nextToken();
    if (localObject == BANG)
    {
      int i = paramXMLTokener.next();
      if (i == 45)
      {
        if (paramXMLTokener.next() == '-')
        {
          paramXMLTokener.skipPast("-->");
          AppMethodBeat.o(50217);
          return false;
        }
        paramXMLTokener.back();
      }
      int j;
      while (i != 91)
      {
        j = 1;
        paramJSONObject = paramXMLTokener.nextMeta();
        if (paramJSONObject != null) {
          break;
        }
        paramXMLTokener = paramXMLTokener.syntaxError("Missing '>' after '<!'.");
        AppMethodBeat.o(50217);
        throw paramXMLTokener;
      }
      if (("CDATA".equals(paramXMLTokener.nextToken())) && (paramXMLTokener.next() == '['))
      {
        paramXMLTokener = paramXMLTokener.nextCDATA();
        if (paramXMLTokener.length() > 0) {
          paramJSONObject.accumulate("content", paramXMLTokener);
        }
        AppMethodBeat.o(50217);
        return false;
      }
      paramXMLTokener = paramXMLTokener.syntaxError("Expected 'CDATA['");
      AppMethodBeat.o(50217);
      throw paramXMLTokener;
      if (paramJSONObject == LT) {
        i = j + 1;
      }
      for (;;)
      {
        j = i;
        if (i > 0) {
          break;
        }
        AppMethodBeat.o(50217);
        return false;
        i = j;
        if (paramJSONObject == GT) {
          i = j - 1;
        }
      }
    }
    if (localObject == QUEST)
    {
      paramXMLTokener.skipPast("?>");
      AppMethodBeat.o(50217);
      return false;
    }
    if (localObject == SLASH)
    {
      paramJSONObject = paramXMLTokener.nextToken();
      if (paramString == null)
      {
        paramXMLTokener = paramXMLTokener.syntaxError("Mismatched close tag ".concat(String.valueOf(paramJSONObject)));
        AppMethodBeat.o(50217);
        throw paramXMLTokener;
      }
      if (!paramJSONObject.equals(paramString))
      {
        paramXMLTokener = paramXMLTokener.syntaxError("Mismatched " + paramString + " and " + paramJSONObject);
        AppMethodBeat.o(50217);
        throw paramXMLTokener;
      }
      if (paramXMLTokener.nextToken() != GT)
      {
        paramXMLTokener = paramXMLTokener.syntaxError("Misshaped close tag");
        AppMethodBeat.o(50217);
        throw paramXMLTokener;
      }
      AppMethodBeat.o(50217);
      return true;
    }
    if ((localObject instanceof Character))
    {
      paramXMLTokener = paramXMLTokener.syntaxError("Misshaped tag");
      AppMethodBeat.o(50217);
      throw paramXMLTokener;
    }
    String str = (String)localObject;
    paramString = null;
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      localObject = paramString;
      if (paramString == null) {
        localObject = paramXMLTokener.nextToken();
      }
      if (!(localObject instanceof String)) {
        break;
      }
      localObject = (String)localObject;
      paramString = paramXMLTokener.nextToken();
      if (paramString == EQ)
      {
        paramString = paramXMLTokener.nextToken();
        if (!(paramString instanceof String))
        {
          paramXMLTokener = paramXMLTokener.syntaxError("Missing value");
          AppMethodBeat.o(50217);
          throw paramXMLTokener;
        }
        localJSONObject.accumulate((String)localObject, stringToValue((String)paramString));
        paramString = null;
      }
      else
      {
        localJSONObject.accumulate((String)localObject, "");
      }
    }
    if (localObject == SLASH)
    {
      if (paramXMLTokener.nextToken() != GT)
      {
        paramXMLTokener = paramXMLTokener.syntaxError("Misshaped tag");
        AppMethodBeat.o(50217);
        throw paramXMLTokener;
      }
      if (localJSONObject.length() > 0) {
        paramJSONObject.accumulate(str, localJSONObject);
      }
      for (;;)
      {
        AppMethodBeat.o(50217);
        return false;
        paramJSONObject.accumulate(str, "");
      }
    }
    if (localObject == GT)
    {
      do
      {
        for (;;)
        {
          paramString = paramXMLTokener.nextContent();
          if (paramString == null)
          {
            if (str != null)
            {
              paramXMLTokener = paramXMLTokener.syntaxError("Unclosed tag ".concat(String.valueOf(str)));
              AppMethodBeat.o(50217);
              throw paramXMLTokener;
            }
            AppMethodBeat.o(50217);
            return false;
          }
          if (!(paramString instanceof String)) {
            break;
          }
          paramString = (String)paramString;
          if (paramString.length() > 0) {
            localJSONObject.accumulate("content", stringToValue(paramString));
          }
        }
      } while ((paramString != LT) || (!parse(paramXMLTokener, localJSONObject, str)));
      if (localJSONObject.length() == 0) {
        paramJSONObject.accumulate(str, "");
      }
      for (;;)
      {
        AppMethodBeat.o(50217);
        return false;
        if ((localJSONObject.length() == 1) && (localJSONObject.opt("content") != null)) {
          paramJSONObject.accumulate(str, localJSONObject.opt("content"));
        } else {
          paramJSONObject.accumulate(str, localJSONObject);
        }
      }
    }
    paramXMLTokener = paramXMLTokener.syntaxError("Misshaped tag");
    AppMethodBeat.o(50217);
    throw paramXMLTokener;
  }
  
  public static Object stringToValue(String paramString)
  {
    int k = 1;
    int j = 0;
    AppMethodBeat.i(50218);
    if ("".equals(paramString))
    {
      AppMethodBeat.o(50218);
      return paramString;
    }
    if ("true".equalsIgnoreCase(paramString))
    {
      paramString = Boolean.TRUE;
      AppMethodBeat.o(50218);
      return paramString;
    }
    if ("false".equalsIgnoreCase(paramString))
    {
      paramString = Boolean.FALSE;
      AppMethodBeat.o(50218);
      return paramString;
    }
    if ("null".equalsIgnoreCase(paramString))
    {
      paramString = JSONObject.NULL;
      AppMethodBeat.o(50218);
      return paramString;
    }
    if ("0".equals(paramString))
    {
      AppMethodBeat.o(50218);
      return Integer.valueOf(0);
    }
    for (;;)
    {
      int i;
      try
      {
        int m = paramString.charAt(0);
        i = m;
        if (m != 45) {
          break label268;
        }
        i = paramString.charAt(1);
        j = 1;
      }
      catch (Exception localException)
      {
        Object localObject;
        AppMethodBeat.o(50218);
        return paramString;
      }
      j = paramString.charAt(k);
      if (j == 48)
      {
        AppMethodBeat.o(50218);
        return paramString;
      }
      if ((i >= 48) && (i <= 57))
      {
        if (paramString.indexOf('.') >= 0)
        {
          localObject = Double.valueOf(paramString);
          AppMethodBeat.o(50218);
          return localObject;
        }
        if ((paramString.indexOf('e') < 0) && (paramString.indexOf('E') < 0))
        {
          localObject = new Long(paramString);
          if (((Long)localObject).longValue() == ((Long)localObject).intValue())
          {
            localObject = new Integer(((Long)localObject).intValue());
            AppMethodBeat.o(50218);
            return localObject;
          }
          AppMethodBeat.o(50218);
          return localObject;
        }
      }
      label268:
      if (i == 48) {
        if (j != 0) {
          k = 2;
        }
      }
    }
  }
  
  public static JSONObject toJSONObject(String paramString)
  {
    AppMethodBeat.i(50219);
    JSONObject localJSONObject = new JSONObject();
    paramString = new XMLTokener(paramString);
    while ((paramString.more()) && (paramString.skipPast("<"))) {
      parse(paramString, localJSONObject, null);
    }
    AppMethodBeat.o(50219);
    return localJSONObject;
  }
  
  public static String toString(Object paramObject)
  {
    AppMethodBeat.i(50220);
    paramObject = toString(paramObject, null);
    AppMethodBeat.o(50220);
    return paramObject;
  }
  
  public static String toString(Object paramObject, String paramString)
  {
    AppMethodBeat.i(50221);
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject2;
    Object localObject1;
    int j;
    int i;
    if ((paramObject instanceof JSONObject))
    {
      if (paramString != null)
      {
        localStringBuffer.append('<');
        localStringBuffer.append(paramString);
        localStringBuffer.append('>');
      }
      localObject2 = (JSONObject)paramObject;
      Iterator localIterator = ((JSONObject)localObject2).keys();
      while (localIterator.hasNext())
      {
        String str = localIterator.next().toString();
        localObject1 = ((JSONObject)localObject2).opt(str);
        paramObject = localObject1;
        if (localObject1 == null) {
          paramObject = "";
        }
        if ("content".equals(str))
        {
          if ((paramObject instanceof JSONArray))
          {
            paramObject = (JSONArray)paramObject;
            j = paramObject.length();
            i = 0;
            while (i < j)
            {
              if (i > 0) {
                localStringBuffer.append('\n');
              }
              localStringBuffer.append(escape(paramObject.get(i).toString()));
              i += 1;
            }
          }
          else
          {
            localStringBuffer.append(escape(paramObject.toString()));
          }
        }
        else
        {
          if ((paramObject instanceof JSONArray))
          {
            paramObject = (JSONArray)paramObject;
            j = paramObject.length();
            i = 0;
            label209:
            if (i < j)
            {
              localObject1 = paramObject.get(i);
              if (!(localObject1 instanceof JSONArray)) {
                break label296;
              }
              localStringBuffer.append('<');
              localStringBuffer.append(str);
              localStringBuffer.append('>');
              localStringBuffer.append(toString(localObject1));
              localStringBuffer.append("</");
              localStringBuffer.append(str);
              localStringBuffer.append('>');
            }
            for (;;)
            {
              i += 1;
              break label209;
              break;
              label296:
              localStringBuffer.append(toString(localObject1, str));
            }
          }
          if ("".equals(paramObject))
          {
            localStringBuffer.append('<');
            localStringBuffer.append(str);
            localStringBuffer.append("/>");
          }
          else
          {
            localStringBuffer.append(toString(paramObject, str));
          }
        }
      }
      if (paramString != null)
      {
        localStringBuffer.append("</");
        localStringBuffer.append(paramString);
        localStringBuffer.append('>');
      }
      paramObject = localStringBuffer.toString();
      AppMethodBeat.o(50221);
      return paramObject;
    }
    if (paramObject.getClass().isArray()) {
      paramObject = new JSONArray(paramObject);
    }
    for (;;)
    {
      if ((paramObject instanceof JSONArray))
      {
        localObject1 = (JSONArray)paramObject;
        j = ((JSONArray)localObject1).length();
        i = 0;
        if (i < j)
        {
          localObject2 = ((JSONArray)localObject1).opt(i);
          if (paramString == null) {}
          for (paramObject = "array";; paramObject = paramString)
          {
            localStringBuffer.append(toString(localObject2, paramObject));
            i += 1;
            break;
          }
        }
        paramObject = localStringBuffer.toString();
        AppMethodBeat.o(50221);
        return paramObject;
      }
      if (paramObject == null) {}
      for (paramObject = "null"; paramString == null; paramObject = escape(paramObject.toString()))
      {
        paramObject = "\"" + paramObject + "\"";
        AppMethodBeat.o(50221);
        return paramObject;
      }
      if (paramObject.length() == 0)
      {
        paramObject = "<" + paramString + "/>";
        AppMethodBeat.o(50221);
        return paramObject;
      }
      paramObject = "<" + paramString + ">" + paramObject + "</" + paramString + ">";
      AppMethodBeat.o(50221);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.json.XML
 * JD-Core Version:    0.7.0.1
 */