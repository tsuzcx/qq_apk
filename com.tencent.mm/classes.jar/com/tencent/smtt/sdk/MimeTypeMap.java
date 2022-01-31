package com.tencent.smtt.sdk;

public class MimeTypeMap
{
  private static MimeTypeMap a;
  
  public static String getFileExtensionFromUrl(String paramString)
  {
    bv localbv = bv.a();
    if ((localbv != null) && (localbv.b())) {
      return localbv.c().h(paramString);
    }
    return android.webkit.MimeTypeMap.getFileExtensionFromUrl(paramString);
  }
  
  public static MimeTypeMap getSingleton()
  {
    try
    {
      if (a == null) {
        a = new MimeTypeMap();
      }
      MimeTypeMap localMimeTypeMap = a;
      return localMimeTypeMap;
    }
    finally {}
  }
  
  public String getExtensionFromMimeType(String paramString)
  {
    bv localbv = bv.a();
    if ((localbv != null) && (localbv.b())) {
      return localbv.c().l(paramString);
    }
    return android.webkit.MimeTypeMap.getSingleton().getExtensionFromMimeType(paramString);
  }
  
  public String getMimeTypeFromExtension(String paramString)
  {
    bv localbv = bv.a();
    if ((localbv != null) && (localbv.b())) {
      return localbv.c().j(paramString);
    }
    return android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(paramString);
  }
  
  public boolean hasExtension(String paramString)
  {
    bv localbv = bv.a();
    if ((localbv != null) && (localbv.b())) {
      return localbv.c().k(paramString);
    }
    return android.webkit.MimeTypeMap.getSingleton().hasExtension(paramString);
  }
  
  public boolean hasMimeType(String paramString)
  {
    bv localbv = bv.a();
    if ((localbv != null) && (localbv.b())) {
      return localbv.c().i(paramString);
    }
    return android.webkit.MimeTypeMap.getSingleton().hasMimeType(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.smtt.sdk.MimeTypeMap
 * JD-Core Version:    0.7.0.1
 */