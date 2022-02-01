package d.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ak;
import d.g.b.q;
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
import java.util.List;
import java.util.Set;

public final class e
{
  private static final Set<a.a> NFO;
  private static final Set<a.a> NFP;
  private static final d.l.b.a.b.e.c.a.f NFQ;
  private static final d.l.b.a.b.e.c.a.f NFR;
  private static final d.l.b.a.b.e.c.a.f NFS;
  public static final a NFT;
  public l NFN;
  
  static
  {
    AppMethodBeat.i(58191);
    NFT = new a((byte)0);
    NFO = ak.setOf(a.a.NGN);
    NFP = ak.setOf(new a.a[] { a.a.NGO, a.a.NGR });
    NFQ = new d.l.b.a.b.e.c.a.f(new int[] { 1, 1, 2 });
    NFR = new d.l.b.a.b.e.c.a.f(new int[] { 1, 1, 11 });
    NFS = new d.l.b.a.b.e.c.a.f(new int[] { 1, 1, 13 });
    AppMethodBeat.o(58191);
  }
  
  private static String[] a(p paramp, Set<? extends a.a> paramSet)
  {
    AppMethodBeat.i(58190);
    d.l.b.a.b.d.b.a.a locala = paramp.goY();
    String[] arrayOfString = locala.NGI;
    paramp = arrayOfString;
    if (arrayOfString == null) {
      paramp = locala.NGJ;
    }
    if (paramp != null)
    {
      if (paramSet.contains(locala.NGF))
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
    gqG();
    if (paramp.goY().NGG.guL())
    {
      AppMethodBeat.o(58187);
      return null;
    }
    paramp = new t((d.l.b.a.b.e.b.a)paramp.goY().NGG, (d.l.b.a.b.e.b.a)d.l.b.a.b.e.c.a.f.NNa, paramp.getLocation(), paramp.gkV());
    AppMethodBeat.o(58187);
    return paramp;
  }
  
  private final boolean c(p paramp)
  {
    AppMethodBeat.i(58188);
    if (this.NFN == null) {
      d.g.b.p.bdF("components");
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
    if (this.NFN == null) {
      d.g.b.p.bdF("components");
    }
    if ((paramp.goY().gqO()) && (d.g.b.p.i(paramp.goY().NGG, NFR)))
    {
      AppMethodBeat.o(58189);
      return true;
    }
    AppMethodBeat.o(58189);
    return false;
  }
  
  private final boolean gqG()
  {
    AppMethodBeat.i(58184);
    if (this.NFN == null) {
      d.g.b.p.bdF("components");
    }
    AppMethodBeat.o(58184);
    return false;
  }
  
  public final d.l.b.a.b.j.f.h a(ab paramab, p paramp)
  {
    AppMethodBeat.i(58186);
    d.g.b.p.h(paramab, "descriptor");
    d.g.b.p.h(paramp, "kotlinClass");
    Object localObject1 = a(paramp, NFP);
    if (localObject1 == null)
    {
      AppMethodBeat.o(58186);
      return null;
    }
    Object localObject2 = paramp.goY().strings;
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
        gqG();
        if (paramp.goY().NGG.guL())
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
      paramp = (d.l.b.a.b.e.b.a)paramp.goY().NGG;
      localObject3 = (d.l.b.a.b.k.a.b.f)localObject3;
      l locall = this.NFN;
      if (locall == null) {
        d.g.b.p.bdF("components");
      }
      paramab = (d.l.b.a.b.j.f.h)new d.l.b.a.b.k.a.b.i(paramab, localk1, (c)localObject2, paramp, (d.l.b.a.b.k.a.b.f)localObject3, locall, (d.g.a.a)b.NFU);
      AppMethodBeat.o(58186);
    }
    return paramab;
  }
  
  public final d.l.b.a.b.k.a.h a(p paramp)
  {
    AppMethodBeat.i(58185);
    d.g.b.p.h(paramp, "kotlinClass");
    Object localObject1 = a(paramp, NFO);
    if (localObject1 == null)
    {
      AppMethodBeat.o(58185);
      return null;
    }
    Object localObject2 = paramp.goY().strings;
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
        gqG();
        if (paramp.goY().NGG.guL())
        {
          AppMethodBeat.o(58185);
          throw localThrowable2;
        }
        localb = null;
      }
      localObject2 = (g)localb.first;
      a.b localb = (a.b)localb.second;
      r localr = new r(paramp, b(paramp), c(paramp));
      paramp = new d.l.b.a.b.k.a.h((c)localObject2, localb, (d.l.b.a.b.e.b.a)paramp.goY().NGG, (an)localr);
      AppMethodBeat.o(58185);
    }
    return paramp;
  }
  
  public final l gqF()
  {
    AppMethodBeat.i(58183);
    l locall = this.NFN;
    if (locall == null) {
      d.g.b.p.bdF("components");
    }
    AppMethodBeat.o(58183);
    return locall;
  }
  
  public static final class a {}
  
  static final class b
    extends q
    implements d.g.a.a<List<? extends d.l.b.a.b.f.f>>
  {
    public static final b NFU;
    
    static
    {
      AppMethodBeat.i(58182);
      NFU = new b();
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