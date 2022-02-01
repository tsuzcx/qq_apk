package kotlin.l.b.a.b.e.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b.a.b.h.b;
import kotlin.l.b.a.b.h.f;
import kotlin.l.b.a.b.h.i;
import kotlin.l.b.a.b.h.i.a;
import kotlin.l.b.a.b.h.s;

public final class a$c
  extends i
  implements d
{
  private static final c TBZ;
  public static s<c> TwL;
  public a.a TCa;
  public a.b TCb;
  public a.b TCc;
  public a.b TCd;
  private final kotlin.l.b.a.b.h.d TwK;
  private int bOT;
  private byte bPe = -1;
  private int bVY = -1;
  
  static
  {
    AppMethodBeat.i(59159);
    TwL = new b() {};
    c localc = new c();
    TBZ = localc;
    localc.hEu();
    AppMethodBeat.o(59159);
  }
  
  private a$c()
  {
    this.TwK = kotlin.l.b.a.b.h.d.TDp;
  }
  
  /* Error */
  private a$c(kotlin.l.b.a.b.h.e parame, kotlin.l.b.a.b.h.g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 57	kotlin/l/b/a/b/h/i:<init>	()V
    //   4: ldc 74
    //   6: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 59	kotlin/l/b/a/b/e/c/a$c:bPe	B
    //   14: aload_0
    //   15: iconst_m1
    //   16: putfield 61	kotlin/l/b/a/b/e/c/a$c:bVY	I
    //   19: aload_0
    //   20: invokespecial 52	kotlin/l/b/a/b/e/c/a$c:hEu	()V
    //   23: invokestatic 78	kotlin/l/b/a/b/h/d:hJo	()Lkotlin/l/b/a/b/h/d$b;
    //   26: astore 6
    //   28: aload 6
    //   30: iconst_1
    //   31: invokestatic 84	kotlin/l/b/a/b/h/f:f	(Ljava/io/OutputStream;I)Lkotlin/l/b/a/b/h/f;
    //   34: astore 7
    //   36: iconst_0
    //   37: istore_3
    //   38: iload_3
    //   39: ifne +430 -> 469
    //   42: aload_1
    //   43: invokevirtual 90	kotlin/l/b/a/b/h/e:yT	()I
    //   46: istore 4
    //   48: iload 4
    //   50: lookupswitch	default:+527->577, 0:+530->580, 10:+68->118, 18:+178->228, 26:+274->324, 34:+345->395
    //   101: aload_1
    //   102: aload 7
    //   104: aload_2
    //   105: iload 4
    //   107: invokevirtual 93	kotlin/l/b/a/b/e/c/a$c:a	(Lkotlin/l/b/a/b/h/e;Lkotlin/l/b/a/b/h/f;Lkotlin/l/b/a/b/h/g;I)Z
    //   110: ifne -72 -> 38
    //   113: iconst_1
    //   114: istore_3
    //   115: goto -77 -> 38
    //   118: aload_0
    //   119: getfield 95	kotlin/l/b/a/b/e/c/a$c:bOT	I
    //   122: iconst_1
    //   123: iand
    //   124: iconst_1
    //   125: if_icmpne +446 -> 571
    //   128: aload_0
    //   129: getfield 97	kotlin/l/b/a/b/e/c/a$c:TCa	Lkotlin/l/b/a/b/e/c/a$a;
    //   132: invokevirtual 103	kotlin/l/b/a/b/e/c/a$a:hIo	()Lkotlin/l/b/a/b/e/c/a$a$a;
    //   135: astore 5
    //   137: aload_0
    //   138: aload_1
    //   139: getstatic 104	kotlin/l/b/a/b/e/c/a$a:TwL	Lkotlin/l/b/a/b/h/s;
    //   142: aload_2
    //   143: invokevirtual 107	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/s;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/q;
    //   146: checkcast 99	kotlin/l/b/a/b/e/c/a$a
    //   149: putfield 97	kotlin/l/b/a/b/e/c/a$c:TCa	Lkotlin/l/b/a/b/e/c/a$a;
    //   152: aload 5
    //   154: ifnull +22 -> 176
    //   157: aload 5
    //   159: aload_0
    //   160: getfield 97	kotlin/l/b/a/b/e/c/a$c:TCa	Lkotlin/l/b/a/b/e/c/a$a;
    //   163: invokevirtual 112	kotlin/l/b/a/b/e/c/a$a$a:c	(Lkotlin/l/b/a/b/e/c/a$a;)Lkotlin/l/b/a/b/e/c/a$a$a;
    //   166: pop
    //   167: aload_0
    //   168: aload 5
    //   170: invokevirtual 116	kotlin/l/b/a/b/e/c/a$a$a:hIq	()Lkotlin/l/b/a/b/e/c/a$a;
    //   173: putfield 97	kotlin/l/b/a/b/e/c/a$c:TCa	Lkotlin/l/b/a/b/e/c/a$a;
    //   176: aload_0
    //   177: aload_0
    //   178: getfield 95	kotlin/l/b/a/b/e/c/a$c:bOT	I
    //   181: iconst_1
    //   182: ior
    //   183: putfield 95	kotlin/l/b/a/b/e/c/a$c:bOT	I
    //   186: goto -148 -> 38
    //   189: astore_1
    //   190: aload_1
    //   191: aload_0
    //   192: putfield 120	kotlin/l/b/a/b/h/k:TDK	Lkotlin/l/b/a/b/h/q;
    //   195: ldc 74
    //   197: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   200: aload_1
    //   201: athrow
    //   202: astore_1
    //   203: aload 7
    //   205: invokevirtual 123	kotlin/l/b/a/b/h/f:flush	()V
    //   208: aload_0
    //   209: aload 6
    //   211: invokevirtual 129	kotlin/l/b/a/b/h/d$b:hJs	()Lkotlin/l/b/a/b/h/d;
    //   214: putfield 68	kotlin/l/b/a/b/e/c/a$c:TwK	Lkotlin/l/b/a/b/h/d;
    //   217: aload_0
    //   218: invokevirtual 132	kotlin/l/b/a/b/e/c/a$c:Gw	()V
    //   221: ldc 74
    //   223: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   226: aload_1
    //   227: athrow
    //   228: aload_0
    //   229: getfield 95	kotlin/l/b/a/b/e/c/a$c:bOT	I
    //   232: iconst_2
    //   233: iand
    //   234: iconst_2
    //   235: if_icmpne +330 -> 565
    //   238: aload_0
    //   239: getfield 134	kotlin/l/b/a/b/e/c/a$c:TCb	Lkotlin/l/b/a/b/e/c/a$b;
    //   242: invokevirtual 140	kotlin/l/b/a/b/e/c/a$b:hIt	()Lkotlin/l/b/a/b/e/c/a$b$a;
    //   245: astore 5
    //   247: aload_0
    //   248: aload_1
    //   249: getstatic 141	kotlin/l/b/a/b/e/c/a$b:TwL	Lkotlin/l/b/a/b/h/s;
    //   252: aload_2
    //   253: invokevirtual 107	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/s;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/q;
    //   256: checkcast 136	kotlin/l/b/a/b/e/c/a$b
    //   259: putfield 134	kotlin/l/b/a/b/e/c/a$c:TCb	Lkotlin/l/b/a/b/e/c/a$b;
    //   262: aload 5
    //   264: ifnull +22 -> 286
    //   267: aload 5
    //   269: aload_0
    //   270: getfield 134	kotlin/l/b/a/b/e/c/a$c:TCb	Lkotlin/l/b/a/b/e/c/a$b;
    //   273: invokevirtual 146	kotlin/l/b/a/b/e/c/a$b$a:c	(Lkotlin/l/b/a/b/e/c/a$b;)Lkotlin/l/b/a/b/e/c/a$b$a;
    //   276: pop
    //   277: aload_0
    //   278: aload 5
    //   280: invokevirtual 150	kotlin/l/b/a/b/e/c/a$b$a:hIv	()Lkotlin/l/b/a/b/e/c/a$b;
    //   283: putfield 134	kotlin/l/b/a/b/e/c/a$c:TCb	Lkotlin/l/b/a/b/e/c/a$b;
    //   286: aload_0
    //   287: aload_0
    //   288: getfield 95	kotlin/l/b/a/b/e/c/a$c:bOT	I
    //   291: iconst_2
    //   292: ior
    //   293: putfield 95	kotlin/l/b/a/b/e/c/a$c:bOT	I
    //   296: goto -258 -> 38
    //   299: astore_1
    //   300: new 71	kotlin/l/b/a/b/h/k
    //   303: dup
    //   304: aload_1
    //   305: invokevirtual 154	java/io/IOException:getMessage	()Ljava/lang/String;
    //   308: invokespecial 157	kotlin/l/b/a/b/h/k:<init>	(Ljava/lang/String;)V
    //   311: astore_1
    //   312: aload_1
    //   313: aload_0
    //   314: putfield 120	kotlin/l/b/a/b/h/k:TDK	Lkotlin/l/b/a/b/h/q;
    //   317: ldc 74
    //   319: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   322: aload_1
    //   323: athrow
    //   324: aload_0
    //   325: getfield 95	kotlin/l/b/a/b/e/c/a$c:bOT	I
    //   328: iconst_4
    //   329: iand
    //   330: iconst_4
    //   331: if_icmpne +228 -> 559
    //   334: aload_0
    //   335: getfield 159	kotlin/l/b/a/b/e/c/a$c:TCc	Lkotlin/l/b/a/b/e/c/a$b;
    //   338: invokevirtual 140	kotlin/l/b/a/b/e/c/a$b:hIt	()Lkotlin/l/b/a/b/e/c/a$b$a;
    //   341: astore 5
    //   343: aload_0
    //   344: aload_1
    //   345: getstatic 141	kotlin/l/b/a/b/e/c/a$b:TwL	Lkotlin/l/b/a/b/h/s;
    //   348: aload_2
    //   349: invokevirtual 107	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/s;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/q;
    //   352: checkcast 136	kotlin/l/b/a/b/e/c/a$b
    //   355: putfield 159	kotlin/l/b/a/b/e/c/a$c:TCc	Lkotlin/l/b/a/b/e/c/a$b;
    //   358: aload 5
    //   360: ifnull +22 -> 382
    //   363: aload 5
    //   365: aload_0
    //   366: getfield 159	kotlin/l/b/a/b/e/c/a$c:TCc	Lkotlin/l/b/a/b/e/c/a$b;
    //   369: invokevirtual 146	kotlin/l/b/a/b/e/c/a$b$a:c	(Lkotlin/l/b/a/b/e/c/a$b;)Lkotlin/l/b/a/b/e/c/a$b$a;
    //   372: pop
    //   373: aload_0
    //   374: aload 5
    //   376: invokevirtual 150	kotlin/l/b/a/b/e/c/a$b$a:hIv	()Lkotlin/l/b/a/b/e/c/a$b;
    //   379: putfield 159	kotlin/l/b/a/b/e/c/a$c:TCc	Lkotlin/l/b/a/b/e/c/a$b;
    //   382: aload_0
    //   383: aload_0
    //   384: getfield 95	kotlin/l/b/a/b/e/c/a$c:bOT	I
    //   387: iconst_4
    //   388: ior
    //   389: putfield 95	kotlin/l/b/a/b/e/c/a$c:bOT	I
    //   392: goto -354 -> 38
    //   395: aload_0
    //   396: getfield 95	kotlin/l/b/a/b/e/c/a$c:bOT	I
    //   399: bipush 8
    //   401: iand
    //   402: bipush 8
    //   404: if_icmpne +149 -> 553
    //   407: aload_0
    //   408: getfield 161	kotlin/l/b/a/b/e/c/a$c:TCd	Lkotlin/l/b/a/b/e/c/a$b;
    //   411: invokevirtual 140	kotlin/l/b/a/b/e/c/a$b:hIt	()Lkotlin/l/b/a/b/e/c/a$b$a;
    //   414: astore 5
    //   416: aload_0
    //   417: aload_1
    //   418: getstatic 141	kotlin/l/b/a/b/e/c/a$b:TwL	Lkotlin/l/b/a/b/h/s;
    //   421: aload_2
    //   422: invokevirtual 107	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/s;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/q;
    //   425: checkcast 136	kotlin/l/b/a/b/e/c/a$b
    //   428: putfield 161	kotlin/l/b/a/b/e/c/a$c:TCd	Lkotlin/l/b/a/b/e/c/a$b;
    //   431: aload 5
    //   433: ifnull +22 -> 455
    //   436: aload 5
    //   438: aload_0
    //   439: getfield 161	kotlin/l/b/a/b/e/c/a$c:TCd	Lkotlin/l/b/a/b/e/c/a$b;
    //   442: invokevirtual 146	kotlin/l/b/a/b/e/c/a$b$a:c	(Lkotlin/l/b/a/b/e/c/a$b;)Lkotlin/l/b/a/b/e/c/a$b$a;
    //   445: pop
    //   446: aload_0
    //   447: aload 5
    //   449: invokevirtual 150	kotlin/l/b/a/b/e/c/a$b$a:hIv	()Lkotlin/l/b/a/b/e/c/a$b;
    //   452: putfield 161	kotlin/l/b/a/b/e/c/a$c:TCd	Lkotlin/l/b/a/b/e/c/a$b;
    //   455: aload_0
    //   456: aload_0
    //   457: getfield 95	kotlin/l/b/a/b/e/c/a$c:bOT	I
    //   460: bipush 8
    //   462: ior
    //   463: putfield 95	kotlin/l/b/a/b/e/c/a$c:bOT	I
    //   466: goto -428 -> 38
    //   469: aload 7
    //   471: invokevirtual 123	kotlin/l/b/a/b/h/f:flush	()V
    //   474: aload_0
    //   475: aload 6
    //   477: invokevirtual 129	kotlin/l/b/a/b/h/d$b:hJs	()Lkotlin/l/b/a/b/h/d;
    //   480: putfield 68	kotlin/l/b/a/b/e/c/a$c:TwK	Lkotlin/l/b/a/b/h/d;
    //   483: aload_0
    //   484: invokevirtual 132	kotlin/l/b/a/b/e/c/a$c:Gw	()V
    //   487: ldc 74
    //   489: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   492: return
    //   493: astore_1
    //   494: aload_0
    //   495: aload 6
    //   497: invokevirtual 129	kotlin/l/b/a/b/h/d$b:hJs	()Lkotlin/l/b/a/b/h/d;
    //   500: putfield 68	kotlin/l/b/a/b/e/c/a$c:TwK	Lkotlin/l/b/a/b/h/d;
    //   503: goto -20 -> 483
    //   506: astore_1
    //   507: aload_0
    //   508: aload 6
    //   510: invokevirtual 129	kotlin/l/b/a/b/h/d$b:hJs	()Lkotlin/l/b/a/b/h/d;
    //   513: putfield 68	kotlin/l/b/a/b/e/c/a$c:TwK	Lkotlin/l/b/a/b/h/d;
    //   516: ldc 74
    //   518: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   521: aload_1
    //   522: athrow
    //   523: astore_2
    //   524: aload_0
    //   525: aload 6
    //   527: invokevirtual 129	kotlin/l/b/a/b/h/d$b:hJs	()Lkotlin/l/b/a/b/h/d;
    //   530: putfield 68	kotlin/l/b/a/b/e/c/a$c:TwK	Lkotlin/l/b/a/b/h/d;
    //   533: goto -316 -> 217
    //   536: astore_1
    //   537: aload_0
    //   538: aload 6
    //   540: invokevirtual 129	kotlin/l/b/a/b/h/d$b:hJs	()Lkotlin/l/b/a/b/h/d;
    //   543: putfield 68	kotlin/l/b/a/b/e/c/a$c:TwK	Lkotlin/l/b/a/b/h/d;
    //   546: ldc 74
    //   548: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   551: aload_1
    //   552: athrow
    //   553: aconst_null
    //   554: astore 5
    //   556: goto -140 -> 416
    //   559: aconst_null
    //   560: astore 5
    //   562: goto -219 -> 343
    //   565: aconst_null
    //   566: astore 5
    //   568: goto -321 -> 247
    //   571: aconst_null
    //   572: astore 5
    //   574: goto -437 -> 137
    //   577: goto -477 -> 100
    //   580: iconst_1
    //   581: istore_3
    //   582: goto -544 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	585	0	this	c
    //   0	585	1	parame	kotlin.l.b.a.b.h.e
    //   0	585	2	paramg	kotlin.l.b.a.b.h.g
    //   37	545	3	i	int
    //   46	60	4	j	int
    //   135	438	5	localObject	java.lang.Object
    //   26	513	6	localb	kotlin.l.b.a.b.h.d.b
    //   34	436	7	localf	f
    // Exception table:
    //   from	to	target	type
    //   42	48	189	kotlin/l/b/a/b/h/k
    //   100	113	189	kotlin/l/b/a/b/h/k
    //   118	137	189	kotlin/l/b/a/b/h/k
    //   137	152	189	kotlin/l/b/a/b/h/k
    //   157	176	189	kotlin/l/b/a/b/h/k
    //   176	186	189	kotlin/l/b/a/b/h/k
    //   228	247	189	kotlin/l/b/a/b/h/k
    //   247	262	189	kotlin/l/b/a/b/h/k
    //   267	286	189	kotlin/l/b/a/b/h/k
    //   286	296	189	kotlin/l/b/a/b/h/k
    //   324	343	189	kotlin/l/b/a/b/h/k
    //   343	358	189	kotlin/l/b/a/b/h/k
    //   363	382	189	kotlin/l/b/a/b/h/k
    //   382	392	189	kotlin/l/b/a/b/h/k
    //   395	416	189	kotlin/l/b/a/b/h/k
    //   416	431	189	kotlin/l/b/a/b/h/k
    //   436	455	189	kotlin/l/b/a/b/h/k
    //   455	466	189	kotlin/l/b/a/b/h/k
    //   42	48	202	finally
    //   100	113	202	finally
    //   118	137	202	finally
    //   137	152	202	finally
    //   157	176	202	finally
    //   176	186	202	finally
    //   190	202	202	finally
    //   228	247	202	finally
    //   247	262	202	finally
    //   267	286	202	finally
    //   286	296	202	finally
    //   300	324	202	finally
    //   324	343	202	finally
    //   343	358	202	finally
    //   363	382	202	finally
    //   382	392	202	finally
    //   395	416	202	finally
    //   416	431	202	finally
    //   436	455	202	finally
    //   455	466	202	finally
    //   42	48	299	java/io/IOException
    //   100	113	299	java/io/IOException
    //   118	137	299	java/io/IOException
    //   137	152	299	java/io/IOException
    //   157	176	299	java/io/IOException
    //   176	186	299	java/io/IOException
    //   228	247	299	java/io/IOException
    //   247	262	299	java/io/IOException
    //   267	286	299	java/io/IOException
    //   286	296	299	java/io/IOException
    //   324	343	299	java/io/IOException
    //   343	358	299	java/io/IOException
    //   363	382	299	java/io/IOException
    //   382	392	299	java/io/IOException
    //   395	416	299	java/io/IOException
    //   416	431	299	java/io/IOException
    //   436	455	299	java/io/IOException
    //   455	466	299	java/io/IOException
    //   469	474	493	java/io/IOException
    //   469	474	506	finally
    //   203	208	523	java/io/IOException
    //   203	208	536	finally
  }
  
  private a$c(i.a parama)
  {
    super((byte)0);
    this.TwK = parama.TwK;
  }
  
  private void hEu()
  {
    AppMethodBeat.i(59154);
    this.TCa = a.a.hIm();
    this.TCb = a.b.hIs();
    this.TCc = a.b.hIs();
    this.TCd = a.b.hIs();
    AppMethodBeat.o(59154);
  }
  
  public static c hIx()
  {
    return TBZ;
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(59155);
    yC();
    if ((this.bOT & 0x1) == 1) {
      paramf.a(1, this.TCa);
    }
    if ((this.bOT & 0x2) == 2) {
      paramf.a(2, this.TCb);
    }
    if ((this.bOT & 0x4) == 4) {
      paramf.a(3, this.TCc);
    }
    if ((this.bOT & 0x8) == 8) {
      paramf.a(4, this.TCd);
    }
    paramf.e(this.TwK);
    AppMethodBeat.o(59155);
  }
  
  public final s<c> hEs()
  {
    return TwL;
  }
  
  public final boolean hIA()
  {
    return (this.bOT & 0x4) == 4;
  }
  
  public final boolean hIB()
  {
    return (this.bOT & 0x8) == 8;
  }
  
  public final boolean hIy()
  {
    return (this.bOT & 0x1) == 1;
  }
  
  public final boolean hIz()
  {
    return (this.bOT & 0x2) == 2;
  }
  
  public final boolean isInitialized()
  {
    int i = this.bPe;
    if (i == 1) {
      return true;
    }
    if (i == 0) {
      return false;
    }
    this.bPe = 1;
    return true;
  }
  
  public final int yC()
  {
    AppMethodBeat.i(59156);
    int i = this.bVY;
    if (i != -1)
    {
      AppMethodBeat.o(59156);
      return i;
    }
    int j = 0;
    if ((this.bOT & 0x1) == 1) {
      j = f.c(1, this.TCa) + 0;
    }
    i = j;
    if ((this.bOT & 0x2) == 2) {
      i = j + f.c(2, this.TCb);
    }
    j = i;
    if ((this.bOT & 0x4) == 4) {
      j = i + f.c(3, this.TCc);
    }
    i = j;
    if ((this.bOT & 0x8) == 8) {
      i = j + f.c(4, this.TCd);
    }
    i += this.TwK.size();
    this.bVY = i;
    AppMethodBeat.o(59156);
    return i;
  }
  
  public static final class a
    extends i.a<a.c, a>
    implements d
  {
    private a.a TCa;
    private a.b TCb;
    private a.b TCc;
    private a.b TCd;
    private int bOT;
    
    private a()
    {
      AppMethodBeat.i(59134);
      this.TCa = a.a.hIm();
      this.TCb = a.b.hIs();
      this.TCc = a.b.hIs();
      this.TCd = a.b.hIs();
      AppMethodBeat.o(59134);
    }
    
    /* Error */
    private a D(kotlin.l.b.a.b.h.e parame, kotlin.l.b.a.b.h.g paramg)
    {
      // Byte code:
      //   0: ldc 61
      //   2: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: getstatic 65	kotlin/l/b/a/b/e/c/a$c:TwL	Lkotlin/l/b/a/b/h/s;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 70 3 0
      //   17: checkcast 9	kotlin/l/b/a/b/e/c/a$c
      //   20: astore_1
      //   21: aload_0
      //   22: aload_1
      //   23: invokevirtual 74	kotlin/l/b/a/b/e/c/a$c$a:b	(Lkotlin/l/b/a/b/e/c/a$c;)Lkotlin/l/b/a/b/e/c/a$c$a;
      //   26: pop
      //   27: ldc 61
      //   29: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   32: aload_0
      //   33: areturn
      //   34: astore_1
      //   35: aload_1
      //   36: getfield 78	kotlin/l/b/a/b/h/k:TDK	Lkotlin/l/b/a/b/h/q;
      //   39: checkcast 9	kotlin/l/b/a/b/e/c/a$c
      //   42: astore_2
      //   43: ldc 61
      //   45: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   48: aload_1
      //   49: athrow
      //   50: astore_1
      //   51: aload_2
      //   52: ifnull +9 -> 61
      //   55: aload_0
      //   56: aload_2
      //   57: invokevirtual 74	kotlin/l/b/a/b/e/c/a$c$a:b	(Lkotlin/l/b/a/b/e/c/a$c;)Lkotlin/l/b/a/b/e/c/a$c$a;
      //   60: pop
      //   61: ldc 61
      //   63: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
      //   6	64	3	localObject	java.lang.Object
      // Exception table:
      //   from	to	target	type
      //   7	21	34	kotlin/l/b/a/b/h/k
      //   43	50	50	finally
      //   7	21	68	finally
      //   35	43	68	finally
    }
    
    private a d(a.a parama)
    {
      AppMethodBeat.i(59139);
      if (((this.bOT & 0x1) == 1) && (this.TCa != a.a.hIm())) {}
      for (this.TCa = a.a.a(this.TCa).c(parama).hIq();; this.TCa = parama)
      {
        this.bOT |= 0x1;
        AppMethodBeat.o(59139);
        return this;
      }
    }
    
    private a d(a.b paramb)
    {
      AppMethodBeat.i(59140);
      if (((this.bOT & 0x2) == 2) && (this.TCb != a.b.hIs())) {}
      for (this.TCb = a.b.a(this.TCb).c(paramb).hIv();; this.TCb = paramb)
      {
        this.bOT |= 0x2;
        AppMethodBeat.o(59140);
        return this;
      }
    }
    
    private a e(a.b paramb)
    {
      AppMethodBeat.i(59141);
      if (((this.bOT & 0x4) == 4) && (this.TCc != a.b.hIs())) {}
      for (this.TCc = a.b.a(this.TCc).c(paramb).hIv();; this.TCc = paramb)
      {
        this.bOT |= 0x4;
        AppMethodBeat.o(59141);
        return this;
      }
    }
    
    private a f(a.b paramb)
    {
      AppMethodBeat.i(59142);
      if (((this.bOT & 0x8) == 8) && (this.TCd != a.b.hIs())) {}
      for (this.TCd = a.b.a(this.TCd).c(paramb).hIv();; this.TCd = paramb)
      {
        this.bOT |= 0x8;
        AppMethodBeat.o(59142);
        return this;
      }
    }
    
    private a hIC()
    {
      AppMethodBeat.i(59135);
      a locala = new a().b(hID());
      AppMethodBeat.o(59135);
      return locala;
    }
    
    private a.c hID()
    {
      int j = 1;
      AppMethodBeat.i(59136);
      a.c localc = new a.c(this, (byte)0);
      int k = this.bOT;
      if ((k & 0x1) == 1) {}
      for (;;)
      {
        a.c.a(localc, this.TCa);
        int i = j;
        if ((k & 0x2) == 2) {
          i = j | 0x2;
        }
        a.c.a(localc, this.TCb);
        j = i;
        if ((k & 0x4) == 4) {
          j = i | 0x4;
        }
        a.c.b(localc, this.TCc);
        i = j;
        if ((k & 0x8) == 8) {
          i = j | 0x8;
        }
        a.c.c(localc, this.TCd);
        a.c.a(localc, i);
        AppMethodBeat.o(59136);
        return localc;
        j = 0;
      }
    }
    
    public final a b(a.c paramc)
    {
      AppMethodBeat.i(59137);
      if (paramc == a.c.hIx())
      {
        AppMethodBeat.o(59137);
        return this;
      }
      if (paramc.hIy()) {
        d(paramc.TCa);
      }
      if (paramc.hIz()) {
        d(paramc.TCb);
      }
      if (paramc.hIA()) {
        e(paramc.TCc);
      }
      if (paramc.hIB()) {
        f(paramc.TCd);
      }
      this.TwK = this.TwK.a(a.c.a(paramc));
      AppMethodBeat.o(59137);
      return this;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     kotlin.l.b.a.b.e.c.a.c
 * JD-Core Version:    0.7.0.1
 */