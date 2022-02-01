package okhttp3.internal.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.a;
import okhttp3.r;
import okhttp3.s;
import okhttp3.u;
import okhttp3.x;
import okhttp3.z;

public final class j
  implements s
{
  private final u ajNB;
  private final boolean ajNG;
  public Object ajPC;
  public volatile okhttp3.internal.b.g ajPO;
  public volatile boolean oLU;
  
  public j(u paramu, boolean paramBoolean)
  {
    this.ajNB = paramu;
    this.ajNG = paramBoolean;
  }
  
  private static int a(z paramz, int paramInt)
  {
    AppMethodBeat.i(186829);
    paramz = paramz.bKv("Retry-After");
    if (paramz == null)
    {
      AppMethodBeat.o(186829);
      return paramInt;
    }
    if (paramz.matches("\\d+"))
    {
      paramInt = Integer.valueOf(paramz).intValue();
      AppMethodBeat.o(186829);
      return paramInt;
    }
    AppMethodBeat.o(186829);
    return 2147483647;
  }
  
  private boolean a(IOException paramIOException, okhttp3.internal.b.g paramg, boolean paramBoolean, x paramx)
  {
    AppMethodBeat.i(186807);
    paramg.e(paramIOException);
    if (!this.ajNB.ajNq)
    {
      AppMethodBeat.o(186807);
      return false;
    }
    if ((paramBoolean) && (a(paramIOException, paramx)))
    {
      AppMethodBeat.o(186807);
      return false;
    }
    if (!a(paramIOException, paramBoolean))
    {
      AppMethodBeat.o(186807);
      return false;
    }
    if (!paramg.kHC())
    {
      AppMethodBeat.o(186807);
      return false;
    }
    AppMethodBeat.o(186807);
    return true;
  }
  
  private static boolean a(IOException paramIOException, x paramx)
  {
    return ((paramx.ajNK instanceof l)) || ((paramIOException instanceof FileNotFoundException));
  }
  
  private static boolean a(IOException paramIOException, boolean paramBoolean)
  {
    AppMethodBeat.i(186824);
    if ((paramIOException instanceof ProtocolException))
    {
      AppMethodBeat.o(186824);
      return false;
    }
    if ((paramIOException instanceof InterruptedIOException))
    {
      if (((paramIOException instanceof SocketTimeoutException)) && (!paramBoolean))
      {
        AppMethodBeat.o(186824);
        return true;
      }
      AppMethodBeat.o(186824);
      return false;
    }
    if (((paramIOException instanceof SSLHandshakeException)) && ((paramIOException.getCause() instanceof CertificateException)))
    {
      AppMethodBeat.o(186824);
      return false;
    }
    if ((paramIOException instanceof SSLPeerUnverifiedException))
    {
      AppMethodBeat.o(186824);
      return false;
    }
    AppMethodBeat.o(186824);
    return true;
  }
  
  private static boolean a(z paramz, r paramr)
  {
    AppMethodBeat.i(186837);
    paramz = paramz.ajNQ.ajIN;
    if ((paramz.host.equals(paramr.host)) && (paramz.port == paramr.port) && (paramz.scheme.equals(paramr.scheme)))
    {
      AppMethodBeat.o(186837);
      return true;
    }
    AppMethodBeat.o(186837);
    return false;
  }
  
  private a e(r paramr)
  {
    AppMethodBeat.i(186799);
    SSLSocketFactory localSSLSocketFactory;
    HostnameVerifier localHostnameVerifier;
    okhttp3.g localg;
    if (paramr.isHttps())
    {
      localSSLSocketFactory = this.ajNB.ajIU;
      localHostnameVerifier = this.ajNB.ajIV;
      localg = this.ajNB.ajIW;
    }
    for (;;)
    {
      paramr = new a(paramr.host, paramr.port, this.ajNB.ajIO, this.ajNB.ajIP, localSSLSocketFactory, localHostnameVerifier, localg, this.ajNB.ajIQ, this.ajNB.uuH, this.ajNB.ajIR, this.ajNB.ajIS, this.ajNB.ajIT);
      AppMethodBeat.o(186799);
      return paramr;
      localg = null;
      localHostnameVerifier = null;
      localSSLSocketFactory = null;
    }
  }
  
  /* Error */
  public final z a(okhttp3.s.a parama)
  {
    // Byte code:
    //   0: ldc 196
    //   2: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokeinterface 202 1 0
    //   11: astore 6
    //   13: aload_1
    //   14: checkcast 204	okhttp3/internal/c/g
    //   17: astore 8
    //   19: aload 8
    //   21: getfield 208	okhttp3/internal/c/g:cqs	Lokhttp3/e;
    //   24: astore 9
    //   26: aload 8
    //   28: getfield 212	okhttp3/internal/c/g:ajNE	Lokhttp3/o;
    //   31: astore 10
    //   33: new 68	okhttp3/internal/b/g
    //   36: dup
    //   37: aload_0
    //   38: getfield 22	okhttp3/internal/c/j:ajNB	Lokhttp3/u;
    //   41: getfield 216	okhttp3/u:ajNn	Lokhttp3/i;
    //   44: aload_0
    //   45: aload 6
    //   47: getfield 126	okhttp3/x:ajIN	Lokhttp3/r;
    //   50: invokespecial 218	okhttp3/internal/c/j:e	(Lokhttp3/r;)Lokhttp3/a;
    //   53: aload 9
    //   55: aload 10
    //   57: aload_0
    //   58: getfield 220	okhttp3/internal/c/j:ajPC	Ljava/lang/Object;
    //   61: invokespecial 223	okhttp3/internal/b/g:<init>	(Lokhttp3/i;Lokhttp3/a;Lokhttp3/e;Lokhttp3/o;Ljava/lang/Object;)V
    //   64: astore 5
    //   66: aload_0
    //   67: aload 5
    //   69: putfield 225	okhttp3/internal/c/j:ajPO	Lokhttp3/internal/b/g;
    //   72: aconst_null
    //   73: astore 7
    //   75: iconst_0
    //   76: istore_2
    //   77: aload 6
    //   79: astore_1
    //   80: aload_0
    //   81: getfield 227	okhttp3/internal/c/j:oLU	Z
    //   84: ifeq +25 -> 109
    //   87: aload 5
    //   89: invokevirtual 230	okhttp3/internal/b/g:release	()V
    //   92: new 108	java/io/IOException
    //   95: dup
    //   96: ldc 232
    //   98: invokespecial 235	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   101: astore_1
    //   102: ldc 196
    //   104: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: aload_1
    //   108: athrow
    //   109: aload 8
    //   111: aload_1
    //   112: aload 5
    //   114: aconst_null
    //   115: aconst_null
    //   116: invokevirtual 238	okhttp3/internal/c/g:a	(Lokhttp3/x;Lokhttp3/internal/b/g;Lokhttp3/internal/c/c;Lokhttp3/internal/b/c;)Lokhttp3/z;
    //   119: astore 6
    //   121: aload 6
    //   123: astore_1
    //   124: aload_1
    //   125: astore 6
    //   127: aload 7
    //   129: ifnull +162 -> 291
    //   132: aload_1
    //   133: invokevirtual 242	okhttp3/z:kHi	()Lokhttp3/z$a;
    //   136: astore_1
    //   137: aload 7
    //   139: invokevirtual 242	okhttp3/z:kHi	()Lokhttp3/z$a;
    //   142: astore 6
    //   144: aload 6
    //   146: aconst_null
    //   147: putfield 248	okhttp3/z$a:ajNR	Lokhttp3/aa;
    //   150: aload 6
    //   152: invokevirtual 252	okhttp3/z$a:kHj	()Lokhttp3/z;
    //   155: astore 6
    //   157: aload 6
    //   159: ifnull +120 -> 279
    //   162: aload 6
    //   164: getfield 253	okhttp3/z:ajNR	Lokhttp3/aa;
    //   167: ifnull +112 -> 279
    //   170: new 255	java/lang/IllegalArgumentException
    //   173: dup
    //   174: ldc_w 257
    //   177: invokespecial 258	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   180: astore_1
    //   181: ldc 196
    //   183: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   186: aload_1
    //   187: athrow
    //   188: astore 6
    //   190: aload_0
    //   191: aload 6
    //   193: getfield 262	okhttp3/internal/b/e:ajPu	Ljava/io/IOException;
    //   196: aload 5
    //   198: iconst_0
    //   199: aload_1
    //   200: invokespecial 264	okhttp3/internal/c/j:a	(Ljava/io/IOException;Lokhttp3/internal/b/g;ZLokhttp3/x;)Z
    //   203: ifne -123 -> 80
    //   206: aload 6
    //   208: getfield 267	okhttp3/internal/b/e:ajPt	Ljava/io/IOException;
    //   211: astore_1
    //   212: ldc 196
    //   214: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   217: aload_1
    //   218: athrow
    //   219: astore_1
    //   220: aload 5
    //   222: aconst_null
    //   223: invokevirtual 72	okhttp3/internal/b/g:e	(Ljava/io/IOException;)V
    //   226: aload 5
    //   228: invokevirtual 230	okhttp3/internal/b/g:release	()V
    //   231: ldc 196
    //   233: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   236: aload_1
    //   237: athrow
    //   238: astore 6
    //   240: aload 6
    //   242: instanceof 269
    //   245: ifne +28 -> 273
    //   248: iconst_1
    //   249: istore 4
    //   251: aload_0
    //   252: aload 6
    //   254: aload 5
    //   256: iload 4
    //   258: aload_1
    //   259: invokespecial 264	okhttp3/internal/c/j:a	(Ljava/io/IOException;Lokhttp3/internal/b/g;ZLokhttp3/x;)Z
    //   262: ifne -182 -> 80
    //   265: ldc 196
    //   267: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   270: aload 6
    //   272: athrow
    //   273: iconst_0
    //   274: istore 4
    //   276: goto -25 -> 251
    //   279: aload_1
    //   280: aload 6
    //   282: putfield 273	okhttp3/z$a:ajNU	Lokhttp3/z;
    //   285: aload_1
    //   286: invokevirtual 252	okhttp3/z$a:kHj	()Lokhttp3/z;
    //   289: astore 6
    //   291: aload 5
    //   293: getfield 277	okhttp3/internal/b/g:ajPk	Lokhttp3/ab;
    //   296: astore_1
    //   297: aload 6
    //   299: ifnonnull +31 -> 330
    //   302: new 279	java/lang/IllegalStateException
    //   305: dup
    //   306: invokespecial 280	java/lang/IllegalStateException:<init>	()V
    //   309: astore_1
    //   310: ldc 196
    //   312: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   315: aload_1
    //   316: athrow
    //   317: astore_1
    //   318: aload 5
    //   320: invokevirtual 230	okhttp3/internal/b/g:release	()V
    //   323: ldc 196
    //   325: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   328: aload_1
    //   329: athrow
    //   330: aload 6
    //   332: getfield 283	okhttp3/z:code	I
    //   335: istore_3
    //   336: aload 6
    //   338: getfield 122	okhttp3/z:ajNQ	Lokhttp3/x;
    //   341: getfield 286	okhttp3/x:method	Ljava/lang/String;
    //   344: astore 11
    //   346: iload_3
    //   347: lookupswitch	default:+89->436, 300:+193->540, 301:+193->540, 302:+193->540, 303:+193->540, 307:+171->518, 308:+171->518, 401:+155->502, 407:+108->455, 408:+419->766, 503:+483->830
    //   437: astore_1
    //   438: aload_1
    //   439: ifnonnull +437 -> 876
    //   442: aload 5
    //   444: invokevirtual 230	okhttp3/internal/b/g:release	()V
    //   447: ldc 196
    //   449: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   452: aload 6
    //   454: areturn
    //   455: aload_1
    //   456: getfield 289	okhttp3/ab:uuH	Ljava/net/Proxy;
    //   459: invokevirtual 295	java/net/Proxy:type	()Ljava/net/Proxy$Type;
    //   462: getstatic 301	java/net/Proxy$Type:HTTP	Ljava/net/Proxy$Type;
    //   465: if_acmpeq +21 -> 486
    //   468: new 100	java/net/ProtocolException
    //   471: dup
    //   472: ldc_w 303
    //   475: invokespecial 304	java/net/ProtocolException:<init>	(Ljava/lang/String;)V
    //   478: astore_1
    //   479: ldc 196
    //   481: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   484: aload_1
    //   485: athrow
    //   486: aload_0
    //   487: getfield 22	okhttp3/internal/c/j:ajNB	Lokhttp3/u;
    //   490: getfield 174	okhttp3/u:ajIQ	Lokhttp3/b;
    //   493: invokeinterface 309 1 0
    //   498: astore_1
    //   499: goto -61 -> 438
    //   502: aload_0
    //   503: getfield 22	okhttp3/internal/c/j:ajNB	Lokhttp3/u;
    //   506: getfield 312	okhttp3/u:ajNm	Lokhttp3/b;
    //   509: invokeinterface 309 1 0
    //   514: astore_1
    //   515: goto -77 -> 438
    //   518: aload 11
    //   520: ldc_w 314
    //   523: invokevirtual 136	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   526: ifne +14 -> 540
    //   529: aload 11
    //   531: ldc_w 316
    //   534: invokevirtual 136	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   537: ifeq -101 -> 436
    //   540: aload_0
    //   541: getfield 22	okhttp3/internal/c/j:ajNB	Lokhttp3/u;
    //   544: getfield 319	okhttp3/u:ajNp	Z
    //   547: ifeq -111 -> 436
    //   550: aload 6
    //   552: ldc_w 321
    //   555: invokevirtual 42	okhttp3/z:bKv	(Ljava/lang/String;)Ljava/lang/String;
    //   558: astore_1
    //   559: aload_1
    //   560: ifnull -124 -> 436
    //   563: aload 6
    //   565: getfield 122	okhttp3/z:ajNQ	Lokhttp3/x;
    //   568: getfield 126	okhttp3/x:ajIN	Lokhttp3/r;
    //   571: aload_1
    //   572: invokevirtual 325	okhttp3/r:bKq	(Ljava/lang/String;)Lokhttp3/r$a;
    //   575: astore_1
    //   576: aload_1
    //   577: ifnull +497 -> 1074
    //   580: aload_1
    //   581: invokevirtual 331	okhttp3/r$a:kGU	()Lokhttp3/r;
    //   584: astore_1
    //   585: aload_1
    //   586: ifnull -150 -> 436
    //   589: aload_1
    //   590: getfield 143	okhttp3/r:scheme	Ljava/lang/String;
    //   593: aload 6
    //   595: getfield 122	okhttp3/z:ajNQ	Lokhttp3/x;
    //   598: getfield 126	okhttp3/x:ajIN	Lokhttp3/r;
    //   601: getfield 143	okhttp3/r:scheme	Ljava/lang/String;
    //   604: invokevirtual 136	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   607: ifne +13 -> 620
    //   610: aload_0
    //   611: getfield 22	okhttp3/internal/c/j:ajNB	Lokhttp3/u;
    //   614: getfield 334	okhttp3/u:ajNo	Z
    //   617: ifeq -181 -> 436
    //   620: aload 6
    //   622: getfield 122	okhttp3/z:ajNQ	Lokhttp3/x;
    //   625: invokevirtual 338	okhttp3/x:kHf	()Lokhttp3/x$a;
    //   628: astore 12
    //   630: aload 11
    //   632: invokestatic 343	okhttp3/internal/c/f:bKI	(Ljava/lang/String;)Z
    //   635: ifeq +72 -> 707
    //   638: aload 11
    //   640: ldc_w 345
    //   643: invokevirtual 136	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   646: istore 4
    //   648: aload 11
    //   650: ldc_w 345
    //   653: invokevirtual 136	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   656: ifne +423 -> 1079
    //   659: iconst_1
    //   660: istore_3
    //   661: iload_3
    //   662: ifeq +76 -> 738
    //   665: aload 12
    //   667: ldc_w 314
    //   670: aconst_null
    //   671: invokevirtual 350	okhttp3/x$a:a	(Ljava/lang/String;Lokhttp3/y;)Lokhttp3/x$a;
    //   674: pop
    //   675: iload 4
    //   677: ifne +30 -> 707
    //   680: aload 12
    //   682: ldc_w 352
    //   685: invokevirtual 356	okhttp3/x$a:bKw	(Ljava/lang/String;)Lokhttp3/x$a;
    //   688: pop
    //   689: aload 12
    //   691: ldc_w 358
    //   694: invokevirtual 356	okhttp3/x$a:bKw	(Ljava/lang/String;)Lokhttp3/x$a;
    //   697: pop
    //   698: aload 12
    //   700: ldc_w 360
    //   703: invokevirtual 356	okhttp3/x$a:bKw	(Ljava/lang/String;)Lokhttp3/x$a;
    //   706: pop
    //   707: aload 6
    //   709: aload_1
    //   710: invokestatic 362	okhttp3/internal/c/j:a	(Lokhttp3/z;Lokhttp3/r;)Z
    //   713: ifne +12 -> 725
    //   716: aload 12
    //   718: ldc_w 364
    //   721: invokevirtual 356	okhttp3/x$a:bKw	(Ljava/lang/String;)Lokhttp3/x$a;
    //   724: pop
    //   725: aload 12
    //   727: aload_1
    //   728: invokevirtual 368	okhttp3/x$a:b	(Lokhttp3/r;)Lokhttp3/x$a;
    //   731: invokevirtual 371	okhttp3/x$a:kHh	()Lokhttp3/x;
    //   734: astore_1
    //   735: goto -297 -> 438
    //   738: iload 4
    //   740: ifeq +344 -> 1084
    //   743: aload 6
    //   745: getfield 122	okhttp3/z:ajNQ	Lokhttp3/x;
    //   748: getfield 93	okhttp3/x:ajNK	Lokhttp3/y;
    //   751: astore 7
    //   753: aload 12
    //   755: aload 11
    //   757: aload 7
    //   759: invokevirtual 350	okhttp3/x$a:a	(Ljava/lang/String;Lokhttp3/y;)Lokhttp3/x$a;
    //   762: pop
    //   763: goto -88 -> 675
    //   766: aload_0
    //   767: getfield 22	okhttp3/internal/c/j:ajNB	Lokhttp3/u;
    //   770: getfield 77	okhttp3/u:ajNq	Z
    //   773: ifeq -337 -> 436
    //   776: aload 6
    //   778: getfield 122	okhttp3/z:ajNQ	Lokhttp3/x;
    //   781: getfield 93	okhttp3/x:ajNK	Lokhttp3/y;
    //   784: instanceof 95
    //   787: ifne -351 -> 436
    //   790: aload 6
    //   792: getfield 372	okhttp3/z:ajNU	Lokhttp3/z;
    //   795: ifnull +17 -> 812
    //   798: aload 6
    //   800: getfield 372	okhttp3/z:ajNU	Lokhttp3/z;
    //   803: getfield 283	okhttp3/z:code	I
    //   806: sipush 408
    //   809: if_icmpeq -373 -> 436
    //   812: aload 6
    //   814: iconst_0
    //   815: invokestatic 374	okhttp3/internal/c/j:a	(Lokhttp3/z;I)I
    //   818: ifgt -382 -> 436
    //   821: aload 6
    //   823: getfield 122	okhttp3/z:ajNQ	Lokhttp3/x;
    //   826: astore_1
    //   827: goto -389 -> 438
    //   830: aload 6
    //   832: getfield 372	okhttp3/z:ajNU	Lokhttp3/z;
    //   835: ifnull +17 -> 852
    //   838: aload 6
    //   840: getfield 372	okhttp3/z:ajNU	Lokhttp3/z;
    //   843: getfield 283	okhttp3/z:code	I
    //   846: sipush 503
    //   849: if_icmpeq -413 -> 436
    //   852: aload 6
    //   854: ldc 64
    //   856: invokestatic 374	okhttp3/internal/c/j:a	(Lokhttp3/z;I)I
    //   859: ifne +12 -> 871
    //   862: aload 6
    //   864: getfield 122	okhttp3/z:ajNQ	Lokhttp3/x;
    //   867: astore_1
    //   868: goto -430 -> 438
    //   871: aconst_null
    //   872: astore_1
    //   873: goto -435 -> 438
    //   876: aload 6
    //   878: getfield 253	okhttp3/z:ajNR	Lokhttp3/aa;
    //   881: invokestatic 380	okhttp3/internal/c:closeQuietly	(Ljava/io/Closeable;)V
    //   884: iload_2
    //   885: iconst_1
    //   886: iadd
    //   887: istore_2
    //   888: iload_2
    //   889: bipush 20
    //   891: if_icmple +33 -> 924
    //   894: aload 5
    //   896: invokevirtual 230	okhttp3/internal/b/g:release	()V
    //   899: new 100	java/net/ProtocolException
    //   902: dup
    //   903: ldc_w 382
    //   906: iload_2
    //   907: invokestatic 385	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   910: invokevirtual 388	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   913: invokespecial 304	java/net/ProtocolException:<init>	(Ljava/lang/String;)V
    //   916: astore_1
    //   917: ldc 196
    //   919: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   922: aload_1
    //   923: athrow
    //   924: aload_1
    //   925: getfield 93	okhttp3/x:ajNK	Lokhttp3/y;
    //   928: instanceof 95
    //   931: ifeq +31 -> 962
    //   934: aload 5
    //   936: invokevirtual 230	okhttp3/internal/b/g:release	()V
    //   939: new 390	java/net/HttpRetryException
    //   942: dup
    //   943: ldc_w 392
    //   946: aload 6
    //   948: getfield 283	okhttp3/z:code	I
    //   951: invokespecial 395	java/net/HttpRetryException:<init>	(Ljava/lang/String;I)V
    //   954: astore_1
    //   955: ldc 196
    //   957: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   960: aload_1
    //   961: athrow
    //   962: aload 6
    //   964: aload_1
    //   965: getfield 126	okhttp3/x:ajIN	Lokhttp3/r;
    //   968: invokestatic 362	okhttp3/internal/c/j:a	(Lokhttp3/z;Lokhttp3/r;)Z
    //   971: ifne +53 -> 1024
    //   974: aload 5
    //   976: invokevirtual 230	okhttp3/internal/b/g:release	()V
    //   979: new 68	okhttp3/internal/b/g
    //   982: dup
    //   983: aload_0
    //   984: getfield 22	okhttp3/internal/c/j:ajNB	Lokhttp3/u;
    //   987: getfield 216	okhttp3/u:ajNn	Lokhttp3/i;
    //   990: aload_0
    //   991: aload_1
    //   992: getfield 126	okhttp3/x:ajIN	Lokhttp3/r;
    //   995: invokespecial 218	okhttp3/internal/c/j:e	(Lokhttp3/r;)Lokhttp3/a;
    //   998: aload 9
    //   1000: aload 10
    //   1002: aload_0
    //   1003: getfield 220	okhttp3/internal/c/j:ajPC	Ljava/lang/Object;
    //   1006: invokespecial 223	okhttp3/internal/b/g:<init>	(Lokhttp3/i;Lokhttp3/a;Lokhttp3/e;Lokhttp3/o;Ljava/lang/Object;)V
    //   1009: astore 5
    //   1011: aload_0
    //   1012: aload 5
    //   1014: putfield 225	okhttp3/internal/c/j:ajPO	Lokhttp3/internal/b/g;
    //   1017: aload 6
    //   1019: astore 7
    //   1021: goto -941 -> 80
    //   1024: aload 5
    //   1026: invokevirtual 399	okhttp3/internal/b/g:kHy	()Lokhttp3/internal/c/c;
    //   1029: ifnull +42 -> 1071
    //   1032: new 279	java/lang/IllegalStateException
    //   1035: dup
    //   1036: new 401	java/lang/StringBuilder
    //   1039: dup
    //   1040: ldc_w 403
    //   1043: invokespecial 404	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1046: aload 6
    //   1048: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1051: ldc_w 410
    //   1054: invokevirtual 413	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1057: invokevirtual 417	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1060: invokespecial 418	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   1063: astore_1
    //   1064: ldc 196
    //   1066: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1069: aload_1
    //   1070: athrow
    //   1071: goto -54 -> 1017
    //   1074: aconst_null
    //   1075: astore_1
    //   1076: goto -491 -> 585
    //   1079: iconst_0
    //   1080: istore_3
    //   1081: goto -420 -> 661
    //   1084: aconst_null
    //   1085: astore 7
    //   1087: goto -334 -> 753
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1090	0	this	j
    //   0	1090	1	parama	okhttp3.s.a
    //   76	831	2	i	int
    //   335	746	3	j	int
    //   249	490	4	bool	boolean
    //   64	961	5	localg	okhttp3.internal.b.g
    //   11	152	6	localObject1	Object
    //   188	19	6	locale	okhttp3.internal.b.e
    //   238	43	6	localIOException	IOException
    //   289	758	6	localz	z
    //   73	1013	7	localObject2	Object
    //   17	93	8	localg1	g
    //   24	975	9	locale1	okhttp3.e
    //   31	970	10	localo	okhttp3.o
    //   344	412	11	str	String
    //   628	126	12	locala	okhttp3.x.a
    // Exception table:
    //   from	to	target	type
    //   109	121	188	okhttp3/internal/b/e
    //   109	121	219	finally
    //   190	219	219	finally
    //   240	248	219	finally
    //   251	273	219	finally
    //   109	121	238	java/io/IOException
    //   291	297	317	java/io/IOException
    //   302	317	317	java/io/IOException
    //   330	346	317	java/io/IOException
    //   455	486	317	java/io/IOException
    //   486	499	317	java/io/IOException
    //   502	515	317	java/io/IOException
    //   518	540	317	java/io/IOException
    //   540	559	317	java/io/IOException
    //   563	576	317	java/io/IOException
    //   580	585	317	java/io/IOException
    //   589	620	317	java/io/IOException
    //   620	659	317	java/io/IOException
    //   665	675	317	java/io/IOException
    //   680	707	317	java/io/IOException
    //   707	725	317	java/io/IOException
    //   725	735	317	java/io/IOException
    //   743	753	317	java/io/IOException
    //   753	763	317	java/io/IOException
    //   766	812	317	java/io/IOException
    //   812	827	317	java/io/IOException
    //   830	852	317	java/io/IOException
    //   852	868	317	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     okhttp3.internal.c.j
 * JD-Core Version:    0.7.0.1
 */