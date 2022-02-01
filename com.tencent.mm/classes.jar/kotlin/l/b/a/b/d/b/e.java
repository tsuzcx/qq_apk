package kotlin.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.ab;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.d.b.a.a.a;
import kotlin.l.b.a.b.e.a.b;
import kotlin.l.b.a.b.e.a.k;
import kotlin.l.b.a.b.e.b.c;
import kotlin.l.b.a.b.e.c.a.g;
import kotlin.l.b.a.b.k.a.t;
import kotlin.o;

public final class e
{
  private static final Set<a.a> aaYn;
  private static final Set<a.a> aaYo;
  private static final kotlin.l.b.a.b.e.c.a.f aaYp;
  private static final kotlin.l.b.a.b.e.c.a.f aaYq;
  private static final kotlin.l.b.a.b.e.c.a.f aaYr;
  public static final a aaYs;
  public kotlin.l.b.a.b.k.a.l aaYm;
  
  static
  {
    AppMethodBeat.i(58191);
    aaYs = new a((byte)0);
    aaYn = ak.setOf(a.a.aaZk);
    aaYo = ak.setOf(new a.a[] { a.a.aaZl, a.a.aaZo });
    aaYp = new kotlin.l.b.a.b.e.c.a.f(new int[] { 1, 1, 2 });
    aaYq = new kotlin.l.b.a.b.e.c.a.f(new int[] { 1, 1, 11 });
    aaYr = new kotlin.l.b.a.b.e.c.a.f(new int[] { 1, 1, 13 });
    AppMethodBeat.o(58191);
  }
  
  private static String[] a(p paramp, Set<? extends a.a> paramSet)
  {
    AppMethodBeat.i(58190);
    kotlin.l.b.a.b.d.b.a.a locala = paramp.iGR();
    String[] arrayOfString = locala.aaZe;
    paramp = arrayOfString;
    if (arrayOfString == null) {
      paramp = locala.aaZf;
    }
    if (paramp != null)
    {
      if (paramSet.contains(locala.aaZb))
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
    iID();
    if (paramp.iGR().aaZc.iMC())
    {
      AppMethodBeat.o(58187);
      return null;
    }
    paramp = new t((kotlin.l.b.a.b.e.b.a)paramp.iGR().aaZc, (kotlin.l.b.a.b.e.b.a)kotlin.l.b.a.b.e.c.a.f.abfs, paramp.getLocation(), paramp.iCJ());
    AppMethodBeat.o(58187);
    return paramp;
  }
  
  private final boolean c(p paramp)
  {
    AppMethodBeat.i(58188);
    if (this.aaYm == null) {
      kotlin.g.b.p.bGy("components");
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
    if (this.aaYm == null) {
      kotlin.g.b.p.bGy("components");
    }
    if ((paramp.iGR().iIK()) && (kotlin.g.b.p.h(paramp.iGR().aaZc, aaYq)))
    {
      AppMethodBeat.o(58189);
      return true;
    }
    AppMethodBeat.o(58189);
    return false;
  }
  
  private final boolean iID()
  {
    AppMethodBeat.i(58184);
    if (this.aaYm == null) {
      kotlin.g.b.p.bGy("components");
    }
    AppMethodBeat.o(58184);
    return false;
  }
  
  public final kotlin.l.b.a.b.j.f.h a(ab paramab, p paramp)
  {
    AppMethodBeat.i(58186);
    kotlin.g.b.p.k(paramab, "descriptor");
    kotlin.g.b.p.k(paramp, "kotlinClass");
    Object localObject1 = a(paramp, aaYo);
    if (localObject1 == null)
    {
      AppMethodBeat.o(58186);
      return null;
    }
    Object localObject2 = paramp.iGR().aaZg;
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
    catch (kotlin.l.b.a.b.h.l locall)
    {
      Throwable localThrowable1 = (Throwable)new IllegalStateException("Could not read data from " + paramp.getLocation(), (Throwable)locall);
      AppMethodBeat.o(58186);
      throw localThrowable1;
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        iID();
        if (paramp.iGR().aaZc.iMC())
        {
          AppMethodBeat.o(58186);
          throw localThrowable2;
        }
        localk = null;
      }
      localObject2 = (g)localk.Mx;
      a.k localk = (a.k)localk.My;
      Object localObject3 = new j(paramp, localk, (c)localObject2, b(paramp), c(paramp));
      localObject2 = (c)localObject2;
      paramp = (kotlin.l.b.a.b.e.b.a)paramp.iGR().aaZc;
      localObject3 = (kotlin.l.b.a.b.k.a.b.f)localObject3;
      kotlin.l.b.a.b.k.a.l locall1 = this.aaYm;
      if (locall1 == null) {
        kotlin.g.b.p.bGy("components");
      }
      paramab = (kotlin.l.b.a.b.j.f.h)new kotlin.l.b.a.b.k.a.b.i(paramab, localk, (c)localObject2, paramp, (kotlin.l.b.a.b.k.a.b.f)localObject3, locall1, (kotlin.g.a.a)b.aaYt);
      AppMethodBeat.o(58186);
    }
    return paramab;
  }
  
  public final kotlin.l.b.a.b.k.a.h a(p paramp)
  {
    AppMethodBeat.i(58185);
    kotlin.g.b.p.k(paramp, "kotlinClass");
    Object localObject1 = a(paramp, aaYn);
    if (localObject1 == null)
    {
      AppMethodBeat.o(58185);
      return null;
    }
    Object localObject2 = paramp.iGR().aaZg;
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
    catch (kotlin.l.b.a.b.h.l locall)
    {
      Throwable localThrowable1 = (Throwable)new IllegalStateException("Could not read data from " + paramp.getLocation(), (Throwable)locall);
      AppMethodBeat.o(58185);
      throw localThrowable1;
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        iID();
        if (paramp.iGR().aaZc.iMC())
        {
          AppMethodBeat.o(58185);
          throw localThrowable2;
        }
        localb = null;
      }
      localObject2 = (g)localb.Mx;
      a.b localb = (a.b)localb.My;
      r localr = new r(paramp, b(paramp), c(paramp));
      paramp = new kotlin.l.b.a.b.k.a.h((c)localObject2, localb, (kotlin.l.b.a.b.e.b.a)paramp.iGR().aaZc, (an)localr);
      AppMethodBeat.o(58185);
    }
    return paramp;
  }
  
  public final kotlin.l.b.a.b.k.a.l iIC()
  {
    AppMethodBeat.i(58183);
    kotlin.l.b.a.b.k.a.l locall = this.aaYm;
    if (locall == null) {
      kotlin.g.b.p.bGy("components");
    }
    AppMethodBeat.o(58183);
    return locall;
  }
  
  public static final class a {}
  
  static final class b
    extends q
    implements kotlin.g.a.a<List<? extends kotlin.l.b.a.b.f.f>>
  {
    public static final b aaYt;
    
    static
    {
      AppMethodBeat.i(58182);
      aaYt = new b();
      AppMethodBeat.o(58182);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.d.b.e
 * JD-Core Version:    0.7.0.1
 */