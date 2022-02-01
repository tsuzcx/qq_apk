package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.g;
import com.tencent.smtt.utils.g.a;
import com.tencent.smtt.utils.m;
import com.tencent.smtt.utils.o;
import com.tencent.smtt.utils.r;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;

public class TbsLogReport
{
  private static TbsLogReport a;
  private Handler b;
  private Context c;
  private boolean d;
  
  private TbsLogReport(Context paramContext)
  {
    AppMethodBeat.i(54960);
    this.b = null;
    this.d = false;
    this.c = paramContext.getApplicationContext();
    paramContext = new HandlerThread("TbsLogReportThread");
    paramContext.start();
    this.b = new Handler(paramContext.getLooper())
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(55019);
        if (paramAnonymousMessage.what == 600)
        {
          if ((paramAnonymousMessage.obj instanceof TbsLogReport.TbsLogInfo)) {
            try
            {
              TbsLogReport.TbsLogInfo localTbsLogInfo = (TbsLogReport.TbsLogInfo)paramAnonymousMessage.obj;
              int i = paramAnonymousMessage.arg1;
              TbsLogReport.a(TbsLogReport.this, i, localTbsLogInfo);
              AppMethodBeat.o(55019);
              return;
            }
            catch (Exception paramAnonymousMessage) {}
          }
          AppMethodBeat.o(55019);
          return;
        }
        if (paramAnonymousMessage.what == 601) {
          TbsLogReport.a(TbsLogReport.this);
        }
        AppMethodBeat.o(55019);
      }
    };
    AppMethodBeat.o(54960);
  }
  
  private String a(int paramInt)
  {
    AppMethodBeat.i(54979);
    String str = paramInt + "|";
    AppMethodBeat.o(54979);
    return str;
  }
  
  private String a(long paramLong)
  {
    AppMethodBeat.i(54976);
    Object localObject = null;
    try
    {
      String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(paramLong));
      localObject = str;
    }
    catch (Exception localException)
    {
      label35:
      break label35;
    }
    AppMethodBeat.o(54976);
    return localObject;
  }
  
  private String a(String paramString)
  {
    AppMethodBeat.i(54978);
    StringBuilder localStringBuilder = new StringBuilder();
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = str + "|";
    AppMethodBeat.o(54978);
    return paramString;
  }
  
  private JSONArray a()
  {
    AppMethodBeat.i(54972);
    Object localObject = d().getString("tbs_download_upload", null);
    if (localObject == null) {
      localObject = new JSONArray();
    }
    for (;;)
    {
      AppMethodBeat.o(54972);
      return localObject;
      try
      {
        JSONArray localJSONArray2 = new JSONArray((String)localObject);
        localObject = localJSONArray2;
        if (localJSONArray2.length() > 5)
        {
          JSONArray localJSONArray3 = new JSONArray();
          int i = localJSONArray2.length() - 1;
          localObject = localJSONArray2;
          if (i > localJSONArray2.length() - 5)
          {
            localJSONArray3.put(localJSONArray2.get(i));
            AppMethodBeat.o(54972);
            return localJSONArray3;
          }
        }
      }
      catch (Exception localException)
      {
        JSONArray localJSONArray1 = new JSONArray();
      }
    }
  }
  
  private void a(int paramInt, TbsLogInfo paramTbsLogInfo)
  {
    AppMethodBeat.i(54971);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(paramInt));
    if (b.g(this.c)) {
      localStringBuilder.append(a(b.h(this.c)));
    }
    localStringBuilder.append(a(m.a(this.c)));
    localStringBuilder.append(a(q.a().j(this.c)));
    Object localObject1 = r.d(this.c);
    try
    {
      localObject2 = new String(((String)localObject1).getBytes("UTF-8"), "ISO8859-1");
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      SharedPreferences localSharedPreferences;
      try
      {
        for (;;)
        {
          Object localObject2;
          int i;
          ((JSONArray)localObject2).put(((JSONArray)localObject1).get(((JSONArray)localObject2).length() - i));
          i -= 1;
          continue;
          localException = localException;
        }
        localStringBuilder.append(a(b.e(this.c)));
      }
      catch (Exception paramTbsLogInfo)
      {
        for (;;)
        {
          TbsLog.e("upload", "JSONArray transform error!");
        }
      }
      paramTbsLogInfo = (TbsLogInfo)localObject1;
      paramTbsLogInfo.put(localStringBuilder.toString());
      localObject1 = localSharedPreferences.edit();
      ((SharedPreferences.Editor)localObject1).putString("tbs_download_upload", paramTbsLogInfo.toString());
      ((SharedPreferences.Editor)localObject1).commit();
      if ((!this.d) && (paramInt == EventType.TYPE_LOAD.a)) {
        break label657;
      }
      b();
      AppMethodBeat.o(54971);
    }
    localStringBuilder.append(a((String)localObject1));
    localObject1 = this.c.getPackageName();
    localStringBuilder.append(a((String)localObject1));
    if ("com.tencent.mm".equals(localObject1))
    {
      localStringBuilder.append(a(b.a(this.c, "com.tencent.mm.BuildInfo.CLIENT_VERSION")));
      localStringBuilder.append(a(a(TbsLogInfo.a(paramTbsLogInfo))));
      localStringBuilder.append(a(TbsLogInfo.b(paramTbsLogInfo)));
      localStringBuilder.append(a(TbsLogInfo.c(paramTbsLogInfo)));
      localStringBuilder.append(a(TbsLogInfo.d(paramTbsLogInfo)));
      localStringBuilder.append(a(TbsLogInfo.e(paramTbsLogInfo)));
      localStringBuilder.append(a(TbsLogInfo.f(paramTbsLogInfo)));
      localStringBuilder.append(a(TbsLogInfo.g(paramTbsLogInfo)));
      localStringBuilder.append(a(TbsLogInfo.h(paramTbsLogInfo)));
      localStringBuilder.append(a(TbsLogInfo.i(paramTbsLogInfo)));
      localStringBuilder.append(a(TbsLogInfo.j(paramTbsLogInfo)));
      localStringBuilder.append(b(TbsLogInfo.k(paramTbsLogInfo)));
      localStringBuilder.append(b(TbsLogInfo.l(paramTbsLogInfo)));
      localStringBuilder.append(b(TbsLogInfo.m(paramTbsLogInfo)));
      localStringBuilder.append(a(TbsLogInfo.n(paramTbsLogInfo)));
      localStringBuilder.append(a(paramTbsLogInfo.a));
      localStringBuilder.append(a(TbsLogInfo.o(paramTbsLogInfo)));
      localStringBuilder.append(a(TbsLogInfo.p(paramTbsLogInfo)));
      localStringBuilder.append(a(TbsDownloadConfig.getInstance(this.c).mPreferences.getInt("tbs_download_version", 0)));
      localStringBuilder.append(a(b.k(this.c)));
      localStringBuilder.append(a("4.4.1.0038_44138"));
      localStringBuilder.append(false);
      localSharedPreferences = d();
      localObject1 = a();
      localObject2 = new JSONArray();
      if (((JSONArray)localObject2).length() < 5) {
        break label592;
      }
      i = 4;
      paramTbsLogInfo = (TbsLogInfo)localObject2;
      if (i <= 0) {
        break label595;
      }
    }
    label592:
    label595:
    return;
  }
  
  private void a(int paramInt, TbsLogInfo paramTbsLogInfo, EventType paramEventType)
  {
    AppMethodBeat.i(54965);
    paramTbsLogInfo.setErrorCode(paramInt);
    paramTbsLogInfo.setEventTime(System.currentTimeMillis());
    QbSdk.l.onInstallFinish(paramInt);
    eventReport(paramEventType, paramTbsLogInfo);
    AppMethodBeat.o(54965);
  }
  
  private String b(long paramLong)
  {
    AppMethodBeat.i(54980);
    String str = paramLong + "|";
    AppMethodBeat.o(54980);
    return str;
  }
  
  private void b()
  {
    AppMethodBeat.i(54974);
    if ((QbSdk.mSettings != null) && (QbSdk.mSettings.containsKey(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD)) && (QbSdk.mSettings.get(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false")))
    {
      TbsLog.i("upload", "[TbsLogReport.sendLogReportRequest] -- SET_SENDREQUEST_AND_UPLOAD is false");
      AppMethodBeat.o(54974);
      return;
    }
    TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat]");
    Object localObject1 = a();
    if ((localObject1 == null) || (((JSONArray)localObject1).length() == 0))
    {
      TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat] no data");
      AppMethodBeat.o(54974);
      return;
    }
    TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat] jsonArray:".concat(String.valueOf(localObject1)));
    try
    {
      localObject1 = g.a(o.a(this.c).c(), ((JSONArray)localObject1).toString().getBytes("utf-8"), new g.a()
      {
        public void a(int paramAnonymousInt)
        {
          AppMethodBeat.i(55090);
          TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat] onHttpResponseCode:".concat(String.valueOf(paramAnonymousInt)));
          if (paramAnonymousInt < 300) {
            TbsLogReport.b(TbsLogReport.this);
          }
          AppMethodBeat.o(55090);
        }
      }, true);
      TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat] response:" + (String)localObject1 + " testcase: -1");
      return;
    }
    finally
    {
      AppMethodBeat.o(54974);
    }
  }
  
  private void c()
  {
    AppMethodBeat.i(54975);
    SharedPreferences.Editor localEditor = d().edit();
    localEditor.remove("tbs_download_upload");
    localEditor.commit();
    AppMethodBeat.o(54975);
  }
  
  private SharedPreferences d()
  {
    AppMethodBeat.i(54977);
    SharedPreferences localSharedPreferences = this.c.getSharedPreferences("tbs_download_stat", 4);
    AppMethodBeat.o(54977);
    return localSharedPreferences;
  }
  
  public static TbsLogReport getInstance(Context paramContext)
  {
    AppMethodBeat.i(54961);
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new TbsLogReport(paramContext);
      }
      paramContext = a;
      AppMethodBeat.o(54961);
      return paramContext;
    }
    finally
    {
      AppMethodBeat.o(54961);
    }
  }
  
  public void clear()
  {
    AppMethodBeat.i(54981);
    try
    {
      SharedPreferences.Editor localEditor = d().edit();
      localEditor.clear();
      localEditor.commit();
      AppMethodBeat.o(54981);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(54981);
    }
  }
  
  public void dailyReport()
  {
    AppMethodBeat.i(54969);
    this.b.sendEmptyMessage(601);
    AppMethodBeat.o(54969);
  }
  
  public void eventReport(EventType paramEventType, TbsLogInfo paramTbsLogInfo)
  {
    AppMethodBeat.i(54970);
    try
    {
      paramTbsLogInfo = (TbsLogInfo)paramTbsLogInfo.clone();
      Message localMessage = this.b.obtainMessage();
      localMessage.what = 600;
      localMessage.arg1 = paramEventType.a;
      localMessage.obj = paramTbsLogInfo;
      this.b.sendMessage(localMessage);
      AppMethodBeat.o(54970);
      return;
    }
    finally
    {
      TbsLog.w("upload", "[TbsLogReport.eventReport] error, message=" + paramEventType.getMessage());
      AppMethodBeat.o(54970);
    }
  }
  
  public boolean getShouldUploadEventReport()
  {
    return this.d;
  }
  
  /* Error */
  public void reportTbsLog()
  {
    // Byte code:
    //   0: ldc_w 484
    //   3: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: getstatic 358	com/tencent/smtt/sdk/QbSdk:mSettings	Ljava/util/Map;
    //   9: ifnull +53 -> 62
    //   12: getstatic 358	com/tencent/smtt/sdk/QbSdk:mSettings	Ljava/util/Map;
    //   15: getstatic 362	com/tencent/smtt/sdk/QbSdk:KEY_SET_SENDREQUEST_AND_UPLOAD	Ljava/lang/String;
    //   18: invokeinterface 367 2 0
    //   23: ifeq +39 -> 62
    //   26: getstatic 358	com/tencent/smtt/sdk/QbSdk:mSettings	Ljava/util/Map;
    //   29: getstatic 362	com/tencent/smtt/sdk/QbSdk:KEY_SET_SENDREQUEST_AND_UPLOAD	Ljava/lang/String;
    //   32: invokeinterface 370 2 0
    //   37: ldc_w 372
    //   40: invokevirtual 373	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   43: ifeq +19 -> 62
    //   46: ldc_w 286
    //   49: ldc_w 486
    //   52: invokestatic 377	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   55: ldc_w 484
    //   58: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: return
    //   62: aload_0
    //   63: getfield 50	com/tencent/smtt/sdk/TbsLogReport:c	Landroid/content/Context;
    //   66: invokestatic 491	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   69: iconst_3
    //   70: if_icmpeq +10 -> 80
    //   73: ldc_w 484
    //   76: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   79: return
    //   80: invokestatic 494	com/tencent/smtt/utils/TbsLog:getTbsLogFilePath	()Ljava/lang/String;
    //   83: astore 9
    //   85: aload 9
    //   87: ifnonnull +10 -> 97
    //   90: ldc_w 484
    //   93: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: return
    //   97: invokestatic 499	com/tencent/smtt/utils/h:a	()Lcom/tencent/smtt/utils/h;
    //   100: invokevirtual 501	com/tencent/smtt/utils/h:b	()Ljava/lang/String;
    //   103: astore 6
    //   105: ldc 119
    //   107: astore_2
    //   108: aload_0
    //   109: getfield 50	com/tencent/smtt/sdk/TbsLogReport:c	Landroid/content/Context;
    //   112: invokestatic 158	com/tencent/smtt/utils/b:g	(Landroid/content/Context;)Z
    //   115: ifeq +11 -> 126
    //   118: aload_0
    //   119: getfield 50	com/tencent/smtt/sdk/TbsLogReport:c	Landroid/content/Context;
    //   122: invokestatic 162	com/tencent/smtt/utils/b:h	(Landroid/content/Context;)Ljava/lang/String;
    //   125: astore_2
    //   126: aload_0
    //   127: getfield 50	com/tencent/smtt/sdk/TbsLogReport:c	Landroid/content/Context;
    //   130: invokestatic 275	com/tencent/smtt/utils/b:k	(Landroid/content/Context;)Ljava/lang/String;
    //   133: astore 4
    //   135: aload_2
    //   136: invokevirtual 504	java/lang/String:getBytes	()[B
    //   139: astore_3
    //   140: aload 4
    //   142: invokevirtual 504	java/lang/String:getBytes	()[B
    //   145: astore 4
    //   147: aload_3
    //   148: astore_2
    //   149: invokestatic 499	com/tencent/smtt/utils/h:a	()Lcom/tencent/smtt/utils/h;
    //   152: aload_3
    //   153: invokevirtual 507	com/tencent/smtt/utils/h:a	([B)[B
    //   156: astore_3
    //   157: aload_3
    //   158: astore_2
    //   159: invokestatic 499	com/tencent/smtt/utils/h:a	()Lcom/tencent/smtt/utils/h;
    //   162: aload 4
    //   164: invokevirtual 507	com/tencent/smtt/utils/h:a	([B)[B
    //   167: astore 5
    //   169: aload 5
    //   171: astore_2
    //   172: aload_3
    //   173: astore 4
    //   175: aload_2
    //   176: astore_3
    //   177: aload 4
    //   179: invokestatic 510	com/tencent/smtt/utils/h:b	([B)Ljava/lang/String;
    //   182: astore_2
    //   183: aload_3
    //   184: invokestatic 510	com/tencent/smtt/utils/h:b	([B)Ljava/lang/String;
    //   187: astore_3
    //   188: new 75	java/lang/StringBuilder
    //   191: dup
    //   192: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   195: aload_0
    //   196: getfield 50	com/tencent/smtt/sdk/TbsLogReport:c	Landroid/content/Context;
    //   199: invokestatic 397	com/tencent/smtt/utils/o:a	(Landroid/content/Context;)Lcom/tencent/smtt/utils/o;
    //   202: invokevirtual 512	com/tencent/smtt/utils/o:e	()Ljava/lang/String;
    //   205: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: aload_2
    //   209: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: ldc_w 514
    //   215: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: aload_3
    //   219: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: astore 7
    //   227: new 516	java/util/HashMap
    //   230: dup
    //   231: invokespecial 517	java/util/HashMap:<init>	()V
    //   234: astore 8
    //   236: aload 8
    //   238: ldc_w 519
    //   241: ldc_w 521
    //   244: invokeinterface 524 3 0
    //   249: pop
    //   250: aload 8
    //   252: ldc_w 526
    //   255: ldc 185
    //   257: invokeinterface 524 3 0
    //   262: pop
    //   263: aload 8
    //   265: ldc_w 528
    //   268: aload_0
    //   269: getfield 50	com/tencent/smtt/sdk/TbsLogReport:c	Landroid/content/Context;
    //   272: invokestatic 168	com/tencent/smtt/utils/m:a	(Landroid/content/Context;)Ljava/lang/String;
    //   275: invokeinterface 524 3 0
    //   280: pop
    //   281: new 530	java/io/File
    //   284: dup
    //   285: getstatic 534	com/tencent/smtt/utils/f:a	Ljava/lang/String;
    //   288: invokespecial 535	java/io/File:<init>	(Ljava/lang/String;)V
    //   291: pop
    //   292: new 18	com/tencent/smtt/sdk/TbsLogReport$a
    //   295: dup
    //   296: aload 9
    //   298: new 75	java/lang/StringBuilder
    //   301: dup
    //   302: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   305: getstatic 534	com/tencent/smtt/utils/f:a	Ljava/lang/String;
    //   308: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: ldc_w 537
    //   314: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   320: invokespecial 539	com/tencent/smtt/sdk/TbsLogReport$a:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   323: invokevirtual 541	com/tencent/smtt/sdk/TbsLogReport$a:a	()V
    //   326: new 530	java/io/File
    //   329: dup
    //   330: getstatic 534	com/tencent/smtt/utils/f:a	Ljava/lang/String;
    //   333: ldc_w 543
    //   336: invokespecial 544	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   339: astore 4
    //   341: new 546	java/io/FileInputStream
    //   344: dup
    //   345: aload 4
    //   347: invokespecial 549	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   350: astore 5
    //   352: sipush 8192
    //   355: newarray byte
    //   357: astore_2
    //   358: new 551	java/io/ByteArrayOutputStream
    //   361: dup
    //   362: invokespecial 552	java/io/ByteArrayOutputStream:<init>	()V
    //   365: astore_3
    //   366: aload 5
    //   368: aload_2
    //   369: invokevirtual 556	java/io/FileInputStream:read	([B)I
    //   372: istore_1
    //   373: iload_1
    //   374: iconst_m1
    //   375: if_icmpeq +97 -> 472
    //   378: aload_3
    //   379: aload_2
    //   380: iconst_0
    //   381: iload_1
    //   382: invokevirtual 560	java/io/ByteArrayOutputStream:write	([BII)V
    //   385: goto -19 -> 366
    //   388: astore_2
    //   389: aload_3
    //   390: astore_2
    //   391: aload 5
    //   393: astore_3
    //   394: aload_3
    //   395: ifnull +7 -> 402
    //   398: aload_3
    //   399: invokevirtual 563	java/io/FileInputStream:close	()V
    //   402: aload_2
    //   403: ifnull +7 -> 410
    //   406: aload_2
    //   407: invokevirtual 564	java/io/ByteArrayOutputStream:close	()V
    //   410: aload 4
    //   412: ifnull +246 -> 658
    //   415: aload 4
    //   417: invokevirtual 567	java/io/File:delete	()Z
    //   420: pop
    //   421: aconst_null
    //   422: astore_2
    //   423: new 75	java/lang/StringBuilder
    //   426: dup
    //   427: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   430: aload 7
    //   432: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: ldc_w 569
    //   438: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: aload 6
    //   443: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   449: aload 8
    //   451: aload_2
    //   452: new 8	com/tencent/smtt/sdk/TbsLogReport$2
    //   455: dup
    //   456: aload_0
    //   457: invokespecial 570	com/tencent/smtt/sdk/TbsLogReport$2:<init>	(Lcom/tencent/smtt/sdk/TbsLogReport;)V
    //   460: iconst_0
    //   461: invokestatic 573	com/tencent/smtt/utils/g:a	(Ljava/lang/String;Ljava/util/Map;[BLcom/tencent/smtt/utils/g$a;Z)Ljava/lang/String;
    //   464: pop
    //   465: ldc_w 484
    //   468: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   471: return
    //   472: aload_3
    //   473: invokevirtual 576	java/io/ByteArrayOutputStream:flush	()V
    //   476: invokestatic 499	com/tencent/smtt/utils/h:a	()Lcom/tencent/smtt/utils/h;
    //   479: aload_3
    //   480: invokevirtual 579	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   483: invokevirtual 507	com/tencent/smtt/utils/h:a	([B)[B
    //   486: astore_2
    //   487: aload 5
    //   489: invokevirtual 563	java/io/FileInputStream:close	()V
    //   492: aload_3
    //   493: invokevirtual 564	java/io/ByteArrayOutputStream:close	()V
    //   496: aload 4
    //   498: invokevirtual 567	java/io/File:delete	()Z
    //   501: pop
    //   502: goto -79 -> 423
    //   505: astore_2
    //   506: aconst_null
    //   507: astore_3
    //   508: aconst_null
    //   509: astore 6
    //   511: aconst_null
    //   512: astore 4
    //   514: aload 4
    //   516: ifnull +8 -> 524
    //   519: aload 4
    //   521: invokevirtual 563	java/io/FileInputStream:close	()V
    //   524: aload_3
    //   525: ifnull +7 -> 532
    //   528: aload_3
    //   529: invokevirtual 564	java/io/ByteArrayOutputStream:close	()V
    //   532: aload 6
    //   534: ifnull +9 -> 543
    //   537: aload 6
    //   539: invokevirtual 567	java/io/File:delete	()Z
    //   542: pop
    //   543: ldc_w 484
    //   546: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   549: aload_2
    //   550: athrow
    //   551: astore 5
    //   553: goto -61 -> 492
    //   556: astore_3
    //   557: goto -61 -> 496
    //   560: astore_3
    //   561: goto -159 -> 402
    //   564: astore_2
    //   565: goto -155 -> 410
    //   568: astore 4
    //   570: goto -46 -> 524
    //   573: astore_3
    //   574: goto -42 -> 532
    //   577: astore_2
    //   578: aconst_null
    //   579: astore_3
    //   580: aconst_null
    //   581: astore 5
    //   583: aload 4
    //   585: astore 6
    //   587: aload 5
    //   589: astore 4
    //   591: goto -77 -> 514
    //   594: astore_2
    //   595: aconst_null
    //   596: astore_3
    //   597: aload 4
    //   599: astore 6
    //   601: aload 5
    //   603: astore 4
    //   605: goto -91 -> 514
    //   608: astore_2
    //   609: aload 4
    //   611: astore 6
    //   613: aload 5
    //   615: astore 4
    //   617: goto -103 -> 514
    //   620: astore_2
    //   621: aconst_null
    //   622: astore_2
    //   623: aconst_null
    //   624: astore 4
    //   626: aconst_null
    //   627: astore_3
    //   628: goto -234 -> 394
    //   631: astore_2
    //   632: aconst_null
    //   633: astore_2
    //   634: aconst_null
    //   635: astore_3
    //   636: goto -242 -> 394
    //   639: astore_2
    //   640: aconst_null
    //   641: astore_2
    //   642: aload 5
    //   644: astore_3
    //   645: goto -251 -> 394
    //   648: astore_3
    //   649: aload 4
    //   651: astore_3
    //   652: aload_2
    //   653: astore 4
    //   655: goto -478 -> 177
    //   658: aconst_null
    //   659: astore_2
    //   660: goto -237 -> 423
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	663	0	this	TbsLogReport
    //   372	10	1	i	int
    //   107	273	2	localObject1	Object
    //   388	1	2	localException1	Exception
    //   390	97	2	localObject2	Object
    //   505	45	2	localObject3	Object
    //   564	1	2	localException2	Exception
    //   577	1	2	localObject4	Object
    //   594	1	2	localObject5	Object
    //   608	1	2	localObject6	Object
    //   620	1	2	localException3	Exception
    //   622	1	2	localObject7	Object
    //   631	1	2	localException4	Exception
    //   633	1	2	localObject8	Object
    //   639	1	2	localException5	Exception
    //   641	19	2	localObject9	Object
    //   139	390	3	localObject10	Object
    //   556	1	3	localException6	Exception
    //   560	1	3	localException7	Exception
    //   573	1	3	localException8	Exception
    //   579	66	3	localObject11	Object
    //   648	1	3	localException9	Exception
    //   651	1	3	localObject12	Object
    //   133	387	4	localObject13	Object
    //   568	16	4	localException10	Exception
    //   589	65	4	localObject14	Object
    //   167	321	5	localObject15	Object
    //   551	1	5	localException11	Exception
    //   581	62	5	localObject16	Object
    //   103	509	6	localObject17	Object
    //   225	206	7	str1	String
    //   234	216	8	localHashMap	java.util.HashMap
    //   83	214	9	str2	String
    // Exception table:
    //   from	to	target	type
    //   366	373	388	java/lang/Exception
    //   378	385	388	java/lang/Exception
    //   472	487	388	java/lang/Exception
    //   281	341	505	finally
    //   487	492	551	java/lang/Exception
    //   492	496	556	java/lang/Exception
    //   398	402	560	java/lang/Exception
    //   406	410	564	java/lang/Exception
    //   519	524	568	java/lang/Exception
    //   528	532	573	java/lang/Exception
    //   341	352	577	finally
    //   352	366	594	finally
    //   366	373	608	finally
    //   378	385	608	finally
    //   472	487	608	finally
    //   281	341	620	java/lang/Exception
    //   341	352	631	java/lang/Exception
    //   352	366	639	java/lang/Exception
    //   149	157	648	java/lang/Exception
    //   159	169	648	java/lang/Exception
  }
  
  public void setInstallErrorCode(int paramInt, String paramString)
  {
    AppMethodBeat.i(54963);
    setInstallErrorCode(paramInt, paramString, EventType.TYPE_INSTALL);
    AppMethodBeat.o(54963);
  }
  
  public void setInstallErrorCode(int paramInt, String paramString, EventType paramEventType)
  {
    AppMethodBeat.i(54964);
    if ((paramInt != 200) && (paramInt != 220) && (paramInt != 221)) {
      TbsLog.i("TbsDownload", "error occured in installation, errorCode:".concat(String.valueOf(paramInt)), true);
    }
    TbsLogInfo localTbsLogInfo = tbsLogInfo();
    localTbsLogInfo.setFailDetail(paramString);
    a(paramInt, localTbsLogInfo, paramEventType);
    AppMethodBeat.o(54964);
  }
  
  public void setInstallErrorCode(int paramInt, Throwable paramThrowable)
  {
    AppMethodBeat.i(54966);
    TbsLogInfo localTbsLogInfo = tbsLogInfo();
    localTbsLogInfo.setFailDetail(paramThrowable);
    a(paramInt, localTbsLogInfo, EventType.TYPE_INSTALL);
    AppMethodBeat.o(54966);
  }
  
  public void setLoadErrorCode(int paramInt, String paramString)
  {
    AppMethodBeat.i(54967);
    TbsLogInfo localTbsLogInfo = tbsLogInfo();
    localTbsLogInfo.setErrorCode(paramInt);
    localTbsLogInfo.setEventTime(System.currentTimeMillis());
    localTbsLogInfo.setFailDetail(paramString);
    eventReport(EventType.TYPE_LOAD, localTbsLogInfo);
    new StringBuilder("setLoadErrorCode(").append(paramInt).append(",").append(paramString).append(")");
    AppMethodBeat.o(54967);
  }
  
  public void setLoadErrorCode(int paramInt, Throwable paramThrowable)
  {
    AppMethodBeat.i(54968);
    Object localObject = "NULL";
    if (paramThrowable != null)
    {
      paramThrowable = "msg: " + paramThrowable.getMessage() + "; err: " + paramThrowable + "; cause: " + Log.getStackTraceString(paramThrowable.getCause());
      localObject = paramThrowable;
      if (paramThrowable.length() > 1024) {
        localObject = paramThrowable.substring(0, 1024);
      }
    }
    setLoadErrorCode(paramInt, (String)localObject);
    AppMethodBeat.o(54968);
  }
  
  public void setShouldUploadEventReport(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public TbsLogInfo tbsLogInfo()
  {
    AppMethodBeat.i(54962);
    TbsLogInfo localTbsLogInfo = new TbsLogInfo(null);
    AppMethodBeat.o(54962);
    return localTbsLogInfo;
  }
  
  public static enum EventType
  {
    int a;
    
    static
    {
      AppMethodBeat.i(54369);
      TYPE_DOWNLOAD = new EventType("TYPE_DOWNLOAD", 0, 0);
      TYPE_INSTALL = new EventType("TYPE_INSTALL", 1, 1);
      TYPE_LOAD = new EventType("TYPE_LOAD", 2, 2);
      TYPE_DOWNLOAD_DECOUPLE = new EventType("TYPE_DOWNLOAD_DECOUPLE", 3, 3);
      TYPE_INSTALL_DECOUPLE = new EventType("TYPE_INSTALL_DECOUPLE", 4, 4);
      TYPE_COOKIE_DB_SWITCH = new EventType("TYPE_COOKIE_DB_SWITCH", 5, 5);
      TYPE_SDK_REPORT_INFO = new EventType("TYPE_SDK_REPORT_INFO", 6, 6);
      b = new EventType[] { TYPE_DOWNLOAD, TYPE_INSTALL, TYPE_LOAD, TYPE_DOWNLOAD_DECOUPLE, TYPE_INSTALL_DECOUPLE, TYPE_COOKIE_DB_SWITCH, TYPE_SDK_REPORT_INFO };
      AppMethodBeat.o(54369);
    }
    
    private EventType(int paramInt)
    {
      this.a = paramInt;
    }
  }
  
  public static class TbsLogInfo
    implements Cloneable
  {
    int a;
    private long b;
    private String c;
    private String d;
    private int e;
    private int f;
    private int g;
    private int h;
    private String i;
    private int j;
    private int k;
    private long l;
    private long m;
    private int n;
    private String o;
    private String p;
    private long q;
    
    private TbsLogInfo()
    {
      AppMethodBeat.i(55046);
      resetArgs();
      AppMethodBeat.o(55046);
    }
    
    protected Object clone()
    {
      AppMethodBeat.i(55047);
      try
      {
        Object localObject = super.clone();
        AppMethodBeat.o(55047);
        return localObject;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException)
      {
        AppMethodBeat.o(55047);
      }
      return this;
    }
    
    public int getDownFinalFlag()
    {
      return this.k;
    }
    
    public void resetArgs()
    {
      this.b = 0L;
      this.c = null;
      this.d = null;
      this.e = 0;
      this.f = 0;
      this.g = 0;
      this.h = 2;
      this.i = "unknown";
      this.j = 0;
      this.k = 2;
      this.l = 0L;
      this.m = 0L;
      this.n = 1;
      this.a = 0;
      this.o = null;
      this.p = null;
      this.q = 0L;
    }
    
    public void setApn(String paramString)
    {
      this.i = paramString;
    }
    
    public void setCheckErrorDetail(String paramString)
    {
      AppMethodBeat.i(55050);
      setErrorCode(108);
      this.o = paramString;
      AppMethodBeat.o(55050);
    }
    
    public void setDownConsumeTime(long paramLong)
    {
      this.m += paramLong;
    }
    
    public void setDownFinalFlag(int paramInt)
    {
      this.k = paramInt;
    }
    
    public void setDownloadCancel(int paramInt)
    {
      this.g = paramInt;
    }
    
    public void setDownloadSize(long paramLong)
    {
      this.q += paramLong;
    }
    
    public void setDownloadUrl(String paramString)
    {
      AppMethodBeat.i(55048);
      if (this.c == null)
      {
        this.c = paramString;
        AppMethodBeat.o(55048);
        return;
      }
      this.c = (this.c + ";" + paramString);
      AppMethodBeat.o(55048);
    }
    
    public void setErrorCode(int paramInt)
    {
      AppMethodBeat.i(55049);
      if ((paramInt != 100) && (paramInt != 110) && (paramInt != 120) && (paramInt != 111) && (paramInt < 400)) {
        TbsLog.i("TbsDownload", "error occured, errorCode:".concat(String.valueOf(paramInt)), true);
      }
      if (paramInt == 111) {
        TbsLog.i("TbsDownload", "you are not in wifi, downloading stoped", true);
      }
      this.a = paramInt;
      AppMethodBeat.o(55049);
    }
    
    public void setEventTime(long paramLong)
    {
      this.b = paramLong;
    }
    
    public void setFailDetail(String paramString)
    {
      AppMethodBeat.i(55051);
      if (paramString == null)
      {
        AppMethodBeat.o(55051);
        return;
      }
      String str = paramString;
      if (paramString.length() > 1024) {
        str = paramString.substring(0, 1024);
      }
      this.p = str;
      AppMethodBeat.o(55051);
    }
    
    public void setFailDetail(Throwable paramThrowable)
    {
      AppMethodBeat.i(55052);
      if (paramThrowable == null)
      {
        this.p = "";
        AppMethodBeat.o(55052);
        return;
      }
      String str = Log.getStackTraceString(paramThrowable);
      paramThrowable = str;
      if (str.length() > 1024) {
        paramThrowable = str.substring(0, 1024);
      }
      this.p = paramThrowable;
      AppMethodBeat.o(55052);
    }
    
    public void setHttpCode(int paramInt)
    {
      this.e = paramInt;
    }
    
    public void setNetworkChange(int paramInt)
    {
      this.n = paramInt;
    }
    
    public void setNetworkType(int paramInt)
    {
      this.j = paramInt;
    }
    
    public void setPatchUpdateFlag(int paramInt)
    {
      this.f = paramInt;
    }
    
    public void setPkgSize(long paramLong)
    {
      this.l = paramLong;
    }
    
    public void setResolveIp(String paramString)
    {
      this.d = paramString;
    }
    
    public void setUnpkgFlag(int paramInt)
    {
      this.h = paramInt;
    }
  }
  
  static class a
  {
    private final String a;
    private final String b;
    
    public a(String paramString1, String paramString2)
    {
      this.a = paramString1;
      this.b = paramString2;
    }
    
    /* Error */
    private static void a(java.io.File paramFile)
    {
      // Byte code:
      //   0: ldc 25
      //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: new 33	java/io/RandomAccessFile
      //   8: dup
      //   9: aload_0
      //   10: ldc 35
      //   12: invokespecial 38	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   15: astore_0
      //   16: ldc 40
      //   18: iconst_2
      //   19: invokestatic 46	java/lang/Integer:parseInt	(Ljava/lang/String;I)I
      //   22: istore_1
      //   23: aload_0
      //   24: ldc2_w 47
      //   27: invokevirtual 52	java/io/RandomAccessFile:seek	(J)V
      //   30: aload_0
      //   31: invokevirtual 56	java/io/RandomAccessFile:read	()I
      //   34: istore_2
      //   35: iload_2
      //   36: iload_1
      //   37: iand
      //   38: ifle +23 -> 61
      //   41: aload_0
      //   42: ldc2_w 47
      //   45: invokevirtual 52	java/io/RandomAccessFile:seek	(J)V
      //   48: aload_0
      //   49: iload_1
      //   50: iconst_m1
      //   51: ixor
      //   52: sipush 255
      //   55: iand
      //   56: iload_2
      //   57: iand
      //   58: invokevirtual 59	java/io/RandomAccessFile:write	(I)V
      //   61: aload_0
      //   62: invokevirtual 62	java/io/RandomAccessFile:close	()V
      //   65: ldc 25
      //   67: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   70: return
      //   71: astore_0
      //   72: ldc 25
      //   74: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   77: return
      //   78: astore_0
      //   79: aconst_null
      //   80: astore_0
      //   81: aload_0
      //   82: ifnull +38 -> 120
      //   85: aload_0
      //   86: invokevirtual 62	java/io/RandomAccessFile:close	()V
      //   89: ldc 25
      //   91: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   94: return
      //   95: astore_0
      //   96: ldc 25
      //   98: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   101: return
      //   102: astore_0
      //   103: aconst_null
      //   104: astore_3
      //   105: aload_3
      //   106: ifnull +7 -> 113
      //   109: aload_3
      //   110: invokevirtual 62	java/io/RandomAccessFile:close	()V
      //   113: ldc 25
      //   115: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   118: aload_0
      //   119: athrow
      //   120: ldc 25
      //   122: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   125: return
      //   126: astore_3
      //   127: goto -14 -> 113
      //   130: astore_3
      //   131: aload_0
      //   132: astore 4
      //   134: aload_3
      //   135: astore_0
      //   136: aload 4
      //   138: astore_3
      //   139: goto -34 -> 105
      //   142: astore_3
      //   143: goto -62 -> 81
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	146	0	paramFile	java.io.File
      //   22	30	1	i	int
      //   34	24	2	j	int
      //   104	6	3	localObject1	Object
      //   126	1	3	localIOException	java.io.IOException
      //   130	5	3	localObject2	Object
      //   138	1	3	localObject3	Object
      //   142	1	3	localException	Exception
      //   132	5	4	localFile	java.io.File
      // Exception table:
      //   from	to	target	type
      //   61	65	71	java/io/IOException
      //   5	16	78	java/lang/Exception
      //   85	89	95	java/io/IOException
      //   5	16	102	finally
      //   109	113	126	java/io/IOException
      //   16	35	130	finally
      //   41	61	130	finally
      //   16	35	142	java/lang/Exception
      //   41	61	142	java/lang/Exception
    }
    
    /* Error */
    public void a()
    {
      // Byte code:
      //   0: ldc 66
      //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: new 68	java/io/FileOutputStream
      //   8: dup
      //   9: aload_0
      //   10: getfield 18	com/tencent/smtt/sdk/TbsLogReport$a:b	Ljava/lang/String;
      //   13: invokespecial 71	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
      //   16: astore_2
      //   17: new 73	java/util/zip/ZipOutputStream
      //   20: dup
      //   21: new 75	java/io/BufferedOutputStream
      //   24: dup
      //   25: aload_2
      //   26: invokespecial 78	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
      //   29: invokespecial 79	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
      //   32: astore 5
      //   34: sipush 2048
      //   37: newarray byte
      //   39: astore 6
      //   41: aload_0
      //   42: getfield 16	com/tencent/smtt/sdk/TbsLogReport$a:a	Ljava/lang/String;
      //   45: astore 7
      //   47: new 81	java/io/FileInputStream
      //   50: dup
      //   51: aload 7
      //   53: invokespecial 82	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
      //   56: astore 4
      //   58: new 84	java/io/BufferedInputStream
      //   61: dup
      //   62: aload 4
      //   64: sipush 2048
      //   67: invokespecial 87	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
      //   70: astore_3
      //   71: aload 5
      //   73: new 89	java/util/zip/ZipEntry
      //   76: dup
      //   77: aload 7
      //   79: aload 7
      //   81: ldc 91
      //   83: invokevirtual 97	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
      //   86: iconst_1
      //   87: iadd
      //   88: invokevirtual 101	java/lang/String:substring	(I)Ljava/lang/String;
      //   91: invokespecial 102	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
      //   94: invokevirtual 106	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
      //   97: aload_3
      //   98: aload 6
      //   100: iconst_0
      //   101: sipush 2048
      //   104: invokevirtual 109	java/io/BufferedInputStream:read	([BII)I
      //   107: istore_1
      //   108: iload_1
      //   109: iconst_m1
      //   110: if_icmpeq +64 -> 174
      //   113: aload 5
      //   115: aload 6
      //   117: iconst_0
      //   118: iload_1
      //   119: invokevirtual 112	java/util/zip/ZipOutputStream:write	([BII)V
      //   122: goto -25 -> 97
      //   125: astore 6
      //   127: aload_3
      //   128: ifnull +7 -> 135
      //   131: aload_3
      //   132: invokevirtual 113	java/io/BufferedInputStream:close	()V
      //   135: aload 4
      //   137: ifnull +8 -> 145
      //   140: aload 4
      //   142: invokevirtual 114	java/io/FileInputStream:close	()V
      //   145: new 116	java/io/File
      //   148: dup
      //   149: aload_0
      //   150: getfield 18	com/tencent/smtt/sdk/TbsLogReport$a:b	Ljava/lang/String;
      //   153: invokespecial 117	java/io/File:<init>	(Ljava/lang/String;)V
      //   156: invokestatic 119	com/tencent/smtt/sdk/TbsLogReport$a:a	(Ljava/io/File;)V
      //   159: aload 5
      //   161: invokevirtual 120	java/util/zip/ZipOutputStream:close	()V
      //   164: aload_2
      //   165: invokevirtual 121	java/io/FileOutputStream:close	()V
      //   168: ldc 66
      //   170: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   173: return
      //   174: aload 5
      //   176: invokevirtual 124	java/util/zip/ZipOutputStream:flush	()V
      //   179: aload 5
      //   181: invokevirtual 127	java/util/zip/ZipOutputStream:closeEntry	()V
      //   184: aload_3
      //   185: invokevirtual 113	java/io/BufferedInputStream:close	()V
      //   188: aload 4
      //   190: invokevirtual 114	java/io/FileInputStream:close	()V
      //   193: goto -48 -> 145
      //   196: astore_3
      //   197: goto -52 -> 145
      //   200: astore_3
      //   201: aconst_null
      //   202: astore 4
      //   204: aconst_null
      //   205: astore 6
      //   207: aload 4
      //   209: ifnull +8 -> 217
      //   212: aload 4
      //   214: invokevirtual 113	java/io/BufferedInputStream:close	()V
      //   217: aload 6
      //   219: ifnull +8 -> 227
      //   222: aload 6
      //   224: invokevirtual 114	java/io/FileInputStream:close	()V
      //   227: ldc 66
      //   229: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   232: aload_3
      //   233: athrow
      //   234: astore_3
      //   235: aload_2
      //   236: astore_3
      //   237: aload 5
      //   239: astore_2
      //   240: aload_2
      //   241: ifnull +7 -> 248
      //   244: aload_2
      //   245: invokevirtual 120	java/util/zip/ZipOutputStream:close	()V
      //   248: aload_3
      //   249: ifnull +58 -> 307
      //   252: aload_3
      //   253: invokevirtual 121	java/io/FileOutputStream:close	()V
      //   256: ldc 66
      //   258: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   261: return
      //   262: astore_2
      //   263: ldc 66
      //   265: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   268: return
      //   269: astore_2
      //   270: ldc 66
      //   272: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   275: return
      //   276: astore_3
      //   277: aconst_null
      //   278: astore 4
      //   280: aconst_null
      //   281: astore_2
      //   282: aload 4
      //   284: ifnull +8 -> 292
      //   287: aload 4
      //   289: invokevirtual 120	java/util/zip/ZipOutputStream:close	()V
      //   292: aload_2
      //   293: ifnull +7 -> 300
      //   296: aload_2
      //   297: invokevirtual 121	java/io/FileOutputStream:close	()V
      //   300: ldc 66
      //   302: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   305: aload_3
      //   306: athrow
      //   307: ldc 66
      //   309: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   312: return
      //   313: astore_3
      //   314: goto -126 -> 188
      //   317: astore_3
      //   318: goto -183 -> 135
      //   321: astore_3
      //   322: goto -177 -> 145
      //   325: astore 4
      //   327: goto -110 -> 217
      //   330: astore 4
      //   332: goto -105 -> 227
      //   335: astore_3
      //   336: goto -172 -> 164
      //   339: astore_2
      //   340: goto -92 -> 248
      //   343: astore 4
      //   345: goto -53 -> 292
      //   348: astore_2
      //   349: goto -49 -> 300
      //   352: astore_3
      //   353: aconst_null
      //   354: astore 4
      //   356: goto -74 -> 282
      //   359: astore_3
      //   360: aload 5
      //   362: astore 4
      //   364: goto -82 -> 282
      //   367: astore_2
      //   368: aconst_null
      //   369: astore_2
      //   370: aconst_null
      //   371: astore_3
      //   372: goto -132 -> 240
      //   375: astore_3
      //   376: aconst_null
      //   377: astore 4
      //   379: aload_2
      //   380: astore_3
      //   381: aload 4
      //   383: astore_2
      //   384: goto -144 -> 240
      //   387: astore_3
      //   388: aconst_null
      //   389: astore 7
      //   391: aload 4
      //   393: astore 6
      //   395: aload 7
      //   397: astore 4
      //   399: goto -192 -> 207
      //   402: astore 7
      //   404: aload_3
      //   405: astore 8
      //   407: aload 4
      //   409: astore 6
      //   411: aload 7
      //   413: astore_3
      //   414: aload 8
      //   416: astore 4
      //   418: goto -211 -> 207
      //   421: astore_3
      //   422: aconst_null
      //   423: astore_3
      //   424: aconst_null
      //   425: astore 4
      //   427: goto -300 -> 127
      //   430: astore_3
      //   431: aconst_null
      //   432: astore_3
      //   433: goto -306 -> 127
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	436	0	this	a
      //   107	12	1	i	int
      //   16	229	2	localObject1	Object
      //   262	1	2	localIOException1	java.io.IOException
      //   269	1	2	localIOException2	java.io.IOException
      //   281	16	2	localObject2	Object
      //   339	1	2	localIOException3	java.io.IOException
      //   348	1	2	localIOException4	java.io.IOException
      //   367	1	2	localException1	Exception
      //   369	15	2	localObject3	Object
      //   70	115	3	localBufferedInputStream	java.io.BufferedInputStream
      //   196	1	3	localIOException5	java.io.IOException
      //   200	33	3	localObject4	Object
      //   234	1	3	localException2	Exception
      //   236	17	3	localObject5	Object
      //   276	30	3	localObject6	Object
      //   313	1	3	localIOException6	java.io.IOException
      //   317	1	3	localIOException7	java.io.IOException
      //   321	1	3	localIOException8	java.io.IOException
      //   335	1	3	localIOException9	java.io.IOException
      //   352	1	3	localObject7	Object
      //   359	1	3	localObject8	Object
      //   371	1	3	localObject9	Object
      //   375	1	3	localException3	Exception
      //   380	1	3	localObject10	Object
      //   387	18	3	localObject11	Object
      //   413	1	3	localObject12	Object
      //   421	1	3	localException4	Exception
      //   423	1	3	localObject13	Object
      //   430	1	3	localException5	Exception
      //   432	1	3	localObject14	Object
      //   56	232	4	localFileInputStream	java.io.FileInputStream
      //   325	1	4	localIOException10	java.io.IOException
      //   330	1	4	localIOException11	java.io.IOException
      //   343	1	4	localIOException12	java.io.IOException
      //   354	72	4	localObject15	Object
      //   32	329	5	localZipOutputStream	java.util.zip.ZipOutputStream
      //   39	77	6	arrayOfByte	byte[]
      //   125	1	6	localException6	Exception
      //   205	205	6	localObject16	Object
      //   45	351	7	str	String
      //   402	10	7	localObject17	Object
      //   405	10	8	localObject18	Object
      // Exception table:
      //   from	to	target	type
      //   71	97	125	java/lang/Exception
      //   97	108	125	java/lang/Exception
      //   113	122	125	java/lang/Exception
      //   174	184	125	java/lang/Exception
      //   188	193	196	java/io/IOException
      //   47	58	200	finally
      //   34	47	234	java/lang/Exception
      //   131	135	234	java/lang/Exception
      //   140	145	234	java/lang/Exception
      //   145	159	234	java/lang/Exception
      //   184	188	234	java/lang/Exception
      //   188	193	234	java/lang/Exception
      //   212	217	234	java/lang/Exception
      //   222	227	234	java/lang/Exception
      //   227	234	234	java/lang/Exception
      //   164	168	262	java/io/IOException
      //   252	256	269	java/io/IOException
      //   5	17	276	finally
      //   184	188	313	java/io/IOException
      //   131	135	317	java/io/IOException
      //   140	145	321	java/io/IOException
      //   212	217	325	java/io/IOException
      //   222	227	330	java/io/IOException
      //   159	164	335	java/io/IOException
      //   244	248	339	java/io/IOException
      //   287	292	343	java/io/IOException
      //   296	300	348	java/io/IOException
      //   17	34	352	finally
      //   34	47	359	finally
      //   131	135	359	finally
      //   140	145	359	finally
      //   145	159	359	finally
      //   184	188	359	finally
      //   188	193	359	finally
      //   212	217	359	finally
      //   222	227	359	finally
      //   227	234	359	finally
      //   5	17	367	java/lang/Exception
      //   17	34	375	java/lang/Exception
      //   58	71	387	finally
      //   71	97	402	finally
      //   97	108	402	finally
      //   113	122	402	finally
      //   174	184	402	finally
      //   47	58	421	java/lang/Exception
      //   58	71	430	java/lang/Exception
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsLogReport
 * JD-Core Version:    0.7.0.1
 */