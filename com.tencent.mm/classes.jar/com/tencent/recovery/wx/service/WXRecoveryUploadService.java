package com.tencent.recovery.wx.service;

import android.content.Intent;
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

public class WXRecoveryUploadService
  extends RecoveryUploadService
{
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
    //   11: invokestatic 83	com/tencent/recovery/wx/util/WXUtil:getWXUserName	(Landroid/content/Context;)Ljava/lang/String;
    //   14: astore 7
    //   16: aload 6
    //   18: astore 4
    //   20: new 48	java/lang/StringBuilder
    //   23: dup
    //   24: ldc 85
    //   26: invokespecial 88	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   29: getstatic 94	android/os/Build$VERSION:SDK_INT	I
    //   32: invokevirtual 97	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   35: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: astore 9
    //   40: aload 6
    //   42: astore 4
    //   44: new 99	org/json/JSONObject
    //   47: dup
    //   48: invokespecial 100	org/json/JSONObject:<init>	()V
    //   51: ldc 102
    //   53: new 99	org/json/JSONObject
    //   56: dup
    //   57: invokespecial 100	org/json/JSONObject:<init>	()V
    //   60: ldc 104
    //   62: iconst_1
    //   63: invokevirtual 108	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   66: ldc 110
    //   68: new 48	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   75: getstatic 115	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   78: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: ldc 117
    //   83: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: getstatic 120	android/os/Build:MODEL	Ljava/lang/String;
    //   89: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokevirtual 123	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   98: ldc 125
    //   100: aload 9
    //   102: invokevirtual 123	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   105: ldc 127
    //   107: invokestatic 133	java/lang/System:currentTimeMillis	()J
    //   110: invokevirtual 136	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   113: invokevirtual 123	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   116: ldc 138
    //   118: aload_1
    //   119: invokevirtual 123	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   122: invokevirtual 139	org/json/JSONObject:toString	()Ljava/lang/String;
    //   125: invokevirtual 145	java/lang/String:getBytes	()[B
    //   128: astore 8
    //   130: aload 6
    //   132: astore 4
    //   134: aload 8
    //   136: arraylength
    //   137: istore_3
    //   138: aload 6
    //   140: astore 4
    //   142: ldc 147
    //   144: iconst_2
    //   145: anewarray 64	java/lang/Object
    //   148: dup
    //   149: iconst_0
    //   150: aload_2
    //   151: invokestatic 26	java/lang/Integer:decode	(Ljava/lang/String;)Ljava/lang/Integer;
    //   154: aastore
    //   155: dup
    //   156: iconst_1
    //   157: iload_3
    //   158: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   161: aastore
    //   162: invokestatic 155	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   165: invokevirtual 145	java/lang/String:getBytes	()[B
    //   168: invokestatic 161	com/tencent/recovery/wx/util/EncryptUtil:getMessageDigest	([B)Ljava/lang/String;
    //   171: invokevirtual 164	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   174: astore_1
    //   175: aload 6
    //   177: astore 4
    //   179: aload 8
    //   181: invokestatic 168	com/tencent/recovery/wx/util/EncryptUtil:compress	([B)[B
    //   184: astore 10
    //   186: aload 6
    //   188: astore 4
    //   190: new 170	com/tencent/recovery/wx/util/PByteArray
    //   193: dup
    //   194: invokespecial 171	com/tencent/recovery/wx/util/PByteArray:<init>	()V
    //   197: astore 8
    //   199: aload 6
    //   201: astore 4
    //   203: aload 8
    //   205: aload 10
    //   207: aload_1
    //   208: invokevirtual 145	java/lang/String:getBytes	()[B
    //   211: invokestatic 175	com/tencent/recovery/wx/util/EncryptUtil:DESEncrypt	(Lcom/tencent/recovery/wx/util/PByteArray;[B[B)I
    //   214: pop
    //   215: aload 6
    //   217: astore 4
    //   219: new 48	java/lang/StringBuilder
    //   222: dup
    //   223: sipush 256
    //   226: invokespecial 178	java/lang/StringBuilder:<init>	(I)V
    //   229: ldc 180
    //   231: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: aload_2
    //   235: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: ldc 182
    //   240: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: aload 9
    //   245: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: ldc 184
    //   250: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: iload_3
    //   254: invokevirtual 97	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   257: ldc 186
    //   259: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: aload_1
    //   263: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: ldc 188
    //   268: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: astore_1
    //   272: aload 7
    //   274: ifnull +31 -> 305
    //   277: aload 6
    //   279: astore 4
    //   281: aload 7
    //   283: invokevirtual 191	java/lang/String:length	()I
    //   286: ifeq +19 -> 305
    //   289: aload 6
    //   291: astore 4
    //   293: aload_1
    //   294: ldc 193
    //   296: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: aload 7
    //   301: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: aload 6
    //   307: astore 4
    //   309: new 195	java/net/URL
    //   312: dup
    //   313: aload_1
    //   314: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   317: invokespecial 196	java/net/URL:<init>	(Ljava/lang/String;)V
    //   320: invokevirtual 200	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   323: checkcast 202	java/net/HttpURLConnection
    //   326: astore_1
    //   327: aload_1
    //   328: ldc 204
    //   330: invokevirtual 207	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   333: aload_1
    //   334: sipush 20000
    //   337: invokevirtual 210	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   340: aload_1
    //   341: sipush 10000
    //   344: invokevirtual 213	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   347: aload_1
    //   348: ldc 215
    //   350: ldc 217
    //   352: invokevirtual 221	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   355: aload_1
    //   356: iconst_1
    //   357: invokevirtual 225	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   360: aload_1
    //   361: iconst_1
    //   362: invokevirtual 228	java/net/HttpURLConnection:setDoInput	(Z)V
    //   365: aload_1
    //   366: invokevirtual 231	java/net/HttpURLConnection:connect	()V
    //   369: aload_1
    //   370: invokevirtual 235	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   373: astore 4
    //   375: aload 4
    //   377: aload 8
    //   379: getfield 239	com/tencent/recovery/wx/util/PByteArray:value	[B
    //   382: invokevirtual 245	java/io/OutputStream:write	([B)V
    //   385: aload 4
    //   387: invokevirtual 248	java/io/OutputStream:flush	()V
    //   390: aload 4
    //   392: invokevirtual 249	java/io/OutputStream:close	()V
    //   395: aload_1
    //   396: invokevirtual 252	java/net/HttpURLConnection:getResponseCode	()I
    //   399: sipush 200
    //   402: if_icmpeq +90 -> 492
    //   405: aload_1
    //   406: invokevirtual 256	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   409: invokestatic 258	com/tencent/recovery/wx/service/WXRecoveryUploadService:convertStreamToString	(Ljava/io/InputStream;)Ljava/lang/String;
    //   412: astore 4
    //   414: aload_1
    //   415: invokevirtual 261	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   418: invokestatic 258	com/tencent/recovery/wx/service/WXRecoveryUploadService:convertStreamToString	(Ljava/io/InputStream;)Ljava/lang/String;
    //   421: astore 5
    //   423: ldc 8
    //   425: ldc_w 263
    //   428: iconst_4
    //   429: anewarray 64	java/lang/Object
    //   432: dup
    //   433: iconst_0
    //   434: aload_1
    //   435: invokevirtual 252	java/net/HttpURLConnection:getResponseCode	()I
    //   438: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   441: aastore
    //   442: dup
    //   443: iconst_1
    //   444: aload_2
    //   445: aastore
    //   446: dup
    //   447: iconst_2
    //   448: aload 4
    //   450: aastore
    //   451: dup
    //   452: iconst_3
    //   453: aload 5
    //   455: aastore
    //   456: invokestatic 267	com/tencent/recovery/log/RecoveryLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   459: aload_1
    //   460: ifnull +14 -> 474
    //   463: aload_1
    //   464: invokevirtual 261	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   467: invokevirtual 75	java/io/InputStream:close	()V
    //   470: aload_1
    //   471: invokevirtual 270	java/net/HttpURLConnection:disconnect	()V
    //   474: iconst_0
    //   475: ireturn
    //   476: astore_2
    //   477: ldc 8
    //   479: aload_2
    //   480: ldc 36
    //   482: iconst_0
    //   483: anewarray 64	java/lang/Object
    //   486: invokestatic 70	com/tencent/recovery/log/RecoveryLog:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   489: goto -19 -> 470
    //   492: ldc 8
    //   494: ldc_w 272
    //   497: iconst_1
    //   498: anewarray 64	java/lang/Object
    //   501: dup
    //   502: iconst_0
    //   503: aload_2
    //   504: aastore
    //   505: invokestatic 267	com/tencent/recovery/log/RecoveryLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   508: aload_1
    //   509: ifnull +14 -> 523
    //   512: aload_1
    //   513: invokevirtual 261	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   516: invokevirtual 75	java/io/InputStream:close	()V
    //   519: aload_1
    //   520: invokevirtual 270	java/net/HttpURLConnection:disconnect	()V
    //   523: iconst_1
    //   524: ireturn
    //   525: astore_2
    //   526: ldc 8
    //   528: aload_2
    //   529: ldc 36
    //   531: iconst_0
    //   532: anewarray 64	java/lang/Object
    //   535: invokestatic 70	com/tencent/recovery/log/RecoveryLog:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   538: goto -19 -> 519
    //   541: astore_2
    //   542: aload 5
    //   544: astore_1
    //   545: aload_1
    //   546: astore 4
    //   548: ldc 8
    //   550: aload_2
    //   551: ldc_w 273
    //   554: iconst_0
    //   555: anewarray 64	java/lang/Object
    //   558: invokestatic 70	com/tencent/recovery/log/RecoveryLog:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   561: aload_1
    //   562: ifnull +14 -> 576
    //   565: aload_1
    //   566: invokevirtual 261	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   569: invokevirtual 75	java/io/InputStream:close	()V
    //   572: aload_1
    //   573: invokevirtual 270	java/net/HttpURLConnection:disconnect	()V
    //   576: iconst_0
    //   577: ireturn
    //   578: astore_2
    //   579: ldc 8
    //   581: aload_2
    //   582: ldc 36
    //   584: iconst_0
    //   585: anewarray 64	java/lang/Object
    //   588: invokestatic 70	com/tencent/recovery/log/RecoveryLog:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   591: goto -19 -> 572
    //   594: astore_1
    //   595: aload 4
    //   597: ifnull +16 -> 613
    //   600: aload 4
    //   602: invokevirtual 261	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   605: invokevirtual 75	java/io/InputStream:close	()V
    //   608: aload 4
    //   610: invokevirtual 270	java/net/HttpURLConnection:disconnect	()V
    //   613: aload_1
    //   614: athrow
    //   615: astore_2
    //   616: ldc 8
    //   618: aload_2
    //   619: ldc 36
    //   621: iconst_0
    //   622: anewarray 64	java/lang/Object
    //   625: invokestatic 70	com/tencent/recovery/log/RecoveryLog:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   628: goto -20 -> 608
    //   631: astore_2
    //   632: aload_1
    //   633: astore 4
    //   635: aload_2
    //   636: astore_1
    //   637: goto -42 -> 595
    //   640: astore_2
    //   641: goto -96 -> 545
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	644	0	this	WXRecoveryUploadService
    //   0	644	1	paramJSONArray	JSONArray
    //   0	644	2	paramString	String
    //   137	117	3	i	int
    //   8	626	4	localObject1	Object
    //   4	539	5	str1	String
    //   1	305	6	localObject2	Object
    //   14	286	7	str2	String
    //   128	250	8	localObject3	Object
    //   38	206	9	str3	String
    //   184	22	10	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   463	470	476	java/lang/Exception
    //   512	519	525	java/lang/Exception
    //   10	16	541	java/lang/Exception
    //   20	40	541	java/lang/Exception
    //   44	130	541	java/lang/Exception
    //   134	138	541	java/lang/Exception
    //   142	175	541	java/lang/Exception
    //   179	186	541	java/lang/Exception
    //   190	199	541	java/lang/Exception
    //   203	215	541	java/lang/Exception
    //   219	272	541	java/lang/Exception
    //   281	289	541	java/lang/Exception
    //   293	305	541	java/lang/Exception
    //   309	327	541	java/lang/Exception
    //   565	572	578	java/lang/Exception
    //   10	16	594	finally
    //   20	40	594	finally
    //   44	130	594	finally
    //   134	138	594	finally
    //   142	175	594	finally
    //   179	186	594	finally
    //   190	199	594	finally
    //   203	215	594	finally
    //   219	272	594	finally
    //   281	289	594	finally
    //   293	305	594	finally
    //   309	327	594	finally
    //   548	561	594	finally
    //   600	608	615	java/lang/Exception
    //   327	459	631	finally
    //   492	508	631	finally
    //   327	459	640	java/lang/Exception
    //   492	508	640	java/lang/Exception
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