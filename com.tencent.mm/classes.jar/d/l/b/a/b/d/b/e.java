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
import d.l.b.a.b.h.k;
import d.l.b.a.b.k.a.l;
import d.l.b.a.b.k.a.t;
import d.o;
import java.util.Set;

public final class e
{
  private static final Set<a.a> NiI;
  private static final Set<a.a> NiJ;
  private static final d.l.b.a.b.e.c.a.f NiK;
  private static final d.l.b.a.b.e.c.a.f NiL;
  private static final d.l.b.a.b.e.c.a.f NiM;
  public static final a NiN;
  public l NiH;
  
  static
  {
    AppMethodBeat.i(58191);
    NiN = new a((byte)0);
    NiI = ak.setOf(a.a.NjH);
    NiJ = ak.setOf(new a.a[] { a.a.NjI, a.a.NjL });
    NiK = new d.l.b.a.b.e.c.a.f(new int[] { 1, 1, 2 });
    NiL = new d.l.b.a.b.e.c.a.f(new int[] { 1, 1, 11 });
    NiM = new d.l.b.a.b.e.c.a.f(new int[] { 1, 1, 13 });
    AppMethodBeat.o(58191);
  }
  
  private static String[] a(p paramp, Set<? extends a.a> paramSet)
  {
    AppMethodBeat.i(58190);
    d.l.b.a.b.d.b.a.a locala = paramp.gkw();
    String[] arrayOfString = locala.NjC;
    paramp = arrayOfString;
    if (arrayOfString == null) {
      paramp = locala.NjD;
    }
    if (paramp != null)
    {
      if (paramSet.contains(locala.Njz))
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
    gme();
    if (paramp.gkw().NjA.gqj())
    {
      AppMethodBeat.o(58187);
      return null;
    }
    paramp = new t((d.l.b.a.b.e.b.a)paramp.gkw().NjA, (d.l.b.a.b.e.b.a)d.l.b.a.b.e.c.a.f.NpU, paramp.getLocation(), paramp.ggt());
    AppMethodBeat.o(58187);
    return paramp;
  }
  
  private final boolean c(p paramp)
  {
    AppMethodBeat.i(58188);
    if (this.NiH == null) {
      d.g.b.p.bcb("components");
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
    if (this.NiH == null) {
      d.g.b.p.bcb("components");
    }
    if ((paramp.gkw().gmm()) && (d.g.b.p.i(paramp.gkw().NjA, NiL)))
    {
      AppMethodBeat.o(58189);
      return true;
    }
    AppMethodBeat.o(58189);
    return false;
  }
  
  private final boolean gme()
  {
    AppMethodBeat.i(58184);
    if (this.NiH == null) {
      d.g.b.p.bcb("components");
    }
    AppMethodBeat.o(58184);
    return false;
  }
  
  public final d.l.b.a.b.j.f.h a(ab paramab, p paramp)
  {
    AppMethodBeat.i(58186);
    d.g.b.p.h(paramab, "descriptor");
    d.g.b.p.h(paramp, "kotlinClass");
    Object localObject1 = a(paramp, NiJ);
    if (localObject1 == null)
    {
      AppMethodBeat.o(58186);
      return null;
    }
    Object localObject2 = paramp.gkw().strings;
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
    catch (k localk)
    {
      Throwable localThrowable1 = (Throwable)new IllegalStateException("Could not read data from " + paramp.getLocation(), (Throwable)localk);
      AppMethodBeat.o(58186);
      throw localThrowable1;
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        gme();
        if (paramp.gkw().NjA.gqj())
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
      paramp = (d.l.b.a.b.e.b.a)paramp.gkw().NjA;
      localObject3 = (d.l.b.a.b.k.a.b.f)localObject3;
      l locall = this.NiH;
      if (locall == null) {
        d.g.b.p.bcb("components");
      }
      paramab = (d.l.b.a.b.j.f.h)new d.l.b.a.b.k.a.b.i(paramab, localk1, (c)localObject2, paramp, (d.l.b.a.b.k.a.b.f)localObject3, locall, (d.g.a.a)e.b.NiO);
      AppMethodBeat.o(58186);
    }
    return paramab;
  }
  
  public final d.l.b.a.b.k.a.h a(p paramp)
  {
    AppMethodBeat.i(58185);
    d.g.b.p.h(paramp, "kotlinClass");
    Object localObject1 = a(paramp, NiI);
    if (localObject1 == null)
    {
      AppMethodBeat.o(58185);
      return null;
    }
    Object localObject2 = paramp.gkw().strings;
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
    catch (k localk)
    {
      Throwable localThrowable1 = (Throwable)new IllegalStateException("Could not read data from " + paramp.getLocation(), (Throwable)localk);
      AppMethodBeat.o(58185);
      throw localThrowable1;
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        gme();
        if (paramp.gkw().NjA.gqj())
        {
          AppMethodBeat.o(58185);
          throw localThrowable2;
        }
        localb = null;
      }
      localObject2 = (g)localb.first;
      a.b localb = (a.b)localb.second;
      r localr = new r(paramp, b(paramp), c(paramp));
      paramp = new d.l.b.a.b.k.a.h((c)localObject2, localb, (d.l.b.a.b.e.b.a)paramp.gkw().NjA, (an)localr);
      AppMethodBeat.o(58185);
    }
    return paramp;
  }
  
  public final l gmd()
  {
    AppMethodBeat.i(58183);
    l locall = this.NiH;
    if (locall == null) {
      d.g.b.p.bcb("components");
    }
    AppMethodBeat.o(58183);
    return locall;
  }
  
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.d.b.e
 * JD-Core Version:    0.7.0.1
 */