package com.tencent.mm.sdk.f;

import android.text.TextUtils;
import android.util.Pair;
import android.webkit.MimeTypeMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class d
{
  private static final Map<String, String> EYK;
  private static final Map<String, String> EYL;
  
  static
  {
    AppMethodBeat.i(153471);
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(new Pair("silk", "audio/silk"));
    ((ArrayList)localObject).add(new Pair("jpg", "image/jpeg"));
    ((ArrayList)localObject).add(new Pair("json", "application/json"));
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Pair localPair = (Pair)((Iterator)localObject).next();
      localHashMap1.put(localPair.first, localPair.second);
      localHashMap2.put(localPair.second, localPair.first);
    }
    EYK = Collections.unmodifiableMap(localHashMap1);
    EYL = Collections.unmodifiableMap(localHashMap2);
    AppMethodBeat.o(153471);
  }
  
  public static String aBx(String paramString)
  {
    AppMethodBeat.i(153470);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(153470);
      return null;
    }
    String str3 = paramString.toLowerCase();
    String str2 = (String)EYL.get(str3);
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = MimeTypeMap.getSingleton().getExtensionFromMimeType(paramString);
    }
    if (TextUtils.isEmpty(str1))
    {
      if ("audio/mpeg".equals(str3))
      {
        AppMethodBeat.o(153470);
        return "mp3";
      }
      if ("audio/mp3".equals(str3))
      {
        AppMethodBeat.o(153470);
        return "mp3";
      }
      if ("audio/mp4".equals(str3))
      {
        AppMethodBeat.o(153470);
        return "mp4";
      }
      if ("application/pdf".equals(str3))
      {
        AppMethodBeat.o(153470);
        return "pdf";
      }
      if ("image/jpeg".equals(str3))
      {
        AppMethodBeat.o(153470);
        return "jpg";
      }
    }
    AppMethodBeat.o(153470);
    return str1;
  }
  
  public static String aCP(String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(153469);
    Object localObject1;
    if (TextUtils.isEmpty(paramString)) {
      localObject1 = localObject2;
    }
    for (;;)
    {
      paramString = aGE((String)localObject1);
      AppMethodBeat.o(153469);
      return paramString;
      int i = paramString.lastIndexOf('.');
      localObject1 = localObject2;
      if (i >= 0)
      {
        localObject1 = localObject2;
        if (i < paramString.length() - 1) {
          localObject1 = paramString.substring(i + 1);
        }
      }
    }
  }
  
  public static String aGE(String paramString)
  {
    AppMethodBeat.i(153468);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(153468);
      return null;
    }
    String str2 = (String)EYK.get(paramString.toLowerCase());
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      str1 = str2;
      if (!TextUtils.isEmpty(paramString)) {
        str1 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(paramString);
      }
    }
    if ((TextUtils.isEmpty(str1)) && ("mp3".equals(paramString)))
    {
      AppMethodBeat.o(153468);
      return "audio/mpeg";
    }
    AppMethodBeat.o(153468);
    return str1;
  }
  
  public static final class a
  {
    private static final Pattern EYM;
    public final String charset;
    public final String mimeType;
    
    static
    {
      AppMethodBeat.i(153467);
      EYM = Pattern.compile("([a-zA-Z*-.0-9]+/[a-zA-Z*-.0-9]+)");
      AppMethodBeat.o(153467);
    }
    
    private a(String paramString1, String paramString2)
    {
      this.mimeType = paramString1;
      this.charset = paramString2;
    }
    
    public static a aGF(String paramString)
    {
      String str = null;
      AppMethodBeat.i(153466);
      if (TextUtils.isEmpty(paramString))
      {
        AppMethodBeat.o(153466);
        return null;
      }
      Object localObject = EYM.matcher(paramString);
      if (!((Matcher)localObject).find())
      {
        AppMethodBeat.o(153466);
        return null;
      }
      localObject = ((Matcher)localObject).group(0);
      if (paramString.contains("charset=")) {
        str = paramString.substring(paramString.indexOf("charset=") + 8).trim();
      }
      paramString = str;
      if (TextUtils.isEmpty(str)) {
        paramString = "UTF-8";
      }
      paramString = new a((String)localObject, paramString);
      AppMethodBeat.o(153466);
      return paramString;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(153465);
      String str = "ContentType{mimeType='" + this.mimeType + '\'' + ", charset='" + this.charset + '\'' + '}';
      AppMethodBeat.o(153465);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.f.d
 * JD-Core Version:    0.7.0.1
 */