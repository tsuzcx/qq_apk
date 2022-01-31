package com.tencent.tmassistantsdk.downloadservice;

import android.os.RemoteCallbackList;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceCallback;
import com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface.Stub;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantsdk.downloadservice.taskmanager.ServiceDownloadTaskManager;
import com.tencent.tmassistantsdk.storage.DBManager;
import com.tencent.tmassistantsdk.util.TMLog;
import java.util.HashMap;
import java.util.Map;

public class TMAssistantDownloadSDKService$TMAssistantDownloadSDKServiceImpl
  extends ITMAssistantDownloadSDKServiceInterface.Stub
{
  protected TMAssistantDownloadSDKService$TMAssistantDownloadSDKServiceImpl(TMAssistantDownloadSDKService paramTMAssistantDownloadSDKService) {}
  
  public void cancelDownloadTask(String paramString1, String paramString2)
  {
    AppMethodBeat.i(75786);
    if (this.this$0.mServiceDownloadTaskManager != null) {
      this.this$0.mServiceDownloadTaskManager.cancelDownload(paramString1, paramString2);
    }
    AppMethodBeat.o(75786);
  }
  
  public TMAssistantDownloadTaskInfo getDownloadTaskInfo(String paramString1, String paramString2)
  {
    AppMethodBeat.i(75783);
    TMLog.i("TMAssistantDownloadSDKService", "getDownloadTaskInfo");
    if (this.this$0.mServiceDownloadTaskManager != null)
    {
      paramString1 = this.this$0.mServiceDownloadTaskManager.getDownloadTaskInfo(paramString1, paramString2);
      AppMethodBeat.o(75783);
      return paramString1;
    }
    AppMethodBeat.o(75783);
    return null;
  }
  
  public int getServiceVersion()
  {
    return 1;
  }
  
  public boolean isAllDownloadFinished()
  {
    AppMethodBeat.i(75782);
    boolean bool = ApkDownloadManager.getInstance().isAllDownloadFinished().booleanValue();
    AppMethodBeat.o(75782);
    return bool;
  }
  
  public void pauseDownloadTask(String paramString1, String paramString2)
  {
    AppMethodBeat.i(75785);
    TMLog.i("TMAssistantDownloadSDKService", "pauseDownloadTask");
    try
    {
      if (this.this$0.mServiceDownloadTaskManager != null) {
        this.this$0.mServiceDownloadTaskManager.pauseDownload(paramString1, paramString2);
      }
      TMLog.i("TMAssistantDownloadSDKService", "pauseDownloadTask end");
      AppMethodBeat.o(75785);
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        ab.printErrStackTrace("TMAssistantDownloadSDKService", paramString1, "", new Object[0]);
      }
    }
  }
  
  public void registerDownloadTaskCallback(String paramString, ITMAssistantDownloadSDKServiceCallback paramITMAssistantDownloadSDKServiceCallback)
  {
    AppMethodBeat.i(75787);
    TMLog.i("TMAssistantDownloadSDKService", "registerDownloadTaskCallback,clientKey:".concat(String.valueOf(paramString)));
    if ((paramString != null) && (paramITMAssistantDownloadSDKServiceCallback != null))
    {
      this.this$0.mCallbacks.register(paramITMAssistantDownloadSDKServiceCallback);
      try
      {
        this.this$0.mCallbackHashMap.put(paramITMAssistantDownloadSDKServiceCallback, paramString);
        return;
      }
      finally
      {
        AppMethodBeat.o(75787);
      }
    }
    AppMethodBeat.o(75787);
  }
  
  public void setServiceSetingIsDownloadWifiOnly(boolean paramBoolean)
  {
    AppMethodBeat.i(75780);
    DownloadSetting.getInstance().setIsDownloadWifiOnly(paramBoolean);
    AppMethodBeat.o(75780);
  }
  
  public void setServiceSetingIsTaskAutoResume(boolean paramBoolean)
  {
    AppMethodBeat.i(75779);
    DownloadSetting.getInstance().setIsTaskAutoResume(paramBoolean);
    AppMethodBeat.o(75779);
  }
  
  public void setServiceSetingMaxTaskNum(int paramInt)
  {
    AppMethodBeat.i(75781);
    DownloadSetting.getInstance().setMaxTaskNum(paramInt);
    AppMethodBeat.o(75781);
  }
  
  public int startDownloadTask(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt, String paramString4, String paramString5, Map paramMap)
  {
    AppMethodBeat.i(75784);
    TMLog.i("TMAssistantDownloadSDKService", "startDownloadTask，clientkey:" + paramString1 + ",url:" + paramString2 + ",manager:" + this.this$0.mServiceDownloadTaskManager + ",fileName:" + paramString5);
    if (this.this$0.mServiceDownloadTaskManager != null)
    {
      DBManager.getInstance().saveClientInfo(paramString1, paramString2);
      paramInt = this.this$0.mServiceDownloadTaskManager.startDownload(paramString1, paramString2, paramString3, paramLong, paramInt, paramString4, paramString5, paramMap);
      AppMethodBeat.o(75784);
      return paramInt;
    }
    AppMethodBeat.o(75784);
    return 3;
  }
  
  public void unregisterDownloadTaskCallback(String paramString, ITMAssistantDownloadSDKServiceCallback paramITMAssistantDownloadSDKServiceCallback)
  {
    AppMethodBeat.i(75788);
    TMLog.i("TMAssistantDownloadSDKService", "unregisterDownloadTaskCallback,clientKey:".concat(String.valueOf(paramString)));
    if ((paramString != null) && (paramITMAssistantDownloadSDKServiceCallback != null))
    {
      this.this$0.mCallbacks.unregister(paramITMAssistantDownloadSDKServiceCallback);
      try
      {
        this.this$0.mCallbackHashMap.remove(paramITMAssistantDownloadSDKServiceCallback);
        return;
      }
      finally
      {
        AppMethodBeat.o(75788);
      }
    }
    AppMethodBeat.o(75788);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadservice.TMAssistantDownloadSDKService.TMAssistantDownloadSDKServiceImpl
 * JD-Core Version:    0.7.0.1
 */