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
    AppMethodBeat.i(207239);
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        int i = TPDownloadProxyNative.getInstance().deInitService(this.mServiceType);
        AppMethodBeat.o(207239);
        return i;
      }
      catch (Throwable localThrowable)
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "deinit failed, error:" + localThrowable.toString());
      }
    }
    AppMethodBeat.o(207239);
    return -1;
  }
  
  public String getClipPlayUrl(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(207245);
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
    AppMethodBeat.o(207245);
    return str1;
  }
  
  public String getPlayErrorCodeStr(int paramInt)
  {
    AppMethodBeat.i(207246);
    String str3 = "";
    String str1 = str3;
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {}
    try
    {
      str1 = TPDLProxyUtils.byteArrayToString(TPDownloadProxyNative.getInstance().getErrorCodeStr(paramInt));
      AppMethodBeat.o(207246);
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
    AppMethodBeat.i(207244);
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
    AppMethodBeat.o(207244);
    return str1;
  }
  
  public int init(Context paramContext, TPDLProxyInitParam paramTPDLProxyInitParam)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(207238);
        if (this.IsInit)
        {
          TPDLProxyLog.i("TPDownloadProxy", 0, "tpdlnative", "download already init");
          AppMethodBeat.o(207238);
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
              AppMethodBeat.i(207237);
              paramAnonymousContext = paramAnonymousIntent.getAction();
              if ("android.intent.action.SCREEN_OFF".equals(paramAnonymousContext))
              {
                TPDownloadProxy.this.pushEvent(20);
                AppMethodBeat.o(207237);
                return;
              }
              if ("android.intent.action.SCREEN_ON".equals(paramAnonymousContext)) {
                TPDownloadProxy.this.pushEvent(19);
              }
              AppMethodBeat.o(207237);
            }
          };
          if (paramContext != null) {
            paramContext.registerReceiver((BroadcastReceiver)localObject, paramTPDLProxyInitParam);
          }
          if (i == 0) {
            this.IsInit = true;
          }
          AppMethodBeat.o(207238);
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
      AppMethodBeat.o(207238);
      continue;
      label354:
      i = TPDownloadProxyNative.getInstance().initService(this.mServiceType, str1, paramTPDLProxyInitParam.getDataDir(), paramTPDLProxyInitParam.getConfigDir());
    }
  }
  
  public int pauseDownload(int paramInt)
  {
    AppMethodBeat.i(207248);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(207248);
      return -1;
    }
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        paramInt = TPDownloadProxyNative.getInstance().pauseDownload(paramInt);
        AppMethodBeat.o(207248);
        return paramInt;
      }
      catch (Throwable localThrowable)
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "pauseDownload failed, error:" + localThrowable.toString());
      }
    }
    AppMethodBeat.o(207248);
    return -1;
  }
  
  public void pushEvent(int paramInt)
  {
    AppMethodBeat.i(207260);
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        TPDownloadProxyNative.getInstance().pushEvent(paramInt);
        AppMethodBeat.o(207260);
        return;
      }
      catch (Throwable localThrowable)
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "pushEvent failed, error:" + localThrowable.toString());
      }
    }
    AppMethodBeat.o(207260);
  }
  
  public int removeOfflineDownload(String paramString)
  {
    AppMethodBeat.i(207255);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(207255);
      return -1;
    }
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        int i = TPDownloadProxyNative.getInstance().deleteOfflineCache(paramString);
        AppMethodBeat.o(207255);
        return i;
      }
      catch (Throwable paramString)
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "removeOfflineDownload failed, error:" + paramString.toString());
      }
    }
    AppMethodBeat.o(207255);
    return -1;
  }
  
  public int resumeDownload(int paramInt)
  {
    AppMethodBeat.i(207249);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(207249);
      return -1;
    }
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        paramInt = TPDownloadProxyNative.getInstance().resumeDownload(paramInt);
        AppMethodBeat.o(207249);
        return paramInt;
      }
      catch (Throwable localThrowable)
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "resumeDownload failed, error:" + localThrowable.toString());
      }
    }
    AppMethodBeat.o(207249);
    return -1;
  }
  
  public boolean setClipInfo(int paramInt1, int paramInt2, String paramString, TPDownloadParam paramTPDownloadParam)
  {
    bool2 = false;
    AppMethodBeat.i(207243);
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
      AppMethodBeat.o(207243);
      return bool1;
      bool1 = false;
    }
  }
  
  public void setLogListener(ITPDLProxyLogListener paramITPDLProxyLogListener)
  {
    AppMethodBeat.i(207240);
    TPDLProxyLog.setLogListener(this.mServiceType, paramITPDLProxyLogListener);
    AppMethodBeat.o(207240);
  }
  
  public void setMaxStorageSizeMB(long paramLong)
  {
    AppMethodBeat.i(207258);
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        TPDownloadProxyNative.getInstance().setMaxStorageSizeMB(this.mServiceType, paramLong);
        AppMethodBeat.o(207258);
        return;
      }
      catch (Throwable localThrowable)
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "setMaxStorageSizeMB failed, error:" + localThrowable.toString());
      }
    }
    AppMethodBeat.o(207258);
  }
  
  public void setPlayState(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(207261);
    if (paramInt1 <= 0)
    {
      AppMethodBeat.o(207261);
      return;
    }
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        TPDownloadProxyNative.getInstance().setPlayerState(paramInt1, paramInt2);
        AppMethodBeat.o(207261);
        return;
      }
      catch (Throwable localThrowable)
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "setPlayState failed, error:" + localThrowable.toString());
      }
    }
    AppMethodBeat.o(207261);
  }
  
  public void setUserData(String paramString, Object paramObject)
  {
    AppMethodBeat.i(207259);
    if (TPDownloadProxyNative.getInstance().isNativeLoaded())
    {
      try
      {
        if (paramString.equalsIgnoreCase("app_version_name"))
        {
          TPDownloadProxyNative.getInstance().setUserData("app_version_name", (String)paramObject);
          AppMethodBeat.o(207259);
          return;
        }
        if (!paramString.equalsIgnoreCase("platform")) {
          break label107;
        }
        TPDownloadProxyNative.getInstance().setUserData("platform", paramObject.toString());
        AppMethodBeat.o(207259);
        return;
      }
      catch (Throwable paramString)
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "setUserData failed, error:" + paramString.toString());
      }
    }
    else
    {
      AppMethodBeat.o(207259);
      return;
    }
    label107:
    if (paramString.equalsIgnoreCase("guid"))
    {
      TPDownloadProxyNative.getInstance().setUserData("guid", (String)paramObject);
      AppMethodBeat.o(207259);
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
      AppMethodBeat.o(207259);
      return;
      if (paramString.equalsIgnoreCase("carrier_pesudo_code"))
      {
        TPDownloadProxyNative.getInstance().setUserData("carrier_pesudo_code", (String)paramObject);
        AppMethodBeat.o(207259);
        return;
      }
      if (paramString.equalsIgnoreCase("carrier_pesudo_state"))
      {
        TPDownloadProxyNative.getInstance().setUserData("carrier_pesudo_state", paramObject.toString());
        AppMethodBeat.o(207259);
        return;
      }
      TPDownloadProxyNative.getInstance().setUserData(paramString, paramObject.toString());
      AppMethodBeat.o(207259);
      return;
    }
  }
  
  public int startClipOfflineDownload(String paramString, int paramInt, ITPOfflineDownloadListener paramITPOfflineDownloadListener)
  {
    AppMethodBeat.i(207253);
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
    AppMethodBeat.o(207253);
    return i;
  }
  
  public int startClipPlay(String paramString, int paramInt, ITPPlayListener paramITPPlayListener)
  {
    AppMethodBeat.i(207242);
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
    AppMethodBeat.o(207242);
    return i;
  }
  
  public int startOfflineDownload(String paramString, TPDownloadParam paramTPDownloadParam, ITPOfflineDownloadListener paramITPOfflineDownloadListener)
  {
    AppMethodBeat.i(207252);
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
      AppMethodBeat.o(207252);
      return i;
      i = j;
      paramString = paramTPDownloadParam.getKeyid();
    }
  }
  
  public int startPlay(String paramString, TPDownloadParam paramTPDownloadParam, ITPPlayListener paramITPPlayListener)
  {
    AppMethodBeat.i(207241);
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
        AppMethodBeat.o(207241);
        return -1;
      }
      if (!TPDownloadProxyFactory.isReadyForDownload())
      {
        i = TPProxyAdapterManager.getInstance().startOnlineOrOfflinePlay(3, "", str1, str2, false, false, 0, null, paramTPDownloadParam.getOfflinePlayExtraInfo());
        if (i > 0) {
          TPListenerManager.getInstance().setProxyPlayListener(i, paramITPPlayListener);
        }
        AppMethodBeat.o(207241);
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
      AppMethodBeat.o(207241);
      return j;
      j = k;
      paramString = paramTPDownloadParam.getKeyid();
    }
  }
  
  public int startPreload(String paramString, TPDownloadParam paramTPDownloadParam, ITPPreLoadListener paramITPPreLoadListener)
  {
    AppMethodBeat.i(207250);
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
      AppMethodBeat.o(207250);
      return i;
      i = j;
      paramString = paramTPDownloadParam.getKeyid();
    }
  }
  
  public void startTask(int paramInt)
  {
    AppMethodBeat.i(207256);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(207256);
      return;
    }
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        TPDownloadProxyNative.getInstance().startDownload(paramInt);
        AppMethodBeat.o(207256);
        return;
      }
      catch (Throwable localThrowable)
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "startTask failed, error:" + localThrowable.toString());
      }
    }
    AppMethodBeat.o(207256);
  }
  
  public void stopOfflineDownload(int paramInt)
  {
    AppMethodBeat.i(207254);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(207254);
      return;
    }
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        TPDownloadProxyNative.getInstance().stopDownload(paramInt);
        TPListenerManager.getInstance().removeOfflineDownloadListener(paramInt);
        AppMethodBeat.o(207254);
        return;
      }
      catch (Throwable localThrowable)
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "stopOfflineDownload failed, error:" + localThrowable.toString());
      }
    }
    AppMethodBeat.o(207254);
  }
  
  public void stopPlay(int paramInt)
  {
    AppMethodBeat.i(207247);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(207247);
      return;
    }
    TPProxyAdapterManager.getInstance().stopPlay(paramInt);
    TPListenerManager.getInstance().removeProxyPlayListener(paramInt);
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        TPDownloadProxyNative.getInstance().stopDownload(paramInt);
        TPListenerManager.getInstance().removePlayListener(paramInt);
        AppMethodBeat.o(207247);
        return;
      }
      catch (Throwable localThrowable)
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "stopPlay failed, error:" + localThrowable.toString());
      }
    }
    AppMethodBeat.o(207247);
  }
  
  public void stopPreload(int paramInt)
  {
    AppMethodBeat.i(207251);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(207251);
      return;
    }
    if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
      try
      {
        TPDownloadProxyNative.getInstance().stopDownload(paramInt);
        TPListenerManager.getInstance().removePreLoadListener(paramInt);
        AppMethodBeat.o(207251);
        return;
      }
      catch (Throwable localThrowable)
      {
        TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "stopPreload failed, error:" + localThrowable.toString());
      }
    }
    AppMethodBeat.o(207251);
  }
  
  public void updateStoragePath(String paramString)
  {
    AppMethodBeat.i(207257);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(207257);
      return;
    }
    try
    {
      this.mCurrentStoragePath = paramString;
      TPDownloadProxyNative.getInstance().updateStoragePath(this.mServiceType, paramString);
      AppMethodBeat.o(207257);
      return;
    }
    catch (Throwable paramString)
    {
      TPDLProxyLog.e("TPDownloadProxy", 0, "tpdlnative", "updateStoragePath failed, error:" + paramString.toString());
      AppMethodBeat.o(207257);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxy
 * JD-Core Version:    0.7.0.1
 */