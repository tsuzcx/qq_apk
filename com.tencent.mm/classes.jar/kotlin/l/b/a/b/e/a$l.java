package kotlin.l.b.a.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.l.b.a.b.h.b;
import kotlin.l.b.a.b.h.d;
import kotlin.l.b.a.b.h.f;
import kotlin.l.b.a.b.h.g;
import kotlin.l.b.a.b.h.i.a;
import kotlin.l.b.a.b.h.i.b;
import kotlin.l.b.a.b.h.i.c;
import kotlin.l.b.a.b.h.i.c.a;
import kotlin.l.b.a.b.h.r;
import kotlin.l.b.a.b.h.t;

public final class a$l
  extends i.c<l>
  implements l
{
  public static t<l> aiYa;
  private static final l ajag;
  private final d aiXZ;
  public a.o ajah;
  public a.n ajai;
  public a.k ajaj;
  public List<a.b> ajak;
  private int bitField0_;
  private int dRJ = -1;
  private byte memoizedIsInitialized = -1;
  
  static
  {
    AppMethodBeat.i(58691);
    aiYa = new b() {};
    l locall = new l();
    ajag = locall;
    locall.ktf();
    AppMethodBeat.o(58691);
  }
  
  private a$l()
  {
    this.aiXZ = d.ajeU;
  }
  
  /* Error */
  private a$l(kotlin.l.b.a.b.h.e parame, g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 61	kotlin/l/b/a/b/h/i$c:<init>	()V
    //   4: ldc 78
    //   6: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 63	kotlin/l/b/a/b/e/a$l:memoizedIsInitialized	B
    //   14: aload_0
    //   15: iconst_m1
    //   16: putfield 65	kotlin/l/b/a/b/e/a$l:dRJ	I
    //   19: aload_0
    //   20: invokespecial 56	kotlin/l/b/a/b/e/a$l:ktf	()V
    //   23: iconst_0
    //   24: istore_3
    //   25: invokestatic 82	kotlin/l/b/a/b/h/d:kya	()Lkotlin/l/b/a/b/h/d$b;
    //   28: astore 7
    //   30: aload 7
    //   32: iconst_1
    //   33: invokestatic 87	kotlin/l/b/a/b/h/f:i	(Ljava/io/OutputStream;I)Lkotlin/l/b/a/b/h/f;
    //   36: astore 8
    //   38: iconst_0
    //   39: istore 4
    //   41: iload 4
    //   43: ifne +450 -> 493
    //   46: aload_1
    //   47: invokevirtual 93	kotlin/l/b/a/b/h/e:aac	()I
    //   50: istore 5
    //   52: iload 5
    //   54: lookupswitch	default:+585->639, 0:+588->642, 10:+69->123, 18:+211->265, 26:+322->376, 34:+393->447
    //   105: aload_1
    //   106: aload 8
    //   108: aload_2
    //   109: iload 5
    //   111: invokevirtual 96	kotlin/l/b/a/b/e/a$l:a	(Lkotlin/l/b/a/b/h/e;Lkotlin/l/b/a/b/h/f;Lkotlin/l/b/a/b/h/g;I)Z
    //   114: ifne +522 -> 636
    //   117: iconst_1
    //   118: istore 4
    //   120: goto -79 -> 41
    //   123: aload_0
    //   124: getfield 98	kotlin/l/b/a/b/e/a$l:bitField0_	I
    //   127: iconst_1
    //   128: iand
    //   129: iconst_1
    //   130: if_icmpne +500 -> 630
    //   133: aload_0
    //   134: getfield 100	kotlin/l/b/a/b/e/a$l:ajah	Lkotlin/l/b/a/b/e/a$o;
    //   137: invokestatic 106	kotlin/l/b/a/b/e/a$o:b	(Lkotlin/l/b/a/b/e/a$o;)Lkotlin/l/b/a/b/e/a$o$a;
    //   140: astore 6
    //   142: aload_0
    //   143: aload_1
    //   144: getstatic 107	kotlin/l/b/a/b/e/a$o:aiYa	Lkotlin/l/b/a/b/h/t;
    //   147: aload_2
    //   148: invokevirtual 110	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/t;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/r;
    //   151: checkcast 102	kotlin/l/b/a/b/e/a$o
    //   154: putfield 100	kotlin/l/b/a/b/e/a$l:ajah	Lkotlin/l/b/a/b/e/a$o;
    //   157: aload 6
    //   159: ifnull +22 -> 181
    //   162: aload 6
    //   164: aload_0
    //   165: getfield 100	kotlin/l/b/a/b/e/a$l:ajah	Lkotlin/l/b/a/b/e/a$o;
    //   168: invokevirtual 115	kotlin/l/b/a/b/e/a$o$a:e	(Lkotlin/l/b/a/b/e/a$o;)Lkotlin/l/b/a/b/e/a$o$a;
    //   171: pop
    //   172: aload_0
    //   173: aload 6
    //   175: invokevirtual 119	kotlin/l/b/a/b/e/a$o$a:kvE	()Lkotlin/l/b/a/b/e/a$o;
    //   178: putfield 100	kotlin/l/b/a/b/e/a$l:ajah	Lkotlin/l/b/a/b/e/a$o;
    //   181: aload_0
    //   182: aload_0
    //   183: getfield 98	kotlin/l/b/a/b/e/a$l:bitField0_	I
    //   186: iconst_1
    //   187: ior
    //   188: putfield 98	kotlin/l/b/a/b/e/a$l:bitField0_	I
    //   191: goto -150 -> 41
    //   194: astore_1
    //   195: iload_3
    //   196: istore 4
    //   198: iload 4
    //   200: istore_3
    //   201: aload_1
    //   202: aload_0
    //   203: putfield 123	kotlin/l/b/a/b/h/l:ajfp	Lkotlin/l/b/a/b/h/r;
    //   206: iload 4
    //   208: istore_3
    //   209: ldc 78
    //   211: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   214: iload 4
    //   216: istore_3
    //   217: aload_1
    //   218: athrow
    //   219: astore_1
    //   220: iload_3
    //   221: bipush 8
    //   223: iand
    //   224: bipush 8
    //   226: if_icmpne +14 -> 240
    //   229: aload_0
    //   230: aload_0
    //   231: getfield 125	kotlin/l/b/a/b/e/a$l:ajak	Ljava/util/List;
    //   234: invokestatic 131	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   237: putfield 125	kotlin/l/b/a/b/e/a$l:ajak	Ljava/util/List;
    //   240: aload 8
    //   242: invokevirtual 134	kotlin/l/b/a/b/h/f:flush	()V
    //   245: aload_0
    //   246: aload 7
    //   248: invokevirtual 140	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   251: putfield 72	kotlin/l/b/a/b/e/a$l:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   254: aload_0
    //   255: invokevirtual 143	kotlin/l/b/a/b/e/a$l:makeExtensionsImmutable	()V
    //   258: ldc 78
    //   260: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   263: aload_1
    //   264: athrow
    //   265: aload_0
    //   266: getfield 98	kotlin/l/b/a/b/e/a$l:bitField0_	I
    //   269: iconst_2
    //   270: iand
    //   271: iconst_2
    //   272: if_icmpne +352 -> 624
    //   275: aload_0
    //   276: getfield 145	kotlin/l/b/a/b/e/a$l:ajai	Lkotlin/l/b/a/b/e/a$n;
    //   279: invokestatic 150	kotlin/l/b/a/b/e/a$n:b	(Lkotlin/l/b/a/b/e/a$n;)Lkotlin/l/b/a/b/e/a$n$a;
    //   282: astore 6
    //   284: aload_0
    //   285: aload_1
    //   286: getstatic 151	kotlin/l/b/a/b/e/a$n:aiYa	Lkotlin/l/b/a/b/h/t;
    //   289: aload_2
    //   290: invokevirtual 110	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/t;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/r;
    //   293: checkcast 147	kotlin/l/b/a/b/e/a$n
    //   296: putfield 145	kotlin/l/b/a/b/e/a$l:ajai	Lkotlin/l/b/a/b/e/a$n;
    //   299: aload 6
    //   301: ifnull +22 -> 323
    //   304: aload 6
    //   306: aload_0
    //   307: getfield 145	kotlin/l/b/a/b/e/a$l:ajai	Lkotlin/l/b/a/b/e/a$n;
    //   310: invokevirtual 155	kotlin/l/b/a/b/e/a$n$a:e	(Lkotlin/l/b/a/b/e/a$n;)Lkotlin/l/b/a/b/e/a$n$a;
    //   313: pop
    //   314: aload_0
    //   315: aload 6
    //   317: invokevirtual 159	kotlin/l/b/a/b/e/a$n$a:kvt	()Lkotlin/l/b/a/b/e/a$n;
    //   320: putfield 145	kotlin/l/b/a/b/e/a$l:ajai	Lkotlin/l/b/a/b/e/a$n;
    //   323: aload_0
    //   324: aload_0
    //   325: getfield 98	kotlin/l/b/a/b/e/a$l:bitField0_	I
    //   328: iconst_2
    //   329: ior
    //   330: putfield 98	kotlin/l/b/a/b/e/a$l:bitField0_	I
    //   333: goto -292 -> 41
    //   336: astore_1
    //   337: iload_3
    //   338: istore 4
    //   340: iload 4
    //   342: istore_3
    //   343: new 75	kotlin/l/b/a/b/h/l
    //   346: dup
    //   347: aload_1
    //   348: invokevirtual 163	java/io/IOException:getMessage	()Ljava/lang/String;
    //   351: invokespecial 166	kotlin/l/b/a/b/h/l:<init>	(Ljava/lang/String;)V
    //   354: astore_1
    //   355: iload 4
    //   357: istore_3
    //   358: aload_1
    //   359: aload_0
    //   360: putfield 123	kotlin/l/b/a/b/h/l:ajfp	Lkotlin/l/b/a/b/h/r;
    //   363: iload 4
    //   365: istore_3
    //   366: ldc 78
    //   368: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   371: iload 4
    //   373: istore_3
    //   374: aload_1
    //   375: athrow
    //   376: aload_0
    //   377: getfield 98	kotlin/l/b/a/b/e/a$l:bitField0_	I
    //   380: iconst_4
    //   381: iand
    //   382: iconst_4
    //   383: if_icmpne +235 -> 618
    //   386: aload_0
    //   387: getfield 168	kotlin/l/b/a/b/e/a$l:ajaj	Lkotlin/l/b/a/b/e/a$k;
    //   390: invokevirtual 174	kotlin/l/b/a/b/e/a$k:kuZ	()Lkotlin/l/b/a/b/e/a$k$a;
    //   393: astore 6
    //   395: aload_0
    //   396: aload_1
    //   397: getstatic 175	kotlin/l/b/a/b/e/a$k:aiYa	Lkotlin/l/b/a/b/h/t;
    //   400: aload_2
    //   401: invokevirtual 110	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/t;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/r;
    //   404: checkcast 170	kotlin/l/b/a/b/e/a$k
    //   407: putfield 168	kotlin/l/b/a/b/e/a$l:ajaj	Lkotlin/l/b/a/b/e/a$k;
    //   410: aload 6
    //   412: ifnull +22 -> 434
    //   415: aload 6
    //   417: aload_0
    //   418: getfield 168	kotlin/l/b/a/b/e/a$l:ajaj	Lkotlin/l/b/a/b/e/a$k;
    //   421: invokevirtual 181	kotlin/l/b/a/b/e/a$k$a:f	(Lkotlin/l/b/a/b/e/a$k;)Lkotlin/l/b/a/b/e/a$k$a;
    //   424: pop
    //   425: aload_0
    //   426: aload 6
    //   428: invokevirtual 185	kotlin/l/b/a/b/e/a$k$a:kvb	()Lkotlin/l/b/a/b/e/a$k;
    //   431: putfield 168	kotlin/l/b/a/b/e/a$l:ajaj	Lkotlin/l/b/a/b/e/a$k;
    //   434: aload_0
    //   435: aload_0
    //   436: getfield 98	kotlin/l/b/a/b/e/a$l:bitField0_	I
    //   439: iconst_4
    //   440: ior
    //   441: putfield 98	kotlin/l/b/a/b/e/a$l:bitField0_	I
    //   444: goto -403 -> 41
    //   447: iload_3
    //   448: bipush 8
    //   450: iand
    //   451: bipush 8
    //   453: if_icmpeq +162 -> 615
    //   456: aload_0
    //   457: new 187	java/util/ArrayList
    //   460: dup
    //   461: invokespecial 188	java/util/ArrayList:<init>	()V
    //   464: putfield 125	kotlin/l/b/a/b/e/a$l:ajak	Ljava/util/List;
    //   467: iload_3
    //   468: bipush 8
    //   470: ior
    //   471: istore_3
    //   472: aload_0
    //   473: getfield 125	kotlin/l/b/a/b/e/a$l:ajak	Ljava/util/List;
    //   476: aload_1
    //   477: getstatic 191	kotlin/l/b/a/b/e/a$b:aiYa	Lkotlin/l/b/a/b/h/t;
    //   480: aload_2
    //   481: invokevirtual 110	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/t;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/r;
    //   484: invokeinterface 197 2 0
    //   489: pop
    //   490: goto -449 -> 41
    //   493: iload_3
    //   494: bipush 8
    //   496: iand
    //   497: bipush 8
    //   499: if_icmpne +14 -> 513
    //   502: aload_0
    //   503: aload_0
    //   504: getfield 125	kotlin/l/b/a/b/e/a$l:ajak	Ljava/util/List;
    //   507: invokestatic 131	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   510: putfield 125	kotlin/l/b/a/b/e/a$l:ajak	Ljava/util/List;
    //   513: aload 8
    //   515: invokevirtual 134	kotlin/l/b/a/b/h/f:flush	()V
    //   518: aload_0
    //   519: aload 7
    //   521: invokevirtual 140	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   524: putfield 72	kotlin/l/b/a/b/e/a$l:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   527: aload_0
    //   528: invokevirtual 143	kotlin/l/b/a/b/e/a$l:makeExtensionsImmutable	()V
    //   531: ldc 78
    //   533: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   536: return
    //   537: astore_1
    //   538: aload_0
    //   539: aload 7
    //   541: invokevirtual 140	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   544: putfield 72	kotlin/l/b/a/b/e/a$l:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   547: goto -20 -> 527
    //   550: astore_1
    //   551: aload_0
    //   552: aload 7
    //   554: invokevirtual 140	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   557: putfield 72	kotlin/l/b/a/b/e/a$l:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   560: ldc 78
    //   562: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   565: aload_1
    //   566: athrow
    //   567: astore_2
    //   568: aload_0
    //   569: aload 7
    //   571: invokevirtual 140	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   574: putfield 72	kotlin/l/b/a/b/e/a$l:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   577: goto -323 -> 254
    //   580: astore_1
    //   581: aload_0
    //   582: aload 7
    //   584: invokevirtual 140	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   587: putfield 72	kotlin/l/b/a/b/e/a$l:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   590: ldc 78
    //   592: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   595: aload_1
    //   596: athrow
    //   597: astore_1
    //   598: goto -378 -> 220
    //   601: astore_1
    //   602: iload_3
    //   603: istore 4
    //   605: goto -265 -> 340
    //   608: astore_1
    //   609: iload_3
    //   610: istore 4
    //   612: goto -414 -> 198
    //   615: goto -143 -> 472
    //   618: aconst_null
    //   619: astore 6
    //   621: goto -226 -> 395
    //   624: aconst_null
    //   625: astore 6
    //   627: goto -343 -> 284
    //   630: aconst_null
    //   631: astore 6
    //   633: goto -491 -> 142
    //   636: goto -146 -> 490
    //   639: goto -535 -> 104
    //   642: iconst_1
    //   643: istore 4
    //   645: goto -604 -> 41
    //   648: astore_1
    //   649: goto -429 -> 220
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	652	0	this	l
    //   0	652	1	parame	kotlin.l.b.a.b.h.e
    //   0	652	2	paramg	g
    //   24	586	3	i	int
    //   39	605	4	j	int
    //   50	60	5	k	int
    //   140	492	6	localObject	java.lang.Object
    //   28	555	7	localb	kotlin.l.b.a.b.h.d.b
    //   36	478	8	localf	f
    // Exception table:
    //   from	to	target	type
    //   46	52	194	kotlin/l/b/a/b/h/l
    //   104	117	194	kotlin/l/b/a/b/h/l
    //   123	142	194	kotlin/l/b/a/b/h/l
    //   142	157	194	kotlin/l/b/a/b/h/l
    //   162	181	194	kotlin/l/b/a/b/h/l
    //   181	191	194	kotlin/l/b/a/b/h/l
    //   265	284	194	kotlin/l/b/a/b/h/l
    //   284	299	194	kotlin/l/b/a/b/h/l
    //   304	323	194	kotlin/l/b/a/b/h/l
    //   323	333	194	kotlin/l/b/a/b/h/l
    //   376	395	194	kotlin/l/b/a/b/h/l
    //   395	410	194	kotlin/l/b/a/b/h/l
    //   415	434	194	kotlin/l/b/a/b/h/l
    //   434	444	194	kotlin/l/b/a/b/h/l
    //   456	467	194	kotlin/l/b/a/b/h/l
    //   201	206	219	finally
    //   209	214	219	finally
    //   217	219	219	finally
    //   343	355	219	finally
    //   358	363	219	finally
    //   366	371	219	finally
    //   374	376	219	finally
    //   46	52	336	java/io/IOException
    //   104	117	336	java/io/IOException
    //   123	142	336	java/io/IOException
    //   142	157	336	java/io/IOException
    //   162	181	336	java/io/IOException
    //   181	191	336	java/io/IOException
    //   265	284	336	java/io/IOException
    //   284	299	336	java/io/IOException
    //   304	323	336	java/io/IOException
    //   323	333	336	java/io/IOException
    //   376	395	336	java/io/IOException
    //   395	410	336	java/io/IOException
    //   415	434	336	java/io/IOException
    //   434	444	336	java/io/IOException
    //   456	467	336	java/io/IOException
    //   513	518	537	java/io/IOException
    //   513	518	550	finally
    //   240	245	567	java/io/IOException
    //   240	245	580	finally
    //   472	490	597	finally
    //   472	490	601	java/io/IOException
    //   472	490	608	kotlin/l/b/a/b/h/l
    //   46	52	648	finally
    //   104	117	648	finally
    //   123	142	648	finally
    //   142	157	648	finally
    //   162	181	648	finally
    //   181	191	648	finally
    //   265	284	648	finally
    //   284	299	648	finally
    //   304	323	648	finally
    //   323	333	648	finally
    //   376	395	648	finally
    //   395	410	648	finally
    //   415	434	648	finally
    //   434	444	648	finally
    //   456	467	648	finally
  }
  
  private a$l(i.b<l, ?> paramb)
  {
    super(paramb);
    this.aiXZ = paramb.aiXZ;
  }
  
  public static l d(InputStream paramInputStream, g paramg)
  {
    AppMethodBeat.i(58688);
    paramInputStream = (l)aiYa.j(paramInputStream, paramg);
    AppMethodBeat.o(58688);
    return paramInputStream;
  }
  
  private void ktf()
  {
    AppMethodBeat.i(58684);
    this.ajah = a.o.kvC();
    this.ajai = a.n.kvr();
    this.ajaj = a.k.kuY();
    this.ajak = Collections.emptyList();
    AppMethodBeat.o(58684);
  }
  
  public static l kvd()
  {
    return ajag;
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(58686);
    getSerializedSize();
    i.c.a locala = kym();
    if ((this.bitField0_ & 0x1) == 1) {
      paramf.a(1, this.ajah);
    }
    if ((this.bitField0_ & 0x2) == 2) {
      paramf.a(2, this.ajai);
    }
    if ((this.bitField0_ & 0x4) == 4) {
      paramf.a(3, this.ajaj);
    }
    int i = 0;
    while (i < this.ajak.size())
    {
      paramf.a(4, (r)this.ajak.get(i));
      i += 1;
    }
    locala.b(200, paramf);
    paramf.e(this.aiXZ);
    AppMethodBeat.o(58686);
  }
  
  public final boolean adZ()
  {
    return (this.bitField0_ & 0x4) == 4;
  }
  
  public final int getSerializedSize()
  {
    int k = 0;
    AppMethodBeat.i(58687);
    int i = this.dRJ;
    if (i != -1)
    {
      AppMethodBeat.o(58687);
      return i;
    }
    if ((this.bitField0_ & 0x1) == 1) {}
    for (int j = f.c(1, this.ajah) + 0;; j = 0)
    {
      i = j;
      if ((this.bitField0_ & 0x2) == 2) {
        i = j + f.c(2, this.ajai);
      }
      j = i;
      if ((this.bitField0_ & 0x4) == 4) {
        j = i + f.c(3, this.ajaj);
      }
      i = j;
      j = k;
      while (j < this.ajak.size())
      {
        k = f.c(4, (r)this.ajak.get(j));
        j += 1;
        i = k + i;
      }
      i = aie() + i + this.aiXZ.size();
      this.dRJ = i;
      AppMethodBeat.o(58687);
      return i;
    }
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(58685);
    int i = this.memoizedIsInitialized;
    if (i == 1)
    {
      AppMethodBeat.o(58685);
      return true;
    }
    if (i == 0)
    {
      AppMethodBeat.o(58685);
      return false;
    }
    if ((kvf()) && (!this.ajai.isInitialized()))
    {
      this.memoizedIsInitialized = 0;
      AppMethodBeat.o(58685);
      return false;
    }
    if ((adZ()) && (!this.ajaj.isInitialized()))
    {
      this.memoizedIsInitialized = 0;
      AppMethodBeat.o(58685);
      return false;
    }
    i = 0;
    while (i < this.ajak.size())
    {
      if (!((a.b)this.ajak.get(i)).isInitialized())
      {
        this.memoizedIsInitialized = 0;
        AppMethodBeat.o(58685);
        return false;
      }
      i += 1;
    }
    if (!aic())
    {
      this.memoizedIsInitialized = 0;
      AppMethodBeat.o(58685);
      return false;
    }
    this.memoizedIsInitialized = 1;
    AppMethodBeat.o(58685);
    return true;
  }
  
  public final boolean kve()
  {
    return (this.bitField0_ & 0x1) == 1;
  }
  
  public final boolean kvf()
  {
    return (this.bitField0_ & 0x2) == 2;
  }
  
  public static final class a
    extends i.b<a.l, a>
    implements l
  {
    private a.o ajah;
    private a.n ajai;
    private a.k ajaj;
    private List<a.b> ajak;
    private int bitField0_;
    
    private a()
    {
      AppMethodBeat.i(58662);
      this.ajah = a.o.kvC();
      this.ajai = a.n.kvr();
      this.ajaj = a.k.kuY();
      this.ajak = Collections.emptyList();
      AppMethodBeat.o(58662);
    }
    
    private a a(a.n paramn)
    {
      AppMethodBeat.i(58669);
      if (((this.bitField0_ & 0x2) == 2) && (this.ajai != a.n.kvr())) {}
      for (this.ajai = a.n.b(this.ajai).e(paramn).kvt();; this.ajai = paramn)
      {
        this.bitField0_ |= 0x2;
        AppMethodBeat.o(58669);
        return this;
      }
    }
    
    private a a(a.o paramo)
    {
      AppMethodBeat.i(58668);
      if (((this.bitField0_ & 0x1) == 1) && (this.ajah != a.o.kvC())) {}
      for (this.ajah = a.o.b(this.ajah).e(paramo).kvE();; this.ajah = paramo)
      {
        this.bitField0_ |= 0x1;
        AppMethodBeat.o(58668);
        return this;
      }
    }
    
    private a g(a.k paramk)
    {
      AppMethodBeat.i(58670);
      if (((this.bitField0_ & 0x4) == 4) && (this.ajaj != a.k.kuY())) {}
      for (this.ajaj = a.k.a(this.ajaj).f(paramk).kvb();; this.ajaj = paramk)
      {
        this.bitField0_ |= 0x4;
        AppMethodBeat.o(58670);
        return this;
      }
    }
    
    private a kvg()
    {
      AppMethodBeat.i(58663);
      a locala = new a().c(kvh());
      AppMethodBeat.o(58663);
      return locala;
    }
    
    private a.l kvh()
    {
      int j = 1;
      AppMethodBeat.i(58664);
      a.l locall = new a.l(this, (byte)0);
      int k = this.bitField0_;
      if ((k & 0x1) == 1) {}
      for (;;)
      {
        a.l.a(locall, this.ajah);
        int i = j;
        if ((k & 0x2) == 2) {
          i = j | 0x2;
        }
        a.l.a(locall, this.ajai);
        j = i;
        if ((k & 0x4) == 4) {
          j = i | 0x4;
        }
        a.l.a(locall, this.ajaj);
        if ((this.bitField0_ & 0x8) == 8)
        {
          this.ajak = Collections.unmodifiableList(this.ajak);
          this.bitField0_ &= 0xFFFFFFF7;
        }
        a.l.a(locall, this.ajak);
        a.l.a(locall, j);
        AppMethodBeat.o(58664);
        return locall;
        j = 0;
      }
    }
    
    private void kvi()
    {
      AppMethodBeat.i(58671);
      if ((this.bitField0_ & 0x8) != 8)
      {
        this.ajak = new ArrayList(this.ajak);
        this.bitField0_ |= 0x8;
      }
      AppMethodBeat.o(58671);
    }
    
    /* Error */
    private a o(kotlin.l.b.a.b.h.e parame, g paramg)
    {
      // Byte code:
      //   0: ldc 161
      //   2: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: getstatic 165	kotlin/l/b/a/b/e/a$l:aiYa	Lkotlin/l/b/a/b/h/t;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 170 3 0
      //   17: checkcast 9	kotlin/l/b/a/b/e/a$l
      //   20: astore_1
      //   21: aload_1
      //   22: ifnull +9 -> 31
      //   25: aload_0
      //   26: aload_1
      //   27: invokevirtual 125	kotlin/l/b/a/b/e/a$l$a:c	(Lkotlin/l/b/a/b/e/a$l;)Lkotlin/l/b/a/b/e/a$l$a;
      //   30: pop
      //   31: ldc 161
      //   33: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   36: aload_0
      //   37: areturn
      //   38: astore_1
      //   39: aload_1
      //   40: getfield 174	kotlin/l/b/a/b/h/l:ajfp	Lkotlin/l/b/a/b/h/r;
      //   43: checkcast 9	kotlin/l/b/a/b/e/a$l
      //   46: astore_2
      //   47: ldc 161
      //   49: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   52: aload_1
      //   53: athrow
      //   54: astore_1
      //   55: aload_2
      //   56: ifnull +9 -> 65
      //   59: aload_0
      //   60: aload_2
      //   61: invokevirtual 125	kotlin/l/b/a/b/e/a$l$a:c	(Lkotlin/l/b/a/b/e/a$l;)Lkotlin/l/b/a/b/e/a$l$a;
      //   64: pop
      //   65: ldc 161
      //   67: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   70: aload_1
      //   71: athrow
      //   72: astore_1
      //   73: aload_3
      //   74: astore_2
      //   75: goto -20 -> 55
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	78	0	this	a
      //   0	78	1	parame	kotlin.l.b.a.b.h.e
      //   0	78	2	paramg	g
      //   6	68	3	localObject	java.lang.Object
      // Exception table:
      //   from	to	target	type
      //   7	21	38	kotlin/l/b/a/b/h/l
      //   47	54	54	finally
      //   7	21	72	finally
      //   39	47	72	finally
    }
    
    public final a c(a.l paraml)
    {
      AppMethodBeat.i(58665);
      if (paraml == a.l.kvd())
      {
        AppMethodBeat.o(58665);
        return this;
      }
      if (paraml.kve()) {
        a(paraml.ajah);
      }
      if (paraml.kvf()) {
        a(paraml.ajai);
      }
      if (paraml.adZ()) {
        g(paraml.ajaj);
      }
      if (!a.l.a(paraml).isEmpty())
      {
        if (!this.ajak.isEmpty()) {
          break label137;
        }
        this.ajak = a.l.a(paraml);
        this.bitField0_ &= 0xFFFFFFF7;
      }
      for (;;)
      {
        a(paraml);
        this.aiXZ = this.aiXZ.a(a.l.b(paraml));
        AppMethodBeat.o(58665);
        return this;
        label137:
        kvi();
        this.ajak.addAll(a.l.a(paraml));
      }
    }
    
    public final boolean isInitialized()
    {
      AppMethodBeat.i(58666);
      if ((this.bitField0_ & 0x2) == 2) {}
      for (int i = 1; (i != 0) && (!this.ajai.isInitialized()); i = 0)
      {
        AppMethodBeat.o(58666);
        return false;
      }
      if ((this.bitField0_ & 0x4) == 4) {}
      for (i = 1; (i != 0) && (!this.ajaj.isInitialized()); i = 0)
      {
        AppMethodBeat.o(58666);
        return false;
      }
      i = 0;
      while (i < this.ajak.size())
      {
        if (!((a.b)this.ajak.get(i)).isInitialized())
        {
          AppMethodBeat.o(58666);
          return false;
        }
        i += 1;
      }
      if (!aic())
      {
        AppMethodBeat.o(58666);
        return false;
      }
      AppMethodBeat.o(58666);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.e.a.l
 * JD-Core Version:    0.7.0.1
 */