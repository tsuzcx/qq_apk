package com.tencent.tmassistantsdk.openSDK;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.tmassistantsdk.channel.TMAssistantSDKChannel;
import com.tencent.tmassistantsdk.channel.TMAssistantSDKChannelDataItem;
import com.tencent.tmassistantsdk.downloadservice.NetworkMonitorReceiver;
import com.tencent.tmassistantsdk.logreport.DownloadReportManager;
import com.tencent.tmassistantsdk.logreport.GetSettingEngine;
import com.tencent.tmassistantsdk.logreport.LogReportManager;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos;
import com.tencent.tmassistantsdk.protocol.jce.DownloadChunkLogInfo;
import com.tencent.tmassistantsdk.util.GlobalUtil;
import com.tencent.tmassistantsdk.util.TMLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

public class TMQQDownloaderOpenSDK
  extends BaseQQDownloaderOpenSDK
  implements IDownloadStateChangedListener
{
  public static final String AUTHORITY = "com.tencent.android.qqdownloader.provider";
  public static final Uri CONTENT_URI = AssistantStore.DownloadInfos.CONTENT_URI;
  protected static final String TAG = "QQDownloaderOpenSDK";
  protected static TMQQDownloaderOpenSDK mInstance = null;
  Map<String, TMQQDownloaderOpenSDKParam> mDownloadParams = null;
  protected int sdkAPILevel = 1;
  
  public static String about()
  {
    return "TMQQDownloaderOpenSDK_2014_05_13_17_36_release_35169";
  }
  
  public static TMQQDownloaderOpenSDK getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new TMQQDownloaderOpenSDK();
      }
      TMQQDownloaderOpenSDK localTMQQDownloaderOpenSDK = mInstance;
      return localTMQQDownloaderOpenSDK;
    }
    finally {}
  }
  
  public static boolean isExistActoin(long paramLong)
  {
    if (paramLong < 0L) {
      return false;
    }
    Object localObject = new TMAssistantSDKChannel().getChannelDataItemList();
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        TMAssistantSDKChannelDataItem localTMAssistantSDKChannelDataItem = (TMAssistantSDKChannelDataItem)((Iterator)localObject).next();
        if ((localTMAssistantSDKChannelDataItem.mDBIdentity == paramLong) && (localTMAssistantSDKChannelDataItem.mDataItemEndTime - localTMAssistantSDKChannelDataItem.mDataItemStartTime <= 300000L)) {
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean isFileExist(String paramString)
  {
    return new File(paramString).exists();
  }
  
  private void relateToQQDownloader(Context paramContext, TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam, String paramString)
  {
    paramTMQQDownloaderOpenSDKParam = super.formatMapParams(paramTMQQDownloaderOpenSDKParam, false, false);
    paramTMQQDownloaderOpenSDKParam.put("taskid", paramString);
    paramTMQQDownloaderOpenSDKParam = super.formatIntentUriPath(4, paramTMQQDownloaderOpenSDKParam);
    paramString = new Intent("com.tencent.android.qqdownloader.action.RELATED");
    paramString.setPackage("com.tencent.android.qqdownloader");
    paramString.putExtra("command", "cmd_updatedownload");
    paramString.putExtra("relatedurl", paramTMQQDownloaderOpenSDKParam);
    paramContext.sendBroadcast(paramString);
  }
  
  public long addDownloadTaskFromAppDetail(TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.mDownloadParams != null) && (paramTMQQDownloaderOpenSDKParam != null))
    {
      String str = UUID.randomUUID().toString();
      this.mDownloadParams.put(str, paramTMQQDownloaderOpenSDKParam);
    }
    return super.buildAddDBData(paramTMQQDownloaderOpenSDKParam, paramBoolean1, paramBoolean2, paramTMQQDownloaderOpenSDKParam.actionFlag, null, 2);
  }
  
  public long addDownloadTaskFromAuthorize(TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam, String paramString)
  {
    if ((this.mDownloadParams != null) && (paramTMQQDownloaderOpenSDKParam != null))
    {
      String str = UUID.randomUUID().toString();
      this.mDownloadParams.put(str, paramTMQQDownloaderOpenSDKParam);
    }
    return super.buildAddDBData(paramTMQQDownloaderOpenSDKParam, true, true, paramTMQQDownloaderOpenSDKParam.actionFlag, paramString, 3);
  }
  
  public long addDownloadTaskFromAuthorize(String paramString)
  {
    paramString = super.formatEncryptUrl(paramString);
    long l = System.currentTimeMillis();
    return this.sdkChannel.AddDataItem(this.hostPackageName, this.hostVersionCode, "", 0, paramString, l, l + 300000L, 0, null);
  }
  
  public long addDownloadTaskFromTaskList(TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.mDownloadParams != null) && (paramTMQQDownloaderOpenSDKParam != null))
    {
      String str = UUID.randomUUID().toString();
      this.mDownloadParams.put(str, paramTMQQDownloaderOpenSDKParam);
    }
    return super.buildAddDBData(paramTMQQDownloaderOpenSDKParam, paramBoolean1, paramBoolean2, paramTMQQDownloaderOpenSDKParam.actionFlag, null, 1);
  }
  
  public int checkQQDownloaderInstalled(int paramInt)
  {
    if (this.mContext == null) {
      throw new Exception("you must initial openSDK,by calling initQQDownloaderOpenSDK method!");
    }
    PackageManager localPackageManager = this.mContext.getPackageManager();
    if (localPackageManager != null) {
      try
      {
        if (localPackageManager.getPackageInfo("com.tencent.android.qqdownloader", 0) != null)
        {
          int i = GlobalUtil.getInstance().getQQDownloaderVersionCode();
          int j = GlobalUtil.getInstance().getQQDownloaderAPILevel();
          int k = this.sdkAPILevel;
          if (k > j) {}
          while (paramInt > i) {
            return 2;
          }
          return 0;
        }
        return 1;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        y.printErrStackTrace("QQDownloaderOpenSDK", localNameNotFoundException, "", new Object[0]);
      }
    }
    return 1;
  }
  
  public void destroyQQDownloaderOpenSDK()
  {
    NetworkMonitorReceiver.getInstance().unregisterReceiver();
    GetSettingEngine.getInstance().cancleRequest();
    LogReportManager.getInstance().cancleReport();
    LogReportManager.getInstance().destory();
    if (this.mContext != null)
    {
      DownloadStateChangedReceiver.getInstance().unRegisteReceiver(this.mContext);
      DownloadStateChangedReceiver.getInstance().removeDownloadStateChangedListener(this);
    }
    GlobalUtil.getInstance().destroy();
    this.mContext = null;
  }
  
  /* Error */
  public com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo getDownloadTaskState(TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 205	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDK:mContext	Landroid/content/Context;
    //   4: ifnonnull +14 -> 18
    //   7: new 207	java/lang/Exception
    //   10: dup
    //   11: ldc_w 288
    //   14: invokespecial 210	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   17: athrow
    //   18: aload_1
    //   19: ifnonnull +14 -> 33
    //   22: new 207	java/lang/Exception
    //   25: dup
    //   26: ldc_w 290
    //   29: invokespecial 210	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   32: athrow
    //   33: aload_0
    //   34: getfield 205	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDK:mContext	Landroid/content/Context;
    //   37: invokevirtual 294	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   40: astore 10
    //   42: aload 10
    //   44: getstatic 31	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDK:CONTENT_URI	Landroid/net/Uri;
    //   47: aconst_null
    //   48: ldc_w 296
    //   51: iconst_3
    //   52: anewarray 298	java/lang/String
    //   55: dup
    //   56: iconst_0
    //   57: aload_1
    //   58: getfield 301	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam:taskPackageName	Ljava/lang/String;
    //   61: aastore
    //   62: dup
    //   63: iconst_1
    //   64: aload_1
    //   65: getfield 304	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam:taskVersion	I
    //   68: invokestatic 308	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   71: aastore
    //   72: dup
    //   73: iconst_2
    //   74: aload_1
    //   75: getfield 311	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam:channelId	Ljava/lang/String;
    //   78: aastore
    //   79: aconst_null
    //   80: invokevirtual 317	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   83: astore 10
    //   85: ldc 15
    //   87: new 319	java/lang/StringBuilder
    //   90: dup
    //   91: ldc_w 321
    //   94: invokespecial 322	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   97: aload_1
    //   98: getfield 301	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam:taskPackageName	Ljava/lang/String;
    //   101: invokevirtual 326	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: ldc_w 328
    //   107: invokevirtual 326	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload_1
    //   111: getfield 304	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam:taskVersion	I
    //   114: invokestatic 308	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   117: invokevirtual 326	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: ldc_w 330
    //   123: invokevirtual 326	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: aload_1
    //   127: getfield 311	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam:channelId	Ljava/lang/String;
    //   130: invokevirtual 326	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: invokevirtual 331	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokestatic 337	com/tencent/tmassistantsdk/util/TMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   139: aload 10
    //   141: ifnull +579 -> 720
    //   144: aload 10
    //   146: invokeinterface 342 1 0
    //   151: ifeq +569 -> 720
    //   154: ldc 15
    //   156: new 319	java/lang/StringBuilder
    //   159: dup
    //   160: ldc_w 344
    //   163: invokespecial 322	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   166: aload_1
    //   167: getfield 301	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam:taskPackageName	Ljava/lang/String;
    //   170: invokevirtual 326	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: invokevirtual 331	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: invokestatic 347	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   179: aload 10
    //   181: aload 10
    //   183: ldc_w 349
    //   186: invokeinterface 353 2 0
    //   191: invokeinterface 357 2 0
    //   196: lstore_3
    //   197: aload 10
    //   199: aload 10
    //   201: ldc_w 359
    //   204: invokeinterface 353 2 0
    //   209: invokeinterface 362 2 0
    //   214: invokestatic 366	com/tencent/tmassistantsdk/util/GlobalUtil:String2List	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   217: iconst_0
    //   218: invokevirtual 370	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   221: checkcast 298	java/lang/String
    //   224: astore 12
    //   226: aload 10
    //   228: aload 10
    //   230: ldc_w 372
    //   233: invokeinterface 353 2 0
    //   238: invokeinterface 362 2 0
    //   243: astore 11
    //   245: aload 10
    //   247: aload 10
    //   249: ldc_w 374
    //   252: invokeinterface 353 2 0
    //   257: invokeinterface 357 2 0
    //   262: lstore 5
    //   264: aload 10
    //   266: aload 10
    //   268: ldc_w 376
    //   271: invokeinterface 353 2 0
    //   276: invokeinterface 357 2 0
    //   281: lstore 7
    //   283: aload 10
    //   285: aload 10
    //   287: ldc_w 378
    //   290: invokeinterface 353 2 0
    //   295: invokeinterface 381 2 0
    //   300: invokestatic 384	com/tencent/tmassistantsdk/util/GlobalUtil:assistantState2SDKState	(I)I
    //   303: istore_2
    //   304: ldc 15
    //   306: new 319	java/lang/StringBuilder
    //   309: dup
    //   310: ldc_w 386
    //   313: invokespecial 322	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   316: iload_2
    //   317: invokevirtual 389	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   320: invokevirtual 331	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   323: invokestatic 347	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   326: iconst_4
    //   327: iload_2
    //   328: if_icmpne +34 -> 362
    //   331: aload_0
    //   332: aload 11
    //   334: invokespecial 391	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDK:isFileExist	(Ljava/lang/String;)Z
    //   337: istore 9
    //   339: iload 9
    //   341: ifne +21 -> 362
    //   344: aload 10
    //   346: ifnull +10 -> 356
    //   349: aload 10
    //   351: invokeinterface 394 1 0
    //   356: aconst_null
    //   357: astore 11
    //   359: aload 11
    //   361: areturn
    //   362: new 396	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadTaskInfo
    //   365: dup
    //   366: aload 12
    //   368: aload 11
    //   370: iload_2
    //   371: lload 5
    //   373: lload 7
    //   375: ldc_w 398
    //   378: invokespecial 401	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadTaskInfo:<init>	(Ljava/lang/String;Ljava/lang/String;IJJLjava/lang/String;)V
    //   381: astore 11
    //   383: iload_2
    //   384: iconst_5
    //   385: if_icmpeq +13 -> 398
    //   388: iload_2
    //   389: iconst_4
    //   390: if_icmpeq +8 -> 398
    //   393: iload_2
    //   394: iconst_3
    //   395: if_icmpne +51 -> 446
    //   398: invokestatic 406	com/tencent/tmassistantsdk/logreport/DownloadReportManager:getInstance	()Lcom/tencent/tmassistantsdk/logreport/DownloadReportManager;
    //   401: iconst_1
    //   402: invokevirtual 410	com/tencent/tmassistantsdk/logreport/DownloadReportManager:createNewChunkLogInfo	(B)Lcom/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo;
    //   405: astore 13
    //   407: aload 13
    //   409: aload_1
    //   410: getfield 413	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam:via	Ljava/lang/String;
    //   413: putfield 416	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:via	Ljava/lang/String;
    //   416: aload 13
    //   418: lload_3
    //   419: invokestatic 419	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   422: putfield 422	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:appId	Ljava/lang/String;
    //   425: aload 13
    //   427: iload_2
    //   428: putfield 425	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:resultState	I
    //   431: aload 13
    //   433: aload 12
    //   435: putfield 428	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:requestUrl	Ljava/lang/String;
    //   438: invokestatic 406	com/tencent/tmassistantsdk/logreport/DownloadReportManager:getInstance	()Lcom/tencent/tmassistantsdk/logreport/DownloadReportManager;
    //   441: aload 13
    //   443: invokevirtual 432	com/tencent/tmassistantsdk/logreport/DownloadReportManager:addLogData	(Lcom/qq/taf/jce/JceStruct;)V
    //   446: aload 11
    //   448: astore 12
    //   450: aload_0
    //   451: getfield 39	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDK:mDownloadParams	Ljava/util/Map;
    //   454: ifnull +160 -> 614
    //   457: aload_0
    //   458: getfield 39	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDK:mDownloadParams	Ljava/util/Map;
    //   461: invokeinterface 436 1 0
    //   466: invokeinterface 439 1 0
    //   471: astore 12
    //   473: aload 12
    //   475: invokeinterface 74 1 0
    //   480: ifeq +235 -> 715
    //   483: aload 12
    //   485: invokeinterface 78 1 0
    //   490: checkcast 441	java/util/Map$Entry
    //   493: invokeinterface 444 1 0
    //   498: checkcast 160	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam
    //   501: astore 13
    //   503: aload 13
    //   505: ifnull -32 -> 473
    //   508: aload 13
    //   510: getfield 301	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam:taskPackageName	Ljava/lang/String;
    //   513: aload_1
    //   514: getfield 301	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam:taskPackageName	Ljava/lang/String;
    //   517: invokevirtual 448	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   520: ifeq -47 -> 473
    //   523: aload 13
    //   525: getfield 304	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam:taskVersion	I
    //   528: aload_1
    //   529: getfield 304	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam:taskVersion	I
    //   532: if_icmpne -59 -> 473
    //   535: iconst_1
    //   536: istore_2
    //   537: aload 11
    //   539: astore 12
    //   541: iload_2
    //   542: ifne +72 -> 614
    //   545: ldc 15
    //   547: new 319	java/lang/StringBuilder
    //   550: dup
    //   551: ldc_w 344
    //   554: invokespecial 322	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   557: aload_1
    //   558: getfield 301	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam:taskPackageName	Ljava/lang/String;
    //   561: invokevirtual 326	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: invokevirtual 331	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   567: invokestatic 347	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   570: invokestatic 155	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   573: invokevirtual 158	java/util/UUID:toString	()Ljava/lang/String;
    //   576: astore 12
    //   578: aload_1
    //   579: lload_3
    //   580: invokestatic 419	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   583: putfield 451	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam:taskApkId	Ljava/lang/String;
    //   586: aload_0
    //   587: getfield 39	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDK:mDownloadParams	Ljava/util/Map;
    //   590: aload 12
    //   592: aload_1
    //   593: invokeinterface 116 3 0
    //   598: pop
    //   599: aload_0
    //   600: aload_0
    //   601: getfield 205	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDK:mContext	Landroid/content/Context;
    //   604: aload_1
    //   605: aload 12
    //   607: invokespecial 453	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDK:relateToQQDownloader	(Landroid/content/Context;Lcom/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam;Ljava/lang/String;)V
    //   610: aload 11
    //   612: astore 12
    //   614: aload 12
    //   616: astore 11
    //   618: aload 10
    //   620: ifnull -261 -> 359
    //   623: aload 10
    //   625: invokeinterface 394 1 0
    //   630: aload 12
    //   632: areturn
    //   633: astore 11
    //   635: aconst_null
    //   636: astore 10
    //   638: aconst_null
    //   639: astore_1
    //   640: ldc 15
    //   642: aload 11
    //   644: ldc 192
    //   646: iconst_0
    //   647: anewarray 233	java/lang/Object
    //   650: invokestatic 239	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   653: aload_1
    //   654: astore 11
    //   656: aload 10
    //   658: ifnull -299 -> 359
    //   661: aload 10
    //   663: invokeinterface 394 1 0
    //   668: aload_1
    //   669: areturn
    //   670: astore_1
    //   671: aconst_null
    //   672: astore 10
    //   674: aload 10
    //   676: ifnull +10 -> 686
    //   679: aload 10
    //   681: invokeinterface 394 1 0
    //   686: aload_1
    //   687: athrow
    //   688: astore_1
    //   689: goto -15 -> 674
    //   692: astore_1
    //   693: goto -19 -> 674
    //   696: astore 11
    //   698: aconst_null
    //   699: astore_1
    //   700: goto -60 -> 640
    //   703: astore 12
    //   705: aload 11
    //   707: astore_1
    //   708: aload 12
    //   710: astore 11
    //   712: goto -72 -> 640
    //   715: iconst_0
    //   716: istore_2
    //   717: goto -180 -> 537
    //   720: aconst_null
    //   721: astore 12
    //   723: goto -109 -> 614
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	726	0	this	TMQQDownloaderOpenSDK
    //   0	726	1	paramTMQQDownloaderOpenSDKParam	TMQQDownloaderOpenSDKParam
    //   303	414	2	i	int
    //   196	384	3	l1	long
    //   262	110	5	l2	long
    //   281	93	7	l3	long
    //   337	3	9	bool	boolean
    //   40	640	10	localObject1	Object
    //   243	374	11	localObject2	Object
    //   633	10	11	localException1	Exception
    //   654	1	11	localTMQQDownloaderOpenSDKParam	TMQQDownloaderOpenSDKParam
    //   696	10	11	localException2	Exception
    //   710	1	11	localException3	Exception
    //   224	407	12	localObject3	Object
    //   703	6	12	localException4	Exception
    //   721	1	12	localObject4	Object
    //   405	119	13	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   42	85	633	java/lang/Exception
    //   42	85	670	finally
    //   85	139	688	finally
    //   144	326	688	finally
    //   331	339	688	finally
    //   362	383	688	finally
    //   398	446	688	finally
    //   450	473	688	finally
    //   473	503	688	finally
    //   508	535	688	finally
    //   545	610	688	finally
    //   640	653	692	finally
    //   85	139	696	java/lang/Exception
    //   144	326	696	java/lang/Exception
    //   331	339	696	java/lang/Exception
    //   362	383	696	java/lang/Exception
    //   398	446	703	java/lang/Exception
    //   450	473	703	java/lang/Exception
    //   473	503	703	java/lang/Exception
    //   508	535	703	java/lang/Exception
    //   545	610	703	java/lang/Exception
  }
  
  public void initQQDownloaderOpenSDK(Context paramContext)
  {
    this.mContext = paramContext;
    this.hostPackageName = paramContext.getPackageName();
    this.hostVersionCode = GlobalUtil.getAppVersionCode(this.mContext);
    GlobalUtil.getInstance().setContext(this.mContext);
    this.sdkAPILevel = 1;
    DownloadStateChangedReceiver.getInstance().registeReceiver(this.mContext);
    DownloadStateChangedReceiver.getInstance().addDownloadStateChangedListener(this);
    NetworkMonitorReceiver.getInstance().registerReceiver();
    GetSettingEngine.getInstance().sendRequest();
    LogReportManager.getInstance().reportLog();
  }
  
  public void onDownloadStateChanged(TMQQDownloaderStateChangeParam paramTMQQDownloaderStateChangeParam)
  {
    TMQQDownloaderOpenSDKParam localTMQQDownloaderOpenSDKParam = paramTMQQDownloaderStateChangeParam.param;
    int i = GlobalUtil.assistantState2SDKState(paramTMQQDownloaderStateChangeParam.state);
    int j = GlobalUtil.assistantErrorCode2SDKErrorCode(paramTMQQDownloaderStateChangeParam.errorCode);
    Object localObject2 = paramTMQQDownloaderStateChangeParam.errorMsg;
    Object localObject3 = paramTMQQDownloaderStateChangeParam.taskId;
    TMLog.i("QQDownloaderOpenSDK", "onDownloadStateChanged state = " + i);
    Object localObject1 = null;
    paramTMQQDownloaderStateChangeParam = (TMQQDownloaderStateChangeParam)localObject1;
    if (localObject3 != null)
    {
      paramTMQQDownloaderStateChangeParam = (TMQQDownloaderStateChangeParam)localObject1;
      if (((String)localObject3).trim().length() > 0) {
        paramTMQQDownloaderStateChangeParam = (TMQQDownloaderOpenSDKParam)this.mDownloadParams.get(localObject3);
      }
    }
    if (paramTMQQDownloaderStateChangeParam != null) {
      onStateChanged(paramTMQQDownloaderStateChangeParam, i, j, (String)localObject2);
    }
    while (6 == i)
    {
      paramTMQQDownloaderStateChangeParam = new ArrayList();
      localObject1 = this.mDownloadParams.entrySet().iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject1).next();
          localObject2 = (TMQQDownloaderOpenSDKParam)((Map.Entry)localObject3).getValue();
          localObject3 = (String)((Map.Entry)localObject3).getKey();
          if ((localObject2 != null) && (!TextUtils.isEmpty(localTMQQDownloaderOpenSDKParam.taskPackageName)) && (((TMQQDownloaderOpenSDKParam)localObject2).taskPackageName.equals(localTMQQDownloaderOpenSDKParam.taskPackageName)) && (((TMQQDownloaderOpenSDKParam)localObject2).taskVersion == localTMQQDownloaderOpenSDKParam.taskVersion))
          {
            paramTMQQDownloaderStateChangeParam.add(localObject3);
            continue;
            TMLog.i("QQDownloaderOpenSDK", "onDownloadStateChanged storeParam = null");
            break;
          }
        }
      }
      paramTMQQDownloaderStateChangeParam = paramTMQQDownloaderStateChangeParam.iterator();
      while (paramTMQQDownloaderStateChangeParam.hasNext())
      {
        localObject1 = (String)paramTMQQDownloaderStateChangeParam.next();
        this.mDownloadParams.remove(localObject1);
      }
    }
  }
  
  public void startQQDownloader(Context paramContext)
  {
    if (paramContext != null)
    {
      Intent localIntent = paramContext.getPackageManager().getLaunchIntentForPackage("com.tencent.android.qqdownloader");
      if ((paramContext instanceof Application)) {
        localIntent.addFlags(268435456);
      }
      paramContext.startActivity(localIntent);
    }
  }
  
  public void startToAppDetail(Context paramContext, TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramContext == null) {
      throw new Exception("you must input an application or activity context!");
    }
    String str = UUID.randomUUID().toString();
    if (this.mDownloadParams != null) {
      this.mDownloadParams.put(str, paramTMQQDownloaderOpenSDKParam);
    }
    if (paramBoolean1)
    {
      DownloadChunkLogInfo localDownloadChunkLogInfo = DownloadReportManager.getInstance().createNewChunkLogInfo((byte)1);
      localDownloadChunkLogInfo.via = paramTMQQDownloaderOpenSDKParam.via;
      localDownloadChunkLogInfo.UUID = str;
      localDownloadChunkLogInfo.appId = paramTMQQDownloaderOpenSDKParam.taskAppId;
      localDownloadChunkLogInfo.resultState = 1;
      DownloadReportManager.getInstance().addLogData(localDownloadChunkLogInfo);
    }
    paramTMQQDownloaderOpenSDKParam = super.formatMapParams(paramTMQQDownloaderOpenSDKParam, paramBoolean1, paramBoolean2);
    paramTMQQDownloaderOpenSDKParam.put("taskid", str);
    paramTMQQDownloaderOpenSDKParam = new Intent("android.intent.action.VIEW", Uri.parse(super.formatIntentUriPath(2, paramTMQQDownloaderOpenSDKParam)));
    if ((paramContext instanceof Application)) {
      paramTMQQDownloaderOpenSDKParam.addFlags(268435456);
    }
    paramContext.startActivity(paramTMQQDownloaderOpenSDKParam);
  }
  
  public void startToAuthorized(Context paramContext, TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam, String paramString)
  {
    if (paramContext == null) {
      throw new Exception("you must input an application or activity context!");
    }
    if (paramTMQQDownloaderOpenSDKParam == null) {
      throw new Exception("QQDownloaderParam param cann't be null!");
    }
    String str = UUID.randomUUID().toString();
    if (this.mDownloadParams != null) {
      this.mDownloadParams.put(str, paramTMQQDownloaderOpenSDKParam);
    }
    DownloadChunkLogInfo localDownloadChunkLogInfo = DownloadReportManager.getInstance().createNewChunkLogInfo((byte)1);
    localDownloadChunkLogInfo.via = paramTMQQDownloaderOpenSDKParam.via;
    localDownloadChunkLogInfo.UUID = str;
    localDownloadChunkLogInfo.appId = paramTMQQDownloaderOpenSDKParam.taskAppId;
    localDownloadChunkLogInfo.resultState = 1;
    DownloadReportManager.getInstance().addLogData(localDownloadChunkLogInfo);
    paramTMQQDownloaderOpenSDKParam = super.formatMapParams(paramTMQQDownloaderOpenSDKParam, true, true);
    paramTMQQDownloaderOpenSDKParam.put("verifytype", paramString);
    paramTMQQDownloaderOpenSDKParam.put("taskid", str);
    paramTMQQDownloaderOpenSDKParam = new Intent("android.intent.action.VIEW", Uri.parse(super.formatIntentUriPath(3, paramTMQQDownloaderOpenSDKParam)));
    if ((paramContext instanceof Application)) {
      paramTMQQDownloaderOpenSDKParam.addFlags(268435456);
    }
    paramContext.startActivity(paramTMQQDownloaderOpenSDKParam);
  }
  
  public void startToAuthorized(Context paramContext, String paramString)
  {
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(formatEncryptUrl(paramString)));
    if ((paramContext instanceof Application)) {
      paramString.addFlags(268435456);
    }
    paramContext.startActivity(paramString);
  }
  
  public void startToDownloadTaskList(Context paramContext, TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramContext == null) {
      throw new Exception("you must input an application or activity context!");
    }
    if (paramTMQQDownloaderOpenSDKParam == null) {
      return;
    }
    String str = UUID.randomUUID().toString();
    if (this.mDownloadParams != null) {
      this.mDownloadParams.put(str, paramTMQQDownloaderOpenSDKParam);
    }
    if (paramBoolean1)
    {
      DownloadChunkLogInfo localDownloadChunkLogInfo = DownloadReportManager.getInstance().createNewChunkLogInfo((byte)1);
      localDownloadChunkLogInfo.UUID = str;
      localDownloadChunkLogInfo.requestUrl = "";
      localDownloadChunkLogInfo.via = paramTMQQDownloaderOpenSDKParam.via;
      localDownloadChunkLogInfo.appId = paramTMQQDownloaderOpenSDKParam.taskAppId;
      DownloadReportManager.getInstance().addLogData(localDownloadChunkLogInfo);
    }
    paramTMQQDownloaderOpenSDKParam = super.formatMapParams(paramTMQQDownloaderOpenSDKParam, paramBoolean1, paramBoolean2);
    paramTMQQDownloaderOpenSDKParam.put("taskid", str);
    paramTMQQDownloaderOpenSDKParam = new Intent("android.intent.action.VIEW", Uri.parse(super.formatIntentUriPath(1, paramTMQQDownloaderOpenSDKParam)));
    if ((paramContext instanceof Application)) {
      paramTMQQDownloaderOpenSDKParam.addFlags(268435456);
    }
    paramContext.startActivity(paramTMQQDownloaderOpenSDKParam);
  }
  
  public void startToWebView(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      throw new Exception("you must input an application or activity context!");
    }
    if (TextUtils.isEmpty(paramString)) {
      throw new Exception("param url shouldn't be null!");
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("url", paramString);
    paramString = super.formatIntentUriPath(5, localHashMap);
    TMLog.i("QQDownloaderOpenSDK", "startToWebView finalPath:" + paramString);
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    if ((paramContext instanceof Application)) {
      paramString.addFlags(268435456);
    }
    paramContext.startActivity(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDK
 * JD-Core Version:    0.7.0.1
 */