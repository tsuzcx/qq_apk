package com.tencent.mm.plugin.sns.ui;

import android.os.AsyncTask;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.vfs.e;
import java.util.HashSet;
import java.util.Set;

final class SnsAdNativeLandingTestUI$a
  extends AsyncTask<String, Void, Void>
{
  private static Set<String> oVk = new HashSet();
  private static byte[] oVl = new byte[0];
  final String fileName;
  final String filePath;
  final ah handler;
  final String oKf;
  final String oKg;
  final int oKi;
  final String oKj;
  final SnsAdNativeLandingTestUI.a.a oVm;
  
  public SnsAdNativeLandingTestUI$a(String paramString1, String paramString2, ah paramah, SnsAdNativeLandingTestUI.a.a parama)
  {
    this(paramString1, paramString2, paramah, parama, 0);
  }
  
  public SnsAdNativeLandingTestUI$a(String paramString1, String paramString2, ah paramah, SnsAdNativeLandingTestUI.a.a parama, int paramInt)
  {
    e.nb(paramString1);
    this.oKj = paramString1;
    this.fileName = paramString2;
    this.filePath = (paramString1 + "/" + paramString2);
    this.oKg = ("temp_" + paramString2);
    this.oKf = (paramString1 + "/" + this.oKg);
    this.handler = paramah;
    this.oKi = paramInt;
    this.oVm = new SnsAdNativeLandingTestUI.a.1(this, paramah, parama);
  }
  
  /* Error */
  private Void z(String... paramVarArgs)
  {
    // Byte code:
    //   0: getstatic 38	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:oVl	[B
    //   3: astore 5
    //   5: aload 5
    //   7: monitorenter
    //   8: getstatic 36	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:oVk	Ljava/util/Set;
    //   11: aload_1
    //   12: iconst_0
    //   13: aaload
    //   14: invokeinterface 101 2 0
    //   19: ifeq +8 -> 27
    //   22: aload 5
    //   24: monitorexit
    //   25: aconst_null
    //   26: areturn
    //   27: getstatic 36	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:oVk	Ljava/util/Set;
    //   30: aload_1
    //   31: iconst_0
    //   32: aaload
    //   33: invokeinterface 104 2 0
    //   38: pop
    //   39: aload 5
    //   41: monitorexit
    //   42: aload_0
    //   43: getfield 69	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:filePath	Ljava/lang/String;
    //   46: invokestatic 107	com/tencent/mm/vfs/e:bK	(Ljava/lang/String;)Z
    //   49: ifeq +53 -> 102
    //   52: aload_0
    //   53: getfield 89	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:oVm	Lcom/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a$a;
    //   56: aload_0
    //   57: getfield 69	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:filePath	Ljava/lang/String;
    //   60: invokeinterface 110 2 0
    //   65: getstatic 38	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:oVl	[B
    //   68: astore 5
    //   70: aload 5
    //   72: monitorenter
    //   73: getstatic 36	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:oVk	Ljava/util/Set;
    //   76: aload_1
    //   77: iconst_0
    //   78: aaload
    //   79: invokeinterface 113 2 0
    //   84: pop
    //   85: aload 5
    //   87: monitorexit
    //   88: aconst_null
    //   89: areturn
    //   90: astore_1
    //   91: aload 5
    //   93: monitorexit
    //   94: aload_1
    //   95: athrow
    //   96: astore_1
    //   97: aload 5
    //   99: monitorexit
    //   100: aload_1
    //   101: athrow
    //   102: aload_0
    //   103: getfield 78	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:oKf	Ljava/lang/String;
    //   106: invokestatic 107	com/tencent/mm/vfs/e:bK	(Ljava/lang/String;)Z
    //   109: ifeq +11 -> 120
    //   112: aload_0
    //   113: getfield 78	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:oKf	Ljava/lang/String;
    //   116: invokestatic 116	com/tencent/mm/vfs/e:deleteFile	(Ljava/lang/String;)Z
    //   119: pop
    //   120: new 118	java/net/URL
    //   123: dup
    //   124: aload_1
    //   125: iconst_0
    //   126: aaload
    //   127: invokespecial 119	java/net/URL:<init>	(Ljava/lang/String;)V
    //   130: invokevirtual 123	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   133: checkcast 125	java/net/HttpURLConnection
    //   136: astore 5
    //   138: aload 5
    //   140: invokevirtual 128	java/net/HttpURLConnection:connect	()V
    //   143: aload 5
    //   145: invokevirtual 132	java/net/HttpURLConnection:getResponseCode	()I
    //   148: sipush 200
    //   151: if_icmpeq +86 -> 237
    //   154: aload_0
    //   155: getfield 89	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:oVm	Lcom/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a$a;
    //   158: new 56	java/lang/StringBuilder
    //   161: dup
    //   162: ldc 134
    //   164: invokespecial 74	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   167: aload 5
    //   169: invokevirtual 132	java/net/HttpURLConnection:getResponseCode	()I
    //   172: invokevirtual 137	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   175: ldc 139
    //   177: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: aload 5
    //   182: invokevirtual 142	java/net/HttpURLConnection:getResponseMessage	()Ljava/lang/String;
    //   185: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: invokeinterface 145 2 0
    //   196: aload 5
    //   198: ifnull +8 -> 206
    //   201: aload 5
    //   203: invokevirtual 148	java/net/HttpURLConnection:disconnect	()V
    //   206: getstatic 38	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:oVl	[B
    //   209: astore 5
    //   211: aload 5
    //   213: monitorenter
    //   214: getstatic 36	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:oVk	Ljava/util/Set;
    //   217: aload_1
    //   218: iconst_0
    //   219: aaload
    //   220: invokeinterface 113 2 0
    //   225: pop
    //   226: aload 5
    //   228: monitorexit
    //   229: aconst_null
    //   230: areturn
    //   231: astore_1
    //   232: aload 5
    //   234: monitorexit
    //   235: aload_1
    //   236: athrow
    //   237: aload 5
    //   239: invokevirtual 151	java/net/HttpURLConnection:getContentLength	()I
    //   242: pop
    //   243: aload 5
    //   245: invokevirtual 155	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   248: astore 8
    //   250: aload_0
    //   251: getfield 78	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:oKf	Ljava/lang/String;
    //   254: iconst_0
    //   255: invokestatic 158	com/tencent/mm/vfs/e:I	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   258: astore 7
    //   260: sipush 4096
    //   263: newarray byte
    //   265: astore 6
    //   267: iconst_0
    //   268: istore_3
    //   269: iconst_0
    //   270: istore_2
    //   271: aload 8
    //   273: aload 6
    //   275: invokevirtual 164	java/io/InputStream:read	([B)I
    //   278: istore 4
    //   280: iload 4
    //   282: iconst_m1
    //   283: if_icmpeq +54 -> 337
    //   286: aload 7
    //   288: aload 6
    //   290: iconst_0
    //   291: iload 4
    //   293: invokevirtual 170	java/io/OutputStream:write	([BII)V
    //   296: iload 4
    //   298: iload_2
    //   299: iadd
    //   300: istore_2
    //   301: aload_0
    //   302: getfield 82	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:oKi	I
    //   305: ifeq +393 -> 698
    //   308: iload_2
    //   309: iload_3
    //   310: isub
    //   311: aload_0
    //   312: getfield 82	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:oKi	I
    //   315: if_icmplt +383 -> 698
    //   318: aload_0
    //   319: getfield 89	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:oVm	Lcom/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a$a;
    //   322: aload_0
    //   323: getfield 78	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:oKf	Ljava/lang/String;
    //   326: iload_2
    //   327: invokeinterface 174 3 0
    //   332: iload_2
    //   333: istore_3
    //   334: goto -63 -> 271
    //   337: aload_0
    //   338: getfield 78	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:oKf	Ljava/lang/String;
    //   341: aload_0
    //   342: getfield 69	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:filePath	Ljava/lang/String;
    //   345: invokestatic 178	com/tencent/mm/vfs/e:aA	(Ljava/lang/String;Ljava/lang/String;)Z
    //   348: pop
    //   349: aload_0
    //   350: getfield 89	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:oVm	Lcom/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a$a;
    //   353: aload_0
    //   354: getfield 69	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:filePath	Ljava/lang/String;
    //   357: invokeinterface 110 2 0
    //   362: aload 7
    //   364: ifnull +8 -> 372
    //   367: aload 7
    //   369: invokevirtual 181	java/io/OutputStream:close	()V
    //   372: aload 8
    //   374: ifnull +8 -> 382
    //   377: aload 8
    //   379: invokevirtual 182	java/io/InputStream:close	()V
    //   382: aload 5
    //   384: ifnull +8 -> 392
    //   387: aload 5
    //   389: invokevirtual 148	java/net/HttpURLConnection:disconnect	()V
    //   392: getstatic 38	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:oVl	[B
    //   395: astore 5
    //   397: aload 5
    //   399: monitorenter
    //   400: getstatic 36	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:oVk	Ljava/util/Set;
    //   403: aload_1
    //   404: iconst_0
    //   405: aaload
    //   406: invokeinterface 113 2 0
    //   411: pop
    //   412: aload 5
    //   414: monitorexit
    //   415: aconst_null
    //   416: areturn
    //   417: astore_1
    //   418: aload 5
    //   420: monitorexit
    //   421: aload_1
    //   422: athrow
    //   423: astore 5
    //   425: aconst_null
    //   426: astore 6
    //   428: aconst_null
    //   429: astore 7
    //   431: aconst_null
    //   432: astore 8
    //   434: aload_0
    //   435: getfield 89	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:oVm	Lcom/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a$a;
    //   438: aload 5
    //   440: invokevirtual 185	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   443: invokeinterface 145 2 0
    //   448: aload 7
    //   450: ifnull +8 -> 458
    //   453: aload 7
    //   455: invokevirtual 181	java/io/OutputStream:close	()V
    //   458: aload 8
    //   460: ifnull +8 -> 468
    //   463: aload 8
    //   465: invokevirtual 182	java/io/InputStream:close	()V
    //   468: aload 6
    //   470: ifnull +8 -> 478
    //   473: aload 6
    //   475: invokevirtual 148	java/net/HttpURLConnection:disconnect	()V
    //   478: getstatic 38	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:oVl	[B
    //   481: astore 5
    //   483: aload 5
    //   485: monitorenter
    //   486: getstatic 36	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:oVk	Ljava/util/Set;
    //   489: aload_1
    //   490: iconst_0
    //   491: aaload
    //   492: invokeinterface 113 2 0
    //   497: pop
    //   498: aload 5
    //   500: monitorexit
    //   501: aconst_null
    //   502: areturn
    //   503: astore_1
    //   504: aload 5
    //   506: monitorexit
    //   507: aload_1
    //   508: athrow
    //   509: astore 5
    //   511: aconst_null
    //   512: astore 6
    //   514: aconst_null
    //   515: astore 7
    //   517: aconst_null
    //   518: astore 8
    //   520: aload 7
    //   522: ifnull +8 -> 530
    //   525: aload 7
    //   527: invokevirtual 181	java/io/OutputStream:close	()V
    //   530: aload 8
    //   532: ifnull +8 -> 540
    //   535: aload 8
    //   537: invokevirtual 182	java/io/InputStream:close	()V
    //   540: aload 6
    //   542: ifnull +8 -> 550
    //   545: aload 6
    //   547: invokevirtual 148	java/net/HttpURLConnection:disconnect	()V
    //   550: getstatic 38	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:oVl	[B
    //   553: astore 6
    //   555: aload 6
    //   557: monitorenter
    //   558: getstatic 36	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:oVk	Ljava/util/Set;
    //   561: aload_1
    //   562: iconst_0
    //   563: aaload
    //   564: invokeinterface 113 2 0
    //   569: pop
    //   570: aload 6
    //   572: monitorexit
    //   573: aload 5
    //   575: athrow
    //   576: astore_1
    //   577: aload 6
    //   579: monitorexit
    //   580: aload_1
    //   581: athrow
    //   582: astore 7
    //   584: goto -44 -> 540
    //   587: astore 9
    //   589: aload 5
    //   591: astore 6
    //   593: aconst_null
    //   594: astore 7
    //   596: aconst_null
    //   597: astore 8
    //   599: aload 9
    //   601: astore 5
    //   603: goto -83 -> 520
    //   606: astore 9
    //   608: aload 5
    //   610: astore 6
    //   612: aconst_null
    //   613: astore 7
    //   615: aload 9
    //   617: astore 5
    //   619: goto -99 -> 520
    //   622: astore 9
    //   624: aload 5
    //   626: astore 6
    //   628: aload 9
    //   630: astore 5
    //   632: goto -112 -> 520
    //   635: astore 5
    //   637: goto -117 -> 520
    //   640: astore 5
    //   642: goto -174 -> 468
    //   645: astore 9
    //   647: aload 5
    //   649: astore 6
    //   651: aconst_null
    //   652: astore 7
    //   654: aconst_null
    //   655: astore 8
    //   657: aload 9
    //   659: astore 5
    //   661: goto -227 -> 434
    //   664: astore 9
    //   666: aload 5
    //   668: astore 6
    //   670: aconst_null
    //   671: astore 7
    //   673: aload 9
    //   675: astore 5
    //   677: goto -243 -> 434
    //   680: astore 9
    //   682: aload 5
    //   684: astore 6
    //   686: aload 9
    //   688: astore 5
    //   690: goto -256 -> 434
    //   693: astore 6
    //   695: goto -313 -> 382
    //   698: goto -427 -> 271
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	701	0	this	a
    //   0	701	1	paramVarArgs	String[]
    //   270	63	2	i	int
    //   268	66	3	j	int
    //   278	22	4	k	int
    //   3	416	5	localObject1	java.lang.Object
    //   423	16	5	localException1	java.lang.Exception
    //   481	24	5	arrayOfByte	byte[]
    //   509	81	5	localObject2	java.lang.Object
    //   601	30	5	localObject3	java.lang.Object
    //   635	1	5	localObject4	java.lang.Object
    //   640	8	5	localIOException1	java.io.IOException
    //   659	30	5	localObject5	java.lang.Object
    //   265	420	6	localObject6	java.lang.Object
    //   693	1	6	localIOException2	java.io.IOException
    //   258	268	7	localOutputStream	java.io.OutputStream
    //   582	1	7	localIOException3	java.io.IOException
    //   594	78	7	localObject7	java.lang.Object
    //   248	408	8	localInputStream	java.io.InputStream
    //   587	13	9	localObject8	java.lang.Object
    //   606	10	9	localObject9	java.lang.Object
    //   622	7	9	localObject10	java.lang.Object
    //   645	13	9	localException2	java.lang.Exception
    //   664	10	9	localException3	java.lang.Exception
    //   680	7	9	localException4	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   73	88	90	finally
    //   91	94	90	finally
    //   8	25	96	finally
    //   27	42	96	finally
    //   97	100	96	finally
    //   214	229	231	finally
    //   232	235	231	finally
    //   400	415	417	finally
    //   418	421	417	finally
    //   42	65	423	java/lang/Exception
    //   102	120	423	java/lang/Exception
    //   120	138	423	java/lang/Exception
    //   486	501	503	finally
    //   504	507	503	finally
    //   42	65	509	finally
    //   102	120	509	finally
    //   120	138	509	finally
    //   558	573	576	finally
    //   577	580	576	finally
    //   525	530	582	java/io/IOException
    //   535	540	582	java/io/IOException
    //   138	196	587	finally
    //   237	250	587	finally
    //   250	260	606	finally
    //   260	267	622	finally
    //   271	280	622	finally
    //   286	296	622	finally
    //   301	332	622	finally
    //   337	362	622	finally
    //   434	448	635	finally
    //   453	458	640	java/io/IOException
    //   463	468	640	java/io/IOException
    //   138	196	645	java/lang/Exception
    //   237	250	645	java/lang/Exception
    //   250	260	664	java/lang/Exception
    //   260	267	680	java/lang/Exception
    //   271	280	680	java/lang/Exception
    //   286	296	680	java/lang/Exception
    //   301	332	680	java/lang/Exception
    //   337	362	680	java/lang/Exception
    //   367	372	693	java/io/IOException
    //   377	382	693	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI.a
 * JD-Core Version:    0.7.0.1
 */