package com.tencent.manager;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import android.util.LongSparseArray;
import com.tencent.manager.a.c.a;
import com.tencent.manager.a.f.b;
import com.tencent.manager.c.d;
import com.tencent.manager.c.f;
import com.tencent.manager.c.g;
import com.tencent.manager.c.h;
import com.tencent.manager.ui.a.a;
import com.tencent.mobileqq.intervideo.shadow.PluginProcessKiller;
import com.tencent.platform.Platform;
import com.tencent.pluginmanager.channel.ChannelCallback;
import com.tencent.pluginmanager.channel.IPCHelper;
import com.tencent.pluginmanager.channel.listener.IBizReqListener;
import com.tencent.shadow.core.manager.installplugin.InstalledPlugin;
import com.tencent.shadow.core.manager.installplugin.InstalledPlugin.PluginPart;
import com.tencent.shadow.dynamic.host.EnterCallback;
import com.tencent.shadow.dynamic.host.PpsController;
import com.tencent.shadow.dynamic.loader.PluginLoader;
import com.tencent.shadow.dynamic.manager.PluginManagerThatUseDynamicLoader;
import com.tencent.util.IPlatformCallback;
import com.tencent.util.IPlatformInterface;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class NowPluginManager
  extends PluginManagerThatUseDynamicLoader
  implements PluginProcessKiller
{
  public static String HOST_SERVICE_NAME = "com.tencent.intervideo.nowproxy.service.QTProxyService";
  public static final String LOCAL_PLUGIN_SWITCH_PATH = "/now/localPlugin";
  public static final String PLUGIN_SERVICE_NAME = "com.tencent.now.channel.core.IPCService";
  public static String TAG = "NowPluginManager";
  private long bootTimeStart = 0L;
  private boolean isErrorHappen = false;
  private boolean isNeedStop;
  long lastCheckVersionTime = 0L;
  private IBizReqListener mBizTaskListener = new IBizReqListener()
  {
    public void onReceiveBizTask(int paramAnonymousInt, Bundle paramAnonymousBundle, ChannelCallback paramAnonymousChannelCallback)
    {
      if (paramAnonymousInt == 3)
      {
        com.tencent.util.e.a.a(NowPluginManager.TAG, "onReceiveBizTask LOAD_BIZ_PLUGIN");
        paramAnonymousBundle = new Bundle();
        paramAnonymousBundle.putString("op_name", "load_biz_plugin");
        paramAnonymousBundle.putString("d1", "start");
        com.tencent.util.g.a.a(paramAnonymousBundle);
        NowPluginManager.this.checkAndLoadBizPlugin(1);
      }
      do
      {
        do
        {
          boolean bool;
          do
          {
            return;
            if (paramAnonymousInt != 24) {
              break;
            }
            bool = d.b(NowPluginManager.this.mPlugininfo.g);
          } while (paramAnonymousChannelCallback == null);
          paramAnonymousBundle = new Bundle();
          paramAnonymousBundle.putBoolean("isInstalled", bool);
          paramAnonymousChannelCallback.responseToPlugin(paramAnonymousBundle);
          return;
          if (paramAnonymousInt != 8) {
            break;
          }
          paramAnonymousChannelCallback = new Bundle();
          paramAnonymousChannelCallback.putAll(paramAnonymousBundle);
          paramAnonymousChannelCallback.putString("op_name", "enter_room");
          paramAnonymousChannelCallback.putString("timeconsume", String.valueOf(System.currentTimeMillis() - NowPluginManager.this.bootTimeStart));
          com.tencent.util.g.a.a(paramAnonymousChannelCallback);
        } while (!NowPluginManager.this.isOpenDelayOdex());
        com.tencent.manager.b.a.b().a(new Runnable()
        {
          public void run()
          {
            NowPluginManager.this.odexPluginAfterLoaded();
          }
        }, 60000L);
        return;
      } while ((paramAnonymousInt != 25) || (NowPluginManager.this.mLoadingView == null));
      NowPluginManager.this.completeEnter();
      com.tencent.util.e.a.a(NowPluginManager.TAG, "receieve ROOM_ACTIVITY_DESTROY");
    }
  };
  private final Context mContext;
  private IBinder.DeathRecipient mDeathRecipient = new IBinder.DeathRecipient()
  {
    public void binderDied()
    {
      com.tencent.util.e.a.a(NowPluginManager.TAG, "binderDied");
      NowPluginManager.access$1202(NowPluginManager.this, false);
      NowPluginManager.access$1302(NowPluginManager.this, false);
      NowPluginManager.this.resetPluginStatus();
      IPCHelper.removeBizReqListener(NowPluginManager.this.mBizTaskListener);
    }
  };
  private ExecutorService mFixedPool = Executors.newFixedThreadPool(4);
  private Handler mHandler = new Handler(Looper.getMainLooper());
  private boolean mIsBindLoadPluginService;
  private boolean mIsBindPluginService;
  private boolean mIsUseLocalPlugin = false;
  private com.tencent.manager.ui.a mLoadingView;
  private IPlatformInterface mPlatformInterface;
  private b mPluginServiceConnection = new b()
  {
    public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
    {
      try
      {
        com.tencent.util.e.a.a(NowPluginManager.TAG, "bindPluginService successed! ");
        paramAnonymousComponentName = new Bundle();
        paramAnonymousComponentName.putString("op_name", "bindservice");
        paramAnonymousComponentName.putString("d1", "success");
        paramAnonymousComponentName.putString("timeconsume", String.valueOf(System.currentTimeMillis() - NowPluginManager.this.mPluginServiceConnection.b));
        com.tencent.util.g.a.a(paramAnonymousComponentName);
        IPCHelper.setBindler(paramAnonymousIBinder);
        IPCHelper.addBizReqListener(NowPluginManager.this.mBizTaskListener);
        NowPluginManager.this.mHandler.post(new Runnable()
        {
          public void run()
          {
            if (NowPluginManager.this.isNeedStop()) {
              com.tencent.util.e.a.a(NowPluginManager.TAG, "bindService before callApplicationOnCreate isNeedStop");
            }
            do
            {
              return;
              if (NowPluginManager.4.this.c == 1)
              {
                NowPluginManager.this.launchNowAVPlugin();
                return;
              }
            } while (NowPluginManager.4.this.c != 2);
            NowPluginManager.this.checkAndLoadBizPlugin(NowPluginManager.4.this.c);
          }
        });
        paramAnonymousIBinder.linkToDeath(NowPluginManager.this.mDeathRecipient, 0);
        return;
      }
      catch (RemoteException paramAnonymousComponentName)
      {
        com.tencent.util.e.a.a(NowPluginManager.TAG, "Bind Plugin Service exception,e = " + paramAnonymousComponentName.getMessage());
        paramAnonymousIBinder = new Bundle();
        paramAnonymousIBinder.putString("op_name", "boot_fail");
        paramAnonymousIBinder.putString("d1", "bind_service");
        paramAnonymousIBinder.putString("d2", paramAnonymousComponentName.getMessage());
        com.tencent.util.g.a.a(paramAnonymousIBinder);
        NowPluginManager.this.showError();
      }
    }
    
    public void onServiceDisconnected(ComponentName paramAnonymousComponentName)
    {
      com.tencent.util.e.a.a(NowPluginManager.TAG, "onServiceDisconnected! ");
      IPCHelper.removeBizReqListener(NowPluginManager.this.mBizTaskListener);
      NowPluginManager.this.resetPluginStatus();
    }
  };
  c mPlugininfo = new c();
  private AtomicInteger mRetryLoadAvCount = new AtomicInteger(0);
  com.tencent.manager.a.e mUpdateDelegator;
  private final LongSparseArray<EnterCallback> mViewCallbackMap = new LongSparseArray();
  long startLoadAVTime = 0L;
  
  public NowPluginManager(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
  }
  
  private void bindService(int paramInt)
  {
    this.mIsBindPluginService = true;
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("op_name", "bindservice");
    ((Bundle)localObject).putString("d1", "start");
    com.tencent.util.g.a.a((Bundle)localObject);
    long l = System.currentTimeMillis();
    localObject = new ComponentName(this.mContext.getPackageName(), "com.tencent.now.channel.core.IPCService");
    Intent localIntent = new Intent();
    localIntent.setComponent((ComponentName)localObject);
    this.mPluginServiceConnection.b = l;
    this.mPluginServiceConnection.c = paramInt;
    this.mPluginLoader.bindPluginService(localIntent, this.mPluginServiceConnection, 1);
  }
  
  private void checkAndLoadBizPlugin(final int paramInt)
  {
    if (this.mIsUseLocalPlugin) {
      com.tencent.manager.b.a.b().a(new Runnable()
      {
        public void run()
        {
          try
          {
            NowPluginManager.this.installPlugin(2, "sdcard/now_biz.zip", null, false);
            NowPluginManager.this.loadLocalNowBizPlugin(paramInt);
            return;
          }
          catch (Exception localException)
          {
            com.tencent.util.e.a.b(NowPluginManager.TAG, "installAndLoadBizPluginInSingleThread error, error=" + localException.toString());
          }
        }
      });
    }
    while (isNeedStop()) {
      return;
    }
    this.mPlugininfo.b(5);
    if (!d.b(this.mPlugininfo.g))
    {
      downloadBizPlugin(paramInt);
      this.mPlugininfo.a(4);
      return;
    }
    com.tencent.manager.b.a.b().a(new Runnable()
    {
      public void run()
      {
        NowPluginManager.this.loadLocalNowBizPlugin(paramInt);
      }
    });
  }
  
  private void completeEnter()
  {
    com.tencent.util.e.a.a(TAG, "completeEnter");
    EnterCallback localEnterCallback = (EnterCallback)this.mViewCallbackMap.get(1L);
    if (localEnterCallback != null)
    {
      com.tencent.util.e.a.a(TAG, "  enterCallback.onEnterComplete();");
      localEnterCallback.onCloseLoadingView();
      this.mLoadingView = null;
      localEnterCallback.onEnterComplete();
      this.mViewCallbackMap.remove(1L);
    }
  }
  
  private void deleteOverDuePlugin()
  {
    try
    {
      Object localObject1 = getInstalledPlugins(5);
      String str;
      if ((localObject1 != null) && (((List)localObject1).size() > 1))
      {
        com.tencent.util.e.a.a(TAG, "deleteOverDuePlugin installedPlugins.size = " + ((List)localObject1).size());
        str = ((InstalledPlugin)((List)localObject1).get(0)).UUID;
        ((List)localObject1).remove(0);
        localObject1 = ((List)localObject1).iterator();
      }
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (InstalledPlugin)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          localObject2 = ((InstalledPlugin)localObject2).UUID;
          if (!((String)localObject2).equals(str))
          {
            com.tencent.util.e.a.a(TAG, "deleteOverDuePlugin UUID = " + (String)localObject2);
            deleteInstalledPlugin((String)localObject2);
            continue;
            return;
          }
        }
      }
    }
    catch (Exception localException)
    {
      com.tencent.util.e.a.b(TAG, "deleteOverDuePlugin ex = " + localException);
    }
    resetPluginStatus();
  }
  
  private void downloadBizPlugin(int paramInt)
  {
    if (isNeedStop()) {
      return;
    }
    final long l = System.currentTimeMillis();
    com.tencent.util.e.a.a(TAG, "开始下载业务插件, action=" + paramInt);
    this.mUpdateDelegator.a(new f.b()
    {
      public void a(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        com.tencent.util.e.a.a(NowPluginManager.TAG, "开始下载业务插件失败");
        Bundle localBundle = new Bundle();
        localBundle.putString("op_name", "download_biz_fail");
        localBundle.putString("timeconsume", String.valueOf(System.currentTimeMillis() - l));
        com.tencent.util.g.a.a(localBundle);
        if (this.b == 1)
        {
          localBundle = new Bundle();
          localBundle.putInt("load_step", 3);
          localBundle.putString("err_msg", "download fail!");
          IPCHelper.pushToPlugin(3, localBundle);
        }
      }
      
      public void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt)
      {
        if (this.b == 1)
        {
          Bundle localBundle = new Bundle();
          localBundle.putInt("load_step", 1);
          localBundle.putLong("download_size", paramAnonymousLong1);
          localBundle.putLong("total_size", paramAnonymousLong2);
          localBundle.putInt("percent", paramAnonymousInt);
          IPCHelper.pushToPlugin(3, localBundle);
        }
      }
      
      public void a(final String paramAnonymousString1, final String paramAnonymousString2)
      {
        com.tencent.util.e.a.a(NowPluginManager.TAG, "下载业务插件完成，耗时为：" + (System.currentTimeMillis() - l) + "ms");
        Bundle localBundle = new Bundle();
        localBundle.putString("op_name", "download_biz_success");
        localBundle.putString("timeconsume", String.valueOf(System.currentTimeMillis() - l));
        com.tencent.util.g.a.a(localBundle);
        com.tencent.manager.b.a.b().a(new Runnable()
        {
          public void run()
          {
            try
            {
              NowPluginManager.this.installPlugin(2, paramAnonymousString1, paramAnonymousString2, false);
              if ((NowPluginManager.14.this.b == 1) || (NowPluginManager.14.this.b == 2)) {
                NowPluginManager.this.loadLocalNowBizPlugin(NowPluginManager.14.this.b);
              }
              return;
            }
            catch (Exception localException)
            {
              com.tencent.util.e.a.b(NowPluginManager.TAG, "installAndLoadBizPluginInSingleThread error, error=" + localException.toString());
            }
          }
        });
      }
    }, 2, 0);
  }
  
  private void excuteCheckResult(int paramInt1, final int paramInt2)
  {
    if (isNeedStop()) {
      com.tencent.util.e.a.a(TAG, "excuteCheckResult isNeedStop");
    }
    do
    {
      do
      {
        return;
        if ((paramInt1 == 3) || (paramInt1 == 1))
        {
          this.mPlugininfo.g = null;
          this.mPlugininfo.b(2);
          final long l = System.currentTimeMillis();
          this.mUpdateDelegator.a(new f.b()
          {
            public void a(int paramAnonymousInt1, int paramAnonymousInt2)
            {
              com.tencent.util.e.a.a(NowPluginManager.TAG, "下载AV插件失败 code " + paramAnonymousInt1 + " subCode = " + paramAnonymousInt2);
              Bundle localBundle = new Bundle();
              localBundle.putString("op_name", "download_fail");
              localBundle.putString("op_result", String.valueOf(paramAnonymousInt1));
              localBundle.putString("d1", String.valueOf(NowPluginManager.this.mUpdateDelegator.e));
              localBundle.putString("d2", String.valueOf(paramAnonymousInt2));
              localBundle.putString("timeconsume", String.valueOf(System.currentTimeMillis() - l));
              com.tencent.util.g.a.a(localBundle);
              NowPluginManager.this.showError();
            }
            
            public void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt)
            {
              if (NowPluginManager.this.mLoadingView != null) {
                NowPluginManager.this.mLoadingView.a(paramAnonymousInt);
              }
            }
            
            public void a(final String paramAnonymousString1, final String paramAnonymousString2)
            {
              Bundle localBundle = new Bundle();
              localBundle.putString("op_name", "download_complete");
              localBundle.putInt("op_in", 1);
              localBundle.putInt("op_result", 0);
              localBundle.putString("d1", String.valueOf(NowPluginManager.this.mUpdateDelegator.e));
              localBundle.putString("d2", String.valueOf(0));
              localBundle.putString("timeconsume", String.valueOf(System.currentTimeMillis() - l));
              com.tencent.util.g.a.a(localBundle);
              com.tencent.manager.b.a.a().a(new Runnable()
              {
                public void run()
                {
                  com.tencent.util.e.a.a(NowPluginManager.TAG, "下载AV插件完成，开始安装");
                  NowPluginManager.this.mPlugininfo.b(3);
                  if (NowPluginManager.this.installPlugin(1, paramAnonymousString1, paramAnonymousString2, false))
                  {
                    NowPluginManager.this.mPlugininfo.a(2);
                    if ((NowPluginManager.25.this.b == 2) || (NowPluginManager.25.this.b == 1)) {
                      NowPluginManager.this.loadLocalNowAVPlugin(NowPluginManager.25.this.b);
                    }
                    while ((NowPluginManager.25.this.b != 8) || (d.b(NowPluginManager.this.mPlugininfo.g))) {
                      return;
                    }
                    NowPluginManager.this.downloadBizPlugin(8);
                    return;
                  }
                  NowPluginManager.this.showError();
                }
              });
            }
          }, 1, paramInt1);
          return;
        }
      } while ((paramInt1 != 4) && (paramInt1 != 2));
      com.tencent.manager.b.a.a().a(new Runnable()
      {
        public void run()
        {
          if (paramInt2 == 8) {
            return;
          }
          NowPluginManager.this.loadLocalNowAVPlugin(paramInt2);
        }
      });
    } while (paramInt1 != 2);
    new Handler().postDelayed(new Runnable()
    {
      public void run()
      {
        NowPluginManager.this.executeSilenceUpdate();
      }
    }, 30000L);
  }
  
  private void executeSilenceUpdate()
  {
    com.tencent.util.e.a.a(TAG, "开始静默更新");
    this.mUpdateDelegator.a(new f.b()
    {
      public void a(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        com.tencent.util.e.a.a(NowPluginManager.TAG, "静默更新AV插件失败,code = " + paramAnonymousInt1);
      }
      
      public void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt) {}
      
      public void a(final String paramAnonymousString1, final String paramAnonymousString2)
      {
        com.tencent.util.e.a.a(NowPluginManager.TAG, "静默更新AV插件成功,hash = " + paramAnonymousString2);
        com.tencent.manager.b.a.a().a(new Runnable()
        {
          public void run()
          {
            NowPluginManager.this.installPlugin(1, paramAnonymousString1, paramAnonymousString2, true);
          }
        });
        com.tencent.util.e.a.a(NowPluginManager.TAG, "开始下载业务插件,hash = " + paramAnonymousString2);
        NowPluginManager.this.mUpdateDelegator.a(new f.b()
        {
          public void a(int paramAnonymous2Int1, int paramAnonymous2Int2) {}
          
          public void a(long paramAnonymous2Long1, long paramAnonymous2Long2, int paramAnonymous2Int) {}
          
          public void a(final String paramAnonymous2String1, String paramAnonymous2String2)
          {
            com.tencent.util.e.a.a(NowPluginManager.TAG, "静默更新BIZ插件成功,hash = " + paramAnonymous2String2);
            com.tencent.manager.b.a.b().a(new Runnable()
            {
              public void run()
              {
                NowPluginManager.this.installPlugin(2, paramAnonymous2String1, paramAnonymous2String1, true);
              }
            });
          }
        }, 2);
      }
    }, 1);
  }
  
  private void initUpdateDelegator(Context paramContext)
  {
    if (this.mUpdateDelegator == null) {
      this.mUpdateDelegator = new com.tencent.manager.a.e(paramContext, this.mPlugininfo, this.lastCheckVersionTime);
    }
  }
  
  private boolean installPlugin(int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (this.isNeedStop) {
      return true;
    }
    final long l;
    int i;
    Object localObject1;
    Object localObject2;
    try
    {
      l = System.currentTimeMillis();
      Bundle localBundle = new Bundle();
      localBundle.putString("op_name", "install_start");
      if (paramBoolean)
      {
        i = 1;
        localBundle.putInt("op_in", i);
        localBundle.putString("d1", paramString1);
        localBundle.putString("d2", paramString2);
        localBundle.putString("d3", String.valueOf(paramBoolean));
        com.tencent.util.g.a.a(localBundle);
        localObject1 = installPluginFromZip(new File(paramString1), paramString2);
        com.tencent.util.e.a.a(TAG, "installPluginFromZip done ，耗时为：" + (System.currentTimeMillis() - l) + "ms");
        localObject2 = new LinkedList();
        if (((paramInt == 1) || (!isOpenDelayOdex())) && (((InstalledPlugin)localObject1).runtimeFile != null) && (((InstalledPlugin)localObject1).pluginLoaderFile != null))
        {
          ((List)localObject2).add(this.mFixedPool.submit(new Callable()
          {
            public Object call()
            {
              NowPluginManager.this.oDexPluginLoaderOrRunTime(this.a.UUID, 4);
              return null;
            }
          }));
          ((List)localObject2).add(this.mFixedPool.submit(new Callable()
          {
            public Object call()
            {
              NowPluginManager.this.oDexPluginLoaderOrRunTime(this.a.UUID, 3);
              return null;
            }
          }));
        }
        Iterator localIterator = ((InstalledPlugin)localObject1).plugins.entrySet().iterator();
        while (localIterator.hasNext())
        {
          final String str = (String)((Map.Entry)localIterator.next()).getKey();
          ((List)localObject2).add(this.mFixedPool.submit(new Callable()
          {
            public Object call()
            {
              NowPluginManager.this.extractSo(this.a.UUID, str);
              com.tencent.util.e.a.a(NowPluginManager.TAG, "extractSo 完成耗时为：" + (System.currentTimeMillis() - l) + "ms");
              return null;
            }
          }));
          if (!isOpenDelayOdex())
          {
            ((List)localObject2).add(this.mFixedPool.submit(new Callable()
            {
              public Object call()
              {
                NowPluginManager.this.oDexPlugin(this.a.UUID, str);
                return null;
              }
            }));
            continue;
            paramInt = 1;
          }
        }
      }
    }
    catch (Exception localException)
    {
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("op_name", "install_complete");
      if (!paramBoolean) {}
    }
    for (;;)
    {
      ((Bundle)localObject1).putInt("op_in", paramInt);
      ((Bundle)localObject1).putInt("op_result", 1);
      ((Bundle)localObject1).putString("d1", paramString1);
      ((Bundle)localObject1).putString("d2", paramString2);
      ((Bundle)localObject1).putString("d3", String.valueOf(paramBoolean));
      ((Bundle)localObject1).putString("d4", localException.getMessage());
      com.tencent.util.g.a.a((Bundle)localObject1);
      return false;
      i = 2;
      break;
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Future)((Iterator)localObject1).next();
        com.tencent.util.e.a.a(TAG, " future.get() start耗时为：" + (System.currentTimeMillis() - l) + "ms");
        ((Future)localObject2).get();
        com.tencent.util.e.a.a(TAG, " future.get() finish耗时为：" + (System.currentTimeMillis() - l) + "ms");
      }
      if (!paramBoolean)
      {
        localObject1 = getInstalledPlugins(1);
        if ((localObject1 != null) && (((List)localObject1).get(0) != null)) {
          this.mPlugininfo.g = ((InstalledPlugin)((List)localObject1).get(0));
        }
      }
      if (paramString2 != null) {
        h.a(new File(paramString1));
      }
      com.tencent.util.e.a.a(TAG, "installPlugin SUCCESS!zipPath = " + paramString1 + " timespan = " + (System.currentTimeMillis() - l) + "ms");
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("op_name", "install_complete");
      if (paramBoolean) {}
      for (paramInt = 1;; paramInt = 2)
      {
        localException.putInt("op_in", paramInt);
        ((Bundle)localObject1).putString("d1", "");
        ((Bundle)localObject1).putInt("op_result", 0);
        ((Bundle)localObject1).putString("timeconsume", String.valueOf(System.currentTimeMillis() - l));
        ((Bundle)localObject1).putString("d1", paramString1);
        ((Bundle)localObject1).putString("d2", paramString2);
        ((Bundle)localObject1).putString("d3", String.valueOf(paramBoolean));
        com.tencent.util.g.a.a((Bundle)localObject1);
        return true;
      }
      paramInt = 2;
    }
  }
  
  /* Error */
  private boolean isAVPluginLoaded()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aload_0
    //   7: getfield 259	com/tencent/manager/NowPluginManager:mPluginLoader	Lcom/tencent/shadow/dynamic/loader/PluginLoader;
    //   10: ifnull +50 -> 60
    //   13: aload_0
    //   14: getfield 259	com/tencent/manager/NowPluginManager:mPluginLoader	Lcom/tencent/shadow/dynamic/loader/PluginLoader;
    //   17: invokeinterface 639 1 0
    //   22: astore 5
    //   24: aload 5
    //   26: astore 4
    //   28: aload 4
    //   30: ifnull +205 -> 235
    //   33: aload 4
    //   35: ldc_w 641
    //   38: invokeinterface 644 2 0
    //   43: ifeq +192 -> 235
    //   46: iconst_1
    //   47: istore_1
    //   48: iload_1
    //   49: ireturn
    //   50: astore 5
    //   52: aload 5
    //   54: invokevirtual 647	android/os/RemoteException:printStackTrace	()V
    //   57: goto -29 -> 28
    //   60: aload_0
    //   61: getfield 649	com/tencent/manager/NowPluginManager:mPlatformInterface	Lcom/tencent/util/IPlatformInterface;
    //   64: ifnull -36 -> 28
    //   67: getstatic 124	com/tencent/manager/NowPluginManager:TAG	Ljava/lang/String;
    //   70: ldc_w 651
    //   73: invokestatic 389	com/tencent/util/e/a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   76: invokestatic 325	java/lang/System:currentTimeMillis	()J
    //   79: lstore_2
    //   80: aload_0
    //   81: getstatic 128	com/tencent/manager/NowPluginManager:HOST_SERVICE_NAME	Ljava/lang/String;
    //   84: invokevirtual 654	com/tencent/manager/NowPluginManager:bindPluginProcessService	(Ljava/lang/String;)V
    //   87: aload_0
    //   88: bipush 10
    //   90: getstatic 660	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   93: invokevirtual 664	com/tencent/manager/NowPluginManager:waitServiceConnected	(ILjava/util/concurrent/TimeUnit;)V
    //   96: aload 5
    //   98: astore 4
    //   100: aload_0
    //   101: getfield 259	com/tencent/manager/NowPluginManager:mPluginLoader	Lcom/tencent/shadow/dynamic/loader/PluginLoader;
    //   104: ifnull +14 -> 118
    //   107: aload_0
    //   108: getfield 259	com/tencent/manager/NowPluginManager:mPluginLoader	Lcom/tencent/shadow/dynamic/loader/PluginLoader;
    //   111: invokeinterface 639 1 0
    //   116: astore 4
    //   118: new 301	android/os/Bundle
    //   121: dup
    //   122: invokespecial 302	android/os/Bundle:<init>	()V
    //   125: astore 5
    //   127: aload 5
    //   129: ldc_w 304
    //   132: ldc_w 666
    //   135: invokevirtual 310	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   138: aload 5
    //   140: ldc_w 627
    //   143: invokestatic 325	java/lang/System:currentTimeMillis	()J
    //   146: lload_2
    //   147: lsub
    //   148: invokestatic 630	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   151: invokevirtual 310	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   154: aload 5
    //   156: invokestatic 319	com/tencent/util/g/a:a	(Landroid/os/Bundle;)V
    //   159: goto -131 -> 28
    //   162: astore 4
    //   164: getstatic 124	com/tencent/manager/NowPluginManager:TAG	Ljava/lang/String;
    //   167: new 422	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   174: ldc_w 668
    //   177: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: aload 4
    //   182: invokevirtual 669	java/util/concurrent/TimeoutException:toString	()Ljava/lang/String;
    //   185: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: invokestatic 389	com/tencent/util/e/a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   194: iconst_0
    //   195: ireturn
    //   196: astore 4
    //   198: getstatic 124	com/tencent/manager/NowPluginManager:TAG	Ljava/lang/String;
    //   201: new 422	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   208: ldc_w 671
    //   211: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: aload 4
    //   216: invokevirtual 672	android/os/RemoteException:toString	()Ljava/lang/String;
    //   219: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: invokestatic 389	com/tencent/util/e/a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   228: aload 5
    //   230: astore 4
    //   232: goto -114 -> 118
    //   235: iconst_0
    //   236: istore_1
    //   237: goto -189 -> 48
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	240	0	this	NowPluginManager
    //   47	190	1	bool	boolean
    //   79	68	2	l	long
    //   4	113	4	localObject	Object
    //   162	19	4	localTimeoutException	java.util.concurrent.TimeoutException
    //   196	19	4	localRemoteException1	RemoteException
    //   230	1	4	localBundle1	Bundle
    //   1	24	5	localMap	Map
    //   50	47	5	localRemoteException2	RemoteException
    //   125	104	5	localBundle2	Bundle
    // Exception table:
    //   from	to	target	type
    //   13	24	50	android/os/RemoteException
    //   87	96	162	java/util/concurrent/TimeoutException
    //   107	118	196	android/os/RemoteException
  }
  
  private boolean isBizPluginLoaded()
  {
    if (!isAVPluginLoaded()) {
      return false;
    }
    if (this.mPluginLoader != null) {}
    for (;;)
    {
      try
      {
        Map localMap = this.mPluginLoader.getLoadedPlugin();
        if ((localMap == null) || (!localMap.containsKey("NowBiz"))) {
          break;
        }
        return true;
      }
      catch (RemoteException localRemoteException)
      {
        localRemoteException.printStackTrace();
      }
      Object localObject = null;
    }
  }
  
  private void jumpToPluginWithLoadingView(Bundle paramBundle)
  {
    Object localObject2 = com.tencent.manager.c.b.p(paramBundle);
    Object localObject1 = com.tencent.manager.c.b.q(paramBundle);
    com.tencent.util.e.a.a(TAG, "jumpToPluginWithLoadingView coverurl = " + (String)localObject1);
    localObject1 = com.tencent.util.b.a.a((String)localObject1);
    if (localObject1 == null) {
      localObject1 = g.a((String)localObject2);
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        com.tencent.util.e.a.a(TAG, "coverimg  width = " + ((Bitmap)localObject1).getWidth() + " height = " + ((Bitmap)localObject1).getHeight());
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        ((Bitmap)localObject1).compress(Bitmap.CompressFormat.JPEG, 100, localByteArrayOutputStream);
        byte[] arrayOfByte = localByteArrayOutputStream.toByteArray();
        com.tencent.util.e.a.a(TAG, "coverimg  length = " + arrayOfByte.length);
        localObject2 = arrayOfByte;
        if (arrayOfByte.length > 512000)
        {
          com.tencent.util.e.a.a(TAG, "coverimg 大小超标,先压缩!");
          localByteArrayOutputStream.reset();
          ((Bitmap)localObject1).compress(Bitmap.CompressFormat.JPEG, 100, localByteArrayOutputStream);
          localObject2 = localByteArrayOutputStream.toByteArray();
        }
        if (localObject2.length > 512000) {
          com.tencent.util.e.a.a(TAG, "coverimg 大小超标,直接丢掉! length = " + localObject2.length);
        }
      }
      else
      {
        if (isAVPluginLoaded()) {
          break label499;
        }
        com.tencent.util.e.a.a(TAG, "音视频插件还没有加载,展示一个中间loading页面");
        this.mLoadingView = new com.tencent.manager.ui.a(this.mContext);
        if ((com.tencent.manager.c.b.m(paramBundle) != 0) || ((!com.tencent.manager.c.b.o(paramBundle)) && (!com.tencent.manager.c.b.n(paramBundle)))) {
          break label522;
        }
      }
      label388:
      label522:
      for (int i = 20;; i = 100)
      {
        this.mLoadingView.a(this.mContext, (Bitmap)localObject1, i, String.valueOf(getClass().getClassLoader().hashCode()));
        if (d.a(this.mPlugininfo.g)) {
          this.mHandler.post(new Runnable()
          {
            public void run()
            {
              NowPluginManager.this.mLoadingView.b();
            }
          });
        }
        paramBundle = (EnterCallback)this.mViewCallbackMap.get(1L);
        if (paramBundle != null) {
          paramBundle.onShowLoadingView(this.mLoadingView);
        }
        this.mLoadingView.setOprListener(new a.a()
        {
          public void a()
          {
            NowPluginManager.access$402(NowPluginManager.this, System.currentTimeMillis());
            Bundle localBundle = new Bundle();
            localBundle.putString("op_name", "now_retry");
            com.tencent.util.g.a.a(localBundle);
            NowPluginManager.this.launchPlugin(1);
          }
        });
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("op_name", "jump_plugin");
        if (isAVPluginLoaded()) {}
        for (paramBundle = "1";; paramBundle = "0")
        {
          ((Bundle)localObject1).putString("d1", paramBundle);
          ((Bundle)localObject1).putString("timeconsume", String.valueOf(System.currentTimeMillis() - this.bootTimeStart));
          com.tencent.util.g.a.a((Bundle)localObject1);
          if (com.tencent.util.a.a.a() != null) {
            this.mPlugininfo.i.putAll(com.tencent.util.a.a.a());
          }
          com.tencent.manager.b.a.a().a(new Runnable()
          {
            public void run()
            {
              NowPluginManager.this.launchPlugin(1);
            }
          });
          return;
          this.mPlugininfo.i.putByteArray("bitmap_cover_buf", (byte[])localObject2);
          break;
          label499:
          completeEnter();
          com.tencent.util.e.a.a(TAG, "音视频插件已加载，主进程不需要展示loading页了");
          break label388;
        }
      }
    }
  }
  
  private void jumpToWebView(long paramLong, String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    Log.i(TAG, "jumpToWebView url = " + paramString1);
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1))
    {
      if (paramLong == 0L) {
        str = "https://now.qq.com/qq/play.html?_bid=2374&_wv=16778245&from=50320";
      }
    }
    else {
      if (!str.endsWith("&")) {
        break label239;
      }
    }
    label239:
    for (paramString1 = str + "fromid=" + paramString3 + "&_t=" + System.currentTimeMillis();; paramString1 = str + "&fromid=" + paramString3 + "&_t=" + System.currentTimeMillis())
    {
      paramString3 = paramBundle;
      if (paramBundle == null) {
        paramString3 = new Bundle();
      }
      paramString3.putBoolean("hide_operation_bar", true);
      paramString3.putString("op_type", "now_live");
      paramString3.putBoolean("key_isReadModeEnabled", true);
      paramString3.putStringArray("insertPluginsArray", new String[] { "nowlive" });
      com.tencent.util.i.a.a(paramString1, paramString3);
      paramString3 = new Bundle();
      paramString3.putString("op_name", "jump_h5");
      paramString3.putString("d1", paramString2);
      paramString3.putString("d2", paramString1);
      com.tencent.util.g.a.a(paramString3);
      return;
      str = "https://now.qq.com/h5/index.html?_bid=2336&_wv=16778245&from=50320&roomid=" + paramLong;
      break;
    }
  }
  
  private void launchDebugAVPlugin(final int paramInt)
  {
    com.tencent.manager.b.a.a().a(new Runnable()
    {
      public void run()
      {
        if (!d.a(NowPluginManager.this.mPlugininfo))
        {
          NowPluginManager.this.mPlugininfo.a(1);
          NowPluginManager.this.installPlugin(1, "sdcard/now_av.zip", null, false);
        }
        NowPluginManager.this.loadLocalNowAVPlugin(paramInt);
      }
    });
  }
  
  private void launchNowAVPlugin()
  {
    if (this.mPlugininfo == null)
    {
      showError();
      return;
    }
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        Bundle localBundle = new Bundle();
        try
        {
          if (NowPluginManager.this.isNeedStop())
          {
            com.tencent.util.e.a.a(NowPluginManager.TAG, "launchNowAVPlugin before startActivity isNeedStop");
            return;
          }
          Intent localIntent = NowPluginManager.this.mPluginLoader.convertActivityIntent(NowPluginManager.this.mPlugininfo.a(NowPluginManager.this.mContext));
          if (!(NowPluginManager.this.mHostContext instanceof Activity)) {
            localIntent.setFlags(268435456);
          }
          NowPluginManager.this.mHostContext.startActivity(localIntent);
          NowPluginManager.this.mHandler.postDelayed(new Runnable()
          {
            public void run()
            {
              NowPluginManager.this.completeEnter();
            }
          }, 1000L);
          localBundle.putString("op_name", "shadow_startActivity");
          localBundle.putString("d1", "0");
          localBundle.putString("d2", "");
          com.tencent.util.g.a.a(localBundle);
          com.tencent.util.e.a.a(NowPluginManager.TAG, "startPluginActivity AV successed! , hashcode=" + hashCode() + "manage.hash=" + NowPluginManager.this.hashCode());
          return;
        }
        catch (RemoteException localRemoteException)
        {
          localBundle.putString("op_name", "boot_fail");
          localBundle.putString("d1", "start_activity");
          localBundle.putString("d2", localRemoteException.getMessage());
          com.tencent.util.g.a.a(localBundle);
          com.tencent.util.e.a.a(NowPluginManager.TAG, "launchNowAVPlugin, e=" + localRemoteException.toString());
        }
      }
    });
  }
  
  private void launchPlugin(final int paramInt)
  {
    com.tencent.util.e.a.a(TAG, "launchPlugin action = " + paramInt);
    if (this.mIsUseLocalPlugin)
    {
      if (paramInt == 1) {
        launchDebugAVPlugin(1);
      }
      while (paramInt != 2) {
        return;
      }
      preloadNowPlugin();
      return;
    }
    if (needCheckPluginVersion())
    {
      this.mPlugininfo.b(1);
      com.tencent.util.e.a.a(TAG, "还没有执行过版本检查");
      this.mUpdateDelegator.a(new c.a()
      {
        public void a(boolean paramAnonymousBoolean, int paramAnonymousInt)
        {
          if (paramAnonymousBoolean)
          {
            NowPluginManager.this.excuteCheckResult(paramAnonymousInt, paramInt);
            return;
          }
          NowPluginManager.this.showError();
        }
      });
      return;
    }
    if (d.a(this.mPlugininfo.g))
    {
      com.tencent.util.e.a.a(TAG, "AV插件已安装");
      excuteCheckResult(4, paramInt);
      return;
    }
    com.tencent.util.e.a.a(TAG, "AV插件没有安装");
    excuteCheckResult(3, paramInt);
  }
  
  private void listenHostCallback()
  {
    this.mPlatformInterface = new Platform();
    HOST_SERVICE_NAME = this.mPlatformInterface.getQTProxyServiceName();
    this.mPlatformInterface.onPluginManagerCreate(this.mContext, new IPlatformCallback()
    {
      public void killPluginProcess()
      {
        com.tencent.util.e.a.a(NowPluginManager.TAG, "killPluginProcess");
        NowPluginManager.this.killPluginProcessSysn();
        NowPluginManager.this.resetPluginStatus();
      }
      
      public void notifyLoadingActivityBackPress()
      {
        com.tencent.util.e.a.a(NowPluginManager.TAG, "loading时用户点击返回，本次enter结束");
        Bundle localBundle = new Bundle();
        localBundle.putString("op_name", "cancel_run");
        localBundle.putInt("op_in", 1);
        if (NowPluginManager.this.isErrorHappen) {}
        for (String str = "1";; str = "0")
        {
          localBundle.putString("d1", str);
          localBundle.putString("d2", String.valueOf(NowPluginManager.this.mPlugininfo.l));
          localBundle.putString("timeconsume", String.valueOf(System.currentTimeMillis() - NowPluginManager.this.bootTimeStart));
          com.tencent.util.g.a.a(localBundle);
          NowPluginManager.this.completeEnter();
          return;
        }
      }
    });
  }
  
  /* Error */
  private void loadLocalNowAVPlugin(int paramInt)
  {
    // Byte code:
    //   0: iconst_5
    //   1: istore_2
    //   2: getstatic 124	com/tencent/manager/NowPluginManager:TAG	Ljava/lang/String;
    //   5: new 422	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   12: ldc_w 913
    //   15: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: iload_1
    //   19: invokevirtual 432	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   22: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: invokestatic 389	com/tencent/util/e/a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: aload_0
    //   29: getfield 173	com/tencent/manager/NowPluginManager:mPlugininfo	Lcom/tencent/manager/c;
    //   32: iconst_4
    //   33: invokevirtual 372	com/tencent/manager/c:b	(I)V
    //   36: aload_0
    //   37: invokestatic 325	java/lang/System:currentTimeMillis	()J
    //   40: putfield 193	com/tencent/manager/NowPluginManager:startLoadAVTime	J
    //   43: new 301	android/os/Bundle
    //   46: dup
    //   47: invokespecial 302	android/os/Bundle:<init>	()V
    //   50: astore 7
    //   52: aload 7
    //   54: ldc_w 304
    //   57: ldc_w 915
    //   60: invokevirtual 310	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   63: aload 7
    //   65: invokestatic 319	com/tencent/util/g/a:a	(Landroid/os/Bundle;)V
    //   68: aload_0
    //   69: invokevirtual 370	com/tencent/manager/NowPluginManager:isNeedStop	()Z
    //   72: ifeq +29 -> 101
    //   75: getstatic 124	com/tencent/manager/NowPluginManager:TAG	Ljava/lang/String;
    //   78: ldc_w 917
    //   81: invokestatic 389	com/tencent/util/e/a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   84: aload 7
    //   86: ldc_w 304
    //   89: ldc_w 919
    //   92: invokevirtual 310	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   95: aload 7
    //   97: invokestatic 319	com/tencent/util/g/a:a	(Landroid/os/Bundle;)V
    //   100: return
    //   101: aload_0
    //   102: invokespecial 675	com/tencent/manager/NowPluginManager:isAVPluginLoaded	()Z
    //   105: istore_3
    //   106: aload_0
    //   107: getfield 173	com/tencent/manager/NowPluginManager:mPlugininfo	Lcom/tencent/manager/c;
    //   110: getfield 376	com/tencent/manager/c:g	Lcom/tencent/shadow/core/manager/installplugin/InstalledPlugin;
    //   113: invokestatic 381	com/tencent/manager/c/d:b	(Lcom/tencent/shadow/core/manager/installplugin/InstalledPlugin;)Z
    //   116: istore 4
    //   118: iload_3
    //   119: ifne +523 -> 642
    //   122: aload_0
    //   123: iconst_0
    //   124: putfield 218	com/tencent/manager/NowPluginManager:mIsBindPluginService	Z
    //   127: aload 7
    //   129: ldc_w 304
    //   132: ldc_w 921
    //   135: invokevirtual 310	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   138: aload 7
    //   140: invokestatic 319	com/tencent/util/g/a:a	(Landroid/os/Bundle;)V
    //   143: new 301	android/os/Bundle
    //   146: dup
    //   147: invokespecial 302	android/os/Bundle:<init>	()V
    //   150: astore 8
    //   152: invokestatic 325	java/lang/System:currentTimeMillis	()J
    //   155: lstore 5
    //   157: aload_0
    //   158: aload_0
    //   159: getfield 173	com/tencent/manager/NowPluginManager:mPlugininfo	Lcom/tencent/manager/c;
    //   162: getfield 376	com/tencent/manager/c:g	Lcom/tencent/shadow/core/manager/installplugin/InstalledPlugin;
    //   165: getfield 443	com/tencent/shadow/core/manager/installplugin/InstalledPlugin:UUID	Ljava/lang/String;
    //   168: ldc_w 923
    //   171: invokespecial 926	com/tencent/manager/NowPluginManager:loadPlugin	(Ljava/lang/String;Ljava/lang/String;)V
    //   174: aload_0
    //   175: aload_0
    //   176: getfield 173	com/tencent/manager/NowPluginManager:mPlugininfo	Lcom/tencent/manager/c;
    //   179: getfield 376	com/tencent/manager/c:g	Lcom/tencent/shadow/core/manager/installplugin/InstalledPlugin;
    //   182: getfield 443	com/tencent/shadow/core/manager/installplugin/InstalledPlugin:UUID	Ljava/lang/String;
    //   185: ldc_w 641
    //   188: invokespecial 926	com/tencent/manager/NowPluginManager:loadPlugin	(Ljava/lang/String;Ljava/lang/String;)V
    //   191: getstatic 124	com/tencent/manager/NowPluginManager:TAG	Ljava/lang/String;
    //   194: ldc_w 928
    //   197: invokestatic 389	com/tencent/util/e/a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   200: aload 8
    //   202: ldc_w 304
    //   205: ldc_w 930
    //   208: invokevirtual 310	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   211: aload 8
    //   213: ldc_w 627
    //   216: invokestatic 325	java/lang/System:currentTimeMillis	()J
    //   219: lload 5
    //   221: lsub
    //   222: invokestatic 630	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   225: invokevirtual 310	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   228: aload 8
    //   230: invokestatic 319	com/tencent/util/g/a:a	(Landroid/os/Bundle;)V
    //   233: aload_0
    //   234: invokevirtual 370	com/tencent/manager/NowPluginManager:isNeedStop	()Z
    //   237: ifeq +100 -> 337
    //   240: getstatic 124	com/tencent/manager/NowPluginManager:TAG	Ljava/lang/String;
    //   243: ldc_w 932
    //   246: invokestatic 389	com/tencent/util/e/a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   249: aload 7
    //   251: ldc_w 304
    //   254: ldc_w 919
    //   257: invokevirtual 310	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   260: aload 7
    //   262: invokestatic 319	com/tencent/util/g/a:a	(Landroid/os/Bundle;)V
    //   265: return
    //   266: astore 8
    //   268: getstatic 124	com/tencent/manager/NowPluginManager:TAG	Ljava/lang/String;
    //   271: new 422	java/lang/StringBuilder
    //   274: dup
    //   275: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   278: ldc_w 934
    //   281: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: aload 8
    //   286: invokevirtual 935	android/os/DeadObjectException:toString	()Ljava/lang/String;
    //   289: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   295: invokestatic 389	com/tencent/util/e/a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   298: ldc2_w 936
    //   301: invokestatic 942	java/lang/Thread:sleep	(J)V
    //   304: aload_0
    //   305: getstatic 128	com/tencent/manager/NowPluginManager:HOST_SERVICE_NAME	Ljava/lang/String;
    //   308: invokevirtual 654	com/tencent/manager/NowPluginManager:bindPluginProcessService	(Ljava/lang/String;)V
    //   311: aload_0
    //   312: bipush 10
    //   314: getstatic 660	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   317: invokevirtual 664	com/tencent/manager/NowPluginManager:waitServiceConnected	(ILjava/util/concurrent/TimeUnit;)V
    //   320: aload_0
    //   321: getfield 167	com/tencent/manager/NowPluginManager:mRetryLoadAvCount	Ljava/util/concurrent/atomic/AtomicInteger;
    //   324: invokevirtual 945	java/util/concurrent/atomic/AtomicInteger:incrementAndGet	()I
    //   327: iconst_3
    //   328: if_icmpgt +465 -> 793
    //   331: aload_0
    //   332: iload_1
    //   333: invokespecial 298	com/tencent/manager/NowPluginManager:loadLocalNowAVPlugin	(I)V
    //   336: return
    //   337: getstatic 124	com/tencent/manager/NowPluginManager:TAG	Ljava/lang/String;
    //   340: ldc_w 947
    //   343: invokestatic 822	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   346: pop
    //   347: aload_0
    //   348: getfield 173	com/tencent/manager/NowPluginManager:mPlugininfo	Lcom/tencent/manager/c;
    //   351: astore 8
    //   353: iload 4
    //   355: ifeq +216 -> 571
    //   358: aload 8
    //   360: iload_2
    //   361: invokevirtual 383	com/tencent/manager/c:a	(I)V
    //   364: new 301	android/os/Bundle
    //   367: dup
    //   368: invokespecial 302	android/os/Bundle:<init>	()V
    //   371: astore 8
    //   373: invokestatic 325	java/lang/System:currentTimeMillis	()J
    //   376: lstore 5
    //   378: aload 8
    //   380: ldc_w 304
    //   383: ldc_w 949
    //   386: invokevirtual 310	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   389: aload 8
    //   391: invokestatic 319	com/tencent/util/g/a:a	(Landroid/os/Bundle;)V
    //   394: aload_0
    //   395: getfield 259	com/tencent/manager/NowPluginManager:mPluginLoader	Lcom/tencent/shadow/dynamic/loader/PluginLoader;
    //   398: ldc_w 641
    //   401: invokeinterface 952 2 0
    //   406: iconst_1
    //   407: putstatic 954	com/tencent/manager/c:a	Z
    //   410: aload 8
    //   412: ldc_w 304
    //   415: ldc_w 956
    //   418: invokevirtual 310	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   421: aload 8
    //   423: ldc_w 627
    //   426: invokestatic 325	java/lang/System:currentTimeMillis	()J
    //   429: lload 5
    //   431: lsub
    //   432: invokestatic 630	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   435: invokevirtual 310	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   438: aload 8
    //   440: invokestatic 319	com/tencent/util/g/a:a	(Landroid/os/Bundle;)V
    //   443: getstatic 124	com/tencent/manager/NowPluginManager:TAG	Ljava/lang/String;
    //   446: ldc_w 958
    //   449: invokestatic 389	com/tencent/util/e/a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   452: aload_0
    //   453: iload_1
    //   454: invokespecial 960	com/tencent/manager/NowPluginManager:bindService	(I)V
    //   457: aload_0
    //   458: getfield 218	com/tencent/manager/NowPluginManager:mIsBindPluginService	Z
    //   461: ifne +308 -> 769
    //   464: aload_0
    //   465: invokespecial 675	com/tencent/manager/NowPluginManager:isAVPluginLoaded	()Z
    //   468: ifeq +289 -> 757
    //   471: getstatic 124	com/tencent/manager/NowPluginManager:TAG	Ljava/lang/String;
    //   474: ldc_w 962
    //   477: invokestatic 477	com/tencent/util/e/a:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   480: aload_0
    //   481: iload_1
    //   482: invokespecial 960	com/tencent/manager/NowPluginManager:bindService	(I)V
    //   485: aload_0
    //   486: getfield 167	com/tencent/manager/NowPluginManager:mRetryLoadAvCount	Ljava/util/concurrent/atomic/AtomicInteger;
    //   489: iconst_0
    //   490: invokevirtual 965	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   493: return
    //   494: astore 8
    //   496: getstatic 124	com/tencent/manager/NowPluginManager:TAG	Ljava/lang/String;
    //   499: new 422	java/lang/StringBuilder
    //   502: dup
    //   503: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   506: ldc_w 967
    //   509: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   512: aload 8
    //   514: invokevirtual 968	java/lang/Exception:toString	()Ljava/lang/String;
    //   517: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   523: invokestatic 389	com/tencent/util/e/a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   526: aload 7
    //   528: ldc_w 304
    //   531: ldc_w 970
    //   534: invokevirtual 310	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   537: aload 7
    //   539: ldc_w 312
    //   542: aload 8
    //   544: invokevirtual 606	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   547: invokevirtual 310	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   550: aload 7
    //   552: ldc_w 525
    //   555: ldc_w 972
    //   558: invokevirtual 310	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   561: aload 7
    //   563: invokestatic 319	com/tencent/util/g/a:a	(Landroid/os/Bundle;)V
    //   566: aload_0
    //   567: invokespecial 288	com/tencent/manager/NowPluginManager:showError	()V
    //   570: return
    //   571: iconst_4
    //   572: istore_2
    //   573: goto -215 -> 358
    //   576: astore 9
    //   578: aload 8
    //   580: ldc_w 304
    //   583: ldc_w 970
    //   586: invokevirtual 310	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   589: aload 8
    //   591: ldc_w 312
    //   594: ldc_w 974
    //   597: invokevirtual 310	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   600: aload 8
    //   602: invokestatic 319	com/tencent/util/g/a:a	(Landroid/os/Bundle;)V
    //   605: getstatic 124	com/tencent/manager/NowPluginManager:TAG	Ljava/lang/String;
    //   608: new 422	java/lang/StringBuilder
    //   611: dup
    //   612: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   615: ldc_w 976
    //   618: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   621: aload 9
    //   623: invokevirtual 606	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   626: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   629: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   632: invokestatic 389	com/tencent/util/e/a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   635: aload_0
    //   636: invokespecial 288	com/tencent/manager/NowPluginManager:showError	()V
    //   639: goto -187 -> 452
    //   642: getstatic 124	com/tencent/manager/NowPluginManager:TAG	Ljava/lang/String;
    //   645: ldc_w 978
    //   648: invokestatic 389	com/tencent/util/e/a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   651: getstatic 954	com/tencent/manager/c:a	Z
    //   654: ifne +30 -> 684
    //   657: getstatic 980	com/tencent/manager/c:c	Z
    //   660: ifeq +24 -> 684
    //   663: getstatic 124	com/tencent/manager/NowPluginManager:TAG	Ljava/lang/String;
    //   666: ldc_w 982
    //   669: invokestatic 389	com/tencent/util/e/a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   672: aload_0
    //   673: getfield 259	com/tencent/manager/NowPluginManager:mPluginLoader	Lcom/tencent/shadow/dynamic/loader/PluginLoader;
    //   676: ldc_w 641
    //   679: invokeinterface 952 2 0
    //   684: aload_0
    //   685: getfield 218	com/tencent/manager/NowPluginManager:mIsBindPluginService	Z
    //   688: ifeq +12 -> 700
    //   691: iload_1
    //   692: iconst_1
    //   693: if_icmpne +26 -> 719
    //   696: aload_0
    //   697: invokespecial 233	com/tencent/manager/NowPluginManager:launchNowAVPlugin	()V
    //   700: aload_0
    //   701: invokespecial 984	com/tencent/manager/NowPluginManager:isBizPluginLoaded	()Z
    //   704: ifeq +28 -> 732
    //   707: aload_0
    //   708: getfield 173	com/tencent/manager/NowPluginManager:mPlugininfo	Lcom/tencent/manager/c;
    //   711: bipush 6
    //   713: invokevirtual 383	com/tencent/manager/c:a	(I)V
    //   716: goto -259 -> 457
    //   719: iload_1
    //   720: iconst_2
    //   721: if_icmpne -21 -> 700
    //   724: aload_0
    //   725: iload_1
    //   726: invokespecial 237	com/tencent/manager/NowPluginManager:checkAndLoadBizPlugin	(I)V
    //   729: goto -29 -> 700
    //   732: iload 4
    //   734: ifeq -277 -> 457
    //   737: aload_0
    //   738: getfield 173	com/tencent/manager/NowPluginManager:mPlugininfo	Lcom/tencent/manager/c;
    //   741: astore 8
    //   743: iload 4
    //   745: ifeq +93 -> 838
    //   748: aload 8
    //   750: iload_2
    //   751: invokevirtual 383	com/tencent/manager/c:a	(I)V
    //   754: goto -297 -> 457
    //   757: getstatic 124	com/tencent/manager/NowPluginManager:TAG	Ljava/lang/String;
    //   760: ldc_w 986
    //   763: invokestatic 477	com/tencent/util/e/a:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   766: goto -281 -> 485
    //   769: getstatic 124	com/tencent/manager/NowPluginManager:TAG	Ljava/lang/String;
    //   772: ldc_w 988
    //   775: invokestatic 477	com/tencent/util/e/a:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   778: goto -293 -> 485
    //   781: astore 7
    //   783: getstatic 124	com/tencent/manager/NowPluginManager:TAG	Ljava/lang/String;
    //   786: ldc_w 990
    //   789: invokestatic 389	com/tencent/util/e/a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   792: return
    //   793: new 301	android/os/Bundle
    //   796: dup
    //   797: invokespecial 302	android/os/Bundle:<init>	()V
    //   800: pop
    //   801: aload 7
    //   803: ldc_w 304
    //   806: ldc_w 970
    //   809: invokevirtual 310	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   812: aload 7
    //   814: ldc_w 312
    //   817: ldc_w 992
    //   820: invokevirtual 310	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   823: aload 7
    //   825: invokestatic 319	com/tencent/util/g/a:a	(Landroid/os/Bundle;)V
    //   828: aload_0
    //   829: invokespecial 288	com/tencent/manager/NowPluginManager:showError	()V
    //   832: return
    //   833: astore 8
    //   835: goto -531 -> 304
    //   838: iconst_4
    //   839: istore_2
    //   840: goto -92 -> 748
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	843	0	this	NowPluginManager
    //   0	843	1	paramInt	int
    //   1	839	2	i	int
    //   105	14	3	bool1	boolean
    //   116	628	4	bool2	boolean
    //   155	275	5	l	long
    //   50	512	7	localBundle1	Bundle
    //   781	43	7	localTimeoutException	java.util.concurrent.TimeoutException
    //   150	79	8	localBundle2	Bundle
    //   266	19	8	localDeadObjectException	android.os.DeadObjectException
    //   351	88	8	localObject	Object
    //   494	107	8	localException1	Exception
    //   741	8	8	localc	c
    //   833	1	8	localInterruptedException	java.lang.InterruptedException
    //   576	46	9	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   122	265	266	android/os/DeadObjectException
    //   337	353	266	android/os/DeadObjectException
    //   358	373	266	android/os/DeadObjectException
    //   373	452	266	android/os/DeadObjectException
    //   452	457	266	android/os/DeadObjectException
    //   457	485	266	android/os/DeadObjectException
    //   485	493	266	android/os/DeadObjectException
    //   578	639	266	android/os/DeadObjectException
    //   642	684	266	android/os/DeadObjectException
    //   684	691	266	android/os/DeadObjectException
    //   696	700	266	android/os/DeadObjectException
    //   700	716	266	android/os/DeadObjectException
    //   724	729	266	android/os/DeadObjectException
    //   737	743	266	android/os/DeadObjectException
    //   748	754	266	android/os/DeadObjectException
    //   757	766	266	android/os/DeadObjectException
    //   769	778	266	android/os/DeadObjectException
    //   122	265	494	java/lang/Exception
    //   337	353	494	java/lang/Exception
    //   358	373	494	java/lang/Exception
    //   452	457	494	java/lang/Exception
    //   457	485	494	java/lang/Exception
    //   485	493	494	java/lang/Exception
    //   578	639	494	java/lang/Exception
    //   642	684	494	java/lang/Exception
    //   684	691	494	java/lang/Exception
    //   696	700	494	java/lang/Exception
    //   700	716	494	java/lang/Exception
    //   724	729	494	java/lang/Exception
    //   737	743	494	java/lang/Exception
    //   748	754	494	java/lang/Exception
    //   757	766	494	java/lang/Exception
    //   769	778	494	java/lang/Exception
    //   373	452	576	java/lang/Exception
    //   311	320	781	java/util/concurrent/TimeoutException
    //   298	304	833	java/lang/InterruptedException
  }
  
  private void loadLocalNowBizPlugin(int paramInt)
  {
    com.tencent.util.e.a.a(TAG, "loadLocalNowBizPlugin action = " + paramInt);
    if (isNeedStop()) {
      com.tencent.util.e.a.a(TAG, "loadLocalNowBizPlugin needStop");
    }
    do
    {
      return;
      long l = System.currentTimeMillis();
      Bundle localBundle1 = new Bundle();
      localBundle1.putString("op_name", "load_biz_plugin");
      localBundle1.putString("d1", "load_local");
      com.tencent.util.g.a.a(localBundle1);
      Bundle localBundle4;
      try
      {
        if (isBizPluginLoaded())
        {
          if ((!c.b) && (c.c))
          {
            com.tencent.util.e.a.a(TAG, "bizplugin is loaded,but application has not called   ");
            this.mPluginLoader.callApplicationOnCreate("NowBiz");
          }
          if (paramInt == 1)
          {
            Bundle localBundle2 = new Bundle();
            localBundle2.putInt("load_step", 5);
            localBundle2.putInt("load_result", 0);
            localBundle2.putString("err_msg", "");
            IPCHelper.pushToPlugin(3, localBundle2);
            this.mPlugininfo.b(6);
          }
          localBundle1.putString("op_name", "load_biz_plugin");
          localBundle1.putString("d1", "sucess");
          localBundle1.putString("d2", "2");
          com.tencent.util.g.a.a(localBundle1);
          return;
        }
      }
      catch (Exception localException)
      {
        if (paramInt == 1)
        {
          localBundle4 = new Bundle();
          localBundle4.putInt("load_result", 1);
          localBundle4.putInt("load_step", 6);
          localBundle4.putString("err_msg", localException.getMessage());
          IPCHelper.pushToPlugin(3, localBundle4);
        }
        localBundle1.putString("op_name", "load_biz_plugin");
        localBundle1.putString("d1", "fail");
        localBundle1.putString("d2", "2");
        localBundle1.putString("d3", localException.getMessage());
        com.tencent.util.g.a.a(localBundle1);
        com.tencent.util.e.a.a(TAG, "load biz exception!e = " + localException.getMessage());
        return;
      }
      loadPlugin(this.mPlugininfo.g.UUID, "NowBiz");
      com.tencent.util.e.a.a(TAG, "loadLocalNowBizPlugin finish");
      try
      {
        if (isNeedStop())
        {
          com.tencent.util.e.a.a(TAG, "loadLocalNowBizPlugin before callApplicationOnCreate isNeedStop");
          return;
        }
      }
      catch (RemoteException localRemoteException)
      {
        if (paramInt == 1)
        {
          localBundle4 = new Bundle();
          localBundle4.putInt("load_result", 1);
          localBundle4.putInt("load_step", 6);
          localBundle4.putString("err_msg", localRemoteException.getMessage());
          IPCHelper.pushToPlugin(3, localBundle4);
        }
        localBundle1.putString("op_name", "load_biz_plugin");
        localBundle1.putString("d1", "fail");
        localBundle1.putString("d2", "1");
        localBundle1.putString("d3", localRemoteException.getMessage());
        com.tencent.util.g.a.a(localBundle1);
        com.tencent.util.e.a.a(TAG, "loadLocalNowBizPlugin  e = " + localRemoteException.getMessage());
        return;
      }
      this.mPluginLoader.callApplicationOnCreate("NowBiz");
      this.mPlugininfo.a(6);
      c.b = true;
      localBundle1.putString("op_name", "load_biz_plugin");
      localBundle1.putString("d1", "sucess");
      localBundle1.putString("d2", "1");
      localBundle1.putString("timeconsume", String.valueOf(System.currentTimeMillis() - l));
      com.tencent.util.g.a.a(localBundle1);
    } while (paramInt != 1);
    Bundle localBundle3 = new Bundle();
    localBundle3.putInt("load_step", 5);
    localBundle3.putInt("load_result", 0);
    localBundle3.putString("err_msg", "");
    IPCHelper.pushToPlugin(3, localBundle3);
  }
  
  private void loadPlugin(String paramString1, String paramString2)
  {
    if (isNeedStop())
    {
      com.tencent.util.e.a.a(TAG, "loadPlugin isNeedStop");
      return;
    }
    loadPluginLoaderAndRuntime(paramString1);
    this.mPluginLoader.loadPlugin(paramString2);
  }
  
  private void loadPluginLoaderAndRuntime(String paramString)
  {
    if (this.mPpsController == null)
    {
      bindPluginProcessService(HOST_SERVICE_NAME);
      waitServiceConnected(10, TimeUnit.SECONDS);
    }
    if (isNeedStop())
    {
      com.tencent.util.e.a.a(TAG, "loadPluginLoaderAndRuntime isNeedStop");
      return;
    }
    loadRunTime(paramString);
    loadPluginLoader(paramString);
  }
  
  private boolean needCheckPluginVersion()
  {
    return (d.a(this.mContext) != 14) || (this.mUpdateDelegator.a());
  }
  
  private void odexPluginAfterLoaded()
  {
    try
    {
      long l = System.currentTimeMillis();
      Object localObject = this.mPlugininfo.g;
      if (localObject == null) {
        return;
      }
      LinkedList localLinkedList = new LinkedList();
      Iterator localIterator = ((InstalledPlugin)localObject).plugins.entrySet().iterator();
      for (;;)
      {
        final String str;
        if (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          str = (String)localEntry.getKey();
          if (((InstalledPlugin.PluginPart)localEntry.getValue()).oDexDir == null) {}
        }
        else
        {
          localObject = localLinkedList.iterator();
          while (((Iterator)localObject).hasNext()) {
            ((Future)((Iterator)localObject).next()).get();
          }
        }
        localLinkedList.add(this.mFixedPool.submit(new Callable()
        {
          public Object call()
          {
            NowPluginManager.this.oDexPlugin(this.a.UUID, str);
            return null;
          }
        }));
      }
      com.tencent.util.e.a.a(TAG, " odex  finish耗时为：" + (System.currentTimeMillis() - l) + "ms");
      return;
    }
    catch (Exception localException) {}
  }
  
  private void openRoom(final long paramLong, Bundle paramBundle)
  {
    parsePluginParamInfo(paramLong, paramBundle);
    paramBundle.putInt("pluginstatus", this.mPlugininfo.k);
    int i = com.tencent.manager.c.b.f(paramBundle);
    paramLong = com.tencent.manager.c.b.a(paramBundle);
    String str1 = com.tencent.manager.c.b.g(paramBundle);
    if (i == 3)
    {
      completeEnter();
      jumpToWebView(paramLong, com.tencent.manager.c.b.l(paramBundle), "first_h5", com.tencent.manager.c.b.g(paramBundle), null);
      return;
    }
    if ((i == 1) && (f.a(this.mHostContext)))
    {
      completeEnter();
      try
      {
        f.a(this.mHostContext, paramBundle);
        return;
      }
      catch (Exception paramBundle)
      {
        com.tencent.util.e.a.b(TAG, "jumpToNowApp, e=" + paramBundle.toString());
        return;
      }
    }
    String str2 = com.tencent.manager.c.b.c(paramBundle);
    if ("1".equals(str2))
    {
      str1 = com.tencent.manager.c.b.j(paramBundle);
      str1 = com.tencent.util.f.b.a(com.tencent.manager.c.b.a(str1)) + "&" + com.tencent.manager.c.b.k(paramBundle);
      completeEnter();
      jumpToWebView(paramLong, str1, "record", com.tencent.manager.c.b.g(paramBundle), null);
      return;
    }
    if ("2".equals(str2))
    {
      jumpToPluginWithLoadingView(paramBundle);
      return;
    }
    com.tencent.util.e.a.a(TAG, "record logic");
    if (com.tencent.util.f.b.a(paramBundle))
    {
      com.tencent.util.e.a.a(TAG, "getRecordInfo");
      final long l = System.currentTimeMillis();
      com.tencent.util.f.b.a(str1, paramLong, this.mPlugininfo.d, this.mPlugininfo.h, new com.tencent.util.f.a()
      {
        public void a(boolean paramAnonymousBoolean, String paramAnonymousString1, String paramAnonymousString2, long paramAnonymousLong, String paramAnonymousString3)
        {
          int j = 1;
          Bundle localBundle = new Bundle();
          localBundle.putString("op_name", "get_record_complete");
          if (paramAnonymousBoolean) {}
          for (paramAnonymousString2 = "1";; paramAnonymousString2 = "0")
          {
            localBundle.putString("d1", paramAnonymousString2);
            localBundle.putString("timeconsume", String.valueOf(System.currentTimeMillis() - l));
            com.tencent.util.g.a.a(localBundle);
            if (!paramAnonymousBoolean) {
              break;
            }
            NowPluginManager.this.jumpToPluginWithLoadingView(paramLong);
            return;
          }
          int i;
          if ((!TextUtils.isEmpty(paramAnonymousString3)) && (paramAnonymousString3.startsWith("mqqapi")))
          {
            i = 1;
            if (TextUtils.isEmpty(paramAnonymousString1)) {
              break label179;
            }
          }
          for (;;)
          {
            if (i == 0) {
              break label185;
            }
            com.tencent.util.e.a.a(NowPluginManager.TAG, "停播状态，并且后台有下发mqq串,mqqscheme = " + paramAnonymousString3);
            paramAnonymousString1 = paramAnonymousString3 + "&shakespearetime=1";
            NowPluginManager.this.completeEnter();
            com.tencent.util.h.a.a(paramAnonymousString1);
            return;
            i = 0;
            break;
            label179:
            j = 0;
          }
          label185:
          if (j != 0)
          {
            com.tencent.util.e.a.a(NowPluginManager.TAG, "停播状态，录播url = " + paramAnonymousString1);
            if (!com.tencent.util.a.a()) {
              break label280;
            }
            paramAnonymousString1 = paramAnonymousString1.replaceAll("now.qq.com", "h5test.now.qq.com");
          }
          label280:
          for (;;)
          {
            NowPluginManager.this.completeEnter();
            NowPluginManager.this.jumpToWebView(this.c, paramAnonymousString1, "record", com.tencent.manager.c.b.g(paramLong), null);
            return;
            com.tencent.util.e.a.a(NowPluginManager.TAG, "停播状态,没有mqqscheme,也没有vid,直接跳转结合版");
            NowPluginManager.this.jumpToPluginWithLoadingView(paramLong);
            return;
          }
        }
      });
      return;
    }
    jumpToPluginWithLoadingView(paramBundle);
  }
  
  private void parsePluginParamInfo(long paramLong, Bundle paramBundle)
  {
    Log.i(TAG, "parsePluginParamInfo");
    this.mPlugininfo.d = paramBundle.getString("appid");
    this.mPlugininfo.e = paramBundle.getString("uid");
    this.mPlugininfo.h = paramBundle.getString("hostVersion");
    this.mPlugininfo.i = paramBundle;
    Log.i(TAG, "parsePluginParamInfo  finish");
  }
  
  private void preInstallNow(long paramLong, Bundle paramBundle)
  {
    com.tencent.util.e.a.a(TAG, "start preInstall");
    parsePluginParamInfo(paramLong, paramBundle);
    launchPlugin(8);
  }
  
  private void preloadNow(long paramLong, Bundle paramBundle)
  {
    com.tencent.util.e.a.a(TAG, "start preloadNow");
    parsePluginParamInfo(paramLong, paramBundle);
    launchPlugin(2);
  }
  
  private void preloadNowPlugin()
  {
    com.tencent.manager.b.a.a().a(new Runnable()
    {
      public void run()
      {
        NowPluginManager.this.installPlugin(1, "sdcard/now_av.zip", null, false);
        NowPluginManager.this.loadLocalNowAVPlugin(2);
      }
    });
    com.tencent.manager.b.a.b().a(new Runnable()
    {
      public void run()
      {
        NowPluginManager.this.installPlugin(2, "sdcard/now_biz.zip", null, false);
        NowPluginManager.this.loadLocalNowBizPlugin(2);
      }
    });
  }
  
  private void resetPluginStatus()
  {
    try
    {
      this.mPlugininfo.a(0);
      List localList = getInstalledPlugins(1);
      if ((localList != null) && (localList.size() != 0))
      {
        this.mPlugininfo.g = ((InstalledPlugin)localList.get(0));
        int j = this.mPlugininfo.k;
        int i;
        if (!d.a(this.mPlugininfo.g)) {
          i = 1;
        }
        for (;;)
        {
          this.mPlugininfo.a(i);
          return;
          if ((d.a(this.mPlugininfo.g)) && (!d.b(this.mPlugininfo.g)))
          {
            i = 2;
          }
          else
          {
            i = j;
            if (d.a(this.mPlugininfo.g))
            {
              i = j;
              if (d.b(this.mPlugininfo.g)) {
                i = 3;
              }
            }
          }
        }
      }
      this.mPlugininfo.a(1);
      return;
    }
    catch (Exception localException)
    {
      this.mPlugininfo.a(1);
    }
  }
  
  private void showError()
  {
    com.tencent.util.e.a.b(TAG, "showError");
    EnterCallback localEnterCallback = (EnterCallback)this.mViewCallbackMap.get(1L);
    if (localEnterCallback != null)
    {
      localEnterCallback.onEnterComplete();
      this.mViewCallbackMap.remove(1L);
    }
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        NowPluginManager.access$2502(NowPluginManager.this, true);
        if (NowPluginManager.this.mLoadingView != null) {
          NowPluginManager.this.mLoadingView.a();
        }
      }
    });
  }
  
  public void clearInstalledPlugin()
  {
    try
    {
      killPluginProcessSysn();
      Object localObject1 = getInstalledPlugins(5);
      if (localObject1 != null)
      {
        com.tencent.util.e.a.a(TAG, "deleteAllInstalledPlugin installedPlugins.size = " + ((List)localObject1).size());
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          InstalledPlugin localInstalledPlugin = (InstalledPlugin)((Iterator)localObject1).next();
          if (localInstalledPlugin != null) {
            deleteInstalledPlugin(localInstalledPlugin.UUID);
          }
        }
        this.mPlugininfo.g = null;
      }
    }
    finally {}
  }
  
  public void enter(Context paramContext, long paramLong, Bundle paramBundle, EnterCallback paramEnterCallback)
  {
    com.tencent.util.e.a.a(TAG, "enter nowpluginmanager, versionName=4.1.0,versionCode=140,fromId=" + paramLong);
    this.isErrorHappen = false;
    int i = paramBundle.getInt("action");
    if (i == 1) {
      if (this.mViewCallbackMap.get(i) != null) {
        com.tencent.util.e.a.a(TAG, " 前一个action==" + i + " 未完成，重入了。");
      }
    }
    do
    {
      return;
      this.mViewCallbackMap.put(i, paramEnterCallback);
      paramBundle.putInt("pluginstatus", this.mPlugininfo.k);
      if ((!this.mIsBindLoadPluginService) && ((i == 1) || (i == 2)))
      {
        bindPluginProcessService(HOST_SERVICE_NAME);
        this.mIsBindLoadPluginService = true;
      }
      setNeedStop(false);
      initUpdateDelegator(paramContext);
      this.mPlugininfo.m = i;
      if (this.mPlatformInterface != null) {
        this.mPlatformInterface.onEnter(paramContext, paramLong, paramBundle);
      }
      this.bootTimeStart = paramBundle.getLong("entryTime", 0L);
      if (i == 1)
      {
        Log.i(TAG, "openroom");
        long l1 = System.currentTimeMillis();
        long l2 = this.bootTimeStart;
        paramContext = new Bundle();
        paramContext.putString("op_name", "enter_shadow");
        paramContext.putString("status1", String.valueOf(this.mPlugininfo.k));
        paramContext.putString("frameVersion", String.valueOf(14));
        paramContext.putString("timeconsume", String.valueOf(l1 - l2));
        paramContext.putString("d1", String.valueOf(140));
        com.tencent.util.g.a.a(paramContext);
        openRoom(paramLong, paramBundle);
        return;
      }
      if (i == 2)
      {
        if (this.mViewCallbackMap.get(1L) != null)
        {
          com.tencent.util.e.a.a(TAG, "ACTION_OPEN_ROOM的操作还没有完成，不可以做预加载");
          return;
        }
        if (com.tencent.manager.c.e.a(paramContext))
        {
          com.tencent.util.e.a.a(TAG, "当前为wifi网络，开始预加载");
          preloadNow(paramLong, paramBundle);
          return;
        }
        com.tencent.util.e.a.a(TAG, "当前为4g网络，不处理预预加载");
        return;
      }
      if (i == 4)
      {
        killPluginProcessSysn();
        deleteOverDuePlugin();
        resetPluginStatus();
        return;
      }
      if (i == 7)
      {
        IPCHelper.pushToPlugin(27, paramBundle);
        return;
      }
      if (i == 8)
      {
        if (this.mViewCallbackMap.get(1L) != null)
        {
          com.tencent.util.e.a.a(TAG, "ACTION_OPEN_ROOM的操作还没有完成，不可以做预安装");
          return;
        }
        preInstallNow(paramLong, paramBundle);
        return;
      }
    } while (i != 9);
    IPCHelper.pushToPlugin(30, paramBundle);
  }
  
  public String getAbi()
  {
    return "armeabi";
  }
  
  protected String getName()
  {
    return "Now";
  }
  
  public boolean isNeedStop()
  {
    try
    {
      boolean bool = this.isNeedStop;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isOpenDelayOdex()
  {
    return Build.VERSION.SDK_INT >= 21;
  }
  
  public void killPluginProcessSysn()
  {
    if ((this.mContext == null) || (this.mPlatformInterface == null)) {}
    do
    {
      return;
      if (com.tencent.manager.c.a.a(this.mContext, this.mPlatformInterface.pluginProcessName(this.mContext)))
      {
        long l = System.currentTimeMillis();
        com.tencent.manager.c.a.c(this.mContext, this.mPlatformInterface.pluginProcessName(this.mContext));
        com.tencent.util.e.a.a(TAG, "plugin process exit, sysnKillProcess, cost=" + (System.currentTimeMillis() - l));
      }
    } while (this.mPpsController == null);
    try
    {
      this.mPpsController.exit();
      this.mPpsController = null;
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        com.tencent.util.e.a.a(TAG, "mPpsController exit e:" + localRemoteException.getClass().getSimpleName());
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int i = 0;
    Log.i(TAG, "onCreate hashcode = " + hashCode());
    super.onCreate(paramBundle);
    listenHostCallback();
    IPCHelper.setLogger(new a());
    if (d.a(this.mContext) != 14)
    {
      com.tencent.util.e.a.a(TAG, "not match version");
      clearInstalledPlugin();
      killPluginProcessSysn();
      this.mPlugininfo.a(1);
      d.a(this.mContext, 14);
    }
    for (;;)
    {
      com.tencent.manager.b.a.a().c();
      com.tencent.manager.b.a.b().c();
      resetPluginStatus();
      if (i != 0) {
        this.mPlugininfo.a(i);
      }
      this.mViewCallbackMap.clear();
      com.tencent.util.e.a.a(TAG, "onCreate finish");
      return;
      if (paramBundle != null)
      {
        i = paramBundle.getInt("save_pluginstatus", 0);
        this.lastCheckVersionTime = paramBundle.getLong("last_checkversion_time", 0L);
        c.c = paramBundle.containsKey("av_application_inited");
        c.a = paramBundle.getBoolean("av_application_inited", false);
        c.b = paramBundle.getBoolean("biz_application_inited", false);
      }
    }
  }
  
  public void onDestroy()
  {
    com.tencent.util.e.a.a(TAG, "onDestroy");
    setNeedStop(true);
    try
    {
      if (this.mPluginLoader != null) {
        this.mPluginLoader.unbindService(this.mPluginServiceConnection);
      }
      if (this.mPlatformInterface != null) {
        this.mPlatformInterface.onPluginManagerDestory();
      }
      IPCHelper.removeBizReqListener(this.mBizTaskListener);
      super.onDestroy();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.util.e.a.a(TAG, "onDestroy, e=" + localException.toString());
      }
    }
  }
  
  /* Error */
  public void onKillPluginProcess()
  {
    // Byte code:
    //   0: getstatic 124	com/tencent/manager/NowPluginManager:TAG	Ljava/lang/String;
    //   3: ldc_w 1329
    //   6: invokestatic 389	com/tencent/util/e/a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: aload_0
    //   10: iconst_1
    //   11: invokevirtual 1189	com/tencent/manager/NowPluginManager:setNeedStop	(Z)V
    //   14: aload_0
    //   15: invokespecial 225	com/tencent/manager/NowPluginManager:resetPluginStatus	()V
    //   18: aload_0
    //   19: invokevirtual 1332	com/tencent/manager/NowPluginManager:unBinderUUIDManager	()V
    //   22: aload_0
    //   23: getfield 1042	com/tencent/manager/NowPluginManager:mPpsController	Lcom/tencent/shadow/dynamic/host/PpsController;
    //   26: ifnonnull +18 -> 44
    //   29: aload_0
    //   30: getstatic 128	com/tencent/manager/NowPluginManager:HOST_SERVICE_NAME	Ljava/lang/String;
    //   33: invokevirtual 654	com/tencent/manager/NowPluginManager:bindPluginProcessService	(Ljava/lang/String;)V
    //   36: aload_0
    //   37: iconst_5
    //   38: getstatic 660	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   41: invokevirtual 664	com/tencent/manager/NowPluginManager:waitServiceConnected	(ILjava/util/concurrent/TimeUnit;)V
    //   44: aload_0
    //   45: getfield 1042	com/tencent/manager/NowPluginManager:mPpsController	Lcom/tencent/shadow/dynamic/host/PpsController;
    //   48: astore_1
    //   49: aload_1
    //   50: monitorenter
    //   51: aload_0
    //   52: getfield 1042	com/tencent/manager/NowPluginManager:mPpsController	Lcom/tencent/shadow/dynamic/host/PpsController;
    //   55: invokevirtual 1260	com/tencent/shadow/dynamic/host/PpsController:exit	()V
    //   58: aload_0
    //   59: aconst_null
    //   60: putfield 1042	com/tencent/manager/NowPluginManager:mPpsController	Lcom/tencent/shadow/dynamic/host/PpsController;
    //   63: aload_1
    //   64: monitorexit
    //   65: getstatic 124	com/tencent/manager/NowPluginManager:TAG	Ljava/lang/String;
    //   68: ldc_w 1334
    //   71: invokestatic 389	com/tencent/util/e/a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   74: return
    //   75: astore_1
    //   76: getstatic 124	com/tencent/manager/NowPluginManager:TAG	Ljava/lang/String;
    //   79: ldc_w 1336
    //   82: invokestatic 477	com/tencent/util/e/a:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   85: aload_0
    //   86: invokevirtual 1165	com/tencent/manager/NowPluginManager:killPluginProcessSysn	()V
    //   89: return
    //   90: astore_2
    //   91: getstatic 124	com/tencent/manager/NowPluginManager:TAG	Ljava/lang/String;
    //   94: new 422	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 423	java/lang/StringBuilder:<init>	()V
    //   101: ldc_w 1262
    //   104: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload_2
    //   108: invokevirtual 757	java/lang/Object:getClass	()Ljava/lang/Class;
    //   111: invokevirtual 1265	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   114: invokevirtual 429	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 389	com/tencent/util/e/a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   123: goto -65 -> 58
    //   126: astore_2
    //   127: aload_1
    //   128: monitorexit
    //   129: aload_2
    //   130: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	this	NowPluginManager
    //   75	53	1	localTimeoutException	java.util.concurrent.TimeoutException
    //   90	18	2	localRemoteException	RemoteException
    //   126	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   36	44	75	java/util/concurrent/TimeoutException
    //   51	58	90	android/os/RemoteException
    //   51	58	126	finally
    //   58	65	126	finally
    //   91	123	126	finally
    //   127	129	126	finally
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putInt("save_pluginstatus", this.mPlugininfo.k);
    paramBundle.putLong("last_checkversion_time", this.mUpdateDelegator.b());
    paramBundle.putBoolean("av_application_inited", c.a);
    paramBundle.putBoolean("biz_application_inited", c.b);
    super.onSaveInstanceState(paramBundle);
  }
  
  public void setNeedStop(boolean paramBoolean)
  {
    try
    {
      this.isNeedStop = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\shadow\NowPluginManager_apk\classes.jar
 * Qualified Name:     com.tencent.manager.NowPluginManager
 * JD-Core Version:    0.7.0.1
 */