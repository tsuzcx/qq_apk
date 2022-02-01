package com.tencent.mm.timelineedit.a.a;

import com.google.b.aj.a;
import com.google.b.aj.f;
import com.google.b.bb;
import com.google.b.bb.a;
import com.google.b.bb.b;
import com.google.b.bb.e;
import com.google.b.be;
import com.google.b.bt;
import com.google.b.c;
import com.google.b.ci;
import com.google.b.da;
import com.google.b.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class u
  extends bb
  implements v
{
  private static final u VNi;
  private static final ci<u> bRf;
  boolean VLS;
  float VMY;
  boolean VMZ;
  boolean VNa;
  int VNb;
  int VNc;
  float VNd;
  float VNe;
  int VNf;
  int VNg;
  long VNh;
  private byte bRd = -1;
  
  static
  {
    AppMethodBeat.i(261129);
    VNi = new u();
    bRf = new c() {};
    AppMethodBeat.o(261129);
  }
  
  private u()
  {
    this.VNb = 0;
    this.VNc = 0;
  }
  
  private u(bb.a<?> parama)
  {
    super(parama);
  }
  
  /* Error */
  private u(com.google.b.h paramh, com.google.b.ap paramap)
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
    //   28: invokestatic 83	com/google/b/da:Jj	()Lcom/google/b/da$a;
    //   31: astore 5
    //   33: iconst_0
    //   34: istore_3
    //   35: iload_3
    //   36: ifne +311 -> 347
    //   39: aload_1
    //   40: invokevirtual 89	com/google/b/h:Av	()I
    //   43: istore 4
    //   45: iload 4
    //   47: lookupswitch	default:+319->366, 0:+322->369, 13:+123->170, 16:+168->215, 24:+201->248, 32:+212->259, 40:+223->270, 53:+234->281, 61:+245->292, 64:+256->303, 72:+267->314, 80:+278->325, 88:+289->336
    //   153: aload_1
    //   154: aload 5
    //   156: aload_2
    //   157: iload 4
    //   159: invokevirtual 92	com/tencent/mm/timelineedit/a/a/u:a	(Lcom/google/b/h;Lcom/google/b/da$a;Lcom/google/b/ap;I)Z
    //   162: ifne -127 -> 35
    //   165: iconst_1
    //   166: istore_3
    //   167: goto -132 -> 35
    //   170: aload_0
    //   171: aload_1
    //   172: invokevirtual 96	com/google/b/h:readFloat	()F
    //   175: putfield 98	com/tencent/mm/timelineedit/a/a/u:VMY	F
    //   178: goto -143 -> 35
    //   181: astore_1
    //   182: aload_1
    //   183: aload_0
    //   184: putfield 102	com/google/b/bf:bZj	Lcom/google/b/bw;
    //   187: ldc 74
    //   189: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   192: aload_1
    //   193: athrow
    //   194: astore_1
    //   195: aload_0
    //   196: aload 5
    //   198: invokevirtual 108	com/google/b/da$a:Jm	()Lcom/google/b/da;
    //   201: putfield 112	com/tencent/mm/timelineedit/a/a/u:bVW	Lcom/google/b/da;
    //   204: aload_0
    //   205: invokevirtual 115	com/tencent/mm/timelineedit/a/a/u:HZ	()V
    //   208: ldc 74
    //   210: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   213: aload_1
    //   214: athrow
    //   215: aload_0
    //   216: aload_1
    //   217: invokevirtual 119	com/google/b/h:AB	()Z
    //   220: putfield 121	com/tencent/mm/timelineedit/a/a/u:VMZ	Z
    //   223: goto -188 -> 35
    //   226: astore_1
    //   227: new 71	com/google/b/bf
    //   230: dup
    //   231: aload_1
    //   232: invokespecial 124	com/google/b/bf:<init>	(Ljava/io/IOException;)V
    //   235: astore_1
    //   236: aload_1
    //   237: aload_0
    //   238: putfield 102	com/google/b/bf:bZj	Lcom/google/b/bw;
    //   241: ldc 74
    //   243: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   246: aload_1
    //   247: athrow
    //   248: aload_0
    //   249: aload_1
    //   250: invokevirtual 119	com/google/b/h:AB	()Z
    //   253: putfield 126	com/tencent/mm/timelineedit/a/a/u:VNa	Z
    //   256: goto -221 -> 35
    //   259: aload_0
    //   260: aload_1
    //   261: invokevirtual 129	com/google/b/h:AF	()I
    //   264: putfield 59	com/tencent/mm/timelineedit/a/a/u:VNb	I
    //   267: goto -232 -> 35
    //   270: aload_0
    //   271: aload_1
    //   272: invokevirtual 129	com/google/b/h:AF	()I
    //   275: putfield 61	com/tencent/mm/timelineedit/a/a/u:VNc	I
    //   278: goto -243 -> 35
    //   281: aload_0
    //   282: aload_1
    //   283: invokevirtual 96	com/google/b/h:readFloat	()F
    //   286: putfield 131	com/tencent/mm/timelineedit/a/a/u:VNd	F
    //   289: goto -254 -> 35
    //   292: aload_0
    //   293: aload_1
    //   294: invokevirtual 96	com/google/b/h:readFloat	()F
    //   297: putfield 133	com/tencent/mm/timelineedit/a/a/u:VNe	F
    //   300: goto -265 -> 35
    //   303: aload_0
    //   304: aload_1
    //   305: invokevirtual 136	com/google/b/h:Ay	()I
    //   308: putfield 138	com/tencent/mm/timelineedit/a/a/u:VNf	I
    //   311: goto -276 -> 35
    //   314: aload_0
    //   315: aload_1
    //   316: invokevirtual 136	com/google/b/h:Ay	()I
    //   319: putfield 140	com/tencent/mm/timelineedit/a/a/u:VNg	I
    //   322: goto -287 -> 35
    //   325: aload_0
    //   326: aload_1
    //   327: invokevirtual 119	com/google/b/h:AB	()Z
    //   330: putfield 142	com/tencent/mm/timelineedit/a/a/u:VLS	Z
    //   333: goto -298 -> 35
    //   336: aload_0
    //   337: aload_1
    //   338: invokevirtual 146	com/google/b/h:Ax	()J
    //   341: putfield 148	com/tencent/mm/timelineedit/a/a/u:VNh	J
    //   344: goto -309 -> 35
    //   347: aload_0
    //   348: aload 5
    //   350: invokevirtual 108	com/google/b/da$a:Jm	()Lcom/google/b/da;
    //   353: putfield 112	com/tencent/mm/timelineedit/a/a/u:bVW	Lcom/google/b/da;
    //   356: aload_0
    //   357: invokevirtual 115	com/tencent/mm/timelineedit/a/a/u:HZ	()V
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
    //   0	374	1	paramh	com.google.b.h
    //   0	374	2	paramap	com.google.b.ap
    //   34	337	3	i	int
    //   43	115	4	j	int
    //   31	318	5	locala	com.google.b.da.a
    // Exception table:
    //   from	to	target	type
    //   39	45	181	com/google/b/bf
    //   152	165	181	com/google/b/bf
    //   170	178	181	com/google/b/bf
    //   215	223	181	com/google/b/bf
    //   248	256	181	com/google/b/bf
    //   259	267	181	com/google/b/bf
    //   270	278	181	com/google/b/bf
    //   281	289	181	com/google/b/bf
    //   292	300	181	com/google/b/bf
    //   303	311	181	com/google/b/bf
    //   314	322	181	com/google/b/bf
    //   325	333	181	com/google/b/bf
    //   336	344	181	com/google/b/bf
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
  
  public static a hDU()
  {
    AppMethodBeat.i(261112);
    a locala = VNi.hDV();
    AppMethodBeat.o(261112);
    return locala;
  }
  
  private a hDV()
  {
    AppMethodBeat.i(261114);
    if (this == VNi)
    {
      locala = new a((byte)0);
      AppMethodBeat.o(261114);
      return locala;
    }
    a locala = new a((byte)0).d(this);
    AppMethodBeat.o(261114);
    return locala;
  }
  
  public static u hDW()
  {
    return VNi;
  }
  
  public final int Ad()
  {
    AppMethodBeat.i(261108);
    int i = this.bOZ;
    if (i != -1)
    {
      AppMethodBeat.o(261108);
      return i;
    }
    int j = 0;
    if (this.VMY != 0.0F) {
      j = i.gJ(1) + 0;
    }
    i = j;
    if (this.VMZ) {
      i = j + i.gK(2);
    }
    j = i;
    if (this.VNa) {
      j = i + i.gK(3);
    }
    i = j;
    if (this.VNb != k.VMn.getNumber()) {
      i = j + i.bO(4, this.VNb);
    }
    j = i;
    if (this.VNc != k.VMn.getNumber()) {
      j = i + i.bO(5, this.VNc);
    }
    i = j;
    if (this.VNd != 0.0F) {
      i = j + i.gJ(6);
    }
    j = i;
    if (this.VNe != 0.0F) {
      j = i + i.gJ(7);
    }
    i = j;
    if (this.VNf != 0) {
      i = j + i.bM(8, this.VNf);
    }
    j = i;
    if (this.VNg != 0) {
      j = i + i.bM(9, this.VNg);
    }
    i = j;
    if (this.VLS) {
      i = j + i.gK(10);
    }
    j = i;
    if (this.VNh != 0L) {
      j = i + i.p(11, this.VNh);
    }
    i = j + this.bVW.Ad();
    this.bOZ = i;
    AppMethodBeat.o(261108);
    return i;
  }
  
  public final da Ca()
  {
    return this.bVW;
  }
  
  public final bb.e Cb()
  {
    AppMethodBeat.i(261105);
    bb.e locale = ae.VOv.b(u.class, a.class);
    AppMethodBeat.o(261105);
    return locale;
  }
  
  public final ci<u> Co()
  {
    return bRf;
  }
  
  public final void a(i parami)
  {
    AppMethodBeat.i(261107);
    if (this.VMY != 0.0F) {
      parami.i(1, this.VMY);
    }
    if (this.VMZ) {
      parami.t(2, this.VMZ);
    }
    if (this.VNa) {
      parami.t(3, this.VNa);
    }
    if (this.VNb != k.VMn.getNumber()) {
      parami.bJ(4, this.VNb);
    }
    if (this.VNc != k.VMn.getNumber()) {
      parami.bJ(5, this.VNc);
    }
    if (this.VNd != 0.0F) {
      parami.i(6, this.VNd);
    }
    if (this.VNe != 0.0F) {
      parami.i(7, this.VNe);
    }
    if (this.VNf != 0) {
      parami.bJ(8, this.VNf);
    }
    if (this.VNg != 0) {
      parami.bJ(9, this.VNg);
    }
    if (this.VLS) {
      parami.t(10, this.VLS);
    }
    if (this.VNh != 0L) {
      parami.n(11, this.VNh);
    }
    this.bVW.a(parami);
    AppMethodBeat.o(261107);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(261109);
    if (paramObject == this)
    {
      AppMethodBeat.o(261109);
      return true;
    }
    if (!(paramObject instanceof u))
    {
      boolean bool = super.equals(paramObject);
      AppMethodBeat.o(261109);
      return bool;
    }
    paramObject = (u)paramObject;
    if (Float.floatToIntBits(this.VMY) != Float.floatToIntBits(paramObject.VMY))
    {
      AppMethodBeat.o(261109);
      return false;
    }
    if (this.VMZ != paramObject.VMZ)
    {
      AppMethodBeat.o(261109);
      return false;
    }
    if (this.VNa != paramObject.VNa)
    {
      AppMethodBeat.o(261109);
      return false;
    }
    if (this.VNb != paramObject.VNb)
    {
      AppMethodBeat.o(261109);
      return false;
    }
    if (this.VNc != paramObject.VNc)
    {
      AppMethodBeat.o(261109);
      return false;
    }
    if (Float.floatToIntBits(this.VNd) != Float.floatToIntBits(paramObject.VNd))
    {
      AppMethodBeat.o(261109);
      return false;
    }
    if (Float.floatToIntBits(this.VNe) != Float.floatToIntBits(paramObject.VNe))
    {
      AppMethodBeat.o(261109);
      return false;
    }
    if (this.VNf != paramObject.VNf)
    {
      AppMethodBeat.o(261109);
      return false;
    }
    if (this.VNg != paramObject.VNg)
    {
      AppMethodBeat.o(261109);
      return false;
    }
    if (this.VLS != paramObject.VLS)
    {
      AppMethodBeat.o(261109);
      return false;
    }
    if (this.VNh != paramObject.VNh)
    {
      AppMethodBeat.o(261109);
      return false;
    }
    if (!this.bVW.equals(paramObject.bVW))
    {
      AppMethodBeat.o(261109);
      return false;
    }
    AppMethodBeat.o(261109);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(261111);
    if (this.bPa != 0)
    {
      i = this.bPa;
      AppMethodBeat.o(261111);
      return i;
    }
    int i = (((((((((((((((((((((((ae.VOu.hashCode() + 779) * 37 + 1) * 53 + Float.floatToIntBits(this.VMY)) * 37 + 2) * 53 + be.bS(this.VMZ)) * 37 + 3) * 53 + be.bS(this.VNa)) * 37 + 4) * 53 + this.VNb) * 37 + 5) * 53 + this.VNc) * 37 + 6) * 53 + Float.floatToIntBits(this.VNd)) * 37 + 7) * 53 + Float.floatToIntBits(this.VNe)) * 37 + 8) * 53 + this.VNf) * 37 + 9) * 53 + this.VNg) * 37 + 10) * 53 + be.bS(this.VLS)) * 37 + 11) * 53 + be.aJ(this.VNh)) * 29 + this.bVW.hashCode();
    this.bPa = i;
    AppMethodBeat.o(261111);
    return i;
  }
  
  public final boolean isInitialized()
  {
    int i = this.bRd;
    if (i == 1) {
      return true;
    }
    if (i == 0) {
      return false;
    }
    this.bRd = 1;
    return true;
  }
  
  public static final class a
    extends bb.a<a>
    implements v
  {
    private boolean VLS;
    private float VMY;
    private boolean VMZ;
    private boolean VNa;
    private int VNb;
    private int VNc;
    private float VNd;
    private float VNe;
    private int VNf;
    private int VNg;
    private long VNh;
    
    private a()
    {
      AppMethodBeat.i(261039);
      this.VNb = 0;
      this.VNc = 0;
      AppMethodBeat.o(261039);
    }
    
    private a(bb.b paramb)
    {
      super();
      AppMethodBeat.i(261040);
      this.VNb = 0;
      this.VNc = 0;
      AppMethodBeat.o(261040);
    }
    
    private a U(bt parambt)
    {
      AppMethodBeat.i(261045);
      if ((parambt instanceof u))
      {
        parambt = d((u)parambt);
        AppMethodBeat.o(261045);
        return parambt;
      }
      super.a(parambt);
      AppMethodBeat.o(261045);
      return this;
    }
    
    /* Error */
    private a V(com.google.b.h paramh, com.google.b.ap paramap)
    {
      // Byte code:
      //   0: ldc 71
      //   2: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: invokestatic 75	com/tencent/mm/timelineedit/a/a/u:hDX	()Lcom/google/b/ci;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 80 3 0
      //   17: checkcast 9	com/tencent/mm/timelineedit/a/a/u
      //   20: astore_1
      //   21: aload_1
      //   22: ifnull +9 -> 31
      //   25: aload_0
      //   26: aload_1
      //   27: invokevirtual 63	com/tencent/mm/timelineedit/a/a/u$a:d	(Lcom/tencent/mm/timelineedit/a/a/u;)Lcom/tencent/mm/timelineedit/a/a/u$a;
      //   30: pop
      //   31: ldc 71
      //   33: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   36: aload_0
      //   37: areturn
      //   38: astore_1
      //   39: aload_1
      //   40: getfield 84	com/google/b/bf:bZj	Lcom/google/b/bw;
      //   43: checkcast 9	com/tencent/mm/timelineedit/a/a/u
      //   46: astore_2
      //   47: aload_1
      //   48: invokevirtual 88	com/google/b/bf:Im	()Ljava/io/IOException;
      //   51: astore_1
      //   52: ldc 71
      //   54: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   57: aload_1
      //   58: athrow
      //   59: astore_1
      //   60: aload_2
      //   61: ifnull +9 -> 70
      //   64: aload_0
      //   65: aload_2
      //   66: invokevirtual 63	com/tencent/mm/timelineedit/a/a/u$a:d	(Lcom/tencent/mm/timelineedit/a/a/u;)Lcom/tencent/mm/timelineedit/a/a/u$a;
      //   69: pop
      //   70: ldc 71
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
      //   0	83	1	paramh	com.google.b.h
      //   0	83	2	paramap	com.google.b.ap
      //   6	73	3	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   7	21	38	com/google/b/bf
      //   47	59	59	finally
      //   7	21	77	finally
      //   39	47	77	finally
    }
    
    private a aO(aj.f paramf, Object paramObject)
    {
      AppMethodBeat.i(261043);
      paramf = (a)super.d(paramf, paramObject);
      AppMethodBeat.o(261043);
      return paramf;
    }
    
    private a aP(aj.f paramf, Object paramObject)
    {
      AppMethodBeat.i(261044);
      paramf = (a)super.c(paramf, paramObject);
      AppMethodBeat.o(261044);
      return paramf;
    }
    
    private a aQ(da paramda)
    {
      AppMethodBeat.i(261069);
      paramda = (a)super.e(paramda);
      AppMethodBeat.o(261069);
      return paramda;
    }
    
    private a aR(da paramda)
    {
      AppMethodBeat.i(261070);
      paramda = (a)super.d(paramda);
      AppMethodBeat.o(261070);
      return paramda;
    }
    
    private a atq(int paramInt)
    {
      AppMethodBeat.i(261054);
      this.VNb = paramInt;
      onChanged();
      AppMethodBeat.o(261054);
      return this;
    }
    
    private a atr(int paramInt)
    {
      AppMethodBeat.i(261058);
      this.VNc = paramInt;
      onChanged();
      AppMethodBeat.o(261058);
      return this;
    }
    
    private u hDY()
    {
      AppMethodBeat.i(261041);
      Object localObject = hDZ();
      if (!((u)localObject).isInitialized())
      {
        localObject = b((bt)localObject);
        AppMethodBeat.o(261041);
        throw ((Throwable)localObject);
      }
      AppMethodBeat.o(261041);
      return localObject;
    }
    
    private u hDZ()
    {
      AppMethodBeat.i(261042);
      u localu = new u(this, (byte)0);
      u.a(localu, this.VMY);
      u.a(localu, this.VMZ);
      u.b(localu, this.VNa);
      u.a(localu, this.VNb);
      u.b(localu, this.VNc);
      u.b(localu, this.VNd);
      u.c(localu, this.VNe);
      u.c(localu, this.VNf);
      u.d(localu, this.VNg);
      u.c(localu, this.VLS);
      u.a(localu, this.VNh);
      Ib();
      AppMethodBeat.o(261042);
      return localu;
    }
    
    public final bb.e Cb()
    {
      AppMethodBeat.i(261038);
      bb.e locale = ae.VOv.b(u.class, a.class);
      AppMethodBeat.o(261038);
      return locale;
    }
    
    public final aj.a Cv()
    {
      return ae.VOu;
    }
    
    public final a Fb(boolean paramBoolean)
    {
      AppMethodBeat.i(261051);
      this.VMZ = paramBoolean;
      onChanged();
      AppMethodBeat.o(261051);
      return this;
    }
    
    public final a Fc(boolean paramBoolean)
    {
      AppMethodBeat.i(261052);
      this.VNa = paramBoolean;
      onChanged();
      AppMethodBeat.o(261052);
      return this;
    }
    
    public final a Fd(boolean paramBoolean)
    {
      AppMethodBeat.i(261065);
      this.VLS = paramBoolean;
      onChanged();
      AppMethodBeat.o(261065);
      return this;
    }
    
    public final a Vk(long paramLong)
    {
      AppMethodBeat.i(261067);
      this.VNh = paramLong;
      onChanged();
      AppMethodBeat.o(261067);
      return this;
    }
    
    public final a a(k paramk)
    {
      AppMethodBeat.i(261057);
      if (paramk == null)
      {
        paramk = new NullPointerException();
        AppMethodBeat.o(261057);
        throw paramk;
      }
      this.VNb = paramk.getNumber();
      onChanged();
      AppMethodBeat.o(261057);
      return this;
    }
    
    public final a ats(int paramInt)
    {
      AppMethodBeat.i(261062);
      this.VNf = paramInt;
      onChanged();
      AppMethodBeat.o(261062);
      return this;
    }
    
    public final a att(int paramInt)
    {
      AppMethodBeat.i(261063);
      this.VNg = paramInt;
      onChanged();
      AppMethodBeat.o(261063);
      return this;
    }
    
    public final a b(k paramk)
    {
      AppMethodBeat.i(261059);
      if (paramk == null)
      {
        paramk = new NullPointerException();
        AppMethodBeat.o(261059);
        throw paramk;
      }
      this.VNc = paramk.getNumber();
      onChanged();
      AppMethodBeat.o(261059);
      return this;
    }
    
    public final a cx(float paramFloat)
    {
      AppMethodBeat.i(261050);
      this.VMY = paramFloat;
      onChanged();
      AppMethodBeat.o(261050);
      return this;
    }
    
    public final a cy(float paramFloat)
    {
      AppMethodBeat.i(261060);
      this.VNd = paramFloat;
      onChanged();
      AppMethodBeat.o(261060);
      return this;
    }
    
    public final a cz(float paramFloat)
    {
      AppMethodBeat.i(261061);
      this.VNe = paramFloat;
      onChanged();
      AppMethodBeat.o(261061);
      return this;
    }
    
    public final a d(u paramu)
    {
      AppMethodBeat.i(261047);
      if (paramu == u.hDW())
      {
        AppMethodBeat.o(261047);
        return this;
      }
      if (paramu.VMY != 0.0F) {
        cx(paramu.VMY);
      }
      if (paramu.VMZ) {
        Fb(paramu.VMZ);
      }
      if (paramu.VNa) {
        Fc(paramu.VNa);
      }
      if (u.a(paramu) != 0) {
        atq(paramu.VNb);
      }
      if (u.b(paramu) != 0) {
        atr(paramu.VNc);
      }
      if (paramu.VNd != 0.0F) {
        cy(paramu.VNd);
      }
      if (paramu.VNe != 0.0F) {
        cz(paramu.VNe);
      }
      if (paramu.VNf != 0) {
        ats(paramu.VNf);
      }
      if (paramu.VNg != 0) {
        att(paramu.VNg);
      }
      if (paramu.VLS) {
        Fd(paramu.VLS);
      }
      if (paramu.VNh != 0L) {
        Vk(paramu.VNh);
      }
      aR(u.c(paramu));
      onChanged();
      AppMethodBeat.o(261047);
      return this;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.timelineedit.a.a.u
 * JD-Core Version:    0.7.0.1
 */