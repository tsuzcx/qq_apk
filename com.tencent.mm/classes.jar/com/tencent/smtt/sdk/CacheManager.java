package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.IX5CoreCacheManager;
import com.tencent.smtt.utils.k;
import java.io.File;
import java.io.InputStream;
import java.util.Map;

public final class CacheManager
  extends z
{
  @Deprecated
  public static boolean cacheDisabled()
  {
    AppMethodBeat.i(55084);
    if (isX5Core())
    {
      bool = getCacheManagerImpl().cacheDisabled();
      AppMethodBeat.o(55084);
      return bool;
    }
    Object localObject = k.a("android.webkit.CacheManager", "cacheDisabled");
    if (localObject == null)
    {
      AppMethodBeat.o(55084);
      return false;
    }
    boolean bool = ((Boolean)localObject).booleanValue();
    AppMethodBeat.o(55084);
    return bool;
  }
  
  public static InputStream getCacheFile(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(55086);
    if (isX5Core())
    {
      paramString = getCacheManagerImpl().getCacheFile(paramString, paramBoolean);
      AppMethodBeat.o(55086);
      return paramString;
    }
    AppMethodBeat.o(55086);
    return null;
  }
  
  public static Object getCacheFile(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(55085);
    if (isX5Core())
    {
      paramString = getCacheManagerImpl().getCacheFileBaseDir();
      AppMethodBeat.o(55085);
      return paramString;
    }
    try
    {
      paramString = k.a(Class.forName("android.webkit.CacheManager"), "getCacheFile", new Class[] { String.class, Map.class }, new Object[] { paramString, paramMap });
      AppMethodBeat.o(55085);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(55085);
    }
    return null;
  }
  
  @Deprecated
  public static File getCacheFileBaseDir()
  {
    AppMethodBeat.i(55083);
    if (isX5Core())
    {
      localFile = getCacheManagerImpl().getCacheFileBaseDir();
      AppMethodBeat.o(55083);
      return localFile;
    }
    File localFile = (File)k.a("android.webkit.CacheManager", "getCacheFileBaseDir");
    AppMethodBeat.o(55083);
    return localFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.sdk.CacheManager
 * JD-Core Version:    0.7.0.1
 */