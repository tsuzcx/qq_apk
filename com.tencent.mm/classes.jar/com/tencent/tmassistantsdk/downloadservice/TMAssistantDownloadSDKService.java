package com.tencent.tmassistantsdk.downloadservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.SystemClock;
import com.tencent.mm.sdk.platformtools.y;
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
  protected final TMAssistantDownloadSDKServiceImpl downloadSDKServiceImpl = new TMAssistantDownloadSDKServiceImpl();
  protected final HashMap<ITMAssistantDownloadSDKServiceCallback, String> mCallbackHashMap = new HashMap();
  protected final RemoteCallbackList<ITMAssistantDownloadSDKServiceCallback> mCallbacks = new RemoteCallbackList();
  ServiceDownloadTaskManager mServiceDownloadTaskManager = null;
  
  public void OnDownloadProgressChanged(String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
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
    catch (Throwable paramString1) {}
  }
  
  public void OnDownloadStateChanged(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, boolean paramBoolean1, boolean paramBoolean2)
  {
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
    catch (Throwable paramString1) {}
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    TMLog.i("TMAssistantDownloadSDKService", "onBind ,intent:" + paramIntent);
    return this.downloadSDKServiceImpl;
  }
  
  public void onCreate()
  {
    super.onCreate();
    GlobalUtil.getInstance().setContext(this);
    NetworkMonitorReceiver.getInstance().registerReceiver();
    this.mServiceDownloadTaskManager = new ServiceDownloadTaskManager(DBManager.getInstance().queryWaitingAndDownloadingTaskList());
    this.mServiceDownloadTaskManager.setListener(this);
    this.mServiceDownloadTaskManager.registerApkDownloadManagerListener();
    ApkDownloadManager.getInstance().init();
    TMLog.i("TMAssistantDownloadSDKService", "onCreate");
  }
  
  public void onDestroy()
  {
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
    Process.killProcess(Process.myPid());
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    TMLog.i("TMAssistantDownloadSDKService", "onUnbind ,intent:" + paramIntent);
    return super.onUnbind(paramIntent);
  }
  
  protected class TMAssistantDownloadSDKServiceImpl
    extends ITMAssistantDownloadSDKServiceInterface.Stub
  {
    protected TMAssistantDownloadSDKServiceImpl() {}
    
    public void cancelDownloadTask(String paramString1, String paramString2)
    {
      if (TMAssistantDownloadSDKService.this.mServiceDownloadTaskManager != null) {
        TMAssistantDownloadSDKService.this.mServiceDownloadTaskManager.cancelDownload(paramString1, paramString2);
      }
    }
    
    public TMAssistantDownloadTaskInfo getDownloadTaskInfo(String paramString1, String paramString2)
    {
      TMLog.i("TMAssistantDownloadSDKService", "getDownloadTaskInfo");
      if (TMAssistantDownloadSDKService.this.mServiceDownloadTaskManager != null) {
        return TMAssistantDownloadSDKService.this.mServiceDownloadTaskManager.getDownloadTaskInfo(paramString1, paramString2);
      }
      return null;
    }
    
    public int getServiceVersion()
    {
      return 1;
    }
    
    public boolean isAllDownloadFinished()
    {
      return ApkDownloadManager.getInstance().isAllDownloadFinished().booleanValue();
    }
    
    public void pauseDownloadTask(String paramString1, String paramString2)
    {
      TMLog.i("TMAssistantDownloadSDKService", "pauseDownloadTask");
      try
      {
        if (TMAssistantDownloadSDKService.this.mServiceDownloadTaskManager != null) {
          TMAssistantDownloadSDKService.this.mServiceDownloadTaskManager.pauseDownload(paramString1, paramString2);
        }
        TMLog.i("TMAssistantDownloadSDKService", "pauseDownloadTask end");
        return;
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          y.printErrStackTrace("TMAssistantDownloadSDKService", paramString1, "", new Object[0]);
        }
      }
    }
    
    public void registerDownloadTaskCallback(String paramString, ITMAssistantDownloadSDKServiceCallback paramITMAssistantDownloadSDKServiceCallback)
    {
      TMLog.i("TMAssistantDownloadSDKService", "registerDownloadTaskCallback,clientKey:" + paramString);
      if ((paramString != null) && (paramITMAssistantDownloadSDKServiceCallback != null))
      {
        TMAssistantDownloadSDKService.this.mCallbacks.register(paramITMAssistantDownloadSDKServiceCallback);
        try
        {
          TMAssistantDownloadSDKService.this.mCallbackHashMap.put(paramITMAssistantDownloadSDKServiceCallback, paramString);
          return;
        }
        finally {}
      }
    }
    
    public void setServiceSetingIsDownloadWifiOnly(boolean paramBoolean)
    {
      DownloadSetting.getInstance().setIsDownloadWifiOnly(paramBoolean);
    }
    
    public void setServiceSetingIsTaskAutoResume(boolean paramBoolean)
    {
      DownloadSetting.getInstance().setIsTaskAutoResume(paramBoolean);
    }
    
    public void setServiceSetingMaxTaskNum(int paramInt)
    {
      DownloadSetting.getInstance().setMaxTaskNum(paramInt);
    }
    
    public int startDownloadTask(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt, String paramString4, String paramString5, Map paramMap)
    {
      TMLog.i("TMAssistantDownloadSDKService", "startDownloadTask，clientkey:" + paramString1 + ",url:" + paramString2 + ",manager:" + TMAssistantDownloadSDKService.this.mServiceDownloadTaskManager + ",fileName:" + paramString5);
      if (TMAssistantDownloadSDKService.this.mServiceDownloadTaskManager != null)
      {
        DBManager.getInstance().saveClientInfo(paramString1, paramString2);
        return TMAssistantDownloadSDKService.this.mServiceDownloadTaskManager.startDownload(paramString1, paramString2, paramString3, paramLong, paramInt, paramString4, paramString5, paramMap);
      }
      return 3;
    }
    
    public void unregisterDownloadTaskCallback(String paramString, ITMAssistantDownloadSDKServiceCallback paramITMAssistantDownloadSDKServiceCallback)
    {
      TMLog.i("TMAssistantDownloadSDKService", "unregisterDownloadTaskCallback,clientKey:" + paramString);
      if ((paramString != null) && (paramITMAssistantDownloadSDKServiceCallback != null))
      {
        TMAssistantDownloadSDKService.this.mCallbacks.unregister(paramITMAssistantDownloadSDKServiceCallback);
        try
        {
          TMAssistantDownloadSDKService.this.mCallbackHashMap.remove(paramITMAssistantDownloadSDKServiceCallback);
          return;
        }
        finally {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadservice.TMAssistantDownloadSDKService
 * JD-Core Version:    0.7.0.1
 */