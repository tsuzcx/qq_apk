package com.tencent.thumbplayer.core.downloadproxy.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.downloadproxy.apiinner.TPListenerManager;
import com.tencent.thumbplayer.core.downloadproxy.apiinner.TPProxyAdapterManager;
import com.tencent.thumbplayer.core.downloadproxy.jni.TPDownloadProxyNative;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLFileSystem;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyLog;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyUtils;
import java.io.File;

public class TPDownloadProxy
  implements ITPDownloadProxy
{
  private static final String FILE_NAME = "TPDownloadProxy";
  private boolean IsInit = false;
  private String mCurrentStoragePath;
  private int mServiceType;
  
  public TPDownloadProxy(int paramInt)
  {
    this.mServiceType = paramInt;
  }
  
  public int deinit()
  {
    AppMethodBeat.i(191386);
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        int i = TPDownloadProxyNative.getInstance().deInitService(this.mServiceType);
        AppMethodBeat.o(191386);
        return i;
      }
      catch (Throwable localThrowable)
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "deinit failed, error:" + localThrowable.toString());
      }
    }
    AppMethodBeat.o(191386);
    return -1;
  }
  
  public String getClipPlayUrl(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(191392);
    String str2 = TPProxyAdapterManager.getInstance().getProxyClipUrl(paramInt1, paramInt2);
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      str1 = str2;
      if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
        str1 = str2;
      }
    }
    try
    {
      str2 = TPDLProxyUtils.byteArrayToString(TPDownloadProxyNative.getInstance().getClipPlayUrl(paramInt1, paramInt2));
      str1 = str2;
      TPDownloadProxyNative.getInstance().startDownload(paramInt1);
      str1 = str2;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "getClipPlayUrl failed, error:" + localThrowable.toString());
      }
    }
    AppMethodBeat.o(191392);
    return str1;
  }
  
  public String getPlayErrorCodeStr(int paramInt)
  {
    AppMethodBeat.i(191393);
    String str3 = "";
    String str1 = str3;
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {}
    try
    {
      str1 = TPDLProxyUtils.byteArrayToString(TPDownloadProxyNative.getInstance().getErrorCodeStr(paramInt));
      AppMethodBeat.o(191393);
      return str1;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "getPlayErrorCodeStr failed, error:" + localThrowable.toString());
        String str2 = str3;
      }
    }
  }
  
  public String getPlayUrl(int paramInt)
  {
    AppMethodBeat.i(191391);
    String str2 = TPProxyAdapterManager.getInstance().getProxyClipUrl(paramInt, 1);
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      str1 = str2;
      if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
        str1 = str2;
      }
    }
    try
    {
      str2 = TPDLProxyUtils.byteArrayToString(TPDownloadProxyNative.getInstance().getClipPlayUrl(paramInt, 1));
      str1 = str2;
      TPDownloadProxyNative.getInstance().startDownload(paramInt);
      str1 = str2;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "getPlayUrl failed, error:" + localThrowable.toString());
      }
    }
    AppMethodBeat.o(191391);
    return str1;
  }
  
  public int init(Context paramContext, TPDLProxyInitParam paramTPDLProxyInitParam)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(191385);
        if (this.IsInit)
        {
          TPDLProxyLog.i("TPDownloadProxy", 0, "tpdlnative", "download already init");
          AppMethodBeat.o(191385);
          return i;
        }
        bool = TPDownloadProxyNative.getInstance().isNativeLoaded();
        if (!bool) {}
      }
      finally
      {
        try
        {
          if (!TextUtils.isEmpty(paramTPDLProxyInitParam.getAppVer())) {
            setUserData("app_version_name", paramTPDLProxyInitParam.getAppVer());
          }
          if (paramTPDLProxyInitParam.getPlatform() > 0) {
            setUserData("platform", Integer.valueOf(paramTPDLProxyInitParam.getPlatform()));
          }
          if (!TextUtils.isEmpty(paramTPDLProxyInitParam.getGuid())) {
            setUserData("guid", paramTPDLProxyInitParam.getGuid());
          }
          str2 = paramTPDLProxyInitParam.getCacheDir();
          boolean bool = TextUtils.isEmpty(str2);
          Object localObject = str2;
          if (bool)
          {
            localObject = str2;
            if (paramContext == null) {}
          }
          try
          {
            File localFile = TPDLFileSystem.getProperCacheDirectory(paramContext, "download");
            localObject = str2;
            if (localFile != null) {
              localObject = localFile.getAbsolutePath();
            }
          }
          catch (Throwable localThrowable)
          {
            TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "init get cache dir failed, error:" + localThrowable.toString());
            str1 = str2;
            continue;
          }
          TPListenerManager.getInstance().initHandler();
          if ((!TextUtils.isEmpty(paramTPDLProxyInitParam.getDataDir())) || (TextUtils.isEmpty(this.mCurrentStoragePath))) {
            break label354;
          }
          i = TPDownloadProxyNative.getInstance().initService(this.mServiceType, (String)localObject, this.mCurrentStoragePath, paramTPDLProxyInitParam.getConfigDir());
          paramTPDLProxyInitParam = new IntentFilter();
          paramTPDLProxyInitParam.addAction("android.intent.action.SCREEN_OFF");
          paramTPDLProxyInitParam.addAction("android.intent.action.SCREEN_ON");
          paramTPDLProxyInitParam.addAction("android.intent.action.USER_PRESENT");
          localObject = new BroadcastReceiver()
          {
            public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
            {
              AppMethodBeat.i(191384);
              paramAnonymousContext = paramAnonymousIntent.getAction();
              if ("android.intent.action.SCREEN_OFF".equals(paramAnonymousContext))
              {
                TPDownloadProxy.this.pushEvent(20);
                AppMethodBeat.o(191384);
                return;
              }
              if ("android.intent.action.SCREEN_ON".equals(paramAnonymousContext)) {
                TPDownloadProxy.this.pushEvent(19);
              }
              AppMethodBeat.o(191384);
            }
          };
          if (paramContext != null) {
            paramContext.registerReceiver((BroadcastReceiver)localObject, paramTPDLProxyInitParam);
          }
          if (i == 0) {
            this.IsInit = true;
          }
          AppMethodBeat.o(191385);
        }
        catch (Throwable paramContext)
        {
          String str2;
          TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "init failed, error:" + paramContext.toString());
        }
        paramContext = finally;
      }
      String str1;
      i = -1;
      AppMethodBeat.o(191385);
      continue;
      label354:
      i = TPDownloadProxyNative.getInstance().initService(this.mServiceType, str1, paramTPDLProxyInitParam.getDataDir(), paramTPDLProxyInitParam.getConfigDir());
    }
  }
  
  public int pauseDownload(int paramInt)
  {
    AppMethodBeat.i(191395);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(191395);
      return -1;
    }
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        paramInt = TPDownloadProxyNative.getInstance().pauseDownload(paramInt);
        AppMethodBeat.o(191395);
        return paramInt;
      }
      catch (Throwable localThrowable)
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "pauseDownload failed, error:" + localThrowable.toString());
      }
    }
    AppMethodBeat.o(191395);
    return -1;
  }
  
  public void pushEvent(int paramInt)
  {
    AppMethodBeat.i(191407);
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        TPDownloadProxyNative.getInstance().pushEvent(paramInt);
        AppMethodBeat.o(191407);
        return;
      }
      catch (Throwable localThrowable)
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "pushEvent failed, error:" + localThrowable.toString());
      }
    }
    AppMethodBeat.o(191407);
  }
  
  public int removeOfflineDownload(String paramString)
  {
    AppMethodBeat.i(191402);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(191402);
      return -1;
    }
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        int i = TPDownloadProxyNative.getInstance().deleteOfflineCache(paramString);
        AppMethodBeat.o(191402);
        return i;
      }
      catch (Throwable paramString)
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "removeOfflineDownload failed, error:" + paramString.toString());
      }
    }
    AppMethodBeat.o(191402);
    return -1;
  }
  
  public int resumeDownload(int paramInt)
  {
    AppMethodBeat.i(191396);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(191396);
      return -1;
    }
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        paramInt = TPDownloadProxyNative.getInstance().resumeDownload(paramInt);
        AppMethodBeat.o(191396);
        return paramInt;
      }
      catch (Throwable localThrowable)
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "resumeDownload failed, error:" + localThrowable.toString());
      }
    }
    AppMethodBeat.o(191396);
    return -1;
  }
  
  public boolean setClipInfo(int paramInt1, int paramInt2, String paramString, TPDownloadParam paramTPDownloadParam)
  {
    bool2 = false;
    AppMethodBeat.i(191390);
    int j = paramTPDownloadParam.getDlType();
    int i = j;
    if (paramTPDownloadParam.isOffline()) {
      i = j + 300;
    }
    bool1 = bool2;
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {}
    for (;;)
    {
      try
      {
        paramInt1 = TPDownloadProxyNative.getInstance().setClipInfo(paramInt1, paramInt2, paramString, i, paramTPDownloadParam.getCdnUrls(), paramTPDownloadParam.getSavaPath(), paramTPDownloadParam.getExtraJsonInfo());
        if (paramInt1 < 0) {
          continue;
        }
        bool1 = true;
      }
      catch (Throwable paramString)
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "setClipInfo failed, error:" + paramString.toString());
        bool1 = bool2;
        continue;
      }
      AppMethodBeat.o(191390);
      return bool1;
      bool1 = false;
    }
  }
  
  public void setLogListener(ITPDLProxyLogListener paramITPDLProxyLogListener)
  {
    AppMethodBeat.i(191387);
    TPDLProxyLog.setLogListener(this.mServiceType, paramITPDLProxyLogListener);
    AppMethodBeat.o(191387);
  }
  
  public void setMaxStorageSizeMB(long paramLong)
  {
    AppMethodBeat.i(191405);
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        TPDownloadProxyNative.getInstance().setMaxStorageSizeMB(this.mServiceType, paramLong);
        AppMethodBeat.o(191405);
        return;
      }
      catch (Throwable localThrowable)
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "setMaxStorageSizeMB failed, error:" + localThrowable.toString());
      }
    }
    AppMethodBeat.o(191405);
  }
  
  public void setPlayState(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(191408);
    if (paramInt1 <= 0)
    {
      AppMethodBeat.o(191408);
      return;
    }
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        TPDownloadProxyNative.getInstance().setPlayerState(paramInt1, paramInt2);
        AppMethodBeat.o(191408);
        return;
      }
      catch (Throwable localThrowable)
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "setPlayState failed, error:" + localThrowable.toString());
      }
    }
    AppMethodBeat.o(191408);
  }
  
  public void setUserData(String paramString, Object paramObject)
  {
    AppMethodBeat.i(191406);
    if (TPDownloadProxyNative.getInstance().isNativeLoaded())
    {
      try
      {
        if (paramString.equalsIgnoreCase("app_version_name"))
        {
          TPDownloadProxyNative.getInstance().setUserData("app_version_name", (String)paramObject);
          AppMethodBeat.o(191406);
          return;
        }
        if (!paramString.equalsIgnoreCase("platform")) {
          break label107;
        }
        TPDownloadProxyNative.getInstance().setUserData("platform", paramObject.toString());
        AppMethodBeat.o(191406);
        return;
      }
      catch (Throwable paramString)
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "setUserData failed, error:" + paramString.toString());
      }
    }
    else
    {
      AppMethodBeat.o(191406);
      return;
    }
    label107:
    if (paramString.equalsIgnoreCase("guid"))
    {
      TPDownloadProxyNative.getInstance().setUserData("guid", (String)paramObject);
      AppMethodBeat.o(191406);
      return;
    }
    TPDownloadProxyNative localTPDownloadProxyNative;
    if (paramString.equalsIgnoreCase("qq_is_vip"))
    {
      localTPDownloadProxyNative = TPDownloadProxyNative.getInstance();
      if (!((Boolean)paramObject).booleanValue()) {
        break label256;
      }
    }
    label256:
    for (paramString = "1";; paramString = "0")
    {
      localTPDownloadProxyNative.setUserData("qq_is_vip", paramString);
      AppMethodBeat.o(191406);
      return;
      if (paramString.equalsIgnoreCase("carrier_pesudo_code"))
      {
        TPDownloadProxyNative.getInstance().setUserData("carrier_pesudo_code", (String)paramObject);
        AppMethodBeat.o(191406);
        return;
      }
      if (paramString.equalsIgnoreCase("carrier_pesudo_state"))
      {
        TPDownloadProxyNative.getInstance().setUserData("carrier_pesudo_state", paramObject.toString());
        AppMethodBeat.o(191406);
        return;
      }
      TPDownloadProxyNative.getInstance().setUserData(paramString, paramObject.toString());
      AppMethodBeat.o(191406);
      return;
    }
  }
  
  public int startClipOfflineDownload(String paramString, int paramInt, ITPOfflineDownloadListener paramITPOfflineDownloadListener)
  {
    AppMethodBeat.i(191400);
    int j = -1;
    int i = j;
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      i = j;
    }
    try
    {
      paramInt = TPDownloadProxyNative.getInstance().createDownloadTask(this.mServiceType, paramString, 102, paramInt);
      i = paramInt;
      TPListenerManager.getInstance().setOfflineDownloadListener(paramInt, paramITPOfflineDownloadListener);
      i = paramInt;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "startClipOfflineDownload failed, error:" + paramString.toString());
      }
    }
    AppMethodBeat.o(191400);
    return i;
  }
  
  public int startClipPlay(String paramString, int paramInt, ITPPlayListener paramITPPlayListener)
  {
    AppMethodBeat.i(191389);
    int j = -1;
    int i = j;
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      i = j;
    }
    try
    {
      paramInt = TPDownloadProxyNative.getInstance().createDownloadTask(this.mServiceType, paramString, 2, paramInt);
      i = paramInt;
      TPListenerManager.getInstance().setPlayListener(paramInt, paramITPPlayListener);
      i = paramInt;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "startClipPlay failed, error:" + paramString.toString());
      }
    }
    AppMethodBeat.o(191389);
    return i;
  }
  
  public int startOfflineDownload(String paramString, TPDownloadParam paramTPDownloadParam, ITPOfflineDownloadListener paramITPOfflineDownloadListener)
  {
    AppMethodBeat.i(191399);
    int j = -1;
    int i = j;
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      i = j;
    }
    for (;;)
    {
      try
      {
        int k = paramTPDownloadParam.getDlType() + 100;
        i = j;
        j = TPDownloadProxyNative.getInstance().createDownloadTask(this.mServiceType, paramString, k, paramTPDownloadParam.getClipCount());
        i = j;
        TPListenerManager.getInstance().setOfflineDownloadListener(j, paramITPOfflineDownloadListener);
        i = j;
        if (!TextUtils.isEmpty(paramTPDownloadParam.getKeyid())) {
          continue;
        }
        i = j;
        TPDownloadProxyNative.getInstance().setClipInfo(j, paramTPDownloadParam.getClipNo(), paramString, k, paramTPDownloadParam.getCdnUrls(), paramTPDownloadParam.getSavaPath(), paramTPDownloadParam.getExtraJsonInfo());
        i = j;
      }
      catch (Throwable paramString)
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "stopOfflineDownload failed, error:" + paramString.toString());
        continue;
      }
      AppMethodBeat.o(191399);
      return i;
      i = j;
      paramString = paramTPDownloadParam.getKeyid();
    }
  }
  
  public int startPlay(String paramString, TPDownloadParam paramTPDownloadParam, ITPPlayListener paramITPPlayListener)
  {
    AppMethodBeat.i(191388);
    int k = -1;
    int j = paramTPDownloadParam.getDlType();
    int i = j;
    if (paramTPDownloadParam.isOffline())
    {
      i = j + 300;
      String str1 = paramTPDownloadParam.getVid();
      String str2 = paramTPDownloadParam.getPlayDefinition();
      if ((str1.isEmpty()) || (str2.isEmpty()))
      {
        AppMethodBeat.o(191388);
        return -1;
      }
      if (!TPDownloadProxyFactory.isReadyForDownload())
      {
        i = TPProxyAdapterManager.getInstance().startOnlineOrOfflinePlay(3, "", str1, str2, false, false, 0, null, paramTPDownloadParam.getOfflinePlayExtraInfo());
        if (i > 0) {
          TPListenerManager.getInstance().setProxyPlayListener(i, paramITPPlayListener);
        }
        AppMethodBeat.o(191388);
        return i;
      }
    }
    j = k;
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      j = k;
    }
    try
    {
      if ((!paramTPDownloadParam.isAdaptive()) || (i != 3)) {
        break label299;
      }
      i += 400;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "startPlay failed, error:" + paramString.toString());
      }
    }
    j = k;
    k = TPDownloadProxyNative.getInstance().createDownloadTask(this.mServiceType, paramString, i, paramTPDownloadParam.getClipCount());
    j = k;
    if (TextUtils.isEmpty(paramTPDownloadParam.getKeyid())) {}
    for (;;)
    {
      j = k;
      TPDownloadProxyNative.getInstance().setClipInfo(k, paramTPDownloadParam.getClipNo(), paramString, i, paramTPDownloadParam.getCdnUrls(), paramTPDownloadParam.getSavaPath(), paramTPDownloadParam.getExtraJsonInfo());
      j = k;
      TPListenerManager.getInstance().setPlayListener(k, paramITPPlayListener);
      j = k;
      AppMethodBeat.o(191388);
      return j;
      j = k;
      paramString = paramTPDownloadParam.getKeyid();
    }
  }
  
  public int startPreload(String paramString, TPDownloadParam paramTPDownloadParam, ITPPreLoadListener paramITPPreLoadListener)
  {
    AppMethodBeat.i(191397);
    int j = -1;
    int i = j;
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      i = j;
    }
    for (;;)
    {
      try
      {
        int k = paramTPDownloadParam.getDlType() + 200;
        i = j;
        j = TPDownloadProxyNative.getInstance().createDownloadTask(this.mServiceType, paramString, k, paramTPDownloadParam.getClipCount());
        i = j;
        TPListenerManager.getInstance().setPreLoadListener(j, paramITPPreLoadListener);
        i = j;
        if (!TextUtils.isEmpty(paramTPDownloadParam.getKeyid())) {
          continue;
        }
        i = j;
        TPDownloadProxyNative.getInstance().setClipInfo(j, paramTPDownloadParam.getClipNo(), paramString, k, paramTPDownloadParam.getCdnUrls(), paramTPDownloadParam.getSavaPath(), paramTPDownloadParam.getExtraJsonInfo());
        i = j;
        TPDownloadProxyNative.getInstance().startDownload(j);
        i = j;
      }
      catch (Throwable paramString)
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "startPreload failed, error:" + paramString.toString());
        continue;
      }
      AppMethodBeat.o(191397);
      return i;
      i = j;
      paramString = paramTPDownloadParam.getKeyid();
    }
  }
  
  public void startTask(int paramInt)
  {
    AppMethodBeat.i(191403);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(191403);
      return;
    }
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        TPDownloadProxyNative.getInstance().startDownload(paramInt);
        AppMethodBeat.o(191403);
        return;
      }
      catch (Throwable localThrowable)
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "startTask failed, error:" + localThrowable.toString());
      }
    }
    AppMethodBeat.o(191403);
  }
  
  public void stopOfflineDownload(int paramInt)
  {
    AppMethodBeat.i(191401);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(191401);
      return;
    }
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        TPDownloadProxyNative.getInstance().stopDownload(paramInt);
        TPListenerManager.getInstance().removeOfflineDownloadListener(paramInt);
        AppMethodBeat.o(191401);
        return;
      }
      catch (Throwable localThrowable)
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "stopOfflineDownload failed, error:" + localThrowable.toString());
      }
    }
    AppMethodBeat.o(191401);
  }
  
  public void stopPlay(int paramInt)
  {
    AppMethodBeat.i(191394);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(191394);
      return;
    }
    TPProxyAdapterManager.getInstance().stopPlay(paramInt);
    TPListenerManager.getInstance().removeProxyPlayListener(paramInt);
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        TPDownloadProxyNative.getInstance().stopDownload(paramInt);
        TPListenerManager.getInstance().removePlayListener(paramInt);
        AppMethodBeat.o(191394);
        return;
      }
      catch (Throwable localThrowable)
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "stopPlay failed, error:" + localThrowable.toString());
      }
    }
    AppMethodBeat.o(191394);
  }
  
  public void stopPreload(int paramInt)
  {
    AppMethodBeat.i(191398);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(191398);
      return;
    }
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        TPDownloadProxyNative.getInstance().stopDownload(paramInt);
        TPListenerManager.getInstance().removePreLoadListener(paramInt);
        AppMethodBeat.o(191398);
        return;
      }
      catch (Throwable localThrowable)
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "stopPreload failed, error:" + localThrowable.toString());
      }
    }
    AppMethodBeat.o(191398);
  }
  
  public void updateStoragePath(String paramString)
  {
    AppMethodBeat.i(191404);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(191404);
      return;
    }
    try
    {
      this.mCurrentStoragePath = paramString;
      TPDownloadProxyNative.getInstance().updateStoragePath(this.mServiceType, paramString);
      AppMethodBeat.o(191404);
      return;
    }
    catch (Throwable paramString)
    {
      TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "updateStoragePath failed, error:" + paramString.toString());
      AppMethodBeat.o(191404);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxy
 * JD-Core Version:    0.7.0.1
 */