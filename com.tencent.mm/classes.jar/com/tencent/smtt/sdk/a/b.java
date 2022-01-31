package com.tencent.smtt.sdk.a;

import MTT.ThirdAppInfoNew;
import android.content.Context;
import android.content.pm.Signature;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsPVConfig;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

public class b
{
  public static byte[] a = null;
  
  static
  {
    try
    {
      a = "65dRa93L".getBytes("utf-8");
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
  }
  
  private static String a(Context paramContext)
  {
    int i = 0;
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 64).signatures[0].toByteArray();
      if (paramContext != null)
      {
        Object localObject = MessageDigest.getInstance("SHA-1");
        ((MessageDigest)localObject).update(paramContext);
        paramContext = ((MessageDigest)localObject).digest();
        if (paramContext != null)
        {
          localObject = new StringBuilder("");
          if (paramContext != null)
          {
            if (paramContext.length <= 0) {
              return null;
            }
            while (i < paramContext.length)
            {
              String str = Integer.toHexString(paramContext[i] & 0xFF).toUpperCase();
              if (i > 0) {
                ((StringBuilder)localObject).append(":");
              }
              if (str.length() < 2) {
                ((StringBuilder)localObject).append(0);
              }
              ((StringBuilder)localObject).append(str);
              i += 1;
            }
            paramContext = ((StringBuilder)localObject).toString();
            return paramContext;
          }
        }
      }
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  public static void a(ThirdAppInfoNew paramThirdAppInfoNew, Context paramContext)
  {
    new c("HttpUtils", paramContext, paramThirdAppInfoNew).start();
  }
  
  private static void a(Context paramContext, String paramString1, String paramString2)
  {
    if (("reset".equals(paramString1)) && ("true".equals(paramString2)))
    {
      QbSdk.reset(paramContext);
      return;
    }
    TbsPVConfig.getInstance(paramContext).putData(paramString1, paramString2);
  }
  
  /* Error */
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean, long paramLong)
  {
    // Byte code:
    //   0: invokestatic 150	com/tencent/smtt/sdk/QbSdk:getSettings	()Ljava/util/Map;
    //   3: ifnull +44 -> 47
    //   6: invokestatic 150	com/tencent/smtt/sdk/QbSdk:getSettings	()Ljava/util/Map;
    //   9: getstatic 154	com/tencent/smtt/sdk/QbSdk:KEY_SET_SENDREQUEST_AND_UPLOAD	Ljava/lang/String;
    //   12: invokeinterface 159 2 0
    //   17: ifeq +30 -> 47
    //   20: invokestatic 150	com/tencent/smtt/sdk/QbSdk:getSettings	()Ljava/util/Map;
    //   23: getstatic 154	com/tencent/smtt/sdk/QbSdk:KEY_SET_SENDREQUEST_AND_UPLOAD	Ljava/lang/String;
    //   26: invokeinterface 163 2 0
    //   31: ldc 165
    //   33: invokevirtual 166	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   36: ifeq +11 -> 47
    //   39: ldc 168
    //   41: ldc 170
    //   43: invokestatic 175	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: return
    //   47: ldc 73
    //   49: astore 10
    //   51: aload 10
    //   53: astore 9
    //   55: aload_0
    //   56: invokevirtual 179	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   59: astore 11
    //   61: aload 10
    //   63: astore 8
    //   65: aload 10
    //   67: astore 9
    //   69: ldc 181
    //   71: aload 11
    //   73: getfield 186	android/content/pm/ApplicationInfo:packageName	Ljava/lang/String;
    //   76: invokevirtual 127	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   79: ifeq +74 -> 153
    //   82: aload 10
    //   84: astore 9
    //   86: aload_0
    //   87: invokevirtual 32	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   90: aload 11
    //   92: getfield 186	android/content/pm/ApplicationInfo:packageName	Ljava/lang/String;
    //   95: iconst_0
    //   96: invokevirtual 42	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   99: getfield 189	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   102: astore 10
    //   104: aload 10
    //   106: astore 8
    //   108: aload 10
    //   110: astore 9
    //   112: invokestatic 192	com/tencent/smtt/sdk/QbSdk:getQQBuildNumber	()Ljava/lang/String;
    //   115: invokestatic 198	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   118: ifne +35 -> 153
    //   121: aload 10
    //   123: astore 9
    //   125: new 71	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   132: aload 10
    //   134: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: ldc 202
    //   139: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: invokestatic 192	com/tencent/smtt/sdk/QbSdk:getQQBuildNumber	()Ljava/lang/String;
    //   145: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: astore 8
    //   153: aload 8
    //   155: astore 9
    //   157: new 204	MTT/ThirdAppInfoNew
    //   160: dup
    //   161: invokespecial 205	MTT/ThirdAppInfoNew:<init>	()V
    //   164: astore 8
    //   166: aload 8
    //   168: aload_0
    //   169: invokevirtual 209	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   172: invokevirtual 179	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   175: getfield 186	android/content/pm/ApplicationInfo:packageName	Ljava/lang/String;
    //   178: putfield 212	MTT/ThirdAppInfoNew:sAppName	Ljava/lang/String;
    //   181: aload_0
    //   182: invokestatic 217	com/tencent/smtt/utils/s:a	(Landroid/content/Context;)Lcom/tencent/smtt/utils/s;
    //   185: pop
    //   186: new 219	java/text/SimpleDateFormat
    //   189: dup
    //   190: ldc 221
    //   192: invokespecial 222	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   195: astore 10
    //   197: aload 10
    //   199: ldc 224
    //   201: invokestatic 230	java/util/TimeZone:getTimeZone	(Ljava/lang/String;)Ljava/util/TimeZone;
    //   204: invokevirtual 234	java/text/SimpleDateFormat:setTimeZone	(Ljava/util/TimeZone;)V
    //   207: aload 8
    //   209: aload 10
    //   211: invokestatic 239	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   214: invokevirtual 243	java/util/Calendar:getTime	()Ljava/util/Date;
    //   217: invokevirtual 247	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   220: putfield 250	MTT/ThirdAppInfoNew:sTime	Ljava/lang/String;
    //   223: aload 8
    //   225: invokestatic 254	com/tencent/smtt/utils/b:a	()Ljava/lang/String;
    //   228: putfield 257	MTT/ThirdAppInfoNew:sCpu	Ljava/lang/String;
    //   231: aload 8
    //   233: aload_0
    //   234: invokestatic 260	com/tencent/smtt/utils/b:b	(Landroid/content/Context;)I
    //   237: putfield 264	MTT/ThirdAppInfoNew:sVersionCode	I
    //   240: aload_0
    //   241: ldc_w 266
    //   244: invokestatic 269	com/tencent/smtt/utils/b:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   247: astore 10
    //   249: aload 10
    //   251: invokestatic 198	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   254: ifne +10 -> 264
    //   257: aload 8
    //   259: aload 10
    //   261: putfield 272	MTT/ThirdAppInfoNew:sMetaData	Ljava/lang/String;
    //   264: aload 8
    //   266: aload_1
    //   267: putfield 275	MTT/ThirdAppInfoNew:sGuid	Ljava/lang/String;
    //   270: iload 5
    //   272: ifeq +193 -> 465
    //   275: aload 8
    //   277: aload_2
    //   278: putfield 278	MTT/ThirdAppInfoNew:sQua2	Ljava/lang/String;
    //   281: aload 8
    //   283: aload_3
    //   284: putfield 281	MTT/ThirdAppInfoNew:sLc	Ljava/lang/String;
    //   287: aload_0
    //   288: invokestatic 284	com/tencent/smtt/utils/b:e	(Landroid/content/Context;)Ljava/lang/String;
    //   291: astore_1
    //   292: aload_0
    //   293: invokestatic 287	com/tencent/smtt/utils/b:c	(Landroid/content/Context;)Ljava/lang/String;
    //   296: astore_2
    //   297: aload_0
    //   298: invokestatic 290	com/tencent/smtt/utils/b:d	(Landroid/content/Context;)Ljava/lang/String;
    //   301: astore_3
    //   302: aload_0
    //   303: invokestatic 293	com/tencent/smtt/utils/b:f	(Landroid/content/Context;)Ljava/lang/String;
    //   306: astore 10
    //   308: aload_2
    //   309: ifnull +18 -> 327
    //   312: ldc 73
    //   314: aload_2
    //   315: invokevirtual 127	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   318: ifne +9 -> 327
    //   321: aload 8
    //   323: aload_2
    //   324: putfield 296	MTT/ThirdAppInfoNew:sImei	Ljava/lang/String;
    //   327: aload_3
    //   328: ifnull +18 -> 346
    //   331: ldc 73
    //   333: aload_3
    //   334: invokevirtual 127	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   337: ifne +9 -> 346
    //   340: aload 8
    //   342: aload_3
    //   343: putfield 299	MTT/ThirdAppInfoNew:sImsi	Ljava/lang/String;
    //   346: aload 10
    //   348: invokestatic 198	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   351: ifne +10 -> 361
    //   354: aload 8
    //   356: aload 10
    //   358: putfield 302	MTT/ThirdAppInfoNew:sAndroidID	Ljava/lang/String;
    //   361: aload_1
    //   362: ifnull +18 -> 380
    //   365: ldc 73
    //   367: aload_1
    //   368: invokevirtual 127	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   371: ifne +9 -> 380
    //   374: aload 8
    //   376: aload_1
    //   377: putfield 305	MTT/ThirdAppInfoNew:sMac	Ljava/lang/String;
    //   380: aload 8
    //   382: iload 4
    //   384: i2l
    //   385: putfield 309	MTT/ThirdAppInfoNew:iPv	J
    //   388: aload_0
    //   389: invokestatic 315	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   392: ifeq +103 -> 495
    //   395: iload 5
    //   397: ifeq +89 -> 486
    //   400: invokestatic 319	com/tencent/smtt/sdk/TbsShareManager:getCoreFormOwn	()Z
    //   403: ifeq +74 -> 477
    //   406: iconst_2
    //   407: istore 4
    //   409: aload 8
    //   411: astore_1
    //   412: aload_1
    //   413: iload 4
    //   415: putfield 322	MTT/ThirdAppInfoNew:iCoreType	I
    //   418: aload 8
    //   420: aload 9
    //   422: putfield 325	MTT/ThirdAppInfoNew:sAppVersionName	Ljava/lang/String;
    //   425: aload 8
    //   427: aload_0
    //   428: invokestatic 327	com/tencent/smtt/sdk/a/b:a	(Landroid/content/Context;)Ljava/lang/String;
    //   431: putfield 330	MTT/ThirdAppInfoNew:sAppSignature	Ljava/lang/String;
    //   434: iload 5
    //   436: ifne +19 -> 455
    //   439: aload 8
    //   441: lload 6
    //   443: putfield 333	MTT/ThirdAppInfoNew:sWifiConnectedTime	J
    //   446: aload 8
    //   448: aload_0
    //   449: invokestatic 336	com/tencent/smtt/sdk/QbSdk:getTbsVersion	(Landroid/content/Context;)I
    //   452: putfield 339	MTT/ThirdAppInfoNew:localCoreVersion	I
    //   455: aload 8
    //   457: aload_0
    //   458: invokevirtual 209	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   461: invokestatic 341	com/tencent/smtt/sdk/a/b:a	(LMTT/ThirdAppInfoNew;Landroid/content/Context;)V
    //   464: return
    //   465: aload 8
    //   467: aload_0
    //   468: invokestatic 344	com/tencent/smtt/utils/r:a	(Landroid/content/Context;)Ljava/lang/String;
    //   471: putfield 278	MTT/ThirdAppInfoNew:sQua2	Ljava/lang/String;
    //   474: goto -193 -> 281
    //   477: iconst_1
    //   478: istore 4
    //   480: aload 8
    //   482: astore_1
    //   483: goto -71 -> 412
    //   486: iconst_0
    //   487: istore 4
    //   489: aload 8
    //   491: astore_1
    //   492: goto -80 -> 412
    //   495: iload 5
    //   497: ifeq +12 -> 509
    //   500: iconst_1
    //   501: istore 4
    //   503: aload 8
    //   505: astore_1
    //   506: goto -94 -> 412
    //   509: goto -23 -> 486
    //   512: astore_0
    //   513: return
    //   514: astore 8
    //   516: goto -359 -> 157
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	519	0	paramContext	Context
    //   0	519	1	paramString1	String
    //   0	519	2	paramString2	String
    //   0	519	3	paramString3	String
    //   0	519	4	paramInt	int
    //   0	519	5	paramBoolean	boolean
    //   0	519	6	paramLong	long
    //   63	441	8	localObject1	Object
    //   514	1	8	localException	Exception
    //   53	368	9	localObject2	Object
    //   49	308	10	localObject3	Object
    //   59	32	11	localApplicationInfo	android.content.pm.ApplicationInfo
    // Exception table:
    //   from	to	target	type
    //   157	264	512	java/lang/Throwable
    //   264	270	512	java/lang/Throwable
    //   275	281	512	java/lang/Throwable
    //   281	308	512	java/lang/Throwable
    //   312	327	512	java/lang/Throwable
    //   331	346	512	java/lang/Throwable
    //   346	361	512	java/lang/Throwable
    //   365	380	512	java/lang/Throwable
    //   380	395	512	java/lang/Throwable
    //   400	406	512	java/lang/Throwable
    //   412	434	512	java/lang/Throwable
    //   439	455	512	java/lang/Throwable
    //   455	464	512	java/lang/Throwable
    //   465	474	512	java/lang/Throwable
    //   55	61	514	java/lang/Exception
    //   69	82	514	java/lang/Exception
    //   86	104	514	java/lang/Exception
    //   112	121	514	java/lang/Exception
    //   125	153	514	java/lang/Exception
  }
  
