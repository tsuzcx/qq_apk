package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class MimeTypeMap
{
  private static MimeTypeMap a;
  
  public static String getFileExtensionFromUrl(String paramString)
  {
    AppMethodBeat.i(63976);
    bz localbz = bz.a();
    if ((localbz != null) && (localbz.b()))
    {
      paramString = localbz.c().h(paramString);
      AppMethodBeat.o(63976);
      return paramString;
    }
    paramString = android.webkit.MimeTypeMap.getFileExtensionFromUrl(paramString);
    AppMethodBeat.o(63976);
    return paramString;
  }
  
  public static MimeTypeMap getSingleton()
  {
    try
    {
      AppMethodBeat.i(63981);
      if (a == null) {
        a = new MimeTypeMap();
      }
      MimeTypeMap localMimeTypeMap = a;
      AppMethodBeat.o(63981);
      return localMimeTypeMap;
    }
    finally {}
  }
  
  public String getExtensionFromMimeType(String paramString)
  {
    AppMethodBeat.i(63980);
    bz localbz = bz.a();
    if ((localbz != null) && (localbz.b()))
    {
      paramString = localbz.c().l(paramString);
      AppMethodBeat.o(63980);
      return paramString;
    }
    paramString = android.webkit.MimeTypeMap.getSingleton().getExtensionFromMimeType(paramString);
    AppMethodBeat.o(63980);
    return paramString;
  }
  
  public String getMimeTypeFromExtension(String paramString)
  {
    AppMethodBeat.i(63978);
    bz localbz = bz.a();
    if ((localbz != null) && (localbz.b()))
    {
      paramString = localbz.c().j(paramString);
      AppMethodBeat.o(63978);
      return paramString;
    }
    paramString = android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(paramString);
    AppMethodBeat.o(63978);
    return paramString;
  }
  
  public boolean hasExtension(String paramString)
  {
    AppMethodBeat.i(63979);
    bz localbz = bz.a();
    if ((localbz != null) && (localbz.b()))
    {
      bool = localbz.c().k(paramString);
      AppMethodBeat.o(63979);
      return bool;
    }
    boolean bool = android.webkit.MimeTypeMap.getSingleton().hasExtension(paramString);
    AppMethodBeat.o(63979);
    return bool;
  }
  
  public boolean hasMimeType(String paramString)
  {
    AppMethodBeat.i(63977);
    bz localbz = bz.a();
    if ((localbz != null) && (localbz.b()))
    {
      bool = localbz.c().i(paramString);
      AppMethodBeat.o(63977);
      return bool;
    }
    boolean bool = android.webkit.MimeTypeMap.getSingleton().hasMimeType(paramString);
    AppMethodBeat.o(63977);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.smtt.sdk.MimeTypeMap
 * JD-Core Version:    0.7.0.1
 */