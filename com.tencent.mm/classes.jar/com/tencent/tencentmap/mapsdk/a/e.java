package com.tencent.tencentmap.mapsdk.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.Base64;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.security.Key;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.KeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.http.util.EncodingUtils;

public final class e
{
  private static e a;
  
  public static int a(Context paramContext, Long[] paramArrayOfLong)
  {
    cy.a(" RecordDAO.deleteRecordList() start", new Object[0]);
    if (paramContext == null)
    {
      cy.d(" deleteRecordList() have null args!", new Object[0]);
      return -1;
    }
    cy.a(" RecordDAO.deleteRecordList() end", new Object[0]);
    return cg.a(paramContext, paramArrayOfLong);
  }
  
  /* Error */
  public static cs a(int paramInt1, c paramc, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: ldc 35
    //   2: iconst_0
    //   3: anewarray 4	java/lang/Object
    //   6: invokestatic 38	com/tencent/tencentmap/mapsdk/a/cy:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   9: aload_1
    //   10: ifnonnull +14 -> 24
    //   13: ldc 40
    //   15: iconst_0
    //   16: anewarray 4	java/lang/Object
    //   19: invokestatic 24	com/tencent/tencentmap/mapsdk/a/cy:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   22: aconst_null
    //   23: areturn
    //   24: new 42	com/tencent/tencentmap/mapsdk/a/cs
    //   27: dup
    //   28: invokespecial 43	com/tencent/tencentmap/mapsdk/a/cs:<init>	()V
    //   31: astore 6
    //   33: aload_1
    //   34: monitorenter
    //   35: aload 6
    //   37: aload_1
    //   38: invokevirtual 48	com/tencent/tencentmap/mapsdk/a/c:a	()Ljava/lang/String;
    //   41: putfield 52	com/tencent/tencentmap/mapsdk/a/cs:j	Ljava/lang/String;
    //   44: aload 6
    //   46: aload_1
    //   47: invokevirtual 54	com/tencent/tencentmap/mapsdk/a/c:b	()Ljava/lang/String;
    //   50: putfield 57	com/tencent/tencentmap/mapsdk/a/cs:k	Ljava/lang/String;
    //   53: aload 6
    //   55: aload_1
    //   56: invokevirtual 61	com/tencent/tencentmap/mapsdk/a/c:c	()B
    //   59: putfield 64	com/tencent/tencentmap/mapsdk/a/cs:a	B
    //   62: aload 6
    //   64: aload_1
    //   65: invokevirtual 66	com/tencent/tencentmap/mapsdk/a/c:j	()Ljava/lang/String;
    //   68: putfield 68	com/tencent/tencentmap/mapsdk/a/cs:b	Ljava/lang/String;
    //   71: aload 6
    //   73: aload_1
    //   74: invokevirtual 70	com/tencent/tencentmap/mapsdk/a/c:d	()Ljava/lang/String;
    //   77: putfield 72	com/tencent/tencentmap/mapsdk/a/cs:c	Ljava/lang/String;
    //   80: aload 6
    //   82: aload_1
    //   83: invokevirtual 75	com/tencent/tencentmap/mapsdk/a/c:e	()Ljava/lang/String;
    //   86: putfield 77	com/tencent/tencentmap/mapsdk/a/cs:d	Ljava/lang/String;
    //   89: aload 6
    //   91: aload_1
    //   92: invokevirtual 80	com/tencent/tencentmap/mapsdk/a/c:f	()Ljava/lang/String;
    //   95: putfield 82	com/tencent/tencentmap/mapsdk/a/cs:e	Ljava/lang/String;
    //   98: aload 6
    //   100: ldc 84
    //   102: putfield 87	com/tencent/tencentmap/mapsdk/a/cs:l	Ljava/lang/String;
    //   105: iload_0
    //   106: bipush 100
    //   108: if_icmpne +380 -> 488
    //   111: new 89	java/util/HashMap
    //   114: dup
    //   115: invokespecial 90	java/util/HashMap:<init>	()V
    //   118: astore 7
    //   120: aload 7
    //   122: ldc 92
    //   124: new 94	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   131: invokestatic 98	com/tencent/tencentmap/mapsdk/a/df:a	()Ljava/lang/String;
    //   134: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokeinterface 111 3 0
    //   145: pop
    //   146: aload 7
    //   148: ldc 113
    //   150: new 94	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   157: aload_1
    //   158: invokevirtual 116	com/tencent/tencentmap/mapsdk/a/c:i	()Ljava/lang/String;
    //   161: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokeinterface 111 3 0
    //   172: pop
    //   173: aload_1
    //   174: invokevirtual 119	com/tencent/tencentmap/mapsdk/a/c:l	()Landroid/content/Context;
    //   177: invokestatic 124	com/tencent/tencentmap/mapsdk/a/di:a	(Landroid/content/Context;)Lcom/tencent/tencentmap/mapsdk/a/di;
    //   180: astore 5
    //   182: aload 7
    //   184: ldc 126
    //   186: new 94	java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   193: aload 5
    //   195: invokevirtual 128	com/tencent/tencentmap/mapsdk/a/di:c	()Ljava/lang/String;
    //   198: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokeinterface 111 3 0
    //   209: pop
    //   210: aload 7
    //   212: ldc 130
    //   214: new 94	java/lang/StringBuilder
    //   217: dup
    //   218: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   221: aload 5
    //   223: invokevirtual 131	com/tencent/tencentmap/mapsdk/a/di:b	()Ljava/lang/String;
    //   226: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: invokeinterface 111 3 0
    //   237: pop
    //   238: aload 7
    //   240: ldc 133
    //   242: new 94	java/lang/StringBuilder
    //   245: dup
    //   246: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   249: aload 5
    //   251: invokevirtual 134	com/tencent/tencentmap/mapsdk/a/di:d	()Ljava/lang/String;
    //   254: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: invokeinterface 111 3 0
    //   265: pop
    //   266: aload 7
    //   268: ldc 136
    //   270: new 94	java/lang/StringBuilder
    //   273: dup
    //   274: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   277: aload 5
    //   279: invokevirtual 137	com/tencent/tencentmap/mapsdk/a/di:e	()Ljava/lang/String;
    //   282: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   288: invokeinterface 111 3 0
    //   293: pop
    //   294: aload 7
    //   296: ldc 139
    //   298: new 94	java/lang/StringBuilder
    //   301: dup
    //   302: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   305: aload_1
    //   306: invokevirtual 141	com/tencent/tencentmap/mapsdk/a/c:k	()Ljava/lang/String;
    //   309: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   315: invokeinterface 111 3 0
    //   320: pop
    //   321: aload 7
    //   323: ldc 143
    //   325: new 94	java/lang/StringBuilder
    //   328: dup
    //   329: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   332: aload 5
    //   334: invokevirtual 144	com/tencent/tencentmap/mapsdk/a/di:f	()Ljava/lang/String;
    //   337: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: invokeinterface 111 3 0
    //   348: pop
    //   349: aload_1
    //   350: invokevirtual 119	com/tencent/tencentmap/mapsdk/a/c:l	()Landroid/content/Context;
    //   353: invokestatic 147	com/tencent/tencentmap/mapsdk/a/e:a	(Landroid/content/Context;)Lcom/tencent/tencentmap/mapsdk/a/e;
    //   356: pop
    //   357: aload 7
    //   359: ldc 149
    //   361: aload_1
    //   362: invokevirtual 119	com/tencent/tencentmap/mapsdk/a/c:l	()Landroid/content/Context;
    //   365: invokestatic 153	com/tencent/tencentmap/mapsdk/a/e:g	(Landroid/content/Context;)Ljava/lang/String;
    //   368: invokeinterface 111 3 0
    //   373: pop
    //   374: aload_1
    //   375: invokevirtual 119	com/tencent/tencentmap/mapsdk/a/c:l	()Landroid/content/Context;
    //   378: invokestatic 158	com/tencent/tencentmap/mapsdk/a/a:g	(Landroid/content/Context;)Z
    //   381: ifeq +177 -> 558
    //   384: aload 7
    //   386: ldc 160
    //   388: ldc 162
    //   390: invokeinterface 111 3 0
    //   395: pop
    //   396: aload 7
    //   398: ldc 164
    //   400: new 94	java/lang/StringBuilder
    //   403: dup
    //   404: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   407: aload_1
    //   408: invokevirtual 119	com/tencent/tencentmap/mapsdk/a/c:l	()Landroid/content/Context;
    //   411: invokestatic 166	com/tencent/tencentmap/mapsdk/a/a:i	(Landroid/content/Context;)Ljava/lang/String;
    //   414: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   420: invokeinterface 111 3 0
    //   425: pop
    //   426: aload 7
    //   428: ldc 168
    //   430: new 94	java/lang/StringBuilder
    //   433: dup
    //   434: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   437: aload_1
    //   438: invokevirtual 119	com/tencent/tencentmap/mapsdk/a/c:l	()Landroid/content/Context;
    //   441: invokestatic 172	com/tencent/tencentmap/mapsdk/a/a:h	(Landroid/content/Context;)I
    //   444: invokevirtual 175	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   447: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   450: invokeinterface 111 3 0
    //   455: pop
    //   456: getstatic 178	com/tencent/tencentmap/mapsdk/a/a:b	Z
    //   459: ifeq +126 -> 585
    //   462: ldc 180
    //   464: astore 5
    //   466: aload 7
    //   468: ldc 182
    //   470: aload 5
    //   472: invokeinterface 111 3 0
    //   477: pop
    //   478: aload 6
    //   480: aload 7
    //   482: invokestatic 185	com/tencent/tencentmap/mapsdk/a/e:a	(Ljava/util/Map;)Ljava/lang/String;
    //   485: putfield 87	com/tencent/tencentmap/mapsdk/a/cs:l	Ljava/lang/String;
    //   488: aload_1
    //   489: monitorexit
    //   490: iload_0
    //   491: iconst_4
    //   492: if_icmpeq +13 -> 505
    //   495: iload_0
    //   496: iconst_2
    //   497: if_icmpeq +8 -> 505
    //   500: iload_0
    //   501: iconst_1
    //   502: if_icmpne +14 -> 516
    //   505: aload 6
    //   507: invokestatic 188	com/tencent/tencentmap/mapsdk/a/df:c	()Ljava/util/Map;
    //   510: invokestatic 185	com/tencent/tencentmap/mapsdk/a/e:a	(Ljava/util/Map;)Ljava/lang/String;
    //   513: putfield 87	com/tencent/tencentmap/mapsdk/a/cs:l	Ljava/lang/String;
    //   516: aload 6
    //   518: iload_0
    //   519: putfield 191	com/tencent/tencentmap/mapsdk/a/cs:f	I
    //   522: aload 6
    //   524: iload 4
    //   526: i2b
    //   527: putfield 193	com/tencent/tencentmap/mapsdk/a/cs:h	B
    //   530: aload 6
    //   532: iload_3
    //   533: i2b
    //   534: putfield 195	com/tencent/tencentmap/mapsdk/a/cs:i	B
    //   537: aload_2
    //   538: astore_1
    //   539: aload_2
    //   540: ifnonnull +9 -> 549
    //   543: ldc 84
    //   545: invokevirtual 201	java/lang/String:getBytes	()[B
    //   548: astore_1
    //   549: aload 6
    //   551: aload_1
    //   552: putfield 204	com/tencent/tencentmap/mapsdk/a/cs:g	[B
    //   555: aload 6
    //   557: areturn
    //   558: aload 7
    //   560: ldc 160
    //   562: ldc 205
    //   564: invokeinterface 111 3 0
    //   569: pop
    //   570: goto -174 -> 396
    //   573: astore_2
    //   574: aload_1
    //   575: monitorexit
    //   576: aload_2
    //   577: athrow
    //   578: astore_1
    //   579: aload_1
    //   580: invokestatic 208	com/tencent/tencentmap/mapsdk/a/cy:a	(Ljava/lang/Throwable;)V
    //   583: aconst_null
    //   584: areturn
    //   585: ldc 210
    //   587: astore 5
    //   589: goto -123 -> 466
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	592	0	paramInt1	int
    //   0	592	1	paramc	c
    //   0	592	2	paramArrayOfByte	byte[]
    //   0	592	3	paramInt2	int
    //   0	592	4	paramInt3	int
    //   180	408	5	localObject	Object
    //   31	525	6	localcs	cs
    //   118	441	7	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   35	105	573	finally
    //   111	396	573	finally
    //   396	462	573	finally
    //   466	488	573	finally
    //   488	490	573	finally
    //   558	570	573	finally
    //   24	35	578	java/lang/Throwable
    //   505	516	578	java/lang/Throwable
    //   516	537	578	java/lang/Throwable
    //   543	549	578	java/lang/Throwable
    //   549	555	578	java/lang/Throwable
    //   574	578	578	java/lang/Throwable
  }
  
