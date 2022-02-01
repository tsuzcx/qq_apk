package com.tencent.mm.sdk.system;

import android.text.TextUtils;
import android.util.Pair;
import android.webkit.MimeTypeMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MimeTypeUtil
{
  private static final Map<String, String> MyMimeMapExtToMime;
  private static final Map<String, String> MyMimeMapMimeToExt;
  
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
      localHashMap1.put((String)localPair.first, (String)localPair.second);
      localHashMap2.put((String)localPair.second, (String)localPair.first);
    }
    MyMimeMapExtToMime = Collections.unmodifiableMap(localHashMap1);
    MyMimeMapMimeToExt = Collections.unmodifiableMap(localHashMap2);
    AppMethodBeat.o(153471);
  }
  
  public static String getExtByMimeType(String paramString)
  {
    AppMethodBeat.i(153470);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(153470);
      return null;
    }
    String str3 = paramString.toLowerCase();
    String str2 = (String)MyMimeMapMimeToExt.get(str3);
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
      if ("image/jpg".equals(str3))
      {
        AppMethodBeat.o(153470);
        return "jpg";
      }
    }
    AppMethodBeat.o(153470);
    return str1;
  }
  
  public static String getFileExtByFilePath(String paramString)
  {
    AppMethodBeat.i(243215);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(243215);
      return null;
    }
    int i = paramString.lastIndexOf('.');
    if ((i < 0) || (i >= paramString.length() - 1))
    {
      AppMethodBeat.o(243215);
      return null;
    }
    paramString = paramString.substring(i + 1);
    AppMethodBeat.o(243215);
    return paramString;
  }
  
  public static String getMimeTypeByFileExt(String paramString)
  {
    AppMethodBeat.i(153468);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(153468);
      return null;
    }
    String str2 = (String)MyMimeMapExtToMime.get(paramString.toLowerCase());
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
  
  public static String getMimeTypeByFilePath(String paramString)
  {
    AppMethodBeat.i(153469);
    paramString = getMimeTypeByFileExt(getFileExtByFilePath(paramString));
    AppMethodBeat.o(153469);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sdk.system.MimeTypeUtil
 * JD-Core Version:    0.7.0.1
 */