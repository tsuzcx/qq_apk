package com.tencent.tmassistantsdk.openSDK;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
  protected CopyOnWriteArrayList<TMQQDownloaderOpenSDKParam> mTaskList;
  
  protected TMQQDownloaderOpenSDK_V2()
  {
    AppMethodBeat.i(102142);
    this.mTaskList = null;
    this.mTaskList = new CopyOnWriteArrayList();
    AppMethodBeat.o(102142);
  }
  
  public static String about()
  {
    return "TMQQDownloaderOpenSDK_2014_05_13_17_36_release_35169";
  }
  
  private void addToTaskList(TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(102155);
        TMQQDownloaderOpenSDKParam localTMQQDownloaderOpenSDKParam;
        if ((paramTMQQDownloaderOpenSDKParam != null) && (this.mTaskList != null))
        {
          Iterator localIterator = this.mTaskList.iterator();
          if (!localIterator.hasNext()) {
            break label155;
          }
          localTMQQDownloaderOpenSDKParam = (TMQQDownloaderOpenSDKParam)localIterator.next();
          if (localTMQQDownloaderOpenSDKParam.taskAppId == null) {
            continue;
          }
          if (!localTMQQDownloaderOpenSDKParam.taskAppId.equals(paramTMQQDownloaderOpenSDKParam.taskAppId)) {
            continue;
          }
          if (localTMQQDownloaderOpenSDKParam.taskPackageName == null) {
            break label160;
          }
          if (!localTMQQDownloaderOpenSDKParam.taskPackageName.equals(paramTMQQDownloaderOpenSDKParam.taskPackageName)) {
            continue;
          }
          break label160;
          if (i == 0) {
            this.mTaskList.add(paramTMQQDownloaderOpenSDKParam);
          }
        }
        AppMethodBeat.o(102155);
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
      label155:
      continue;
      label160:
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
      AppMethodBeat.i(102143);
      if (mInstance == null) {
        mInstance = new TMQQDownloaderOpenSDK_V2();
      }
      TMQQDownloaderOpenSDK_V2 localTMQQDownloaderOpenSDK_V2 = mInstance;
      AppMethodBeat.o(102143);
      return localTMQQDownloaderOpenSDK_V2;
    }
    finally {}
  }
  
  private void onProgressChanged(TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(102154);
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
    AppMethodBeat.o(102154);
  }
  
  public void OnDownloadTaskProgressChanged(TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(102157);
    if (paramTMQQDownloaderOpenSDKParam != null) {
      onProgressChanged(paramTMQQDownloaderOpenSDKParam, paramLong1, paramLong2);
    }
    AppMethodBeat.o(102157);
  }
  
  public void OnDownloadTaskStateChanged(TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(102156);
    if (paramTMQQDownloaderOpenSDKParam != null) {
      onStateChanged(paramTMQQDownloaderOpenSDKParam, paramInt1, paramInt2, paramString);
    }
    AppMethodBeat.o(102156);
  }
  
  public void OnQQDownloaderInvalid()
  {
    AppMethodBeat.i(102158);
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
    AppMethodBeat.o(102158);
  }
  
  public void OnServiceFree()
  {
    AppMethodBeat.i(102160);
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
    AppMethodBeat.o(102160);
  }
  
  public long addBatchUpdateOperationToDB(ArrayList<TMQQDownloaderOpenSDKParam> paramArrayList, boolean paramBoolean, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(102152);
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
      if (paramArrayList == null) {}
    }
    for (long l = buildAddDBData(paramArrayList);; l = -1L)
    {
      AppMethodBeat.o(102152);
      return l;
    }
  }
  
  public long addDownloadTaskFromAppDetail(TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(102161);
    addToTaskList(paramTMQQDownloaderOpenSDKParam);
    long l = super.buildAddDBData(paramTMQQDownloaderOpenSDKParam, paramBoolean1, paramBoolean2, paramTMQQDownloaderOpenSDKParam.actionFlag, null, 2);
    AppMethodBeat.o(102161);
    return l;
  }
  
  public long addDownloadTaskFromAuthorize(TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam, String paramString)
  {
    AppMethodBeat.i(102162);
    addToTaskList(paramTMQQDownloaderOpenSDKParam);
    long l = super.buildAddDBData(paramTMQQDownloaderOpenSDKParam, true, true, paramTMQQDownloaderOpenSDKParam.actionFlag, paramString, 3);
    AppMethodBeat.o(102162);
    return l;
  }
  
  public long addDownloadTaskFromTaskList(TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(102163);
    addToTaskList(paramTMQQDownloaderOpenSDKParam);
    long l = super.buildAddDBData(paramTMQQDownloaderOpenSDKParam, paramBoolean1, paramBoolean2, paramTMQQDownloaderOpenSDKParam.actionFlag, null, 1);
    AppMethodBeat.o(102163);
    return l;
  }
  
  public void destroyQQDownloaderOpenSDK()
  {
    AppMethodBeat.i(102144);
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
    AppMethodBeat.o(102144);
  }
  
  public ArrayList<TMAssistantDownloadTaskInfo> getBatchTaskState(ArrayList<TMQQDownloaderOpenSDKParam> paramArrayList, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(102151);
    if (this.mContext == null)
    {
      paramArrayList = new Exception("mContext shouldn't be null !");
      AppMethodBeat.o(102151);
      throw paramArrayList;
    }
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      paramArrayList = new Exception("ArrayList<TMQQDownloaderOpenSDKParam> appList cann't be null or empty!");
      AppMethodBeat.o(102151);
      throw paramArrayList;
    }
    int i = getQQDownloadApiLevel(this.mContext);
    if (i <= 1)
    {
      AppMethodBeat.o(102151);
      return null;
    }
    if (i < 4)
    {
      paramArrayList = TMQQDownloaderOpenSDKDataProcessor.getInstance(this.mContext).getDownloadTask((TMQQDownloaderOpenSDKParam)paramArrayList.get(0));
      if (paramArrayList != null)
      {
        paramString1 = new ArrayList();
        paramString1.add(paramArrayList);
        AppMethodBeat.o(102151);
        return paramString1;
      }
      AppMethodBeat.o(102151);
      return null;
    }
    paramArrayList = TMQQDownloaderOpenSDKDataProcessor.getInstance(this.mContext).getBatchTaskInfos(paramArrayList, paramString1, paramString2, paramString3);
    AppMethodBeat.o(102151);
    return paramArrayList;
  }
  
  public TMAssistantDownloadTaskInfo getDownloadTaskState(TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam)
  {
    AppMethodBeat.i(102153);
    if (this.mContext == null)
    {
      paramTMQQDownloaderOpenSDKParam = new Exception("Context shouldn't be null !");
      AppMethodBeat.o(102153);
      throw paramTMQQDownloaderOpenSDKParam;
    }
    if (paramTMQQDownloaderOpenSDKParam == null)
    {
      paramTMQQDownloaderOpenSDKParam = new Exception("TMQQDownloaderOpenSDKParam param cann't is null!");
      AppMethodBeat.o(102153);
      throw paramTMQQDownloaderOpenSDKParam;
    }
    paramTMQQDownloaderOpenSDKParam = TMQQDownloaderOpenSDKDataProcessor.getInstance(this.mContext).getDownloadTask(paramTMQQDownloaderOpenSDKParam);
    AppMethodBeat.o(102153);
    return paramTMQQDownloaderOpenSDKParam;
  }
  
  public void initQQDownloaderOpenSDK(Context paramContext)
  {
    AppMethodBeat.i(102164);
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
    AppMethodBeat.o(102164);
  }
  
  /* Error */
  public void onQQDownloaderInstalled(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 312
    //   5: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 12
    //   10: ldc_w 314
    //   13: invokestatic 106	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: aload_0
    //   17: getfield 34	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDK_V2:mTaskList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   20: ifnull +74 -> 94
    //   23: aload_0
    //   24: getfield 34	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDK_V2:mTaskList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   27: invokevirtual 51	java/util/concurrent/CopyOnWriteArrayList:iterator	()Ljava/util/Iterator;
    //   30: astore_1
    //   31: aload_1
    //   32: invokeinterface 57 1 0
    //   37: ifeq +57 -> 94
    //   40: aload_1
    //   41: invokeinterface 61 1 0
    //   46: checkcast 63	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam
    //   49: astore_2
    //   50: aload_2
    //   51: ifnull -20 -> 31
    //   54: aload_0
    //   55: aload_2
    //   56: invokevirtual 316	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDK_V2:getDownloadTaskState	(Lcom/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam;)Lcom/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadTaskInfo;
    //   59: pop
    //   60: aload_0
    //   61: getfield 34	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDK_V2:mTaskList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   64: aload_2
    //   65: invokevirtual 319	java/util/concurrent/CopyOnWriteArrayList:remove	(Ljava/lang/Object;)Z
    //   68: pop
    //   69: goto -38 -> 31
    //   72: astore_1
    //   73: aload_0
    //   74: monitorexit
    //   75: aload_1
    //   76: athrow
    //   77: astore_3
    //   78: ldc 12
    //   80: aload_3
    //   81: ldc_w 321
    //   84: iconst_0
    //   85: anewarray 323	java/lang/Object
    //   88: invokestatic 329	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   91: goto -31 -> 60
    //   94: ldc_w 312
    //   97: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   100: aload_0
    //   101: monitorexit
    //   102: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	this	TMQQDownloaderOpenSDK_V2
    //   0	103	1	paramContext	Context
    //   49	16	2	localTMQQDownloaderOpenSDKParam	TMQQDownloaderOpenSDKParam
    //   77	4	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	31	72	finally
    //   31	50	72	finally
    //   54	60	72	finally
    //   60	69	72	finally
    //   78	91	72	finally
    //   94	100	72	finally
    //   54	60	77	java/lang/Exception
  }
  
  public void releaseIPCConnected()
  {
    AppMethodBeat.i(102165);
    if (this.mContext != null) {
      TMQQDownloaderOpenSDKDataProcessor.getInstance(this.mContext).releaseIPCClient();
    }
    AppMethodBeat.o(102165);
  }
  
  public void startToAppDetail(Context paramContext, TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(102146);
    if (paramContext == null)
    {
      paramContext = new Exception("you must input an application or activity context!");
      AppMethodBeat.o(102146);
      throw paramContext;
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
        break label144;
      }
    }
    label144:
    for (paramInt = i;; paramInt = 4)
    {
      addToTaskList(paramTMQQDownloaderOpenSDKParam);
      TMQQDownloaderOpenSDKDataProcessor.getInstance(this.mContext).handleDownloadTask(paramTMQQDownloaderOpenSDKParam, paramInt, paramContext, paramTMQQDownloaderOpenSDKParam.actionFlag, null);
      AppMethodBeat.o(102146);
      return;
    }
  }
  
  public void startToAuthorized(Context paramContext, TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam, String paramString)
  {
    AppMethodBeat.i(102147);
    if (paramContext == null)
    {
      paramContext = new Exception("you must input an application or activity context!");
      AppMethodBeat.o(102147);
      throw paramContext;
    }
    if (paramTMQQDownloaderOpenSDKParam == null)
    {
      paramContext = new Exception("QQDownloaderParam param cann't be null!");
      AppMethodBeat.o(102147);
      throw paramContext;
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
    AppMethodBeat.o(102147);
  }
  
  public void startToAuthorized(Context paramContext, String paramString)
  {
    AppMethodBeat.i(102148);
    paramContext = super.formatEncryptUrl(paramString);
    if ((!TextUtils.isEmpty(paramString)) && (this.mContext != null)) {
      TMQQDownloaderOpenSDKDataProcessor.getInstance(this.mContext).handleUriAction(paramContext);
    }
    AppMethodBeat.o(102148);
  }
  
  public int startToBatchUpdateOperation(Context paramContext, ArrayList<TMQQDownloaderOpenSDKParam> paramArrayList, boolean paramBoolean, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    boolean bool = true;
    AppMethodBeat.i(102150);
    if (paramContext == null)
    {
      paramContext = new Exception("you must input an application or activity context!");
      AppMethodBeat.o(102150);
      throw paramContext;
    }
    int i = getQQDownloadApiLevel(paramContext);
    if (i <= 0)
    {
      AppMethodBeat.o(102150);
      return 1;
    }
    if (i < 4)
    {
      AppMethodBeat.o(102150);
      return 2;
    }
    paramBoolean = bool;
    if (paramArrayList != null) {
      if (paramArrayList.size() != 0) {
        break label137;
      }
    }
    label137:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      paramInt = getBatchRequestType(paramBoolean, paramInt);
      if (!TMQQDownloaderOpenSDKDataProcessor.getInstance(this.mContext).handleBatchRequestAction(paramInt, paramArrayList, paramString1, paramString2, paramString3)) {
        TMLog.w("QQDownloaderOpenSDK", "handleBatchRequestAction return false with batchRequestType=".concat(String.valueOf(paramInt)));
      }
      AppMethodBeat.o(102150);
      return 0;
    }
  }
  
  public void startToDownloadTaskList(Context paramContext, TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(102145);
    if (paramContext == null)
    {
      paramContext = new Exception("you must input an application or activity context!");
      AppMethodBeat.o(102145);
      throw paramContext;
    }
    if (paramTMQQDownloaderOpenSDKParam == null)
    {
      AppMethodBeat.o(102145);
      return;
    }
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
    if (paramTMQQDownloaderOpenSDKParam != null)
    {
      paramContext = super.formatOplist(paramBoolean1, paramBoolean2);
      if (1 != paramInt) {
        break label153;
      }
    }
    label153:
    for (paramInt = 2;; paramInt = 5)
    {
      addToTaskList(paramTMQQDownloaderOpenSDKParam);
      TMQQDownloaderOpenSDKDataProcessor.getInstance(this.mContext).handleDownloadTask(paramTMQQDownloaderOpenSDKParam, paramInt, paramContext, paramTMQQDownloaderOpenSDKParam.actionFlag, null);
      AppMethodBeat.o(102145);
      return;
    }
  }
  
  public void startToWebView(Context paramContext, String paramString)
  {
    AppMethodBeat.i(102149);
    if (paramContext == null)
    {
      paramContext = new Exception("you must input an application or activity context!");
      AppMethodBeat.o(102149);
      throw paramContext;
    }
    if (TextUtils.isEmpty(paramString))
    {
      paramContext = new Exception("param url shouldn't be null!");
      AppMethodBeat.o(102149);
      throw paramContext;
    }
    paramContext = new HashMap();
    paramContext.put("url", paramString);
    paramContext = super.formatIntentUriPath(5, paramContext);
    TMLog.i("QQDownloaderOpenSDK", "startToWebView finalPath:".concat(String.valueOf(paramContext)));
    if ((!TextUtils.isEmpty(paramString)) && (this.mContext != null)) {
      TMQQDownloaderOpenSDKDataProcessor.getInstance(this.mContext).handleUriAction(paramContext);
    }
    AppMethodBeat.o(102149);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDK_V2
 * JD-Core Version:    0.7.0.1
 */