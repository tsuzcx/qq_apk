package com.tencent.recovery.wx.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mm.protocal.protobuf.dhg;
import com.tencent.mm.recovery.b.3;
import com.tencent.mm.recovery.c;
import com.tencent.mm.recoveryv2.g;
import com.tencent.mm.recoveryv2.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.recovery.model.RecoveryHandleItem;
import com.tencent.recovery.report.RecoveryReporter;
import com.tencent.recovery.service.RecoveryUploadService;
import com.tencent.recovery.util.Util;
import com.tencent.recovery.wx.WXRecoveryVersion;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@SuppressLint({"LongLogTag"})
public class WXRecoveryUploadService
  extends RecoveryUploadService
{
  private static final String EXTRA_FETCH_BASE_ID = "extra_fetch_base_id";
  private static final String EXTRA_PATCH_URL = "extra_patch_url";
  private static final String RECOVERY_TAG = "MicroMsg.recovery.service";
  private static final String TAG = "Recovery.WXRecoveryUploadService";
  private static final String UNIT_REPORT_TAG = "RecoveryHandle";
  
  private static int compareVersion(String paramString1, String paramString2)
  {
    int i = 0;
    try
    {
      int j = Integer.decode(paramString1).intValue();
      int k = Integer.decode(paramString2).intValue();
      if (j > k) {
        i = 1;
      }
      while (k <= j) {
        return i;
      }
      return -1;
    }
    catch (Exception paramString1) {}
    return 0;
  }
  
  public static String convertStreamToString(InputStream paramInputStream)
  {
    if (paramInputStream == null) {
      return "";
    }
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream));
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      for (;;)
      {
        String str = localBufferedReader.readLine();
        if (str == null) {
          break;
        }
        localStringBuilder.append(str + "\n");
      }
      try
      {
        paramInputStream.close();
        throw localObject;
      }
      catch (IOException paramInputStream)
      {
        for (;;)
        {
          RecoveryLog.printErrStackTrace("Recovery.WXRecoveryUploadService", paramInputStream, "", new Object[0]);
        }
      }
    }
    catch (IOException localIOException)
    {
      localIOException = localIOException;
      RecoveryLog.printErrStackTrace("Recovery.WXRecoveryUploadService", localIOException, "", new Object[0]);
      try
      {
        paramInputStream.close();
        for (;;)
        {
          return localStringBuilder.toString();
          try
          {
            paramInputStream.close();
          }
          catch (IOException paramInputStream)
          {
            RecoveryLog.printErrStackTrace("Recovery.WXRecoveryUploadService", paramInputStream, "", new Object[0]);
          }
        }
      }
      catch (IOException paramInputStream)
      {
        for (;;)
        {
          RecoveryLog.printErrStackTrace("Recovery.WXRecoveryUploadService", paramInputStream, "", new Object[0]);
        }
      }
    }
    finally {}
  }
  
  public static void fetchTinkerPatch(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(paramContext, WXRecoveryUploadService.class);
    localIntent.putExtra("extra_fetch_base_id", paramString);
    try
    {
      paramContext.startService(localIntent);
      return;
    }
    catch (Throwable paramContext)
    {
      Log.w("MicroMsg.recovery.service", "start service fail", new Object[] { paramContext });
    }
  }
  
  private void fetchTinkerPatch(Intent paramIntent)
  {
    arrayOfInt = new int[1];
    arrayOfInt[0] = 0;
    for (;;)
    {
      try
      {
        localc = new c(arrayOfInt);
        String str2 = paramIntent.getStringExtra("extra_patch_url");
        str1 = str2;
        if (TextUtils.isEmpty(str2)) {
          str1 = paramIntent.getDataString();
        }
        if (!TextUtils.isEmpty(str1)) {
          continue;
        }
        g.i("MicroMsg.recovery.service", "#fetchTinkerPatch, fetch patch url with cgi");
        com.tencent.mm.recovery.b.b(getApplicationContext(), localc);
      }
      catch (Throwable paramIntent)
      {
        c localc;
        String str1;
        g.w("MicroMsg.recovery.service", "fetch error", paramIntent);
        arrayOfInt[0] = 10;
        continue;
      }
      g.i("MicroMsg.recovery.service", "#fetchTinkerPatch done, status = " + arrayOfInt[0]);
      j.jT(getApplication()).EA(false).arJ(arrayOfInt[0]).arg();
      return;
      g.i("MicroMsg.recovery.service", "#fetchTinkerPatch, download patch with given url, url = ".concat(String.valueOf(str1)));
      com.tencent.mm.recovery.b.a(getApplicationContext(), str1, localc);
    }
  }
  
  /* Error */
  private boolean pushData(JSONArray paramJSONArray, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: aload 6
    //   8: astore 4
    //   10: aload_0
    //   11: invokestatic 212	com/tencent/recovery/wx/util/WXUtil:getWXUserName	(Landroid/content/Context;)Ljava/lang/String;
    //   14: astore 7
    //   16: aload 6
    //   18: astore 4
    //   20: new 62	java/lang/StringBuilder
    //   23: dup
    //   24: ldc 214
    //   26: invokespecial 160	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   29: getstatic 220	android/os/Build$VERSION:SDK_INT	I
    //   32: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   35: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: astore 9
    //   40: aload 6
    //   42: astore 4
    //   44: new 222	org/json/JSONObject
    //   47: dup
    //   48: invokespecial 223	org/json/JSONObject:<init>	()V
    //   51: ldc 225
    //   53: new 222	org/json/JSONObject
    //   56: dup
    //   57: invokespecial 223	org/json/JSONObject:<init>	()V
    //   60: ldc 227
    //   62: iconst_1
    //   63: invokevirtual 231	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   66: ldc 233
    //   68: new 62	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   75: getstatic 238	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   78: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: ldc 240
    //   83: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: getstatic 243	android/os/Build:MODEL	Ljava/lang/String;
    //   89: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokevirtual 246	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   98: ldc 248
    //   100: aload 9
    //   102: invokevirtual 246	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   105: ldc 250
    //   107: invokestatic 256	java/lang/System:currentTimeMillis	()J
    //   110: invokevirtual 259	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   113: invokevirtual 246	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   116: ldc_w 261
    //   119: aload_1
    //   120: invokevirtual 246	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   123: invokevirtual 262	org/json/JSONObject:toString	()Ljava/lang/String;
    //   126: invokevirtual 266	java/lang/String:getBytes	()[B
    //   129: astore 8
    //   131: aload 6
    //   133: astore 4
    //   135: aload 8
    //   137: arraylength
    //   138: istore_3
    //   139: aload 6
    //   141: astore 4
    //   143: ldc_w 268
    //   146: iconst_2
    //   147: anewarray 78	java/lang/Object
    //   150: dup
    //   151: iconst_0
    //   152: aload_2
    //   153: invokestatic 40	java/lang/Integer:decode	(Ljava/lang/String;)Ljava/lang/Integer;
    //   156: aastore
    //   157: dup
    //   158: iconst_1
    //   159: iload_3
    //   160: invokestatic 271	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   163: aastore
    //   164: invokestatic 275	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   167: invokevirtual 266	java/lang/String:getBytes	()[B
    //   170: invokestatic 281	com/tencent/recovery/wx/util/EncryptUtil:getMessageDigest	([B)Ljava/lang/String;
    //   173: invokevirtual 284	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   176: astore_1
    //   177: aload 6
    //   179: astore 4
    //   181: aload 8
    //   183: invokestatic 288	com/tencent/recovery/wx/util/EncryptUtil:compress	([B)[B
    //   186: astore 10
    //   188: aload 6
    //   190: astore 4
    //   192: new 290	com/tencent/recovery/wx/util/PByteArray
    //   195: dup
    //   196: invokespecial 291	com/tencent/recovery/wx/util/PByteArray:<init>	()V
    //   199: astore 8
    //   201: aload 6
    //   203: astore 4
    //   205: aload 8
    //   207: aload 10
    //   209: aload_1
    //   210: invokevirtual 266	java/lang/String:getBytes	()[B
    //   213: invokestatic 295	com/tencent/recovery/wx/util/EncryptUtil:DESEncrypt	(Lcom/tencent/recovery/wx/util/PByteArray;[B[B)I
    //   216: pop
    //   217: aload 6
    //   219: astore 4
    //   221: new 62	java/lang/StringBuilder
    //   224: dup
    //   225: sipush 256
    //   228: invokespecial 298	java/lang/StringBuilder:<init>	(I)V
    //   231: ldc_w 300
    //   234: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: getstatic 305	com/tencent/recovery/wx/R$string:host_support_weixin_qq_com	I
    //   240: invokestatic 311	com/tencent/mm/sdk/platformtools/WeChatHosts:domainString	(I)Ljava/lang/String;
    //   243: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: ldc_w 313
    //   249: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: aload_2
    //   253: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: ldc_w 315
    //   259: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: aload 9
    //   264: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: ldc_w 317
    //   270: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: iload_3
    //   274: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   277: ldc_w 319
    //   280: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: aload_1
    //   284: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: ldc_w 321
    //   290: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: astore_1
    //   294: aload 7
    //   296: ifnull +32 -> 328
    //   299: aload 6
    //   301: astore 4
    //   303: aload 7
    //   305: invokevirtual 324	java/lang/String:length	()I
    //   308: ifeq +20 -> 328
    //   311: aload 6
    //   313: astore 4
    //   315: aload_1
    //   316: ldc_w 326
    //   319: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: aload 7
    //   324: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: pop
    //   328: aload 6
    //   330: astore 4
    //   332: new 328	java/net/URL
    //   335: dup
    //   336: aload_1
    //   337: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   340: invokespecial 329	java/net/URL:<init>	(Ljava/lang/String;)V
    //   343: invokevirtual 333	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   346: checkcast 335	java/net/HttpURLConnection
    //   349: astore_1
    //   350: aload_1
    //   351: ldc_w 337
    //   354: invokevirtual 340	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   357: aload_1
    //   358: sipush 20000
    //   361: invokevirtual 343	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   364: aload_1
    //   365: sipush 10000
    //   368: invokevirtual 346	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   371: aload_1
    //   372: ldc_w 348
    //   375: ldc_w 350
    //   378: invokevirtual 353	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   381: aload_1
    //   382: iconst_1
    //   383: invokevirtual 357	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   386: aload_1
    //   387: iconst_1
    //   388: invokevirtual 360	java/net/HttpURLConnection:setDoInput	(Z)V
    //   391: aload_1
    //   392: invokevirtual 363	java/net/HttpURLConnection:connect	()V
    //   395: aload_1
    //   396: invokevirtual 367	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   399: astore 4
    //   401: aload 4
    //   403: aload 8
    //   405: getfield 370	com/tencent/recovery/wx/util/PByteArray:value	[B
    //   408: invokevirtual 376	java/io/OutputStream:write	([B)V
    //   411: aload 4
    //   413: invokevirtual 379	java/io/OutputStream:flush	()V
    //   416: aload 4
    //   418: invokevirtual 380	java/io/OutputStream:close	()V
    //   421: aload_1
    //   422: invokevirtual 383	java/net/HttpURLConnection:getResponseCode	()I
    //   425: sipush 200
    //   428: if_icmpeq +90 -> 518
    //   431: aload_1
    //   432: invokevirtual 387	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   435: invokestatic 389	com/tencent/recovery/wx/service/WXRecoveryUploadService:convertStreamToString	(Ljava/io/InputStream;)Ljava/lang/String;
    //   438: astore 4
    //   440: aload_1
    //   441: invokevirtual 392	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   444: invokestatic 389	com/tencent/recovery/wx/service/WXRecoveryUploadService:convertStreamToString	(Ljava/io/InputStream;)Ljava/lang/String;
    //   447: astore 5
    //   449: ldc 22
    //   451: ldc_w 394
    //   454: iconst_4
    //   455: anewarray 78	java/lang/Object
    //   458: dup
    //   459: iconst_0
    //   460: aload_1
    //   461: invokevirtual 383	java/net/HttpURLConnection:getResponseCode	()I
    //   464: invokestatic 271	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   467: aastore
    //   468: dup
    //   469: iconst_1
    //   470: aload_2
    //   471: aastore
    //   472: dup
    //   473: iconst_2
    //   474: aload 4
    //   476: aastore
    //   477: dup
    //   478: iconst_3
    //   479: aload 5
    //   481: aastore
    //   482: invokestatic 396	com/tencent/recovery/log/RecoveryLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   485: aload_1
    //   486: ifnull +14 -> 500
    //   489: aload_1
    //   490: invokevirtual 392	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   493: invokevirtual 89	java/io/InputStream:close	()V
    //   496: aload_1
    //   497: invokevirtual 399	java/net/HttpURLConnection:disconnect	()V
    //   500: iconst_0
    //   501: ireturn
    //   502: astore_2
    //   503: ldc 22
    //   505: aload_2
    //   506: ldc 50
    //   508: iconst_0
    //   509: anewarray 78	java/lang/Object
    //   512: invokestatic 84	com/tencent/recovery/log/RecoveryLog:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   515: goto -19 -> 496
    //   518: ldc 22
    //   520: ldc_w 401
    //   523: iconst_1
    //   524: anewarray 78	java/lang/Object
    //   527: dup
    //   528: iconst_0
    //   529: aload_2
    //   530: aastore
    //   531: invokestatic 396	com/tencent/recovery/log/RecoveryLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   534: aload_1
    //   535: ifnull +14 -> 549
    //   538: aload_1
    //   539: invokevirtual 392	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   542: invokevirtual 89	java/io/InputStream:close	()V
    //   545: aload_1
    //   546: invokevirtual 399	java/net/HttpURLConnection:disconnect	()V
    //   549: iconst_1
    //   550: ireturn
    //   551: astore_2
    //   552: ldc 22
    //   554: aload_2
    //   555: ldc 50
    //   557: iconst_0
    //   558: anewarray 78	java/lang/Object
    //   561: invokestatic 84	com/tencent/recovery/log/RecoveryLog:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   564: goto -19 -> 545
    //   567: astore_2
    //   568: aload 5
    //   570: astore_1
    //   571: aload_1
    //   572: astore 4
    //   574: ldc 22
    //   576: aload_2
    //   577: ldc_w 402
    //   580: iconst_0
    //   581: anewarray 78	java/lang/Object
    //   584: invokestatic 84	com/tencent/recovery/log/RecoveryLog:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   587: aload_1
    //   588: ifnull +14 -> 602
    //   591: aload_1
    //   592: invokevirtual 392	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   595: invokevirtual 89	java/io/InputStream:close	()V
    //   598: aload_1
    //   599: invokevirtual 399	java/net/HttpURLConnection:disconnect	()V
    //   602: iconst_0
    //   603: ireturn
    //   604: astore_2
    //   605: ldc 22
    //   607: aload_2
    //   608: ldc 50
    //   610: iconst_0
    //   611: anewarray 78	java/lang/Object
    //   614: invokestatic 84	com/tencent/recovery/log/RecoveryLog:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   617: goto -19 -> 598
    //   620: astore_1
    //   621: aload 4
    //   623: ifnull +16 -> 639
    //   626: aload 4
    //   628: invokevirtual 392	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   631: invokevirtual 89	java/io/InputStream:close	()V
    //   634: aload 4
    //   636: invokevirtual 399	java/net/HttpURLConnection:disconnect	()V
    //   639: aload_1
    //   640: athrow
    //   641: astore_2
    //   642: ldc 22
    //   644: aload_2
    //   645: ldc 50
    //   647: iconst_0
    //   648: anewarray 78	java/lang/Object
    //   651: invokestatic 84	com/tencent/recovery/log/RecoveryLog:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   654: goto -20 -> 634
    //   657: astore_2
    //   658: aload_1
    //   659: astore 4
    //   661: aload_2
    //   662: astore_1
    //   663: goto -42 -> 621
    //   666: astore_2
    //   667: goto -96 -> 571
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	670	0	this	WXRecoveryUploadService
    //   0	670	1	paramJSONArray	JSONArray
    //   0	670	2	paramString	String
    //   138	136	3	i	int
    //   8	652	4	localObject1	Object
    //   4	565	5	str1	String
    //   1	328	6	localObject2	Object
    //   14	309	7	str2	String
    //   129	275	8	localObject3	Object
    //   38	225	9	str3	String
    //   186	22	10	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   489	496	502	java/lang/Exception
    //   538	545	551	java/lang/Exception
    //   10	16	567	java/lang/Exception
    //   20	40	567	java/lang/Exception
    //   44	131	567	java/lang/Exception
    //   135	139	567	java/lang/Exception
    //   143	177	567	java/lang/Exception
    //   181	188	567	java/lang/Exception
    //   192	201	567	java/lang/Exception
    //   205	217	567	java/lang/Exception
    //   221	294	567	java/lang/Exception
    //   303	311	567	java/lang/Exception
    //   315	328	567	java/lang/Exception
    //   332	350	567	java/lang/Exception
    //   591	598	604	java/lang/Exception
    //   10	16	620	finally
    //   20	40	620	finally
    //   44	131	620	finally
    //   135	139	620	finally
    //   143	177	620	finally
    //   181	188	620	finally
    //   192	201	620	finally
    //   205	217	620	finally
    //   221	294	620	finally
    //   303	311	620	finally
    //   315	328	620	finally
    //   332	350	620	finally
    //   574	587	620	finally
    //   626	634	641	java/lang/Exception
    //   350	485	657	finally
    //   518	534	657	finally
    //   350	485	666	java/lang/Exception
    //   518	534	666	java/lang/Exception
  }
  
  public void onHandleIntent(Intent paramIntent)
  {
    if (paramIntent.getIntExtra("extra_crash_count", -1) == -1)
    {
      String str = paramIntent.getStringExtra("extra_fetch_base_id");
      if (TextUtils.isEmpty(str))
      {
        super.onHandleIntent(paramIntent);
        return;
      }
      Log.i("MicroMsg.recovery.service", "fetchTinkerPatchByBaseId");
      Log.i("MicroMsg.recovery.service", "baseId = ".concat(String.valueOf(str)));
      paramIntent = getApplicationContext();
      Object localObject = new androidx.core.f.a()
      {
        public void accept(Integer paramAnonymousInteger)
        {
          Log.i("MicroMsg.recovery.service", "fetchTinkerPatchByBaseId callback, status = ".concat(String.valueOf(paramAnonymousInteger)));
        }
      };
      g.i("MicroMsg.recovery.operator", "#fetchTinkerPatchForTest");
      localObject = new b.3(paramIntent, str, (androidx.core.f.a)localObject);
      dhg localdhg = new dhg();
      localdhg.TOo = str;
      localdhg.GIL = com.tencent.mm.loader.j.a.aSz();
      localdhg.TOp = com.tencent.mm.recovery.a.b.eIb();
      localdhg.TOr = 1;
      com.tencent.mm.recovery.b.a(paramIntent, localdhg, (androidx.core.f.a)localObject, false);
      Log.i("MicroMsg.recovery.service", "fetchTinkerPatchByBaseId done");
      return;
    }
    j.jT(getApplication()).EA(false).hqz().arg();
    fetchTinkerPatch(paramIntent);
  }
  
  public boolean tryToUploadData()
  {
    Object localObject = new Intent();
    ((Intent)localObject).setPackage(getPackageName());
    ((Intent)localObject).setAction("com.tecent.mm.intent.action.RECOVERY_STATUS_UPLOAD");
    sendBroadcast((Intent)localObject);
    localObject = RecoveryReporter.getItemList(this, "HandleStatus", RecoveryHandleItem.class);
    boolean bool = uploadData((List)localObject);
    if ((((List)localObject).size() == 0) || (bool)) {
      RecoveryReporter.clearReportFile(this, "HandleStatus");
    }
    return bool;
  }
  
  protected boolean uploadData(List<RecoveryHandleItem> paramList)
  {
    int i = Util.getUUID(this);
    JSONArray localJSONArray = new JSONArray();
    Object localObject1 = WXRecoveryVersion.getBaseClientVersion(this);
    Iterator localIterator = paramList.iterator();
    Object localObject2;
    if (localIterator.hasNext()) {
      localObject2 = (RecoveryHandleItem)localIterator.next();
    }
    label221:
    for (;;)
    {
      try
      {
        localJSONArray.put(new JSONObject().put("tag", "RecoveryHandle").put("info", ((RecoveryHandleItem)localObject2).key).put("uin", ((RecoveryHandleItem)localObject2).uuid).put("deviceUUID", i).put("time", Util.getTimeFormat(((RecoveryHandleItem)localObject2).timestamp)).put("cver", ((RecoveryHandleItem)localObject2).clientVersion).put("processName", ((RecoveryHandleItem)localObject2).processName).put("phoneStatus", ((RecoveryHandleItem)localObject2).phoneStatus));
        if (compareVersion(((RecoveryHandleItem)localObject2).clientVersion, (String)localObject1) <= 0) {
          break label221;
        }
        localObject2 = ((RecoveryHandleItem)localObject2).clientVersion;
        localObject1 = localObject2;
      }
      catch (Exception localException) {}
      boolean bool = pushData(localJSONArray, (String)localObject1);
      RecoveryLog.i("Recovery.WXRecoveryUploadService", "upload result %b %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramList.size()) });
      return bool;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.recovery.wx.service.WXRecoveryUploadService
 * JD-Core Version:    0.7.0.1
 */