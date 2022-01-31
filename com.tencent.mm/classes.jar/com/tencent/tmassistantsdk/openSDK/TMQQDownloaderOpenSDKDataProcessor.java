package com.tencent.tmassistantsdk.openSDK;

import android.content.Context;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
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
  protected ITMQQDownloaderOpenSDKListener callback;
  String clientKey;
  protected TMAssistantDownloadOpenSDKClient openSDKClient;
  
  public TMQQDownloaderOpenSDKDataProcessor()
  {
    AppMethodBeat.i(75876);
    this.openSDKClient = null;
    this.callback = null;
    this.clientKey = UUID.randomUUID().toString();
    AppMethodBeat.o(75876);
  }
  
  private TMQQDownloaderOpenSDKDataProcessor(Context paramContext)
  {
    AppMethodBeat.i(75877);
    this.openSDKClient = null;
    this.callback = null;
    this.clientKey = UUID.randomUUID().toString();
    if (paramContext != null) {
      getOpenSDKClient(paramContext);
    }
    AppMethodBeat.o(75877);
  }
  
  private static IPCBaseParam QQParam2BasePram(TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam)
  {
    AppMethodBeat.i(75887);
    if (paramTMQQDownloaderOpenSDKParam == null)
    {
      AppMethodBeat.o(75887);
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
    AppMethodBeat.o(75887);
    return localIPCBaseParam;
  }
  
  private TMQQDownloaderOpenSDKParam baseParam2QQParam(IPCBaseParam paramIPCBaseParam)
  {
    AppMethodBeat.i(75888);
    if (paramIPCBaseParam == null)
    {
      AppMethodBeat.o(75888);
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
      AppMethodBeat.o(75888);
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
    AppMethodBeat.i(75885);
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
    AppMethodBeat.o(75885);
    return localBatchDownloadActionRequest;
  }
  
  protected static byte[] buildSendData(JceStruct paramJceStruct)
  {
    AppMethodBeat.i(75886);
    paramJceStruct = IPCPackageTools.buildIpcRequest(paramJceStruct);
    if (paramJceStruct != null)
    {
      paramJceStruct = IPCPackageTools.buildPostData(paramJceStruct);
      if ((paramJceStruct != null) && (paramJceStruct.length > 0))
      {
        AppMethodBeat.o(75886);
        return paramJceStruct;
      }
      TMLog.i("QQDownloaderOpenSDKDataProcessor", "handleUriAction sendData = null");
      AppMethodBeat.o(75886);
      return null;
    }
    TMLog.i("QQDownloaderOpenSDKDataProcessor", "handleUriAction IPCRequest = null");
    AppMethodBeat.o(75886);
    return null;
  }
  
  public static TMQQDownloaderOpenSDKDataProcessor getInstance(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(75878);
      if (mOpenSDKDataProcessor == null) {
        mOpenSDKDataProcessor = new TMQQDownloaderOpenSDKDataProcessor(paramContext);
      }
      paramContext = mOpenSDKDataProcessor;
      AppMethodBeat.o(75878);
      return paramContext;
    }
    finally {}
  }
  
  public ArrayList<TMAssistantDownloadTaskInfo> getBatchTaskInfos(ArrayList<TMQQDownloaderOpenSDKParam> paramArrayList, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(75883);
    if (paramArrayList == null)
    {
      AppMethodBeat.o(75883);
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
        paramString1 = null;
        paramArrayList = IPCPackageTools.unpackPackage(paramArrayList);
        if (paramArrayList == null) {
          break label354;
        }
        paramString2 = (BatchDownloadActionResponse)IPCPackageTools.unpackBodyStruct(paramArrayList);
        if (paramString2 == null) {
          break label341;
        }
        paramArrayList = "getBatchTaskInfos BatchDownloadActionResponse batchRequestType:" + paramString2.batchRequestType;
        if (paramString2.batchData == null) {
          break label315;
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
        ab.printErrStackTrace("QQDownloaderOpenSDKDataProcessor", paramArrayList, "", new Object[0]);
        AppMethodBeat.o(75883);
        return null;
      }
    }
    TMLog.i("QQDownloaderOpenSDKDataProcessor", paramString1);
    for (;;)
    {
      AppMethodBeat.o(75883);
      return paramArrayList;
      label315:
      paramString1 = paramArrayList + "response.batchData = null";
      paramArrayList = null;
      break;
      label341:
      TMLog.i("QQDownloaderOpenSDKDataProcessor", "getBatchTaskInfos BatchDownloadActionResponse response = null");
      paramArrayList = paramString1;
      continue;
      label354:
      TMLog.i("QQDownloaderOpenSDKDataProcessor", "getBatchTaskInfos IPCResponse resp = null");
      paramArrayList = paramString1;
    }
  }
  
  public TMAssistantDownloadTaskInfo getDownloadTask(TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam)
  {
    AppMethodBeat.i(75884);
    TMLog.i("QQDownloaderOpenSDKDataProcessor", "getDownloadTask param.sngAppid:" + paramTMQQDownloaderOpenSDKParam.SNGAppId + "|param.appid:" + paramTMQQDownloaderOpenSDKParam.taskAppId + "| param.taskPackageName:" + paramTMQQDownloaderOpenSDKParam.taskPackageName + "|param.taskVersion:" + paramTMQQDownloaderOpenSDKParam.taskVersion);
    paramTMQQDownloaderOpenSDKParam = QQParam2BasePram(paramTMQQDownloaderOpenSDKParam);
    QueryDownloadTaskRequest localQueryDownloadTaskRequest = new QueryDownloadTaskRequest();
    localQueryDownloadTaskRequest.baseParam = paramTMQQDownloaderOpenSDKParam;
    paramTMQQDownloaderOpenSDKParam = buildSendData(localQueryDownloadTaskRequest);
    if ((paramTMQQDownloaderOpenSDKParam != null) && (paramTMQQDownloaderOpenSDKParam.length > 0)) {}
    for (;;)
    {
      try
      {
        getOpenSDKClient(GlobalUtil.getInstance().getContext());
        if (this.openSDKClient == null) {
          break label238;
        }
        paramTMQQDownloaderOpenSDKParam = this.openSDKClient.sendSyncData(paramTMQQDownloaderOpenSDKParam);
        paramTMQQDownloaderOpenSDKParam = IPCPackageTools.unpackPackage(paramTMQQDownloaderOpenSDKParam);
        if (paramTMQQDownloaderOpenSDKParam == null) {
          break;
        }
        paramTMQQDownloaderOpenSDKParam = (QueryDownloadTaskResponse)IPCPackageTools.unpackBodyStruct(paramTMQQDownloaderOpenSDKParam);
        TMLog.i("QQDownloaderOpenSDKDataProcessor", "QueryDownloadTaskResponse downloadTask:".concat(String.valueOf(paramTMQQDownloaderOpenSDKParam)));
        int i = GlobalUtil.assistantState2SDKState(paramTMQQDownloaderOpenSDKParam.state);
        if (paramTMQQDownloaderOpenSDKParam == null) {
          break label251;
        }
        paramTMQQDownloaderOpenSDKParam = new TMAssistantDownloadTaskInfo(paramTMQQDownloaderOpenSDKParam.url, paramTMQQDownloaderOpenSDKParam.savePath, i, paramTMQQDownloaderOpenSDKParam.receivedLen, paramTMQQDownloaderOpenSDKParam.totalLen, "application/vnd.android.package-archive");
        AppMethodBeat.o(75884);
        return paramTMQQDownloaderOpenSDKParam;
      }
      catch (Throwable paramTMQQDownloaderOpenSDKParam)
      {
        ab.printErrStackTrace("QQDownloaderOpenSDKDataProcessor", paramTMQQDownloaderOpenSDKParam, "", new Object[0]);
        AppMethodBeat.o(75884);
        return null;
      }
      TMLog.i("QQDownloaderOpenSDKDataProcessor", "getDownloadTask sendData = null");
      label238:
      paramTMQQDownloaderOpenSDKParam = null;
    }
    TMLog.i("QQDownloaderOpenSDKDataProcessor", "getDownloadTask IPCResponse = null");
    label251:
    AppMethodBeat.o(75884);
    return null;
  }
  
  public void getOpenSDKClient(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(75895);
      if ((this.openSDKClient == null) && (paramContext != null))
      {
        this.openSDKClient = TMAssistantDownloadSDKManager.getInstance(paramContext).getDownloadOpenSDKClient(this.clientKey);
        if (this.openSDKClient != null) {
          this.openSDKClient.addAssistantOnActionListener(this);
        }
      }
      AppMethodBeat.o(75895);
      return;
    }
    finally {}
  }
  
  public boolean handleBatchRequestAction(int paramInt, ArrayList<TMQQDownloaderOpenSDKParam> paramArrayList, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(75882);
    TMLog.i("QQDownloaderOpenSDKDataProcessor", "handleBatchUpdateAction batchRequestType:" + paramInt + "|appList:" + paramArrayList);
    paramArrayList = buildSendData(buildBatchActionRequest(paramInt, paramArrayList, paramString1, paramString2, paramString3));
    if ((paramArrayList != null) && (paramArrayList.length > 0)) {
      try
      {
        getOpenSDKClient(GlobalUtil.getInstance().getContext());
        if (this.openSDKClient != null)
        {
          this.openSDKClient.sendAsyncData(paramArrayList);
          AppMethodBeat.o(75882);
          return true;
        }
        AppMethodBeat.o(75882);
        return false;
      }
      catch (Throwable paramArrayList)
      {
        ab.printErrStackTrace("QQDownloaderOpenSDKDataProcessor", paramArrayList, "", new Object[0]);
        AppMethodBeat.o(75882);
        return false;
      }
    }
    TMLog.i("QQDownloaderOpenSDKDataProcessor", "handleBatchUpdateAction sendData = null or length = 0");
    AppMethodBeat.o(75882);
    return false;
  }
  
  public boolean handleDownloadTask(TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(75880);
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
          AppMethodBeat.o(75880);
          return true;
        }
        AppMethodBeat.o(75880);
        return false;
      }
      catch (Throwable paramTMQQDownloaderOpenSDKParam)
      {
        ab.printErrStackTrace("QQDownloaderOpenSDKDataProcessor", paramTMQQDownloaderOpenSDKParam, "", new Object[0]);
        AppMethodBeat.o(75880);
        return false;
      }
    }
    TMLog.i("QQDownloaderOpenSDKDataProcessor", "handleDownloadTask sendData = null");
    AppMethodBeat.o(75880);
    return false;
  }
  
  public boolean handleUriAction(String paramString)
  {
    AppMethodBeat.i(75881);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(75881);
      return false;
    }
    paramString = buildSendData(new URIActionRequest(paramString));
    if ((paramString != null) && (paramString.length > 0)) {
      try
      {
        getOpenSDKClient(GlobalUtil.getInstance().getContext());
        if (this.openSDKClient != null) {
          this.openSDKClient.sendAsyncData(paramString);
        }
        AppMethodBeat.o(75881);
        return false;
      }
      catch (Throwable paramString)
      {
        ab.printErrStackTrace("QQDownloaderOpenSDKDataProcessor", paramString, "", new Object[0]);
        AppMethodBeat.o(75881);
        return false;
      }
    }
    TMLog.i("QQDownloaderOpenSDKDataProcessor", "handleUriAction sendData = null");
    AppMethodBeat.o(75881);
    return false;
  }
  
  public void onActionResult(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(75889);
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramArrayOfByte = IPCPackageTools.unpackPackage(paramArrayOfByte);
      JceStruct localJceStruct = IPCPackageTools.unpackBodyStruct(paramArrayOfByte);
      switch (paramArrayOfByte.head.cmdId)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(75889);
        return;
        if (localJceStruct != null)
        {
          onStateChanged((GetDownloadStateResponse)localJceStruct);
          AppMethodBeat.o(75889);
          return;
          if (localJceStruct != null)
          {
            onProgressChanged((GetDownloadProgressResponse)localJceStruct);
            AppMethodBeat.o(75889);
            return;
            onServiceFreed();
          }
        }
      }
    }
    TMLog.i("QQDownloaderOpenSDKDataProcessor", "onActionResult reponseData = null");
    AppMethodBeat.o(75889);
  }
  
  public void onDownloadSDKServiceInvalid()
  {
    AppMethodBeat.i(75890);
    if (this.callback != null) {
      this.callback.OnQQDownloaderInvalid();
    }
    Context localContext = GlobalUtil.getInstance().getContext();
    if (localContext != null) {
      TMAssistantDownloadSDKManager.getInstance(localContext).releaseDownloadSDKClient(this.clientKey);
    }
    this.openSDKClient = null;
    AppMethodBeat.o(75890);
  }
  
  void onProgressChanged(GetDownloadProgressResponse paramGetDownloadProgressResponse)
  {
    AppMethodBeat.i(75893);
    TMQQDownloaderOpenSDKParam localTMQQDownloaderOpenSDKParam = baseParam2QQParam(paramGetDownloadProgressResponse.requestParam);
    if ((localTMQQDownloaderOpenSDKParam != null) && (this.callback != null))
    {
      TMLog.i("QQDownloaderOpenSDKDataProcessor", "进度回调：GetDownloadProgressResponse response.receivedLen:" + paramGetDownloadProgressResponse.receivedLen + ",response.totalLen" + paramGetDownloadProgressResponse.totalLen);
      this.callback.OnDownloadTaskProgressChanged(localTMQQDownloaderOpenSDKParam, paramGetDownloadProgressResponse.receivedLen, paramGetDownloadProgressResponse.totalLen);
    }
    AppMethodBeat.o(75893);
  }
  
  void onServiceFreed()
  {
    AppMethodBeat.i(75894);
    if (this.callback != null) {
      this.callback.OnServiceFree();
    }
    AppMethodBeat.o(75894);
  }
  
  void onStateChanged(GetDownloadStateResponse paramGetDownloadStateResponse)
  {
    AppMethodBeat.i(75892);
    TMQQDownloaderOpenSDKParam localTMQQDownloaderOpenSDKParam = baseParam2QQParam(paramGetDownloadStateResponse.requestParam);
    if ((localTMQQDownloaderOpenSDKParam != null) && (this.callback != null))
    {
      TMLog.i("QQDownloaderOpenSDKDataProcessor", "状态回调：GetDownloadStateResponse param.taskAppId:" + localTMQQDownloaderOpenSDKParam.taskAppId + ",param.taskPackageName:" + localTMQQDownloaderOpenSDKParam.taskPackageName + ",state:" + paramGetDownloadStateResponse.state + ",response.errorCode" + paramGetDownloadStateResponse.errorCode);
      this.callback.OnDownloadTaskStateChanged(localTMQQDownloaderOpenSDKParam, GlobalUtil.assistantState2SDKState(paramGetDownloadStateResponse.state), GlobalUtil.assistantErrorCode2SDKErrorCode(paramGetDownloadStateResponse.errorCode), paramGetDownloadStateResponse.errorMsg);
    }
    AppMethodBeat.o(75892);
  }
  
  public void registerIQQDownloaderOpenSDKListener(ITMQQDownloaderOpenSDKListener paramITMQQDownloaderOpenSDKListener)
  {
    this.callback = paramITMQQDownloaderOpenSDKListener;
  }
  
  public void releaseIPCClient()
  {
    AppMethodBeat.i(75891);
    if (this.openSDKClient != null)
    {
      Context localContext = GlobalUtil.getInstance().getContext();
      if (localContext != null) {
        TMAssistantDownloadSDKManager.getInstance(localContext).releaseDownloadSDKClient(this.clientKey);
      }
      this.openSDKClient = null;
    }
    AppMethodBeat.o(75891);
  }
  
  public void unregisterIQQDownloaderOpenSDKListener()
  {
    AppMethodBeat.i(75879);
    this.callback = null;
    Context localContext = GlobalUtil.getInstance().getContext();
    if (localContext != null) {
      TMAssistantDownloadSDKManager.getInstance(localContext).releaseDownloadSDKClient(this.clientKey);
    }
    this.openSDKClient = null;
    AppMethodBeat.o(75879);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKDataProcessor
 * JD-Core Version:    0.7.0.1
 */