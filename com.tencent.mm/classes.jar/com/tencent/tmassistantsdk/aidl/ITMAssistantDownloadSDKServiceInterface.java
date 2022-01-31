package com.tencent.tmassistantsdk.aidl;

import android.os.IInterface;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;
import java.util.Map;

public abstract interface ITMAssistantDownloadSDKServiceInterface
  extends IInterface
{
  public abstract void cancelDownloadTask(String paramString1, String paramString2);
  
  public abstract TMAssistantDownloadTaskInfo getDownloadTaskInfo(String paramString1, String paramString2);
  
  public abstract int getServiceVersion();
  
  public abstract boolean isAllDownloadFinished();
  
  public abstract void pauseDownloadTask(String paramString1, String paramString2);
  
  public abstract void registerDownloadTaskCallback(String paramString, ITMAssistantDownloadSDKServiceCallback paramITMAssistantDownloadSDKServiceCallback);
  
  public abstract void setServiceSetingIsDownloadWifiOnly(boolean paramBoolean);
  
  public abstract void setServiceSetingIsTaskAutoResume(boolean paramBoolean);
  
  public abstract void setServiceSetingMaxTaskNum(int paramInt);
  
  public abstract int startDownloadTask(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt, String paramString4, String paramString5, Map paramMap);
  
  public abstract void unregisterDownloadTaskCallback(String paramString, ITMAssistantDownloadSDKServiceCallback paramITMAssistantDownloadSDKServiceCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface
 * JD-Core Version:    0.7.0.1
 */