package com.tencent.recovery.wx.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mm.recovery.b;
import com.tencent.mm.recoveryv2.f;
import com.tencent.mm.recoveryv2.i;
import com.tencent.mm.sdk.platformtools.ae;
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
      ae.w("MicroMsg.recovery.service", "start service fail", new Object[] { paramContext });
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
        localc = new com.tencent.mm.recovery.c(arrayOfInt);
        String str2 = paramIntent.getStringExtra("extra_patch_url");
        str1 = str2;
        if (TextUtils.isEmpty(str2)) {
          str1 = paramIntent.getDataString();
        }
        if (!TextUtils.isEmpty(str1)) {
          continue;
        }
        f.i("MicroMsg.recovery.service", "#fetchTinkerPatch, fetch patch url with cgi");
        b.a(getApplicationContext(), localc);
      }
      catch (Throwable paramIntent)
      {
        com.tencent.mm.recovery.c localc;
        String str1;
        f.w("MicroMsg.recovery.service", "fetch error", paramIntent);
        arrayOfInt[0] = 10;
        continue;
      }
      f.i("MicroMsg.recovery.service", "#fetchTinkerPatch done, status = " + arrayOfInt[0]);
      paramIntent = i.hX(getApplication());
      paramIntent.IoA = false;
      paramIntent.Ioz = arrayOfInt[0];
      paramIntent.save();
      return;
      f.i("MicroMsg.recovery.service", "#fetchTinkerPatch, download patch with given url, url = ".concat(String.valueOf(str1)));
      b.b(getApplicationContext(), str1, localc);
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
    //   29: getstatic 219	android/os/Build$VERSION:SDK_INT	I
    //   32: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   35: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: astore 9
    //   40: aload 6
    //   42: astore 4
    //   44: new 221	org/json/JSONObject
    //   47: dup
    //   48: invokespecial 222	org/json/JSONObject:<init>	()V
    //   51: ldc 224
    //   53: new 221	org/json/JSONObject
    //   56: dup
    //   57: invokespecial 222	org/json/JSONObject:<init>	()V
    //   60: ldc 226
    //   62: iconst_1
    //   63: invokevirtual 230	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   66: ldc 232
    //   68: new 62	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   75: getstatic 237	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   78: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: ldc 239
    //   83: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: getstatic 242	android/os/Build:MODEL	Ljava/lang/String;
    //   89: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokevirtual 245	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   98: ldc 247
    //   100: aload 9
    //   102: invokevirtual 245	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   105: ldc 249
    //   107: invokestatic 255	java/lang/System:currentTimeMillis	()J
    //   110: invokevirtual 258	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   113: invokevirtual 245	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   116: ldc_w 260
    //   119: aload_1
    //   120: invokevirtual 245	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   123: invokevirtual 261	org/json/JSONObject:toString	()Ljava/lang/String;
    //   126: invokevirtual 265	java/lang/String:getBytes	()[B
    //   129: astore 8
    //   131: aload 6
    //   133: astore 4
    //   135: aload 8
    //   137: arraylength
    //   138: istore_3
    //   139: aload 6
    //   141: astore 4
    //   143: ldc_w 267
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
    //   160: invokestatic 270	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   163: aastore
    //   164: invokestatic 274	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   167: invokevirtual 265	java/lang/String:getBytes	()[B
    //   170: invokestatic 280	com/tencent/recovery/wx/util/EncryptUtil:getMessageDigest	([B)Ljava/lang/String;
    //   173: invokevirtual 283	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   176: astore_1
    //   177: aload 6
    //   179: astore 4
    //   181: aload 8
    //   183: invokestatic 287	com/tencent/recovery/wx/util/EncryptUtil:compress	([B)[B
    //   186: astore 10
    //   188: aload 6
    //   190: astore 4
    //   192: new 289	com/tencent/recovery/wx/util/PByteArray
    //   195: dup
    //   196: invokespecial 290	com/tencent/recovery/wx/util/PByteArray:<init>	()V
    //   199: astore 8
    //   201: aload 6
    //   203: astore 4
    //   205: aload 8
    //   207: aload 10
    //   209: aload_1
    //   210: invokevirtual 265	java/lang/String:getBytes	()[B
    //   213: invokestatic 294	com/tencent/recovery/wx/util/EncryptUtil:DESEncrypt	(Lcom/tencent/recovery/wx/util/PByteArray;[B[B)I
    //   216: pop
    //   217: aload 6
    //   219: astore 4
    //   221: new 62	java/lang/StringBuilder
    //   224: dup
    //   225: sipush 256
    //   228: invokespecial 297	java/lang/StringBuilder:<init>	(I)V
    //   231: ldc_w 299
    //   234: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: aload_2
    //   238: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: ldc_w 301
    //   244: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: aload 9
    //   249: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: ldc_w 303
    //   255: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: iload_3
    //   259: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   262: ldc_w 305
    //   265: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: aload_1
    //   269: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: ldc_w 307
    //   275: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: astore_1
    //   279: aload 7
    //   281: ifnull +32 -> 313
    //   284: aload 6
    //   286: astore 4
    //   288: aload 7
    //   290: invokevirtual 310	java/lang/String:length	()I
    //   293: ifeq +20 -> 313
    //   296: aload 6
    //   298: astore 4
    //   300: aload_1
    //   301: ldc_w 312
    //   304: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: aload 7
    //   309: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: pop
    //   313: aload 6
    //   315: astore 4
    //   317: new 314	java/net/URL
    //   320: dup
    //   321: aload_1
    //   322: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   325: invokespecial 315	java/net/URL:<init>	(Ljava/lang/String;)V
    //   328: invokevirtual 319	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   331: checkcast 321	java/net/HttpURLConnection
    //   334: astore_1
    //   335: aload_1
    //   336: ldc_w 323
    //   339: invokevirtual 326	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   342: aload_1
    //   343: sipush 20000
    //   346: invokevirtual 329	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   349: aload_1
    //   350: sipush 10000
    //   353: invokevirtual 332	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   356: aload_1
    //   357: ldc_w 334
    //   360: ldc_w 336
    //   363: invokevirtual 339	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   366: aload_1
    //   367: iconst_1
    //   368: invokevirtual 343	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   371: aload_1
    //   372: iconst_1
    //   373: invokevirtual 346	java/net/HttpURLConnection:setDoInput	(Z)V
    //   376: aload_1
    //   377: invokevirtual 349	java/net/HttpURLConnection:connect	()V
    //   380: aload_1
    //   381: invokevirtual 353	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   384: astore 4
    //   386: aload 4
    //   388: aload 8
    //   390: getfield 356	com/tencent/recovery/wx/util/PByteArray:value	[B
    //   393: invokevirtual 362	java/io/OutputStream:write	([B)V
    //   396: aload 4
    //   398: invokevirtual 365	java/io/OutputStream:flush	()V
    //   401: aload 4
    //   403: invokevirtual 366	java/io/OutputStream:close	()V
    //   406: aload_1
    //   407: invokevirtual 369	java/net/HttpURLConnection:getResponseCode	()I
    //   410: sipush 200
    //   413: if_icmpeq +90 -> 503
    //   416: aload_1
    //   417: invokevirtual 373	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   420: invokestatic 375	com/tencent/recovery/wx/service/WXRecoveryUploadService:convertStreamToString	(Ljava/io/InputStream;)Ljava/lang/String;
    //   423: astore 4
    //   425: aload_1
    //   426: invokevirtual 378	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   429: invokestatic 375	com/tencent/recovery/wx/service/WXRecoveryUploadService:convertStreamToString	(Ljava/io/InputStream;)Ljava/lang/String;
    //   432: astore 5
    //   434: ldc 22
    //   436: ldc_w 380
    //   439: iconst_4
    //   440: anewarray 78	java/lang/Object
    //   443: dup
    //   444: iconst_0
    //   445: aload_1
    //   446: invokevirtual 369	java/net/HttpURLConnection:getResponseCode	()I
    //   449: invokestatic 270	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   452: aastore
    //   453: dup
    //   454: iconst_1
    //   455: aload_2
    //   456: aastore
    //   457: dup
    //   458: iconst_2
    //   459: aload 4
    //   461: aastore
    //   462: dup
    //   463: iconst_3
    //   464: aload 5
    //   466: aastore
    //   467: invokestatic 382	com/tencent/recovery/log/RecoveryLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   470: aload_1
    //   471: ifnull +14 -> 485
    //   474: aload_1
    //   475: invokevirtual 378	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   478: invokevirtual 89	java/io/InputStream:close	()V
    //   481: aload_1
    //   482: invokevirtual 385	java/net/HttpURLConnection:disconnect	()V
    //   485: iconst_0
    //   486: ireturn
    //   487: astore_2
    //   488: ldc 22
    //   490: aload_2
    //   491: ldc 50
    //   493: iconst_0
    //   494: anewarray 78	java/lang/Object
    //   497: invokestatic 84	com/tencent/recovery/log/RecoveryLog:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   500: goto -19 -> 481
    //   503: ldc 22
    //   505: ldc_w 387
    //   508: iconst_1
    //   509: anewarray 78	java/lang/Object
    //   512: dup
    //   513: iconst_0
    //   514: aload_2
    //   515: aastore
    //   516: invokestatic 382	com/tencent/recovery/log/RecoveryLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   519: aload_1
    //   520: ifnull +14 -> 534
    //   523: aload_1
    //   524: invokevirtual 378	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   527: invokevirtual 89	java/io/InputStream:close	()V
    //   530: aload_1
    //   531: invokevirtual 385	java/net/HttpURLConnection:disconnect	()V
    //   534: iconst_1
    //   535: ireturn
    //   536: astore_2
    //   537: ldc 22
    //   539: aload_2
    //   540: ldc 50
    //   542: iconst_0
    //   543: anewarray 78	java/lang/Object
    //   546: invokestatic 84	com/tencent/recovery/log/RecoveryLog:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   549: goto -19 -> 530
    //   552: astore_2
    //   553: aload 5
    //   555: astore_1
    //   556: aload_1
    //   557: astore 4
    //   559: ldc 22
    //   561: aload_2
    //   562: ldc_w 388
    //   565: iconst_0
    //   566: anewarray 78	java/lang/Object
    //   569: invokestatic 84	com/tencent/recovery/log/RecoveryLog:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   572: aload_1
    //   573: ifnull +14 -> 587
    //   576: aload_1
    //   577: invokevirtual 378	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   580: invokevirtual 89	java/io/InputStream:close	()V
    //   583: aload_1
    //   584: invokevirtual 385	java/net/HttpURLConnection:disconnect	()V
    //   587: iconst_0
    //   588: ireturn
    //   589: astore_2
    //   590: ldc 22
    //   592: aload_2
    //   593: ldc 50
    //   595: iconst_0
    //   596: anewarray 78	java/lang/Object
    //   599: invokestatic 84	com/tencent/recovery/log/RecoveryLog:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   602: goto -19 -> 583
    //   605: astore_1
    //   606: aload 4
    //   608: ifnull +16 -> 624
    //   611: aload 4
    //   613: invokevirtual 378	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   616: invokevirtual 89	java/io/InputStream:close	()V
    //   619: aload 4
    //   621: invokevirtual 385	java/net/HttpURLConnection:disconnect	()V
    //   624: aload_1
    //   625: athrow
    //   626: astore_2
    //   627: ldc 22
    //   629: aload_2
    //   630: ldc 50
    //   632: iconst_0
    //   633: anewarray 78	java/lang/Object
    //   636: invokestatic 84	com/tencent/recovery/log/RecoveryLog:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   639: goto -20 -> 619
    //   642: astore_2
    //   643: aload_1
    //   644: astore 4
    //   646: aload_2
    //   647: astore_1
    //   648: goto -42 -> 606
    //   651: astore_2
    //   652: goto -96 -> 556
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	655	0	this	WXRecoveryUploadService
    //   0	655	1	paramJSONArray	JSONArray
    //   0	655	2	paramString	String
    //   138	121	3	i	int
    //   8	637	4	localObject1	Object
    //   4	550	5	str1	String
    //   1	313	6	localObject2	Object
    //   14	294	7	str2	String
    //   129	260	8	localObject3	Object
    //   38	210	9	str3	String
    //   186	22	10	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   474	481	487	java/lang/Exception
    //   523	530	536	java/lang/Exception
    //   10	16	552	java/lang/Exception
    //   20	40	552	java/lang/Exception
    //   44	131	552	java/lang/Exception
    //   135	139	552	java/lang/Exception
    //   143	177	552	java/lang/Exception
    //   181	188	552	java/lang/Exception
    //   192	201	552	java/lang/Exception
    //   205	217	552	java/lang/Exception
    //   221	279	552	java/lang/Exception
    //   288	296	552	java/lang/Exception
    //   300	313	552	java/lang/Exception
    //   317	335	552	java/lang/Exception
    //   576	583	589	java/lang/Exception
    //   10	16	605	finally
    //   20	40	605	finally
    //   44	131	605	finally
    //   135	139	605	finally
    //   143	177	605	finally
    //   181	188	605	finally
    //   192	201	605	finally
    //   205	217	605	finally
    //   221	279	605	finally
    //   288	296	605	finally
    //   300	313	605	finally
    //   317	335	605	finally
    //   559	572	605	finally
    //   611	619	626	java/lang/Exception
    //   335	470	642	finally
    //   503	519	642	finally
    //   335	470	651	java/lang/Exception
    //   503	519	651	java/lang/Exception
  }
  
  public void onHandleIntent(Intent paramIntent)
  {
    if (paramIntent.getIntExtra("extra_crash_count", -1) == -1)
    {
      localObject = paramIntent.getStringExtra("extra_fetch_base_id");
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        super.onHandleIntent(paramIntent);
        return;
      }
      ae.i("MicroMsg.recovery.service", "fetchTinkerPatchByBaseId");
      ae.i("MicroMsg.recovery.service", "baseId = ".concat(String.valueOf(localObject)));
      b.a(getApplicationContext(), (String)localObject, new android.support.v4.e.c()
      {
        public void accept(Integer paramAnonymousInteger)
        {
          ae.i("MicroMsg.recovery.service", "fetchTinkerPatchByBaseId callback, status = ".concat(String.valueOf(paramAnonymousInteger)));
        }
      });
      ae.i("MicroMsg.recovery.service", "fetchTinkerPatchByBaseId done");
      return;
    }
    Object localObject = i.hX(getApplication());
    ((i)localObject).IoA = false;
    ((i)localObject).Iox = true;
    ((i)localObject).save();
    b.fkM();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.recovery.wx.service.WXRecoveryUploadService
 * JD-Core Version:    0.7.0.1
 */