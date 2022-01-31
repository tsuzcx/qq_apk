package com.tencent.recovery.wx.service;

import android.content.Context;
import android.os.PowerManager;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.recovery.model.RecoveryData;
import com.tencent.recovery.model.RecoveryHandleItem;
import com.tencent.recovery.service.RecoveryHandleService;
import com.tencent.recovery.wx.util.NetUtil;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.ArrayList;

public class WXRecoveryHandleService
  extends RecoveryHandleService
{
  private PowerManager uGW;
  
  private RecoveryHandleItem a(RecoveryData paramRecoveryData, String paramString)
  {
    RecoveryHandleItem localRecoveryHandleItem = new RecoveryHandleItem();
    localRecoveryHandleItem.eAx = paramRecoveryData.eAx;
    localRecoveryHandleItem.clientVersion = paramRecoveryData.clientVersion;
    localRecoveryHandleItem.timestamp = System.currentTimeMillis();
    localRecoveryHandleItem.key = paramString;
    localRecoveryHandleItem.processName = paramRecoveryData.processName;
    localRecoveryHandleItem.Biw = iW(this);
    return localRecoveryHandleItem;
  }
  
  /* Error */
  private static String a(String paramString, RecoveryHandleItem paramRecoveryHandleItem)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 58
    //   3: invokevirtual 64	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   6: ifeq +141 -> 147
    //   9: new 66	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: ldc 58
    //   16: ldc 68
    //   18: invokevirtual 72	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   21: invokespecial 75	java/io/File:<init>	(Ljava/lang/String;)V
    //   24: astore_0
    //   25: new 77	java/io/FileInputStream
    //   28: dup
    //   29: aload_0
    //   30: invokespecial 80	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   33: astore_0
    //   34: aload_0
    //   35: invokestatic 86	com/tencent/recovery/wx/util/FileUtil:m	(Ljava/io/InputStream;)[B
    //   38: astore_3
    //   39: aload_0
    //   40: invokevirtual 91	java/io/InputStream:close	()V
    //   43: aload_3
    //   44: astore_0
    //   45: aload_0
    //   46: ifnull +444 -> 490
    //   49: aload_0
    //   50: invokestatic 97	com/tencent/recovery/wx/util/EncryptUtil:w	([B)Ljava/lang/String;
    //   53: astore_3
    //   54: ldc 99
    //   56: ldc 101
    //   58: iconst_1
    //   59: anewarray 103	java/lang/Object
    //   62: dup
    //   63: iconst_0
    //   64: aload_3
    //   65: aastore
    //   66: invokestatic 109	com/tencent/recovery/log/RecoveryLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   69: aload_0
    //   70: ldc 111
    //   72: invokestatic 115	com/tencent/recovery/wx/util/EncryptUtil:g	([BLjava/lang/String;)[B
    //   75: astore_0
    //   76: aload_0
    //   77: ifnonnull +343 -> 420
    //   80: aload_1
    //   81: new 117	java/lang/StringBuilder
    //   84: dup
    //   85: ldc 119
    //   87: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   90: aload_3
    //   91: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: ldc 126
    //   96: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: putfield 40	com/tencent/recovery/model/RecoveryHandleItem:key	Ljava/lang/String;
    //   105: aconst_null
    //   106: areturn
    //   107: astore_0
    //   108: aconst_null
    //   109: astore_0
    //   110: aload_0
    //   111: ifnull +31 -> 142
    //   114: aload_0
    //   115: invokevirtual 91	java/io/InputStream:close	()V
    //   118: aconst_null
    //   119: astore_0
    //   120: goto -75 -> 45
    //   123: astore_0
    //   124: aconst_null
    //   125: astore_0
    //   126: goto -81 -> 45
    //   129: astore_0
    //   130: aconst_null
    //   131: astore_1
    //   132: aload_1
    //   133: ifnull +7 -> 140
    //   136: aload_1
    //   137: invokevirtual 91	java/io/InputStream:close	()V
    //   140: aload_0
    //   141: athrow
    //   142: aconst_null
    //   143: astore_0
    //   144: goto -99 -> 45
    //   147: aload_0
    //   148: invokestatic 136	com/tencent/recovery/wx/util/WXUtil:awx	(Ljava/lang/String;)Ljava/lang/String;
    //   151: astore_0
    //   152: new 138	java/net/URL
    //   155: dup
    //   156: aload_0
    //   157: invokespecial 139	java/net/URL:<init>	(Ljava/lang/String;)V
    //   160: invokevirtual 143	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   163: checkcast 145	java/net/HttpURLConnection
    //   166: astore_3
    //   167: aload_3
    //   168: ldc 147
    //   170: invokevirtual 150	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   173: aload_3
    //   174: sipush 10000
    //   177: invokevirtual 154	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   180: aload_3
    //   181: sipush 20000
    //   184: invokevirtual 157	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   187: aload_3
    //   188: invokevirtual 160	java/net/HttpURLConnection:connect	()V
    //   191: aload_3
    //   192: invokevirtual 164	java/net/HttpURLConnection:getResponseCode	()I
    //   195: istore_2
    //   196: iload_2
    //   197: sipush 200
    //   200: if_icmpeq +44 -> 244
    //   203: aload_1
    //   204: iload_2
    //   205: invokestatic 168	com/tencent/recovery/wx/util/WXUtil:Se	(I)Ljava/lang/String;
    //   208: putfield 40	com/tencent/recovery/model/RecoveryHandleItem:key	Ljava/lang/String;
    //   211: aconst_null
    //   212: astore 6
    //   214: aconst_null
    //   215: astore 4
    //   217: aload 6
    //   219: ifnull +8 -> 227
    //   222: aload 6
    //   224: invokevirtual 91	java/io/InputStream:close	()V
    //   227: aload 4
    //   229: astore_0
    //   230: aload_3
    //   231: ifnull -186 -> 45
    //   234: aload_3
    //   235: invokevirtual 171	java/net/HttpURLConnection:disconnect	()V
    //   238: aload 4
    //   240: astore_0
    //   241: goto -196 -> 45
    //   244: aload_3
    //   245: invokevirtual 175	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   248: astore_0
    //   249: aload_0
    //   250: ifnonnull +18 -> 268
    //   253: aload_1
    //   254: ldc 177
    //   256: putfield 40	com/tencent/recovery/model/RecoveryHandleItem:key	Ljava/lang/String;
    //   259: aconst_null
    //   260: astore 4
    //   262: aload_0
    //   263: astore 6
    //   265: goto -48 -> 217
    //   268: aload_0
    //   269: invokestatic 178	com/tencent/recovery/wx/service/WXRecoveryHandleService:m	(Ljava/io/InputStream;)[B
    //   272: astore 5
    //   274: aload 5
    //   276: ifnonnull +96 -> 372
    //   279: aload_1
    //   280: ldc 180
    //   282: putfield 40	com/tencent/recovery/model/RecoveryHandleItem:key	Ljava/lang/String;
    //   285: aload_0
    //   286: astore 6
    //   288: aload 5
    //   290: astore 4
    //   292: goto -75 -> 217
    //   295: astore 6
    //   297: aload 5
    //   299: astore 4
    //   301: aload 6
    //   303: astore 5
    //   305: ldc 99
    //   307: aload 5
    //   309: ldc 182
    //   311: iconst_0
    //   312: anewarray 103	java/lang/Object
    //   315: invokestatic 186	com/tencent/recovery/log/RecoveryLog:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   318: aload_1
    //   319: new 117	java/lang/StringBuilder
    //   322: dup
    //   323: ldc 188
    //   325: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   328: aload 5
    //   330: invokevirtual 191	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   333: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: ldc 126
    //   338: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   344: putfield 40	com/tencent/recovery/model/RecoveryHandleItem:key	Ljava/lang/String;
    //   347: aload_0
    //   348: ifnull +7 -> 355
    //   351: aload_0
    //   352: invokevirtual 91	java/io/InputStream:close	()V
    //   355: aload 4
    //   357: astore_0
    //   358: aload_3
    //   359: ifnull -314 -> 45
    //   362: aload_3
    //   363: invokevirtual 171	java/net/HttpURLConnection:disconnect	()V
    //   366: aload 4
    //   368: astore_0
    //   369: goto -324 -> 45
    //   372: aload_0
    //   373: astore 6
    //   375: aload 5
    //   377: astore 4
    //   379: aload 5
    //   381: arraylength
    //   382: ifne -165 -> 217
    //   385: aload_1
    //   386: ldc 193
    //   388: putfield 40	com/tencent/recovery/model/RecoveryHandleItem:key	Ljava/lang/String;
    //   391: aload_0
    //   392: astore 6
    //   394: aload 5
    //   396: astore 4
    //   398: goto -181 -> 217
    //   401: astore_1
    //   402: aload_0
    //   403: ifnull +7 -> 410
    //   406: aload_0
    //   407: invokevirtual 91	java/io/InputStream:close	()V
    //   410: aload_3
    //   411: ifnull +7 -> 418
    //   414: aload_3
    //   415: invokevirtual 171	java/net/HttpURLConnection:disconnect	()V
    //   418: aload_1
    //   419: athrow
    //   420: ldc 99
    //   422: ldc 195
    //   424: iconst_1
    //   425: anewarray 103	java/lang/Object
    //   428: dup
    //   429: iconst_0
    //   430: aload_0
    //   431: invokestatic 97	com/tencent/recovery/wx/util/EncryptUtil:w	([B)Ljava/lang/String;
    //   434: aastore
    //   435: invokestatic 109	com/tencent/recovery/log/RecoveryLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   438: new 60	java/lang/String
    //   441: dup
    //   442: aload_0
    //   443: invokespecial 198	java/lang/String:<init>	([B)V
    //   446: astore_0
    //   447: aload_0
    //   448: areturn
    //   449: astore_0
    //   450: ldc 99
    //   452: aload_0
    //   453: ldc 182
    //   455: iconst_0
    //   456: anewarray 103	java/lang/Object
    //   459: invokestatic 186	com/tencent/recovery/log/RecoveryLog:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   462: aload_1
    //   463: new 117	java/lang/StringBuilder
    //   466: dup
    //   467: ldc 200
    //   469: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   472: aload_0
    //   473: invokevirtual 191	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   476: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: ldc 126
    //   481: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   487: putfield 40	com/tencent/recovery/model/RecoveryHandleItem:key	Ljava/lang/String;
    //   490: aconst_null
    //   491: areturn
    //   492: astore_0
    //   493: aload_3
    //   494: astore_0
    //   495: goto -450 -> 45
    //   498: astore_1
    //   499: goto -359 -> 140
    //   502: astore_0
    //   503: goto -276 -> 227
    //   506: astore_0
    //   507: goto -152 -> 355
    //   510: astore_0
    //   511: goto -101 -> 410
    //   514: astore_1
    //   515: aconst_null
    //   516: astore_0
    //   517: aconst_null
    //   518: astore_3
    //   519: goto -117 -> 402
    //   522: astore_1
    //   523: aconst_null
    //   524: astore_0
    //   525: goto -123 -> 402
    //   528: astore_1
    //   529: goto -127 -> 402
    //   532: astore 5
    //   534: aconst_null
    //   535: astore_0
    //   536: aconst_null
    //   537: astore_3
    //   538: aconst_null
    //   539: astore 4
    //   541: goto -236 -> 305
    //   544: astore 5
    //   546: aconst_null
    //   547: astore_0
    //   548: aconst_null
    //   549: astore 4
    //   551: goto -246 -> 305
    //   554: astore 5
    //   556: aconst_null
    //   557: astore 4
    //   559: goto -254 -> 305
    //   562: astore_1
    //   563: aload_0
    //   564: astore_3
    //   565: aload_1
    //   566: astore_0
    //   567: aload_3
    //   568: astore_1
    //   569: goto -437 -> 132
    //   572: astore_3
    //   573: goto -463 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	576	0	paramString	String
    //   0	576	1	paramRecoveryHandleItem	RecoveryHandleItem
    //   195	10	2	i	int
    //   38	530	3	localObject1	Object
    //   572	1	3	localException1	Exception
    //   215	343	4	localObject2	Object
    //   272	123	5	localObject3	Object
    //   532	1	5	localException2	Exception
    //   544	1	5	localException3	Exception
    //   554	1	5	localException4	Exception
    //   212	75	6	str1	String
    //   295	7	6	localException5	Exception
    //   373	20	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   25	34	107	java/lang/Exception
    //   114	118	123	java/io/IOException
    //   25	34	129	finally
    //   279	285	295	java/lang/Exception
    //   379	391	295	java/lang/Exception
    //   253	259	401	finally
    //   268	274	401	finally
    //   279	285	401	finally
    //   379	391	401	finally
    //   49	76	449	java/lang/Exception
    //   80	105	449	java/lang/Exception
    //   420	447	449	java/lang/Exception
    //   39	43	492	java/io/IOException
    //   136	140	498	java/io/IOException
    //   222	227	502	java/io/IOException
    //   351	355	506	java/io/IOException
    //   406	410	510	java/io/IOException
    //   152	167	514	finally
    //   167	196	522	finally
    //   203	211	522	finally
    //   244	249	522	finally
    //   305	347	528	finally
    //   152	167	532	java/lang/Exception
    //   167	196	544	java/lang/Exception
    //   203	211	544	java/lang/Exception
    //   244	249	544	java/lang/Exception
    //   253	259	554	java/lang/Exception
    //   268	274	554	java/lang/Exception
    //   34	39	562	finally
    //   34	39	572	java/lang/Exception
  }
  
  /* Error */
  private static byte[] a(String paramString1, String paramString2, RecoveryHandleItem paramRecoveryHandleItem)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: ldc 58
    //   6: invokevirtual 64	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   9: ifeq +71 -> 80
    //   12: new 66	java/io/File
    //   15: dup
    //   16: aload_0
    //   17: ldc 58
    //   19: ldc 68
    //   21: invokevirtual 72	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   24: invokespecial 75	java/io/File:<init>	(Ljava/lang/String;)V
    //   27: astore_0
    //   28: new 77	java/io/FileInputStream
    //   31: dup
    //   32: aload_0
    //   33: invokespecial 80	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   36: astore_0
    //   37: aload_0
    //   38: invokestatic 178	com/tencent/recovery/wx/service/WXRecoveryHandleService:m	(Ljava/io/InputStream;)[B
    //   41: astore_1
    //   42: aload_0
    //   43: invokevirtual 91	java/io/InputStream:close	()V
    //   46: aload_1
    //   47: areturn
    //   48: astore_0
    //   49: aconst_null
    //   50: astore_0
    //   51: aload_0
    //   52: ifnull +26 -> 78
    //   55: aload_0
    //   56: invokevirtual 91	java/io/InputStream:close	()V
    //   59: aconst_null
    //   60: areturn
    //   61: astore_0
    //   62: aconst_null
    //   63: areturn
    //   64: astore_0
    //   65: aload 4
    //   67: astore_1
    //   68: aload_1
    //   69: ifnull +7 -> 76
    //   72: aload_1
    //   73: invokevirtual 91	java/io/InputStream:close	()V
    //   76: aload_0
    //   77: athrow
    //   78: aconst_null
    //   79: areturn
    //   80: aload_0
    //   81: invokestatic 136	com/tencent/recovery/wx/util/WXUtil:awx	(Ljava/lang/String;)Ljava/lang/String;
    //   84: astore_0
    //   85: new 138	java/net/URL
    //   88: dup
    //   89: aload_0
    //   90: invokespecial 139	java/net/URL:<init>	(Ljava/lang/String;)V
    //   93: invokevirtual 143	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   96: checkcast 145	java/net/HttpURLConnection
    //   99: astore_0
    //   100: aload_0
    //   101: ldc 147
    //   103: invokevirtual 150	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   106: aload_0
    //   107: sipush 10000
    //   110: invokevirtual 154	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   113: aload_0
    //   114: sipush 20000
    //   117: invokevirtual 157	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   120: aload_0
    //   121: invokevirtual 160	java/net/HttpURLConnection:connect	()V
    //   124: aload_0
    //   125: invokevirtual 164	java/net/HttpURLConnection:getResponseCode	()I
    //   128: istore_3
    //   129: iload_3
    //   130: sipush 200
    //   133: if_icmpeq +41 -> 174
    //   136: aload_2
    //   137: iload_3
    //   138: invokestatic 204	com/tencent/recovery/wx/util/WXUtil:Sf	(I)Ljava/lang/String;
    //   141: putfield 40	com/tencent/recovery/model/RecoveryHandleItem:key	Ljava/lang/String;
    //   144: aconst_null
    //   145: astore 7
    //   147: aconst_null
    //   148: astore 4
    //   150: aload 7
    //   152: ifnull +8 -> 160
    //   155: aload 7
    //   157: invokevirtual 91	java/io/InputStream:close	()V
    //   160: aload 4
    //   162: astore_2
    //   163: aload_0
    //   164: ifnull +309 -> 473
    //   167: aload_0
    //   168: invokevirtual 171	java/net/HttpURLConnection:disconnect	()V
    //   171: aload 4
    //   173: areturn
    //   174: aload_0
    //   175: invokevirtual 175	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   178: astore 5
    //   180: aload 5
    //   182: ifnonnull +19 -> 201
    //   185: aload_2
    //   186: ldc 206
    //   188: putfield 40	com/tencent/recovery/model/RecoveryHandleItem:key	Ljava/lang/String;
    //   191: aconst_null
    //   192: astore 4
    //   194: aload 5
    //   196: astore 7
    //   198: goto -48 -> 150
    //   201: aload 5
    //   203: invokestatic 86	com/tencent/recovery/wx/util/FileUtil:m	(Ljava/io/InputStream;)[B
    //   206: astore 6
    //   208: aload 6
    //   210: ifnonnull +91 -> 301
    //   213: aload_2
    //   214: ldc 208
    //   216: putfield 40	com/tencent/recovery/model/RecoveryHandleItem:key	Ljava/lang/String;
    //   219: aload 6
    //   221: astore 4
    //   223: aload 5
    //   225: astore 7
    //   227: goto -77 -> 150
    //   230: astore 4
    //   232: aload_0
    //   233: astore_1
    //   234: aload 6
    //   236: astore_0
    //   237: ldc 99
    //   239: aload 4
    //   241: ldc 210
    //   243: iconst_0
    //   244: anewarray 103	java/lang/Object
    //   247: invokestatic 186	com/tencent/recovery/log/RecoveryLog:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   250: aload_2
    //   251: new 117	java/lang/StringBuilder
    //   254: dup
    //   255: ldc 212
    //   257: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   260: aload 4
    //   262: invokevirtual 191	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   265: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: ldc 126
    //   270: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   276: putfield 40	com/tencent/recovery/model/RecoveryHandleItem:key	Ljava/lang/String;
    //   279: aload 5
    //   281: ifnull +8 -> 289
    //   284: aload 5
    //   286: invokevirtual 91	java/io/InputStream:close	()V
    //   289: aload_0
    //   290: astore_2
    //   291: aload_1
    //   292: ifnull +181 -> 473
    //   295: aload_1
    //   296: invokevirtual 171	java/net/HttpURLConnection:disconnect	()V
    //   299: aload_0
    //   300: areturn
    //   301: aload 6
    //   303: arraylength
    //   304: ifne +45 -> 349
    //   307: aload_2
    //   308: ldc 214
    //   310: putfield 40	com/tencent/recovery/model/RecoveryHandleItem:key	Ljava/lang/String;
    //   313: aload 6
    //   315: astore 4
    //   317: aload 5
    //   319: astore 7
    //   321: goto -171 -> 150
    //   324: astore_2
    //   325: aload_0
    //   326: astore_1
    //   327: aload_2
    //   328: astore_0
    //   329: aload 5
    //   331: ifnull +8 -> 339
    //   334: aload 5
    //   336: invokevirtual 91	java/io/InputStream:close	()V
    //   339: aload_1
    //   340: ifnull +7 -> 347
    //   343: aload_1
    //   344: invokevirtual 171	java/net/HttpURLConnection:disconnect	()V
    //   347: aload_0
    //   348: athrow
    //   349: aload 6
    //   351: astore 4
    //   353: aload 5
    //   355: astore 7
    //   357: aload 6
    //   359: invokestatic 97	com/tencent/recovery/wx/util/EncryptUtil:w	([B)Ljava/lang/String;
    //   362: aload_1
    //   363: invokevirtual 218	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   366: ifne -216 -> 150
    //   369: aload_2
    //   370: ldc 220
    //   372: putfield 40	com/tencent/recovery/model/RecoveryHandleItem:key	Ljava/lang/String;
    //   375: aconst_null
    //   376: astore 4
    //   378: aload 5
    //   380: astore 7
    //   382: goto -232 -> 150
    //   385: astore_0
    //   386: aload_1
    //   387: areturn
    //   388: astore_1
    //   389: goto -313 -> 76
    //   392: astore_1
    //   393: goto -233 -> 160
    //   396: astore_2
    //   397: goto -108 -> 289
    //   400: astore_2
    //   401: goto -62 -> 339
    //   404: astore_0
    //   405: aconst_null
    //   406: astore 5
    //   408: aconst_null
    //   409: astore_1
    //   410: goto -81 -> 329
    //   413: astore_2
    //   414: aconst_null
    //   415: astore 5
    //   417: aload_0
    //   418: astore_1
    //   419: aload_2
    //   420: astore_0
    //   421: goto -92 -> 329
    //   424: astore_0
    //   425: goto -96 -> 329
    //   428: astore 4
    //   430: aconst_null
    //   431: astore 5
    //   433: aconst_null
    //   434: astore_1
    //   435: aconst_null
    //   436: astore_0
    //   437: goto -200 -> 237
    //   440: astore 4
    //   442: aconst_null
    //   443: astore 5
    //   445: aload_0
    //   446: astore_1
    //   447: aconst_null
    //   448: astore_0
    //   449: goto -212 -> 237
    //   452: astore 4
    //   454: aload_0
    //   455: astore_1
    //   456: aconst_null
    //   457: astore_0
    //   458: goto -221 -> 237
    //   461: astore_2
    //   462: aload_0
    //   463: astore_1
    //   464: aload_2
    //   465: astore_0
    //   466: goto -398 -> 68
    //   469: astore_1
    //   470: goto -419 -> 51
    //   473: aload_2
    //   474: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	475	0	paramString1	String
    //   0	475	1	paramString2	String
    //   0	475	2	paramRecoveryHandleItem	RecoveryHandleItem
    //   128	10	3	i	int
    //   1	221	4	localObject1	Object
    //   230	31	4	localException1	Exception
    //   315	62	4	localObject2	Object
    //   428	1	4	localException2	Exception
    //   440	1	4	localException3	Exception
    //   452	1	4	localException4	Exception
    //   178	266	5	localInputStream	InputStream
    //   206	152	6	arrayOfByte	byte[]
    //   145	236	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   28	37	48	java/lang/Exception
    //   55	59	61	java/io/IOException
    //   28	37	64	finally
    //   213	219	230	java/lang/Exception
    //   301	313	230	java/lang/Exception
    //   357	375	230	java/lang/Exception
    //   185	191	324	finally
    //   201	208	324	finally
    //   213	219	324	finally
    //   301	313	324	finally
    //   357	375	324	finally
    //   42	46	385	java/io/IOException
    //   72	76	388	java/io/IOException
    //   155	160	392	java/io/IOException
    //   284	289	396	java/io/IOException
    //   334	339	400	java/io/IOException
    //   85	100	404	finally
    //   100	129	413	finally
    //   136	144	413	finally
    //   174	180	413	finally
    //   237	279	424	finally
    //   85	100	428	java/lang/Exception
    //   100	129	440	java/lang/Exception
    //   136	144	440	java/lang/Exception
    //   174	180	440	java/lang/Exception
    //   185	191	452	java/lang/Exception
    //   201	208	452	java/lang/Exception
    //   37	42	461	finally
    //   37	42	469	java/lang/Exception
  }
  
  private static boolean aww(String paramString)
  {
    boolean bool2 = false;
    try
    {
      paramString = InetAddress.getByName(paramString);
      boolean bool1 = bool2;
      if (paramString != null)
      {
        paramString = paramString.getHostAddress();
        bool1 = bool2;
        if (paramString != null) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  private String iW(Context paramContext)
  {
    paramContext = NetUtil.iX(paramContext);
    boolean bool1 = this.uGW.isScreenOn();
    boolean bool2 = aww("dldir1.qq.com");
    boolean bool3 = aww("www.qq.com");
    return paramContext + "|" + bool1 + "|" + bool2 + "|" + bool3;
  }
  
  private static byte[] m(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[1024];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte, 0, 1024);
      if (i <= 0) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    return localByteArrayOutputStream.toByteArray();
  }
  
  /* Error */
  public final com.tencent.recovery.model.RecoveryHandleResult a(Context paramContext, RecoveryData paramRecoveryData, ArrayList<RecoveryHandleItem> paramArrayList, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 273	com/tencent/recovery/model/RecoveryHandleResult
    //   3: dup
    //   4: invokespecial 274	com/tencent/recovery/model/RecoveryHandleResult:<init>	()V
    //   7: astore 7
    //   9: aload_3
    //   10: aload_0
    //   11: aload_2
    //   12: ldc_w 276
    //   15: iconst_2
    //   16: anewarray 103	java/lang/Object
    //   19: dup
    //   20: iconst_0
    //   21: ldc_w 278
    //   24: aastore
    //   25: dup
    //   26: iconst_1
    //   27: iload 4
    //   29: invokestatic 284	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   32: aastore
    //   33: invokestatic 288	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   36: invokespecial 290	com/tencent/recovery/wx/service/WXRecoveryHandleService:a	(Lcom/tencent/recovery/model/RecoveryData;Ljava/lang/String;)Lcom/tencent/recovery/model/RecoveryHandleItem;
    //   39: invokevirtual 295	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   42: pop
    //   43: aload_0
    //   44: aload_2
    //   45: ldc 68
    //   47: invokespecial 290	com/tencent/recovery/wx/service/WXRecoveryHandleService:a	(Lcom/tencent/recovery/model/RecoveryData;Ljava/lang/String;)Lcom/tencent/recovery/model/RecoveryHandleItem;
    //   50: astore 8
    //   52: aload_0
    //   53: invokestatic 299	com/tencent/recovery/wx/util/NetUtil:isConnected	(Landroid/content/Context;)Z
    //   56: ifeq +496 -> 552
    //   59: aload_2
    //   60: getfield 302	com/tencent/recovery/model/RecoveryData:Biu	Ljava/lang/String;
    //   63: astore_2
    //   64: ldc 99
    //   66: ldc_w 304
    //   69: iconst_1
    //   70: anewarray 103	java/lang/Object
    //   73: dup
    //   74: iconst_0
    //   75: aload_2
    //   76: aastore
    //   77: invokestatic 109	com/tencent/recovery/log/RecoveryLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   80: aload_2
    //   81: aload 8
    //   83: invokestatic 306	com/tencent/recovery/wx/service/WXRecoveryHandleService:a	(Ljava/lang/String;Lcom/tencent/recovery/model/RecoveryHandleItem;)Ljava/lang/String;
    //   86: astore_2
    //   87: aload_2
    //   88: ifnull +430 -> 518
    //   91: ldc 99
    //   93: ldc_w 308
    //   96: iconst_1
    //   97: anewarray 103	java/lang/Object
    //   100: dup
    //   101: iconst_0
    //   102: aload_2
    //   103: aastore
    //   104: invokestatic 109	com/tencent/recovery/log/RecoveryLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   107: new 310	org/json/JSONObject
    //   110: dup
    //   111: aload_2
    //   112: invokespecial 311	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   115: astore_2
    //   116: aload_2
    //   117: ifnull +378 -> 495
    //   120: aload_2
    //   121: ldc_w 313
    //   124: iconst_m1
    //   125: invokevirtual 317	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   128: istore 5
    //   130: aload_2
    //   131: ldc_w 319
    //   134: iconst_m1
    //   135: invokevirtual 317	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   138: istore 6
    //   140: aload_2
    //   141: ldc_w 321
    //   144: ldc 68
    //   146: invokevirtual 325	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   149: astore 9
    //   151: aload_2
    //   152: ldc_w 327
    //   155: ldc 68
    //   157: invokevirtual 325	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   160: astore_2
    //   161: aload_0
    //   162: invokestatic 333	com/tencent/recovery/util/Util:iT	(Landroid/content/Context;)I
    //   165: iload 5
    //   167: irem
    //   168: iload 6
    //   170: if_icmpne +204 -> 374
    //   173: iconst_1
    //   174: istore 5
    //   176: iload 5
    //   178: ifeq +294 -> 472
    //   181: ldc 99
    //   183: ldc_w 335
    //   186: iconst_1
    //   187: anewarray 103	java/lang/Object
    //   190: dup
    //   191: iconst_0
    //   192: aload 9
    //   194: aastore
    //   195: invokestatic 109	com/tencent/recovery/log/RecoveryLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   198: aload 9
    //   200: aload_2
    //   201: aload 8
    //   203: invokestatic 337	com/tencent/recovery/wx/service/WXRecoveryHandleService:a	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/recovery/model/RecoveryHandleItem;)[B
    //   206: astore 11
    //   208: aload 11
    //   210: ifnull +247 -> 457
    //   213: new 117	java/lang/StringBuilder
    //   216: dup
    //   217: invokespecial 250	java/lang/StringBuilder:<init>	()V
    //   220: aload_1
    //   221: invokevirtual 343	android/content/Context:getCacheDir	()Ljava/io/File;
    //   224: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   227: ldc_w 348
    //   230: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: astore 9
    //   238: new 66	java/io/File
    //   241: dup
    //   242: aload 9
    //   244: invokespecial 75	java/io/File:<init>	(Ljava/lang/String;)V
    //   247: astore 10
    //   249: aload 10
    //   251: invokevirtual 351	java/io/File:exists	()Z
    //   254: ifeq +9 -> 263
    //   257: aload 10
    //   259: invokevirtual 354	java/io/File:delete	()Z
    //   262: pop
    //   263: new 356	java/io/FileOutputStream
    //   266: dup
    //   267: aload 10
    //   269: invokespecial 357	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   272: astore_2
    //   273: aload_2
    //   274: aload 11
    //   276: invokevirtual 359	java/io/FileOutputStream:write	([B)V
    //   279: aload_2
    //   280: invokevirtual 360	java/io/FileOutputStream:close	()V
    //   283: aload 10
    //   285: invokevirtual 351	java/io/File:exists	()Z
    //   288: ifeq +146 -> 434
    //   291: aload_1
    //   292: aload 9
    //   294: invokestatic 366	com/tencent/recovery/wx/RecoveryTinkerManager:bX	(Landroid/content/Context;Ljava/lang/String;)I
    //   297: istore 5
    //   299: iload 5
    //   301: ifeq +110 -> 411
    //   304: aload 8
    //   306: new 117	java/lang/StringBuilder
    //   309: dup
    //   310: ldc_w 368
    //   313: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   316: iload 5
    //   318: invokevirtual 371	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   321: ldc 126
    //   323: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   329: putfield 40	com/tencent/recovery/model/RecoveryHandleItem:key	Ljava/lang/String;
    //   332: ldc 99
    //   334: ldc_w 373
    //   337: iconst_1
    //   338: anewarray 103	java/lang/Object
    //   341: dup
    //   342: iconst_0
    //   343: iload 5
    //   345: invokestatic 378	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   348: aastore
    //   349: invokestatic 109	com/tencent/recovery/log/RecoveryLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   352: aload 7
    //   354: iconst_1
    //   355: putfield 382	com/tencent/recovery/model/RecoveryHandleResult:cmX	Z
    //   358: aload_3
    //   359: aload 8
    //   361: invokevirtual 295	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   364: pop
    //   365: aload 7
    //   367: areturn
    //   368: astore_2
    //   369: aconst_null
    //   370: astore_2
    //   371: goto -255 -> 116
    //   374: iconst_0
    //   375: istore 5
    //   377: goto -201 -> 176
    //   380: astore_2
    //   381: aconst_null
    //   382: astore_2
    //   383: aload_2
    //   384: ifnull -101 -> 283
    //   387: aload_2
    //   388: invokevirtual 360	java/io/FileOutputStream:close	()V
    //   391: goto -108 -> 283
    //   394: astore_2
    //   395: goto -112 -> 283
    //   398: astore_1
    //   399: aconst_null
    //   400: astore_2
    //   401: aload_2
    //   402: ifnull +7 -> 409
    //   405: aload_2
    //   406: invokevirtual 360	java/io/FileOutputStream:close	()V
    //   409: aload_1
    //   410: athrow
    //   411: aload 8
    //   413: ldc_w 384
    //   416: putfield 40	com/tencent/recovery/model/RecoveryHandleItem:key	Ljava/lang/String;
    //   419: ldc 99
    //   421: ldc_w 386
    //   424: iconst_0
    //   425: anewarray 103	java/lang/Object
    //   428: invokestatic 109	com/tencent/recovery/log/RecoveryLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   431: goto -79 -> 352
    //   434: aload 8
    //   436: ldc_w 388
    //   439: putfield 40	com/tencent/recovery/model/RecoveryHandleItem:key	Ljava/lang/String;
    //   442: ldc 99
    //   444: ldc_w 390
    //   447: iconst_0
    //   448: anewarray 103	java/lang/Object
    //   451: invokestatic 109	com/tencent/recovery/log/RecoveryLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   454: goto -96 -> 358
    //   457: ldc 99
    //   459: ldc_w 392
    //   462: iconst_0
    //   463: anewarray 103	java/lang/Object
    //   466: invokestatic 109	com/tencent/recovery/log/RecoveryLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   469: goto -111 -> 358
    //   472: ldc 99
    //   474: ldc_w 394
    //   477: iconst_0
    //   478: anewarray 103	java/lang/Object
    //   481: invokestatic 109	com/tencent/recovery/log/RecoveryLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   484: aload 8
    //   486: ldc_w 396
    //   489: putfield 40	com/tencent/recovery/model/RecoveryHandleItem:key	Ljava/lang/String;
    //   492: goto -134 -> 358
    //   495: ldc 99
    //   497: ldc_w 398
    //   500: iconst_0
    //   501: anewarray 103	java/lang/Object
    //   504: invokestatic 109	com/tencent/recovery/log/RecoveryLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   507: aload 8
    //   509: ldc_w 400
    //   512: putfield 40	com/tencent/recovery/model/RecoveryHandleItem:key	Ljava/lang/String;
    //   515: goto -157 -> 358
    //   518: ldc 99
    //   520: ldc_w 402
    //   523: iconst_0
    //   524: anewarray 103	java/lang/Object
    //   527: invokestatic 109	com/tencent/recovery/log/RecoveryLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   530: aload 8
    //   532: getfield 40	com/tencent/recovery/model/RecoveryHandleItem:key	Ljava/lang/String;
    //   535: invokestatic 405	com/tencent/recovery/util/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   538: ifeq -180 -> 358
    //   541: aload 8
    //   543: ldc_w 407
    //   546: putfield 40	com/tencent/recovery/model/RecoveryHandleItem:key	Ljava/lang/String;
    //   549: goto -191 -> 358
    //   552: ldc 99
    //   554: ldc_w 409
    //   557: iconst_0
    //   558: anewarray 103	java/lang/Object
    //   561: invokestatic 109	com/tencent/recovery/log/RecoveryLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   564: iload 4
    //   566: ifne +9 -> 575
    //   569: aload 7
    //   571: iconst_1
    //   572: putfield 412	com/tencent/recovery/model/RecoveryHandleResult:retry	Z
    //   575: aload 8
    //   577: ldc_w 276
    //   580: iconst_2
    //   581: anewarray 103	java/lang/Object
    //   584: dup
    //   585: iconst_0
    //   586: ldc_w 414
    //   589: aastore
    //   590: dup
    //   591: iconst_1
    //   592: iload 4
    //   594: invokestatic 284	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   597: aastore
    //   598: invokestatic 288	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   601: putfield 40	com/tencent/recovery/model/RecoveryHandleItem:key	Ljava/lang/String;
    //   604: goto -246 -> 358
    //   607: astore_2
    //   608: goto -325 -> 283
    //   611: astore_2
    //   612: goto -203 -> 409
    //   615: astore_1
    //   616: goto -215 -> 401
    //   619: astore 11
    //   621: goto -238 -> 383
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	624	0	this	WXRecoveryHandleService
    //   0	624	1	paramContext	Context
    //   0	624	2	paramRecoveryData	RecoveryData
    //   0	624	3	paramArrayList	ArrayList<RecoveryHandleItem>
    //   0	624	4	paramBoolean	boolean
    //   128	248	5	i	int
    //   138	33	6	j	int
    //   7	563	7	localRecoveryHandleResult	com.tencent.recovery.model.RecoveryHandleResult
    //   50	526	8	localRecoveryHandleItem	RecoveryHandleItem
    //   149	144	9	str	String
    //   247	37	10	localFile	java.io.File
    //   206	69	11	arrayOfByte	byte[]
    //   619	1	11	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   107	116	368	java/lang/Exception
    //   263	273	380	java/lang/Exception
    //   387	391	394	java/io/IOException
    //   263	273	398	finally
    //   279	283	607	java/io/IOException
    //   405	409	611	java/io/IOException
    //   273	279	615	finally
    //   273	279	619	java/lang/Exception
  }
  
  public final void a(RecoveryData paramRecoveryData, ArrayList<RecoveryHandleItem> paramArrayList, boolean paramBoolean)
  {
    paramArrayList.add(a(paramRecoveryData, String.format("%s[%b]", new Object[] { "KeyTotalCount", Boolean.valueOf(paramBoolean) })));
    paramArrayList.add(a(paramRecoveryData, String.format("%s[%b]", new Object[] { "KeyAlreadyRunning", Boolean.valueOf(paramBoolean) })));
  }
  
  public void onCreate()
  {
    super.onCreate();
    RecoveryLog.i("Recovery.WXRecoveryHandleService", "onCreate", new Object[0]);
    this.uGW = ((PowerManager)getSystemService("power"));
  }
  
  public void onDestroy()
  {
    RecoveryLog.i("Recovery.WXRecoveryHandleService", "onDestroy", new Object[0]);
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.recovery.wx.service.WXRecoveryHandleService
 * JD-Core Version:    0.7.0.1
 */