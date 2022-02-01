package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.IX5CoreMessy;

public class MimeTypeMap
  extends z
{
  private static MimeTypeMap a;
  
  public static String getFileExtensionFromUrl(String paramString)
  {
    AppMethodBeat.i(54575);
    if (isX5Core())
    {
      paramString = getCoreMessy().mimeTypeMapGetFileExtensionFromUrl(paramString);
      AppMethodBeat.o(54575);
      return paramString;
    }
    paramString = android.webkit.MimeTypeMap.getFileExtensionFromUrl(paramString);
    AppMethodBeat.o(54575);
    return paramString;
  }
  
  public static MimeTypeMap getSingleton()
  {
    try
    {
      AppMethodBeat.i(54580);
      if (a == null) {
        a = new MimeTypeMap();
      }
      MimeTypeMap localMimeTypeMap = a;
      AppMethodBeat.o(54580);
      return localMimeTypeMap;
    }
    finally {}
  }
  
  public String getExtensionFromMimeType(String paramString)
  {
    AppMethodBeat.i(54579);
    if (isX5Core())
    {
      paramString = getCoreMessy().mimeTypeMapGetExtensionFromMimeType(paramString);
      AppMethodBeat.o(54579);
      return paramString;
    }
    paramString = android.webkit.MimeTypeMap.getSingleton().getExtensionFromMimeType(paramString);
    AppMethodBeat.o(54579);
    return paramString;
  }
  
  public String getMimeTypeFromExtension(String paramString)
  {
    AppMethodBeat.i(54577);
    if (isX5Core())
    {
      paramString = getCoreMessy().mimeTypeMapGetMimeTypeFromExtension(paramString);
      AppMethodBeat.o(54577);
      return paramString;
    }
    paramString = android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(paramString);
    AppMethodBeat.o(54577);
    return paramString;
  }
  
  public boolean hasExtension(String paramString)
  {
    AppMethodBeat.i(54578);
    if (isX5Core())
    {
      bool = getCoreMessy().mimeTypeMapHasExtension(paramString);
      AppMethodBeat.o(54578);
      return bool;
    }
    boolean bool = android.webkit.MimeTypeMap.getSingleton().hasExtension(paramString);
    AppMethodBeat.o(54578);
    return bool;
  }
  
  public boolean hasMimeType(String paramString)
  {
    AppMethodBeat.i(54576);
    if (isX5Core())
    {
      bool = getCoreMessy().mimeTypeMapHasMimeType(paramString);
      AppMethodBeat.o(54576);
      return bool;
    }
    boolean bool = android.webkit.MimeTypeMap.getSingleton().hasMimeType(paramString);
    AppMethodBeat.o(54576);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.sdk.MimeTypeMap
 * JD-Core Version:    0.7.0.1
 */