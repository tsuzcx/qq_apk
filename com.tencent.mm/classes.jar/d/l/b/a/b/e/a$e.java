package d.l.b.a.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.h.b;
import d.l.b.a.b.h.d;
import d.l.b.a.b.h.f;
import d.l.b.a.b.h.i;
import d.l.b.a.b.h.i.a;
import d.l.b.a.b.h.j.a;
import d.l.b.a.b.h.j.b;
import d.l.b.a.b.h.q;
import d.l.b.a.b.h.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class a$e
  extends i
  implements h
{
  public static s<e> NjZ;
  private static final e Nlo;
  private final d NjY;
  private int Nka;
  private byte Nkd = -1;
  private int Nke = -1;
  b Nlp;
  private List<a.g> Nlq;
  a.g Nlr;
  c Nls;
  
  static
  {
    AppMethodBeat.i(58526);
    NjZ = new b() {};
    e locale = new e();
    Nlo = locale;
    locale.gmq();
    AppMethodBeat.o(58526);
  }
  
  private a$e()
  {
    this.NjY = d.NqI;
  }
  
  /* Error */
  private a$e(d.l.b.a.b.h.e parame, d.l.b.a.b.h.g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 70	d/l/b/a/b/h/i:<init>	()V
    //   4: ldc 87
    //   6: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 72	d/l/b/a/b/e/a$e:Nkd	B
    //   14: aload_0
    //   15: iconst_m1
    //   16: putfield 74	d/l/b/a/b/e/a$e:Nke	I
    //   19: aload_0
    //   20: invokespecial 65	d/l/b/a/b/e/a$e:gmq	()V
    //   23: invokestatic 91	d/l/b/a/b/h/d:grr	()Ld/l/b/a/b/h/d$b;
    //   26: astore 11
    //   28: aload 11
    //   30: iconst_1
    //   31: invokestatic 97	d/l/b/a/b/h/f:f	(Ljava/io/OutputStream;I)Ld/l/b/a/b/h/f;
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
    //   56: invokevirtual 103	d/l/b/a/b/h/e:zb	()I
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
    //   128: invokevirtual 106	d/l/b/a/b/e/a$e:a	(Ld/l/b/a/b/h/e;Ld/l/b/a/b/h/f;Ld/l/b/a/b/h/g;I)Z
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
    //   150: invokevirtual 109	d/l/b/a/b/h/e:zc	()I
    //   153: istore 9
    //   155: iload_3
    //   156: istore 7
    //   158: iload_3
    //   159: istore 5
    //   161: iload_3
    //   162: istore 8
    //   164: iload 9
    //   166: invokestatic 113	d/l/b/a/b/e/a$e$b:ajH	(I)Ld/l/b/a/b/e/a$e$b;
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
    //   189: invokevirtual 116	d/l/b/a/b/h/f:fO	(I)V
    //   192: iload_3
    //   193: istore 7
    //   195: iload_3
    //   196: istore 5
    //   198: iload_3
    //   199: istore 8
    //   201: aload 12
    //   203: iload 9
    //   205: invokevirtual 116	d/l/b/a/b/h/f:fO	(I)V
    //   208: goto -167 -> 41
    //   211: astore_1
    //   212: iload 7
    //   214: istore 5
    //   216: aload_1
    //   217: aload_0
    //   218: putfield 120	d/l/b/a/b/h/k:Nrq	Ld/l/b/a/b/h/q;
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
    //   247: getfield 122	d/l/b/a/b/e/a$e:Nlq	Ljava/util/List;
    //   250: invokestatic 128	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   253: putfield 122	d/l/b/a/b/e/a$e:Nlq	Ljava/util/List;
    //   256: aload 12
    //   258: invokevirtual 131	d/l/b/a/b/h/f:flush	()V
    //   261: aload_0
    //   262: aload 11
    //   264: invokevirtual 137	d/l/b/a/b/h/d$b:grv	()Ld/l/b/a/b/h/d;
    //   267: putfield 81	d/l/b/a/b/e/a$e:NjY	Ld/l/b/a/b/h/d;
    //   270: aload_0
    //   271: invokevirtual 140	d/l/b/a/b/e/a$e:grN	()V
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
    //   292: getfield 142	d/l/b/a/b/e/a$e:Nka	I
    //   295: iconst_1
    //   296: ior
    //   297: putfield 142	d/l/b/a/b/e/a$e:Nka	I
    //   300: iload_3
    //   301: istore 7
    //   303: iload_3
    //   304: istore 5
    //   306: iload_3
    //   307: istore 8
    //   309: aload_0
    //   310: aload 10
    //   312: putfield 144	d/l/b/a/b/e/a$e:Nlp	Ld/l/b/a/b/e/a$e$b;
    //   315: goto -274 -> 41
    //   318: astore_1
    //   319: iload 8
    //   321: istore 5
    //   323: new 84	d/l/b/a/b/h/k
    //   326: dup
    //   327: aload_1
    //   328: invokevirtual 148	java/io/IOException:getMessage	()Ljava/lang/String;
    //   331: invokespecial 151	d/l/b/a/b/h/k:<init>	(Ljava/lang/String;)V
    //   334: astore_1
    //   335: iload 8
    //   337: istore 5
    //   339: aload_1
    //   340: aload_0
    //   341: putfield 120	d/l/b/a/b/h/k:Nrq	Ld/l/b/a/b/h/q;
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
    //   386: putfield 122	d/l/b/a/b/e/a$e:Nlq	Ljava/util/List;
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
    //   407: getfield 122	d/l/b/a/b/e/a$e:Nlq	Ljava/util/List;
    //   410: aload_1
    //   411: getstatic 157	d/l/b/a/b/e/a$g:NjZ	Ld/l/b/a/b/h/s;
    //   414: aload_2
    //   415: invokevirtual 160	d/l/b/a/b/h/e:a	(Ld/l/b/a/b/h/s;Ld/l/b/a/b/h/g;)Ld/l/b/a/b/h/q;
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
    //   440: getfield 142	d/l/b/a/b/e/a$e:Nka	I
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
    //   459: getfield 168	d/l/b/a/b/e/a$e:Nlr	Ld/l/b/a/b/e/a$g;
    //   462: invokestatic 171	d/l/b/a/b/e/a$g:b	(Ld/l/b/a/b/e/a$g;)Ld/l/b/a/b/e/a$g$a;
    //   465: astore 10
    //   467: iload_3
    //   468: istore 7
    //   470: iload_3
    //   471: istore 5
    //   473: iload_3
    //   474: istore 8
    //   476: aload_0
    //   477: aload_1
    //   478: getstatic 157	d/l/b/a/b/e/a$g:NjZ	Ld/l/b/a/b/h/s;
    //   481: aload_2
    //   482: invokevirtual 160	d/l/b/a/b/h/e:a	(Ld/l/b/a/b/h/s;Ld/l/b/a/b/h/g;)Ld/l/b/a/b/h/q;
    //   485: checkcast 156	d/l/b/a/b/e/a$g
    //   488: putfield 168	d/l/b/a/b/e/a$e:Nlr	Ld/l/b/a/b/e/a$g;
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
    //   508: getfield 168	d/l/b/a/b/e/a$e:Nlr	Ld/l/b/a/b/e/a$g;
    //   511: invokevirtual 175	d/l/b/a/b/e/a$g$a:f	(Ld/l/b/a/b/e/a$g;)Ld/l/b/a/b/e/a$g$a;
    //   514: pop
    //   515: iload_3
    //   516: istore 7
    //   518: iload_3
    //   519: istore 5
    //   521: iload_3
    //   522: istore 8
    //   524: aload_0
    //   525: aload 10
    //   527: invokevirtual 179	d/l/b/a/b/e/a$g$a:gnV	()Ld/l/b/a/b/e/a$g;
    //   530: putfield 168	d/l/b/a/b/e/a$e:Nlr	Ld/l/b/a/b/e/a$g;
    //   533: iload_3
    //   534: istore 7
    //   536: iload_3
    //   537: istore 5
    //   539: iload_3
    //   540: istore 8
    //   542: aload_0
    //   543: aload_0
    //   544: getfield 142	d/l/b/a/b/e/a$e:Nka	I
    //   547: iconst_2
    //   548: ior
    //   549: putfield 142	d/l/b/a/b/e/a$e:Nka	I
    //   552: goto -511 -> 41
    //   555: iload_3
    //   556: istore 7
    //   558: iload_3
    //   559: istore 5
    //   561: iload_3
    //   562: istore 8
    //   564: aload_1
    //   565: invokevirtual 109	d/l/b/a/b/h/e:zc	()I
    //   568: istore 9
    //   570: iload_3
    //   571: istore 7
    //   573: iload_3
    //   574: istore 5
    //   576: iload_3
    //   577: istore 8
    //   579: iload 9
    //   581: invokestatic 183	d/l/b/a/b/e/a$e$c:ajI	(I)Ld/l/b/a/b/e/a$e$c;
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
    //   604: invokevirtual 116	d/l/b/a/b/h/f:fO	(I)V
    //   607: iload_3
    //   608: istore 7
    //   610: iload_3
    //   611: istore 5
    //   613: iload_3
    //   614: istore 8
    //   616: aload 12
    //   618: iload 9
    //   620: invokevirtual 116	d/l/b/a/b/h/f:fO	(I)V
    //   623: goto -582 -> 41
    //   626: iload_3
    //   627: istore 7
    //   629: iload_3
    //   630: istore 5
    //   632: iload_3
    //   633: istore 8
    //   635: aload_0
    //   636: aload_0
    //   637: getfield 142	d/l/b/a/b/e/a$e:Nka	I
    //   640: iconst_4
    //   641: ior
    //   642: putfield 142	d/l/b/a/b/e/a$e:Nka	I
    //   645: iload_3
    //   646: istore 7
    //   648: iload_3
    //   649: istore 5
    //   651: iload_3
    //   652: istore 8
    //   654: aload_0
    //   655: aload 10
    //   657: putfield 185	d/l/b/a/b/e/a$e:Nls	Ld/l/b/a/b/e/a$e$c;
    //   660: goto -619 -> 41
    //   663: iload_3
    //   664: iconst_2
    //   665: iand
    //   666: iconst_2
    //   667: if_icmpne +14 -> 681
    //   670: aload_0
    //   671: aload_0
    //   672: getfield 122	d/l/b/a/b/e/a$e:Nlq	Ljava/util/List;
    //   675: invokestatic 128	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   678: putfield 122	d/l/b/a/b/e/a$e:Nlq	Ljava/util/List;
    //   681: aload 12
    //   683: invokevirtual 131	d/l/b/a/b/h/f:flush	()V
    //   686: aload_0
    //   687: aload 11
    //   689: invokevirtual 137	d/l/b/a/b/h/d$b:grv	()Ld/l/b/a/b/h/d;
    //   692: putfield 81	d/l/b/a/b/e/a$e:NjY	Ld/l/b/a/b/h/d;
    //   695: aload_0
    //   696: invokevirtual 140	d/l/b/a/b/e/a$e:grN	()V
    //   699: ldc 87
    //   701: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   704: return
    //   705: astore_1
    //   706: aload_0
    //   707: aload 11
    //   709: invokevirtual 137	d/l/b/a/b/h/d$b:grv	()Ld/l/b/a/b/h/d;
    //   712: putfield 81	d/l/b/a/b/e/a$e:NjY	Ld/l/b/a/b/h/d;
    //   715: goto -20 -> 695
    //   718: astore_1
    //   719: aload_0
    //   720: aload 11
    //   722: invokevirtual 137	d/l/b/a/b/h/d$b:grv	()Ld/l/b/a/b/h/d;
    //   725: putfield 81	d/l/b/a/b/e/a$e:NjY	Ld/l/b/a/b/h/d;
    //   728: ldc 87
    //   730: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   733: aload_1
    //   734: athrow
    //   735: astore_2
    //   736: aload_0
    //   737: aload 11
    //   739: invokevirtual 137	d/l/b/a/b/h/d$b:grv	()Ld/l/b/a/b/h/d;
    //   742: putfield 81	d/l/b/a/b/e/a$e:NjY	Ld/l/b/a/b/h/d;
    //   745: goto -475 -> 270
    //   748: astore_1
    //   749: aload_0
    //   750: aload 11
    //   752: invokevirtual 137	d/l/b/a/b/h/d$b:grv	()Ld/l/b/a/b/h/d;
    //   755: putfield 81	d/l/b/a/b/e/a$e:NjY	Ld/l/b/a/b/h/d;
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
    //   0	780	1	parame	d.l.b.a.b.h.e
    //   0	780	2	paramg	d.l.b.a.b.h.g
    //   40	626	3	i	int
    //   59	544	4	j	int
    //   50	600	5	k	int
    //   37	739	6	m	int
    //   47	600	7	n	int
    //   53	600	8	i1	int
    //   153	466	9	i2	int
    //   169	598	10	localObject	Object
    //   26	725	11	localb	d.l.b.a.b.h.d.b
    //   34	648	12	localf	f
    // Exception table:
    //   from	to	target	type
    //   55	61	211	d/l/b/a/b/h/k
    //   121	134	211	d/l/b/a/b/h/k
    //   149	155	211	d/l/b/a/b/h/k
    //   164	171	211	d/l/b/a/b/h/k
    //   185	192	211	d/l/b/a/b/h/k
    //   201	208	211	d/l/b/a/b/h/k
    //   290	300	211	d/l/b/a/b/h/k
    //   309	315	211	d/l/b/a/b/h/k
    //   378	389	211	d/l/b/a/b/h/k
    //   406	424	211	d/l/b/a/b/h/k
    //   439	449	211	d/l/b/a/b/h/k
    //   458	467	211	d/l/b/a/b/h/k
    //   476	491	211	d/l/b/a/b/h/k
    //   505	515	211	d/l/b/a/b/h/k
    //   524	533	211	d/l/b/a/b/h/k
    //   542	552	211	d/l/b/a/b/h/k
    //   564	570	211	d/l/b/a/b/h/k
    //   579	586	211	d/l/b/a/b/h/k
    //   600	607	211	d/l/b/a/b/h/k
    //   616	623	211	d/l/b/a/b/h/k
    //   635	645	211	d/l/b/a/b/h/k
    //   654	660	211	d/l/b/a/b/h/k
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
    this.NjY = parama.NjY;
  }
  
  private void gmq()
  {
    AppMethodBeat.i(58520);
    this.Nlp = b.Nlt;
    this.Nlq = Collections.emptyList();
    this.Nlr = a.g.gnP();
    this.Nls = c.Nlx;
    AppMethodBeat.o(58520);
  }
  
  public static e gnC()
  {
    return Nlo;
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(58522);
    zp();
    if ((this.Nka & 0x1) == 1) {
      paramf.lr(1, this.Nlp.value);
    }
    int i = 0;
    while (i < this.Nlq.size())
    {
      paramf.a(2, (q)this.Nlq.get(i));
      i += 1;
    }
    if ((this.Nka & 0x2) == 2) {
      paramf.a(3, this.Nlr);
    }
    if ((this.Nka & 0x4) == 4) {
      paramf.lr(4, this.Nls.value);
    }
    paramf.e(this.NjY);
    AppMethodBeat.o(58522);
  }
  
  public final s<e> gmo()
  {
    return NjZ;
  }
  
  public final boolean gnD()
  {
    return (this.Nka & 0x1) == 1;
  }
  
  public final boolean gnE()
  {
    return (this.Nka & 0x2) == 2;
  }
  
  public final boolean gnF()
  {
    return (this.Nka & 0x4) == 4;
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(58521);
    int i = this.Nkd;
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
    while (i < this.Nlq.size())
    {
      if (!((a.g)this.Nlq.get(i)).isInitialized())
      {
        this.Nkd = 0;
        AppMethodBeat.o(58521);
        return false;
      }
      i += 1;
    }
    if ((gnE()) && (!this.Nlr.isInitialized()))
    {
      this.Nkd = 0;
      AppMethodBeat.o(58521);
      return false;
    }
    this.Nkd = 1;
    AppMethodBeat.o(58521);
    return true;
  }
  
  public final int zp()
  {
    int j = 0;
    AppMethodBeat.i(58523);
    int i = this.Nke;
    if (i != -1)
    {
      AppMethodBeat.o(58523);
      return i;
    }
    if ((this.Nka & 0x1) == 1) {
      i = f.ls(1, this.Nlp.value) + 0;
    }
    for (;;)
    {
      if (j < this.Nlq.size())
      {
        int k = f.c(2, (q)this.Nlq.get(j));
        j += 1;
        i = k + i;
      }
      else
      {
        j = i;
        if ((this.Nka & 0x2) == 2) {
          j = i + f.c(3, this.Nlr);
        }
        i = j;
        if ((this.Nka & 0x4) == 4) {
          i = j + f.ls(4, this.Nls.value);
        }
        i = this.NjY.size() + i;
        this.Nke = i;
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
    private int Nka;
    private a.e.b Nlp;
    private List<a.g> Nlq;
    private a.g Nlr;
    private a.e.c Nls;
    
    private a()
    {
      AppMethodBeat.i(58491);
      this.Nlp = a.e.b.Nlt;
      this.Nlq = Collections.emptyList();
      this.Nlr = a.g.gnP();
      this.Nls = a.e.c.Nlx;
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
      this.Nka |= 0x1;
      this.Nlp = paramb;
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
      this.Nka |= 0x8;
      this.Nls = paramc;
      AppMethodBeat.o(58500);
      return this;
    }
    
    private a a(a.g paramg)
    {
      AppMethodBeat.i(58499);
      if (((this.Nka & 0x4) == 4) && (this.Nlr != a.g.gnP())) {}
      for (this.Nlr = a.g.b(this.Nlr).f(paramg).gnV();; this.Nlr = paramg)
      {
        this.Nka |= 0x4;
        AppMethodBeat.o(58499);
        return this;
      }
    }
    
    private a gnG()
    {
      AppMethodBeat.i(58492);
      a locala = new a().c(gnH());
      AppMethodBeat.o(58492);
      return locala;
    }
    
    private a.e gnH()
    {
      int j = 1;
      AppMethodBeat.i(58493);
      a.e locale = new a.e(this, (byte)0);
      int k = this.Nka;
      if ((k & 0x1) == 1) {}
      for (;;)
      {
        a.e.a(locale, this.Nlp);
        if ((this.Nka & 0x2) == 2)
        {
          this.Nlq = Collections.unmodifiableList(this.Nlq);
          this.Nka &= 0xFFFFFFFD;
        }
        a.e.a(locale, this.Nlq);
        int i = j;
        if ((k & 0x4) == 4) {
          i = j | 0x2;
        }
        a.e.a(locale, this.Nlr);
        j = i;
        if ((k & 0x8) == 8) {
          j = i | 0x4;
        }
        a.e.a(locale, this.Nls);
        a.e.a(locale, j);
        AppMethodBeat.o(58493);
        return locale;
        j = 0;
      }
    }
    
    private void gnI()
    {
      AppMethodBeat.i(58498);
      if ((this.Nka & 0x2) != 2)
      {
        this.Nlq = new ArrayList(this.Nlq);
        this.Nka |= 0x2;
      }
      AppMethodBeat.o(58498);
    }
    
    /* Error */
    private a j(d.l.b.a.b.h.e parame, d.l.b.a.b.h.g paramg)
    {
      // Byte code:
      //   0: ldc 141
      //   2: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: getstatic 145	d/l/b/a/b/e/a$e:NjZ	Ld/l/b/a/b/h/s;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 150 3 0
      //   17: checkcast 9	d/l/b/a/b/e/a$e
      //   20: astore_1
      //   21: aload_0
      //   22: aload_1
      //   23: invokevirtual 104	d/l/b/a/b/e/a$e$a:c	(Ld/l/b/a/b/e/a$e;)Ld/l/b/a/b/e/a$e$a;
      //   26: pop
      //   27: ldc 141
      //   29: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   32: aload_0
      //   33: areturn
      //   34: astore_1
      //   35: aload_1
      //   36: getfield 154	d/l/b/a/b/h/k:Nrq	Ld/l/b/a/b/h/q;
      //   39: checkcast 9	d/l/b/a/b/e/a$e
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
      //   57: invokevirtual 104	d/l/b/a/b/e/a$e$a:c	(Ld/l/b/a/b/e/a$e;)Ld/l/b/a/b/e/a$e$a;
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
      //   0	74	1	parame	d.l.b.a.b.h.e
      //   0	74	2	paramg	d.l.b.a.b.h.g
      //   6	64	3	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   7	21	34	d/l/b/a/b/h/k
      //   43	50	50	finally
      //   7	21	68	finally
      //   35	43	68	finally
    }
    
    public final a c(a.e parame)
    {
      AppMethodBeat.i(58494);
      if (parame == a.e.gnC())
      {
        AppMethodBeat.o(58494);
        return this;
      }
      if (parame.gnD()) {
        a(parame.Nlp);
      }
      if (!a.e.a(parame).isEmpty())
      {
        if (!this.Nlq.isEmpty()) {
          break label132;
        }
        this.Nlq = a.e.a(parame);
        this.Nka &= 0xFFFFFFFD;
      }
      for (;;)
      {
        if (parame.gnE()) {
          a(parame.Nlr);
        }
        if (parame.gnF()) {
          a(parame.Nls);
        }
        this.NjY = this.NjY.a(a.e.b(parame));
        AppMethodBeat.o(58494);
        return this;
        label132:
        gnI();
        this.Nlq.addAll(a.e.a(parame));
      }
    }
    
    public final boolean isInitialized()
    {
      AppMethodBeat.i(58495);
      int i = 0;
      while (i < this.Nlq.size())
      {
        if (!((a.g)this.Nlq.get(i)).isInitialized())
        {
          AppMethodBeat.o(58495);
          return false;
        }
        i += 1;
      }
      if ((this.Nka & 0x4) == 4) {}
      for (i = 1; (i != 0) && (!this.Nlr.isInitialized()); i = 0)
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
    private static j.b<b> NkH;
    final int value;
    
    static
    {
      AppMethodBeat.i(58514);
      Nlt = new b("RETURNS_CONSTANT", 0, 0);
      Nlu = new b("CALLS", 1, 1);
      Nlv = new b("RETURNS_NOT_NULL", 2, 2);
      Nlw = new b[] { Nlt, Nlu, Nlv };
      NkH = new j.b() {};
      AppMethodBeat.o(58514);
    }
    
    private b(int paramInt1, int paramInt2)
    {
      this.value = paramInt1;
    }
    
    public static b ajH(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 0: 
        return Nlt;
      case 1: 
        return Nlu;
      }
      return Nlv;
    }
    
    public final int getNumber()
    {
      return this.value;
    }
  }
  
  public static enum c
    implements j.a
  {
    private static j.b<c> NkH;
    final int value;
    
    static
    {
      AppMethodBeat.i(58518);
      Nlx = new c("AT_MOST_ONCE", 0, 0);
      Nly = new c("EXACTLY_ONCE", 1, 1);
      Nlz = new c("AT_LEAST_ONCE", 2, 2);
      NlA = new c[] { Nlx, Nly, Nlz };
      NkH = new j.b() {};
      AppMethodBeat.o(58518);
    }
    
    private c(int paramInt1, int paramInt2)
    {
      this.value = paramInt1;
    }
    
    public static c ajI(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 0: 
        return Nlx;
      case 1: 
        return Nly;
      }
      return Nlz;
    }
    
    public final int getNumber()
    {
      return this.value;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.e.a.e
 * JD-Core Version:    0.7.0.1
 */