  public static cu a(dn paramdn)
  {
    if ((paramdn == null) || (!"UA".equals(paramdn.b()))) {
      return null;
    }
    Map localMap = paramdn.e();
    if (localMap == null) {
      return null;
    }
    try
    {
      cu localcu = new cu();
      localcu.a = ((String)localMap.get("A19"));
      localcu.c = paramdn.d();
      localcu.h = paramdn.c();
      localcu.b = ((String)localMap.get("A28"));
      localcu.f = Long.parseLong((String)localMap.get("A26"));
      localcu.d = Boolean.parseBoolean((String)localMap.get("A25"));
      localcu.e = Long.parseLong((String)localMap.get("A27"));
      localMap.remove("A19");
      localMap.remove("A28");
      localMap.remove("A26");
      localMap.remove("A25");
      localMap.remove("A27");
      localcu.g = a(localMap);
      return localcu;
    }
    catch (Throwable paramdn)
    {
      cy.a(paramdn);
      cy.d(paramdn.getMessage(), new Object[0]);
    }
    return null;
  }
  
  public static dn a(Context paramContext, String paramString, boolean paramBoolean1, long paramLong1, long paramLong2, Map<String, String> paramMap, boolean paramBoolean2)
  {
    if (paramString == null) {
      return null;
    }
    c localc = c.m();
    if (localc == null)
    {
      cy.d("  CommonInfo or DeviceInfo have not been Created return null!", new Object[0]);
      return null;
    }
    df.a();
    long l1 = localc.h();
    long l2 = new Date().getTime();
    String str1 = localc.g();
    Object localObject2 = n(paramContext);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "null";
    }
    localObject2 = new HashMap();
    if (paramMap != null) {
      ((Map)localObject2).putAll(paramMap);
    }
    int j = 0;
    int i = j;
    if (dq.d().g().h())
    {
      i = j;
      if (!paramString.startsWith("rqd_")) {
        i = 1;
      }
    }
    paramMap = di.a(paramContext);
    if (i == 0)
    {
      String str2 = df.b();
      if ((str2 != null) && (!str2.equals(""))) {
        ((Map)localObject2).put("QQ", str2);
      }
      ((Map)localObject2).put("A2", localc.i());
      ((Map)localObject2).put("A4", paramMap.c());
      ((Map)localObject2).put("A6", paramMap.b());
      ((Map)localObject2).put("A7", paramMap.d());
      ((Map)localObject2).put("A23", localc.k());
      ((Map)localObject2).put("A31", paramMap.f());
      ((Map)localObject2).put("A67", a.i(paramContext));
      ((Map)localObject2).put("A76", a.a());
      ((Map)localObject2).put("A95", a.e(paramContext));
    }
    ((Map)localObject2).put("A19", localObject1);
    ((Map)localObject2).put("A28", str1);
    ((Map)localObject2).put("A25", String.valueOf(paramBoolean1));
    ((Map)localObject2).put("A26", String.valueOf(paramLong1));
    ((Map)localObject2).put("A27", String.valueOf(paramLong2));
    paramContext = new dn();
    paramContext.b(paramString);
    paramContext.b(l2 + l1);
    paramContext.a("UA");
    paramContext.a((Map)localObject2);
    paramContext.a(paramBoolean2);
    return paramContext;
  }
  
  public static e a(Context paramContext)
  {
    try
    {
      if ((a == null) && (paramContext != null)) {
        a = new e();
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public static String a()
  {
    try
    {
      String str = Build.MODEL;
      return str;
    }
    catch (Throwable localThrowable)
    {
      cy.d("getDeviceName error", new Object[0]);
      cy.a(localThrowable);
    }
    return "";
  }
  
  private static String a(Map<String, String> paramMap)
  {
    cy.b("map 2 str", new Object[0]);
    if (paramMap == null) {
      return "";
    }
    Object localObject = paramMap.keySet();
    if (localObject == null) {
      return "";
    }
    if (((Set)localObject).size() > 50) {
      cy.c("The Map<String, String> params size is more than 50, effective size is <= 50!", new Object[0]);
    }
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = ((Set)localObject).iterator();
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      int i = str2.trim().length();
      String str1;
      if ((i > 0) && (c(str2)))
      {
        str1 = str2.trim();
        localObject = str1;
        if (i > 64) {
          localObject = str1.substring(0, 64);
        }
        localStringBuffer.append("&");
        localStringBuffer.append(((String)localObject).replace("|", "%7C").replace("&", "%26").replace("=", "%3D"));
        localStringBuffer.append("=");
        localObject = (String)paramMap.get(str2);
        if (localObject == null) {
          continue;
        }
        str1 = ((String)localObject).trim();
        if (!str1.contains(";")) {
          break label330;
        }
        localObject = str1;
        if (str1.length() > 10240)
        {
          localObject = str1.substring(0, 10240);
          localObject = ((String)localObject).substring(0, ((String)localObject).lastIndexOf(";"));
        }
      }
      for (;;)
      {
        localStringBuffer.append(((String)localObject).replace('\n', ' ').replace('\r', ' ').replace("|", "%7C").replace("&", "%26").replace("=", "%3D"));
        break;
        cy.c("The Map<String, String> params key is invalid!! key should be ASCII code in 32-126! key:" + str2, new Object[0]);
        break;
        label330:
        localObject = str1;
        if (str1.length() > 1024) {
          localObject = str1.substring(0, 1024);
        }
      }
    }
    paramMap = localStringBuffer.substring(1);
    localStringBuffer.setLength(0);
    return paramMap;
  }
  
  public static HashSet<String> a(ArrayList<String> paramArrayList)
  {
    int i = paramArrayList.size();
    if ((paramArrayList != null) && (i > 0))
    {
      HashSet localHashSet = new HashSet(i);
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        localHashSet.add((String)paramArrayList.next());
      }
      return localHashSet;
    }
    return null;
  }
  
  public static List<dn> a(Context paramContext, int paramInt)
  {
    cy.a(" RecordDAO.queryRecentRecord() start", new Object[0]);
    if (paramContext == null) {
      cy.d(" queryRecentRecord() have null args!", new Object[0]);
    }
    List localList;
    do
    {
      return null;
      localList = cg.a(paramContext, new int[] { 1 }, paramInt);
    } while ((localList == null) || (localList.size() <= 0));
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = localList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      cg localcg = (cg)((Iterator)localObject1).next();
      try
      {
        Object localObject2 = b(localcg.b);
        if ((localObject2 != null) && (dn.class.isInstance(localObject2)))
        {
          localObject2 = (dn)dn.class.cast(localObject2);
          ((dn)localObject2).a(localcg.a);
          localArrayList.add(localObject2);
          ((Iterator)localObject1).remove();
        }
      }
      catch (Throwable localThrowable)
      {
        cy.a(localThrowable);
        cy.d(" query have error!", new Object[0]);
      }
    }
    if (localList.size() > 0)
    {
      cy.a(" there are error datas ,should be remove " + localList.size(), new Object[0]);
      localObject1 = new Long[localList.size()];
      paramInt = 0;
      while (paramInt < localList.size())
      {
        localObject1[paramInt] = Long.valueOf(((cg)localList.get(paramInt)).a);
        paramInt += 1;
      }
      cg.a(paramContext, (Long[])localObject1);
    }
    cy.a(" RecordDAO.queryRecentRecord() end", new Object[0]);
    return localArrayList;
  }
  
  public static boolean a(Context paramContext, cq paramcq)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    if ((paramContext == null) || (paramcq == null)) {}
    SQLiteDatabase localSQLiteDatabase;
    for (;;)
    {
      try
      {
        cy.c("context == null || bean == null}", new Object[0]);
        bool1 = bool2;
        return bool1;
      }
      finally {}
      try
      {
        localSQLiteDatabase = ci.a(paramContext).getWritableDatabase();
        if (localSQLiteDatabase != null) {
          break;
        }
        cy.d("get db fail!,return false ", new Object[0]);
        bool1 = bool2;
      }
      catch (Throwable paramContext)
      {
        cy.d("Error strategy update!  %s", new Object[] { paramContext.toString() });
        bool1 = bool2;
      }
    }
    if (paramcq == null) {
      paramContext = null;
    }
    for (;;)
    {
      if (paramContext != null)
      {
        long l = localSQLiteDatabase.replace("t_strategy", "_id", paramContext);
        if (l < 0L)
        {
          cy.c("insert failure! return false ", new Object[0]);
          bool1 = bool2;
          break;
          paramContext = new ContentValues();
          if (paramcq.a() >= 0L) {
            paramContext.put("_id", Long.valueOf(paramcq.a()));
          }
          paramContext.put("_key", Integer.valueOf(paramcq.b()));
          paramContext.put("_datas", paramcq.c());
          continue;
        }
        paramcq.a(l);
        cy.e("update strategy  %d true ", new Object[] { Integer.valueOf(paramcq.b()) });
      }
    }
    for (;;)
    {
      break;
      bool1 = false;
    }
  }
  
  public static boolean a(Context paramContext, String paramString, Object[] paramArrayOfObject)
  {
    Object localObject = ci.a;
    if ((paramContext != null) && (paramString != null) && (paramArrayOfObject != null)) {}
    for (;;)
    {
      ContentValues localContentValues;
      try
      {
        if (paramArrayOfObject.length == 0) {
          return false;
        }
      }
      finally {}
      try
      {
        paramContext = ci.a(paramContext).getWritableDatabase();
        paramContext.delete("t_conf", "_key = '" + paramString + "'", null);
        localContentValues = new ContentValues();
        localContentValues.put("_key", paramString);
        localContentValues.put("_value", (String)paramArrayOfObject[0]);
        localContentValues.put("_vdate", (Long)paramArrayOfObject[1]);
        localContentValues.put("_time", Long.valueOf(new Date().getTime()));
        if (paramContext.insert("t_conf", null, localContentValues) >= 0L) {
          break label175;
        }
        cy.d(" insertOrUpdateByKey failure! return false!", new Object[0]);
        bool = false;
      }
      catch (Exception paramContext)
      {
        label175:
        bool = false;
        continue;
      }
      return bool;
      bool = true;
    }
  }
  
  /* Error */
  private static byte[] a(Object paramObject)
  {
    // Byte code:
    //   0: ldc_w 607
    //   3: iconst_0
    //   4: anewarray 4	java/lang/Object
    //   7: invokestatic 38	com/tencent/tencentmap/mapsdk/a/cy:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   10: aload_0
    //   11: ifnull +13 -> 24
    //   14: ldc_w 609
    //   17: aload_0
    //   18: invokevirtual 487	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   21: ifne +15 -> 36
    //   24: ldc_w 611
    //   27: iconst_0
    //   28: anewarray 4	java/lang/Object
    //   31: invokestatic 379	com/tencent/tencentmap/mapsdk/a/cy:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   34: aconst_null
    //   35: areturn
    //   36: new 613	java/io/ByteArrayOutputStream
    //   39: dup
    //   40: invokespecial 614	java/io/ByteArrayOutputStream:<init>	()V
    //   43: astore 4
    //   45: new 616	java/io/ObjectOutputStream
    //   48: dup
    //   49: aload 4
    //   51: invokespecial 619	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   54: astore_2
    //   55: aload_2
    //   56: astore_1
    //   57: aload_2
    //   58: aload_0
    //   59: invokevirtual 623	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   62: aload_2
    //   63: astore_1
    //   64: aload_2
    //   65: invokevirtual 626	java/io/ObjectOutputStream:flush	()V
    //   68: aload_2
    //   69: astore_1
    //   70: aload 4
    //   72: invokevirtual 629	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   75: astore_0
    //   76: aload_2
    //   77: invokevirtual 632	java/io/ObjectOutputStream:close	()V
    //   80: aload 4
    //   82: invokevirtual 633	java/io/ByteArrayOutputStream:close	()V
    //   85: aload_0
    //   86: areturn
    //   87: astore_1
    //   88: aload_1
    //   89: invokestatic 208	com/tencent/tencentmap/mapsdk/a/cy:a	(Ljava/lang/Throwable;)V
    //   92: aload_0
    //   93: areturn
    //   94: astore_1
    //   95: aload_1
    //   96: invokestatic 208	com/tencent/tencentmap/mapsdk/a/cy:a	(Ljava/lang/Throwable;)V
    //   99: goto -19 -> 80
    //   102: astore_3
    //   103: aconst_null
    //   104: astore_0
    //   105: aload_0
    //   106: astore_1
    //   107: aload_3
    //   108: invokestatic 208	com/tencent/tencentmap/mapsdk/a/cy:a	(Ljava/lang/Throwable;)V
    //   111: aload_0
    //   112: astore_1
    //   113: aload_3
    //   114: invokevirtual 276	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   117: iconst_0
    //   118: anewarray 4	java/lang/Object
    //   121: invokestatic 24	com/tencent/tencentmap/mapsdk/a/cy:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   124: aload_0
    //   125: ifnull +7 -> 132
    //   128: aload_0
    //   129: invokevirtual 632	java/io/ObjectOutputStream:close	()V
    //   132: aload 4
    //   134: invokevirtual 633	java/io/ByteArrayOutputStream:close	()V
    //   137: aconst_null
    //   138: areturn
    //   139: astore_0
    //   140: aload_0
    //   141: invokestatic 208	com/tencent/tencentmap/mapsdk/a/cy:a	(Ljava/lang/Throwable;)V
    //   144: aconst_null
    //   145: areturn
    //   146: astore_0
    //   147: aload_0
    //   148: invokestatic 208	com/tencent/tencentmap/mapsdk/a/cy:a	(Ljava/lang/Throwable;)V
    //   151: goto -19 -> 132
    //   154: astore_0
    //   155: aconst_null
    //   156: astore_1
    //   157: aload_1
    //   158: ifnull +7 -> 165
    //   161: aload_1
    //   162: invokevirtual 632	java/io/ObjectOutputStream:close	()V
    //   165: aload 4
    //   167: invokevirtual 633	java/io/ByteArrayOutputStream:close	()V
    //   170: aload_0
    //   171: athrow
    //   172: astore_1
    //   173: aload_1
    //   174: invokestatic 208	com/tencent/tencentmap/mapsdk/a/cy:a	(Ljava/lang/Throwable;)V
    //   177: goto -12 -> 165
    //   180: astore_1
    //   181: aload_1
    //   182: invokestatic 208	com/tencent/tencentmap/mapsdk/a/cy:a	(Ljava/lang/Throwable;)V
    //   185: goto -15 -> 170
    //   188: astore_0
    //   189: goto -32 -> 157
    //   192: astore_3
    //   193: aload_2
    //   194: astore_0
    //   195: goto -90 -> 105
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	paramObject	Object
    //   56	14	1	localObjectOutputStream1	java.io.ObjectOutputStream
    //   87	2	1	localIOException1	java.io.IOException
    //   94	2	1	localIOException2	java.io.IOException
    //   106	56	1	localObject	Object
    //   172	2	1	localIOException3	java.io.IOException
    //   180	2	1	localIOException4	java.io.IOException
    //   54	140	2	localObjectOutputStream2	java.io.ObjectOutputStream
    //   102	12	3	localThrowable1	Throwable
    //   192	1	3	localThrowable2	Throwable
    //   43	123	4	localByteArrayOutputStream	ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   80	85	87	java/io/IOException
    //   76	80	94	java/io/IOException
    //   45	55	102	java/lang/Throwable
    //   132	137	139	java/io/IOException
    //   128	132	146	java/io/IOException
    //   45	55	154	finally
    //   161	165	172	java/io/IOException
    //   165	170	180	java/io/IOException
    //   57	62	188	finally
    //   64	68	188	finally
    //   70	76	188	finally
    //   107	111	188	finally
    //   113	124	188	finally
    //   57	62	192	java/lang/Throwable
    //   64	68	192	java/lang/Throwable
    //   70	76	192	java/lang/Throwable
  }
  
  public static byte[] a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      Object localObject = new X509EncodedKeySpec(Base64.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCsAxNCSLyNUCOP1QqYStE8ZeiU\nv4afaMqEmoLCKb0mUZYvYOoVN7LPMi2IVY2MRaFJvuND3glVw1RDm2VJJtjQkwUd\n3kpR9TrHAf7UQOVTpNo3Vi7pXTOqZ6bh3ZA/fs56jDCCKV6+wT/pCeu8N6vVnPrD\nz3SdHIeNeWb/woazCwIDAQAB", 0));
      localObject = (RSAPublicKey)KeyFactory.getInstance("RSA", "BC").generatePublic((KeySpec)localObject);
      Cipher localCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
      localCipher.init(1, (Key)localObject);
      paramString = localCipher.doFinal(paramString.getBytes());
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = null;
      }
    }
  }
  
  private static byte[] a(String paramString, byte[] paramArrayOfByte)
  {
    if ((paramString == null) || (paramArrayOfByte == null)) {
      return null;
    }
    int i = paramString.length();
    while (i < 16)
    {
      paramString = paramString + "0";
      i += 1;
    }
    paramString = paramString.substring(0, 16);
    SecretKeySpec localSecretKeySpec = new SecretKeySpec(paramString.getBytes(), "AES");
    Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    localCipher.init(2, localSecretKeySpec, new IvParameterSpec(paramString.getBytes()));
    return localCipher.doFinal(paramArrayOfByte);
  }
  
  private static byte[] a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
    GZIPInputStream localGZIPInputStream = new GZIPInputStream(paramArrayOfByte);
    byte[] arrayOfByte = new byte[1024];
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    for (;;)
    {
      int i = localGZIPInputStream.read(arrayOfByte, 0, 1024);
      if (i == -1) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    arrayOfByte = localByteArrayOutputStream.toByteArray();
    localByteArrayOutputStream.flush();
    localByteArrayOutputStream.close();
    localGZIPInputStream.close();
    paramArrayOfByte.close();
    return arrayOfByte;
  }
  
  private static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramArrayOfByte == null) || (paramInt == -1)) {
      return paramArrayOfByte;
    }
    cy.b("zp: %s len: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfByte.length) });
    ByteArrayOutputStream localByteArrayOutputStream;
    Object localObject;
    if (paramInt == 1) {
      try
      {
        localByteArrayOutputStream = new ByteArrayOutputStream();
        localObject = new ZipOutputStream(localByteArrayOutputStream);
        ZipEntry localZipEntry = new ZipEntry("zip");
        localZipEntry.setSize(paramArrayOfByte.length);
        ((ZipOutputStream)localObject).putNextEntry(localZipEntry);
        ((ZipOutputStream)localObject).write(paramArrayOfByte);
        ((ZipOutputStream)localObject).closeEntry();
        ((ZipOutputStream)localObject).close();
        paramArrayOfByte = localByteArrayOutputStream.toByteArray();
        localByteArrayOutputStream.close();
        return paramArrayOfByte;
      }
      catch (Throwable paramArrayOfByte)
      {
        cy.a(paramArrayOfByte);
        cy.d("err zp : %s", new Object[] { paramArrayOfByte.toString() });
        return null;
      }
    }
    if (paramInt == 2)
    {
      localByteArrayOutputStream = new ByteArrayOutputStream();
      localObject = new GZIPOutputStream(localByteArrayOutputStream);
      ((GZIPOutputStream)localObject).write(paramArrayOfByte);
      ((GZIPOutputStream)localObject).finish();
      ((GZIPOutputStream)localObject).close();
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      localByteArrayOutputStream.close();
      return paramArrayOfByte;
    }
    return null;
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, String paramString)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    try
    {
      paramArrayOfByte = a(a(paramArrayOfByte, paramInt1), paramInt2, paramString);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      cy.a(paramArrayOfByte);
    }
    return null;
  }
  
  private static byte[] a(byte[] paramArrayOfByte, int paramInt, String paramString)
  {
    if ((paramArrayOfByte == null) || (paramInt == -1)) {
      return paramArrayOfByte;
    }
    cy.b("enD:} %d %d", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(paramInt) });
    if (paramInt == 1) {
      if ((paramString == null) || (paramArrayOfByte == null)) {
        return null;
      }
    }
    try
    {
      Cipher localCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
      DESKeySpec localDESKeySpec = new DESKeySpec(paramString.getBytes("UTF-8"));
      localCipher.init(1, SecretKeyFactory.getInstance("DES").generateSecret(localDESKeySpec), new IvParameterSpec(paramString.getBytes("UTF-8")));
      return localCipher.doFinal(paramArrayOfByte);
    }
    catch (Throwable paramArrayOfByte)
    {
      cy.a(paramArrayOfByte);
      cy.d("err enD: %s", new Object[] { paramArrayOfByte.toString() });
    }
    if (paramInt == 3)
    {
      paramArrayOfByte = b(paramString, paramArrayOfByte);
      return paramArrayOfByte;
    }
    return null;
    return null;
  }
  
  public static Long[] a(Context paramContext, List<dn> paramList)
  {
    int j = 0;
    cy.a(" RecordDAO.insertList() start", new Object[0]);
    if ((paramContext == null) || (paramList == null))
    {
      cy.d(" insertList() have null args!", new Object[0]);
      return null;
    }
    int k = paramList.size();
    if (k == 0)
    {
      cy.b(" list siez == 0 , return true!", new Object[0]);
      return null;
    }
    Long[] arrayOfLong = new Long[k];
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < k)
    {
      dn localdn = (dn)paramList.get(i);
      if ((localdn == null) || (localdn.b() == null) || (!localdn.b().equals("UA"))) {
        cy.d(" bean's type is error!", new Object[0]);
      }
      for (;;)
      {
        i += 1;
        break;
        try
        {
          localArrayList.add(new cg(localdn.c(), a(localdn)));
        }
        catch (Throwable localThrowable)
        {
          cy.a(localThrowable);
        }
      }
    }
    if (!cg.a(paramContext, localArrayList)) {
      return null;
    }
    paramContext = localArrayList.iterator();
    i = j;
    while (paramContext.hasNext())
    {
      paramList = (cg)paramContext.next();
      if (i < k) {
        arrayOfLong[i] = Long.valueOf(paramList.a);
      }
      i += 1;
    }
    return arrayOfLong;
  }
  
  /* Error */
  public static Object[] a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: getstatic 578	com/tencent/tencentmap/mapsdk/a/ci:a	Ljava/lang/Object;
    //   6: astore 5
    //   8: aload 5
    //   10: monitorenter
    //   11: aload_0
    //   12: ifnonnull +18 -> 30
    //   15: ldc_w 803
    //   18: iconst_0
    //   19: anewarray 4	java/lang/Object
    //   22: invokestatic 379	com/tencent/tencentmap/mapsdk/a/cy:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   25: aload 5
    //   27: monitorexit
    //   28: aconst_null
    //   29: areturn
    //   30: aload_1
    //   31: ifnonnull +18 -> 49
    //   34: ldc_w 805
    //   37: iconst_0
    //   38: anewarray 4	java/lang/Object
    //   41: invokestatic 379	com/tencent/tencentmap/mapsdk/a/cy:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   44: aload 5
    //   46: monitorexit
    //   47: aconst_null
    //   48: areturn
    //   49: aload_0
    //   50: invokestatic 518	com/tencent/tencentmap/mapsdk/a/ci:a	(Landroid/content/Context;)Lcom/tencent/tencentmap/mapsdk/a/ci;
    //   53: invokevirtual 522	com/tencent/tencentmap/mapsdk/a/ci:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   56: astore_0
    //   57: aload_0
    //   58: ifnonnull +18 -> 76
    //   61: ldc_w 807
    //   64: iconst_0
    //   65: anewarray 4	java/lang/Object
    //   68: invokestatic 379	com/tencent/tencentmap/mapsdk/a/cy:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   71: aload 5
    //   73: monitorexit
    //   74: aconst_null
    //   75: areturn
    //   76: aload_0
    //   77: ldc_w 580
    //   80: aconst_null
    //   81: new 94	java/lang/StringBuilder
    //   84: dup
    //   85: ldc_w 582
    //   88: invokespecial 443	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   91: aload_1
    //   92: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: ldc_w 584
    //   98: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: aconst_null
    //   105: aconst_null
    //   106: aconst_null
    //   107: aconst_null
    //   108: invokevirtual 811	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   111: astore_0
    //   112: aload_0
    //   113: ifnull +94 -> 207
    //   116: aload_0
    //   117: invokeinterface 816 1 0
    //   122: ifeq +85 -> 207
    //   125: aload_0
    //   126: aload_0
    //   127: ldc_w 593
    //   130: invokeinterface 819 2 0
    //   135: invokeinterface 822 2 0
    //   140: astore 4
    //   142: aload_0
    //   143: aload_0
    //   144: ldc_w 595
    //   147: invokeinterface 819 2 0
    //   152: invokeinterface 826 2 0
    //   157: lstore_2
    //   158: aload_0
    //   159: ifnull +18 -> 177
    //   162: aload_0
    //   163: invokeinterface 829 1 0
    //   168: ifne +9 -> 177
    //   171: aload_0
    //   172: invokeinterface 830 1 0
    //   177: aload 5
    //   179: monitorexit
    //   180: iconst_3
    //   181: anewarray 4	java/lang/Object
    //   184: dup
    //   185: iconst_0
    //   186: aload_1
    //   187: aastore
    //   188: dup
    //   189: iconst_1
    //   190: aload 4
    //   192: aastore
    //   193: dup
    //   194: iconst_2
    //   195: lload_2
    //   196: invokestatic 507	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   199: aastore
    //   200: areturn
    //   201: astore_0
    //   202: aload 5
    //   204: monitorexit
    //   205: aload_0
    //   206: athrow
    //   207: aload_0
    //   208: ifnull +18 -> 226
    //   211: aload_0
    //   212: invokeinterface 829 1 0
    //   217: ifne +9 -> 226
    //   220: aload_0
    //   221: invokeinterface 830 1 0
    //   226: aload 5
    //   228: monitorexit
    //   229: aconst_null
    //   230: areturn
    //   231: aload_0
    //   232: ifnull -6 -> 226
    //   235: aload_0
    //   236: invokeinterface 829 1 0
    //   241: ifne -15 -> 226
    //   244: aload_0
    //   245: invokeinterface 830 1 0
    //   250: goto -24 -> 226
    //   253: aload_1
    //   254: ifnull +18 -> 272
    //   257: aload_1
    //   258: invokeinterface 829 1 0
    //   263: ifne +9 -> 272
    //   266: aload_1
    //   267: invokeinterface 830 1 0
    //   272: aload_0
    //   273: athrow
    //   274: astore 4
    //   276: aload_0
    //   277: astore_1
    //   278: aload 4
    //   280: astore_0
    //   281: goto -28 -> 253
    //   284: astore_1
    //   285: goto -54 -> 231
    //   288: astore_0
    //   289: aconst_null
    //   290: astore_0
    //   291: goto -60 -> 231
    //   294: astore_0
    //   295: aload 4
    //   297: astore_1
    //   298: goto -45 -> 253
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	301	0	paramContext	Context
    //   0	301	1	paramString	String
    //   157	39	2	l	long
    //   1	190	4	str	String
    //   274	22	4	localObject1	Object
    //   6	221	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   15	28	201	finally
    //   34	47	201	finally
    //   71	74	201	finally
    //   162	177	201	finally
    //   177	180	201	finally
    //   211	226	201	finally
    //   226	229	201	finally
    //   235	250	201	finally
    //   257	272	201	finally
    //   272	274	201	finally
    //   116	158	274	finally
    //   116	158	284	java/lang/Exception
    //   49	57	288	java/lang/Exception
    //   61	71	288	java/lang/Exception
    //   76	112	288	java/lang/Exception
    //   49	57	294	finally
    //   61	71	294	finally
    //   76	112	294	finally
  }
  
  /* Error */
  private static Object b(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc_w 832
    //   3: iconst_0
    //   4: anewarray 4	java/lang/Object
    //   7: invokestatic 38	com/tencent/tencentmap/mapsdk/a/cy:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   10: aload_0
    //   11: ifnull +8 -> 19
    //   14: aload_0
    //   15: arraylength
    //   16: ifge +5 -> 21
    //   19: aconst_null
    //   20: areturn
    //   21: new 698	java/io/ByteArrayInputStream
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 699	java/io/ByteArrayInputStream:<init>	([B)V
    //   29: astore_3
    //   30: new 834	java/io/ObjectInputStream
    //   33: dup
    //   34: aload_3
    //   35: invokespecial 835	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   38: astore_1
    //   39: aload_1
    //   40: astore_0
    //   41: aload_1
    //   42: invokevirtual 838	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   45: astore_2
    //   46: aload_1
    //   47: invokevirtual 839	java/io/ObjectInputStream:close	()V
    //   50: aload_3
    //   51: invokevirtual 715	java/io/ByteArrayInputStream:close	()V
    //   54: aload_2
    //   55: areturn
    //   56: astore_0
    //   57: aload_0
    //   58: invokestatic 208	com/tencent/tencentmap/mapsdk/a/cy:a	(Ljava/lang/Throwable;)V
    //   61: aload_2
    //   62: areturn
    //   63: astore_0
    //   64: aload_0
    //   65: invokestatic 208	com/tencent/tencentmap/mapsdk/a/cy:a	(Ljava/lang/Throwable;)V
    //   68: goto -18 -> 50
    //   71: astore_2
    //   72: aconst_null
    //   73: astore_1
    //   74: aload_1
    //   75: astore_0
    //   76: aload_2
    //   77: invokestatic 208	com/tencent/tencentmap/mapsdk/a/cy:a	(Ljava/lang/Throwable;)V
    //   80: aload_1
    //   81: astore_0
    //   82: aload_2
    //   83: invokevirtual 276	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   86: iconst_0
    //   87: anewarray 4	java/lang/Object
    //   90: invokestatic 24	com/tencent/tencentmap/mapsdk/a/cy:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   93: aload_1
    //   94: ifnull +7 -> 101
    //   97: aload_1
    //   98: invokevirtual 839	java/io/ObjectInputStream:close	()V
    //   101: aload_3
    //   102: invokevirtual 715	java/io/ByteArrayInputStream:close	()V
    //   105: aconst_null
    //   106: areturn
    //   107: astore_0
    //   108: aload_0
    //   109: invokestatic 208	com/tencent/tencentmap/mapsdk/a/cy:a	(Ljava/lang/Throwable;)V
    //   112: aconst_null
    //   113: areturn
    //   114: astore_0
    //   115: aload_0
    //   116: invokestatic 208	com/tencent/tencentmap/mapsdk/a/cy:a	(Ljava/lang/Throwable;)V
    //   119: goto -18 -> 101
    //   122: astore_1
    //   123: aconst_null
    //   124: astore_0
    //   125: aload_0
    //   126: ifnull +7 -> 133
    //   129: aload_0
    //   130: invokevirtual 839	java/io/ObjectInputStream:close	()V
    //   133: aload_3
    //   134: invokevirtual 715	java/io/ByteArrayInputStream:close	()V
    //   137: aload_1
    //   138: athrow
    //   139: astore_0
    //   140: aload_0
    //   141: invokestatic 208	com/tencent/tencentmap/mapsdk/a/cy:a	(Ljava/lang/Throwable;)V
    //   144: goto -11 -> 133
    //   147: astore_0
    //   148: aload_0
    //   149: invokestatic 208	com/tencent/tencentmap/mapsdk/a/cy:a	(Ljava/lang/Throwable;)V
    //   152: goto -15 -> 137
    //   155: astore_1
    //   156: goto -31 -> 125
    //   159: astore_2
    //   160: goto -86 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	paramArrayOfByte	byte[]
    //   38	60	1	localObjectInputStream	java.io.ObjectInputStream
    //   122	16	1	localObject1	Object
    //   155	1	1	localObject2	Object
    //   45	17	2	localObject3	Object
    //   71	12	2	localThrowable1	Throwable
    //   159	1	2	localThrowable2	Throwable
    //   29	105	3	localByteArrayInputStream	ByteArrayInputStream
    // Exception table:
    //   from	to	target	type
    //   50	54	56	java/io/IOException
    //   46	50	63	java/io/IOException
    //   30	39	71	java/lang/Throwable
    //   101	105	107	java/io/IOException
    //   97	101	114	java/io/IOException
    //   30	39	122	finally
    //   129	133	139	java/io/IOException
    //   133	137	147	java/io/IOException
    //   41	46	155	finally
    //   76	80	155	finally
    //   82	93	155	finally
    //   41	46	159	java/lang/Throwable
  }
  
  public static String b()
  {
    try
    {
      String str = Build.VERSION.RELEASE;
      return str;
    }
    catch (Throwable localThrowable)
    {
      cy.d("getVersion error", new Object[0]);
      cy.a(localThrowable);
    }
    return "";
  }
  
  public static String b(Context paramContext)
  {
    if (paramContext == null)
    {
      cy.d("getImei but context == null!", new Object[0]);
      return "";
    }
    for (;;)
    {
      try
      {
        if (!a.f(paramContext)) {
          continue;
        }
        paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
        if (paramContext != null) {
          continue;
        }
        paramContext = "";
      }
      catch (Throwable paramContext)
      {
        Object localObject = "";
        continue;
        paramContext = "";
        continue;
      }
      localObject = paramContext;
      try
      {
        cy.a("IMEI:" + paramContext, new Object[0]);
        return paramContext;
      }
      catch (Throwable paramContext) {}
      cy.d("getImei error!", new Object[0]);
      return localObject;
      localObject = paramContext;
      paramContext = paramContext.toLowerCase();
    }
  }
  
  public static String b(Context paramContext, int paramInt)
  {
    try
    {
      Object localObject = di.a(paramContext);
      paramContext = ((di)localObject).a();
      localObject = ((di)localObject).b();
      paramContext = g(paramContext + "_" + (String)localObject + "_" + new Date().getTime() + "_" + paramInt);
      return paramContext;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  public static String b(String paramString)
  {
    String str2 = "unknown";
    String str1 = str2;
    if (paramString != null)
    {
      if (paramString.trim().length() == 0) {
        str1 = str2;
      }
    }
    else {
      return str1;
    }
    str1 = paramString.trim();
    int i = str1.length();
    int j;
    do
    {
      i -= 1;
      if (i < 0) {
        break;
      }
      j = str1.charAt(i);
    } while ((j >= 48) && (j <= 57));
    for (i = 0;; i = 1)
    {
      if (i == 0) {
        break label98;
      }
      paramString = paramString.trim();
      str1 = paramString;
      if (paramString.length() <= 16) {
        break;
      }
      return paramString.substring(0, 16);
    }
    label98:
    cy.c("channelID is invalid!! channelID should be Numeric! channelID:" + paramString, new Object[0]);
    return "unknown";
  }
  
  private static byte[] b(String paramString, byte[] paramArrayOfByte)
  {
    if ((paramString == null) || (paramArrayOfByte == null)) {
      return null;
    }
    int i = paramString.length();
    while (i < 16)
    {
      paramString = paramString + "0";
      i += 1;
    }
    paramString = paramString.substring(0, 16);
    SecretKeySpec localSecretKeySpec = new SecretKeySpec(paramString.getBytes(), "AES");
    Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    localCipher.init(1, localSecretKeySpec, new IvParameterSpec(paramString.getBytes()));
    return localCipher.doFinal(paramArrayOfByte);
  }
  
  private static byte[] b(byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramArrayOfByte == null) || (paramInt == -1)) {
      return paramArrayOfByte;
    }
    cy.b("unzp: %s len: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfByte.length) });
    if (paramInt == 1)
    {
      ByteArrayInputStream localByteArrayInputStream;
      ZipInputStream localZipInputStream;
      for (;;)
      {
        ByteArrayOutputStream localByteArrayOutputStream;
        try
        {
          localByteArrayInputStream = new ByteArrayInputStream(paramArrayOfByte);
          localZipInputStream = new ZipInputStream(localByteArrayInputStream);
          paramArrayOfByte = null;
          if (localZipInputStream.getNextEntry() == null) {
            break;
          }
          paramArrayOfByte = new byte[1024];
          localByteArrayOutputStream = new ByteArrayOutputStream();
          paramInt = localZipInputStream.read(paramArrayOfByte, 0, 1024);
          if (paramInt != -1)
          {
            localByteArrayOutputStream.write(paramArrayOfByte, 0, paramInt);
            continue;
          }
          paramArrayOfByte = localByteArrayOutputStream.toByteArray();
        }
        catch (Throwable paramArrayOfByte)
        {
          cy.a(paramArrayOfByte);
          cy.d("err unzp}" + paramArrayOfByte.toString(), new Object[0]);
          return null;
        }
        localByteArrayOutputStream.flush();
        localByteArrayOutputStream.close();
      }
      localZipInputStream.close();
      localByteArrayInputStream.close();
      return paramArrayOfByte;
    }
    if (paramInt == 2)
    {
      paramArrayOfByte = a(paramArrayOfByte);
      return paramArrayOfByte;
    }
    return null;
  }
  
  public static byte[] b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, String paramString)
  {
    try
    {
      paramArrayOfByte = b(b(paramArrayOfByte, paramInt2, paramString), paramInt1);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      cy.a(paramArrayOfByte);
    }
    return null;
  }
  
  private static byte[] b(byte[] paramArrayOfByte, int paramInt, String paramString)
  {
    if ((paramArrayOfByte == null) || (paramInt == -1)) {
      return paramArrayOfByte;
    }
    if (paramInt == 1) {
      if ((paramString == null) || (paramArrayOfByte == null)) {
        return null;
      }
    }
    try
    {
      Cipher localCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
      DESKeySpec localDESKeySpec = new DESKeySpec(paramString.getBytes("UTF-8"));
      localCipher.init(2, SecretKeyFactory.getInstance("DES").generateSecret(localDESKeySpec), new IvParameterSpec(paramString.getBytes("UTF-8")));
      return localCipher.doFinal(paramArrayOfByte);
    }
    catch (Throwable paramArrayOfByte)
    {
      cy.a(paramArrayOfByte);
      cy.d("err unD: %s", new Object[] { paramArrayOfByte.toString() });
    }
    if (paramInt == 3)
    {
      paramArrayOfByte = a(paramString, paramArrayOfByte);
      return paramArrayOfByte;
    }
    return null;
    return null;
  }
  
  public static String c()
  {
    try
    {
      String str = Build.VERSION.SDK;
      return str;
    }
    catch (Throwable localThrowable)
    {
      cy.d("getApiLevel error", new Object[0]);
      cy.a(localThrowable);
    }
    return "";
  }
  
  public static String c(Context paramContext)
  {
    String str = "";
    if (paramContext == null)
    {
      cy.d("getImsi but context == null!", new Object[0]);
      return "";
    }
    Object localObject = str;
    try
    {
      if (a.f(paramContext))
      {
        localObject = str;
        paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getSubscriberId();
        if (paramContext == null)
        {
          paramContext = "";
        }
        else
        {
          localObject = paramContext;
          paramContext = paramContext.toLowerCase();
        }
      }
    }
    catch (Throwable paramContext)
    {
      paramContext = (Context)localObject;
      cy.d("getImsi error!", new Object[0]);
    }
    paramContext = "";
    return paramContext;
  }
  
  public static boolean c(String paramString)
  {
    boolean bool = true;
    int i = paramString.length();
    for (;;)
    {
      int j = i - 1;
      if (j < 0) {
        break;
      }
      int k = paramString.charAt(j);
      if (k >= 32)
      {
        i = j;
        if (k < 127) {}
      }
      else
      {
        bool = false;
        i = j;
      }
    }
    return bool;
  }
  
  public static String d()
  {
    try
    {
      String str = Build.BRAND;
      return str;
    }
    catch (Throwable localThrowable)
    {
      cy.d("getBrand error!", new Object[0]);
      cy.a(localThrowable);
    }
    return null;
  }
  
  public static String d(Context paramContext)
  {
    Object localObject = "";
    if (paramContext == null)
    {
      cy.d("getAndroidId but context == null!", new Object[0]);
      return "";
    }
    try
    {
      paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      if (paramContext == null) {
        return "";
      }
      localObject = paramContext;
      paramContext = paramContext.toLowerCase();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      cy.d("getAndroidId error!", new Object[0]);
      cy.a(paramContext);
    }
    return localObject;
  }
  
  public static Date d(String paramString)
  {
    if ((paramString == null) || (paramString.trim().length() <= 0)) {
      return null;
    }
    try
    {
      paramString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).parse(paramString);
      return paramString;
    }
    catch (ParseException paramString)
    {
      cy.a(paramString);
    }
    return null;
  }
  
  public static String e()
  {
    try
    {
      Object localObject = new StatFs(Environment.getDataDirectory().getPath());
      long l1 = ((StatFs)localObject).getBlockSize();
      long l2 = ((StatFs)localObject).getBlockCount();
      localObject = l2 * l1 / 1024L / 1024L;
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      cy.d("getDisplayMetrics error!", new Object[0]);
      cy.a(localThrowable);
    }
    return null;
  }
  
  public static String e(Context paramContext)
  {
    int i = 0;
    Object localObject;
    if (paramContext == null)
    {
      cy.d("getMacAddress but context == null!", new Object[0]);
      localObject = "";
      return localObject;
    }
    try
    {
      if (Integer.valueOf(Build.VERSION.SDK).intValue() < 23)
      {
        localObject = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getMacAddress();
        if (localObject == null) {
          return "";
        }
        paramContext = (Context)localObject;
      }
    }
    catch (Throwable localThrowable1)
    {
      paramContext = "";
    }
    try
    {
      localObject = ((String)localObject).toLowerCase();
      return localObject;
    }
    catch (Throwable localThrowable2)
    {
      break label141;
    }
    for (paramContext = "";; paramContext = (Context)localObject)
    {
      localObject = paramContext;
      if (i >= 2) {
        break;
      }
      localObject = e(new String[] { "/sys/class/net/wlan0/address", "/sys/devices/virtual/net/wlan0/address" }[i]).toString().trim();
      if (localObject != null)
      {
        paramContext = (Context)localObject;
        if (((String)localObject).length() > 0)
        {
          paramContext = (Context)localObject;
          localObject = ((String)localObject).toLowerCase();
          return localObject;
        }
      }
      i += 1;
    }
    label141:
    cy.a(localThrowable1);
    return paramContext;
  }
  
  public static String e(String paramString)
  {
    String str2 = "";
    String str1 = str2;
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(paramString);
      str1 = str2;
      byte[] arrayOfByte = new byte[localFileInputStream.available()];
      str1 = str2;
      localFileInputStream.read(arrayOfByte);
      str1 = str2;
      str2 = EncodingUtils.getString(arrayOfByte, "UTF-8");
      str1 = str2;
      localFileInputStream.close();
      return str2;
    }
    catch (Exception localException)
    {
      cy.d("Read file %s failed.", new Object[] { paramString });
    }
    return str1;
  }
  
  public static String f()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      BufferedReader localBufferedReader = new BufferedReader(new FileReader(new File("/sys/block/mmcblk0/device/type")));
      String str = localBufferedReader.readLine();
      localBufferedReader.close();
      localStringBuilder.append(str).append(",");
      localBufferedReader = new BufferedReader(new FileReader(new File("/sys/block/mmcblk0/device/name")));
      str = localBufferedReader.readLine();
      localBufferedReader.close();
      localStringBuilder.append(str).append(",");
      localBufferedReader = new BufferedReader(new FileReader(new File("/sys/block/mmcblk0/device/cid")));
      str = localBufferedReader.readLine();
      localBufferedReader.close();
      localStringBuilder.append(str);
      return localStringBuilder.toString();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        cy.a(localException);
      }
    }
  }
  
  public static String f(Context paramContext)
  {
    if (a != null) {
      return g(paramContext);
    }
    return "unknown";
  }
  
  private static String f(String paramString)
  {
    int i = 0;
    try
    {
      Object localObject = MessageDigest.getInstance("MD5").digest(paramString.getBytes());
      StringBuffer localStringBuffer = new StringBuffer();
      int j = localObject.length;
      while (i < j)
      {
        int k = localObject[i] & 0xFF;
        if (k < 16) {
          localStringBuffer.append(0);
        }
        localStringBuffer.append(Integer.toHexString(k));
        i += 1;
      }
      localObject = localStringBuffer.toString();
      return localObject;
    }
    catch (Exception localException)
    {
      cy.a(localException);
    }
    return paramString;
  }
  
  public static String g()
  {
    try
    {
      String str = new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(new Date());
      return str;
    }
    catch (Throwable localThrowable)
    {
      cy.a(localThrowable);
    }
    return "";
  }
  
  public static String g(Context paramContext)
  {
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (localNetworkInfo == null) {
        return "unknown";
      }
      if (localNetworkInfo.getType() == 1)
      {
        paramContext = "wifi";
      }
      else if (localNetworkInfo.getType() == 0)
      {
        paramContext = (TelephonyManager)paramContext.getSystemService("phone");
        if (paramContext != null) {
          switch (paramContext.getNetworkType())
          {
          case 15: 
            paramContext = "HSPA+";
          }
        }
      }
    }
    catch (Exception paramContext)
    {
      cy.a(paramContext);
      paramContext = "unknown";
    }
    for (;;)
    {
      return paramContext;
      paramContext = "unknown";
      continue;
      paramContext = "GPRS";
      continue;
      paramContext = "EDGE";
      continue;
      paramContext = "UMTS";
      continue;
      paramContext = "HSDPA";
      continue;
      paramContext = "HSUPA";
      continue;
      paramContext = "HSPA";
      continue;
      paramContext = "CDMA";
      continue;
      paramContext = "EVDO_0";
      continue;
      paramContext = "EVDO_A";
      continue;
      paramContext = "1xRTT";
      continue;
      paramContext = "iDen";
      continue;
      paramContext = "EVDO_B";
      continue;
      paramContext = "LTE";
      continue;
      paramContext = "eHRPD";
    }
  }
  
  private static String g(String paramString)
  {
    String str = f(paramString);
    paramString = str;
    if (str != null) {}
    try
    {
      paramString = str.substring(8, 24);
      return paramString;
    }
    catch (Exception paramString) {}
    return str;
  }
  
  /* Error */
  public static cq h(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc 2
    //   5: monitorenter
    //   6: aload_0
    //   7: ifnonnull +20 -> 27
    //   10: ldc_w 1128
    //   13: iconst_0
    //   14: anewarray 4	java/lang/Object
    //   17: invokestatic 379	com/tencent/tencentmap/mapsdk/a/cy:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   20: aconst_null
    //   21: astore_2
    //   22: ldc 2
    //   24: monitorexit
    //   25: aload_2
    //   26: areturn
    //   27: aload_0
    //   28: invokestatic 518	com/tencent/tencentmap/mapsdk/a/ci:a	(Landroid/content/Context;)Lcom/tencent/tencentmap/mapsdk/a/ci;
    //   31: invokevirtual 522	com/tencent/tencentmap/mapsdk/a/ci:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   34: astore_0
    //   35: aload_0
    //   36: ifnonnull +18 -> 54
    //   39: ldc_w 807
    //   42: iconst_0
    //   43: anewarray 4	java/lang/Object
    //   46: invokestatic 379	com/tencent/tencentmap/mapsdk/a/cy:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   49: aconst_null
    //   50: astore_2
    //   51: goto -29 -> 22
    //   54: aload_0
    //   55: ldc_w 529
    //   58: aconst_null
    //   59: getstatic 956	java/util/Locale:US	Ljava/util/Locale;
    //   62: ldc_w 1130
    //   65: iconst_2
    //   66: anewarray 4	java/lang/Object
    //   69: dup
    //   70: iconst_0
    //   71: ldc_w 550
    //   74: aastore
    //   75: dup
    //   76: iconst_1
    //   77: bipush 101
    //   79: invokestatic 557	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   82: aastore
    //   83: invokestatic 1133	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   86: aconst_null
    //   87: aconst_null
    //   88: aconst_null
    //   89: aconst_null
    //   90: invokevirtual 811	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   93: astore_3
    //   94: aload_3
    //   95: ifnull +277 -> 372
    //   98: aload_3
    //   99: astore_2
    //   100: aload_3
    //   101: invokeinterface 816 1 0
    //   106: ifeq +266 -> 372
    //   109: aload 4
    //   111: astore_0
    //   112: aload_3
    //   113: ifnull +33 -> 146
    //   116: aload 4
    //   118: astore_0
    //   119: aload_3
    //   120: astore_2
    //   121: aload_3
    //   122: invokeinterface 1136 1 0
    //   127: ifne +19 -> 146
    //   130: aload_3
    //   131: astore_2
    //   132: aload_3
    //   133: invokeinterface 1139 1 0
    //   138: istore_1
    //   139: iload_1
    //   140: ifeq +66 -> 206
    //   143: aload 4
    //   145: astore_0
    //   146: aload_0
    //   147: ifnull +25 -> 172
    //   150: aload_3
    //   151: astore_2
    //   152: ldc_w 1141
    //   155: iconst_1
    //   156: anewarray 4	java/lang/Object
    //   159: dup
    //   160: iconst_0
    //   161: aload_0
    //   162: invokevirtual 552	com/tencent/tencentmap/mapsdk/a/cq:b	()I
    //   165: invokestatic 557	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   168: aastore
    //   169: invokestatic 1143	com/tencent/tencentmap/mapsdk/a/cy:g	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   172: aload_0
    //   173: astore_2
    //   174: aload_3
    //   175: ifnull -153 -> 22
    //   178: aload_0
    //   179: astore_2
    //   180: aload_3
    //   181: invokeinterface 829 1 0
    //   186: ifne -164 -> 22
    //   189: aload_3
    //   190: invokeinterface 830 1 0
    //   195: aload_0
    //   196: astore_2
    //   197: goto -175 -> 22
    //   200: astore_0
    //   201: ldc 2
    //   203: monitorexit
    //   204: aload_0
    //   205: athrow
    //   206: aload_3
    //   207: astore_2
    //   208: ldc_w 1145
    //   211: iconst_0
    //   212: anewarray 4	java/lang/Object
    //   215: invokestatic 38	com/tencent/tencentmap/mapsdk/a/cy:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   218: aload_3
    //   219: astore_2
    //   220: new 543	com/tencent/tencentmap/mapsdk/a/cq
    //   223: dup
    //   224: invokespecial 1146	com/tencent/tencentmap/mapsdk/a/cq:<init>	()V
    //   227: astore_0
    //   228: aload_3
    //   229: astore_2
    //   230: aload_0
    //   231: aload_3
    //   232: aload_3
    //   233: ldc_w 531
    //   236: invokeinterface 819 2 0
    //   241: invokeinterface 826 2 0
    //   246: invokevirtual 568	com/tencent/tencentmap/mapsdk/a/cq:a	(J)V
    //   249: aload_3
    //   250: astore_2
    //   251: aload_0
    //   252: aload_3
    //   253: aload_3
    //   254: ldc_w 550
    //   257: invokeinterface 819 2 0
    //   262: invokeinterface 1150 2 0
    //   267: invokevirtual 1152	com/tencent/tencentmap/mapsdk/a/cq:a	(I)V
    //   270: aload_3
    //   271: astore_2
    //   272: aload_0
    //   273: aload_3
    //   274: aload_3
    //   275: ldc_w 562
    //   278: invokeinterface 819 2 0
    //   283: invokeinterface 1156 2 0
    //   288: invokevirtual 1158	com/tencent/tencentmap/mapsdk/a/cq:a	([B)V
    //   291: goto -145 -> 146
    //   294: astore 4
    //   296: aconst_null
    //   297: astore_0
    //   298: aconst_null
    //   299: astore_3
    //   300: aload_3
    //   301: astore_2
    //   302: aload 4
    //   304: invokestatic 208	com/tencent/tencentmap/mapsdk/a/cy:a	(Ljava/lang/Throwable;)V
    //   307: aload_0
    //   308: astore_2
    //   309: aload_3
    //   310: ifnull -288 -> 22
    //   313: aload_0
    //   314: astore_2
    //   315: aload_3
    //   316: invokeinterface 829 1 0
    //   321: ifne -299 -> 22
    //   324: aload_3
    //   325: invokeinterface 830 1 0
    //   330: aload_0
    //   331: astore_2
    //   332: goto -310 -> 22
    //   335: aload_2
    //   336: ifnull +18 -> 354
    //   339: aload_2
    //   340: invokeinterface 829 1 0
    //   345: ifne +9 -> 354
    //   348: aload_2
    //   349: invokeinterface 830 1 0
    //   354: aload_0
    //   355: athrow
    //   356: astore_0
    //   357: goto -22 -> 335
    //   360: astore 4
    //   362: aconst_null
    //   363: astore_0
    //   364: goto -64 -> 300
    //   367: astore 4
    //   369: goto -69 -> 300
    //   372: aconst_null
    //   373: astore_0
    //   374: goto -202 -> 172
    //   377: astore_0
    //   378: aconst_null
    //   379: astore_2
    //   380: goto -45 -> 335
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	383	0	paramContext	Context
    //   138	2	1	bool	boolean
    //   21	359	2	localObject1	Object
    //   93	232	3	localCursor	android.database.Cursor
    //   1	143	4	localObject2	Object
    //   294	9	4	localThrowable1	Throwable
    //   360	1	4	localThrowable2	Throwable
    //   367	1	4	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   10	20	200	finally
    //   180	195	200	finally
    //   315	330	200	finally
    //   339	354	200	finally
    //   354	356	200	finally
    //   27	35	294	java/lang/Throwable
    //   39	49	294	java/lang/Throwable
    //   54	94	294	java/lang/Throwable
    //   100	109	356	finally
    //   121	130	356	finally
    //   132	139	356	finally
    //   152	172	356	finally
    //   208	218	356	finally
    //   220	228	356	finally
    //   230	249	356	finally
    //   251	270	356	finally
    //   272	291	356	finally
    //   302	307	356	finally
    //   100	109	360	java/lang/Throwable
    //   121	130	360	java/lang/Throwable
    //   132	139	360	java/lang/Throwable
    //   208	218	360	java/lang/Throwable
    //   220	228	360	java/lang/Throwable
    //   230	249	360	java/lang/Throwable
    //   251	270	360	java/lang/Throwable
    //   272	291	360	java/lang/Throwable
    //   152	172	367	java/lang/Throwable
    //   27	35	377	finally
    //   39	49	377	finally
    //   54	94	377	finally
  }
  
  public static int i(Context paramContext)
  {
    int k = 0;
    int j = 0;
    if (paramContext == null) {}
    for (;;)
    {
      try
      {
        cy.c("context == null ||key < -1}", new Object[0]);
        i = j;
        return i;
      }
      finally {}
      int i = k;
      try
      {
        paramContext = ci.a(paramContext).getWritableDatabase();
        if (paramContext != null) {
          break label73;
        }
        i = k;
        cy.d("get db fail!,return ", new Object[0]);
        i = j;
      }
      catch (Throwable paramContext)
      {
        cy.a(paramContext);
      }
      continue;
      label73:
      i = k;
      j = paramContext.delete("t_strategy", String.format("%s = %d", new Object[] { "_key", Integer.valueOf(101) }), null);
      i = j;
      cy.g("delete Strategy key} %d , num} %d", new Object[] { Integer.valueOf(101), Integer.valueOf(j) });
      i = j;
    }
  }
  
  public static int j(Context paramContext)
  {
    cy.a(" RecordDAO.countRecordNum() start", new Object[0]);
    if (paramContext == null)
    {
      cy.d(" countRecordNum() have null args!", new Object[0]);
      return -1;
    }
    return cg.b(paramContext, new int[] { 1 });
  }
  
  public static String k(Context paramContext)
  {
    try
    {
      String str = di.a(paramContext).d();
      paramContext = "";
      c localc = c.m();
      if (localc != null) {
        paramContext = localc.j();
      }
      int i = (int)(Math.random() * 2147483647.0D);
      paramContext = g(paramContext + "_" + str + "_" + new Date().getTime() + "_" + i);
      return paramContext;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  public static boolean l(Context paramContext)
  {
    paramContext = o(paramContext);
    return (paramContext != null) && (paramContext.getType() == 1);
  }
  
  public static boolean m(Context paramContext)
  {
    paramContext = o(paramContext);
    return (paramContext != null) && (paramContext.isConnected());
  }
  
  public static String n(Context paramContext)
  {
    paramContext = o(paramContext);
    if (paramContext == null) {
      paramContext = "unknown";
    }
    String str;
    do
    {
      do
      {
        return paramContext;
        if (paramContext.getType() == 1) {
          return "wifi";
        }
        str = paramContext.getExtraInfo();
        paramContext = str;
      } while (str == null);
      paramContext = str;
    } while (str.length() <= 64);
    return str.substring(0, 64);
  }
  
  private static NetworkInfo o(Context paramContext)
  {
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext == null) {
        return null;
      }
      paramContext = paramContext.getActiveNetworkInfo();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      cy.a(paramContext);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.e
 * JD-Core Version:    0.7.0.1
 */