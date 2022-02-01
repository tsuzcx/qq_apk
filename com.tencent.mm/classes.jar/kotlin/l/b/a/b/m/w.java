package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import kotlin.l.b.a.b.m.c.i;
import kotlin.l.b.a.b.m.c.k;
import kotlin.l.b.a.b.m.c.o;
import kotlin.l.b.a.b.m.c.p;

public final class w
{
  public static final i a(bf parambf, i parami, HashSet<o> paramHashSet)
  {
    AppMethodBeat.i(191614);
    Object localObject = parambf.q(parami);
    if (!paramHashSet.add(localObject))
    {
      AppMethodBeat.o(191614);
      return null;
    }
    p localp = parambf.d((o)localObject);
    if (localp != null)
    {
      paramHashSet = a(parambf, parambf.a(localp), paramHashSet);
      if (paramHashSet == null)
      {
        AppMethodBeat.o(191614);
        return null;
      }
      if ((parambf.m(paramHashSet)) || (!parambf.k(parami)))
      {
        AppMethodBeat.o(191614);
        return paramHashSet;
      }
      parambf = parambf.p(paramHashSet);
      AppMethodBeat.o(191614);
      return parambf;
    }
    if (parambf.i((o)localObject))
    {
      localObject = parambf.e(parami);
      if (localObject == null)
      {
        AppMethodBeat.o(191614);
        return null;
      }
      paramHashSet = a(parambf, (i)localObject, paramHashSet);
      if (paramHashSet == null)
      {
        AppMethodBeat.o(191614);
        return null;
      }
      if (!parambf.m(parami))
      {
        AppMethodBeat.o(191614);
        return paramHashSet;
      }
      if ((!parambf.m(paramHashSet)) && ((!(paramHashSet instanceof k)) || (!parambf.g((k)paramHashSet))))
      {
        parambf = parambf.p(paramHashSet);
        AppMethodBeat.o(191614);
        return parambf;
      }
    }
    AppMethodBeat.o(191614);
    return parami;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.m.w
 * JD-Core Version:    0.7.0.1
 */