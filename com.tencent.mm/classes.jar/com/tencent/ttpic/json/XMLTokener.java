package com.tencent.ttpic.json;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public class XMLTokener
  extends JSONTokener
{
  public static final HashMap entity;
  
  static
  {
    AppMethodBeat.i(50229);
    HashMap localHashMap = new HashMap(8);
    entity = localHashMap;
    localHashMap.put("amp", XML.AMP);
    entity.put("apos", XML.APOS);
    entity.put("gt", XML.GT);
    entity.put("lt", XML.LT);
    entity.put("quot", XML.QUOT);
    AppMethodBeat.o(50229);
  }
  
  public XMLTokener(String paramString)
  {
    super(paramString);
  }
  
  public String nextCDATA()
  {
    AppMethodBeat.i(50223);
    Object localObject = new StringBuffer();
    int i;
    do
    {
      char c = next();
      if (end())
      {
        localObject = syntaxError("Unclosed CDATA");
        AppMethodBeat.o(50223);
        throw ((Throwable)localObject);
      }
      ((StringBuffer)localObject).append(c);
      i = ((StringBuffer)localObject).length() - 3;
    } while ((i < 0) || (((StringBuffer)localObject).charAt(i) != ']') || (((StringBuffer)localObject).charAt(i + 1) != ']') || (((StringBuffer)localObject).charAt(i + 2) != '>'));
    ((StringBuffer)localObject).setLength(i);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(50223);
    return localObject;
  }
  
  public Object nextContent()
  {
    AppMethodBeat.i(50224);
    char c;
    do
    {
      c = next();
    } while (Character.isWhitespace(c));
    if (c == 0)
    {
      AppMethodBeat.o(50224);
      return null;
    }
    if (c == '<')
    {
      localObject = XML.LT;
      AppMethodBeat.o(50224);
      return localObject;
    }
    Object localObject = new StringBuffer();
    if ((c == '<') || (c == 0))
    {
      back();
      localObject = ((StringBuffer)localObject).toString().trim();
      AppMethodBeat.o(50224);
      return localObject;
    }
    if (c == '&') {
      ((StringBuffer)localObject).append(nextEntity(c));
    }
    for (;;)
    {
      c = next();
      break;
      ((StringBuffer)localObject).append(c);
    }
  }
  
  public Object nextEntity(char paramChar)
  {
    AppMethodBeat.i(50225);
    Object localObject1 = new StringBuffer();
    char c;
    for (;;)
    {
      c = next();
      if ((!Character.isLetterOrDigit(c)) && (c != '#')) {
        break;
      }
      ((StringBuffer)localObject1).append(Character.toLowerCase(c));
    }
    if (c != ';')
    {
      localObject1 = syntaxError("Missing ';' in XML entity: &".concat(String.valueOf(localObject1)));
      AppMethodBeat.o(50225);
      throw ((Throwable)localObject1);
    }
    localObject1 = ((StringBuffer)localObject1).toString();
    Object localObject2 = entity.get(localObject1);
    if (localObject2 != null)
    {
      AppMethodBeat.o(50225);
      return localObject2;
    }
    localObject1 = paramChar + (String)localObject1 + ";";
    AppMethodBeat.o(50225);
    return localObject1;
  }
  
  public Object nextMeta()
  {
    AppMethodBeat.i(50226);
    char c1;
    do
    {
      c1 = next();
    } while (Character.isWhitespace(c1));
    switch (c1)
    {
    }
    for (;;)
    {
      c1 = next();
      if (Character.isWhitespace(c1))
      {
        localObject = Boolean.TRUE;
        AppMethodBeat.o(50226);
        return localObject;
        localObject = syntaxError("Misshaped meta tag");
        AppMethodBeat.o(50226);
        throw ((Throwable)localObject);
        localObject = XML.LT;
        AppMethodBeat.o(50226);
        return localObject;
        localObject = XML.GT;
        AppMethodBeat.o(50226);
        return localObject;
        localObject = XML.SLASH;
        AppMethodBeat.o(50226);
        return localObject;
        localObject = XML.EQ;
        AppMethodBeat.o(50226);
        return localObject;
        localObject = XML.BANG;
        AppMethodBeat.o(50226);
        return localObject;
        localObject = XML.QUEST;
        AppMethodBeat.o(50226);
        return localObject;
        char c2;
        do
        {
          c2 = next();
          if (c2 == 0)
          {
            localObject = syntaxError("Unterminated string");
            AppMethodBeat.o(50226);
            throw ((Throwable)localObject);
          }
        } while (c2 != c1);
        localObject = Boolean.TRUE;
        AppMethodBeat.o(50226);
        return localObject;
      }
      switch (c1)
      {
      }
    }
    back();
    Object localObject = Boolean.TRUE;
    AppMethodBeat.o(50226);
    return localObject;
  }
  
  public Object nextToken()
  {
    AppMethodBeat.i(50227);
    char c1;
    do
    {
      c1 = next();
    } while (Character.isWhitespace(c1));
    switch (c1)
    {
    default: 
      localObject = new StringBuffer();
    }
    for (;;)
    {
      ((StringBuffer)localObject).append(c1);
      c1 = next();
      if (Character.isWhitespace(c1))
      {
        localObject = ((StringBuffer)localObject).toString();
        AppMethodBeat.o(50227);
        return localObject;
        localObject = syntaxError("Misshaped element");
        AppMethodBeat.o(50227);
        throw ((Throwable)localObject);
        localObject = syntaxError("Misplaced '<'");
        AppMethodBeat.o(50227);
        throw ((Throwable)localObject);
        localObject = XML.GT;
        AppMethodBeat.o(50227);
        return localObject;
        localObject = XML.SLASH;
        AppMethodBeat.o(50227);
        return localObject;
        localObject = XML.EQ;
        AppMethodBeat.o(50227);
        return localObject;
        localObject = XML.BANG;
        AppMethodBeat.o(50227);
        return localObject;
        localObject = XML.QUEST;
        AppMethodBeat.o(50227);
        return localObject;
        localObject = new StringBuffer();
        for (;;)
        {
          char c2 = next();
          if (c2 == 0)
          {
            localObject = syntaxError("Unterminated string");
            AppMethodBeat.o(50227);
            throw ((Throwable)localObject);
          }
          if (c2 == c1)
          {
            localObject = ((StringBuffer)localObject).toString();
            AppMethodBeat.o(50227);
            return localObject;
          }
          if (c2 == '&') {
            ((StringBuffer)localObject).append(nextEntity(c2));
          } else {
            ((StringBuffer)localObject).append(c2);
          }
        }
      }
      switch (c1)
      {
      }
    }
    Object localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(50227);
    return localObject;
    back();
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(50227);
    return localObject;
    localObject = syntaxError("Bad character in a name");
    AppMethodBeat.o(50227);
    throw ((Throwable)localObject);
  }
  
  public boolean skipPast(String paramString)
  {
    AppMethodBeat.i(50228);
    int i1 = paramString.length();
    char[] arrayOfChar = new char[i1];
    int j = 0;
    int i;
    int k;
    for (;;)
    {
      if (j < i1)
      {
        i = next();
        if (i == 0)
        {
          AppMethodBeat.o(50228);
          return false;
        }
        arrayOfChar[j] = i;
        j += 1;
        continue;
        arrayOfChar[j] = i;
        k = j + 1;
        j = k;
        if (k < i1) {
          break;
        }
      }
    }
    for (j = k - i1;; j = 0)
    {
      k = j;
      int m = 0;
      label85:
      if (m < i1) {
        if (arrayOfChar[k] == paramString.charAt(m)) {}
      }
      for (k = 0;; k = 1)
      {
        if (k != 0)
        {
          AppMethodBeat.o(50228);
          return true;
          int n = k + 1;
          k = n;
          if (n >= i1) {
            k = n - i1;
          }
          m += 1;
          break label85;
        }
        i = next();
        if (i != 0) {
          break;
        }
        AppMethodBeat.o(50228);
        return false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.json.XMLTokener
 * JD-Core Version:    0.7.0.1
 */