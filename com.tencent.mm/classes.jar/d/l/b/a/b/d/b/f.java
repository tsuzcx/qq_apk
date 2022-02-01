package d.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.m.bb;
import d.l.b.a.b.m.c.h;
import d.l.b.a.b.m.c.j;
import d.l.b.a.b.m.c.n;
import d.l.b.a.b.m.c.o;
import java.util.HashSet;

public final class f
{
  static final h a(bb parambb, h paramh, HashSet<n> paramHashSet)
  {
    AppMethodBeat.i(58192);
    Object localObject = parambb.d(paramh);
    if (!paramHashSet.add(localObject))
    {
      AppMethodBeat.o(58192);
      return null;
    }
    o localo = parambb.a((n)localObject);
    if (localo != null)
    {
      paramHashSet = a(parambb, parambb.a(localo), paramHashSet);
      if (paramHashSet != null)
      {
        if ((parambb.s(paramHashSet)) || (!parambb.l(paramh)))
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
    if (parambb.b((n)localObject))
    {
      localObject = parambb.k(paramh);
      if (localObject == null)
      {
        AppMethodBeat.o(58192);
        return null;
      }
      paramHashSet = a(parambb, (h)localObject, paramHashSet);
      if (paramHashSet == null)
      {
        AppMethodBeat.o(58192);
        return null;
      }
      if (!parambb.s(paramh))
      {
        AppMethodBeat.o(58192);
        return paramHashSet;
      }
      if ((!parambb.s(paramHashSet)) && ((!(paramHashSet instanceof j)) || (!parambb.l((j)paramHashSet))))
      {
        parambb = parambb.m(paramHashSet);
        AppMethodBeat.o(58192);
        return parambb;
      }
    }
    AppMethodBeat.o(58192);
    return paramh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.d.b.f
 * JD-Core Version:    0.7.0.1
 */