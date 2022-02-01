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
import com.google.b.h;
import com.google.b.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class c
  extends bb
  implements d
{
  private static final c VLL;
  private static final ci<c> bRf;
  private q VLH;
  private List<a> VLI;
  boolean VLJ;
  private q VLK;
  private byte bRd;
  
  static
  {
    AppMethodBeat.i(260154);
    VLL = new c();
    bRf = new com.google.b.c() {};
    AppMethodBeat.o(260154);
  }
  
  private c()
  {
    AppMethodBeat.i(260126);
    this.bRd = -1;
    this.VLI = Collections.emptyList();
    AppMethodBeat.o(260126);
  }
  
  private c(bb.a<?> parama)
  {
    super(parama);
    this.bRd = -1;
  }
  
  private c(h paramh, ap paramap)
  {
    this();
    AppMethodBeat.i(260129);
    if (paramap == null)
    {
      paramh = new NullPointerException();
      AppMethodBeat.o(260129);
      throw paramh;
    }
    da.a locala1 = da.Jj();
    int k = 0;
    int i = 0;
    for (;;)
    {
      label38:
      int n;
      int i1;
      int m;
      if (k == 0)
      {
        n = i;
        i1 = i;
        m = i;
      }
      int j;
      for (;;)
      {
        try
        {
          j = paramh.Av();
          switch (j)
          {
          case 10: 
            n = i;
            i1 = i;
            m = i;
            if (a(paramh, locala1, paramap, j)) {
              break label570;
            }
            j = 1;
            break label592;
            n = i;
            i1 = i;
            m = i;
            if (this.VLH == null) {
              break label583;
            }
            n = i;
            i1 = i;
            m = i;
            locala = this.VLH.hDL();
            n = i;
            i1 = i;
            m = i;
            this.VLH = ((q)paramh.a(q.hCD(), paramap));
            if (locala == null) {
              break label570;
            }
            n = i;
            i1 = i;
            m = i;
            locala.l(this.VLH);
            n = i;
            i1 = i;
            m = i;
            this.VLH = locala.hDP();
            break label38;
          }
        }
        catch (bf paramh)
        {
          try
          {
            paramh.bZj = this;
            AppMethodBeat.o(260129);
            throw paramh;
          }
          finally
          {
            m = n;
            if ((m & 0x1) != 0) {
              this.VLI = Collections.unmodifiableList(this.VLI);
            }
            this.bVW = locala1.Jm();
            HZ();
            AppMethodBeat.o(260129);
          }
          j = i;
          if ((i & 0x1) == 0)
          {
            n = i;
            i1 = i;
            m = i;
            this.VLI = new ArrayList();
            j = i | 0x1;
          }
          n = j;
          i1 = j;
          m = j;
          this.VLI.add(paramh.a(a.hCD(), paramap));
          i = j;
          break;
        }
        catch (IOException paramh)
        {
          m = i1;
          paramh = new bf(paramh);
          m = i1;
          paramh.bZj = this;
          m = i1;
          AppMethodBeat.o(260129);
          m = i1;
          throw paramh;
        }
        finally
        {
          continue;
          n = i;
          i1 = i;
          m = i;
          this.VLJ = paramh.AB();
        }
        break;
        n = i;
        i1 = i;
        m = i;
        if (this.VLK != null)
        {
          n = i;
          i1 = i;
          m = i;
        }
        for (q.a locala = this.VLK.hDL();; locala = null)
        {
          n = i;
          i1 = i;
          m = i;
          this.VLK = ((q)paramh.a(q.hCD(), paramap));
          if (locala != null)
          {
            n = i;
            i1 = i;
            m = i;
            locala.l(this.VLK);
            n = i;
            i1 = i;
            m = i;
            this.VLK = locala.hDP();
            break;
            if ((i & 0x1) != 0) {
              this.VLI = Collections.unmodifiableList(this.VLI);
            }
            this.bVW = locala1.Jm();
            HZ();
            AppMethodBeat.o(260129);
            return;
          }
          label570:
          j = k;
          break label592;
        }
        label583:
        locala = null;
      }
      label592:
      k = j;
      continue;
      k = 1;
    }
  }
  
  public static a a(c paramc)
  {
    AppMethodBeat.i(260142);
    paramc = VLL.hCL().d(paramc);
    AppMethodBeat.o(260142);
    return paramc;
  }
  
  public static ci<c> hCD()
  {
    return bRf;
  }
  
  public static c hCM()
  {
    return VLL;
  }
  
  public final int Ad()
  {
    int j = 0;
    AppMethodBeat.i(260138);
    int i = this.bOZ;
    if (i != -1)
    {
      AppMethodBeat.o(260138);
      return i;
    }
    if (this.VLH != null) {
      i = i.c(1, hCI()) + 0;
    }
    for (;;)
    {
      if (j < this.VLI.size())
      {
        int k = i.c(2, (bw)this.VLI.get(j));
        j += 1;
        i = k + i;
      }
      else
      {
        j = i;
        if (this.VLJ) {
          j = i + i.gK(3);
        }
        i = j;
        if (this.VLK != null) {
          i = j + i.c(4, hCK());
        }
        i = this.bVW.Ad() + i;
        this.bOZ = i;
        AppMethodBeat.o(260138);
        return i;
        i = 0;
      }
    }
  }
  
  public final da Ca()
  {
    return this.bVW;
  }
  
  public final bb.e Cb()
  {
    AppMethodBeat.i(260130);
    bb.e locale = ae.VOl.b(c.class, a.class);
    AppMethodBeat.o(260130);
    return locale;
  }
  
  public final ci<c> Co()
  {
    return bRf;
  }
  
  public final void a(i parami)
  {
    AppMethodBeat.i(260137);
    if (this.VLH != null) {
      parami.a(1, hCI());
    }
    int i = 0;
    while (i < this.VLI.size())
    {
      parami.a(2, (bw)this.VLI.get(i));
      i += 1;
    }
    if (this.VLJ) {
      parami.t(3, this.VLJ);
    }
    if (this.VLK != null) {
      parami.a(4, hCK());
    }
    this.bVW.a(parami);
    AppMethodBeat.o(260137);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(260139);
    if (paramObject == this)
    {
      AppMethodBeat.o(260139);
      return true;
    }
    if (!(paramObject instanceof c))
    {
      boolean bool = super.equals(paramObject);
      AppMethodBeat.o(260139);
      return bool;
    }
    paramObject = (c)paramObject;
    if (hCH() != paramObject.hCH())
    {
      AppMethodBeat.o(260139);
      return false;
    }
    if ((hCH()) && (!hCI().equals(paramObject.hCI())))
    {
      AppMethodBeat.o(260139);
      return false;
    }
    if (!this.VLI.equals(paramObject.VLI))
    {
      AppMethodBeat.o(260139);
      return false;
    }
    if (this.VLJ != paramObject.VLJ)
    {
      AppMethodBeat.o(260139);
      return false;
    }
    if (hCJ() != paramObject.hCJ())
    {
      AppMethodBeat.o(260139);
      return false;
    }
    if ((hCJ()) && (!hCK().equals(paramObject.hCK())))
    {
      AppMethodBeat.o(260139);
      return false;
    }
    if (!this.bVW.equals(paramObject.bVW))
    {
      AppMethodBeat.o(260139);
      return false;
    }
    AppMethodBeat.o(260139);
    return true;
  }
  
  public final boolean hCH()
  {
    return this.VLH != null;
  }
  
  public final q hCI()
  {
    AppMethodBeat.i(260133);
    if (this.VLH == null)
    {
      localq = q.hDM();
      AppMethodBeat.o(260133);
      return localq;
    }
    q localq = this.VLH;
    AppMethodBeat.o(260133);
    return localq;
  }
  
  public final boolean hCJ()
  {
    return this.VLK != null;
  }
  
  public final q hCK()
  {
    AppMethodBeat.i(260135);
    if (this.VLK == null)
    {
      localq = q.hDM();
      AppMethodBeat.o(260135);
      return localq;
    }
    q localq = this.VLK;
    AppMethodBeat.o(260135);
    return localq;
  }
  
  public final a hCL()
  {
    AppMethodBeat.i(260143);
    if (this == VLL)
    {
      locala = new a((byte)0);
      AppMethodBeat.o(260143);
      return locala;
    }
    a locala = new a((byte)0).d(this);
    AppMethodBeat.o(260143);
    return locala;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(260141);
    if (this.bPa != 0)
    {
      i = this.bPa;
      AppMethodBeat.o(260141);
      return i;
    }
    int j = ae.VOk.hashCode() + 779;
    int i = j;
    if (hCH()) {
      i = (j * 37 + 1) * 53 + hCI().hashCode();
    }
    j = i;
    if (this.VLI.size() > 0) {
      j = (i * 37 + 2) * 53 + this.VLI.hashCode();
    }
    j = (j * 37 + 3) * 53 + be.bS(this.VLJ);
    i = j;
    if (hCJ()) {
      i = (j * 37 + 4) * 53 + hCK().hashCode();
    }
    i = i * 29 + this.bVW.hashCode();
    this.bPa = i;
    AppMethodBeat.o(260141);
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
    implements d
  {
    private q VLH;
    private List<a> VLI;
    private boolean VLJ;
    private q VLK;
    private cs<q, q.a, r> VLM;
    private co<a, a.a, b> VLN;
    private cs<q, q.a, r> VLO;
    private int bQS;
    
    private a()
    {
      AppMethodBeat.i(260033);
      this.VLI = Collections.emptyList();
      Cu();
      AppMethodBeat.o(260033);
    }
    
    private a(bb.b paramb)
    {
      super();
      AppMethodBeat.i(260034);
      this.VLI = Collections.emptyList();
      Cu();
      AppMethodBeat.o(260034);
    }
    
    private void Cu()
    {
      AppMethodBeat.i(260035);
      if (c.bXS) {
        hCS();
      }
      AppMethodBeat.o(260035);
    }
    
    private a EY(boolean paramBoolean)
    {
      AppMethodBeat.i(260061);
      this.VLJ = paramBoolean;
      onChanged();
      AppMethodBeat.o(260061);
      return this;
    }
    
    private a N(bt parambt)
    {
      AppMethodBeat.i(260045);
      if ((parambt instanceof c))
      {
        parambt = d((c)parambt);
        AppMethodBeat.o(260045);
        return parambt;
      }
      super.a(parambt);
      AppMethodBeat.o(260045);
      return this;
    }
    
    /* Error */
    private a O(h paramh, ap paramap)
    {
      // Byte code:
      //   0: ldc 93
      //   2: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: invokestatic 97	com/tencent/mm/timelineedit/a/a/c:hCO	()Lcom/google/b/ci;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 102 3 0
      //   17: checkcast 9	com/tencent/mm/timelineedit/a/a/c
      //   20: astore_1
      //   21: aload_1
      //   22: ifnull +9 -> 31
      //   25: aload_0
      //   26: aload_1
      //   27: invokevirtual 85	com/tencent/mm/timelineedit/a/a/c$a:d	(Lcom/tencent/mm/timelineedit/a/a/c;)Lcom/tencent/mm/timelineedit/a/a/c$a;
      //   30: pop
      //   31: ldc 93
      //   33: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   36: aload_0
      //   37: areturn
      //   38: astore_1
      //   39: aload_1
      //   40: getfield 106	com/google/b/bf:bZj	Lcom/google/b/bw;
      //   43: checkcast 9	com/tencent/mm/timelineedit/a/a/c
      //   46: astore_2
      //   47: aload_1
      //   48: invokevirtual 110	com/google/b/bf:Im	()Ljava/io/IOException;
      //   51: astore_1
      //   52: ldc 93
      //   54: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   57: aload_1
      //   58: athrow
      //   59: astore_1
      //   60: aload_2
      //   61: ifnull +9 -> 70
      //   64: aload_0
      //   65: aload_2
      //   66: invokevirtual 85	com/tencent/mm/timelineedit/a/a/c$a:d	(Lcom/tencent/mm/timelineedit/a/a/c;)Lcom/tencent/mm/timelineedit/a/a/c$a;
      //   69: pop
      //   70: ldc 93
      //   72: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   75: aload_1
      //   76: athrow
      //   77: astore_1
      //   78: aload_3
      //   79: astore_2
      //   80: goto -20 -> 60
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	83	0	this	a
      //   0	83	1	paramh	h
      //   0	83	2	paramap	ap
      //   6	73	3	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   7	21	38	com/google/b/bf
      //   47	59	59	finally
      //   7	21	77	finally
      //   39	47	77	finally
    }
    
    private a aA(aj.f paramf, Object paramObject)
    {
      AppMethodBeat.i(260040);
      paramf = (a)super.d(paramf, paramObject);
      AppMethodBeat.o(260040);
      return paramf;
    }
    
    private a aB(aj.f paramf, Object paramObject)
    {
      AppMethodBeat.i(260043);
      paramf = (a)super.c(paramf, paramObject);
      AppMethodBeat.o(260043);
      return paramf;
    }
    
    private a aC(da paramda)
    {
      AppMethodBeat.i(260066);
      paramda = (a)super.e(paramda);
      AppMethodBeat.o(260066);
      return paramda;
    }
    
    private a aD(da paramda)
    {
      AppMethodBeat.i(260068);
      paramda = (a)super.d(paramda);
      AppMethodBeat.o(260068);
      return paramda;
    }
    
    private a b(q paramq)
    {
      AppMethodBeat.i(260054);
      if (this.VLM == null) {
        if (this.VLH != null)
        {
          this.VLH = q.j(this.VLH).l(paramq).hDP();
          onChanged();
        }
      }
      for (;;)
      {
        AppMethodBeat.o(260054);
        return this;
        this.VLH = paramq;
        break;
        this.VLM.c(paramq);
      }
    }
    
    private a c(q paramq)
    {
      AppMethodBeat.i(260063);
      if (this.VLO == null) {
        if (this.VLK != null)
        {
          this.VLK = q.j(this.VLK).l(paramq).hDP();
          onChanged();
        }
      }
      for (;;)
      {
        AppMethodBeat.o(260063);
        return this;
        this.VLK = paramq;
        break;
        this.VLO.c(paramq);
      }
    }
    
    private c hCP()
    {
      AppMethodBeat.i(260036);
      Object localObject = hCQ();
      if (!((c)localObject).isInitialized())
      {
        localObject = b((bt)localObject);
        AppMethodBeat.o(260036);
        throw ((Throwable)localObject);
      }
      AppMethodBeat.o(260036);
      return localObject;
    }
    
    private void hCR()
    {
      AppMethodBeat.i(260057);
      if ((this.bQS & 0x1) == 0)
      {
        this.VLI = new ArrayList(this.VLI);
        this.bQS |= 0x1;
      }
      AppMethodBeat.o(260057);
    }
    
    private co<a, a.a, b> hCS()
    {
      AppMethodBeat.i(260059);
      Object localObject;
      if (this.VLN == null)
      {
        localObject = this.VLI;
        if ((this.bQS & 0x1) == 0) {
          break label66;
        }
      }
      label66:
      for (boolean bool = true;; bool = false)
      {
        this.VLN = new co((List)localObject, bool, Ie(), Ic());
        this.VLI = null;
        localObject = this.VLN;
        AppMethodBeat.o(260059);
        return localObject;
      }
    }
    
    public final bb.e Cb()
    {
      AppMethodBeat.i(260031);
      bb.e locale = ae.VOl.b(c.class, a.class);
      AppMethodBeat.o(260031);
      return locale;
    }
    
    public final aj.a Cv()
    {
      return ae.VOk;
    }
    
    public final a d(c paramc)
    {
      co localco = null;
      AppMethodBeat.i(260048);
      if (paramc == c.hCM())
      {
        AppMethodBeat.o(260048);
        return this;
      }
      if (paramc.hCH()) {
        b(paramc.hCI());
      }
      if (this.VLN == null) {
        if (!c.b(paramc).isEmpty())
        {
          if (!this.VLI.isEmpty()) {
            break label146;
          }
          this.VLI = c.b(paramc);
          this.bQS &= 0xFFFFFFFE;
          onChanged();
        }
      }
      for (;;)
      {
        if (paramc.VLJ) {
          EY(paramc.VLJ);
        }
        if (paramc.hCJ()) {
          c(paramc.hCK());
        }
        aD(c.c(paramc));
        onChanged();
        AppMethodBeat.o(260048);
        return this;
        label146:
        hCR();
        this.VLI.addAll(c.b(paramc));
        break;
        if (!c.b(paramc).isEmpty()) {
          if (this.VLN.isEmpty())
          {
            this.VLN.cat = null;
            this.VLN = null;
            this.VLI = c.b(paramc);
            this.bQS &= 0xFFFFFFFE;
            if (c.hCN()) {
              localco = hCS();
            }
            this.VLN = localco;
          }
          else
          {
            this.VLN.a(c.b(paramc));
          }
        }
      }
    }
    
    public final c hCQ()
    {
      AppMethodBeat.i(260038);
      c localc = new c(this, (byte)0);
      if (this.VLM == null)
      {
        c.a(localc, this.VLH);
        if (this.VLN != null) {
          break label134;
        }
        if ((this.bQS & 0x1) != 0)
        {
          this.VLI = Collections.unmodifiableList(this.VLI);
          this.bQS &= 0xFFFFFFFE;
        }
        c.a(localc, this.VLI);
        label79:
        c.a(localc, this.VLJ);
        if (this.VLO != null) {
          break label149;
        }
        c.b(localc, this.VLK);
      }
      for (;;)
      {
        Ib();
        AppMethodBeat.o(260038);
        return localc;
        c.a(localc, (q)this.VLM.IV());
        break;
        label134:
        c.a(localc, this.VLN.build());
        break label79;
        label149:
        c.b(localc, (q)this.VLO.IV());
      }
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.timelineedit.a.a.c
 * JD-Core Version:    0.7.0.1
 */