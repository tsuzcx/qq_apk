package com.tencent.tmassistantsdk.openSDK;

import android.content.Context;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.tmassistantsdk.downloadclient.IAssistantOnActionListener;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadOpenSDKClient;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKManager;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantsdk.openSDK.param.IPCPackageTools;
import com.tencent.tmassistantsdk.openSDK.param.jce.BatchDownloadActionRequest;
import com.tencent.tmassistantsdk.openSDK.param.jce.BatchDownloadActionResponse;
import com.tencent.tmassistantsdk.openSDK.param.jce.GetDownloadProgressResponse;
import com.tencent.tmassistantsdk.openSDK.param.jce.GetDownloadStateResponse;
import com.tencent.tmassistantsdk.openSDK.param.jce.IPCBaseParam;
import com.tencent.tmassistantsdk.openSDK.param.jce.IPCDownloadParam;
import com.tencent.tmassistantsdk.openSDK.param.jce.IPCHead;
import com.tencent.tmassistantsdk.openSDK.param.jce.IPCQueryDownloadInfo;
import com.tencent.tmassistantsdk.openSDK.param.jce.IPCResponse;
import com.tencent.tmassistantsdk.openSDK.param.jce.OperateDownloadTaskRequest;
import com.tencent.tmassistantsdk.openSDK.param.jce.QueryDownloadTaskRequest;
import com.tencent.tmassistantsdk.openSDK.param.jce.QueryDownloadTaskResponse;
import com.tencent.tmassistantsdk.openSDK.param.jce.URIActionRequest;
import com.tencent.tmassistantsdk.util.GlobalUtil;
import com.tencent.tmassistantsdk.util.TMLog;
import java.util.ArrayList;
import java.util.UUID;

