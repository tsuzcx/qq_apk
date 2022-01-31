package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.r;
import java.io.File;
import java.io.InputStream;
import java.util.Map;

public final class CacheManager
{
  @Deprecated
  public static boolean cacheDisabled()
  {
    AppMethodBeat.i(63859);
    Object localObject = bz.a();
    if ((localObject != null) && (((bz)localObject).b()))
    {
      bool = ((Boolean)((bz)localObject).c().c()).booleanValue();
      AppMethodBeat.o(63859);
      return bool;
    }
    localObject = r.a("android.webkit.CacheManager", "cacheDisabled");
    if (localObject == null)
    {
      AppMethodBeat.o(63859);
      return false;
    }
    boolean bool = ((Boolean)localObject).booleanValue();
    AppMethodBeat.o(63859);
    return bool;
  }
  
  public static InputStream getCacheFile(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(63861);
    bz localbz = bz.a();
    if ((localbz != null) && (localbz.b()))
    {
      paramString = localbz.c().a(paramString, paramBoolean);
      AppMethodBeat.o(63861);
      return paramString;
    }
    AppMethodBeat.o(63861);
    return null;
  }
  
  public static Object getCacheFile(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(63860);
    bz localbz = bz.a();
    if ((localbz != null) && (localbz.b()))
    {
      paramString = localbz.c().g();
      AppMethodBeat.o(63860);
      return paramString;
    }
    try
    {
      paramString = r.a(Class.forName("android.webkit.CacheManager"), "getCacheFile", new Class[] { String.class, Map.class }, new Object[] { paramString, paramMap });
      AppMethodBeat.o(63860);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(63860);
    }
    return null;
  }
  
  @Deprecated
  public static File getCacheFileBaseDir()
  {
    AppMethodBeat.i(63858);
    Object localObject = bz.a();
    if ((localObject != null) && (((bz)localObject).b()))
    {
      localObject = (File)((bz)localObject).c().g();
      AppMethodBeat.o(63858);
      return localObject;
    }
    localObject = (File)r.a("android.webkit.CacheManager", "getCacheFileBaseDir");
    AppMethodBeat.o(63858);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.smtt.sdk.CacheManager
 * JD-Core Version:    0.7.0.1
 */