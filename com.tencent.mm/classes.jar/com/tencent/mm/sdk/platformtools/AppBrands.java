package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Callable;

public final class AppBrands
{
  private static Callable<AppBrandAppInfo> sAppBrandInfoGetterSupplier;
  
  static
  {
    AppMethodBeat.i(200837);
    sAppBrandInfoGetterSupplier = new Callable()
    {
      public final AppBrands.AppBrandAppInfo call()
      {
        return null;
      }
    };
    AppMethodBeat.o(200837);
  }
  
  public static AppBrandAppInfo getAppBrandInfo()
  {
    AppMethodBeat.i(200836);
    try
    {
      AppBrandAppInfo localAppBrandAppInfo = (AppBrandAppInfo)sAppBrandInfoGetterSupplier.call();
      AppMethodBeat.o(200836);
      return localAppBrandAppInfo;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(200836);
    }
    return null;
  }
  
  public static boolean isAppBrandProc()
  {
    AppMethodBeat.i(200835);
    boolean bool = MMApplicationContext.isAppBrandProcess();
    AppMethodBeat.o(200835);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.AppBrands
 * JD-Core Version:    0.7.0.1
 */