package com.tencent.mm.sdk.systemservicecache;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/systemservicecache/NetworkCache;", "Lcom/tencent/mm/sdk/systemservicecache/ISystemServiceCache;", "Landroid/content/Context;", "()V", "TAG", "", "UPDATE_WIFI_CACHE_THREAD_NAME", "activeNetworkInfo", "Landroid/net/NetworkInfo;", "hasRegisteredNetworkBroadcast", "", "iosNetworkType", "", "networkCacheExpt", "networkType", "wapCacheExpt", "wifiCacheExpt", "getActiveNetworkInfoFromCache", "ctx", "getIOSNetTypeFromCache", "initCache", "", "isWapFromCache", "isWifiFromCache", "setNetworkCacheExpt", "expt", "setWapCacheExpt", "setWifiCacheExpt", "updateCache", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class NetworkCache
  implements ISystemServiceCache<Context>
{
  public static final NetworkCache INSTANCE;
  private static final String TAG = "NetWorkCache";
  private static final String UPDATE_WIFI_CACHE_THREAD_NAME = "SystemServiceCallingCache-UpdateNetWorkCache";
  private static NetworkInfo activeNetworkInfo;
  private static boolean hasRegisteredNetworkBroadcast;
  private static int iosNetworkType;
  private static boolean networkCacheExpt;
  private static int networkType;
  private static boolean wapCacheExpt;
  private static boolean wifiCacheExpt;
  
  static
  {
    AppMethodBeat.i(244209);
    INSTANCE = new NetworkCache();
    networkType = -100;
    iosNetworkType = -100;
    wifiCacheExpt = true;
    wapCacheExpt = true;
    networkCacheExpt = true;
    AppMethodBeat.o(244209);
  }
  
  private static final void initCache$lambda-1$lambda-0(Context paramContext)
  {
    AppMethodBeat.i(244177);
    paramContext.registerReceiver((BroadcastReceiver)new BroadcastReceiver()
    {
      private static final void onReceive$lambda-0(Context paramAnonymousContext)
      {
        AppMethodBeat.i(244184);
        NetworkCache localNetworkCache = NetworkCache.INSTANCE;
        NetworkCache.access$setActiveNetworkInfo$p(NetStatusUtil.getActiveNetworkInfo(paramAnonymousContext));
        if (NetworkCache.access$getActiveNetworkInfo$p() != null)
        {
          paramAnonymousContext = NetworkCache.INSTANCE;
          NetworkCache.access$setNetworkType$p(NetStatusUtil.getNetType(NetworkCache.access$getActiveNetworkInfo$p()));
          paramAnonymousContext = NetworkCache.INSTANCE;
          NetworkCache.access$setIosNetworkType$p(NetStatusUtil.getIOSNetType(NetworkCache.access$getActiveNetworkInfo$p()));
          Log.i("NetWorkCache", "initCache onReceive, networkType = " + NetworkCache.access$getNetworkType$p() + ", iosNetworkType = " + NetworkCache.access$getIosNetworkType$p());
        }
        AppMethodBeat.o(244184);
      }
      
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(244192);
        s.u(paramAnonymousContext, "context");
        s.u(paramAnonymousIntent, "intent");
        h.ahAA.g(new NetworkCache.initCache.1.1.1..ExternalSyntheticLambda0(this.$ctx), "SystemServiceCallingCache-UpdateNetWorkCache");
        AppMethodBeat.o(244192);
      }
    }, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    AppMethodBeat.o(244177);
  }
  
  private static final void updateCache$lambda-2(Context paramContext)
  {
    AppMethodBeat.i(244182);
    paramContext = NetStatusUtil.getActiveNetworkInfo(paramContext);
    activeNetworkInfo = paramContext;
    if (paramContext != null)
    {
      networkType = NetStatusUtil.getNetType(activeNetworkInfo);
      iosNetworkType = NetStatusUtil.getIOSNetType(activeNetworkInfo);
    }
    Log.i("NetWorkCache", "UpdateNetWorkCache updateCache, networkType = " + networkType + ", iosNetworkType = " + iosNetworkType);
    AppMethodBeat.o(244182);
  }
  
  public final NetworkInfo getActiveNetworkInfoFromCache(Context paramContext)
  {
    AppMethodBeat.i(244246);
    if (!networkCacheExpt)
    {
      paramContext = NetStatusUtil.getActiveNetworkInfo(paramContext);
      AppMethodBeat.o(244246);
      return paramContext;
    }
    if (activeNetworkInfo == null)
    {
      paramContext = NetStatusUtil.getActiveNetworkInfo(paramContext);
      activeNetworkInfo = paramContext;
      AppMethodBeat.o(244246);
      return paramContext;
    }
    updateCache(paramContext);
    Log.i("NetWorkCache", "getActiveNetworkInfoFromCache");
    paramContext = activeNetworkInfo;
    AppMethodBeat.o(244246);
    return paramContext;
  }
  
  public final int getIOSNetTypeFromCache(Context paramContext)
  {
    AppMethodBeat.i(244243);
    if (!networkCacheExpt)
    {
      i = NetStatusUtil.getIOSNetType(paramContext);
      AppMethodBeat.o(244243);
      return i;
    }
    if (iosNetworkType == -100)
    {
      i = NetStatusUtil.getIOSNetType(paramContext);
      iosNetworkType = i;
      AppMethodBeat.o(244243);
      return i;
    }
    updateCache(paramContext);
    Log.i("NetWorkCache", s.X("getIOSNetTypeFromCache, iosNetworkType = ", Integer.valueOf(iosNetworkType)));
    int i = iosNetworkType;
    AppMethodBeat.o(244243);
    return i;
  }
  
  public final void initCache(Context paramContext)
  {
    AppMethodBeat.i(244224);
    if (paramContext == null)
    {
      Log.e("NetWorkCache", "initCache error ctx is null");
      AppMethodBeat.o(244224);
      return;
    }
    try
    {
      Log.i("NetWorkCache", s.X("registerNetWorkBroadCastReceiver = ", Boolean.valueOf(hasRegisteredNetworkBroadcast)));
      boolean bool = hasRegisteredNetworkBroadcast;
      if (bool) {
        return;
      }
      h.ahAA.bm(new NetworkCache..ExternalSyntheticLambda0(paramContext));
      hasRegisteredNetworkBroadcast = true;
      paramContext = ah.aiuX;
      return;
    }
    finally
    {
      AppMethodBeat.o(244224);
    }
  }
  
  public final boolean isWapFromCache(Context paramContext)
  {
    AppMethodBeat.i(244239);
    if (!wapCacheExpt)
    {
      bool = NetStatusUtil.isWap(paramContext);
      AppMethodBeat.o(244239);
      return bool;
    }
    if (networkType == -100)
    {
      int i = NetStatusUtil.getNetType(paramContext);
      networkType = i;
      bool = NetStatusUtil.isWap(i);
      AppMethodBeat.o(244239);
      return bool;
    }
    updateCache(paramContext);
    boolean bool = NetStatusUtil.isWap(networkType);
    AppMethodBeat.o(244239);
    return bool;
  }
  
  public final boolean isWifiFromCache(Context paramContext)
  {
    AppMethodBeat.i(244235);
    if (!wifiCacheExpt)
    {
      bool = NetStatusUtil.isWifi(paramContext);
      AppMethodBeat.o(244235);
      return bool;
    }
    if (networkType == -100)
    {
      int i = NetStatusUtil.getNetType(paramContext);
      networkType = i;
      bool = NetStatusUtil.isWifi(i);
      AppMethodBeat.o(244235);
      return bool;
    }
    updateCache(paramContext);
    boolean bool = NetStatusUtil.isWifi(networkType);
    AppMethodBeat.o(244235);
    return bool;
  }
  
  public final void setNetworkCacheExpt(boolean paramBoolean)
  {
    networkCacheExpt = paramBoolean;
  }
  
  public final void setWapCacheExpt(boolean paramBoolean)
  {
    wapCacheExpt = paramBoolean;
  }
  
  public final void setWifiCacheExpt(boolean paramBoolean)
  {
    wifiCacheExpt = paramBoolean;
  }
  
  public final void updateCache(Context paramContext)
  {
    AppMethodBeat.i(244229);
    h.ahAA.g(new NetworkCache..ExternalSyntheticLambda1(paramContext), "SystemServiceCallingCache-UpdateNetWorkCache");
    AppMethodBeat.o(244229);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sdk.systemservicecache.NetworkCache
 * JD-Core Version:    0.7.0.1
 */