package d.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.m.bb;
import d.l.b.a.b.m.c.g;
import d.l.b.a.b.m.c.i;
import d.l.b.a.b.m.c.m;
import d.l.b.a.b.m.c.n;
import java.util.HashSet;

public final class f
{
  static final g a(bb parambb, g paramg, HashSet<m> paramHashSet)
  {
    AppMethodBeat.i(58192);
    Object localObject = parambb.d(paramg);
    if (!paramHashSet.add(localObject))
    {
      AppMethodBeat.o(58192);
      return null;
    }
    n localn = parambb.a((m)localObject);
    if (localn != null)
    {
      paramHashSet = a(parambb, parambb.a(localn), paramHashSet);
      if (paramHashSet != null)
      {
        if ((parambb.s(paramHashSet)) || (!parambb.l(paramg)))
        {
          AppMethodBeat.o(58192);
          return paramHashSet;
        }
        parambb = parambb.m(paramHashSet);
        AppMethodBeat.o(58192);
        return parambb;
      }
      AppMethodBeat.o(58192);
      return null;
    }
    if (parambb.b((m)localObject))
    {
      localObject = parambb.k(paramg);
      if (localObject == null)
      {
        AppMethodBeat.o(58192);
        return null;
      }
      paramHashSet = a(parambb, (g)localObject, paramHashSet);
      if (paramHashSet == null)
      {
        AppMethodBeat.o(58192);
        return null;
      }
      if (!parambb.s(paramg))
      {
        AppMethodBeat.o(58192);
        return paramHashSet;
      }
      if ((!parambb.s(paramHashSet)) && ((!(paramHashSet instanceof i)) || (!parambb.l((i)paramHashSet))))
      {
        parambb = parambb.m(paramHashSet);
        AppMethodBeat.o(58192);
        return parambb;
      }
    }
    AppMethodBeat.o(58192);
    return paramg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.d.b.f
 * JD-Core Version:    0.7.0.1
 */