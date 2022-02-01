package kotlin.l.b.a.b.e.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b.a.b.e.a.b.b;
import kotlin.l.b.a.b.e.a.i;
import kotlin.l.b.a.b.e.a.j;
import kotlin.l.b.a.b.e.a.w;
import kotlin.l.b.a.b.h.j.a;

public final class b
{
  public static final a TAT;
  public static final a TAU;
  public static final c<a.w> TAV;
  public static final c<a.j> TAW;
  public static final c<a.b.b> TAY;
  public static final a TAZ;
  public static final a TBA;
  public static final a TBB;
  public static final a TBC;
  public static final a TBD;
  public static final a TBE;
  public static final a TBa;
  public static final a TBb;
  public static final a TBc;
  public static final a TBd;
  public static final a TBe;
  public static final c<a.i> TBf;
  public static final a TBg;
  public static final a TBh;
  public static final a TBi;
  public static final a TBj;
  public static final a TBk;
  public static final a TBl;
  public static final a TBm;
  public static final a TBn;
  public static final a TBo;
  public static final a TBp;
  public static final a TBq;
  public static final a TBr;
  public static final a TBs;
  public static final a TBt;
  public static final a TBu;
  public static final a TBv;
  public static final a TBw;
  public static final a TBx;
  public static final a TBy;
  public static final a TBz;
  
  static
  {
    AppMethodBeat.i(59061);
    TAT = c.hIk();
    Object localObject = c.hIk();
    TAU = (a)localObject;
    localObject = c.a((c)localObject, a.w.values());
    TAV = (c)localObject;
    localObject = c.a((c)localObject, a.j.values());
    TAW = (c)localObject;
    localObject = c.a((c)localObject, a.b.b.values());
    TAY = (c)localObject;
    localObject = c.a((c)localObject);
    TAZ = (a)localObject;
    localObject = c.a((c)localObject);
    TBa = (a)localObject;
    localObject = c.a((c)localObject);
    TBb = (a)localObject;
    localObject = c.a((c)localObject);
    TBc = (a)localObject;
    TBd = c.a((c)localObject);
    TBe = c.a(TAV);
    localObject = c.a(TAW, a.i.values());
    TBf = (c)localObject;
    localObject = c.a((c)localObject);
    TBg = (a)localObject;
    localObject = c.a((c)localObject);
    TBh = (a)localObject;
    localObject = c.a((c)localObject);
    TBi = (a)localObject;
    localObject = c.a((c)localObject);
    TBj = (a)localObject;
    localObject = c.a((c)localObject);
    TBk = (a)localObject;
    localObject = c.a((c)localObject);
    TBl = (a)localObject;
    TBm = c.a((c)localObject);
    localObject = c.a(TBf);
    TBn = (a)localObject;
    localObject = c.a((c)localObject);
    TBo = (a)localObject;
    localObject = c.a((c)localObject);
    TBp = (a)localObject;
    localObject = c.a((c)localObject);
    TBq = (a)localObject;
    localObject = c.a((c)localObject);
    TBr = (a)localObject;
    localObject = c.a((c)localObject);
    TBs = (a)localObject;
    localObject = c.a((c)localObject);
    TBt = (a)localObject;
    localObject = c.a((c)localObject);
    TBu = (a)localObject;
    TBv = c.a((c)localObject);
    localObject = c.a(TAU);
    TBw = (a)localObject;
    localObject = c.a((c)localObject);
    TBx = (a)localObject;
    TBy = c.a((c)localObject);
    localObject = c.a(TAW);
    TBz = (a)localObject;
    localObject = c.a((c)localObject);
    TBA = (a)localObject;
    TBB = c.a((c)localObject);
    localObject = c.hIk();
    TBC = (a)localObject;
    TBD = c.a((c)localObject);
    TBE = c.hIk();
    AppMethodBeat.o(59061);
  }
  
  public static int a(boolean paramBoolean, a.w paramw, a.j paramj)
  {
    AppMethodBeat.i(59060);
    if (paramw == null) {
      atM(10);
    }
    if (paramj == null) {
      atM(11);
    }
    int i = TAU.x(Boolean.valueOf(paramBoolean));
    int j = TAW.fv(paramj);
    int k = TAV.fv(paramw);
    int m = TBz.x(Boolean.FALSE);
    int n = TBA.x(Boolean.FALSE);
    int i1 = TBB.x(Boolean.FALSE);
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
    
    public final Boolean avk(int paramInt)
    {
      boolean bool = true;
      AppMethodBeat.i(59051);
      if ((1 << this.offset & paramInt) != 0) {}
      for (;;)
      {
        Boolean localBoolean = Boolean.valueOf(bool);
        if (localBoolean == null) {
          hIj();
        }
        AppMethodBeat.o(59051);
        return localBoolean;
        bool = false;
      }
    }
    
    public final int x(Boolean paramBoolean)
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
    private final E[] TBF;
    
    public b(int paramInt, E[] paramArrayOfE)
    {
      super(ai(paramArrayOfE), (byte)0);
      AppMethodBeat.i(59056);
      this.TBF = paramArrayOfE;
      AppMethodBeat.o(59056);
    }
    
    private static <E> int ai(E[] paramArrayOfE)
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
    public final int TBG;
    public final int offset;
    
    private c(int paramInt1, int paramInt2)
    {
      this.offset = paramInt1;
      this.TBG = paramInt2;
    }
    
    public static b.a a(c<?> paramc)
    {
      return new b.a(paramc.offset + paramc.TBG);
    }
    
    public static <E extends j.a> c<E> a(c<?> paramc, E[] paramArrayOfE)
    {
      return new b.b(paramc.offset + paramc.TBG, paramArrayOfE);
    }
    
    public static b.a hIk()
    {
      return new b.a(0);
    }
    
    public abstract int fv(E paramE);
    
    public abstract E get(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.e.b.b
 * JD-Core Version:    0.7.0.1
 */