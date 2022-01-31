package com.tencent.smtt.sdk.a;

import MTT.ThirdAppInfoNew;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsPVConfig;
import com.tencent.smtt.sdk.TbsShareManager;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.s;
import com.tencent.smtt.utils.v;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;
import java.util.TimeZone;

public class b
{
  public static byte[] a;
  
  static
  {
    AppMethodBeat.i(65150);
    a = null;
    try
    {
      a = "65dRa93L".getBytes("utf-8");
      AppMethodBeat.o(65150);
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      AppMethodBeat.o(65150);
    }
  }
  
  private static String a(Context paramContext)
  {
    int i = 0;
    AppMethodBeat.i(65143);
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
            int j = paramContext.length;
            if (j > 0) {}
          }
          else
          {
            AppMethodBeat.o(65143);
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
          AppMethodBeat.o(65143);
          return paramContext;
        }
      }
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(65143);
    }
    return null;
  }
  
  public static void a(ThirdAppInfoNew paramThirdAppInfoNew, Context paramContext)
  {
    AppMethodBeat.i(65140);
    new c("HttpUtils", paramThirdAppInfoNew, paramContext).start();
    AppMethodBeat.o(65140);
  }
  
  private static void a(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(65146);
    if (("reset".equals(paramString1)) && ("true".equals(paramString2)))
    {
      QbSdk.reset(paramContext);
      AppMethodBeat.o(65146);
      return;
    }
    TbsPVConfig.getInstance(paramContext).putData(paramString1, paramString2);
    AppMethodBeat.o(65146);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean1, long paramLong, boolean paramBoolean2)
  {
    AppMethodBeat.i(139520);
    if ((QbSdk.getSettings() != null) && (QbSdk.getSettings().containsKey(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD)) && (QbSdk.getSettings().get(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false")))
    {
      TbsLog.i("sdkreport", "[HttpUtils.doReport] -- SET_SENDREQUEST_AND_UPLOAD is false");
      AppMethodBeat.o(139520);
      return;
    }
    Object localObject4 = "";
    Object localObject3 = localObject4;
    for (;;)
    {
      try
      {
        ApplicationInfo localApplicationInfo = paramContext.getApplicationInfo();
        Object localObject1 = localObject4;
        localObject3 = localObject4;
        if ("com.tencent.mobileqq".equals(localApplicationInfo.packageName))
        {
          localObject3 = localObject4;
          localObject4 = paramContext.getPackageManager().getPackageInfo(localApplicationInfo.packageName, 0).versionName;
          localObject1 = localObject4;
          localObject3 = localObject4;
          if (!TextUtils.isEmpty(QbSdk.getQQBuildNumber()))
          {
            localObject3 = localObject4;
            localObject1 = (String)localObject4 + "." + QbSdk.getQQBuildNumber();
          }
        }
        Object localObject2;
        continue;
      }
      catch (Exception localException)
      {
        try
        {
          localObject3 = new ThirdAppInfoNew();
          ((ThirdAppInfoNew)localObject3).sAppName = paramContext.getApplicationContext().getApplicationInfo().packageName;
          v.a(paramContext);
          localObject4 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
          ((SimpleDateFormat)localObject4).setTimeZone(TimeZone.getTimeZone("GMT+08"));
          ((ThirdAppInfoNew)localObject3).sTime = ((SimpleDateFormat)localObject4).format(Calendar.getInstance().getTime());
          ((ThirdAppInfoNew)localObject3).sVersionCode = com.tencent.smtt.utils.b.b(paramContext);
          localObject4 = com.tencent.smtt.utils.b.a(paramContext, "com.tencent.mm.BuildInfo.CLIENT_VERSION");
          if (!TextUtils.isEmpty((CharSequence)localObject4)) {
            ((ThirdAppInfoNew)localObject3).sMetaData = ((String)localObject4);
          }
          ((ThirdAppInfoNew)localObject3).sGuid = paramString1;
          if (paramBoolean1)
          {
            ((ThirdAppInfoNew)localObject3).sQua2 = paramString2;
            ((ThirdAppInfoNew)localObject3).bIsSandboxMode = paramBoolean2;
            ((ThirdAppInfoNew)localObject3).sLc = paramString3;
            paramString1 = com.tencent.smtt.utils.b.e(paramContext);
            paramString2 = com.tencent.smtt.utils.b.c(paramContext);
            paramString3 = com.tencent.smtt.utils.b.d(paramContext);
            localObject4 = com.tencent.smtt.utils.b.f(paramContext);
            if ((paramString2 != null) && (!"".equals(paramString2))) {
              ((ThirdAppInfoNew)localObject3).sImei = paramString2;
            }
            if ((paramString3 != null) && (!"".equals(paramString3))) {
              ((ThirdAppInfoNew)localObject3).sImsi = paramString3;
            }
            if (!TextUtils.isEmpty((CharSequence)localObject4)) {
              ((ThirdAppInfoNew)localObject3).sAndroidID = ((String)localObject4);
            }
            if ((paramString1 != null) && (!"".equals(paramString1))) {
              ((ThirdAppInfoNew)localObject3).sMac = paramString1;
            }
            ((ThirdAppInfoNew)localObject3).iPv = paramInt;
            if (!TbsShareManager.isThirdPartyApp(paramContext)) {
              break;
            }
            if (!paramBoolean1) {
              break label517;
            }
            if (TbsShareManager.getCoreFormOwn())
            {
              ((ThirdAppInfoNew)localObject3).iCoreType = 2;
              if (paramBoolean2) {
                ((ThirdAppInfoNew)localObject3).iCoreType = 3;
              }
              ((ThirdAppInfoNew)localObject3).sAppVersionName = ((String)localObject1);
              ((ThirdAppInfoNew)localObject3).sAppSignature = a(paramContext);
              if (!paramBoolean1)
              {
                ((ThirdAppInfoNew)localObject3).sWifiConnectedTime = paramLong;
                ((ThirdAppInfoNew)localObject3).localCoreVersion = QbSdk.getTbsVersion(paramContext);
              }
              a((ThirdAppInfoNew)localObject3, paramContext.getApplicationContext());
              AppMethodBeat.o(139520);
              return;
              localException = localException;
              localObject2 = localObject3;
            }
          }
          else
          {
            ((ThirdAppInfoNew)localObject3).sQua2 = s.a(paramContext);
            continue;
          }
          ((ThirdAppInfoNew)localObject3).iCoreType = 1;
        }
        catch (Throwable paramContext)
        {
          AppMethodBeat.o(139520);
          return;
        }
      }
      label517:
      ((ThirdAppInfoNew)localObject3).iCoreType = 0;
    }
    for (;;)
    {
      ((ThirdAppInfoNew)localObject3).iCoreType = paramInt;
      if ((!paramBoolean1) || (!paramBoolean2)) {
        break;
      }
      ((ThirdAppInfoNew)localObject3).iCoreType = 3;
      break;
      do
      {
        paramInt = 0;
        break;
      } while (!paramBoolean1);
      paramInt = 1;
    }
  }
  
  /* Error */
  private static String b(java.net.HttpURLConnection paramHttpURLConnection, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 361
    //   3: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 84
    //   8: astore 5
    //   10: aload_0
    //   11: invokevirtual 367	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   14: astore 4
    //   16: aload_0
    //   17: invokevirtual 370	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   20: astore_0
    //   21: aload_0
    //   22: ifnull +133 -> 155
    //   25: aload_0
    //   26: ldc_w 372
    //   29: invokevirtual 376	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   32: ifeq +123 -> 155
    //   35: new 378	java/util/zip/GZIPInputStream
    //   38: dup
    //   39: aload 4
    //   41: invokespecial 381	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   44: astore_0
    //   45: new 383	java/io/ByteArrayOutputStream
    //   48: dup
    //   49: invokespecial 384	java/io/ByteArrayOutputStream:<init>	()V
    //   52: astore 4
    //   54: sipush 128
    //   57: newarray byte
    //   59: astore 6
    //   61: aload_0
    //   62: aload 6
    //   64: invokevirtual 390	java/io/InputStream:read	([B)I
    //   67: istore_3
    //   68: iload_3
    //   69: iconst_m1
    //   70: if_icmpeq +134 -> 204
    //   73: aload 4
    //   75: aload 6
    //   77: iconst_0
    //   78: iload_3
    //   79: invokevirtual 394	java/io/ByteArrayOutputStream:write	([BII)V
    //   82: goto -21 -> 61
    //   85: astore_1
    //   86: aload 4
    //   88: astore_1
    //   89: aload_1
    //   90: ifnull +7 -> 97
    //   93: aload_1
    //   94: invokevirtual 397	java/io/ByteArrayOutputStream:close	()V
    //   97: aload 5
    //   99: astore 4
    //   101: aload_0
    //   102: ifnull +11 -> 113
    //   105: aload_0
    //   106: invokevirtual 398	java/io/InputStream:close	()V
    //   109: aload 5
    //   111: astore 4
    //   113: ldc 124
    //   115: new 82	java/lang/StringBuilder
    //   118: dup
    //   119: ldc_w 400
    //   122: invokespecial 88	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   125: aload 4
    //   127: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: ldc_w 402
    //   133: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: iload_2
    //   137: invokevirtual 405	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   140: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: invokestatic 190	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   146: ldc_w 361
    //   149: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   152: aload 4
    //   154: areturn
    //   155: aload_0
    //   156: ifnull +42 -> 198
    //   159: aload_0
    //   160: ldc_w 407
    //   163: invokevirtual 376	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   166: ifeq +32 -> 198
    //   169: new 409	java/util/zip/InflaterInputStream
    //   172: dup
    //   173: aload 4
    //   175: new 411	java/util/zip/Inflater
    //   178: dup
    //   179: iconst_1
    //   180: invokespecial 414	java/util/zip/Inflater:<init>	(Z)V
    //   183: invokespecial 417	java/util/zip/InflaterInputStream:<init>	(Ljava/io/InputStream;Ljava/util/zip/Inflater;)V
    //   186: astore_0
    //   187: goto -142 -> 45
    //   190: astore_0
    //   191: aconst_null
    //   192: astore_1
    //   193: aconst_null
    //   194: astore_0
    //   195: goto -106 -> 89
    //   198: aload 4
    //   200: astore_0
    //   201: goto -156 -> 45
    //   204: iload_2
    //   205: ifeq +51 -> 256
    //   208: new 25	java/lang/String
    //   211: dup
    //   212: invokestatic 422	com/tencent/smtt/utils/o:a	()Lcom/tencent/smtt/utils/o;
    //   215: aload 4
    //   217: invokevirtual 423	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   220: invokevirtual 426	com/tencent/smtt/utils/o:c	([B)[B
    //   223: invokespecial 428	java/lang/String:<init>	([B)V
    //   226: astore_1
    //   227: aload 4
    //   229: invokevirtual 397	java/io/ByteArrayOutputStream:close	()V
    //   232: aload_1
    //   233: astore 4
    //   235: aload_0
    //   236: ifnull -123 -> 113
    //   239: aload_0
    //   240: invokevirtual 398	java/io/InputStream:close	()V
    //   243: aload_1
    //   244: astore 4
    //   246: goto -133 -> 113
    //   249: astore_0
    //   250: aload_1
    //   251: astore 4
    //   253: goto -140 -> 113
    //   256: new 25	java/lang/String
    //   259: dup
    //   260: aload 4
    //   262: invokevirtual 423	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   265: aload_1
    //   266: invokestatic 431	com/tencent/smtt/utils/o:b	([BLjava/lang/String;)[B
    //   269: invokespecial 428	java/lang/String:<init>	([B)V
    //   272: astore_1
    //   273: goto -46 -> 227
    //   276: astore_1
    //   277: aconst_null
    //   278: astore 4
    //   280: aconst_null
    //   281: astore_0
    //   282: aload 4
    //   284: ifnull +8 -> 292
    //   287: aload 4
    //   289: invokevirtual 397	java/io/ByteArrayOutputStream:close	()V
    //   292: aload_0
    //   293: ifnull +7 -> 300
    //   296: aload_0
    //   297: invokevirtual 398	java/io/InputStream:close	()V
    //   300: ldc_w 361
    //   303: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   306: aload_1
    //   307: athrow
    //   308: astore 4
    //   310: goto -78 -> 232
    //   313: astore_1
    //   314: goto -217 -> 97
    //   317: astore_0
    //   318: aload 5
    //   320: astore 4
    //   322: goto -209 -> 113
    //   325: astore 4
    //   327: goto -35 -> 292
    //   330: astore_0
    //   331: goto -31 -> 300
    //   334: astore_1
    //   335: aconst_null
    //   336: astore 4
    //   338: goto -56 -> 282
    //   341: astore_1
    //   342: goto -60 -> 282
    //   345: astore_1
    //   346: aconst_null
    //   347: astore_1
    //   348: goto -259 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	351	0	paramHttpURLConnection	java.net.HttpURLConnection
    //   0	351	1	paramString	String
    //   0	351	2	paramBoolean	boolean
    //   67	12	3	i	int
    //   14	274	4	localObject1	Object
    //   308	1	4	localIOException1	java.io.IOException
    //   320	1	4	str1	String
    //   325	1	4	localIOException2	java.io.IOException
    //   336	1	4	localObject2	Object
    //   8	311	5	str2	String
    //   59	17	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   54	61	85	java/lang/Exception
    //   61	68	85	java/lang/Exception
    //   73	82	85	java/lang/Exception
    //   208	227	85	java/lang/Exception
    //   256	273	85	java/lang/Exception
    //   10	21	190	java/lang/Exception
    //   25	45	190	java/lang/Exception
    //   159	187	190	java/lang/Exception
    //   239	243	249	java/io/IOException
    //   10	21	276	finally
    //   25	45	276	finally
    //   159	187	276	finally
    //   227	232	308	java/io/IOException
    //   93	97	313	java/io/IOException
    //   105	109	317	java/io/IOException
    //   287	292	325	java/io/IOException
    //   296	300	330	java/io/IOException
    //   45	54	334	finally
    //   54	61	341	finally
    //   61	68	341	finally
    //   73	82	341	finally
    //   208	227	341	finally
    //   256	273	341	finally
    //   45	54	345	java/lang/Exception
  }
  
  /* Error */
  private static void b(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: ldc_w 436
    //   5: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 439	com/tencent/smtt/sdk/TbsPVConfig:releaseInstance	()V
    //   11: aload_0
    //   12: invokestatic 154	com/tencent/smtt/sdk/TbsPVConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsPVConfig;
    //   15: invokevirtual 442	com/tencent/smtt/sdk/TbsPVConfig:clear	()V
    //   18: aload_1
    //   19: invokestatic 213	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   22: istore 4
    //   24: iload 4
    //   26: ifeq +10 -> 36
    //   29: ldc_w 436
    //   32: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   35: return
    //   36: aload_1
    //   37: ldc_w 444
    //   40: invokevirtual 448	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   43: astore_1
    //   44: aload_1
    //   45: arraylength
    //   46: istore_3
    //   47: iload_2
    //   48: iload_3
    //   49: if_icmpge +44 -> 93
    //   52: aload_1
    //   53: iload_2
    //   54: aaload
    //   55: astore 5
    //   57: aload 5
    //   59: ldc_w 450
    //   62: invokevirtual 448	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   65: astore 5
    //   67: aload 5
    //   69: arraylength
    //   70: iconst_2
    //   71: if_icmpne +15 -> 86
    //   74: aload_0
    //   75: aload 5
    //   77: iconst_0
    //   78: aaload
    //   79: aload 5
    //   81: iconst_1
    //   82: aaload
    //   83: invokestatic 452	com/tencent/smtt/sdk/a/b:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   86: iload_2
    //   87: iconst_1
    //   88: iadd
    //   89: istore_2
    //   90: goto -43 -> 47
    //   93: aload_0
    //   94: invokestatic 154	com/tencent/smtt/sdk/TbsPVConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsPVConfig;
    //   97: invokevirtual 455	com/tencent/smtt/sdk/TbsPVConfig:commit	()V
    //   100: ldc_w 436
    //   103: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   106: return
    //   107: astore_0
    //   108: ldc_w 436
    //   111: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   114: return
    //   115: astore 5
    //   117: goto -31 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	paramContext	Context
    //   0	120	1	paramString	String
    //   1	89	2	i	int
    //   46	4	3	j	int
    //   22	3	4	bool	boolean
    //   55	25	5	arrayOfString	String[]
    //   115	1	5	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   8	24	107	java/lang/Exception
    //   36	47	107	java/lang/Exception
    //   93	100	107	java/lang/Exception
    //   57	86	115	java/lang/Exception
  }
  
  /* Error */
  private static org.json.JSONObject c(ThirdAppInfoNew paramThirdAppInfoNew, Context paramContext)
  {
    // Byte code:
    //   0: ldc_w 456
    //   3: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 458	org/json/JSONObject
    //   9: dup
    //   10: invokespecial 459	org/json/JSONObject:<init>	()V
    //   13: astore 6
    //   15: aload 6
    //   17: ldc_w 461
    //   20: aload_0
    //   21: getfield 227	MTT/ThirdAppInfoNew:sAppName	Ljava/lang/String;
    //   24: invokevirtual 465	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   27: pop
    //   28: aload 6
    //   30: ldc_w 467
    //   33: aload_0
    //   34: getfield 265	MTT/ThirdAppInfoNew:sTime	Ljava/lang/String;
    //   37: invokevirtual 465	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   40: pop
    //   41: aload 6
    //   43: ldc_w 469
    //   46: aload_0
    //   47: getfield 288	MTT/ThirdAppInfoNew:sQua2	Ljava/lang/String;
    //   50: invokevirtual 465	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   53: pop
    //   54: aload 6
    //   56: ldc_w 471
    //   59: aload_0
    //   60: getfield 295	MTT/ThirdAppInfoNew:sLc	Ljava/lang/String;
    //   63: invokevirtual 465	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   66: pop
    //   67: aload 6
    //   69: ldc_w 473
    //   72: aload_0
    //   73: getfield 285	MTT/ThirdAppInfoNew:sGuid	Ljava/lang/String;
    //   76: invokevirtual 465	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   79: pop
    //   80: aload 6
    //   82: ldc_w 475
    //   85: aload_0
    //   86: getfield 310	MTT/ThirdAppInfoNew:sImei	Ljava/lang/String;
    //   89: invokevirtual 465	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   92: pop
    //   93: aload 6
    //   95: ldc_w 477
    //   98: aload_0
    //   99: getfield 313	MTT/ThirdAppInfoNew:sImsi	Ljava/lang/String;
    //   102: invokevirtual 465	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   105: pop
    //   106: aload 6
    //   108: ldc_w 479
    //   111: aload_0
    //   112: getfield 319	MTT/ThirdAppInfoNew:sMac	Ljava/lang/String;
    //   115: invokevirtual 465	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   118: pop
    //   119: aload 6
    //   121: ldc_w 481
    //   124: aload_0
    //   125: getfield 323	MTT/ThirdAppInfoNew:iPv	J
    //   128: invokevirtual 484	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   131: pop
    //   132: aload 6
    //   134: ldc_w 486
    //   137: aload_0
    //   138: getfield 336	MTT/ThirdAppInfoNew:iCoreType	I
    //   141: invokevirtual 489	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   144: pop
    //   145: aload 6
    //   147: ldc_w 491
    //   150: aload_0
    //   151: getfield 339	MTT/ThirdAppInfoNew:sAppVersionName	Ljava/lang/String;
    //   154: invokevirtual 465	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   157: pop
    //   158: aload 6
    //   160: ldc_w 493
    //   163: aload_0
    //   164: getfield 282	MTT/ThirdAppInfoNew:sMetaData	Ljava/lang/String;
    //   167: invokevirtual 465	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   170: pop
    //   171: aload 6
    //   173: ldc_w 495
    //   176: aload_0
    //   177: getfield 274	MTT/ThirdAppInfoNew:sVersionCode	I
    //   180: invokevirtual 489	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   183: pop
    //   184: aload 6
    //   186: ldc_w 497
    //   189: aload_0
    //   190: getfield 500	MTT/ThirdAppInfoNew:sCpu	Ljava/lang/String;
    //   193: invokevirtual 465	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   196: pop
    //   197: ldc_w 502
    //   200: aload_0
    //   201: getfield 227	MTT/ThirdAppInfoNew:sAppName	Ljava/lang/String;
    //   204: invokevirtual 142	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   207: ifne +28 -> 235
    //   210: ldc 196
    //   212: aload_0
    //   213: getfield 227	MTT/ThirdAppInfoNew:sAppName	Ljava/lang/String;
    //   216: invokevirtual 142	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   219: ifne +16 -> 235
    //   222: ldc_w 504
    //   225: aload_0
    //   226: getfield 227	MTT/ThirdAppInfoNew:sAppName	Ljava/lang/String;
    //   229: invokevirtual 142	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   232: ifeq +276 -> 508
    //   235: new 506	com/tencent/smtt/sdk/TbsDownloadUpload
    //   238: dup
    //   239: aload_1
    //   240: invokespecial 508	com/tencent/smtt/sdk/TbsDownloadUpload:<init>	(Landroid/content/Context;)V
    //   243: astore 7
    //   245: aload 7
    //   247: aload_1
    //   248: invokevirtual 511	com/tencent/smtt/sdk/TbsDownloadUpload:readTbsDownloadInfo	(Landroid/content/Context;)V
    //   251: aload 7
    //   253: invokevirtual 514	com/tencent/smtt/sdk/TbsDownloadUpload:getNeedDownloadCode	()I
    //   256: istore_2
    //   257: aload 7
    //   259: invokevirtual 517	com/tencent/smtt/sdk/TbsDownloadUpload:getStartDownloadCode	()I
    //   262: istore_3
    //   263: aload 7
    //   265: invokevirtual 520	com/tencent/smtt/sdk/TbsDownloadUpload:getNeedDownloadReturn	()I
    //   268: istore 4
    //   270: aload 7
    //   272: invokevirtual 523	com/tencent/smtt/sdk/TbsDownloadUpload:getLocalCoreVersion	()I
    //   275: istore 5
    //   277: aload 6
    //   279: ldc_w 525
    //   282: new 82	java/lang/StringBuilder
    //   285: dup
    //   286: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   289: iload_2
    //   290: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   293: ldc 99
    //   295: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: iload_3
    //   299: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   302: ldc 99
    //   304: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: iload 4
    //   309: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   312: ldc 99
    //   314: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: iload 5
    //   319: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   322: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   325: invokevirtual 465	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   328: pop
    //   329: aload 6
    //   331: ldc_w 527
    //   334: iconst_3
    //   335: invokevirtual 489	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   338: pop
    //   339: aload 6
    //   341: ldc_w 529
    //   344: aload_0
    //   345: getfield 316	MTT/ThirdAppInfoNew:sAndroidID	Ljava/lang/String;
    //   348: invokevirtual 465	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   351: pop
    //   352: aload_1
    //   353: invokestatic 329	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   356: ifeq +207 -> 563
    //   359: aload 6
    //   361: ldc_w 531
    //   364: aload_1
    //   365: invokestatic 535	com/tencent/smtt/sdk/TbsShareManager:getHostCoreVersions	(Landroid/content/Context;)J
    //   368: invokevirtual 484	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   371: pop
    //   372: aload_0
    //   373: getfield 336	MTT/ThirdAppInfoNew:iCoreType	I
    //   376: ifne +69 -> 445
    //   379: aload 6
    //   381: ldc_w 537
    //   384: aload_0
    //   385: getfield 347	MTT/ThirdAppInfoNew:sWifiConnectedTime	J
    //   388: invokevirtual 484	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   391: pop
    //   392: aload 6
    //   394: ldc_w 539
    //   397: aload_0
    //   398: getfield 353	MTT/ThirdAppInfoNew:localCoreVersion	I
    //   401: invokevirtual 489	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   404: pop
    //   405: getstatic 544	com/tencent/smtt/sdk/TbsCoreLoadStat:mLoadErrorCode	I
    //   408: istore_2
    //   409: aload_0
    //   410: getfield 353	MTT/ThirdAppInfoNew:localCoreVersion	I
    //   413: ifgt +179 -> 592
    //   416: aload 6
    //   418: ldc_w 546
    //   421: aload_1
    //   422: invokestatic 551	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   425: invokevirtual 554	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadInterruptCode	()I
    //   428: invokevirtual 489	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   431: pop
    //   432: iload_2
    //   433: iconst_m1
    //   434: if_icmpne +11 -> 445
    //   437: ldc 184
    //   439: ldc_w 556
    //   442: invokestatic 558	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   445: aload_1
    //   446: invokestatic 551	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   449: aload_1
    //   450: invokevirtual 561	com/tencent/smtt/sdk/TbsDownloadConfig:uploadDownloadInterruptCodeIfNeeded	(Landroid/content/Context;)V
    //   453: invokestatic 564	com/tencent/smtt/sdk/QbSdk:getTID	()Ljava/lang/String;
    //   456: ifnull +43 -> 499
    //   459: aload_0
    //   460: getfield 227	MTT/ThirdAppInfoNew:sAppName	Ljava/lang/String;
    //   463: ldc 196
    //   465: invokevirtual 142	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   468: ifeq +137 -> 605
    //   471: aload 6
    //   473: ldc_w 566
    //   476: invokestatic 571	com/tencent/smtt/utils/p:a	()Lcom/tencent/smtt/utils/p;
    //   479: invokestatic 564	com/tencent/smtt/sdk/QbSdk:getTID	()Ljava/lang/String;
    //   482: invokevirtual 574	com/tencent/smtt/utils/p:a	(Ljava/lang/String;)Ljava/lang/String;
    //   485: invokevirtual 465	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   488: pop
    //   489: aload 6
    //   491: ldc_w 576
    //   494: iconst_1
    //   495: invokevirtual 489	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   498: pop
    //   499: ldc_w 456
    //   502: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   505: aload 6
    //   507: areturn
    //   508: aload_0
    //   509: getfield 344	MTT/ThirdAppInfoNew:sAppSignature	Ljava/lang/String;
    //   512: ifnonnull +35 -> 547
    //   515: aload 6
    //   517: ldc_w 525
    //   520: ldc_w 578
    //   523: invokevirtual 465	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   526: pop
    //   527: goto -198 -> 329
    //   530: astore_0
    //   531: ldc 184
    //   533: ldc_w 580
    //   536: invokestatic 558	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   539: ldc_w 456
    //   542: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   545: aconst_null
    //   546: areturn
    //   547: aload 6
    //   549: ldc_w 525
    //   552: aload_0
    //   553: getfield 344	MTT/ThirdAppInfoNew:sAppSignature	Ljava/lang/String;
    //   556: invokevirtual 465	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   559: pop
    //   560: goto -231 -> 329
    //   563: aload 6
    //   565: ldc_w 531
    //   568: aload_1
    //   569: invokestatic 585	com/tencent/smtt/sdk/TbsDownloader:getCoreShareDecoupleCoreVersionByContext	(Landroid/content/Context;)I
    //   572: invokevirtual 489	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   575: pop
    //   576: aload 6
    //   578: ldc_w 587
    //   581: aload_1
    //   582: invokestatic 585	com/tencent/smtt/sdk/TbsDownloader:getCoreShareDecoupleCoreVersionByContext	(Landroid/content/Context;)I
    //   585: invokevirtual 489	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   588: pop
    //   589: goto -217 -> 372
    //   592: aload 6
    //   594: ldc_w 546
    //   597: iload_2
    //   598: invokevirtual 489	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   601: pop
    //   602: goto -170 -> 432
    //   605: aload_0
    //   606: getfield 227	MTT/ThirdAppInfoNew:sAppName	Ljava/lang/String;
    //   609: ldc_w 502
    //   612: invokevirtual 142	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   615: ifeq -116 -> 499
    //   618: aload 6
    //   620: ldc_w 566
    //   623: invokestatic 564	com/tencent/smtt/sdk/QbSdk:getTID	()Ljava/lang/String;
    //   626: invokevirtual 465	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   629: pop
    //   630: aload 6
    //   632: ldc_w 576
    //   635: iconst_0
    //   636: invokevirtual 489	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   639: pop
    //   640: goto -141 -> 499
    //   643: astore_0
    //   644: goto -145 -> 499
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	647	0	paramThirdAppInfoNew	ThirdAppInfoNew
    //   0	647	1	paramContext	Context
    //   256	342	2	i	int
    //   262	37	3	j	int
    //   268	40	4	k	int
    //   275	43	5	m	int
    //   13	618	6	localJSONObject	org.json.JSONObject
    //   243	28	7	localTbsDownloadUpload	com.tencent.smtt.sdk.TbsDownloadUpload
    // Exception table:
    //   from	to	target	type
    //   6	235	530	java/lang/Exception
    //   235	329	530	java/lang/Exception
    //   329	372	530	java/lang/Exception
    //   372	432	530	java/lang/Exception
    //   437	445	530	java/lang/Exception
    //   445	453	530	java/lang/Exception
    //   508	527	530	java/lang/Exception
    //   547	560	530	java/lang/Exception
    //   563	589	530	java/lang/Exception
    //   592	602	530	java/lang/Exception
    //   453	499	643	java/lang/Exception
    //   605	640	643	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.sdk.a.b
 * JD-Core Version:    0.7.0.1
 */