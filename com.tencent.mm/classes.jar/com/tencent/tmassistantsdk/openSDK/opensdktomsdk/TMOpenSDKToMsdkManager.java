package com.tencent.tmassistantsdk.openSDK.opensdktomsdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.qq.taf.jce.JceStruct;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
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
  protected int authorizedState = 0;
  protected PopDialog dialog = null;
  protected boolean hasNotify = false;
  protected long insertActionId = -1L;
  protected boolean isInstallFinished = false;
  protected TMOpenSDKAuthorizedInfo mAuthorizedInfo = null;
  protected TMAssistantDownloadSDKClient mClient = null;
  protected Context mContext = null;
  protected ITMAssistantDownloadSDKClientListener mDownloadSDKListener = new TMOpenSDKToMsdkManager.9(this);
  protected String mDownloadUrl = null;
  protected GetAuthorizedHttpRequest mHttpRequest = null;
  protected ah mMainMessageHandler = null;
  protected TMQQDownloaderOpenSDK mOpenSDK = null;
  protected IGetAuthorizedHttpRequestListenner mRequestListener = new TMOpenSDKToMsdkManager.2(this);
  protected ah mSubMessageHandler = null;
  protected HandlerThread mSubMessagehandlerThread = null;
  protected int mSupportVersionCode = 0;
  protected ITMOpenSDKToMsdkListener mToMsdkListener = null;
  protected View.OnClickListener negativeBtnListenner = new TMOpenSDKToMsdkManager.5(this);
  protected View.OnClickListener positiveBtnListener = new TMOpenSDKToMsdkManager.6(this);
  protected View.OnClickListener retryBtnListener = new TMOpenSDKToMsdkManager.4(this);
  protected TMAssistantSDKChannel sdkChannel = null;
  
  private TMOpenSDKToMsdkManager(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public static String about()
  {
    return "TMOpenSDKToMsdkManager_2014_04_01_19_51_release_25434";
  }
  
  public static TMOpenSDKToMsdkManager getInstance(Context paramContext)
  {
    try
    {
      if (mInstance == null) {
        mInstance = new TMOpenSDKToMsdkManager(paramContext);
      }
      paramContext = mInstance;
      return paramContext;
    }
    finally {}
  }
  
  protected void continueDownload()
  {
    this.mSubMessageHandler.post(new TMOpenSDKToMsdkManager.3(this));
  }
  
  protected TMAssistantDownloadSDKClient getClient()
  {
    if (this.mContext != null)
    {
      if (this.mClient == null)
      {
        TMAssistantDownloadSDKClient localTMAssistantDownloadSDKClient = TMAssistantDownloadSDKManager.getInstance(this.mContext).getDownloadSDKClient("downloadSDKClient");
        localTMAssistantDownloadSDKClient.registerDownloadTaskListener(this.mDownloadSDKListener);
        this.mClient = localTMAssistantDownloadSDKClient;
        return localTMAssistantDownloadSDKClient;
      }
      return this.mClient;
    }
    return null;
  }
  
  public void getUserAuthorizedInfo(TMOpenSDKAuthorizedInfo paramTMOpenSDKAuthorizedInfo, Context paramContext)
  {
    if (paramContext != null) {
      this.mContext = paramContext;
    }
    TMLog.i("OpensdkToMsdkManager", "getUserAuthorizedInfo method called!");
    this.hasNotify = false;
    if (this.mHttpRequest != null) {
      TMLog.i("OpensdkToMsdkManager", "mHttpRequest != null, request didn't finish!");
    }
    do
    {
      return;
      if (paramTMOpenSDKAuthorizedInfo == null) {
        break;
      }
      this.mAuthorizedInfo = paramTMOpenSDKAuthorizedInfo;
    } while (this.mHttpRequest != null);
    this.authorizedState = 1;
    this.mHttpRequest = new GetAuthorizedHttpRequest();
    this.mHttpRequest.setListenner(this.mRequestListener);
    this.mHttpRequest.sendRequest(paramTMOpenSDKAuthorizedInfo);
    return;
    TMLog.i("OpensdkToMsdkManager", "AuthorizedInfo object is null!");
  }
  
  protected void handleDownloadContinue(long paramLong1, long paramLong2)
  {
    if (this.mContext == null) {
      TMLog.i("OpensdkToMsdkManager", "handleDownloading context = null!");
    }
    Res localRes;
    do
    {
      return;
      localRes = new Res(this.mContext);
      String str1 = this.mContext.getString(localRes.string("white_list_positive_continue"));
      String str2 = "(" + (int)(((float)(100L * paramLong1) + 0.0F) / (float)paramLong2) + "%)";
      this.dialog.downloadText.setText(str1 + str2);
      this.dialog.downloadProgressBar.setProgress((int)(((float)paramLong1 + 0.0F) / (float)paramLong2 * this.dialog.downloadProgressBar.getMax()));
    } while (this.dialog.downloadProgressBar.getProgress() <= 0);
    this.dialog.setPositiveBtnBgResource(localRes.drawable("com_tencent_tmassistant_sdk_button_bg"));
  }
  
  protected void handleDownloadFailed()
  {
    if (this.mContext == null) {
      TMLog.i("OpensdkToMsdkManager", "handleDownloading context = null!");
    }
    Res localRes;
    do
    {
      return;
      localRes = new Res(this.mContext);
      this.dialog.setPositiveBtnEnable(true);
      this.dialog.downloadText.setText(this.mContext.getString(localRes.string("white_list_positive_retry")));
    } while (this.dialog.downloadProgressBar.getProgress() <= 0);
    this.dialog.setPositiveBtnBgResource(localRes.drawable("com_tencent_tmassistant_sdk_button_bg"));
  }
  
  protected void handleDownloading(long paramLong1, long paramLong2)
  {
    if (this.mContext == null)
    {
      TMLog.i("OpensdkToMsdkManager", "handleDownloading context = null!");
      return;
    }
    Object localObject = new Res(this.mContext);
    localObject = this.mContext.getString(((Res)localObject).string("white_list_positive_downloading"));
    String str = "(" + (int)(((float)(100L * paramLong1) + 0.0F) / (float)paramLong2) + "%)";
    this.dialog.downloadText.setText((String)localObject + str);
    this.dialog.downloadProgressBar.setProgress((int)(((float)paramLong1 + 0.0F) / (float)paramLong2 * this.dialog.downloadProgressBar.getMax()));
    TMLog.i("OpensdkToMsdkManager", "handleDownloading : receivedlen:" + paramLong1 + " | totalLen:" + paramLong2);
  }
  
  protected void handleInstall(String paramString, int paramInt)
  {
    if (this.mContext == null) {}
    do
    {
      return;
      localObject = new Res(this.mContext);
      this.dialog.setPositiveBtnEnable(true);
      this.dialog.downloadText.setText(this.mContext.getString(((Res)localObject).string("white_list_positive_install")));
      if (this.mContext == null)
      {
        TMLog.i("OpensdkToMsdkManager", "handleDownloading context = null!");
        return;
      }
      this.isInstallFinished = true;
    } while (paramInt == 1);
    Object localObject = new Intent("android.intent.action.VIEW");
    ((Intent)localObject).setDataAndType(Uri.fromFile(new File(paramString)), "application/vnd.android.package-archive");
    this.mContext.startActivity((Intent)localObject);
  }
  
  public void initOpenSDK(ITMOpenSDKToMsdkListener paramITMOpenSDKToMsdkListener)
  {
    this.mOpenSDK = TMQQDownloaderOpenSDK.getInstance();
    this.mOpenSDK.initQQDownloaderOpenSDK(this.mContext);
    this.mToMsdkListener = paramITMOpenSDKToMsdkListener;
    this.sdkChannel = new TMAssistantSDKChannel();
    this.mSubMessagehandlerThread = new HandlerThread("OpenSDKToMsdkManager");
    this.mSubMessagehandlerThread.start();
    this.mSubMessageHandler = new ah(this.mSubMessagehandlerThread.getLooper());
    this.mMainMessageHandler = new ah(Looper.getMainLooper(), new TMOpenSDKToMsdkManager.1(this));
  }
  
  protected boolean isExitsAction(long paramLong)
  {
    if (paramLong < 0L) {
      return false;
    }
    if (this.sdkChannel == null) {
      return false;
    }
    Iterator localIterator = this.sdkChannel.getChannelDataItemList().iterator();
    while (localIterator.hasNext())
    {
      TMAssistantSDKChannelDataItem localTMAssistantSDKChannelDataItem = (TMAssistantSDKChannelDataItem)localIterator.next();
      if ((localTMAssistantSDKChannelDataItem.mDBIdentity == paramLong) && (localTMAssistantSDKChannelDataItem.mDataItemEndTime - localTMAssistantSDKChannelDataItem.mDataItemStartTime <= 300000L)) {
        return true;
      }
    }
    return false;
  }
  
  protected void notifyAuthorizedFinished(boolean paramBoolean, TMOpenSDKAuthorizedInfo paramTMOpenSDKAuthorizedInfo)
  {
    TMLog.i("OpensdkToMsdkManager", "before realy notifyAuthorizedFinished: TMOpenSDKAuthorizedInfo:" + this.mAuthorizedInfo);
    if (this.mToMsdkListener == null) {
      TMLog.i("OpensdkToMsdkManager", "before notifyAuthorizedFinished: mToMsdkListener = null !");
    }
    if ((this.mToMsdkListener != null) && (this.mAuthorizedInfo != null))
    {
      TMLog.i("OpensdkToMsdkManager", "notifyAuthorizedFinished: result:" + paramBoolean);
      this.mToMsdkListener.onAuthorizedFinished(paramBoolean, this.mAuthorizedInfo);
      this.mHttpRequest = null;
      this.hasNotify = true;
    }
  }
  
  public void onDestroy()
  {
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
  }
  
  protected void onNetworkException(int paramInt)
  {
    if (this.mContext == null) {
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
      return;
    }
  }
  
  protected void onNetworkFinishedFailed(int paramInt)
  {
    if ((paramInt == 606) || (paramInt == 602) || (paramInt == 601) || (paramInt == 704))
    {
      onServerException(paramInt);
      return;
    }
    onNetworkException(paramInt);
  }
  
  protected void onNetworkFinishedSuccess(AuthorizedResult paramAuthorizedResult)
  {
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
        return;
      }
      notifyAuthorizedFinished(true, this.mAuthorizedInfo);
      return;
    }
    this.authorizedState = 3;
    if (paramAuthorizedResult.tipsInfo != null)
    {
      showDialog(paramAuthorizedResult.tipsInfo);
      return;
    }
    onServerException(paramAuthorizedResult.errorCode);
    TMLog.i("OpensdkToMsdkManager", "not in white list and no tips!");
  }
  
  public void onResume()
  {
    tryToCloseDialog();
    if (this.hasNotify) {}
    while ((this.authorizedState == 2) || ((this.authorizedState != 3) && (this.authorizedState != 0)) || (this.mContext == null)) {
      return;
    }
    getUserAuthorizedInfo(this.mAuthorizedInfo, this.mContext);
  }
  
  protected void onServerException(int paramInt)
  {
    if (this.mContext == null) {
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
      return;
    }
  }
  
  protected void pauseDownloadTask(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (this.mAuthorizedInfo == null) {
      return;
    }
    this.mSubMessageHandler.post(new TMOpenSDKToMsdkManager.8(this, paramString));
  }
  
  protected void showDialog(TipsInfo paramTipsInfo)
  {
    if (this.mContext == null) {}
    ArrayList localArrayList;
    do
    {
      do
      {
        do
        {
          return;
        } while ((this.dialog != null) && (this.dialog.isShowing()));
        if (((this.mContext instanceof Activity)) && (((Activity)this.mContext).isFinishing()))
        {
          TMLog.i("OpensdkToMsdkManager", "context is finishing!  context" + this.mContext);
          return;
        }
        localRes = new Res(this.mContext);
      } while (paramTipsInfo == null);
      localArrayList = paramTipsInfo.actionButton;
    } while ((localArrayList == null) || (localArrayList.size() <= 0));
    this.dialog = new PopDialog(this.mContext, localRes.style("while_list_dialog"), localArrayList.size());
    this.dialog.show();
    this.dialog.setTitle(paramTipsInfo.title);
    this.dialog.setContent(paramTipsInfo.content);
    int i = 0;
    label169:
    if (i < localArrayList.size())
    {
      paramTipsInfo = (ActionButton)localArrayList.get(i);
      if (paramTipsInfo.jumpType != 3) {
        break label225;
      }
      this.dialog.setNegativeBtnText(paramTipsInfo.textInstalled);
      this.dialog.setNegativeBtnClickListener(this.negativeBtnListenner);
    }
    for (;;)
    {
      i += 1;
      break label169;
      break;
      label225:
      if (paramTipsInfo.jumpType != 4) {
        break label258;
      }
      this.dialog.setPositiveBtnText(paramTipsInfo.textUninstalled);
      this.dialog.setPositiveBtnClickListener(this.retryBtnListener);
    }
    for (;;)
    {
      try
      {
        label258:
        int j = this.mOpenSDK.checkQQDownloaderInstalled(this.mSupportVersionCode);
        switch (j)
        {
        }
      }
      catch (Exception localException)
      {
        TipsInfoLog localTipsInfoLog;
        y.printErrStackTrace("OpensdkToMsdkManager", localException, "", new Object[0]);
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
  
  protected void startDownloadTask(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    this.dialog.setPositiveBtnEnable(false);
    this.mSubMessageHandler.post(new TMOpenSDKToMsdkManager.7(this, paramString2, paramString1));
  }
  
  protected void startToQQDownloaderAuthorized(String paramString)
  {
    if (this.dialog.isShowing()) {
      this.dialog.dismiss();
    }
    this.mHttpRequest = null;
    this.isInstallFinished = false;
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      TipsInfoLog localTipsInfoLog = TipsInfoReportManager.getInstance().createTipsInfoLog(this.mAuthorizedInfo);
      localTipsInfoLog.authorizedBtnClickCount += 1;
      TipsInfoReportManager.getInstance().addLogData(localTipsInfoLog);
    } while ((this.mContext == null) || (this.mOpenSDK == null));
    this.mOpenSDK.startToAuthorized(this.mContext, paramString);
  }
  
  protected void tryToCloseDialog()
  {
    if (this.mOpenSDK == null) {}
    for (;;)
    {
      return;
      if (this.mContext != null) {
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
            if (isExitsAction(this.insertActionId))
            {
              this.mOpenSDK.startQQDownloader(this.mContext);
              return;
            }
          }
        }
        catch (Exception localException)
        {
          y.printErrStackTrace("OpensdkToMsdkManager", localException, "", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tmassistantsdk.openSDK.opensdktomsdk.TMOpenSDKToMsdkManager
 * JD-Core Version:    0.7.0.1
 */