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

public final class c
{
  private static final Map<String, String> ysb;
  private static final Map<String, String> ysc;
  
  static
  {
    AppMethodBeat.i(65365);
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(new Pair("silk", "audio/silk"));
    ((ArrayList)localObject).add(new Pair("jpg", "image/jpg"));
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
    ysb = Collections.unmodifiableMap(localHashMap1);
    ysc = Collections.unmodifiableMap(localHashMap2);
    AppMethodBeat.o(65365);
  }
  
  public static String alX(String paramString)
  {
    AppMethodBeat.i(65364);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(65364);
      return null;
    }
    String str2 = (String)ysc.get(paramString.toLowerCase());
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = MimeTypeMap.getSingleton().getExtensionFromMimeType(paramString);
    }
    if (TextUtils.isEmpty(str1))
    {
      if ("audio/mpeg".equals(paramString))
      {
        AppMethodBeat.o(65364);
        return "mp3";
      }
      if ("audio/mp3".equals(paramString))
      {
        AppMethodBeat.o(65364);
        return "mp3";
      }
      if ("audio/mp4".equals(paramString))
      {
        AppMethodBeat.o(65364);
        return "mp4";
      }
    }
    AppMethodBeat.o(65364);
    return str1;
  }
  
  public static String amX(String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(65363);
    Object localObject1;
    if (TextUtils.isEmpty(paramString)) {
      localObject1 = localObject2;
    }
    for (;;)
    {
      paramString = aqq((String)localObject1);
      AppMethodBeat.o(65363);
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
  
  public static String aqq(String paramString)
  {
    AppMethodBeat.i(65362);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(65362);
      return null;
    }
    String str2 = (String)ysb.get(paramString.toLowerCase());
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
      AppMethodBeat.o(65362);
      return "audio/mpeg";
    }
    AppMethodBeat.o(65362);
    return str1;
  }
  
  public static final class a
  {
    private static final Pattern ysd;
    public final String charset;
    public final String mimeType;
    
    static
    {
      AppMethodBeat.i(65361);
      ysd = Pattern.compile("([a-zA-Z*-.0-9]+/[a-zA-Z*-.0-9]+)");
      AppMethodBeat.o(65361);
    }
    
    private a(String paramString1, String paramString2)
    {
      this.mimeType = paramString1;
      this.charset = paramString2;
    }
    
    public static a aqr(String paramString)
    {
      String str = null;
      AppMethodBeat.i(65360);
      if (TextUtils.isEmpty(paramString))
      {
        AppMethodBeat.o(65360);
        return null;
      }
      Object localObject = ysd.matcher(paramString);
      if (!((Matcher)localObject).find())
      {
        AppMethodBeat.o(65360);
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
      AppMethodBeat.o(65360);
      return paramString;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(65359);
      String str = "ContentType{mimeType='" + this.mimeType + '\'' + ", charset='" + this.charset + '\'' + '}';
      AppMethodBeat.o(65359);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.sdk.f.c
 * JD-Core Version:    0.7.0.1
 */