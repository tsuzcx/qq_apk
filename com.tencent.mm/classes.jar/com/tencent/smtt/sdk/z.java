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

public class z
{
  public static IX5CoreCacheManager getCacheManagerImpl()
  {
    AppMethodBeat.i(194478);
    IX5CoreCacheManager localIX5CoreCacheManager = TbsOneGreyInfoHelper.getCoreEntry().getX5CoreCacheManager();
    AppMethodBeat.o(194478);
    return localIX5CoreCacheManager;
  }
  
  public static IX5CoreCookieManager getCookieManagerImpl()
  {
    AppMethodBeat.i(194477);
    IX5CoreCookieManager localIX5CoreCookieManager = TbsOneGreyInfoHelper.getCoreEntry().getX5CoreCookieManager();
    AppMethodBeat.o(194477);
    return localIX5CoreCookieManager;
  }
  
  public static IX5CoreMessy getCoreMessy()
  {
    AppMethodBeat.i(194493);
    IX5CoreMessy localIX5CoreMessy = TbsOneGreyInfoHelper.getCoreEntry().getX5CoreMessy();
    AppMethodBeat.o(194493);
    return localIX5CoreMessy;
  }
  
  public static IX5CoreGeolocationPermissions getGeolocationPermissionsImpl()
  {
    AppMethodBeat.i(194486);
    IX5CoreGeolocationPermissions localIX5CoreGeolocationPermissions = TbsOneGreyInfoHelper.getCoreEntry().getX5CoreGeolocationPermissions();
    AppMethodBeat.o(194486);
    return localIX5CoreGeolocationPermissions;
  }
  
  public static IX5CoreJsCore getJSCoreImpl()
  {
    AppMethodBeat.i(194488);
    IX5CoreJsCore localIX5CoreJsCore = TbsOneGreyInfoHelper.getCoreEntry().getX5CoreJsCore();
    AppMethodBeat.o(194488);
    return localIX5CoreJsCore;
  }
  
  public static IX5CoreWebIconDB getWebIconDBImpl()
  {
    AppMethodBeat.i(194482);
    IX5CoreWebIconDB localIX5CoreWebIconDB = TbsOneGreyInfoHelper.getCoreEntry().getX5CoreWebIconDB();
    AppMethodBeat.o(194482);
    return localIX5CoreWebIconDB;
  }
  
  public static IX5CoreWebStorage getWebStorageImpl()
  {
    AppMethodBeat.i(194484);
    IX5CoreWebStorage localIX5CoreWebStorage = TbsOneGreyInfoHelper.getCoreEntry().getX5CoreWebStorage();
    AppMethodBeat.o(194484);
    return localIX5CoreWebStorage;
  }
  
  public static IX5CoreWebViewDB getWebViewDBImpl()
  {
    AppMethodBeat.i(194491);
    IX5CoreWebViewDB localIX5CoreWebViewDB = TbsOneGreyInfoHelper.getCoreEntry().getX5CoreWebViewDB();
    AppMethodBeat.o(194491);
    return localIX5CoreWebViewDB;
  }
  
  public static IX5CoreNetwork getX5CoreNetwork()
  {
    AppMethodBeat.i(194496);
    IX5CoreNetwork localIX5CoreNetwork = TbsOneGreyInfoHelper.getCoreEntry().getX5CoreNetwork();
    AppMethodBeat.o(194496);
    return localIX5CoreNetwork;
  }
  
  public static IX5CoreUrlUtil getX5CoreUrlUtilImpl()
  {
    AppMethodBeat.i(194480);
    IX5CoreUrlUtil localIX5CoreUrlUtil = TbsOneGreyInfoHelper.getCoreEntry().getX5CoreUrlUtil();
    AppMethodBeat.o(194480);
    return localIX5CoreUrlUtil;
  }
  
  public static boolean isX5Core()
  {
    AppMethodBeat.i(194474);
    x localx = x.a();
    if ((localx != null) && (localx.b()))
    {
      AppMethodBeat.o(194474);
      return true;
    }
    AppMethodBeat.o(194474);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.z
 * JD-Core Version:    0.7.0.1
 */