  /* Error */
  private static String b(java.net.HttpURLConnection paramHttpURLConnection, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 73
    //   2: astore 5
    //   4: aload_0
    //   5: invokevirtual 352	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   8: astore 4
    //   10: aload_0
    //   11: invokevirtual 355	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   14: astore_0
    //   15: aload_0
    //   16: ifnull +131 -> 147
    //   19: aload_0
    //   20: ldc_w 357
    //   23: invokevirtual 361	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   26: ifeq +121 -> 147
    //   29: new 363	java/util/zip/GZIPInputStream
    //   32: dup
    //   33: aload 4
    //   35: invokespecial 366	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   38: astore_0
    //   39: new 368	java/io/ByteArrayOutputStream
    //   42: dup
    //   43: invokespecial 369	java/io/ByteArrayOutputStream:<init>	()V
    //   46: astore 4
    //   48: sipush 128
    //   51: newarray byte
    //   53: astore 6
    //   55: aload_0
    //   56: aload 6
    //   58: invokevirtual 375	java/io/InputStream:read	([B)I
    //   61: istore_3
    //   62: iload_3
    //   63: iconst_m1
    //   64: if_icmpeq +132 -> 196
    //   67: aload 4
    //   69: aload 6
    //   71: iconst_0
    //   72: iload_3
    //   73: invokevirtual 379	java/io/ByteArrayOutputStream:write	([BII)V
    //   76: goto -21 -> 55
    //   79: astore_1
    //   80: aload 4
    //   82: astore_1
    //   83: aload_1
    //   84: ifnull +7 -> 91
    //   87: aload_1
    //   88: invokevirtual 382	java/io/ByteArrayOutputStream:close	()V
    //   91: aload 5
    //   93: astore 4
    //   95: aload_0
    //   96: ifnull +15 -> 111
    //   99: aload 5
    //   101: astore 4
    //   103: aload_0
    //   104: invokevirtual 383	java/io/InputStream:close	()V
    //   107: aload 5
    //   109: astore 4
    //   111: ldc 111
    //   113: new 71	java/lang/StringBuilder
    //   116: dup
    //   117: ldc_w 385
    //   120: invokespecial 77	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   123: aload 4
    //   125: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: ldc_w 387
    //   131: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: iload_2
    //   135: invokevirtual 390	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   138: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: invokestatic 175	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   144: aload 4
    //   146: areturn
    //   147: aload_0
    //   148: ifnull +42 -> 190
    //   151: aload_0
    //   152: ldc_w 392
    //   155: invokevirtual 361	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   158: ifeq +32 -> 190
    //   161: new 394	java/util/zip/InflaterInputStream
    //   164: dup
    //   165: aload 4
    //   167: new 396	java/util/zip/Inflater
    //   170: dup
    //   171: iconst_1
    //   172: invokespecial 399	java/util/zip/Inflater:<init>	(Z)V
    //   175: invokespecial 402	java/util/zip/InflaterInputStream:<init>	(Ljava/io/InputStream;Ljava/util/zip/Inflater;)V
    //   178: astore_0
    //   179: goto -140 -> 39
    //   182: astore_0
    //   183: aconst_null
    //   184: astore_1
    //   185: aconst_null
    //   186: astore_0
    //   187: goto -104 -> 83
    //   190: aload 4
    //   192: astore_0
    //   193: goto -154 -> 39
    //   196: iload_2
    //   197: ifeq +56 -> 253
    //   200: new 18	java/lang/String
    //   203: dup
    //   204: invokestatic 407	com/tencent/smtt/utils/n:a	()Lcom/tencent/smtt/utils/n;
    //   207: aload 4
    //   209: invokevirtual 408	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   212: invokevirtual 411	com/tencent/smtt/utils/n:c	([B)[B
    //   215: invokespecial 413	java/lang/String:<init>	([B)V
    //   218: astore_1
    //   219: aload 4
    //   221: ifnull +8 -> 229
    //   224: aload 4
    //   226: invokevirtual 382	java/io/ByteArrayOutputStream:close	()V
    //   229: aload_1
    //   230: astore 4
    //   232: aload_0
    //   233: ifnull -122 -> 111
    //   236: aload_1
    //   237: astore 4
    //   239: aload_0
    //   240: invokevirtual 383	java/io/InputStream:close	()V
    //   243: aload_1
    //   244: astore 4
    //   246: goto -135 -> 111
    //   249: astore_0
    //   250: goto -139 -> 111
    //   253: new 18	java/lang/String
    //   256: dup
    //   257: aload 4
    //   259: invokevirtual 408	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   262: aload_1
    //   263: invokestatic 416	com/tencent/smtt/utils/n:b	([BLjava/lang/String;)[B
    //   266: invokespecial 413	java/lang/String:<init>	([B)V
    //   269: astore_1
    //   270: goto -51 -> 219
    //   273: astore_1
    //   274: aconst_null
    //   275: astore 4
    //   277: aconst_null
    //   278: astore_0
    //   279: aload 4
    //   281: ifnull +8 -> 289
    //   284: aload 4
    //   286: invokevirtual 382	java/io/ByteArrayOutputStream:close	()V
    //   289: aload_0
    //   290: ifnull +7 -> 297
    //   293: aload_0
    //   294: invokevirtual 383	java/io/InputStream:close	()V
    //   297: aload_1
    //   298: athrow
    //   299: astore_1
    //   300: goto -209 -> 91
    //   303: astore 4
    //   305: goto -16 -> 289
    //   308: astore_0
    //   309: goto -12 -> 297
    //   312: astore 4
    //   314: goto -85 -> 229
    //   317: astore_1
    //   318: aconst_null
    //   319: astore 4
    //   321: goto -42 -> 279
    //   324: astore_1
    //   325: goto -46 -> 279
    //   328: astore_1
    //   329: aconst_null
    //   330: astore_1
    //   331: goto -248 -> 83
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	334	0	paramHttpURLConnection	java.net.HttpURLConnection
    //   0	334	1	paramString	String
    //   0	334	2	paramBoolean	boolean
    //   61	12	3	i	int
    //   8	277	4	localObject1	Object
    //   303	1	4	localIOException1	java.io.IOException
    //   312	1	4	localIOException2	java.io.IOException
    //   319	1	4	localObject2	Object
    //   2	106	5	str	String
    //   53	17	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   48	55	79	java/lang/Exception
    //   55	62	79	java/lang/Exception
    //   67	76	79	java/lang/Exception
    //   200	219	79	java/lang/Exception
    //   253	270	79	java/lang/Exception
    //   4	15	182	java/lang/Exception
    //   19	39	182	java/lang/Exception
    //   151	179	182	java/lang/Exception
    //   103	107	249	java/io/IOException
    //   239	243	249	java/io/IOException
    //   4	15	273	finally
    //   19	39	273	finally
    //   151	179	273	finally
    //   87	91	299	java/io/IOException
    //   284	289	303	java/io/IOException
    //   293	297	308	java/io/IOException
    //   224	229	312	java/io/IOException
    //   39	48	317	finally
    //   48	55	324	finally
    //   55	62	324	finally
    //   67	76	324	finally
    //   200	219	324	finally
    //   253	270	324	finally
    //   39	48	328	java/lang/Exception
  }
  
