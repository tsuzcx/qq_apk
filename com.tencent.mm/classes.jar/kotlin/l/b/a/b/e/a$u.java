package kotlin.l.b.a.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b.a.b.h.b;
import kotlin.l.b.a.b.h.d;
import kotlin.l.b.a.b.h.f;
import kotlin.l.b.a.b.h.i;
import kotlin.l.b.a.b.h.i.a;
import kotlin.l.b.a.b.h.k.a;
import kotlin.l.b.a.b.h.k.b;
import kotlin.l.b.a.b.h.t;

public final class a$u
  extends i
  implements x
{
  public static t<u> aiYa;
  private static final u ajbt;
  private final d aiXZ;
  public int ajbu;
  public int ajbv;
  public b ajbw;
  public int ajbx;
  public int ajby;
  public c ajbz;
  private int bitField0_;
  private int dRJ = -1;
  private byte memoizedIsInitialized = -1;
  
  static
  {
    AppMethodBeat.i(59017);
    aiYa = new b() {};
    u localu = new u();
    ajbt = localu;
    localu.ktf();
    AppMethodBeat.o(59017);
  }
  
  private a$u()
  {
    this.aiXZ = d.ajeU;
  }
  
  /* Error */
  private a$u(kotlin.l.b.a.b.h.e parame, kotlin.l.b.a.b.h.g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 69	kotlin/l/b/a/b/h/i:<init>	()V
    //   4: ldc 86
    //   6: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 71	kotlin/l/b/a/b/e/a$u:memoizedIsInitialized	B
    //   14: aload_0
    //   15: iconst_m1
    //   16: putfield 73	kotlin/l/b/a/b/e/a$u:dRJ	I
    //   19: aload_0
    //   20: invokespecial 64	kotlin/l/b/a/b/e/a$u:ktf	()V
    //   23: invokestatic 90	kotlin/l/b/a/b/h/d:kya	()Lkotlin/l/b/a/b/h/d$b;
    //   26: astore 6
    //   28: aload 6
    //   30: iconst_1
    //   31: invokestatic 95	kotlin/l/b/a/b/h/f:i	(Ljava/io/OutputStream;I)Lkotlin/l/b/a/b/h/f;
    //   34: astore 7
    //   36: iconst_0
    //   37: istore_3
    //   38: iload_3
    //   39: ifne +354 -> 393
    //   42: aload_1
    //   43: invokevirtual 101	kotlin/l/b/a/b/h/e:aac	()I
    //   46: istore 4
    //   48: iload 4
    //   50: lookupswitch	default:+427->477, 0:+430->480, 8:+84->134, 16:+144->194, 24:+190->240, 32:+244->294, 40:+266->316, 48:+288->338
    //   117: aload_1
    //   118: aload 7
    //   120: aload_2
    //   121: iload 4
    //   123: invokevirtual 104	kotlin/l/b/a/b/e/a$u:a	(Lkotlin/l/b/a/b/h/e;Lkotlin/l/b/a/b/h/f;Lkotlin/l/b/a/b/h/g;I)Z
    //   126: ifne -88 -> 38
    //   129: iconst_1
    //   130: istore_3
    //   131: goto -93 -> 38
    //   134: aload_0
    //   135: aload_0
    //   136: getfield 106	kotlin/l/b/a/b/e/a$u:bitField0_	I
    //   139: iconst_1
    //   140: ior
    //   141: putfield 106	kotlin/l/b/a/b/e/a$u:bitField0_	I
    //   144: aload_0
    //   145: aload_1
    //   146: invokevirtual 109	kotlin/l/b/a/b/h/e:aar	()I
    //   149: putfield 111	kotlin/l/b/a/b/e/a$u:ajbu	I
    //   152: goto -114 -> 38
    //   155: astore_1
    //   156: aload_1
    //   157: aload_0
    //   158: putfield 115	kotlin/l/b/a/b/h/l:ajfp	Lkotlin/l/b/a/b/h/r;
    //   161: ldc 86
    //   163: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   166: aload_1
    //   167: athrow
    //   168: astore_1
    //   169: aload 7
    //   171: invokevirtual 118	kotlin/l/b/a/b/h/f:flush	()V
    //   174: aload_0
    //   175: aload 6
    //   177: invokevirtual 124	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   180: putfield 80	kotlin/l/b/a/b/e/a$u:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   183: aload_0
    //   184: invokevirtual 127	kotlin/l/b/a/b/e/a$u:makeExtensionsImmutable	()V
    //   187: ldc 86
    //   189: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   192: aload_1
    //   193: athrow
    //   194: aload_0
    //   195: aload_0
    //   196: getfield 106	kotlin/l/b/a/b/e/a$u:bitField0_	I
    //   199: iconst_2
    //   200: ior
    //   201: putfield 106	kotlin/l/b/a/b/e/a$u:bitField0_	I
    //   204: aload_0
    //   205: aload_1
    //   206: invokevirtual 109	kotlin/l/b/a/b/h/e:aar	()I
    //   209: putfield 129	kotlin/l/b/a/b/e/a$u:ajbv	I
    //   212: goto -174 -> 38
    //   215: astore_1
    //   216: new 83	kotlin/l/b/a/b/h/l
    //   219: dup
    //   220: aload_1
    //   221: invokevirtual 133	java/io/IOException:getMessage	()Ljava/lang/String;
    //   224: invokespecial 136	kotlin/l/b/a/b/h/l:<init>	(Ljava/lang/String;)V
    //   227: astore_1
    //   228: aload_1
    //   229: aload_0
    //   230: putfield 115	kotlin/l/b/a/b/h/l:ajfp	Lkotlin/l/b/a/b/h/r;
    //   233: ldc 86
    //   235: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   238: aload_1
    //   239: athrow
    //   240: aload_1
    //   241: invokevirtual 109	kotlin/l/b/a/b/h/e:aar	()I
    //   244: istore 5
    //   246: iload 5
    //   248: invokestatic 140	kotlin/l/b/a/b/e/a$u$b:aLS	(I)Lkotlin/l/b/a/b/e/a$u$b;
    //   251: astore 8
    //   253: aload 8
    //   255: ifnonnull +20 -> 275
    //   258: aload 7
    //   260: iload 4
    //   262: invokevirtual 143	kotlin/l/b/a/b/h/f:lI	(I)V
    //   265: aload 7
    //   267: iload 5
    //   269: invokevirtual 143	kotlin/l/b/a/b/h/f:lI	(I)V
    //   272: goto -234 -> 38
    //   275: aload_0
    //   276: aload_0
    //   277: getfield 106	kotlin/l/b/a/b/e/a$u:bitField0_	I
    //   280: iconst_4
    //   281: ior
    //   282: putfield 106	kotlin/l/b/a/b/e/a$u:bitField0_	I
    //   285: aload_0
    //   286: aload 8
    //   288: putfield 145	kotlin/l/b/a/b/e/a$u:ajbw	Lkotlin/l/b/a/b/e/a$u$b;
    //   291: goto -253 -> 38
    //   294: aload_0
    //   295: aload_0
    //   296: getfield 106	kotlin/l/b/a/b/e/a$u:bitField0_	I
    //   299: bipush 8
    //   301: ior
    //   302: putfield 106	kotlin/l/b/a/b/e/a$u:bitField0_	I
    //   305: aload_0
    //   306: aload_1
    //   307: invokevirtual 109	kotlin/l/b/a/b/h/e:aar	()I
    //   310: putfield 147	kotlin/l/b/a/b/e/a$u:ajbx	I
    //   313: goto -275 -> 38
    //   316: aload_0
    //   317: aload_0
    //   318: getfield 106	kotlin/l/b/a/b/e/a$u:bitField0_	I
    //   321: bipush 16
    //   323: ior
    //   324: putfield 106	kotlin/l/b/a/b/e/a$u:bitField0_	I
    //   327: aload_0
    //   328: aload_1
    //   329: invokevirtual 109	kotlin/l/b/a/b/h/e:aar	()I
    //   332: putfield 149	kotlin/l/b/a/b/e/a$u:ajby	I
    //   335: goto -297 -> 38
    //   338: aload_1
    //   339: invokevirtual 109	kotlin/l/b/a/b/h/e:aar	()I
    //   342: istore 5
    //   344: iload 5
    //   346: invokestatic 153	kotlin/l/b/a/b/e/a$u$c:aLT	(I)Lkotlin/l/b/a/b/e/a$u$c;
    //   349: astore 8
    //   351: aload 8
    //   353: ifnonnull +20 -> 373
    //   356: aload 7
    //   358: iload 4
    //   360: invokevirtual 143	kotlin/l/b/a/b/h/f:lI	(I)V
    //   363: aload 7
    //   365: iload 5
    //   367: invokevirtual 143	kotlin/l/b/a/b/h/f:lI	(I)V
    //   370: goto -332 -> 38
    //   373: aload_0
    //   374: aload_0
    //   375: getfield 106	kotlin/l/b/a/b/e/a$u:bitField0_	I
    //   378: bipush 32
    //   380: ior
    //   381: putfield 106	kotlin/l/b/a/b/e/a$u:bitField0_	I
    //   384: aload_0
    //   385: aload 8
    //   387: putfield 155	kotlin/l/b/a/b/e/a$u:ajbz	Lkotlin/l/b/a/b/e/a$u$c;
    //   390: goto -352 -> 38
    //   393: aload 7
    //   395: invokevirtual 118	kotlin/l/b/a/b/h/f:flush	()V
    //   398: aload_0
    //   399: aload 6
    //   401: invokevirtual 124	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   404: putfield 80	kotlin/l/b/a/b/e/a$u:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   407: aload_0
    //   408: invokevirtual 127	kotlin/l/b/a/b/e/a$u:makeExtensionsImmutable	()V
    //   411: ldc 86
    //   413: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   416: return
    //   417: astore_1
    //   418: aload_0
    //   419: aload 6
    //   421: invokevirtual 124	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   424: putfield 80	kotlin/l/b/a/b/e/a$u:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   427: goto -20 -> 407
    //   430: astore_1
    //   431: aload_0
    //   432: aload 6
    //   434: invokevirtual 124	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   437: putfield 80	kotlin/l/b/a/b/e/a$u:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   440: ldc 86
    //   442: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   445: aload_1
    //   446: athrow
    //   447: astore_2
    //   448: aload_0
    //   449: aload 6
    //   451: invokevirtual 124	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   454: putfield 80	kotlin/l/b/a/b/e/a$u:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   457: goto -274 -> 183
    //   460: astore_1
    //   461: aload_0
    //   462: aload 6
    //   464: invokevirtual 124	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   467: putfield 80	kotlin/l/b/a/b/e/a$u:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   470: ldc 86
    //   472: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   475: aload_1
    //   476: athrow
    //   477: goto -361 -> 116
    //   480: iconst_1
    //   481: istore_3
    //   482: goto -444 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	485	0	this	u
    //   0	485	1	parame	kotlin.l.b.a.b.h.e
    //   0	485	2	paramg	kotlin.l.b.a.b.h.g
    //   37	445	3	i	int
    //   46	313	4	j	int
    //   244	122	5	k	int
    //   26	437	6	localb	kotlin.l.b.a.b.h.d.b
    //   34	360	7	localf	f
    //   251	135	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   42	48	155	kotlin/l/b/a/b/h/l
    //   116	129	155	kotlin/l/b/a/b/h/l
    //   134	152	155	kotlin/l/b/a/b/h/l
    //   194	212	155	kotlin/l/b/a/b/h/l
    //   240	253	155	kotlin/l/b/a/b/h/l
    //   258	272	155	kotlin/l/b/a/b/h/l
    //   275	291	155	kotlin/l/b/a/b/h/l
    //   294	313	155	kotlin/l/b/a/b/h/l
    //   316	335	155	kotlin/l/b/a/b/h/l
    //   338	351	155	kotlin/l/b/a/b/h/l
    //   356	370	155	kotlin/l/b/a/b/h/l
    //   373	390	155	kotlin/l/b/a/b/h/l
    //   42	48	168	finally
    //   116	129	168	finally
    //   134	152	168	finally
    //   156	168	168	finally
    //   194	212	168	finally
    //   216	240	168	finally
    //   240	253	168	finally
    //   258	272	168	finally
    //   275	291	168	finally
    //   294	313	168	finally
    //   316	335	168	finally
    //   338	351	168	finally
    //   356	370	168	finally
    //   373	390	168	finally
    //   42	48	215	java/io/IOException
    //   116	129	215	java/io/IOException
    //   134	152	215	java/io/IOException
    //   194	212	215	java/io/IOException
    //   240	253	215	java/io/IOException
    //   258	272	215	java/io/IOException
    //   275	291	215	java/io/IOException
    //   294	313	215	java/io/IOException
    //   316	335	215	java/io/IOException
    //   338	351	215	java/io/IOException
    //   356	370	215	java/io/IOException
    //   373	390	215	java/io/IOException
    //   393	398	417	java/io/IOException
    //   393	398	430	finally
    //   169	174	447	java/io/IOException
    //   169	174	460	finally
  }
  
  private a$u(i.a parama)
  {
    super((byte)0);
    this.aiXZ = parama.aiXZ;
  }
  
  private void ktf()
  {
    this.ajbu = 0;
    this.ajbv = 0;
    this.ajbw = b.ajbB;
    this.ajbx = 0;
    this.ajby = 0;
    this.ajbz = c.ajbE;
  }
  
  public static u kwI()
  {
    return ajbt;
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(59013);
    getSerializedSize();
    if ((this.bitField0_ & 0x1) == 1) {
      paramf.cF(1, this.ajbu);
    }
    if ((this.bitField0_ & 0x2) == 2) {
      paramf.cF(2, this.ajbv);
    }
    if ((this.bitField0_ & 0x4) == 4) {
      paramf.cP(3, this.ajbw.value);
    }
    if ((this.bitField0_ & 0x8) == 8) {
      paramf.cF(4, this.ajbx);
    }
    if ((this.bitField0_ & 0x10) == 16) {
      paramf.cF(5, this.ajby);
    }
    if ((this.bitField0_ & 0x20) == 32) {
      paramf.cP(6, this.ajbz.value);
    }
    paramf.e(this.aiXZ);
    AppMethodBeat.o(59013);
  }
  
  public final int getSerializedSize()
  {
    AppMethodBeat.i(59014);
    int i = this.dRJ;
    if (i != -1)
    {
      AppMethodBeat.o(59014);
      return i;
    }
    int j = 0;
    if ((this.bitField0_ & 0x1) == 1) {
      j = f.cJ(1, this.ajbu) + 0;
    }
    i = j;
    if ((this.bitField0_ & 0x2) == 2) {
      i = j + f.cJ(2, this.ajbv);
    }
    j = i;
    if ((this.bitField0_ & 0x4) == 4) {
      j = i + f.cM(3, this.ajbw.value);
    }
    i = j;
    if ((this.bitField0_ & 0x8) == 8) {
      i = j + f.cJ(4, this.ajbx);
    }
    j = i;
    if ((this.bitField0_ & 0x10) == 16) {
      j = i + f.cJ(5, this.ajby);
    }
    i = j;
    if ((this.bitField0_ & 0x20) == 32) {
      i = j + f.cM(6, this.ajbz.value);
    }
    i += this.aiXZ.size();
    this.dRJ = i;
    AppMethodBeat.o(59014);
    return i;
  }
  
  public final boolean hasErrorCode()
  {
    return (this.bitField0_ & 0x8) == 8;
  }
  
  public final boolean isInitialized()
  {
    int i = this.memoizedIsInitialized;
    if (i == 1) {
      return true;
    }
    if (i == 0) {
      return false;
    }
    this.memoizedIsInitialized = 1;
    return true;
  }
  
  public final boolean kwJ()
  {
    return (this.bitField0_ & 0x1) == 1;
  }
  
  public final boolean kwK()
  {
    return (this.bitField0_ & 0x2) == 2;
  }
  
  public final boolean kwL()
  {
    return (this.bitField0_ & 0x4) == 4;
  }
  
  public final boolean kwM()
  {
    return (this.bitField0_ & 0x10) == 16;
  }
  
  public final boolean kwN()
  {
    return (this.bitField0_ & 0x20) == 32;
  }
  
  public static final class a
    extends i.a<a.u, a>
    implements x
  {
    private int ajbu;
    private int ajbv;
    private a.u.b ajbw = a.u.b.ajbB;
    private int ajbx;
    private int ajby;
    private a.u.c ajbz = a.u.c.ajbE;
    private int bitField0_;
    
    private a a(a.u.b paramb)
    {
      AppMethodBeat.i(58992);
      if (paramb == null)
      {
        paramb = new NullPointerException();
        AppMethodBeat.o(58992);
        throw paramb;
      }
      this.bitField0_ |= 0x4;
      this.ajbw = paramb;
      AppMethodBeat.o(58992);
      return this;
    }
    
    private a a(a.u.c paramc)
    {
      AppMethodBeat.i(58993);
      if (paramc == null)
      {
        paramc = new NullPointerException();
        AppMethodBeat.o(58993);
        throw paramc;
      }
      this.bitField0_ |= 0x20;
      this.ajbz = paramc;
      AppMethodBeat.o(58993);
      return this;
    }
    
    private a aLO(int paramInt)
    {
      this.bitField0_ |= 0x1;
      this.ajbu = paramInt;
      return this;
    }
    
    private a aLP(int paramInt)
    {
      this.bitField0_ |= 0x2;
      this.ajbv = paramInt;
      return this;
    }
    
    private a aLQ(int paramInt)
    {
      this.bitField0_ |= 0x8;
      this.ajbx = paramInt;
      return this;
    }
    
    private a aLR(int paramInt)
    {
      this.bitField0_ |= 0x10;
      this.ajby = paramInt;
      return this;
    }
    
    private a kwO()
    {
      AppMethodBeat.i(58988);
      a locala = new a().b(kwP());
      AppMethodBeat.o(58988);
      return locala;
    }
    
    private a.u kwP()
    {
      int j = 1;
      AppMethodBeat.i(58989);
      a.u localu = new a.u(this, (byte)0);
      int k = this.bitField0_;
      if ((k & 0x1) == 1) {}
      for (;;)
      {
        a.u.a(localu, this.ajbu);
        int i = j;
        if ((k & 0x2) == 2) {
          i = j | 0x2;
        }
        a.u.b(localu, this.ajbv);
        j = i;
        if ((k & 0x4) == 4) {
          j = i | 0x4;
        }
        a.u.a(localu, this.ajbw);
        i = j;
        if ((k & 0x8) == 8) {
          i = j | 0x8;
        }
        a.u.c(localu, this.ajbx);
        j = i;
        if ((k & 0x10) == 16) {
          j = i | 0x10;
        }
        a.u.d(localu, this.ajby);
        i = j;
        if ((k & 0x20) == 32) {
          i = j | 0x20;
        }
        a.u.a(localu, this.ajbz);
        a.u.e(localu, i);
        AppMethodBeat.o(58989);
        return localu;
        j = 0;
      }
    }
    
    /* Error */
    private a z(kotlin.l.b.a.b.h.e parame, kotlin.l.b.a.b.h.g paramg)
    {
      // Byte code:
      //   0: ldc 116
      //   2: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: getstatic 120	kotlin/l/b/a/b/e/a$u:aiYa	Lkotlin/l/b/a/b/h/t;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 125 3 0
      //   17: checkcast 9	kotlin/l/b/a/b/e/a$u
      //   20: astore_1
      //   21: aload_1
      //   22: ifnull +9 -> 31
      //   25: aload_0
      //   26: aload_1
      //   27: invokevirtual 85	kotlin/l/b/a/b/e/a$u$a:b	(Lkotlin/l/b/a/b/e/a$u;)Lkotlin/l/b/a/b/e/a$u$a;
      //   30: pop
      //   31: ldc 116
      //   33: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   36: aload_0
      //   37: areturn
      //   38: astore_1
      //   39: aload_1
      //   40: getfield 129	kotlin/l/b/a/b/h/l:ajfp	Lkotlin/l/b/a/b/h/r;
      //   43: checkcast 9	kotlin/l/b/a/b/e/a$u
      //   46: astore_2
      //   47: ldc 116
      //   49: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   52: aload_1
      //   53: athrow
      //   54: astore_1
      //   55: aload_2
      //   56: ifnull +9 -> 65
      //   59: aload_0
      //   60: aload_2
      //   61: invokevirtual 85	kotlin/l/b/a/b/e/a$u$a:b	(Lkotlin/l/b/a/b/e/a$u;)Lkotlin/l/b/a/b/e/a$u$a;
      //   64: pop
      //   65: ldc 116
      //   67: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    
    public final a b(a.u paramu)
    {
      AppMethodBeat.i(58990);
      if (paramu == a.u.kwI())
      {
        AppMethodBeat.o(58990);
        return this;
      }
      if (paramu.kwJ()) {
        aLO(paramu.ajbu);
      }
      if (paramu.kwK()) {
        aLP(paramu.ajbv);
      }
      if (paramu.kwL()) {
        a(paramu.ajbw);
      }
      if (paramu.hasErrorCode()) {
        aLQ(paramu.ajbx);
      }
      if (paramu.kwM()) {
        aLR(paramu.ajby);
      }
      if (paramu.kwN()) {
        a(paramu.ajbz);
      }
      this.aiXZ = this.aiXZ.a(a.u.a(paramu));
      AppMethodBeat.o(58990);
      return this;
    }
    
    public final boolean isInitialized()
    {
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
      AppMethodBeat.i(59007);
      ajbA = new b("WARNING", 0, 0);
      ajbB = new b("ERROR", 1, 1);
      ajbC = new b("HIDDEN", 2, 2);
      ajbD = new b[] { ajbA, ajbB, ajbC };
      aiYE = new k.b() {};
      AppMethodBeat.o(59007);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static b aLS(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 0: 
        return ajbA;
      case 1: 
        return ajbB;
      }
      return ajbC;
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
      AppMethodBeat.i(59011);
      ajbE = new c("LANGUAGE_VERSION", 0, 0);
      ajbF = new c("COMPILER_VERSION", 1, 1);
      ajbG = new c("API_VERSION", 2, 2);
      ajbH = new c[] { ajbE, ajbF, ajbG };
      aiYE = new k.b() {};
      AppMethodBeat.o(59011);
    }
    
    private c(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static c aLT(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 0: 
        return ajbE;
      case 1: 
        return ajbF;
      }
      return ajbG;
    }
    
    public final int getNumber()
    {
      return this.value;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.e.a.u
 * JD-Core Version:    0.7.0.1
 */