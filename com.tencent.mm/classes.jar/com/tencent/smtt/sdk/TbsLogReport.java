package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.m;
import com.tencent.smtt.utils.r;
import com.tencent.smtt.utils.s;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;

public class TbsLogReport
{
  private static TbsLogReport a;
  private Handler b = null;
  private Context c;
  private boolean d = false;
  
  private TbsLogReport(Context paramContext)
  {
    this.c = paramContext.getApplicationContext();
    paramContext = new HandlerThread("TbsLogReportThread");
    paramContext.start();
    this.b = new ax(this, paramContext.getLooper());
  }
  
  private String a(int paramInt)
  {
    return paramInt + "|";
  }
  
  private String a(long paramLong)
  {
    try
    {
      String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(paramLong));
      return str;
    }
    catch (Exception localException) {}
    return null;
  }
  
  private String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str + "|";
  }
  
  private JSONArray a()
  {
    Object localObject = d().getString("tbs_download_upload", null);
    if (localObject == null) {
      localObject = new JSONArray();
    }
    for (;;)
    {
      return localObject;
      try
      {
        JSONArray localJSONArray1 = new JSONArray((String)localObject);
        localObject = localJSONArray1;
        if (localJSONArray1.length() > 5)
        {
          JSONArray localJSONArray2 = new JSONArray();
          int i = localJSONArray1.length() - 1;
          localObject = localJSONArray1;
          if (i > localJSONArray1.length() - 5)
          {
            localJSONArray2.put(localJSONArray1.get(i));
            return localJSONArray2;
          }
        }
      }
      catch (Exception localException) {}
    }
    return new JSONArray();
  }
  
  private void a(int paramInt, TbsLogReport.TbsLogInfo paramTbsLogInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(paramInt));
    localStringBuilder.append(a(b.c(this.c)));
    localStringBuilder.append(a(r.a(this.c)));
    localStringBuilder.append(a(an.a().n(this.c)));
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
      paramTbsLogInfo = (TbsLogReport.TbsLogInfo)localObject1;
      paramTbsLogInfo.put(localStringBuilder.toString());
      localObject1 = localSharedPreferences.edit();
      ((SharedPreferences.Editor)localObject1).putString("tbs_download_upload", paramTbsLogInfo.toString());
      ((SharedPreferences.Editor)localObject1).commit();
      if ((!this.d) && (paramInt == TbsLogReport.EventType.TYPE_LOAD.a)) {
        return;
      }
      b();
    }
    localStringBuilder.append(a((String)localObject1));
    localObject1 = this.c.getPackageName();
    localStringBuilder.append(a((String)localObject1));
    if ("com.tencent.mm".equals(localObject1))
    {
      localStringBuilder.append(a(b.a(this.c, "com.tencent.mm.BuildInfo.CLIENT_VERSION")));
      localStringBuilder.append(a(a(TbsLogReport.TbsLogInfo.a(paramTbsLogInfo))));
      localStringBuilder.append(a(TbsLogReport.TbsLogInfo.b(paramTbsLogInfo)));
      localStringBuilder.append(a(TbsLogReport.TbsLogInfo.c(paramTbsLogInfo)));
      localStringBuilder.append(a(TbsLogReport.TbsLogInfo.d(paramTbsLogInfo)));
      localStringBuilder.append(a(TbsLogReport.TbsLogInfo.e(paramTbsLogInfo)));
      localStringBuilder.append(a(TbsLogReport.TbsLogInfo.f(paramTbsLogInfo)));
      localStringBuilder.append(a(TbsLogReport.TbsLogInfo.g(paramTbsLogInfo)));
      localStringBuilder.append(a(TbsLogReport.TbsLogInfo.h(paramTbsLogInfo)));
      localStringBuilder.append(a(TbsLogReport.TbsLogInfo.i(paramTbsLogInfo)));
      localStringBuilder.append(a(TbsLogReport.TbsLogInfo.j(paramTbsLogInfo)));
      localStringBuilder.append(b(TbsLogReport.TbsLogInfo.k(paramTbsLogInfo)));
      localStringBuilder.append(b(TbsLogReport.TbsLogInfo.l(paramTbsLogInfo)));
      localStringBuilder.append(b(TbsLogReport.TbsLogInfo.m(paramTbsLogInfo)));
      localStringBuilder.append(a(TbsLogReport.TbsLogInfo.n(paramTbsLogInfo)));
      localStringBuilder.append(a(paramTbsLogInfo.a));
      localStringBuilder.append(a(TbsLogReport.TbsLogInfo.o(paramTbsLogInfo)));
      localStringBuilder.append(a(TbsLogReport.TbsLogInfo.p(paramTbsLogInfo)));
      localStringBuilder.append(a(TbsDownloadConfig.getInstance(this.c).mPreferences.getInt("tbs_download_version", 0)));
      localStringBuilder.append(a(b.f(this.c)));
      localStringBuilder.append(a("3.6.0.1350_43617"));
      localStringBuilder.append(false);
      localSharedPreferences = d();
      localObject1 = a();
      localObject2 = new JSONArray();
      if (((JSONArray)localObject2).length() < 5) {
        break label572;
      }
      i = 4;
      paramTbsLogInfo = (TbsLogReport.TbsLogInfo)localObject2;
      if (i <= 0) {
        break label575;
      }
    }
    label572:
    label575:
    return;
  }
  
  private void a(int paramInt, TbsLogReport.TbsLogInfo paramTbsLogInfo, TbsLogReport.EventType paramEventType)
  {
    paramTbsLogInfo.setErrorCode(paramInt);
    paramTbsLogInfo.setEventTime(System.currentTimeMillis());
    QbSdk.m.onInstallFinish(paramInt);
    eventReport(paramEventType, paramTbsLogInfo);
  }
  
  private String b(long paramLong)
  {
    return paramLong + "|";
  }
  
  private void b()
  {
    if ((QbSdk.n != null) && (QbSdk.n.containsKey(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD)) && (QbSdk.n.get(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false")))
    {
      TbsLog.i("upload", "[TbsLogReport.sendLogReportRequest] -- SET_SENDREQUEST_AND_UPLOAD is false");
      return;
    }
    TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat]");
    Object localObject = a();
    if ((localObject == null) || (((JSONArray)localObject).length() == 0))
    {
      TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat] no data");
      return;
    }
    TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat] jsonArray:" + localObject);
    try
    {
      localObject = m.a(s.a(this.c).c(), ((JSONArray)localObject).toString().getBytes("utf-8"), new az(this), true);
      TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat] response:" + (String)localObject + " testcase: -1");
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  private void c()
  {
    SharedPreferences.Editor localEditor = d().edit();
    localEditor.remove("tbs_download_upload");
    localEditor.commit();
  }
  
  private SharedPreferences d()
  {
    return this.c.getSharedPreferences("tbs_download_stat", 4);
  }
  
  public static TbsLogReport getInstance(Context paramContext)
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new TbsLogReport(paramContext);
      }
      return a;
    }
    finally {}
  }
  
  public void clear()
  {
    try
    {
      SharedPreferences.Editor localEditor = d().edit();
      localEditor.clear();
      localEditor.commit();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void dailyReport()
  {
    this.b.sendEmptyMessage(601);
  }
  
  public void eventReport(TbsLogReport.EventType paramEventType, TbsLogReport.TbsLogInfo paramTbsLogInfo)
  {
    try
    {
      paramTbsLogInfo = (TbsLogReport.TbsLogInfo)paramTbsLogInfo.clone();
      Message localMessage = this.b.obtainMessage();
      localMessage.what = 600;
      localMessage.arg1 = paramEventType.a;
      localMessage.obj = paramTbsLogInfo;
      this.b.sendMessage(localMessage);
      return;
    }
    catch (Throwable paramEventType)
    {
      TbsLog.w("upload", "[TbsLogReport.eventReport] error, message=" + paramEventType.getMessage());
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
    //   0: getstatic 335	com/tencent/smtt/sdk/QbSdk:n	Ljava/util/Map;
    //   3: ifnull +47 -> 50
    //   6: getstatic 335	com/tencent/smtt/sdk/QbSdk:n	Ljava/util/Map;
    //   9: getstatic 338	com/tencent/smtt/sdk/QbSdk:KEY_SET_SENDREQUEST_AND_UPLOAD	Ljava/lang/String;
    //   12: invokeinterface 343 2 0
    //   17: ifeq +33 -> 50
    //   20: getstatic 335	com/tencent/smtt/sdk/QbSdk:n	Ljava/util/Map;
    //   23: getstatic 338	com/tencent/smtt/sdk/QbSdk:KEY_SET_SENDREQUEST_AND_UPLOAD	Ljava/lang/String;
    //   26: invokeinterface 346 2 0
    //   31: ldc_w 348
    //   34: invokevirtual 349	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   37: ifeq +13 -> 50
    //   40: ldc_w 266
    //   43: ldc_w 450
    //   46: invokestatic 353	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   49: return
    //   50: aload_0
    //   51: getfield 35	com/tencent/smtt/sdk/TbsLogReport:c	Landroid/content/Context;
    //   54: invokestatic 455	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   57: iconst_3
    //   58: if_icmpne -9 -> 49
    //   61: invokestatic 458	com/tencent/smtt/utils/TbsLog:getTbsLogFilePath	()Ljava/lang/String;
    //   64: astore 9
    //   66: aload 9
    //   68: ifnull -19 -> 49
    //   71: invokestatic 463	com/tencent/smtt/utils/n:a	()Lcom/tencent/smtt/utils/n;
    //   74: invokevirtual 465	com/tencent/smtt/utils/n:b	()Ljava/lang/String;
    //   77: astore 6
    //   79: aload_0
    //   80: getfield 35	com/tencent/smtt/sdk/TbsLogReport:c	Landroid/content/Context;
    //   83: invokestatic 136	com/tencent/smtt/utils/b:c	(Landroid/content/Context;)Ljava/lang/String;
    //   86: astore_3
    //   87: aload_0
    //   88: getfield 35	com/tencent/smtt/sdk/TbsLogReport:c	Landroid/content/Context;
    //   91: invokestatic 255	com/tencent/smtt/utils/b:f	(Landroid/content/Context;)Ljava/lang/String;
    //   94: astore_2
    //   95: aload_3
    //   96: invokevirtual 468	java/lang/String:getBytes	()[B
    //   99: astore_3
    //   100: aload_2
    //   101: invokevirtual 468	java/lang/String:getBytes	()[B
    //   104: astore 4
    //   106: aload_3
    //   107: astore_2
    //   108: invokestatic 463	com/tencent/smtt/utils/n:a	()Lcom/tencent/smtt/utils/n;
    //   111: aload_3
    //   112: invokevirtual 471	com/tencent/smtt/utils/n:a	([B)[B
    //   115: astore_3
    //   116: aload_3
    //   117: astore_2
    //   118: invokestatic 463	com/tencent/smtt/utils/n:a	()Lcom/tencent/smtt/utils/n;
    //   121: aload 4
    //   123: invokevirtual 471	com/tencent/smtt/utils/n:a	([B)[B
    //   126: astore 5
    //   128: aload 5
    //   130: astore_2
    //   131: aload_3
    //   132: astore 4
    //   134: aload_2
    //   135: astore_3
    //   136: aload 4
    //   138: invokestatic 474	com/tencent/smtt/utils/n:b	([B)Ljava/lang/String;
    //   141: astore_2
    //   142: aload_3
    //   143: invokestatic 474	com/tencent/smtt/utils/n:b	([B)Ljava/lang/String;
    //   146: astore_3
    //   147: new 58	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   154: aload_0
    //   155: getfield 35	com/tencent/smtt/sdk/TbsLogReport:c	Landroid/content/Context;
    //   158: invokestatic 370	com/tencent/smtt/utils/s:a	(Landroid/content/Context;)Lcom/tencent/smtt/utils/s;
    //   161: invokevirtual 476	com/tencent/smtt/utils/s:e	()Ljava/lang/String;
    //   164: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: aload_2
    //   168: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: ldc_w 478
    //   174: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: aload_3
    //   178: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: astore 7
    //   186: new 480	java/util/HashMap
    //   189: dup
    //   190: invokespecial 481	java/util/HashMap:<init>	()V
    //   193: astore 8
    //   195: aload 8
    //   197: ldc_w 483
    //   200: ldc_w 485
    //   203: invokeinterface 488 3 0
    //   208: pop
    //   209: aload 8
    //   211: ldc_w 490
    //   214: ldc 161
    //   216: invokeinterface 488 3 0
    //   221: pop
    //   222: aload 8
    //   224: ldc_w 492
    //   227: aload_0
    //   228: getfield 35	com/tencent/smtt/sdk/TbsLogReport:c	Landroid/content/Context;
    //   231: invokestatic 142	com/tencent/smtt/utils/r:a	(Landroid/content/Context;)Ljava/lang/String;
    //   234: invokeinterface 488 3 0
    //   239: pop
    //   240: new 494	java/io/File
    //   243: dup
    //   244: getstatic 498	com/tencent/smtt/utils/j:a	Ljava/lang/String;
    //   247: invokespecial 499	java/io/File:<init>	(Ljava/lang/String;)V
    //   250: pop
    //   251: new 10	com/tencent/smtt/sdk/TbsLogReport$a
    //   254: dup
    //   255: aload 9
    //   257: new 58	java/lang/StringBuilder
    //   260: dup
    //   261: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   264: getstatic 498	com/tencent/smtt/utils/j:a	Ljava/lang/String;
    //   267: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: ldc_w 501
    //   273: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   279: invokespecial 503	com/tencent/smtt/sdk/TbsLogReport$a:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   282: invokevirtual 505	com/tencent/smtt/sdk/TbsLogReport$a:a	()V
    //   285: new 494	java/io/File
    //   288: dup
    //   289: getstatic 498	com/tencent/smtt/utils/j:a	Ljava/lang/String;
    //   292: ldc_w 507
    //   295: invokespecial 508	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   298: astore 4
    //   300: new 510	java/io/FileInputStream
    //   303: dup
    //   304: aload 4
    //   306: invokespecial 513	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   309: astore 5
    //   311: sipush 8192
    //   314: newarray byte
    //   316: astore_2
    //   317: new 515	java/io/ByteArrayOutputStream
    //   320: dup
    //   321: invokespecial 516	java/io/ByteArrayOutputStream:<init>	()V
    //   324: astore_3
    //   325: aload 5
    //   327: aload_2
    //   328: invokevirtual 520	java/io/FileInputStream:read	([B)I
    //   331: istore_1
    //   332: iload_1
    //   333: iconst_m1
    //   334: if_icmpeq +91 -> 425
    //   337: aload_3
    //   338: aload_2
    //   339: iconst_0
    //   340: iload_1
    //   341: invokevirtual 524	java/io/ByteArrayOutputStream:write	([BII)V
    //   344: goto -19 -> 325
    //   347: astore_2
    //   348: aload_3
    //   349: astore_2
    //   350: aload 5
    //   352: astore_3
    //   353: aload_3
    //   354: ifnull +7 -> 361
    //   357: aload_3
    //   358: invokevirtual 527	java/io/FileInputStream:close	()V
    //   361: aload_2
    //   362: ifnull +7 -> 369
    //   365: aload_2
    //   366: invokevirtual 528	java/io/ByteArrayOutputStream:close	()V
    //   369: aload 4
    //   371: ifnull +234 -> 605
    //   374: aload 4
    //   376: invokevirtual 531	java/io/File:delete	()Z
    //   379: pop
    //   380: aconst_null
    //   381: astore_2
    //   382: new 58	java/lang/StringBuilder
    //   385: dup
    //   386: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   389: aload 7
    //   391: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: ldc_w 533
    //   397: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: aload 6
    //   402: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   408: aload 8
    //   410: aload_2
    //   411: new 535	com/tencent/smtt/sdk/ay
    //   414: dup
    //   415: aload_0
    //   416: invokespecial 536	com/tencent/smtt/sdk/ay:<init>	(Lcom/tencent/smtt/sdk/TbsLogReport;)V
    //   419: iconst_0
    //   420: invokestatic 539	com/tencent/smtt/utils/m:a	(Ljava/lang/String;Ljava/util/Map;[BLcom/tencent/smtt/utils/m$a;Z)Ljava/lang/String;
    //   423: pop
    //   424: return
    //   425: aload_3
    //   426: invokevirtual 542	java/io/ByteArrayOutputStream:flush	()V
    //   429: invokestatic 463	com/tencent/smtt/utils/n:a	()Lcom/tencent/smtt/utils/n;
    //   432: aload_3
    //   433: invokevirtual 545	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   436: invokevirtual 471	com/tencent/smtt/utils/n:a	([B)[B
    //   439: astore_2
    //   440: aload 5
    //   442: invokevirtual 527	java/io/FileInputStream:close	()V
    //   445: aload_3
    //   446: invokevirtual 528	java/io/ByteArrayOutputStream:close	()V
    //   449: aload 4
    //   451: invokevirtual 531	java/io/File:delete	()Z
    //   454: pop
    //   455: goto -73 -> 382
    //   458: astore_2
    //   459: aconst_null
    //   460: astore_3
    //   461: aconst_null
    //   462: astore 6
    //   464: aconst_null
    //   465: astore 4
    //   467: aload 4
    //   469: ifnull +8 -> 477
    //   472: aload 4
    //   474: invokevirtual 527	java/io/FileInputStream:close	()V
    //   477: aload_3
    //   478: ifnull +7 -> 485
    //   481: aload_3
    //   482: invokevirtual 528	java/io/ByteArrayOutputStream:close	()V
    //   485: aload 6
    //   487: ifnull +9 -> 496
    //   490: aload 6
    //   492: invokevirtual 531	java/io/File:delete	()Z
    //   495: pop
    //   496: aload_2
    //   497: athrow
    //   498: astore 5
    //   500: goto -55 -> 445
    //   503: astore_3
    //   504: goto -55 -> 449
    //   507: astore_3
    //   508: goto -147 -> 361
    //   511: astore_2
    //   512: goto -143 -> 369
    //   515: astore 4
    //   517: goto -40 -> 477
    //   520: astore_3
    //   521: goto -36 -> 485
    //   524: astore_2
    //   525: aconst_null
    //   526: astore_3
    //   527: aconst_null
    //   528: astore 5
    //   530: aload 4
    //   532: astore 6
    //   534: aload 5
    //   536: astore 4
    //   538: goto -71 -> 467
    //   541: astore_2
    //   542: aconst_null
    //   543: astore_3
    //   544: aload 4
    //   546: astore 6
    //   548: aload 5
    //   550: astore 4
    //   552: goto -85 -> 467
    //   555: astore_2
    //   556: aload 4
    //   558: astore 6
    //   560: aload 5
    //   562: astore 4
    //   564: goto -97 -> 467
    //   567: astore_2
    //   568: aconst_null
    //   569: astore_2
    //   570: aconst_null
    //   571: astore 4
    //   573: aconst_null
    //   574: astore_3
    //   575: goto -222 -> 353
    //   578: astore_2
    //   579: aconst_null
    //   580: astore_2
    //   581: aconst_null
    //   582: astore_3
    //   583: goto -230 -> 353
    //   586: astore_2
    //   587: aconst_null
    //   588: astore_2
    //   589: aload 5
    //   591: astore_3
    //   592: goto -239 -> 353
    //   595: astore_3
    //   596: aload 4
    //   598: astore_3
    //   599: aload_2
    //   600: astore 4
    //   602: goto -466 -> 136
    //   605: aconst_null
    //   606: astore_2
    //   607: goto -225 -> 382
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	610	0	this	TbsLogReport
    //   331	10	1	i	int
    //   94	245	2	localObject1	Object
    //   347	1	2	localException1	Exception
    //   349	91	2	localObject2	Object
    //   458	39	2	localObject3	Object
    //   511	1	2	localException2	Exception
    //   524	1	2	localObject4	Object
    //   541	1	2	localObject5	Object
    //   555	1	2	localObject6	Object
    //   567	1	2	localException3	Exception
    //   569	1	2	localObject7	Object
    //   578	1	2	localException4	Exception
    //   580	1	2	localObject8	Object
    //   586	1	2	localException5	Exception
    //   588	19	2	localObject9	Object
    //   86	396	3	localObject10	Object
    //   503	1	3	localException6	Exception
    //   507	1	3	localException7	Exception
    //   520	1	3	localException8	Exception
    //   526	66	3	localObject11	Object
    //   595	1	3	localException9	Exception
    //   598	1	3	localObject12	Object
    //   104	369	4	localObject13	Object
    //   515	16	4	localException10	Exception
    //   536	65	4	localObject14	Object
    //   126	315	5	localObject15	Object
    //   498	1	5	localException11	Exception
    //   528	62	5	localObject16	Object
    //   77	482	6	localObject17	Object
    //   184	206	7	str1	String
    //   193	216	8	localHashMap	java.util.HashMap
    //   64	192	9	str2	String
    // Exception table:
    //   from	to	target	type
    //   325	332	347	java/lang/Exception
    //   337	344	347	java/lang/Exception
    //   425	440	347	java/lang/Exception
    //   240	300	458	finally
    //   440	445	498	java/lang/Exception
    //   445	449	503	java/lang/Exception
    //   357	361	507	java/lang/Exception
    //   365	369	511	java/lang/Exception
    //   472	477	515	java/lang/Exception
    //   481	485	520	java/lang/Exception
    //   300	311	524	finally
    //   311	325	541	finally
    //   325	332	555	finally
    //   337	344	555	finally
    //   425	440	555	finally
    //   240	300	567	java/lang/Exception
    //   300	311	578	java/lang/Exception
    //   311	325	586	java/lang/Exception
    //   108	116	595	java/lang/Exception
    //   118	128	595	java/lang/Exception
  }
  
  public void setInstallErrorCode(int paramInt, String paramString)
  {
    setInstallErrorCode(paramInt, paramString, TbsLogReport.EventType.TYPE_INSTALL);
  }
  
  public void setInstallErrorCode(int paramInt, String paramString, TbsLogReport.EventType paramEventType)
  {
    if ((paramInt != 200) && (paramInt != 220) && (paramInt != 221)) {
      TbsLog.i("TbsDownload", "error occured in installation, errorCode:" + paramInt, true);
    }
    TbsLogReport.TbsLogInfo localTbsLogInfo = tbsLogInfo();
    localTbsLogInfo.setFailDetail(paramString);
    a(paramInt, localTbsLogInfo, paramEventType);
  }
  
  public void setInstallErrorCode(int paramInt, Throwable paramThrowable)
  {
    TbsLogReport.TbsLogInfo localTbsLogInfo = tbsLogInfo();
    localTbsLogInfo.setFailDetail(paramThrowable);
    a(paramInt, localTbsLogInfo, TbsLogReport.EventType.TYPE_INSTALL);
  }
  
  public void setLoadErrorCode(int paramInt, String paramString)
  {
    TbsLogReport.TbsLogInfo localTbsLogInfo = tbsLogInfo();
    localTbsLogInfo.setErrorCode(paramInt);
    localTbsLogInfo.setEventTime(System.currentTimeMillis());
    localTbsLogInfo.setFailDetail(paramString);
    eventReport(TbsLogReport.EventType.TYPE_LOAD, localTbsLogInfo);
  }
  
  public void setLoadErrorCode(int paramInt, Throwable paramThrowable)
  {
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
  }
  
  public void setShouldUploadEventReport(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public TbsLogReport.TbsLogInfo tbsLogInfo()
  {
    return new TbsLogReport.TbsLogInfo(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsLogReport
 * JD-Core Version:    0.7.0.1
 */