  /* Error */
  private static void b(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: invokestatic 422	com/tencent/smtt/sdk/TbsPVConfig:releaseInstance	()V
    //   5: aload_0
    //   6: invokestatic 139	com/tencent/smtt/sdk/TbsPVConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsPVConfig;
    //   9: invokevirtual 425	com/tencent/smtt/sdk/TbsPVConfig:clear	()V
    //   12: aload_1
    //   13: invokestatic 198	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   16: ifeq +4 -> 20
    //   19: return
    //   20: aload_1
    //   21: ldc_w 427
    //   24: invokevirtual 431	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   27: astore_1
    //   28: aload_1
    //   29: arraylength
    //   30: istore_3
    //   31: iload_2
    //   32: iload_3
    //   33: if_icmpge +44 -> 77
    //   36: aload_1
    //   37: iload_2
    //   38: aaload
    //   39: astore 4
    //   41: aload 4
    //   43: ldc_w 433
    //   46: invokevirtual 431	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   49: astore 4
    //   51: aload 4
    //   53: arraylength
    //   54: iconst_2
    //   55: if_icmpne +15 -> 70
    //   58: aload_0
    //   59: aload 4
    //   61: iconst_0
    //   62: aaload
    //   63: aload 4
    //   65: iconst_1
    //   66: aaload
    //   67: invokestatic 435	com/tencent/smtt/sdk/a/b:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   70: iload_2
    //   71: iconst_1
    //   72: iadd
    //   73: istore_2
    //   74: goto -43 -> 31
    //   77: aload_0
    //   78: invokestatic 139	com/tencent/smtt/sdk/TbsPVConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsPVConfig;
    //   81: invokevirtual 438	com/tencent/smtt/sdk/TbsPVConfig:commit	()V
    //   84: return
    //   85: astore_0
    //   86: return
    //   87: astore 4
    //   89: goto -19 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	paramContext	Context
    //   0	92	1	paramString	String
    //   1	73	2	i	int
    //   30	4	3	j	int
    //   39	25	4	arrayOfString	String[]
    //   87	1	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	19	85	java/lang/Exception
    //   20	31	85	java/lang/Exception
    //   77	84	85	java/lang/Exception
    //   41	70	87	java/lang/Exception
  }
  
