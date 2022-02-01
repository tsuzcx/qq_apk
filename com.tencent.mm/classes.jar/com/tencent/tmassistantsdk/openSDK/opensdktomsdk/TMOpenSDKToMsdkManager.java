package com.tencent.tmassistantsdk.openSDK.opensdktomsdk;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.model.app.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import com.tencent.tmassistantsdk.channel.TMAssistantSDKChannel;
import com.tencent.tmassistantsdk.channel.TMAssistantSDKChannelDataItem;
import com.tencent.tmassistantsdk.downloadclient.ITMAssistantDownloadSDKClientListener;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClient;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKManager;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;
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
  protected MMHandler mMainMessageHandler;
  protected TMQQDownloaderOpenSDK mOpenSDK;
  protected IGetAuthorizedHttpRequestListenner mRequestListener;
  protected MMHandler mSubMessageHandler;
  protected HandlerThread mSubMessagehandlerThread;
  protected int mSupportVersionCode;
  protected ITMOpenSDKToMsdkListener mToMsdkListener;
  protected View.OnClickListener negativeBtnListenner;
  protected View.OnClickListener positiveBtnListener;
  protected View.OnClickListener retryBtnListener;
  protected TMAssistantSDKChannel sdkChannel;
  
  private TMOpenSDKToMsdkManager(Context paramContext)
  {
    AppMethodBeat.i(102177);
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
    this.mRequestListener = new IGetAuthorizedHttpRequestListenner()
    {
      public void onGetAuthorizedRequestFinished(AuthorizedResult paramAnonymousAuthorizedResult, int paramAnonymousInt)
      {
        AppMethodBeat.i(102167);
        Message localMessage = new Message();
        if (paramAnonymousInt == 0)
        {
          if (paramAnonymousAuthorizedResult == null)
          {
            AppMethodBeat.o(102167);
            return;
          }
          localMessage.what = 4;
        }
        for (localMessage.obj = paramAnonymousAuthorizedResult;; localMessage.obj = Integer.valueOf(paramAnonymousInt))
        {
          TMOpenSDKToMsdkManager.this.mMainMessageHandler.sendMessage(localMessage);
          AppMethodBeat.o(102167);
          return;
          localMessage.what = 5;
        }
      }
    };
    this.retryBtnListener = new View.OnClickListener()
    {
      private byte _hellAccFlag_;
      
      public void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(102169);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/tmassistantsdk/openSDK/opensdktomsdk/TMOpenSDKToMsdkManager$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (TMOpenSDKToMsdkManager.this.mAuthorizedInfo == null)
        {
          a.a(this, "com/tencent/tmassistantsdk/openSDK/opensdktomsdk/TMOpenSDKToMsdkManager$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(102169);
          return;
        }
        if (TMOpenSDKToMsdkManager.this.mContext != null) {
          TMOpenSDKToMsdkManager.this.getUserAuthorizedInfo(TMOpenSDKToMsdkManager.this.mAuthorizedInfo, TMOpenSDKToMsdkManager.this.mContext);
        }
        TMOpenSDKToMsdkManager.this.dialog.dismiss();
        a.a(this, "com/tencent/tmassistantsdk/openSDK/opensdktomsdk/TMOpenSDKToMsdkManager$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(102169);
      }
    };
    this.negativeBtnListenner = new View.OnClickListener()
    {
      private byte _hellAccFlag_;
      
      public void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(102170);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/tmassistantsdk/openSDK/opensdktomsdk/TMOpenSDKToMsdkManager$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (TMOpenSDKToMsdkManager.this.dialog.isShowing())
        {
          TMOpenSDKToMsdkManager.this.dialog.dismiss();
          TMOpenSDKToMsdkManager.this.mHttpRequest = null;
        }
        paramAnonymousView = TipsInfoReportManager.getInstance().createTipsInfoLog(TMOpenSDKToMsdkManager.this.mAuthorizedInfo);
        paramAnonymousView.cancelBtnClickCount += 1;
        TipsInfoReportManager.getInstance().addLogData(paramAnonymousView);
        try
        {
          if (TMOpenSDKToMsdkManager.this.mClient != null) {
            TMOpenSDKToMsdkManager.this.pauseDownloadTask(TMOpenSDKToMsdkManager.this.mDownloadUrl);
          }
          if (TMOpenSDKToMsdkManager.this.authorizedState == 2)
          {
            TMOpenSDKToMsdkManager.this.notifyAuthorizedFinished(true, TMOpenSDKToMsdkManager.this.mAuthorizedInfo);
            a.a(this, "com/tencent/tmassistantsdk/openSDK/opensdktomsdk/TMOpenSDKToMsdkManager$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(102170);
            return;
          }
        }
        catch (Exception paramAnonymousView)
        {
          for (;;)
          {
            Log.printErrStackTrace("OpensdkToMsdkManager", paramAnonymousView, "", new Object[0]);
            continue;
            TMOpenSDKToMsdkManager.this.notifyAuthorizedFinished(false, TMOpenSDKToMsdkManager.this.mAuthorizedInfo);
          }
        }
      }
    };
    this.positiveBtnListener = new View.OnClickListener()
    {
      private byte _hellAccFlag_;
      
      public void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(102171);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/tmassistantsdk/openSDK/opensdktomsdk/TMOpenSDKToMsdkManager$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (TMOpenSDKToMsdkManager.this.mContext == null)
        {
          a.a(this, "com/tencent/tmassistantsdk/openSDK/opensdktomsdk/TMOpenSDKToMsdkManager$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(102171);
          return;
        }
        paramAnonymousView = (ActionButton)paramAnonymousView.getTag();
        for (;;)
        {
          try
          {
            int i = TMOpenSDKToMsdkManager.this.mOpenSDK.checkQQDownloaderInstalled(TMOpenSDKToMsdkManager.this.mSupportVersionCode);
            switch (i)
            {
            }
          }
          catch (Exception paramAnonymousView)
          {
            Log.printErrStackTrace("OpensdkToMsdkManager", paramAnonymousView, "", new Object[0]);
            continue;
            TMOpenSDKToMsdkManager.this.startDownloadTask(TMOpenSDKToMsdkManager.this.mDownloadUrl, paramAnonymousView.jumpUrl);
            continue;
            TMOpenSDKToMsdkManager.this.startDownloadTask(TMOpenSDKToMsdkManager.this.mDownloadUrl, paramAnonymousView.jumpUrl);
            continue;
          }
          a.a(this, "com/tencent/tmassistantsdk/openSDK/opensdktomsdk/TMOpenSDKToMsdkManager$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(102171);
          return;
          try
          {
            TMOpenSDKToMsdkManager.this.startToQQDownloaderAuthorized(paramAnonymousView.jumpUrl);
          }
          catch (Exception paramAnonymousView)
          {
            Log.printErrStackTrace("OpensdkToMsdkManager", paramAnonymousView, "", new Object[0]);
          }
        }
      }
    };
    this.mDownloadSDKListener = new TMOpenSDKToMsdkManager.9(this);
    this.mContext = paramContext;
    AppMethodBeat.o(102177);
  }
  
  public static String about()
  {
    return "TMOpenSDKToMsdkManager_2014_04_01_19_51_release_25434";
  }
  
  public static TMOpenSDKToMsdkManager getInstance(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(102178);
      if (mInstance == null) {
        mInstance = new TMOpenSDKToMsdkManager(paramContext);
      }
      paramContext = mInstance;
      AppMethodBeat.o(102178);
      return paramContext;
    }
    finally {}
  }
  
  protected void continueDownload()
  {
    AppMethodBeat.i(102189);
    this.mSubMessageHandler.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(102168);
        try
        {
          Object localObject = TMOpenSDKToMsdkManager.this.getClient().getDownloadTaskState(TMOpenSDKToMsdkManager.this.mDownloadUrl);
          Message localMessage;
          if (localObject != null)
          {
            if (((TMAssistantDownloadTaskInfo)localObject).mState != 3) {
              break label143;
            }
            localMessage = new Message();
            localMessage.what = 6;
            Bundle localBundle = new Bundle();
            localBundle.putLong("receiveDataLen", ((TMAssistantDownloadTaskInfo)localObject).mReceiveDataLen);
            localBundle.putLong("totalDataLen", ((TMAssistantDownloadTaskInfo)localObject).mTotalDataLen);
            localMessage.setData(localBundle);
            TMOpenSDKToMsdkManager.this.mMainMessageHandler.sendMessage(localMessage);
          }
          while ((localObject != null) && (((TMAssistantDownloadTaskInfo)localObject).mState == 4))
          {
            localObject = TipsInfoReportManager.getInstance().createTipsInfoLog(TMOpenSDKToMsdkManager.this.mAuthorizedInfo);
            ((TipsInfoLog)localObject).installTipsCount += 1;
            TipsInfoReportManager.getInstance().addLogData((JceStruct)localObject);
            AppMethodBeat.o(102168);
            return;
            label143:
            if (((TMAssistantDownloadTaskInfo)localObject).mState == 4)
            {
              localMessage = new Message();
              localMessage.what = 0;
              localMessage.arg1 = 1;
              localMessage.obj = ((TMAssistantDownloadTaskInfo)localObject).mSavePath;
              TMOpenSDKToMsdkManager.this.mMainMessageHandler.sendMessage(localMessage);
            }
          }
          localTipsInfoLog = TipsInfoReportManager.getInstance().createTipsInfoLog(TMOpenSDKToMsdkManager.this.mAuthorizedInfo);
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace("OpensdkToMsdkManager", localException, "", new Object[0]);
          AppMethodBeat.o(102168);
          return;
        }
        TipsInfoLog localTipsInfoLog;
        localTipsInfoLog.downloadTipsCount += 1;
        TipsInfoReportManager.getInstance().addLogData(localTipsInfoLog);
        AppMethodBeat.o(102168);
      }
    });
    AppMethodBeat.o(102189);
  }
  
  protected TMAssistantDownloadSDKClient getClient()
  {
    AppMethodBeat.i(102199);
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
        AppMethodBeat.o(102199);
        return localTMAssistantDownloadSDKClient;
        localTMAssistantDownloadSDKClient = this.mClient;
      }
    }
    AppMethodBeat.o(102199);
    return null;
  }
  
  public void getUserAuthorizedInfo(TMOpenSDKAuthorizedInfo paramTMOpenSDKAuthorizedInfo, Context paramContext)
  {
    AppMethodBeat.i(102182);
    if (paramContext != null) {
      this.mContext = paramContext;
    }
    TMLog.i("OpensdkToMsdkManager", "getUserAuthorizedInfo method called!");
    this.hasNotify = false;
    if (this.mHttpRequest != null)
    {
      TMLog.i("OpensdkToMsdkManager", "mHttpRequest != null, request didn't finish!");
      AppMethodBeat.o(102182);
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
        AppMethodBeat.o(102182);
      }
    }
    else
    {
      TMLog.i("OpensdkToMsdkManager", "AuthorizedInfo object is null!");
    }
    AppMethodBeat.o(102182);
  }
  
  protected void handleDownloadContinue(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(102195);
    if (this.mContext == null)
    {
      TMLog.i("OpensdkToMsdkManager", "handleDownloading context = null!");
      AppMethodBeat.o(102195);
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
    AppMethodBeat.o(102195);
  }
  
  protected void handleDownloadFailed()
  {
    AppMethodBeat.i(102193);
    if (this.mContext == null)
    {
      TMLog.i("OpensdkToMsdkManager", "handleDownloading context = null!");
      AppMethodBeat.o(102193);
      return;
    }
    Res localRes = new Res(this.mContext);
    this.dialog.setPositiveBtnEnable(true);
    this.dialog.downloadText.setText(this.mContext.getString(localRes.string("white_list_positive_retry")));
    if (this.dialog.downloadProgressBar.getProgress() > 0) {
      this.dialog.setPositiveBtnBgResource(localRes.drawable("com_tencent_tmassistant_sdk_button_bg"));
    }
    AppMethodBeat.o(102193);
  }
  
  protected void handleDownloading(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(102194);
    if (this.mContext == null)
    {
      TMLog.i("OpensdkToMsdkManager", "handleDownloading context = null!");
      AppMethodBeat.o(102194);
      return;
    }
    Object localObject = new Res(this.mContext);
    localObject = this.mContext.getString(((Res)localObject).string("white_list_positive_downloading"));
    String str = "(" + (int)(((float)(100L * paramLong1) + 0.0F) / (float)paramLong2) + "%)";
    this.dialog.downloadText.setText((String)localObject + str);
    this.dialog.downloadProgressBar.setProgress((int)(((float)paramLong1 + 0.0F) / (float)paramLong2 * this.dialog.downloadProgressBar.getMax()));
    TMLog.i("OpensdkToMsdkManager", "handleDownloading : receivedlen:" + paramLong1 + " | totalLen:" + paramLong2);
    AppMethodBeat.o(102194);
  }
  
  protected void handleInstall(String paramString, int paramInt)
  {
    AppMethodBeat.i(102192);
    if (this.mContext == null)
    {
      AppMethodBeat.o(102192);
      return;
    }
    Res localRes = new Res(this.mContext);
    this.dialog.setPositiveBtnEnable(true);
    this.dialog.downloadText.setText(this.mContext.getString(localRes.string("white_list_positive_install")));
    if (this.mContext == null)
    {
      TMLog.i("OpensdkToMsdkManager", "handleDownloading context = null!");
      AppMethodBeat.o(102192);
      return;
    }
    this.isInstallFinished = true;
    if (paramInt == 1)
    {
      AppMethodBeat.o(102192);
      return;
    }
    v.b(this.mContext, paramString, null, false);
    AppMethodBeat.o(102192);
  }
  
  public void initOpenSDK(ITMOpenSDKToMsdkListener paramITMOpenSDKToMsdkListener)
  {
    AppMethodBeat.i(102179);
    this.mOpenSDK = TMQQDownloaderOpenSDK.getInstance();
    this.mOpenSDK.initQQDownloaderOpenSDK(this.mContext);
    this.mToMsdkListener = paramITMOpenSDKToMsdkListener;
    this.sdkChannel = new TMAssistantSDKChannel();
    this.mSubMessageHandler = new MMHandler("OpenSDKToMsdkManager");
    this.mMainMessageHandler = new MMHandler(Looper.getMainLooper(), new MMHandler.Callback()
    {
      public boolean handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(102166);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(102166);
          return false;
          paramAnonymousMessage = (AuthorizedResult)paramAnonymousMessage.obj;
          if (paramAnonymousMessage != null)
          {
            TMOpenSDKToMsdkManager.this.onNetworkFinishedSuccess(paramAnonymousMessage);
            continue;
            int i = ((Integer)paramAnonymousMessage.obj).intValue();
            TMOpenSDKToMsdkManager.this.onNetworkFinishedFailed(i);
            continue;
            i = paramAnonymousMessage.arg1;
            paramAnonymousMessage = paramAnonymousMessage.obj.toString();
            TMOpenSDKToMsdkManager.this.handleInstall(paramAnonymousMessage, i);
            continue;
            paramAnonymousMessage = paramAnonymousMessage.getData();
            if (paramAnonymousMessage != null)
            {
              TMOpenSDKToMsdkManager.this.handleDownloading(paramAnonymousMessage.getLong("receiveDataLen"), paramAnonymousMessage.getLong("totalDataLen"));
              continue;
              paramAnonymousMessage = paramAnonymousMessage.getData();
              if (paramAnonymousMessage != null)
              {
                TMOpenSDKToMsdkManager.this.handleDownloadContinue(paramAnonymousMessage.getLong("receiveDataLen"), paramAnonymousMessage.getLong("totalDataLen"));
                continue;
                TMOpenSDKToMsdkManager.this.handleDownloadFailed();
              }
            }
          }
        }
      }
    });
    AppMethodBeat.o(102179);
  }
  
  protected boolean isExitsAction(long paramLong)
  {
    AppMethodBeat.i(102191);
    if (paramLong < 0L)
    {
      AppMethodBeat.o(102191);
      return false;
    }
    if (this.sdkChannel == null)
    {
      AppMethodBeat.o(102191);
      return false;
    }
    Iterator localIterator = this.sdkChannel.getChannelDataItemList().iterator();
    while (localIterator.hasNext())
    {
      TMAssistantSDKChannelDataItem localTMAssistantSDKChannelDataItem = (TMAssistantSDKChannelDataItem)localIterator.next();
      if ((localTMAssistantSDKChannelDataItem.mDBIdentity == paramLong) && (localTMAssistantSDKChannelDataItem.mDataItemEndTime - localTMAssistantSDKChannelDataItem.mDataItemStartTime <= 300000L))
      {
        AppMethodBeat.o(102191);
        return true;
      }
    }
    AppMethodBeat.o(102191);
    return false;
  }
  
  protected void notifyAuthorizedFinished(boolean paramBoolean, TMOpenSDKAuthorizedInfo paramTMOpenSDKAuthorizedInfo)
  {
    AppMethodBeat.i(102187);
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
    AppMethodBeat.o(102187);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(102180);
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
    AppMethodBeat.o(102180);
  }
  
  protected void onNetworkException(int paramInt)
  {
    AppMethodBeat.i(102186);
    if (this.mContext == null)
    {
      AppMethodBeat.o(102186);
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
      AppMethodBeat.o(102186);
      return;
    }
  }
  
  protected void onNetworkFinishedFailed(int paramInt)
  {
    AppMethodBeat.i(102184);
    if ((paramInt == 606) || (paramInt == 602) || (paramInt == 601) || (paramInt == 704))
    {
      onServerException(paramInt);
      AppMethodBeat.o(102184);
      return;
    }
    onNetworkException(paramInt);
    AppMethodBeat.o(102184);
  }
  
  protected void onNetworkFinishedSuccess(AuthorizedResult paramAuthorizedResult)
  {
    AppMethodBeat.i(102183);
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
        AppMethodBeat.o(102183);
        return;
      }
      notifyAuthorizedFinished(true, this.mAuthorizedInfo);
      AppMethodBeat.o(102183);
      return;
    }
    this.authorizedState = 3;
    if (paramAuthorizedResult.tipsInfo != null)
    {
      showDialog(paramAuthorizedResult.tipsInfo);
      AppMethodBeat.o(102183);
      return;
    }
    onServerException(paramAuthorizedResult.errorCode);
    TMLog.i("OpensdkToMsdkManager", "not in white list and no tips!");
    AppMethodBeat.o(102183);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(102181);
    tryToCloseDialog();
    if (this.hasNotify)
    {
      AppMethodBeat.o(102181);
      return;
    }
    if (this.authorizedState == 2)
    {
      AppMethodBeat.o(102181);
      return;
    }
    if (((this.authorizedState == 3) || (this.authorizedState == 0)) && (this.mContext != null)) {
      getUserAuthorizedInfo(this.mAuthorizedInfo, this.mContext);
    }
    AppMethodBeat.o(102181);
  }
  
  protected void onServerException(int paramInt)
  {
    AppMethodBeat.i(102185);
    if (this.mContext == null)
    {
      AppMethodBeat.o(102185);
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
      AppMethodBeat.o(102185);
      return;
    }
  }
  
  protected void pauseDownloadTask(String paramString)
  {
    AppMethodBeat.i(102198);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(102198);
      return;
    }
    if (this.mAuthorizedInfo == null)
    {
      AppMethodBeat.o(102198);
      return;
    }
    this.mSubMessageHandler.post(new TMOpenSDKToMsdkManager.8(this, paramString));
    AppMethodBeat.o(102198);
  }
  
  protected void showDialog(TipsInfo paramTipsInfo)
  {
    AppMethodBeat.i(102188);
    if (this.mContext == null)
    {
      AppMethodBeat.o(102188);
      return;
    }
    if ((this.dialog != null) && (this.dialog.isShowing()))
    {
      AppMethodBeat.o(102188);
      return;
    }
    if (((this.mContext instanceof Activity)) && (((Activity)this.mContext).isFinishing()))
    {
      TMLog.i("OpensdkToMsdkManager", "context is finishing!  context" + this.mContext);
      AppMethodBeat.o(102188);
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
              Log.printErrStackTrace("OpensdkToMsdkManager", localException, "", new Object[0]);
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
    AppMethodBeat.o(102188);
  }
  
  protected void startDownloadTask(final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(102197);
    if (TextUtils.isEmpty(paramString1))
    {
      AppMethodBeat.o(102197);
      return;
    }
    this.dialog.setPositiveBtnEnable(false);
    this.mSubMessageHandler.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(102172);
        if ((TMOpenSDKToMsdkManager.this.mContext != null) && (TMOpenSDKToMsdkManager.this.mOpenSDK != null) && (!TextUtils.isEmpty(paramString2))) {
          TMOpenSDKToMsdkManager.this.insertActionId = TMOpenSDKToMsdkManager.this.mOpenSDK.addDownloadTaskFromAuthorize(paramString2);
        }
        Object localObject1 = TMOpenSDKToMsdkManager.this.getClient();
        if (localObject1 == null)
        {
          AppMethodBeat.o(102172);
          return;
        }
        for (;;)
        {
          int i;
          try
          {
            i = ((TMAssistantDownloadSDKClient)localObject1).startDownloadTask(paramString1, "application/vnd.android.package-archive");
            if (4 == i)
            {
              localObject1 = ((TMAssistantDownloadSDKClient)localObject1).getDownloadTaskState(paramString1).mSavePath;
              Message localMessage = new Message();
              localMessage.what = 0;
              localMessage.obj = localObject1;
              TMOpenSDKToMsdkManager.this.mMainMessageHandler.sendMessage(localMessage);
              if (i != 4) {
                break;
              }
              localObject1 = TipsInfoReportManager.getInstance().createTipsInfoLog(TMOpenSDKToMsdkManager.this.mAuthorizedInfo);
              ((TipsInfoLog)localObject1).installBtnClickCount += 1;
              TipsInfoReportManager.getInstance().addLogData((JceStruct)localObject1);
              AppMethodBeat.o(102172);
              return;
            }
          }
          catch (Exception localException)
          {
            Log.printErrStackTrace("OpensdkToMsdkManager", localException, "", new Object[0]);
            AppMethodBeat.o(102172);
            return;
          }
          if (i == 0)
          {
            TMLog.i("OpensdkToMsdkManager", "start success!");
          }
          else if (1 == i)
          {
            localObject2 = new Message();
            ((Message)localObject2).what = 5;
            ((Message)localObject2).obj = Integer.valueOf(1);
            TMOpenSDKToMsdkManager.this.mMainMessageHandler.sendMessage((Message)localObject2);
          }
          else
          {
            localObject2 = new Message();
            ((Message)localObject2).what = 3;
            TMOpenSDKToMsdkManager.this.mMainMessageHandler.sendMessage((Message)localObject2);
          }
        }
        Object localObject2 = TipsInfoReportManager.getInstance().createTipsInfoLog(TMOpenSDKToMsdkManager.this.mAuthorizedInfo);
        ((TipsInfoLog)localObject2).downloadBtnClickCount += 1;
        TipsInfoReportManager.getInstance().addLogData((JceStruct)localObject2);
        AppMethodBeat.o(102172);
      }
    });
    AppMethodBeat.o(102197);
  }
  
  protected void startToQQDownloaderAuthorized(String paramString)
  {
    AppMethodBeat.i(102196);
    if (this.dialog.isShowing()) {
      this.dialog.dismiss();
    }
    this.mHttpRequest = null;
    this.isInstallFinished = false;
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(102196);
      return;
    }
    TipsInfoLog localTipsInfoLog = TipsInfoReportManager.getInstance().createTipsInfoLog(this.mAuthorizedInfo);
    localTipsInfoLog.authorizedBtnClickCount += 1;
    TipsInfoReportManager.getInstance().addLogData(localTipsInfoLog);
    if ((this.mContext != null) && (this.mOpenSDK != null)) {
      this.mOpenSDK.startToAuthorized(this.mContext, paramString);
    }
    AppMethodBeat.o(102196);
  }
  
  protected void tryToCloseDialog()
  {
    AppMethodBeat.i(102190);
    if (this.mOpenSDK == null)
    {
      AppMethodBeat.o(102190);
      return;
    }
    if (this.mContext == null)
    {
      AppMethodBeat.o(102190);
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
      AppMethodBeat.o(102190);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("OpensdkToMsdkManager", localException, "", new Object[0]);
      AppMethodBeat.o(102190);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tmassistantsdk.openSDK.opensdktomsdk.TMOpenSDKToMsdkManager
 * JD-Core Version:    0.7.0.1
 */