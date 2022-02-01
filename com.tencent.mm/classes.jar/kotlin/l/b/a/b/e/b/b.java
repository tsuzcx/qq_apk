package kotlin.l.b.a.b.e.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b.a.b.e.a.b.b;
import kotlin.l.b.a.b.e.a.i;
import kotlin.l.b.a.b.e.a.j;
import kotlin.l.b.a.b.e.a.w;
import kotlin.l.b.a.b.h.k.a;

public final class b
{
  public static final a abdI;
  public static final a abdJ;
  public static final c<a.w> abdK;
  public static final c<a.j> abdL;
  public static final c<a.b.b> abdM;
  public static final a abdN;
  public static final a abdO;
  public static final a abdP;
  public static final a abdQ;
  public static final a abdR;
  public static final a abdS;
  public static final c<a.i> abdT;
  public static final a abdU;
  public static final a abdV;
  public static final a abdW;
  public static final a abdX;
  public static final a abdY;
  public static final a abdZ;
  public static final a abea;
  public static final a abeb;
  public static final a abec;
  public static final a abed;
  public static final a abee;
  public static final a abef;
  public static final a abeg;
  public static final a abeh;
  public static final a abei;
  public static final a abej;
  public static final a abek;
  public static final a abel;
  public static final a abem;
  public static final a aben;
  public static final a abeo;
  public static final a abep;
  public static final a abeq;
  public static final a aber;
  public static final a abes;
  
  static
  {
    AppMethodBeat.i(59061);
    abdI = c.iME();
    Object localObject = c.iME();
    abdJ = (a)localObject;
    localObject = c.a((c)localObject, a.w.values());
    abdK = (c)localObject;
    localObject = c.a((c)localObject, a.j.values());
    abdL = (c)localObject;
    localObject = c.a((c)localObject, a.b.b.values());
    abdM = (c)localObject;
    localObject = c.a((c)localObject);
    abdN = (a)localObject;
    localObject = c.a((c)localObject);
    abdO = (a)localObject;
    localObject = c.a((c)localObject);
    abdP = (a)localObject;
    localObject = c.a((c)localObject);
    abdQ = (a)localObject;
    abdR = c.a((c)localObject);
    abdS = c.a(abdK);
    localObject = c.a(abdL, a.i.values());
    abdT = (c)localObject;
    localObject = c.a((c)localObject);
    abdU = (a)localObject;
    localObject = c.a((c)localObject);
    abdV = (a)localObject;
    localObject = c.a((c)localObject);
    abdW = (a)localObject;
    localObject = c.a((c)localObject);
    abdX = (a)localObject;
    localObject = c.a((c)localObject);
    abdY = (a)localObject;
    localObject = c.a((c)localObject);
    abdZ = (a)localObject;
    abea = c.a((c)localObject);
    localObject = c.a(abdT);
    abeb = (a)localObject;
    localObject = c.a((c)localObject);
    abec = (a)localObject;
    localObject = c.a((c)localObject);
    abed = (a)localObject;
    localObject = c.a((c)localObject);
    abee = (a)localObject;
    localObject = c.a((c)localObject);
    abef = (a)localObject;
    localObject = c.a((c)localObject);
    abeg = (a)localObject;
    localObject = c.a((c)localObject);
    abeh = (a)localObject;
    localObject = c.a((c)localObject);
    abei = (a)localObject;
    abej = c.a((c)localObject);
    localObject = c.a(abdJ);
    abek = (a)localObject;
    localObject = c.a((c)localObject);
    abel = (a)localObject;
    abem = c.a((c)localObject);
    localObject = c.a(abdL);
    aben = (a)localObject;
    localObject = c.a((c)localObject);
    abeo = (a)localObject;
    abep = c.a((c)localObject);
    localObject = c.iME();
    abeq = (a)localObject;
    aber = c.a((c)localObject);
    abes = c.iME();
    AppMethodBeat.o(59061);
  }
  
  public static int a(boolean paramBoolean, a.w paramw, a.j paramj)
  {
    AppMethodBeat.i(59060);
    if (paramw == null) {
      aDG(10);
    }
    if (paramj == null) {
      aDG(11);
    }
    int i = abdJ.C(Boolean.valueOf(paramBoolean));
    int j = abdL.fA(paramj);
    int k = abdK.fA(paramw);
    int m = aben.C(Boolean.FALSE);
    int n = abeo.C(Boolean.FALSE);
    int i1 = abep.C(Boolean.FALSE);
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
    
    public final int C(Boolean paramBoolean)
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
    
    public final Boolean aFe(int paramInt)
    {
      boolean bool = true;
      AppMethodBeat.i(59051);
      if ((1 << this.offset & paramInt) != 0) {}
      for (;;)
      {
        Boolean localBoolean = Boolean.valueOf(bool);
        if (localBoolean == null) {
          iMD();
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
    private final E[] abet;
    
    public b(int paramInt, E[] paramArrayOfE)
    {
      super(am(paramArrayOfE), (byte)0);
      AppMethodBeat.i(59056);
      this.abet = paramArrayOfE;
      AppMethodBeat.o(59056);
    }
    
    private static <E> int am(E[] paramArrayOfE)
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
    public final int abeu;
    public final int offset;
    
    private c(int paramInt1, int paramInt2)
    {
      this.offset = paramInt1;
      this.abeu = paramInt2;
    }
    
    public static b.a a(c<?> paramc)
    {
      return new b.a(paramc.offset + paramc.abeu);
    }
    
    public static <E extends k.a> c<E> a(c<?> paramc, E[] paramArrayOfE)
    {
      return new b.b(paramc.offset + paramc.abeu, paramArrayOfE);
    }
    
    public static b.a iME()
    {
      return new b.a(0);
    }
    
    public abstract int fA(E paramE);
    
    public abstract E get(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.e.b.b
 * JD-Core Version:    0.7.0.1
 */