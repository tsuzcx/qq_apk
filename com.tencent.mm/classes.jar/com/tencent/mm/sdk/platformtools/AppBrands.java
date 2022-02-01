package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Callable;

public final class AppBrands
{
  private static Callable<AppBrands.AppBrandAppInfo> sAppBrandInfoGetterSupplier;
  
  static
  {
    AppMethodBeat.i(244127);
    sAppBrandInfoGetterSupplier = new Callable()
    {
      public AppBrands.AppBrandAppInfo call()
      {
        return null;
      }
    };
    AppMethodBeat.o(244127);
  }
  
  public static AppBrands.AppBrandAppInfo getAppBrandInfo()
  {
    AppMethodBeat.i(244119);
    try
    {
      AppBrands.AppBrandAppInfo localAppBrandAppInfo = (AppBrands.AppBrandAppInfo)sAppBrandInfoGetterSupplier.call();
      AppMethodBeat.o(244119);
      return localAppBrandAppInfo;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(244119);
    }
    return null;
  }
  
  public static boolean isAppBrandProc()
  {
    AppMethodBeat.i(244112);
    boolean bool = MMApplicationContext.isAppBrandProcess();
    AppMethodBeat.o(244112);
    return bool;
  }
  
  public static void setAppBrandInfoGetterSupplier(Callable<AppBrands.AppBrandAppInfo> paramCallable)
  {
    sAppBrandInfoGetterSupplier = paramCallable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.AppBrands
 * JD-Core Version:    0.7.0.1
 */