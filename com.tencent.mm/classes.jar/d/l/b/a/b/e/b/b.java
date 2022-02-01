package d.l.b.a.b.e.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.e.a.b.b;
import d.l.b.a.b.e.a.i;
import d.l.b.a.b.e.a.j;
import d.l.b.a.b.e.a.w;
import d.l.b.a.b.h.j.a;

public final class b
{
  public static final a LxA;
  public static final a LxB;
  public static final a LxC;
  public static final a LxD;
  public static final a LxE;
  public static final a LxF;
  public static final a LxG;
  public static final a LxH;
  public static final a LxI;
  public static final a LxJ;
  public static final a LxK;
  public static final a LxL;
  public static final a LxM;
  public static final a LxN;
  public static final a LxO;
  public static final a LxP;
  public static final a LxQ;
  public static final a LxR;
  public static final a LxS;
  public static final a LxT;
  public static final a LxU;
  public static final a LxV;
  public static final a LxW;
  public static final a LxX;
  public static final a Lxn;
  public static final a Lxo;
  public static final c<a.w> Lxp;
  public static final c<a.j> Lxq;
  public static final c<a.b.b> Lxr;
  public static final a Lxs;
  public static final a Lxt;
  public static final a Lxu;
  public static final a Lxv;
  public static final a Lxw;
  public static final a Lxx;
  public static final c<a.i> Lxy;
  public static final a Lxz;
  
  static
  {
    AppMethodBeat.i(59061);
    Lxn = c.fYM();
    Object localObject = c.fYM();
    Lxo = (a)localObject;
    localObject = c.a((c)localObject, a.w.values());
    Lxp = (c)localObject;
    localObject = c.a((c)localObject, a.j.values());
    Lxq = (c)localObject;
    localObject = c.a((c)localObject, a.b.b.values());
    Lxr = (c)localObject;
    localObject = c.a((c)localObject);
    Lxs = (a)localObject;
    localObject = c.a((c)localObject);
    Lxt = (a)localObject;
    localObject = c.a((c)localObject);
    Lxu = (a)localObject;
    localObject = c.a((c)localObject);
    Lxv = (a)localObject;
    Lxw = c.a((c)localObject);
    Lxx = c.a(Lxp);
    localObject = c.a(Lxq, a.i.values());
    Lxy = (c)localObject;
    localObject = c.a((c)localObject);
    Lxz = (a)localObject;
    localObject = c.a((c)localObject);
    LxA = (a)localObject;
    localObject = c.a((c)localObject);
    LxB = (a)localObject;
    localObject = c.a((c)localObject);
    LxC = (a)localObject;
    localObject = c.a((c)localObject);
    LxD = (a)localObject;
    localObject = c.a((c)localObject);
    LxE = (a)localObject;
    LxF = c.a((c)localObject);
    localObject = c.a(Lxy);
    LxG = (a)localObject;
    localObject = c.a((c)localObject);
    LxH = (a)localObject;
    localObject = c.a((c)localObject);
    LxI = (a)localObject;
    localObject = c.a((c)localObject);
    LxJ = (a)localObject;
    localObject = c.a((c)localObject);
    LxK = (a)localObject;
    localObject = c.a((c)localObject);
    LxL = (a)localObject;
    localObject = c.a((c)localObject);
    LxM = (a)localObject;
    localObject = c.a((c)localObject);
    LxN = (a)localObject;
    LxO = c.a((c)localObject);
    localObject = c.a(Lxo);
    LxP = (a)localObject;
    localObject = c.a((c)localObject);
    LxQ = (a)localObject;
    LxR = c.a((c)localObject);
    localObject = c.a(Lxq);
    LxS = (a)localObject;
    localObject = c.a((c)localObject);
    LxT = (a)localObject;
    LxU = c.a((c)localObject);
    localObject = c.fYM();
    LxV = (a)localObject;
    LxW = c.a((c)localObject);
    LxX = c.fYM();
    AppMethodBeat.o(59061);
  }
  
  public static int a(boolean paramBoolean, a.w paramw, a.j paramj)
  {
    AppMethodBeat.i(59060);
    if (paramw == null) {
      agL(10);
    }
    if (paramj == null) {
      agL(11);
    }
    int i = Lxo.q(Boolean.valueOf(paramBoolean));
    int j = Lxq.fl(paramj);
    int k = Lxp.fl(paramw);
    int m = LxS.q(Boolean.FALSE);
    int n = LxT.q(Boolean.FALSE);
    int i1 = LxU.q(Boolean.FALSE);
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
    
    public final Boolean aij(int paramInt)
    {
      boolean bool = true;
      AppMethodBeat.i(59051);
      if ((1 << this.offset & paramInt) != 0) {}
      for (;;)
      {
        Boolean localBoolean = Boolean.valueOf(bool);
        if (localBoolean == null) {
          fYL();
        }
        AppMethodBeat.o(59051);
        return localBoolean;
        bool = false;
      }
    }
    
    public final int q(Boolean paramBoolean)
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
    private final E[] LxY;
    
    public b(int paramInt, E[] paramArrayOfE)
    {
      super(ag(paramArrayOfE), (byte)0);
      AppMethodBeat.i(59056);
      this.LxY = paramArrayOfE;
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
    public final int LxZ;
    public final int offset;
    
    private c(int paramInt1, int paramInt2)
    {
      this.offset = paramInt1;
      this.LxZ = paramInt2;
    }
    
    public static b.a a(c<?> paramc)
    {
      return new b.a(paramc.offset + paramc.LxZ);
    }
    
    public static <E extends j.a> c<E> a(c<?> paramc, E[] paramArrayOfE)
    {
      return new b.b(paramc.offset + paramc.LxZ, paramArrayOfE);
    }
    
    public static b.a fYM()
    {
      return new b.a(0);
    }
    
    public abstract int fl(E paramE);
    
    public abstract E get(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.e.b.b
 * JD-Core Version:    0.7.0.1
 */