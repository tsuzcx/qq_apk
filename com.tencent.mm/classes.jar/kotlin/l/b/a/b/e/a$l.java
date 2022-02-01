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
  public static t<l> aaZC;
  private static final l abbF;
  private final d aaZB;
  public a.o abbG;
  public a.n abbH;
  public a.k abbI;
  public List<a.b> abbJ;
  private int bQS;
  private byte bRd = -1;
  private int bXW = -1;
  
  static
  {
    AppMethodBeat.i(58691);
    aaZC = new b() {};
    l locall = new l();
    abbF = locall;
    locall.iIN();
    AppMethodBeat.o(58691);
  }
  
  private a$l()
  {
    this.aaZB = d.abgb;
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
    //   11: putfield 63	kotlin/l/b/a/b/e/a$l:bRd	B
    //   14: aload_0
    //   15: iconst_m1
    //   16: putfield 65	kotlin/l/b/a/b/e/a$l:bXW	I
    //   19: aload_0
    //   20: invokespecial 56	kotlin/l/b/a/b/e/a$l:iIN	()V
    //   23: iconst_0
    //   24: istore_3
    //   25: invokestatic 82	kotlin/l/b/a/b/h/d:iNH	()Lkotlin/l/b/a/b/h/d$b;
    //   28: astore 7
    //   30: aload 7
    //   32: iconst_1
    //   33: invokestatic 88	kotlin/l/b/a/b/h/f:f	(Ljava/io/OutputStream;I)Lkotlin/l/b/a/b/h/f;
    //   36: astore 8
    //   38: iconst_0
    //   39: istore 4
    //   41: iload 4
    //   43: ifne +450 -> 493
    //   46: aload_1
    //   47: invokevirtual 94	kotlin/l/b/a/b/h/e:Av	()I
    //   50: istore 5
    //   52: iload 5
    //   54: lookupswitch	default:+585->639, 0:+588->642, 10:+69->123, 18:+211->265, 26:+322->376, 34:+393->447
    //   105: aload_1
    //   106: aload 8
    //   108: aload_2
    //   109: iload 5
    //   111: invokevirtual 97	kotlin/l/b/a/b/e/a$l:a	(Lkotlin/l/b/a/b/h/e;Lkotlin/l/b/a/b/h/f;Lkotlin/l/b/a/b/h/g;I)Z
    //   114: ifne +522 -> 636
    //   117: iconst_1
    //   118: istore 4
    //   120: goto -79 -> 41
    //   123: aload_0
    //   124: getfield 99	kotlin/l/b/a/b/e/a$l:bQS	I
    //   127: iconst_1
    //   128: iand
    //   129: iconst_1
    //   130: if_icmpne +500 -> 630
    //   133: aload_0
    //   134: getfield 101	kotlin/l/b/a/b/e/a$l:abbG	Lkotlin/l/b/a/b/e/a$o;
    //   137: invokestatic 107	kotlin/l/b/a/b/e/a$o:b	(Lkotlin/l/b/a/b/e/a$o;)Lkotlin/l/b/a/b/e/a$o$a;
    //   140: astore 6
    //   142: aload_0
    //   143: aload_1
    //   144: getstatic 108	kotlin/l/b/a/b/e/a$o:aaZC	Lkotlin/l/b/a/b/h/t;
    //   147: aload_2
    //   148: invokevirtual 111	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/t;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/r;
    //   151: checkcast 103	kotlin/l/b/a/b/e/a$o
    //   154: putfield 101	kotlin/l/b/a/b/e/a$l:abbG	Lkotlin/l/b/a/b/e/a$o;
    //   157: aload 6
    //   159: ifnull +22 -> 181
    //   162: aload 6
    //   164: aload_0
    //   165: getfield 101	kotlin/l/b/a/b/e/a$l:abbG	Lkotlin/l/b/a/b/e/a$o;
    //   168: invokevirtual 116	kotlin/l/b/a/b/e/a$o$a:e	(Lkotlin/l/b/a/b/e/a$o;)Lkotlin/l/b/a/b/e/a$o$a;
    //   171: pop
    //   172: aload_0
    //   173: aload 6
    //   175: invokevirtual 120	kotlin/l/b/a/b/e/a$o$a:iLj	()Lkotlin/l/b/a/b/e/a$o;
    //   178: putfield 101	kotlin/l/b/a/b/e/a$l:abbG	Lkotlin/l/b/a/b/e/a$o;
    //   181: aload_0
    //   182: aload_0
    //   183: getfield 99	kotlin/l/b/a/b/e/a$l:bQS	I
    //   186: iconst_1
    //   187: ior
    //   188: putfield 99	kotlin/l/b/a/b/e/a$l:bQS	I
    //   191: goto -150 -> 41
    //   194: astore_1
    //   195: iload_3
    //   196: istore 4
    //   198: iload 4
    //   200: istore_3
    //   201: aload_1
    //   202: aload_0
    //   203: putfield 124	kotlin/l/b/a/b/h/l:abgy	Lkotlin/l/b/a/b/h/r;
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
    //   231: getfield 126	kotlin/l/b/a/b/e/a$l:abbJ	Ljava/util/List;
    //   234: invokestatic 132	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   237: putfield 126	kotlin/l/b/a/b/e/a$l:abbJ	Ljava/util/List;
    //   240: aload 8
    //   242: invokevirtual 135	kotlin/l/b/a/b/h/f:flush	()V
    //   245: aload_0
    //   246: aload 7
    //   248: invokevirtual 141	kotlin/l/b/a/b/h/d$b:iNK	()Lkotlin/l/b/a/b/h/d;
    //   251: putfield 72	kotlin/l/b/a/b/e/a$l:aaZB	Lkotlin/l/b/a/b/h/d;
    //   254: aload_0
    //   255: invokevirtual 144	kotlin/l/b/a/b/e/a$l:HZ	()V
    //   258: ldc 78
    //   260: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   263: aload_1
    //   264: athrow
    //   265: aload_0
    //   266: getfield 99	kotlin/l/b/a/b/e/a$l:bQS	I
    //   269: iconst_2
    //   270: iand
    //   271: iconst_2
    //   272: if_icmpne +352 -> 624
    //   275: aload_0
    //   276: getfield 146	kotlin/l/b/a/b/e/a$l:abbH	Lkotlin/l/b/a/b/e/a$n;
    //   279: invokestatic 151	kotlin/l/b/a/b/e/a$n:b	(Lkotlin/l/b/a/b/e/a$n;)Lkotlin/l/b/a/b/e/a$n$a;
    //   282: astore 6
    //   284: aload_0
    //   285: aload_1
    //   286: getstatic 152	kotlin/l/b/a/b/e/a$n:aaZC	Lkotlin/l/b/a/b/h/t;
    //   289: aload_2
    //   290: invokevirtual 111	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/t;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/r;
    //   293: checkcast 148	kotlin/l/b/a/b/e/a$n
    //   296: putfield 146	kotlin/l/b/a/b/e/a$l:abbH	Lkotlin/l/b/a/b/e/a$n;
    //   299: aload 6
    //   301: ifnull +22 -> 323
    //   304: aload 6
    //   306: aload_0
    //   307: getfield 146	kotlin/l/b/a/b/e/a$l:abbH	Lkotlin/l/b/a/b/e/a$n;
    //   310: invokevirtual 156	kotlin/l/b/a/b/e/a$n$a:e	(Lkotlin/l/b/a/b/e/a$n;)Lkotlin/l/b/a/b/e/a$n$a;
    //   313: pop
    //   314: aload_0
    //   315: aload 6
    //   317: invokevirtual 160	kotlin/l/b/a/b/e/a$n$a:iKY	()Lkotlin/l/b/a/b/e/a$n;
    //   320: putfield 146	kotlin/l/b/a/b/e/a$l:abbH	Lkotlin/l/b/a/b/e/a$n;
    //   323: aload_0
    //   324: aload_0
    //   325: getfield 99	kotlin/l/b/a/b/e/a$l:bQS	I
    //   328: iconst_2
    //   329: ior
    //   330: putfield 99	kotlin/l/b/a/b/e/a$l:bQS	I
    //   333: goto -292 -> 41
    //   336: astore_1
    //   337: iload_3
    //   338: istore 4
    //   340: iload 4
    //   342: istore_3
    //   343: new 75	kotlin/l/b/a/b/h/l
    //   346: dup
    //   347: aload_1
    //   348: invokevirtual 164	java/io/IOException:getMessage	()Ljava/lang/String;
    //   351: invokespecial 167	kotlin/l/b/a/b/h/l:<init>	(Ljava/lang/String;)V
    //   354: astore_1
    //   355: iload 4
    //   357: istore_3
    //   358: aload_1
    //   359: aload_0
    //   360: putfield 124	kotlin/l/b/a/b/h/l:abgy	Lkotlin/l/b/a/b/h/r;
    //   363: iload 4
    //   365: istore_3
    //   366: ldc 78
    //   368: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   371: iload 4
    //   373: istore_3
    //   374: aload_1
    //   375: athrow
    //   376: aload_0
    //   377: getfield 99	kotlin/l/b/a/b/e/a$l:bQS	I
    //   380: iconst_4
    //   381: iand
    //   382: iconst_4
    //   383: if_icmpne +235 -> 618
    //   386: aload_0
    //   387: getfield 169	kotlin/l/b/a/b/e/a$l:abbI	Lkotlin/l/b/a/b/e/a$k;
    //   390: invokevirtual 175	kotlin/l/b/a/b/e/a$k:iKE	()Lkotlin/l/b/a/b/e/a$k$a;
    //   393: astore 6
    //   395: aload_0
    //   396: aload_1
    //   397: getstatic 176	kotlin/l/b/a/b/e/a$k:aaZC	Lkotlin/l/b/a/b/h/t;
    //   400: aload_2
    //   401: invokevirtual 111	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/t;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/r;
    //   404: checkcast 171	kotlin/l/b/a/b/e/a$k
    //   407: putfield 169	kotlin/l/b/a/b/e/a$l:abbI	Lkotlin/l/b/a/b/e/a$k;
    //   410: aload 6
    //   412: ifnull +22 -> 434
    //   415: aload 6
    //   417: aload_0
    //   418: getfield 169	kotlin/l/b/a/b/e/a$l:abbI	Lkotlin/l/b/a/b/e/a$k;
    //   421: invokevirtual 181	kotlin/l/b/a/b/e/a$k$a:f	(Lkotlin/l/b/a/b/e/a$k;)Lkotlin/l/b/a/b/e/a$k$a;
    //   424: pop
    //   425: aload_0
    //   426: aload 6
    //   428: invokevirtual 185	kotlin/l/b/a/b/e/a$k$a:iKG	()Lkotlin/l/b/a/b/e/a$k;
    //   431: putfield 169	kotlin/l/b/a/b/e/a$l:abbI	Lkotlin/l/b/a/b/e/a$k;
    //   434: aload_0
    //   435: aload_0
    //   436: getfield 99	kotlin/l/b/a/b/e/a$l:bQS	I
    //   439: iconst_4
    //   440: ior
    //   441: putfield 99	kotlin/l/b/a/b/e/a$l:bQS	I
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
    //   464: putfield 126	kotlin/l/b/a/b/e/a$l:abbJ	Ljava/util/List;
    //   467: iload_3
    //   468: bipush 8
    //   470: ior
    //   471: istore_3
    //   472: aload_0
    //   473: getfield 126	kotlin/l/b/a/b/e/a$l:abbJ	Ljava/util/List;
    //   476: aload_1
    //   477: getstatic 191	kotlin/l/b/a/b/e/a$b:aaZC	Lkotlin/l/b/a/b/h/t;
    //   480: aload_2
    //   481: invokevirtual 111	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/t;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/r;
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
    //   504: getfield 126	kotlin/l/b/a/b/e/a$l:abbJ	Ljava/util/List;
    //   507: invokestatic 132	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   510: putfield 126	kotlin/l/b/a/b/e/a$l:abbJ	Ljava/util/List;
    //   513: aload 8
    //   515: invokevirtual 135	kotlin/l/b/a/b/h/f:flush	()V
    //   518: aload_0
    //   519: aload 7
    //   521: invokevirtual 141	kotlin/l/b/a/b/h/d$b:iNK	()Lkotlin/l/b/a/b/h/d;
    //   524: putfield 72	kotlin/l/b/a/b/e/a$l:aaZB	Lkotlin/l/b/a/b/h/d;
    //   527: aload_0
    //   528: invokevirtual 144	kotlin/l/b/a/b/e/a$l:HZ	()V
    //   531: ldc 78
    //   533: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   536: return
    //   537: astore_1
    //   538: aload_0
    //   539: aload 7
    //   541: invokevirtual 141	kotlin/l/b/a/b/h/d$b:iNK	()Lkotlin/l/b/a/b/h/d;
    //   544: putfield 72	kotlin/l/b/a/b/e/a$l:aaZB	Lkotlin/l/b/a/b/h/d;
    //   547: goto -20 -> 527
    //   550: astore_1
    //   551: aload_0
    //   552: aload 7
    //   554: invokevirtual 141	kotlin/l/b/a/b/h/d$b:iNK	()Lkotlin/l/b/a/b/h/d;
    //   557: putfield 72	kotlin/l/b/a/b/e/a$l:aaZB	Lkotlin/l/b/a/b/h/d;
    //   560: ldc 78
    //   562: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   565: aload_1
    //   566: athrow
    //   567: astore_2
    //   568: aload_0
    //   569: aload 7
    //   571: invokevirtual 141	kotlin/l/b/a/b/h/d$b:iNK	()Lkotlin/l/b/a/b/h/d;
    //   574: putfield 72	kotlin/l/b/a/b/e/a$l:aaZB	Lkotlin/l/b/a/b/h/d;
    //   577: goto -323 -> 254
    //   580: astore_1
    //   581: aload_0
    //   582: aload 7
    //   584: invokevirtual 141	kotlin/l/b/a/b/h/d$b:iNK	()Lkotlin/l/b/a/b/h/d;
    //   587: putfield 72	kotlin/l/b/a/b/e/a$l:aaZB	Lkotlin/l/b/a/b/h/d;
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
    this.aaZB = paramb.aaZB;
  }
  
  public static l d(InputStream paramInputStream, g paramg)
  {
    AppMethodBeat.i(58688);
    paramInputStream = (l)aaZC.j(paramInputStream, paramg);
    AppMethodBeat.o(58688);
    return paramInputStream;
  }
  
  private void iIN()
  {
    AppMethodBeat.i(58684);
    this.abbG = a.o.iLh();
    this.abbH = a.n.iKW();
    this.abbI = a.k.iKD();
    this.abbJ = Collections.emptyList();
    AppMethodBeat.o(58684);
  }
  
  public static l iKI()
  {
    return abbF;
  }
  
  public final int Ad()
  {
    int k = 0;
    AppMethodBeat.i(58687);
    int i = this.bXW;
    if (i != -1)
    {
      AppMethodBeat.o(58687);
      return i;
    }
    if ((this.bQS & 0x1) == 1) {}
    for (int j = f.c(1, this.abbG) + 0;; j = 0)
    {
      i = j;
      if ((this.bQS & 0x2) == 2) {
        i = j + f.c(2, this.abbH);
      }
      j = i;
      if ((this.bQS & 0x4) == 4) {
        j = i + f.c(3, this.abbI);
      }
      i = j;
      j = k;
      while (j < this.abbJ.size())
      {
        k = f.c(4, (r)this.abbJ.get(j));
        j += 1;
        i = k + i;
      }
      i = Ii() + i + this.aaZB.size();
      this.bXW = i;
      AppMethodBeat.o(58687);
      return i;
    }
  }
  
  public final boolean Eq()
  {
    return (this.bQS & 0x4) == 4;
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(58686);
    Ad();
    i.c.a locala = iNU();
    if ((this.bQS & 0x1) == 1) {
      paramf.a(1, this.abbG);
    }
    if ((this.bQS & 0x2) == 2) {
      paramf.a(2, this.abbH);
    }
    if ((this.bQS & 0x4) == 4) {
      paramf.a(3, this.abbI);
    }
    int i = 0;
    while (i < this.abbJ.size())
    {
      paramf.a(4, (r)this.abbJ.get(i));
      i += 1;
    }
    locala.b(200, paramf);
    paramf.e(this.aaZB);
    AppMethodBeat.o(58686);
  }
  
  public final boolean iKJ()
  {
    return (this.bQS & 0x1) == 1;
  }
  
  public final boolean iKK()
  {
    return (this.bQS & 0x2) == 2;
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(58685);
    int i = this.bRd;
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
    if ((iKK()) && (!this.abbH.isInitialized()))
    {
      this.bRd = 0;
      AppMethodBeat.o(58685);
      return false;
    }
    if ((Eq()) && (!this.abbI.isInitialized()))
    {
      this.bRd = 0;
      AppMethodBeat.o(58685);
      return false;
    }
    i = 0;
    while (i < this.abbJ.size())
    {
      if (!((a.b)this.abbJ.get(i)).isInitialized())
      {
        this.bRd = 0;
        AppMethodBeat.o(58685);
        return false;
      }
      i += 1;
    }
    if (!Ig())
    {
      this.bRd = 0;
      AppMethodBeat.o(58685);
      return false;
    }
    this.bRd = 1;
    AppMethodBeat.o(58685);
    return true;
  }
  
  public static final class a
    extends i.b<a.l, a>
    implements l
  {
    private a.o abbG;
    private a.n abbH;
    private a.k abbI;
    private List<a.b> abbJ;
    private int bQS;
    
    private a()
    {
      AppMethodBeat.i(58662);
      this.abbG = a.o.iLh();
      this.abbH = a.n.iKW();
      this.abbI = a.k.iKD();
      this.abbJ = Collections.emptyList();
      AppMethodBeat.o(58662);
    }
    
    private a a(a.n paramn)
    {
      AppMethodBeat.i(58669);
      if (((this.bQS & 0x2) == 2) && (this.abbH != a.n.iKW())) {}
      for (this.abbH = a.n.b(this.abbH).e(paramn).iKY();; this.abbH = paramn)
      {
        this.bQS |= 0x2;
        AppMethodBeat.o(58669);
        return this;
      }
    }
    
    private a a(a.o paramo)
    {
      AppMethodBeat.i(58668);
      if (((this.bQS & 0x1) == 1) && (this.abbG != a.o.iLh())) {}
      for (this.abbG = a.o.b(this.abbG).e(paramo).iLj();; this.abbG = paramo)
      {
        this.bQS |= 0x1;
        AppMethodBeat.o(58668);
        return this;
      }
    }
    
    private a g(a.k paramk)
    {
      AppMethodBeat.i(58670);
      if (((this.bQS & 0x4) == 4) && (this.abbI != a.k.iKD())) {}
      for (this.abbI = a.k.a(this.abbI).f(paramk).iKG();; this.abbI = paramk)
      {
        this.bQS |= 0x4;
        AppMethodBeat.o(58670);
        return this;
      }
    }
    
    private a iKL()
    {
      AppMethodBeat.i(58663);
      a locala = new a().c(iKM());
      AppMethodBeat.o(58663);
      return locala;
    }
    
    private a.l iKM()
    {
      int j = 1;
      AppMethodBeat.i(58664);
      a.l locall = new a.l(this, (byte)0);
      int k = this.bQS;
      if ((k & 0x1) == 1) {}
      for (;;)
      {
        a.l.a(locall, this.abbG);
        int i = j;
        if ((k & 0x2) == 2) {
          i = j | 0x2;
        }
        a.l.a(locall, this.abbH);
        j = i;
        if ((k & 0x4) == 4) {
          j = i | 0x4;
        }
        a.l.a(locall, this.abbI);
        if ((this.bQS & 0x8) == 8)
        {
          this.abbJ = Collections.unmodifiableList(this.abbJ);
          this.bQS &= 0xFFFFFFF7;
        }
        a.l.a(locall, this.abbJ);
        a.l.a(locall, j);
        AppMethodBeat.o(58664);
        return locall;
        j = 0;
      }
    }
    
    private void iKN()
    {
      AppMethodBeat.i(58671);
      if ((this.bQS & 0x8) != 8)
      {
        this.abbJ = new ArrayList(this.abbJ);
        this.bQS |= 0x8;
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
      //   7: getstatic 165	kotlin/l/b/a/b/e/a$l:aaZC	Lkotlin/l/b/a/b/h/t;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 170 3 0
      //   17: checkcast 9	kotlin/l/b/a/b/e/a$l
      //   20: astore_1
      //   21: aload_0
      //   22: aload_1
      //   23: invokevirtual 125	kotlin/l/b/a/b/e/a$l$a:c	(Lkotlin/l/b/a/b/e/a$l;)Lkotlin/l/b/a/b/e/a$l$a;
      //   26: pop
      //   27: ldc 161
      //   29: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   32: aload_0
      //   33: areturn
      //   34: astore_1
      //   35: aload_1
      //   36: getfield 174	kotlin/l/b/a/b/h/l:abgy	Lkotlin/l/b/a/b/h/r;
      //   39: checkcast 9	kotlin/l/b/a/b/e/a$l
      //   42: astore_2
      //   43: ldc 161
      //   45: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   48: aload_1
      //   49: athrow
      //   50: astore_1
      //   51: aload_2
      //   52: ifnull +9 -> 61
      //   55: aload_0
      //   56: aload_2
      //   57: invokevirtual 125	kotlin/l/b/a/b/e/a$l$a:c	(Lkotlin/l/b/a/b/e/a$l;)Lkotlin/l/b/a/b/e/a$l$a;
      //   60: pop
      //   61: ldc 161
      //   63: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   66: aload_1
      //   67: athrow
      //   68: astore_1
      //   69: aload_3
      //   70: astore_2
      //   71: goto -20 -> 51
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	74	0	this	a
      //   0	74	1	parame	kotlin.l.b.a.b.h.e
      //   0	74	2	paramg	g
      //   6	64	3	localObject	java.lang.Object
      // Exception table:
      //   from	to	target	type
      //   7	21	34	kotlin/l/b/a/b/h/l
      //   43	50	50	finally
      //   7	21	68	finally
      //   35	43	68	finally
    }
    
    public final a c(a.l paraml)
    {
      AppMethodBeat.i(58665);
      if (paraml == a.l.iKI())
      {
        AppMethodBeat.o(58665);
        return this;
      }
      if (paraml.iKJ()) {
        a(paraml.abbG);
      }
      if (paraml.iKK()) {
        a(paraml.abbH);
      }
      if (paraml.Eq()) {
        g(paraml.abbI);
      }
      if (!a.l.a(paraml).isEmpty())
      {
        if (!this.abbJ.isEmpty()) {
          break label137;
        }
        this.abbJ = a.l.a(paraml);
        this.bQS &= 0xFFFFFFF7;
      }
      for (;;)
      {
        a(paraml);
        this.aaZB = this.aaZB.a(a.l.b(paraml));
        AppMethodBeat.o(58665);
        return this;
        label137:
        iKN();
        this.abbJ.addAll(a.l.a(paraml));
      }
    }
    
    public final boolean isInitialized()
    {
      AppMethodBeat.i(58666);
      if ((this.bQS & 0x2) == 2) {}
      for (int i = 1; (i != 0) && (!this.abbH.isInitialized()); i = 0)
      {
        AppMethodBeat.o(58666);
        return false;
      }
      if ((this.bQS & 0x4) == 4) {}
      for (i = 1; (i != 0) && (!this.abbI.isInitialized()); i = 0)
      {
        AppMethodBeat.o(58666);
        return false;
      }
      i = 0;
      while (i < this.abbJ.size())
      {
        if (!((a.b)this.abbJ.get(i)).isInitialized())
        {
          AppMethodBeat.o(58666);
          return false;
        }
        i += 1;
      }
      if (!Ig())
      {
        AppMethodBeat.o(58666);
        return false;
      }
      AppMethodBeat.o(58666);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     kotlin.l.b.a.b.e.a.l
 * JD-Core Version:    0.7.0.1
 */