package com.tencent.mm.timelineedit.a.a;

import com.google.b.aj.a;
import com.google.b.aj.f;
import com.google.b.bb;
import com.google.b.bb.a;
import com.google.b.bb.b;
import com.google.b.bb.e;
import com.google.b.bt;
import com.google.b.c;
import com.google.b.ci;
import com.google.b.da;
import com.google.b.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class y
  extends bb
  implements z
{
  private static final y VNo;
  private static final ci<y> bRf;
  float VNn;
  private byte bRd = -1;
  int type_;
  
  static
  {
    AppMethodBeat.i(261383);
    VNo = new y();
    bRf = new c() {};
    AppMethodBeat.o(261383);
  }
  
  private y()
  {
    this.type_ = 0;
  }
  
  private y(bb.a<?> parama)
  {
    super(parama);
  }
  
  /* Error */
  private y(com.google.b.h paramh, com.google.b.ap paramap)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 34	com/tencent/mm/timelineedit/a/a/y:<init>	()V
    //   4: ldc 61
    //   6: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_2
    //   10: ifnonnull +18 -> 28
    //   13: new 63	java/lang/NullPointerException
    //   16: dup
    //   17: invokespecial 64	java/lang/NullPointerException:<init>	()V
    //   20: astore_1
    //   21: ldc 61
    //   23: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: aload_1
    //   27: athrow
    //   28: invokestatic 70	com/google/b/da:Jj	()Lcom/google/b/da$a;
    //   31: astore 5
    //   33: iconst_0
    //   34: istore_3
    //   35: iload_3
    //   36: ifne +140 -> 176
    //   39: aload_1
    //   40: invokevirtual 76	com/google/b/h:Av	()I
    //   43: istore 4
    //   45: iload 4
    //   47: lookupswitch	default:+148->195, 0:+151->198, 8:+51->98, 21:+96->143
    //   81: aload_1
    //   82: aload 5
    //   84: aload_2
    //   85: iload 4
    //   87: invokevirtual 79	com/tencent/mm/timelineedit/a/a/y:a	(Lcom/google/b/h;Lcom/google/b/da$a;Lcom/google/b/ap;I)Z
    //   90: ifne -55 -> 35
    //   93: iconst_1
    //   94: istore_3
    //   95: goto -60 -> 35
    //   98: aload_0
    //   99: aload_1
    //   100: invokevirtual 82	com/google/b/h:AF	()I
    //   103: putfield 48	com/tencent/mm/timelineedit/a/a/y:type_	I
    //   106: goto -71 -> 35
    //   109: astore_1
    //   110: aload_1
    //   111: aload_0
    //   112: putfield 86	com/google/b/bf:bZj	Lcom/google/b/bw;
    //   115: ldc 61
    //   117: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: aload_1
    //   121: athrow
    //   122: astore_1
    //   123: aload_0
    //   124: aload 5
    //   126: invokevirtual 92	com/google/b/da$a:Jm	()Lcom/google/b/da;
    //   129: putfield 96	com/tencent/mm/timelineedit/a/a/y:bVW	Lcom/google/b/da;
    //   132: aload_0
    //   133: invokevirtual 99	com/tencent/mm/timelineedit/a/a/y:HZ	()V
    //   136: ldc 61
    //   138: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   141: aload_1
    //   142: athrow
    //   143: aload_0
    //   144: aload_1
    //   145: invokevirtual 103	com/google/b/h:readFloat	()F
    //   148: putfield 105	com/tencent/mm/timelineedit/a/a/y:VNn	F
    //   151: goto -116 -> 35
    //   154: astore_1
    //   155: new 58	com/google/b/bf
    //   158: dup
    //   159: aload_1
    //   160: invokespecial 108	com/google/b/bf:<init>	(Ljava/io/IOException;)V
    //   163: astore_1
    //   164: aload_1
    //   165: aload_0
    //   166: putfield 86	com/google/b/bf:bZj	Lcom/google/b/bw;
    //   169: ldc 61
    //   171: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   174: aload_1
    //   175: athrow
    //   176: aload_0
    //   177: aload 5
    //   179: invokevirtual 92	com/google/b/da$a:Jm	()Lcom/google/b/da;
    //   182: putfield 96	com/tencent/mm/timelineedit/a/a/y:bVW	Lcom/google/b/da;
    //   185: aload_0
    //   186: invokevirtual 99	com/tencent/mm/timelineedit/a/a/y:HZ	()V
    //   189: ldc 61
    //   191: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   194: return
    //   195: goto -115 -> 80
    //   198: iconst_1
    //   199: istore_3
    //   200: goto -165 -> 35
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	203	0	this	y
    //   0	203	1	paramh	com.google.b.h
    //   0	203	2	paramap	com.google.b.ap
    //   34	166	3	i	int
    //   43	43	4	j	int
    //   31	147	5	locala	com.google.b.da.a
    // Exception table:
    //   from	to	target	type
    //   39	45	109	com/google/b/bf
    //   80	93	109	com/google/b/bf
    //   98	106	109	com/google/b/bf
    //   143	151	109	com/google/b/bf
    //   39	45	122	finally
    //   80	93	122	finally
    //   98	106	122	finally
    //   110	122	122	finally
    //   143	151	122	finally
    //   155	176	122	finally
    //   39	45	154	java/io/IOException
    //   80	93	154	java/io/IOException
    //   98	106	154	java/io/IOException
    //   143	151	154	java/io/IOException
  }
  
  public static a a(y paramy)
  {
    AppMethodBeat.i(261373);
    paramy = VNo.hEh().d(paramy);
    AppMethodBeat.o(261373);
    return paramy;
  }
  
  public static ci<y> hCD()
  {
    return bRf;
  }
  
  public static y hEi()
  {
    return VNo;
  }
  
  public final int Ad()
  {
    AppMethodBeat.i(261369);
    int i = this.bOZ;
    if (i != -1)
    {
      AppMethodBeat.o(261369);
      return i;
    }
    i = 0;
    if (this.type_ != n.VMw.getNumber()) {
      i = i.bO(1, this.type_) + 0;
    }
    int j = i;
    if (this.VNn != 0.0F) {
      j = i + i.gJ(2);
    }
    i = j + this.bVW.Ad();
    this.bOZ = i;
    AppMethodBeat.o(261369);
    return i;
  }
  
  public final da Ca()
  {
    return this.bVW;
  }
  
  public final bb.e Cb()
  {
    AppMethodBeat.i(261365);
    bb.e locale = ae.VNZ.b(y.class, a.class);
    AppMethodBeat.o(261365);
    return locale;
  }
  
  public final ci<y> Co()
  {
    return bRf;
  }
  
  public final void a(i parami)
  {
    AppMethodBeat.i(261367);
    if (this.type_ != n.VMw.getNumber()) {
      parami.bJ(1, this.type_);
    }
    if (this.VNn != 0.0F) {
      parami.i(2, this.VNn);
    }
    this.bVW.a(parami);
    AppMethodBeat.o(261367);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(261370);
    if (paramObject == this)
    {
      AppMethodBeat.o(261370);
      return true;
    }
    if (!(paramObject instanceof y))
    {
      boolean bool = super.equals(paramObject);
      AppMethodBeat.o(261370);
      return bool;
    }
    paramObject = (y)paramObject;
    if (this.type_ != paramObject.type_)
    {
      AppMethodBeat.o(261370);
      return false;
    }
    if (Float.floatToIntBits(this.VNn) != Float.floatToIntBits(paramObject.VNn))
    {
      AppMethodBeat.o(261370);
      return false;
    }
    if (!this.bVW.equals(paramObject.bVW))
    {
      AppMethodBeat.o(261370);
      return false;
    }
    AppMethodBeat.o(261370);
    return true;
  }
  
  public final a hEh()
  {
    AppMethodBeat.i(261374);
    if (this == VNo)
    {
      locala = new a((byte)0);
      AppMethodBeat.o(261374);
      return locala;
    }
    a locala = new a((byte)0).d(this);
    AppMethodBeat.o(261374);
    return locala;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(261371);
    if (this.bPa != 0)
    {
      i = this.bPa;
      AppMethodBeat.o(261371);
      return i;
    }
    int i = (((((ae.VNY.hashCode() + 779) * 37 + 1) * 53 + this.type_) * 37 + 2) * 53 + Float.floatToIntBits(this.VNn)) * 29 + this.bVW.hashCode();
    this.bPa = i;
    AppMethodBeat.o(261371);
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
    implements z
  {
    private float VNn;
    private int type_;
    
    private a()
    {
      AppMethodBeat.i(261279);
      this.type_ = 0;
      AppMethodBeat.o(261279);
    }
    
    private a(bb.b paramb)
    {
      super();
      AppMethodBeat.i(261281);
      this.type_ = 0;
      AppMethodBeat.o(261281);
    }
    
    private a W(bt parambt)
    {
      AppMethodBeat.i(261291);
      if ((parambt instanceof y))
      {
        parambt = d((y)parambt);
        AppMethodBeat.o(261291);
        return parambt;
      }
      super.a(parambt);
      AppMethodBeat.o(261291);
      return this;
    }
    
    /* Error */
    private a X(com.google.b.h paramh, com.google.b.ap paramap)
    {
      // Byte code:
      //   0: ldc 58
      //   2: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: invokestatic 62	com/tencent/mm/timelineedit/a/a/y:hCE	()Lcom/google/b/ci;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 67 3 0
      //   17: checkcast 9	com/tencent/mm/timelineedit/a/a/y
      //   20: astore_1
      //   21: aload_1
      //   22: ifnull +9 -> 31
      //   25: aload_0
      //   26: aload_1
      //   27: invokevirtual 50	com/tencent/mm/timelineedit/a/a/y$a:d	(Lcom/tencent/mm/timelineedit/a/a/y;)Lcom/tencent/mm/timelineedit/a/a/y$a;
      //   30: pop
      //   31: ldc 58
      //   33: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   36: aload_0
      //   37: areturn
      //   38: astore_1
      //   39: aload_1
      //   40: getfield 71	com/google/b/bf:bZj	Lcom/google/b/bw;
      //   43: checkcast 9	com/tencent/mm/timelineedit/a/a/y
      //   46: astore_2
      //   47: aload_1
      //   48: invokevirtual 75	com/google/b/bf:Im	()Ljava/io/IOException;
      //   51: astore_1
      //   52: ldc 58
      //   54: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   57: aload_1
      //   58: athrow
      //   59: astore_1
      //   60: aload_2
      //   61: ifnull +9 -> 70
      //   64: aload_0
      //   65: aload_2
      //   66: invokevirtual 50	com/tencent/mm/timelineedit/a/a/y$a:d	(Lcom/tencent/mm/timelineedit/a/a/y;)Lcom/tencent/mm/timelineedit/a/a/y$a;
      //   69: pop
      //   70: ldc 58
      //   72: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    
    private a aS(aj.f paramf, Object paramObject)
    {
      AppMethodBeat.i(261288);
      paramf = (a)super.d(paramf, paramObject);
      AppMethodBeat.o(261288);
      return paramf;
    }
    
    private a aT(aj.f paramf, Object paramObject)
    {
      AppMethodBeat.i(261289);
      paramf = (a)super.c(paramf, paramObject);
      AppMethodBeat.o(261289);
      return paramf;
    }
    
    private a aU(da paramda)
    {
      AppMethodBeat.i(261304);
      paramda = (a)super.e(paramda);
      AppMethodBeat.o(261304);
      return paramda;
    }
    
    private a aV(da paramda)
    {
      AppMethodBeat.i(261305);
      paramda = (a)super.d(paramda);
      AppMethodBeat.o(261305);
      return paramda;
    }
    
    private a atu(int paramInt)
    {
      AppMethodBeat.i(261302);
      this.type_ = paramInt;
      onChanged();
      AppMethodBeat.o(261302);
      return this;
    }
    
    private a cA(float paramFloat)
    {
      AppMethodBeat.i(261303);
      this.VNn = paramFloat;
      onChanged();
      AppMethodBeat.o(261303);
      return this;
    }
    
    private y hEj()
    {
      AppMethodBeat.i(261283);
      Object localObject = hEk();
      if (!((y)localObject).isInitialized())
      {
        localObject = b((bt)localObject);
        AppMethodBeat.o(261283);
        throw ((Throwable)localObject);
      }
      AppMethodBeat.o(261283);
      return localObject;
    }
    
    public final bb.e Cb()
    {
      AppMethodBeat.i(261278);
      bb.e locale = ae.VNZ.b(y.class, a.class);
      AppMethodBeat.o(261278);
      return locale;
    }
    
    public final aj.a Cv()
    {
      return ae.VNY;
    }
    
    public final a d(y paramy)
    {
      AppMethodBeat.i(261294);
      if (paramy == y.hEi())
      {
        AppMethodBeat.o(261294);
        return this;
      }
      if (y.b(paramy) != 0) {
        atu(paramy.type_);
      }
      if (paramy.VNn != 0.0F) {
        cA(paramy.VNn);
      }
      aV(y.c(paramy));
      onChanged();
      AppMethodBeat.o(261294);
      return this;
    }
    
    public final y hEk()
    {
      AppMethodBeat.i(261285);
      y localy = new y(this, (byte)0);
      y.a(localy, this.type_);
      y.a(localy, this.VNn);
      Ib();
      AppMethodBeat.o(261285);
      return localy;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.timelineedit.a.a.y
 * JD-Core Version:    0.7.0.1
 */