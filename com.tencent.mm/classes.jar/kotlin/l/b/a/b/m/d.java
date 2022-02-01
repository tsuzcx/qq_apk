package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;
import kotlin.l.b.a.b.m.c.i;
import kotlin.l.b.a.b.m.c.k;
import kotlin.l.b.a.b.m.c.n;
import kotlin.l.b.a.b.m.c.r;

public final class d
{
  public static final d ajoP;
  
  static
  {
    AppMethodBeat.i(60575);
    ajoP = new d();
    AppMethodBeat.o(60575);
  }
  
  private final boolean a(r paramr, k paramk1, k paramk2)
  {
    AppMethodBeat.i(60574);
    if ((paramr.a((i)paramk1) == paramr.a((i)paramk2)) && (paramr.f(paramk1) == paramr.f(paramk2)))
    {
      if (paramr.c(paramk1) != null) {
        break label108;
      }
      i = 1;
      if (paramr.c(paramk2) != null) {
        break label114;
      }
    }
    label108:
    label114:
    for (int j = 1;; j = 0)
    {
      if ((i == j) && (paramr.a(paramr.l(paramk1), paramr.l(paramk2)))) {
        break label120;
      }
      AppMethodBeat.o(60574);
      return false;
      i = 0;
      break;
    }
    label120:
    if (paramr.b(paramk1, paramk2))
    {
      AppMethodBeat.o(60574);
      return true;
    }
    int k = paramr.a((i)paramk1);
    if (k > 0) {}
    for (int i = 0;; i = j)
    {
      j = i + 1;
      n localn1 = paramr.a((i)paramk1, i);
      n localn2 = paramr.a((i)paramk2, i);
      if (paramr.c(localn1) != paramr.c(localn2))
      {
        AppMethodBeat.o(60574);
        return false;
      }
      if (!paramr.c(localn1))
      {
        if (paramr.b(localn1) != paramr.b(localn2))
        {
          AppMethodBeat.o(60574);
          return false;
        }
        if (!b(paramr, paramr.a(localn1), paramr.a(localn2)))
        {
          AppMethodBeat.o(60574);
          return false;
        }
      }
      if (j >= k)
      {
        AppMethodBeat.o(60574);
        return true;
      }
    }
  }
  
  private final boolean b(r paramr, i parami1, i parami2)
  {
    AppMethodBeat.i(60573);
    if (parami1 == parami2)
    {
      AppMethodBeat.o(60573);
      return true;
    }
    k localk1 = paramr.c(parami1);
    k localk2 = paramr.c(parami2);
    if ((localk1 != null) && (localk2 != null))
    {
      boolean bool = a(paramr, localk1, localk2);
      AppMethodBeat.o(60573);
      return bool;
    }
    parami1 = paramr.b(parami1);
    parami2 = paramr.b(parami2);
    if ((parami1 != null) && (parami2 != null))
    {
      if ((a(paramr, paramr.b(parami1), paramr.b(parami2))) && (a(paramr, paramr.c(parami1), paramr.c(parami2))))
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
  
  public final boolean a(r paramr, i parami1, i parami2)
  {
    AppMethodBeat.i(60572);
    s.u(paramr, "context");
    s.u(parami1, "a");
    s.u(parami2, "b");
    boolean bool = b(paramr, parami1, parami2);
    AppMethodBeat.o(60572);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.m.d
 * JD-Core Version:    0.7.0.1
 */