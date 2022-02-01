package com.tencent.tmassistantsdk.downloadservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceCallback;
import com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface.Stub;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantsdk.downloadservice.taskmanager.IServiceDownloadTaskManagerListener;
import com.tencent.tmassistantsdk.downloadservice.taskmanager.ServiceDownloadTaskManager;
import com.tencent.tmassistantsdk.logreport.GetSettingEngine;
import com.tencent.tmassistantsdk.logreport.LogReportManager;
import com.tencent.tmassistantsdk.storage.DBManager;
import com.tencent.tmassistantsdk.util.GlobalUtil;
import com.tencent.tmassistantsdk.util.TMLog;
import java.util.HashMap;
import java.util.Map;

public class TMAssistantDownloadSDKService
  extends Service
  implements IServiceDownloadTaskManagerListener
{
  protected static final String TAG = "TMAssistantDownloadSDKService";
  private byte _hellAccFlag_;
  protected final TMAssistantDownloadSDKServiceImpl downloadSDKServiceImpl;
  protected final HashMap<ITMAssistantDownloadSDKServiceCallback, String> mCallbackHashMap;
  protected final RemoteCallbackList<ITMAssistantDownloadSDKServiceCallback> mCallbacks;
  ServiceDownloadTaskManager mServiceDownloadTaskManager;
  
  public TMAssistantDownloadSDKService()
  {
    AppMethodBeat.i(102035);
    this.downloadSDKServiceImpl = new TMAssistantDownloadSDKServiceImpl();
    this.mCallbacks = new RemoteCallbackList();
    this.mCallbackHashMap = new HashMap();
    this.mServiceDownloadTaskManager = null;
    AppMethodBeat.o(102035);
  }
  
  public void OnDownloadProgressChanged(String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(102041);
    try
    {
      int j = this.mCallbacks.beginBroadcast();
      int i = 0;
      for (;;)
      {
        if (i < j) {}
        try
        {
          ITMAssistantDownloadSDKServiceCallback localITMAssistantDownloadSDKServiceCallback = (ITMAssistantDownloadSDKServiceCallback)this.mCallbacks.getBroadcastItem(i);
          String str = (String)this.mCallbackHashMap.get(localITMAssistantDownloadSDKServiceCallback);
          if ((str != null) && (str.equals(paramString1) == true))
          {
            TMLog.i("TMAssistantDownloadSDKService", "OnDownloadProgressChanged,clientKey:" + paramString1 + ",receivedLen:" + paramLong1 + ",url:" + paramString2);
            localITMAssistantDownloadSDKServiceCallback.OnDownloadSDKServiceTaskProgressChanged(paramString1, paramString2, paramLong1, paramLong2);
            this.mCallbacks.finishBroadcast();
            AppMethodBeat.o(102041);
            return;
          }
        }
        catch (RemoteException localRemoteException)
        {
          i += 1;
        }
      }
      return;
    }
    catch (Throwable paramString1)
    {
      AppMethodBeat.o(102041);
    }
  }
  
  public void OnDownloadStateChanged(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(102040);
    try
    {
      int j = this.mCallbacks.beginBroadcast();
      int i = 0;
      for (;;)
      {
        if (i < j) {}
        try
        {
          ITMAssistantDownloadSDKServiceCallback localITMAssistantDownloadSDKServiceCallback = (ITMAssistantDownloadSDKServiceCallback)this.mCallbacks.getBroadcastItem(i);
          String str = (String)this.mCallbackHashMap.get(localITMAssistantDownloadSDKServiceCallback);
          if ((str != null) && (str.equals(paramString1) == true))
          {
            TMLog.i("TMAssistantDownloadSDKService", "OnDownloadStateChanged,clientKey:" + paramString1 + ",state:" + paramInt1 + ",url:" + paramString2);
            localITMAssistantDownloadSDKServiceCallback.OnDownloadSDKServiceTaskStateChanged(paramString1, paramString2, paramInt1, paramInt2, paramString3, paramBoolean1, paramBoolean2);
            this.mCallbacks.finishBroadcast();
            AppMethodBeat.o(102040);
            return;
          }
        }
        catch (RemoteException localRemoteException)
        {
          i += 1;
        }
      }
      return;
    }
    catch (Throwable paramString1)
    {
      AppMethodBeat.o(102040);
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(102037);
    TMLog.i("TMAssistantDownloadSDKService", "onBind ,intent:".concat(String.valueOf(paramIntent)));
    paramIntent = this.downloadSDKServiceImpl;
    AppMethodBeat.o(102037);
    return paramIntent;
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(102036);
    super.onCreate();
    GlobalUtil.getInstance().setContext(this);
    NetworkMonitorReceiver.getInstance().registerReceiver();
    this.mServiceDownloadTaskManager = new ServiceDownloadTaskManager(DBManager.getInstance().queryWaitingAndDownloadingTaskList());
    this.mServiceDownloadTaskManager.setListener(this);
    this.mServiceDownloadTaskManager.registerApkDownloadManagerListener();
    ApkDownloadManager.getInstance().init();
    TMLog.i("TMAssistantDownloadSDKService", "onCreate");
    AppMethodBeat.o(102036);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(102039);
    TMLog.i("TMAssistantDownloadSDKService", "onDestroy");
    super.onDestroy();
    ApkDownloadManager.getInstance().uninit();
    GetSettingEngine.getInstance().cancleRequest();
    LogReportManager.getInstance().cancleReport();
    LogReportManager.getInstance().destory();
    this.mServiceDownloadTaskManager.unRegisterApkDownloadManagerListener();
    this.mServiceDownloadTaskManager.setListener(null);
    this.mServiceDownloadTaskManager = null;
    NetworkMonitorReceiver.getInstance().unregisterReceiver();
    GlobalUtil.getInstance().destroy();
    SystemClock.sleep(300L);
    com.tencent.mm.hellhoundlib.b.a locala = c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahp(), "com/tencent/tmassistantsdk/downloadservice/TMAssistantDownloadSDKService", "onDestroy", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    Process.killProcess(((Integer)locala.mq(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/tmassistantsdk/downloadservice/TMAssistantDownloadSDKService", "onDestroy", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    AppMethodBeat.o(102039);
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    AppMethodBeat.i(102038);
    TMLog.i("TMAssistantDownloadSDKService", "onUnbind ,intent:".concat(String.valueOf(paramIntent)));
    boolean bool = super.onUnbind(paramIntent);
    AppMethodBeat.o(102038);
    return bool;
  }
  
  protected class TMAssistantDownloadSDKServiceImpl
    extends ITMAssistantDownloadSDKServiceInterface.Stub
  {
    protected TMAssistantDownloadSDKServiceImpl() {}
    
    public void cancelDownloadTask(String paramString1, String paramString2)
    {
      AppMethodBeat.i(102032);
      if (TMAssistantDownloadSDKService.this.mServiceDownloadTaskManager != null) {
        TMAssistantDownloadSDKService.this.mServiceDownloadTaskManager.cancelDownload(paramString1, paramString2);
      }
      AppMethodBeat.o(102032);
    }
    
    public TMAssistantDownloadTaskInfo getDownloadTaskInfo(String paramString1, String paramString2)
    {
      AppMethodBeat.i(102029);
      TMLog.i("TMAssistantDownloadSDKService", "getDownloadTaskInfo");
      if (TMAssistantDownloadSDKService.this.mServiceDownloadTaskManager != null)
      {
        paramString1 = TMAssistantDownloadSDKService.this.mServiceDownloadTaskManager.getDownloadTaskInfo(paramString1, paramString2);
        AppMethodBeat.o(102029);
        return paramString1;
      }
      AppMethodBeat.o(102029);
      return null;
    }
    
    public int getServiceVersion()
    {
      return 1;
    }
    
    public boolean isAllDownloadFinished()
    {
      AppMethodBeat.i(102028);
      boolean bool = ApkDownloadManager.getInstance().isAllDownloadFinished().booleanValue();
      AppMethodBeat.o(102028);
      return bool;
    }
    
    public void pauseDownloadTask(String paramString1, String paramString2)
    {
      AppMethodBeat.i(102031);
      TMLog.i("TMAssistantDownloadSDKService", "pauseDownloadTask");
      try
      {
        if (TMAssistantDownloadSDKService.this.mServiceDownloadTaskManager != null) {
          TMAssistantDownloadSDKService.this.mServiceDownloadTaskManager.pauseDownload(paramString1, paramString2);
        }
        TMLog.i("TMAssistantDownloadSDKService", "pauseDownloadTask end");
        AppMethodBeat.o(102031);
        return;
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          ad.printErrStackTrace("TMAssistantDownloadSDKService", paramString1, "", new Object[0]);
        }
      }
    }
    
    public void registerDownloadTaskCallback(String paramString, ITMAssistantDownloadSDKServiceCallback paramITMAssistantDownloadSDKServiceCallback)
    {
      AppMethodBeat.i(102033);
      TMLog.i("TMAssistantDownloadSDKService", "registerDownloadTaskCallback,clientKey:".concat(String.valueOf(paramString)));
      if ((paramString != null) && (paramITMAssistantDownloadSDKServiceCallback != null))
      {
        TMAssistantDownloadSDKService.this.mCallbacks.register(paramITMAssistantDownloadSDKServiceCallback);
        try
        {
          TMAssistantDownloadSDKService.this.mCallbackHashMap.put(paramITMAssistantDownloadSDKServiceCallback, paramString);
          return;
        }
        finally
        {
          AppMethodBeat.o(102033);
        }
      }
      AppMethodBeat.o(102033);
    }
    
    public void setServiceSetingIsDownloadWifiOnly(boolean paramBoolean)
    {
      AppMethodBeat.i(102026);
      DownloadSetting.getInstance().setIsDownloadWifiOnly(paramBoolean);
      AppMethodBeat.o(102026);
    }
    
    public void setServiceSetingIsTaskAutoResume(boolean paramBoolean)
    {
      AppMethodBeat.i(102025);
      DownloadSetting.getInstance().setIsTaskAutoResume(paramBoolean);
      AppMethodBeat.o(102025);
    }
    
    public void setServiceSetingMaxTaskNum(int paramInt)
    {
      AppMethodBeat.i(102027);
      DownloadSetting.getInstance().setMaxTaskNum(paramInt);
      AppMethodBeat.o(102027);
    }
    
    public int startDownloadTask(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt, String paramString4, String paramString5, Map paramMap)
    {
      AppMethodBeat.i(102030);
      TMLog.i("TMAssistantDownloadSDKService", "startDownloadTask，clientkey:" + paramString1 + ",url:" + paramString2 + ",manager:" + TMAssistantDownloadSDKService.this.mServiceDownloadTaskManager + ",fileName:" + paramString5);
      if (TMAssistantDownloadSDKService.this.mServiceDownloadTaskManager != null)
      {
        DBManager.getInstance().saveClientInfo(paramString1, paramString2);
        paramInt = TMAssistantDownloadSDKService.this.mServiceDownloadTaskManager.startDownload(paramString1, paramString2, paramString3, paramLong, paramInt, paramString4, paramString5, paramMap);
        AppMethodBeat.o(102030);
        return paramInt;
      }
      AppMethodBeat.o(102030);
      return 3;
    }
    
    public void unregisterDownloadTaskCallback(String paramString, ITMAssistantDownloadSDKServiceCallback paramITMAssistantDownloadSDKServiceCallback)
    {
      AppMethodBeat.i(102034);
      TMLog.i("TMAssistantDownloadSDKService", "unregisterDownloadTaskCallback,clientKey:".concat(String.valueOf(paramString)));
      if ((paramString != null) && (paramITMAssistantDownloadSDKServiceCallback != null))
      {
        TMAssistantDownloadSDKService.this.mCallbacks.unregister(paramITMAssistantDownloadSDKServiceCallback);
        try
        {
          TMAssistantDownloadSDKService.this.mCallbackHashMap.remove(paramITMAssistantDownloadSDKServiceCallback);
          return;
        }
        finally
        {
          AppMethodBeat.o(102034);
        }
      }
      AppMethodBeat.o(102034);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadservice.TMAssistantDownloadSDKService
 * JD-Core Version:    0.7.0.1
 */