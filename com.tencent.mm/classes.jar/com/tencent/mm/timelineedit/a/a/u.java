package com.tencent.mm.timelineedit.a.a;

import com.google.d.am.a;
import com.google.d.am.f;
import com.google.d.am.j;
import com.google.d.bg;
import com.google.d.bg.a;
import com.google.d.bg.b;
import com.google.d.bg.e;
import com.google.d.bg.f;
import com.google.d.bj;
import com.google.d.c;
import com.google.d.cb;
import com.google.d.cs;
import com.google.d.dn;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class u
  extends bg
  implements v
{
  private static final cs<u> PARSER;
  private static final u adrn;
  boolean adpX;
  float adrd;
  boolean adre;
  boolean adrf;
  int adrg;
  int adrh;
  float adri;
  float adrj;
  int adrk;
  int adrl;
  long adrm;
  private byte memoizedIsInitialized = -1;
  
  static
  {
    AppMethodBeat.i(232288);
    adrn = new u();
    PARSER = new c() {};
    AppMethodBeat.o(232288);
  }
  
  private u()
  {
    this.adrg = 0;
    this.adrh = 0;
  }
  
  private u(bg.a<?> parama)
  {
    super(parama);
  }
  
  /* Error */
  private u(com.google.d.i parami, com.google.d.at paramat)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 45	com/tencent/mm/timelineedit/a/a/u:<init>	()V
    //   4: ldc 74
    //   6: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_2
    //   10: ifnonnull +18 -> 28
    //   13: new 76	java/lang/NullPointerException
    //   16: dup
    //   17: invokespecial 77	java/lang/NullPointerException:<init>	()V
    //   20: astore_1
    //   21: ldc 74
    //   23: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: aload_1
    //   27: athrow
    //   28: invokestatic 83	com/google/d/dn:ajE	()Lcom/google/d/dn$a;
    //   31: astore 5
    //   33: iconst_0
    //   34: istore_3
    //   35: iload_3
    //   36: ifne +311 -> 347
    //   39: aload_1
    //   40: invokevirtual 89	com/google/d/i:aac	()I
    //   43: istore 4
    //   45: iload 4
    //   47: lookupswitch	default:+319->366, 0:+322->369, 13:+123->170, 16:+168->215, 24:+201->248, 32:+212->259, 40:+223->270, 53:+234->281, 61:+245->292, 64:+256->303, 72:+267->314, 80:+278->325, 88:+289->336
    //   153: aload_1
    //   154: aload 5
    //   156: aload_2
    //   157: iload 4
    //   159: invokevirtual 93	com/tencent/mm/timelineedit/a/a/u:parseUnknownField	(Lcom/google/d/i;Lcom/google/d/dn$a;Lcom/google/d/at;I)Z
    //   162: ifne -127 -> 35
    //   165: iconst_1
    //   166: istore_3
    //   167: goto -132 -> 35
    //   170: aload_0
    //   171: aload_1
    //   172: invokevirtual 97	com/google/d/i:readFloat	()F
    //   175: putfield 99	com/tencent/mm/timelineedit/a/a/u:adrd	F
    //   178: goto -143 -> 35
    //   181: astore_1
    //   182: aload_1
    //   183: aload_0
    //   184: putfield 103	com/google/d/bk:dST	Lcom/google/d/ce;
    //   187: ldc 74
    //   189: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   192: aload_1
    //   193: athrow
    //   194: astore_1
    //   195: aload_0
    //   196: aload 5
    //   198: invokevirtual 109	com/google/d/dn$a:ajH	()Lcom/google/d/dn;
    //   201: putfield 113	com/tencent/mm/timelineedit/a/a/u:unknownFields	Lcom/google/d/dn;
    //   204: aload_0
    //   205: invokevirtual 116	com/tencent/mm/timelineedit/a/a/u:makeExtensionsImmutable	()V
    //   208: ldc 74
    //   210: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   213: aload_1
    //   214: athrow
    //   215: aload_0
    //   216: aload_1
    //   217: invokevirtual 120	com/google/d/i:aai	()Z
    //   220: putfield 122	com/tencent/mm/timelineedit/a/a/u:adre	Z
    //   223: goto -188 -> 35
    //   226: astore_1
    //   227: new 71	com/google/d/bk
    //   230: dup
    //   231: aload_1
    //   232: invokespecial 125	com/google/d/bk:<init>	(Ljava/io/IOException;)V
    //   235: astore_1
    //   236: aload_1
    //   237: aload_0
    //   238: putfield 103	com/google/d/bk:dST	Lcom/google/d/ce;
    //   241: ldc 74
    //   243: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   246: aload_1
    //   247: athrow
    //   248: aload_0
    //   249: aload_1
    //   250: invokevirtual 120	com/google/d/i:aai	()Z
    //   253: putfield 127	com/tencent/mm/timelineedit/a/a/u:adrf	Z
    //   256: goto -221 -> 35
    //   259: aload_0
    //   260: aload_1
    //   261: invokevirtual 130	com/google/d/i:aam	()I
    //   264: putfield 59	com/tencent/mm/timelineedit/a/a/u:adrg	I
    //   267: goto -232 -> 35
    //   270: aload_0
    //   271: aload_1
    //   272: invokevirtual 130	com/google/d/i:aam	()I
    //   275: putfield 61	com/tencent/mm/timelineedit/a/a/u:adrh	I
    //   278: goto -243 -> 35
    //   281: aload_0
    //   282: aload_1
    //   283: invokevirtual 97	com/google/d/i:readFloat	()F
    //   286: putfield 132	com/tencent/mm/timelineedit/a/a/u:adri	F
    //   289: goto -254 -> 35
    //   292: aload_0
    //   293: aload_1
    //   294: invokevirtual 97	com/google/d/i:readFloat	()F
    //   297: putfield 134	com/tencent/mm/timelineedit/a/a/u:adrj	F
    //   300: goto -265 -> 35
    //   303: aload_0
    //   304: aload_1
    //   305: invokevirtual 137	com/google/d/i:aaf	()I
    //   308: putfield 139	com/tencent/mm/timelineedit/a/a/u:adrk	I
    //   311: goto -276 -> 35
    //   314: aload_0
    //   315: aload_1
    //   316: invokevirtual 137	com/google/d/i:aaf	()I
    //   319: putfield 141	com/tencent/mm/timelineedit/a/a/u:adrl	I
    //   322: goto -287 -> 35
    //   325: aload_0
    //   326: aload_1
    //   327: invokevirtual 120	com/google/d/i:aai	()Z
    //   330: putfield 143	com/tencent/mm/timelineedit/a/a/u:adpX	Z
    //   333: goto -298 -> 35
    //   336: aload_0
    //   337: aload_1
    //   338: invokevirtual 147	com/google/d/i:aae	()J
    //   341: putfield 149	com/tencent/mm/timelineedit/a/a/u:adrm	J
    //   344: goto -309 -> 35
    //   347: aload_0
    //   348: aload 5
    //   350: invokevirtual 109	com/google/d/dn$a:ajH	()Lcom/google/d/dn;
    //   353: putfield 113	com/tencent/mm/timelineedit/a/a/u:unknownFields	Lcom/google/d/dn;
    //   356: aload_0
    //   357: invokevirtual 116	com/tencent/mm/timelineedit/a/a/u:makeExtensionsImmutable	()V
    //   360: ldc 74
    //   362: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   365: return
    //   366: goto -214 -> 152
    //   369: iconst_1
    //   370: istore_3
    //   371: goto -336 -> 35
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	374	0	this	u
    //   0	374	1	parami	com.google.d.i
    //   0	374	2	paramat	com.google.d.at
    //   34	337	3	i	int
    //   43	115	4	j	int
    //   31	318	5	locala	com.google.d.dn.a
    // Exception table:
    //   from	to	target	type
    //   39	45	181	com/google/d/bk
    //   152	165	181	com/google/d/bk
    //   170	178	181	com/google/d/bk
    //   215	223	181	com/google/d/bk
    //   248	256	181	com/google/d/bk
    //   259	267	181	com/google/d/bk
    //   270	278	181	com/google/d/bk
    //   281	289	181	com/google/d/bk
    //   292	300	181	com/google/d/bk
    //   303	311	181	com/google/d/bk
    //   314	322	181	com/google/d/bk
    //   325	333	181	com/google/d/bk
    //   336	344	181	com/google/d/bk
    //   39	45	194	finally
    //   152	165	194	finally
    //   170	178	194	finally
    //   182	194	194	finally
    //   215	223	194	finally
    //   227	248	194	finally
    //   248	256	194	finally
    //   259	267	194	finally
    //   270	278	194	finally
    //   281	289	194	finally
    //   292	300	194	finally
    //   303	311	194	finally
    //   314	322	194	finally
    //   325	333	194	finally
    //   336	344	194	finally
    //   39	45	226	java/io/IOException
    //   152	165	226	java/io/IOException
    //   170	178	226	java/io/IOException
    //   215	223	226	java/io/IOException
    //   248	256	226	java/io/IOException
    //   259	267	226	java/io/IOException
    //   270	278	226	java/io/IOException
    //   281	289	226	java/io/IOException
    //   292	300	226	java/io/IOException
    //   303	311	226	java/io/IOException
    //   314	322	226	java/io/IOException
    //   325	333	226	java/io/IOException
    //   336	344	226	java/io/IOException
  }
  
  public static a jge()
  {
    AppMethodBeat.i(232154);
    a locala = adrn.jgf();
    AppMethodBeat.o(232154);
    return locala;
  }
  
  private a jgf()
  {
    AppMethodBeat.i(232162);
    if (this == adrn)
    {
      locala = new a((byte)0);
      AppMethodBeat.o(232162);
      return locala;
    }
    a locala = new a((byte)0).d(this);
    AppMethodBeat.o(232162);
    return locala;
  }
  
  public static u jgg()
  {
    return adrn;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(232381);
    if (paramObject == this)
    {
      AppMethodBeat.o(232381);
      return true;
    }
    if (!(paramObject instanceof u))
    {
      boolean bool = super.equals(paramObject);
      AppMethodBeat.o(232381);
      return bool;
    }
    paramObject = (u)paramObject;
    if (Float.floatToIntBits(this.adrd) != Float.floatToIntBits(paramObject.adrd))
    {
      AppMethodBeat.o(232381);
      return false;
    }
    if (this.adre != paramObject.adre)
    {
      AppMethodBeat.o(232381);
      return false;
    }
    if (this.adrf != paramObject.adrf)
    {
      AppMethodBeat.o(232381);
      return false;
    }
    if (this.adrg != paramObject.adrg)
    {
      AppMethodBeat.o(232381);
      return false;
    }
    if (this.adrh != paramObject.adrh)
    {
      AppMethodBeat.o(232381);
      return false;
    }
    if (Float.floatToIntBits(this.adri) != Float.floatToIntBits(paramObject.adri))
    {
      AppMethodBeat.o(232381);
      return false;
    }
    if (Float.floatToIntBits(this.adrj) != Float.floatToIntBits(paramObject.adrj))
    {
      AppMethodBeat.o(232381);
      return false;
    }
    if (this.adrk != paramObject.adrk)
    {
      AppMethodBeat.o(232381);
      return false;
    }
    if (this.adrl != paramObject.adrl)
    {
      AppMethodBeat.o(232381);
      return false;
    }
    if (this.adpX != paramObject.adpX)
    {
      AppMethodBeat.o(232381);
      return false;
    }
    if (this.adrm != paramObject.adrm)
    {
      AppMethodBeat.o(232381);
      return false;
    }
    if (!this.unknownFields.equals(paramObject.unknownFields))
    {
      AppMethodBeat.o(232381);
      return false;
    }
    AppMethodBeat.o(232381);
    return true;
  }
  
  public final cs<u> getParserForType()
  {
    return PARSER;
  }
  
  public final int getSerializedSize()
  {
    AppMethodBeat.i(232366);
    int i = this.memoizedSize;
    if (i != -1)
    {
      AppMethodBeat.o(232366);
      return i;
    }
    int j = 0;
    if (this.adrd != 0.0F) {
      j = com.google.d.k.kl(1) + 0;
    }
    i = j;
    if (this.adre) {
      i = j + com.google.d.k.kn(2);
    }
    j = i;
    if (this.adrf) {
      j = i + com.google.d.k.kn(3);
    }
    i = j;
    if (this.adrg != k.adqs.getNumber()) {
      i = j + com.google.d.k.cM(4, this.adrg);
    }
    j = i;
    if (this.adrh != k.adqs.getNumber()) {
      j = i + com.google.d.k.cM(5, this.adrh);
    }
    i = j;
    if (this.adri != 0.0F) {
      i = j + com.google.d.k.kl(6);
    }
    j = i;
    if (this.adrj != 0.0F) {
      j = i + com.google.d.k.kl(7);
    }
    i = j;
    if (this.adrk != 0) {
      i = j + com.google.d.k.cJ(8, this.adrk);
    }
    j = i;
    if (this.adrl != 0) {
      j = i + com.google.d.k.cJ(9, this.adrl);
    }
    i = j;
    if (this.adpX) {
      i = j + com.google.d.k.kn(10);
    }
    j = i;
    if (this.adrm != 0L) {
      j = i + com.google.d.k.q(11, this.adrm);
    }
    i = j + this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    AppMethodBeat.o(232366);
    return i;
  }
  
  public final dn getUnknownFields()
  {
    return this.unknownFields;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(232393);
    if (this.memoizedHashCode != 0)
    {
      i = this.memoizedHashCode;
      AppMethodBeat.o(232393);
      return i;
    }
    int i = (((((((((((((((((((((((ae.adsz.hashCode() + 779) * 37 + 1) * 53 + Float.floatToIntBits(this.adrd)) * 37 + 2) * 53 + bj.hashBoolean(this.adre)) * 37 + 3) * 53 + bj.hashBoolean(this.adrf)) * 37 + 4) * 53 + this.adrg) * 37 + 5) * 53 + this.adrh) * 37 + 6) * 53 + Float.floatToIntBits(this.adri)) * 37 + 7) * 53 + Float.floatToIntBits(this.adrj)) * 37 + 8) * 53 + this.adrk) * 37 + 9) * 53 + this.adrl) * 37 + 10) * 53 + bj.hashBoolean(this.adpX)) * 37 + 11) * 53 + bj.hashLong(this.adrm)) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    AppMethodBeat.o(232393);
    return i;
  }
  
  public final bg.e internalGetFieldAccessorTable()
  {
    AppMethodBeat.i(232317);
    bg.e locale = ae.adsA.b(u.class, a.class);
    AppMethodBeat.o(232317);
    return locale;
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
  
  public final Object newInstance(bg.f paramf)
  {
    AppMethodBeat.i(232299);
    paramf = new u();
    AppMethodBeat.o(232299);
    return paramf;
  }
  
  public final void writeTo(com.google.d.k paramk)
  {
    AppMethodBeat.i(232342);
    if (this.adrd != 0.0F) {
      paramk.l(1, this.adrd);
    }
    if (this.adre) {
      paramk.I(2, this.adre);
    }
    if (this.adrf) {
      paramk.I(3, this.adrf);
    }
    if (this.adrg != k.adqs.getNumber()) {
      paramk.cF(4, this.adrg);
    }
    if (this.adrh != k.adqs.getNumber()) {
      paramk.cF(5, this.adrh);
    }
    if (this.adri != 0.0F) {
      paramk.l(6, this.adri);
    }
    if (this.adrj != 0.0F) {
      paramk.l(7, this.adrj);
    }
    if (this.adrk != 0) {
      paramk.cF(8, this.adrk);
    }
    if (this.adrl != 0) {
      paramk.cF(9, this.adrl);
    }
    if (this.adpX) {
      paramk.I(10, this.adpX);
    }
    if (this.adrm != 0L) {
      paramk.n(11, this.adrm);
    }
    this.unknownFields.writeTo(paramk);
    AppMethodBeat.o(232342);
  }
  
  public static final class a
    extends bg.a<a>
    implements v
  {
    private boolean adpX;
    private float adrd;
    private boolean adre;
    private boolean adrf;
    private int adrg;
    private int adrh;
    private float adri;
    private float adrj;
    private int adrk;
    private int adrl;
    private long adrm;
    
    private a()
    {
      AppMethodBeat.i(232209);
      this.adrg = 0;
      this.adrh = 0;
      u.ayB();
      AppMethodBeat.o(232209);
    }
    
    private a(bg.b paramb)
    {
      super();
      AppMethodBeat.i(232216);
      this.adrg = 0;
      this.adrh = 0;
      u.ayB();
      AppMethodBeat.o(232216);
    }
    
    private a R(am.f paramf, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(232281);
      paramf = (a)super.setRepeatedField(paramf, paramInt, paramObject);
      AppMethodBeat.o(232281);
      return paramf;
    }
    
    /* Error */
    private a R(com.google.d.i parami, com.google.d.at paramat)
    {
      // Byte code:
      //   0: ldc 67
      //   2: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: invokestatic 71	com/tencent/mm/timelineedit/a/a/u:jgh	()Lcom/google/d/cs;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 77 3 0
      //   17: checkcast 9	com/tencent/mm/timelineedit/a/a/u
      //   20: astore_1
      //   21: aload_1
      //   22: ifnull +9 -> 31
      //   25: aload_0
      //   26: aload_1
      //   27: invokevirtual 81	com/tencent/mm/timelineedit/a/a/u$a:d	(Lcom/tencent/mm/timelineedit/a/a/u;)Lcom/tencent/mm/timelineedit/a/a/u$a;
      //   30: pop
      //   31: ldc 67
      //   33: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   36: aload_0
      //   37: areturn
      //   38: astore_1
      //   39: aload_1
      //   40: getfield 85	com/google/d/bk:dST	Lcom/google/d/ce;
      //   43: checkcast 9	com/tencent/mm/timelineedit/a/a/u
      //   46: astore_2
      //   47: aload_1
      //   48: invokevirtual 89	com/google/d/bk:aii	()Ljava/io/IOException;
      //   51: astore_1
      //   52: ldc 67
      //   54: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   57: aload_1
      //   58: athrow
      //   59: astore_1
      //   60: aload_2
      //   61: ifnull +9 -> 70
      //   64: aload_0
      //   65: aload_2
      //   66: invokevirtual 81	com/tencent/mm/timelineedit/a/a/u$a:d	(Lcom/tencent/mm/timelineedit/a/a/u;)Lcom/tencent/mm/timelineedit/a/a/u$a;
      //   69: pop
      //   70: ldc 67
      //   72: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   75: aload_1
      //   76: athrow
      //   77: astore_1
      //   78: aload_3
      //   79: astore_2
      //   80: goto -20 -> 60
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	83	0	this	a
      //   0	83	1	parami	com.google.d.i
      //   0	83	2	paramat	com.google.d.at
      //   6	73	3	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   7	21	38	com/google/d/bk
      //   47	59	59	finally
      //   7	21	77	finally
      //   39	47	77	finally
    }
    
    private a S(cb paramcb)
    {
      AppMethodBeat.i(232300);
      if ((paramcb instanceof u))
      {
        paramcb = d((u)paramcb);
        AppMethodBeat.o(232300);
        return paramcb;
      }
      super.mergeFrom(paramcb);
      AppMethodBeat.o(232300);
      return this;
    }
    
    private a V(am.j paramj)
    {
      AppMethodBeat.i(232271);
      paramj = (a)super.clearOneof(paramj);
      AppMethodBeat.o(232271);
      return paramj;
    }
    
    private a Z(am.f paramf)
    {
      AppMethodBeat.i(232261);
      paramf = (a)super.clearField(paramf);
      AppMethodBeat.o(232261);
      return paramf;
    }
    
    private a aK(am.f paramf, Object paramObject)
    {
      AppMethodBeat.i(232251);
      paramf = (a)super.setField(paramf, paramObject);
      AppMethodBeat.o(232251);
      return paramf;
    }
    
    private a aL(am.f paramf, Object paramObject)
    {
      AppMethodBeat.i(232291);
      paramf = (a)super.addRepeatedField(paramf, paramObject);
      AppMethodBeat.o(232291);
      return paramf;
    }
    
    private a aM(dn paramdn)
    {
      AppMethodBeat.i(232345);
      paramdn = (a)super.setUnknownFields(paramdn);
      AppMethodBeat.o(232345);
      return paramdn;
    }
    
    private a aN(dn paramdn)
    {
      AppMethodBeat.i(232355);
      paramdn = (a)super.mergeUnknownFields(paramdn);
      AppMethodBeat.o(232355);
      return paramdn;
    }
    
    private a azG(int paramInt)
    {
      AppMethodBeat.i(232324);
      this.adrg = paramInt;
      onChanged();
      AppMethodBeat.o(232324);
      return this;
    }
    
    private a azH(int paramInt)
    {
      AppMethodBeat.i(232335);
      this.adrh = paramInt;
      onChanged();
      AppMethodBeat.o(232335);
      return this;
    }
    
    private a jgi()
    {
      AppMethodBeat.i(232225);
      super.clear();
      this.adrd = 0.0F;
      this.adre = false;
      this.adrf = false;
      this.adrg = 0;
      this.adrh = 0;
      this.adri = 0.0F;
      this.adrj = 0.0F;
      this.adrk = 0;
      this.adrl = 0;
      this.adpX = false;
      this.adrm = 0L;
      AppMethodBeat.o(232225);
      return this;
    }
    
    private u jgj()
    {
      AppMethodBeat.i(232234);
      Object localObject = jgk();
      if (!((u)localObject).isInitialized())
      {
        localObject = newUninitializedMessageException((cb)localObject);
        AppMethodBeat.o(232234);
        throw ((Throwable)localObject);
      }
      AppMethodBeat.o(232234);
      return localObject;
    }
    
    private u jgk()
    {
      AppMethodBeat.i(232244);
      u localu = new u(this, (byte)0);
      u.a(localu, this.adrd);
      u.a(localu, this.adre);
      u.b(localu, this.adrf);
      u.a(localu, this.adrg);
      u.b(localu, this.adrh);
      u.b(localu, this.adri);
      u.c(localu, this.adrj);
      u.c(localu, this.adrk);
      u.d(localu, this.adrl);
      u.c(localu, this.adpX);
      u.a(localu, this.adrm);
      onBuilt();
      AppMethodBeat.o(232244);
      return localu;
    }
    
    public final a KL(boolean paramBoolean)
    {
      AppMethodBeat.i(232724);
      this.adre = paramBoolean;
      onChanged();
      AppMethodBeat.o(232724);
      return this;
    }
    
    public final a KM(boolean paramBoolean)
    {
      AppMethodBeat.i(232745);
      this.adrf = paramBoolean;
      onChanged();
      AppMethodBeat.o(232745);
      return this;
    }
    
    public final a KN(boolean paramBoolean)
    {
      AppMethodBeat.i(232823);
      this.adpX = paramBoolean;
      onChanged();
      AppMethodBeat.o(232823);
      return this;
    }
    
    public final a a(k paramk)
    {
      AppMethodBeat.i(232757);
      if (paramk == null)
      {
        paramk = new NullPointerException();
        AppMethodBeat.o(232757);
        throw paramk;
      }
      this.adrg = paramk.getNumber();
      onChanged();
      AppMethodBeat.o(232757);
      return this;
    }
    
    public final a azI(int paramInt)
    {
      AppMethodBeat.i(232799);
      this.adrk = paramInt;
      onChanged();
      AppMethodBeat.o(232799);
      return this;
    }
    
    public final a azJ(int paramInt)
    {
      AppMethodBeat.i(232811);
      this.adrl = paramInt;
      onChanged();
      AppMethodBeat.o(232811);
      return this;
    }
    
    public final a b(k paramk)
    {
      AppMethodBeat.i(232767);
      if (paramk == null)
      {
        paramk = new NullPointerException();
        AppMethodBeat.o(232767);
        throw paramk;
      }
      this.adrh = paramk.getNumber();
      onChanged();
      AppMethodBeat.o(232767);
      return this;
    }
    
    public final a d(u paramu)
    {
      AppMethodBeat.i(232697);
      if (paramu == u.jgg())
      {
        AppMethodBeat.o(232697);
        return this;
      }
      if (paramu.adrd != 0.0F) {
        dJ(paramu.adrd);
      }
      if (paramu.adre) {
        KL(paramu.adre);
      }
      if (paramu.adrf) {
        KM(paramu.adrf);
      }
      if (u.a(paramu) != 0) {
        azG(paramu.adrg);
      }
      if (u.b(paramu) != 0) {
        azH(paramu.adrh);
      }
      if (paramu.adri != 0.0F) {
        dK(paramu.adri);
      }
      if (paramu.adrj != 0.0F) {
        dL(paramu.adrj);
      }
      if (paramu.adrk != 0) {
        azI(paramu.adrk);
      }
      if (paramu.adrl != 0) {
        azJ(paramu.adrl);
      }
      if (paramu.adpX) {
        KN(paramu.adpX);
      }
      if (paramu.adrm != 0L) {
        zs(paramu.adrm);
      }
      aN(u.c(paramu));
      onChanged();
      AppMethodBeat.o(232697);
      return this;
    }
    
    public final a dJ(float paramFloat)
    {
      AppMethodBeat.i(232715);
      this.adrd = paramFloat;
      onChanged();
      AppMethodBeat.o(232715);
      return this;
    }
    
    public final a dK(float paramFloat)
    {
      AppMethodBeat.i(232778);
      this.adri = paramFloat;
      onChanged();
      AppMethodBeat.o(232778);
      return this;
    }
    
    public final a dL(float paramFloat)
    {
      AppMethodBeat.i(232790);
      this.adrj = paramFloat;
      onChanged();
      AppMethodBeat.o(232790);
      return this;
    }
    
    public final am.a getDescriptorForType()
    {
      return ae.adsz;
    }
    
    public final bg.e internalGetFieldAccessorTable()
    {
      AppMethodBeat.i(232687);
      bg.e locale = ae.adsA.b(u.class, a.class);
      AppMethodBeat.o(232687);
      return locale;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public final a zs(long paramLong)
    {
      AppMethodBeat.i(232832);
      this.adrm = paramLong;
      onChanged();
      AppMethodBeat.o(232832);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.timelineedit.a.a.u
 * JD-Core Version:    0.7.0.1
 */