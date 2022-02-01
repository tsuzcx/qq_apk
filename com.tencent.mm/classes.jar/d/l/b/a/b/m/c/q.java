package d.l.b.a.b.m.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.g.b.z;
import java.util.Collection;
import java.util.List;

public abstract interface q
  extends s
{
  public abstract int a(l paraml);
  
  public abstract f a(g paramg);
  
  public abstract h a(d paramd);
  
  public abstract j a(j paramj, b paramb);
  
  public abstract j a(j paramj, boolean paramBoolean);
  
  public abstract m a(h paramh, int paramInt);
  
  public abstract m a(l paraml, int paramInt);
  
  public abstract o a(n paramn, int paramInt);
  
  public abstract boolean a(m paramm);
  
  public abstract j b(g paramg);
  
  public abstract t b(m paramm);
  
  public abstract t b(o paramo);
  
  public abstract boolean b(n paramn1, n paramn2);
  
  public abstract h c(m paramm);
  
  public abstract j c(g paramg);
  
  public abstract n d(h paramh);
  
  public abstract Collection<h> d(j paramj);
  
  public abstract j e(h paramh);
  
  public abstract boolean e(j paramj);
  
  public abstract d f(j paramj);
  
  public abstract j f(h paramh);
  
  public abstract e g(j paramj);
  
  public abstract boolean g(n paramn);
  
  public abstract boolean h(j paramj);
  
  public abstract boolean h(n paramn);
  
  public abstract n i(j paramj);
  
  public abstract boolean i(n paramn);
  
  public abstract int j(n paramn);
  
  public abstract l j(j paramj);
  
  public abstract h ju(List<? extends h> paramList);
  
  public abstract Collection<h> k(n paramn);
  
  public abstract boolean k(j paramj);
  
  public abstract boolean l(j paramj);
  
  public abstract boolean l(n paramn);
  
  public abstract boolean m(n paramn);
  
  public abstract boolean n(h paramh);
  
  public abstract boolean n(n paramn);
  
  public abstract j o(h paramh);
  
  public abstract boolean o(n paramn);
  
  public abstract g p(h paramh);
  
  public abstract int q(h paramh);
  
  public abstract m r(h paramh);
  
  public abstract boolean s(h paramh);
  
  public static final class a
  {
    public static int a(q paramq, l paraml)
    {
      AppMethodBeat.i(61238);
      p.h(paraml, "$this$size");
      int i;
      if ((paraml instanceof j))
      {
        i = paramq.q((h)paraml);
        AppMethodBeat.o(61238);
        return i;
      }
      if ((paraml instanceof a))
      {
        i = ((a)paraml).size();
        AppMethodBeat.o(61238);
        return i;
      }
      paramq = (Throwable)new IllegalStateException(("unknown type argument list type: " + paraml + ", " + z.bp(paraml.getClass())).toString());
      AppMethodBeat.o(61238);
      throw paramq;
    }
    
    public static j a(q paramq, h paramh)
    {
      AppMethodBeat.i(61227);
      p.h(paramh, "$this$lowerBoundIfFlexible");
      Object localObject = paramq.p(paramh);
      if (localObject != null)
      {
        j localj = paramq.c((g)localObject);
        localObject = localj;
        if (localj != null) {}
      }
      else
      {
        paramq = paramq.o(paramh);
        localObject = paramq;
        if (paramq == null)
        {
          p.gfZ();
          localObject = paramq;
        }
      }
      AppMethodBeat.o(61227);
      return localObject;
    }
    
    public static m a(q paramq, j paramj, int paramInt)
    {
      AppMethodBeat.i(61226);
      p.h(paramj, "$this$getArgumentOrNull");
      int i = paramq.q((h)paramj);
      if (paramInt < 0) {}
      while (i <= paramInt)
      {
        AppMethodBeat.o(61226);
        return null;
      }
      paramq = paramq.a((h)paramj, paramInt);
      AppMethodBeat.o(61226);
      return paramq;
    }
    
    public static m a(q paramq, l paraml, int paramInt)
    {
      AppMethodBeat.i(61237);
      p.h(paraml, "$this$get");
      if ((paraml instanceof j))
      {
        paramq = paramq.a((h)paraml, paramInt);
        AppMethodBeat.o(61237);
        return paramq;
      }
      if ((paraml instanceof a))
      {
        paramq = ((a)paraml).get(paramInt);
        p.g(paramq, "get(index)");
        paramq = (m)paramq;
        AppMethodBeat.o(61237);
        return paramq;
      }
      paramq = (Throwable)new IllegalStateException(("unknown type argument list type: " + paraml + ", " + z.bp(paraml.getClass())).toString());
      AppMethodBeat.o(61237);
      throw paramq;
    }
    
    public static boolean a(q paramq, j paramj)
    {
      AppMethodBeat.i(61234);
      p.h(paramj, "$this$isClassType");
      boolean bool = paramq.l(paramq.i(paramj));
      AppMethodBeat.o(61234);
      return bool;
    }
    
    public static j b(q paramq, h paramh)
    {
      AppMethodBeat.i(61228);
      p.h(paramh, "$this$upperBoundIfFlexible");
      Object localObject = paramq.p(paramh);
      if (localObject != null)
      {
        j localj = paramq.b((g)localObject);
        localObject = localj;
        if (localj != null) {}
      }
      else
      {
        paramq = paramq.o(paramh);
        localObject = paramq;
        if (paramq == null)
        {
          p.gfZ();
          localObject = paramq;
        }
      }
      AppMethodBeat.o(61228);
      return localObject;
    }
    
    public static List<j> b(j paramj, n paramn)
    {
      AppMethodBeat.i(61235);
      p.h(paramj, "$this$fastCorrespondingSupertypes");
      p.h(paramn, "constructor");
      AppMethodBeat.o(61235);
      return null;
    }
    
    public static boolean b(q paramq, j paramj)
    {
      AppMethodBeat.i(61236);
      p.h(paramj, "$this$isIntegerLiteralType");
      boolean bool = paramq.h(paramq.i(paramj));
      AppMethodBeat.o(61236);
      return bool;
    }
    
    public static boolean c(q paramq, h paramh)
    {
      AppMethodBeat.i(61229);
      p.h(paramh, "$this$isDynamic");
      paramh = paramq.p(paramh);
      if (paramh != null) {}
      for (paramq = paramq.a(paramh); paramq != null; paramq = null)
      {
        AppMethodBeat.o(61229);
        return true;
      }
      AppMethodBeat.o(61229);
      return false;
    }
    
    public static boolean d(q paramq, h paramh)
    {
      AppMethodBeat.i(61230);
      p.h(paramh, "$this$isDefinitelyNotNullType");
      paramh = paramq.o(paramh);
      if (paramh != null) {}
      for (paramq = paramq.g(paramh); paramq != null; paramq = null)
      {
        AppMethodBeat.o(61230);
        return true;
      }
      AppMethodBeat.o(61230);
      return false;
    }
    
    public static boolean e(q paramq, h paramh)
    {
      AppMethodBeat.i(61231);
      p.h(paramh, "$this$hasFlexibleNullability");
      if (paramq.h(paramq.e(paramh)) != paramq.h(paramq.f(paramh)))
      {
        AppMethodBeat.o(61231);
        return true;
      }
      AppMethodBeat.o(61231);
      return false;
    }
    
    public static n f(q paramq, h paramh)
    {
      AppMethodBeat.i(61232);
      p.h(paramh, "$this$typeConstructor");
      j localj2 = paramq.o(paramh);
      j localj1 = localj2;
      if (localj2 == null) {
        localj1 = paramq.e(paramh);
      }
      paramq = paramq.i(localj1);
      AppMethodBeat.o(61232);
      return paramq;
    }
    
    public static boolean g(q paramq, h paramh)
    {
      AppMethodBeat.i(61233);
      p.h(paramh, "$this$isNothing");
      if ((paramq.o(paramq.d(paramh))) && (!paramq.s(paramh)))
      {
        AppMethodBeat.o(61233);
        return true;
      }
      AppMethodBeat.o(61233);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.m.c.q
 * JD-Core Version:    0.7.0.1
 */