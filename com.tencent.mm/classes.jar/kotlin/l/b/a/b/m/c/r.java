package kotlin.l.b.a.b.m.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.ai;
import kotlin.g.b.s;

public abstract interface r
  extends u
{
  public abstract int a(i parami);
  
  public abstract int a(m paramm);
  
  public abstract List<k> a(k paramk, o paramo);
  
  public abstract b a(d paramd);
  
  public abstract f a(g paramg);
  
  public abstract i a(n paramn);
  
  public abstract k a(e parame);
  
  public abstract k a(k paramk, b paramb);
  
  public abstract k a(k paramk, boolean paramBoolean);
  
  public abstract m a(k paramk);
  
  public abstract n a(c paramc);
  
  public abstract n a(i parami, int paramInt);
  
  public abstract n a(k paramk, int paramInt);
  
  public abstract n a(m paramm, int paramInt);
  
  public abstract p a(o paramo, int paramInt);
  
  public abstract p a(v paramv);
  
  public abstract boolean a(o paramo1, o paramo2);
  
  public abstract boolean a(p paramp, o paramo);
  
  public abstract d b(k paramk);
  
  public abstract g b(i parami);
  
  public abstract k b(g paramg);
  
  public abstract w b(n paramn);
  
  public abstract w b(p paramp);
  
  public abstract boolean b(d paramd);
  
  public abstract e c(k paramk);
  
  public abstract k c(g paramg);
  
  public abstract k c(i parami);
  
  public abstract boolean c(d paramd);
  
  public abstract boolean c(n paramn);
  
  public abstract i d(d paramd);
  
  public abstract n d(i parami);
  
  public abstract p d(o paramo);
  
  public abstract boolean d(k paramk);
  
  public abstract c e(d paramd);
  
  public abstract boolean e(k paramk);
  
  public abstract boolean e(o paramo);
  
  public abstract boolean f(i parami);
  
  public abstract boolean f(k paramk);
  
  public abstract boolean f(o paramo);
  
  public abstract boolean g(i parami);
  
  public abstract boolean g(k paramk);
  
  public abstract boolean g(o paramo);
  
  public abstract boolean h(i parami);
  
  public abstract boolean h(k paramk);
  
  public abstract boolean h(o paramo);
  
  public abstract boolean i(i parami);
  
  public abstract boolean i(k paramk);
  
  public abstract boolean j(i parami);
  
  public abstract boolean j(k paramk);
  
  public abstract boolean j(o paramo);
  
  public abstract Collection<i> k(k paramk);
  
  public abstract boolean k(i parami);
  
  public abstract boolean k(o paramo);
  
  public abstract o l(k paramk);
  
  public abstract boolean l(i parami);
  
  public abstract boolean l(o paramo);
  
  public abstract boolean m(i parami);
  
  public abstract int n(o paramo);
  
  public abstract k n(i parami);
  
  public abstract Collection<i> o(o paramo);
  
  public abstract i o(i parami);
  
  public abstract i pd(List<? extends i> paramList);
  
  public abstract o q(i parami);
  
  public abstract k r(i parami);
  
  public abstract i s(i parami);
  
  public static final class a
  {
    public static int a(r paramr, m paramm)
    {
      AppMethodBeat.i(61238);
      s.u(paramr, "this");
      s.u(paramm, "receiver");
      int i;
      if ((paramm instanceof k))
      {
        i = paramr.a((i)paramm);
        AppMethodBeat.o(61238);
        return i;
      }
      if ((paramm instanceof a))
      {
        i = ((a)paramm).size();
        AppMethodBeat.o(61238);
        return i;
      }
      paramr = (Throwable)new IllegalStateException(("unknown type argument list type: " + paramm + ", " + ai.cz(paramm.getClass())).toString());
      AppMethodBeat.o(61238);
      throw paramr;
    }
    
    public static List<k> a(r paramr, k paramk, o paramo)
    {
      AppMethodBeat.i(191708);
      s.u(paramr, "this");
      s.u(paramk, "receiver");
      s.u(paramo, "constructor");
      AppMethodBeat.o(191708);
      return null;
    }
    
    public static n a(r paramr, k paramk, int paramInt)
    {
      AppMethodBeat.i(61226);
      s.u(paramr, "this");
      s.u(paramk, "receiver");
      int i;
      if (paramInt >= 0) {
        if (paramInt < paramr.a((i)paramk)) {
          i = 1;
        }
      }
      while (i != 0)
      {
        paramr = paramr.a((i)paramk, paramInt);
        AppMethodBeat.o(61226);
        return paramr;
        i = 0;
        continue;
        i = 0;
      }
      AppMethodBeat.o(61226);
      return null;
    }
    
    public static n a(r paramr, m paramm, int paramInt)
    {
      AppMethodBeat.i(61237);
      s.u(paramr, "this");
      s.u(paramm, "receiver");
      if ((paramm instanceof k))
      {
        paramr = paramr.a((i)paramm, paramInt);
        AppMethodBeat.o(61237);
        return paramr;
      }
      if ((paramm instanceof a))
      {
        paramr = ((a)paramm).get(paramInt);
        s.s(paramr, "get(index)");
        paramr = (n)paramr;
        AppMethodBeat.o(61237);
        return paramr;
      }
      paramr = (Throwable)new IllegalStateException(("unknown type argument list type: " + paramm + ", " + ai.cz(paramm.getClass())).toString());
      AppMethodBeat.o(61237);
      throw paramr;
    }
    
    public static boolean a(r paramr, k paramk)
    {
      AppMethodBeat.i(61234);
      s.u(paramr, "this");
      s.u(paramk, "receiver");
      boolean bool = paramr.f(paramr.l(paramk));
      AppMethodBeat.o(61234);
      return bool;
    }
    
    public static boolean b(r paramr, i parami)
    {
      AppMethodBeat.i(191659);
      s.u(paramr, "this");
      s.u(parami, "receiver");
      parami = paramr.c(parami);
      if (parami == null) {}
      for (paramr = null; paramr != null; paramr = paramr.b(parami))
      {
        AppMethodBeat.o(191659);
        return true;
      }
      AppMethodBeat.o(191659);
      return false;
    }
    
    public static boolean b(r paramr, k paramk)
    {
      AppMethodBeat.i(61236);
      s.u(paramr, "this");
      s.u(paramk, "receiver");
      boolean bool = paramr.j(paramr.l(paramk));
      AppMethodBeat.o(61236);
      return bool;
    }
    
    public static boolean c(r paramr, i parami)
    {
      AppMethodBeat.i(191663);
      s.u(paramr, "this");
      s.u(parami, "receiver");
      if (((parami instanceof k)) && (paramr.f((k)parami)))
      {
        AppMethodBeat.o(191663);
        return true;
      }
      AppMethodBeat.o(191663);
      return false;
    }
    
    public static k d(r paramr, i parami)
    {
      AppMethodBeat.i(61227);
      s.u(paramr, "this");
      s.u(parami, "receiver");
      g localg = paramr.b(parami);
      if (localg == null)
      {
        paramr = paramr.c(parami);
        s.checkNotNull(paramr);
        AppMethodBeat.o(61227);
        return paramr;
      }
      paramr = paramr.b(localg);
      AppMethodBeat.o(61227);
      return paramr;
    }
    
    public static k e(r paramr, i parami)
    {
      AppMethodBeat.i(61228);
      s.u(paramr, "this");
      s.u(parami, "receiver");
      g localg = paramr.b(parami);
      if (localg == null)
      {
        paramr = paramr.c(parami);
        s.checkNotNull(paramr);
        AppMethodBeat.o(61228);
        return paramr;
      }
      paramr = paramr.c(localg);
      AppMethodBeat.o(61228);
      return paramr;
    }
    
    public static boolean f(r paramr, i parami)
    {
      AppMethodBeat.i(61229);
      s.u(paramr, "this");
      s.u(parami, "receiver");
      parami = paramr.b(parami);
      if (parami == null) {}
      for (paramr = null; paramr != null; paramr = paramr.a(parami))
      {
        AppMethodBeat.o(61229);
        return true;
      }
      AppMethodBeat.o(61229);
      return false;
    }
    
    public static boolean g(r paramr, i parami)
    {
      AppMethodBeat.i(61230);
      s.u(paramr, "this");
      s.u(parami, "receiver");
      parami = paramr.c(parami);
      if (parami == null) {}
      for (paramr = null; paramr != null; paramr = paramr.c(parami))
      {
        AppMethodBeat.o(61230);
        return true;
      }
      AppMethodBeat.o(61230);
      return false;
    }
    
    public static boolean h(r paramr, i parami)
    {
      AppMethodBeat.i(61231);
      s.u(paramr, "this");
      s.u(parami, "receiver");
      if (paramr.f(paramr.n(parami)) != paramr.f(paramr.r(parami)))
      {
        AppMethodBeat.o(61231);
        return true;
      }
      AppMethodBeat.o(61231);
      return false;
    }
    
    public static o i(r paramr, i parami)
    {
      AppMethodBeat.i(61232);
      s.u(paramr, "this");
      s.u(parami, "receiver");
      k localk2 = paramr.c(parami);
      k localk1 = localk2;
      if (localk2 == null) {
        localk1 = paramr.n(parami);
      }
      paramr = paramr.l(localk1);
      AppMethodBeat.o(61232);
      return paramr;
    }
    
    public static boolean j(r paramr, i parami)
    {
      AppMethodBeat.i(61233);
      s.u(paramr, "this");
      s.u(parami, "receiver");
      if ((paramr.l(paramr.q(parami))) && (!paramr.m(parami)))
      {
        AppMethodBeat.o(61233);
        return true;
      }
      AppMethodBeat.o(61233);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.m.c.r
 * JD-Core Version:    0.7.0.1
 */