  /* Error */
  private static org.json.JSONObject c(ThirdAppInfoNew paramThirdAppInfoNew, Context paramContext)
  {
    // Byte code:
    //   0: new 440	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 441	org/json/JSONObject:<init>	()V
    //   7: astore 5
    //   9: aload 5
    //   11: ldc_w 443
    //   14: aload_0
    //   15: getfield 212	MTT/ThirdAppInfoNew:sAppName	Ljava/lang/String;
    //   18: invokevirtual 447	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   21: pop
    //   22: aload 5
    //   24: ldc_w 449
    //   27: aload_0
    //   28: getfield 250	MTT/ThirdAppInfoNew:sTime	Ljava/lang/String;
    //   31: invokevirtual 447	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   34: pop
    //   35: aload 5
    //   37: ldc_w 451
    //   40: aload_0
    //   41: getfield 278	MTT/ThirdAppInfoNew:sQua2	Ljava/lang/String;
    //   44: invokevirtual 447	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   47: pop
    //   48: aload 5
    //   50: ldc_w 453
    //   53: aload_0
    //   54: getfield 281	MTT/ThirdAppInfoNew:sLc	Ljava/lang/String;
    //   57: invokevirtual 447	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   60: pop
    //   61: aload 5
    //   63: ldc_w 455
    //   66: aload_0
    //   67: getfield 275	MTT/ThirdAppInfoNew:sGuid	Ljava/lang/String;
    //   70: invokevirtual 447	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   73: pop
    //   74: aload 5
    //   76: ldc_w 457
    //   79: aload_0
    //   80: getfield 296	MTT/ThirdAppInfoNew:sImei	Ljava/lang/String;
    //   83: invokevirtual 447	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   86: pop
    //   87: aload 5
    //   89: ldc_w 459
    //   92: aload_0
    //   93: getfield 299	MTT/ThirdAppInfoNew:sImsi	Ljava/lang/String;
    //   96: invokevirtual 447	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   99: pop
    //   100: aload 5
    //   102: ldc_w 461
    //   105: aload_0
    //   106: getfield 305	MTT/ThirdAppInfoNew:sMac	Ljava/lang/String;
    //   109: invokevirtual 447	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   112: pop
    //   113: aload 5
    //   115: ldc_w 463
    //   118: aload_0
    //   119: getfield 309	MTT/ThirdAppInfoNew:iPv	J
    //   122: invokevirtual 466	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   125: pop
    //   126: aload 5
    //   128: ldc_w 468
    //   131: aload_0
    //   132: getfield 322	MTT/ThirdAppInfoNew:iCoreType	I
    //   135: invokevirtual 471	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   138: pop
    //   139: aload 5
    //   141: ldc_w 473
    //   144: aload_0
    //   145: getfield 325	MTT/ThirdAppInfoNew:sAppVersionName	Ljava/lang/String;
    //   148: invokevirtual 447	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   151: pop
    //   152: aload 5
    //   154: ldc_w 475
    //   157: aload_0
    //   158: getfield 272	MTT/ThirdAppInfoNew:sMetaData	Ljava/lang/String;
    //   161: invokevirtual 447	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   164: pop
    //   165: aload 5
    //   167: ldc_w 477
    //   170: aload_0
    //   171: getfield 264	MTT/ThirdAppInfoNew:sVersionCode	I
    //   174: invokevirtual 471	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   177: pop
    //   178: aload 5
    //   180: ldc_w 479
    //   183: aload_0
    //   184: getfield 257	MTT/ThirdAppInfoNew:sCpu	Ljava/lang/String;
    //   187: invokevirtual 447	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   190: pop
    //   191: ldc_w 481
    //   194: aload_0
    //   195: getfield 212	MTT/ThirdAppInfoNew:sAppName	Ljava/lang/String;
    //   198: invokevirtual 127	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   201: ifne +16 -> 217
    //   204: ldc_w 483
    //   207: aload_0
    //   208: getfield 212	MTT/ThirdAppInfoNew:sAppName	Ljava/lang/String;
    //   211: invokevirtual 127	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   214: ifeq +253 -> 467
    //   217: new 485	com/tencent/smtt/sdk/TbsDownloadUpload
    //   220: dup
    //   221: aload_1
    //   222: invokespecial 487	com/tencent/smtt/sdk/TbsDownloadUpload:<init>	(Landroid/content/Context;)V
    //   225: astore 6
    //   227: aload 6
    //   229: aload_1
    //   230: invokevirtual 490	com/tencent/smtt/sdk/TbsDownloadUpload:readTbsDownloadInfo	(Landroid/content/Context;)V
    //   233: aload 6
    //   235: invokevirtual 493	com/tencent/smtt/sdk/TbsDownloadUpload:getNeedDownloadCode	()I
    //   238: istore_2
    //   239: aload 6
    //   241: invokevirtual 496	com/tencent/smtt/sdk/TbsDownloadUpload:getStartDownloadCode	()I
    //   244: istore_3
    //   245: aload 6
    //   247: invokevirtual 499	com/tencent/smtt/sdk/TbsDownloadUpload:getNeedDownloadReturn	()I
    //   250: istore 4
    //   252: aload 5
    //   254: ldc_w 501
    //   257: new 71	java/lang/StringBuilder
    //   260: dup
    //   261: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   264: iload_2
    //   265: invokevirtual 99	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   268: ldc 88
    //   270: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: iload_3
    //   274: invokevirtual 99	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   277: ldc 88
    //   279: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: iload 4
    //   284: invokevirtual 99	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   287: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: invokevirtual 447	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   293: pop
    //   294: aload 5
    //   296: ldc_w 503
    //   299: iconst_3
    //   300: invokevirtual 471	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   303: pop
    //   304: aload 5
    //   306: ldc_w 505
    //   309: aload_0
    //   310: getfield 302	MTT/ThirdAppInfoNew:sAndroidID	Ljava/lang/String;
    //   313: invokevirtual 447	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   316: pop
    //   317: aload_1
    //   318: invokestatic 315	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   321: ifeq +195 -> 516
    //   324: aload 5
    //   326: ldc_w 507
    //   329: aload_1
    //   330: invokestatic 511	com/tencent/smtt/sdk/TbsShareManager:getHostCoreVersions	(Landroid/content/Context;)J
    //   333: invokevirtual 466	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   336: pop
    //   337: aload_0
    //   338: getfield 322	MTT/ThirdAppInfoNew:iCoreType	I
    //   341: ifne +69 -> 410
    //   344: aload 5
    //   346: ldc_w 513
    //   349: aload_0
    //   350: getfield 333	MTT/ThirdAppInfoNew:sWifiConnectedTime	J
    //   353: invokevirtual 466	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   356: pop
    //   357: aload 5
    //   359: ldc_w 515
    //   362: aload_0
    //   363: getfield 339	MTT/ThirdAppInfoNew:localCoreVersion	I
    //   366: invokevirtual 471	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   369: pop
    //   370: getstatic 520	com/tencent/smtt/sdk/TbsCoreLoadStat:mLoadErrorCode	I
    //   373: istore_2
    //   374: aload_0
    //   375: getfield 339	MTT/ThirdAppInfoNew:localCoreVersion	I
    //   378: ifgt +167 -> 545
    //   381: aload 5
    //   383: ldc_w 522
    //   386: aload_1
    //   387: invokestatic 527	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   390: invokevirtual 530	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadInterruptCode	()I
    //   393: invokevirtual 471	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   396: pop
    //   397: iload_2
    //   398: iconst_m1
    //   399: if_icmpne +11 -> 410
    //   402: ldc 168
    //   404: ldc_w 532
    //   407: invokestatic 534	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   410: aload_1
    //   411: invokestatic 527	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   414: aload_1
    //   415: invokevirtual 537	com/tencent/smtt/sdk/TbsDownloadConfig:uploadDownloadInterruptCodeIfNeeded	(Landroid/content/Context;)V
    //   418: invokestatic 540	com/tencent/smtt/sdk/QbSdk:getTID	()Ljava/lang/String;
    //   421: ifnull +43 -> 464
    //   424: aload_0
    //   425: getfield 212	MTT/ThirdAppInfoNew:sAppName	Ljava/lang/String;
    //   428: ldc 181
    //   430: invokevirtual 127	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   433: ifeq +125 -> 558
    //   436: aload 5
    //   438: ldc_w 542
    //   441: invokestatic 547	com/tencent/smtt/utils/o:a	()Lcom/tencent/smtt/utils/o;
    //   444: invokestatic 540	com/tencent/smtt/sdk/QbSdk:getTID	()Ljava/lang/String;
    //   447: invokevirtual 550	com/tencent/smtt/utils/o:a	(Ljava/lang/String;)Ljava/lang/String;
    //   450: invokevirtual 447	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   453: pop
    //   454: aload 5
    //   456: ldc_w 552
    //   459: iconst_1
    //   460: invokevirtual 471	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   463: pop
    //   464: aload 5
    //   466: areturn
    //   467: aload_0
    //   468: getfield 330	MTT/ThirdAppInfoNew:sAppSignature	Ljava/lang/String;
    //   471: ifnonnull +29 -> 500
    //   474: aload 5
    //   476: ldc_w 501
    //   479: ldc_w 554
    //   482: invokevirtual 447	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   485: pop
    //   486: goto -192 -> 294
    //   489: astore_0
    //   490: ldc 168
    //   492: ldc_w 556
    //   495: invokestatic 534	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   498: aconst_null
    //   499: areturn
    //   500: aload 5
    //   502: ldc_w 501
    //   505: aload_0
    //   506: getfield 330	MTT/ThirdAppInfoNew:sAppSignature	Ljava/lang/String;
    //   509: invokevirtual 447	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   512: pop
    //   513: goto -219 -> 294
    //   516: aload 5
    //   518: ldc_w 507
    //   521: aload_1
    //   522: invokestatic 561	com/tencent/smtt/sdk/TbsDownloader:getCoreShareDecoupleCoreVersionByContext	(Landroid/content/Context;)I
    //   525: invokevirtual 471	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   528: pop
    //   529: aload 5
    //   531: ldc_w 563
    //   534: aload_1
    //   535: invokestatic 561	com/tencent/smtt/sdk/TbsDownloader:getCoreShareDecoupleCoreVersionByContext	(Landroid/content/Context;)I
    //   538: invokevirtual 471	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   541: pop
    //   542: goto -205 -> 337
    //   545: aload 5
    //   547: ldc_w 522
    //   550: iload_2
    //   551: invokevirtual 471	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   554: pop
    //   555: goto -158 -> 397
    //   558: aload_0
    //   559: getfield 212	MTT/ThirdAppInfoNew:sAppName	Ljava/lang/String;
    //   562: ldc_w 481
    //   565: invokevirtual 127	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   568: ifeq -104 -> 464
    //   571: aload 5
    //   573: ldc_w 542
    //   576: invokestatic 540	com/tencent/smtt/sdk/QbSdk:getTID	()Ljava/lang/String;
    //   579: invokevirtual 447	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   582: pop
    //   583: aload 5
    //   585: ldc_w 552
    //   588: iconst_0
    //   589: invokevirtual 471	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   592: pop
    //   593: aload 5
    //   595: areturn
    //   596: astore_0
    //   597: aload 5
    //   599: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	600	0	paramThirdAppInfoNew	ThirdAppInfoNew
    //   0	600	1	paramContext	Context
    //   238	313	2	i	int
    //   244	30	3	j	int
    //   250	33	4	k	int
    //   7	591	5	localJSONObject	org.json.JSONObject
    //   225	21	6	localTbsDownloadUpload	com.tencent.smtt.sdk.TbsDownloadUpload
    // Exception table:
    //   from	to	target	type
    //   0	217	489	java/lang/Exception
    //   217	294	489	java/lang/Exception
    //   294	337	489	java/lang/Exception
    //   337	397	489	java/lang/Exception
    //   402	410	489	java/lang/Exception
    //   410	418	489	java/lang/Exception
    //   467	486	489	java/lang/Exception
    //   500	513	489	java/lang/Exception
    //   516	542	489	java/lang/Exception
    //   545	555	489	java/lang/Exception
    //   418	464	596	java/lang/Exception
    //   558	593	596	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.sdk.a.b
 * JD-Core Version:    0.7.0.1
 */