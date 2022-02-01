package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Callable;

public final class AppBrands
{
  private static Callable<AppBrandAppInfo> sAppBrandInfoGetterSupplier;
  
  static
  {
    AppMethodBeat.i(249019);
    sAppBrandInfoGetterSupplier = new Callable()
    {
      public final AppBrands.AppBrandAppInfo call()
      {
        return null;
      }
    };
    AppMethodBeat.o(249019);
  }
  
  public static AppBrandAppInfo getAppBrandInfo()
  {
    AppMethodBeat.i(249018);
    try
    {
      AppBrandAppInfo localAppBrandAppInfo = (AppBrandAppInfo)sAppBrandInfoGetterSupplier.call();
      AppMethodBeat.o(249018);
      return localAppBrandAppInfo;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(249018);
    }
    return null;
  }
  
  public static boolean isAppBrandProc()
  {
    AppMethodBeat.i(249016);
    boolean bool = MMApplicationContext.isAppBrandProcess();
    AppMethodBeat.o(249016);
    return bool;
  }
  
  public static void setAppBrandInfoGetterSupplier(Callable<AppBrandAppInfo> paramCallable)
  {
    sAppBrandInfoGetterSupplier = paramCallable;
  }
  
  public static final class AppBrandAppInfo
  {
    public String appId;
    public String appName;
    public int appType;
    public int appVersion;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.AppBrands
 * JD-Core Version:    0.7.0.1
 */