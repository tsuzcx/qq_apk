package kotlin.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;
import kotlin.a.ak;
import kotlin.l.b.a.b.b.ab;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.d.b.a.a.a;
import kotlin.l.b.a.b.e.a.b;
import kotlin.l.b.a.b.e.a.k;
import kotlin.l.b.a.b.e.b.c;
import kotlin.l.b.a.b.e.c.a.g;
import kotlin.l.b.a.b.h.k;
import kotlin.l.b.a.b.k.a.l;
import kotlin.l.b.a.b.k.a.t;
import kotlin.o;

public final class e
{
  private static final Set<a.a> Tvu;
  private static final Set<a.a> Tvv;
  private static final kotlin.l.b.a.b.e.c.a.f Tvw;
  private static final kotlin.l.b.a.b.e.c.a.f Tvx;
  private static final kotlin.l.b.a.b.e.c.a.f Tvy;
  public static final a Tvz;
  public l Tvt;
  
  static
  {
    AppMethodBeat.i(58191);
    Tvz = new a((byte)0);
    Tvu = ak.setOf(a.a.Twt);
    Tvv = ak.setOf(new a.a[] { a.a.Twu, a.a.Twx });
    Tvw = new kotlin.l.b.a.b.e.c.a.f(new int[] { 1, 1, 2 });
    Tvx = new kotlin.l.b.a.b.e.c.a.f(new int[] { 1, 1, 11 });
    Tvy = new kotlin.l.b.a.b.e.c.a.f(new int[] { 1, 1, 13 });
    AppMethodBeat.o(58191);
  }
  
  private static String[] a(p paramp, Set<? extends a.a> paramSet)
  {
    AppMethodBeat.i(58190);
    kotlin.l.b.a.b.d.b.a.a locala = paramp.hCA();
    String[] arrayOfString = locala.Two;
    paramp = arrayOfString;
    if (arrayOfString == null) {
      paramp = locala.Twp;
    }
    if (paramp != null)
    {
      if (paramSet.contains(locala.Twl))
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
  
  private final t<kotlin.l.b.a.b.e.c.a.f> b(p paramp)
  {
    AppMethodBeat.i(58187);
    hEi();
    if (paramp.hCA().Twm.hIi())
    {
      AppMethodBeat.o(58187);
      return null;
    }
    paramp = new t((kotlin.l.b.a.b.e.b.a)paramp.hCA().Twm, (kotlin.l.b.a.b.e.b.a)kotlin.l.b.a.b.e.c.a.f.TCE, paramp.getLocation(), paramp.hyy());
    AppMethodBeat.o(58187);
    return paramp;
  }
  
  private final boolean c(p paramp)
  {
    AppMethodBeat.i(58188);
    if (this.Tvt == null) {
      kotlin.g.b.p.btv("components");
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
    if (this.Tvt == null) {
      kotlin.g.b.p.btv("components");
    }
    if ((paramp.hCA().hEq()) && (kotlin.g.b.p.j(paramp.hCA().Twm, Tvx)))
    {
      AppMethodBeat.o(58189);
      return true;
    }
    AppMethodBeat.o(58189);
    return false;
  }
  
  private final boolean hEi()
  {
    AppMethodBeat.i(58184);
    if (this.Tvt == null) {
      kotlin.g.b.p.btv("components");
    }
    AppMethodBeat.o(58184);
    return false;
  }
  
  public final kotlin.l.b.a.b.j.f.h a(ab paramab, p paramp)
  {
    AppMethodBeat.i(58186);
    kotlin.g.b.p.h(paramab, "descriptor");
    kotlin.g.b.p.h(paramp, "kotlinClass");
    Object localObject1 = a(paramp, Tvv);
    if (localObject1 == null)
    {
      AppMethodBeat.o(58186);
      return null;
    }
    Object localObject2 = paramp.hCA().strings;
    if (localObject2 == null)
    {
      AppMethodBeat.o(58186);
      return null;
    }
    try
    {
      localObject1 = kotlin.l.b.a.b.e.c.a.i.f((String[])localObject1, (String[])localObject2);
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
        hEi();
        if (paramp.hCA().Twm.hIi())
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
      paramp = (kotlin.l.b.a.b.e.b.a)paramp.hCA().Twm;
      localObject3 = (kotlin.l.b.a.b.k.a.b.f)localObject3;
      l locall = this.Tvt;
      if (locall == null) {
        kotlin.g.b.p.btv("components");
      }
      paramab = (kotlin.l.b.a.b.j.f.h)new kotlin.l.b.a.b.k.a.b.i(paramab, localk1, (c)localObject2, paramp, (kotlin.l.b.a.b.k.a.b.f)localObject3, locall, (kotlin.g.a.a)e.b.TvA);
      AppMethodBeat.o(58186);
    }
    return paramab;
  }
  
  public final kotlin.l.b.a.b.k.a.h a(p paramp)
  {
    AppMethodBeat.i(58185);
    kotlin.g.b.p.h(paramp, "kotlinClass");
    Object localObject1 = a(paramp, Tvu);
    if (localObject1 == null)
    {
      AppMethodBeat.o(58185);
      return null;
    }
    Object localObject2 = paramp.hCA().strings;
    if (localObject2 == null)
    {
      AppMethodBeat.o(58185);
      return null;
    }
    try
    {
      localObject1 = kotlin.l.b.a.b.e.c.a.i.e((String[])localObject1, (String[])localObject2);
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
        hEi();
        if (paramp.hCA().Twm.hIi())
        {
          AppMethodBeat.o(58185);
          throw localThrowable2;
        }
        localb = null;
      }
      localObject2 = (g)localb.first;
      a.b localb = (a.b)localb.second;
      r localr = new r(paramp, b(paramp), c(paramp));
      paramp = new kotlin.l.b.a.b.k.a.h((c)localObject2, localb, (kotlin.l.b.a.b.e.b.a)paramp.hCA().Twm, (an)localr);
      AppMethodBeat.o(58185);
    }
    return paramp;
  }
  
  public final l hEh()
  {
    AppMethodBeat.i(58183);
    l locall = this.Tvt;
    if (locall == null) {
      kotlin.g.b.p.btv("components");
    }
    AppMethodBeat.o(58183);
    return locall;
  }
  
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.d.b.e
 * JD-Core Version:    0.7.0.1
 */