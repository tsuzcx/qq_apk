package d.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ak;
import d.l.b.a.b.b.ab;
import d.l.b.a.b.b.an;
import d.l.b.a.b.d.b.a.a.a;
import d.l.b.a.b.e.a.b;
import d.l.b.a.b.e.a.k;
import d.l.b.a.b.e.b.c;
import d.l.b.a.b.e.c.a.g;
import d.l.b.a.b.k.a.t;
import d.o;
import java.util.List;
import java.util.Set;

public final class e
{
  private static final Set<a.a> LrL;
  private static final Set<a.a> LrM;
  private static final d.l.b.a.b.e.c.a.f LrN;
  private static final d.l.b.a.b.e.c.a.f LrO;
  private static final d.l.b.a.b.e.c.a.f LrP;
  public static final a LrQ;
  public d.l.b.a.b.k.a.l LrK;
  
  static
  {
    AppMethodBeat.i(58191);
    LrQ = new a((byte)0);
    LrL = ak.setOf(a.a.LsK);
    LrM = ak.setOf(new a.a[] { a.a.LsL, a.a.LsO });
    LrN = new d.l.b.a.b.e.c.a.f(new int[] { 1, 1, 2 });
    LrO = new d.l.b.a.b.e.c.a.f(new int[] { 1, 1, 11 });
    LrP = new d.l.b.a.b.e.c.a.f(new int[] { 1, 1, 13 });
    AppMethodBeat.o(58191);
  }
  
  private static String[] a(p paramp, Set<? extends a.a> paramSet)
  {
    AppMethodBeat.i(58190);
    d.l.b.a.b.d.b.a.a locala = paramp.fSX();
    String[] arrayOfString = locala.LsF;
    paramp = arrayOfString;
    if (arrayOfString == null) {
      paramp = locala.LsG;
    }
    if (paramp != null)
    {
      if (paramSet.contains(locala.LsC))
      {
        AppMethodBeat.o(58190);
        return paramp;
      }
      AppMethodBeat.o(58190);
      return null;
    }
    AppMethodBeat.o(58190);
    return null;
  }
  
  private final t<d.l.b.a.b.e.c.a.f> b(p paramp)
  {
    AppMethodBeat.i(58187);
    fUF();
    if (paramp.fSX().LsD.fYK())
    {
      AppMethodBeat.o(58187);
      return null;
    }
    paramp = new t((d.l.b.a.b.e.b.a)paramp.fSX().LsD, (d.l.b.a.b.e.b.a)d.l.b.a.b.e.c.a.f.LyX, paramp.getLocation(), paramp.fOT());
    AppMethodBeat.o(58187);
    return paramp;
  }
  
  private final boolean c(p paramp)
  {
    AppMethodBeat.i(58188);
    if (this.LrK == null) {
      d.g.b.k.aVY("components");
    }
    if (d(paramp))
    {
      AppMethodBeat.o(58188);
      return true;
    }
    AppMethodBeat.o(58188);
    return false;
  }
  
  private final boolean d(p paramp)
  {
    AppMethodBeat.i(58189);
    if (this.LrK == null) {
      d.g.b.k.aVY("components");
    }
    if ((paramp.fSX().fUN()) && (d.g.b.k.g(paramp.fSX().LsD, LrO)))
    {
      AppMethodBeat.o(58189);
      return true;
    }
    AppMethodBeat.o(58189);
    return false;
  }
  
  private final boolean fUF()
  {
    AppMethodBeat.i(58184);
    if (this.LrK == null) {
      d.g.b.k.aVY("components");
    }
    AppMethodBeat.o(58184);
    return false;
  }
  
