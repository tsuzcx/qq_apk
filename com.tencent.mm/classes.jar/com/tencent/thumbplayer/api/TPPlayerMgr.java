package com.tencent.thumbplayer.api;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.common.ITPNativeLibraryExternalLoader;
import com.tencent.thumbplayer.core.common.ITPNativeLogCallback;
import com.tencent.thumbplayer.core.common.TPNativeLibraryLoader;
import com.tencent.thumbplayer.core.common.TPNativeLog;
import com.tencent.thumbplayer.core.common.TPThumbplayerCapabilityHelper;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyNativeLibLoader;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPProxyAdapter;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyHelper;
import com.tencent.thumbplayer.utils.TPNetworkChangeMonitor;
import com.tencent.thumbplayer.utils.e;
import com.tencent.thumbplayer.utils.g;

public class TPPlayerMgr
{
  public static final String BEACON_LOG_HOST_KEY = "beacon_log_host";
  public static final String BEACON_PLYAER_HOST_KEY = "player_host_config";
  public static final String BEACON_POLICY_HOST_KEY = "beacon_policy_host";
  public static final int EVENT_ID_APP_ENTER_BACKGROUND = 100001;
  public static final int EVENT_ID_APP_ENTER_FOREGROUND = 100002;
  private static final String TAG = "TPThumbPlayer[TPPlayerMgr.java]";
  public static final String TP_DOWNLOAD_PROXY_MODULE_NAME = "DownloadProxy";
  public static final String TP_PLAYERCORE_MODULE_NAME = "TPCore";
  private static boolean isInit;
  private static Context mAppContext;
  
  public static Context getAppContext()
  {
    return mAppContext;
  }
  
  public static String getLibVersion(String paramString)
  {
    AppMethodBeat.i(219879);
    if (!isInit)
    {
      paramString = new IllegalStateException("player not initialized");
      AppMethodBeat.o(219879);
      throw paramString;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.equals("DownloadProxy"))
      {
        paramString = TPDownloadProxyHelper.getNativeLibVersion();
        AppMethodBeat.o(219879);
        return paramString;
      }
      if (paramString.equals("TPCore"))
      {
        paramString = TPNativeLibraryLoader.getLibVersion();
        AppMethodBeat.o(219879);
        return paramString;
      }
    }
    paramString = new IllegalArgumentException("libName:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(219879);
    throw paramString;
  }
  
  public static String getThumbPlayerVersion()
  {
    return "2.9.0.1112";
  }
  
