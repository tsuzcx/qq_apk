package d.l.b.a.b.m.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.w;
import java.util.Collection;
import java.util.List;

public abstract interface p
  extends r
{
  public abstract int a(k paramk);
  
  public abstract e a(f paramf);
  
  public abstract g a(c paramc);
  
  public abstract i a(i parami, b paramb);
  
  public abstract i a(i parami, boolean paramBoolean);
  
  public abstract l a(g paramg, int paramInt);
  
  public abstract l a(k paramk, int paramInt);
  
  public abstract n a(m paramm, int paramInt);
  
  public abstract boolean a(l paraml);
  
  public abstract i b(f paramf);
  
  public abstract s b(l paraml);
  
  public abstract s b(n paramn);
  
  public abstract boolean b(m paramm1, m paramm2);
  
  public abstract g c(l paraml);
  
  public abstract i c(f paramf);
  
  public abstract m d(g paramg);
  
  public abstract Collection<g> d(i parami);
  
  public abstract i e(g paramg);
  
  public abstract boolean e(i parami);
  
  public abstract c f(i parami);
  
  public abstract i f(g paramg);
  
  public abstract d g(i parami);
  
  public abstract boolean g(m paramm);
  
  public abstract boolean h(i parami);
  
  public abstract boolean h(m paramm);
  
  public abstract m i(i parami);
  
  public abstract boolean i(m paramm);
  
  public abstract int j(m paramm);
  
  public abstract k j(i parami);
  
  public abstract g jg(List<? extends g> paramList);
  
  public abstract Collection<g> k(m paramm);
  
  public abstract boolean k(i parami);
  
  public abstract boolean l(i parami);
  
  public abstract boolean l(m paramm);
  
  public abstract boolean m(m paramm);
  
  public abstract boolean n(g paramg);
  
  public abstract boolean n(m paramm);
  
  public abstract i o(g paramg);
  
  public abstract boolean o(m paramm);
  
  public abstract f p(g paramg);
  
  public abstract int q(g paramg);
  
  public abstract l r(g paramg);
  
  public abstract boolean s(g paramg);
  
  public static final class a
  {
    public static int a(p paramp, k paramk)
    {
      AppMethodBeat.i(61238);
      d.g.b.k.h(paramk, "$this$size");
      int i;
      if ((paramk instanceof i))
      {
        i = paramp.q((g)paramk);
        AppMethodBeat.o(61238);
        return i;
      }
      if ((paramk instanceof a))
      {
        i = ((a)paramk).size();
        AppMethodBeat.o(61238);
        return i;
      }
      paramp = (Throwable)new IllegalStateException(("unknown type argument list type: " + paramk + ", " + w.bn(paramk.getClass())).toString());
      AppMethodBeat.o(61238);
      throw paramp;
    }
    
    public static i a(p paramp, g paramg)
    {
      AppMethodBeat.i(61227);
      d.g.b.k.h(paramg, "$this$lowerBoundIfFlexible");
      Object localObject = paramp.p(paramg);
      if (localObject != null)
      {
        i locali = paramp.c((f)localObject);
        localObject = locali;
        if (locali != null) {}
      }
      else
      {
        paramp = paramp.o(paramg);
        localObject = paramp;
        if (paramp == null)
        {
          d.g.b.k.fOy();
          localObject = paramp;
        }
      }
      AppMethodBeat.o(61227);
      return localObject;
    }
    
    public static l a(p paramp, i parami, int paramInt)
    {
      AppMethodBeat.i(61226);
      d.g.b.k.h(parami, "$this$getArgumentOrNull");
      int i = paramp.q((g)parami);
      if (paramInt < 0) {}
      while (i <= paramInt)
      {
        AppMethodBeat.o(61226);
        return null;
      }
      paramp = paramp.a((g)parami, paramInt);
      AppMethodBeat.o(61226);
      return paramp;
    }
    
    public static l a(p paramp, k paramk, int paramInt)
    {
      AppMethodBeat.i(61237);
      d.g.b.k.h(paramk, "$this$get");
      if ((paramk instanceof i))
      {
        paramp = paramp.a((g)paramk, paramInt);
        AppMethodBeat.o(61237);
        return paramp;
      }
      if ((paramk instanceof a))
      {
        paramp = ((a)paramk).get(paramInt);
        d.g.b.k.g(paramp, "get(index)");
        paramp = (l)paramp;
        AppMethodBeat.o(61237);
        return paramp;
      }
      paramp = (Throwable)new IllegalStateException(("unknown type argument list type: " + paramk + ", " + w.bn(paramk.getClass())).toString());
      AppMethodBeat.o(61237);
      throw paramp;
    }
    
    public static boolean a(p paramp, i parami)
    {
      AppMethodBeat.i(61234);
      d.g.b.k.h(parami, "$this$isClassType");
      boolean bool = paramp.l(paramp.i(parami));
      AppMethodBeat.o(61234);
      return bool;
    }
    
    public static i b(p paramp, g paramg)
    {
      AppMethodBeat.i(61228);
      d.g.b.k.h(paramg, "$this$upperBoundIfFlexible");
      Object localObject = paramp.p(paramg);
      if (localObject != null)
      {
        i locali = paramp.b((f)localObject);
        localObject = locali;
        if (locali != null) {}
      }
      else
      {
        paramp = paramp.o(paramg);
        localObject = paramp;
        if (paramp == null)
        {
          d.g.b.k.fOy();
          localObject = paramp;
        }
      }
      AppMethodBeat.o(61228);
      return localObject;
    }
    
    public static List<i> b(i parami, m paramm)
    {
      AppMethodBeat.i(61235);
      d.g.b.k.h(parami, "$this$fastCorrespondingSupertypes");
      d.g.b.k.h(paramm, "constructor");
      AppMethodBeat.o(61235);
      return null;
    }
    
    public static boolean b(p paramp, i parami)
    {
      AppMethodBeat.i(61236);
      d.g.b.k.h(parami, "$this$isIntegerLiteralType");
      boolean bool = paramp.h(paramp.i(parami));
      AppMethodBeat.o(61236);
      return bool;
    }
    
    public static boolean c(p paramp, g paramg)
    {
      AppMethodBeat.i(61229);
      d.g.b.k.h(paramg, "$this$isDynamic");
      paramg = paramp.p(paramg);
      if (paramg != null) {}
      for (paramp = paramp.a(paramg); paramp != null; paramp = null)
      {
        AppMethodBeat.o(61229);
        return true;
      }
      AppMethodBeat.o(61229);
      return false;
    }
    
    public static boolean d(p paramp, g paramg)
    {
      AppMethodBeat.i(61230);
      d.g.b.k.h(paramg, "$this$isDefinitelyNotNullType");
      paramg = paramp.o(paramg);
      if (paramg != null) {}
      for (paramp = paramp.g(paramg); paramp != null; paramp = null)
      {
        AppMethodBeat.o(61230);
        return true;
      }
      AppMethodBeat.o(61230);
      return false;
    }
    
    public static boolean e(p paramp, g paramg)
    {
      AppMethodBeat.i(61231);
      d.g.b.k.h(paramg, "$this$hasFlexibleNullability");
      if (paramp.h(paramp.e(paramg)) != paramp.h(paramp.f(paramg)))
      {
        AppMethodBeat.o(61231);
        return true;
      }
      AppMethodBeat.o(61231);
      return false;
    }
    
    public static m f(p paramp, g paramg)
    {
      AppMethodBeat.i(61232);
      d.g.b.k.h(paramg, "$this$typeConstructor");
      i locali2 = paramp.o(paramg);
      i locali1 = locali2;
      if (locali2 == null) {
        locali1 = paramp.e(paramg);
      }
      paramp = paramp.i(locali1);
      AppMethodBeat.o(61232);
      return paramp;
    }
    
    public static boolean g(p paramp, g paramg)
    {
      AppMethodBeat.i(61233);
      d.g.b.k.h(paramg, "$this$isNothing");
      if ((paramp.o(paramp.d(paramg))) && (!paramp.s(paramg)))
      {
        AppMethodBeat.o(61233);
        return true;
      }
      AppMethodBeat.o(61233);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.m.c.p
 * JD-Core Version:    0.7.0.1
 */