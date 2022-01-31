package com.tencent.smtt.sdk;

import com.tencent.smtt.utils.q;
import java.io.File;
import java.io.InputStream;
import java.util.Map;

public final class CacheManager
{
  @Deprecated
  public static boolean cacheDisabled()
  {
    Object localObject = bv.a();
    if ((localObject != null) && (((bv)localObject).b())) {
      return ((Boolean)((bv)localObject).c().c()).booleanValue();
    }
    localObject = q.a("android.webkit.CacheManager", "cacheDisabled");
    if (localObject == null) {
      return false;
    }
    return ((Boolean)localObject).booleanValue();
  }
  
  public static InputStream getCacheFile(String paramString, boolean paramBoolean)
  {
    bv localbv = bv.a();
    if ((localbv != null) && (localbv.b())) {
      return localbv.c().a(paramString, paramBoolean);
    }
    return null;
  }
  
  public static Object getCacheFile(String paramString, Map<String, String> paramMap)
  {
    bv localbv = bv.a();
    if ((localbv != null) && (localbv.b())) {
      return localbv.c().g();
    }
    try
    {
      paramString = q.a(Class.forName("android.webkit.CacheManager"), "getCacheFile", new Class[] { String.class, Map.class }, new Object[] { paramString, paramMap });
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  @Deprecated
  public static File getCacheFileBaseDir()
  {
    bv localbv = bv.a();
    if ((localbv != null) && (localbv.b())) {
      return (File)localbv.c().g();
    }
    return (File)q.a("android.webkit.CacheManager", "getCacheFileBaseDir");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.smtt.sdk.CacheManager
 * JD-Core Version:    0.7.0.1
 */