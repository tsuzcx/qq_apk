package d.l.b.a.b.e.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.e.a.b.b;
import d.l.b.a.b.e.a.i;
import d.l.b.a.b.e.a.j;
import d.l.b.a.b.e.a.w;
import d.l.b.a.b.h.j.a;

public final class b
{
  public static final a NoA;
  public static final a NoB;
  public static final a NoC;
  public static final a NoD;
  public static final a NoE;
  public static final a NoF;
  public static final a NoG;
  public static final a NoH;
  public static final a NoI;
  public static final a NoJ;
  public static final a NoK;
  public static final a NoL;
  public static final a NoM;
  public static final a NoN;
  public static final a NoO;
  public static final a NoP;
  public static final a NoQ;
  public static final a NoR;
  public static final a NoS;
  public static final a NoT;
  public static final a NoU;
  public static final a Nok;
  public static final a Nol;
  public static final c<a.w> Nom;
  public static final c<a.j> Non;
  public static final c<a.b.b> Noo;
  public static final a Nop;
  public static final a Noq;
  public static final a Nor;
  public static final a Nos;
  public static final a Not;
  public static final a Nou;
  public static final c<a.i> Nov;
  public static final a Now;
  public static final a Nox;
  public static final a Noy;
  public static final a Noz;
  
  static
  {
    AppMethodBeat.i(59061);
    Nok = c.gql();
    Object localObject = c.gql();
    Nol = (a)localObject;
    localObject = c.a((c)localObject, a.w.values());
    Nom = (c)localObject;
    localObject = c.a((c)localObject, a.j.values());
    Non = (c)localObject;
    localObject = c.a((c)localObject, a.b.b.values());
    Noo = (c)localObject;
    localObject = c.a((c)localObject);
    Nop = (a)localObject;
    localObject = c.a((c)localObject);
    Noq = (a)localObject;
    localObject = c.a((c)localObject);
    Nor = (a)localObject;
    localObject = c.a((c)localObject);
    Nos = (a)localObject;
    Not = c.a((c)localObject);
    Nou = c.a(Nom);
    localObject = c.a(Non, a.i.values());
    Nov = (c)localObject;
    localObject = c.a((c)localObject);
    Now = (a)localObject;
    localObject = c.a((c)localObject);
    Nox = (a)localObject;
    localObject = c.a((c)localObject);
    Noy = (a)localObject;
    localObject = c.a((c)localObject);
    Noz = (a)localObject;
    localObject = c.a((c)localObject);
    NoA = (a)localObject;
    localObject = c.a((c)localObject);
    NoB = (a)localObject;
    NoC = c.a((c)localObject);
    localObject = c.a(Nov);
    NoD = (a)localObject;
    localObject = c.a((c)localObject);
    NoE = (a)localObject;
    localObject = c.a((c)localObject);
    NoF = (a)localObject;
    localObject = c.a((c)localObject);
    NoG = (a)localObject;
    localObject = c.a((c)localObject);
    NoH = (a)localObject;
    localObject = c.a((c)localObject);
    NoI = (a)localObject;
    localObject = c.a((c)localObject);
    NoJ = (a)localObject;
    localObject = c.a((c)localObject);
    NoK = (a)localObject;
    NoL = c.a((c)localObject);
    localObject = c.a(Nol);
    NoM = (a)localObject;
    localObject = c.a((c)localObject);
    NoN = (a)localObject;
    NoO = c.a((c)localObject);
    localObject = c.a(Non);
    NoP = (a)localObject;
    localObject = c.a((c)localObject);
    NoQ = (a)localObject;
    NoR = c.a((c)localObject);
    localObject = c.gql();
    NoS = (a)localObject;
    NoT = c.a((c)localObject);
    NoU = c.gql();
    AppMethodBeat.o(59061);
  }
  
  public static int a(boolean paramBoolean, a.w paramw, a.j paramj)
  {
    AppMethodBeat.i(59060);
    if (paramw == null) {
      ajm(10);
    }
    if (paramj == null) {
      ajm(11);
    }
    int i = Nol.t(Boolean.valueOf(paramBoolean));
    int j = Non.fn(paramj);
    int k = Nom.fn(paramw);
    int m = NoP.t(Boolean.FALSE);
    int n = NoQ.t(Boolean.FALSE);
    int i1 = NoR.t(Boolean.FALSE);
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
    
    public final Boolean akK(int paramInt)
    {
      boolean bool = true;
      AppMethodBeat.i(59051);
      if ((1 << this.offset & paramInt) != 0) {}
      for (;;)
      {
        Boolean localBoolean = Boolean.valueOf(bool);
        if (localBoolean == null) {
          gqk();
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
    private final E[] NoV;
    
    public b(int paramInt, E[] paramArrayOfE)
    {
      super(ah(paramArrayOfE), (byte)0);
      AppMethodBeat.i(59056);
      this.NoV = paramArrayOfE;
      AppMethodBeat.o(59056);
    }
    
    private static <E> int ah(E[] paramArrayOfE)
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
    public final int NoW;
    public final int offset;
    
    private c(int paramInt1, int paramInt2)
    {
      this.offset = paramInt1;
      this.NoW = paramInt2;
    }
    
    public static b.a a(c<?> paramc)
    {
      return new b.a(paramc.offset + paramc.NoW);
    }
    
    public static <E extends j.a> c<E> a(c<?> paramc, E[] paramArrayOfE)
    {
      return new b.b(paramc.offset + paramc.NoW, paramArrayOfE);
    }
    
    public static b.a gql()
    {
      return new b.a(0);
    }
    
    public abstract int fn(E paramE);
    
    public abstract E get(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.e.b.b
 * JD-Core Version:    0.7.0.1
 */