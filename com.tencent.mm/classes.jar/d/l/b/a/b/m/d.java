package d.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l.b.a.b.m.c.g;
import d.l.b.a.b.m.c.i;
import d.l.b.a.b.m.c.l;
import d.l.b.a.b.m.c.p;

public final class d
{
  public static final d JWR;
  
  static
  {
    AppMethodBeat.i(60575);
    JWR = new d();
    AppMethodBeat.o(60575);
  }
  
  private final boolean a(p paramp, i parami1, i parami2)
  {
    AppMethodBeat.i(60574);
    if ((paramp.q((g)parami1) == paramp.q((g)parami2)) && (paramp.h(parami1) == paramp.h(parami2)))
    {
      if (paramp.g(parami1) != null) {
        break label108;
      }
      i = 1;
      if (paramp.g(parami2) != null) {
        break label114;
      }
    }
    label108:
    label114:
    for (int j = 1;; j = 0)
    {
      if ((i == j) && (paramp.b(paramp.i(parami1), paramp.i(parami2)))) {
        break label120;
      }
      AppMethodBeat.o(60574);
      return false;
      i = 0;
      break;
    }
    label120:
    if (paramp.b(parami1, parami2))
    {
      AppMethodBeat.o(60574);
      return true;
    }
    j = paramp.q((g)parami1);
    int i = 0;
    while (i < j)
    {
      l locall1 = paramp.a((g)parami1, i);
      l locall2 = paramp.a((g)parami2, i);
      if (paramp.a(locall1) != paramp.a(locall2))
      {
        AppMethodBeat.o(60574);
        return false;
      }
      if (!paramp.a(locall1))
      {
        if (paramp.b(locall1) != paramp.b(locall2))
        {
          AppMethodBeat.o(60574);
          return false;
        }
        if (!b(paramp, paramp.c(locall1), paramp.c(locall2)))
        {
          AppMethodBeat.o(60574);
          return false;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(60574);
    return true;
  }
  
  private final boolean b(p paramp, g paramg1, g paramg2)
  {
    AppMethodBeat.i(60573);
    if (paramg1 == paramg2)
    {
      AppMethodBeat.o(60573);
      return true;
    }
    i locali1 = paramp.o(paramg1);
    i locali2 = paramp.o(paramg2);
    if ((locali1 != null) && (locali2 != null))
    {
      boolean bool = a(paramp, locali1, locali2);
      AppMethodBeat.o(60573);
      return bool;
    }
    paramg1 = paramp.p(paramg1);
    paramg2 = paramp.p(paramg2);
    if ((paramg1 != null) && (paramg2 != null))
    {
      if ((a(paramp, paramp.c(paramg1), paramp.c(paramg2))) && (a(paramp, paramp.b(paramg1), paramp.b(paramg2))))
      {
        AppMethodBeat.o(60573);
        return true;
      }
      AppMethodBeat.o(60573);
      return false;
    }
    AppMethodBeat.o(60573);
    return false;
  }
  
  public final boolean a(p paramp, g paramg1, g paramg2)
  {
    AppMethodBeat.i(60572);
    k.h(paramp, "context");
    k.h(paramg1, "a");
    k.h(paramg2, "b");
    boolean bool = b(paramp, paramg1, paramg2);
    AppMethodBeat.o(60572);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.m.d
 * JD-Core Version:    0.7.0.1
 */