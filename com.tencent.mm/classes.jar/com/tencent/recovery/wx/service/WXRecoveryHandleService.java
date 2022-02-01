package com.tencent.recovery.wx.service;

import android.content.Context;
import android.os.PowerManager;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.recovery.model.RecoveryData;
import com.tencent.recovery.model.RecoveryHandleItem;
import com.tencent.recovery.model.RecoveryHandleResult;
import com.tencent.recovery.service.RecoveryHandleService;
import com.tencent.recovery.wx.util.NetUtil;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.ArrayList;

public class WXRecoveryHandleService
  extends RecoveryHandleService
{
  private static final String TAG = "Recovery.WXRecoveryHandleService";
  private PowerManager powerManager;
  
  public static boolean checkResolveIPAddress(String paramString)
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
  
  /* Error */
  public static final String getConfigData(String paramString, RecoveryHandleItem paramRecoveryHandleItem)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 35
    //   3: invokevirtual 40	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   6: ifeq +141 -> 147
    //   9: new 42	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: ldc 35
    //   16: ldc 44
    //   18: invokevirtual 48	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   21: invokespecial 51	java/io/File:<init>	(Ljava/lang/String;)V
    //   24: astore_0
    //   25: new 53	java/io/FileInputStream
    //   28: dup
    //   29: aload_0
    //   30: invokespecial 56	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   33: astore_0
    //   34: aload_0
    //   35: invokestatic 62	com/tencent/recovery/wx/util/FileUtil:readFromStream	(Ljava/io/InputStream;)[B
    //   38: astore_3
    //   39: aload_0
    //   40: invokevirtual 67	java/io/InputStream:close	()V
    //   43: aload_3
    //   44: astore_0
    //   45: aload_0
    //   46: ifnull +444 -> 490
    //   49: aload_0
    //   50: invokestatic 73	com/tencent/recovery/wx/util/EncryptUtil:getMessageDigest	([B)Ljava/lang/String;
    //   53: astore_3
    //   54: ldc 8
    //   56: ldc 75
    //   58: iconst_1
    //   59: anewarray 77	java/lang/Object
    //   62: dup
    //   63: iconst_0
    //   64: aload_3
    //   65: aastore
    //   66: invokestatic 83	com/tencent/recovery/log/RecoveryLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   69: aload_0
    //   70: ldc 85
    //   72: invokestatic 89	com/tencent/recovery/wx/util/EncryptUtil:decryptByPublicKey	([BLjava/lang/String;)[B
    //   75: astore_0
    //   76: aload_0
    //   77: ifnonnull +343 -> 420
    //   80: aload_1
    //   81: new 91	java/lang/StringBuilder
    //   84: dup
    //   85: ldc 93
    //   87: invokespecial 94	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   90: aload_3
    //   91: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: ldc 100
    //   96: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: putfield 108	com/tencent/recovery/model/RecoveryHandleItem:key	Ljava/lang/String;
    //   105: aconst_null
    //   106: areturn
    //   107: astore_0
    //   108: aconst_null
    //   109: astore_0
    //   110: aload_0
    //   111: ifnull +31 -> 142
    //   114: aload_0
    //   115: invokevirtual 67	java/io/InputStream:close	()V
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
    //   137: invokevirtual 67	java/io/InputStream:close	()V
    //   140: aload_0
    //   141: athrow
    //   142: aconst_null
    //   143: astore_0
    //   144: goto -99 -> 45
    //   147: aload_0
    //   148: invokestatic 114	com/tencent/recovery/wx/util/WXUtil:appendRandomParams	(Ljava/lang/String;)Ljava/lang/String;
    //   151: astore_0
    //   152: new 116	java/net/URL
    //   155: dup
    //   156: aload_0
    //   157: invokespecial 117	java/net/URL:<init>	(Ljava/lang/String;)V
    //   160: invokevirtual 121	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   163: checkcast 123	java/net/HttpURLConnection
    //   166: astore_3
    //   167: aload_3
    //   168: ldc 125
    //   170: invokevirtual 128	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   173: aload_3
    //   174: sipush 10000
    //   177: invokevirtual 132	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   180: aload_3
    //   181: sipush 20000
    //   184: invokevirtual 135	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   187: aload_3
    //   188: invokevirtual 138	java/net/HttpURLConnection:connect	()V
    //   191: aload_3
    //   192: invokevirtual 142	java/net/HttpURLConnection:getResponseCode	()I
    //   195: istore_2
    //   196: iload_2
    //   197: sipush 200
    //   200: if_icmpeq +44 -> 244
    //   203: aload_1
    //   204: iload_2
    //   205: invokestatic 146	com/tencent/recovery/wx/util/WXUtil:getHttpConfigCodeKey	(I)Ljava/lang/String;
    //   208: putfield 108	com/tencent/recovery/model/RecoveryHandleItem:key	Ljava/lang/String;
    //   211: aconst_null
    //   212: astore 6
    //   214: aconst_null
    //   215: astore 4
    //   217: aload 6
    //   219: ifnull +8 -> 227
    //   222: aload 6
    //   224: invokevirtual 67	java/io/InputStream:close	()V
    //   227: aload 4
    //   229: astore_0
    //   230: aload_3
    //   231: ifnull -186 -> 45
    //   234: aload_3
    //   235: invokevirtual 149	java/net/HttpURLConnection:disconnect	()V
    //   238: aload 4
    //   240: astore_0
    //   241: goto -196 -> 45
    //   244: aload_3
    //   245: invokevirtual 153	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   248: astore_0
    //   249: aload_0
    //   250: ifnonnull +18 -> 268
    //   253: aload_1
    //   254: ldc 155
    //   256: putfield 108	com/tencent/recovery/model/RecoveryHandleItem:key	Ljava/lang/String;
    //   259: aconst_null
    //   260: astore 4
    //   262: aload_0
    //   263: astore 6
    //   265: goto -48 -> 217
    //   268: aload_0
    //   269: invokestatic 156	com/tencent/recovery/wx/service/WXRecoveryHandleService:readFromStream	(Ljava/io/InputStream;)[B
    //   272: astore 5
    //   274: aload 5
    //   276: ifnonnull +96 -> 372
    //   279: aload_1
    //   280: ldc 158
    //   282: putfield 108	com/tencent/recovery/model/RecoveryHandleItem:key	Ljava/lang/String;
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
    //   305: ldc 8
    //   307: aload 5
    //   309: ldc 159
    //   311: iconst_0
    //   312: anewarray 77	java/lang/Object
    //   315: invokestatic 163	com/tencent/recovery/log/RecoveryLog:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   318: aload_1
    //   319: new 91	java/lang/StringBuilder
    //   322: dup
    //   323: ldc 165
    //   325: invokespecial 94	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   328: aload 5
    //   330: invokevirtual 168	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   333: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: ldc 100
    //   338: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   344: putfield 108	com/tencent/recovery/model/RecoveryHandleItem:key	Ljava/lang/String;
    //   347: aload_0
    //   348: ifnull +7 -> 355
    //   351: aload_0
    //   352: invokevirtual 67	java/io/InputStream:close	()V
    //   355: aload 4
    //   357: astore_0
    //   358: aload_3
    //   359: ifnull -314 -> 45
    //   362: aload_3
    //   363: invokevirtual 149	java/net/HttpURLConnection:disconnect	()V
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
    //   386: ldc 170
    //   388: putfield 108	com/tencent/recovery/model/RecoveryHandleItem:key	Ljava/lang/String;
    //   391: aload_0
    //   392: astore 6
    //   394: aload 5
    //   396: astore 4
    //   398: goto -181 -> 217
    //   401: astore_1
    //   402: aload_0
    //   403: ifnull +7 -> 410
    //   406: aload_0
    //   407: invokevirtual 67	java/io/InputStream:close	()V
    //   410: aload_3
    //   411: ifnull +7 -> 418
    //   414: aload_3
    //   415: invokevirtual 149	java/net/HttpURLConnection:disconnect	()V
    //   418: aload_1
    //   419: athrow
    //   420: ldc 8
    //   422: ldc 172
    //   424: iconst_1
    //   425: anewarray 77	java/lang/Object
    //   428: dup
    //   429: iconst_0
    //   430: aload_0
    //   431: invokestatic 73	com/tencent/recovery/wx/util/EncryptUtil:getMessageDigest	([B)Ljava/lang/String;
    //   434: aastore
    //   435: invokestatic 83	com/tencent/recovery/log/RecoveryLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   438: new 37	java/lang/String
    //   441: dup
    //   442: aload_0
    //   443: invokespecial 175	java/lang/String:<init>	([B)V
    //   446: astore_0
    //   447: aload_0
    //   448: areturn
    //   449: astore_0
    //   450: ldc 8
    //   452: aload_0
    //   453: ldc 159
    //   455: iconst_0
    //   456: anewarray 77	java/lang/Object
    //   459: invokestatic 163	com/tencent/recovery/log/RecoveryLog:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   462: aload_1
    //   463: new 91	java/lang/StringBuilder
    //   466: dup
    //   467: ldc 177
    //   469: invokespecial 94	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   472: aload_0
    //   473: invokevirtual 168	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   476: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: ldc 100
    //   481: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   487: putfield 108	com/tencent/recovery/model/RecoveryHandleItem:key	Ljava/lang/String;
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
  public static final byte[] getPatchData(String paramString1, String paramString2, RecoveryHandleItem paramRecoveryHandleItem)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: ldc 35
    //   6: invokevirtual 40	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   9: ifeq +71 -> 80
    //   12: new 42	java/io/File
    //   15: dup
    //   16: aload_0
    //   17: ldc 35
    //   19: ldc 44
    //   21: invokevirtual 48	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   24: invokespecial 51	java/io/File:<init>	(Ljava/lang/String;)V
    //   27: astore_0
    //   28: new 53	java/io/FileInputStream
    //   31: dup
    //   32: aload_0
    //   33: invokespecial 56	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   36: astore_0
    //   37: aload_0
    //   38: invokestatic 156	com/tencent/recovery/wx/service/WXRecoveryHandleService:readFromStream	(Ljava/io/InputStream;)[B
    //   41: astore_1
    //   42: aload_0
    //   43: invokevirtual 67	java/io/InputStream:close	()V
    //   46: aload_1
    //   47: areturn
    //   48: astore_0
    //   49: aconst_null
    //   50: astore_0
    //   51: aload_0
    //   52: ifnull +26 -> 78
    //   55: aload_0
    //   56: invokevirtual 67	java/io/InputStream:close	()V
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
    //   73: invokevirtual 67	java/io/InputStream:close	()V
    //   76: aload_0
    //   77: athrow
    //   78: aconst_null
    //   79: areturn
    //   80: aload_0
    //   81: invokestatic 114	com/tencent/recovery/wx/util/WXUtil:appendRandomParams	(Ljava/lang/String;)Ljava/lang/String;
    //   84: astore_0
    //   85: new 116	java/net/URL
    //   88: dup
    //   89: aload_0
    //   90: invokespecial 117	java/net/URL:<init>	(Ljava/lang/String;)V
    //   93: invokevirtual 121	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   96: checkcast 123	java/net/HttpURLConnection
    //   99: astore_0
    //   100: aload_0
    //   101: ldc 125
    //   103: invokevirtual 128	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   106: aload_0
    //   107: sipush 10000
    //   110: invokevirtual 132	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   113: aload_0
    //   114: sipush 20000
    //   117: invokevirtual 135	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   120: aload_0
    //   121: invokevirtual 138	java/net/HttpURLConnection:connect	()V
    //   124: aload_0
    //   125: invokevirtual 142	java/net/HttpURLConnection:getResponseCode	()I
    //   128: istore_3
    //   129: iload_3
    //   130: sipush 200
    //   133: if_icmpeq +41 -> 174
    //   136: aload_2
    //   137: iload_3
    //   138: invokestatic 182	com/tencent/recovery/wx/util/WXUtil:getHttpPatchCodeKey	(I)Ljava/lang/String;
    //   141: putfield 108	com/tencent/recovery/model/RecoveryHandleItem:key	Ljava/lang/String;
    //   144: aconst_null
    //   145: astore 7
    //   147: aconst_null
    //   148: astore 4
    //   150: aload 7
    //   152: ifnull +8 -> 160
    //   155: aload 7
    //   157: invokevirtual 67	java/io/InputStream:close	()V
    //   160: aload 4
    //   162: astore_2
    //   163: aload_0
    //   164: ifnull +309 -> 473
    //   167: aload_0
    //   168: invokevirtual 149	java/net/HttpURLConnection:disconnect	()V
    //   171: aload 4
    //   173: areturn
    //   174: aload_0
    //   175: invokevirtual 153	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   178: astore 5
    //   180: aload 5
    //   182: ifnonnull +19 -> 201
    //   185: aload_2
    //   186: ldc 184
    //   188: putfield 108	com/tencent/recovery/model/RecoveryHandleItem:key	Ljava/lang/String;
    //   191: aconst_null
    //   192: astore 4
    //   194: aload 5
    //   196: astore 7
    //   198: goto -48 -> 150
    //   201: aload 5
    //   203: invokestatic 62	com/tencent/recovery/wx/util/FileUtil:readFromStream	(Ljava/io/InputStream;)[B
    //   206: astore 6
    //   208: aload 6
    //   210: ifnonnull +91 -> 301
    //   213: aload_2
    //   214: ldc 186
    //   216: putfield 108	com/tencent/recovery/model/RecoveryHandleItem:key	Ljava/lang/String;
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
    //   237: ldc 8
    //   239: aload 4
    //   241: ldc 188
    //   243: iconst_0
    //   244: anewarray 77	java/lang/Object
    //   247: invokestatic 163	com/tencent/recovery/log/RecoveryLog:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   250: aload_2
    //   251: new 91	java/lang/StringBuilder
    //   254: dup
    //   255: ldc 190
    //   257: invokespecial 94	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   260: aload 4
    //   262: invokevirtual 168	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   265: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: ldc 100
    //   270: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   276: putfield 108	com/tencent/recovery/model/RecoveryHandleItem:key	Ljava/lang/String;
    //   279: aload 5
    //   281: ifnull +8 -> 289
    //   284: aload 5
    //   286: invokevirtual 67	java/io/InputStream:close	()V
    //   289: aload_0
    //   290: astore_2
    //   291: aload_1
    //   292: ifnull +181 -> 473
    //   295: aload_1
    //   296: invokevirtual 149	java/net/HttpURLConnection:disconnect	()V
    //   299: aload_0
    //   300: areturn
    //   301: aload 6
    //   303: arraylength
    //   304: ifne +45 -> 349
    //   307: aload_2
    //   308: ldc 192
    //   310: putfield 108	com/tencent/recovery/model/RecoveryHandleItem:key	Ljava/lang/String;
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
    //   336: invokevirtual 67	java/io/InputStream:close	()V
    //   339: aload_1
    //   340: ifnull +7 -> 347
    //   343: aload_1
    //   344: invokevirtual 149	java/net/HttpURLConnection:disconnect	()V
    //   347: aload_0
    //   348: athrow
    //   349: aload 6
    //   351: astore 4
    //   353: aload 5
    //   355: astore 7
    //   357: aload 6
    //   359: invokestatic 73	com/tencent/recovery/wx/util/EncryptUtil:getMessageDigest	([B)Ljava/lang/String;
    //   362: aload_1
    //   363: invokevirtual 196	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   366: ifne -216 -> 150
    //   369: aload_2
    //   370: ldc 198
    //   372: putfield 108	com/tencent/recovery/model/RecoveryHandleItem:key	Ljava/lang/String;
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
  
  public static byte[] readFromStream(InputStream paramInputStream)
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
  private void realHandleException(Context paramContext, RecoveryData paramRecoveryData, RecoveryHandleItem paramRecoveryHandleItem, RecoveryHandleResult paramRecoveryHandleResult)
  {
    // Byte code:
    //   0: aload_2
    //   1: getfield 220	com/tencent/recovery/model/RecoveryData:configUrl	Ljava/lang/String;
    //   4: astore_2
    //   5: ldc 8
    //   7: ldc 222
    //   9: iconst_1
    //   10: anewarray 77	java/lang/Object
    //   13: dup
    //   14: iconst_0
    //   15: aload_2
    //   16: aastore
    //   17: invokestatic 83	com/tencent/recovery/log/RecoveryLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   20: aload_2
    //   21: aload_3
    //   22: invokestatic 224	com/tencent/recovery/wx/service/WXRecoveryHandleService:getConfigData	(Ljava/lang/String;Lcom/tencent/recovery/model/RecoveryHandleItem;)Ljava/lang/String;
    //   25: astore_2
    //   26: aload_2
    //   27: ifnull +401 -> 428
    //   30: ldc 8
    //   32: ldc 226
    //   34: iconst_1
    //   35: anewarray 77	java/lang/Object
    //   38: dup
    //   39: iconst_0
    //   40: aload_2
    //   41: aastore
    //   42: invokestatic 83	com/tencent/recovery/log/RecoveryLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   45: new 228	org/json/JSONObject
    //   48: dup
    //   49: aload_2
    //   50: invokespecial 229	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   53: astore_2
    //   54: aload_2
    //   55: ifnull +353 -> 408
    //   58: aload_2
    //   59: ldc 231
    //   61: iconst_m1
    //   62: invokevirtual 235	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   65: istore 5
    //   67: aload_2
    //   68: ldc 237
    //   70: iconst_m1
    //   71: invokevirtual 235	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   74: istore 6
    //   76: aload_2
    //   77: ldc 239
    //   79: ldc 44
    //   81: invokevirtual 243	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   84: astore 7
    //   86: aload_2
    //   87: ldc 245
    //   89: ldc 44
    //   91: invokevirtual 243	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   94: astore_2
    //   95: aload_0
    //   96: invokestatic 251	com/tencent/recovery/util/Util:getUUID	(Landroid/content/Context;)I
    //   99: iload 5
    //   101: irem
    //   102: iload 6
    //   104: if_icmpne +192 -> 296
    //   107: iconst_1
    //   108: istore 5
    //   110: iload 5
    //   112: ifeq +276 -> 388
    //   115: ldc 8
    //   117: ldc 253
    //   119: iconst_1
    //   120: anewarray 77	java/lang/Object
    //   123: dup
    //   124: iconst_0
    //   125: aload 7
    //   127: aastore
    //   128: invokestatic 83	com/tencent/recovery/log/RecoveryLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   131: aload 7
    //   133: aload_2
    //   134: aload_3
    //   135: invokestatic 255	com/tencent/recovery/wx/service/WXRecoveryHandleService:getPatchData	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/recovery/model/RecoveryHandleItem;)[B
    //   138: astore 9
    //   140: aload 9
    //   142: ifnull +233 -> 375
    //   145: new 91	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 256	java/lang/StringBuilder:<init>	()V
    //   152: aload_1
    //   153: invokevirtual 262	android/content/Context:getCacheDir	()Ljava/io/File;
    //   156: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   159: ldc_w 267
    //   162: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: astore 7
    //   170: new 42	java/io/File
    //   173: dup
    //   174: aload 7
    //   176: invokespecial 51	java/io/File:<init>	(Ljava/lang/String;)V
    //   179: astore 8
    //   181: aload 8
    //   183: invokevirtual 271	java/io/File:exists	()Z
    //   186: ifeq +9 -> 195
    //   189: aload 8
    //   191: invokevirtual 274	java/io/File:delete	()Z
    //   194: pop
    //   195: new 276	java/io/FileOutputStream
    //   198: dup
    //   199: aload 8
    //   201: invokespecial 277	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   204: astore_2
    //   205: aload_2
    //   206: aload 9
    //   208: invokevirtual 279	java/io/FileOutputStream:write	([B)V
    //   211: aload_2
    //   212: invokevirtual 280	java/io/FileOutputStream:close	()V
    //   215: aload 8
    //   217: invokevirtual 271	java/io/File:exists	()Z
    //   220: ifeq +135 -> 355
    //   223: aload_1
    //   224: aload 7
    //   226: invokestatic 286	com/tencent/recovery/wx/RecoveryTinkerManager:startToPatch	(Landroid/content/Context;Ljava/lang/String;)I
    //   229: istore 5
    //   231: iload 5
    //   233: ifeq +100 -> 333
    //   236: aload_3
    //   237: new 91	java/lang/StringBuilder
    //   240: dup
    //   241: ldc_w 288
    //   244: invokespecial 94	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   247: iload 5
    //   249: invokevirtual 291	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   252: ldc 100
    //   254: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: putfield 108	com/tencent/recovery/model/RecoveryHandleItem:key	Ljava/lang/String;
    //   263: ldc 8
    //   265: ldc_w 293
    //   268: iconst_1
    //   269: anewarray 77	java/lang/Object
    //   272: dup
    //   273: iconst_0
    //   274: iload 5
    //   276: invokestatic 299	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   279: aastore
    //   280: invokestatic 83	com/tencent/recovery/log/RecoveryLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   283: aload 4
    //   285: iconst_1
    //   286: putfield 305	com/tencent/recovery/model/RecoveryHandleResult:result	Z
    //   289: return
    //   290: astore_2
    //   291: aconst_null
    //   292: astore_2
    //   293: goto -239 -> 54
    //   296: iconst_0
    //   297: istore 5
    //   299: goto -189 -> 110
    //   302: astore_2
    //   303: aconst_null
    //   304: astore_2
    //   305: aload_2
    //   306: ifnull -91 -> 215
    //   309: aload_2
    //   310: invokevirtual 280	java/io/FileOutputStream:close	()V
    //   313: goto -98 -> 215
    //   316: astore_2
    //   317: goto -102 -> 215
    //   320: astore_1
    //   321: aconst_null
    //   322: astore_2
    //   323: aload_2
    //   324: ifnull +7 -> 331
    //   327: aload_2
    //   328: invokevirtual 280	java/io/FileOutputStream:close	()V
    //   331: aload_1
    //   332: athrow
    //   333: aload_3
    //   334: ldc_w 307
    //   337: putfield 108	com/tencent/recovery/model/RecoveryHandleItem:key	Ljava/lang/String;
    //   340: ldc 8
    //   342: ldc_w 309
    //   345: iconst_0
    //   346: anewarray 77	java/lang/Object
    //   349: invokestatic 83	com/tencent/recovery/log/RecoveryLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   352: goto -69 -> 283
    //   355: aload_3
    //   356: ldc_w 311
    //   359: putfield 108	com/tencent/recovery/model/RecoveryHandleItem:key	Ljava/lang/String;
    //   362: ldc 8
    //   364: ldc_w 313
    //   367: iconst_0
    //   368: anewarray 77	java/lang/Object
    //   371: invokestatic 83	com/tencent/recovery/log/RecoveryLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   374: return
    //   375: ldc 8
    //   377: ldc_w 315
    //   380: iconst_0
    //   381: anewarray 77	java/lang/Object
    //   384: invokestatic 83	com/tencent/recovery/log/RecoveryLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   387: return
    //   388: ldc 8
    //   390: ldc_w 317
    //   393: iconst_0
    //   394: anewarray 77	java/lang/Object
    //   397: invokestatic 83	com/tencent/recovery/log/RecoveryLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   400: aload_3
    //   401: ldc_w 319
    //   404: putfield 108	com/tencent/recovery/model/RecoveryHandleItem:key	Ljava/lang/String;
    //   407: return
    //   408: ldc 8
    //   410: ldc_w 321
    //   413: iconst_0
    //   414: anewarray 77	java/lang/Object
    //   417: invokestatic 83	com/tencent/recovery/log/RecoveryLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   420: aload_3
    //   421: ldc_w 323
    //   424: putfield 108	com/tencent/recovery/model/RecoveryHandleItem:key	Ljava/lang/String;
    //   427: return
    //   428: ldc 8
    //   430: ldc_w 325
    //   433: iconst_0
    //   434: anewarray 77	java/lang/Object
    //   437: invokestatic 83	com/tencent/recovery/log/RecoveryLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   440: aload_3
    //   441: getfield 108	com/tencent/recovery/model/RecoveryHandleItem:key	Ljava/lang/String;
    //   444: invokestatic 328	com/tencent/recovery/util/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   447: ifeq -158 -> 289
    //   450: aload_3
    //   451: ldc_w 330
    //   454: putfield 108	com/tencent/recovery/model/RecoveryHandleItem:key	Ljava/lang/String;
    //   457: return
    //   458: astore_2
    //   459: goto -244 -> 215
    //   462: astore_2
    //   463: goto -132 -> 331
    //   466: astore_1
    //   467: goto -144 -> 323
    //   470: astore 9
    //   472: goto -167 -> 305
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	475	0	this	WXRecoveryHandleService
    //   0	475	1	paramContext	Context
    //   0	475	2	paramRecoveryData	RecoveryData
    //   0	475	3	paramRecoveryHandleItem	RecoveryHandleItem
    //   0	475	4	paramRecoveryHandleResult	RecoveryHandleResult
    //   65	233	5	i	int
    //   74	31	6	j	int
    //   84	141	7	str	String
    //   179	37	8	localFile	java.io.File
    //   138	69	9	arrayOfByte	byte[]
    //   470	1	9	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   45	54	290	java/lang/Exception
    //   195	205	302	java/lang/Exception
    //   309	313	316	java/io/IOException
    //   195	205	320	finally
    //   211	215	458	java/io/IOException
    //   327	331	462	java/io/IOException
    //   205	211	466	finally
    //   205	211	470	java/lang/Exception
  }
  
  public void alreadyRunning(Context paramContext, RecoveryData paramRecoveryData, ArrayList<RecoveryHandleItem> paramArrayList, int paramInt, boolean paramBoolean)
  {
    paramArrayList.add(generateHandleItem(paramRecoveryData, String.format("%s[%b]", new Object[] { "KeyTotalCount", Boolean.valueOf(paramBoolean) })));
    paramArrayList.add(generateHandleItem(paramRecoveryData, String.format("%s[%b]", new Object[] { "KeyAlreadyRunning", Boolean.valueOf(paramBoolean) })));
  }
  
  protected RecoveryHandleItem generateHandleItem(RecoveryData paramRecoveryData, String paramString)
  {
    RecoveryHandleItem localRecoveryHandleItem = new RecoveryHandleItem();
    localRecoveryHandleItem.uuid = paramRecoveryData.uuid;
    localRecoveryHandleItem.clientVersion = paramRecoveryData.clientVersion;
    localRecoveryHandleItem.timestamp = System.currentTimeMillis();
    localRecoveryHandleItem.key = paramString;
    localRecoveryHandleItem.processName = paramRecoveryData.processName;
    localRecoveryHandleItem.phoneStatus = getCurrentPhoneStatus(this);
    return localRecoveryHandleItem;
  }
  
  public String getCurrentPhoneStatus(Context paramContext)
  {
    paramContext = NetUtil.getCurrentNetWorkStatus(paramContext);
    boolean bool1 = this.powerManager.isScreenOn();
    boolean bool2 = checkResolveIPAddress("dldir1.qq.com");
    boolean bool3 = checkResolveIPAddress("www.qq.com");
    return paramContext + "|" + bool1 + "|" + bool2 + "|" + bool3;
  }
  
  public RecoveryHandleResult handleException(Context paramContext, RecoveryData paramRecoveryData, ArrayList<RecoveryHandleItem> paramArrayList, int paramInt, boolean paramBoolean)
  {
    RecoveryHandleResult localRecoveryHandleResult = new RecoveryHandleResult();
    paramArrayList.add(generateHandleItem(paramRecoveryData, String.format("%s[%b]", new Object[] { "KeyTotalCount", Boolean.valueOf(paramBoolean) })));
    RecoveryHandleItem localRecoveryHandleItem = generateHandleItem(paramRecoveryData, "");
    if (NetUtil.isConnected(this)) {
      realHandleException(paramContext, paramRecoveryData, localRecoveryHandleItem, localRecoveryHandleResult);
    }
    for (;;)
    {
      paramArrayList.add(localRecoveryHandleItem);
      return localRecoveryHandleResult;
      RecoveryLog.i("Recovery.WXRecoveryHandleService", "no network", new Object[0]);
      if (!paramBoolean) {
        localRecoveryHandleResult.retry = true;
      }
      localRecoveryHandleItem.key = String.format("%s[%b]", new Object[] { "KeyNoNetWork", Boolean.valueOf(paramBoolean) });
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    RecoveryLog.i("Recovery.WXRecoveryHandleService", "onCreate", new Object[0]);
    this.powerManager = ((PowerManager)getSystemService("power"));
  }
  
  public void onDestroy()
  {
    RecoveryLog.i("Recovery.WXRecoveryHandleService", "onDestroy", new Object[0]);
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.recovery.wx.service.WXRecoveryHandleService
 * JD-Core Version:    0.7.0.1
 */