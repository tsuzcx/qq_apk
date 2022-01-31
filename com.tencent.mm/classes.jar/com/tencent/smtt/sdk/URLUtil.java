package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class URLUtil
{
  public static String composeSearchUrl(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(64650);
    bz localbz = bz.a();
    if ((localbz != null) && (localbz.b()))
    {
      paramString1 = localbz.c().a(paramString1, paramString2, paramString3);
      AppMethodBeat.o(64650);
      return paramString1;
    }
    paramString1 = android.webkit.URLUtil.composeSearchUrl(paramString1, paramString2, paramString3);
    AppMethodBeat.o(64650);
    return paramString1;
  }
  
  public static byte[] decode(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(64651);
    bz localbz = bz.a();
    if ((localbz != null) && (localbz.b()))
    {
      paramArrayOfByte = localbz.c().a(paramArrayOfByte);
      AppMethodBeat.o(64651);
      return paramArrayOfByte;
    }
    paramArrayOfByte = android.webkit.URLUtil.decode(paramArrayOfByte);
    AppMethodBeat.o(64651);
    return paramArrayOfByte;
  }
  
  public static final String guessFileName(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(64664);
    bz localbz = bz.a();
    if ((localbz != null) && (localbz.b()))
    {
      paramString1 = localbz.c().b(paramString1, paramString2, paramString3);
      AppMethodBeat.o(64664);
      return paramString1;
    }
    paramString1 = android.webkit.URLUtil.guessFileName(paramString1, paramString2, paramString3);
    AppMethodBeat.o(64664);
    return paramString1;
  }
  
  public static String guessUrl(String paramString)
  {
    AppMethodBeat.i(64649);
    bz localbz = bz.a();
    if ((localbz != null) && (localbz.b()))
    {
      paramString = localbz.c().m(paramString);
      AppMethodBeat.o(64649);
      return paramString;
    }
    paramString = android.webkit.URLUtil.guessUrl(paramString);
    AppMethodBeat.o(64649);
    return paramString;
  }
  
  public static boolean isAboutUrl(String paramString)
  {
    AppMethodBeat.i(64655);
    bz localbz = bz.a();
    if ((localbz != null) && (localbz.b()))
    {
      bool = localbz.c().q(paramString);
      AppMethodBeat.o(64655);
      return bool;
    }
    boolean bool = android.webkit.URLUtil.isAboutUrl(paramString);
    AppMethodBeat.o(64655);
    return bool;
  }
  
  public static boolean isAssetUrl(String paramString)
  {
    AppMethodBeat.i(64652);
    bz localbz = bz.a();
    if ((localbz != null) && (localbz.b()))
    {
      bool = localbz.c().n(paramString);
      AppMethodBeat.o(64652);
      return bool;
    }
    boolean bool = android.webkit.URLUtil.isAssetUrl(paramString);
    AppMethodBeat.o(64652);
    return bool;
  }
  
  public static boolean isContentUrl(String paramString)
  {
    AppMethodBeat.i(64661);
    bz localbz = bz.a();
    if ((localbz != null) && (localbz.b()))
    {
      bool = localbz.c().w(paramString);
      AppMethodBeat.o(64661);
      return bool;
    }
    boolean bool = android.webkit.URLUtil.isContentUrl(paramString);
    AppMethodBeat.o(64661);
    return bool;
  }
  
  @Deprecated
  public static boolean isCookielessProxyUrl(String paramString)
  {
    AppMethodBeat.i(64653);
    bz localbz = bz.a();
    if ((localbz != null) && (localbz.b()))
    {
      bool = localbz.c().o(paramString);
      AppMethodBeat.o(64653);
      return bool;
    }
    boolean bool = android.webkit.URLUtil.isCookielessProxyUrl(paramString);
    AppMethodBeat.o(64653);
    return bool;
  }
  
  public static boolean isDataUrl(String paramString)
  {
    AppMethodBeat.i(64656);
    bz localbz = bz.a();
    if ((localbz != null) && (localbz.b()))
    {
      bool = localbz.c().r(paramString);
      AppMethodBeat.o(64656);
      return bool;
    }
    boolean bool = android.webkit.URLUtil.isDataUrl(paramString);
    AppMethodBeat.o(64656);
    return bool;
  }
  
  public static boolean isFileUrl(String paramString)
  {
    AppMethodBeat.i(64654);
    bz localbz = bz.a();
    if ((localbz != null) && (localbz.b()))
    {
      bool = localbz.c().p(paramString);
      AppMethodBeat.o(64654);
      return bool;
    }
    boolean bool = android.webkit.URLUtil.isFileUrl(paramString);
    AppMethodBeat.o(64654);
    return bool;
  }
  
  public static boolean isHttpUrl(String paramString)
  {
    AppMethodBeat.i(64658);
    bz localbz = bz.a();
    if ((localbz != null) && (localbz.b()))
    {
      bool = localbz.c().t(paramString);
      AppMethodBeat.o(64658);
      return bool;
    }
    boolean bool = android.webkit.URLUtil.isHttpUrl(paramString);
    AppMethodBeat.o(64658);
    return bool;
  }
  
  public static boolean isHttpsUrl(String paramString)
  {
    AppMethodBeat.i(64659);
    bz localbz = bz.a();
    if ((localbz != null) && (localbz.b()))
    {
      bool = localbz.c().u(paramString);
      AppMethodBeat.o(64659);
      return bool;
    }
    boolean bool = android.webkit.URLUtil.isHttpsUrl(paramString);
    AppMethodBeat.o(64659);
    return bool;
  }
  
  public static boolean isJavaScriptUrl(String paramString)
  {
    AppMethodBeat.i(64657);
    bz localbz = bz.a();
    if ((localbz != null) && (localbz.b()))
    {
      bool = localbz.c().s(paramString);
      AppMethodBeat.o(64657);
      return bool;
    }
    boolean bool = android.webkit.URLUtil.isJavaScriptUrl(paramString);
    AppMethodBeat.o(64657);
    return bool;
  }
  
  public static boolean isNetworkUrl(String paramString)
  {
    AppMethodBeat.i(64660);
    bz localbz = bz.a();
    if ((localbz != null) && (localbz.b()))
    {
      bool = localbz.c().v(paramString);
      AppMethodBeat.o(64660);
      return bool;
    }
    boolean bool = android.webkit.URLUtil.isNetworkUrl(paramString);
    AppMethodBeat.o(64660);
    return bool;
  }
  
  public static boolean isValidUrl(String paramString)
  {
    AppMethodBeat.i(64662);
    bz localbz = bz.a();
    if ((localbz != null) && (localbz.b()))
    {
      bool = localbz.c().x(paramString);
      AppMethodBeat.o(64662);
      return bool;
    }
    boolean bool = android.webkit.URLUtil.isValidUrl(paramString);
    AppMethodBeat.o(64662);
    return bool;
  }
  
  public static String stripAnchor(String paramString)
  {
    AppMethodBeat.i(64663);
    bz localbz = bz.a();
    if ((localbz != null) && (localbz.b()))
    {
      paramString = localbz.c().y(paramString);
      AppMethodBeat.o(64663);
      return paramString;
    }
    paramString = android.webkit.URLUtil.stripAnchor(paramString);
    AppMethodBeat.o(64663);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.sdk.URLUtil
 * JD-Core Version:    0.7.0.1
 */