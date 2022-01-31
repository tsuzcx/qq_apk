package com.tencent.tmassistantsdk.openSDK;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
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
import java.util.concurrent.ConcurrentHashMap;

public class TMQQDownloaderOpenSDK
  extends BaseQQDownloaderOpenSDK
  implements IDownloadStateChangedListener
{
  public static final String AUTHORITY = "com.tencent.android.qqdownloader.provider";
  public static final Uri CONTENT_URI = AssistantStore.DownloadInfos.CONTENT_URI;
  protected static final String TAG = "QQDownloaderOpenSDK";
  protected static TMQQDownloaderOpenSDK mInstance = null;
  Map<String, TMQQDownloaderOpenSDKParam> mDownloadParams;
  protected int sdkAPILevel;
  
  private TMQQDownloaderOpenSDK()
  {
    AppMethodBeat.i(75856);
    this.sdkAPILevel = 1;
    this.mDownloadParams = null;
    this.mDownloadParams = new ConcurrentHashMap();
    AppMethodBeat.o(75856);
  }
  
  public static String about()
  {
    return "TMQQDownloaderOpenSDK_2014_05_13_17_36_release_35169";
  }
  
  public static TMQQDownloaderOpenSDK getInstance()
  {
    try
    {
      AppMethodBeat.i(75857);
      if (mInstance == null) {
        mInstance = new TMQQDownloaderOpenSDK();
      }
      TMQQDownloaderOpenSDK localTMQQDownloaderOpenSDK = mInstance;
      AppMethodBeat.o(75857);
      return localTMQQDownloaderOpenSDK;
    }
    finally {}
  }
  
  public static boolean isExistActoin(long paramLong)
  {
    AppMethodBeat.i(75859);
    if (paramLong < 0L)
    {
      AppMethodBeat.o(75859);
      return false;
    }
    Object localObject = new TMAssistantSDKChannel().getChannelDataItemList();
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        TMAssistantSDKChannelDataItem localTMAssistantSDKChannelDataItem = (TMAssistantSDKChannelDataItem)((Iterator)localObject).next();
        if ((localTMAssistantSDKChannelDataItem.mDBIdentity == paramLong) && (localTMAssistantSDKChannelDataItem.mDataItemEndTime - localTMAssistantSDKChannelDataItem.mDataItemStartTime <= 300000L))
        {
          AppMethodBeat.o(75859);
          return true;
        }
      }
    }
    AppMethodBeat.o(75859);
    return false;
  }
  
  private boolean isFileExist(String paramString)
  {
    AppMethodBeat.i(75872);
    if (new File(paramString).exists())
    {
      AppMethodBeat.o(75872);
      return true;
    }
    AppMethodBeat.o(75872);
    return false;
  }
  
  private void relateToQQDownloader(Context paramContext, TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam, String paramString)
  {
    AppMethodBeat.i(75871);
    paramTMQQDownloaderOpenSDKParam = super.formatMapParams(paramTMQQDownloaderOpenSDKParam, false, false);
    paramTMQQDownloaderOpenSDKParam.put("taskid", paramString);
    paramTMQQDownloaderOpenSDKParam = super.formatIntentUriPath(4, paramTMQQDownloaderOpenSDKParam);
    paramString = new Intent("com.tencent.android.qqdownloader.action.RELATED");
    paramString.setPackage("com.tencent.android.qqdownloader");
    paramString.putExtra("command", "cmd_updatedownload");
    paramString.putExtra("relatedurl", paramTMQQDownloaderOpenSDKParam);
    paramContext.sendBroadcast(paramString);
    AppMethodBeat.o(75871);
  }
  
  public long addDownloadTaskFromAppDetail(TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(75865);
    if ((this.mDownloadParams != null) && (paramTMQQDownloaderOpenSDKParam != null))
    {
      String str = UUID.randomUUID().toString();
      this.mDownloadParams.put(str, paramTMQQDownloaderOpenSDKParam);
    }
    long l = super.buildAddDBData(paramTMQQDownloaderOpenSDKParam, paramBoolean1, paramBoolean2, paramTMQQDownloaderOpenSDKParam.actionFlag, null, 2);
    AppMethodBeat.o(75865);
    return l;
  }
  
  public long addDownloadTaskFromAuthorize(TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam, String paramString)
  {
    AppMethodBeat.i(75868);
    if ((this.mDownloadParams != null) && (paramTMQQDownloaderOpenSDKParam != null))
    {
      String str = UUID.randomUUID().toString();
      this.mDownloadParams.put(str, paramTMQQDownloaderOpenSDKParam);
    }
    long l = super.buildAddDBData(paramTMQQDownloaderOpenSDKParam, true, true, paramTMQQDownloaderOpenSDKParam.actionFlag, paramString, 3);
    AppMethodBeat.o(75868);
    return l;
  }
  
  public long addDownloadTaskFromAuthorize(String paramString)
  {
    AppMethodBeat.i(75869);
    paramString = super.formatEncryptUrl(paramString);
    long l = System.currentTimeMillis();
    l = this.sdkChannel.AddDataItem(this.hostPackageName, this.hostVersionCode, "", 0, paramString, l, l + 300000L, 0, null);
    AppMethodBeat.o(75869);
    return l;
  }
  
  public long addDownloadTaskFromTaskList(TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(75863);
    if ((this.mDownloadParams != null) && (paramTMQQDownloaderOpenSDKParam != null))
    {
      String str = UUID.randomUUID().toString();
      this.mDownloadParams.put(str, paramTMQQDownloaderOpenSDKParam);
    }
    long l = super.buildAddDBData(paramTMQQDownloaderOpenSDKParam, paramBoolean1, paramBoolean2, paramTMQQDownloaderOpenSDKParam.actionFlag, null, 1);
    AppMethodBeat.o(75863);
    return l;
  }
  
  public int checkQQDownloaderInstalled(int paramInt)
  {
    AppMethodBeat.i(75860);
    if (this.mContext == null)
    {
      localObject = new Exception("you must initial openSDK,by calling initQQDownloaderOpenSDK method!");
      AppMethodBeat.o(75860);
      throw ((Throwable)localObject);
    }
    Object localObject = this.mContext.getPackageManager();
    if (localObject != null) {
      try
      {
        if (((PackageManager)localObject).getPackageInfo("com.tencent.android.qqdownloader", 0) != null)
        {
          int i = GlobalUtil.getInstance().getQQDownloaderVersionCode();
          int j = GlobalUtil.getInstance().getQQDownloaderAPILevel();
          int k = this.sdkAPILevel;
          if (k > j)
          {
            AppMethodBeat.o(75860);
            return 2;
          }
          if (paramInt > i)
          {
            AppMethodBeat.o(75860);
            return 2;
          }
          AppMethodBeat.o(75860);
          return 0;
        }
        AppMethodBeat.o(75860);
        return 1;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        ab.printErrStackTrace("QQDownloaderOpenSDK", localNameNotFoundException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(75860);
    return 1;
  }
  
  public void destroyQQDownloaderOpenSDK()
  {
    AppMethodBeat.i(75858);
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
    AppMethodBeat.o(75858);
  }
  
  /* Error */
  public com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo getDownloadTaskState(TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam)
  {
    // Byte code:
    //   0: ldc_w 307
    //   3: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 224	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDK:mContext	Landroid/content/Context;
    //   10: ifnonnull +22 -> 32
    //   13: new 226	java/lang/Exception
    //   16: dup
    //   17: ldc_w 309
    //   20: invokespecial 229	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   23: astore_1
    //   24: ldc_w 307
    //   27: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: aload_1
    //   31: athrow
    //   32: aload_1
    //   33: ifnonnull +22 -> 55
    //   36: new 226	java/lang/Exception
    //   39: dup
    //   40: ldc_w 311
    //   43: invokespecial 229	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   46: astore_1
    //   47: ldc_w 307
    //   50: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: aload_1
    //   54: athrow
    //   55: aload_0
    //   56: getfield 224	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDK:mContext	Landroid/content/Context;
    //   59: invokevirtual 315	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   62: astore 10
    //   64: aload 10
    //   66: getstatic 31	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDK:CONTENT_URI	Landroid/net/Uri;
    //   69: aconst_null
    //   70: ldc_w 317
    //   73: iconst_3
    //   74: anewarray 319	java/lang/String
    //   77: dup
    //   78: iconst_0
    //   79: aload_1
    //   80: getfield 322	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam:taskPackageName	Ljava/lang/String;
    //   83: aastore
    //   84: dup
    //   85: iconst_1
    //   86: aload_1
    //   87: getfield 325	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam:taskVersion	I
    //   90: invokestatic 329	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   93: aastore
    //   94: dup
    //   95: iconst_2
    //   96: aload_1
    //   97: getfield 332	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam:channelId	Ljava/lang/String;
    //   100: aastore
    //   101: aconst_null
    //   102: invokevirtual 338	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   105: astore 10
    //   107: ldc 15
    //   109: new 340	java/lang/StringBuilder
    //   112: dup
    //   113: ldc_w 342
    //   116: invokespecial 343	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   119: aload_1
    //   120: getfield 322	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam:taskPackageName	Ljava/lang/String;
    //   123: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: ldc_w 349
    //   129: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: aload_1
    //   133: getfield 325	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam:taskVersion	I
    //   136: invokestatic 329	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   139: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: ldc_w 351
    //   145: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: aload_1
    //   149: getfield 332	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam:channelId	Ljava/lang/String;
    //   152: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: invokevirtual 352	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: invokestatic 358	com/tencent/tmassistantsdk/util/TMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   161: aload 10
    //   163: ifnull +590 -> 753
    //   166: aload 10
    //   168: invokeinterface 363 1 0
    //   173: ifeq +580 -> 753
    //   176: ldc 15
    //   178: new 340	java/lang/StringBuilder
    //   181: dup
    //   182: ldc_w 365
    //   185: invokespecial 343	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   188: aload_1
    //   189: getfield 322	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam:taskPackageName	Ljava/lang/String;
    //   192: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: invokevirtual 352	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: invokestatic 367	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   201: aload 10
    //   203: aload 10
    //   205: ldc_w 369
    //   208: invokeinterface 373 2 0
    //   213: invokeinterface 377 2 0
    //   218: lstore_3
    //   219: aload 10
    //   221: aload 10
    //   223: ldc_w 379
    //   226: invokeinterface 373 2 0
    //   231: invokeinterface 382 2 0
    //   236: invokestatic 386	com/tencent/tmassistantsdk/util/GlobalUtil:String2List	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   239: iconst_0
    //   240: invokevirtual 390	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   243: checkcast 319	java/lang/String
    //   246: astore 11
    //   248: aload 10
    //   250: aload 10
    //   252: ldc_w 392
    //   255: invokeinterface 373 2 0
    //   260: invokeinterface 382 2 0
    //   265: astore 12
    //   267: aload 10
    //   269: aload 10
    //   271: ldc_w 394
    //   274: invokeinterface 373 2 0
    //   279: invokeinterface 377 2 0
    //   284: lstore 5
    //   286: aload 10
    //   288: aload 10
    //   290: ldc_w 396
    //   293: invokeinterface 373 2 0
    //   298: invokeinterface 377 2 0
    //   303: lstore 7
    //   305: aload 10
    //   307: aload 10
    //   309: ldc_w 398
    //   312: invokeinterface 373 2 0
    //   317: invokeinterface 401 2 0
    //   322: invokestatic 404	com/tencent/tmassistantsdk/util/GlobalUtil:assistantState2SDKState	(I)I
    //   325: istore_2
    //   326: ldc 15
    //   328: ldc_w 406
    //   331: iload_2
    //   332: invokestatic 329	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   335: invokevirtual 409	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   338: invokestatic 367	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   341: iconst_4
    //   342: iload_2
    //   343: if_icmpne +36 -> 379
    //   346: aload_0
    //   347: aload 12
    //   349: invokespecial 411	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDK:isFileExist	(Ljava/lang/String;)Z
    //   352: istore 9
    //   354: iload 9
    //   356: ifne +23 -> 379
    //   359: aload 10
    //   361: ifnull +10 -> 371
    //   364: aload 10
    //   366: invokeinterface 414 1 0
    //   371: ldc_w 307
    //   374: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   377: aconst_null
    //   378: areturn
    //   379: new 416	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadTaskInfo
    //   382: dup
    //   383: aload 11
    //   385: aload 12
    //   387: iload_2
    //   388: lload 5
    //   390: lload 7
    //   392: ldc_w 418
    //   395: invokespecial 421	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadTaskInfo:<init>	(Ljava/lang/String;Ljava/lang/String;IJJLjava/lang/String;)V
    //   398: astore 12
    //   400: iload_2
    //   401: iconst_5
    //   402: if_icmpeq +13 -> 415
    //   405: iload_2
    //   406: iconst_4
    //   407: if_icmpeq +8 -> 415
    //   410: iload_2
    //   411: iconst_3
    //   412: if_icmpne +51 -> 463
    //   415: invokestatic 426	com/tencent/tmassistantsdk/logreport/DownloadReportManager:getInstance	()Lcom/tencent/tmassistantsdk/logreport/DownloadReportManager;
    //   418: iconst_1
    //   419: invokevirtual 430	com/tencent/tmassistantsdk/logreport/DownloadReportManager:createNewChunkLogInfo	(B)Lcom/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo;
    //   422: astore 13
    //   424: aload 13
    //   426: aload_1
    //   427: getfield 433	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam:via	Ljava/lang/String;
    //   430: putfield 436	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:via	Ljava/lang/String;
    //   433: aload 13
    //   435: lload_3
    //   436: invokestatic 439	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   439: putfield 442	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:appId	Ljava/lang/String;
    //   442: aload 13
    //   444: iload_2
    //   445: putfield 445	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:resultState	I
    //   448: aload 13
    //   450: aload 11
    //   452: putfield 448	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:requestUrl	Ljava/lang/String;
    //   455: invokestatic 426	com/tencent/tmassistantsdk/logreport/DownloadReportManager:getInstance	()Lcom/tencent/tmassistantsdk/logreport/DownloadReportManager;
    //   458: aload 13
    //   460: invokevirtual 452	com/tencent/tmassistantsdk/logreport/DownloadReportManager:addLogData	(Lcom/qq/taf/jce/JceStruct;)V
    //   463: aload 12
    //   465: astore 11
    //   467: aload_0
    //   468: getfield 46	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDK:mDownloadParams	Ljava/util/Map;
    //   471: ifnull +160 -> 631
    //   474: aload_0
    //   475: getfield 46	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDK:mDownloadParams	Ljava/util/Map;
    //   478: invokeinterface 456 1 0
    //   483: invokeinterface 459 1 0
    //   488: astore 11
    //   490: aload 11
    //   492: invokeinterface 86 1 0
    //   497: ifeq +251 -> 748
    //   500: aload 11
    //   502: invokeinterface 90 1 0
    //   507: checkcast 461	java/util/Map$Entry
    //   510: invokeinterface 464 1 0
    //   515: checkcast 175	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam
    //   518: astore 13
    //   520: aload 13
    //   522: ifnull -32 -> 490
    //   525: aload 13
    //   527: getfield 322	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam:taskPackageName	Ljava/lang/String;
    //   530: aload_1
    //   531: getfield 322	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam:taskPackageName	Ljava/lang/String;
    //   534: invokevirtual 468	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   537: ifeq -47 -> 490
    //   540: aload 13
    //   542: getfield 325	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam:taskVersion	I
    //   545: aload_1
    //   546: getfield 325	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam:taskVersion	I
    //   549: if_icmpne -59 -> 490
    //   552: iconst_1
    //   553: istore_2
    //   554: aload 12
    //   556: astore 11
    //   558: iload_2
    //   559: ifne +72 -> 631
    //   562: ldc 15
    //   564: new 340	java/lang/StringBuilder
    //   567: dup
    //   568: ldc_w 365
    //   571: invokespecial 343	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   574: aload_1
    //   575: getfield 322	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam:taskPackageName	Ljava/lang/String;
    //   578: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: invokevirtual 352	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   584: invokestatic 367	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   587: invokestatic 170	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   590: invokevirtual 173	java/util/UUID:toString	()Ljava/lang/String;
    //   593: astore 11
    //   595: aload_1
    //   596: lload_3
    //   597: invokestatic 439	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   600: putfield 471	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam:taskApkId	Ljava/lang/String;
    //   603: aload_0
    //   604: getfield 46	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDK:mDownloadParams	Ljava/util/Map;
    //   607: aload 11
    //   609: aload_1
    //   610: invokeinterface 130 3 0
    //   615: pop
    //   616: aload_0
    //   617: aload_0
    //   618: getfield 224	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDK:mContext	Landroid/content/Context;
    //   621: aload_1
    //   622: aload 11
    //   624: invokespecial 473	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDK:relateToQQDownloader	(Landroid/content/Context;Lcom/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam;Ljava/lang/String;)V
    //   627: aload 12
    //   629: astore 11
    //   631: aload 11
    //   633: astore 12
    //   635: aload 10
    //   637: ifnull +14 -> 651
    //   640: aload 10
    //   642: invokeinterface 414 1 0
    //   647: aload 11
    //   649: astore 12
    //   651: ldc_w 307
    //   654: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   657: aload 12
    //   659: areturn
    //   660: astore 11
    //   662: aconst_null
    //   663: astore 10
    //   665: aconst_null
    //   666: astore_1
    //   667: ldc 15
    //   669: aload 11
    //   671: ldc 209
    //   673: iconst_0
    //   674: anewarray 252	java/lang/Object
    //   677: invokestatic 258	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   680: aload_1
    //   681: astore 12
    //   683: aload 10
    //   685: ifnull -34 -> 651
    //   688: aload 10
    //   690: invokeinterface 414 1 0
    //   695: aload_1
    //   696: astore 12
    //   698: goto -47 -> 651
    //   701: astore_1
    //   702: aconst_null
    //   703: astore 10
    //   705: aload 10
    //   707: ifnull +10 -> 717
    //   710: aload 10
    //   712: invokeinterface 414 1 0
    //   717: ldc_w 307
    //   720: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   723: aload_1
    //   724: athrow
    //   725: astore_1
    //   726: goto -21 -> 705
    //   729: astore_1
    //   730: goto -25 -> 705
    //   733: astore 11
    //   735: aconst_null
    //   736: astore_1
    //   737: goto -70 -> 667
    //   740: astore 11
    //   742: aload 12
    //   744: astore_1
    //   745: goto -78 -> 667
    //   748: iconst_0
    //   749: istore_2
    //   750: goto -196 -> 554
    //   753: aconst_null
    //   754: astore 11
    //   756: goto -125 -> 631
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	759	0	this	TMQQDownloaderOpenSDK
    //   0	759	1	paramTMQQDownloaderOpenSDKParam	TMQQDownloaderOpenSDKParam
    //   325	425	2	i	int
    //   218	379	3	l1	long
    //   284	105	5	l2	long
    //   303	88	7	l3	long
    //   352	3	9	bool	boolean
    //   62	649	10	localObject1	Object
    //   246	402	11	localObject2	Object
    //   660	10	11	localException1	Exception
    //   733	1	11	localException2	Exception
    //   740	1	11	localException3	Exception
    //   754	1	11	localObject3	Object
    //   265	478	12	localObject4	Object
    //   422	119	13	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   64	107	660	java/lang/Exception
    //   64	107	701	finally
    //   107	161	725	finally
    //   166	341	725	finally
    //   346	354	725	finally
    //   379	400	725	finally
    //   415	463	725	finally
    //   467	490	725	finally
    //   490	520	725	finally
    //   525	552	725	finally
    //   562	627	725	finally
    //   667	680	729	finally
    //   107	161	733	java/lang/Exception
    //   166	341	733	java/lang/Exception
    //   346	354	733	java/lang/Exception
    //   379	400	733	java/lang/Exception
    //   415	463	740	java/lang/Exception
    //   467	490	740	java/lang/Exception
    //   490	520	740	java/lang/Exception
    //   525	552	740	java/lang/Exception
    //   562	627	740	java/lang/Exception
  }
  
  public void initQQDownloaderOpenSDK(Context paramContext)
  {
    AppMethodBeat.i(75874);
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
    AppMethodBeat.o(75874);
  }
  
  public void onDownloadStateChanged(TMQQDownloaderStateChangeParam paramTMQQDownloaderStateChangeParam)
  {
    AppMethodBeat.i(75873);
    TMQQDownloaderOpenSDKParam localTMQQDownloaderOpenSDKParam = paramTMQQDownloaderStateChangeParam.param;
    int i = GlobalUtil.assistantState2SDKState(paramTMQQDownloaderStateChangeParam.state);
    int j = GlobalUtil.assistantErrorCode2SDKErrorCode(paramTMQQDownloaderStateChangeParam.errorCode);
    Object localObject2 = paramTMQQDownloaderStateChangeParam.errorMsg;
    Object localObject3 = paramTMQQDownloaderStateChangeParam.taskId;
    TMLog.i("QQDownloaderOpenSDK", "onDownloadStateChanged state = ".concat(String.valueOf(i)));
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
    AppMethodBeat.o(75873);
  }
  
  public void startQQDownloader(Context paramContext)
  {
    AppMethodBeat.i(75861);
    if (paramContext != null)
    {
      Intent localIntent = paramContext.getPackageManager().getLaunchIntentForPackage("com.tencent.android.qqdownloader");
      if ((paramContext instanceof Application)) {
        localIntent.addFlags(268435456);
      }
      paramContext.startActivity(localIntent);
    }
    AppMethodBeat.o(75861);
  }
  
  public void startToAppDetail(Context paramContext, TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(75864);
    if (paramContext == null)
    {
      paramContext = new Exception("you must input an application or activity context!");
      AppMethodBeat.o(75864);
      throw paramContext;
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
    AppMethodBeat.o(75864);
  }
  
  public void startToAuthorized(Context paramContext, TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam, String paramString)
  {
    AppMethodBeat.i(75866);
    if (paramContext == null)
    {
      paramContext = new Exception("you must input an application or activity context!");
      AppMethodBeat.o(75866);
      throw paramContext;
    }
    if (paramTMQQDownloaderOpenSDKParam == null)
    {
      paramContext = new Exception("QQDownloaderParam param cann't be null!");
      AppMethodBeat.o(75866);
      throw paramContext;
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
    AppMethodBeat.o(75866);
  }
  
  public void startToAuthorized(Context paramContext, String paramString)
  {
    AppMethodBeat.i(75867);
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(formatEncryptUrl(paramString)));
    if ((paramContext instanceof Application)) {
      paramString.addFlags(268435456);
    }
    paramContext.startActivity(paramString);
    AppMethodBeat.o(75867);
  }
  
  public void startToDownloadTaskList(Context paramContext, TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(75862);
    if (paramContext == null)
    {
      paramContext = new Exception("you must input an application or activity context!");
      AppMethodBeat.o(75862);
      throw paramContext;
    }
    if (paramTMQQDownloaderOpenSDKParam == null)
    {
      AppMethodBeat.o(75862);
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
    AppMethodBeat.o(75862);
  }
  
  public void startToWebView(Context paramContext, String paramString)
  {
    AppMethodBeat.i(75875);
    if (paramContext == null)
    {
      paramContext = new Exception("you must input an application or activity context!");
      AppMethodBeat.o(75875);
      throw paramContext;
    }
    if (TextUtils.isEmpty(paramString))
    {
      paramContext = new Exception("param url shouldn't be null!");
      AppMethodBeat.o(75875);
      throw paramContext;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("url", paramString);
    paramString = super.formatIntentUriPath(5, localHashMap);
    TMLog.i("QQDownloaderOpenSDK", "startToWebView finalPath:".concat(String.valueOf(paramString)));
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    if ((paramContext instanceof Application)) {
      paramString.addFlags(268435456);
    }
    paramContext.startActivity(paramString);
    AppMethodBeat.o(75875);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDK
 * JD-Core Version:    0.7.0.1
 */