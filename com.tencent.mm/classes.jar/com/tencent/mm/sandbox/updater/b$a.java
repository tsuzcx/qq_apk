package com.tencent.mm.sandbox.updater;

import android.os.AsyncTask;
import com.tencent.mm.network.u;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.alm;
import com.tencent.mm.protocal.c.aln;
import com.tencent.mm.sdk.platformtools.y;
import java.net.HttpURLConnection;

final class b$a
  extends AsyncTask<alm, Integer, aln>
{
  private String host = null;
  private u nfp = null;
  private com.tencent.mm.sandbox.b.a ucm = null;
  private int ucq = 200;
  private PInt ucr = new PInt();
  
  public b$a(b paramb, String paramString, com.tencent.mm.sandbox.b.a parama)
  {
    this.host = paramString;
    this.ucm = parama;
  }
  
  /* Error */
  private aln a(alm... paramVarArgs)
  {
    // Byte code:
    //   0: aload_1
    //   1: arraylength
    //   2: ifeq +9 -> 11
    //   5: aload_1
    //   6: iconst_0
    //   7: aaload
    //   8: ifnonnull +12 -> 20
    //   11: aload_0
    //   12: iconst_m1
    //   13: putfield 31	com/tencent/mm/sandbox/updater/b$a:ucq	I
    //   16: aconst_null
    //   17: astore_1
    //   18: aload_1
    //   19: areturn
    //   20: ldc 48
    //   22: new 50	java/lang/StringBuilder
    //   25: dup
    //   26: ldc 52
    //   28: invokespecial 55	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   31: aload_1
    //   32: iconst_0
    //   33: aaload
    //   34: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokestatic 69	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: aload_1
    //   44: iconst_0
    //   45: aaload
    //   46: astore_1
    //   47: new 71	com/tencent/mm/pointers/PByteArray
    //   50: dup
    //   51: invokespecial 72	com/tencent/mm/pointers/PByteArray:<init>	()V
    //   54: astore 9
    //   56: bipush 6
    //   58: istore_2
    //   59: getstatic 78	com/tencent/mm/sdk/a/b:foreground	Z
    //   62: ifeq +6 -> 68
    //   65: bipush 7
    //   67: istore_2
    //   68: aload_1
    //   69: invokevirtual 84	com/tencent/mm/protocal/c/alm:toByteArray	()[B
    //   72: astore_1
    //   73: aload_0
    //   74: getfield 24	com/tencent/mm/sandbox/updater/b$a:ucp	Lcom/tencent/mm/sandbox/updater/b;
    //   77: invokestatic 88	com/tencent/mm/sandbox/updater/b:j	(Lcom/tencent/mm/sandbox/updater/b;)[B
    //   80: astore 6
    //   82: aload_0
    //   83: getfield 24	com/tencent/mm/sandbox/updater/b$a:ucp	Lcom/tencent/mm/sandbox/updater/b;
    //   86: invokestatic 91	com/tencent/mm/sandbox/updater/b:k	(Lcom/tencent/mm/sandbox/updater/b;)[B
    //   89: astore 7
    //   91: invokestatic 96	com/tencent/mm/compatible/e/q:zg	()Ljava/lang/String;
    //   94: astore 8
    //   96: aload_0
    //   97: getfield 24	com/tencent/mm/sandbox/updater/b$a:ucp	Lcom/tencent/mm/sandbox/updater/b;
    //   100: invokestatic 100	com/tencent/mm/sandbox/updater/b:l	(Lcom/tencent/mm/sandbox/updater/b;)I
    //   103: istore_3
    //   104: aload_0
    //   105: getfield 24	com/tencent/mm/sandbox/updater/b$a:ucp	Lcom/tencent/mm/sandbox/updater/b;
    //   108: invokestatic 103	com/tencent/mm/sandbox/updater/b:m	(Lcom/tencent/mm/sandbox/updater/b;)[B
    //   111: astore 10
    //   113: aload_1
    //   114: aload 9
    //   116: aload 6
    //   118: aload 7
    //   120: aload 8
    //   122: iload_3
    //   123: bipush 113
    //   125: iconst_0
    //   126: iconst_0
    //   127: newarray byte
    //   129: iconst_0
    //   130: newarray byte
    //   132: aload 10
    //   134: iload_2
    //   135: iconst_0
    //   136: invokestatic 109	com/tencent/mm/protocal/MMProtocalJni:pack	([BLcom/tencent/mm/pointers/PByteArray;[B[BLjava/lang/String;III[B[B[BII)Z
    //   139: pop
    //   140: aconst_null
    //   141: astore 8
    //   143: aconst_null
    //   144: astore 6
    //   146: aconst_null
    //   147: astore 7
    //   149: aload_0
    //   150: new 50	java/lang/StringBuilder
    //   153: dup
    //   154: ldc 111
    //   156: invokespecial 55	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   159: aload_0
    //   160: getfield 38	com/tencent/mm/sandbox/updater/b$a:host	Ljava/lang/String;
    //   163: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: ldc 116
    //   168: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: aconst_null
    //   175: invokestatic 121	com/tencent/mm/network/b:a	(Ljava/lang/String;Lcom/tencent/mm/network/b$b;)Lcom/tencent/mm/network/u;
    //   178: putfield 29	com/tencent/mm/sandbox/updater/b$a:nfp	Lcom/tencent/mm/network/u;
    //   181: aload_0
    //   182: getfield 29	com/tencent/mm/sandbox/updater/b$a:nfp	Lcom/tencent/mm/network/u;
    //   185: ldc 123
    //   187: invokevirtual 128	com/tencent/mm/network/u:setRequestMethod	(Ljava/lang/String;)V
    //   190: aload_0
    //   191: getfield 29	com/tencent/mm/sandbox/updater/b$a:nfp	Lcom/tencent/mm/network/u;
    //   194: invokevirtual 131	com/tencent/mm/network/u:Ud	()V
    //   197: aload_0
    //   198: getfield 29	com/tencent/mm/sandbox/updater/b$a:nfp	Lcom/tencent/mm/network/u;
    //   201: invokevirtual 134	com/tencent/mm/network/u:Ue	()V
    //   204: aload_0
    //   205: getfield 29	com/tencent/mm/sandbox/updater/b$a:nfp	Lcom/tencent/mm/network/u;
    //   208: iconst_0
    //   209: invokevirtual 138	com/tencent/mm/network/u:setUseCaches	(Z)V
    //   212: aload_0
    //   213: getfield 29	com/tencent/mm/sandbox/updater/b$a:nfp	Lcom/tencent/mm/network/u;
    //   216: ldc 140
    //   218: ldc 142
    //   220: invokevirtual 145	com/tencent/mm/network/u:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   223: aload_0
    //   224: getfield 29	com/tencent/mm/sandbox/updater/b$a:nfp	Lcom/tencent/mm/network/u;
    //   227: ldc 147
    //   229: ldc 149
    //   231: invokevirtual 145	com/tencent/mm/network/u:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   234: aload_0
    //   235: getfield 29	com/tencent/mm/sandbox/updater/b$a:nfp	Lcom/tencent/mm/network/u;
    //   238: ldc 151
    //   240: ldc 153
    //   242: invokevirtual 145	com/tencent/mm/network/u:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   245: aload_0
    //   246: getfield 29	com/tencent/mm/sandbox/updater/b$a:nfp	Lcom/tencent/mm/network/u;
    //   249: ldc 155
    //   251: ldc 157
    //   253: invokevirtual 145	com/tencent/mm/network/u:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   256: aload_0
    //   257: getfield 29	com/tencent/mm/sandbox/updater/b$a:nfp	Lcom/tencent/mm/network/u;
    //   260: ldc 159
    //   262: ldc 161
    //   264: invokevirtual 145	com/tencent/mm/network/u:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   267: aload_0
    //   268: getfield 29	com/tencent/mm/sandbox/updater/b$a:nfp	Lcom/tencent/mm/network/u;
    //   271: ldc 163
    //   273: ldc 165
    //   275: invokevirtual 145	com/tencent/mm/network/u:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   278: aload_0
    //   279: getfield 29	com/tencent/mm/sandbox/updater/b$a:nfp	Lcom/tencent/mm/network/u;
    //   282: sipush 15000
    //   285: invokevirtual 169	com/tencent/mm/network/u:setConnectTimeout	(I)V
    //   288: aload_0
    //   289: getfield 29	com/tencent/mm/sandbox/updater/b$a:nfp	Lcom/tencent/mm/network/u;
    //   292: invokevirtual 172	com/tencent/mm/network/u:connect	()V
    //   295: aload_0
    //   296: getfield 29	com/tencent/mm/sandbox/updater/b$a:nfp	Lcom/tencent/mm/network/u;
    //   299: invokevirtual 176	com/tencent/mm/network/u:getOutputStream	()Ljava/io/OutputStream;
    //   302: astore_1
    //   303: aload_1
    //   304: aload 9
    //   306: getfield 180	com/tencent/mm/pointers/PByteArray:value	[B
    //   309: invokevirtual 186	java/io/OutputStream:write	([B)V
    //   312: aload_1
    //   313: invokevirtual 189	java/io/OutputStream:flush	()V
    //   316: aload_0
    //   317: getfield 40	com/tencent/mm/sandbox/updater/b$a:ucm	Lcom/tencent/mm/sandbox/b$a;
    //   320: ldc2_w 190
    //   323: aload 9
    //   325: getfield 180	com/tencent/mm/pointers/PByteArray:value	[B
    //   328: arraylength
    //   329: i2l
    //   330: ladd
    //   331: invokeinterface 197 3 0
    //   336: aload_0
    //   337: aload_0
    //   338: getfield 29	com/tencent/mm/sandbox/updater/b$a:nfp	Lcom/tencent/mm/network/u;
    //   341: invokevirtual 201	com/tencent/mm/network/u:getResponseCode	()I
    //   344: putfield 31	com/tencent/mm/sandbox/updater/b$a:ucq	I
    //   347: aload_0
    //   348: getfield 31	com/tencent/mm/sandbox/updater/b$a:ucq	I
    //   351: istore_2
    //   352: iload_2
    //   353: sipush 200
    //   356: if_icmpeq +84 -> 440
    //   359: aload_1
    //   360: ifnull +7 -> 367
    //   363: aload_1
    //   364: invokevirtual 204	java/io/OutputStream:close	()V
    //   367: aload_0
    //   368: getfield 29	com/tencent/mm/sandbox/updater/b$a:nfp	Lcom/tencent/mm/network/u;
    //   371: ifnull +18 -> 389
    //   374: aload_0
    //   375: getfield 29	com/tencent/mm/sandbox/updater/b$a:nfp	Lcom/tencent/mm/network/u;
    //   378: getfield 208	com/tencent/mm/network/u:aRG	Ljava/net/HttpURLConnection;
    //   381: invokevirtual 213	java/net/HttpURLConnection:disconnect	()V
    //   384: aload_0
    //   385: aconst_null
    //   386: putfield 29	com/tencent/mm/sandbox/updater/b$a:nfp	Lcom/tencent/mm/network/u;
    //   389: aconst_null
    //   390: areturn
    //   391: astore_1
    //   392: ldc 48
    //   394: ldc 215
    //   396: iconst_1
    //   397: anewarray 217	java/lang/Object
    //   400: dup
    //   401: iconst_0
    //   402: aload_1
    //   403: invokevirtual 220	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   406: aastore
    //   407: invokestatic 224	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   410: ldc 48
    //   412: aload_1
    //   413: ldc 226
    //   415: iconst_0
    //   416: anewarray 217	java/lang/Object
    //   419: invokestatic 230	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   422: aconst_null
    //   423: areturn
    //   424: astore_1
    //   425: ldc 48
    //   427: aload_1
    //   428: ldc 226
    //   430: iconst_0
    //   431: anewarray 217	java/lang/Object
    //   434: invokestatic 230	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   437: goto -70 -> 367
    //   440: aload_0
    //   441: getfield 29	com/tencent/mm/sandbox/updater/b$a:nfp	Lcom/tencent/mm/network/u;
    //   444: ldc 232
    //   446: invokevirtual 236	com/tencent/mm/network/u:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   449: astore 6
    //   451: aload_0
    //   452: getfield 29	com/tencent/mm/sandbox/updater/b$a:nfp	Lcom/tencent/mm/network/u;
    //   455: invokevirtual 240	com/tencent/mm/network/u:getInputStream	()Ljava/io/InputStream;
    //   458: astore 8
    //   460: ldc2_w 190
    //   463: lstore 4
    //   465: aload 6
    //   467: ifnull +597 -> 1064
    //   470: aload 6
    //   472: ldc 242
    //   474: invokevirtual 248	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   477: ifeq +587 -> 1064
    //   480: new 250	java/util/zip/GZIPInputStream
    //   483: dup
    //   484: aload 8
    //   486: invokespecial 253	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   489: astore 6
    //   491: iconst_1
    //   492: istore_2
    //   493: new 255	java/io/ByteArrayOutputStream
    //   496: dup
    //   497: invokespecial 256	java/io/ByteArrayOutputStream:<init>	()V
    //   500: astore 7
    //   502: sipush 1024
    //   505: newarray byte
    //   507: astore 9
    //   509: aload 6
    //   511: aload 9
    //   513: invokevirtual 262	java/io/InputStream:read	([B)I
    //   516: istore_3
    //   517: iload_3
    //   518: ifle +22 -> 540
    //   521: aload 7
    //   523: aload 9
    //   525: iconst_0
    //   526: iload_3
    //   527: invokevirtual 265	java/io/ByteArrayOutputStream:write	([BII)V
    //   530: lload 4
    //   532: iload_3
    //   533: i2l
    //   534: ladd
    //   535: lstore 4
    //   537: goto -28 -> 509
    //   540: iload_2
    //   541: ifeq +200 -> 741
    //   544: aload 8
    //   546: invokevirtual 269	java/io/InputStream:markSupported	()Z
    //   549: ifeq +192 -> 741
    //   552: aload 8
    //   554: iconst_1
    //   555: invokevirtual 272	java/io/InputStream:mark	(I)V
    //   558: ldc2_w 190
    //   561: lstore 4
    //   563: aload 8
    //   565: aload 9
    //   567: invokevirtual 262	java/io/InputStream:read	([B)I
    //   570: istore_2
    //   571: iload_2
    //   572: ifle +13 -> 585
    //   575: lload 4
    //   577: iload_2
    //   578: i2l
    //   579: ladd
    //   580: lstore 4
    //   582: goto -19 -> 563
    //   585: aload_0
    //   586: getfield 40	com/tencent/mm/sandbox/updater/b$a:ucm	Lcom/tencent/mm/sandbox/b$a;
    //   589: lload 4
    //   591: invokeinterface 275 3 0
    //   596: new 71	com/tencent/mm/pointers/PByteArray
    //   599: dup
    //   600: invokespecial 72	com/tencent/mm/pointers/PByteArray:<init>	()V
    //   603: astore 8
    //   605: new 71	com/tencent/mm/pointers/PByteArray
    //   608: dup
    //   609: invokespecial 72	com/tencent/mm/pointers/PByteArray:<init>	()V
    //   612: astore 9
    //   614: new 33	com/tencent/mm/pointers/PInt
    //   617: dup
    //   618: invokespecial 34	com/tencent/mm/pointers/PInt:<init>	()V
    //   621: astore 10
    //   623: new 33	com/tencent/mm/pointers/PInt
    //   626: dup
    //   627: iconst_0
    //   628: invokespecial 277	com/tencent/mm/pointers/PInt:<init>	(I)V
    //   631: astore 11
    //   633: new 33	com/tencent/mm/pointers/PInt
    //   636: dup
    //   637: sipush 255
    //   640: invokespecial 277	com/tencent/mm/pointers/PInt:<init>	(I)V
    //   643: astore 12
    //   645: aload 8
    //   647: aload 7
    //   649: invokevirtual 278	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   652: aload_0
    //   653: getfield 24	com/tencent/mm/sandbox/updater/b$a:ucp	Lcom/tencent/mm/sandbox/updater/b;
    //   656: invokestatic 88	com/tencent/mm/sandbox/updater/b:j	(Lcom/tencent/mm/sandbox/updater/b;)[B
    //   659: aload 9
    //   661: aload_0
    //   662: getfield 36	com/tencent/mm/sandbox/updater/b$a:ucr	Lcom/tencent/mm/pointers/PInt;
    //   665: aload 10
    //   667: aload 11
    //   669: aload 12
    //   671: invokestatic 282	com/tencent/mm/protocal/MMProtocalJni:unpack	(Lcom/tencent/mm/pointers/PByteArray;[B[BLcom/tencent/mm/pointers/PByteArray;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;)Z
    //   674: pop
    //   675: new 284	com/tencent/mm/protocal/c/aln
    //   678: dup
    //   679: invokespecial 285	com/tencent/mm/protocal/c/aln:<init>	()V
    //   682: aload 8
    //   684: getfield 180	com/tencent/mm/pointers/PByteArray:value	[B
    //   687: invokevirtual 289	com/tencent/mm/protocal/c/aln:aH	([B)Lcom/tencent/mm/bv/a;
    //   690: checkcast 284	com/tencent/mm/protocal/c/aln
    //   693: astore 7
    //   695: aload_1
    //   696: ifnull +7 -> 703
    //   699: aload_1
    //   700: invokevirtual 204	java/io/OutputStream:close	()V
    //   703: aload 6
    //   705: ifnull +8 -> 713
    //   708: aload 6
    //   710: invokevirtual 290	java/io/InputStream:close	()V
    //   713: aload 7
    //   715: astore_1
    //   716: aload_0
    //   717: getfield 29	com/tencent/mm/sandbox/updater/b$a:nfp	Lcom/tencent/mm/network/u;
    //   720: ifnull -702 -> 18
    //   723: aload_0
    //   724: getfield 29	com/tencent/mm/sandbox/updater/b$a:nfp	Lcom/tencent/mm/network/u;
    //   727: getfield 208	com/tencent/mm/network/u:aRG	Ljava/net/HttpURLConnection;
    //   730: invokevirtual 213	java/net/HttpURLConnection:disconnect	()V
    //   733: aload_0
    //   734: aconst_null
    //   735: putfield 29	com/tencent/mm/sandbox/updater/b$a:nfp	Lcom/tencent/mm/network/u;
    //   738: aload 7
    //   740: areturn
    //   741: aload_0
    //   742: getfield 40	com/tencent/mm/sandbox/updater/b$a:ucm	Lcom/tencent/mm/sandbox/b$a;
    //   745: lload 4
    //   747: invokeinterface 275 3 0
    //   752: goto -156 -> 596
    //   755: astore 8
    //   757: aload 6
    //   759: astore 7
    //   761: aload_1
    //   762: astore 6
    //   764: aload 7
    //   766: astore_1
    //   767: aload 8
    //   769: astore 7
    //   771: ldc 48
    //   773: ldc_w 292
    //   776: iconst_1
    //   777: anewarray 217	java/lang/Object
    //   780: dup
    //   781: iconst_0
    //   782: aload 7
    //   784: invokevirtual 220	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   787: aastore
    //   788: invokestatic 224	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   791: ldc 48
    //   793: aload 7
    //   795: ldc 226
    //   797: iconst_0
    //   798: anewarray 217	java/lang/Object
    //   801: invokestatic 230	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   804: aload_0
    //   805: iconst_m1
    //   806: putfield 31	com/tencent/mm/sandbox/updater/b$a:ucq	I
    //   809: aload 6
    //   811: ifnull +8 -> 819
    //   814: aload 6
    //   816: invokevirtual 204	java/io/OutputStream:close	()V
    //   819: aload_1
    //   820: ifnull +7 -> 827
    //   823: aload_1
    //   824: invokevirtual 290	java/io/InputStream:close	()V
    //   827: aload_0
    //   828: getfield 29	com/tencent/mm/sandbox/updater/b$a:nfp	Lcom/tencent/mm/network/u;
    //   831: ifnull +18 -> 849
    //   834: aload_0
    //   835: getfield 29	com/tencent/mm/sandbox/updater/b$a:nfp	Lcom/tencent/mm/network/u;
    //   838: getfield 208	com/tencent/mm/network/u:aRG	Ljava/net/HttpURLConnection;
    //   841: invokevirtual 213	java/net/HttpURLConnection:disconnect	()V
    //   844: aload_0
    //   845: aconst_null
    //   846: putfield 29	com/tencent/mm/sandbox/updater/b$a:nfp	Lcom/tencent/mm/network/u;
    //   849: aconst_null
    //   850: areturn
    //   851: astore_1
    //   852: ldc 48
    //   854: aload_1
    //   855: ldc 226
    //   857: iconst_0
    //   858: anewarray 217	java/lang/Object
    //   861: invokestatic 230	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   864: goto -161 -> 703
    //   867: astore_1
    //   868: ldc 48
    //   870: aload_1
    //   871: ldc 226
    //   873: iconst_0
    //   874: anewarray 217	java/lang/Object
    //   877: invokestatic 230	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   880: goto -167 -> 713
    //   883: astore 6
    //   885: ldc 48
    //   887: aload 6
    //   889: ldc 226
    //   891: iconst_0
    //   892: anewarray 217	java/lang/Object
    //   895: invokestatic 230	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   898: goto -79 -> 819
    //   901: astore_1
    //   902: ldc 48
    //   904: aload_1
    //   905: ldc 226
    //   907: iconst_0
    //   908: anewarray 217	java/lang/Object
    //   911: invokestatic 230	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   914: goto -87 -> 827
    //   917: astore_1
    //   918: aload 8
    //   920: astore 6
    //   922: aload 6
    //   924: ifnull +8 -> 932
    //   927: aload 6
    //   929: invokevirtual 204	java/io/OutputStream:close	()V
    //   932: aload 7
    //   934: ifnull +8 -> 942
    //   937: aload 7
    //   939: invokevirtual 290	java/io/InputStream:close	()V
    //   942: aload_0
    //   943: getfield 29	com/tencent/mm/sandbox/updater/b$a:nfp	Lcom/tencent/mm/network/u;
    //   946: ifnull +18 -> 964
    //   949: aload_0
    //   950: getfield 29	com/tencent/mm/sandbox/updater/b$a:nfp	Lcom/tencent/mm/network/u;
    //   953: getfield 208	com/tencent/mm/network/u:aRG	Ljava/net/HttpURLConnection;
    //   956: invokevirtual 213	java/net/HttpURLConnection:disconnect	()V
    //   959: aload_0
    //   960: aconst_null
    //   961: putfield 29	com/tencent/mm/sandbox/updater/b$a:nfp	Lcom/tencent/mm/network/u;
    //   964: aload_1
    //   965: athrow
    //   966: astore 6
    //   968: ldc 48
    //   970: aload 6
    //   972: ldc 226
    //   974: iconst_0
    //   975: anewarray 217	java/lang/Object
    //   978: invokestatic 230	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   981: goto -49 -> 932
    //   984: astore 6
    //   986: ldc 48
    //   988: aload 6
    //   990: ldc 226
    //   992: iconst_0
    //   993: anewarray 217	java/lang/Object
    //   996: invokestatic 230	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   999: goto -57 -> 942
    //   1002: astore 8
    //   1004: aload_1
    //   1005: astore 6
    //   1007: aload 8
    //   1009: astore_1
    //   1010: goto -88 -> 922
    //   1013: astore 7
    //   1015: aload_1
    //   1016: astore 8
    //   1018: aload 7
    //   1020: astore_1
    //   1021: aload 6
    //   1023: astore 7
    //   1025: aload 8
    //   1027: astore 6
    //   1029: goto -107 -> 922
    //   1032: astore 8
    //   1034: aload_1
    //   1035: astore 7
    //   1037: aload 8
    //   1039: astore_1
    //   1040: goto -118 -> 922
    //   1043: astore 7
    //   1045: aconst_null
    //   1046: astore_1
    //   1047: goto -276 -> 771
    //   1050: astore 7
    //   1052: aconst_null
    //   1053: astore 8
    //   1055: aload_1
    //   1056: astore 6
    //   1058: aload 8
    //   1060: astore_1
    //   1061: goto -290 -> 771
    //   1064: iconst_0
    //   1065: istore_2
    //   1066: aload 8
    //   1068: astore 6
    //   1070: goto -577 -> 493
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1073	0	this	a
    //   0	1073	1	paramVarArgs	alm[]
    //   58	1008	2	i	int
    //   103	430	3	j	int
    //   463	283	4	l	long
    //   80	735	6	localObject1	java.lang.Object
    //   883	5	6	localIOException1	java.io.IOException
    //   920	8	6	localObject2	java.lang.Object
    //   966	5	6	localIOException2	java.io.IOException
    //   984	5	6	localIOException3	java.io.IOException
    //   1005	64	6	localObject3	java.lang.Object
    //   89	849	7	localObject4	java.lang.Object
    //   1013	6	7	localObject5	java.lang.Object
    //   1023	13	7	localObject6	java.lang.Object
    //   1043	1	7	localException1	java.lang.Exception
    //   1050	1	7	localException2	java.lang.Exception
    //   94	589	8	localObject7	java.lang.Object
    //   755	164	8	localException3	java.lang.Exception
    //   1002	6	8	localObject8	java.lang.Object
    //   1016	10	8	arrayOfalm	alm[]
    //   1032	6	8	localObject9	java.lang.Object
    //   1053	14	8	localObject10	java.lang.Object
    //   54	606	9	localObject11	java.lang.Object
    //   111	555	10	localObject12	java.lang.Object
    //   631	37	11	localPInt1	PInt
    //   643	27	12	localPInt2	PInt
    // Exception table:
    //   from	to	target	type
    //   68	140	391	java/lang/Exception
    //   363	367	424	java/io/IOException
    //   493	509	755	java/lang/Exception
    //   509	517	755	java/lang/Exception
    //   521	530	755	java/lang/Exception
    //   544	558	755	java/lang/Exception
    //   563	571	755	java/lang/Exception
    //   585	596	755	java/lang/Exception
    //   596	695	755	java/lang/Exception
    //   741	752	755	java/lang/Exception
    //   699	703	851	java/io/IOException
    //   708	713	867	java/io/IOException
    //   814	819	883	java/io/IOException
    //   823	827	901	java/io/IOException
    //   149	303	917	finally
    //   927	932	966	java/io/IOException
    //   937	942	984	java/io/IOException
    //   303	352	1002	finally
    //   440	460	1002	finally
    //   470	491	1002	finally
    //   493	509	1013	finally
    //   509	517	1013	finally
    //   521	530	1013	finally
    //   544	558	1013	finally
    //   563	571	1013	finally
    //   585	596	1013	finally
    //   596	695	1013	finally
    //   741	752	1013	finally
    //   771	809	1032	finally
    //   149	303	1043	java/lang/Exception
    //   303	352	1050	java/lang/Exception
    //   440	460	1050	java/lang/Exception
    //   470	491	1050	java/lang/Exception
  }
  
  protected final void onCancelled()
  {
    y.d("MicroMsg.NetSceneGetUpdatePack", "task had been cancelled.");
    if (this.nfp != null) {
      this.nfp.aRG.disconnect();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.b.a
 * JD-Core Version:    0.7.0.1
 */