package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.m.c.h;
import kotlin.l.b.a.b.m.c.j;
import kotlin.l.b.a.b.m.c.m;
import kotlin.l.b.a.b.m.c.q;

public final class d
{
  public static final d abpL;
  
  static
  {
    AppMethodBeat.i(60575);
    abpL = new d();
    AppMethodBeat.o(60575);
  }
  
  private final boolean a(q paramq, j paramj1, j paramj2)
  {
    AppMethodBeat.i(60574);
    if ((paramq.q((h)paramj1) == paramq.q((h)paramj2)) && (paramq.h(paramj1) == paramq.h(paramj2)))
    {
      if (paramq.g(paramj1) != null) {
        break label108;
      }
      i = 1;
      if (paramq.g(paramj2) != null) {
        break label114;
      }
    }
    label108:
    label114:
    for (int j = 1;; j = 0)
    {
      if ((i == j) && (paramq.b(paramq.i(paramj1), paramq.i(paramj2)))) {
        break label120;
      }
      AppMethodBeat.o(60574);
      return false;
      i = 0;
      break;
    }
    label120:
    if (paramq.a(paramj1, paramj2))
    {
      AppMethodBeat.o(60574);
      return true;
    }
    j = paramq.q((h)paramj1);
    int i = 0;
    while (i < j)
    {
      m localm1 = paramq.a((h)paramj1, i);
      m localm2 = paramq.a((h)paramj2, i);
      if (paramq.a(localm1) != paramq.a(localm2))
      {
        AppMethodBeat.o(60574);
        return false;
      }
      if (!paramq.a(localm1))
      {
        if (paramq.b(localm1) != paramq.b(localm2))
        {
          AppMethodBeat.o(60574);
          return false;
        }
        if (!b(paramq, paramq.c(localm1), paramq.c(localm2)))
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
  
  private final boolean b(q paramq, h paramh1, h paramh2)
  {
    AppMethodBeat.i(60573);
    if (paramh1 == paramh2)
    {
      AppMethodBeat.o(60573);
      return true;
    }
    j localj1 = paramq.o(paramh1);
    j localj2 = paramq.o(paramh2);
    if ((localj1 != null) && (localj2 != null))
    {
      boolean bool = a(paramq, localj1, localj2);
      AppMethodBeat.o(60573);
      return bool;
    }
    paramh1 = paramq.p(paramh1);
    paramh2 = paramq.p(paramh2);
    if ((paramh1 != null) && (paramh2 != null))
    {
      if ((a(paramq, paramq.c(paramh1), paramq.c(paramh2))) && (a(paramq, paramq.b(paramh1), paramq.b(paramh2))))
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
  
  public final boolean a(q paramq, h paramh1, h paramh2)
  {
    AppMethodBeat.i(60572);
    p.k(paramq, "context");
    p.k(paramh1, "a");
    p.k(paramh2, "b");
    boolean bool = b(paramq, paramh1, paramh2);
    AppMethodBeat.o(60572);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.m.d
 * JD-Core Version:    0.7.0.1
 */