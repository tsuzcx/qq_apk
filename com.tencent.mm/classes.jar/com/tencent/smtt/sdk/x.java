package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.IX5CoreCacheManager;
import com.tencent.smtt.export.external.interfaces.IX5CoreCookieManager;
import com.tencent.smtt.export.external.interfaces.IX5CoreEntry;
import com.tencent.smtt.export.external.interfaces.IX5CoreGeolocationPermissions;
import com.tencent.smtt.export.external.interfaces.IX5CoreJsCore;
import com.tencent.smtt.export.external.interfaces.IX5CoreMessy;
import com.tencent.smtt.export.external.interfaces.IX5CoreNetwork;
import com.tencent.smtt.export.external.interfaces.IX5CoreUrlUtil;
import com.tencent.smtt.export.external.interfaces.IX5CoreWebIconDB;
import com.tencent.smtt.export.external.interfaces.IX5CoreWebStorage;
import com.tencent.smtt.export.external.interfaces.IX5CoreWebViewDB;

public class x
{
  public static IX5CoreCacheManager getCacheManagerImpl()
  {
    AppMethodBeat.i(54501);
    IX5CoreCacheManager localIX5CoreCacheManager = TbsOneGreyInfoHelper.getCoreEntry().getX5CoreCacheManager();
    AppMethodBeat.o(54501);
    return localIX5CoreCacheManager;
  }
  
  public static IX5CoreCookieManager getCookieManagerImpl()
  {
    AppMethodBeat.i(54500);
    IX5CoreCookieManager localIX5CoreCookieManager = TbsOneGreyInfoHelper.getCoreEntry().getX5CoreCookieManager();
    AppMethodBeat.o(54500);
    return localIX5CoreCookieManager;
  }
  
  public static IX5CoreMessy getCoreMessy()
  {
    AppMethodBeat.i(54508);
    IX5CoreMessy localIX5CoreMessy = TbsOneGreyInfoHelper.getCoreEntry().getX5CoreMessy();
    AppMethodBeat.o(54508);
    return localIX5CoreMessy;
  }
  
  public static IX5CoreGeolocationPermissions getGeolocationPermissionsImpl()
  {
    AppMethodBeat.i(54505);
    IX5CoreGeolocationPermissions localIX5CoreGeolocationPermissions = TbsOneGreyInfoHelper.getCoreEntry().getX5CoreGeolocationPermissions();
    AppMethodBeat.o(54505);
    return localIX5CoreGeolocationPermissions;
  }
  
  public static IX5CoreJsCore getJSCoreImpl()
  {
    AppMethodBeat.i(54506);
    IX5CoreJsCore localIX5CoreJsCore = TbsOneGreyInfoHelper.getCoreEntry().getX5CoreJsCore();
    AppMethodBeat.o(54506);
    return localIX5CoreJsCore;
  }
  
  public static IX5CoreWebIconDB getWebIconDBImpl()
  {
    AppMethodBeat.i(54503);
    IX5CoreWebIconDB localIX5CoreWebIconDB = TbsOneGreyInfoHelper.getCoreEntry().getX5CoreWebIconDB();
    AppMethodBeat.o(54503);
    return localIX5CoreWebIconDB;
  }
  
  public static IX5CoreWebStorage getWebStorageImpl()
  {
    AppMethodBeat.i(54504);
    IX5CoreWebStorage localIX5CoreWebStorage = TbsOneGreyInfoHelper.getCoreEntry().getX5CoreWebStorage();
    AppMethodBeat.o(54504);
    return localIX5CoreWebStorage;
  }
  
  public static IX5CoreWebViewDB getWebViewDBImpl()
  {
    AppMethodBeat.i(54507);
    IX5CoreWebViewDB localIX5CoreWebViewDB = TbsOneGreyInfoHelper.getCoreEntry().getX5CoreWebViewDB();
    AppMethodBeat.o(54507);
    return localIX5CoreWebViewDB;
  }
  
  public static IX5CoreNetwork getX5CoreNetwork()
  {
    AppMethodBeat.i(54509);
    IX5CoreNetwork localIX5CoreNetwork = TbsOneGreyInfoHelper.getCoreEntry().getX5CoreNetwork();
    AppMethodBeat.o(54509);
    return localIX5CoreNetwork;
  }
  
  public static IX5CoreUrlUtil getX5CoreUrlUtilImpl()
  {
    AppMethodBeat.i(54502);
    IX5CoreUrlUtil localIX5CoreUrlUtil = TbsOneGreyInfoHelper.getCoreEntry().getX5CoreUrlUtil();
    AppMethodBeat.o(54502);
    return localIX5CoreUrlUtil;
  }
  
  public static boolean isX5Core()
  {
    AppMethodBeat.i(54499);
    v localv = v.a();
    if ((localv != null) && (localv.b()))
    {
      AppMethodBeat.o(54499);
      return true;
    }
    AppMethodBeat.o(54499);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.x
 * JD-Core Version:    0.7.0.1
 */