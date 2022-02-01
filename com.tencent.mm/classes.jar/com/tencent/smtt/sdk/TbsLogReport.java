package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
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
import com.tencent.smtt.utils.l;
import com.tencent.smtt.utils.n;
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
    localStringBuilder.append(a(b.d(this.c)));
    localStringBuilder.append(a(l.a(this.c)));
    localStringBuilder.append(a(o.a().i(this.c)));
    Object localObject1 = Build.MODEL;
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
        localStringBuilder.append(a(b.b(this.c)));
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
        break label643;
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
      localStringBuilder.append(a(b.g(this.c)));
      localStringBuilder.append(a("4.4.0.0005_43804"));
      localStringBuilder.append(false);
      localSharedPreferences = d();
      localObject1 = a();
      localObject2 = new JSONArray();
      if (((JSONArray)localObject2).length() < 5) {
        break label578;
      }
      i = 4;
      paramTbsLogInfo = (TbsLogInfo)localObject2;
      if (i <= 0) {
        break label581;
      }
    }
    label578:
    label581:
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
    Object localObject = a();
    if ((localObject == null) || (((JSONArray)localObject).length() == 0))
    {
      TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat] no data");
      AppMethodBeat.o(54974);
      return;
    }
    TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat] jsonArray:".concat(String.valueOf(localObject)));
    try
    {
      localObject = g.a(n.a(this.c).c(), ((JSONArray)localObject).toString().getBytes("utf-8"), new g.a()
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
      TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat] response:" + (String)localObject + " testcase: -1");
      AppMethodBeat.o(54974);
      return;
    }
    catch (Throwable localThrowable)
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
    catch (Throwable paramEventType)
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
    //   0: ldc_w 482
    //   3: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: getstatic 359	com/tencent/smtt/sdk/QbSdk:mSettings	Ljava/util/Map;
    //   9: ifnull +53 -> 62
    //   12: getstatic 359	com/tencent/smtt/sdk/QbSdk:mSettings	Ljava/util/Map;
    //   15: getstatic 362	com/tencent/smtt/sdk/QbSdk:KEY_SET_SENDREQUEST_AND_UPLOAD	Ljava/lang/String;
    //   18: invokeinterface 367 2 0
    //   23: ifeq +39 -> 62
    //   26: getstatic 359	com/tencent/smtt/sdk/QbSdk:mSettings	Ljava/util/Map;
    //   29: getstatic 362	com/tencent/smtt/sdk/QbSdk:KEY_SET_SENDREQUEST_AND_UPLOAD	Ljava/lang/String;
    //   32: invokeinterface 370 2 0
    //   37: ldc_w 372
    //   40: invokevirtual 373	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   43: ifeq +19 -> 62
    //   46: ldc_w 285
    //   49: ldc_w 484
    //   52: invokestatic 377	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   55: ldc_w 482
    //   58: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: return
    //   62: aload_0
    //   63: getfield 50	com/tencent/smtt/sdk/TbsLogReport:c	Landroid/content/Context;
    //   66: invokestatic 489	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   69: iconst_3
    //   70: if_icmpeq +10 -> 80
    //   73: ldc_w 482
    //   76: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   79: return
    //   80: invokestatic 492	com/tencent/smtt/utils/TbsLog:getTbsLogFilePath	()Ljava/lang/String;
    //   83: astore 9
    //   85: aload 9
    //   87: ifnonnull +10 -> 97
    //   90: ldc_w 482
    //   93: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: return
    //   97: invokestatic 497	com/tencent/smtt/utils/h:a	()Lcom/tencent/smtt/utils/h;
    //   100: invokevirtual 499	com/tencent/smtt/utils/h:b	()Ljava/lang/String;
    //   103: astore 6
    //   105: aload_0
    //   106: getfield 50	com/tencent/smtt/sdk/TbsLogReport:c	Landroid/content/Context;
    //   109: invokestatic 157	com/tencent/smtt/utils/b:d	(Landroid/content/Context;)Ljava/lang/String;
    //   112: astore_3
    //   113: aload_0
    //   114: getfield 50	com/tencent/smtt/sdk/TbsLogReport:c	Landroid/content/Context;
    //   117: invokestatic 274	com/tencent/smtt/utils/b:g	(Landroid/content/Context;)Ljava/lang/String;
    //   120: astore_2
    //   121: aload_3
    //   122: invokevirtual 502	java/lang/String:getBytes	()[B
    //   125: astore_3
    //   126: aload_2
    //   127: invokevirtual 502	java/lang/String:getBytes	()[B
    //   130: astore 4
    //   132: aload_3
    //   133: astore_2
    //   134: invokestatic 497	com/tencent/smtt/utils/h:a	()Lcom/tencent/smtt/utils/h;
    //   137: aload_3
    //   138: invokevirtual 505	com/tencent/smtt/utils/h:a	([B)[B
    //   141: astore_3
    //   142: aload_3
    //   143: astore_2
    //   144: invokestatic 497	com/tencent/smtt/utils/h:a	()Lcom/tencent/smtt/utils/h;
    //   147: aload 4
    //   149: invokevirtual 505	com/tencent/smtt/utils/h:a	([B)[B
    //   152: astore 5
    //   154: aload 5
    //   156: astore_2
    //   157: aload_3
    //   158: astore 4
    //   160: aload_2
    //   161: astore_3
    //   162: aload 4
    //   164: invokestatic 508	com/tencent/smtt/utils/h:b	([B)Ljava/lang/String;
    //   167: astore_2
    //   168: aload_3
    //   169: invokestatic 508	com/tencent/smtt/utils/h:b	([B)Ljava/lang/String;
    //   172: astore_3
    //   173: new 75	java/lang/StringBuilder
    //   176: dup
    //   177: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   180: aload_0
    //   181: getfield 50	com/tencent/smtt/sdk/TbsLogReport:c	Landroid/content/Context;
    //   184: invokestatic 397	com/tencent/smtt/utils/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/utils/n;
    //   187: invokevirtual 510	com/tencent/smtt/utils/n:e	()Ljava/lang/String;
    //   190: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: aload_2
    //   194: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: ldc_w 512
    //   200: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: aload_3
    //   204: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: astore 7
    //   212: new 514	java/util/HashMap
    //   215: dup
    //   216: invokespecial 515	java/util/HashMap:<init>	()V
    //   219: astore 8
    //   221: aload 8
    //   223: ldc_w 517
    //   226: ldc_w 519
    //   229: invokeinterface 522 3 0
    //   234: pop
    //   235: aload 8
    //   237: ldc_w 524
    //   240: ldc 181
    //   242: invokeinterface 522 3 0
    //   247: pop
    //   248: aload 8
    //   250: ldc_w 526
    //   253: aload_0
    //   254: getfield 50	com/tencent/smtt/sdk/TbsLogReport:c	Landroid/content/Context;
    //   257: invokestatic 163	com/tencent/smtt/utils/l:a	(Landroid/content/Context;)Ljava/lang/String;
    //   260: invokeinterface 522 3 0
    //   265: pop
    //   266: new 528	java/io/File
    //   269: dup
    //   270: getstatic 532	com/tencent/smtt/utils/f:a	Ljava/lang/String;
    //   273: invokespecial 533	java/io/File:<init>	(Ljava/lang/String;)V
    //   276: pop
    //   277: new 18	com/tencent/smtt/sdk/TbsLogReport$a
    //   280: dup
    //   281: aload 9
    //   283: new 75	java/lang/StringBuilder
    //   286: dup
    //   287: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   290: getstatic 532	com/tencent/smtt/utils/f:a	Ljava/lang/String;
    //   293: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: ldc_w 535
    //   299: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   305: invokespecial 537	com/tencent/smtt/sdk/TbsLogReport$a:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   308: invokevirtual 539	com/tencent/smtt/sdk/TbsLogReport$a:a	()V
    //   311: new 528	java/io/File
    //   314: dup
    //   315: getstatic 532	com/tencent/smtt/utils/f:a	Ljava/lang/String;
    //   318: ldc_w 541
    //   321: invokespecial 542	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   324: astore 4
    //   326: new 544	java/io/FileInputStream
    //   329: dup
    //   330: aload 4
    //   332: invokespecial 547	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   335: astore 5
    //   337: sipush 8192
    //   340: newarray byte
    //   342: astore_2
    //   343: new 549	java/io/ByteArrayOutputStream
    //   346: dup
    //   347: invokespecial 550	java/io/ByteArrayOutputStream:<init>	()V
    //   350: astore_3
    //   351: aload 5
    //   353: aload_2
    //   354: invokevirtual 554	java/io/FileInputStream:read	([B)I
    //   357: istore_1
    //   358: iload_1
    //   359: iconst_m1
    //   360: if_icmpeq +97 -> 457
    //   363: aload_3
    //   364: aload_2
    //   365: iconst_0
    //   366: iload_1
    //   367: invokevirtual 558	java/io/ByteArrayOutputStream:write	([BII)V
    //   370: goto -19 -> 351
    //   373: astore_2
    //   374: aload_3
    //   375: astore_2
    //   376: aload 5
    //   378: astore_3
    //   379: aload_3
    //   380: ifnull +7 -> 387
    //   383: aload_3
    //   384: invokevirtual 561	java/io/FileInputStream:close	()V
    //   387: aload_2
    //   388: ifnull +7 -> 395
    //   391: aload_2
    //   392: invokevirtual 562	java/io/ByteArrayOutputStream:close	()V
    //   395: aload 4
    //   397: ifnull +246 -> 643
    //   400: aload 4
    //   402: invokevirtual 565	java/io/File:delete	()Z
    //   405: pop
    //   406: aconst_null
    //   407: astore_2
    //   408: new 75	java/lang/StringBuilder
    //   411: dup
    //   412: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   415: aload 7
    //   417: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: ldc_w 567
    //   423: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: aload 6
    //   428: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   434: aload 8
    //   436: aload_2
    //   437: new 8	com/tencent/smtt/sdk/TbsLogReport$2
    //   440: dup
    //   441: aload_0
    //   442: invokespecial 568	com/tencent/smtt/sdk/TbsLogReport$2:<init>	(Lcom/tencent/smtt/sdk/TbsLogReport;)V
    //   445: iconst_0
    //   446: invokestatic 571	com/tencent/smtt/utils/g:a	(Ljava/lang/String;Ljava/util/Map;[BLcom/tencent/smtt/utils/g$a;Z)Ljava/lang/String;
    //   449: pop
    //   450: ldc_w 482
    //   453: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   456: return
    //   457: aload_3
    //   458: invokevirtual 574	java/io/ByteArrayOutputStream:flush	()V
    //   461: invokestatic 497	com/tencent/smtt/utils/h:a	()Lcom/tencent/smtt/utils/h;
    //   464: aload_3
    //   465: invokevirtual 577	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   468: invokevirtual 505	com/tencent/smtt/utils/h:a	([B)[B
    //   471: astore_2
    //   472: aload 5
    //   474: invokevirtual 561	java/io/FileInputStream:close	()V
    //   477: aload_3
    //   478: invokevirtual 562	java/io/ByteArrayOutputStream:close	()V
    //   481: aload 4
    //   483: invokevirtual 565	java/io/File:delete	()Z
    //   486: pop
    //   487: goto -79 -> 408
    //   490: astore_2
    //   491: aconst_null
    //   492: astore_3
    //   493: aconst_null
    //   494: astore 6
    //   496: aconst_null
    //   497: astore 4
    //   499: aload 4
    //   501: ifnull +8 -> 509
    //   504: aload 4
    //   506: invokevirtual 561	java/io/FileInputStream:close	()V
    //   509: aload_3
    //   510: ifnull +7 -> 517
    //   513: aload_3
    //   514: invokevirtual 562	java/io/ByteArrayOutputStream:close	()V
    //   517: aload 6
    //   519: ifnull +9 -> 528
    //   522: aload 6
    //   524: invokevirtual 565	java/io/File:delete	()Z
    //   527: pop
    //   528: ldc_w 482
    //   531: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   534: aload_2
    //   535: athrow
    //   536: astore 5
    //   538: goto -61 -> 477
    //   541: astore_3
    //   542: goto -61 -> 481
    //   545: astore_3
    //   546: goto -159 -> 387
    //   549: astore_2
    //   550: goto -155 -> 395
    //   553: astore 4
    //   555: goto -46 -> 509
    //   558: astore_3
    //   559: goto -42 -> 517
    //   562: astore_2
    //   563: aconst_null
    //   564: astore_3
    //   565: aconst_null
    //   566: astore 5
    //   568: aload 4
    //   570: astore 6
    //   572: aload 5
    //   574: astore 4
    //   576: goto -77 -> 499
    //   579: astore_2
    //   580: aconst_null
    //   581: astore_3
    //   582: aload 4
    //   584: astore 6
    //   586: aload 5
    //   588: astore 4
    //   590: goto -91 -> 499
    //   593: astore_2
    //   594: aload 4
    //   596: astore 6
    //   598: aload 5
    //   600: astore 4
    //   602: goto -103 -> 499
    //   605: astore_2
    //   606: aconst_null
    //   607: astore_2
    //   608: aconst_null
    //   609: astore 4
    //   611: aconst_null
    //   612: astore_3
    //   613: goto -234 -> 379
    //   616: astore_2
    //   617: aconst_null
    //   618: astore_2
    //   619: aconst_null
    //   620: astore_3
    //   621: goto -242 -> 379
    //   624: astore_2
    //   625: aconst_null
    //   626: astore_2
    //   627: aload 5
    //   629: astore_3
    //   630: goto -251 -> 379
    //   633: astore_3
    //   634: aload 4
    //   636: astore_3
    //   637: aload_2
    //   638: astore 4
    //   640: goto -478 -> 162
    //   643: aconst_null
    //   644: astore_2
    //   645: goto -237 -> 408
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	648	0	this	TbsLogReport
    //   357	10	1	i	int
    //   120	245	2	localObject1	Object
    //   373	1	2	localException1	Exception
    //   375	97	2	localObject2	Object
    //   490	45	2	localObject3	Object
    //   549	1	2	localException2	Exception
    //   562	1	2	localObject4	Object
    //   579	1	2	localObject5	Object
    //   593	1	2	localObject6	Object
    //   605	1	2	localException3	Exception
    //   607	1	2	localObject7	Object
    //   616	1	2	localException4	Exception
    //   618	1	2	localObject8	Object
    //   624	1	2	localException5	Exception
    //   626	19	2	localObject9	Object
    //   112	402	3	localObject10	Object
    //   541	1	3	localException6	Exception
    //   545	1	3	localException7	Exception
    //   558	1	3	localException8	Exception
    //   564	66	3	localObject11	Object
    //   633	1	3	localException9	Exception
    //   636	1	3	localObject12	Object
    //   130	375	4	localObject13	Object
    //   553	16	4	localException10	Exception
    //   574	65	4	localObject14	Object
    //   152	321	5	localObject15	Object
    //   536	1	5	localException11	Exception
    //   566	62	5	localObject16	Object
    //   103	494	6	localObject17	Object
    //   210	206	7	str1	String
    //   219	216	8	localHashMap	java.util.HashMap
    //   83	199	9	str2	String
    // Exception table:
    //   from	to	target	type
    //   351	358	373	java/lang/Exception
    //   363	370	373	java/lang/Exception
    //   457	472	373	java/lang/Exception
    //   266	326	490	finally
    //   472	477	536	java/lang/Exception
    //   477	481	541	java/lang/Exception
    //   383	387	545	java/lang/Exception
    //   391	395	549	java/lang/Exception
    //   504	509	553	java/lang/Exception
    //   513	517	558	java/lang/Exception
    //   326	337	562	finally
    //   337	351	579	finally
    //   351	358	593	finally
    //   363	370	593	finally
    //   457	472	593	finally
    //   266	326	605	java/lang/Exception
    //   326	337	616	java/lang/Exception
    //   337	351	624	java/lang/Exception
    //   134	142	633	java/lang/Exception
    //   144	154	633	java/lang/Exception
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsLogReport
 * JD-Core Version:    0.7.0.1
 */