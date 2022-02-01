package kotlin.l.b.a.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.l.b.a.b.h.b;
import kotlin.l.b.a.b.h.d;
import kotlin.l.b.a.b.h.f;
import kotlin.l.b.a.b.h.i;
import kotlin.l.b.a.b.h.i.a;
import kotlin.l.b.a.b.h.k.a;
import kotlin.l.b.a.b.h.k.b;
import kotlin.l.b.a.b.h.r;
import kotlin.l.b.a.b.h.t;

public final class a$e
  extends i
  implements h
{
  public static t<e> aiYa;
  private static final e aiZo;
  private final d aiXZ;
  b aiZp;
  private List<a.g> aiZq;
  a.g aiZr;
  c aiZs;
  private int bitField0_;
  private int dRJ = -1;
  private byte memoizedIsInitialized = -1;
  
  static
  {
    AppMethodBeat.i(58526);
    aiYa = new b() {};
    e locale = new e();
    aiZo = locale;
    locale.ktf();
    AppMethodBeat.o(58526);
  }
  
  private a$e()
  {
    this.aiXZ = d.ajeU;
  }
  
  /* Error */
  private a$e(kotlin.l.b.a.b.h.e parame, kotlin.l.b.a.b.h.g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 70	kotlin/l/b/a/b/h/i:<init>	()V
    //   4: ldc 87
    //   6: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 72	kotlin/l/b/a/b/e/a$e:memoizedIsInitialized	B
    //   14: aload_0
    //   15: iconst_m1
    //   16: putfield 74	kotlin/l/b/a/b/e/a$e:dRJ	I
    //   19: aload_0
    //   20: invokespecial 65	kotlin/l/b/a/b/e/a$e:ktf	()V
    //   23: invokestatic 91	kotlin/l/b/a/b/h/d:kya	()Lkotlin/l/b/a/b/h/d$b;
    //   26: astore 11
    //   28: aload 11
    //   30: iconst_1
    //   31: invokestatic 96	kotlin/l/b/a/b/h/f:i	(Ljava/io/OutputStream;I)Lkotlin/l/b/a/b/h/f;
    //   34: astore 12
    //   36: iconst_0
    //   37: istore 6
    //   39: iconst_0
    //   40: istore_3
    //   41: iload 6
    //   43: ifne +620 -> 663
    //   46: iload_3
    //   47: istore 7
    //   49: iload_3
    //   50: istore 5
    //   52: iload_3
    //   53: istore 8
    //   55: aload_1
    //   56: invokevirtual 102	kotlin/l/b/a/b/h/e:aac	()I
    //   59: istore 4
    //   61: iload 4
    //   63: lookupswitch	default:+708->771, 0:+711->774, 8:+77->140, 18:+296->359, 26:+367->430, 32:+492->555
    //   113: istore 7
    //   115: iload_3
    //   116: istore 5
    //   118: iload_3
    //   119: istore 8
    //   121: aload_0
    //   122: aload_1
    //   123: aload 12
    //   125: aload_2
    //   126: iload 4
    //   128: invokevirtual 105	kotlin/l/b/a/b/e/a$e:a	(Lkotlin/l/b/a/b/h/e;Lkotlin/l/b/a/b/h/f;Lkotlin/l/b/a/b/h/g;I)Z
    //   131: ifne -90 -> 41
    //   134: iconst_1
    //   135: istore 6
    //   137: goto -96 -> 41
    //   140: iload_3
    //   141: istore 7
    //   143: iload_3
    //   144: istore 5
    //   146: iload_3
    //   147: istore 8
    //   149: aload_1
    //   150: invokevirtual 108	kotlin/l/b/a/b/h/e:aar	()I
    //   153: istore 9
    //   155: iload_3
    //   156: istore 7
    //   158: iload_3
    //   159: istore 5
    //   161: iload_3
    //   162: istore 8
    //   164: iload 9
    //   166: invokestatic 112	kotlin/l/b/a/b/e/a$e$b:aKS	(I)Lkotlin/l/b/a/b/e/a$e$b;
    //   169: astore 10
    //   171: aload 10
    //   173: ifnonnull +108 -> 281
    //   176: iload_3
    //   177: istore 7
    //   179: iload_3
    //   180: istore 5
    //   182: iload_3
    //   183: istore 8
    //   185: aload 12
    //   187: iload 4
    //   189: invokevirtual 115	kotlin/l/b/a/b/h/f:lI	(I)V
    //   192: iload_3
    //   193: istore 7
    //   195: iload_3
    //   196: istore 5
    //   198: iload_3
    //   199: istore 8
    //   201: aload 12
    //   203: iload 9
    //   205: invokevirtual 115	kotlin/l/b/a/b/h/f:lI	(I)V
    //   208: goto -167 -> 41
    //   211: astore_1
    //   212: iload 7
    //   214: istore 5
    //   216: aload_1
    //   217: aload_0
    //   218: putfield 119	kotlin/l/b/a/b/h/l:ajfp	Lkotlin/l/b/a/b/h/r;
    //   221: iload 7
    //   223: istore 5
    //   225: ldc 87
    //   227: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   230: iload 7
    //   232: istore 5
    //   234: aload_1
    //   235: athrow
    //   236: astore_1
    //   237: iload 5
    //   239: iconst_2
    //   240: iand
    //   241: iconst_2
    //   242: if_icmpne +14 -> 256
    //   245: aload_0
    //   246: aload_0
    //   247: getfield 121	kotlin/l/b/a/b/e/a$e:aiZq	Ljava/util/List;
    //   250: invokestatic 127	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   253: putfield 121	kotlin/l/b/a/b/e/a$e:aiZq	Ljava/util/List;
    //   256: aload 12
    //   258: invokevirtual 130	kotlin/l/b/a/b/h/f:flush	()V
    //   261: aload_0
    //   262: aload 11
    //   264: invokevirtual 136	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   267: putfield 81	kotlin/l/b/a/b/e/a$e:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   270: aload_0
    //   271: invokevirtual 139	kotlin/l/b/a/b/e/a$e:makeExtensionsImmutable	()V
    //   274: ldc 87
    //   276: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   279: aload_1
    //   280: athrow
    //   281: iload_3
    //   282: istore 7
    //   284: iload_3
    //   285: istore 5
    //   287: iload_3
    //   288: istore 8
    //   290: aload_0
    //   291: aload_0
    //   292: getfield 141	kotlin/l/b/a/b/e/a$e:bitField0_	I
    //   295: iconst_1
    //   296: ior
    //   297: putfield 141	kotlin/l/b/a/b/e/a$e:bitField0_	I
    //   300: iload_3
    //   301: istore 7
    //   303: iload_3
    //   304: istore 5
    //   306: iload_3
    //   307: istore 8
    //   309: aload_0
    //   310: aload 10
    //   312: putfield 143	kotlin/l/b/a/b/e/a$e:aiZp	Lkotlin/l/b/a/b/e/a$e$b;
    //   315: goto -274 -> 41
    //   318: astore_1
    //   319: iload 8
    //   321: istore 5
    //   323: new 84	kotlin/l/b/a/b/h/l
    //   326: dup
    //   327: aload_1
    //   328: invokevirtual 147	java/io/IOException:getMessage	()Ljava/lang/String;
    //   331: invokespecial 150	kotlin/l/b/a/b/h/l:<init>	(Ljava/lang/String;)V
    //   334: astore_1
    //   335: iload 8
    //   337: istore 5
    //   339: aload_1
    //   340: aload_0
    //   341: putfield 119	kotlin/l/b/a/b/h/l:ajfp	Lkotlin/l/b/a/b/h/r;
    //   344: iload 8
    //   346: istore 5
    //   348: ldc 87
    //   350: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   353: iload 8
    //   355: istore 5
    //   357: aload_1
    //   358: athrow
    //   359: iload_3
    //   360: istore 4
    //   362: iload_3
    //   363: iconst_2
    //   364: iand
    //   365: iconst_2
    //   366: if_icmpeq +28 -> 394
    //   369: iload_3
    //   370: istore 7
    //   372: iload_3
    //   373: istore 5
    //   375: iload_3
    //   376: istore 8
    //   378: aload_0
    //   379: new 152	java/util/ArrayList
    //   382: dup
    //   383: invokespecial 153	java/util/ArrayList:<init>	()V
    //   386: putfield 121	kotlin/l/b/a/b/e/a$e:aiZq	Ljava/util/List;
    //   389: iload_3
    //   390: iconst_2
    //   391: ior
    //   392: istore 4
    //   394: iload 4
    //   396: istore 7
    //   398: iload 4
    //   400: istore 5
    //   402: iload 4
    //   404: istore 8
    //   406: aload_0
    //   407: getfield 121	kotlin/l/b/a/b/e/a$e:aiZq	Ljava/util/List;
    //   410: aload_1
    //   411: getstatic 156	kotlin/l/b/a/b/e/a$g:aiYa	Lkotlin/l/b/a/b/h/t;
    //   414: aload_2
    //   415: invokevirtual 159	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/t;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/r;
    //   418: invokeinterface 165 2 0
    //   423: pop
    //   424: iload 4
    //   426: istore_3
    //   427: goto -386 -> 41
    //   430: iload_3
    //   431: istore 7
    //   433: iload_3
    //   434: istore 5
    //   436: iload_3
    //   437: istore 8
    //   439: aload_0
    //   440: getfield 141	kotlin/l/b/a/b/e/a$e:bitField0_	I
    //   443: iconst_2
    //   444: iand
    //   445: iconst_2
    //   446: if_icmpne +319 -> 765
    //   449: iload_3
    //   450: istore 7
    //   452: iload_3
    //   453: istore 5
    //   455: iload_3
    //   456: istore 8
    //   458: aload_0
    //   459: getfield 167	kotlin/l/b/a/b/e/a$e:aiZr	Lkotlin/l/b/a/b/e/a$g;
    //   462: invokestatic 170	kotlin/l/b/a/b/e/a$g:b	(Lkotlin/l/b/a/b/e/a$g;)Lkotlin/l/b/a/b/e/a$g$a;
    //   465: astore 10
    //   467: iload_3
    //   468: istore 7
    //   470: iload_3
    //   471: istore 5
    //   473: iload_3
    //   474: istore 8
    //   476: aload_0
    //   477: aload_1
    //   478: getstatic 156	kotlin/l/b/a/b/e/a$g:aiYa	Lkotlin/l/b/a/b/h/t;
    //   481: aload_2
    //   482: invokevirtual 159	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/t;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/r;
    //   485: checkcast 155	kotlin/l/b/a/b/e/a$g
    //   488: putfield 167	kotlin/l/b/a/b/e/a$e:aiZr	Lkotlin/l/b/a/b/e/a$g;
    //   491: aload 10
    //   493: ifnull +40 -> 533
    //   496: iload_3
    //   497: istore 7
    //   499: iload_3
    //   500: istore 5
    //   502: iload_3
    //   503: istore 8
    //   505: aload 10
    //   507: aload_0
    //   508: getfield 167	kotlin/l/b/a/b/e/a$e:aiZr	Lkotlin/l/b/a/b/e/a$g;
    //   511: invokevirtual 175	kotlin/l/b/a/b/e/a$g$a:f	(Lkotlin/l/b/a/b/e/a$g;)Lkotlin/l/b/a/b/e/a$g$a;
    //   514: pop
    //   515: iload_3
    //   516: istore 7
    //   518: iload_3
    //   519: istore 5
    //   521: iload_3
    //   522: istore 8
    //   524: aload_0
    //   525: aload 10
    //   527: invokevirtual 179	kotlin/l/b/a/b/e/a$g$a:kuK	()Lkotlin/l/b/a/b/e/a$g;
    //   530: putfield 167	kotlin/l/b/a/b/e/a$e:aiZr	Lkotlin/l/b/a/b/e/a$g;
    //   533: iload_3
    //   534: istore 7
    //   536: iload_3
    //   537: istore 5
    //   539: iload_3
    //   540: istore 8
    //   542: aload_0
    //   543: aload_0
    //   544: getfield 141	kotlin/l/b/a/b/e/a$e:bitField0_	I
    //   547: iconst_2
    //   548: ior
    //   549: putfield 141	kotlin/l/b/a/b/e/a$e:bitField0_	I
    //   552: goto -511 -> 41
    //   555: iload_3
    //   556: istore 7
    //   558: iload_3
    //   559: istore 5
    //   561: iload_3
    //   562: istore 8
    //   564: aload_1
    //   565: invokevirtual 108	kotlin/l/b/a/b/h/e:aar	()I
    //   568: istore 9
    //   570: iload_3
    //   571: istore 7
    //   573: iload_3
    //   574: istore 5
    //   576: iload_3
    //   577: istore 8
    //   579: iload 9
    //   581: invokestatic 183	kotlin/l/b/a/b/e/a$e$c:aKT	(I)Lkotlin/l/b/a/b/e/a$e$c;
    //   584: astore 10
    //   586: aload 10
    //   588: ifnonnull +38 -> 626
    //   591: iload_3
    //   592: istore 7
    //   594: iload_3
    //   595: istore 5
    //   597: iload_3
    //   598: istore 8
    //   600: aload 12
    //   602: iload 4
    //   604: invokevirtual 115	kotlin/l/b/a/b/h/f:lI	(I)V
    //   607: iload_3
    //   608: istore 7
    //   610: iload_3
    //   611: istore 5
    //   613: iload_3
    //   614: istore 8
    //   616: aload 12
    //   618: iload 9
    //   620: invokevirtual 115	kotlin/l/b/a/b/h/f:lI	(I)V
    //   623: goto -582 -> 41
    //   626: iload_3
    //   627: istore 7
    //   629: iload_3
    //   630: istore 5
    //   632: iload_3
    //   633: istore 8
    //   635: aload_0
    //   636: aload_0
    //   637: getfield 141	kotlin/l/b/a/b/e/a$e:bitField0_	I
    //   640: iconst_4
    //   641: ior
    //   642: putfield 141	kotlin/l/b/a/b/e/a$e:bitField0_	I
    //   645: iload_3
    //   646: istore 7
    //   648: iload_3
    //   649: istore 5
    //   651: iload_3
    //   652: istore 8
    //   654: aload_0
    //   655: aload 10
    //   657: putfield 185	kotlin/l/b/a/b/e/a$e:aiZs	Lkotlin/l/b/a/b/e/a$e$c;
    //   660: goto -619 -> 41
    //   663: iload_3
    //   664: iconst_2
    //   665: iand
    //   666: iconst_2
    //   667: if_icmpne +14 -> 681
    //   670: aload_0
    //   671: aload_0
    //   672: getfield 121	kotlin/l/b/a/b/e/a$e:aiZq	Ljava/util/List;
    //   675: invokestatic 127	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   678: putfield 121	kotlin/l/b/a/b/e/a$e:aiZq	Ljava/util/List;
    //   681: aload 12
    //   683: invokevirtual 130	kotlin/l/b/a/b/h/f:flush	()V
    //   686: aload_0
    //   687: aload 11
    //   689: invokevirtual 136	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   692: putfield 81	kotlin/l/b/a/b/e/a$e:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   695: aload_0
    //   696: invokevirtual 139	kotlin/l/b/a/b/e/a$e:makeExtensionsImmutable	()V
    //   699: ldc 87
    //   701: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   704: return
    //   705: astore_1
    //   706: aload_0
    //   707: aload 11
    //   709: invokevirtual 136	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   712: putfield 81	kotlin/l/b/a/b/e/a$e:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   715: goto -20 -> 695
    //   718: astore_1
    //   719: aload_0
    //   720: aload 11
    //   722: invokevirtual 136	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   725: putfield 81	kotlin/l/b/a/b/e/a$e:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   728: ldc 87
    //   730: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   733: aload_1
    //   734: athrow
    //   735: astore_2
    //   736: aload_0
    //   737: aload 11
    //   739: invokevirtual 136	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   742: putfield 81	kotlin/l/b/a/b/e/a$e:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   745: goto -475 -> 270
    //   748: astore_1
    //   749: aload_0
    //   750: aload 11
    //   752: invokevirtual 136	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   755: putfield 81	kotlin/l/b/a/b/e/a$e:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   758: ldc 87
    //   760: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   763: aload_1
    //   764: athrow
    //   765: aconst_null
    //   766: astore 10
    //   768: goto -301 -> 467
    //   771: goto -659 -> 112
    //   774: iconst_1
    //   775: istore 6
    //   777: goto -736 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	780	0	this	e
    //   0	780	1	parame	kotlin.l.b.a.b.h.e
    //   0	780	2	paramg	kotlin.l.b.a.b.h.g
    //   40	626	3	i	int
    //   59	544	4	j	int
    //   50	600	5	k	int
    //   37	739	6	m	int
    //   47	600	7	n	int
    //   53	600	8	i1	int
    //   153	466	9	i2	int
    //   169	598	10	localObject	Object
    //   26	725	11	localb	kotlin.l.b.a.b.h.d.b
    //   34	648	12	localf	f
    // Exception table:
    //   from	to	target	type
    //   55	61	211	kotlin/l/b/a/b/h/l
    //   121	134	211	kotlin/l/b/a/b/h/l
    //   149	155	211	kotlin/l/b/a/b/h/l
    //   164	171	211	kotlin/l/b/a/b/h/l
    //   185	192	211	kotlin/l/b/a/b/h/l
    //   201	208	211	kotlin/l/b/a/b/h/l
    //   290	300	211	kotlin/l/b/a/b/h/l
    //   309	315	211	kotlin/l/b/a/b/h/l
    //   378	389	211	kotlin/l/b/a/b/h/l
    //   406	424	211	kotlin/l/b/a/b/h/l
    //   439	449	211	kotlin/l/b/a/b/h/l
    //   458	467	211	kotlin/l/b/a/b/h/l
    //   476	491	211	kotlin/l/b/a/b/h/l
    //   505	515	211	kotlin/l/b/a/b/h/l
    //   524	533	211	kotlin/l/b/a/b/h/l
    //   542	552	211	kotlin/l/b/a/b/h/l
    //   564	570	211	kotlin/l/b/a/b/h/l
    //   579	586	211	kotlin/l/b/a/b/h/l
    //   600	607	211	kotlin/l/b/a/b/h/l
    //   616	623	211	kotlin/l/b/a/b/h/l
    //   635	645	211	kotlin/l/b/a/b/h/l
    //   654	660	211	kotlin/l/b/a/b/h/l
    //   55	61	236	finally
    //   121	134	236	finally
    //   149	155	236	finally
    //   164	171	236	finally
    //   185	192	236	finally
    //   201	208	236	finally
    //   216	221	236	finally
    //   225	230	236	finally
    //   234	236	236	finally
    //   290	300	236	finally
    //   309	315	236	finally
    //   323	335	236	finally
    //   339	344	236	finally
    //   348	353	236	finally
    //   357	359	236	finally
    //   378	389	236	finally
    //   406	424	236	finally
    //   439	449	236	finally
    //   458	467	236	finally
    //   476	491	236	finally
    //   505	515	236	finally
    //   524	533	236	finally
    //   542	552	236	finally
    //   564	570	236	finally
    //   579	586	236	finally
    //   600	607	236	finally
    //   616	623	236	finally
    //   635	645	236	finally
    //   654	660	236	finally
    //   55	61	318	java/io/IOException
    //   121	134	318	java/io/IOException
    //   149	155	318	java/io/IOException
    //   164	171	318	java/io/IOException
    //   185	192	318	java/io/IOException
    //   201	208	318	java/io/IOException
    //   290	300	318	java/io/IOException
    //   309	315	318	java/io/IOException
    //   378	389	318	java/io/IOException
    //   406	424	318	java/io/IOException
    //   439	449	318	java/io/IOException
    //   458	467	318	java/io/IOException
    //   476	491	318	java/io/IOException
    //   505	515	318	java/io/IOException
    //   524	533	318	java/io/IOException
    //   542	552	318	java/io/IOException
    //   564	570	318	java/io/IOException
    //   579	586	318	java/io/IOException
    //   600	607	318	java/io/IOException
    //   616	623	318	java/io/IOException
    //   635	645	318	java/io/IOException
    //   654	660	318	java/io/IOException
    //   681	686	705	java/io/IOException
    //   681	686	718	finally
    //   256	261	735	java/io/IOException
    //   256	261	748	finally
  }
  
  private a$e(i.a parama)
  {
    super((byte)0);
    this.aiXZ = parama.aiXZ;
  }
  
  private void ktf()
  {
    AppMethodBeat.i(58520);
    this.aiZp = b.aiZt;
    this.aiZq = Collections.emptyList();
    this.aiZr = a.g.kuE();
    this.aiZs = c.aiZx;
    AppMethodBeat.o(58520);
  }
  
  public static e kus()
  {
    return aiZo;
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(58522);
    getSerializedSize();
    if ((this.bitField0_ & 0x1) == 1) {
      paramf.cP(1, this.aiZp.value);
    }
    int i = 0;
    while (i < this.aiZq.size())
    {
      paramf.a(2, (r)this.aiZq.get(i));
      i += 1;
    }
    if ((this.bitField0_ & 0x2) == 2) {
      paramf.a(3, this.aiZr);
    }
    if ((this.bitField0_ & 0x4) == 4) {
      paramf.cP(4, this.aiZs.value);
    }
    paramf.e(this.aiXZ);
    AppMethodBeat.o(58522);
  }
  
  public final int getSerializedSize()
  {
    int j = 0;
    AppMethodBeat.i(58523);
    int i = this.dRJ;
    if (i != -1)
    {
      AppMethodBeat.o(58523);
      return i;
    }
    if ((this.bitField0_ & 0x1) == 1) {
      i = f.cM(1, this.aiZp.value) + 0;
    }
    for (;;)
    {
      if (j < this.aiZq.size())
      {
        int k = f.c(2, (r)this.aiZq.get(j));
        j += 1;
        i = k + i;
      }
      else
      {
        j = i;
        if ((this.bitField0_ & 0x2) == 2) {
          j = i + f.c(3, this.aiZr);
        }
        i = j;
        if ((this.bitField0_ & 0x4) == 4) {
          i = j + f.cM(4, this.aiZs.value);
        }
        i = this.aiXZ.size() + i;
        this.dRJ = i;
        AppMethodBeat.o(58523);
        return i;
        i = 0;
      }
    }
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(58521);
    int i = this.memoizedIsInitialized;
    if (i == 1)
    {
      AppMethodBeat.o(58521);
      return true;
    }
    if (i == 0)
    {
      AppMethodBeat.o(58521);
      return false;
    }
    i = 0;
    while (i < this.aiZq.size())
    {
      if (!((a.g)this.aiZq.get(i)).isInitialized())
      {
        this.memoizedIsInitialized = 0;
        AppMethodBeat.o(58521);
        return false;
      }
      i += 1;
    }
    if ((kuu()) && (!this.aiZr.isInitialized()))
    {
      this.memoizedIsInitialized = 0;
      AppMethodBeat.o(58521);
      return false;
    }
    this.memoizedIsInitialized = 1;
    AppMethodBeat.o(58521);
    return true;
  }
  
  public final boolean kut()
  {
    return (this.bitField0_ & 0x1) == 1;
  }
  
  public final boolean kuu()
  {
    return (this.bitField0_ & 0x2) == 2;
  }
  
  public final boolean kuv()
  {
    return (this.bitField0_ & 0x4) == 4;
  }
  
  public static final class a
    extends i.a<a.e, a>
    implements h
  {
    private a.e.b aiZp;
    private List<a.g> aiZq;
    private a.g aiZr;
    private a.e.c aiZs;
    private int bitField0_;
    
    private a()
    {
      AppMethodBeat.i(58491);
      this.aiZp = a.e.b.aiZt;
      this.aiZq = Collections.emptyList();
      this.aiZr = a.g.kuE();
      this.aiZs = a.e.c.aiZx;
      AppMethodBeat.o(58491);
    }
    
    private a a(a.e.b paramb)
    {
      AppMethodBeat.i(58497);
      if (paramb == null)
      {
        paramb = new NullPointerException();
        AppMethodBeat.o(58497);
        throw paramb;
      }
      this.bitField0_ |= 0x1;
      this.aiZp = paramb;
      AppMethodBeat.o(58497);
      return this;
    }
    
    private a a(a.e.c paramc)
    {
      AppMethodBeat.i(58500);
      if (paramc == null)
      {
        paramc = new NullPointerException();
        AppMethodBeat.o(58500);
        throw paramc;
      }
      this.bitField0_ |= 0x8;
      this.aiZs = paramc;
      AppMethodBeat.o(58500);
      return this;
    }
    
    private a a(a.g paramg)
    {
      AppMethodBeat.i(58499);
      if (((this.bitField0_ & 0x4) == 4) && (this.aiZr != a.g.kuE())) {}
      for (this.aiZr = a.g.b(this.aiZr).f(paramg).kuK();; this.aiZr = paramg)
      {
        this.bitField0_ |= 0x4;
        AppMethodBeat.o(58499);
        return this;
      }
    }
    
    /* Error */
    private a j(kotlin.l.b.a.b.h.e parame, kotlin.l.b.a.b.h.g paramg)
    {
      // Byte code:
      //   0: ldc 97
      //   2: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: getstatic 101	kotlin/l/b/a/b/e/a$e:aiYa	Lkotlin/l/b/a/b/h/t;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 106 3 0
      //   17: checkcast 9	kotlin/l/b/a/b/e/a$e
      //   20: astore_1
      //   21: aload_1
      //   22: ifnull +9 -> 31
      //   25: aload_0
      //   26: aload_1
      //   27: invokevirtual 110	kotlin/l/b/a/b/e/a$e$a:c	(Lkotlin/l/b/a/b/e/a$e;)Lkotlin/l/b/a/b/e/a$e$a;
      //   30: pop
      //   31: ldc 97
      //   33: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   36: aload_0
      //   37: areturn
      //   38: astore_1
      //   39: aload_1
      //   40: getfield 114	kotlin/l/b/a/b/h/l:ajfp	Lkotlin/l/b/a/b/h/r;
      //   43: checkcast 9	kotlin/l/b/a/b/e/a$e
      //   46: astore_2
      //   47: ldc 97
      //   49: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   52: aload_1
      //   53: athrow
      //   54: astore_1
      //   55: aload_2
      //   56: ifnull +9 -> 65
      //   59: aload_0
      //   60: aload_2
      //   61: invokevirtual 110	kotlin/l/b/a/b/e/a$e$a:c	(Lkotlin/l/b/a/b/e/a$e;)Lkotlin/l/b/a/b/e/a$e$a;
      //   64: pop
      //   65: ldc 97
      //   67: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
      //   0	78	2	paramg	kotlin.l.b.a.b.h.g
      //   6	68	3	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   7	21	38	kotlin/l/b/a/b/h/l
      //   47	54	54	finally
      //   7	21	72	finally
      //   39	47	72	finally
    }
    
    private a kuw()
    {
      AppMethodBeat.i(58492);
      a locala = new a().c(kux());
      AppMethodBeat.o(58492);
      return locala;
    }
    
    private a.e kux()
    {
      int j = 1;
      AppMethodBeat.i(58493);
      a.e locale = new a.e(this, (byte)0);
      int k = this.bitField0_;
      if ((k & 0x1) == 1) {}
      for (;;)
      {
        a.e.a(locale, this.aiZp);
        if ((this.bitField0_ & 0x2) == 2)
        {
          this.aiZq = Collections.unmodifiableList(this.aiZq);
          this.bitField0_ &= 0xFFFFFFFD;
        }
        a.e.a(locale, this.aiZq);
        int i = j;
        if ((k & 0x4) == 4) {
          i = j | 0x2;
        }
        a.e.a(locale, this.aiZr);
        j = i;
        if ((k & 0x8) == 8) {
          j = i | 0x4;
        }
        a.e.a(locale, this.aiZs);
        a.e.a(locale, j);
        AppMethodBeat.o(58493);
        return locale;
        j = 0;
      }
    }
    
    private void kuy()
    {
      AppMethodBeat.i(58498);
      if ((this.bitField0_ & 0x2) != 2)
      {
        this.aiZq = new ArrayList(this.aiZq);
        this.bitField0_ |= 0x2;
      }
      AppMethodBeat.o(58498);
    }
    
    public final a c(a.e parame)
    {
      AppMethodBeat.i(58494);
      if (parame == a.e.kus())
      {
        AppMethodBeat.o(58494);
        return this;
      }
      if (parame.kut()) {
        a(parame.aiZp);
      }
      if (!a.e.a(parame).isEmpty())
      {
        if (!this.aiZq.isEmpty()) {
          break label132;
        }
        this.aiZq = a.e.a(parame);
        this.bitField0_ &= 0xFFFFFFFD;
      }
      for (;;)
      {
        if (parame.kuu()) {
          a(parame.aiZr);
        }
        if (parame.kuv()) {
          a(parame.aiZs);
        }
        this.aiXZ = this.aiXZ.a(a.e.b(parame));
        AppMethodBeat.o(58494);
        return this;
        label132:
        kuy();
        this.aiZq.addAll(a.e.a(parame));
      }
    }
    
    public final boolean isInitialized()
    {
      AppMethodBeat.i(58495);
      int i = 0;
      while (i < this.aiZq.size())
      {
        if (!((a.g)this.aiZq.get(i)).isInitialized())
        {
          AppMethodBeat.o(58495);
          return false;
        }
        i += 1;
      }
      if ((this.bitField0_ & 0x4) == 4) {}
      for (i = 1; (i != 0) && (!this.aiZr.isInitialized()); i = 0)
      {
        AppMethodBeat.o(58495);
        return false;
      }
      AppMethodBeat.o(58495);
      return true;
    }
  }
  
  public static enum b
    implements k.a
  {
    private static k.b<b> aiYE;
    final int value;
    
    static
    {
      AppMethodBeat.i(58514);
      aiZt = new b("RETURNS_CONSTANT", 0, 0);
      aiZu = new b("CALLS", 1, 1);
      aiZv = new b("RETURNS_NOT_NULL", 2, 2);
      aiZw = new b[] { aiZt, aiZu, aiZv };
      aiYE = new k.b() {};
      AppMethodBeat.o(58514);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static b aKS(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 0: 
        return aiZt;
      case 1: 
        return aiZu;
      }
      return aiZv;
    }
    
    public final int getNumber()
    {
      return this.value;
    }
  }
  
  public static enum c
    implements k.a
  {
    private static k.b<c> aiYE;
    final int value;
    
    static
    {
      AppMethodBeat.i(58518);
      aiZx = new c("AT_MOST_ONCE", 0, 0);
      aiZy = new c("EXACTLY_ONCE", 1, 1);
      aiZz = new c("AT_LEAST_ONCE", 2, 2);
      aiZA = new c[] { aiZx, aiZy, aiZz };
      aiYE = new k.b() {};
      AppMethodBeat.o(58518);
    }
    
    private c(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static c aKT(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 0: 
        return aiZx;
      case 1: 
        return aiZy;
      }
      return aiZz;
    }
    
    public final int getNumber()
    {
      return this.value;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.e.a.e
 * JD-Core Version:    0.7.0.1
 */