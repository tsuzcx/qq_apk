package d.l.b.a.b.e.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.e.a.b.b;
import d.l.b.a.b.e.a.i;
import d.l.b.a.b.e.a.j;
import d.l.b.a.b.e.a.w;
import d.l.b.a.b.h.j.a;

public final class b
{
  public static final a JJU;
  public static final a JJV;
  public static final c<a.w> JJW;
  public static final c<a.j> JJX;
  public static final c<a.b.b> JJY;
  public static final a JJZ;
  public static final a JKA;
  public static final a JKB;
  public static final a JKC;
  public static final a JKD;
  public static final a JKE;
  public static final a JKa;
  public static final a JKb;
  public static final a JKc;
  public static final a JKd;
  public static final a JKe;
  public static final c<a.i> JKf;
  public static final a JKg;
  public static final a JKh;
  public static final a JKi;
  public static final a JKj;
  public static final a JKk;
  public static final a JKl;
  public static final a JKm;
  public static final a JKn;
  public static final a JKo;
  public static final a JKp;
  public static final a JKq;
  public static final a JKr;
  public static final a JKs;
  public static final a JKt;
  public static final a JKu;
  public static final a JKv;
  public static final a JKw;
  public static final a JKx;
  public static final a JKy;
  public static final a JKz;
  
  static
  {
    AppMethodBeat.i(59061);
    JJU = c.fGi();
    Object localObject = c.fGi();
    JJV = (a)localObject;
    localObject = c.a((c)localObject, a.w.values());
    JJW = (c)localObject;
    localObject = c.a((c)localObject, a.j.values());
    JJX = (c)localObject;
    localObject = c.a((c)localObject, a.b.b.values());
    JJY = (c)localObject;
    localObject = c.a((c)localObject);
    JJZ = (a)localObject;
    localObject = c.a((c)localObject);
    JKa = (a)localObject;
    localObject = c.a((c)localObject);
    JKb = (a)localObject;
    localObject = c.a((c)localObject);
    JKc = (a)localObject;
    JKd = c.a((c)localObject);
    JKe = c.a(JJW);
    localObject = c.a(JJX, a.i.values());
    JKf = (c)localObject;
    localObject = c.a((c)localObject);
    JKg = (a)localObject;
    localObject = c.a((c)localObject);
    JKh = (a)localObject;
    localObject = c.a((c)localObject);
    JKi = (a)localObject;
    localObject = c.a((c)localObject);
    JKj = (a)localObject;
    localObject = c.a((c)localObject);
    JKk = (a)localObject;
    localObject = c.a((c)localObject);
    JKl = (a)localObject;
    JKm = c.a((c)localObject);
    localObject = c.a(JKf);
    JKn = (a)localObject;
    localObject = c.a((c)localObject);
    JKo = (a)localObject;
    localObject = c.a((c)localObject);
    JKp = (a)localObject;
    localObject = c.a((c)localObject);
    JKq = (a)localObject;
    localObject = c.a((c)localObject);
    JKr = (a)localObject;
    localObject = c.a((c)localObject);
    JKs = (a)localObject;
    localObject = c.a((c)localObject);
    JKt = (a)localObject;
    localObject = c.a((c)localObject);
    JKu = (a)localObject;
    JKv = c.a((c)localObject);
    localObject = c.a(JJV);
    JKw = (a)localObject;
    localObject = c.a((c)localObject);
    JKx = (a)localObject;
    JKy = c.a((c)localObject);
    localObject = c.a(JJX);
    JKz = (a)localObject;
    localObject = c.a((c)localObject);
    JKA = (a)localObject;
    JKB = c.a((c)localObject);
    localObject = c.fGi();
    JKC = (a)localObject;
    JKD = c.a((c)localObject);
    JKE = c.fGi();
    AppMethodBeat.o(59061);
  }
  
  public static int a(boolean paramBoolean, a.w paramw, a.j paramj)
  {
    AppMethodBeat.i(59060);
    if (paramw == null) {
      adP(10);
    }
    if (paramj == null) {
      adP(11);
    }
    int i = JJV.q(Boolean.valueOf(paramBoolean));
    int j = JJX.fi(paramj);
    int k = JJW.fi(paramw);
    int m = JKz.q(Boolean.FALSE);
    int n = JKA.q(Boolean.FALSE);
    int i1 = JKB.q(Boolean.FALSE);
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
    
    public final Boolean afn(int paramInt)
    {
      boolean bool = true;
      AppMethodBeat.i(59051);
      if ((1 << this.offset & paramInt) != 0) {}
      for (;;)
      {
        Boolean localBoolean = Boolean.valueOf(bool);
        if (localBoolean == null) {
          fGh();
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
    private final E[] JKF;
    
    public b(int paramInt, E[] paramArrayOfE)
    {
      super(ae(paramArrayOfE), (byte)0);
      AppMethodBeat.i(59056);
      this.JKF = paramArrayOfE;
      AppMethodBeat.o(59056);
    }
    
    private static <E> int ae(E[] paramArrayOfE)
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
    public final int JKG;
    public final int offset;
    
    private c(int paramInt1, int paramInt2)
    {
      this.offset = paramInt1;
      this.JKG = paramInt2;
    }
    
    public static b.a a(c<?> paramc)
    {
      return new b.a(paramc.offset + paramc.JKG);
    }
    
    public static <E extends j.a> c<E> a(c<?> paramc, E[] paramArrayOfE)
    {
      return new b.b(paramc.offset + paramc.JKG, paramArrayOfE);
    }
    
    public static b.a fGi()
    {
      return new b.a(0);
    }
    
    public abstract int fi(E paramE);
    
    public abstract E get(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.e.b.b
 * JD-Core Version:    0.7.0.1
 */