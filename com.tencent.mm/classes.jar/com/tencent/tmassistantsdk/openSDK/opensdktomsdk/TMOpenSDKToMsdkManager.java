package com.tencent.tmassistantsdk.openSDK.opensdktomsdk;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.tmassistantsdk.channel.TMAssistantSDKChannel;
import com.tencent.tmassistantsdk.channel.TMAssistantSDKChannelDataItem;
import com.tencent.tmassistantsdk.downloadclient.ITMAssistantDownloadSDKClientListener;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClient;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKManager;
import com.tencent.tmassistantsdk.logreport.TipsInfoReportManager;
import com.tencent.tmassistantsdk.network.GetAuthorizedHttpRequest;
import com.tencent.tmassistantsdk.network.IGetAuthorizedHttpRequestListenner;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDK;
import com.tencent.tmassistantsdk.openSDK.opensdktomsdk.component.PopDialog;
import com.tencent.tmassistantsdk.openSDK.opensdktomsdk.data.ActionButton;
import com.tencent.tmassistantsdk.openSDK.opensdktomsdk.data.AuthorizedResult;
import com.tencent.tmassistantsdk.openSDK.opensdktomsdk.data.TipsInfo;
import com.tencent.tmassistantsdk.protocol.jce.TipsInfoLog;
import com.tencent.tmassistantsdk.util.Res;
import com.tencent.tmassistantsdk.util.TMLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class TMOpenSDKToMsdkManager
{
  protected static final String CLIENT_NAME = "downloadSDKClient";
  protected static final String TAG = "OpensdkToMsdkManager";
  protected static TMOpenSDKToMsdkManager mInstance = null;
  protected int authorizedState;
  protected PopDialog dialog;
  protected boolean hasNotify;
  protected long insertActionId;
  protected boolean isInstallFinished;
  protected TMOpenSDKAuthorizedInfo mAuthorizedInfo;
  protected TMAssistantDownloadSDKClient mClient;
  protected Context mContext;
  protected ITMAssistantDownloadSDKClientListener mDownloadSDKListener;
  protected String mDownloadUrl;
  protected GetAuthorizedHttpRequest mHttpRequest;
  protected ak mMainMessageHandler;
  protected TMQQDownloaderOpenSDK mOpenSDK;
  protected IGetAuthorizedHttpRequestListenner mRequestListener;
  protected ak mSubMessageHandler;
  protected HandlerThread mSubMessagehandlerThread;
  protected int mSupportVersionCode;
  protected ITMOpenSDKToMsdkListener mToMsdkListener;
  protected View.OnClickListener negativeBtnListenner;
  protected View.OnClickListener positiveBtnListener;
  protected View.OnClickListener retryBtnListener;
  protected TMAssistantSDKChannel sdkChannel;
  
  private TMOpenSDKToMsdkManager(Context paramContext)
  {
    AppMethodBeat.i(75931);
    this.mContext = null;
    this.mHttpRequest = null;
    this.mToMsdkListener = null;
    this.mAuthorizedInfo = null;
    this.mDownloadUrl = null;
    this.mSupportVersionCode = 0;
    this.authorizedState = 0;
    this.hasNotify = false;
    this.isInstallFinished = false;
    this.insertActionId = -1L;
    this.sdkChannel = null;
    this.dialog = null;
    this.mOpenSDK = null;
    this.mSubMessagehandlerThread = null;
    this.mSubMessageHandler = null;
    this.mMainMessageHandler = null;
    this.mClient = null;
    this.mRequestListener = new TMOpenSDKToMsdkManager.2(this);
    this.retryBtnListener = new TMOpenSDKToMsdkManager.4(this);
    this.negativeBtnListenner = new TMOpenSDKToMsdkManager.5(this);
    this.positiveBtnListener = new TMOpenSDKToMsdkManager.6(this);
    this.mDownloadSDKListener = new ITMAssistantDownloadSDKClientListener()
    {
      public void OnDownloadSDKTaskProgressChanged(TMAssistantDownloadSDKClient paramAnonymousTMAssistantDownloadSDKClient, String paramAnonymousString, long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(75930);
        paramAnonymousTMAssistantDownloadSDKClient = new Message();
        paramAnonymousTMAssistantDownloadSDKClient.what = 1;
        paramAnonymousString = new Bundle();
        paramAnonymousString.putLong("receiveDataLen", paramAnonymousLong1);
        paramAnonymousString.putLong("totalDataLen", paramAnonymousLong2);
        paramAnonymousTMAssistantDownloadSDKClient.setData(paramAnonymousString);
        TMOpenSDKToMsdkManager.this.mMainMessageHandler.sendMessage(paramAnonymousTMAssistantDownloadSDKClient);
        AppMethodBeat.o(75930);
      }
      
      public void OnDownloadSDKTaskStateChanged(TMAssistantDownloadSDKClient paramAnonymousTMAssistantDownloadSDKClient, String paramAnonymousString1, int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString2, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(75929);
        TMLog.i("OpensdkToMsdkManager", "OnDownloadSDKTaskStateChanged client:" + paramAnonymousTMAssistantDownloadSDKClient + " | state:" + paramAnonymousInt1 + " | errorcode:" + paramAnonymousInt2 + " | errorMsg:" + paramAnonymousString2);
        if ((paramAnonymousTMAssistantDownloadSDKClient == null) || (TextUtils.isEmpty(paramAnonymousString1)))
        {
          AppMethodBeat.o(75929);
          return;
        }
        if (4 == paramAnonymousInt1)
        {
          TMOpenSDKToMsdkManager.this.mSubMessageHandler.post(new TMOpenSDKToMsdkManager.9.1(this, paramAnonymousTMAssistantDownloadSDKClient, paramAnonymousString1));
          AppMethodBeat.o(75929);
          return;
        }
        if (5 == paramAnonymousInt1)
        {
          paramAnonymousTMAssistantDownloadSDKClient = new Message();
          paramAnonymousTMAssistantDownloadSDKClient.what = 3;
          TMOpenSDKToMsdkManager.this.mMainMessageHandler.sendMessage(paramAnonymousTMAssistantDownloadSDKClient);
        }
        AppMethodBeat.o(75929);
      }
      
      public void OnDwonloadSDKServiceInvalid(TMAssistantDownloadSDKClient paramAnonymousTMAssistantDownloadSDKClient) {}
    };
    this.mContext = paramContext;
    AppMethodBeat.o(75931);
  }
  
  public static String about()
  {
    return "TMOpenSDKToMsdkManager_2014_04_01_19_51_release_25434";
  }
  
  public static TMOpenSDKToMsdkManager getInstance(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(75932);
      if (mInstance == null) {
        mInstance = new TMOpenSDKToMsdkManager(paramContext);
      }
      paramContext = mInstance;
      AppMethodBeat.o(75932);
      return paramContext;
    }
    finally {}
  }
  
  protected void continueDownload()
  {
    AppMethodBeat.i(75943);
    this.mSubMessageHandler.post(new TMOpenSDKToMsdkManager.3(this));
    AppMethodBeat.o(75943);
  }
  
  protected TMAssistantDownloadSDKClient getClient()
  {
    AppMethodBeat.i(75953);
    if (this.mContext != null)
    {
      TMAssistantDownloadSDKClient localTMAssistantDownloadSDKClient;
      if (this.mClient == null)
      {
        localTMAssistantDownloadSDKClient = TMAssistantDownloadSDKManager.getInstance(this.mContext).getDownloadSDKClient("downloadSDKClient");
        localTMAssistantDownloadSDKClient.registerDownloadTaskListener(this.mDownloadSDKListener);
        this.mClient = localTMAssistantDownloadSDKClient;
      }
      for (;;)
      {
        AppMethodBeat.o(75953);
        return localTMAssistantDownloadSDKClient;
        localTMAssistantDownloadSDKClient = this.mClient;
      }
    }
    AppMethodBeat.o(75953);
    return null;
  }
  
  public void getUserAuthorizedInfo(TMOpenSDKAuthorizedInfo paramTMOpenSDKAuthorizedInfo, Context paramContext)
  {
    AppMethodBeat.i(75936);
    if (paramContext != null) {
      this.mContext = paramContext;
    }
    TMLog.i("OpensdkToMsdkManager", "getUserAuthorizedInfo method called!");
    this.hasNotify = false;
    if (this.mHttpRequest != null)
    {
      TMLog.i("OpensdkToMsdkManager", "mHttpRequest != null, request didn't finish!");
      AppMethodBeat.o(75936);
      return;
    }
    if (paramTMOpenSDKAuthorizedInfo != null)
    {
      this.mAuthorizedInfo = paramTMOpenSDKAuthorizedInfo;
      if (this.mHttpRequest == null)
      {
        this.authorizedState = 1;
        this.mHttpRequest = new GetAuthorizedHttpRequest();
        this.mHttpRequest.setListenner(this.mRequestListener);
        this.mHttpRequest.sendRequest(paramTMOpenSDKAuthorizedInfo);
        AppMethodBeat.o(75936);
      }
    }
    else
    {
      TMLog.i("OpensdkToMsdkManager", "AuthorizedInfo object is null!");
    }
    AppMethodBeat.o(75936);
  }
  
  protected void handleDownloadContinue(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(75949);
    if (this.mContext == null)
    {
      TMLog.i("OpensdkToMsdkManager", "handleDownloading context = null!");
      AppMethodBeat.o(75949);
      return;
    }
    Res localRes = new Res(this.mContext);
    String str1 = this.mContext.getString(localRes.string("white_list_positive_continue"));
    String str2 = "(" + (int)(((float)(100L * paramLong1) + 0.0F) / (float)paramLong2) + "%)";
    this.dialog.downloadText.setText(str1 + str2);
    this.dialog.downloadProgressBar.setProgress((int)(((float)paramLong1 + 0.0F) / (float)paramLong2 * this.dialog.downloadProgressBar.getMax()));
    if (this.dialog.downloadProgressBar.getProgress() > 0) {
      this.dialog.setPositiveBtnBgResource(localRes.drawable("com_tencent_tmassistant_sdk_button_bg"));
    }
    AppMethodBeat.o(75949);
  }
  
  protected void handleDownloadFailed()
  {
    AppMethodBeat.i(75947);
    if (this.mContext == null)
    {
      TMLog.i("OpensdkToMsdkManager", "handleDownloading context = null!");
      AppMethodBeat.o(75947);
      return;
    }
    Res localRes = new Res(this.mContext);
    this.dialog.setPositiveBtnEnable(true);
    this.dialog.downloadText.setText(this.mContext.getString(localRes.string("white_list_positive_retry")));
    if (this.dialog.downloadProgressBar.getProgress() > 0) {
      this.dialog.setPositiveBtnBgResource(localRes.drawable("com_tencent_tmassistant_sdk_button_bg"));
    }
    AppMethodBeat.o(75947);
  }
  
  protected void handleDownloading(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(75948);
    if (this.mContext == null)
    {
      TMLog.i("OpensdkToMsdkManager", "handleDownloading context = null!");
      AppMethodBeat.o(75948);
      return;
    }
    Object localObject = new Res(this.mContext);
    localObject = this.mContext.getString(((Res)localObject).string("white_list_positive_downloading"));
    String str = "(" + (int)(((float)(100L * paramLong1) + 0.0F) / (float)paramLong2) + "%)";
    this.dialog.downloadText.setText((String)localObject + str);
    this.dialog.downloadProgressBar.setProgress((int)(((float)paramLong1 + 0.0F) / (float)paramLong2 * this.dialog.downloadProgressBar.getMax()));
    TMLog.i("OpensdkToMsdkManager", "handleDownloading : receivedlen:" + paramLong1 + " | totalLen:" + paramLong2);
    AppMethodBeat.o(75948);
  }
  
  protected void handleInstall(String paramString, int paramInt)
  {
    AppMethodBeat.i(75946);
    if (this.mContext == null)
    {
      AppMethodBeat.o(75946);
      return;
    }
    Res localRes = new Res(this.mContext);
    this.dialog.setPositiveBtnEnable(true);
    this.dialog.downloadText.setText(this.mContext.getString(localRes.string("white_list_positive_install")));
    if (this.mContext == null)
    {
      TMLog.i("OpensdkToMsdkManager", "handleDownloading context = null!");
      AppMethodBeat.o(75946);
      return;
    }
    this.isInstallFinished = true;
    if (paramInt == 1)
    {
      AppMethodBeat.o(75946);
      return;
    }
    q.a(this.mContext, new File(paramString), null, false);
    AppMethodBeat.o(75946);
  }
  
  public void initOpenSDK(ITMOpenSDKToMsdkListener paramITMOpenSDKToMsdkListener)
  {
    AppMethodBeat.i(75933);
    this.mOpenSDK = TMQQDownloaderOpenSDK.getInstance();
    this.mOpenSDK.initQQDownloaderOpenSDK(this.mContext);
    this.mToMsdkListener = paramITMOpenSDKToMsdkListener;
    this.sdkChannel = new TMAssistantSDKChannel();
    this.mSubMessagehandlerThread = new HandlerThread("OpenSDKToMsdkManager");
    this.mSubMessagehandlerThread.start();
    this.mSubMessageHandler = new ak(this.mSubMessagehandlerThread.getLooper());
    this.mMainMessageHandler = new ak(Looper.getMainLooper(), new TMOpenSDKToMsdkManager.1(this));
    AppMethodBeat.o(75933);
  }
  
  protected boolean isExitsAction(long paramLong)
  {
    AppMethodBeat.i(75945);
    if (paramLong < 0L)
    {
      AppMethodBeat.o(75945);
      return false;
    }
    if (this.sdkChannel == null)
    {
      AppMethodBeat.o(75945);
      return false;
    }
    Iterator localIterator = this.sdkChannel.getChannelDataItemList().iterator();
    while (localIterator.hasNext())
    {
      TMAssistantSDKChannelDataItem localTMAssistantSDKChannelDataItem = (TMAssistantSDKChannelDataItem)localIterator.next();
      if ((localTMAssistantSDKChannelDataItem.mDBIdentity == paramLong) && (localTMAssistantSDKChannelDataItem.mDataItemEndTime - localTMAssistantSDKChannelDataItem.mDataItemStartTime <= 300000L))
      {
        AppMethodBeat.o(75945);
        return true;
      }
    }
    AppMethodBeat.o(75945);
    return false;
  }
  
  protected void notifyAuthorizedFinished(boolean paramBoolean, TMOpenSDKAuthorizedInfo paramTMOpenSDKAuthorizedInfo)
  {
    AppMethodBeat.i(75941);
    TMLog.i("OpensdkToMsdkManager", "before realy notifyAuthorizedFinished: TMOpenSDKAuthorizedInfo:" + this.mAuthorizedInfo);
    if (this.mToMsdkListener == null) {
      TMLog.i("OpensdkToMsdkManager", "before notifyAuthorizedFinished: mToMsdkListener = null !");
    }
    if ((this.mToMsdkListener != null) && (this.mAuthorizedInfo != null))
    {
      TMLog.i("OpensdkToMsdkManager", "notifyAuthorizedFinished: result:".concat(String.valueOf(paramBoolean)));
      this.mToMsdkListener.onAuthorizedFinished(paramBoolean, this.mAuthorizedInfo);
      this.mHttpRequest = null;
      this.hasNotify = true;
    }
    AppMethodBeat.o(75941);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(75934);
    if ((this.dialog != null) && (this.dialog.isShowing())) {
      this.dialog.dismiss();
    }
    if (this.mOpenSDK != null) {
      this.mOpenSDK.destroyQQDownloaderOpenSDK();
    }
    this.mToMsdkListener = null;
    this.hasNotify = false;
    this.isInstallFinished = false;
    this.authorizedState = 0;
    this.mHttpRequest = null;
    this.mAuthorizedInfo = null;
    this.sdkChannel = null;
    this.insertActionId = -1L;
    if (this.mContext != null) {
      TMAssistantDownloadSDKManager.closeAllService(this.mContext);
    }
    this.mClient = null;
    AppMethodBeat.o(75934);
  }
  
  protected void onNetworkException(int paramInt)
  {
    AppMethodBeat.i(75940);
    if (this.mContext == null)
    {
      AppMethodBeat.o(75940);
      return;
    }
    Object localObject2 = new Res(this.mContext);
    if (1 == paramInt) {}
    for (Object localObject1 = this.mContext.getString(((Res)localObject2).string("white_list_network_not_connected"));; localObject1 = this.mContext.getString(((Res)localObject2).string("white_list_network_error")))
    {
      TipsInfo localTipsInfo = new TipsInfo();
      localTipsInfo.title = this.mContext.getString(((Res)localObject2).string("white_list_dlg_title"));
      localTipsInfo.content = ((String)localObject1);
      localObject1 = new ArrayList();
      ActionButton localActionButton = new ActionButton();
      localActionButton.jumpType = 3;
      ((ArrayList)localObject1).add(localActionButton);
      localObject2 = this.mContext.getString(((Res)localObject2).string("white_list_negtive_known"));
      localActionButton.textInstalled = ((String)localObject2);
      localActionButton.textUninstalled = ((String)localObject2);
      localTipsInfo.actionButton = ((ArrayList)localObject1);
      showDialog(localTipsInfo);
      this.mHttpRequest = null;
      this.mDownloadUrl = "";
      this.authorizedState = 3;
      TMLog.i("OpensdkToMsdkManager", "network error happened!");
      localObject1 = TipsInfoReportManager.getInstance().createTipsInfoLog(this.mAuthorizedInfo);
      ((TipsInfoLog)localObject1).networkErrorTipsCount += 1;
      TipsInfoReportManager.getInstance().addLogData((JceStruct)localObject1);
      AppMethodBeat.o(75940);
      return;
    }
  }
  
  protected void onNetworkFinishedFailed(int paramInt)
  {
    AppMethodBeat.i(75938);
    if ((paramInt == 606) || (paramInt == 602) || (paramInt == 601) || (paramInt == 704))
    {
      onServerException(paramInt);
      AppMethodBeat.o(75938);
      return;
    }
    onNetworkException(paramInt);
    AppMethodBeat.o(75938);
  }
  
  protected void onNetworkFinishedSuccess(AuthorizedResult paramAuthorizedResult)
  {
    AppMethodBeat.i(75937);
    this.mDownloadUrl = paramAuthorizedResult.downloadUrl;
    this.mSupportVersionCode = paramAuthorizedResult.versionCode;
    this.mHttpRequest = null;
    TMLog.i("OpensdkToMsdkManager", "onNetworkFinishedSuccess! authorizedResult.hasAuthoried=" + paramAuthorizedResult.hasAuthoried + "  listenner:" + this.mToMsdkListener + "  authroizedinfo:" + this.mAuthorizedInfo);
    if (paramAuthorizedResult.hasAuthoried == 1)
    {
      this.authorizedState = 2;
      if (paramAuthorizedResult.tipsInfo != null)
      {
        showDialog(paramAuthorizedResult.tipsInfo);
        AppMethodBeat.o(75937);
        return;
      }
      notifyAuthorizedFinished(true, this.mAuthorizedInfo);
      AppMethodBeat.o(75937);
      return;
    }
    this.authorizedState = 3;
    if (paramAuthorizedResult.tipsInfo != null)
    {
      showDialog(paramAuthorizedResult.tipsInfo);
      AppMethodBeat.o(75937);
      return;
    }
    onServerException(paramAuthorizedResult.errorCode);
    TMLog.i("OpensdkToMsdkManager", "not in white list and no tips!");
    AppMethodBeat.o(75937);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(75935);
    tryToCloseDialog();
    if (this.hasNotify)
    {
      AppMethodBeat.o(75935);
      return;
    }
    if (this.authorizedState == 2)
    {
      AppMethodBeat.o(75935);
      return;
    }
    if (((this.authorizedState == 3) || (this.authorizedState == 0)) && (this.mContext != null)) {
      getUserAuthorizedInfo(this.mAuthorizedInfo, this.mContext);
    }
    AppMethodBeat.o(75935);
  }
  
  protected void onServerException(int paramInt)
  {
    AppMethodBeat.i(75939);
    if (this.mContext == null)
    {
      AppMethodBeat.o(75939);
      return;
    }
    Object localObject2 = new Res(this.mContext);
    Object localObject1 = new TipsInfo();
    ((TipsInfo)localObject1).title = this.mContext.getString(((Res)localObject2).string("white_list_dlg_title"));
    if ((paramInt == 602) || (paramInt == 601)) {}
    for (((TipsInfo)localObject1).content = this.mContext.getString(((Res)localObject2).string("white_list_network_error"));; ((TipsInfo)localObject1).content = this.mContext.getString(((Res)localObject2).string("white_list_server_error")))
    {
      ArrayList localArrayList = new ArrayList();
      ActionButton localActionButton = new ActionButton();
      localActionButton.jumpType = 4;
      Object localObject3 = this.mContext.getString(((Res)localObject2).string("white_list_positive_retry_again"));
      localActionButton.textInstalled = ((String)localObject3);
      localActionButton.textUninstalled = ((String)localObject3);
      localObject3 = new ActionButton();
      ((ActionButton)localObject3).jumpType = 3;
      localObject2 = this.mContext.getString(((Res)localObject2).string("white_list_negtive"));
      ((ActionButton)localObject3).textInstalled = ((String)localObject2);
      ((ActionButton)localObject3).textUninstalled = ((String)localObject2);
      localArrayList.add(localActionButton);
      localArrayList.add(localObject3);
      ((TipsInfo)localObject1).actionButton = localArrayList;
      showDialog((TipsInfo)localObject1);
      this.mHttpRequest = null;
      this.mDownloadUrl = "";
      this.authorizedState = 3;
      localObject1 = TipsInfoReportManager.getInstance().createTipsInfoLog(this.mAuthorizedInfo);
      ((TipsInfoLog)localObject1).networkErrorTipsCount += 1;
      TipsInfoReportManager.getInstance().addLogData((JceStruct)localObject1);
      AppMethodBeat.o(75939);
      return;
    }
  }
  
  protected void pauseDownloadTask(String paramString)
  {
    AppMethodBeat.i(75952);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(75952);
      return;
    }
    if (this.mAuthorizedInfo == null)
    {
      AppMethodBeat.o(75952);
      return;
    }
    this.mSubMessageHandler.post(new TMOpenSDKToMsdkManager.8(this, paramString));
    AppMethodBeat.o(75952);
  }
  
  protected void showDialog(TipsInfo paramTipsInfo)
  {
    AppMethodBeat.i(75942);
    if (this.mContext == null)
    {
      AppMethodBeat.o(75942);
      return;
    }
    if ((this.dialog != null) && (this.dialog.isShowing()))
    {
      AppMethodBeat.o(75942);
      return;
    }
    if (((this.mContext instanceof Activity)) && (((Activity)this.mContext).isFinishing()))
    {
      TMLog.i("OpensdkToMsdkManager", "context is finishing!  context" + this.mContext);
      AppMethodBeat.o(75942);
      return;
    }
    Res localRes = new Res(this.mContext);
    if (paramTipsInfo != null)
    {
      ArrayList localArrayList = paramTipsInfo.actionButton;
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        this.dialog = new PopDialog(this.mContext, localRes.style("while_list_dialog"), localArrayList.size());
        this.dialog.show();
        this.dialog.setTitle(paramTipsInfo.title);
        this.dialog.setContent(paramTipsInfo.content);
        int i = 0;
        if (i < localArrayList.size())
        {
          paramTipsInfo = (ActionButton)localArrayList.get(i);
          if (paramTipsInfo.jumpType == 3)
          {
            this.dialog.setNegativeBtnText(paramTipsInfo.textInstalled);
            this.dialog.setNegativeBtnClickListener(this.negativeBtnListenner);
          }
          for (;;)
          {
            i += 1;
            break;
            if (paramTipsInfo.jumpType != 4) {
              break label283;
            }
            this.dialog.setPositiveBtnText(paramTipsInfo.textUninstalled);
            this.dialog.setPositiveBtnClickListener(this.retryBtnListener);
          }
          for (;;)
          {
            try
            {
              label283:
              int j = this.mOpenSDK.checkQQDownloaderInstalled(this.mSupportVersionCode);
              switch (j)
              {
              }
            }
            catch (Exception localException)
            {
              TipsInfoLog localTipsInfoLog;
              ab.printErrStackTrace("OpensdkToMsdkManager", localException, "", new Object[0]);
              continue;
              this.dialog.setPositiveBtnText(this.mContext.getString(localRes.string("white_list_positive_update")));
              continueDownload();
              continue;
              this.dialog.setPositiveBtnText(paramTipsInfo.textUninstalled);
              continueDownload();
              continue;
            }
            this.dialog.setPositiveBtnTag(paramTipsInfo);
            this.dialog.setPositiveBtnClickListener(this.positiveBtnListener);
            break;
            this.dialog.setPositiveBtnText(paramTipsInfo.textInstalled);
            localTipsInfoLog = TipsInfoReportManager.getInstance().createTipsInfoLog(this.mAuthorizedInfo);
            localTipsInfoLog.authorizedTipsCount += 1;
            TipsInfoReportManager.getInstance().addLogData(localTipsInfoLog);
          }
        }
      }
    }
    AppMethodBeat.o(75942);
  }
  
  protected void startDownloadTask(String paramString1, String paramString2)
  {
    AppMethodBeat.i(75951);
    if (TextUtils.isEmpty(paramString1))
    {
      AppMethodBeat.o(75951);
      return;
    }
    this.dialog.setPositiveBtnEnable(false);
    this.mSubMessageHandler.post(new TMOpenSDKToMsdkManager.7(this, paramString2, paramString1));
    AppMethodBeat.o(75951);
  }
  
  protected void startToQQDownloaderAuthorized(String paramString)
  {
    AppMethodBeat.i(75950);
    if (this.dialog.isShowing()) {
      this.dialog.dismiss();
    }
    this.mHttpRequest = null;
    this.isInstallFinished = false;
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(75950);
      return;
    }
    TipsInfoLog localTipsInfoLog = TipsInfoReportManager.getInstance().createTipsInfoLog(this.mAuthorizedInfo);
    localTipsInfoLog.authorizedBtnClickCount += 1;
    TipsInfoReportManager.getInstance().addLogData(localTipsInfoLog);
    if ((this.mContext != null) && (this.mOpenSDK != null)) {
      this.mOpenSDK.startToAuthorized(this.mContext, paramString);
    }
    AppMethodBeat.o(75950);
  }
  
  protected void tryToCloseDialog()
  {
    AppMethodBeat.i(75944);
    if (this.mOpenSDK == null)
    {
      AppMethodBeat.o(75944);
      return;
    }
    if (this.mContext == null)
    {
      AppMethodBeat.o(75944);
      return;
    }
    try
    {
      int i = this.mOpenSDK.checkQQDownloaderInstalled(this.mSupportVersionCode);
      if ((this.isInstallFinished) && (i == 0))
      {
        this.mHttpRequest = null;
        this.isInstallFinished = false;
        this.mDownloadUrl = null;
        if (this.dialog.isShowing()) {
          this.dialog.dismiss();
        }
        TMAssistantDownloadSDKManager.closeAllService(this.mContext);
        this.mClient = null;
        if (isExitsAction(this.insertActionId)) {
          this.mOpenSDK.startQQDownloader(this.mContext);
        }
      }
      AppMethodBeat.o(75944);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("OpensdkToMsdkManager", localException, "", new Object[0]);
      AppMethodBeat.o(75944);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tmassistantsdk.openSDK.opensdktomsdk.TMOpenSDKToMsdkManager
 * JD-Core Version:    0.7.0.1
 */