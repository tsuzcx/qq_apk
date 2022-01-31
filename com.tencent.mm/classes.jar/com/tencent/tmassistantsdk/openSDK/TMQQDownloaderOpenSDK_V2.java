package com.tencent.tmassistantsdk.openSDK;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantsdk.downloadservice.NetworkMonitorReceiver;
import com.tencent.tmassistantsdk.logreport.DownloadReportManager;
import com.tencent.tmassistantsdk.logreport.GetSettingEngine;
import com.tencent.tmassistantsdk.logreport.LogReportManager;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.QQDownloaderInstalled;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.QQDownloaderInstalled.IQQDownloaderInstalled;
import com.tencent.tmassistantsdk.protocol.jce.DownloadChunkLogInfo;
import com.tencent.tmassistantsdk.util.GlobalUtil;
import com.tencent.tmassistantsdk.util.TMLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class TMQQDownloaderOpenSDK_V2
  extends BaseQQDownloaderOpenSDK
  implements ITMQQDownloaderOpenSDKListener, QQDownloaderInstalled.IQQDownloaderInstalled
{
  protected static final String TAG = "QQDownloaderOpenSDK";
  protected static TMQQDownloaderOpenSDK_V2 mInstance = null;
  protected CopyOnWriteArrayList<TMQQDownloaderOpenSDKParam> mTaskList = null;
  
  public static String about()
  {
    return "TMQQDownloaderOpenSDK_2014_05_13_17_36_release_35169";
  }
  
  private void addToTaskList(TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam)
  {
    if (paramTMQQDownloaderOpenSDKParam != null) {}
    for (;;)
    {
      try
      {
        TMQQDownloaderOpenSDKParam localTMQQDownloaderOpenSDKParam;
        if (this.mTaskList != null)
        {
          Iterator localIterator = this.mTaskList.iterator();
          if (!localIterator.hasNext()) {
            break label145;
          }
          localTMQQDownloaderOpenSDKParam = (TMQQDownloaderOpenSDKParam)localIterator.next();
          if (localTMQQDownloaderOpenSDKParam.taskAppId == null) {
            continue;
          }
          if (!localTMQQDownloaderOpenSDKParam.taskAppId.equals(paramTMQQDownloaderOpenSDKParam.taskAppId)) {
            continue;
          }
          if (localTMQQDownloaderOpenSDKParam.taskPackageName == null) {
            break label150;
          }
          if (!localTMQQDownloaderOpenSDKParam.taskPackageName.equals(paramTMQQDownloaderOpenSDKParam.taskPackageName)) {
            continue;
          }
          break label150;
          if (i == 0) {
            this.mTaskList.add(paramTMQQDownloaderOpenSDKParam);
          }
        }
        return;
        if (localTMQQDownloaderOpenSDKParam.taskPackageName == null) {
          continue;
        }
        boolean bool = localTMQQDownloaderOpenSDKParam.taskPackageName.equals(paramTMQQDownloaderOpenSDKParam.taskPackageName);
        if (bool != true) {
          continue;
        }
        i = 1;
        continue;
        i = 0;
      }
      finally {}
      label145:
      continue;
      label150:
      int i = 1;
    }
  }
  
  private int getBatchRequestType(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      switch (paramInt)
      {
      case 0: 
      default: 
        return 2;
      case 1: 
        return 1;
      case 2: 
        return 6;
      }
      return 5;
    }
    switch (paramInt)
    {
    default: 
      return 2;
    case 0: 
    case 1: 
      return 4;
    case 2: 
      return 8;
    }
    return 7;
  }
  
  public static TMQQDownloaderOpenSDK_V2 getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new TMQQDownloaderOpenSDK_V2();
      }
      TMQQDownloaderOpenSDK_V2 localTMQQDownloaderOpenSDK_V2 = mInstance;
      return localTMQQDownloaderOpenSDK_V2;
    }
    finally {}
  }
  
  private void onProgressChanged(TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam, long paramLong1, long paramLong2)
  {
    Iterator localIterator = this.mWeakListenerArrayList.iterator();
    while (localIterator.hasNext())
    {
      ITMQQDownloaderOpenSDKListener localITMQQDownloaderOpenSDKListener = (ITMQQDownloaderOpenSDKListener)((WeakReference)localIterator.next()).get();
      if (localITMQQDownloaderOpenSDKListener == null) {
        TMLog.i("QQDownloaderOpenSDK", "onDownloadStateChanged listener = null");
      } else {
        localITMQQDownloaderOpenSDKListener.OnDownloadTaskProgressChanged(paramTMQQDownloaderOpenSDKParam, paramLong1, paramLong2);
      }
    }
  }
  
  public void OnDownloadTaskProgressChanged(TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam, long paramLong1, long paramLong2)
  {
    if (paramTMQQDownloaderOpenSDKParam != null) {
      onProgressChanged(paramTMQQDownloaderOpenSDKParam, paramLong1, paramLong2);
    }
  }
  
  public void OnDownloadTaskStateChanged(TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam, int paramInt1, int paramInt2, String paramString)
  {
    if (paramTMQQDownloaderOpenSDKParam != null) {
      onStateChanged(paramTMQQDownloaderOpenSDKParam, paramInt1, paramInt2, paramString);
    }
  }
  
  public void OnQQDownloaderInvalid()
  {
    Iterator localIterator = this.mWeakListenerArrayList.iterator();
    while (localIterator.hasNext())
    {
      ITMQQDownloaderOpenSDKListener localITMQQDownloaderOpenSDKListener = (ITMQQDownloaderOpenSDKListener)((WeakReference)localIterator.next()).get();
      if (localITMQQDownloaderOpenSDKListener == null) {
        TMLog.i("QQDownloaderOpenSDK", "OnQQDownloaderInvalid listener = null");
      } else {
        localITMQQDownloaderOpenSDKListener.OnQQDownloaderInvalid();
      }
    }
  }
  
  public void OnServiceFree()
  {
    Iterator localIterator = this.mWeakListenerArrayList.iterator();
    while (localIterator.hasNext())
    {
      ITMQQDownloaderOpenSDKListener localITMQQDownloaderOpenSDKListener = (ITMQQDownloaderOpenSDKListener)((WeakReference)localIterator.next()).get();
      if (localITMQQDownloaderOpenSDKListener == null) {
        TMLog.i("QQDownloaderOpenSDK", "OnQQDownloaderInvalid listener = null");
      } else {
        localITMQQDownloaderOpenSDKListener.OnServiceFree();
      }
    }
  }
  
  public long addBatchUpdateOperationToDB(ArrayList<TMQQDownloaderOpenSDKParam> paramArrayList, boolean paramBoolean, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramInt = getBatchRequestType(paramBoolean, paramInt);
      if ((paramInt == 3) || (paramBoolean)) {
        break;
      }
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        TMQQDownloaderOpenSDKParam localTMQQDownloaderOpenSDKParam = (TMQQDownloaderOpenSDKParam)localIterator.next();
        if (localTMQQDownloaderOpenSDKParam != null) {
          addToTaskList(localTMQQDownloaderOpenSDKParam);
        }
      }
    }
    paramArrayList = TMQQDownloaderOpenSDKDataProcessor.buildBatchActionRequest(paramInt, paramArrayList, paramString1, paramString2, paramString3);
    if (paramArrayList != null)
    {
      paramArrayList = TMQQDownloaderOpenSDKDataProcessor.buildSendData(paramArrayList);
      if (paramArrayList != null) {
        return buildAddDBData(paramArrayList);
      }
    }
    return -1L;
  }
  
  public long addDownloadTaskFromAppDetail(TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam, boolean paramBoolean1, boolean paramBoolean2)
  {
    addToTaskList(paramTMQQDownloaderOpenSDKParam);
    return super.buildAddDBData(paramTMQQDownloaderOpenSDKParam, paramBoolean1, paramBoolean2, paramTMQQDownloaderOpenSDKParam.actionFlag, null, 2);
  }
  
  public long addDownloadTaskFromAuthorize(TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam, String paramString)
  {
    addToTaskList(paramTMQQDownloaderOpenSDKParam);
    return super.buildAddDBData(paramTMQQDownloaderOpenSDKParam, true, true, paramTMQQDownloaderOpenSDKParam.actionFlag, paramString, 3);
  }
  
  public long addDownloadTaskFromTaskList(TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam, boolean paramBoolean1, boolean paramBoolean2)
  {
    addToTaskList(paramTMQQDownloaderOpenSDKParam);
    return super.buildAddDBData(paramTMQQDownloaderOpenSDKParam, paramBoolean1, paramBoolean2, paramTMQQDownloaderOpenSDKParam.actionFlag, null, 1);
  }
  
  public void destroyQQDownloaderOpenSDK()
  {
    NetworkMonitorReceiver.getInstance().unregisterReceiver();
    GetSettingEngine.getInstance().cancleRequest();
    LogReportManager.getInstance().cancleReport();
    LogReportManager.getInstance().destory();
    if (this.mContext != null)
    {
      TMQQDownloaderOpenSDKDataProcessor.getInstance(this.mContext).unregisterIQQDownloaderOpenSDKListener();
      QQDownloaderInstalled.getInstance().unregisteListener();
      QQDownloaderInstalled.getInstance().unRegisteReceiver(this.mContext);
    }
    GlobalUtil.getInstance().destroy();
    this.mContext = null;
  }
  
  public ArrayList<TMAssistantDownloadTaskInfo> getBatchTaskState(ArrayList<TMQQDownloaderOpenSDKParam> paramArrayList, String paramString1, String paramString2, String paramString3)
  {
    if (this.mContext == null) {
      throw new Exception("mContext shouldn't be null !");
    }
    if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
      throw new Exception("ArrayList<TMQQDownloaderOpenSDKParam> appList cann't be null or empty!");
    }
    int i = getQQDownloadApiLevel(this.mContext);
    if (i <= 1) {
      return null;
    }
    if (i < 4)
    {
      paramArrayList = TMQQDownloaderOpenSDKDataProcessor.getInstance(this.mContext).getDownloadTask((TMQQDownloaderOpenSDKParam)paramArrayList.get(0));
      if (paramArrayList != null)
      {
        paramString1 = new ArrayList();
        paramString1.add(paramArrayList);
        return paramString1;
      }
      return null;
    }
    return TMQQDownloaderOpenSDKDataProcessor.getInstance(this.mContext).getBatchTaskInfos(paramArrayList, paramString1, paramString2, paramString3);
  }
  
  public TMAssistantDownloadTaskInfo getDownloadTaskState(TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam)
  {
    if (this.mContext == null) {
      throw new Exception("Context shouldn't be null !");
    }
    if (paramTMQQDownloaderOpenSDKParam == null) {
      throw new Exception("TMQQDownloaderOpenSDKParam param cann't is null!");
    }
    return TMQQDownloaderOpenSDKDataProcessor.getInstance(this.mContext).getDownloadTask(paramTMQQDownloaderOpenSDKParam);
  }
  
  public void initQQDownloaderOpenSDK(Context paramContext)
  {
    this.mContext = paramContext;
    this.hostPackageName = paramContext.getPackageName();
    this.hostVersionCode = GlobalUtil.getAppVersionCode(this.mContext);
    GlobalUtil.getInstance().setContext(this.mContext);
    this.sdkAPILevel = 2;
    if (this.mContext != null)
    {
      TMQQDownloaderOpenSDKDataProcessor.getInstance(this.mContext).registerIQQDownloaderOpenSDKListener(this);
      QQDownloaderInstalled.getInstance().registeReceiver(this.mContext);
      QQDownloaderInstalled.getInstance().registeListener(this);
    }
    NetworkMonitorReceiver.getInstance().registerReceiver();
    GetSettingEngine.getInstance().sendRequest();
    LogReportManager.getInstance().reportLog();
  }
  
  /* Error */
  public void onQQDownloaderInstalled(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 12
    //   4: ldc_w 289
    //   7: invokestatic 94	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   10: aload_0
    //   11: getfield 27	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDK_V2:mTaskList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   14: ifnull +74 -> 88
    //   17: aload_0
    //   18: getfield 27	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDK_V2:mTaskList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   21: invokevirtual 40	java/util/concurrent/CopyOnWriteArrayList:iterator	()Ljava/util/Iterator;
    //   24: astore_1
    //   25: aload_1
    //   26: invokeinterface 46 1 0
    //   31: ifeq +57 -> 88
    //   34: aload_1
    //   35: invokeinterface 50 1 0
    //   40: checkcast 52	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam
    //   43: astore_2
    //   44: aload_2
    //   45: ifnull -20 -> 25
    //   48: aload_0
    //   49: aload_2
    //   50: invokevirtual 291	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDK_V2:getDownloadTaskState	(Lcom/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam;)Lcom/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadTaskInfo;
    //   53: pop
    //   54: aload_0
    //   55: getfield 27	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDK_V2:mTaskList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   58: aload_2
    //   59: invokevirtual 294	java/util/concurrent/CopyOnWriteArrayList:remove	(Ljava/lang/Object;)Z
    //   62: pop
    //   63: goto -38 -> 25
    //   66: astore_1
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_1
    //   70: athrow
    //   71: astore_3
    //   72: ldc 12
    //   74: aload_3
    //   75: ldc_w 296
    //   78: iconst_0
    //   79: anewarray 298	java/lang/Object
    //   82: invokestatic 304	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   85: goto -31 -> 54
    //   88: aload_0
    //   89: monitorexit
    //   90: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	TMQQDownloaderOpenSDK_V2
    //   0	91	1	paramContext	Context
    //   43	16	2	localTMQQDownloaderOpenSDKParam	TMQQDownloaderOpenSDKParam
    //   71	4	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	25	66	finally
    //   25	44	66	finally
    //   48	54	66	finally
    //   54	63	66	finally
    //   72	85	66	finally
    //   48	54	71	java/lang/Exception
  }
  
  public void releaseIPCConnected()
  {
    if (this.mContext != null) {
      TMQQDownloaderOpenSDKDataProcessor.getInstance(this.mContext).releaseIPCClient();
    }
  }
  
  public void startToAppDetail(Context paramContext, TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    int i = 1;
    if (paramContext == null) {
      throw new Exception("you must input an application or activity context!");
    }
    paramContext = UUID.randomUUID().toString();
    if (paramBoolean1)
    {
      DownloadChunkLogInfo localDownloadChunkLogInfo = DownloadReportManager.getInstance().createNewChunkLogInfo((byte)1);
      localDownloadChunkLogInfo.via = paramTMQQDownloaderOpenSDKParam.via;
      localDownloadChunkLogInfo.UUID = paramContext;
      localDownloadChunkLogInfo.appId = paramTMQQDownloaderOpenSDKParam.taskAppId;
      localDownloadChunkLogInfo.resultState = 1;
      DownloadReportManager.getInstance().addLogData(localDownloadChunkLogInfo);
    }
    if (paramTMQQDownloaderOpenSDKParam != null)
    {
      paramContext = super.formatOplist(paramBoolean1, paramBoolean2);
      if (1 != paramInt) {
        break label124;
      }
    }
    label124:
    for (paramInt = i;; paramInt = 4)
    {
      addToTaskList(paramTMQQDownloaderOpenSDKParam);
      TMQQDownloaderOpenSDKDataProcessor.getInstance(this.mContext).handleDownloadTask(paramTMQQDownloaderOpenSDKParam, paramInt, paramContext, paramTMQQDownloaderOpenSDKParam.actionFlag, null);
      return;
    }
  }
  
  public void startToAuthorized(Context paramContext, TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam, String paramString)
  {
    if (paramContext == null) {
      throw new Exception("you must input an application or activity context!");
    }
    if (paramTMQQDownloaderOpenSDKParam == null) {
      throw new Exception("QQDownloaderParam param cann't be null!");
    }
    paramContext = UUID.randomUUID().toString();
    DownloadChunkLogInfo localDownloadChunkLogInfo = DownloadReportManager.getInstance().createNewChunkLogInfo((byte)1);
    localDownloadChunkLogInfo.via = paramTMQQDownloaderOpenSDKParam.via;
    localDownloadChunkLogInfo.UUID = paramContext;
    localDownloadChunkLogInfo.appId = paramTMQQDownloaderOpenSDKParam.taskAppId;
    localDownloadChunkLogInfo.resultState = 1;
    DownloadReportManager.getInstance().addLogData(localDownloadChunkLogInfo);
    if (paramTMQQDownloaderOpenSDKParam != null)
    {
      addToTaskList(paramTMQQDownloaderOpenSDKParam);
      paramContext = super.formatOplist(true, true);
      TMQQDownloaderOpenSDKDataProcessor.getInstance(this.mContext).handleDownloadTask(paramTMQQDownloaderOpenSDKParam, 3, paramContext, paramTMQQDownloaderOpenSDKParam.actionFlag, paramString);
    }
  }
  
  public void startToAuthorized(Context paramContext, String paramString)
  {
    paramContext = super.formatEncryptUrl(paramString);
    if ((!TextUtils.isEmpty(paramString)) && (this.mContext != null)) {
      TMQQDownloaderOpenSDKDataProcessor.getInstance(this.mContext).handleUriAction(paramContext);
    }
  }
  
  public int startToBatchUpdateOperation(Context paramContext, ArrayList<TMQQDownloaderOpenSDKParam> paramArrayList, boolean paramBoolean, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    boolean bool = true;
    if (paramContext == null) {
      throw new Exception("you must input an application or activity context!");
    }
    int i = getQQDownloadApiLevel(paramContext);
    if (i <= 0) {
      return 1;
    }
    if (i < 4) {
      return 2;
    }
    paramBoolean = bool;
    if (paramArrayList != null) {
      if (paramArrayList.size() != 0) {
        break label112;
      }
    }
    label112:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      paramInt = getBatchRequestType(paramBoolean, paramInt);
      if (!TMQQDownloaderOpenSDKDataProcessor.getInstance(this.mContext).handleBatchRequestAction(paramInt, paramArrayList, paramString1, paramString2, paramString3)) {
        TMLog.w("QQDownloaderOpenSDK", "handleBatchRequestAction return false with batchRequestType=" + paramInt);
      }
      return 0;
    }
  }
  
  public void startToDownloadTaskList(Context paramContext, TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (paramContext == null) {
      throw new Exception("you must input an application or activity context!");
    }
    if (paramTMQQDownloaderOpenSDKParam == null) {}
    do
    {
      return;
      paramContext = UUID.randomUUID().toString();
      if (paramBoolean1)
      {
        DownloadChunkLogInfo localDownloadChunkLogInfo = DownloadReportManager.getInstance().createNewChunkLogInfo((byte)1);
        localDownloadChunkLogInfo.UUID = paramContext;
        localDownloadChunkLogInfo.requestUrl = "";
        localDownloadChunkLogInfo.via = paramTMQQDownloaderOpenSDKParam.via;
        localDownloadChunkLogInfo.appId = paramTMQQDownloaderOpenSDKParam.taskAppId;
        DownloadReportManager.getInstance().addLogData(localDownloadChunkLogInfo);
      }
    } while (paramTMQQDownloaderOpenSDKParam == null);
    paramContext = super.formatOplist(paramBoolean1, paramBoolean2);
    if (1 == paramInt) {}
    for (paramInt = 2;; paramInt = 5)
    {
      addToTaskList(paramTMQQDownloaderOpenSDKParam);
      TMQQDownloaderOpenSDKDataProcessor.getInstance(this.mContext).handleDownloadTask(paramTMQQDownloaderOpenSDKParam, paramInt, paramContext, paramTMQQDownloaderOpenSDKParam.actionFlag, null);
      return;
    }
  }
  
  public void startToWebView(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      throw new Exception("you must input an application or activity context!");
    }
    if (TextUtils.isEmpty(paramString)) {
      throw new Exception("param url shouldn't be null!");
    }
    paramContext = new HashMap();
    paramContext.put("url", paramString);
    paramContext = super.formatIntentUriPath(5, paramContext);
    TMLog.i("QQDownloaderOpenSDK", "startToWebView finalPath:" + paramContext);
    if ((!TextUtils.isEmpty(paramString)) && (this.mContext != null)) {
      TMQQDownloaderOpenSDKDataProcessor.getInstance(this.mContext).handleUriAction(paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDK_V2
 * JD-Core Version:    0.7.0.1
 */