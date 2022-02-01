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
import kotlin.l.b.a.b.h.j.a;
import kotlin.l.b.a.b.h.j.b;
import kotlin.l.b.a.b.h.q;
import kotlin.l.b.a.b.h.s;

public final class a$e
  extends i
  implements h
{
  public static s<e> TwL;
  private static final e TxW;
  private final d TwK;
  b TxX;
  private List<a.g> TxY;
  a.g TxZ;
  c Tya;
  private int bOT;
  private byte bPe = -1;
  private int bVY = -1;
  
  static
  {
    AppMethodBeat.i(58526);
    TwL = new b() {};
    e locale = new e();
    TxW = locale;
    locale.hEu();
    AppMethodBeat.o(58526);
  }
  
  private a$e()
  {
    this.TwK = d.TDp;
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
    //   11: putfield 72	kotlin/l/b/a/b/e/a$e:bPe	B
    //   14: aload_0
    //   15: iconst_m1
    //   16: putfield 74	kotlin/l/b/a/b/e/a$e:bVY	I
    //   19: aload_0
    //   20: invokespecial 65	kotlin/l/b/a/b/e/a$e:hEu	()V
    //   23: invokestatic 91	kotlin/l/b/a/b/h/d:hJo	()Lkotlin/l/b/a/b/h/d$b;
    //   26: astore 11
    //   28: aload 11
    //   30: iconst_1
    //   31: invokestatic 97	kotlin/l/b/a/b/h/f:f	(Ljava/io/OutputStream;I)Lkotlin/l/b/a/b/h/f;
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
    //   56: invokevirtual 103	kotlin/l/b/a/b/h/e:yT	()I
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
    //   128: invokevirtual 106	kotlin/l/b/a/b/e/a$e:a	(Lkotlin/l/b/a/b/h/e;Lkotlin/l/b/a/b/h/f;Lkotlin/l/b/a/b/h/g;I)Z
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
    //   150: invokevirtual 109	kotlin/l/b/a/b/h/e:zi	()I
    //   153: istore 9
    //   155: iload_3
    //   156: istore 7
    //   158: iload_3
    //   159: istore 5
    //   161: iload_3
    //   162: istore 8
    //   164: iload 9
    //   166: invokestatic 113	kotlin/l/b/a/b/e/a$e$b:auh	(I)Lkotlin/l/b/a/b/e/a$e$b;
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
    //   189: invokevirtual 116	kotlin/l/b/a/b/h/f:hc	(I)V
    //   192: iload_3
    //   193: istore 7
    //   195: iload_3
    //   196: istore 5
    //   198: iload_3
    //   199: istore 8
    //   201: aload 12
    //   203: iload 9
    //   205: invokevirtual 116	kotlin/l/b/a/b/h/f:hc	(I)V
    //   208: goto -167 -> 41
    //   211: astore_1
    //   212: iload 7
    //   214: istore 5
    //   216: aload_1
    //   217: aload_0
    //   218: putfield 120	kotlin/l/b/a/b/h/k:TDK	Lkotlin/l/b/a/b/h/q;
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
    //   247: getfield 122	kotlin/l/b/a/b/e/a$e:TxY	Ljava/util/List;
    //   250: invokestatic 128	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   253: putfield 122	kotlin/l/b/a/b/e/a$e:TxY	Ljava/util/List;
    //   256: aload 12
    //   258: invokevirtual 131	kotlin/l/b/a/b/h/f:flush	()V
    //   261: aload_0
    //   262: aload 11
    //   264: invokevirtual 137	kotlin/l/b/a/b/h/d$b:hJs	()Lkotlin/l/b/a/b/h/d;
    //   267: putfield 81	kotlin/l/b/a/b/e/a$e:TwK	Lkotlin/l/b/a/b/h/d;
    //   270: aload_0
    //   271: invokevirtual 140	kotlin/l/b/a/b/e/a$e:Gw	()V
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
    //   292: getfield 142	kotlin/l/b/a/b/e/a$e:bOT	I
    //   295: iconst_1
    //   296: ior
    //   297: putfield 142	kotlin/l/b/a/b/e/a$e:bOT	I
    //   300: iload_3
    //   301: istore 7
    //   303: iload_3
    //   304: istore 5
    //   306: iload_3
    //   307: istore 8
    //   309: aload_0
    //   310: aload 10
    //   312: putfield 144	kotlin/l/b/a/b/e/a$e:TxX	Lkotlin/l/b/a/b/e/a$e$b;
    //   315: goto -274 -> 41
    //   318: astore_1
    //   319: iload 8
    //   321: istore 5
    //   323: new 84	kotlin/l/b/a/b/h/k
    //   326: dup
    //   327: aload_1
    //   328: invokevirtual 148	java/io/IOException:getMessage	()Ljava/lang/String;
    //   331: invokespecial 151	kotlin/l/b/a/b/h/k:<init>	(Ljava/lang/String;)V
    //   334: astore_1
    //   335: iload 8
    //   337: istore 5
    //   339: aload_1
    //   340: aload_0
    //   341: putfield 120	kotlin/l/b/a/b/h/k:TDK	Lkotlin/l/b/a/b/h/q;
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
    //   379: new 153	java/util/ArrayList
    //   382: dup
    //   383: invokespecial 154	java/util/ArrayList:<init>	()V
    //   386: putfield 122	kotlin/l/b/a/b/e/a$e:TxY	Ljava/util/List;
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
    //   407: getfield 122	kotlin/l/b/a/b/e/a$e:TxY	Ljava/util/List;
    //   410: aload_1
    //   411: getstatic 157	kotlin/l/b/a/b/e/a$g:TwL	Lkotlin/l/b/a/b/h/s;
    //   414: aload_2
    //   415: invokevirtual 160	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/s;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/q;
    //   418: invokeinterface 166 2 0
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
    //   440: getfield 142	kotlin/l/b/a/b/e/a$e:bOT	I
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
    //   459: getfield 168	kotlin/l/b/a/b/e/a$e:TxZ	Lkotlin/l/b/a/b/e/a$g;
    //   462: invokestatic 171	kotlin/l/b/a/b/e/a$g:b	(Lkotlin/l/b/a/b/e/a$g;)Lkotlin/l/b/a/b/e/a$g$a;
    //   465: astore 10
    //   467: iload_3
    //   468: istore 7
    //   470: iload_3
    //   471: istore 5
    //   473: iload_3
    //   474: istore 8
    //   476: aload_0
    //   477: aload_1
    //   478: getstatic 157	kotlin/l/b/a/b/e/a$g:TwL	Lkotlin/l/b/a/b/h/s;
    //   481: aload_2
    //   482: invokevirtual 160	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/s;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/q;
    //   485: checkcast 156	kotlin/l/b/a/b/e/a$g
    //   488: putfield 168	kotlin/l/b/a/b/e/a$e:TxZ	Lkotlin/l/b/a/b/e/a$g;
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
    //   508: getfield 168	kotlin/l/b/a/b/e/a$e:TxZ	Lkotlin/l/b/a/b/e/a$g;
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
    //   527: invokevirtual 179	kotlin/l/b/a/b/e/a$g$a:hFV	()Lkotlin/l/b/a/b/e/a$g;
    //   530: putfield 168	kotlin/l/b/a/b/e/a$e:TxZ	Lkotlin/l/b/a/b/e/a$g;
    //   533: iload_3
    //   534: istore 7
    //   536: iload_3
    //   537: istore 5
    //   539: iload_3
    //   540: istore 8
    //   542: aload_0
    //   543: aload_0
    //   544: getfield 142	kotlin/l/b/a/b/e/a$e:bOT	I
    //   547: iconst_2
    //   548: ior
    //   549: putfield 142	kotlin/l/b/a/b/e/a$e:bOT	I
    //   552: goto -511 -> 41
    //   555: iload_3
    //   556: istore 7
    //   558: iload_3
    //   559: istore 5
    //   561: iload_3
    //   562: istore 8
    //   564: aload_1
    //   565: invokevirtual 109	kotlin/l/b/a/b/h/e:zi	()I
    //   568: istore 9
    //   570: iload_3
    //   571: istore 7
    //   573: iload_3
    //   574: istore 5
    //   576: iload_3
    //   577: istore 8
    //   579: iload 9
    //   581: invokestatic 183	kotlin/l/b/a/b/e/a$e$c:aui	(I)Lkotlin/l/b/a/b/e/a$e$c;
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
    //   604: invokevirtual 116	kotlin/l/b/a/b/h/f:hc	(I)V
    //   607: iload_3
    //   608: istore 7
    //   610: iload_3
    //   611: istore 5
    //   613: iload_3
    //   614: istore 8
    //   616: aload 12
    //   618: iload 9
    //   620: invokevirtual 116	kotlin/l/b/a/b/h/f:hc	(I)V
    //   623: goto -582 -> 41
    //   626: iload_3
    //   627: istore 7
    //   629: iload_3
    //   630: istore 5
    //   632: iload_3
    //   633: istore 8
    //   635: aload_0
    //   636: aload_0
    //   637: getfield 142	kotlin/l/b/a/b/e/a$e:bOT	I
    //   640: iconst_4
    //   641: ior
    //   642: putfield 142	kotlin/l/b/a/b/e/a$e:bOT	I
    //   645: iload_3
    //   646: istore 7
    //   648: iload_3
    //   649: istore 5
    //   651: iload_3
    //   652: istore 8
    //   654: aload_0
    //   655: aload 10
    //   657: putfield 185	kotlin/l/b/a/b/e/a$e:Tya	Lkotlin/l/b/a/b/e/a$e$c;
    //   660: goto -619 -> 41
    //   663: iload_3
    //   664: iconst_2
    //   665: iand
    //   666: iconst_2
    //   667: if_icmpne +14 -> 681
    //   670: aload_0
    //   671: aload_0
    //   672: getfield 122	kotlin/l/b/a/b/e/a$e:TxY	Ljava/util/List;
    //   675: invokestatic 128	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   678: putfield 122	kotlin/l/b/a/b/e/a$e:TxY	Ljava/util/List;
    //   681: aload 12
    //   683: invokevirtual 131	kotlin/l/b/a/b/h/f:flush	()V
    //   686: aload_0
    //   687: aload 11
    //   689: invokevirtual 137	kotlin/l/b/a/b/h/d$b:hJs	()Lkotlin/l/b/a/b/h/d;
    //   692: putfield 81	kotlin/l/b/a/b/e/a$e:TwK	Lkotlin/l/b/a/b/h/d;
    //   695: aload_0
    //   696: invokevirtual 140	kotlin/l/b/a/b/e/a$e:Gw	()V
    //   699: ldc 87
    //   701: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   704: return
    //   705: astore_1
    //   706: aload_0
    //   707: aload 11
    //   709: invokevirtual 137	kotlin/l/b/a/b/h/d$b:hJs	()Lkotlin/l/b/a/b/h/d;
    //   712: putfield 81	kotlin/l/b/a/b/e/a$e:TwK	Lkotlin/l/b/a/b/h/d;
    //   715: goto -20 -> 695
    //   718: astore_1
    //   719: aload_0
    //   720: aload 11
    //   722: invokevirtual 137	kotlin/l/b/a/b/h/d$b:hJs	()Lkotlin/l/b/a/b/h/d;
    //   725: putfield 81	kotlin/l/b/a/b/e/a$e:TwK	Lkotlin/l/b/a/b/h/d;
    //   728: ldc 87
    //   730: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   733: aload_1
    //   734: athrow
    //   735: astore_2
    //   736: aload_0
    //   737: aload 11
    //   739: invokevirtual 137	kotlin/l/b/a/b/h/d$b:hJs	()Lkotlin/l/b/a/b/h/d;
    //   742: putfield 81	kotlin/l/b/a/b/e/a$e:TwK	Lkotlin/l/b/a/b/h/d;
    //   745: goto -475 -> 270
    //   748: astore_1
    //   749: aload_0
    //   750: aload 11
    //   752: invokevirtual 137	kotlin/l/b/a/b/h/d$b:hJs	()Lkotlin/l/b/a/b/h/d;
    //   755: putfield 81	kotlin/l/b/a/b/e/a$e:TwK	Lkotlin/l/b/a/b/h/d;
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
    //   55	61	211	kotlin/l/b/a/b/h/k
    //   121	134	211	kotlin/l/b/a/b/h/k
    //   149	155	211	kotlin/l/b/a/b/h/k
    //   164	171	211	kotlin/l/b/a/b/h/k
    //   185	192	211	kotlin/l/b/a/b/h/k
    //   201	208	211	kotlin/l/b/a/b/h/k
    //   290	300	211	kotlin/l/b/a/b/h/k
    //   309	315	211	kotlin/l/b/a/b/h/k
    //   378	389	211	kotlin/l/b/a/b/h/k
    //   406	424	211	kotlin/l/b/a/b/h/k
    //   439	449	211	kotlin/l/b/a/b/h/k
    //   458	467	211	kotlin/l/b/a/b/h/k
    //   476	491	211	kotlin/l/b/a/b/h/k
    //   505	515	211	kotlin/l/b/a/b/h/k
    //   524	533	211	kotlin/l/b/a/b/h/k
    //   542	552	211	kotlin/l/b/a/b/h/k
    //   564	570	211	kotlin/l/b/a/b/h/k
    //   579	586	211	kotlin/l/b/a/b/h/k
    //   600	607	211	kotlin/l/b/a/b/h/k
    //   616	623	211	kotlin/l/b/a/b/h/k
    //   635	645	211	kotlin/l/b/a/b/h/k
    //   654	660	211	kotlin/l/b/a/b/h/k
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
    this.TwK = parama.TwK;
  }
  
  private void hEu()
  {
    AppMethodBeat.i(58520);
    this.TxX = b.Tyb;
    this.TxY = Collections.emptyList();
    this.TxZ = a.g.hFP();
    this.Tya = c.Tyf;
    AppMethodBeat.o(58520);
  }
  
  public static e hFD()
  {
    return TxW;
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(58522);
    yC();
    if ((this.bOT & 0x1) == 1) {
      paramf.nb(1, this.TxX.value);
    }
    int i = 0;
    while (i < this.TxY.size())
    {
      paramf.a(2, (q)this.TxY.get(i));
      i += 1;
    }
    if ((this.bOT & 0x2) == 2) {
      paramf.a(3, this.TxZ);
    }
    if ((this.bOT & 0x4) == 4) {
      paramf.nb(4, this.Tya.value);
    }
    paramf.e(this.TwK);
    AppMethodBeat.o(58522);
  }
  
  public final s<e> hEs()
  {
    return TwL;
  }
  
  public final boolean hFE()
  {
    return (this.bOT & 0x1) == 1;
  }
  
  public final boolean hFF()
  {
    return (this.bOT & 0x2) == 2;
  }
  
  public final boolean hFG()
  {
    return (this.bOT & 0x4) == 4;
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(58521);
    int i = this.bPe;
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
    while (i < this.TxY.size())
    {
      if (!((a.g)this.TxY.get(i)).isInitialized())
      {
        this.bPe = 0;
        AppMethodBeat.o(58521);
        return false;
      }
      i += 1;
    }
    if ((hFF()) && (!this.TxZ.isInitialized()))
    {
      this.bPe = 0;
      AppMethodBeat.o(58521);
      return false;
    }
    this.bPe = 1;
    AppMethodBeat.o(58521);
    return true;
  }
  
  public final int yC()
  {
    int j = 0;
    AppMethodBeat.i(58523);
    int i = this.bVY;
    if (i != -1)
    {
      AppMethodBeat.o(58523);
      return i;
    }
    if ((this.bOT & 0x1) == 1) {
      i = f.bv(1, this.TxX.value) + 0;
    }
    for (;;)
    {
      if (j < this.TxY.size())
      {
        int k = f.c(2, (q)this.TxY.get(j));
        j += 1;
        i = k + i;
      }
      else
      {
        j = i;
        if ((this.bOT & 0x2) == 2) {
          j = i + f.c(3, this.TxZ);
        }
        i = j;
        if ((this.bOT & 0x4) == 4) {
          i = j + f.bv(4, this.Tya.value);
        }
        i = this.TwK.size() + i;
        this.bVY = i;
        AppMethodBeat.o(58523);
        return i;
        i = 0;
      }
    }
  }
  
  public static final class a
    extends i.a<a.e, a>
    implements h
  {
    private a.e.b TxX;
    private List<a.g> TxY;
    private a.g TxZ;
    private a.e.c Tya;
    private int bOT;
    
    private a()
    {
      AppMethodBeat.i(58491);
      this.TxX = a.e.b.Tyb;
      this.TxY = Collections.emptyList();
      this.TxZ = a.g.hFP();
      this.Tya = a.e.c.Tyf;
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
      this.bOT |= 0x1;
      this.TxX = paramb;
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
      this.bOT |= 0x8;
      this.Tya = paramc;
      AppMethodBeat.o(58500);
      return this;
    }
    
    private a a(a.g paramg)
    {
      AppMethodBeat.i(58499);
      if (((this.bOT & 0x4) == 4) && (this.TxZ != a.g.hFP())) {}
      for (this.TxZ = a.g.b(this.TxZ).f(paramg).hFV();; this.TxZ = paramg)
      {
        this.bOT |= 0x4;
        AppMethodBeat.o(58499);
        return this;
      }
    }
    
    private a hFH()
    {
      AppMethodBeat.i(58492);
      a locala = new a().c(hFI());
      AppMethodBeat.o(58492);
      return locala;
    }
    
    private a.e hFI()
    {
      int j = 1;
      AppMethodBeat.i(58493);
      a.e locale = new a.e(this, (byte)0);
      int k = this.bOT;
      if ((k & 0x1) == 1) {}
      for (;;)
      {
        a.e.a(locale, this.TxX);
        if ((this.bOT & 0x2) == 2)
        {
          this.TxY = Collections.unmodifiableList(this.TxY);
          this.bOT &= 0xFFFFFFFD;
        }
        a.e.a(locale, this.TxY);
        int i = j;
        if ((k & 0x4) == 4) {
          i = j | 0x2;
        }
        a.e.a(locale, this.TxZ);
        j = i;
        if ((k & 0x8) == 8) {
          j = i | 0x4;
        }
        a.e.a(locale, this.Tya);
        a.e.a(locale, j);
        AppMethodBeat.o(58493);
        return locale;
        j = 0;
      }
    }
    
    private void hFJ()
    {
      AppMethodBeat.i(58498);
      if ((this.bOT & 0x2) != 2)
      {
        this.TxY = new ArrayList(this.TxY);
        this.bOT |= 0x2;
      }
      AppMethodBeat.o(58498);
    }
    
    /* Error */
    private a j(kotlin.l.b.a.b.h.e parame, kotlin.l.b.a.b.h.g paramg)
    {
      // Byte code:
      //   0: ldc 141
      //   2: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: getstatic 145	kotlin/l/b/a/b/e/a$e:TwL	Lkotlin/l/b/a/b/h/s;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 150 3 0
      //   17: checkcast 9	kotlin/l/b/a/b/e/a$e
      //   20: astore_1
      //   21: aload_0
      //   22: aload_1
      //   23: invokevirtual 104	kotlin/l/b/a/b/e/a$e$a:c	(Lkotlin/l/b/a/b/e/a$e;)Lkotlin/l/b/a/b/e/a$e$a;
      //   26: pop
      //   27: ldc 141
      //   29: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   32: aload_0
      //   33: areturn
      //   34: astore_1
      //   35: aload_1
      //   36: getfield 154	kotlin/l/b/a/b/h/k:TDK	Lkotlin/l/b/a/b/h/q;
      //   39: checkcast 9	kotlin/l/b/a/b/e/a$e
      //   42: astore_2
      //   43: ldc 141
      //   45: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   48: aload_1
      //   49: athrow
      //   50: astore_1
      //   51: aload_2
      //   52: ifnull +9 -> 61
      //   55: aload_0
      //   56: aload_2
      //   57: invokevirtual 104	kotlin/l/b/a/b/e/a$e$a:c	(Lkotlin/l/b/a/b/e/a$e;)Lkotlin/l/b/a/b/e/a$e$a;
      //   60: pop
      //   61: ldc 141
      //   63: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
      //   0	74	2	paramg	kotlin.l.b.a.b.h.g
      //   6	64	3	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   7	21	34	kotlin/l/b/a/b/h/k
      //   43	50	50	finally
      //   7	21	68	finally
      //   35	43	68	finally
    }
    
    public final a c(a.e parame)
    {
      AppMethodBeat.i(58494);
      if (parame == a.e.hFD())
      {
        AppMethodBeat.o(58494);
        return this;
      }
      if (parame.hFE()) {
        a(parame.TxX);
      }
      if (!a.e.a(parame).isEmpty())
      {
        if (!this.TxY.isEmpty()) {
          break label132;
        }
        this.TxY = a.e.a(parame);
        this.bOT &= 0xFFFFFFFD;
      }
      for (;;)
      {
        if (parame.hFF()) {
          a(parame.TxZ);
        }
        if (parame.hFG()) {
          a(parame.Tya);
        }
        this.TwK = this.TwK.a(a.e.b(parame));
        AppMethodBeat.o(58494);
        return this;
        label132:
        hFJ();
        this.TxY.addAll(a.e.a(parame));
      }
    }
    
    public final boolean isInitialized()
    {
      AppMethodBeat.i(58495);
      int i = 0;
      while (i < this.TxY.size())
      {
        if (!((a.g)this.TxY.get(i)).isInitialized())
        {
          AppMethodBeat.o(58495);
          return false;
        }
        i += 1;
      }
      if ((this.bOT & 0x4) == 4) {}
      for (i = 1; (i != 0) && (!this.TxZ.isInitialized()); i = 0)
      {
        AppMethodBeat.o(58495);
        return false;
      }
      AppMethodBeat.o(58495);
      return true;
    }
  }
  
  public static enum b
    implements j.a
  {
    private static j.b<b> Txp;
    final int value;
    
    static
    {
      AppMethodBeat.i(58514);
      Tyb = new b("RETURNS_CONSTANT", 0, 0);
      Tyc = new b("CALLS", 1, 1);
      Tyd = new b("RETURNS_NOT_NULL", 2, 2);
      Tye = new b[] { Tyb, Tyc, Tyd };
      Txp = new j.b() {};
      AppMethodBeat.o(58514);
    }
    
    private b(int paramInt1, int paramInt2)
    {
      this.value = paramInt1;
    }
    
    public static b auh(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 0: 
        return Tyb;
      case 1: 
        return Tyc;
      }
      return Tyd;
    }
    
    public final int getNumber()
    {
      return this.value;
    }
  }
  
  public static enum c
    implements j.a
  {
    private static j.b<c> Txp;
    final int value;
    
    static
    {
      AppMethodBeat.i(58518);
      Tyf = new c("AT_MOST_ONCE", 0, 0);
      Tyg = new c("EXACTLY_ONCE", 1, 1);
      Tyh = new c("AT_LEAST_ONCE", 2, 2);
      Tyi = new c[] { Tyf, Tyg, Tyh };
      Txp = new j.b() {};
      AppMethodBeat.o(58518);
    }
    
    private c(int paramInt1, int paramInt2)
    {
      this.value = paramInt1;
    }
    
    public static c aui(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 0: 
        return Tyf;
      case 1: 
        return Tyg;
      }
      return Tyh;
    }
    
    public final int getNumber()
    {
      return this.value;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     kotlin.l.b.a.b.e.a.e
 * JD-Core Version:    0.7.0.1
 */