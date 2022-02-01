package d.l.b.a.b.e.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.e.a.b.b;
import d.l.b.a.b.e.a.i;
import d.l.b.a.b.e.a.j;
import d.l.b.a.b.e.a.w;
import d.l.b.a.b.h.j.a;

public final class b
{
  public static final a NLA;
  public static final c<a.i> NLB;
  public static final a NLC;
  public static final a NLD;
  public static final a NLE;
  public static final a NLF;
  public static final a NLG;
  public static final a NLH;
  public static final a NLI;
  public static final a NLJ;
  public static final a NLK;
  public static final a NLL;
  public static final a NLM;
  public static final a NLN;
  public static final a NLO;
  public static final a NLP;
  public static final a NLQ;
  public static final a NLR;
  public static final a NLS;
  public static final a NLT;
  public static final a NLU;
  public static final a NLV;
  public static final a NLW;
  public static final a NLX;
  public static final a NLY;
  public static final a NLZ;
  public static final a NLq;
  public static final a NLr;
  public static final c<a.w> NLs;
  public static final c<a.j> NLt;
  public static final c<a.b.b> NLu;
  public static final a NLv;
  public static final a NLw;
  public static final a NLx;
  public static final a NLy;
  public static final a NLz;
  public static final a NMa;
  
  static
  {
    AppMethodBeat.i(59061);
    NLq = c.guN();
    Object localObject = c.guN();
    NLr = (a)localObject;
    localObject = c.a((c)localObject, a.w.values());
    NLs = (c)localObject;
    localObject = c.a((c)localObject, a.j.values());
    NLt = (c)localObject;
    localObject = c.a((c)localObject, a.b.b.values());
    NLu = (c)localObject;
    localObject = c.a((c)localObject);
    NLv = (a)localObject;
    localObject = c.a((c)localObject);
    NLw = (a)localObject;
    localObject = c.a((c)localObject);
    NLx = (a)localObject;
    localObject = c.a((c)localObject);
    NLy = (a)localObject;
    NLz = c.a((c)localObject);
    NLA = c.a(NLs);
    localObject = c.a(NLt, a.i.values());
    NLB = (c)localObject;
    localObject = c.a((c)localObject);
    NLC = (a)localObject;
    localObject = c.a((c)localObject);
    NLD = (a)localObject;
    localObject = c.a((c)localObject);
    NLE = (a)localObject;
    localObject = c.a((c)localObject);
    NLF = (a)localObject;
    localObject = c.a((c)localObject);
    NLG = (a)localObject;
    localObject = c.a((c)localObject);
    NLH = (a)localObject;
    NLI = c.a((c)localObject);
    localObject = c.a(NLB);
    NLJ = (a)localObject;
    localObject = c.a((c)localObject);
    NLK = (a)localObject;
    localObject = c.a((c)localObject);
    NLL = (a)localObject;
    localObject = c.a((c)localObject);
    NLM = (a)localObject;
    localObject = c.a((c)localObject);
    NLN = (a)localObject;
    localObject = c.a((c)localObject);
    NLO = (a)localObject;
    localObject = c.a((c)localObject);
    NLP = (a)localObject;
    localObject = c.a((c)localObject);
    NLQ = (a)localObject;
    NLR = c.a((c)localObject);
    localObject = c.a(NLr);
    NLS = (a)localObject;
    localObject = c.a((c)localObject);
    NLT = (a)localObject;
    NLU = c.a((c)localObject);
    localObject = c.a(NLt);
    NLV = (a)localObject;
    localObject = c.a((c)localObject);
    NLW = (a)localObject;
    NLX = c.a((c)localObject);
    localObject = c.guN();
    NLY = (a)localObject;
    NLZ = c.a((c)localObject);
    NMa = c.guN();
    AppMethodBeat.o(59061);
  }
  
  public static int a(boolean paramBoolean, a.w paramw, a.j paramj)
  {
    AppMethodBeat.i(59060);
    if (paramw == null) {
      ajW(10);
    }
    if (paramj == null) {
      ajW(11);
    }
    int i = NLr.t(Boolean.valueOf(paramBoolean));
    int j = NLt.fq(paramj);
    int k = NLs.fq(paramw);
    int m = NLV.t(Boolean.FALSE);
    int n = NLW.t(Boolean.FALSE);
    int i1 = NLX.t(Boolean.FALSE);
    AppMethodBeat.o(59060);
    return i | j | k | m | n | i1;
  }
  
  public static final class a
    extends b.c<Boolean>
  {
    public a(int paramInt)
    {
      super(1, (byte)0);
    }
    
    public final Boolean alu(int paramInt)
    {
      boolean bool = true;
      AppMethodBeat.i(59051);
      if ((1 << this.offset & paramInt) != 0) {}
      for (;;)
      {
        Boolean localBoolean = Boolean.valueOf(bool);
        if (localBoolean == null) {
          guM();
        }
        AppMethodBeat.o(59051);
        return localBoolean;
        bool = false;
      }
    }
    
    public final int t(Boolean paramBoolean)
    {
      AppMethodBeat.i(59052);
      if (paramBoolean.booleanValue())
      {
        int i = this.offset;
        AppMethodBeat.o(59052);
        return 1 << i;
      }
      AppMethodBeat.o(59052);
      return 0;
    }
  }
  
  static final class b<E extends j.a>
    extends b.c<E>
  {
    private final E[] NMb;
    
    public b(int paramInt, E[] paramArrayOfE)
    {
      super(ag(paramArrayOfE), (byte)0);
      AppMethodBeat.i(59056);
      this.NMb = paramArrayOfE;
      AppMethodBeat.o(59056);
    }
    
    private static <E> int ag(E[] paramArrayOfE)
    {
      AppMethodBeat.i(59057);
      if (paramArrayOfE == null)
      {
        paramArrayOfE = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[] { "enumEntries", "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$EnumLiteFlagField", "bitWidth" }));
        AppMethodBeat.o(59057);
        throw paramArrayOfE;
      }
      int j = paramArrayOfE.length - 1;
      if (j == 0)
      {
        AppMethodBeat.o(59057);
        return 1;
      }
      int i = 31;
      while (i >= 0)
      {
        if ((1 << i & j) != 0)
        {
          AppMethodBeat.o(59057);
          return i + 1;
        }
        i -= 1;
      }
      paramArrayOfE = new IllegalStateException("Empty enum: " + paramArrayOfE.getClass());
      AppMethodBeat.o(59057);
      throw paramArrayOfE;
    }
  }
  
  public static abstract class c<E>
  {
    public final int NMc;
    public final int offset;
    
    private c(int paramInt1, int paramInt2)
    {
      this.offset = paramInt1;
      this.NMc = paramInt2;
    }
    
    public static b.a a(c<?> paramc)
    {
      return new b.a(paramc.offset + paramc.NMc);
    }
    
    public static <E extends j.a> c<E> a(c<?> paramc, E[] paramArrayOfE)
    {
      return new b.b(paramc.offset + paramc.NMc, paramArrayOfE);
    }
    
    public static b.a guN()
    {
      return new b.a(0);
    }
    
    public abstract int fq(E paramE);
    
    public abstract E get(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.e.b.b
 * JD-Core Version:    0.7.0.1
 */