  public final d.l.b.a.b.j.f.h a(ab paramab, p paramp)
  {
    AppMethodBeat.i(58186);
    d.g.b.k.h(paramab, "descriptor");
    d.g.b.k.h(paramp, "kotlinClass");
    Object localObject1 = a(paramp, LrM);
    if (localObject1 == null)
    {
      AppMethodBeat.o(58186);
      return null;
    }
    Object localObject2 = paramp.fSX().strings;
    if (localObject2 == null)
    {
      AppMethodBeat.o(58186);
      return null;
    }
    try
    {
      localObject1 = d.l.b.a.b.e.c.a.i.f((String[])localObject1, (String[])localObject2);
      if (localObject1 == null)
      {
        AppMethodBeat.o(58186);
        return null;
      }
    }
    catch (d.l.b.a.b.h.k localk)
    {
      Throwable localThrowable1 = (Throwable)new IllegalStateException("Could not read data from " + paramp.getLocation(), (Throwable)localk);
      AppMethodBeat.o(58186);
      throw localThrowable1;
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        fUF();
        if (paramp.fSX().LsD.fYK())
        {
          AppMethodBeat.o(58186);
          throw localThrowable2;
        }
        localk1 = null;
      }
      localObject2 = (g)localk1.first;
      a.k localk1 = (a.k)localk1.second;
      Object localObject3 = new j(paramp, localk1, (c)localObject2, b(paramp), c(paramp));
      localObject2 = (c)localObject2;
      paramp = (d.l.b.a.b.e.b.a)paramp.fSX().LsD;
      localObject3 = (d.l.b.a.b.k.a.b.f)localObject3;
      d.l.b.a.b.k.a.l locall = this.LrK;
      if (locall == null) {
        d.g.b.k.aVY("components");
      }
      paramab = (d.l.b.a.b.j.f.h)new d.l.b.a.b.k.a.b.i(paramab, localk1, (c)localObject2, paramp, (d.l.b.a.b.k.a.b.f)localObject3, locall, (d.g.a.a)b.LrR);
      AppMethodBeat.o(58186);
    }
    return paramab;
  }
  
  public final d.l.b.a.b.k.a.h a(p paramp)
  {
    AppMethodBeat.i(58185);
    d.g.b.k.h(paramp, "kotlinClass");
    Object localObject1 = a(paramp, LrL);
    if (localObject1 == null)
    {
      AppMethodBeat.o(58185);
      return null;
    }
    Object localObject2 = paramp.fSX().strings;
    if (localObject2 == null)
    {
      AppMethodBeat.o(58185);
      return null;
    }
    try
    {
      localObject1 = d.l.b.a.b.e.c.a.i.e((String[])localObject1, (String[])localObject2);
      if (localObject1 == null)
      {
        AppMethodBeat.o(58185);
        return null;
      }
    }
    catch (d.l.b.a.b.h.k localk)
    {
      Throwable localThrowable1 = (Throwable)new IllegalStateException("Could not read data from " + paramp.getLocation(), (Throwable)localk);
      AppMethodBeat.o(58185);
      throw localThrowable1;
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        fUF();
        if (paramp.fSX().LsD.fYK())
        {
          AppMethodBeat.o(58185);
          throw localThrowable2;
        }
        localb = null;
      }
      localObject2 = (g)localb.first;
      a.b localb = (a.b)localb.second;
      r localr = new r(paramp, b(paramp), c(paramp));
      paramp = new d.l.b.a.b.k.a.h((c)localObject2, localb, (d.l.b.a.b.e.b.a)paramp.fSX().LsD, (an)localr);
      AppMethodBeat.o(58185);
    }
    return paramp;
  }
  
  public final d.l.b.a.b.k.a.l fUE()
  {
    AppMethodBeat.i(58183);
    d.l.b.a.b.k.a.l locall = this.LrK;
    if (locall == null) {
      d.g.b.k.aVY("components");
    }
    AppMethodBeat.o(58183);
    return locall;
  }
  
  public static final class a {}
  
  static final class b
    extends d.g.b.l
    implements d.g.a.a<List<? extends d.l.b.a.b.f.f>>
  {
    public static final b LrR;
    
    static
    {
      AppMethodBeat.i(58182);
      LrR = new b();
      AppMethodBeat.o(58182);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.d.b.e
 * JD-Core Version:    0.7.0.1
 */