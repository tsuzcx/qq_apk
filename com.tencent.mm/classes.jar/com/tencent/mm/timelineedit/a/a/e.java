package com.tencent.mm.timelineedit.a.a;

import com.google.b.aj.a;
import com.google.b.aj.f;
import com.google.b.ap;
import com.google.b.bb;
import com.google.b.bb.a;
import com.google.b.bb.b;
import com.google.b.bb.e;
import com.google.b.be;
import com.google.b.bf;
import com.google.b.bt;
import com.google.b.bw;
import com.google.b.ci;
import com.google.b.co;
import com.google.b.cs;
import com.google.b.da;
import com.google.b.da.a;
import com.google.b.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class e
  extends bb
  implements f
{
  private static final e VLZ;
  private static final ci<e> bRf;
  private q VLK;
  private List<aa> VLP;
  long VLQ;
  long VLR;
  boolean VLS;
  private c VLT;
  private List<l> VLU;
  private af VLV;
  boolean VLW;
  private List<g> VLX;
  private q VLY;
  private byte bRd;
  
  static
  {
    AppMethodBeat.i(260295);
    VLZ = new e();
    bRf = new com.google.b.c() {};
    AppMethodBeat.o(260295);
  }
  
  private e()
  {
    AppMethodBeat.i(260255);
    this.bRd = -1;
    this.VLP = Collections.emptyList();
    this.VLU = Collections.emptyList();
    this.VLX = Collections.emptyList();
    AppMethodBeat.o(260255);
  }
  
  private e(bb.a<?> parama)
  {
    super(parama);
    this.bRd = -1;
  }
  
  private e(com.google.b.h paramh, ap paramap)
  {
    this();
    AppMethodBeat.i(260260);
    if (paramap == null)
    {
      paramh = new NullPointerException();
      AppMethodBeat.o(260260);
      throw paramh;
    }
    da.a locala = da.Jj();
    int i1 = 0;
    int i = 0;
    for (;;)
    {
      label38:
      int k;
      int m;
      int j;
      if (i1 == 0)
      {
        k = i;
        m = i;
        j = i;
      }
      for (;;)
      {
        int n;
        try
        {
          n = paramh.Av();
          switch (n)
          {
          case 10: 
            k = i;
            m = i;
            j = i;
            if (a(paramh, locala, paramap, n)) {
              break label1102;
            }
            j = 1;
            break label1136;
            n = i;
            if ((i & 0x1) == 0)
            {
              k = i;
              m = i;
              j = i;
              this.VLP = new ArrayList();
              n = i | 0x1;
            }
            k = n;
            m = n;
            j = n;
            this.VLP.add(paramh.a(aa.hCD(), paramap));
            i = n;
            break label38;
          }
        }
        catch (bf paramh)
        {
          try
          {
            paramh.bZj = this;
            AppMethodBeat.o(260260);
            throw paramh;
          }
          finally
          {
            j = k;
            if ((j & 0x1) != 0) {
              this.VLP = Collections.unmodifiableList(this.VLP);
            }
            if ((j & 0x2) != 0) {
              this.VLU = Collections.unmodifiableList(this.VLU);
            }
            if ((j & 0x4) != 0) {
              this.VLX = Collections.unmodifiableList(this.VLX);
            }
            this.bVW = locala.Jm();
            HZ();
            AppMethodBeat.o(260260);
          }
          k = i;
          m = i;
          j = i;
          this.VLQ = paramh.Ax();
          break;
        }
        catch (IOException paramh)
        {
          j = m;
          paramh = new bf(paramh);
          j = m;
          paramh.bZj = this;
          j = m;
          AppMethodBeat.o(260260);
          j = m;
          throw paramh;
        }
        finally
        {
          continue;
          k = i;
          m = i;
          j = i;
          this.VLR = paramh.Ax();
        }
        break;
        k = i;
        m = i;
        j = i;
        this.VLS = paramh.AB();
        break;
        k = i;
        m = i;
        j = i;
        if (this.VLT != null)
        {
          k = i;
          m = i;
          j = i;
        }
        for (Object localObject = this.VLT.hCL();; localObject = null)
        {
          k = i;
          m = i;
          j = i;
          this.VLT = ((c)paramh.a(c.hCD(), paramap));
          if (localObject != null)
          {
            k = i;
            m = i;
            j = i;
            ((c.a)localObject).d(this.VLT);
            k = i;
            m = i;
            j = i;
            this.VLT = ((c.a)localObject).hCQ();
            break;
            n = i;
            if ((i & 0x2) == 0)
            {
              k = i;
              m = i;
              j = i;
              this.VLU = new ArrayList();
              n = i | 0x2;
            }
            k = n;
            m = n;
            j = n;
            this.VLU.add(paramh.a(l.hCD(), paramap));
            i = n;
            break;
            k = i;
            m = i;
            j = i;
            if (this.VLV == null) {
              break label1121;
            }
            k = i;
            m = i;
            j = i;
          }
          label1102:
          label1109:
          label1115:
          label1121:
          for (localObject = this.VLV.hEL();; localObject = null)
          {
            k = i;
            m = i;
            j = i;
            this.VLV = ((af)paramh.a(af.hCD(), paramap));
            if (localObject != null)
            {
              k = i;
              m = i;
              j = i;
              ((af.a)localObject).f(this.VLV);
              k = i;
              m = i;
              j = i;
              this.VLV = ((af.a)localObject).hEO();
              break;
              k = i;
              m = i;
              j = i;
              this.VLW = paramh.AB();
              break;
              n = i;
              if ((i & 0x4) == 0)
              {
                k = i;
                m = i;
                j = i;
                this.VLX = new ArrayList();
                n = i | 0x4;
              }
              k = n;
              m = n;
              j = n;
              this.VLX.add(paramh.a(g.hCD(), paramap));
              i = n;
              break;
              k = i;
              m = i;
              j = i;
              if (this.VLY == null) {
                break label1115;
              }
              k = i;
              m = i;
              j = i;
            }
            for (localObject = this.VLY.hDL();; localObject = null)
            {
              k = i;
              m = i;
              j = i;
              this.VLY = ((q)paramh.a(q.hCD(), paramap));
              if (localObject != null)
              {
                k = i;
                m = i;
                j = i;
                ((q.a)localObject).l(this.VLY);
                k = i;
                m = i;
                j = i;
                this.VLY = ((q.a)localObject).hDP();
                break;
                k = i;
                m = i;
                j = i;
                if (this.VLK == null) {
                  break label1109;
                }
                k = i;
                m = i;
                j = i;
              }
              for (localObject = this.VLK.hDL();; localObject = null)
              {
                k = i;
                m = i;
                j = i;
                this.VLK = ((q)paramh.a(q.hCD(), paramap));
                if (localObject != null)
                {
                  k = i;
                  m = i;
                  j = i;
                  ((q.a)localObject).l(this.VLK);
                  k = i;
                  m = i;
                  j = i;
                  this.VLK = ((q.a)localObject).hDP();
                  break;
                  if ((i & 0x1) != 0) {
                    this.VLP = Collections.unmodifiableList(this.VLP);
                  }
                  if ((i & 0x2) != 0) {
                    this.VLU = Collections.unmodifiableList(this.VLU);
                  }
                  if ((i & 0x4) != 0) {
                    this.VLX = Collections.unmodifiableList(this.VLX);
                  }
                  this.bVW = locala.Jm();
                  HZ();
                  AppMethodBeat.o(260260);
                  return;
                }
                j = i1;
                break label1136;
              }
            }
          }
        }
      }
      label1136:
      i1 = j;
      continue;
      i1 = 1;
    }
  }
  
  public static e dh(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(260272);
    paramArrayOfByte = (e)bRf.w(paramArrayOfByte);
    AppMethodBeat.o(260272);
    return paramArrayOfByte;
  }
  
  private a hDb()
  {
    AppMethodBeat.i(260273);
    if (this == VLZ)
    {
      locala = new a((byte)0);
      AppMethodBeat.o(260273);
      return locala;
    }
    a locala = new a((byte)0).e(this);
    AppMethodBeat.o(260273);
    return locala;
  }
  
  public static e hDc()
  {
    return VLZ;
  }
  
  public final int Ad()
  {
    int m = 0;
    AppMethodBeat.i(260268);
    int i = this.bOZ;
    if (i != -1)
    {
      AppMethodBeat.o(260268);
      return i;
    }
    int j = 0;
    i = 0;
    while (j < this.VLP.size())
    {
      i += i.c(1, (bw)this.VLP.get(j));
      j += 1;
    }
    j = i;
    if (this.VLQ != 0L) {
      j = i + i.p(2, this.VLQ);
    }
    i = j;
    if (this.VLR != 0L) {
      i = j + i.p(3, this.VLR);
    }
    j = i;
    if (this.VLS) {
      j = i + i.gK(4);
    }
    i = j;
    if (this.VLT != null) {
      i = j + i.c(5, hCW());
    }
    j = 0;
    while (j < this.VLU.size())
    {
      i += i.c(6, (bw)this.VLU.get(j));
      j += 1;
    }
    j = i;
    if (this.VLV != null) {
      j = i + i.c(7, hCY());
    }
    int k = m;
    i = j;
    if (this.VLW)
    {
      i = j + i.gK(8);
      k = m;
    }
    while (k < this.VLX.size())
    {
      i += i.c(9, (bw)this.VLX.get(k));
      k += 1;
    }
    j = i;
    if (this.VLY != null) {
      j = i + i.c(10, hDa());
    }
    i = j;
    if (this.VLK != null) {
      i = j + i.c(11, hCK());
    }
    i = this.bVW.Ad() + i;
    this.bOZ = i;
    AppMethodBeat.o(260268);
    return i;
  }
  
  public final da Ca()
  {
    return this.bVW;
  }
  
  public final bb.e Cb()
  {
    AppMethodBeat.i(260261);
    bb.e locale = ae.VOt.b(e.class, a.class);
    AppMethodBeat.o(260261);
    return locale;
  }
  
  public final ci<e> Co()
  {
    return bRf;
  }
  
  public final void a(i parami)
  {
    int j = 0;
    AppMethodBeat.i(260267);
    int i = 0;
    while (i < this.VLP.size())
    {
      parami.a(1, (bw)this.VLP.get(i));
      i += 1;
    }
    if (this.VLQ != 0L) {
      parami.n(2, this.VLQ);
    }
    if (this.VLR != 0L) {
      parami.n(3, this.VLR);
    }
    if (this.VLS) {
      parami.t(4, this.VLS);
    }
    if (this.VLT != null) {
      parami.a(5, hCW());
    }
    i = 0;
    while (i < this.VLU.size())
    {
      parami.a(6, (bw)this.VLU.get(i));
      i += 1;
    }
    if (this.VLV != null) {
      parami.a(7, hCY());
    }
    i = j;
    if (this.VLW)
    {
      parami.t(8, this.VLW);
      i = j;
    }
    while (i < this.VLX.size())
    {
      parami.a(9, (bw)this.VLX.get(i));
      i += 1;
    }
    if (this.VLY != null) {
      parami.a(10, hDa());
    }
    if (this.VLK != null) {
      parami.a(11, hCK());
    }
    this.bVW.a(parami);
    AppMethodBeat.o(260267);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(260269);
    if (paramObject == this)
    {
      AppMethodBeat.o(260269);
      return true;
    }
    if (!(paramObject instanceof e))
    {
      boolean bool = super.equals(paramObject);
      AppMethodBeat.o(260269);
      return bool;
    }
    paramObject = (e)paramObject;
    if (!this.VLP.equals(paramObject.VLP))
    {
      AppMethodBeat.o(260269);
      return false;
    }
    if (this.VLQ != paramObject.VLQ)
    {
      AppMethodBeat.o(260269);
      return false;
    }
    if (this.VLR != paramObject.VLR)
    {
      AppMethodBeat.o(260269);
      return false;
    }
    if (this.VLS != paramObject.VLS)
    {
      AppMethodBeat.o(260269);
      return false;
    }
    if (hCV() != paramObject.hCV())
    {
      AppMethodBeat.o(260269);
      return false;
    }
    if ((hCV()) && (!hCW().equals(paramObject.hCW())))
    {
      AppMethodBeat.o(260269);
      return false;
    }
    if (!this.VLU.equals(paramObject.VLU))
    {
      AppMethodBeat.o(260269);
      return false;
    }
    if (hCX() != paramObject.hCX())
    {
      AppMethodBeat.o(260269);
      return false;
    }
    if ((hCX()) && (!hCY().equals(paramObject.hCY())))
    {
      AppMethodBeat.o(260269);
      return false;
    }
    if (this.VLW != paramObject.VLW)
    {
      AppMethodBeat.o(260269);
      return false;
    }
    if (!this.VLX.equals(paramObject.VLX))
    {
      AppMethodBeat.o(260269);
      return false;
    }
    if (hCZ() != paramObject.hCZ())
    {
      AppMethodBeat.o(260269);
      return false;
    }
    if ((hCZ()) && (!hDa().equals(paramObject.hDa())))
    {
      AppMethodBeat.o(260269);
      return false;
    }
    if (hCJ() != paramObject.hCJ())
    {
      AppMethodBeat.o(260269);
      return false;
    }
    if ((hCJ()) && (!hCK().equals(paramObject.hCK())))
    {
      AppMethodBeat.o(260269);
      return false;
    }
    if (!this.bVW.equals(paramObject.bVW))
    {
      AppMethodBeat.o(260269);
      return false;
    }
    AppMethodBeat.o(260269);
    return true;
  }
  
  public final boolean hCJ()
  {
    return this.VLK != null;
  }
  
  public final q hCK()
  {
    AppMethodBeat.i(260266);
    if (this.VLK == null)
    {
      localq = q.hDM();
      AppMethodBeat.o(260266);
      return localq;
    }
    q localq = this.VLK;
    AppMethodBeat.o(260266);
    return localq;
  }
  
  public final List<aa> hCT()
  {
    return this.VLP;
  }
  
  public final boolean hCU()
  {
    return this.VLS;
  }
  
  public final boolean hCV()
  {
    return this.VLT != null;
  }
  
  public final c hCW()
  {
    AppMethodBeat.i(260262);
    if (this.VLT == null)
    {
      localc = c.hCM();
      AppMethodBeat.o(260262);
      return localc;
    }
    c localc = this.VLT;
    AppMethodBeat.o(260262);
    return localc;
  }
  
  public final boolean hCX()
  {
    return this.VLV != null;
  }
  
  public final af hCY()
  {
    AppMethodBeat.i(260264);
    if (this.VLV == null)
    {
      localaf = af.hEM();
      AppMethodBeat.o(260264);
      return localaf;
    }
    af localaf = this.VLV;
    AppMethodBeat.o(260264);
    return localaf;
  }
  
  public final boolean hCZ()
  {
    return this.VLY != null;
  }
  
  public final q hDa()
  {
    AppMethodBeat.i(260265);
    if (this.VLY == null)
    {
      localq = q.hDM();
      AppMethodBeat.o(260265);
      return localq;
    }
    q localq = this.VLY;
    AppMethodBeat.o(260265);
    return localq;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(260271);
    if (this.bPa != 0)
    {
      i = this.bPa;
      AppMethodBeat.o(260271);
      return i;
    }
    int j = ae.VOs.hashCode() + 779;
    int i = j;
    if (this.VLP.size() > 0) {
      i = (j * 37 + 1) * 53 + this.VLP.hashCode();
    }
    j = (((((i * 37 + 2) * 53 + be.aJ(this.VLQ)) * 37 + 3) * 53 + be.aJ(this.VLR)) * 37 + 4) * 53 + be.bS(this.VLS);
    i = j;
    if (hCV()) {
      i = (j * 37 + 5) * 53 + hCW().hashCode();
    }
    j = i;
    if (this.VLU.size() > 0) {
      j = (i * 37 + 6) * 53 + this.VLU.hashCode();
    }
    i = j;
    if (hCX()) {
      i = (j * 37 + 7) * 53 + hCY().hashCode();
    }
    j = (i * 37 + 8) * 53 + be.bS(this.VLW);
    i = j;
    if (this.VLX.size() > 0) {
      i = (j * 37 + 9) * 53 + this.VLX.hashCode();
    }
    j = i;
    if (hCZ()) {
      j = (i * 37 + 10) * 53 + hDa().hashCode();
    }
    i = j;
    if (hCJ()) {
      i = (j * 37 + 11) * 53 + hCK().hashCode();
    }
    i = i * 29 + this.bVW.hashCode();
    this.bPa = i;
    AppMethodBeat.o(260271);
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
    implements f
  {
    private q VLK;
    private cs<q, q.a, r> VLO;
    private List<aa> VLP;
    private long VLQ;
    private long VLR;
    private boolean VLS;
    private c VLT;
    private List<l> VLU;
    private af VLV;
    private boolean VLW;
    private List<g> VLX;
    private q VLY;
    private co<aa, aa.a, ab> VMa;
    private cs<c, c.a, d> VMb;
    private co<l, l.a, m> VMc;
    private cs<af, af.a, ag> VMd;
    private co<g, g.a, h> VMe;
    private cs<q, q.a, r> VMf;
    private int bQS;
    
    private a()
    {
      AppMethodBeat.i(260178);
      this.VLP = Collections.emptyList();
      this.VLU = Collections.emptyList();
      this.VLX = Collections.emptyList();
      Cu();
      AppMethodBeat.o(260178);
    }
    
    private a(bb.b paramb)
    {
      super();
      AppMethodBeat.i(260180);
      this.VLP = Collections.emptyList();
      this.VLU = Collections.emptyList();
      this.VLX = Collections.emptyList();
      Cu();
      AppMethodBeat.o(260180);
    }
    
    private void Cu()
    {
      AppMethodBeat.i(260182);
      if (e.bXS)
      {
        hDk();
        hDm();
        hDo();
      }
      AppMethodBeat.o(260182);
    }
    
    private a EZ(boolean paramBoolean)
    {
      AppMethodBeat.i(260198);
      this.VLS = paramBoolean;
      onChanged();
      AppMethodBeat.o(260198);
      return this;
    }
    
    private a Fa(boolean paramBoolean)
    {
      AppMethodBeat.i(260204);
      this.VLW = paramBoolean;
      onChanged();
      AppMethodBeat.o(260204);
      return this;
    }
    
    private a O(bt parambt)
    {
      AppMethodBeat.i(260191);
      if ((parambt instanceof e))
      {
        parambt = e((e)parambt);
        AppMethodBeat.o(260191);
        return parambt;
      }
      super.a(parambt);
      AppMethodBeat.o(260191);
      return this;
    }
    
    /* Error */
    private a P(com.google.b.h paramh, ap paramap)
    {
      // Byte code:
      //   0: ldc 127
      //   2: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: invokestatic 131	com/tencent/mm/timelineedit/a/a/e:hDg	()Lcom/google/b/ci;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 137 3 0
      //   17: checkcast 9	com/tencent/mm/timelineedit/a/a/e
      //   20: astore_1
      //   21: aload_1
      //   22: ifnull +9 -> 31
      //   25: aload_0
      //   26: aload_1
      //   27: invokevirtual 119	com/tencent/mm/timelineedit/a/a/e$a:e	(Lcom/tencent/mm/timelineedit/a/a/e;)Lcom/tencent/mm/timelineedit/a/a/e$a;
      //   30: pop
      //   31: ldc 127
      //   33: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   36: aload_0
      //   37: areturn
      //   38: astore_1
      //   39: aload_1
      //   40: getfield 141	com/google/b/bf:bZj	Lcom/google/b/bw;
      //   43: checkcast 9	com/tencent/mm/timelineedit/a/a/e
      //   46: astore_2
      //   47: aload_1
      //   48: invokevirtual 145	com/google/b/bf:Im	()Ljava/io/IOException;
      //   51: astore_1
      //   52: ldc 127
      //   54: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   57: aload_1
      //   58: athrow
      //   59: astore_1
      //   60: aload_2
      //   61: ifnull +9 -> 70
      //   64: aload_0
      //   65: aload_2
      //   66: invokevirtual 119	com/tencent/mm/timelineedit/a/a/e$a:e	(Lcom/tencent/mm/timelineedit/a/a/e;)Lcom/tencent/mm/timelineedit/a/a/e$a;
      //   69: pop
      //   70: ldc 127
      //   72: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
      //   0	83	2	paramap	ap
      //   6	73	3	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   7	21	38	com/google/b/bf
      //   47	59	59	finally
      //   7	21	77	finally
      //   39	47	77	finally
    }
    
    private a Vf(long paramLong)
    {
      AppMethodBeat.i(260196);
      this.VLQ = paramLong;
      onChanged();
      AppMethodBeat.o(260196);
      return this;
    }
    
    private a Vg(long paramLong)
    {
      AppMethodBeat.i(260197);
      this.VLR = paramLong;
      onChanged();
      AppMethodBeat.o(260197);
      return this;
    }
    
    private a a(af paramaf)
    {
      AppMethodBeat.i(260203);
      if (this.VMd == null) {
        if (this.VLV != null)
        {
          this.VLV = af.b(this.VLV).f(paramaf).hEO();
          onChanged();
        }
      }
      for (;;)
      {
        AppMethodBeat.o(260203);
        return this;
        this.VLV = paramaf;
        break;
        this.VMd.c(paramaf);
      }
    }
    
    private a aC(aj.f paramf, Object paramObject)
    {
      AppMethodBeat.i(260189);
      paramf = (a)super.d(paramf, paramObject);
      AppMethodBeat.o(260189);
      return paramf;
    }
    
    private a aD(aj.f paramf, Object paramObject)
    {
      AppMethodBeat.i(260190);
      paramf = (a)super.c(paramf, paramObject);
      AppMethodBeat.o(260190);
      return paramf;
    }
    
    private a aE(da paramda)
    {
      AppMethodBeat.i(260212);
      paramda = (a)super.e(paramda);
      AppMethodBeat.o(260212);
      return paramda;
    }
    
    private a aF(da paramda)
    {
      AppMethodBeat.i(260213);
      paramda = (a)super.d(paramda);
      AppMethodBeat.o(260213);
      return paramda;
    }
    
    private a d(q paramq)
    {
      AppMethodBeat.i(260208);
      if (this.VMf == null) {
        if (this.VLY != null)
        {
          this.VLY = q.j(this.VLY).l(paramq).hDP();
          onChanged();
        }
      }
      for (;;)
      {
        AppMethodBeat.o(260208);
        return this;
        this.VLY = paramq;
        break;
        this.VMf.c(paramq);
      }
    }
    
    private a e(c paramc)
    {
      AppMethodBeat.i(260199);
      if (this.VMb == null) {
        if (this.VLT != null)
        {
          this.VLT = c.a(this.VLT).d(paramc).hCQ();
          onChanged();
        }
      }
      for (;;)
      {
        AppMethodBeat.o(260199);
        return this;
        this.VLT = paramc;
        break;
        this.VMb.c(paramc);
      }
    }
    
    private a e(q paramq)
    {
      AppMethodBeat.i(260210);
      if (this.VLO == null) {
        if (this.VLK != null)
        {
          this.VLK = q.j(this.VLK).l(paramq).hDP();
          onChanged();
        }
      }
      for (;;)
      {
        AppMethodBeat.o(260210);
        return this;
        this.VLK = paramq;
        break;
        this.VLO.c(paramq);
      }
    }
    
    private e hDh()
    {
      AppMethodBeat.i(260185);
      Object localObject = hDi();
      if (!((e)localObject).isInitialized())
      {
        localObject = b((bt)localObject);
        AppMethodBeat.o(260185);
        throw ((Throwable)localObject);
      }
      AppMethodBeat.o(260185);
      return localObject;
    }
    
    private e hDi()
    {
      AppMethodBeat.i(260187);
      e locale = new e(this, (byte)0);
      if (this.VMa == null)
      {
        if ((this.bQS & 0x1) != 0)
        {
          this.VLP = Collections.unmodifiableList(this.VLP);
          this.bQS &= 0xFFFFFFFE;
        }
        e.a(locale, this.VLP);
        e.a(locale, this.VLQ);
        e.b(locale, this.VLR);
        e.a(locale, this.VLS);
        if (this.VMb != null) {
          break label284;
        }
        e.a(locale, this.VLT);
        label106:
        if (this.VMc != null) {
          break label302;
        }
        if ((this.bQS & 0x2) != 0)
        {
          this.VLU = Collections.unmodifiableList(this.VLU);
          this.bQS &= 0xFFFFFFFD;
        }
        e.b(locale, this.VLU);
        label153:
        if (this.VMd != null) {
          break label317;
        }
        e.a(locale, this.VLV);
        label169:
        e.b(locale, this.VLW);
        if (this.VMe != null) {
          break label335;
        }
        if ((this.bQS & 0x4) != 0)
        {
          this.VLX = Collections.unmodifiableList(this.VLX);
          this.bQS &= 0xFFFFFFFB;
        }
        e.c(locale, this.VLX);
        label225:
        if (this.VMf != null) {
          break label350;
        }
        e.a(locale, this.VLY);
        label241:
        if (this.VLO != null) {
          break label368;
        }
        e.b(locale, this.VLK);
      }
      for (;;)
      {
        Ib();
        AppMethodBeat.o(260187);
        return locale;
        e.a(locale, this.VMa.build());
        break;
        label284:
        e.a(locale, (c)this.VMb.IV());
        break label106;
        label302:
        e.b(locale, this.VMc.build());
        break label153;
        label317:
        e.a(locale, (af)this.VMd.IV());
        break label169;
        label335:
        e.c(locale, this.VMe.build());
        break label225;
        label350:
        e.a(locale, (q)this.VMf.IV());
        break label241;
        label368:
        e.b(locale, (q)this.VLO.IV());
      }
    }
    
    private void hDj()
    {
      AppMethodBeat.i(260194);
      if ((this.bQS & 0x1) == 0)
      {
        this.VLP = new ArrayList(this.VLP);
        this.bQS |= 0x1;
      }
      AppMethodBeat.o(260194);
    }
    
    private co<aa, aa.a, ab> hDk()
    {
      AppMethodBeat.i(260195);
      Object localObject;
      if (this.VMa == null)
      {
        localObject = this.VLP;
        if ((this.bQS & 0x1) == 0) {
          break label68;
        }
      }
      label68:
      for (boolean bool = true;; bool = false)
      {
        this.VMa = new co((List)localObject, bool, Ie(), Ic());
        this.VLP = null;
        localObject = this.VMa;
        AppMethodBeat.o(260195);
        return localObject;
      }
    }
    
    private void hDl()
    {
      AppMethodBeat.i(260200);
      if ((this.bQS & 0x2) == 0)
      {
        this.VLU = new ArrayList(this.VLU);
        this.bQS |= 0x2;
      }
      AppMethodBeat.o(260200);
    }
    
    private co<l, l.a, m> hDm()
    {
      AppMethodBeat.i(260202);
      Object localObject;
      if (this.VMc == null)
      {
        localObject = this.VLU;
        if ((this.bQS & 0x2) == 0) {
          break label68;
        }
      }
      label68:
      for (boolean bool = true;; bool = false)
      {
        this.VMc = new co((List)localObject, bool, Ie(), Ic());
        this.VLU = null;
        localObject = this.VMc;
        AppMethodBeat.o(260202);
        return localObject;
      }
    }
    
    private void hDn()
    {
      AppMethodBeat.i(260205);
      if ((this.bQS & 0x4) == 0)
      {
        this.VLX = new ArrayList(this.VLX);
        this.bQS |= 0x4;
      }
      AppMethodBeat.o(260205);
    }
    
    private co<g, g.a, h> hDo()
    {
      AppMethodBeat.i(260206);
      Object localObject;
      if (this.VMe == null)
      {
        localObject = this.VLX;
        if ((this.bQS & 0x4) == 0) {
          break label68;
        }
      }
      label68:
      for (boolean bool = true;; bool = false)
      {
        this.VMe = new co((List)localObject, bool, Ie(), Ic());
        this.VLX = null;
        localObject = this.VMe;
        AppMethodBeat.o(260206);
        return localObject;
      }
    }
    
    public final bb.e Cb()
    {
      AppMethodBeat.i(260176);
      bb.e locale = ae.VOt.b(e.class, a.class);
      AppMethodBeat.o(260176);
      return locale;
    }
    
    public final aj.a Cv()
    {
      return ae.VOs;
    }
    
    public final a e(e parame)
    {
      Object localObject2 = null;
      AppMethodBeat.i(260192);
      if (parame == e.hDc())
      {
        AppMethodBeat.o(260192);
        return this;
      }
      if (this.VMa == null) {
        if (!e.a(parame).isEmpty())
        {
          if (this.VLP.isEmpty())
          {
            this.VLP = e.a(parame);
            this.bQS &= 0xFFFFFFFE;
            onChanged();
          }
        }
        else
        {
          label77:
          if (parame.VLQ != 0L) {
            Vf(parame.VLQ);
          }
          if (parame.VLR != 0L) {
            Vg(parame.VLR);
          }
          if (parame.VLS) {
            EZ(parame.VLS);
          }
          if (parame.hCV()) {
            e(parame.hCW());
          }
          if (this.VMc != null) {
            break label473;
          }
          if (!e.b(parame).isEmpty())
          {
            if (!this.VLU.isEmpty()) {
              break label452;
            }
            this.VLU = e.b(parame);
            this.bQS &= 0xFFFFFFFD;
            label195:
            onChanged();
          }
          label199:
          if (parame.hCX()) {
            a(parame.hCY());
          }
          if (parame.VLW) {
            Fa(parame.VLW);
          }
          if (this.VMe != null) {
            break label587;
          }
          if (!e.c(parame).isEmpty())
          {
            if (!this.VLX.isEmpty()) {
              break label566;
            }
            this.VLX = e.c(parame);
            this.bQS &= 0xFFFFFFFB;
            label281:
            onChanged();
          }
        }
      }
      for (;;)
      {
        if (parame.hCZ()) {
          d(parame.hDa());
        }
        if (parame.hCJ()) {
          e(parame.hCK());
        }
        aF(e.d(parame));
        onChanged();
        AppMethodBeat.o(260192);
        return this;
        hDj();
        this.VLP.addAll(e.a(parame));
        break;
        if (e.a(parame).isEmpty()) {
          break label77;
        }
        Object localObject1;
        if (this.VMa.isEmpty())
        {
          this.VMa.cat = null;
          this.VMa = null;
          this.VLP = e.a(parame);
          this.bQS &= 0xFFFFFFFE;
          if (e.hDd()) {}
          for (localObject1 = hDk();; localObject1 = null)
          {
            this.VMa = ((co)localObject1);
            break;
          }
        }
        this.VMa.a(e.a(parame));
        break label77;
        label452:
        hDl();
        this.VLU.addAll(e.b(parame));
        break label195;
        label473:
        if (e.b(parame).isEmpty()) {
          break label199;
        }
        if (this.VMc.isEmpty())
        {
          this.VMc.cat = null;
          this.VMc = null;
          this.VLU = e.b(parame);
          this.bQS &= 0xFFFFFFFD;
          if (e.hDe()) {}
          for (localObject1 = hDm();; localObject1 = null)
          {
            this.VMc = ((co)localObject1);
            break;
          }
        }
        this.VMc.a(e.b(parame));
        break label199;
        label566:
        hDn();
        this.VLX.addAll(e.c(parame));
        break label281;
        label587:
        if (!e.c(parame).isEmpty()) {
          if (this.VMe.isEmpty())
          {
            this.VMe.cat = null;
            this.VMe = null;
            this.VLX = e.c(parame);
            this.bQS &= 0xFFFFFFFB;
            localObject1 = localObject2;
            if (e.hDf()) {
              localObject1 = hDo();
            }
            this.VMe = ((co)localObject1);
          }
          else
          {
            this.VMe.a(e.c(parame));
          }
        }
      }
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.timelineedit.a.a.e
 * JD-Core Version:    0.7.0.1
 */