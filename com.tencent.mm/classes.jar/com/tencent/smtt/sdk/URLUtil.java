package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.IX5CoreUrlUtil;

public final class URLUtil
  extends x
{
  public static String composeSearchUrl(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(54944);
    if (isX5Core())
    {
      paramString1 = getX5CoreUrlUtilImpl().composeSearchUrl(paramString1, paramString2, paramString3);
      AppMethodBeat.o(54944);
      return paramString1;
    }
    paramString1 = android.webkit.URLUtil.composeSearchUrl(paramString1, paramString2, paramString3);
    AppMethodBeat.o(54944);
    return paramString1;
  }
  
  public static byte[] decode(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(54945);
    if (isX5Core())
    {
      paramArrayOfByte = getX5CoreUrlUtilImpl().decode(paramArrayOfByte);
      AppMethodBeat.o(54945);
      return paramArrayOfByte;
    }
    paramArrayOfByte = android.webkit.URLUtil.decode(paramArrayOfByte);
    AppMethodBeat.o(54945);
    return paramArrayOfByte;
  }
  
  public static final String guessFileName(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(54958);
    while (isX5Core()) {}
    paramString1 = android.webkit.URLUtil.guessFileName(paramString1, paramString2, paramString3);
    AppMethodBeat.o(54958);
    return paramString1;
  }
  
  public static String guessUrl(String paramString)
  {
    AppMethodBeat.i(54943);
    if (isX5Core())
    {
      paramString = getX5CoreUrlUtilImpl().guessUrl(paramString);
      AppMethodBeat.o(54943);
      return paramString;
    }
    paramString = android.webkit.URLUtil.guessUrl(paramString);
    AppMethodBeat.o(54943);
    return paramString;
  }
  
  public static boolean isAboutUrl(String paramString)
  {
    AppMethodBeat.i(54949);
    if (isX5Core())
    {
      bool = getX5CoreUrlUtilImpl().isAboutUrl(paramString);
      AppMethodBeat.o(54949);
      return bool;
    }
    boolean bool = android.webkit.URLUtil.isAboutUrl(paramString);
    AppMethodBeat.o(54949);
    return bool;
  }
  
  public static boolean isAssetUrl(String paramString)
  {
    AppMethodBeat.i(54946);
    if (isX5Core())
    {
      bool = getX5CoreUrlUtilImpl().isAssetUrl(paramString);
      AppMethodBeat.o(54946);
      return bool;
    }
    boolean bool = android.webkit.URLUtil.isAssetUrl(paramString);
    AppMethodBeat.o(54946);
    return bool;
  }
  
  public static boolean isContentUrl(String paramString)
  {
    AppMethodBeat.i(54955);
    if (isX5Core())
    {
      bool = getX5CoreUrlUtilImpl().isContentUrl(paramString);
      AppMethodBeat.o(54955);
      return bool;
    }
    boolean bool = android.webkit.URLUtil.isContentUrl(paramString);
    AppMethodBeat.o(54955);
    return bool;
  }
  
  @Deprecated
  public static boolean isCookielessProxyUrl(String paramString)
  {
    AppMethodBeat.i(54947);
    if (isX5Core())
    {
      bool = getX5CoreUrlUtilImpl().isCookielessProxyUrl(paramString);
      AppMethodBeat.o(54947);
      return bool;
    }
    boolean bool = android.webkit.URLUtil.isCookielessProxyUrl(paramString);
    AppMethodBeat.o(54947);
    return bool;
  }
  
  public static boolean isDataUrl(String paramString)
  {
    AppMethodBeat.i(54950);
    if (isX5Core())
    {
      bool = getX5CoreUrlUtilImpl().isDataUrl(paramString);
      AppMethodBeat.o(54950);
      return bool;
    }
    boolean bool = android.webkit.URLUtil.isDataUrl(paramString);
    AppMethodBeat.o(54950);
    return bool;
  }
  
  public static boolean isFileUrl(String paramString)
  {
    AppMethodBeat.i(54948);
    if (isX5Core())
    {
      bool = getX5CoreUrlUtilImpl().isFileUrl(paramString);
      AppMethodBeat.o(54948);
      return bool;
    }
    boolean bool = android.webkit.URLUtil.isFileUrl(paramString);
    AppMethodBeat.o(54948);
    return bool;
  }
  
  public static boolean isHttpUrl(String paramString)
  {
    AppMethodBeat.i(54952);
    if (isX5Core())
    {
      bool = getX5CoreUrlUtilImpl().isHttpUrl(paramString);
      AppMethodBeat.o(54952);
      return bool;
    }
    boolean bool = android.webkit.URLUtil.isHttpUrl(paramString);
    AppMethodBeat.o(54952);
    return bool;
  }
  
  public static boolean isHttpsUrl(String paramString)
  {
    AppMethodBeat.i(54953);
    if (isX5Core())
    {
      bool = getX5CoreUrlUtilImpl().isHttpsUrl(paramString);
      AppMethodBeat.o(54953);
      return bool;
    }
    boolean bool = android.webkit.URLUtil.isHttpsUrl(paramString);
    AppMethodBeat.o(54953);
    return bool;
  }
  
  public static boolean isJavaScriptUrl(String paramString)
  {
    AppMethodBeat.i(54951);
    if (isX5Core())
    {
      bool = getX5CoreUrlUtilImpl().isJavaScriptUrl(paramString);
      AppMethodBeat.o(54951);
      return bool;
    }
    boolean bool = android.webkit.URLUtil.isJavaScriptUrl(paramString);
    AppMethodBeat.o(54951);
    return bool;
  }
  
  public static boolean isNetworkUrl(String paramString)
  {
    AppMethodBeat.i(54954);
    if (isX5Core())
    {
      bool = getX5CoreUrlUtilImpl().isNetworkUrl(paramString);
      AppMethodBeat.o(54954);
      return bool;
    }
    boolean bool = android.webkit.URLUtil.isNetworkUrl(paramString);
    AppMethodBeat.o(54954);
    return bool;
  }
  
  public static boolean isValidUrl(String paramString)
  {
    AppMethodBeat.i(54956);
    if (isX5Core())
    {
      bool = getX5CoreUrlUtilImpl().isValidUrl(paramString);
      AppMethodBeat.o(54956);
      return bool;
    }
    boolean bool = android.webkit.URLUtil.isValidUrl(paramString);
    AppMethodBeat.o(54956);
    return bool;
  }
  
  public static String stripAnchor(String paramString)
  {
    AppMethodBeat.i(54957);
    if (isX5Core())
    {
      paramString = getX5CoreUrlUtilImpl().stripAnchor(paramString);
      AppMethodBeat.o(54957);
      return paramString;
    }
    paramString = android.webkit.URLUtil.stripAnchor(paramString);
    AppMethodBeat.o(54957);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.URLUtil
 * JD-Core Version:    0.7.0.1
 */