  public static void initSdk(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(219852);
    if (!isInit)
    {
      g.i("TPThumbPlayer[TPPlayerMgr.java]", "Enter initSdk");
      isInit = true;
      mAppContext = paramContext.getApplicationContext();
      com.tencent.thumbplayer.d.a.setGuid(paramString);
      com.tencent.thumbplayer.d.a.setPlatform(paramInt);
      TPNetworkChangeMonitor.irQ().init(mAppContext);
      g.i("TPThumbPlayer[TPPlayerMgr.java]", "Enter initSdk for monitor");
      g.i("TPThumbPlayer[TPPlayerMgr.java]", "Enter initSdk for report");
      TPNativeLog.setLogCallback(new ITPNativeLogCallback()
      {
        public final void onPrintLog(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(219823);
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(219823);
            return;
            g.v(paramAnonymousString1, paramAnonymousString2);
            AppMethodBeat.o(219823);
            return;
            g.d(paramAnonymousString1, paramAnonymousString2);
            AppMethodBeat.o(219823);
            return;
            g.i(paramAnonymousString1, paramAnonymousString2);
            AppMethodBeat.o(219823);
            return;
            g.w(paramAnonymousString1, paramAnonymousString2);
            AppMethodBeat.o(219823);
            return;
            g.e(paramAnonymousString1, paramAnonymousString2);
          }
        }
      });
    }
    try
    {
      TPNativeLibraryLoader.loadLibIfNeeded(mAppContext);
      g.i("TPThumbPlayer[TPPlayerMgr.java]", "Enter initSdk for loadlib");
      com.tencent.thumbplayer.a.a.b.a.init(mAppContext);
      g.i("TPThumbPlayer[TPPlayerMgr.java]", "Enter initSdk for drm cap");
      TPThumbplayerCapabilityHelper.init(mAppContext, true);
      g.i("TPThumbPlayer[TPPlayerMgr.java]", "Enter initSdk DONE");
      AppMethodBeat.o(219852);
      return;
    }
    catch (UnsupportedOperationException paramContext)
    {
      for (;;)
      {
        g.e("TPThumbPlayer[TPPlayerMgr.java]", paramContext);
      }
    }
  }
  
  public static boolean isProxyEnable()
  {
    AppMethodBeat.i(219862);
    if ((com.tencent.thumbplayer.d.a.iqK()) && (TPDownloadProxyHelper.isReadyForPlay()))
    {
      AppMethodBeat.o(219862);
      return true;
    }
    AppMethodBeat.o(219862);
    return false;
  }
  
  public static boolean isThumbPlayerEnable()
  {
    AppMethodBeat.i(219870);
    boolean bool = TPNativeLibraryLoader.isLibLoaded();
    AppMethodBeat.o(219870);
    return bool;
  }
  
  public static void postEvent(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    AppMethodBeat.i(219871);
    e.g(paramInt1, paramInt2, paramInt3, paramObject);
    AppMethodBeat.o(219871);
  }
  
  public static void setDebugEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(219856);
    com.tencent.thumbplayer.d.a.setDebugEnable(paramBoolean);
    AppMethodBeat.o(219856);
  }
  
  public static void setHost(String paramString)
  {
    AppMethodBeat.i(219854);
    com.tencent.thumbplayer.d.a.bDs(paramString);
    AppMethodBeat.o(219854);
  }
  
  public static void setLibLoader(ITPModuleLoader paramITPModuleLoader)
  {
    AppMethodBeat.i(219875);
    if (isInit)
    {
      paramITPModuleLoader = new IllegalStateException("player has init");
      AppMethodBeat.o(219875);
      throw paramITPModuleLoader;
    }
    TPNativeLibraryLoader.setLibLoader(new ITPNativeLibraryExternalLoader()
    {
      public final boolean loadLib(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(219826);
        if (this.val$loader != null) {
          try
          {
            this.val$loader.loadLibrary(paramAnonymousString1, paramAnonymousString2);
            AppMethodBeat.o(219826);
            return true;
          }
          catch (Throwable paramAnonymousString1)
          {
            g.e("TPThumbPlayer[TPPlayerMgr.java]", paramAnonymousString1);
          }
        }
        AppMethodBeat.o(219826);
        return false;
      }
    });
    TPDownloadProxyHelper.setNativeLibLoader(new ITPDLProxyNativeLibLoader()
    {
      public final boolean loadLib(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(219831);
        if (this.val$loader != null) {
          try
          {
            this.val$loader.loadLibrary(paramAnonymousString1, paramAnonymousString2);
            AppMethodBeat.o(219831);
            return true;
          }
          catch (Throwable paramAnonymousString1)
          {
            g.e("TPThumbPlayer[TPPlayerMgr.java]", paramAnonymousString1);
          }
        }
        AppMethodBeat.o(219831);
        return false;
      }
    });
    AppMethodBeat.o(219875);
  }
  
  public static void setOnLogListener(OnLogListener paramOnLogListener)
  {
    AppMethodBeat.i(219857);
    g.setOnLogListener(paramOnLogListener);
    AppMethodBeat.o(219857);
  }
  
  public static void setOutNetIP(String paramString)
  {
    AppMethodBeat.i(219868);
    com.tencent.thumbplayer.d.a.bDv(paramString);
    AppMethodBeat.o(219868);
  }
  
  public static void setProxyEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(219859);
    com.tencent.thumbplayer.d.a.Iu(paramBoolean);
    AppMethodBeat.o(219859);
  }
  
  public static void setProxyServiceType(int paramInt)
  {
    AppMethodBeat.i(219869);
    com.tencent.thumbplayer.d.a.setProxyServiceType(paramInt);
    AppMethodBeat.o(219869);
  }
  
  public static void setTPProxyAdapter(ITPProxyAdapter paramITPProxyAdapter)
  {
    AppMethodBeat.i(219877);
    TPDownloadProxyHelper.setTPProxyAdapter(paramITPProxyAdapter);
    AppMethodBeat.o(219877);
  }
  
  public static void setUpcInfo(String paramString, int paramInt)
  {
    AppMethodBeat.i(219867);
    com.tencent.thumbplayer.d.a.bDu(paramString);
    com.tencent.thumbplayer.d.a.aBa(paramInt);
    e.g(100003, paramInt, 0, paramString);
    AppMethodBeat.o(219867);
  }
  
  public static void setUserInfo(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(219865);
    com.tencent.thumbplayer.d.a.bDt(paramString);
    com.tencent.thumbplayer.d.a.Iv(paramBoolean);
    AppMethodBeat.o(219865);
  }
  
  public static abstract interface OnLogListener
  {
    public abstract int d(String paramString1, String paramString2);
    
    public abstract int e(String paramString1, String paramString2);
    
    public abstract int i(String paramString1, String paramString2);
    
    public abstract int v(String paramString1, String paramString2);
    
    public abstract int w(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.api.TPPlayerMgr
 * JD-Core Version:    0.7.0.1
 */