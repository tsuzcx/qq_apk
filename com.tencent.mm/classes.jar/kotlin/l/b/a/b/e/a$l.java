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
import kotlin.l.b.a.b.h.h;
import kotlin.l.b.a.b.h.i.a;
import kotlin.l.b.a.b.h.i.b;
import kotlin.l.b.a.b.h.i.c;
import kotlin.l.b.a.b.h.i.c.a;
import kotlin.l.b.a.b.h.q;
import kotlin.l.b.a.b.h.s;

public final class a$l
  extends i.c<l>
  implements l
{
  public static s<l> TwL;
  private static final l TyO;
  private final d TwK;
  public a.o TyP;
  public a.n TyQ;
  public a.k TyR;
  public List<a.b> TyS;
  private int bOT;
  private byte bPe = -1;
  private int bVY = -1;
  
  static
  {
    AppMethodBeat.i(58691);
    TwL = new b() {};
    l locall = new l();
    TyO = locall;
    locall.hEu();
    AppMethodBeat.o(58691);
  }
  
  private a$l()
  {
    this.TwK = d.TDp;
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
    //   11: putfield 63	kotlin/l/b/a/b/e/a$l:bPe	B
    //   14: aload_0
    //   15: iconst_m1
    //   16: putfield 65	kotlin/l/b/a/b/e/a$l:bVY	I
    //   19: aload_0
    //   20: invokespecial 56	kotlin/l/b/a/b/e/a$l:hEu	()V
    //   23: iconst_0
    //   24: istore_3
    //   25: invokestatic 82	kotlin/l/b/a/b/h/d:hJo	()Lkotlin/l/b/a/b/h/d$b;
    //   28: astore 7
    //   30: aload 7
    //   32: iconst_1
    //   33: invokestatic 88	kotlin/l/b/a/b/h/f:f	(Ljava/io/OutputStream;I)Lkotlin/l/b/a/b/h/f;
    //   36: astore 8
    //   38: iconst_0
    //   39: istore 4
    //   41: iload 4
    //   43: ifne +453 -> 496
    //   46: aload_1
    //   47: invokevirtual 94	kotlin/l/b/a/b/h/e:yT	()I
    //   50: istore 5
    //   52: iload 5
    //   54: lookupswitch	default:+591->645, 0:+594->648, 10:+69->123, 18:+214->268, 26:+325->379, 34:+396->450
    //   105: aload_1
    //   106: aload 8
    //   108: aload_2
    //   109: iload 5
    //   111: invokevirtual 97	kotlin/l/b/a/b/e/a$l:a	(Lkotlin/l/b/a/b/h/e;Lkotlin/l/b/a/b/h/f;Lkotlin/l/b/a/b/h/g;I)Z
    //   114: ifne +528 -> 642
    //   117: iconst_1
    //   118: istore 4
    //   120: goto -79 -> 41
    //   123: aload_0
    //   124: getfield 99	kotlin/l/b/a/b/e/a$l:bOT	I
    //   127: iconst_1
    //   128: iand
    //   129: iconst_1
    //   130: if_icmpne +506 -> 636
    //   133: aload_0
    //   134: getfield 101	kotlin/l/b/a/b/e/a$l:TyP	Lkotlin/l/b/a/b/e/a$o;
    //   137: invokestatic 107	kotlin/l/b/a/b/e/a$o:b	(Lkotlin/l/b/a/b/e/a$o;)Lkotlin/l/b/a/b/e/a$o$a;
    //   140: astore 6
    //   142: aload_0
    //   143: aload_1
    //   144: getstatic 108	kotlin/l/b/a/b/e/a$o:TwL	Lkotlin/l/b/a/b/h/s;
    //   147: aload_2
    //   148: invokevirtual 111	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/s;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/q;
    //   151: checkcast 103	kotlin/l/b/a/b/e/a$o
    //   154: putfield 101	kotlin/l/b/a/b/e/a$l:TyP	Lkotlin/l/b/a/b/e/a$o;
    //   157: aload 6
    //   159: ifnull +22 -> 181
    //   162: aload 6
    //   164: aload_0
    //   165: getfield 101	kotlin/l/b/a/b/e/a$l:TyP	Lkotlin/l/b/a/b/e/a$o;
    //   168: invokevirtual 116	kotlin/l/b/a/b/e/a$o$a:e	(Lkotlin/l/b/a/b/e/a$o;)Lkotlin/l/b/a/b/e/a$o$a;
    //   171: pop
    //   172: aload_0
    //   173: aload 6
    //   175: invokevirtual 120	kotlin/l/b/a/b/e/a$o$a:hGP	()Lkotlin/l/b/a/b/e/a$o;
    //   178: putfield 101	kotlin/l/b/a/b/e/a$l:TyP	Lkotlin/l/b/a/b/e/a$o;
    //   181: aload_0
    //   182: aload_0
    //   183: getfield 99	kotlin/l/b/a/b/e/a$l:bOT	I
    //   186: iconst_1
    //   187: ior
    //   188: putfield 99	kotlin/l/b/a/b/e/a$l:bOT	I
    //   191: goto -150 -> 41
    //   194: astore_1
    //   195: iload_3
    //   196: istore 4
    //   198: iload 4
    //   200: istore_3
    //   201: aload_1
    //   202: aload_0
    //   203: putfield 124	kotlin/l/b/a/b/h/k:TDK	Lkotlin/l/b/a/b/h/q;
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
    //   231: getfield 126	kotlin/l/b/a/b/e/a$l:TyS	Ljava/util/List;
    //   234: invokestatic 132	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   237: putfield 126	kotlin/l/b/a/b/e/a$l:TyS	Ljava/util/List;
    //   240: aload 8
    //   242: invokevirtual 135	kotlin/l/b/a/b/h/f:flush	()V
    //   245: aload_0
    //   246: aload 7
    //   248: invokevirtual 141	kotlin/l/b/a/b/h/d$b:hJs	()Lkotlin/l/b/a/b/h/d;
    //   251: putfield 72	kotlin/l/b/a/b/e/a$l:TwK	Lkotlin/l/b/a/b/h/d;
    //   254: aload_0
    //   255: getfield 145	kotlin/l/b/a/b/h/i$c:TDA	Lkotlin/l/b/a/b/h/h;
    //   258: invokevirtual 150	kotlin/l/b/a/b/h/h:yK	()V
    //   261: ldc 78
    //   263: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   266: aload_1
    //   267: athrow
    //   268: aload_0
    //   269: getfield 99	kotlin/l/b/a/b/e/a$l:bOT	I
    //   272: iconst_2
    //   273: iand
    //   274: iconst_2
    //   275: if_icmpne +355 -> 630
    //   278: aload_0
    //   279: getfield 152	kotlin/l/b/a/b/e/a$l:TyQ	Lkotlin/l/b/a/b/e/a$n;
    //   282: invokestatic 157	kotlin/l/b/a/b/e/a$n:b	(Lkotlin/l/b/a/b/e/a$n;)Lkotlin/l/b/a/b/e/a$n$a;
    //   285: astore 6
    //   287: aload_0
    //   288: aload_1
    //   289: getstatic 158	kotlin/l/b/a/b/e/a$n:TwL	Lkotlin/l/b/a/b/h/s;
    //   292: aload_2
    //   293: invokevirtual 111	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/s;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/q;
    //   296: checkcast 154	kotlin/l/b/a/b/e/a$n
    //   299: putfield 152	kotlin/l/b/a/b/e/a$l:TyQ	Lkotlin/l/b/a/b/e/a$n;
    //   302: aload 6
    //   304: ifnull +22 -> 326
    //   307: aload 6
    //   309: aload_0
    //   310: getfield 152	kotlin/l/b/a/b/e/a$l:TyQ	Lkotlin/l/b/a/b/e/a$n;
    //   313: invokevirtual 162	kotlin/l/b/a/b/e/a$n$a:e	(Lkotlin/l/b/a/b/e/a$n;)Lkotlin/l/b/a/b/e/a$n$a;
    //   316: pop
    //   317: aload_0
    //   318: aload 6
    //   320: invokevirtual 166	kotlin/l/b/a/b/e/a$n$a:hGE	()Lkotlin/l/b/a/b/e/a$n;
    //   323: putfield 152	kotlin/l/b/a/b/e/a$l:TyQ	Lkotlin/l/b/a/b/e/a$n;
    //   326: aload_0
    //   327: aload_0
    //   328: getfield 99	kotlin/l/b/a/b/e/a$l:bOT	I
    //   331: iconst_2
    //   332: ior
    //   333: putfield 99	kotlin/l/b/a/b/e/a$l:bOT	I
    //   336: goto -295 -> 41
    //   339: astore_1
    //   340: iload_3
    //   341: istore 4
    //   343: iload 4
    //   345: istore_3
    //   346: new 75	kotlin/l/b/a/b/h/k
    //   349: dup
    //   350: aload_1
    //   351: invokevirtual 170	java/io/IOException:getMessage	()Ljava/lang/String;
    //   354: invokespecial 173	kotlin/l/b/a/b/h/k:<init>	(Ljava/lang/String;)V
    //   357: astore_1
    //   358: iload 4
    //   360: istore_3
    //   361: aload_1
    //   362: aload_0
    //   363: putfield 124	kotlin/l/b/a/b/h/k:TDK	Lkotlin/l/b/a/b/h/q;
    //   366: iload 4
    //   368: istore_3
    //   369: ldc 78
    //   371: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   374: iload 4
    //   376: istore_3
    //   377: aload_1
    //   378: athrow
    //   379: aload_0
    //   380: getfield 99	kotlin/l/b/a/b/e/a$l:bOT	I
    //   383: iconst_4
    //   384: iand
    //   385: iconst_4
    //   386: if_icmpne +238 -> 624
    //   389: aload_0
    //   390: getfield 175	kotlin/l/b/a/b/e/a$l:TyR	Lkotlin/l/b/a/b/e/a$k;
    //   393: invokevirtual 181	kotlin/l/b/a/b/e/a$k:hGk	()Lkotlin/l/b/a/b/e/a$k$a;
    //   396: astore 6
    //   398: aload_0
    //   399: aload_1
    //   400: getstatic 182	kotlin/l/b/a/b/e/a$k:TwL	Lkotlin/l/b/a/b/h/s;
    //   403: aload_2
    //   404: invokevirtual 111	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/s;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/q;
    //   407: checkcast 177	kotlin/l/b/a/b/e/a$k
    //   410: putfield 175	kotlin/l/b/a/b/e/a$l:TyR	Lkotlin/l/b/a/b/e/a$k;
    //   413: aload 6
    //   415: ifnull +22 -> 437
    //   418: aload 6
    //   420: aload_0
    //   421: getfield 175	kotlin/l/b/a/b/e/a$l:TyR	Lkotlin/l/b/a/b/e/a$k;
    //   424: invokevirtual 187	kotlin/l/b/a/b/e/a$k$a:f	(Lkotlin/l/b/a/b/e/a$k;)Lkotlin/l/b/a/b/e/a$k$a;
    //   427: pop
    //   428: aload_0
    //   429: aload 6
    //   431: invokevirtual 191	kotlin/l/b/a/b/e/a$k$a:hGm	()Lkotlin/l/b/a/b/e/a$k;
    //   434: putfield 175	kotlin/l/b/a/b/e/a$l:TyR	Lkotlin/l/b/a/b/e/a$k;
    //   437: aload_0
    //   438: aload_0
    //   439: getfield 99	kotlin/l/b/a/b/e/a$l:bOT	I
    //   442: iconst_4
    //   443: ior
    //   444: putfield 99	kotlin/l/b/a/b/e/a$l:bOT	I
    //   447: goto -406 -> 41
    //   450: iload_3
    //   451: bipush 8
    //   453: iand
    //   454: bipush 8
    //   456: if_icmpeq +165 -> 621
    //   459: aload_0
    //   460: new 193	java/util/ArrayList
    //   463: dup
    //   464: invokespecial 194	java/util/ArrayList:<init>	()V
    //   467: putfield 126	kotlin/l/b/a/b/e/a$l:TyS	Ljava/util/List;
    //   470: iload_3
    //   471: bipush 8
    //   473: ior
    //   474: istore_3
    //   475: aload_0
    //   476: getfield 126	kotlin/l/b/a/b/e/a$l:TyS	Ljava/util/List;
    //   479: aload_1
    //   480: getstatic 197	kotlin/l/b/a/b/e/a$b:TwL	Lkotlin/l/b/a/b/h/s;
    //   483: aload_2
    //   484: invokevirtual 111	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/s;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/q;
    //   487: invokeinterface 203 2 0
    //   492: pop
    //   493: goto -452 -> 41
    //   496: iload_3
    //   497: bipush 8
    //   499: iand
    //   500: bipush 8
    //   502: if_icmpne +14 -> 516
    //   505: aload_0
    //   506: aload_0
    //   507: getfield 126	kotlin/l/b/a/b/e/a$l:TyS	Ljava/util/List;
    //   510: invokestatic 132	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   513: putfield 126	kotlin/l/b/a/b/e/a$l:TyS	Ljava/util/List;
    //   516: aload 8
    //   518: invokevirtual 135	kotlin/l/b/a/b/h/f:flush	()V
    //   521: aload_0
    //   522: aload 7
    //   524: invokevirtual 141	kotlin/l/b/a/b/h/d$b:hJs	()Lkotlin/l/b/a/b/h/d;
    //   527: putfield 72	kotlin/l/b/a/b/e/a$l:TwK	Lkotlin/l/b/a/b/h/d;
    //   530: aload_0
    //   531: getfield 145	kotlin/l/b/a/b/h/i$c:TDA	Lkotlin/l/b/a/b/h/h;
    //   534: invokevirtual 150	kotlin/l/b/a/b/h/h:yK	()V
    //   537: ldc 78
    //   539: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   542: return
    //   543: astore_1
    //   544: aload_0
    //   545: aload 7
    //   547: invokevirtual 141	kotlin/l/b/a/b/h/d$b:hJs	()Lkotlin/l/b/a/b/h/d;
    //   550: putfield 72	kotlin/l/b/a/b/e/a$l:TwK	Lkotlin/l/b/a/b/h/d;
    //   553: goto -23 -> 530
    //   556: astore_1
    //   557: aload_0
    //   558: aload 7
    //   560: invokevirtual 141	kotlin/l/b/a/b/h/d$b:hJs	()Lkotlin/l/b/a/b/h/d;
    //   563: putfield 72	kotlin/l/b/a/b/e/a$l:TwK	Lkotlin/l/b/a/b/h/d;
    //   566: ldc 78
    //   568: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   571: aload_1
    //   572: athrow
    //   573: astore_2
    //   574: aload_0
    //   575: aload 7
    //   577: invokevirtual 141	kotlin/l/b/a/b/h/d$b:hJs	()Lkotlin/l/b/a/b/h/d;
    //   580: putfield 72	kotlin/l/b/a/b/e/a$l:TwK	Lkotlin/l/b/a/b/h/d;
    //   583: goto -329 -> 254
    //   586: astore_1
    //   587: aload_0
    //   588: aload 7
    //   590: invokevirtual 141	kotlin/l/b/a/b/h/d$b:hJs	()Lkotlin/l/b/a/b/h/d;
    //   593: putfield 72	kotlin/l/b/a/b/e/a$l:TwK	Lkotlin/l/b/a/b/h/d;
    //   596: ldc 78
    //   598: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   601: aload_1
    //   602: athrow
    //   603: astore_1
    //   604: goto -384 -> 220
    //   607: astore_1
    //   608: iload_3
    //   609: istore 4
    //   611: goto -268 -> 343
    //   614: astore_1
    //   615: iload_3
    //   616: istore 4
    //   618: goto -420 -> 198
    //   621: goto -146 -> 475
    //   624: aconst_null
    //   625: astore 6
    //   627: goto -229 -> 398
    //   630: aconst_null
    //   631: astore 6
    //   633: goto -346 -> 287
    //   636: aconst_null
    //   637: astore 6
    //   639: goto -497 -> 142
    //   642: goto -149 -> 493
    //   645: goto -541 -> 104
    //   648: iconst_1
    //   649: istore 4
    //   651: goto -610 -> 41
    //   654: astore_1
    //   655: goto -435 -> 220
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	658	0	this	l
    //   0	658	1	parame	kotlin.l.b.a.b.h.e
    //   0	658	2	paramg	g
    //   24	592	3	i	int
    //   39	611	4	j	int
    //   50	60	5	k	int
    //   140	498	6	localObject	java.lang.Object
    //   28	561	7	localb	kotlin.l.b.a.b.h.d.b
    //   36	481	8	localf	f
    // Exception table:
    //   from	to	target	type
    //   46	52	194	kotlin/l/b/a/b/h/k
    //   104	117	194	kotlin/l/b/a/b/h/k
    //   123	142	194	kotlin/l/b/a/b/h/k
    //   142	157	194	kotlin/l/b/a/b/h/k
    //   162	181	194	kotlin/l/b/a/b/h/k
    //   181	191	194	kotlin/l/b/a/b/h/k
    //   268	287	194	kotlin/l/b/a/b/h/k
    //   287	302	194	kotlin/l/b/a/b/h/k
    //   307	326	194	kotlin/l/b/a/b/h/k
    //   326	336	194	kotlin/l/b/a/b/h/k
    //   379	398	194	kotlin/l/b/a/b/h/k
    //   398	413	194	kotlin/l/b/a/b/h/k
    //   418	437	194	kotlin/l/b/a/b/h/k
    //   437	447	194	kotlin/l/b/a/b/h/k
    //   459	470	194	kotlin/l/b/a/b/h/k
    //   201	206	219	finally
    //   209	214	219	finally
    //   217	219	219	finally
    //   346	358	219	finally
    //   361	366	219	finally
    //   369	374	219	finally
    //   377	379	219	finally
    //   46	52	339	java/io/IOException
    //   104	117	339	java/io/IOException
    //   123	142	339	java/io/IOException
    //   142	157	339	java/io/IOException
    //   162	181	339	java/io/IOException
    //   181	191	339	java/io/IOException
    //   268	287	339	java/io/IOException
    //   287	302	339	java/io/IOException
    //   307	326	339	java/io/IOException
    //   326	336	339	java/io/IOException
    //   379	398	339	java/io/IOException
    //   398	413	339	java/io/IOException
    //   418	437	339	java/io/IOException
    //   437	447	339	java/io/IOException
    //   459	470	339	java/io/IOException
    //   516	521	543	java/io/IOException
    //   516	521	556	finally
    //   240	245	573	java/io/IOException
    //   240	245	586	finally
    //   475	493	603	finally
    //   475	493	607	java/io/IOException
    //   475	493	614	kotlin/l/b/a/b/h/k
    //   46	52	654	finally
    //   104	117	654	finally
    //   123	142	654	finally
    //   142	157	654	finally
    //   162	181	654	finally
    //   181	191	654	finally
    //   268	287	654	finally
    //   287	302	654	finally
    //   307	326	654	finally
    //   326	336	654	finally
    //   379	398	654	finally
    //   398	413	654	finally
    //   418	437	654	finally
    //   437	447	654	finally
    //   459	470	654	finally
  }
  
  private a$l(i.b<l, ?> paramb)
  {
    super(paramb);
    this.TwK = paramb.TwK;
  }
  
  public static l d(InputStream paramInputStream, g paramg)
  {
    AppMethodBeat.i(58688);
    paramInputStream = (l)TwL.j(paramInputStream, paramg);
    AppMethodBeat.o(58688);
    return paramInputStream;
  }
  
  private void hEu()
  {
    AppMethodBeat.i(58684);
    this.TyP = a.o.hGN();
    this.TyQ = a.n.hGC();
    this.TyR = a.k.hGj();
    this.TyS = Collections.emptyList();
    AppMethodBeat.o(58684);
  }
  
  public static l hGo()
  {
    return TyO;
  }
  
  public final boolean CL()
  {
    return (this.bOT & 0x4) == 4;
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(58686);
    yC();
    i.c.a locala = hJC();
    if ((this.bOT & 0x1) == 1) {
      paramf.a(1, this.TyP);
    }
    if ((this.bOT & 0x2) == 2) {
      paramf.a(2, this.TyQ);
    }
    if ((this.bOT & 0x4) == 4) {
      paramf.a(3, this.TyR);
    }
    int i = 0;
    while (i < this.TyS.size())
    {
      paramf.a(4, (q)this.TyS.get(i));
      i += 1;
    }
    locala.b(200, paramf);
    paramf.e(this.TwK);
    AppMethodBeat.o(58686);
  }
  
  public final s<l> hEs()
  {
    return TwL;
  }
  
  public final boolean hGp()
  {
    return (this.bOT & 0x1) == 1;
  }
  
  public final boolean hGq()
  {
    return (this.bOT & 0x2) == 2;
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(58685);
    int i = this.bPe;
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
    if ((hGq()) && (!this.TyQ.isInitialized()))
    {
      this.bPe = 0;
      AppMethodBeat.o(58685);
      return false;
    }
    if ((CL()) && (!this.TyR.isInitialized()))
    {
      this.bPe = 0;
      AppMethodBeat.o(58685);
      return false;
    }
    i = 0;
    while (i < this.TyS.size())
    {
      if (!((a.b)this.TyS.get(i)).isInitialized())
      {
        this.bPe = 0;
        AppMethodBeat.o(58685);
        return false;
      }
      i += 1;
    }
    if (!this.TDA.isInitialized())
    {
      this.bPe = 0;
      AppMethodBeat.o(58685);
      return false;
    }
    this.bPe = 1;
    AppMethodBeat.o(58685);
    return true;
  }
  
  public final int yC()
  {
    int k = 0;
    AppMethodBeat.i(58687);
    int i = this.bVY;
    if (i != -1)
    {
      AppMethodBeat.o(58687);
      return i;
    }
    if ((this.bOT & 0x1) == 1) {}
    for (int j = f.c(1, this.TyP) + 0;; j = 0)
    {
      i = j;
      if ((this.bOT & 0x2) == 2) {
        i = j + f.c(2, this.TyQ);
      }
      j = i;
      if ((this.bOT & 0x4) == 4) {
        j = i + f.c(3, this.TyR);
      }
      i = j;
      j = k;
      while (j < this.TyS.size())
      {
        k = f.c(4, (q)this.TyS.get(j));
        j += 1;
        i = k + i;
      }
      i = this.TDA.yC() + i + this.TwK.size();
      this.bVY = i;
      AppMethodBeat.o(58687);
      return i;
    }
  }
  
  public static final class a
    extends i.b<a.l, a>
    implements l
  {
    private a.o TyP;
    private a.n TyQ;
    private a.k TyR;
    private List<a.b> TyS;
    private int bOT;
    
    private a()
    {
      AppMethodBeat.i(58662);
      this.TyP = a.o.hGN();
      this.TyQ = a.n.hGC();
      this.TyR = a.k.hGj();
      this.TyS = Collections.emptyList();
      AppMethodBeat.o(58662);
    }
    
    private a a(a.n paramn)
    {
      AppMethodBeat.i(58669);
      if (((this.bOT & 0x2) == 2) && (this.TyQ != a.n.hGC())) {}
      for (this.TyQ = a.n.b(this.TyQ).e(paramn).hGE();; this.TyQ = paramn)
      {
        this.bOT |= 0x2;
        AppMethodBeat.o(58669);
        return this;
      }
    }
    
    private a a(a.o paramo)
    {
      AppMethodBeat.i(58668);
      if (((this.bOT & 0x1) == 1) && (this.TyP != a.o.hGN())) {}
      for (this.TyP = a.o.b(this.TyP).e(paramo).hGP();; this.TyP = paramo)
      {
        this.bOT |= 0x1;
        AppMethodBeat.o(58668);
        return this;
      }
    }
    
    private a g(a.k paramk)
    {
      AppMethodBeat.i(58670);
      if (((this.bOT & 0x4) == 4) && (this.TyR != a.k.hGj())) {}
      for (this.TyR = a.k.a(this.TyR).f(paramk).hGm();; this.TyR = paramk)
      {
        this.bOT |= 0x4;
        AppMethodBeat.o(58670);
        return this;
      }
    }
    
    private a hGr()
    {
      AppMethodBeat.i(58663);
      a locala = new a().c(hGs());
      AppMethodBeat.o(58663);
      return locala;
    }
    
    private a.l hGs()
    {
      int j = 1;
      AppMethodBeat.i(58664);
      a.l locall = new a.l(this, (byte)0);
      int k = this.bOT;
      if ((k & 0x1) == 1) {}
      for (;;)
      {
        a.l.a(locall, this.TyP);
        int i = j;
        if ((k & 0x2) == 2) {
          i = j | 0x2;
        }
        a.l.a(locall, this.TyQ);
        j = i;
        if ((k & 0x4) == 4) {
          j = i | 0x4;
        }
        a.l.a(locall, this.TyR);
        if ((this.bOT & 0x8) == 8)
        {
          this.TyS = Collections.unmodifiableList(this.TyS);
          this.bOT &= 0xFFFFFFF7;
        }
        a.l.a(locall, this.TyS);
        a.l.a(locall, j);
        AppMethodBeat.o(58664);
        return locall;
        j = 0;
      }
    }
    
    private void hGt()
    {
      AppMethodBeat.i(58671);
      if ((this.bOT & 0x8) != 8)
      {
        this.TyS = new ArrayList(this.TyS);
        this.bOT |= 0x8;
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
      //   7: getstatic 165	kotlin/l/b/a/b/e/a$l:TwL	Lkotlin/l/b/a/b/h/s;
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
      //   36: getfield 174	kotlin/l/b/a/b/h/k:TDK	Lkotlin/l/b/a/b/h/q;
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
      //   7	21	34	kotlin/l/b/a/b/h/k
      //   43	50	50	finally
      //   7	21	68	finally
      //   35	43	68	finally
    }
    
    public final a c(a.l paraml)
    {
      AppMethodBeat.i(58665);
      if (paraml == a.l.hGo())
      {
        AppMethodBeat.o(58665);
        return this;
      }
      if (paraml.hGp()) {
        a(paraml.TyP);
      }
      if (paraml.hGq()) {
        a(paraml.TyQ);
      }
      if (paraml.CL()) {
        g(paraml.TyR);
      }
      if (!a.l.a(paraml).isEmpty())
      {
        if (!this.TyS.isEmpty()) {
          break label137;
        }
        this.TyS = a.l.a(paraml);
        this.bOT &= 0xFFFFFFF7;
      }
      for (;;)
      {
        a(paraml);
        this.TwK = this.TwK.a(a.l.b(paraml));
        AppMethodBeat.o(58665);
        return this;
        label137:
        hGt();
        this.TyS.addAll(a.l.a(paraml));
      }
    }
    
    public final boolean isInitialized()
    {
      AppMethodBeat.i(58666);
      if ((this.bOT & 0x2) == 2) {}
      for (int i = 1; (i != 0) && (!this.TyQ.isInitialized()); i = 0)
      {
        AppMethodBeat.o(58666);
        return false;
      }
      if ((this.bOT & 0x4) == 4) {}
      for (i = 1; (i != 0) && (!this.TyR.isInitialized()); i = 0)
      {
        AppMethodBeat.o(58666);
        return false;
      }
      i = 0;
      while (i < this.TyS.size())
      {
        if (!((a.b)this.TyS.get(i)).isInitialized())
        {
          AppMethodBeat.o(58666);
          return false;
        }
        i += 1;
      }
      if (!this.TDA.isInitialized())
      {
        AppMethodBeat.o(58666);
        return false;
      }
      AppMethodBeat.o(58666);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     kotlin.l.b.a.b.e.a.l
 * JD-Core Version:    0.7.0.1
 */