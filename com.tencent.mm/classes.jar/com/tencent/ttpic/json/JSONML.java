package com.tencent.ttpic.json;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

public class JSONML
{
  private static Object parse(XMLTokener paramXMLTokener, boolean paramBoolean, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(50107);
    for (;;)
    {
      if (!paramXMLTokener.more())
      {
        paramXMLTokener = paramXMLTokener.syntaxError("Bad XML");
        AppMethodBeat.o(50107);
        throw paramXMLTokener;
      }
      Object localObject2 = paramXMLTokener.nextContent();
      Object localObject1;
      if (localObject2 == XML.LT)
      {
        localObject1 = paramXMLTokener.nextToken();
        if ((localObject1 instanceof Character))
        {
          if (localObject1 == XML.SLASH)
          {
            paramJSONArray = paramXMLTokener.nextToken();
            if (!(paramJSONArray instanceof String))
            {
              paramXMLTokener = new JSONException("Expected a closing name instead of '" + paramJSONArray + "'.");
              AppMethodBeat.o(50107);
              throw paramXMLTokener;
            }
            if (paramXMLTokener.nextToken() != XML.GT)
            {
              paramXMLTokener = paramXMLTokener.syntaxError("Misshaped close tag");
              AppMethodBeat.o(50107);
              throw paramXMLTokener;
            }
            AppMethodBeat.o(50107);
            return paramJSONArray;
          }
          if (localObject1 == XML.BANG)
          {
            int i = paramXMLTokener.next();
            if (i == 45)
            {
              if (paramXMLTokener.next() == '-') {
                paramXMLTokener.skipPast("-->");
              } else {
                paramXMLTokener.back();
              }
            }
            else if (i == 91)
            {
              if ((paramXMLTokener.nextToken().equals("CDATA")) && (paramXMLTokener.next() == '['))
              {
                if (paramJSONArray != null) {
                  paramJSONArray.put(paramXMLTokener.nextCDATA());
                }
              }
              else
              {
                paramXMLTokener = paramXMLTokener.syntaxError("Expected 'CDATA['");
                AppMethodBeat.o(50107);
                throw paramXMLTokener;
              }
            }
            else
            {
              int j = 1;
              label246:
              localObject1 = paramXMLTokener.nextMeta();
              if (localObject1 == null)
              {
                paramXMLTokener = paramXMLTokener.syntaxError("Missing '>' after '<!'.");
                AppMethodBeat.o(50107);
                throw paramXMLTokener;
              }
              if (localObject1 == XML.LT) {
                i = j + 1;
              }
              for (;;)
              {
                j = i;
                if (i > 0) {
                  break label246;
                }
                break;
                i = j;
                if (localObject1 == XML.GT) {
                  i = j - 1;
                }
              }
            }
          }
          else if (localObject1 == XML.QUEST)
          {
            paramXMLTokener.skipPast("?>");
          }
          else
          {
            paramXMLTokener = paramXMLTokener.syntaxError("Misshaped tag");
            AppMethodBeat.o(50107);
            throw paramXMLTokener;
          }
        }
        else
        {
          if (!(localObject1 instanceof String))
          {
            paramXMLTokener = paramXMLTokener.syntaxError("Bad tagName '" + localObject1 + "'.");
            AppMethodBeat.o(50107);
            throw paramXMLTokener;
          }
          String str = (String)localObject1;
          JSONArray localJSONArray = new JSONArray();
          JSONObject localJSONObject = new JSONObject();
          if (paramBoolean)
          {
            localJSONArray.put(str);
            if (paramJSONArray != null) {
              paramJSONArray.put(localJSONArray);
            }
            localObject1 = null;
          }
          for (;;)
          {
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = paramXMLTokener.nextToken();
            }
            if (localObject2 == null)
            {
              paramXMLTokener = paramXMLTokener.syntaxError("Misshaped tag");
              AppMethodBeat.o(50107);
              throw paramXMLTokener;
              localJSONObject.put("tagName", str);
              if (paramJSONArray == null) {
                break;
              }
              paramJSONArray.put(localJSONObject);
              break;
            }
            if (!(localObject2 instanceof String)) {
              break label623;
            }
            localObject2 = (String)localObject2;
            if ((!paramBoolean) && (("tagName".equals(localObject2)) || ("childNode".equals(localObject2))))
            {
              paramXMLTokener = paramXMLTokener.syntaxError("Reserved attribute.");
              AppMethodBeat.o(50107);
              throw paramXMLTokener;
            }
            localObject1 = paramXMLTokener.nextToken();
            if (localObject1 == XML.EQ)
            {
              localObject1 = paramXMLTokener.nextToken();
              if (!(localObject1 instanceof String))
              {
                paramXMLTokener = paramXMLTokener.syntaxError("Missing value");
                AppMethodBeat.o(50107);
                throw paramXMLTokener;
              }
              localJSONObject.accumulate((String)localObject2, XML.stringToValue((String)localObject1));
              break;
            }
            localJSONObject.accumulate((String)localObject2, "");
          }
          label623:
          if ((paramBoolean) && (localJSONObject.length() > 0)) {
            localJSONArray.put(localJSONObject);
          }
          if (localObject2 == XML.SLASH)
          {
            if (paramXMLTokener.nextToken() != XML.GT)
            {
              paramXMLTokener = paramXMLTokener.syntaxError("Misshaped tag");
              AppMethodBeat.o(50107);
              throw paramXMLTokener;
            }
            if (paramJSONArray == null)
            {
              if (paramBoolean)
              {
                AppMethodBeat.o(50107);
                return localJSONArray;
              }
              AppMethodBeat.o(50107);
              return localJSONObject;
            }
          }
          else
          {
            if (localObject2 != XML.GT)
            {
              paramXMLTokener = paramXMLTokener.syntaxError("Misshaped tag");
              AppMethodBeat.o(50107);
              throw paramXMLTokener;
            }
            localObject1 = (String)parse(paramXMLTokener, paramBoolean, localJSONArray);
            if (localObject1 != null)
            {
              if (!((String)localObject1).equals(str))
              {
                paramXMLTokener = paramXMLTokener.syntaxError("Mismatched '" + str + "' and '" + (String)localObject1 + "'");
                AppMethodBeat.o(50107);
                throw paramXMLTokener;
              }
              if ((!paramBoolean) && (localJSONArray.length() > 0)) {
                localJSONObject.put("childNodes", localJSONArray);
              }
              if (paramJSONArray == null)
              {
                if (paramBoolean)
                {
                  AppMethodBeat.o(50107);
                  return localJSONArray;
                }
                AppMethodBeat.o(50107);
                return localJSONObject;
              }
            }
          }
        }
      }
      else if (paramJSONArray != null)
      {
        localObject1 = localObject2;
        if ((localObject2 instanceof String)) {
          localObject1 = XML.stringToValue((String)localObject2);
        }
        paramJSONArray.put(localObject1);
      }
    }
  }
  
  public static JSONArray toJSONArray(XMLTokener paramXMLTokener)
  {
    AppMethodBeat.i(50109);
    paramXMLTokener = (JSONArray)parse(paramXMLTokener, true, null);
    AppMethodBeat.o(50109);
    return paramXMLTokener;
  }
  
  public static JSONArray toJSONArray(String paramString)
  {
    AppMethodBeat.i(50108);
    paramString = toJSONArray(new XMLTokener(paramString));
    AppMethodBeat.o(50108);
    return paramString;
  }
  
  public static JSONObject toJSONObject(XMLTokener paramXMLTokener)
  {
    AppMethodBeat.i(50110);
    paramXMLTokener = (JSONObject)parse(paramXMLTokener, false, null);
    AppMethodBeat.o(50110);
    return paramXMLTokener;
  }
  
  public static JSONObject toJSONObject(String paramString)
  {
    AppMethodBeat.i(50111);
    paramString = toJSONObject(new XMLTokener(paramString));
    AppMethodBeat.o(50111);
    return paramString;
  }
  
  public static String toString(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(50112);
    StringBuffer localStringBuffer = new StringBuffer();
    String str1 = paramJSONArray.getString(0);
    XML.noSpace(str1);
    str1 = XML.escape(str1);
    localStringBuffer.append('<');
    localStringBuffer.append(str1);
    Object localObject = paramJSONArray.opt(1);
    if ((localObject instanceof JSONObject))
    {
      localObject = (JSONObject)localObject;
      Iterator localIterator = ((JSONObject)localObject).keys();
      while (localIterator.hasNext())
      {
        String str2 = localIterator.next().toString();
        XML.noSpace(str2);
        String str3 = ((JSONObject)localObject).optString(str2);
        if (str3 != null)
        {
          localStringBuffer.append(' ');
          localStringBuffer.append(XML.escape(str2));
          localStringBuffer.append('=');
          localStringBuffer.append('"');
          localStringBuffer.append(XML.escape(str3));
          localStringBuffer.append('"');
        }
      }
    }
    for (int i = 1;; i = 2)
    {
      int k = paramJSONArray.length();
      if (i >= k)
      {
        localStringBuffer.append('/');
        localStringBuffer.append('>');
        paramJSONArray = localStringBuffer.toString();
        AppMethodBeat.o(50112);
        return paramJSONArray;
      }
      localStringBuffer.append('>');
      label225:
      localObject = paramJSONArray.get(i);
      int j = i + 1;
      if (localObject != null)
      {
        if (!(localObject instanceof String)) {
          break label305;
        }
        localStringBuffer.append(XML.escape(localObject.toString()));
      }
      for (;;)
      {
        i = j;
        if (j < k) {
          break label225;
        }
        localStringBuffer.append('<');
        localStringBuffer.append('/');
        localStringBuffer.append(str1);
        localStringBuffer.append('>');
        break;
        label305:
        if ((localObject instanceof JSONObject)) {
          localStringBuffer.append(toString((JSONObject)localObject));
        } else if ((localObject instanceof JSONArray)) {
          localStringBuffer.append(toString((JSONArray)localObject));
        }
      }
    }
  }
  
  public static String toString(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(50113);
    StringBuffer localStringBuffer = new StringBuffer();
    String str1 = paramJSONObject.optString("tagName");
    if (str1 == null)
    {
      paramJSONObject = XML.escape(paramJSONObject.toString());
      AppMethodBeat.o(50113);
      return paramJSONObject;
    }
    XML.noSpace(str1);
    str1 = XML.escape(str1);
    localStringBuffer.append('<');
    localStringBuffer.append(str1);
    Object localObject = paramJSONObject.keys();
    while (((Iterator)localObject).hasNext())
    {
      String str2 = ((Iterator)localObject).next().toString();
      if ((!"tagName".equals(str2)) && (!"childNodes".equals(str2)))
      {
        XML.noSpace(str2);
        String str3 = paramJSONObject.optString(str2);
        if (str3 != null)
        {
          localStringBuffer.append(' ');
          localStringBuffer.append(XML.escape(str2));
          localStringBuffer.append('=');
          localStringBuffer.append('"');
          localStringBuffer.append(XML.escape(str3));
          localStringBuffer.append('"');
        }
      }
    }
    paramJSONObject = paramJSONObject.optJSONArray("childNodes");
    if (paramJSONObject == null)
    {
      localStringBuffer.append('/');
      localStringBuffer.append('>');
    }
    for (;;)
    {
      paramJSONObject = localStringBuffer.toString();
      AppMethodBeat.o(50113);
      return paramJSONObject;
      localStringBuffer.append('>');
      int j = paramJSONObject.length();
      int i = 0;
      if (i < j)
      {
        localObject = paramJSONObject.get(i);
        if (localObject != null)
        {
          if (!(localObject instanceof String)) {
            break label280;
          }
          localStringBuffer.append(XML.escape(localObject.toString()));
        }
        for (;;)
        {
          i += 1;
          break;
          label280:
          if ((localObject instanceof JSONObject)) {
            localStringBuffer.append(toString((JSONObject)localObject));
          } else if ((localObject instanceof JSONArray)) {
            localStringBuffer.append(toString((JSONArray)localObject));
          } else {
            localStringBuffer.append(localObject.toString());
          }
        }
      }
      localStringBuffer.append('<');
      localStringBuffer.append('/');
      localStringBuffer.append(str1);
      localStringBuffer.append('>');
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.json.JSONML
 * JD-Core Version:    0.7.0.1
 */