public class TMQQDownloaderOpenSDKDataProcessor
  implements IAssistantOnActionListener
{
  protected static final String TAG = "QQDownloaderOpenSDKDataProcessor";
  protected static TMQQDownloaderOpenSDKDataProcessor mOpenSDKDataProcessor = null;
  protected ITMQQDownloaderOpenSDKListener callback = null;
  String clientKey = UUID.randomUUID().toString();
  protected TMAssistantDownloadOpenSDKClient openSDKClient = null;
  
  public TMQQDownloaderOpenSDKDataProcessor() {}
  
  private TMQQDownloaderOpenSDKDataProcessor(Context paramContext)
  {
    if (paramContext != null) {
      getOpenSDKClient(paramContext);
    }
  }
  
  private static IPCBaseParam QQParam2BasePram(TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam)
  {
    if (paramTMQQDownloaderOpenSDKParam == null) {
      return null;
    }
    IPCBaseParam localIPCBaseParam = new IPCBaseParam();
    localIPCBaseParam.hostAppId = paramTMQQDownloaderOpenSDKParam.SNGAppId;
    localIPCBaseParam.taskAppId = paramTMQQDownloaderOpenSDKParam.taskAppId;
    localIPCBaseParam.taskPackageName = paramTMQQDownloaderOpenSDKParam.taskPackageName;
    localIPCBaseParam.taskVersion = String.valueOf(paramTMQQDownloaderOpenSDKParam.taskVersion);
    localIPCBaseParam.uin = paramTMQQDownloaderOpenSDKParam.uin;
    localIPCBaseParam.uinType = paramTMQQDownloaderOpenSDKParam.uinType;
    localIPCBaseParam.via = paramTMQQDownloaderOpenSDKParam.via;
    localIPCBaseParam.channelId = paramTMQQDownloaderOpenSDKParam.channelId;
    return localIPCBaseParam;
  }
  
  private TMQQDownloaderOpenSDKParam baseParam2QQParam(IPCBaseParam paramIPCBaseParam)
  {
    if (paramIPCBaseParam == null) {
      return null;
    }
    TMQQDownloaderOpenSDKParam localTMQQDownloaderOpenSDKParam = new TMQQDownloaderOpenSDKParam();
    localTMQQDownloaderOpenSDKParam.SNGAppId = paramIPCBaseParam.hostAppId;
    localTMQQDownloaderOpenSDKParam.taskAppId = paramIPCBaseParam.taskAppId;
    localTMQQDownloaderOpenSDKParam.taskPackageName = paramIPCBaseParam.taskPackageName;
    try
    {
      localTMQQDownloaderOpenSDKParam.taskVersion = Integer.valueOf(paramIPCBaseParam.taskVersion).intValue();
      localTMQQDownloaderOpenSDKParam.uin = paramIPCBaseParam.uin;
      localTMQQDownloaderOpenSDKParam.uinType = paramIPCBaseParam.uinType;
      localTMQQDownloaderOpenSDKParam.via = paramIPCBaseParam.via;
      localTMQQDownloaderOpenSDKParam.channelId = paramIPCBaseParam.channelId;
      return localTMQQDownloaderOpenSDKParam;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        TMLog.i("QQDownloaderOpenSDKDataProcessor", "baseParam2QQParam Integer.valueOf(baseParam.taskVersion) NumberFormatException occur");
      }
    }
  }
  
  protected static BatchDownloadActionRequest buildBatchActionRequest(int paramInt, ArrayList<TMQQDownloaderOpenSDKParam> paramArrayList, String paramString1, String paramString2, String paramString3)
  {
    BatchDownloadActionRequest localBatchDownloadActionRequest = new BatchDownloadActionRequest();
    localBatchDownloadActionRequest.batchRequestType = paramInt;
    if (paramString1 != null) {
      localBatchDownloadActionRequest.via = paramString1;
    }
    if (paramString2 != null) {
      localBatchDownloadActionRequest.uin = paramString2;
    }
    if (paramString3 != null) {
      localBatchDownloadActionRequest.uinType = paramString3;
    }
    localBatchDownloadActionRequest.batchData = new ArrayList();
    paramString2 = "appList {";
    if (paramArrayList != null)
    {
      paramString1 = "appList {" + "appList.size=" + paramArrayList.size() + "\n";
      paramInt = 0;
      for (;;)
      {
        paramString2 = paramString1;
        if (paramInt >= paramArrayList.size()) {
          break;
        }
        paramString2 = QQParam2BasePram((TMQQDownloaderOpenSDKParam)paramArrayList.get(paramInt));
        paramString3 = new IPCDownloadParam();
        paramString3.baseParam = paramString2;
        localBatchDownloadActionRequest.batchData.add(paramString3);
        paramString1 = paramString1 + "element:" + paramInt + "IPCDownloadParam {IPCBaseParam {hostAppId:" + paramString3.baseParam.hostAppId + "|taskAppId:" + paramString3.baseParam.taskAppId + "|taskPackageName:" + paramString3.baseParam.taskPackageName + "|taskVersion:" + paramString3.baseParam.taskVersion + "}|actionFlag:" + paramString3.actionFlag + "|verifyType:" + paramString3.verifyType + "}\n";
        paramInt += 1;
      }
    }
    TMLog.i("QQDownloaderOpenSDKDataProcessor", paramString2 + "}");
    return localBatchDownloadActionRequest;
  }
  
  protected static byte[] buildSendData(JceStruct paramJceStruct)
  {
    paramJceStruct = IPCPackageTools.buildIpcRequest(paramJceStruct);
    if (paramJceStruct != null)
    {
      paramJceStruct = IPCPackageTools.buildPostData(paramJceStruct);
      if ((paramJceStruct != null) && (paramJceStruct.length > 0)) {
        return paramJceStruct;
      }
      TMLog.i("QQDownloaderOpenSDKDataProcessor", "handleUriAction sendData = null");
      return null;
    }
    TMLog.i("QQDownloaderOpenSDKDataProcessor", "handleUriAction IPCRequest = null");
    return null;
  }
  
  public static TMQQDownloaderOpenSDKDataProcessor getInstance(Context paramContext)
  {
    try
    {
      if (mOpenSDKDataProcessor == null) {
        mOpenSDKDataProcessor = new TMQQDownloaderOpenSDKDataProcessor(paramContext);
      }
      paramContext = mOpenSDKDataProcessor;
      return paramContext;
    }
    finally {}
  }
  
  public ArrayList<TMAssistantDownloadTaskInfo> getBatchTaskInfos(ArrayList<TMQQDownloaderOpenSDKParam> paramArrayList, String paramString1, String paramString2, String paramString3)
  {
    if (paramArrayList == null) {
      return null;
    }
    TMLog.i("QQDownloaderOpenSDKDataProcessor", "getBatchTaskInfos appList.size:" + paramArrayList.size());
    paramString1 = buildSendData(buildBatchActionRequest(3, paramArrayList, paramString1, paramString2, paramString3));
    paramArrayList = null;
    if ((paramString1 != null) && (paramString1.length > 0)) {}
    for (;;)
    {
      try
      {
        getOpenSDKClient(GlobalUtil.getInstance().getContext());
        if (this.openSDKClient != null) {
          paramArrayList = this.openSDKClient.sendSyncData(paramString1);
        }
        paramArrayList = IPCPackageTools.unpackPackage(paramArrayList);
        if (paramArrayList == null) {
          break label329;
        }
        paramString2 = (BatchDownloadActionResponse)IPCPackageTools.unpackBodyStruct(paramArrayList);
        if (paramString2 == null) {
          break label319;
        }
        paramArrayList = "getBatchTaskInfos BatchDownloadActionResponse batchRequestType:" + paramString2.batchRequestType;
        if (paramString2.batchData == null) {
          break label293;
        }
        paramString1 = paramArrayList + "response.batchData.size:" + paramString2.batchData.size();
        paramArrayList = new ArrayList();
        int i = 0;
        if (i >= paramString2.batchData.size()) {
          break;
        }
        paramString3 = (IPCQueryDownloadInfo)paramString2.batchData.get(i);
        int j = GlobalUtil.assistantState2SDKState(paramString3.state);
        if (paramString3 != null) {
          paramArrayList.add(new TMAssistantDownloadTaskInfo(paramString3.url, paramString3.savePath, j, paramString3.receivedLen, paramString3.totalLen, "application/vnd.android.package-archive"));
        }
        i += 1;
        continue;
        TMLog.i("QQDownloaderOpenSDKDataProcessor", "getBatchTaskInfos sendData = null or length = 0");
      }
      catch (Throwable paramArrayList)
      {
        y.printErrStackTrace("QQDownloaderOpenSDKDataProcessor", paramArrayList, "", new Object[0]);
        return null;
      }
    }
    for (;;)
    {
      TMLog.i("QQDownloaderOpenSDKDataProcessor", paramString1);
      return paramArrayList;
      label293:
      paramString1 = paramArrayList + "response.batchData = null";
      paramArrayList = null;
    }
    label319:
    TMLog.i("QQDownloaderOpenSDKDataProcessor", "getBatchTaskInfos BatchDownloadActionResponse response = null");
    return null;
    label329:
    TMLog.i("QQDownloaderOpenSDKDataProcessor", "getBatchTaskInfos IPCResponse resp = null");
    return null;
  }
  
  public TMAssistantDownloadTaskInfo getDownloadTask(TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam)
  {
    Object localObject1 = null;
    TMLog.i("QQDownloaderOpenSDKDataProcessor", "getDownloadTask param.sngAppid:" + paramTMQQDownloaderOpenSDKParam.SNGAppId + "|param.appid:" + paramTMQQDownloaderOpenSDKParam.taskAppId + "| param.taskPackageName:" + paramTMQQDownloaderOpenSDKParam.taskPackageName + "|param.taskVersion:" + paramTMQQDownloaderOpenSDKParam.taskVersion);
    paramTMQQDownloaderOpenSDKParam = QQParam2BasePram(paramTMQQDownloaderOpenSDKParam);
    Object localObject2 = new QueryDownloadTaskRequest();
    ((QueryDownloadTaskRequest)localObject2).baseParam = paramTMQQDownloaderOpenSDKParam;
    paramTMQQDownloaderOpenSDKParam = buildSendData((JceStruct)localObject2);
    if ((paramTMQQDownloaderOpenSDKParam != null) && (paramTMQQDownloaderOpenSDKParam.length > 0)) {}
    for (;;)
    {
      try
      {
        getOpenSDKClient(GlobalUtil.getInstance().getContext());
        if (this.openSDKClient == null) {
          break label242;
        }
        paramTMQQDownloaderOpenSDKParam = this.openSDKClient.sendSyncData(paramTMQQDownloaderOpenSDKParam);
        paramTMQQDownloaderOpenSDKParam = IPCPackageTools.unpackPackage(paramTMQQDownloaderOpenSDKParam);
        if (paramTMQQDownloaderOpenSDKParam == null) {
          break;
        }
        localObject2 = (QueryDownloadTaskResponse)IPCPackageTools.unpackBodyStruct(paramTMQQDownloaderOpenSDKParam);
        TMLog.i("QQDownloaderOpenSDKDataProcessor", "QueryDownloadTaskResponse downloadTask:" + localObject2);
        int i = GlobalUtil.assistantState2SDKState(((QueryDownloadTaskResponse)localObject2).state);
        paramTMQQDownloaderOpenSDKParam = localObject1;
        if (localObject2 != null) {
          paramTMQQDownloaderOpenSDKParam = new TMAssistantDownloadTaskInfo(((QueryDownloadTaskResponse)localObject2).url, ((QueryDownloadTaskResponse)localObject2).savePath, i, ((QueryDownloadTaskResponse)localObject2).receivedLen, ((QueryDownloadTaskResponse)localObject2).totalLen, "application/vnd.android.package-archive");
        }
        return paramTMQQDownloaderOpenSDKParam;
      }
      catch (Throwable paramTMQQDownloaderOpenSDKParam)
      {
        y.printErrStackTrace("QQDownloaderOpenSDKDataProcessor", paramTMQQDownloaderOpenSDKParam, "", new Object[0]);
        return null;
      }
      TMLog.i("QQDownloaderOpenSDKDataProcessor", "getDownloadTask sendData = null");
      label242:
      paramTMQQDownloaderOpenSDKParam = null;
    }
    TMLog.i("QQDownloaderOpenSDKDataProcessor", "getDownloadTask IPCResponse = null");
    return null;
  }
  
  public void getOpenSDKClient(Context paramContext)
  {
    try
    {
      if ((this.openSDKClient == null) && (paramContext != null))
      {
        this.openSDKClient = TMAssistantDownloadSDKManager.getInstance(paramContext).getDownloadOpenSDKClient(this.clientKey);
        if (this.openSDKClient != null) {
          this.openSDKClient.addAssistantOnActionListener(this);
        }
      }
      return;
    }
    finally {}
  }
  
  public boolean handleBatchRequestAction(int paramInt, ArrayList<TMQQDownloaderOpenSDKParam> paramArrayList, String paramString1, String paramString2, String paramString3)
  {
    boolean bool = false;
    TMLog.i("QQDownloaderOpenSDKDataProcessor", "handleBatchUpdateAction batchRequestType:" + paramInt + "|appList:" + paramArrayList);
    paramArrayList = buildSendData(buildBatchActionRequest(paramInt, paramArrayList, paramString1, paramString2, paramString3));
    if ((paramArrayList != null) && (paramArrayList.length > 0)) {
      try
      {
        getOpenSDKClient(GlobalUtil.getInstance().getContext());
        if (this.openSDKClient != null)
        {
          this.openSDKClient.sendAsyncData(paramArrayList);
          bool = true;
        }
        return bool;
      }
      catch (Throwable paramArrayList)
      {
        y.printErrStackTrace("QQDownloaderOpenSDKDataProcessor", paramArrayList, "", new Object[0]);
        return false;
      }
    }
    TMLog.i("QQDownloaderOpenSDKDataProcessor", "handleBatchUpdateAction sendData = null or length = 0");
    return false;
  }
  
  public boolean handleDownloadTask(TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    boolean bool = false;
    TMLog.i("QQDownloaderOpenSDKDataProcessor", "handleDownloadTask requestType:" + paramInt + "  param.sngAppid:" + paramTMQQDownloaderOpenSDKParam.SNGAppId + "|param.appid:" + paramTMQQDownloaderOpenSDKParam.taskAppId + "| param.taskPackageName:" + paramTMQQDownloaderOpenSDKParam.taskPackageName + "|param.taskVersion:" + paramTMQQDownloaderOpenSDKParam.taskVersion + "| param.actionFlag:" + paramString2 + " | verifyType:" + paramString3);
    OperateDownloadTaskRequest localOperateDownloadTaskRequest = new OperateDownloadTaskRequest();
    paramTMQQDownloaderOpenSDKParam = QQParam2BasePram(paramTMQQDownloaderOpenSDKParam);
    localOperateDownloadTaskRequest.requestType = paramInt;
    localOperateDownloadTaskRequest.baseParam = paramTMQQDownloaderOpenSDKParam;
    localOperateDownloadTaskRequest.actionFlag = paramString2;
    localOperateDownloadTaskRequest.verifyType = paramString3;
    localOperateDownloadTaskRequest.opList = paramString1;
    paramTMQQDownloaderOpenSDKParam = buildSendData(localOperateDownloadTaskRequest);
    if ((paramTMQQDownloaderOpenSDKParam != null) && (paramTMQQDownloaderOpenSDKParam.length > 0)) {
      try
      {
        getOpenSDKClient(GlobalUtil.getInstance().getContext());
        if (this.openSDKClient != null)
        {
          this.openSDKClient.sendAsyncData(paramTMQQDownloaderOpenSDKParam);
          bool = true;
        }
        return bool;
      }
      catch (Throwable paramTMQQDownloaderOpenSDKParam)
      {
        y.printErrStackTrace("QQDownloaderOpenSDKDataProcessor", paramTMQQDownloaderOpenSDKParam, "", new Object[0]);
        return false;
      }
    }
    TMLog.i("QQDownloaderOpenSDKDataProcessor", "handleDownloadTask sendData = null");
    return false;
  }
  
  public boolean handleUriAction(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      paramString = buildSendData(new URIActionRequest(paramString));
      if ((paramString != null) && (paramString.length > 0)) {
        try
        {
          getOpenSDKClient(GlobalUtil.getInstance().getContext());
          if (this.openSDKClient != null)
          {
            this.openSDKClient.sendAsyncData(paramString);
            return false;
          }
        }
        catch (Throwable paramString)
        {
          y.printErrStackTrace("QQDownloaderOpenSDKDataProcessor", paramString, "", new Object[0]);
          return false;
        }
      }
    }
    TMLog.i("QQDownloaderOpenSDKDataProcessor", "handleUriAction sendData = null");
    return false;
  }
  
  public void onActionResult(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramArrayOfByte = IPCPackageTools.unpackPackage(paramArrayOfByte);
      JceStruct localJceStruct = IPCPackageTools.unpackBodyStruct(paramArrayOfByte);
      switch (paramArrayOfByte.head.cmdId)
      {
      default: 
      case 2: 
      case 3: 
        do
        {
          do
          {
            return;
          } while (localJceStruct == null);
          onStateChanged((GetDownloadStateResponse)localJceStruct);
          return;
        } while (localJceStruct == null);
        onProgressChanged((GetDownloadProgressResponse)localJceStruct);
        return;
      }
      onServiceFreed();
      return;
    }
    TMLog.i("QQDownloaderOpenSDKDataProcessor", "onActionResult reponseData = null");
  }
  
  public void onDownloadSDKServiceInvalid()
  {
    if (this.callback != null) {
      this.callback.OnQQDownloaderInvalid();
    }
    Context localContext = GlobalUtil.getInstance().getContext();
    if (localContext != null) {
      TMAssistantDownloadSDKManager.getInstance(localContext).releaseDownloadSDKClient(this.clientKey);
    }
    this.openSDKClient = null;
  }
  
  void onProgressChanged(GetDownloadProgressResponse paramGetDownloadProgressResponse)
  {
    TMQQDownloaderOpenSDKParam localTMQQDownloaderOpenSDKParam = baseParam2QQParam(paramGetDownloadProgressResponse.requestParam);
    if ((localTMQQDownloaderOpenSDKParam != null) && (this.callback != null))
    {
      TMLog.i("QQDownloaderOpenSDKDataProcessor", "进度回调：GetDownloadProgressResponse response.receivedLen:" + paramGetDownloadProgressResponse.receivedLen + ",response.totalLen" + paramGetDownloadProgressResponse.totalLen);
      this.callback.OnDownloadTaskProgressChanged(localTMQQDownloaderOpenSDKParam, paramGetDownloadProgressResponse.receivedLen, paramGetDownloadProgressResponse.totalLen);
    }
  }
  
  void onServiceFreed()
  {
    if (this.callback != null) {
      this.callback.OnServiceFree();
    }
  }
  
  void onStateChanged(GetDownloadStateResponse paramGetDownloadStateResponse)
  {
    TMQQDownloaderOpenSDKParam localTMQQDownloaderOpenSDKParam = baseParam2QQParam(paramGetDownloadStateResponse.requestParam);
    if ((localTMQQDownloaderOpenSDKParam != null) && (this.callback != null))
    {
      TMLog.i("QQDownloaderOpenSDKDataProcessor", "状态回调：GetDownloadStateResponse param.taskAppId:" + localTMQQDownloaderOpenSDKParam.taskAppId + ",param.taskPackageName:" + localTMQQDownloaderOpenSDKParam.taskPackageName + ",state:" + paramGetDownloadStateResponse.state + ",response.errorCode" + paramGetDownloadStateResponse.errorCode);
      this.callback.OnDownloadTaskStateChanged(localTMQQDownloaderOpenSDKParam, GlobalUtil.assistantState2SDKState(paramGetDownloadStateResponse.state), GlobalUtil.assistantErrorCode2SDKErrorCode(paramGetDownloadStateResponse.errorCode), paramGetDownloadStateResponse.errorMsg);
    }
  }
  
  public void registerIQQDownloaderOpenSDKListener(ITMQQDownloaderOpenSDKListener paramITMQQDownloaderOpenSDKListener)
  {
    this.callback = paramITMQQDownloaderOpenSDKListener;
  }
  
  public void releaseIPCClient()
  {
    if (this.openSDKClient != null)
    {
      Context localContext = GlobalUtil.getInstance().getContext();
      if (localContext != null) {
        TMAssistantDownloadSDKManager.getInstance(localContext).releaseDownloadSDKClient(this.clientKey);
      }
      this.openSDKClient = null;
    }
  }
  
  public void unregisterIQQDownloaderOpenSDKListener()
  {
    this.callback = null;
    Context localContext = GlobalUtil.getInstance().getContext();
    if (localContext != null) {
      TMAssistantDownloadSDKManager.getInstance(localContext).releaseDownloadSDKClient(this.clientKey);
    }
    this.openSDKClient = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKDataProcessor
 * JD-Core Version:    0.7.0.1
 */