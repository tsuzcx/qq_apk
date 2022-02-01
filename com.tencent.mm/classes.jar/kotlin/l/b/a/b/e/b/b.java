package kotlin.l.b.a.b.e.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b.a.b.e.a.b.b;
import kotlin.l.b.a.b.e.a.i;
import kotlin.l.b.a.b.e.a.j;
import kotlin.l.b.a.b.e.a.w;
import kotlin.l.b.a.b.h.k.a;

public final class b
{
  public static final a ajcA;
  public static final a ajcB;
  public static final a ajcC;
  public static final a ajcD;
  public static final a ajcE;
  public static final a ajcF;
  public static final a ajcG;
  public static final a ajcH;
  public static final a ajcI;
  public static final a ajcJ;
  public static final a ajcK;
  public static final a ajcL;
  public static final a ajcM;
  public static final a ajcN;
  public static final a ajcO;
  public static final a ajcP;
  public static final a ajcQ;
  public static final a ajcR;
  public static final a ajcS;
  public static final a ajcT;
  public static final a ajcU;
  public static final a ajcV;
  public static final a ajcW;
  public static final a ajcX;
  public static final a ajcj;
  public static final a ajck;
  public static final a ajcl;
  public static final c<a.w> ajcm;
  public static final c<a.j> ajcn;
  public static final c<a.b.b> ajco;
  public static final a ajcp;
  public static final a ajcq;
  public static final a ajcr;
  public static final a ajcs;
  public static final a ajct;
  public static final a ajcu;
  public static final a ajcv;
  public static final a ajcw;
  public static final c<a.i> ajcx;
  public static final a ajcy;
  public static final a ajcz;
  
  static
  {
    AppMethodBeat.i(59061);
    Object localObject = c.kwX();
    ajcj = (a)localObject;
    ajck = c.a((c)localObject);
    localObject = c.kwX();
    ajcl = (a)localObject;
    localObject = c.a((c)localObject, a.w.values());
    ajcm = (c)localObject;
    localObject = c.a((c)localObject, a.j.values());
    ajcn = (c)localObject;
    localObject = c.a((c)localObject, a.b.b.values());
    ajco = (c)localObject;
    localObject = c.a((c)localObject);
    ajcp = (a)localObject;
    localObject = c.a((c)localObject);
    ajcq = (a)localObject;
    localObject = c.a((c)localObject);
    ajcr = (a)localObject;
    localObject = c.a((c)localObject);
    ajcs = (a)localObject;
    localObject = c.a((c)localObject);
    ajct = (a)localObject;
    ajcu = c.a((c)localObject);
    localObject = c.a(ajcm);
    ajcv = (a)localObject;
    ajcw = c.a((c)localObject);
    localObject = c.a(ajcn, a.i.values());
    ajcx = (c)localObject;
    localObject = c.a((c)localObject);
    ajcy = (a)localObject;
    localObject = c.a((c)localObject);
    ajcz = (a)localObject;
    localObject = c.a((c)localObject);
    ajcA = (a)localObject;
    localObject = c.a((c)localObject);
    ajcB = (a)localObject;
    localObject = c.a((c)localObject);
    ajcC = (a)localObject;
    localObject = c.a((c)localObject);
    ajcD = (a)localObject;
    localObject = c.a((c)localObject);
    ajcE = (a)localObject;
    ajcF = c.a((c)localObject);
    localObject = c.a(ajcx);
    ajcG = (a)localObject;
    localObject = c.a((c)localObject);
    ajcH = (a)localObject;
    localObject = c.a((c)localObject);
    ajcI = (a)localObject;
    localObject = c.a((c)localObject);
    ajcJ = (a)localObject;
    localObject = c.a((c)localObject);
    ajcK = (a)localObject;
    localObject = c.a((c)localObject);
    ajcL = (a)localObject;
    localObject = c.a((c)localObject);
    ajcM = (a)localObject;
    localObject = c.a((c)localObject);
    ajcN = (a)localObject;
    ajcO = c.a((c)localObject);
    localObject = c.a(ajcl);
    ajcP = (a)localObject;
    localObject = c.a((c)localObject);
    ajcQ = (a)localObject;
    ajcR = c.a((c)localObject);
    localObject = c.a(ajcn);
    ajcS = (a)localObject;
    localObject = c.a((c)localObject);
    ajcT = (a)localObject;
    ajcU = c.a((c)localObject);
    localObject = c.kwX();
    ajcV = (a)localObject;
    ajcW = c.a((c)localObject);
    ajcX = c.kwX();
    AppMethodBeat.o(59061);
  }
  
  public static int a(boolean paramBoolean, a.w paramw, a.j paramj)
  {
    AppMethodBeat.i(59060);
    if (paramw == null) {
      aKu(10);
    }
    if (paramj == null) {
      aKu(11);
    }
    int i = ajcl.O(Boolean.valueOf(paramBoolean));
    int j = ajcn.ia(paramj);
    int k = ajcm.ia(paramw);
    int m = ajcS.O(Boolean.FALSE);
    int n = ajcT.O(Boolean.FALSE);
    int i1 = ajcU.O(Boolean.FALSE);
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
    
    public final int O(Boolean paramBoolean)
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
    
    public final Boolean aLV(int paramInt)
    {
      boolean bool = true;
      AppMethodBeat.i(59051);
      if ((1 << this.offset & paramInt) != 0) {}
      for (;;)
      {
        Boolean localBoolean = Boolean.valueOf(bool);
        if (localBoolean == null) {
          kwW();
        }
        AppMethodBeat.o(59051);
        return localBoolean;
        bool = false;
      }
    }
  }
  
  static final class b<E extends k.a>
    extends b.c<E>
  {
    private final E[] ajcY;
    
    public b(int paramInt, E[] paramArrayOfE)
    {
      super(ar(paramArrayOfE), (byte)0);
      AppMethodBeat.i(59056);
      this.ajcY = paramArrayOfE;
      AppMethodBeat.o(59056);
    }
    
    private static <E> int ar(E[] paramArrayOfE)
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
    public final int ajcZ;
    public final int offset;
    
    private c(int paramInt1, int paramInt2)
    {
      this.offset = paramInt1;
      this.ajcZ = paramInt2;
    }
    
    public static b.a a(c<?> paramc)
    {
      return new b.a(paramc.offset + paramc.ajcZ);
    }
    
    public static <E extends k.a> c<E> a(c<?> paramc, E[] paramArrayOfE)
    {
      return new b.b(paramc.offset + paramc.ajcZ, paramArrayOfE);
    }
    
    public static b.a kwX()
    {
      return new b.a(0);
    }
    
    public abstract E get(int paramInt);
    
    public abstract int ia(E paramE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.e.b.b
 * JD-Core Version:    0.7.0.1
 */